package com.eomcs.oop.ex05.x7;

public class CarTest1 {

  public static void main(String[] args) {
    Sedan sedan = new Sedan();
    Truck truck = new Truck();
    testTruck(truck);
  }
  public static void testSedan(Sedan sedan) {

  }
  public static void testTruck(Truck truck) {
    truck.launch();
    truck.go();
  }

}
