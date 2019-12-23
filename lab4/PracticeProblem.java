//Rong Gui
//rgui

package lab4;

public class PracticeProblem extends Content implements Downloadable{

	private static int practiceProblemCount;
	private static int totalPracticeTime;
	int fileSize;
	
	PracticeProblem(String contentName, int learningTime, int fileSize) {
		super(contentName, learningTime);
		this.fileSize = fileSize;
		practiceProblemCount += 1;
		totalPracticeTime += learningTime;
	
	}
	public static int getPracticeProblemCount() {
		return practiceProblemCount;
	}
	public static int getTotalPracticeTime() {
		return totalPracticeTime;
	}
	
	@Override
	public void learn() {
		// TODO Auto-generated method stub
		System.out.print("Now working on:");
		System.out.print(contentName);
		System.out.print(" for"+ learningTime + "minutes.");
	}
	
	@Override
	public float download(int speed) {
		// TODO Auto-generated method stub
		System.out.println("Expected time to download ... @" + INTERNET_SPEED_MBPS + " is " + (float)(fileSize/INTERNET_SPEED_MBPS) + " seconds");
		System.out.println("Actual time to download ... @" + speed + " is " + (float) fileSize/speed + " seconds");
		return (float)fileSize/speed;
	}

}
