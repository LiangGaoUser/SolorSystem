package mysqlconnect3;
import java.sql.*;
import java.util.Random;
import java.util.Scanner;
public class connect3 {

	Connection conn=null;
	String name=null;
	String password=null;
	int salary=0;
	public Connection createconnect(String name,String password) //连接数据库
	{
			System.out.println("start connect database");
		  try {
				Class.forName("com.mysql.jdbc.Driver");
				//conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useSSL=true");
				conn = DriverManager.getConnection(
				          "jdbc:mysql://localhost:3306/test",name,password);
				
				if(!conn.isClosed())
				{
					System.out.println("Successed connecting to the Database!");
	                //存储当前连接的用户的用户名和密码
	                this.name = name;
	                this.password = password;
	                System.out.println("connect succeed");
				}
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return conn;
	}
	public Boolean close()//关闭数据库
	{
		try {
			if(!conn.isClosed())
			{
				conn.close();
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public void insert(String sql) 
	{
		Statement statement;
		try {
			statement=conn.createStatement();			
			statement.executeUpdate(sql);		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	
	
	
	public void insert() 
	{ 
		String id;
		String account;
		String name;
		float money;
		String password;
		System.out.println("输入身份证号:");
		 Scanner in = new Scanner(System.in);			
		 id = in.nextLine();
		 while(searchid(id))
		 {
			 System.out.println("输入身份证号已开户，请重新输入身份证号:");
			 id = in.nextLine();
			 
		 }
		// System.out.println("输入账户:");
		 //account=in.nextLine();
		 System.out.println("输入密码:");
		 password=in.nextLine();
		 System.out.println("输入姓名:");
		 name=in.nextLine();
		 int flag=0;
		 for(int i=0;i<=100;i++)
		 {
			 flag=new Random().nextInt(999999);
			 if(flag<100000)
			 {
				 flag+=100000;
			 }
		 }
		 account="6222202320200"+String.valueOf(flag);
		 while(searchid(account))
		 {
			 for(int i=0;i<=100;i++)
			 {
				 flag=new Random().nextInt(999999);
				 if(flag<100000)
				 {
					 flag+=100000;
				 }
			 }
			 
			
		 }
		 
		 account="6222202320200"+String.valueOf(flag);
		 money=0;
		
		 //System.out.println(account);
		//if(searchaccount(account))
		//{
		//	System.out.println("该卡号已经存在");
			
			
		//}
		//else
		//{
		String duan="insert into employertable(id,account,name,money,password) values(";
		String gk=")";
		String gd=",";
		String gm="'";
		//String name="梁高";
		//int  age=19;
		//int money=250;
		//String age1=String.valueOf(age);
		//String money1=String.valueOf(money);
		//String fina=password+gm+name+gm+gd+age1+gd+money1+gk;
		String fina1=duan+gm+id+gm+gd+gm+account+gm+gd+gm+name+gm+gd+money+gd+gm+password+gm+gk;
		//System.out.println(fina1);
		String ju="insert into employertable(id,account,name,money,password) values('12','23','liangao',233.00,'12345')";
		Statement statement;
		try {
			statement=conn.createStatement();			
			statement.executeUpdate(fina1);	
			System.out.println("开户成功，请记好您的卡号: "+account);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("该账户已存在");
		//e.printStackTrace();
		}
		
		}
		
		
	//}
	
	
	
	
	
	
	
	public void insert2(String name,int age,int money) 
	{
		String password="insert into employer(name,age,salary) values(";
		String gk=")";
		String gd=",";
		String gm="'";
		//String name="梁高";
		//int  age=19;
		//int money=250;
		String age1=String.valueOf(age);
		String money1=String.valueOf(money);
		String fina=password+gm+name+gm+gd+age1+gd+money1+gk;
		//System.out.println(fina);
		String ju="insert into employer(name,age,salary) values('name',19,5000)";
		Statement statement;
		try {
			statement=conn.createStatement();			
			statement.executeUpdate(fina);		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	boolean  search(String account,String password)
	{
		
		//System.out.println("**********************");
		try {
			Statement statement = null;
			statement = conn.createStatement();
			String duan="select password from employertable where account=";
			String gm="'";
			String sql=duan+gm+account+gm;
			//System.out.println(sql);
			ResultSet rs=statement.executeQuery(sql);
			if(rs.next())
			{
				//System.out.println(rs.getString("password"));
				if(rs.getString("password").equalsIgnoreCase(password))
				{
					//System.out.println(rs.getString("password"));					
					return true;
					
				}
				else
				{
					System.out.println("密码错误");
					return false;
					
				}
			}
			else
			{
				System.out.println("账号不存在");
				rs.close();
				return false;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
		//	return false;
			e.printStackTrace();
		}
		//System.out.println("not fined");
		return false;
		
		
	}
	
	public float getmoney(String name,String password)
	{
		
		if(search(name,password))
		{
			try {
				Statement statement = null;
				statement = conn.createStatement();
				//String duan="select money from employertable where name='lianggao',password='123456'";
				String duan="select money from employertable where account=";
				String gm="'";
				String gd=",";
				String sql=duan+gm+name+gm+"and password="+gm+password+gm;
				//System.out.println("**********************");
				//System.out.println(sql);
				ResultSet rs=statement.executeQuery(sql);
				while(rs.next())
				{
					//System.out.println(rs.getString("money"));
					return rs.getFloat("money");
					
				}
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				
				e.printStackTrace();
			}
			
			
		}
		return 0;
		
		
		
		
	}
	
	public void addmoney(String account,String password)
	{
		 float money;
		 System.out.println("输入存款金额");
		 Scanner in = new Scanner(System.in);			
		 money = in.nextFloat();
		 float money1=money;
		if(search(account,password))
		{
			String sql;
			String duan="update employertable set money=";			
			String dm="'";
			String dd=",";
			money=getmoney(account,password)+money;
			sql=duan+money+" "+"where account="+dm+account+dm+"and password="+dm+password+dm;
			//System.out.println("**********************");
			//System.out.println(sql);
			Statement statement;		
			try {
				statement=conn.createStatement();
				statement.executeUpdate(sql);
				System.out.println("存款成功: +"+money1);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		}
	}
	
	
	
	public boolean Jianmoney(String account,String password,float money)
	{
		 
		if(search(account,password))
		{
			String sql;
			String duan="update employertable set money=";			
			String dm="'";
			String dd=",";
			if(getmoney(account,password)-money>=0)				
			{  
				float money1=money;
				money=getmoney(account,password)-money;						
				sql=duan+money+" "+"where account="+dm+account+dm+"and password="+dm+password+dm;
				//System.out.println("**********************");
				//System.out.println(sql);
				Statement statement;		
				try {
					statement=conn.createStatement();
					statement.executeUpdate(sql);
					System.out.println("取款成功: -"+money1);
					return true;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}
			else
			{
				System.out.println("余额不足");
				return false;
				}
			}
		return false;
	}
	
	public boolean guashi(String account ,String password)
	{
		if(search(account,password))
		{
			String sql;
			String duan="update employertable set loss='yels' where account=";			
			String dm="'";
			String dd=",";
			//update employertable set loss='yels' where account='1234567891234567892' and password='123456' ;						
			sql=duan+dm+account+dm+"and password="+dm+password+dm;
			//System.out.println("**********************");
			//System.out.println(sql);
			Statement statement;		
			try {
					statement=conn.createStatement();
					statement.executeUpdate(sql);
					System.out.println("卡号为  "+account+" 的卡挂失成功");
					return true;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();	
					
			}
		}	
		return false;
	}			
	public void  changepd(String account ,String password)
	{
		
		if(search(account ,password))
		{
			//update employertable set password='12345' where account='1234567891234567891' and password='123456';
			    String newpassword;
			    System.out.println("输入新的密码");
			    Scanner in = new Scanner(System.in);			
				newpassword = in.nextLine();
				String sql;
				String duan="update employertable set password=";			
				String dm="'";
				String dd=",";										
				sql=duan+dm+newpassword+dm+"where account="+dm+account+dm+"and password="+dm+password+dm;
				//System.out.println("**********************");
				//System.out.println(sql);
				Statement statement;		
				try {
						statement=conn.createStatement();
						statement.executeUpdate(sql);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();										
			}															
		}				
	}	
	
	public boolean searchaccount(String account)
	{
		
		//System.out.println("**********************");
		try {
			Statement statement = null;
			statement = conn.createStatement();
			String duan="select account from employertable where account=";
			String gm="'";
			String sql=duan+gm+account+gm;
			//System.out.println(sql);
			ResultSet rs=statement.executeQuery(sql);
			while(rs.next())
			{
				
					//System.out.println(rs.getString("account"));					
					return true;
					
				
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return false;
			//e.printStackTrace();
		}
		System.out.println("not fined account");
		return false;
		
	}
	
	
	
	
	
	public boolean searchid(String id)
	{
		
		//System.out.println("**********************");
		try {
			Statement statement = null;
			statement = conn.createStatement();
			String duan="select id from employertable where id=";
			String gm="'";
			String sql=duan+gm+id+gm;
			//System.out.println(sql);
			ResultSet rs=statement.executeQuery(sql);
			while(rs.next())
			{
				
					//System.out.println(rs.getString("id"));					
					return true;
					
				
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return false;
			//e.printStackTrace();
		}
		//System.out.println("not fined id");
		return false;
		
	}
	
	
	
	
	
	
	
	
	
	public float getzhuangmoney(String account)
	{
	   //不用加searchaccount();
		
		try {
			float money = 0;
			Statement statement = null;
			statement = conn.createStatement();
			//String duan="select money from employertable where name='lianggao',password='123456'";
			String duan="select money from employertable where account=";
			String gm="'";
			String gd=",";
			String sql=duan+gm+account+gm;
			//System.out.println("**********************");
			//System.out.println(sql);
			ResultSet rs=statement.executeQuery(sql);
			while(rs.next())
			{
				
				money=rs.getFloat("money");				
			}
			rs.close();
			return money;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
			return 0;
		}			
		 
	}
	
	
	
	
	public void addzhuang(String account,float money)
	{
		  //不用加searchaccount();
		String sql;
		String duan="update employertable set money=";			
		String dm="'";
		String dd=",";
		//System.out.println("888888"+getzhuangmoney(account));
		money=getzhuangmoney(account)+money;
		sql=duan+money+" "+"where account="+dm+account+dm;
		//System.out.println("**********************");
		//System.out.println(sql);
		Statement statement;		
		try {
			statement=conn.createStatement();
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
		
		
	



	public void zhuang(String account,String password)
	{
		if(search(account,password))
		{
			System.out.println("输入转账的卡号");
			String acc;
		    Scanner in = new Scanner(System.in);	
			acc=in.nextLine();
			if(searchaccount(acc))
			{
				System.out.println("输入转账的金额");
				float money;
				money=in.nextFloat();
				if(Jianmoney(account,password,money))
				{
				  addzhuang(acc,money);
				  System.out.println("转账成功: -"+money+"   to   "+acc);
				  
				}
			}
			else
			{
				System.out.println("转账卡号不存在");
			}
						
				
		}
		
		
		
		
	}
	
	
	
	public float yumoney(String account ,String password)
	{
		
		if(search(account,password))
		{
			//select money from employertable where account ='1241'and password='123'
			try {
				float money = 0;
				Statement statement = null;
				statement = conn.createStatement();
				//String duan="select money from employertable where name='lianggao',password='123456'";
				String duan="select money from employertable where account=";
				String gm="'";
				String gd=",";
				String sql=duan+gm+account+gm+"and password="+gm+password+gm;
				//System.out.println("**********************");
				//System.out.println(sql);
				ResultSet rs=statement.executeQuery(sql);
				while(rs.next())
				{
					
					money=rs.getFloat("money");				
				}
				rs.close();
				return money;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				
				e.printStackTrace();
				return 0;
			}			
			
		}
		return 0;
		
		
	}
	
	
	
	public void zhuxiao(String account,String password)
	{
		if(search(account,password))
		{				
				String duan="delete from employertable where account=";	
				String gm="'";
				String sql=duan+gm+account+gm;
				//System.out.println("**********************");
				//System.out.println(sql);
				Statement statement;		
				try {
						statement=conn.createStatement();
						statement.executeUpdate(sql);
						System.out.println(account+"注销成功");
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();					
				}
		}
		
		//delete from employertable where account='122';
		
		
		
	}
	
	public boolean inuse(String account,String password)
	{
		if(search(account,password))
		{				
			//select loss from employertable where account='122'and password='112';
				String duan="select loss from employertable where account=";	
				String gm="'";
				String sql=duan+gm+account+gm+"and password="+gm+password+gm;
				//System.out.println("**********************");
				//System.out.println(sql);
				try
				{
					Statement statement = null;
					statement = conn.createStatement();
				    ResultSet rs=statement.executeQuery(sql);
					while(rs.next())
					{
						
						if(rs.getString("loss").equals("nols")) 
						{
							return true;
						}
						else
						{
							System.out.println("该卡已挂失");
							return false;
						}
					}
					rs.close();
					
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				
				e.printStackTrace();
				
			}			
		}
		
		return false;
	}
	
	public void delete(String sql)
	{
			Statement statement;		
			try {
				statement=conn.createStatement();
				statement.executeUpdate(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
			
		
	}
	public void update(String sql)
	{
			Statement statement;		
			try {
				statement=conn.createStatement();
				statement.executeUpdate(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
	}
	public void print(String sql)
	{
		System.out.println("**********************");
		try {
			Statement statement = null;
			statement = conn.createStatement();
			ResultSet rs=statement.executeQuery(sql);
			while(rs.next())
			{
				System.out.println(rs.getString("name")+ "\t" + rs.getInt("age") + "\t" + rs.getInt("salary"));
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
