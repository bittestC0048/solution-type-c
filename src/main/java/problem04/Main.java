package problem04;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int a[] = new int[18];
		int b[] = new int[18];
		
		int k = 1;
		for(int i=0; i<a.length; i++) {
			a[i] = k;
			if(i % 2 == 1) k++;
		}
		
		Random r = new Random();
		for(int i=0; i<b.length; i++) {
			b[i] = new Random().nextInt(9) + 1;
			if(i % 2 == 1) {
				if(b[i] == b[i-1]) i--;
			}
		}
		
		for(int i=0; i<a.length; i++) {
			if(i % 2 == 0) System.out.print(a[i] + "x" + b[i] +", ");
			else System.out.println(a[i] + "x" + b[i]);
		}
		
		int random[] = new int[18];
		
		for(int i=0; i<random.length; i++) {
			random[i] = r.nextInt(18) + 1;
			for(int j=0; j<i; j++) {
				if(random[i] == random[j]) i--;
			}
		}
		
		Scanner sc = new Scanner(System.in);
		int correct = 0;
		int wrong = 0;
		for(int i=0; i<random.length; i++) {
			System.out.println((i+1) + ".  " + a[i] + "x" + b[i] + " ?");
			long start = System.currentTimeMillis();
			if(sc.nextInt() == a[i]*b[i]) correct++;
			else wrong++;
			long end = System.currentTimeMillis();
		}
	}
}