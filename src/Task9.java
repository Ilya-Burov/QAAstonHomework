public class Task9 {
    boolean isLeapYear(int year){
        if((year%4==0&&year%100!=0)||(year%400==0)){
            System.out.println("Год високосный");
            return true;

        } else{
            System.out.println("Год не високосный");
            return false;
        }
    }
}
