package solipingen.progressivearchery.entity.projectile.kid_arrow;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;
import solipingen.progressivearchery.entity.ModEntityTypes;
import solipingen.progressivearchery.item.ModItems;
import solipingen.progressivearchery.util.interfaces.mixin.entity.LivingEntityInterface;


public class FlintKidArrowEntity extends KidArrowEntity {
    private static final double DAMAGE_AMOUNT = 2.5;

    
    public FlintKidArrowEntity(EntityType<? extends FlintKidArrowEntity> entityType, World world) {
        super(entityType, DAMAGE_AMOUNT, world);
    }

    public FlintKidArrowEntity(World world, double x, double y, double z) {
        super(ModEntityTypes.FLINT_KID_ARROW_ENTITY, DAMAGE_AMOUNT, world, x, y, z);
    }

    public FlintKidArrowEntity(World world, LivingEntity owner) {
        super(ModEntityTypes.FLINT_KID_ARROW_ENTITY, DAMAGE_AMOUNT, world, owner);
    }

    @Override
    protected ItemStack asItemStack() {
        return new ItemStack(ModItems.FLINT_KID_ARROW);
    }

    @Override
    public void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
        if (entityHitResult.getEntity() instanceof LivingEntity) {
            LivingEntity livingEntity = (LivingEntity)entityHitResult.getEntity();
            LivingEntityInterface iLivingEntity = (LivingEntityInterface)livingEntity;
            iLivingEntity.setStuckFlintKidArrowCount(iLivingEntity.getStuckFlintKidArrowCount() + 1);
        }
    }

    
}
