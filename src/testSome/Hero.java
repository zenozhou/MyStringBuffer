package testSome;

import testSome.Hero.EnemyHeroIsDeadException;

public class Hero {
	private String name;
	private float hp;
	public Hero(String aName,float ahp)
	{
		name = aName;
		hp	= ahp;
	}
	public void attackHero(Hero h) throws EnemyHeroIsDeadException
	{
		if (h.hp==0) {
			throw new EnemyHeroIsDeadException(h.name + " is deaded!");
		}
	}
	public int method()
	{
		try {
			return 1;
		}
		catch(Exception e) {
			return 2;
		}
//		finally{
//			return 3;
//		}
	}
	public String toString()
	{
		return name;
	}
	
	class EnemyHeroIsDeadException extends Exception
	{
		public EnemyHeroIsDeadException() {
			
		}
		public EnemyHeroIsDeadException(String msg) {
			super(msg);
		}
	}
	
//	public static void main(String[] args) 
//	{
//		Hero garen = new Hero("Garen",1000);
//		Hero timoo = new Hero("timoo",0);
//		
////		try {
////			garen.attackHero(timoo);
////		}
////		catch(EnemyHeroIsDeadException e){
////			System.out.println(e.getMessage()+"cause the exception" );
////			e.printStackTrace();
////		}
//			System.out.println(garen.method());
//		
//	}
}

























