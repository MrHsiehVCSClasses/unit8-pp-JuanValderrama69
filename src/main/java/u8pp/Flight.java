package u8pp;
import u8pp.Reservation;
import java.util.ArrayList;
public class Flight{
  Reservation[][]plane;
  public Flight(int rows, int seats){
    plane = new Reservation[rows][seats];
    Reservation res = new Reservation("AISLE", false);
    if(seats%2 == 0){
      for(int i = 0;  i < plane.length; i++){
        plane[i][seats/2 +1] = res;
      }
    }
    else if(seats%2 != 0){
      for(int i = 0;  i < plane.length; i++){
        plane[i][seats/2] = res;        
    }
      }
  }
  public ArrayList<String> getFrequentFlyers() {
    ArrayList<String> frequentFlyers = new ArrayList<String>();
    for(int i = 0;  i < plane.length;i++){
      for(int j = 0;  j < plane[i].length;j++){
        if(plane[i][j].isFrequentFlyer()){
          frequentFlyers.add(plane[i][j].getPassengerName());
        }        
      }
    }
    return frequentFlyers;
  }
  public boolean reserveNextAvailableSeat(String name, boolean freqFlyer){
    Reservation res = new Reservation(name, freqFlyer);
    for(int i = 0;  i < plane.length; i++){
      for(int j = 0;  j < plane[i].length; j++){
        if(plane[i][j] == null){
          plane[i][j] = res;
          return true;
        }
      }
    }
    return false;
  }
  public boolean reserveAdjacentSeats(String passengerName, boolean firstFrequentFlyer, String passengerNameTwo, boolean secondFrequentFlyer){
    Reservation res1 = new Reservation(passengerName, firstFrequentFlyer);
    Reservation res2 = new Reservation(passengerNameTwo, secondFrequentFlyer);
    for(int i =  0; i < plane.length; i++){
      for(int j =  0;  j < plane[i].length -1;  j++){
        if(plane[i][j] == null && plane[i][j+1] == null){
          plane[i][j] = res1;
          plane[i][j+1] = res2;
          return true;
        }       
      }
    }
    return false;
  }
  public boolean reserveWindowSeat(String name, boolean freqFlyer){
    Reservation res = new Reservation(name, freqFlyer);
    for( int i = 0; i < plane.length; i++){
      if(plane[i][0] == null){
        plane[i][0] = res;
        return true;
      }
      else if(plane[i][plane[i].length -1] == null){
        plane[i][plane[i].length -1] = res;
        return true;
      }
    }
    return false;
  }
  public boolean reserveAisleSeat(String name, boolean freqFlyer){
    Reservation res = new Reservation(name, freqFlyer);
    for(int i = 0; i < plane.length;i++){
      for(int j = 0; j < plane[i].length; j++){
        if(plane[i][j] == null){
          if(plane[i][j +1].getPassengerName().equals("AISLE")){
            plane[i][j] = res;
            return true;
          }
          else if(plane[i][j -1].getPassengerName().equals("AISLE")){
            plane[i][j] = res;
            return true;
          }
        }
      }
    }
    return false;
  }
  public ArrayList<String> getIsolatedPassengers(){
    ArrayList<String> isolatedPassengers = new ArrayList<String>();
    for(int i = 0; i < plane.length; i++){
      for(int j = 0; j < plane[i].length; j++){
        if(plane[i][j] != null){
          if(plane[i][j+1] == null){
            isolatedPassengers.add(plane[i][j].getPassengerName());
          }
          else if(plane[i][j-1] == null && plane[i][j+1] == null){
            isolatedPassengers.add(plane[i][j].getPassengerName());
          }
          else if(plane[i][j-1] == null && plane[i][j+1].getPassengerName().equals("AISLE")){
            isolatedPassengers.add(plane[i][j].getPassengerName());
          }
          else if(plane[i][j+1] == null && plane[i][j-1].getPassengerName().equals("AISLE")){
            isolatedPassengers.add(plane[i][j].getPassengerName());
          }
          else if(plane[i][j-1] == null){
            isolatedPassengers.add(plane[i][j].getPassengerName());
          }
        }
      }
    }
    return isolatedPassengers;
  }
  public String toString(){
    String reservations = "";
          for(int i = 0; i < plane.length; i++){
            for(int j = 0; j < plane[i].length; j++)
            {
             if(plane[i][j] == null){
               reservations += "EMPTY";
             } 
              else if(plane[i][j].getPassengerName().equals("AISLE")){
                reservations += "AISLE";
              }
              else{
                reservations += plane[i][j].getPassengerName();                
              }
              if(j < plane[i].length -1){
                reservations += " ";
              }
              }
            reservations += "\n";
          }
    return reservations;
  }
  public Reservation[][] getSeats(){
    return plane;
  }
}