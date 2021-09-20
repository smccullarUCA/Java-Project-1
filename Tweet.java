package javaProject1;

public class Tweet {
	
	private String polarity;
	private long id;
	private String user;
	private String text;
	
	public Tweet() {
		this("0,0,0,0");
	}
	
	public Tweet(String s) {
		polarity = s.split(",")[0];
		
		try {
				id = Long.parseLong(s.split(",")[1]);
			}
			catch (NumberFormatException e)
			{
				System.out.println("Int parse error");
				id = 0;
			}
		
		user = s.split(",")[2];
		text = s.split(",")[3];
	}
	
	public String getPolatiry() {
		return polarity;
	}
	
	public long getId() {
		return id;
	}
	
	public String getUser() {
		return user;
	}
	
	public String getText() {
		return text;
	}
	
	
	
	public String toString() {
		return polarity + id + user + text;
	}
}
