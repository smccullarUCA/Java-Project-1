package javaProject1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TweetCollection {
	private Tweet[] tweets;
	private int size = 0;
	private final int DEFAULT_SIZE = 16;
	private final int TOSTRING_LINES = 10;
	
	private void doubleArray () {
		Tweet[] temp = new Tweet[size*2];	
		System.arraycopy(tweets, 0, temp, 0, size);	
		tweets = temp;
	}
	
	public TweetCollection() {
		tweets = new Tweet[DEFAULT_SIZE];
	}
	
	public TweetCollection(int size) {
		tweets = new Tweet[size];
	}
	
	public void addTweet(Tweet t) {
		if (size >= tweets.length)
			doubleArray();
		
		tweets[size] = t;
		size++;
	}
	
	public Tweet getTweet(int i) {
		if (i<size) {
			return tweets[i];
		} else {
			return null;
		}
	}
	
	public void readFile(String path) {
		try {		
			BufferedReader read = new BufferedReader(new FileReader(path));

			String line;
//			int i=0;
			while ((line = read.readLine()) != null) {
		        Tweet tweet = new Tweet(line);
		        addTweet(tweet);
//		        i++;
			};
//			System.out.println("Read " + i + " lines");
			read.close();				
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
