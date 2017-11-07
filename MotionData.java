package cme;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/*
 * Class: CMEMotionData
 * This class contains the input data for the CME position
 */
public class CMEMotionData {

	BufferedReader br = null;
	int dataPoint = 0;
	float distance  = 0f;
	float hour = 0f;
	float min = 0f;
	float mass = 0f;
	
	/*
	 * Constructor: CMEMotionData
	 * Input: int datapoint
	 * This constructor spawns new object for buffered reader 
	 * used in this class
	 * 
	 */
	public CMEMotionData(int dp)
	{
		dataPoint = dp;
		br = new BufferedReader(new InputStreamReader(System.in)); 	
	}
	
	/*
	 * Function: getDistance
	 * Input: void
	 * Output: float
	 * This function returns the distance.
	 * 
	 */
	public float getDistance()
	{
		return distance;
	}
	
	/*
	 * Function: setDistance
	 * Input: void
	 * Output: void
	 * This function asks the user to input the distance measured on the screen.
	 * 
	 */
	public void setDistance()
	{
		System.out.print("Enter distance: ");
		String distanceString;
		try {
			distanceString = br.readLine();
			distance = Float.parseFloat(distanceString);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*
	 * Function: getHour
	 * Input: void
	 * Output: float
	 * This function returns the hour .
	 * 
	 */
	public float getHour()
	{
		return hour;
	}
	
	/*
	 * Function: setHour
	 * Input: void
	 * Output: void
	 * This function asks the user to input the hour in the video.
	 * 
	 */
	public void setHour()
	{
		System.out.print("Enter hour: ");
		String hourString;
		try {
			hourString = br.readLine();
			hour = Float.parseFloat(hourString);
			if (hour > 24)
				System.out.print("Hours are less than 24");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	/*
	 * Function: getMin
	 * Input: void
	 * Output: float
	 * This function returns the minutes stored in the class .
	 * 
	 */
	public float getMin()
	{
		return min;
	}
	
	/*
	 * Function: setMin
	 * Input: void
	 * Output: void
	 * This function asks the user to input the minutes in the video.
	 * 
	 */
	public void setMin()
	{
		System.out.print("Enter minute: ");
		String minString;
		try {
			minString = br.readLine();
			min = Float.parseFloat(minString);
			if (min > 60)
				System.out.print("Minute are less than 60");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * Function: getMass
	 * Input: void
	 * Output: float
	 * This function returns the length of mass stored in the class .
	 * 
	 */
	public float getMass()
	{
		return mass;
	}
	
	/*
	 * Function: setMass
	 * Input: void
	 * Output: void
	 * This function asks the user to input the length of mass as seen in the video.
	 * 
	 */
	public void setMass()
	{
		System.out.print("Enter CME width: ");
		String massString;
		try {
			massString = br.readLine();
			mass = Float.parseFloat(massString);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
