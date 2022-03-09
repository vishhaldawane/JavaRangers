package com.company.project;

public class Test {
    public static void main(String[] args) {
      //  UI u= new UI(); //react + angular + html
      //  u.bookTicket();

    //    Guitar guitar = new Guitar();
     //   Sitar sitar = new Sitar();

      //  guitar.play();
      //  sitar.play();

        MusicalInstrument musicalInstrument = MusicShop.getMusicalInstrument("bowing");
        musicalInstrument.persist();


    }
}
class TicketDAOImpl // JPA -> Hibernate Guitar - Toplink - Sitar
{
    void bookTicket() {
        System.out.println("\t\t\t\tDAO====> collecting service's data....");
        System.out.println("\t\t\t\tDAO: booking the ticket in the tables...");
        System.out.println("\t\t\t\tDAO====> ticket is confirmed [persist] / not confirmed [ err msg] ");
    }
}
class TicketBookingService
{                                   // 200 - 3 = 197
    void bookTicket() { //BL to book the ticket, find the real time logic and update the reservation chart too.
        System.out.println("\t\t\tSERVICE: ===> collecting the data from the controller....");
        TicketDAOImpl ticketDAO = new TicketDAOImpl();
        ticketDAO.bookTicket();
        System.out.println("\t\t\tSERVICE: bookTicket");
        System.out.println("\t\t\tSERVICE: ===> ticket is confirmed / not confirmed");
    }
}
class BookingController
{
    void bookTicket() { // will take your UI entries
        System.out.println("\t\tCONTROLLER: ==> collecting the UI data...");
        TicketBookingService ticketBookingService = new TicketBookingService();
        ticketBookingService.bookTicket();
        System.out.println("\t\tCONTROLLER: bookTicket");
        System.out.println("\t\tCONTROLLER: ==> ticket is confirmed / not confirmed ");
    }
}
class UI  //angular react
{
    void bookTicket() { //UI event -> for this Button to book a ticket
        System.out.println("\tUI: => sending the UI data ");
        BookingController bookingController = new BookingController();
        bookingController.bookTicket();
        System.out.println("\tUI: bookTicket");
        System.out.println("\tUI: => ticket is confirmed / not confirmed ");
    }
}

interface MusicalInstrument //JPA specification
{
    void persist();
}

class Guitar implements  MusicalInstrument
{
    public void persist() {
        System.out.println("persist via hibernate...");
        System.out.println("this is faster...");
    }
}

class Sitar  implements  MusicalInstrument
{
    public void persist() {
        System.out.println("persist via toplink...");
        System.out.println("this is fast");
    }
}

class Violin  implements  MusicalInstrument
{
    public void persist() {
        System.out.println("persist via informatica warehouse ...");
        System.out.println("this is fastest");
    }
}

/*


class Microwave
{
    Cake bake(CocaPowder cp, Maida m, Sugar s, Water w, etc.......)
    {
        Cake cake = new Cake(.....);
        return cake;
    }
    FriedPeanuts bake(RawPeanuts rp)
    {

    }
}

*/
class MusicShop
{
    int addNumbers(int x,int y) {

        int z = x+y;
        return z; //promise to return the sum of x and y
    }
    static MusicalInstrument getMusicalInstrument(String hint) {
        MusicalInstrument  musicalInstrument = null;

        if(hint.equalsIgnoreCase("pluck"))
            musicalInstrument = new Guitar();
        else  if(hint.equalsIgnoreCase("ting"))
            musicalInstrument = new Sitar();
        else  if(hint.equalsIgnoreCase("bowing"))
            musicalInstrument = new Violin();

        return musicalInstrument;

    }
}