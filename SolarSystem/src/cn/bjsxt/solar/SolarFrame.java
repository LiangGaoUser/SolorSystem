package cn.bjsxt.solar;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import cn.bjsxt.util.Constant;
import cn.bjsxt.util.GameUti;
import cn.bjsxt.util.MyFrame;

public class SolarFrame {
/**
 * Ì«ÑôÏµÖ÷´°¿Ú
 */
	
	public static class SloarFrame extends MyFrame{
		Image bg=GameUti.getImage("images/bg.jpg");
		 Star sun=new Star("images/sun.jpg",Constant.GAME_WIDTH/2,Constant.GAME_HEIGHT/2);
		 
		 Plant earth=new Plant(sun,"images/earth.jpg",150,100,0.01);
		 Plant moon=new Plant(earth,"images/moon.jpg",15,10,0.1);//
		 Plant huoxing=new Plant(sun,"images/huoxing.png",100,70,0.03);//
		public void paint(Graphics g) {
			g.drawImage(bg, 0, 0, null);
			sun.draw(g);
			g.setColor(Color.RED );
			g.drawOval((int)(sun.x+sun.width/2-150), (int)(sun.y+sun.height/2-100), 300, 200);
			earth.draw(g);
			moon.draw(g);
			huoxing.draw(g);
		}
		
		public static void main(String[] args)
		
		{
			SloarFrame sf1=new SloarFrame();
			//new SolarFrame().launchFrame();
			sf1.launchFrame();
		}
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
}
