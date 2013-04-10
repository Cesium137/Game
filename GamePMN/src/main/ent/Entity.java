package main.ent;

import static org.lwjgl.opengl.GL11.*;
import org.lwjgl.input.*;
import org.lwjgl.opengl.Display;

public class Entity {
	
	int x;
	int y;
	int dx = 0;
	int dy = 0;
	long rot;
	long f;
	int maxHealth;
	int health;
	
	int length;// along y axis
	int width;// along x axis
	int topLeftCornerx;
	int topLeftCornery;
	int topRightCornerx;
	int topRightCornery;
	int bottomRightCornerx;
	int bottomRightCornery;
	int bottomLeftCornerx;
	int bottomLeftCornery;
	
	public Entity() {
		
		
		
	}
	
	void draw() {
		glBegin(GL_QUADS);
		glVertex3f(100f, 100f, 0.5f);//top left
		glVertex3f(150f, 100f, 0.5f);//top right
		glVertex3f(150f, 150f, 0.5f);//bottom right
		glVertex3f(100f, 150f, 0.5f);//bottom left
		glEnd();
		
	}
	public void update() {
		this.draw();
		
		//Some update code
	}
	
	int getMaxHealth() {
		return this.health;
	}
	int getHealth() {
		return this.health;
	}
	long getF() {
		return this.f;
	}
	int getX() {
		return this.x;
	}
	int getY() {
		return this.y;
	}
	public void setX(int defX) {
		this.x = defX;
	}
	public void setY(int defY) {
		this.y = defY;
	}
	void setF(long defF) {
		this.f = defF;
	}
	void hurt(int damage) {
		this.health -= damage;
	}
	void kill() {
		this.health = 0;
	}
	void setHealth(int defHealth) {
		this.health = defHealth;
	}
	void calculateCornerPositions() {
		//this.topLeftCorner = 0;
		int opp = (int)Math.sqrt((int)Math.pow(2, Mouse.getX() - this.getX()) + (int)Math.pow(2,  Mouse.getY() - this.getY()));
		int adj = this.width / 2;
		int hyp = (int)Math.tan(opp/adj);
		Display.setTitle(opp + " " + adj + " " + hyp);
	}

}
