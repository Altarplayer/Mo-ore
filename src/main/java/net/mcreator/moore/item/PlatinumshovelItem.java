
package net.mcreator.moore.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.mcreator.moore.itemgroup.MooreItemGroup;
import net.mcreator.moore.MooreModElements;

@MooreModElements.ModElement.Tag
public class PlatinumshovelItem extends MooreModElements.ModElement {
	@ObjectHolder("moore:platinumshovel")
	public static final Item block = null;
	public PlatinumshovelItem(MooreModElements instance) {
		super(instance, 15);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ShovelItem(new IItemTier() {
			public int getMaxUses() {
				return 1000;
			}

			public float getEfficiency() {
				return 10.5f;
			}

			public float getAttackDamage() {
				return 3f;
			}

			public int getHarvestLevel() {
				return 4;
			}

			public int getEnchantability() {
				return 10;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(PlatiniumingotItem.block, (int) (1)));
			}
		}, 1, -2f, new Item.Properties().group(MooreItemGroup.tab)) {
		}.setRegistryName("platinumshovel"));
	}
}
