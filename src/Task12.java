public class Task12 {
    void modifyArray(int[] array){
        for(int i = 0; i < array.length;i++) {
            if (array[i]<6) {
                array[i]*=2;
            }
        }
    }
}
