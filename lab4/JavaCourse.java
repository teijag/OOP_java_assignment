//Rong Gui
//rgui

package lab4;

import java.io.File;
import java.util.*;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class JavaCourse {
	Content[] contents;

	public static void main(String[] args) {
		JavaCourse javaCourse = new JavaCourse();
		javaCourse.loadContentsArray(javaCourse.readJavaContent());
		javaCourse.printCourseSummary();
		javaCourse.peruseContent();
	}

	/**readJavaContent() reads JavaContent.csv
	 * and loads each of its row as a string into an array. 
	 * It returns the array.
	 */
	String[] readJavaContent() {
		StringBuilder contentStrings = new StringBuilder();
		try {
			Scanner input = new Scanner(new File("JavaContent.csv"));
			while (input.hasNextLine()) {
				contentStrings.append(input.nextLine() + "\n");
			}
			input.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return contentStrings.toString().split("\n");
	}

	
	void loadContentsArray(String[] contentStringsArray) {
		String type = null;
		contents = new Content[contentStringsArray.length];
		for (int i = 0; i < contentStringsArray.length;i++) {
			type = contentStringsArray[i].split(",")[0].trim();
			if (type.equals("Video")) {
				String name = contentStringsArray[i].split(",")[1].trim();
				int duration = Integer.parseInt(contentStringsArray[i].split(",")[2].trim());
				Video video = new Video(name,duration);
				contents[i] = video;
			}
			else if (type.equals("Practice")) {
				String name = contentStringsArray[i].split(",")[1].trim();
				int duration = Integer.parseInt(contentStringsArray[i].split(",")[2].trim());
				int size = Integer.parseInt(contentStringsArray[i].split(",")[3].trim());
				PracticeProblem problem = new PracticeProblem(name,duration,size);
				contents[i] = problem;
			}
		}
	}
	
	//do not change this method
	void printCourseSummary() {
		System.out.println("*** JAVA COURSE SUMMARY ***");
		System.out.println("------------------------------------------");
		System.out.printf("%-30s%3d%n", "Total contents:", Content.getContentCount());
		System.out.printf("%-30s%3d%n", "Total videos:", Video.getVideoCount());
		System.out.printf("%-30s%3d%n", "Total practice problems:", PracticeProblem.getPracticeProblemCount());
		System.out.println("------------------------------------------");
		System.out.printf("%-30s%3d min.%n", "Total practice time:", PracticeProblem.getTotalPracticeTime());
		System.out.printf("%-30s%3d min.%n", "Total video time:", Video.getTotalVideoTime());
		System.out.println("------------------------------------------");
	}
	
	void peruseContent() {
		System.out.println("List of Java contents");
		for (int i = 0; i<contents.length;i++) {
			System.out.printf("%-1d%-1s%-40s%-20s%-2d%-5s%n", i+2, ". ", contents[i].contentName, "Learning time:", contents[i].learningTime, "min.");
		}
		System.out.println("Enter the content number between 1 and " + contents.length);
		Scanner input = new Scanner(System.in);
		int choice = 0;
		choice = input.nextInt()-1;
		Random r = new Random();
		int speed = r.nextInt(10)+35;
		if (contents[choice] instanceof PracticeProblem) {
			((PracticeProblem)contents[choice]).download(speed);
		}
	}
	
}
