
public class Sample{
/********************PROBLEM-1*****************/
//TC:0(Nlog(high-low))
//SC:0(N)
class Solution {
    int[] weights;
    public int shipWithinDays(int[] weights, int days) {
        if(weights==null || weights.length==0){
            return 0;
        }
        this.weights=weights;
        int max=0,sum=0,calcDays=0;
        for(int weight:weights){
            max=Math.max(max,weight);
            sum+=weight;
        }

        int low=max,high=sum;

        while(low<=high){
            int mid=low+(high-low)/2;
            if(calcDays(mid)>days){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return low;
    }


    private int calcDays(int max){
        int sumCalc=0,days=0;
        for(int weight:weights){
            sumCalc+=weight;
            if(sumCalc>max){
                days++;
                sumCalc=weight;
            }
        }
        int remainder=(sumCalc>max)?0:1;
        return days+remainder;
    }
}
/********************PROBLEM-2*****************/
}