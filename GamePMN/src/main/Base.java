package main;

import main.ent.Char;
import main.texhandler.BaseTextureLoader;
import main.tile.Tile;
import main.ui.DisplayIndex;
import main.ui.MenuMain;
import main.ui.Rect;
import main.ui.TTypeF;

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
	static Tile tile = new Tile(0, 0);
	public static boolean exitOnNextCycle = false;

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
        GL11.glOrtho(0, 1280, 0, 720, 1, -1);
        GL11.glMatrixMode(GL11.GL_MODELVIEW);
        GL11.glPushMatrix();
        GL11.glLoadIdentity();
        
        BaseTextureLoader.load();
        
		p.setX(640);
		p.setY(360);
		
		while(!Display.isCloseRequested() && !exitOnNextCycle) {
			
			sysNano = System.nanoTime();
			Display.setTitle(Mouse.getX() + " " + Mouse.getY());
			glClear(GL_COLOR_BUFFER_BIT);
			
			BaseRenderer.render();
			
			long done = System.nanoTime();
			long d = done - sysNano;
			//TTypeF.drawString(32, 700, String.format("%d",  1000000000 / d) + " fps", new org.newdawn.slick.Color(1.0f, 1.0f, 0.0f));
			
			GL11.glMatrixMode(GL11.GL_MODELVIEW);
		    GL11.glLoadIdentity();

		    GL11.glMatrixMode(GL11.GL_PROJECTION_MATRIX);
		    GL11.glLoadIdentity();

		    GL11.glPopMatrix();
		    Display.update();
		    Display.sync(fps);
		      
		}
		Display.destroy();
		System.exit(0);
		
	}
	public static void updatePos() {
		glTranslatef(-p.translateX, -p.translateY, 0);
	}
	
}
