import java.util.Random;
import java.util.Scanner;

public class Lee_algorithm{

    private static Scanner scan = new Scanner(System.in);
    private static int[] start = new int[] {0, 0};
    private static int[] stop = new int[] {0, 0};
    private static int[][] map = new int[][] {
        { 00, 00, 00, 00, 00, 00, 00, 00 },
        { 00, 00, -1, 00, 00, 00, 00, 00 },
        { 00, 00, -1, 00, -1, 00, -1, 00 },
        { 00, 00, -1, 00, 00, 00, -1, 00 },
        { 00, 00, -1, 00, 00, 00, -1, 00 },
        { 00, -1, -1, -1, -1, -1, -1, 00 },
        { 00, 00, -1, 00, 00, 00, -1, 00 },
        { 00, 00, -1, 00, 00, 00, -1, 00 },
        { 00, 00, 00, 00, 00, 00, -1, 00 },
        { 00, 00, 00, 00, 00, 00, -1, 00 },
        { 00, 00, 00, 00, 00, 00, 00, 00 }
    }; // The 2D array dimensions are - 11x8.

    private static void show_map()
    {
        for(int i = 0; i < map.length; i++)
        {
            for(int j = 0; j < 8; j++)
            {
                System.out.printf("%d ", map[i][j]);
            }
            System.out.println();
        }
    }
    
    private static void get_start_stop_coordinates()
    {
        String foo = "";
        System.out.println("Enter the starting and finishing coordinates, or generate them randomly.");
        
        System.out.println("Do you want to generate them y/Y ?");
        foo = scan.nextLine();
        if(foo.equals("y") || foo.equals("Y"))
        {
            
        }
        else
        {

        }
    }

    private static void initialization()
    {

    }

    private static void wave_progression()
    {

    }

    private static void way_restoration()
    {

    }

    public static void main(String[] args) {
        String foo = "";
        while(true)
        {
            Lee_algorithm.show_map();
            Lee_algorithm.get_start_stop_coordinates();
            Lee_algorithm.initialization();
            Lee_algorithm.wave_progression();
            Lee_algorithm.show_map();
            Lee_algorithm.way_restoration();

            System.out.println("Do you want to terminate the program y/Y ?");
            foo = scan.next();
            if(foo.equals("y") || foo.equals("Y"))
                break;
        }
        scan.close();
    }
}