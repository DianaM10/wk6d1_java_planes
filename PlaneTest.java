import static org.junit.Assert.*;
import org.junit.*;

public class PlaneTest{
  Plane plane;
  Passenger passenger;
  Luggage luggage;

  @Before
  public void before(){
    plane = new Plane("Boeing 747", "Hans Solo");
    passenger = new Passenger();
    luggage = new Luggage();
  }

  @Test 
  public void hasType(){
    assertEquals( "Boeing 747", plane.getType());
  }

  @Test
  public void hasPilot(){
    assertEquals("Hans Solo", plane.getPilot());
  }

  @Test
  public void fusalageStartsEmpty(){
    assertEquals(0, plane.cargoCount());
  }

  @Test
  public void passengerCanBoard(){
    plane.board(passenger);
    assertEquals(1, plane.cargoCount());
  }

  @Test
  public void luggageCanBoard(){
    plane.board(luggage);
    assertEquals(1, plane.cargoCount());
  }

  @Test 
  public void cantBoardWhenFull(){
    for (int i = 0; i < 200; i++){
      plane.board(passenger);
    }
    for (int i = 0; i < 216; i++){
      plane.board(luggage);
    }
    assertEquals(416, plane.cargoCount());
  }

  @Test
  public void fusalageIsFull(){
    for (int i = 0; i < 200; i++){
      plane.board(passenger);
    }
    for (int i = 0; i < 216; i++){
      plane.board(luggage);
    }
    assertEquals( true, plane.fusalageFull());
  }

  @Test
  public void prepareForTakeOff(){
    // plane.board(passenger);
    // assertEquals(1, plane.passengerCount());
    for (int i = 0; i < 200; i++){
      plane.board(passenger);
    }
    for (int i = 0; i < 216; i++){
      plane.board(luggage);
    }
    plane.fusalageFull();
    assertEquals(true, plane.takeOff());
  }

  @Test
  public void emptyPlane(){
    // plane.board(passenger);
    // assertEquals(1, plane.cargoCount());
    // for (int i = 0; i < 416; i++) {
    //   plane.board(passenger);
    // }
    for (int i = 0; i < 200; i++){
      plane.board(passenger);
    }
    for (int i = 0; i < 216; i++){
      plane.board(luggage);
    }
    plane.fusalageFull();
    plane.empty();
    assertEquals(0, plane.cargoCount());
  }

  @Test 
  public void canDisembark(){
    plane.board(luggage);
    plane.board(passenger);
    Carryable cargo = plane.disembark();
    assertNotNull(cargo);

  }

  @Test
  public void canDisembarkPassenger(){
    plane.board(passenger);
    Carryable cargo = plane.disembark();
    Passenger passenger = (Passenger) cargo;
    assertEquals("speaking", passenger.speak());
  }

 







}