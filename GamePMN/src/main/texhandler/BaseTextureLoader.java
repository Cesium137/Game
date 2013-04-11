package main.texhandler;

import main.Base;

import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

public class BaseTextureLoader {

	public static Texture texture;
	
	public static void load() {
		try {
			texture = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("resource/charbro.png"));
			
		}catch(Exception e) {e.printStackTrace(); System.out.println("Unable to load textures\nExiting..."); Base.exitOnNextCycle = true;}
	}
	
}
