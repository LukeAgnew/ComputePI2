import javax.swing.JOptionPane;
import java.util.Scanner;
import java.math.*;

public class computePI2 {
	public static final double PI = 0.0;
	public static final int STARTING_COUNT = 0;
	public static final int STARTING_SIGN = 1;
	public static final double NUMBER_TWO = 2.0;
	
	public static void main(String[] args) {
		String userInput = JOptionPane.showInputDialog(null, "To how many digits (between 1 and 8) would you 													like to calculate Pi?");
		Scanner input = new Scanner(userInput);

		int numOfDigits = input.nextInt();

		if (numOfDigits >= 1 && numOfDigits <= 8)
		{
			int count = STARTING_COUNT;
			int sign = STARTING_SIGN;

			double specifiedPI = PI;
			double firstMultiple = NUMBER_TWO;
		
			Boolean stopLoop = false;

			while (stopLoop == false) 
			{
				BigDecimal previousPI = new BigDecimal(specifiedPI);
				previousPI = previousPI.setScale(numOfDigits, RoundingMode.DOWN);
			
				if (count == 0)
				{ 
					specifiedPI += 3;
					count += 1;
				}
				else
				{
					specifiedPI += sign * 4/(firstMultiple*(firstMultiple+1.0)*(firstMultiple+2.0));
					firstMultiple += 2.0;
					sign *= -1;
				}
			

				BigDecimal currentPI = new BigDecimal(specifiedPI);
				currentPI = currentPI.setScale(numOfDigits, RoundingMode.DOWN);

				if (currentPI.doubleValue() == previousPI.doubleValue())
				{
					specifiedPI = currentPI.doubleValue();
					stopLoop = true;
				}
			
			} 

			JOptionPane.showMessageDialog(null, "The value of PI according to your number of digits 													is: " + specifiedPI + ".");
			input.close();
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Sorry, you must enter a number between 1 and 8 for the number 													of digits.");
			input.close();
		}
	}
}

