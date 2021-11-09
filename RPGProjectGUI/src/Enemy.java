

public class Enemy
	{
		private String name;
		private String attack;
		private String item;
		private int health;
		private int damage;
		private double hitprob;
		
	public Enemy(String n, String a, String i, int h, int d, double p )
			{
			name = n;
			attack = a;
			item = i;
			health = h;
			damage = d;
			hitprob = p;
			}

	public String getName()
		{
			return name;
		}

	public void setName(String name)
		{
			this.name = name;
		}

	public String getAttack()
		{
			return attack;
		}

	public void setAttack(String attack)
		{
			this.attack = attack;
		}

	public String getItem()
		{
			return item;
		}

	public void setItem(String item)
		{
			this.item = item;
		}

	public int getHealth()
		{
			return health;
		}

	public void setHealth(int health)
		{
			this.health = health;
		}

	public int getDamage()
		{
			return damage;
		}

	public void setDamage(int damage)
		{
			this.damage = damage;
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

