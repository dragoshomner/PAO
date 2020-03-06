import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ex4 {
	public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
        int n = 0;
        try {
    		n = Integer.parseInt(br.readLine());
        } catch(NumberFormatException nfe) {
            System.err.println("Invalid Format!");
        }
		
		Student[] students = new Student[10];
		
		for (int i = 0 ; i < n ; i++) {
			String name, line;
			int grade;
			line = br.readLine();
			String[] sir;
			sir = line.split("\\s+");
			name = sir[0];
			grade = Integer.parseInt(sir[1]);
			students[i] = new Student(name, grade);
		}
		
		for (int i = 0 ; i < n ; i++) {
			students[i].print();
		}
		
		br.close();
	}
}
