import java.util.Scanner;

public class Main {
    public static void printMap() {
        System.out.println("Куда вы хотите пойти?");
        System.out.println("1. К Торговцу");
        System.out.println("2. В темный лес");
        System.out.println("3. Выход");
        System.out.println("4. Опыт и золото персонажа");
    }

    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите имя своего персонажа");
        String name = sc.nextLine();


        Character hero = new Hero(name, 30, 100, 0, 20, 0);
        while (hero.isAlive()) {
            printMap();
            String path = sc.nextLine();
            switch (path) {
                case "1":
                    System.out.println("Торговец еще не приехал");
                    break;
                case "2":
                    System.out.println("Да начнётся битва!");
                    Thread thread = new Thread(new Battle(hero));
                    thread.start();
                    thread.join();
                    break;
                case "3":
                    System.out.println("До встречи в игре!");
                    return;
                case "4":
                    System.out.println("У вас " + hero.getGold() + " золота " + " и " + hero.getExp() + " опыта ");
                    break;

                default:
                    System.out.println("Неправильный ввод");
            }
        }
    }
}
