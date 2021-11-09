import java.util.ArrayList;

public class EnemyList
	{		
		static ArrayList<Enemy> enemies = new ArrayList<Enemy>( );	
		
	
		public static void fillArray()
			{
						
				enemies.add(new Enemy("rat", "teeth", "disease", 20, 12, 60.0));
				enemies.add(new Enemy("slime", "ooze", "absolute annihilation", 40, 50, 75.5));
				enemies.add(new Enemy("zombie", "bite", "enrage", 35, 70, 55.0));
				enemies.add(new Enemy("dragon", "fire breath", "slaughter", 150, 90, 90.9));
				
				
				
				
	}

}