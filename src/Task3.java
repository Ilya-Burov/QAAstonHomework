public class Task3 {
    void printColor(){
        int value = 1;
        if(value<=0){
            System.out.println("Красный");
        } else if(value>0&&value<=100){
            System.out.println("Жёлтый");
        } else if(value>100){
            System.out.println("Зелёный");

        }
    }
}
