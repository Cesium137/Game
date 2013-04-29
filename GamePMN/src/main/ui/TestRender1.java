package main.ui;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL15.*;

import java.nio.FloatBuffer;

import main.Base;

import org.lwjgl.BufferUtils;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

public class TestRender1 {
	
	//public static int vboVertexHandle, vboColorHandle, amountOfVertices, vertexSize, colorSize;
	public static int vboVertexHandle;
	public static int vboColorHandle;
	public static final int amountOfVertices = 4;
	public static final int vertexSize = 2;
	public static final int colorSize = 3;
	
	public static void main(String[] args) {
		
		
		try {
			Display.setTitle("TestThingy");
			Display.setDisplayMode(new DisplayMode(1280, 720));
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
		glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        GL11.glOrtho(0, 1280, 0, 720, 1, -1);
        glMatrixMode(GL_MODELVIEW);
        glLoadIdentity();
		
		testInit();
		while(!Display.isCloseRequested()) {
			render();
		}
		glDeleteBuffers(vboVertexHandle);
		glDeleteBuffers(vboColorHandle);
	}
	
	public static void testInit() {
		//amountOfVertices = 3;
		//vertexSize = 2;
		//colorSize = 3;

	        FloatBuffer vertexData = BufferUtils.createFloatBuffer(amountOfVertices * vertexSize);
	        vertexData.put(new float[]{0f, 720f, 1280f, 720f, 1280f, 0f, 0f, 0f});//last two points were 0, 0
	        vertexData.flip();

	        FloatBuffer colorData = BufferUtils.createFloatBuffer(amountOfVertices * colorSize);
	        colorData.put(new float[]{1f, 0f, 0f, 0f, 1f, 0f, 0f, 0f, 1f, 1f, 1f, 1f});//last three values were 1, 1, 1
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
	
	public static void render() {
		/*glClear(GL_COLOR_BUFFER_BIT);
		glPushMatrix();
		glLoadIdentity();
		//org.lwjgl.opengl.GL11.glDisable(org.lwjgl.opengl.GL11.GL_BLEND);
        glBindBuffer(GL_ARRAY_BUFFER, vboVertexHandle);
        glVertexPointer(vertexSize, GL_FLOAT, 0, 0L);

        glBindBuffer(GL_ARRAY_BUFFER, vboColorHandle);
        glColorPointer(colorSize, GL_FLOAT, 0, 0L);

        glEnableClientState(GL_VERTEX_ARRAY);
        glEnableClientState(GL_COLOR_ARRAY);
        glDrawArrays(GL_TRIANGLES, 0, amountOfVertices);
        glDisableClientState(GL_COLOR_ARRAY);
        glDisableClientState(GL_VERTEX_ARRAY);
		glPopMatrix();
		Display.update();*/
        //glClear(GL_COLOR_BUFFER_BIT);

        glBindBuffer(GL_ARRAY_BUFFER, vboVertexHandle);
        glVertexPointer(vertexSize, GL_FLOAT, 0, 0L);

        glBindBuffer(GL_ARRAY_BUFFER, vboColorHandle);
        glColorPointer(colorSize, GL_FLOAT, 0, 0L);

        glEnableClientState(GL_VERTEX_ARRAY);
        glEnableClientState(GL_COLOR_ARRAY);
        glDrawArrays(GL_QUADS , 0, amountOfVertices);
        glDisableClientState(GL_COLOR_ARRAY);
        glDisableClientState(GL_VERTEX_ARRAY);

        Display.update();
	}

}
