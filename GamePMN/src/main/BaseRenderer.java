package main;

import java.nio.FloatBuffer;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.Display;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL15.GL_ARRAY_BUFFER;
import static org.lwjgl.opengl.GL15.GL_STATIC_DRAW;
import static org.lwjgl.opengl.GL15.glBindBuffer;
import static org.lwjgl.opengl.GL15.glBufferData;
import static org.lwjgl.opengl.GL15.glGenBuffers;

import main.ui.DisplayIndex;
import main.ui.MenuMain;
import main.ui.Rect;

public class BaseRenderer {
	
	public static void render() {
		
		switch(DisplayIndex.index) {
		
		case DisplayIndex.MAIN_MENU:
			renderMainMenu();
			break;
			
		case DisplayIndex.MAIN_GAME:
			renderMainGame();
			break;
			
		case DisplayIndex.TEST:
			renderTest();
			break;
		}
		
	}
	
	private static void renderTest() {
		glDisable(GL_BLEND);
		glDisable(GL_TEXTURE_2D);
		int vboVertexHandle;
		int vboColorHandle;
		final int amountOfVertices = 4;
		final int vertexSize = 2;
		final int colorSize = 3;
        FloatBuffer vertexData = BufferUtils.createFloatBuffer(amountOfVertices * vertexSize);
        vertexData.put(new float[]{0f, 720f, 1280f, 720f, 1280f, 0f, 0f, 0f});
        vertexData.flip();

        FloatBuffer colorData = BufferUtils.createFloatBuffer(amountOfVertices * colorSize);
        colorData.put(new float[]{1f, 0f, 0f, 0f, 1f, 0f, 0f, 0f, 1f, 1f, 1f, 1f});
        colorData.flip();
        
        vboVertexHandle = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, vboVertexHandle);
        glBufferData(GL_ARRAY_BUFFER, vertexData, GL_STATIC_DRAW);
        glBindBuffer(GL_ARRAY_BUFFER, 0);
        
        vboColorHandle = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, vboColorHandle);
        glBufferData(GL_ARRAY_BUFFER, colorData, GL_STATIC_DRAW);
        glBindBuffer(GL_ARRAY_BUFFER, 0);
		main.ui.TestRender1.render();
		Display.setTitle("Test Mode");
	}
	
	private static void renderMainMenu() {
		MenuMain.draw();
	}
	
	private static void renderMainGame() {
		//GL11.glOrtho(0, 1280, 0, 720, 1, -1);
		glEnable(GL_BLEND);
		
		Base.tile.update();
		Rect r1 = new Rect(500f, 195f, 40f, 40f, 0, 0, 0, 0);
		r1.update();
		Rect r2 = new Rect(195f, 500f, 40f, 40f, 0, 0, 0, 0);
		r2.update();
		Rect r3 = new Rect(100f, 100f, 40f, 40f, 0, 0, 0, 0);
		r3.update();
		Rect r4 = new Rect(800f, 300f, 40f, 40f, 0, 0, 0, 0);
		r4.update();
		Rect r5 = new Rect(600f, 85f, 40f, 40f, 0, 0, 0, 0);
		r5.update();
		
		Base.p.update();
		
	}
	

}
