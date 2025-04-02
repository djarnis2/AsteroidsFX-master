import dk.sdu.mmmi.cbse.common.bullet.BulletSPI;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;

module Bullet {
    requires Common;
    requires CommonBullet;
    requires EnemyBullet;
    exports dk.sdu.mmmi.cbse.bulletsystem;
    provides IGamePluginService with dk.sdu.mmmi.cbse.bulletsystem.BulletPlugin;
    provides BulletSPI with dk.sdu.mmmi.cbse.bulletsystem.PlayerBullet;
    provides IEntityProcessingService with dk.sdu.mmmi.cbse.bulletsystem.BulletControlSystem;

}