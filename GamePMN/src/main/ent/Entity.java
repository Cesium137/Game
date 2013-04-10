package main.ent;

import static org.lwjgl.opengl.GL11.*;

public class Entity {
	
	int x;
	int y;
	//double z;
	int dx = 0;
	int dy = 0;
	//float dz = 0;
	long rot;
	long f;
	int maxHealth;
	int health;
	int length;// along y axis
	int width;// along x axis
	
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

}
