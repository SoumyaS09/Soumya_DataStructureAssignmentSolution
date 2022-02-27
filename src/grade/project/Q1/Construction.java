package grade.project.Q1;

import java.util.Scanner;

public class Construction {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n;
		int temp;
		System.out.println("Enter the total no of floors in the building ");
		n = sc.nextInt();
		int a[] = new int[n];

		for (int i = 0; i < n; i++) {
			System.out.println("Enter the floor size given on day: " + (i + 1));
			a[i] = sc.nextInt();
		}

		System.out.println("The order of construction is as follows: ");
		for (int i = 0; i < n; i++) {
			System.out.println("Day " + (i + 1));
			for (int j = i + 1; j < n; j++) {
				if (a[i] < a[j]) {
					temp = a[i];
					a[i] = a[j];
					a[j] = temp;
					System.out.println(a[i]);
				}
			}

			sc.close();
		}

	}
}
