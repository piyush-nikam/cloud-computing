package assignment0.services;

import java.io.IOException;
import java.io.InputStream;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

import assignment0.helper.Constants;

public class ScriptService {
	public void runScript() {
		Runtime runtime = Runtime.getRuntime();
		String cmd = "ssh -i " + Constants.PEM_FILE
				+ " ubuntu@"+Constants.PUBLIC_DNS+" 'bash ./runFile.bash' -o StrictHostKeyChecking=no ";
		cmd = "scp -i /home/piyush/test.pem /home/piyush/script.sh ubuntu@"+Constants.PUBLIC_DNS+":/home/ubuntu";
		System.out.println("CMD to be executed " + cmd);
		try {
			Process p = runtime.exec(cmd);
			p.waitFor();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void executeScript() {
		Runtime runtime = Runtime.getRuntime();
		String cmd = "ssh -i /home/piyush/test.pem ec2-user@"+Constants.PUBLIC_DNS+" chmod 777 /home/ubuntu/script.sh -o StrictHostKeyChecking=no";

		try {
			Process p = runtime.exec(cmd);
			p.waitFor();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void runEC2Script(String cmd) {
		String host = Constants.PUBLIC_DNS;
		String user = "ubuntu";
		
		try {

			java.util.Properties config = new java.util.Properties();
			config.put("StrictHostKeyChecking", "no");
			JSch jsch = new JSch();
			jsch.addIdentity("/home/piyush/test.pem");
			Session session = jsch.getSession(user, host, 22);
			session.setConfig(config);
			session.connect();
			System.out.println("Connected");

			Channel channel = session.openChannel("exec");
			((ChannelExec) channel).setCommand(cmd);
			channel.setInputStream(null);
			((ChannelExec) channel).setErrStream(System.err);

			InputStream in = channel.getInputStream();
			channel.connect();
			byte[] tmp = new byte[1024];
			while (true) {
				while (in.available() > 0) {
					int i = in.read(tmp, 0, 1024);
					if (i < 0)
						break;
					System.out.print(new String(tmp, 0, i));
				}
				if (channel.isClosed()) {
					System.out.println("exit-status: " + channel.getExitStatus());
					break;
				}
				try {
					Thread.sleep(1000);
				} catch (Exception ee) {
				}
			}
			channel.disconnect();
			session.disconnect();
			System.out.println("DONE");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
