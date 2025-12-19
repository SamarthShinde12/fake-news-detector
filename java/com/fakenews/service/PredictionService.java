package com.fakenews.service;

import org.springframework.stereotype.Service;
import weka.classifiers.Classifier;
import weka.classifiers.functions.Logistic;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.SerializationHelper;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.StringToWordVector;

import java.util.ArrayList;

@Service
public class PredictionService {

    private Classifier model;
    private StringToWordVector filter;
    private Instances structure;

    public PredictionService() {
        try {
            // Load model and filter
            model = (Logistic) SerializationHelper.read("src/main/resources/model/fakeNews.model");
            filter = (StringToWordVector) SerializationHelper.read("src/main/resources/model/filter.model");

            // Define structure matching training
            ArrayList<weka.core.Attribute> attrs = new ArrayList<>();
            attrs.add(new weka.core.Attribute("text", (ArrayList<String>) null)); // text attribute

            // class values must match ARFF
            ArrayList<String> classValues = new ArrayList<>();
            classValues.add("fake");
            classValues.add("real");
            attrs.add(new weka.core.Attribute("class", classValues));

            structure = new Instances("TestNews", attrs, 0);
            structure.setClassIndex(structure.numAttributes() - 1);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String predict(String newsText) throws Exception {
        newsText = newsText.toLowerCase().trim();

        // Create a new instance and add it to the dataset
        DenseInstance instance = new DenseInstance(structure.numAttributes());
        instance.setValue(structure.attribute(0), newsText);
        instance.setDataset(structure); // ✅ VERY IMPORTANT
        structure.add(instance);

        // Apply the saved filter
        filter.input(instance);
        Instance filtered = filter.output();

        // Classify
        double prediction = model.classifyInstance(filtered);

        System.out.println("Input text: " + newsText);
        System.out.println("Prediction raw: " + prediction);

        return prediction == 0.0 ? "FAKE NEWS 🔴" : "REAL NEWS 🟢";
    }
}
