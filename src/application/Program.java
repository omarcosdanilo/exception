package ExcecoesPersonalizadas.src.application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import ExcecoesPersonalizadas.src.model.entities.Reservation;

public class Program {
  public static void main(String[] args) throws ParseException {
    Scanner sc = new Scanner(System.in);
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    System.out.println();

    System.out.print("Room number: ");
    int number = sc.nextInt();

    System.out.print("Check-in date (dd/MM/yyyy): ");
    Date checkin = sdf.parse(sc.next());

    System.out.print("Check-out date (dd/MM/yyyy): ");
    Date checkout = sdf.parse(sc.next());

    {/* Veririca se a data checkout não é uma data posterior a data de checkin */}
    if (!checkout.after(checkin)) {
      System.out.println("Error in reservation: Check-out date must be after check-in date");
    }
    else {
      Reservation reservation = new Reservation(number, checkin, checkout);

      System.out.println();
      System.out.println("Reservation: " + reservation);
      System.out.println();

      System.out.println("Enter data to update the reservation");

      System.out.print("Check-in date (dd/MM/yyyy): ");
      checkin = sdf.parse(sc.next());
  
      System.out.print("Check-out date (dd/MM/yyyy): ");
      checkout = sdf.parse(sc.next());

      String error = reservation.updateDates(checkin, checkout);
      
      if (error != null) System.out.println(error);
      else {
        System.out.println();
        System.out.println("Reservation: " + reservation);
      }

    }


    sc.close();
  }
}
