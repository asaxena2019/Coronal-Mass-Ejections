package cme;

/*
 * Class CMEMotionDataAnalysis
 * This class does the data analysis for the CME
 */
public class CMEMotionDataAnalysis {
	float distance = 149600000f;
	float actDia = 1391684.0f;
	float mesDia = 2.0f;
	float min = 0f;
	float hour = 0f;
	int date = 0;
	int month = 0;
	int year = 0;
	
	float hour1 = 0f;
	float hour2 = 0f;
	float hour3 = 0f;
	
	float min1 = 0f;
	float min2 = 0f;
	float min3 = 0f;
	
	float dis1 = 0f;
	float dis2 = 0f;
	float dis3 = 0f;
	
	float pos1 = 0f;
	float pos2 = 0f;
	float pos3 = 0f;

	float vel1 = 0f;
	float vel2 = 0f;
	float vel3 = 0f;
	float acc1 = 0f;
	float acc2 = 0f;
	float acc3 = 0f;
	
	double time = 0d;
	
	float actMass = 0f;
	float mesMass = 0f;	
	
	float cross = 0f;
	float duration = 0f;
	
	/*
	 * Class Constructor: CMEMotionDataAnalysis
	 * Parameters: Object CMEMotionDataInput
	 */
	public CMEMotionDataAnalysis(CMEMotionDataInput dataInput)
	{
		System.out.print("Distance 1: " + dataInput.dataInp1.getDistance() + "\n");
		System.out.print("Hour 1: " + dataInput.dataInp1.getHour() + "\n");
		System.out.print("Minutes 1: " + dataInput.dataInp1.getMin() + "\n");
		System.out.print("Distance 2: " + dataInput.dataInp2.getDistance() + "\n");
		System.out.print("Hour 2: " + dataInput.dataInp2.getHour() + "\n");
		System.out.print("Minutes 2: " + dataInput.dataInp2.getMin() + "\n");
		System.out.print("Distance 3: " + dataInput.dataInp3.getDistance() + "\n");
		System.out.print("Hour 3 " + dataInput.dataInp3.getHour() + "\n");
		System.out.print("Minutes 3: " + dataInput.dataInp3.getMin() + "\n" + "\n");
		
		year = dataInput.timeInp.getYear();
		month = dataInput.timeInp.getMonth();
		date = dataInput.timeInp.getDate();
		hour = dataInput.dataInp1.getHour();
		
		
		hour1 = dataInput.dataInp1.getHour();
		hour2 = dataInput.dataInp2.getHour();
		hour3 = dataInput.dataInp3.getHour();
		
		
		System.out.print("Hour 1 " + hour1 + "\n");
		System.out.print("Hour 2 " + hour2 + "\n");
		System.out.print("Hour 3 " + hour3 + "\n"+ "\n");
		
		min1 = getMinutes(dataInput.dataInp1.getHour(),dataInput.dataInp1.getMin() );
		min2 = getMinutes(dataInput.dataInp2.getHour(),dataInput.dataInp2.getMin() );
		min3 = getMinutes(dataInput.dataInp3.getHour(),dataInput.dataInp3.getMin() );
		
		min = dataInput.dataInp1.getMin();
		
		dis1 = dataInput.dataInp1.getDistance();
		dis2 = dataInput.dataInp2.getDistance();
		dis3 = dataInput.dataInp3.getDistance();
		
		
		pos1 = getPosition (dis1);
		pos2 = getPosition (dis2);
		pos3 = getPosition (dis3);
		
		System.out.print("Position 1 " + pos1 + "\n");
		System.out.print("Position 2 " + pos2 + "\n");
		System.out.print("Position 3 " + pos3 + "\n"+ "\n");
		
		vel1 = pos1/min1;
		vel2 = pos2/min2;
		vel3 = pos3/min3;
		
		System.out.print("Velocity 1 " + vel1 + "\n");
		System.out.print("Velocity 2 " + vel2 + "\n");
		System.out.print("Velocity 3 " + vel3 + "\n"+ "\n");
		
		acc1 = vel1/min1;
		acc2 = (vel2 - vel1)/(min2 - min1);
		acc3 = (vel3 - vel2)/(min3 - min2);
		
		System.out.print("Accelatation 1 " + acc1 + "\n");
		System.out.print("Accelatation 2 " + acc2 + "\n");
		System.out.print("Accelatation 3 " + acc3 + "\n" + "\n");
		
		System.out.print("Time1 : " + getTime(acc1)/60/24 + "\n");
		System.out.print("Time2 : " + getTime(acc2)/60/24 + "\n");
		System.out.print("Time3 : " + getTime(acc3)/60/24 + "\n" + "\n");
		
		duration = (float) (getTime(acc3)/60/24);
		
		mesMass = dataInput.dataInp3.getMass();
		actMass = getPosition (mesMass);
		
		cross = (float) (actMass / (acc3 * getTime(acc3)));
		
		System.out.print("Time to cross earth : " + (actMass / (acc3 * getTime(acc3))) + "\n");
		
		CMEMotionLog log = new CMEMotionLog();
		log.logFile(year, month, date, (int)hour1, (int)min, duration, cross);

	}

	/*
	 * Function: getPosition
	 * Input: float
	 * Output: float
	 * This function returns the position of CME
	 * relative to the position of the sun
	 * 
	 */
	public float getPosition (float pos)
	{
		float position = 0f;
		position = (pos * actDia)/mesDia;
		return position;
	}
	
	/*
	 * Function: getMinutes
	 * Input: float hour, float minutes
	 * Output: float
	 * This function calculates the hours in minutes 
	 * returns the sum of minutes. 
	 */
	public float getMinutes(float f, float g)
	{
		return (f * 60) + g;
	}
	
	/*
	 * Function: getTime
	 * Input: double acceleration
	 * Output: double
	 * This function does a mathematical calculation to
	 * calculate the time from distance and acceleration
	 */
	public double getTime(double acc)
	{
		return Math.sqrt((2 * distance)/acc);
	}
}
