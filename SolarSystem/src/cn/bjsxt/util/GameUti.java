package cn.bjsxt.util;

import java.awt.Image;
import java.awt.Toolkit;

public class GameUti {
	private GameUti() {};
public static Image getImage(String path) 
{
	return Toolkit.getDefaultToolkit().getImage(GameUti.class.getClassLoader().getResource(path));
}
}

