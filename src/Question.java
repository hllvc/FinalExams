import java.util.ArrayList;

public class Question {

	private ArrayList<String> answers = new ArrayList<String>();
	private String question;
	private String correctAnswer;
	
	public Question(String question, String correctAnswer, ArrayList<String> answers) {
		this.question = question;
		this.correctAnswer = correctAnswer;
		for (String x : answers)
			this.answers.add(x);
	}
	
	public String getQ() {
		return question;
	}
	
	public ArrayList<String> getAnswers() {
		return answers;
	}
	
	public String getCorrectAnswer() {
		return correctAnswer;
	}
	
}
