import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import javax.swing.JOptionPane;
public class Application {
	
	boolean[][] seats = new boolean[4][4];
	Map<String, String> ticketList = new HashMap<String, String>();

	public void displayTicketList(){
		String orderedTickets ="";
		Map<String, String> sortedTicketList = new TreeMap<String, String>(ticketList);
		for (Entry<String, String> e : sortedTicketList.entrySet()) {
			  orderedTickets+=(e.getKey()+": "+e.getValue()+"\n");
			}//end for
		JOptionPane.showMessageDialog(null, orderedTickets);
	}//end displayTicketList
	
	public boolean checkPlaneFull(){
		if (seats[0][0] == true && seats[0][1] == true && seats[0][2] == true && seats[0][3] == true 
				&& seats[1][0] == true && seats[1][1] == true && seats[1][2] == true && seats[1][3] == true
				&& seats[2][0] == true && seats[2][1] == true && seats[2][2] == true && seats[2][3] == true 
				&& seats[3][0] == true && seats[3][1] == true && seats[3][2] == true && seats[3][3] == true){
			return true;
		}//end if
		return false;
	}//end checkPlaneFull
	
	public boolean checkFirstClassFull(){
		if (seats[0][0] == true && seats[0][1] == true && seats[0][2] == true && seats[0][3] == true 
				&& seats[1][0] == true && seats[1][1] == true && seats[1][2] == true && seats[1][3] == true){
			return true;
		}//end if
		return false;
	}//end checkFirstClassFull
	
	public boolean checkEconomyFull(){
		if (seats[2][0] == true && seats[2][1] == true && seats[2][2] == true && seats[2][3] == true 
			&& seats[3][0] == true && seats[3][1] == true && seats[3][2] == true && seats[3][3] == true){
			return true;	
		}//end if
		return false;
	}//end checkEconomyFull

	public void showSeats(){
		String seatGrid = "";
		for (int i = 0; i < seats.length; i++) {
		    seatGrid+=(seats[i][0] + " " + seats[i][1] + " " + seats[i][2] + " " + seats[i][3] + "\n");
		    }//end for
		JOptionPane.showMessageDialog(null, seatGrid);
	}//end showSeats

	public int[] checkWindow(int seatClass, int seatPlacement){
		int[] seatCoordinates = new int[2];
		
		if (seatClass == 1 && seatPlacement == 1){
			for (int i = 0; i <= 1; i++) {
				for (int j = 0; j < seats[i].length; j++) {
					if (checkFirstClassFull()){
						JOptionPane.showInputDialog("1st class is full. Would you like Economy? (y/n)");
						return checkWindow((seatClass+1), seatPlacement);
					}else if (seats[i][0] == false){
						seats[i][0] = true;
						seatCoordinates[0] = i+1;
						seatCoordinates[1] = 0+1;
						return seatCoordinates;
					} else if (seats[i][3] == false){
						seats[i][3] = true;
						seatCoordinates[0] = i+1;
						seatCoordinates[1] = 3+1;
						return seatCoordinates;
					}else if (seats[0][0] == true && seats[0][3] == true && seats[1][0] == true && seats[1][3] == true){
						return checkAisle(seatClass, (seatPlacement+1));
					}//end else
				}//end for
			}//end for
		} else if (seatClass == 2 && seatPlacement == 1){
			for (int i = 2; i <= 3; i++) {
				for (int j = 0; j < seats[i].length; j++) {
					if (checkEconomyFull()){
						JOptionPane.showInputDialog("Economy class is full. Would you like 1st? (y/n)");
						return checkWindow((seatClass-1), seatPlacement);
					}else if (seats[i][0] == false){
						seats[i][0] = true;
						seatCoordinates[0] = i+1;
						seatCoordinates[1] = 0+1;
						return seatCoordinates;
					} else if (seats[i][3] == false){
						seats[i][3] = true;
						seatCoordinates[0] = i+1;
						seatCoordinates[1] = 3+1;
						return seatCoordinates;
					}else if (seats[2][0] == true && seats[2][3] == true && seats[3][0] == true && seats[3][3] == true){
						return checkAisle(seatClass, (seatPlacement+1));
					}//end else
				}//end for
			}// end for
		}//end else
		return seatCoordinates;
	}//end checkWindow
	
	public int[] checkAisle(int seatClass, int seatPlacement){
		int[] seatCoordinates = new int[2];
		
		if (seatClass == 1 && seatPlacement == 2){
			for (int i = 0; i <= 1; i++) {
				for (int j = 0; j < seats[i].length; j++) {
					if (checkFirstClassFull()){
						JOptionPane.showInputDialog("1st class is full. Would you like Economy? (y/n)");
						return checkWindow((seatClass+1), seatPlacement);
					}else if (seats[i][1] == false){
						seats[i][1] = true;
						seatCoordinates[0] = i+1;
						seatCoordinates[1] = 1+1;
						return seatCoordinates;
					} else if (seats[i][2] == false){
						seats[i][2] = true;
						seatCoordinates[0] = i+1;
						seatCoordinates[1] = 2+1;
						return seatCoordinates;
					}else if (seats[0][1] == true && seats[0][2] == true && seats[1][1] == true && seats[1][2] == true){
						return checkWindow(seatClass, (seatPlacement-1));
					}//end else
				}//end for
			}//end for
		} else if (seatClass == 2 && seatPlacement == 2){
			for (int i = 2; i <= 3; i++) {
				for (int j = 0; j < seats[i].length; j++) {
					if (checkEconomyFull()){
						JOptionPane.showInputDialog("Economy class is full. Would you like 1st? (y/n)");
						return checkWindow((seatClass-1), seatPlacement);
					}else if (seats[i][1] == false){
						seats[i][1] = true;
						seatCoordinates[0] = i+1;
						seatCoordinates[1] = 1+1;
						return seatCoordinates;
					} else if (seats[i][2] == false){
						seats[i][2] = true;
						seatCoordinates[0] = i+1;
						seatCoordinates[1] = 2+1;
						return seatCoordinates;
					}else if (seats[2][1] == true && seats[2][2] == true && seats[3][1] == true && seats[3][2] == true){
						return checkWindow(seatClass, (seatPlacement-1));
					}//end else
				}//end for
			}// end for
		}//end else
		return seatCoordinates;
	}//end check Aisle
	
	public String getTicket(String name,int seatClass, int seatPlacement){
		String ticket = "";
		String nameTicket = "";
		if (seatPlacement == 1){
			int[] seatCoords = checkWindow(seatClass, seatPlacement);
			ticket = "Row " + seatCoords[0] + " Seat " + seatCoords[1];
		}else if (seatPlacement == 2){
			int[] seatCoords = checkAisle(seatClass, seatPlacement);
			ticket = "Row " + seatCoords[0] + " Seat " + seatCoords[1];
		}//end else
		ticketList.put(name, ticket);
		nameTicket = name + ": " + ticket;
		return  nameTicket;
	}//end getTicket
	
	public String getValidNameInput(String message){
		String input = "";
		do{
			input = JOptionPane.showInputDialog(message);
		} while(input.isEmpty());
		return input;
	}//end getValidNameInput
	
	public String getValidNumber(String message){
		String input = "";
		do{
			input = JOptionPane.showInputDialog(message);
		} while(input.isEmpty() || !input.matches("[1-2]"));
		return input;
	}//end getValidNumber
	
	public String getValidExit(String message){
		String input = "";
		do{
			input = JOptionPane.showInputDialog(message);
		} while(input.isEmpty() || !input.matches("yes|no"));
		return input;
	}//end getValidNameInput
	
	public void start()
	{
				
		String end = "";
		do {
			String name = getValidNameInput("Please input name");
			String seatClass = getValidNumber("What class do you want? Enter 1 for 1st or 2 for Economy");
			String seatPlacement = getValidNumber("What seat would you like? Enter 1 for Window or 2 for Aisle");
			if (checkPlaneFull()){
				JOptionPane.showMessageDialog(null, "Next flight leaves in 3 hours.");
				break;
			}
			JOptionPane.showMessageDialog(null, getTicket(name, Integer.parseInt(seatClass), Integer.parseInt(seatPlacement)));
			showSeats();
			end = getValidExit("Are you done booking? Enter yes to end or no to continue.");
		} while (!"yes".equals(end));
	
		displayTicketList();
	}//end start
	
}//end class
