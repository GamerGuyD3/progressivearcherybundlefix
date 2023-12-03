package solipingen.progressivearchery.advancement.criterion.shot_bow;

import java.util.Optional;

import com.google.gson.JsonObject;

import net.minecraft.advancement.criterion.AbstractCriterion;
import net.minecraft.item.ItemStack;
import net.minecraft.predicate.entity.AdvancementEntityPredicateDeserializer;
import net.minecraft.predicate.entity.LootContextPredicate;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;
import solipingen.progressivearchery.ProgressiveArchery;


public class ShotTubularBowCriterion extends AbstractCriterion<ShotTubularBowConditions> {
    public static final Identifier ID = new Identifier(ProgressiveArchery.MOD_ID, "shot_tubular_bow");


    @Override
    public ShotTubularBowConditions conditionsFromJson(JsonObject jsonObject, Optional<LootContextPredicate> extended, AdvancementEntityPredicateDeserializer advancementEntityPredicateDeserializer) {
        Optional<ItemPredicate> itemPredicate = ItemPredicate.fromJson(jsonObject.get("item"));
        return new ShotTubularBowConditions(extended, itemPredicate);
    }

    public void trigger(ServerPlayerEntity player, ItemStack stack) {
        this.trigger(player, (conditions) -> conditions.matches(stack));
    }
    
}
