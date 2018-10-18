package mysqlconnect3;

import java.sql.Connection;
import java.util.Scanner;



public class Main {
		 public static void main(String args[])
		 {
			 connect3 cn=new connect3();
			 
			 
			Connection con = cn.createconnect("root","admin");
			
			
			String tip_menu=" 请选择操作";
			String tip_exit="系统退出 ";
			String infos=".........欢迎来到简易银行管理系统..............\n\t"+"1.登录\n\t"+"2.开户\n\t"+"3.退出\n\t";
			String account,password;
		
			System.out.println(infos);
			System.out.println(tip_menu);
			String input=null;
			
			Scanner scan=new Scanner(System.in);
			
			while(true){
				input=scan.nextLine().trim();
				if((input).matches("1|2|3"))
				{
					
					int nextInt=Integer.parseInt(input);//字符转化为整形									
					Scanner scan1=new Scanner(System.in);
					switch(nextInt)
					{
					case 1:
						System.out.println("请输入卡号");
						account=scan1.nextLine().trim();
						System.out.println("请输入密码");
						password=scan1.nextLine().trim();
					     
						

						if(cn.inuse(account,password))
					     {
					    	 System.out.println("请选择功能");

								String tip_menu1=" 请选择操作";
								String tip_exit1="系统退出 ";
								String infos1=".........选择功能..............\n\t"+"1.存款\n\t"+
										"2.取款\n\t"+"3.转账\n\t"+"4.查询余额\n\t"+"5.挂失\n\t"+"6.注销\n\t"+
										"7.退出\n\t";
								System.out.println(infos1);
								System.out.println(tip_menu1);
								
								
								String input1=null;
								Scanner scan2=new Scanner(System.in);
								outer:
								while(true){
									input1=scan2.nextLine().trim();
									if((input1).matches("1|2|3|4|5|6|7"))
									{
										
										int nextInt1=Integer.parseInt(input1);//字符转化为整形									
										//Scanner scan3=new Scanner(System.in);
										switch(nextInt1)
										{
										case 1:
											//cn.addmoney(account,password);
											//System.out.println("1");
											cn.addmoney(account, password);
											break ;
										case 2:
											//System.out.println("2");
											float money;
											 System.out.println("输入取款金额");
											 Scanner in = new Scanner(System.in);			
											 money = in.nextFloat();
											cn.Jianmoney(account, password,money);
											break ;
										case 3:
											//System.out.println("3");
											cn.zhuang(account, password);
											break ;
										case 4:
											//System.out.println("4");
											System.out.println(cn.yumoney(account, password));
											break ;
										case 5:
											//System.out.println("5");
											if(cn.guashi(account, password))
											{
												break outer;
											}
											break ;
										case 6:
											System.out.println("6");
											//cn.zhuxiao(account, password);
											cn.zhuxiao(account, password);
											break outer;
											
										case 7:
											System.out.println("7");
											break outer;
										}
									}
									else
									{
										
										System.out.println("输入有误请重新输入");
									}
									System.out.println(infos1);
									System.out.println(tip_menu1);
								}																																					
								
					     }
						
						
						
						
						
						
					     
						break;
					case 2:
						cn.insert();
						break;
					case 3:
						System.out.println(tip_exit);
						scan1.close();
						System.exit(0);
						break;
							
						
					}
				}
				else
				{
					System.out.println("输入有误请重新输入");
					
				}
					System.out.println(infos);
					System.out.println(tip_menu);
				}
				
		}
			
}	
			/*String id,account,password,name = null;
			float money;
			System.out.println("输入id");
			Scanner in = new Scanner(System.in);			
			id = in.nextLine();
			System.out.println("输入account");
			account=in.nextLine();
			System.out.println("输入name");
			name=in.nextLine();		
			System.out.println("输入password");
			password=in.nextLine();
			System.out.println("输入money");
			money=in.nextInt();		
				
			cn.insert(id,account,name,money,password);*/
			
			
			/*String account,password;
			System.out.println("输入account");
			Scanner in = new Scanner(System.in);			
			account = in.nextLine();
			System.out.println("输入password");						
			password= in.nextLine();			
			cn.search(account,password);*/
			
			/*String account,password;
			System.out.println("输入account");
			Scanner in = new Scanner(System.in);			
			account = in.nextLine();
			System.out.println("输入password");						
			password= in.nextLine();			
			cn.getmoney(account,password );*/
			
			

			/*String account,password;
			float money;
			System.out.println("输入account");
			Scanner in = new Scanner(System.in);			
			account = in.nextLine();
			System.out.println("输入password");						
			password= in.nextLine();	
			System.out.println("输入money");						
			money= in.nextFloat();
			cn.addmoney(account,password,money );*/
			
			
			
			
			/*String account,password;
			float money;
			System.out.println("输入account");
			Scanner in = new Scanner(System.in);			
			account = in.nextLine();
			System.out.println("输入password");						
			password= in.nextLine();	
			System.out.println("输入money");						
			money= in.nextFloat();
			cn.Jianmoney(account,password,money );*/
			
			
			
			/*String account,password;			
			System.out.println("输入account");
			Scanner in = new Scanner(System.in);			
			account = in.nextLine();
			System.out.println("输入password");						
			password= in.nextLine();	
			System.out.println("输入money");									
			cn.guashi(account,password);*/
			
			
			/*String account,password;			
			System.out.println("输入account");
			Scanner in = new Scanner(System.in);			
			account = in.nextLine();
			System.out.println("输入password");						
			password= in.nextLine();											
			cn.changepd(account,password);*/
			
			
			//cn.zhuang("1234567891234567891", "123456");
			//System.out.println(cn.yumoney("1234567891234567892", "123456"));
			//cn.zhuxiao("1234567891234567893", "123456");
			//cn.print("select * from employer");
			/*String name;
			int age;
			int money;
			System.out.println("输入姓名");
			Scanner in = new Scanner(System.in);			
			name = in.nextLine();
			System.out.println("输入年龄");
			age=in.nextInt();
			System.out.println("输入金额");
			money=in.nextInt();*/
			
			//cn.insert2(name,age,money);
			//cn.insert("insert into employer(name,age,salary) values(name,19,5000)");
			//cn.insert("insert into employer(name,age,salary) values('Lina',19,5000)");
			//cn.print("select * from employer");
			//cn.delete("delete from employer where name='Lina'");
			//cn.print("select * from employer");
			//cn.update("update employer set salary=3000 where name='liangying'");
			//cn.print("select * from employer");
		 

