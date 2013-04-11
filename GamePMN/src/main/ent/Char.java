package main.ent;

import static org.lwjgl.opengl.GL11.*;
import org.lwjgl.util.vector.*;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

public class Char extends Entity {

	public Char() {
		
		this.width = 32;
		this.length = 32;
		this.x = 640;
		this.y = 360;
		this.maxHealth = 100;
		
	}
	
	void draw() {
		GL11.glColor3f(1.0f, 0.5f, 0.0f);
		glPushMatrix();
		glLoadIdentity();
		glTranslatef(this.x, this.y, 0);
		this.setRot(57.2957795f * Math.atan2((double)this.getY() - Mouse.getY(), (double)this.getX() - Mouse.getX()));
		Display.setTitle(String.format("%f", this.rot));
		glRotatef((float)this.getRot(), 0, 0, 1);
		glBegin(GL_QUADS);
			float nodeOffsetX = this.width / 2;
			float nodeOffsetY = this.length / 2;
			glVertex2f(-nodeOffsetX, nodeOffsetY);
			glVertex2f(nodeOffsetX, nodeOffsetY);
			glVertex2f(nodeOffsetX, -nodeOffsetY);
			glVertex2f(-nodeOffsetX, -nodeOffsetY);
		glEnd();
		/*glRotatef(0, 0, 0, 1);
		glTranslatef(-this.x, -this.y, 0);
		GL11.glColor3f(1.0f,  0.0f,  0.0f);
		glBegin(GL_LINES);
			glVertex2f(this.getX(), this.getY());
			glVertex2f(Mouse.getX(), Mouse.getY());
			glEnd();*/
		glPopMatrix();
			
	}
	
	public void update() {
		//this.calculateCornerPositions();
		this.draw();
	}
	

}
