import static org.junit.Assert.assertEquals;
import org.junit.*;

public class PlaneTest{
  Plane plane;
  Passenger passenger;

  @Before
  public void before(){
    plane = new Plane("Boeing 747");
    passenger = new Passenger();
  }

  @Test 
  public void hasType(){
    assertEquals( "Boeing 747", plane.getType());
  }

  @Test
  public void fusalageStartsEmpty(){
    assertEquals(0, plane.passengerCount());
  }

  @Test
  public void passengersCanBoard(){
    plane.board(passenger);
    assertEquals(1, plane.passengerCount());
  }



}