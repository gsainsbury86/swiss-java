import java.util.ArrayList;
public class SwissPairings{


	public static int[] pair(ArrayList<Player> players){
	
		int numPlayers = players.size();
		int[] order = new int[numPlayers];
		int orderhealth = 0;
		boolean valid = true;
		
		int[] opt_order = new int[numPlayers];
		int opt_orderhealth = Integer.MAX_VALUE;
		
		PermutationGenerator pg = new PermutationGenerator(players.size());
		
		// for each permutation
		while(pg.hasMore()){
		
			order = pg.getNext();
			
			for(int i = 0; i < (numPlayers/2); i++){
				// if players have already played
				if(players.get(order[i*2]).hasPlayed(players.get(order[i*2+1]))){
					valid = false;
				}
				// otherwise - add differences
				if(valid){
					orderhealth+=(int)Math.abs(players.indexOf(players.get(order[i*2])) - 
												players.indexOf(players.get(order[i*2+1])));
				}
			}
			// if has already had a bye
			if(numPlayers%2!=0){
				if(players.get(order[numPlayers - 1]).hasHadBye()){
					valid = false;
				}else{
					orderhealth+=numPlayers - players.indexOf(players.get(order[numPlayers - 1]));
				}
			}
			
			// if good, gogo gadget update
			if(valid && orderhealth > 0 && orderhealth < opt_orderhealth){
				opt_orderhealth = orderhealth;
				opt_order = order.clone();
			}
			
			// reset
			orderhealth = 0;
			valid = true;
			
		}
		
		return opt_order;
	}

}