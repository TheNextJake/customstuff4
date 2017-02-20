package cubex2.cs4.plugins.vanilla;

import cubex2.cs4.api.*;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;

@CS4Plugin
public class VanillaPlugin implements CustomStuffPlugin
{
    @Override
    public void registerContent(ContentRegistry registry)
    {
        registry.registerDeserializer(ResourceLocation.class, new ResourceLocationDeserializer());
        registry.registerDeserializer(WrappedItemStack.class, new WrappedItemStackDeserializer());
        registry.registerDeserializer(RecipeInput.class, new RecipeInputDeserializer());
        registry.registerDeserializer(NBTTagCompound.class, new NBTTagCompoundDeserializer());

        registry.registerDeserializer(ShapedRecipe.class, ShapedRecipe.DESERIALIZER);
        registry.registerContentType("shapedRecipe", ShapedRecipe.class);

        registry.registerDeserializer(ShapelessRecipe.class, ShapelessRecipe.DESERIALIZER);
        registry.registerContentType("shapelessRecipe", ShapelessRecipe.class);

        registry.registerContentType("smeltingRecipe", SmeltingRecipe.class);
        registry.registerContentType("fuel", Fuel.class);
        registry.registerContentType("oreDict", OreDictionaryEntry.class);
        registry.registerContentType("toolTip", ToolTip.class);
        registry.registerContentType("guiModifier", GuiModifier.class);
    }
}
