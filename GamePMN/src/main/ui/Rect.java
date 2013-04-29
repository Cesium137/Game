package main.ui;

import java.nio.FloatBuffer;

import main.Base;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL15.GL_ARRAY_BUFFER;
import static org.lwjgl.opengl.GL15.GL_STATIC_DRAW;
import static org.lwjgl.opengl.GL15.glBindBuffer;
import static org.lwjgl.opengl.GL15.glBufferData;
import static org.lwjgl.opengl.GL15.glGenBuffers;

import org.lwjgl.BufferUtils;
import org.newdawn.slick.opengl.Texture;

public class Rect {
	
	float x;
	float y;
	float width;
	float length;
	float rot;
	Texture tx;
    final int amountOfVertices = 4;
    final int vertexSize = 2;
    final int colorSize = 3;
    int vboVertexHandle;
    int vboColorHandle;
    
	public Rect(float defX, float defY, float defWidth, float defLength, float defRot, float r, float g, float b) {
		this.x = defX;
		this.y = defY;
		this.width = defWidth;
		this.length = defWidth;
		this.rot = defRot;
		
		 glMatrixMode(GL_PROJECTION);
	        glLoadIdentity();
	        glMatrixMode(GL_MODELVIEW);
	        glLoadIdentity();

	        FloatBuffer vertexData = BufferUtils.createFloatBuffer(amountOfVertices * vertexSize);
	        vertexData.put(new float[]{this.x - (this.width / 2), this.y + (this.length / 2), this.x + (this.width / 2), this.y + (this.length / 2), this.x + (this.width / 2), this.y - (this.length / 2), this.x - (this.width / 2), this.y - (this.length / 2)});
	        vertexData.flip();

	        FloatBuffer colorData = BufferUtils.createFloatBuffer(amountOfVertices * colorSize);
	        colorData.put(new float[]{1, 0, 0, 0, 1, 0, 0, 0, 1, 1, 1, 1});
	        colorData.flip();
	        
	        vboVertexHandle = glGenBuffers();
	        glBindBuffer(GL_ARRAY_BUFFER, vboVertexHandle);
	        glBufferData(GL_ARRAY_BUFFER, vertexData, GL_STATIC_DRAW);
	        glBindBuffer(GL_ARRAY_BUFFER, 0);

	        vboColorHandle = glGenBuffers();
	        glBindBuffer(GL_ARRAY_BUFFER, vboColorHandle);
	        glBufferData(GL_ARRAY_BUFFER, colorData, GL_STATIC_DRAW);
	        glBindBuffer(GL_ARRAY_BUFFER, 0);
	        
	}
	
	public void update() {
		this.draw();
	}
	
	void draw() {
		//glDisable(GL_BLEND);
		//glDisable(GL_TEXTURE_2D);
		float offsetX, offsetY;
		offsetX = this.width / 2;
		offsetY = this.length / 2;
		glPushMatrix();
		glLoadIdentity();
		Base.updatePos();
		/*glBegin(GL_QUADS);
			glVertex2f(this.x - offsetX, this.y + offsetY);
			glVertex2f(this.x + offsetX, this.y + offsetY);
			glVertex2f(this.x + offsetX, this.y - offsetY);
			glVertex2f(this.x - offsetX, this.y - offsetY);
		glEnd();*/
		//glTranslatef(Base.p.translateX, Base.p.translateY, 0);
        glBindBuffer(GL_ARRAY_BUFFER, vboVertexHandle);
        glVertexPointer(vertexSize, GL_FLOAT, 0, 0L);

        glBindBuffer(GL_ARRAY_BUFFER, vboColorHandle);
        glColorPointer(colorSize, GL_FLOAT, 0, 0L);

        glEnableClientState(GL_VERTEX_ARRAY);
        glEnableClientState(GL_COLOR_ARRAY);
        glDrawArrays(GL_QUADS, 0, amountOfVertices);
        glDisableClientState(GL_COLOR_ARRAY);
        glDisableClientState(GL_VERTEX_ARRAY);
		glPopMatrix();
	}

}
