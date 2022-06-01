import java.util.Scanner;

public class GameJavaGuessANumber {
	
	public static void main(String [] args) {
		Scanner scanner = new Scanner(System.in);
		showGreetingMessage();
		String userAnswer;
		
		do {
			userAnswer = scanner.nextLine();
			if ("yes".equals(userAnswer)) {
				showRangeMessage();
			} else if ("no".equals(userAnswer)) {
				showMessageForNegativeAnswer();
				System.exit(0);
			} else {
				showMessageForCorrectInput();
			}
		} while(!"yes".equals(userAnswer));

		int min = 0;
		int max = 0;
		
		do {
			min = tryToScanStartOfRangeInput();
			if(min == Integer.MIN_VALUE) {
				System.out.print("Please enter start of range numbers     ");
			} else {
				break;
			}
		} while(min == Integer.MIN_VALUE);
		showEndOfRangeMessage();
		
		do {
			max = tryToScanEndOfRangeInput();
			if(max == Integer.MAX_VALUE) {
				System.out.print("Please enter end of range numbers     ");
			} else {
				break;
			}
		} while(max == Integer.MAX_VALUE);
		int number = (max-min)/2 + min;
		System.out.println("					Ok,let's get started!");
		String userInput;
		
		do {
			System.out.println("				I think is----> "+number);
			showAnswerOptions();
			userInput = scanner.nextLine();
		if (">".equals(userInput)) {
			min = number;
		} else if ("<".equals(userInput)) {
			max = number;
		} else if ("yes".equals(userInput)) {
			break;
		} else {
			showMessageForCorrectInput();
		}
		number = (max-min)/2 + min;
		} while(!"yes".equals(userInput));
		showGratitudeAndGoodbyeText();
	}
	
	private static void showGreetingMessage() {
		System.out.println("				Hi,you wanna play??");
		System.out.println("				yes / no");
	}
	
	private static void showMessageForNegativeAnswer() {
		System.out.println("				Ok,maybe later,good bye");
	}
	
	private static void showMessageForCorrectInput() {
		System.out.println("				Please enter one of the provided answer options");
		System.out.println();
	}
	
	private static void showRangeMessage() {
		System.out.println("				The Game is call \"Guess a number\"");
		System.out.println("				Number in what range are you guess?");
		System.out.print("				from -> ");
	}
	
	private static int tryToScanStartOfRangeInput() {
		Scanner scanner = new Scanner(System.in);
		int min = 0;
		try {
			min = scanner.nextInt();
		} catch(Exception e){
			return Integer.MIN_VALUE;
		} return min - 1;
	}
	
	private static void showEndOfRangeMessage() {
		System.out.print("				to -> ");
	}
	
	private static int tryToScanEndOfRangeInput() {
		Scanner scanner = new Scanner(System.in);
		int max = 100;
		try {
			 max = scanner.nextInt();
		} catch(Exception e){
			return Integer.MAX_VALUE;
		} return max + 1;
	}
	
	private static void showAnswerOptions() {
		System.out.println();
		System.out.println("				I Guess?");
		System.out.println();
		System.out.println("				If your number bigger put \">\"");
		System.out.println("				If your number smaller put \"<\"");
		System.out.println("				If i guess right put \"yes\"");
	}
	
	private static void showGratitudeAndGoodbyeText() {
		System.out.println("				Thank you for playing!");
		System.out.println("					Good Bye!");
	}
}