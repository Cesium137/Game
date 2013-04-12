package main.ent;

import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.input.*;
import org.lwjgl.opengl.Display;

public class Entity {
	
	float x;
	float y;
	float dx = 0;
	float dy = 0;
	float rot;
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
		
	}
	
	void move(float xSpeed, float ySpeed) {
		glPushMatrix();
		glLoadIdentity();
		glTranslatef(this.getX(), this.getY(), 0);
		glRotatef(this.getRot(), 0, 0, 1);
		this.x += (xSpeed * this.speedMultiplier);
		this.y += (ySpeed * this.speedMultiplier);
		glPopMatrix();
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
	public float getX() {
		return this.x;
	}
	public float getY() {
		return this.y;
	}
	public void setX(float defX) {
		this.x = defX;
	}
	public void setY(float defY) {
		this.y = defY;
	}
	float getRot() {
		return this.rot;
	}
	void setRot(float defRot) {
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

}
