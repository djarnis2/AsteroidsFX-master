package spaceship;

import dk.sdu.mmmi.cbse.common.bullet.BulletSPI;
import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;

import java.util.Collection;
import java.util.ServiceLoader;

import static java.util.stream.Collectors.toList;


public class EnemySpaceShipControlSystem implements IEntityProcessingService {

    @Override
    public void process(GameData gameData, World world) {
        int rand = (int)(Math.random()*80 + 1);
            
        for (Entity enemy : world.getEntities(EnemySpaceShip.class)) {
            if (rand == 1) {
                enemy.setRotation(enemy.getRotation() - 5);                
            }
            if (rand == 2) {
                enemy.setRotation(enemy.getRotation() + 5);                
            }
            if (rand == 3) {
                double changeX = Math.cos(Math.toRadians(enemy.getRotation()));
                double changeY = Math.sin(Math.toRadians(enemy.getRotation()));
                enemy.setX(enemy.getX() + changeX);
                enemy.setY(enemy.getY() + changeY);
            }
            if(rand == 4) {
                getBulletSPIs().stream().findFirst().ifPresent(
                        spi -> {world.addEntity(spi.createBullet(enemy, gameData));}
                );
            }
            
        if (enemy.getX() < 0) {
            enemy.setX(1);
        }

        if (enemy.getX() > gameData.getDisplayWidth()) {
            enemy.setX(gameData.getDisplayWidth()-1);
        }

        if (enemy.getY() < 0) {
            enemy.setY(1);
        }

        if (enemy.getY() > gameData.getDisplayHeight()) {
            enemy.setY(gameData.getDisplayHeight()-1);
        }

                                        
        }
    }

    private Collection<? extends BulletSPI> getBulletSPIs() {

        return ServiceLoader.load(BulletSPI.class).stream()
                .map(ServiceLoader.Provider::get)
                .collect(toList());
    }
}
