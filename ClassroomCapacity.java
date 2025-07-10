/** 
@author Ramdial, Samuel "Sam" - ITSC 1212 - 005 - von Briesen
@version 3.0
@since 11/10/2021

Project 2 A
Calculate the building, floor, and classroom capacity based on a percentage amount provided by the user. 
*/
import java.util.Scanner; 
public class ClassroomCapacity 
{
        public static void main (String [] args)
    {
        Scanner console = new Scanner(System.in); 
        boolean percentConditions = false; 
        double stateClassroomCapacity = 0.0;    //Used to store state percent
        int classCapacity = 0;                  //Used to store normal classroom capacity 
        int classroomStateCapacity = 0;         //Used to store classroom capacity after being multiplied by state percent
        int totalFloorCapacity = 0;             //Used to keep count of the total number of floors in the building
        int totalStateCapacity = 0;             //Used to keep count of state capacity in enter building 
        int individualFloorCapacity = 0;        //Used to keep count of the floor capacity of a specific floor
        int individualStateCapacity = 0;        //Used to keep count of the state allowed capacity of a speciifc floor 
        
        String startMessage = "************************* START ******************************* \n";
        String endMessage = "\n***************************** END *****************************"; 

        System.out.println(startMessage);
        while(percentConditions == false) // Verifies that the percent condition isn't negative 
        {
            System.out.print("Please enter the state allowed classroom capacity person. (For example, if it's 5%. enter it as .05): ");
            String capacityInput = console.nextLine(); 
            stateClassroomCapacity = Double.parseDouble(capacityInput); 
            if (stateClassroomCapacity > 0)
            {
                percentConditions = true; 
            }
            else 
            {
                System.out.println("The state allowed capacity percent cannot be negative.");
            }
        }

        boolean floorConditions = false; 
        int numFloors = 0; 
        while (floorConditions == false) // Verifies that the number of floors are at least 1 
        {
            System.out.print("Please enter the number of floors in Woodward Hall: ");
            numFloors = console.nextInt(); 
            if (numFloors >= 1)
            {
                floorConditions = true; 
            }
            else
            {
                System.out.println("The number of floors in Woodward Hall must be at least 1.");
            }
        }

        int numberOfClassrooms; //used to store the number of classrooms 
        for (int i = 1; i <= numFloors; i++) // iterates for the amount of floors user inputs 
        {
            System.out.println("");
            System.out.print("Please enter the number of classrooms that are on Floor #" + i + ": ");
            numberOfClassrooms = console.nextInt(); 
            while (i <= numFloors) // Verifies that the number of classrooms are at least 2 for each floor
            {
                if (numberOfClassrooms >= 2)
                {
                    break; 
                }
                else
                {
                    System.out.print("The number of classrooms must be at least 2. Please enter the number of classrooms that are on Floor #" + i + ": ");
                    numberOfClassrooms = console.nextInt(); 

                }
            }
            for (int j = 1; j <= numberOfClassrooms; j++) // iterates for the number of classrooms on that specific floor
            {
                System.out.println("");
                System.out.print("What is the classroom capacity of (Floor #" + i + " || Classroom #" + j + "): ");
                classCapacity = console.nextInt();
                classroomStateCapacity =(int)(classCapacity * stateClassroomCapacity);
                System.out.println("********************\nFloor: " + i + "/" + numFloors + "\nClassroom: " + j + "/" + numberOfClassrooms + "\nNormal Capacity: " + classCapacity + " Students" + "\nState Capacity: " + classroomStateCapacity + " Students" + "\n*********************");
                individualFloorCapacity += classCapacity; 
                individualStateCapacity += classCapacity * stateClassroomCapacity;
                totalFloorCapacity += classCapacity; //keeps track of all the students on each floor 
                totalStateCapacity = (int)(totalFloorCapacity * stateClassroomCapacity); // calculates the amount of students for the entire building based on user percentage

            }
            
            System.out.println("");
            System.out.println("************** Floor #" + i + " *************");
            System.out.println("Total Classrooms: " + numberOfClassrooms);
            System.out.println("Total Classroom Capacity: " + individualFloorCapacity + " Students");
            System.out.println("Total State Capacity: " + individualStateCapacity + " Students");
            System.out.println("******************************************");
            System.out.println("");
            individualFloorCapacity = 0; //resets floor capacity to 0, to add up depending on the specific floor that the code is on
            individualStateCapacity = 0; //resets floor capacity to 0 to add up depending on the specific floor that the code is on

        }
        System.out.println("");
        System.out.println(" *************** " + "Woodward Hall" + " **************"); 
        System.out.println("Total Floors: " + numFloors);
        System.out.println("Total Normal Capacity: " + totalFloorCapacity + " Students");
        System.out.println("Total State Capacity: " + totalStateCapacity + " Students");
        console.close();
        System.out.print(endMessage);
    } // end main
} // end class
