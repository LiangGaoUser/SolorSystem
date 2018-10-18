package cn.bjsxt.solar;

import java.awt.Graphics;
import java.awt.Image;

import cn.bjsxt.util.GameUti;

public class Star {
 Image img;
 double x,y;
 double width,height;
 public void draw(Graphics g)
 {
	 g.drawImage(img,(int)x,(int)y,null);
	
 }
 
 
 //
 public Star()
 {
	 
 }
 
 //
 
 
 
 
 
 
 public Star(Image img,double x,double y) {
	 this.img=img;
	 this.x=x;
	 this.y=y;
	 this.width=img.getWidth(null);
	 this.height=img.getHeight(null);
 }
 public Star(String imgpath,double x,double y) {
	 this.img=GameUti.getImage(imgpath);
	 this.x=x;
	 this.y=y;
	 this.width=img.getWidth(null);
	 this.height=img.getHeight(null);
 }
}
