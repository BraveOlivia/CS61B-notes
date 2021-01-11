public class H0 {
    public static void main(String[] args) {
        printStar(10);
        int[] numbers = new int[]{9, 2, 15, 2, 22, 10, 6};
        System.out.println(max(numbers));
        System.out.println(max2(numbers));
        int[] a = {1, 2, -3, 4, 5, 4};
        int[] result= windowPosSum(a,3);
        for (int i=0;i<a.length;i++){
            System.out.print(result[i]+", ");
        }

        int[] b = {1, -1, -1, 10, 5, -1};
        int[] result2= windowPosSum(b,2);
        System.out.println("");
        for (int i=0;i<b.length;i++){
            System.out.print(result2[i]+", ");
        }

        int[] nums = {2,7,11,15};
        int target = 9;
        int[] re=twoSum(nums,target);
        System.out.println(re[0]+", "+re[1]);
    }

    public static void printStar(int num) {
        for (int i = 0; i < num+1; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static int max(int[] m){
        int temp =m[0];
        for (int i=1;i<m.length;i++){
            if(m[i]>temp){
                temp=m[i];
            }
        }
        return temp;
    }

    public static int max2(int[] m){
        int temp =m[0];
        if (m.length>1){
            int i=1;
            while (i<m.length){
                if (m[i]>temp){
                    temp=m[i];
                }
                i++;
            }
        }
        return temp;
    }

    public static int[] windowPosSum(int[] a, int n){
        int[] output = new int[a.length];
        for(int i=0;i<a.length;i++){
            int sum=0;
            if(a[i]>0){
                if(a.length-1-i>=n){
                    for(int j=i;j<i+n+1;j++){
                        sum += a[j];
                    }
                } else {
                    for(int j=i;j<a.length;j++){
                        sum += a[j];
                    }
                }
                output[i]=sum;
            } else {
                output[i]=a[i];
            }
        }
        return output;
    }

    public static int[] twoSum(int[] nums, int target) {
            int[] result=new int[2];
            for(int i=0;i<nums.length;i++){
                for(int j=i;j<nums.length;j++){
                    if (nums[i]+nums[j]==target){
                        result[0]=nums[i];
                        result[1]=nums[j];
                    }
                }
            }
            return result;
    }
}
