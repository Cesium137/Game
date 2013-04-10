package main.ent;

import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.opengl.GL11;

public class Char extends Entity {

	public Char() {
		
		this.width = 32;
		this.length = 32;
		this.x = 640;
		this.y = 360;
		
	}
	
	void draw() {
		GL11.glColor3f(1.0f, 0.5f, 0.0f);
		/*glBegin(GL_QUADS);
			glVertex2i(this.x - (this.width / 2), this.y + (this.length / 2));
			glVertex2i(this.x + (this.width / 2), this.y + (this.length / 2));
			glVertex2i(this.x + (this.width / 2), this.y - (this.length / 2));
			glVertex2i(this.x - (this.width / 2), this.y - (this.length / 2));
		glEnd();*/
		glBegin(GL_QUADS);
			glVertex2i(this.topLeftCornerx, this.topLeftCornery);
			glVertex2i(this.topRightCornerx, this.topRightCornery);
			glVertex2i(this.bottomRightCornerx, this.bottomRightCornery);
			glVertex2i(this.bottomLeftCornerx, this.bottomLeftCornery);
		glEnd();
			
	}
	
	public void update() {
		this.calculateCornerPositions();
		this.draw();
	}
	

}
