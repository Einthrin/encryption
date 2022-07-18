import java.util.*;

public class EncryptionProgram {

	private Scanner _scanner;
	private Random _random;
	private ArrayList<Character> _list;
	private ArrayList<Character> _shuffledList;
	private char _character;
	private String _line;
	private char[] _letters;
	private char[] _secretLetters;

	EncryptionProgram() {
		_scanner = new Scanner(System.in);
		_random = new Random();
		_list = new ArrayList();
		_shuffledList = new ArrayList();
		_character = ' ';

		newKey();
		askQuestion();
	}

	private void askQuestion() {
		while (true) {
			System.out.println("************************************************");
			System.out.println("What do you want to do?");
			System.out.println("(N)ewKey, (G)etKey, (E)ncrypt, (D)ecrypt, (Q)uit");
			char response = Character.toUpperCase(_scanner.nextLine().charAt(0));

			switch (response) {
			case 'N':
				newKey();
				break;
			case 'G':
				getKey();
				break;
			case 'E':
				encrypt();
				break;
			case 'D':
				decrypt();
				break;
			case 'Q':
				quit();
				break;
			default:
				System.out.println("Not a valid answer :(");
			}
		}
	}

	private void newKey() {
		_character = ' ';
		_list.clear();
		_shuffledList.clear();

		for (int i = 32; i < 127; i++) {
			_list.add(Character.valueOf(_character));
			_character++;
		}

		_shuffledList = new ArrayList(_list);
		Collections.shuffle(_shuffledList);
		System.out.println("*A new key has been generated*");
	}

	private void getKey() {
		System.out.println("Key: ");
		for (Character x : _list) {
			System.out.print(x);
		}
		System.out.println();
		for (Character x : _list) {
			System.out.print(x);
		}
		System.out.println();
	}

	private void encrypt() {
		System.out.println("Enter a message to be encrypted: ");
		String message = _scanner.nextLine();

		_letters = message.toCharArray();

		for (int i = 0; i < _letters.length; i++) {
			for (int j = 0; j < _list.size(); j++) {
				if (_letters[i]==_list.get(j)) {
					_letters[i] = _shuffledList.get(j);
					break;
				}
			}
		}
		System.out.println("Encrpted: ");
		for (char x : _letters) {
			System.out.print(x);
		}
		System.out.println();
	}

	private void decrypt() {
		System.out.println("Enter a message to be decrypted: ");
		String message = _scanner.nextLine();

		_letters = message.toCharArray();

		for (int i = 0; i < _letters.length; i++) {
			for (int j = 0; j < _shuffledList.size(); j++) {
				if (_letters[i]==_shuffledList.get(j)) {
					_letters[i] = _list.get(j);
					break;
				}
			}
		}
		System.out.println("Decrpted: ");
		for (char x : _letters) {
			System.out.print(x);
		}
		System.out.println();
	}

	private void quit() {
		System.out.println("Thank you, have a nice day :)");
		System.exit(0);
	}
}