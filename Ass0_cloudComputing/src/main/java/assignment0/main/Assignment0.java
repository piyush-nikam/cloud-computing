package assignment0.main;

import java.util.Scanner;

import assignment0.helper.Constants;
import assignment0.services.InstanceService;
import assignment0.services.MenuService;
import assignment0.services.ScriptService;

public class Assignment0 {

	public static void main(String[] args) {
		new Assignment0().performAction();
	}

	private void performAction() {
		MenuService menu = new MenuService();
		InstanceService instance =  new InstanceService();
		ScriptService ss = new ScriptService();

		int input;
		Scanner in = new Scanner(System.in);

		do {
			menu.showOptions();
			input = in.nextInt();
			switch (input) {
			case 1: {
				instance.createInstance();
			}
				break;
			case 2: {
				ss.runScript();
				ss.runEC2Script(Constants.CMD1);
				ss.runEC2Script(Constants.CMD2);
			}

				break;

			case 3:
				return;

			default:
				break;
			}
		} while (input != 3);
		
		in.close();
	}
}
