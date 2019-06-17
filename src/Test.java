import java.awt.Desktop;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {
	
	static {
		
		Text.intro();
		
	}
	
	final private static String SUBJECT_1 = "KIRAET";
	final private static String SUBJECT_2 = "AKAID";
	final private static String SUBJECT_3 = "FIKH";
	final private static String SUBJECT_4 = "AHLAK";
	final private static String SUBJECT_5 = "TEFSIR";
	final private static String SUBJECT_6 = "HADIS";
	final private static String SUBJECT_7 = "POVIJEST ISLAMA";
	final private static String SUBJECT_8 = "BOSANSKI JEZIK";
	final private static String SUBJECT_9 = "ENGLESKI JEZIK";
	final private static String SUBJECT_10 = "HISTORIJA";
	final private static String SUBJECT_11 = "GEOGRAFIJA";
	final private static String SUBJECT_12 = "FILOZOFIJA";
	final private static String SUBJECT_13 = "PSIHOLOGIJA";
	final private static String SUBJECT_14 = "LOGIKA";
	final private static String SUBJECT_15 = "PEDAGOGIJA";
	final private static String SUBJECT_16 = "SOCIOLOGIJA";
	final private static String SUBJECT_17 = "FIZIKA";
	final private static String SUBJECT_18 = "HEMIJA";
	final private static String SUBJECT_19 = "BIOLOGIJA";
	final private static String SUBJECT_20 = "INFORMATIKA";
	final private static String SUBJECT_21 = "TIZO";
	final private static String SUBJECT_22 = "DEMOKRATIJA";
	final private static String SUBJECT_23 = "INFORMATIKA-IZB";
	
	private static ArrayList<Question> allQ = new ArrayList<Question>(); 
	private static ArrayList<String> answers = new ArrayList<String>();
	private static Question q;
	private static String question;
	private static String correctAnswer;
	
	final private static String EXIT_KEYWORD = "exit";
	final private static String CORRECT_KEYWORD = "correct";
	final private static String INCORRECT_KEYWORD = "incorrect";
	final private static int ANSWERS_40 = 40;
	final private static int ANSWERS_55 = 55;
	final private static int ANSWERS_39 = 39;
	final private static int ANSWERS_70 = 70;
	final private static int ANSWERS_54 = 54;
	final private static int ANSWERS_85 = 85;
	final private static int ANSWERS_69 = 69;
	final private static int MARK_1 = 1;
	final private static int MARK_2 = 2;
	final private static int MARK_3 = 3;
	final private static int MARK_4 = 4;
	final private static int MARK_5 = 5;
	
	public static int numberOfCorrect;
	public static int numberOfWrong;
	private static boolean testMark;
	private static ArrayList<Question> wrongAnswers = new ArrayList<Question>();
	
	final private static String PARENT_DESTINATION = "Questions/";
	final private static int NUMBER_OF_ANSWERS = 4;
	final private static String CORRECT_ANSW_SIGN = "*";
	
	private static Scanner input = new Scanner(System.in);
	private static Scanner textInput;
	private static File file;
	
	final private static char ZERO_CHAR = '0';
	final private static char Y_CHAR = 'y';
	final private static char N_CHAR = 'n';
	
	final private static int NUMBER_OF_Q_4 = 4;
	final private static int NUMBER_OF_Q_12 = 12;
	final private static int NUMBER_OF_Q_10 = 10;
	final private static int NUMBER_OF_Q_3 = 3;
	
	final private static int PASSWORD = 210500;
	
	private static void loadData(String destination) {
		
		allQ.clear();
		q = null;
		answers.clear();
		String answer;
		file = new File(PARENT_DESTINATION + destination);
		try {
			textInput = new Scanner(file);
			while (textInput.hasNextLine() && textInput.hasNext()) {
				question = textInput.nextLine();
				for (int i = 0; i < NUMBER_OF_ANSWERS; i++) {
					answer = textInput.nextLine();
					if (answer.contains(CORRECT_ANSW_SIGN)) {
						answer = answer.substring(0, answer.length() - 1);
						correctAnswer = answer;
					}
					answers.add(answer);
				}
				q = new Question(question, correctAnswer, answers);
				allQ.add(q);
				answers.clear();
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		textInput.close();
	}
	
	private static boolean checkAnswer(char answer) {
		if (answer > 'd' || answer < 'a')
			return false;
		return true;
	}
	
	private static void writeQuestion() {
		
		numberOfCorrect = 0;
		numberOfWrong = 0;
		
		System.out.println();
		for (Question subject : allQ) {
			q = subject;
			System.out.println(q.getQ() + "\n");
			answers = q.getAnswers();
			for (String answ : answers)
				System.out.println(answ);
			char answer;
			boolean status = true;
			Text.response();
			do {
				if (!status)
					Text.response();
				answer = input.next().charAt(0);
				status = checkAnswer(answer);
			} while (!status);
			if(checkQuestion(answer) == EXIT_KEYWORD)
				break;
			if(checkQuestion(answer) == CORRECT_KEYWORD) {
				numberOfCorrect++;
				Text.correctAnsw();
			} else {
				numberOfWrong++;
				wrongAnswers.add(q);
				Text.wrongAnsw(q);
			}
		}
		
		Text.testResult();
		if (!testMark) {
			testMark = true;
			Text.mark(getMark(numberOfCorrect));
			
		}
		if (!wrongAnswers.isEmpty()) {
			allQ = wrongAnswers;
			wrongAnswers = new ArrayList<Question>();
			missedQ();
		}
		wrongAnswers.clear();
		
	}
	
	private static int getMark(int numberOfCorrect) {
		
		if (numberOfCorrect < ANSWERS_40)
			return MARK_1;
		else if (numberOfCorrect < ANSWERS_55 && numberOfCorrect > ANSWERS_39)
			return MARK_2;
		else if (numberOfCorrect < ANSWERS_70 && numberOfCorrect > ANSWERS_54)
			return MARK_3;
		else if (numberOfCorrect < ANSWERS_85 && numberOfCorrect > ANSWERS_69)
			return MARK_4;
		else
			return MARK_5;
		
	}
	
	private static String checkQuestion(char answer) {
		
		if (answer == ZERO_CHAR)
			return EXIT_KEYWORD;
		if (answer == q.getCorrectAnswer().charAt(0))
			return CORRECT_KEYWORD;
		else
			return INCORRECT_KEYWORD;
	}
	
	private static void missedQ() {
		
		Text.repeat();
		char answer = input.next().charAt(0);
		if (answer == Y_CHAR)
			writeQuestion();
		else if (answer == N_CHAR)
			return;
		
	}
	
	private static void subjectMenu() {
		
		byte choice;
		try {
			
			do {
				Text.subjectMenu();
				Text.choice();
				choice = input.nextByte();
				
				switch (choice) {
				case 1:
					loadData(SUBJECT_1);
					writeQuestion();
					break;
					
				case 2:
					loadData(SUBJECT_2);
					writeQuestion();
					break;
					
				case 3:
					loadData(SUBJECT_3);
					writeQuestion();
					break;
					
				case 4:
					loadData(SUBJECT_4);
					writeQuestion();
					break;
					
				case 5:
					loadData(SUBJECT_5);
					writeQuestion();
					break;
					
				case 6:
					loadData(SUBJECT_6);
					writeQuestion();
					break;
					
				case 7:
					loadData(SUBJECT_7);
					writeQuestion();
					break;
					
				case 8:
					loadData(SUBJECT_8);
					writeQuestion();
					break;
					
				case 9:
					loadData(SUBJECT_9);
					writeQuestion();
					break;
					
				case 10:
					loadData(SUBJECT_10);
					writeQuestion();
					break;
					
				case 11:
					loadData(SUBJECT_11);
					writeQuestion();
					break;
					
				case 12:
					loadData(SUBJECT_12);
					writeQuestion();
					break;
					
				case 13:
					loadData(SUBJECT_13);
					writeQuestion();
					break;
					
				case 14:
					loadData(SUBJECT_14);
					writeQuestion();
					break;
					
				case 15:
					loadData(SUBJECT_15);
					writeQuestion();
					break;
					
				case 16:
					loadData(SUBJECT_16);
					writeQuestion();
					break;
					
				case 17:
					loadData(SUBJECT_17);
					writeQuestion();
					break;
					
				case 18:
					loadData(SUBJECT_18);
					writeQuestion();
					break;
					
				case 19:
					loadData(SUBJECT_19);
					writeQuestion();
					break;
					
				case 20:
					loadData(SUBJECT_20);
					writeQuestion();
					break;
					
				case 21:
					loadData(SUBJECT_21);
					writeQuestion();
					break;
					
				case 22:
					loadData(SUBJECT_22);
					writeQuestion();
					break;
					
				default:
					Text.wrongInput();
					
				}
				
			} while (choice != 0);
			
		} catch (Exception e) {
		}
		
	}
	
	private static void randomQuestion(int numberOfQuestionOnTest, int allQuestions) {
		
		ArrayList<Integer> randomNumbers = new ArrayList<Integer>();
		boolean existing;
		int random;
		for (int i = 0; i < numberOfQuestionOnTest; i++) {
			 do {
				existing = false;
				random = (int)(Math.random() * (allQuestions + 1));
				for (int x : randomNumbers)
					if (x == random)
						existing = true;
			 } while (existing);
			 randomNumbers.add(random);
			 wrongAnswers.add(allQ.get(random));
		}
	}
	
	private static ArrayList<Question> randomTest() {
		
		loadData(SUBJECT_1);
		randomQuestion(NUMBER_OF_Q_4, allQ.size());
		loadData(SUBJECT_2);
		randomQuestion(NUMBER_OF_Q_4, allQ.size());
		loadData(SUBJECT_3);
		randomQuestion(NUMBER_OF_Q_4, allQ.size());
		loadData(SUBJECT_4);
		randomQuestion(NUMBER_OF_Q_4, allQ.size());
		loadData(SUBJECT_5);
		randomQuestion(NUMBER_OF_Q_4, allQ.size());
		loadData(SUBJECT_6);
		randomQuestion(NUMBER_OF_Q_4, allQ.size());
		loadData(SUBJECT_7);
		randomQuestion(NUMBER_OF_Q_4, allQ.size());
		loadData(SUBJECT_8);
		randomQuestion(NUMBER_OF_Q_12, allQ.size());
		loadData(SUBJECT_9);
		randomQuestion(NUMBER_OF_Q_10, allQ.size());
		loadData(SUBJECT_10);
		randomQuestion(NUMBER_OF_Q_4, allQ.size());
		loadData(SUBJECT_11);
		randomQuestion(NUMBER_OF_Q_4, allQ.size());
		loadData(SUBJECT_12);
		randomQuestion(NUMBER_OF_Q_4, allQ.size());
		loadData(SUBJECT_13);
		randomQuestion(NUMBER_OF_Q_4, allQ.size());
		loadData(SUBJECT_14);
		randomQuestion(NUMBER_OF_Q_3, allQ.size());
		loadData(SUBJECT_15);
		randomQuestion(NUMBER_OF_Q_3, allQ.size());
		loadData(SUBJECT_16);
		randomQuestion(NUMBER_OF_Q_4, allQ.size());
		loadData(SUBJECT_17);
		randomQuestion(NUMBER_OF_Q_4, allQ.size());
		loadData(SUBJECT_18);
		randomQuestion(NUMBER_OF_Q_4, allQ.size());
		loadData(SUBJECT_19);
		randomQuestion(NUMBER_OF_Q_4, allQ.size());
		loadData(SUBJECT_20);
		randomQuestion(NUMBER_OF_Q_4, allQ.size());
		loadData(SUBJECT_21);
		randomQuestion(NUMBER_OF_Q_4, allQ.size());
		loadData(SUBJECT_22);
		randomQuestion(NUMBER_OF_Q_4, allQ.size());
		
		return wrongAnswers;
	}
	
	private static void updateAnsw() {
		
		try {
			
			final int pass = PASSWORD;
			int pass1;
			Text.inputPIN();
			pass1 = input.nextInt();
			if (pass1 == pass) {
				File file = new File(PARENT_DESTINATION);
				Desktop.getDesktop().open(file);
			} else
				Text.wrongPIN();
			
		} catch (Exception e) {
			
		}
		
	}
	
	private static void simulation() {
		
		allQ = randomTest();
		wrongAnswers = new ArrayList<Question>();
		writeQuestion();
		
	}
	
	private static void additionalSubj() {
		byte choice;
		try {
			
			do {
				Text.additionalSubj();
				Text.choice();
				choice = input.nextByte();
				
				switch (choice) {
				
				case 1:
					loadData(SUBJECT_23);
					writeQuestion();
					break;
					
				default:
					Text.wrongInput();
				
				}
				
			} while (choice != 0);
			
		} catch (Exception e) {
			
		}
	}
	
	private static void mainMenu() {
		
		String choice;
		try {
			
			do {
				Text.mainMenu();
				Text.choice();
				choice = input.next();
				
				switch (choice) {
				case "1":
					testMark = false;
					simulation();
					break;
					
				case "2":
					testMark = true;
					subjectMenu();
					break;
					
				case "3":
					testMark = false;
					additionalSubj();
					break;
					
				case "00":
					updateAnsw();
					break;
					
				default:
					Text.wrongInput();
					
				}
				
			} while (!choice.equals("0"));
			
		} catch (Exception e) {
			
		}
		
	}
	
	public static void main(String[] args) {

		mainMenu();
		Text.endMsg();
		input.close();
		
	}
	
}
