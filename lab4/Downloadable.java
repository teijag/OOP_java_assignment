//Rong Gui
//rgui

package lab4;

public interface Downloadable {
	static final int INTERNET_SPEED_MBPS = 40;
	
	abstract float download(int speed);
}
