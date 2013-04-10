package main;

import main.ent.Char;
import org.lwjgl.LWJGLException;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.opengl.*;

public class Base {
	
	public static long sysNano = System.nanoTime();
	private static int fps = 60;
	public static Char p = new Char();

	public static void main(String[] args) {
		
		Display.setTitle("This is a game.");
		
		try {
			Display.setDisplayMode(new DisplayMode(1280, 720));
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
			System.out.println("Failed to initialize the display");
		}
		
		GL11.glDisable(GL11.GL_DEPTH_TEST);
        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glPushMatrix();
        GL11.glLoadIdentity();
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glOrtho(0, 1280, 720, 0, 1, -1);
        GL11.glMatrixMode(GL11.GL_MODELVIEW);
        GL11.glPushMatrix();
        GL11.glLoadIdentity();
        
		p.setX(640);
		p.setY(360);
		while(!Display.isCloseRequested()) {
			sysNano = System.nanoTime();
			
			//Display.setTitle("x= " + Mouse.getX() + " y=" + Mouse.getY());
			
			GL11.glColor3f(1.0f, 0.5f, 0.0f);
			glBegin(GL_QUADS);
			glVertex3f(0f, 10f, 0.5f);//top left
			glVertex3f(10f, 10f, 0.5f);//top right
			glVertex3f(10f, 0f, 0.5f);//bottom right
			glVertex3f(0f, 0f, 0.5f);//bottom left
			glEnd();
			
			p.update();
			GL11.glMatrixMode(GL11.GL_MODELVIEW);
		    GL11.glLoadIdentity();

		    GL11.glMatrixMode(GL11.GL_PROJECTION_MATRIX);
		    GL11.glLoadIdentity();

		    GL11.glPopMatrix();
		    Display.update();
		    //Display.sync(fps);
		      
		}
		Display.destroy();
		System.exit(0);
		
	}
	
}
