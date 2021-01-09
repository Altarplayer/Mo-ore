
package net.mcreator.moore.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.item.UseAction;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.Food;
import net.minecraft.entity.LivingEntity;

import net.mcreator.moore.procedures.ColaFoodEatenProcedure;
import net.mcreator.moore.itemgroup.MooreItemGroup;
import net.mcreator.moore.MooreModElements;

import java.util.Map;
import java.util.HashMap;

@MooreModElements.ModElement.Tag
public class ColaItem extends MooreModElements.ModElement {
	@ObjectHolder("moore:cola")
	public static final Item block = null;
	public ColaItem(MooreModElements instance) {
		super(instance, 16);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}
	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(MooreItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON)
					.food((new Food.Builder()).hunger(1).saturation(0.5f).setAlwaysEdible().build()));
			setRegistryName("cola");
		}

		@Override
		public int getUseDuration(ItemStack stack) {
			return 5;
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.DRINK;
		}

		@Override
		public net.minecraft.util.SoundEvent getEatSound() {
			return net.minecraft.util.SoundEvents.ENTITY_GENERIC_DRINK;
		}

		@Override
		public ItemStack onItemUseFinish(ItemStack itemstack, World world, LivingEntity entity) {
			ItemStack retval = super.onItemUseFinish(itemstack, world, entity);
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				ColaFoodEatenProcedure.executeProcedure($_dependencies);
			}
			return retval;
		}
	}
}
