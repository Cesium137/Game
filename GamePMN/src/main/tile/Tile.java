package main.tile;

import static org.lwjgl.opengl.GL11.*;
import main.Base;

public class Tile {

	float x;
	float y;
	float width;
	float length;
	
	public Tile(float defX, float defY) {
		this.x = defX;
		this.y = defY;
	}
	
	public void update() {
		this.draw();
	}
	
	void draw() {
		glPushMatrix();
		glLoadIdentity();
		//glTranslatef(-Base.p.getX(), -Base.p.getY(), 0);
		glBegin(GL_QUADS);
		glVertex3f(800f, 810f, 0.0f);//top left
		glVertex3f(810f, 810f, 0.0f);//top right
		glVertex3f(810f, 800f, 0.0f);//bottom right
		glVertex3f(800f, 800f, 0.0f);//bottom left
		glEnd();
		glPopMatrix();
	}
	
}
