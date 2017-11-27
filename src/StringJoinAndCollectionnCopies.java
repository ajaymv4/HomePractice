import java.util.Collections;

public class StringJoinAndCollectionnCopies {

	public static void main(String[] args) {
		

		int rows = 5;
		
		System.out.println(String.join("",Collections.nCopies(5, "")));
		
		System.out.println(String.join("$", Collections.nCopies(5, " ")));
		
		
		System.out.println("\n3. Full Pyramid (Compact)\n");
        for (int i = 0; i < rows; i++) {

            System.out.println(String.join("", Collections.nCopies(5 - i - 1, " "))
                    + String.join("", Collections.nCopies(2 * i + 1, "*")));

        }


		
	}
	
	
}
