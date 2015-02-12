/*
 * SDBA to be completed by students
 * 
 */
package javaapplication22;

// imports
import java.util.Scanner;
import java.util.Calendar;
import java.util.Random;

//create the "Zodiac Signs" type
 enum Zodiac {ARIES, TAURUS, GEMINI, CANCER, LEO, VIRGO, LIBRA, SCORPIO, SAGITTARIUS, CAPRICORN, AQUARIUS, PISCES};

/**
 *
 * @author JAVA mhall
 */
public class JavaApplication22 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //vars
        String firstName = ""; String lastName = "";
        String BDayMonth = ""; int BDayDayOfMonth = 0; int BDayYear = 0;
        int BDayMonthNum = 0;   //month as a number (Jan = 1, etc)
        int nowMonth = 0; int nowDayOfMonth = 0; int nowYear = 0;
        String nowMonthString = "";
        int ageYears = 0; int ageMonths = 0; int ageDays = 0;
        int numDaysInMonth = 0;
        String stone = ""; String flower = ""; String celebs = ""; 
        
//init Zodiac variable to aries
        Zodiac sign =  Zodiac.ARIES;
        
        String show = "";
        
        int horoscopeCode = 0;      //code # for ranomly generated horoscope
        String horoscope = "";
         
        //constants
        final int HORO_MIN = 1;
        final int HORO_MAX = 10;    //max number of horoscopes
        
        //header
        System.out.println("Welcome to the Super Duper Birthday Analyzer\n");
        System.out.println("Enter your name & birthday information");
        System.out.println("and I will give you a wealth of information");
        System.out.println("about your birthday...and a horoscope too!\n");
        
        // create scanner for input
        Scanner kbdScanner = new Scanner(System.in);
        
        //get name
        System.out.print("Please enter your full name: ");
        
        firstName = kbdScanner.next();//first name
        lastName = kbdScanner.next();   //last name
        
        //get birthday info
        System.out.print("Please enter the month you were born (January, February, etc.): ");
        BDayMonth = kbdScanner.next();
        System.out.print("Please enter the day of the month you were born (1, 2, 3, etc.): ");
        BDayDayOfMonth = kbdScanner.nextInt();
        System.out.print("Please enter the year you were born (1990, 1991, etc.): ");
        BDayYear = kbdScanner.nextInt();
        System.out.println("");
        
        //convert month to a number code
        BDayMonth.toLowerCase();
        if (BDayMonth.toLowerCase().equals("january")){
            BDayMonthNum = 1;}
        else if (BDayMonth.toLowerCase().equals("february"))
            BDayMonthNum = 2 ;
        else if (BDayMonth.toLowerCase().equals("march"))
            BDayMonthNum = 3;
        else if (BDayMonth.toLowerCase().equals("april"))
            BDayMonthNum = 4;
        else if (BDayMonth.toLowerCase().equals("may"))
            BDayMonthNum = 5;
        else if (BDayMonth.toLowerCase().equals("june"))
            BDayMonthNum = 6;
        else if (BDayMonth.toLowerCase().equals("july"))
            BDayMonthNum = 7;
        else if (BDayMonth.toLowerCase().equals("august"))
            BDayMonthNum = 8;
        else if (BDayMonth.toLowerCase().equals("september"))
            BDayMonthNum = 9;
        else if (BDayMonth.toLowerCase().equals("october"))
            BDayMonthNum = 10;
        else if (BDayMonth.toLowerCase().equals("november"))
            BDayMonthNum = 11;
        else if (BDayMonth.toLowerCase().equals("december"))
            BDayMonthNum = 12;
        else{
            BDayMonthNum = 0;   //can't spell!
            System.out.println("You cant spell! Bye.");
            //finnish(like the people from that country)
            System.exit(-1);
            }

        //create calendar object to get todays date info
        Calendar now = Calendar.getInstance();
        nowMonth = now.get(now.MONTH)+ 1;           //zero based, so adjust by 1
        nowDayOfMonth = now.get(now.DAY_OF_MONTH);
        nowYear = now.get(now.YEAR);
        
        //calc age...
        // 1st determine how many days are in BDay month
        
        switch (numDaysInMonth)
        {
            case 2:
                BDayDayOfMonth = 28;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                BDayDayOfMonth = 30;
                break;
            default:
                BDayDayOfMonth = 31;
            
        }
        
        
        //now calculate how many years 
        ageYears =  nowYear - BDayYear;
        //adjust years if necessary
        if (BDayMonthNum > nowMonth ||(BDayMonthNum == nowMonth && BDayDayOfMonth > nowDayOfMonth)){
            ageYears--;
        }
        //now calculate days
        if (BDayDayOfMonth > nowDayOfMonth)
            ageDays = numDaysInMonth - BDayDayOfMonth + nowDayOfMonth;
        else
            ageDays = nowDayOfMonth - BDayDayOfMonth;
        //now calculate months
        if (BDayMonthNum > nowMonth)
            if (BDayDayOfMonth > nowDayOfMonth)
                ageMonths = 12 - (BDayMonthNum + 1) + nowMonth;
            else
                ageMonths = 12 - BDayMonthNum  + nowMonth;
        else if (BDayDayOfMonth > nowDayOfMonth)
            if (BDayMonthNum < nowMonth)
                ageMonths = nowMonth - (BDayMonthNum +1);
            else
                ageMonths = 11;
        else
            ageMonths = nowMonth - BDayMonthNum;
  
        //get string version of month as well 
        switch (nowMonth){
            case 1:
                nowMonthString = "January";
                break;
            case 2:
                nowMonthString = "February";
                break;
            case 3:
                nowMonthString = "March";
                break;
            case 4:
                nowMonthString = "April";
                break;
            case 5:
                nowMonthString = "May";
                break;
            case 6:
                nowMonthString = "June";
                break;
            case 7:
                nowMonthString = "July";
                break;
            case 8: 
                nowMonthString = "August";//best month
                break;
            case 9:
                nowMonthString = "September";
                break;
            case 10:
                nowMonthString = "October";
                break;
            case 11:
                nowMonthString = "November";
                break;
            default:
                nowMonthString = "December";
                
        }
  
        
        //get stone, flower, celebs & sign
        
        //Todo
        switch (BDayMonthNum){
            case 1:
                stone = "Garnet";
                flower = "Carnation";
                celebs = "Joan of Arc & Al Capone";
                if (BDayDayOfMonth<=19){
                    sign = Zodiac.CAPRICORN;
                }
                else{
                    sign = Zodiac.AQUARIUS;
                }
                break;
            case 2:
                stone = "Amethyst";
                flower = "Primrose";
                celebs = "Boris Yeltsin & Chelsea Clinton";
                if (BDayDayOfMonth>=18){
                    sign = Zodiac.AQUARIUS;
                }
                else{
                    sign=Zodiac.PISCES;
                }
                break;
            case 3:
                stone = "Aquamarine";
                flower = "Violet";
                celebs = "Captain Kirk(in 2228) & Mr. Rogers";
                if (BDayDayOfMonth>=20){
                    sign = Zodiac.PISCES;
                }
                else{
                    sign = Zodiac.ARIES;
                }
                break;
            case 4:
                stone = "Diamond";
                flower = "Daisy";
                celebs = "Daffy Duck & Hitler";
                if (BDayDayOfMonth>=20){
                    sign = Zodiac.ARIES;
                }
                else{
                    sign = Zodiac.TAURUS;
                }
                break;
            case 5:
                stone = "Emerald";
                flower = "Lily of The Valley";
                celebs = "Ted Kaczynski & Socrates";
                if (BDayDayOfMonth>=20){
                    sign = Zodiac.TAURUS;
                }
                else{
                    sign = Zodiac.GEMINI;
                }
                break;
            case 6:
                stone = "Pearl";
                flower = "Rose";
                celebs = "Moe Howard & Blaise Pascal";
                if (BDayDayOfMonth>=21){
                    sign = Zodiac.GEMINI;
                }
                else{
                    sign = Zodiac.CANCER;
                }
                break;
            case 7:
                stone = "Ruby";
                flower = "Water Lilly";
                celebs = "OJ Simpson & Lizzie Borden";
                if (BDayDayOfMonth>=23){
                    sign = Zodiac.LEO;
                }
                else{
                    sign = Zodiac.CANCER;
                }
                break;
            case 8:
                stone = "Peridot";
                flower = "Poppy";
                celebs = "Mother Theresa & Madonna";
                if (BDayDayOfMonth>=23){
                    sign = Zodiac.VIRGO;
                }
                else{
                    sign = Zodiac.LEO;
                }
                break;
            case 9:
                stone = "Sapphire";
                flower = "Morning Glory";
                celebs = "Meat Loaf & Pope Paul VI";
                if (BDayDayOfMonth>=23){
                    sign = Zodiac.LIBRA;
                }
                else{
                    sign = Zodiac.VIRGO;
                }
                break;
            case 10:
                stone = "Opal";
                flower = "Calendula";
                celebs = "Larry Fine & Curly Howard";
                if (BDayDayOfMonth>=23){
                    sign = Zodiac.SCORPIO;
                }
                else{
                    sign = Zodiac.LIBRA;
                }
                break;
            case 11:
                stone = "Topaz";
                flower = "Chrysanthemum";
                celebs = "Charles Manson & Gandhi";
                if (BDayDayOfMonth>=22){
                    sign = Zodiac.SAGITTARIUS;
                }
                else{
                    sign = Zodiac.SCORPIO;
                }
                break;
            default:
                stone = "Turqouise";
                flower = "Holly";
                celebs = "Rod Serling & Walt Disney";
                if (BDayDayOfMonth>=22){
                    sign = Zodiac.CAPRICORN;
                }
                else{
                    sign = Zodiac.SAGITTARIUS;
                }
        }
        
        
        //get top TV show
        switch (BDayYear){
            case 1993:
                show = "60 Minutes";
                break;
            case 1994:
            case 1997:
                show = "Seinfeld";
                break;
            case 1999:
                show = "Who Wants To Be A Millionaire";
                break;
            case 2000:
                show = "Survivor: Australian Outback";
                break;
            case 1996:
            case 1995:
            case 1998:
                show = "ER";
                break;
            default:
                System.out.println("Bad input");
        }
        
                
        //fake a horoscope with a random number...
        //  create RNG
        Random rng = new Random();
        
        // now generate  a random #
        horoscopeCode = rng.nextInt(HORO_MAX)+HORO_MIN;
        //do the horrorscope
        switch(horoscopeCode){
            case 1:
                horoscope="A 1 star day." +
                          "\n  If somebody taps you on the shoulder, turn around." +
                          "\n  If they have a long robe, black hood, no face, " +
                          "\n  and a sickle in their hand, RUN!";
                break;
            case 2:
                horoscope="A 2 star day." +
                          "\n  You will drop your iPhone into a beaker" +
                          "\n  of sulphuric acid in AP Chem. class." +
                          "\n  But it’s not a total loss,";
                break;
            case 3:
                horoscope="A 3 star day." + 
                          "\n  Go to Trumps in Atlantic City." + 
                          "\n  Find Roulette Table #6" +
                          "\n  Bet $10,000 on #16 red." + 
                          "\n  Close your eyes and sing \"YMCA\" in the key of G." +
                          "\n  You lose...3 star day remember?";
                break;
            case 4:
                horoscope="A 3 star day." +
                          "\n  Expect a raise!" +
                          "\n  (You probably won’t get one," +
                          "\n  but you can at least expect one!)";
                break;
            case 5:
                horoscope="A 4 star day." +
                          "\n  You finally start to understand this JAVA stuff!" +
                          "\n  But you still lost points because you forgot" +
                          "\n  how to jump to a new line & put \"quotes\"" +
                          "\n  around something in a string!";
                break;
            case 6:
                horoscope="A 4 star day." +
                          "\n  You will get a new car today!" +
                          "\n  (made by Matchbox, somehow you accidentally" +
                          "\n  get a Happy Meal at McDonald’s instead of your" +
                          "\n  Supersized Double Quarter Pounder).";
                break;
            case 7:
                horoscope="A 5 star day." +
                          "\n  You finally start to understand this JAVA stuff!" +
                          "\n  You earn an A+ because you finally remembered" +
                          "\n  when to use that lousy = = instead of =.";
                break;
            case 8:
                horoscope="A 5 star day." +
                          "\n  The entire student body decides to stop being" +
                          "\n  disrespectful, late, lying, cursing, fighting," +
                          "\n  being apathetic, do their homework," +
                          "\n  and actually study. Everybody realizes that" +
                          "\n  life is actually nice that way!";
                break;
            case 9:
                horoscope="A 5 star day." +
                          "\n  Elvis visits you, you discover who shot JFK" +
                          "\n  and why the Hindenburg went down, and you" +
                          "\n  solve the Roswell mystery. You decide to" +
                          "\n  go live on a mountaintop somewhere and meditate.";
                break;
            default:
                horoscope="A 5 star day." +
                          "\n  You finally wise up and realize this program" +
                          "\n  can’t predict your future any more than" +
                          "\n  reading the wrinkles on the skin of a" +
                          "\n  2 week old Idaho potato.";
                
                
        }
       
         
        //display all results
        System.out.println("Birthday Analysis for " + firstName +
                           " " + lastName + ":");
        System.out.println("");
        System.out.println("Your Birthday is " + BDayMonth +
                           " " + BDayDayOfMonth +
                           ", "+ BDayYear);
        System.out.println("Right now is " + nowMonthString + 
                           " " + nowDayOfMonth +
                           ", " + nowYear);
        System.out.println("You are " + ageYears + " years, " +
                           ageMonths + " months, and " +
                           ageDays + " days old!");
        System.out.println("");
        System.out.println("Your Birth Stone is " + stone);
        System.out.println("Your Birth Flower is " + flower);
        System.out.println("Famous people born in " + BDayMonth + 
                           " are: " + celebs);
        System.out.println("#1 TV show in " + BDayYear + 
                           " was: " + show);
        System.out.println("Your Zodiac Sign is " + sign);  
        System.out.println("");
        System.out.println("Your horoscope for today is:");
        System.out.println(horoscope);     
     }
}
