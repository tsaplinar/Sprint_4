package jensenspb.pageobjects.components;

import org.openqa.selenium.By;

public class Question {
    private By selectorQuestion;
    private By selectorAnswer;
    private String question;
    private String answer;

    public Question(By selectorQuestion, By selectorAnswer, String question, String answer) {
        this.selectorQuestion = selectorQuestion;
        this.selectorAnswer = selectorAnswer;
        this.question = question;
        this.answer = answer;
    }

    public By getQuestionSelector() {
        return selectorQuestion;
    }

    public By getAnswerSelector() {
        return selectorAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    @Override
    public String toString() {
        return "Question{" +
                "question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }
}
