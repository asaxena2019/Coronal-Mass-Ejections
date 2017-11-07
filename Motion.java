package cme;

public class CMEMotion {

	/*
	 * Main entry point to the program
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CMEMotionDataInput dataInput= new CMEMotionDataInput();
		CMEMotionDataAnalysis dataAnalysis = new CMEMotionDataAnalysis(dataInput);
		dataInput.done = 1;
	}

}
