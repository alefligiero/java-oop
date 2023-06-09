package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Student;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		Student student = new Student();
		
		student.name = sc.nextLine();
		student.nota1 = sc.nextDouble();
		student.nota2 = sc.nextDouble();
		student.nota3 = sc.nextDouble();
		
		System.out.printf("NOTA FINAL = %.2f\n", student.finalGrade());
		
		
		if (student.finalGrade() < 60) {
			System.out.println("FAILED");
			System.out.printf("FALTARAM %.2f PONTOS\n", student.missingPoints());
		} else {
			System.out.println("PASS");
		}
		
		sc.close();
	}

}
