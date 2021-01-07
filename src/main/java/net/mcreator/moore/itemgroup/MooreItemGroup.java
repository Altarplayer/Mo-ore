
package net.mcreator.moore.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.moore.item.PlatiniumingotItem;
import net.mcreator.moore.MooreModElements;

@MooreModElements.ModElement.Tag
public class MooreItemGroup extends MooreModElements.ModElement {
	public MooreItemGroup(MooreModElements instance) {
		super(instance, 13);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabmoore") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(PlatiniumingotItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
