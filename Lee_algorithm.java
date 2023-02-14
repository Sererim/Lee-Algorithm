import java.util.Random;
import java.util.Scanner;

public class Lee_algorithm{

    private static Random rand = new Random();
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
    }; // The 2D array dimensions are - 8x11.

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
            while(true)
            {
                start[0] = rand.nextInt(8);
                start[1] = rand.nextInt(11);
                stop[0] = rand.nextInt(8);
                stop[1] = rand.nextInt(11);
                if(!(start[0] == stop[0] && start[1] == stop[1]))
                    break;
            }
        }
        else
        {
            System.out.println("Enter coordinates. x ∈ [0, 8) ; y ∈ [0, 11)");
            while(true)
            {
                try {
                    System.out.println("Enter coordinates of the starting point.");
                    System.out.println("Enter x coordinate of the starting point.");
                    start[0] = scan.nextInt();
                    if(start[0] < 0 || start[0] >= 8)
                        throw new IllegalArgumentException();
                    System.out.println("Enter y coordinate of the starting point.");
                    start[1] = scan.nextInt();
                    if(start[1] < 0 || start[1] >= 11)
                        throw new IllegalArgumentException();
                    
                    System.out.println("Enter coordinates of the stopping point.");
                    System.out.println("Enter x coordinate of the stopping point.");
                    stop[0] = scan.nextInt();
                    if(stop[0] < 0 || stop[0] >= 8)
                        throw new IllegalArgumentException();
                    System.out.println("Enter y coordinate of the stopping point.");
                    stop[1] = scan.nextInt();
                    if(stop[1] < 0 || stop[1] >= 11)
                        throw new IllegalArgumentException();
                    
                    if(start.equals(stop))
                        break;
                    else
                        throw new IllegalArgumentException();
                } catch(IllegalArgumentException e){
                    System.out.println("Wrong number entered!");
                }
            }
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
            System.out.printf("Starting point coordinates [%d, %d]\n", start[0], start[1]);
            System.out.printf("Stopping point coordinates [%d, %d]\n", stop[0], stop[1]);
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
