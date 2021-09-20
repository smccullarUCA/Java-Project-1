package javaProject1;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Main {

	public static void main(String[] args) {
		try {
			
			BufferedReader read = new BufferedReader(new FileReader("trainingProcessed.txt"));
			
			TweetCollection tweets = new TweetCollection();

			String line;
			while ((line = read.readLine()) != null) {
		        Tweet tweet = new Tweet(line);
		        tweets.addTweet(tweet);
			};
			
			read.close();
	
			
		} catch (FileNotFoundException e) {
			
		} catch (IOException e) {
			
		}
	
	}
}
