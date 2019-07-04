import java.util.Scanner;
import java.text.DecimalFormat;

public class Resistor_V2
{

	//Public Scanner object define
	public static Scanner keyboard = new Scanner(System.in);
	private static Resistor_V2 Re = new Resistor_V2();
	private static DecimalFormat df = new DecimalFormat("0.00");

	public static void main(String[] args) 
	{
		double[] resistors = new double[5];
		resistors = new double[] {0.062, 0.1, 0.13, 0.12, 0.2, 0.36, 0.82, 0.04, 0.69, 0.09, 0.27, 1.0, 
			1.2, 1.5, 2.0, 2.7, 3.3, 4.3, 4.7, 5.1, 6.8, 8.2, 10.0, 12.0, 15.0, 20.0, 27.0, 33.0, 43.0, 51.0, 68.0, 
			82.0, 100.0, 120.0};

		String YesOrNo = "Y";
		while(true)
		{
			System.out.println("Please enter the R value you want: ");
			double desiredValue = keyboard.nextDouble();
			if(!Re.existing(desiredValue, resistors))
			{
				System.out.println("Please enter how many resistors you want to do parallel (2 or 3): ");
				int numberOfResistor = keyboard.nextInt();

				Re.parallel(numberOfResistor, resistors, desiredValue);

				System.out.println();
			} else
			{
				System.out.println("We have " + desiredValue + " Ohm resistor!!!");
			}
			System.out.println("Quit? (Y/N): ");
			YesOrNo = keyboard.next();
			if(YesOrNo.equals("Y"))
			{
				break;
			}
		}
	}

	//main function to do the calculation
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
		double value3 = 0;
		double trueValue = 0;
		for(int j = 0; j < R.length; j++)
		{
			
			for(int k = 0; k < R.length; k++)
			{
				//calculated resistance
				double value = calParallel(resistors[j], resistors[k]);

				// if three resistors
				if(numOfResistor == 3)
				{
					for(int i = 0; i < R.length; i++)
					{
						double valueThree = calParallel(value, resistors[i]);

						if(value == desiredValue)
						{
							value1 = resistors[j];
							value2 = resistors[k];
							value3 = resistors[i];
							trueValue = valueThree;
							break;
						}	

						double difference = Math.abs(desiredValue - valueThree);
						if(difference < max)
						{
							max = difference;
							value1 = resistors[j];
							value2 = resistors[k];
							value3 = resistors[i];
							trueValue = valueThree;
						}

					}
					
				}

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
		if(numOfResistor == 3)
		{
			System.out.println("Desired R = " + desiredValue + "ohm " + ", R1 = " + value1 + "ohm " + ", R2 = "
		 + value2 + "ohm " + ", R3 = " + value3 + "ohm " + ", which equals to " + formate + "ohm ");
		}
		else
		{
			System.out.println("Desired R = " + desiredValue + "ohm " + ", R1 = " + value1 + "ohm " + ", R2 = "
		 + value2 + "ohm " + ", which equals to " + formate + "ohm ");
		}

	}
	
	//Parallel R calculator
	public double calParallel(double R1, double R2)
	{
		return 1.0/(1.0/R1 + 1.0/R2);
	}

	//If the R exists or not
	public Boolean existing(double R, double[] resistorList)
	{
		for(int i = 0; i < resistorList.length; i++)
		{
			if(R == resistorList[i])
				return true;
		}
		return false;
	}

}