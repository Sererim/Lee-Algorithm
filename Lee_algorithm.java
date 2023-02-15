import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Lee_algorithm{

    private static Random rand = new Random();
    private static Scanner scan = new Scanner(System.in);
    private static int[] start = new int[] {0, 0};
    private static int[] stop = new int[] {0, 0};
    private static int size_j = 8;
    private static int size_i = 11;
    private static int[] nums = {0, 1};
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
        for(int i = 0; i < size_i; i++)
        {
            for(int j = 0; j < size_j; j++)
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
                start[0] = rand.nextInt(size_i);
                start[1] = rand.nextInt(size_j);
                stop[0] = rand.nextInt(size_i);
                stop[1] = rand.nextInt(size_j);
                if(!(start[0] == stop[0] && start[1] == stop[1]))
                    break;
            }
        }
        else
        {
            System.out.println("Enter coordinates. i E [0, 8) ; j E [0, 11)");
            while(true)
            {
                try {
                    System.out.println("Enter coordinates of the starting point.");
                    System.out.println("Enter i coordinate of the starting point.");
                    start[0] = scan.nextInt();
                    if(start[0] < 0 || start[0] >= size_i)
                        throw new IllegalArgumentException();
                    System.out.println("Enter j coordinate of the starting point.");
                    start[1] = scan.nextInt();
                    if(start[1] < 0 || start[1] >= size_j)
                        throw new IllegalArgumentException();
                    
                    System.out.println("Enter coordinates of the stopping point.");
                    System.out.println("Enter i coordinate of the stopping point.");
                    stop[0] = scan.nextInt();
                    if(stop[0] < 0 || stop[0] >= size_i)
                        throw new IllegalArgumentException();
                    System.out.println("Enter j coordinate of the stopping point.");
                    stop[1] = scan.nextInt();
                    if(stop[1] < 0 || stop[1] >= size_j)
                        throw new IllegalArgumentException();
                    
                    if(!Arrays.equals(start, stop))
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
        int i, j = 0;
        i = start[0];
        j = start[1];
        if (map[i][j] == -1)
        {
            i = 10;
            start[0] = i;
        }
        for(int count = 0; count < 4; count++)
        {
            if(i != 0 && map[i - 1][j] != -1)
                map[i - 1][j] = 1;
            if(i < size_i - 1 && map[i + 1][j] != -1)
                map[i + 1][j] = 1;
            if(j != 0 && map[i][j - 1] != -1)
                map[i][j - 1] = 1;
            if(j < size_j - 1 && map[i][j + 1] != -1)
                map[i][j + 1] = 1;
        }
        nums[0] = 1;
    }

    private static void wave_progression()
    {
        do {
            for(int i = 0; i < size_i; i++)
                for(int j = 0; j < size_j; j++)
                {
                    if(map[i][j] == nums[0])
                    {
                    if(i != 0 && map[i - 1][j] != -1 && map[i - 1][j] != nums[1])
                        map[i - 1][j] = nums[0] + 1;
                    if(i < size_i )
                        if(i + 1 != 11 && map[i + 1][j] != -1 && map[i + 1][j] != nums[1])
                            map[i + 1][j] = nums[0] + 1;
                    if(j != 0 && map[i][j - 1] != -1 && map[i][j - 1] != nums[1])
                        map[i][j - 1] = nums[0] + 1;
                    if(j < size_j )
                        if(j + 1 != 8 && map[i][j + 1] != -1 && map[i][j + 1] != nums[1])
                            map[i][j + 1] = nums[0] + 1;
                    }
                }
                nums[1] = nums[0];
                nums[0]++;
        } while (map[stop[0]][stop[1]] == 0);
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
            Lee_algorithm.show_map();
            Lee_algorithm.wave_progression();
            Lee_algorithm.show_map();

            System.out.println("Do you want to terminate the program y/Y ?");
            foo = scan.next();
            if(foo.equals("y") || foo.equals("Y"))
                break;
        }
        scan.close();
    }
}
