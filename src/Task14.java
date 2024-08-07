public class Task14 {
    int[] createarray(int len, int initialValue){
        var newArray = new int[len];
        for(int i =0; i<len; i++){
            newArray[i] = initialValue;
        }
        return newArray;
    }
}
