import java.util.Random;

public class Spawner {
    private final Handler handler;
    private final HUD hud;
    private final Random r = new Random();

    public static int enemyCountKeep = 1;

    public Spawner(Handler handler, HUD hud){
        this.handler = handler;
        this.hud = hud;
        hud.setEnemyCount(enemyCountKeep);
        handler.addObject(new Enemy0(r.nextInt(Main.WIDTH), r.nextInt(Main.HEIGHT - 316), ID.Enemy0, handler, hud));
    }

    public void tick (){
        if (enemyCountKeep <= 0){
            hud.setLevel(hud.getLevel() + 1);
            enemyCountKeep = ((hud.getLevel()) * 2);
            hud.setEnemyCount(enemyCountKeep);
            for (int i = 0; i < enemyCountKeep; i++) {
                int a = r.nextInt(4);
                if (a == 0){
                    handler.addObject(new Enemy0(r.nextInt(Main.WIDTH), (r.nextInt(Main.HEIGHT - 316)), ID.Enemy0, handler, hud));
                }
                if (a == 1){
                    handler.addObject(new Enemy1(r.nextInt(Main.WIDTH), (r.nextInt(Main.HEIGHT - 316)), ID.Enemy1, handler, hud));
                }
                if (a == 2){
                    handler.addObject(new Enemy2(r.nextInt(Main.WIDTH), (r.nextInt(Main.HEIGHT - 316)), ID.Enemy2, handler, hud));
                }
                if (a == 3){
                    handler.addObject(new Enemy3(r.nextInt(Main.WIDTH), (r.nextInt(Main.HEIGHT - 316)), ID.Enemy3, handler, hud));
                }


            }
        }
    }


}
