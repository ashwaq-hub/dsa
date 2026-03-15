
public class TwoSum {

    private int[] twoSum(int num[], int target){
         Map<Integer,Integer> seen = new HashMap<>(); // value --> index

         for(int i: num){
            if(seen.containsKey(i)){
                 return int[] {seen[i],i};   
            }
         }

         return [];
    }

   public static void main(String args[]){

        int num[] = {2,7,9,10,11};
        int target = 9;

        int indices[] = twoSum(num, target);
        System.out.println(" Target Two Sum Indices are ("+indices[0]+","+indices[1]+")");

   }

}