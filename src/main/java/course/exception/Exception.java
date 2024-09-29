
package course.exception;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import model.entitites.Reservation;

public class Exception {

    public static void main(String[] args) throws ParseException {
        Scanner leitor = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        System.out.print("Room number");
        int roomNumber = leitor.nextInt();
        System.out.print("Check-in datwe (dd/MM/yyyy): ");
        Date checkIn = sdf.parse(leitor.next());
        System.out.print("Check-out datwe (dd/MM/yyyy): ");
        Date checkOut = sdf.parse(leitor.next());
        if(!checkOut.after(checkIn)){
            System.out.println("Error in reservation: Check-out date must be after check-in date");
        }else{
            Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
            System.out.println("Reservation :"+reservation);
            System.out.println();
            System.out.println("Enter data to be updated: ");
            System.out.print("Check-in datwe (dd/MM/yyyy): ");
            checkIn = sdf.parse(leitor.next());
            System.out.print("Check-out datwe (dd/MM/yyyy): ");
            checkOut = sdf.parse(leitor.next());
            reservation.updateDates(checkIn, checkOut);
            System.out.println(reservation);
            
            Date now = new Date();
            if(checkIn.before(now) || checkOut.before(now)){
                System.out.println("Error in reservation: Reservation dates for update must be future");
            }else if(!checkOut.after(checkIn)){
                System.out.println("Error in reservation: Check-out date must be after check-in date");
            }
            else{
                reservation.updateDates(checkIn, checkOut);
                System.out.println("Reservation: "+reservation);
            }
        }
        
        
        
        leitor.close();
    }
}
