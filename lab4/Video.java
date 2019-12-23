//Rong Gui
//rgui

package lab4;

public class Video extends Content {
	private static int videoCount;
	private static int totalVideoTime;
	
	Video(String contentName, int learningTime) {
		super(contentName, learningTime);
		// TODO Auto-generated constructor stub
		videoCount += 1;
		totalVideoTime += learningTime;
	}

	@Override
	public void learn() {
		// TODO Auto-generated method stub
		System.out.println("Watching: ");
		System.out.print(contentName);
		System.out.print(" for"+ learningTime + "minutes.");

	}
	
	public static int getVideoCount() {
		return videoCount;
	}
	
	public static int getTotalVideoTime() {
		return totalVideoTime;
	}
	

}
