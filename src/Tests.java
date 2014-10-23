import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Tests {
	private static ArrayList<Player> players = new ArrayList<Player>();
	private static ArrayList<Match> matches = new ArrayList<Match>();

	public static int round = 0;
	public static int numRounds = 0;
	public static int numTables = 0;
	public static int numPlayers = 0;

	public static Random rand;


	public static void main(String[] args){
		rand = new Random();
		numPlayers = 9;

		for(int i = 0; i < numPlayers; i++){
			players.add(new Player(""+(char)('a'+i)));
		}

		/* Randomise seat order */
		Collections.shuffle(players);

		/* Calculate number of rounds and tables */
		numRounds = (int)Math.ceil(Math.log(numPlayers+1)/Math.log(2.0));
		numTables = numPlayers/2;

		System.out.println(players);

		for(int i = 0; i < numRounds; i++){


			pairRound();
			
			for(Match m: matches){
				System.out.println(m.getP1() + "\tvs\t" + m.getP2());
			}

			randomiseResults();

			finaliseRound();
			
			System.out.println(players);

		}
		
		System.out.println("finished");

	}

	private static void randomiseResults() {
		for(Match m: matches){

			int p1score = 0;
			int p2score = 0;

			while(p1score < 3 && p2score < 3){
				int r = rand.nextInt(2);
				if(r == 0){
					p1score++;
				}else{
					p2score++;
				}
			}
			m.score(p1score,p2score);
		}
	}

	private static void finaliseRound() {
		/* Sort players by score */
		Collections.sort(players);

		/* Standings GUI */
		matches.clear();
	}

	private static void pairRound() {
		/* First round random pairings */
		if(round==0){
			Collections.shuffle(players);
		}
		round++;


		/* Swiss Pairings */
		int[] order = SwissPairings.pair(players);
		Player bye = null;

		for(int i = 0; i < numTables; i++){
			matches.add(new Match(players.get(order[2*i]),players.get(order[2*i+1])));

		}
		if(numPlayers %2 != 0 ){
			bye = players.get(order[numPlayers - 1]);
			bye.bye();
		}
	}

}
