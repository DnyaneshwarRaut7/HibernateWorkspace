
public class aaa {

	public static void displayNames(String... names) {
		for (String mynames : names) {
			System.out.println(mynames + "");

		}
	}

	public static void main(String arga[]) {
		displayNames("Alex", "richard", "John");
	}
}
