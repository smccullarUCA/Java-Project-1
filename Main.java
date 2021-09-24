package javaProject1;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Main {

	public static void main(String[] args) {
		final String PATH = "trainingProcessed.txt";
		TweetCollection tweets = new TweetCollection();
		tweets.readFile(PATH);
		
		System.out.println(tweets);		
		System.out.println(tweets.getTweet(0));
		System.out.println(tweets.getTweet(999999999));
		
	}
}
