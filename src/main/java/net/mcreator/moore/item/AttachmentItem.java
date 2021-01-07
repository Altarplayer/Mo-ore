
package net.mcreator.moore.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.mcreator.moore.itemgroup.MooreItemGroup;
import net.mcreator.moore.MooreModElements;

@MooreModElements.ModElement.Tag
public class AttachmentItem extends MooreModElements.ModElement {
	@ObjectHolder("moore:attachment")
	public static final Item block = null;
	public AttachmentItem(MooreModElements instance) {
		super(instance, 7);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(MooreItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("attachment");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}
	}
}
