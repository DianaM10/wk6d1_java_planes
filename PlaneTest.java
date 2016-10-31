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

  @Test 
  public void cantBoardWhenFull(){
    for (int i = 0; i < 500; i++)
      plane.board(passenger);
    assertEquals(416, plane.passengerCount());
  }

  @Test
  public void fusalageIsFull(){
    for (int i = 0; i < 416; i++) {
      plane.board(passenger);
    }
    assertEquals( true, plane.fusalageFull());
  }

  @Test
  public void prepareForTakeOff(){
    plane.board(passenger);
    assertEquals(1, plane.passengerCount());
    for (int i = 0; i < 416; i++) {
      plane.board(passenger);
    }
    plane.fusalageFull();
    assertEquals(true, plane.takeOff());
  }

  @Test
  public void disembarkPassengers(){
    plane.board(passenger);
    assertEquals(1, plane.passengerCount());
    for (int i = 0; i < 416; i++) {
      plane.board(passenger);
    }
    plane.fusalageFull();
    plane.disembark();
    assertEquals(0, plane.passengerCount());
  }

  // @Test
  // public void weightOfPassenger(){
  //   plane.board(passenger);
  //   assertEquals(1, plane.passengerCount());
  //   passenger.weight()
  // }








}