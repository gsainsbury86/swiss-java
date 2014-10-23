public class Match{

	private Player p1;
	private Player p2;
	
	private int p1games;
	private int p2games;
	
	public Match(Player p1, Player p2){
		this.p1 = p1;
		this.p2 = p2;
		p1.playing(p2);
		p2.playing(p1);
		
	}

	public Player score(int p1games, int p2games){
		//TODO: Fix best of system
		//if(p1games > 2 || p1games < 0 || p2games > 2 || p2games <0 || p1games+p2games > 3){
		//	throw new NumberFormatException();
		//}
		
		
		this.setP1games(p1games);
		this.setP2games(p2games);
		
		p1.addGamesFor(p1games);
		p1.addGamesAgainst(p2games);
		p2.addGamesFor(p2games);
		p2.addGamesAgainst(p1games);
		
		int score = p1games - p2games;
		if(score > 0){
			p1.win();
			p2.loss();
			return p1;
		}else if (score < 0){
			p2.win();
			p1.loss();
			return p2;
		}else{
			p1.draw();
			p2.draw();
			return null;
		}
	}
	
	public Player getP1(){
		return p1;
	}
	
	public Player getP2(){
		return p2;
	}

	public int getP1games() {
		return p1games;
	}

	public void setP1games(int p1games) {
		this.p1games = p1games;
	}

	public int getP2games() {
		return p2games;
	}

	public void setP2games(int p2games) {
		this.p2games = p2games;
	}
	
}