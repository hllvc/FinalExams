import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;


public class Test {
	
	private static ArrayList<Question> allQ = new ArrayList<Question>(); 
	private static ArrayList<String> answers = new ArrayList<String>();
	private static Question q;
	private static String question;
	private static String correctAnswer;
	
	private static int numberOfCorrect;
	private static int numberOfWrong;
	private static ArrayList<Question> wrongAnswers = new ArrayList<Question>();
	
	private static Scanner input = new Scanner(System.in);
	private static Scanner textInput;
	private static File file;
	
	private static void loadData(String destination) {
		
		allQ.clear();
		answers.clear();
		wrongAnswers.clear();
		q = null;
		String answer;
		file = new File(destination);
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
				q = new Question(question, correctAnswer, answers);
				allQ.add(q);
				answers.clear();
				q = null;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		writeQuestion(allQ);
		
	}
	
	private static void writeQuestion(ArrayList<Question> questions) {
		
		numberOfCorrect = 0;
		numberOfWrong = 0;
		
		for (Question subject : questions) {
			q = subject;
			System.out.println(q.getQ() + "\n");
			answers = q.getAnswers();
			for (String answ : answers)
				System.out.println(answ);
			System.out.println();
			System.out.print("Vaš Odgovor: ");
			char answer = input.next().charAt(0);
			if(checkQuestion(answer) == "exit")
				break;
			else
				System.out.println(checkQuestion(answer));
		}
		
		System.out.println("\nNumber Of Correct: " + numberOfCorrect/2);
		System.out.println("\nNumber Of Incorrect: " + numberOfWrong/2);
		for (int i = 0; i < wrongAnswers.size(); i+=2)
			wrongAnswers.remove(i);
		missedQ();
		wrongAnswers.clear();
		
	}
	
	private static String checkQuestion(char answer) {
		
		if (answer == '0')
			return "exit";
		if (answer == q.getCorrectAnswer().charAt(0)) {
			numberOfCorrect++;;
			return("----------------------\n"
					+ "Vaš Odgovor Je Tačan!"
					+ "\n----------------------\n");
		} else {
			numberOfWrong++;
			wrongAnswers.add(q);
			return("----------------------\n"
					+ "Netačan Odgovor!\n\n"
					+ "Tačan Odgovor Je: \n"
					+ q.getCorrectAnswer()
					+ "\n----------------------\n");
		}
		
	}
	
	private static void missedQ() {
		
		System.out.println("Želite li ponoviti pogrešno odgovorena pitanja (y/n)? - ");
		char answer = input.next().charAt(0);
		if (answer == 'y')
			writeQuestion(wrongAnswers);
		else
			return;
		
	}
	
	private static void subjectMenu() {
		
		byte choice;
		try {
			
			do {
				Text.subjectMenu();
				System.out.print("\nVaš Odabir: ");
				choice = input.nextByte();
				
				switch (choice) {
				case 1:
					loadData(".Questions/KIRAET");
					break;
					
				case 2:
					loadData(".Questions/AKAID");
					break;
				}
				
			} while (choice != 0);
			
		} catch (Exception e) {
		}
		
	}
	
	private static void mainMenu() {
		
		byte choice;
		try {
			
			do {
				Text.mainMenu();
				System.out.print("\nVaš Odabir: ");
				choice = input.nextByte();
				
				switch (choice) {
				case 1:
					break;
					
				case 2:
					subjectMenu();
					break;
				}
				
			} while (choice != 0);
			
		} catch (Exception e) {
		}
		
	}
	
	public static void main(String[] args) {

		mainMenu();
		
	}
	
}
