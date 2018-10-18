package cn.bjsxt.solar;

import java.awt.Graphics;
import java.awt.Image;

import cn.bjsxt.util.GameUti;

public class Plant extends Star{
	//曲线，中心，椭圆，速度,角度
	double longAxis;
	double shortAxis;
	double speed;
	double degree;
	Star center;
	public Plant( Star center, String imgpath,double longAxis, double shortAxis, double speed ) {//Image img, double x, double y,
		//super(img, x, y);
		this.center=center;
		this.x=center.x+center.width+longAxis;
		this.y=center.y+center.height/2;
		this.img=GameUti.getImage(imgpath);
		this.longAxis = longAxis;
		this.shortAxis = shortAxis;
		this.speed = speed;
		 this.width=img.getWidth(null);
		 this.height=img.getHeight(null);
	}
	
	
	
	
	
	
	public Plant( Plant center, String imgpath,double longAxis, double shortAxis, double speed ) {//Image img, double x, double y,
		//super(img, x, y);
		this.center=center;
		this.x=center.x+center.width+longAxis;
		this.y=center.y+center.height/2;
		this.img=GameUti.getImage(imgpath);
		this.longAxis = longAxis;
		this.shortAxis = shortAxis;
		this.speed = speed;
		 this.width=img.getWidth(null);
		 this.height=img.getHeight(null);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
public void draw(Graphics g)
		 {
	 g.drawImage(img,(int)x,(int)y,null);
	 x=center.x+center.width/2+longAxis*Math.cos(degree);
	 y=center.y+center.height/2+shortAxis*Math.sin(degree);
	 degree+=speed;
		 }


	
public Plant(Image img,double x,double y) {
	 super(img,x,y);
}

public Plant(String imgpath,double x,double y) {
	super(imgpath,x,y);
}
}
