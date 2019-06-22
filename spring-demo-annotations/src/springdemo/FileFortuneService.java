package springdemo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

import org.springframework.stereotype.Component;

@Component
public class FileFortuneService implements FortuneService {
	
	public String fileName = "fortune-data.txt";
	
	public List<String> fortunes;
	
	public Random random = new Random();
	
	public FileFortuneService() {
		
		File myFile = new File(fileName);
		fortunes = new ArrayList<>();
		try {
			Scanner sc = new Scanner(myFile);
			while (sc.hasNext()) {
				String fortune = sc.nextLine();
				fortune.trim();
				fortunes.add(fortune);
			}
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public String getFortune() {
		
		int idx = random.nextInt(fortunes.size());
		return fortunes.get(idx);
		
	}

}
