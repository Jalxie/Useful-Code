import java.util.Scanner;
import java.text.DecimalFormat;

public class Resistor
{

	//Public Scanner object define
	public static Scanner keyboard = new Scanner(System.in);
	private static Resistor Re = new Resistor();
	private static DecimalFormat df = new DecimalFormat("0.00");

	public static void main(String[] args) 
	{
		double[] resistors = new double[5];
		resistors = new double[] {1.0, 1.2, 1.5, 2.0, 2.7, 3.3, 4.3, 4.7, 5.1, 6.8, 8.2, 10.0, 12.0, 15.0, 20.0, 27.0, 
			33.0, 43.0, 51.0, 68.0, 82.0, 100.0, 120.0};

		String YesOrNo = "Y";
		while(true)
		{
			System.out.println("Please enter the R value you want: ");
			double desiredValue = keyboard.nextDouble();
			Re.parallel(2, resistors, desiredValue);
			System.out.println();
			System.out.println("Quit? (Y/N): ");
			YesOrNo = keyboard.next();
			if(YesOrNo.equals("Y"))
			{
				break;
			}
		}
	}


	public void parallel(int numOfResistor, double[] R, double desiredValue)
	{
		double[] resistors = new double[R.length];

		//Copy the array
		for(int i = 0; i < R.length; i++)
		{
			resistors[i] = R[i];
		}

		//Special value define
		double max = Double.POSITIVE_INFINITY;
		double value1 = 0;
		double value2 = 0;
		double trueValue = 0;
		for(int j = 0; j < R.length; j++)
		{
			
			for(int k = 0; k < R.length; k++)
			{
				//calculated resistance
				double value = calParallel(resistors[j], resistors[k]);

				
				if(value == desiredValue)
				{
					value1 = resistors[j];
					value2 = resistors[k];
					trueValue = value;
					break;
				}	

				double difference = Math.abs(desiredValue - value);
				if(difference < max)
				{
					max = difference;
					value1 = resistors[j];
					value2 = resistors[k];
					trueValue = value;
				}
				// System.out.println(value1 + " " + value2 + " "+ value);
			}
		}

		String formate = df.format(trueValue); 
		System.out.println("Desired R = " + desiredValue + "ohm " + ", R1 = " + value1 + "ohm " + ", R2 = "
		 + value2 + "ohm " + ", which equals to " + formate + "ohm ");

	}

	public double calParallel(double R1, double R2)
	{
		return 1.0/(1.0/R1 + 1.0/R2);
	}

}