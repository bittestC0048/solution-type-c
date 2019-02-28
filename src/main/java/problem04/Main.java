package problem04;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
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
		int second = 0;
		for(int i=0; i<random.length; i++) {
			System.out.println((i+1) + ".  " + a[random[i] - 1] + "x" + b[random[i] - 1] + " ?");
			
			long start = System.currentTimeMillis();
			int answer = sc.nextInt();
			long end = System.currentTimeMillis();
			int sec = (int) ((end-start)/1000.0);
			
			if(answer == a[random[i] - 1]*b[random[i] - 1]) {
				System.out.println(".  " + sec + " .");
				correct++;
			}
			else {
				System.out.println(".  " + answer + ".  " + sec + " .");
				wrong++;
			}
			
			second += sec;
		}
		
		File file = new File("score.txt");
		try {
			FileWriter fw = new FileWriter(file, true) ;
			fw.write(correct + "\t" + wrong + "\t" + second);
            fw.flush();
            
            fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Path path = Paths.get("score.txt");
        Charset cs = StandardCharsets.UTF_8;
        List<String> list = new ArrayList<String>();
        try{
            list = Files.readAllLines(path, cs);
        }catch(IOException e){
            e.printStackTrace();
        }
        
        ArrayList<Integer> cor = new ArrayList<>();
        ArrayList<Integer> wrn = new ArrayList<>();
        ArrayList<Integer> se = new ArrayList<>();
        
        Collections.sort(list);
        
        int ranking = 1;
        for(String readLine : list){
        	String[] arr = readLine.split("\t");
        	System.out.println(ranking + " : " + Integer.parseInt(arr[0]) + " / : " + Integer.parseInt(arr[2]));
        	ranking++;
        }
        
        
	}
}