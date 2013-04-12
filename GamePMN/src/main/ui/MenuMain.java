package main.ui;

import static org.lwjgl.opengl.GL11.*;

import main.texhandler.BaseTextureLoader;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11.*;

public class MenuMain {
	
	public static RectUI startButton = new RectUI(1055f, 710f, /*200f*/450f, /*80f*/20f, 0f, 0.2f, 0.81f, 1f, 1f, 1f, 1f);
	
	public static void draw() {
		
		Display.setTitle("Main Menu");
		glPushMatrix();
		BaseTextureLoader.texture.release();
		glLoadIdentity();
		glColor3f(0.22f, 0.22f, 0.22f);
		glBegin(GL_QUADS);
			glVertex2f(0f, 720f);
			glVertex2f(1280f, 720f);
			glVertex2f(1280f, 0f);
			glVertex2f(0f, 0f);
		glEnd();
		startButton.update();
		TTypeF.drawString(1180,  80,  "Test", org.newdawn.slick.Color.green);
		glPopMatrix();
	}

}
