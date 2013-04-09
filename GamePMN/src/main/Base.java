package main;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.opengl.*;

public class Base {
	
	public static long sysNano = System.nanoTime();
	private static int fps = 60;

	public static void main(String[] args) {
		
		Display.setTitle("This is a game.");
		
		try {
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
			System.out.println("Failed to initialize the display");
		}
		
		while(!Display.isCloseRequested()) {
			sysNano = System.nanoTime();
			
			glClear(GL_COLOR_BUFFER_BIT);
			
			glPushMatrix();
			glLoadIdentity();
			glEnable(GL_TEXTURE_2D);
			glEnable(GL_BLEND);
			glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
			
			glPopMatrix();
			
			Display.update();
			Display.sync(fps);
		}
		
	}
	
}
