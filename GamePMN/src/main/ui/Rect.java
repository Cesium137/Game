package main.ui;

import main.Base;
import static org.lwjgl.opengl.GL11.*;

import org.newdawn.slick.opengl.Texture;

public class Rect {
	
	float x;
	float y;
	float width;
	float length;
	float rot;
	Texture tx;
	
	public Rect(float defX, float defY, float defWidth, float defLength, float defRot, float r, float g, float b) {
		this.x = defX;
		this.y = defY;
		this.width = defWidth;
		this.length = defWidth;
		this.rot = defRot;
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
		Base.updatePos();
		glBegin(GL_QUADS);
			glVertex2f(this.x - offsetX, this.y + offsetY);
			glVertex2f(this.x + offsetX, this.y + offsetY);
			glVertex2f(this.x + offsetX, this.y - offsetY);
			glVertex2f(this.x - offsetX, this.y - offsetY);
		glEnd();
		//glTranslatef(Base.p.translateX, Base.p.translateY, 0);
		glPopMatrix();
	}

}
