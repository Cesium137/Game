package main.ent;

import static org.lwjgl.opengl.GL11.*;
import org.lwjgl.input.*;
import org.lwjgl.opengl.Display;

public class Entity {
	
	float x;
	float y;
	float dx = 0;
	float dy = 0;
	double rot;
	long f;
	int maxHealth;
	int health;
	
	int length;// along y axis
	int width;// along x axis
	
	float speedMultiplier;
	
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
	
	void move(float xSpeed, float ySpeed) {
		this.x += (xSpeed * this.speedMultiplier);
		this.y += (ySpeed * this.speedMultiplier);
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
	float getX() {
		return this.x;
	}
	float getY() {
		return this.y;
	}
	public void setX(float defX) {
		this.x = defX;
	}
	public void setY(float defY) {
		this.y = defY;
	}
	double getRot() {
		return this.rot;
	}
	void setRot(double defRot) {
		this.rot = defRot;
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
