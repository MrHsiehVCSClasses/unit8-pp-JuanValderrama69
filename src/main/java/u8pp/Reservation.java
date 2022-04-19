package u8pp;
public class Reservation{
String name;
boolean frequentFlyer;
public Reservation(String pName, boolean pFrequentFlyer){
  name = pName;
  frequentFlyer = pFrequentFlyer;
}
public String getPassengerName(){
  return name;
}
  public boolean isFrequentFlyer(){
    return frequentFlyer;
  }
}