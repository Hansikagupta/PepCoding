import java.util.Scanner;

public class assignment {
	public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s = scn.nextLine();
        int i = scn.nextInt();
        System.out.println(replace(s, i));
        
    }
    static char replace(String s, int input) {
        boolean state;
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        
        for(int i = 0; i < sb.length(); i++) {
            if(sb.charAt(i) == 'h'){
                state = true;
            }
            else state = false;
            if(state == true && sb.charAt(i) == 'i') {
                sb.replace(i-1, i, "pep");
                // sb.charAt(i-1) = 'p';
                // sb.insert(i , 'e');
                // sb.charAt(i+1) = 'e';
            }
        }
        System.out.println(sb);
        return sb.charAt(input);
    }
}
