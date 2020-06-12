import java.util.Scanner;
public class Game {
    private static final int FARMER_WITHOUT_LAND = 89;
    private static final int SUNNY = 0;
    private static final int RAIN = 1;
    private static final int THUNDERSTORM = 2;
    private static final int SNOW = 3;
    private static int money = 0;
    private static int crops = 0;
    private static int ownedLand = 0;
    private static int cropCapacity = 10;
    private static int weather = 0;
    private static boolean ownsLand = false;
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to Revolution to Technology!");
        System.out.println();
        agrarianLife();
        startGame();
    }
    public static void agrarianLife(){
        int randomNumber = (int) (Math.random()*100);
        System.out.println(randomNumber);
        if(randomNumber <= FARMER_WITHOUT_LAND){
            money = 100;
            System.out.println("You are a farmer in Britain that rents there land to survive");
            System.out.println("You raise common animals and vegetables in your farm.");
            System.out.println("Everyday, you work in the farms and also make goods with your own hands in your house.");
        }
        else{
            money = 30;
            ownedLand = 1;
            ownsLand = true;
            System.out.println("You are a farmer in Britain that owns land.");
            System.out.println("You raise common animals and vegetables in your farm.");
            System.out.println("Everyday, you work in the farms and also make goods with your own hands in your house.");
        }
        printStatus();
    }
    public static void printStatus(){
        System.out.println();
        System.out.println("Your Current Status:");
        System.out.println("Money: " + money + " Crops: " + crops + " Owned Land: " + ownedLand);
        System.out.println();
    }
    public static void weatherStatus(){
        int randomNumber = (int) (Math.random()*100);
        if(randomNumber < 25){
            weather = SUNNY;
        }
        else if(randomNumber >= 25 && randomNumber < 50){
            weather = RAIN;
        }
        else if(randomNumber >= 50 && randomNumber < 80){
            weather = THUNDERSTORM;
        }
        else{
            weather = SNOW;
        }
    }
    public static void payRent(){
        if(!ownsLand){
            if(money == 0){
                crops -= 7;
                System.out.println("Due to monthly rent depths, you payed your landowner 7 crops");
                System.out.println();
            }
            else{
                money -= 30;
                System.out.println("Due to monthly rent depths, you payed your landowner $30");
                System.out.println();
            }
        }
        else{
            System.out.println("Since you own land, you don't have to pay rent.");
            System.out.println();
        }

    }
    public static String wantToContinue(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Do you want to continue? (yes/no)");
        String answer = scan.nextLine();
        return answer;
    }
    public static void harvestOfCrops(){
        weatherStatus();
        if(weather == SNOW || weather == THUNDERSTORM){
            System.out.println("Due to weather conditions, your plants couldn't grow.");
            System.out.println();
        }
        else{
            System.out.println("Due to great weather conditions, you were able to grow " + cropCapacity + " crops!");
            System.out.println();
            crops += cropCapacity;
        }
    }
    public static void sellingOfCrops(){
        if(crops != 0){
            System.out.println("You have to sell your crops to earn some money");
            System.out.println("How many crops do you want to sell?");
            int selling = scan.nextInt();
            if(selling > crops || selling <= 0){
                System.out.println("Sorry, you can't do that");
                sellingOfCrops();
            }
            else{
                crops -= selling;
                int earned = 2 * selling;
                System.out.println("Great, you sold " + selling + " crops and you earn " +  earned + "!");
                money += earned;
            }
        }
    }
    public static void startGame(){
        if(wantToContinue().equals("yes")){
            payRent();
            harvestOfCrops();
            System.out.println("People near you talk about this new product called soap!");
            System.out.println("Would you like to buy some soap?");
            String soap = scan.nextLine();
            if(soap.equals("yes")){
                money -= 4;
                System.out.println("You successfully bought the new product soap!");
                System.out.println("After using this product for about 5 years, everyone saw an improvement in hygiene and sanitation.");
                System.out.println("The population grew in Britain as well!");
            }
            else{
                System.out.println("After using this product for about 5 years, everyone saw an improvement in hygiene and sanitation.");
                System.out.println("But you suffer diseases since you never even bought soap.");
                System.out.println("This causes you to do a daily trip to the doctor.");
                System.out.println("The population grew in Britain as well!");

            }
            printStatus();
            System.out.println("People in Britain have started using new technologies to produce food more efficiently.");
            System.out.println();
            System.out.println("Farmers use new techniques such as selective breeding, mechanization, crop rotation, and enclosure movement.");
            System.out.println("Selective breeding is choosing the most fit animals to breed.");
            System.out.println();
            System.out.println("Mechanization is using machines to improve farming. New inventions spur creativity.");
            System.out.println();
            System.out.println("Crop rotation is rotating your crops from land to land to keep nutrients from running out.");
            System.out.println();
            System.out.println("New were just created!");
            System.out.println("People that own land can enclose land and buy up public land to enclose it!");
            if(ownsLand){
                System.out.println("Would you like to buy public land, or enclose the land you own?");
            }
            else{
                int randomNumber = (int) (Math.random()*10);
                if(randomNumber < 5){
                    System.out.println("Unfortunately, your rented land was enclosed by your landowner!");
                    System.out.println("You will have to find some place else to grow crops and live.");
                }
                else{
                    System.out.println("Your land wasn't enclosed so you fee");
                }
            }

        }
    }
}
