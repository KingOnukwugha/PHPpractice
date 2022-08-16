//Class created by me
package org.company;
import java.lang.IllegalArgumentException;
import java.util.Scanner;

public class Hamster implements Animal{
	private Scanner listen;
	public void makeNoise() {
		System.out.println("Squeek squeek..");
		showTalent();
	}
	
	@SuppressWarnings("deprecation")
	public void showTalent() {
		boolean thrown = false;
		try {
			listen = new Scanner(System.in);
			System.out.println("\nPlease tell me how many flips I should do ... squeek... ?:");
			Integer numFlip = listen.nextInt();
			if (numFlip > 4) {
				System.out.print("Are you crazy that's too many flips ... Squeek..");
				numFlip = 0;
				showTalent();
			}
			try {
				for(int i = 1; i <= numFlip*4;i++) {
					PicRender display = new PicRender(i);
					display.removeAll();
					System.out.println(i);
				}
				
			}catch(IllegalArgumentException e) {
				thrown = true;
				e.printStackTrace();
				System.out.println("The image failed to display");
			}
		}
		catch(Exception e) {
			thrown = true;
			e.printStackTrace();
			System.out.println("You have .not typed acceptable input \n"
					+ "The only acceptable inputs must be positive integer less than: [2,147,483,647] \n"
					+ "Example#: 1... 2... 101... 2147483646 \n"
					+ "You will be taken back to original question... \n");
			//showTalent();
		}if(!thrown) {
			System.out.print("Trick was performed successful");
		}else {
			System.out.print("Trick was performed unsuccessful");
		}
	}
}