package cubex2.cs4.plugins.vanilla;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import net.minecraft.util.EnumFacing;

import java.lang.reflect.Type;

class EnumFacingDeserializer implements JsonDeserializer<EnumFacing>
{
    @Override
    public EnumFacing deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException
    {
        return EnumFacing.byName(json.getAsString());
    }
}
