package main.ui;

import static org.lwjgl.opengl.GL11.*;

import main.texhandler.BaseTextureLoader;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11.*;

public class MenuMain {
	
	public static RectUI startButtonIdentity = new RectUI(1155f, 680f, /*200f*/250f, /*80f*/80f, 0f, 0.72f, 0.72f, 0.72f, 0.30f, 0.33f, 0.35f);
	public static RectUI startButton = new RectUI(1155f, 710f, /*200f*/250f, /*80f*/80f, 0f, 0.72f, 0.72f, 0.72f, 0.30f, 0.33f, 0.35f);
	
	public static void draw() {
		
		Display.setTitle("Main Menu");
		glPushMatrix();
		BaseTextureLoader.texture.release();
		glLoadIdentity();
		glColor3f(0.32f, 0.32f, 0.32f);
		glBegin(GL_QUADS);
			glVertex2f(0f, 720f);
			glVertex2f(1280f, 720f);
			glVertex2f(1280f, 0f);
			glVertex2f(0f, 0f);
		glEnd();
		startButton.update();
		TTypeF.drawString(1105,  19,  "Start Game", new org.newdawn.slick.Color(0f, 0f, 0f));
		if(Mouse.getX() > (1155f - 125f) && Mouse.getX() < 1280f && Mouse.getY() > 640f && Mouse.getY() < 720) {
			startButton = new RectUI(1155f, 680f, /*200f*/250f, /*80f*/80f, 0f, 0.82f, 0.82f, 0.82f, 0.40f, 0.43f, 0.45f);
			if(Mouse.isButtonDown(0)) {
				DisplayIndex.index = DisplayIndex.MAIN_GAME;
			}
		}else {startButton = startButtonIdentity;}
		glPopMatrix();
	}

}
