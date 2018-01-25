package hhtay;

public class App 
{
	private int width;
	private int height;
	
	public App()
	{
	}
	
	public App (int w, int h)
	{
		width = w;
		height = h;
	}
	
	public int getArea()
	{
		return width * height;
	}
}
