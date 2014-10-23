import java.util.ArrayList;
import java.text.DecimalFormat;
public class Player implements Comparable<Player>{

	private String name;
	private int points = 0;
	private int gamesFor = 0;
	private int gamesAgainst = 0;
	private int sheduledforRound = 1;
	private boolean hadBye = false;
	private DecimalFormat formatter = new DecimalFormat("##0.00");
	
	private ArrayList<Player> opponents = new ArrayList<Player>();
	
	public Player(String name){
	
		this.name = name;
	}

	public void win(){
		this.points+=3;
	}
	
	public void draw(){
		this.points++;
	}
	
	public void loss(){
		this.points+=0;
	}
	
	public void bye(){
		sheduledforRound++;
		hadBye = true;
		this.points+=3;
	}
	
	public boolean hasHadBye(){
		return hadBye;
	}
	
	public boolean hasPlayed(Player p){
		return opponents.contains(p);
	}
	
	public void playing(Player o){
		sheduledforRound ++;
		opponents.add(o);
	}
	
	public boolean scheduled(int i){
		if(i < sheduledforRound){
			return true;
		}
		return false;
	}
	
	public int getPoints(){
		return points;
	}
	
	public String getName(){
		return name;
	}
	
	public void addGamesFor(int g){
		gamesFor+=g;
	}
	
	public void addGamesAgainst(int g){
		gamesAgainst+=g;
	}
	
	public int getGamesFor(){
		return gamesFor;
	}
	
	public int getGamesAgainst(){
		return gamesAgainst;
	}
	
	public String toString(){
		double percentage = 0.0;
		if(gamesFor+gamesAgainst != 0){
			percentage = 100*(gamesFor/(double)(gamesFor+gamesAgainst));
		}
		return name + "\t" + points + " (" + formatter.format(percentage) + "%)";
	}
	
	public int compareTo(Player p){
		if(this.points == p.getPoints()){
			return p.getGamesFor() - this.gamesFor;
		}else{
			return p.getPoints() - this.points;
		}
	}
	
	public boolean is(Player p){
		return this.name.equals(p.getName());
	}

}