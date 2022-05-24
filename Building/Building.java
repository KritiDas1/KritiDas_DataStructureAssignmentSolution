package Building;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;


public class Building {
		public static void main(String[] args) {
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the total number floors in the building : ");
			int a = sc.nextInt();
			int x[] = new int[a];
			for (int i = 0; i < a; i++) {
				System.out.println("Enter the floor size given on day : " + (i+1));
				int b = sc.nextInt();
				x[i] = b;
			}
			
			int j = a;
			boolean flag;
			System.out.println("The order of construction is as follows ");
			Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
			for (int k = 0; k < x.length; k++) {
				int value = x[k];
				queue.add(value);
				flag = false;
				System.out.println("Day " + (k+1) + " :");
				while (!queue.isEmpty() && queue.peek() == j) {
					flag = true;
					System.out.print(queue.poll() + " ");
					j--;
				}
				if (flag == true) {
					System.out.println();
				}
			}	}

	}


}
