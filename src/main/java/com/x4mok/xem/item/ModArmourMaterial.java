package com.x4mok.xem.item;

import com.x4mok.xem.XEM;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.function.Supplier;

public enum ModArmourMaterial implements IArmorMaterial {

    DRAGON("dragon", 45, new int[]{4, 7, 9, 5}, 16, SoundEvents.ARMOR_EQUIP_NETHERITE, 5.0F, 0.3F, () -> {
        return Ingredient.of(ModItems.DRAGONSCALE.get());
    }),
    COPPER("copper", 15, new int[]{3, 5, 5, 3}, 10, SoundEvents.ARMOR_EQUIP_IRON, 0.5F, 0.0F, () -> {
        return Ingredient.of(ModItems.COPPERINGOT.get());
    }),
    ALUMINIUM("aluminium", 13, new int[]{3, 4, 4, 2}, 30, SoundEvents.ARMOR_EQUIP_IRON, 0.4F, 0.0F, () -> {
        return Ingredient.of(ModItems.ALUMINIUMINGOT.get());
    }),
    STEEL("steel", 30, new int[]{3, 5, 6, 4}, 9, SoundEvents.ARMOR_EQUIP_IRON, 0.5F, 0.01F, () -> {
        return Ingredient.of(ModItems.STEELINGOT.get());
    }),
    DIVINE("divine", 60, new int[]{6,8,9,6}, 32, SoundEvents.ARMOR_EQUIP_TURTLE, 5.5F, 0.5F, () -> {
        return Ingredient.of(ModItems.DIVINEINGOT.get());
    }),
    ANCIENT("ancient", 75, new int[]{7,9,10,7}, 24, SoundEvents.ARMOR_EQUIP_NETHERITE, 6.0F, 0.6F, () -> {
        return Ingredient.of(ModItems.ANCIENTINGOT.get());
    });
    private static final int[] HEALTH_PER_SLOT = new int[]{13, 15, 16, 11};
    private final String name;
    private final int durabilityMultiplier;
    private final int[] slotProtections;
    private final int enchantmentValue;
    private final SoundEvent sound;
    private final float toughness;
    private final float knockbackResistance;
    private final LazyValue<Ingredient> repairIngredient;

    private ModArmourMaterial(String pName, int pDurabilityMultiplier, int[] pSlotProtections,
                              int pEnchantmentValue, SoundEvent pSound, float pToughness,
                              float pKnockbackResistance, Supplier<Ingredient> pRepairIngredient) {
        this.name = pName;
        this.durabilityMultiplier = pDurabilityMultiplier;
        this.slotProtections = pSlotProtections;
        this.enchantmentValue = pEnchantmentValue;
        this.sound = pSound;
        this.toughness = pToughness;
        this.knockbackResistance = pKnockbackResistance;
        this.repairIngredient = new LazyValue<>(pRepairIngredient);
    }



    public int getDurabilityForSlot(EquipmentSlotType pSlot) {
        return HEALTH_PER_SLOT[pSlot.getIndex()] * this.durabilityMultiplier;
    }

    public int getDefenseForSlot(EquipmentSlotType pSlot) {
        return this.slotProtections[pSlot.getIndex()];
    }

    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    public SoundEvent getEquipSound() {
        return this.sound;
    }

    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    @OnlyIn(Dist.CLIENT)
    public String getName() {
        return XEM.MODID + ":" + this.name;
    }

    public float getToughness() {
        return this.toughness;
    }


    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}
