import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;


public class Test {
	
	private static ArrayList<Question> allQ = new ArrayList<Question>(); 
	private static ArrayList<String> answers = new ArrayList<String>();
	private static Question q;
	private static String question;
	private static String correctAnswer;
	
	private static Scanner input = new Scanner(System.in);
	private static Scanner textInput;
	private static File file;
	
	private static void loadData() {
		
		String answer;
		file = new File(".Questions/KIRAET");
		try {
			textInput = new Scanner(file);
			while (textInput.hasNextLine() && textInput.hasNext()) {
				question = textInput.nextLine();
				for (int i = 0; i < 4; i++) {
					answer = textInput.nextLine();
					if (answer.contains("*")) {
						answer = answer.substring(0, answer.length() - 1);
						correctAnswer = answer;
					}
					answers.add(answer);
						
				}
				textInput.nextLine();
				q = new Question(question, correctAnswer, answers);
				allQ.add(q);
				answers.clear();
				q = null;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
	}
	
	private static void writeQuestion() {
		
		for (Question subject : allQ) {
			q = subject;
			System.out.println(q.getQ() + "\n");
			answers = q.getAnswers();
			for (String answ : answers)
				System.out.println(answ);
			System.out.println();
			checkQuestion();
		}
		
	}
	
	private static void checkQuestion() {
		
		System.out.print("Your Answer: ");
		char answer = input.next().charAt(0);
		if (answer == q.getCorrectAnswer().charAt(0))
			System.out.println("----------------------\n"
					+ "Vaš odgovor je tačan!"
					+ "\n----------------------\n");
		else {
			System.out.print("----------------------\n"
					+ "Netačan odgovor!\n\n"
					+ "Tačan odgovor je: \n");
			System.out.println(q.getCorrectAnswer());
			System.out.println("----------------------\n");
		}
		
	}
	
	public static void main(String[] args) {
		
		loadData();
		writeQuestion();
		
	}
	
}
