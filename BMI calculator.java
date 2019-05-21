package J2_RithvikPeeriga_MID_THM;

import java.util.Scanner; // I/P # of personâ€™s name, w, h, count normal, overweight & obese people 
import javax.swing.JOptionPane; //JOptionPane.showInputDialog (  ); JOptionPane.showMessageDialog(null,   );

public class J2x_RithvikPeeriga_MID_THM {
	
	
	/* Spring 2019, CSCI_185, W02, prog2/java2, MIDTERM section 2 (THM)
	Team members-
		Team leader: Rithvik Peeriga
		Member: Devanshi 
	THM Program title: THM-Calculate Unknown # of Personâ€™s BMI & Provide Data Retrieval Service
	*/

	public static void main(String[] z) {
		Scanner k = new Scanner(System.in); // change this line insert // in start of this line //*
		String title = "Calculate Unknown # of Personâ€™s BMI & Provide Data Retrieval Service"
				+ "\nStep 1: Enter name, weight & height for every body first"
				+ "\nStep 2: The program  calculates all BMI first, it then"
				+ "\nStep 3: calculate number of people are under weight"
				+ "\nStep 4: calculate number of people are normal weight"
				+ "\nStep 5: calculate number of people are over weight"
				+ "\nStep 6: calculate number of people are in obesity range\n\n";
		String s1 = "Programmer name";
		String s2 = "Enter maximum # of people for BMI calculation";
		String s3 = "Enter name"; // loop for names
		String s4 = "Enter weight in pounds"; // loop for weights
		String s5 = "Enter height in inches"; // loop for heights
		String cmt1 = "You are under weight"; // loop to auto add cmt - under
		String cmt2 = "You are normal weight"; // loop to auto add cmt - normal
		String cmt3 = "You are over weight"; // loop to auto add cmt - over
		String cmt4 = "You are obese weight"; // loop to auto add cmt - obese

		JOptionPane.showMessageDialog(null, title); // disp program title
		String PName = JOptionPane.showInputDialog(s1); // enter programmmer's name
		String maxS = JOptionPane.showInputDialog(s2); // enter array size in String type variable
		final int max = Integer.parseInt(maxS); // convert String maxS to integer for array size //*

		String[] name = new String[max]; // declare arrays: name, w, h, bMI, cmt
		// String[ ] name1=new String [max]; //for retrieval
		int[] w = new int[max]; // weight
		int[] h = new int[max]; // height
		double[] bMI = new double[max]; // calculated BMI
		String[] cmt = new String[max]; // cmt (comment) BMI, as underW etc

		final double BUNDER = 18.5;
		int cUnder = 0; // under W bmi range & count # of Under weight
		final double BNORMAL = 25.0;
		int cNormal = 0; // normal W bmi range & count # of Normal weight
		final double BOVER = 30.0;
		int cOver = 0; // over W bmi range & count # of Over weight
		final double BOBESE = 30.0;
		int cObese = 0; // obese W bmi range & count # of Obese weight

		// continued on next page
		// This section allows user enter name, weight, height for up to max number of
		// people.

		String wS;
		String hS; // weight & height in String to be converted to integer via wrape class Integer

		int i = 0; // set array index from 0
		boolean more = true; // Loop control set to true to begin
		while (more) // if more BMI & index i less than max, then loop again
		{
			name[i] = JOptionPane.showInputDialog(s3); // enter name
			wS = JOptionPane.showInputDialog(s4);
			w[i] = Integer.parseInt(wS); // enter&cnvrt wS to integer
			hS = JOptionPane.showInputDialog(s5);
			h[i] = Integer.parseInt(hS); // enter&cnvrt hS to integer

			bMI[i] = calc_bMI(w[i], h[i]); // calc bMI value
			cmt[i] = get_cmt(bMI[i], BUNDER, BNORMAL, BOVER, BOBESE, cmt[i], cUnder, cNormal, cOver, cObese); // analyze
																												// bMI
																												// for
																												// cmt
																												// about
																												// bMI

			JOptionPane.showMessageDialog(null, "Name: " + name[i] + "\nWeight= " + w[i] + "\nHeight= " + h[i]
					+ "\nbMI= " + bMI[i] + "\ncmt= " + cmt[i]);
			
			
			

			int answer = JOptionPane.showConfirmDialog(null, "Continue calculating BMI?", "Click Yes or No:",
					JOptionPane.YES_NO_OPTION);

			if (answer == JOptionPane.YES_OPTION) {
				i++;
			}

			else if (answer == JOptionPane.NO_OPTION) {
				int answer2 = JOptionPane.showConfirmDialog(null, "Do you want to start BMI data retrival service?",
						"Click Yes or NO: ", JOptionPane.YES_NO_OPTION);
				if (answer2 == JOptionPane.YES_OPTION) {

					
					
					
					
					String answer3 = JOptionPane.showInputDialog(null, "Enter name to retrive data");


					for (int j =0 ; j < max;j++) {
						String n = name[j];
							
						if (answer3.equals(n)) {
							
							
	
							// System.out.println(i);
	
							JOptionPane.showMessageDialog(null, "Name: " + name[j] + "\nWeight= " + w[j] + "\nHeight= "
									+ h[j] + "\nbMI= " + bMI[j] + "\ncmt= " + cmt[j]);
						}
					}
					
					System.out.println("retrieval service called");
					System.exit(0);
				}

				else {
					System.exit(0);
				}
			}

// kiran balgani , pol agusthe 
			
			// System.out.print ("Enter true for More BMI, false for No more: ");
			// more = k.nextBoolean();//change this line
			// i++; //increase index for next BMI values
			if (more && (i < max))
				continue; // it means continue to enter next name, w, h et c. {
			else {
				JOptionPane.showConfirmDialog(null,
						"More BMI values to be calculated" + "\nor maximum array elements reached= " + max
								+ "\neither condition happened, BMI data retrieval service starts!",
						"Click Yes or No: ", JOptionPane.YES_NO_OPTION);

				if (answer == JOptionPane.YES_OPTION) {

					
					get_retrival(name, w,h, bMI, cmt,max);
					
					System.out.println("Here is the BMI");
					more = false;
					// int j = 0;
					// name1 [ j ]= JOptionPane.showInputDialog("Enter name: ");
				} else {
					System.out.print("\nEnd of BMI base data entry!");
					more = false;
				}
				
			}
		}
	} // end of main method

	// continued on next page
	// This section calculates a personâ€™s bMI value
	public static double calc_bMI(int weight, int height)

	{
		return (weight * 703) / (height * height); // 703 - conversion factor from imperial to metric
	}

	// This section analyze the parameter BMI value for comment (cmt): under, normal
	// weight, over, & obese
	public static String get_cmt(double bMI, double BUNDER, double BNORMAL, double BOVER, double BOBESE, String cmt,
			int cUnder, int cNormal, int cOver, int cObese) {
		String comment = null;
		if (bMI <= BUNDER) {
			cUnder += 1;
			comment = "You are under weight";
		}

		if (bMI > BUNDER && bMI <= BNORMAL) {
			cNormal += 1;
			comment = "You are normal weight";
		}

		if (bMI > BNORMAL && bMI <= BOVER) {
			cOver += 1;
			comment = "You are over weight";
		}

		if (bMI > BOVER && bMI <= BOBESE) {
			cObese += 1;
			comment = "You are over weight";
		}
		return comment;
	}
	
	public static void get_retrival(String name[],int []w, int []h,double[] bMI,String[]cmt,int max ) {
		
		String answer3 = JOptionPane.showInputDialog(null,"Enter name to retrive data");
		
		for (int j =0; j< max;j++) {
			
			String n = name[j];
			if (answer3.equals(n)) {
				

				JOptionPane.showMessageDialog(null, "Name: " + name[j] + "\nWeight= " + w[j] + "\nHeight= "
						+ h[j] + "\nbMI= " + bMI[j] + "\ncmt= " + cmt[j]);
				
		
				
			}  // end of if statement 
			
		} // end of for loop 
		
		
	}  // end of get_retrival 
	
	
 // end of class

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
