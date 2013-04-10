package main.ent;

import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.opengl.GL11;

public class Char extends Entity {

	public Char() {
		
		this.width = 64;
		this.length = 64;
		
		
	}
	
	void draw() {
		GL11.glColor3f(1.0f, 0.5f, 0.0f);
		glBegin(GL_QUADS);
			glVertex2i(this.x - (this.width / 2), this.y + (this.length / 2));
			glVertex2i(this.x + (this.width / 2), this.y + (this.length / 2));
			glVertex2i(this.x + (this.width / 2), this.y - (this.length / 2));
			glVertex2i(this.x - (this.width / 2), this.y - (this.length / 2));
		glEnd();
	}
	
	public void update() {
		this.draw();
	}

}
