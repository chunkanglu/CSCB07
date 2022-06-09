package lab3;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
//import java.io.FileReader;
//import java.io.BufferedReader;
import java.io.FileWriter;
import java.util.regex.*;

public class Tweets2020 {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		Scanner scan = new Scanner(System.in);
		System.out.println("Read path:");
		String read_path = scan.next();
		System.out.println("Write path:");
		String write_path = scan.next();
		
		File f = new File(read_path);
		File[] files = f.listFiles();
	
		for(File i: files) {
//			BufferedReader b = new BufferedReader(new FileReader(i));
//			String line = b.readLine();
//			while(line != null) {
//				System.out.println(line);
//				line = b.readLine();
//			}
			Scanner sc = new Scanner(i);
			String line;
			Pattern pattern = Pattern.compile("^#[\\w]+$");
			FileWriter output = new FileWriter(write_path + File.separatorChar + i.getName(), true);
			
			while(sc.hasNext()) {
				line = sc.next();
				Matcher matcher = pattern.matcher(line);
				if(matcher.matches()) {
//					System.out.println(matcher.group());
					output.write(matcher.group()+"\n");
				}
			}
			output.close();
			sc.close();
		}
		
		scan.close();
	}
}
