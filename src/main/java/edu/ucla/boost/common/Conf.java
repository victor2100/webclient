package edu.ucla.boost.common;

public class Conf {
	public static Boolean debug = false;
	
	public static String websitePath = "/home/victor/boost_website";
	public static String serverName = "localhost"; //"wise-u10.cs.ucla.edu";
		
	//public static String remotePlanPath = "jiaqi@yellowstone.cs.ucla.edu:~/test.txt";
	public static String remotePlanFile = "hadoop-user@131.179.64.66:~/sharks/boost/shark/json_plan.txt";
	public static String planFile = "json_plan.txt";
	
	public static Integer port = 8080;
	public static Integer sharkPort = 10000;
	public static Integer hivePort = 10000;
	
	public static String getConnectionAddress() {
		boolean sharkMode = true;
		if (sharkMode) {
			return "jdbc:hive://" + serverName + ":" + sharkPort + "/default";
		}
		else {
			return "jdbc:hive://" + serverName + ":" + hivePort + "/default";
		}
	}
}