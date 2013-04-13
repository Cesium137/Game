package main;

import org.lwjgl.opengl.Display;
import static org.lwjgl.opengl.GL11.*;

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
		}
		
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
