package mysqlconnect3;

import java.sql.Connection;
import java.util.Scanner;



public class Main {
		 public static void main(String args[])
		 {
			 connect3 cn=new connect3();
			 
			 
			Connection con = cn.createconnect("root","admin");
			
			
			String tip_menu=" ��ѡ�����";
			String tip_exit="ϵͳ�˳� ";
			String infos=".........��ӭ�����������й���ϵͳ..............\n\t"+"1.��¼\n\t"+"2.����\n\t"+"3.�˳�\n\t";
			String account,password;
		
			System.out.println(infos);
			System.out.println(tip_menu);
			String input=null;
			
			Scanner scan=new Scanner(System.in);
			
			while(true){
				input=scan.nextLine().trim();
				if((input).matches("1|2|3"))
				{
					
					int nextInt=Integer.parseInt(input);//�ַ�ת��Ϊ����									
					Scanner scan1=new Scanner(System.in);
					switch(nextInt)
					{
					case 1:
						System.out.println("�����뿨��");
						account=scan1.nextLine().trim();
						System.out.println("����������");
						password=scan1.nextLine().trim();
					     
						

						if(cn.inuse(account,password))
					     {
					    	 System.out.println("��ѡ����");

								String tip_menu1=" ��ѡ�����";
								String tip_exit1="ϵͳ�˳� ";
								String infos1=".........ѡ����..............\n\t"+"1.���\n\t"+
										"2.ȡ��\n\t"+"3.ת��\n\t"+"4.��ѯ���\n\t"+"5.��ʧ\n\t"+"6.ע��\n\t"+
										"7.�˳�\n\t";
								System.out.println(infos1);
								System.out.println(tip_menu1);
								
								
								String input1=null;
								Scanner scan2=new Scanner(System.in);
								outer:
								while(true){
									input1=scan2.nextLine().trim();
									if((input1).matches("1|2|3|4|5|6|7"))
									{
										
										int nextInt1=Integer.parseInt(input1);//�ַ�ת��Ϊ����									
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
											 System.out.println("����ȡ����");
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
										
										System.out.println("������������������");
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
					System.out.println("������������������");
					
				}
					System.out.println(infos);
					System.out.println(tip_menu);
				}
				
		}
			
}	
			/*String id,account,password,name = null;
			float money;
			System.out.println("����id");
			Scanner in = new Scanner(System.in);			
			id = in.nextLine();
			System.out.println("����account");
			account=in.nextLine();
			System.out.println("����name");
			name=in.nextLine();		
			System.out.println("����password");
			password=in.nextLine();
			System.out.println("����money");
			money=in.nextInt();		
				
			cn.insert(id,account,name,money,password);*/
			
			
			/*String account,password;
			System.out.println("����account");
			Scanner in = new Scanner(System.in);			
			account = in.nextLine();
			System.out.println("����password");						
			password= in.nextLine();			
			cn.search(account,password);*/
			
			/*String account,password;
			System.out.println("����account");
			Scanner in = new Scanner(System.in);			
			account = in.nextLine();
			System.out.println("����password");						
			password= in.nextLine();			
			cn.getmoney(account,password );*/
			
			

			/*String account,password;
			float money;
			System.out.println("����account");
			Scanner in = new Scanner(System.in);			
			account = in.nextLine();
			System.out.println("����password");						
			password= in.nextLine();	
			System.out.println("����money");						
			money= in.nextFloat();
			cn.addmoney(account,password,money );*/
			
			
			
			
			/*String account,password;
			float money;
			System.out.println("����account");
			Scanner in = new Scanner(System.in);			
			account = in.nextLine();
			System.out.println("����password");						
			password= in.nextLine();	
			System.out.println("����money");						
			money= in.nextFloat();
			cn.Jianmoney(account,password,money );*/
			
			
			
			/*String account,password;			
			System.out.println("����account");
			Scanner in = new Scanner(System.in);			
			account = in.nextLine();
			System.out.println("����password");						
			password= in.nextLine();	
			System.out.println("����money");									
			cn.guashi(account,password);*/
			
			
			/*String account,password;			
			System.out.println("����account");
			Scanner in = new Scanner(System.in);			
			account = in.nextLine();
			System.out.println("����password");						
			password= in.nextLine();											
			cn.changepd(account,password);*/
			
			
			//cn.zhuang("1234567891234567891", "123456");
			//System.out.println(cn.yumoney("1234567891234567892", "123456"));
			//cn.zhuxiao("1234567891234567893", "123456");
			//cn.print("select * from employer");
			/*String name;
			int age;
			int money;
			System.out.println("��������");
			Scanner in = new Scanner(System.in);			
			name = in.nextLine();
			System.out.println("��������");
			age=in.nextInt();
			System.out.println("������");
			money=in.nextInt();*/
			
			//cn.insert2(name,age,money);
			//cn.insert("insert into employer(name,age,salary) values(name,19,5000)");
			//cn.insert("insert into employer(name,age,salary) values('Lina',19,5000)");
			//cn.print("select * from employer");
			//cn.delete("delete from employer where name='Lina'");
			//cn.print("select * from employer");
			//cn.update("update employer set salary=3000 where name='liangying'");
			//cn.print("select * from employer");
		 

