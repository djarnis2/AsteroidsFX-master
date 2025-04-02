import dk.sdu.mmmi.cbse.common.bullet.BulletSPI;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;

module EnemyBullet {
    exports dk.sdu.mmmi.cbse.enemy.bulletsystem;
    requires Common;
    requires CommonBullet;
    provides BulletSPI with dk.sdu.mmmi.cbse.enemy.bulletsystem.EnemyBullet;
    provides IEntityProcessingService with dk.sdu.mmmi.cbse.enemy.bulletsystem.EnemyBulletControlSystem;
}