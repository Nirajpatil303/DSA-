// Maximum number of coins or notes works fine for the Indian currencey system
//https://www.geeksforgeeks.org/find-minimum-number-of-coins-that-make-a-change/
// Approch is to keep 


class Main {
    public static void main(String[] args) {
        int[]  arr = {1,2,5,10,20,50,100,500};
        int k = 1270;
		//  1270/500 -> 2 coins
		//  270/100 -> 2 coins
		// 70/50 -> 1 coins
		// 20/20 -> 1 coins
		// total -> 6 coins left
        int i = arr.length-1;
        int count =0;
        while(i>=0)
        {
            if(arr[i]<=k)
            {
                int q = k/arr[i]; // important step to find the multplier value of it rather than running a loop here
                System.out.println(arr[i] + " "+ q);
                count += q;
                k -= q* arr[i];
            }
            i--;
        }
        System.out.println(count);
    }
}

// Actively Selection 

//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine().trim());

        while (t-- > 0) {
            // Read the start times
            String[] startInput = reader.readLine().trim().split("\\s+");
            List<Integer> start = new ArrayList<>();
            for (String s : startInput) {
                start.add(Integer.parseInt(s));
            }

            // Read the end times
            String[] endInput = reader.readLine().trim().split("\\s+");
            List<Integer> end = new ArrayList<>();
            for (String s : endInput) {
                end.add(Integer.parseInt(s));
            }

            // Create solution object and call activitySelection
            Solution obj = new Solution();
            System.out.println(obj.activitySelection(start, end));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends



class Solution {
    public int activitySelection(List<Integer> start, List<Integer> end) {
        // code here.
        
        //step1 prepare opposite List so its easy to sort
        // [end , start] it will be cl= currentlist
        List<List<Integer>> arr = new ArrayList<>();
        int n = start.size();
        for(int i=0;i<n;i++)
        {
            List<Integer> cl = new ArrayList<>();
            cl.add(end.get(i));
            cl.add(start.get(i));
            arr.add(new ArrayList<>(cl));
        }
        //sort it based on end 
      Collections.sort(arr, (x, y) -> Integer.compare(x.get(0), y.get(0)));
    
        /*
        //set first row and pend 
		// [1, 3, 0, 5, 8, 5], end[] = [2, 4, 6, 7, 9, 9]
		// ans -> 1->2->3->4 
		//pend(prev end ) ->2 ->4->7->9
		[2 1] consider
		[4 5] consider
		[6 0] 
		[7 5] consider
		[9 8] consider
		[9 5]
		*/	
        int ans =1;
        int pend = arr.get(0).get(0);
        for(int i=1;i<n;i++)
        {
            if(pend<arr.get(i).get(1))
            {
                ans++;
                pend = arr.get(i).get(0);
            }
        }
        return ans ;
        
        
    }
}


// platform question 

//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            // First array input (arr)
            String[] str1 = br.readLine().trim().split(
                " "); // Read the first line and split by spaces
            int n = str1.length;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] =
                    Integer.parseInt(str1[i]); // Convert each element to an integer
            }

            // Second array input (dep)
            String[] str2 = br.readLine().trim().split(
                " "); // Read the second line and split by spaces
            int m = str2.length;
            int[] dep = new int[m];
            for (int i = 0; i < m; i++) {
                dep[i] =
                    Integer.parseInt(str2[i]); // Convert each element to an integer
            }

            Solution obj = new Solution();
            System.out.println(obj.findPlatform(arr, dep));
            System.out.println("~");
        }
    }
}

// number of platform question 

class Solution {
    // Function to find the minimum number of platforms required at the
    // railway station such that no train waits.
    static int findPlatform(int arr[], int dep[]) {
       // step one put it in array list with +1 for arr -1 for dep
       int n = arr.length;
	   List<Integer> ans = new ArrayList<>();
	   for(int i=0;i<n;i++)
	   {
		   List<List<Integer>> cr = new ArrayList<>();
		   cr.add(arr[i]);
		   cr.add(1);
		   ans.add(new ArrayList<>(cr));
		   cr = new ArrayList<>();
		   cr.add(dep[i]);
		   cr.add(-1);
		   ans.add(new ArrayList<>(cr));
		   
	   }
       
       // sort it according to arravial  and dep if both same then -1 first
       /* 
       3  +1
       18 -1
       18 +1
       20 -1
       gives just one platform 
       
       else 
       3  +1
       18 +1
       18 -1
       20 -1
       gives wrong total platform 2
       */
	   Collections.sort(ans, (o1,o2) -> Integer.compare(o1.get(1), o2.get(1)));
	   //again then find the max of all +1 and -1 at a times
	   int max= 0;
	   for(List now : ans)
	   {
		   int sum = sum + now.get(1);
		   max = Math.max(sum,max);
	   }
	   return max;
    }
}


// job sequenceing question it is 

//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Job {
    int id, profit, deadline;

    Job(int x, int y, int z) {
        this.id = x;
        this.deadline = y;
        this.profit = z;
    }
}

class GfG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String[] jobIDStrings = sc.nextLine().split(" ");
            String[] deadlineStrings = sc.nextLine().split(" ");
            String[] profitStrings = sc.nextLine().split(" ");

            // Convert the input strings to integer arrays
            int[] jobIDs = new int[jobIDStrings.length];
            int[] deadlines = new int[deadlineStrings.length];
            int[] profits = new int[profitStrings.length];

            for (int i = 0; i < jobIDStrings.length; i++) {
                jobIDs[i] = Integer.parseInt(jobIDStrings[i]);
                deadlines[i] = Integer.parseInt(deadlineStrings[i]);
                profits[i] = Integer.parseInt(profitStrings[i]);
            }
            Solution obj = new Solution();
            ArrayList<Integer> ans = obj.JobSequencing(jobIDs, deadlines, profits);
            System.out.println(ans.get(0) + " " + ans.get(1));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends




class Solution {

    public ArrayList<Integer> JobSequencing(int[] id, int[] deadline, int[] profit) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = deadline.length;
        int maxd = 0;
		// fist making a arraylist of deadline and profit with keeping the max deadline to creat a array for it 
        for(int i=0 ;i<n;i++)
        {
            List<Integer> cr = new ArrayList<>();
            cr.add(deadline[i]);
            cr.add(profit[i]);
            ans.add(new ArrayList<>(cr));
            maxd = Math.max(maxd,deadline[i]);
        }
        
		// sorting it according the desc with profit
         ans.sort((a, b) -> Integer.compare(b.get(1), a.get(1)));
         
		 //maxing a array to check max profit for that deadline 
        int[] arr = new int[maxd+1];
        Arrays.fill(arr,-1);
        
        int maxp =0;
        int maxj=0;
        
		
		// 6 2 80 
        // 3 6 70 
        // 4 6 65 
        // 2 5 60 
        // 5 4 25 
        // 8 2 22

        // [-1, 22, 80, 25, 60, 65, 70]
        //  0   1.   2.  3.  4   5.  6
        for(int i=0 ; i<n;i++)
        {
            int currentd = ans.get(i).get(0);
            while(currentd > 0 && arr[currentd] != -1 )
            {
                currentd --;
            }
            if(currentd>0)
            {
                maxj++;
                maxp += ans.get(i).get(1);
                arr[currentd]= ans.get(i).get(1); // not necessary to story it can make it as 1
            }
            
        }
        
        
        ArrayList<Integer> done = new ArrayList<>();
        done.add(maxj);
        done.add(maxp);
        return done ;
    }
}
