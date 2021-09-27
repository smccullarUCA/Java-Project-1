package javaProject1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
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
	
	public Tweet removeTweet(int id) {
		int index = -1;
		int newSize = this.size-1;
		Tweet[] newArray = new Tweet[newSize];
		Tweet ret = null;
		
		for(int i=0;i<this.size;i++) {
			if(tweets[i].getId() == id) {
				index = i;
				ret = tweets[i];
				break;
			}				
		}
		if (index == -1) {
			System.out.println("Could not find " + id + "\"");
			return ret;
		}
			
		System.arraycopy(this.tweets, 0, newArray, 0, index);
		System.arraycopy(this.tweets, index + 1, newArray, index, newArray.length - index);
		
		this.size = newSize;
		this.tweets = newArray;
		return ret;
		
	}
	
	public Tweet searchById(int id) {
		Tweet ret = null;
		
		for(int i=0;i<this.size;i++) {
			if(tweets[i].getId() == id) {
				return tweets[i];
			}				
		}
		
		System.out.println("Could not find " + id + "\"");
		return ret;		
	}
	
	public Tweet searchByName(String user) {
		Tweet ret = null;
		
		for(int i=0;i<this.size;i++) {
			if(tweets[i].getUser().equals(user)) {
				return tweets[i];
			}				
		}
		
		System.out.println("Could not find " + user + "\"");
		return ret;		
	}
	
	public long[] getAllId() {
		long[] ret = new long[size];
		
		for(int i=0;i<size;i++) {
			ret[i] = tweets[i].getId();		
		}
		
		return ret;
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
	
	public void writeFile(String path) {
		try {
		      FileWriter write = new FileWriter(path);
		      for(int i=0;i<size;i++) {
		    	  write.append(tweets[i].getPolatiry() + "," + tweets[i].getId() + "," + tweets[i].getUser() + "," + tweets[i].getText() + "\r\n");
		      }
		      write.close();
		    } catch (IOException e) {
		    }
	}
	
	
	public int predict(String s) {
		//sorry,  ran out of time :(
		return 0;
	}
	
	public double testPredictions() {
		double accuracy = 0;
		
		for(int i=0;i<size;i++) {
//			System.out.println("" + this.predict(tweets[i].getText()) + " " + Integer.parseInt(tweets[i].getPolatiry()));
			if(this.predict(tweets[i].getText()) == Integer.parseInt(tweets[i].getPolatiry())) {
				accuracy += 1;
			}
		}
			
		accuracy = accuracy / size;
		
		return accuracy;
	}
	
	public String toString() {
		String ret = "";
		for(int i=0;i<TOSTRING_LINES;i++)
			System.out.println("Tweet " + i + ": " + tweets[i]);
		
		return ret;
	}
	
	
	
	
	
	
}
