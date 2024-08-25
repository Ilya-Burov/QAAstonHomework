public class Cat extends Animal {
    private static int catCount = 0;
    private boolean isFull;
    public Cat(String name) {
        super(name, 200, 0);
        this.isFull = false;
        catCount++;
    }
    @Override
    public void swim(int distance) {
        System.out.println(name + " не умеет плавать");
    }
    public void eat(Bowl bowl, int foodAmount) {
        if (bowl.getFood() >= foodAmount) {
            bowl.decreaseFood(foodAmount);
            this.isFull = true;
            System.out.println(name + " покушал и теперь сыт");
        } else {
            System.out.println(name + " не хватает еды, он остался голоден");
        }
    }
    public boolean isFull() {
        return isFull;
    }
    public static int getCatCount() {
        return catCount;
    }
}
