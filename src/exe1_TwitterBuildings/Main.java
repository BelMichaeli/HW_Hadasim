package exe1_TwitterBuildings;

import java.util.Scanner;

public class Main {

    Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        int choice = start("for the first time");  //the user set his choice to create a tower
        int height;
        int width;

        while (choice != 3) {

            Scanner input = new Scanner(System.in);
            System.out.println("please enter the height and width of your desired tower size\n");
            height = input.nextInt();
            width = input.nextInt();

            if (choice == 1) {  //A rectangular tower
                rectangle(height, width);
            } else if (choice == 2) { //A triangle tower
                triangle(height, width);
            }

            choice = start("again");  //return to the selection menu

        }

        System.out.println("Good luck, Twitter owners");
    }

    public static int start(String situation) {
        System.out.println("Hello " + situation + " dear user!\n" +
                "Here is the towers construction system.\n" +
                "You are prompted to choose one of the options below:\n" +
                "option no.1- A rectangular tower\n" +
                "option no.2- A triangle tower");

        if (situation == "again") {  //just if the user return to the start menu, he will know to choose the third option- to exit
            System.out.println("option no.3- Stopping the program");
        }

        System.out.println("Your choice:");

        //the user input
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }

    public static void rectangle(int height, int width) {
        System.out.println("Your choice is a rectangle tower\n");
        if (height - width > 5) {
            System.out.println("The area of the rectangle is: " + height * width);
        } else {
            System.out.println("The scope of the rectangle is: " + height * 2 + width * 2);
        }
    }

    public static void triangle(int height, int width) {
        System.out.println("Your choice is a triangle tower\n" +
                "You can choose one of the options below:\n" +
                "option no.1- Get the triangle's scope\n" +
                "option no.2- Print the triangle");

        Scanner input = new Scanner(System.in);
        int tChoice = input.nextInt();

        if (tChoice == 1) {
            System.out.println("The triangle's scope is " + height * 2 + width);
        } else if (tChoice == 2) {
            if (width % 2 == 0 || width > height * 2) {  //תתבצע בדיקה האם רוחב המשולש הוא מספר זוגי או אם רוחבו
                //   ארוך ביותר מפי 2 מגובהו, אם כן תודפס למשתמש הודעה שלא
                //  ניתן להדפיס את המשולש.
                System.out.println("The given triangle cannot be printed");
            } else {
                System.out.println("Here is the triangle tower printing: \n");
                int rows = width;

                for (int i = 1; i <= height; i++) {
                    int k = 0;
                    int j = 1;

                    if (i % 2 == 0) {
                        k++;
                    }

                    for (; j <= rows / 2; j++) {  //printing the spaces
                        System.out.print(" ");
                    }

                    for (; k < i && k < width; k++) {  //printing the stars

                        System.out.print("*");
                    }
                    System.out.println("");
                    rows--;

                }
            }
        }
    }
}


