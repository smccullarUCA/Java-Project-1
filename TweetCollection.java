package javaProject1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TweetCollection {
	private Tweet[] tweets;
	private int size;
	private final int DEFAULT_SIZE = 10;
	private final int TOSTRING_LINES = 10;
	
	private void doubleArray () {
		Tweet[] temp = new Tweet[tweets.length*2];
		for (int i = 0; i < size; i++) {
			temp[i] = tweets[i];
		}		
		tweets = temp;
	}
	
	public TweetCollection() {
		size = DEFAULT_SIZE;
		tweets = new Tweet[size];
	}
	
	public TweetCollection(int size) {
		this.size = size;
		tweets = new Tweet[size];
	}
	
	public void addTweet(Tweet t) {
		if (size >= tweets.length)
			doubleArray();
		tweets[size] = t;
		size++;
	}
	
	public Tweet getTweet(int i) {
		return tweets[i];
	}
	
	public void readFile(String path) {
		try {		
			BufferedReader read = new BufferedReader(new FileReader(path));

			String line;
			int i=0;
			while ((line = read.readLine()) != null) {
		        Tweet tweet = new Tweet(line);
		        addTweet(tweet);
		        i++;
			};
			System.out.println("Read " + i + " lines");
			read.close();
			
			System.out.println(tweets[5]);
				
		} catch (FileNotFoundException e) {
			
		} catch (IOException e) {
			
		}
		
	}
	
	
	public String toString() {
		String ret = "";
		for(int i=0;i<TOSTRING_LINES;i++)
			System.out.println("Tweet " + i + ": " + tweets[i]);
		
		return ret;
	}
	
	
	
	
	
	
}
