package LeetCodes;

public class LC397IntegerReplacement {


    int counter = 0;

    public int integerReplacement(int n) {

        // n is odd and n = 2k+1
        // option 1: (n+1)/2
        // option 2: (n-1)/2
        // for any odd number, it can end as b...011 or b...001
        // after adding one or minus 1
        // it becomes b..100  b...010
        // or b...000 b...010
        // we should always avoid the one that ends as b...010 because after we divide it by 2. we will need to deal with
        // 1 again. so we should go for the one that ends with 00, which means we can divide 2 twice, that is, the one
        // that can be divided by 4

        // 3 is a special case since the goal is to reduce the number to 1, but either operation(+1 or -1) will generate
        // the same result.


        if(n==1) return counter;
        if(n==Integer.MAX_VALUE) return 32;
        counter++;
        if(n%2==0){
            return integerReplacement(n/2);
        }else if((n+1)%4==0 && n!=3){
            return integerReplacement((n+1));
        }else{
            return integerReplacement(n-1);
        }


    }
}
