package main.ent;

import static org.lwjgl.opengl.GL11.*;
import main.texhandler.BaseTextureLoader;

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
		glPushMatrix();
		glLoadIdentity();
		GL11.glColor3f(1.0f,  0.0f,  0.0f);
		glBegin(GL_LINES);
			glVertex2f(Mouse.getX(), Mouse.getY());
			glVertex2f(this.getX(), this.getY());
		glEnd();
		glPopMatrix();
		
		GL11.glColor3f(1.0f, 1.0f, 1.0f);
		glPushMatrix();
		glLoadIdentity();
		glTranslatef(this.x, this.y, 0);
		this.setRot(57.2957795f * Math.atan2((double)this.getY() - Mouse.getY(), (double)this.getX() - Mouse.getX()));
		Display.setTitle(String.format("%f", this.rot));
		glRotatef((float)this.getRot(), 0, 0, 1);
		BaseTextureLoader.load();
		BaseTextureLoader.texture.bind();
		glBegin(GL_QUADS);
			float nodeOffsetX = this.width / 2;
			float nodeOffsetY = this.length / 2;
			glTexCoord2f(0, 0);
			glVertex2f(-nodeOffsetX, nodeOffsetY);
			glTexCoord2f(1, 0);
			glVertex2f(nodeOffsetX, nodeOffsetY);
			glTexCoord2f(1, 1);
			glVertex2f(nodeOffsetX, -nodeOffsetY);
			glTexCoord2f(0, 1);
			glVertex2f(-nodeOffsetX, -nodeOffsetY);
		glEnd();
		BaseTextureLoader.texture.release();
		glPopMatrix();
	}
	
	public void update() {
		this.draw();
	}
	

}
