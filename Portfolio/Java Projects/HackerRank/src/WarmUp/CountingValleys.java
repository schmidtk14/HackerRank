package WarmUp;

public class CountingValleys {
    /*
     * Complete the 'countingValleys' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER steps
     *  2. STRING path
     */

    public static int countingValleys(int steps, String path) {
        // Write your code here
        int valleyCount = 0;
        int elevation = 0;
        boolean valleyStarted = false;
        for(int i = 0; i< steps; i++){
            char c = path.charAt(i);
            if(c=='D'){
                elevation -=1;
            }
            if(c=='D'&&(elevation==-1)){
                valleyStarted=true;
            }
            else if(c=='U'){
                elevation +=1;
            }
            if(valleyStarted &&(elevation==0)){
                valleyCount+=1;
                valleyStarted = false;
            }
        }
        return valleyCount;

    }

}


