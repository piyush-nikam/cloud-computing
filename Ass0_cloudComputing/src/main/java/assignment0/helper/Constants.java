package assignment0.helper;

import java.util.ArrayList;
import java.util.Arrays;

import software.amazon.awssdk.regions.Region;

public class Constants {
	public static String AMI_AI = "ami-03dcedc81ea3e7e27";
	public static String INSTANCE_TAG = "CloudComputingInstance";
	public static String PEM_FILE = "/home/piyush/Documents/'BITS Course'/Cloud Computing/Assignments/common/keypair_cloudComputing.pem";
	public static String SCRIPT_FILE = "/home/piyush/Documents/BITS Course/Cloud Computing/Assignments/Assignment0/script.sh";
	public static Region MUMBAI_REGION = Region.AP_SOUTH_1;
	public static String KEY_PAIR_NAME = "test";
	public static String SECURITY_GROUP_ID = "sg-0548a16b";
	public static ArrayList<String> SECURITY_GROUP_ID_LIST = new ArrayList<>(Arrays.asList(SECURITY_GROUP_ID));
	public static String PUBLIC_DNS = "ec2-13-232-70-15.ap-south-1.compute.amazonaws.com";
	public static String CMD1 = "chmod 777 /home/ubuntu/script.sh";
	public static String CMD2 = "bash ./script.sh";
}
