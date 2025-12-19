package com.fakenews.ml;

import weka.core.*;
import weka.classifiers.functions.Logistic;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.StringToWordVector;
import weka.core.converters.ConverterUtils.DataSource;
import weka.core.SerializationHelper;

public class ModelTrainer {

    public static void main(String[] args) throws Exception {

        DataSource source = new DataSource("src/main/resources/fake_news.arff");
        Instances data = source.getDataSet();
        data.setClassIndex(data.numAttributes() - 1);

        StringToWordVector filter = new StringToWordVector();
        filter.setTFTransform(true);
        filter.setIDFTransform(true);
        filter.setLowerCaseTokens(true);
        filter.setInputFormat(data);

        Instances filteredData = Filter.useFilter(data, filter);

        Logistic model = new Logistic();
        model.buildClassifier(filteredData);

        SerializationHelper.write("src/main/resources/model/fakeNews.model", model);
        SerializationHelper.write("src/main/resources/model/filter.model", filter);

        System.out.println("Model trained and saved!");

    }
}
