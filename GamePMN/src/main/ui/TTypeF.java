package main.ui;

import java.awt.Font;

import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;
import org.newdawn.slick.TrueTypeFont;

public class TTypeF {
	
	static Font awtFont = new Font("Times New Roman", Font.BOLD, 24);
	public static TrueTypeFont font = new TrueTypeFont(awtFont, false);
	
	public static void drawString(float x, float y, String text, Color color) {
		
		glPushMatrix();
		GL11.glDisable(GL11.GL_DEPTH_TEST);
        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glPushMatrix();
        GL11.glLoadIdentity();
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glOrtho(0, 1280, 720, 0, 1, -1);
		GL11.glMatrixMode(GL11.GL_MODELVIEW_MATRIX);
		font.drawString(x, y, text, color);
		GL11.glDisable(GL11.GL_DEPTH_TEST);
        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glPushMatrix();
        GL11.glLoadIdentity();
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glDisable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glOrtho(0, 1280, 0, 720, 1, -1);
		glMatrixMode(GL_MODELVIEW);
		glPopMatrix();
		glLoadIdentity();
		
	}

}
