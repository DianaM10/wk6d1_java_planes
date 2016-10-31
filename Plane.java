public class Plane{
  private String type;
  private String pilot;
  private Passenger[] fusalage;

  public Plane(String type, String pilotName){
    this.type = type;
    this.pilot = pilotName;
    this.fusalage = new Passenger[416];
  }  

  public String getType(){
    return this.type;
  }

  public String getPilot(){
    return this.pilot;
  }

  public int passengerCount(){
    int counter = 0;
    for (Passenger count : fusalage){
      if (count != null){
        counter++;
      }
    }
    return counter;
  }

  public void board(Passenger passenger){
    if ( fusalageFull()){
      return;
    }
    int count = passengerCount();
    fusalage[count] = passenger;
  }

  public boolean fusalageFull(){
    return passengerCount() == fusalage.length;
  }

  public boolean takeOff(){
    if (fusalageFull() == true) {
      return true; 
    }
    else return false;
  }

  public void disembark(){
    for (int i = 0; i < 416 ;i++ ) {
      fusalage[i] = null; 
    }
  }




}