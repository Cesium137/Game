package main.ent;

import static org.lwjgl.opengl.GL11.*;
import main.texhandler.BaseTextureLoader;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

public class Char extends Entity {
	
	public float translateX;
	public float translateY;

	public Char() {
		
		this.width = 32;
		this.length = 32;
		this.x = 0;
		this.y = 0;
		this.translateX = 640;
		this.translateY = 320;
		this.maxHealth = 100;
		
		this.speedMultiplier = 2.2f;
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
		this.setRot(57.2957795f * (float)Math.atan2((double)this.getY() - Mouse.getY(), (double)this.getX() - Mouse.getX()));
		glRotatef(this.getRot(), 0, 0, 1);
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
		this.updateControls();
		//this.move(this.dx,  this.dy);
		this.translateX += this.dx;
		this.translateY += this.dy;
		this.updateTranslate();
		
	}
	void updateControls() {
		if(Keyboard.isKeyDown(Keyboard.KEY_W)) {
			this.dy = this.speedMultiplier;
			//this.dy = 
		}
		else if(Keyboard.isKeyDown(Keyboard.KEY_S)){ 
			this.dy = -this.speedMultiplier;
		}else{this.dy = 0;}
		if(Keyboard.isKeyDown(Keyboard.KEY_A)){ 
			this.dx = -this.speedMultiplier;
		}
		else if(Keyboard.isKeyDown(Keyboard.KEY_D)){ 
			this.dx = this.speedMultiplier;
		}else{this.dx = 0;}
		
	}
	private void updateTranslate() {
		
	}
	

}
