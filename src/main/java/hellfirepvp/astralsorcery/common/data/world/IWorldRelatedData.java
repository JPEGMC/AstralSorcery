package hellfirepvp.astralsorcery.common.data.world;

import net.minecraft.nbt.NBTTagCompound;

/**
 * This class is part of the Astral Sorcery Mod
 * The complete source code for this mod can be found on github.
 * Class: IWorldRelatedData
 * Created by HellFirePvP
 * Date: 12.08.2016 / 11:33
 */
public interface IWorldRelatedData {

    public void readFromNBT(NBTTagCompound compound);

    public void writeToNBT(NBTTagCompound compound);

}
