import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;

module EnemySpaceShip {
    requires Common;
    requires CommonBullet;
    requires EnemyBullet;
    uses dk.sdu.mmmi.cbse.common.bullet.BulletSPI;
    provides IGamePluginService with spaceship.EnemySpaceShipPlugin;
    provides IEntityProcessingService with spaceship.EnemySpaceShipControlSystem;
}