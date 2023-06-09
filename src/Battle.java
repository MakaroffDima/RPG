import java.util.Random;
import java.util.Scanner;

public class Battle implements Runnable {

    private final Character hero;

    public Battle(Character hero) {
        this.hero = hero;
    }

    public void fight(Character hero) throws InterruptedException {
        Character enemy = getEnemy();
        while (hero.getHealth() > 0 && enemy.getHealth() > 0) {
            Thread.sleep(1000);
            if (enemy.getDexterity() >= hero.getDexterity()) {
                enemy.attack(hero);
                if (hero.getHealth() > 0) {
                    hero.attack(enemy);
                }
            } else {
                hero.attack(enemy);
                if (enemy.getHealth() > 0) {
                    enemy.attack(hero);
                }
            }
        }
        if (!enemy.isAlive()) {
            hero.setGold(hero.getGold() + enemy.getGold());
            hero.setExp(hero.getExp() + enemy.getExp());
            System.out.println("Вы победили!!!!\nВы получили золота " + enemy.getGold() + " \nВы получили опыта " + enemy.getExp());
            System.out.println("Теперь у вас " + hero.getGold() + " золота " + " и " + hero.getExp() + " опыта");
            System.out.println("Желаете продолжить поход или вернуться в город? (да- продолжить / нет- вернуться в город)");
            Scanner sc = new Scanner(System.in);
            String choice;
            boolean switchOn = true;
            do {
                choice = sc.nextLine();
                switch (choice) {
                    case "да":
                        Thread thread = new Thread(new Battle(hero));
                        thread.start();
                        thread.join();
                        break;
                    case "нет":
                        return;
                    default:
                        System.out.println("Неверный ввод");
                        return;
                }
            } while (switchOn);


        } else {
            System.out.println("Вы повержены!!! Game Over");
            System.exit(1);
        }
    }

    private Character getEnemy() {
        Character enemy;
        switch (new Random().nextInt(10) % 2) {
            case 0:
                System.out.println("Вам на пути встретился гоблин");
                enemy = new Goblin("Goblin", 30, 100, 15, 10, 30);
                break;
            case 1:
                System.out.println("Вам на пути встретился скелет");
                enemy = new Skelet("Skelet", 30, 100, 10, 5, 15);
                break;
            default:
                throw new EnemyCreationException("Вам не встретилось врагов");

        }
        return enemy;
    }

    @Override
    public void run() {
        try {
            fight(hero);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}







