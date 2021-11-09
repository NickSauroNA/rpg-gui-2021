public class Player
	{
		private String item;
		
		private int attack;
		private int defend;
		private int health;
		private double hitprob; 
		
		public Player(String i, int a, int d, int h, double hp)
		{
			item = i;
			attack = a;
			defend = d;
			health = h;
			hitprob =  hp;
		}



		public String getItem()
			{
				return item;
			}

		public void setItem(String item)
			{
				this.item = item;
			}

		public int getAttack()
			{
				return attack;
			}

		public void setAttack(int attack)
			{
				this.attack = attack;
			}

		public int getDefend()
			{
				return defend;
			}

		public void setDefend(int defend)
			{
				this.defend = defend;
			}

		public int getHealth()
			{
				return health;
			}

		public void setHealth(int health)
			{
				this.health = health;
			}

		public double getHitprob()
			{
				return hitprob;
			}

		public void setHitprob(double hitprob)
			{
				this.hitprob = hitprob;
			}
	}
		
