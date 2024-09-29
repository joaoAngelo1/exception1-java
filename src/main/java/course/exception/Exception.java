
package course.exception;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import model.entitites.Reservation;
import model.exception.DomainException;

public class Exception {

    public static void main(String[] args){
        Scanner leitor = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try{
        System.out.print("Room number: ");
        int roomNumber = leitor.nextInt();
        System.out.print("Check-in datwe (dd/MM/yyyy): ");
        Date checkIn = sdf.parse(leitor.next());
        System.out.print("Check-out date (dd/MM/yyyy): ");
        Date checkOut = sdf.parse(leitor.next());
        
        Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
        System.out.println("Reservation :"+reservation);
        System.out.println();
        System.out.println("Enter data to be updated: ");
        System.out.print("Check-in date (dd/MM/yyyy): ");
        checkIn = sdf.parse(leitor.next());
        System.out.print("Check-out date (dd/MM/yyyy): ");
        checkOut = sdf.parse(leitor.next());

        reservation.updateDates(checkIn, checkOut);   
        System.out.println("Reservation: "+reservation);
            
            
        }catch(ParseException e){
            System.out.println("Invalid date format");
        }
        catch(DomainException e){
            System.out.println("Error in reservation: "+e.getMessage());
        }
        catch(RuntimeException e){
            System.out.println("Unexpected error");
        }
        
        
        
        leitor.close();
    }
}
