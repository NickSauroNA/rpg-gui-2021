import java.util.ArrayList;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*; 
public class mainRPG
	{	
		static int number = (int)(Math.random()*4);
		static JFrame frame = new JFrame();
		static int menuoption;
		 static ImageIcon icon;
		 static String monster;
		 static Boolean block = false;
		 static Boolean alive;
		public static void secstop()
	
			{
				try
					{
						Thread.sleep(1000);
					} catch (InterruptedException e)
					{
						e.printStackTrace();
					}
		}
		public static void halfsecstop() 
			{
				try
					{
						Thread.sleep(500);
					} catch (InterruptedException e)
					{
						e.printStackTrace();
					}
		}

		public static void main(String[] args)
			{
				EnemyList.fillArray();
				PlayerAL.playerAF();
				alive = true;
				welcomePlayer();
				secstop();
				while(alive)
					{
				battle();
					}
				System.out.println("this shit was steezy. november 2021");
			}
		//you are slaughtered
		public static void welcomePlayer()
		{
			
			JOptionPane.showMessageDialog(
					frame, 
					"Hello and welcome to the Java RPG. You will be fighting a random monster now.");
			
			
		}
		
		
		public static void youWin()
		{
			JOptionPane.showMessageDialog(
					frame,
					"You win!"
					);
			alive = false;
		}
		public static void youLose()
		{
			JOptionPane.showMessageDialog(
					frame,
					"You lose!"
					);
			alive = false;
		}
	
		public static void menu()
		{
			if(number == 0)
				{
					 icon = new ImageIcon(("rat.jpg"));
					 monster = "rat";
				} else if (number ==1)
					{
						icon = new ImageIcon(("slime.jpg"));
						monster = "slime";
					} else if (number == 2)
						{
							icon = new ImageIcon(("thazombie.jpg"));
							monster = "zombie";
						} else if (number == 3)
							{
								icon = new ImageIcon(("dragon.jpg"));
								monster = "dragon";
							}
			
			
			
			Object[] options = {"Attack", "Block", "Check", "Item"};
			menuoption = JOptionPane.showOptionDialog(
					frame, 
					"Select an action, you are fighting the " + monster + ".",
					"Attack Menu",
					JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE,
					icon, 
					options, 
					options[0]);
			block = false;
		}
		public static void evalAtk()
		{
			if(block == false)
				{
				PlayerAL.playerset.get(0).setHealth(PlayerAL.playerset.get(0).getHealth() - EnemyList.enemies.get(number).getDamage());
				JOptionPane.showMessageDialog(
						frame, 
						EnemyList.enemies.get(number).getName()+ " uses " + EnemyList.enemies.get(number).getAttack() 
						+ "! Your health is reduced to " + PlayerAL.playerset.get(0).getHealth() + "."
						);
				if(PlayerAL.playerset.get(0).getHealth() > 0 && EnemyList.enemies.get(number).getHealth() > 0)
					{
						enemyTurn();
					} else if(PlayerAL.playerset.get(0).getHealth() < 0) {
						youLose();
					} else if(EnemyList.enemies.get(number).getHealth() < 0)
						{
							youWin();
						}
				} else if(block == true)
					{
			
						System.out.println("...");
					PlayerAL.playerset.get(0).setHealth(PlayerAL.playerset.get(0).getHealth() - EnemyList.enemies.get(number).getDamage() + PlayerAL.playerset.get(0).getDefend());
					JOptionPane.showMessageDialog(
							frame, 
							"You defend against a hit from the " + EnemyList.enemies.get(number).getName() + ", who uses " + EnemyList.enemies.get(number).getAttack() 
							+ "! Your health is only reduced to " + PlayerAL.playerset.get(0).getHealth() + "."
							);
					if(PlayerAL.playerset.get(0).getHealth() > 0 && EnemyList.enemies.get(number).getHealth() > 0)
						{
							menu();
						} else if(PlayerAL.playerset.get(0).getHealth() < 0) {
							youLose();
						} else if(EnemyList.enemies.get(number).getHealth() < 0)
							{
								youWin();
							}
					}
		}
		public static void enemyTurn()
		{
			int enemyChoice = (int)(Math.random()*3);
			if (enemyChoice == 1|| enemyChoice ==2||enemyChoice ==3)
				{
					evalAtk();
		} else if(enemyChoice == 4)
			{
				JOptionPane.showMessageDialog(
						frame,
						EnemyList.enemies.get(number).getName()+ " does a multi-attack!"
						);
				for(int i =0; i<2; i ++ )
					{
						if(block == false){
							PlayerAL.playerset.get(0).setHealth(PlayerAL.playerset.get(0).getHealth() - EnemyList.enemies.get(number).getDamage());
							JOptionPane.showMessageDialog(
									frame, 
									EnemyList.enemies.get(number).getName()+ " uses " + EnemyList.enemies.get(number).getAttack() 
									+ "! Your health is reduced to " + PlayerAL.playerset.get(0).getHealth() + "."
									);
							if(PlayerAL.playerset.get(0).getHealth() > 0 && EnemyList.enemies.get(number).getHealth() > 0)
								{
									menu();
								} else if(PlayerAL.playerset.get(0).getHealth() < 0) {
									youLose();
								} else if(EnemyList.enemies.get(number).getHealth() < 0)
									{
										youWin();
									}
							
						} else if(block == true)
							{
								PlayerAL.playerset.get(0).setHealth(PlayerAL.playerset.get(0).getHealth() - EnemyList.enemies.get(number).getDamage() + PlayerAL.playerset.get(0).getDefend());
								JOptionPane.showMessageDialog(
										frame, 
										"You defend against a hit from the " + EnemyList.enemies.get(number).getName() + ", who uses " + EnemyList.enemies.get(number).getAttack() 
										+ "! Your health is only reduced to " + PlayerAL.playerset.get(0).getHealth() + "."
										);
								if(PlayerAL.playerset.get(0).getHealth() > 0 && EnemyList.enemies.get(number).getHealth() > 0)
									{
										menu();
									} else if(PlayerAL.playerset.get(0).getHealth() < 0) {
										youLose();
									} else if(EnemyList.enemies.get(number).getHealth() < 0)
										{
											youWin();
										}
							}
					}
			}
		}
		public static void battle()
		{
			
			menu();
			
			if(menuoption == 0)
				{
					block = false;
					int hitprob = (int)(Math.random()*100) + 1;
					if(hitprob < PlayerAL.playerset.get(0).getHitprob())
						{
							
							EnemyList.enemies.get(number).setHealth(EnemyList.enemies.get(number).getHealth() - PlayerAL.playerset.get(0).getAttack());
							JOptionPane.showMessageDialog(
									frame, 
									"You attack the " + EnemyList.enemies.get(number).getName() + ", their health is now " + EnemyList.enemies.get(number).getHealth() + "."
									);
							enemyTurn();
							
						}else
							{
								JOptionPane.showMessageDialog(
										frame, 
										"You missed!"
										);
								enemyTurn();
								
							}
					
					
				} else if(menuoption == 1) 
					{
						block = true;
						JOptionPane.showMessageDialog(
								frame, 
								"You brace for impact!"
								);
						enemyTurn();
						
				} else if(menuoption == 2)
					{
						JOptionPane.showMessageDialog(
								frame, 
								EnemyList.enemies.get(number).getName() + ", " + "ATK " + EnemyList.enemies.get(number).getDamage()
								
								);
						enemyTurn();
						
					} else if(menuoption == 3)
						{
							final String[] itemc = { "Burger", "Energy Drink (ATK BOOST)", "Week Old Chocolate Chip Cookie" };
							final JFrame frame = new JFrame();
						    String chooseItem = (String) JOptionPane.showInputDialog(frame, 
						            "Choose an item in your backpack.",
						            "Choose and item.",
						            JOptionPane.QUESTION_MESSAGE, 
						            null, 
						            itemc, 
						            itemc[0]);
						    if(chooseItem.equals("Burger"))
						    	{
						    		PlayerAL.playerset.get(0).setHealth(110); 
						    		JOptionPane.showMessageDialog(
											frame, 
											"You eat the burger and recover most of your health! It is now " + PlayerAL.playerset.get(0).getHealth() + "."
											);
						    		enemyTurn();
						    		
						    	}else if(chooseItem.equals("Energy Drink (ATK BOOST)"))
						    		{
						    			PlayerAL.playerset.get(0).setAttack(100);
						    			JOptionPane.showMessageDialog(
												frame, 
												"The energy drink boosts your ATK! it is now " + PlayerAL.playerset.get(0).getAttack() + "."
												);
						    			enemyTurn();
						    			
						    		}else if (chooseItem.equals("Week Old Chocolate Chip Cookie"))
						    			{
						    				PlayerAL.playerset.get(0).setDefend(100);
						    				JOptionPane.showMessageDialog(
													frame, 
													"The energy drink boosts your ATK! it is now " + PlayerAL.playerset.get(0).getAttack() + "."
													);
						    				enemyTurn();
						    			}
						}
			
		}
	
	}
