# Fake News Detection System

**Description:**  
This project detects whether a news article is **real or fake** using **Java, Spring Boot, and Machine Learning (WEKA)**. Users can paste news text on a web page and get instant predictions.

---

## **Features**

- Machine Learning-based news classification (Logistic Regression)  
- Web interface built with **Spring Boot** and **Thymeleaf**  
- Text preprocessing using **TF-IDF vectorization**  
- Simple and modern **responsive UI**  
- Highlights prediction:
  - **Fake News 🔴** → red background  
  - **Real News 🟢** → green background  

---

## **Technology Stack**

| Component        | Technology/Library        |
|-----------------|---------------------------|
| Backend          | Java, Spring Boot         |
| Machine Learning | WEKA (Logistic Regression, TF-IDF) |
| Frontend         | Thymeleaf, HTML, CSS      |
| Build Tool       | Maven                     |

---

## **Project Structure**

fake-news-detector/
├── src/ → Java source code
│ └── main/java/com/fakenews/
│ ├── controller/ → Handles web requests
│ ├── service/ → Calls ML model for predictions
│ └── ml/ → Model training code
├── pom.xml → Maven dependencies
├── application.properties → Spring Boot config
├── fake_news.arff → Dataset for training
├── README.md → Project explanation


---

## **How to Run**

1. **Train the ML Model:**  
   Run `ModelTrainer.java` to create `fakeNews.model` and `filter.model`.

2. **Start Spring Boot App:**  
   Run `FakeNewsDetectorApplication.java` to start the server.

3. **Open the Web Application:**  
   Open browser and go to:  
http://localhost:8085

5. **Check News:**  
- Paste any news article in the text box  
- Click **Check News**  
- See prediction displayed on screen  

---

## **Screenshots**

**Paste news and check prediction:**

![Fake News Result](screenshot_fake.png)  
![Real News Result](screenshot_real.png)  

> Replace `screenshot_fake.png` and `screenshot_real.png` with your actual screenshots.

---

## **Dataset**

- `fake_news.arff` contains labeled **fake** and **real** news articles used for training.  
- Make sure the dataset is in the project folder when training the model.

---

## **Project Link**

GitHub Repository: [https://github.com/YourUsername/fake-news-detector](https://github.com/YourUsername/fake-news-detector)  

---

## **Future Improvements**

- Deploy as a **live web application online** (Heroku, Railway, or AWS)  
- Add **confidence score (%)** for predictions  
- Include **more advanced NLP models** like BERT for better accuracy  

---

## **Author**

**Samartha Shinde**  
- Java & Spring Boot Developer  
- Machine Learning Enthusiast  
- [LinkedIn Profile](https://www.linkedin.com/in/samarthshinde/)
