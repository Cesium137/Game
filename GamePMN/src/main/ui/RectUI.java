package main.ui;

import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glPopMatrix;
import static org.lwjgl.opengl.GL11.glPushMatrix;
import static org.lwjgl.opengl.GL11.glTranslatef;
import static org.lwjgl.opengl.GL11.glVertex2f;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;

import main.Base;

public class RectUI {

	float x;
	float y;
	float width;
	float length;
	float rot;
	float r1;
	float g1;
	float b1;
	float r2;
	float g2;
	float b2;
	boolean focused;
	
	public RectUI(float defX, float defY, float defWidth, float defLength, float defRot, float defR1, float defG1, float defB1, float defR2, float defG2, float defB2) {
		
		this.x = defX;
		this.y = defY;
		this.width = defWidth;
		this.length = defWidth;
		this.rot = defRot;
		this.r1 = defR1;
		this.g1 = defG1;
		this.b1 = defB1;
		this.r2 = defR2;
		this.g2 = defG2;
		this.b2 = defB2;
		
	}
	
	public void update() {
		this.draw();
	}
	
	void draw() {
		float offsetX, offsetY;
		offsetX = this.width / 2;
		offsetY = this.length / 2;
		glPushMatrix();
		glLoadIdentity();
		if(this.focused){
			GL11.glColor3f(this.r2, this.g2, this.b2);
		}
		else {
			GL11.glColor3f(this.r1, this.g1, this.b1);
		}
		glBegin(GL_QUADS);
			glVertex2f(this.x - offsetX, this.y + offsetY);
			glVertex2f(this.x + offsetX, this.y + offsetY);
			glVertex2f(this.x + offsetX, this.y - offsetY);
			glVertex2f(this.x - offsetX, this.y - offsetY);
		glEnd();
		glPopMatrix();
	}
	
	float getX() {
		return this.x;
	}
	float getY() {
		return this.y;
	}
	float width() {
		return this.width;
	}
	float length() {
		return this.length;
	}
	boolean focused() {
		return this.focused;
	}
	void setFocused(boolean defFocused) {
		this.focused = defFocused;
	}
	
}
