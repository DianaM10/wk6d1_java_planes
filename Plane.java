import java.util.*;

public class Plane{
  private String type;
  private String pilot;
  private ArrayList<Carryable> fusalage;

  public Plane(String type, String pilotName){
    this.type = type;
    this.pilot = pilotName;
    this.fusalage = new ArrayList<Carryable>();
  }  

  public String getType(){
    return this.type;
  }

  public String getPilot(){
    return this.pilot;
  }

  public int cargoCount(){
    return this.fusalage.size();
  }

    public void board(Carryable cargo){
    this.fusalage.add(cargo);
  }

  public boolean fusalageFull(){
    if (cargoCount() == 416){
      return true;
    }
    else return false;
  }

  public boolean takeOff(){
    if (fusalageFull() == true) {
      return true; 
    }
    else return false;
  }

  public void empty(){
    this.fusalage.clear();
  }

  public Carryable disembark(){
    if (cargoCount() > 0){
      return fusalage.remove(0);
    }
    return null;
  }




}