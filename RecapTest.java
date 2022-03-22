package com.company;

public class RecapTest {
}
/*

                JAva Technology
                    |
              -------------
              |     |      |
              JSE   JEE    JME
              |
             standard
             core java

  language fundamentals
   - oops concepts
        1. abstraction
                "what is "
        2. Encapsulation
                "how is it"

        3. Polymorphism
                ability of an entity to have multiple forms
                        a. class extension
                                inheritance

                                Doctor
                                |
                             -------
                             |isA
                             Surgeon
                             |
                          -------
                          |isA
                          HeartSurgeon

                        b. function overloading - early binding - eager loading
                    class Phone {
                            void dial(String contactName) { }
                            void dial(int number) { }
                            void dial(int num, String cn) { }
                            void dial(String cn, int num) { }
                    }

                        c.function over-riding
                    class Phone {
                            void dial(String contactName) { }
                            void dial(int number) { }
                            void dial(int num, String cn) { }
                            void dial(String cn, int num) { }
                    }
                    class SmartPhone extends Phone {
                            void dial(String contactName) { } //redefinition of the parent's function
                            void dial(int number) { }
                            void dial(int num, String cn) { }
                            void dial(String cn, int num) { }
                    }

                    d. operator overloading
                        redefining operators
                        -  u cannot redefine operators in java
                4. Inheritance
                        acquiring properties from existing classes

                derivation              vs      implementation

                                                Diagnosing <-- interface/abstract class
                                                | diagnose(); //declared here
            Doctor                          Doctor <-mandates to be fulfilled by teh immediate non-abstract child
            |                                   | diagnose() { } //defn is mandatory here
            Surgeon                             | Surgery
            |                                   | | doSurgery(); //declared here
            |                               Surgeon
            HeartSurgeon                        |doSurgery() { } //defn is mandatory here

                    aggregation - isA
                    composition - hasA


                    Car
                    {
                            Wheel w[] = new Wheel[5]; //hasA
                            Engine eng = new Engine(); //hasA

                    }

                    @Entity
                    @Table(name="car_tbl");
                    Car
                    {
                        @Id
                        int carId;
                    }


                    @Component
                    Car
                    {
                            @Autowired
                            @Qualifier("electEng");
                            Engine eng ;    //hasA

                    }

      Vehicle - FlyingVehicle - Flight - AirBasedVehicle - CommercialFlight - FighterFlight - CargoFlight


    @Component - its simple java class's object to be created
    class Car { }

    @Repository - its simple java class's object to be created +
                 its a specific class for holding collection of objects + CRUD
                 operations

    @Repository
    class CarDAOImpl
    {
    }


    @Service
    class CarService
    {

    }

            usesA               vs              producesA

            class Human extends Mammal //isA
            {
                String name;
                int age;
                Heart h; //hasA - fixture here

                Human(int a, String n) {
                    age = a;
                    name = n;
                    h = new Heart();
                }

                produces            usesA   usesA
                Article writeNotes(Pen p, Paper ppr)
                {
                    .. ... ..
                    Article art = new Article();
                }

                Drawing draw(Pencil p, Canvas c, Color cc)
                {
                    ..  ..  ..
                    Drawing d = new Drawing();
                    return d;
                }
            }


     packages
                    same as directories

                            jungle
                            |
                       ---------------------------
                       |        |       |       |
                       river    cave    tree    test
                       |         |       |       |
                       Crocodile Tiger   Monkey  Test

                  package - keyword to define a package - must be the first line
                    in java code

                  import - to avail the package content

                  private
                  protected
                  public
                  default ( it is not a keyword )

                  class SavingsAccount
                  {
                    private int accountNumber;
                    protected double accountBalance;
                    public String accountHolderName;
                           int age; //default here

                  }


          Exception handling

                    checked             vs          unchecked
                    |                               |
             children of Exception          children of RuntimeException class
             class

            must be declared
            via the throws class
            if a method throws it


            class Car
            {
                void drive() throws Exception, DoorNotClosedException //mandatory
                {
                    Exception e = new Exception(); //CHECKED
                    throw e;


                    DoorNotClosedException d = new DoorNotClosedException("One of the door is not closed...door number 3"); //checked , since it is the child of Exception class
                    throw d;
                }

                void startCar()
                {
                     RuntimeException e = new RuntimeException(); ////UNCHECKED
                     throw e; //for this throws clause is not mandatory

                       RedSignalDisHonouredException r = new RedSignalDisHonouredException(); // unchecked, being the child of RuntimeException
                       throw r;
                }
            }


            Exception
            |
            DoorNotClosedException


            RuntimeException
            |
            RedSignalDisHonouredException

            try {
                code that is susceptible to throw the exception
            }
            catch(exception e) {
                the error handler
            }
            catch(exception e) {
                the error handler2
            }
            catch(exception e) {
                the error handler3
            }
            finally {
                regardless of the exception it is executed
            }


    Multithreading

                                Runnable            Frame [ gui properties ]
                                |run();              |extends
                            ----------------------+  |II.
                            |          implements |  | a. implement from Runnable
                            |                     |  | b. mandate to define run()
                            |                     |  | c. create object of MyFrameThread mfr;
                            |                     |  | d. create object of Thread t = new Thread(mfr);
                            |                     |  | e. t.start() -> mfr.run();
                            Thread              MyFrameThread [ is a Frame, plus is a Runnable ]
                            |
                            |start() { } //talks to JVM's Thread scheduler
                       ----------
                       |
                       MyThread
                       |
                       | I.
                       |a.extend Thread
                       |b. override the run() { }
                       |c. create object of MyThread mt;
                       |d. call the mt.start() method -> run();
                       MyThread

          OOPS
          packages
          exception handling
          threading
          file handling



          byte based streams                        character based stream
          1 byte                                        1 char ( 2 bytes)
     ASCII                                                 UNICODE
          FileInputStream    FileOutputStream       FileReader      FileWriter
          read              write                   read            write
      <-----byte------------->                          <------ char (2 bytes)---->

                                                                    PrintWriter

            BufferedInputStream                     BufferedReader


            Object serialization
                    writing the private data of the object to the file'


                    class SavingsAccount implements Serializable
                    {

                    }
            ObjectInputStream ObjectOutputStream
            readObject()            writeObject



            Generics


            class IntValue
            {
                    int x;
                    int y;

                    void swap() {
                        int temp = x;
                        x = y;
                        y = temp;
                    }
            }
            class FloatValue
            {
                    float x;
                    float y;

                    void swap() {
                        float temp = x;
                        x = y;
                        y = temp;
                    }
            }
            //and so on for byte, short, long, double, char, String , Account, SavingsAccount,, endless


            class AnyValue<T>
            {
                    T x;
                    T y;

                    void swap() {
                        T temp = x;
                        x = y;
                        y = temp;
                    }
            }

            AnyValue<Long> a = new AnyValue<Long>();
            AnyValue<String> a = new AnyValue<String>();
            AnyValue<Account> a = new AnyValue<Account>();


            Iterable
            |
            Collection f/w
            |
        -------------------------
        |                        |
        List [linear]           Set [ non-linear]
        |duplicate              |unique
     ------------           ----------------
     |          |           |           |
  ArrayList  LinkedList TreeSet         HashSet
  Logs          PhoneBook   Chemical        Books
                            Elements        GroceryStore


                            Comparable - compareTo()

                            class Song implements Comparable
                            {
                                    String title;

                                    public int compareTo(Song otherSong) { //mandate
                                     // can compare song's title with other song's title
                                        if(title.equals(otherSong.title) { .....
                                    }
                            }

                            Comparator - compare()


                            //below class is NOT a song
                            class TitleComparator implements Comparator
                            {
                                    public int compare(Song firstSong, Song secondSong)
                                    {
                                            if(firstSong.title.equals(secondSong.title) {.....
                                    }
                            }
                              //below class is NOT a song
                            class YearComparator implements Comparator
                            {
                                    public int compare(Song firstSong, Song secondSong)
                                    {
                                            if(firstSong.year == secondSong.year) {.....
                                    }
                            }

                            //ArtistComparator
                            //AlbumComparator


             JDBC

             Driver - OracleDriver, 
             DriverManager
             Connection
             |
         --------------------------
         |          |           |

 */