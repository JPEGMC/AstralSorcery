package hellfirepvp.astralsorcery.common.network;

import hellfirepvp.astralsorcery.AstralSorcery;
import hellfirepvp.astralsorcery.common.network.packet.client.PktDiscoverConstellation;
import hellfirepvp.astralsorcery.common.network.packet.server.PktCraftingTableFix;
import hellfirepvp.astralsorcery.common.network.packet.server.PktParticleEvent;
import hellfirepvp.astralsorcery.common.network.packet.server.PktSyncConfig;
import hellfirepvp.astralsorcery.common.network.packet.server.PktSyncData;
import hellfirepvp.astralsorcery.common.network.packet.server.PktSyncKnowledge;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

/**
 * This class is part of the Astral Sorcery Mod
 * The complete source code for this mod can be found on github.
 * Class: PacketChannel
 * Created by HellFirePvP
 * Date: 07.05.2016 / 01:11
 */
public class PacketChannel {

    public static final SimpleNetworkWrapper CHANNEL = NetworkRegistry.INSTANCE.newSimpleChannel(AstralSorcery.NAME);

    public static void init() {
        int id = 0;

        //Synchronizing data (server -> client)
        CHANNEL.registerMessage(PktSyncConfig.class, PktSyncConfig.class, id++, Side.CLIENT); //General config sync
        CHANNEL.registerMessage(PktSyncKnowledge.class, PktSyncKnowledge.class, id++, Side.CLIENT); //Knowledge data sync
        CHANNEL.registerMessage(PktSyncData.class, PktSyncData.class, id++, Side.CLIENT); //General dataholder sync
        CHANNEL.registerMessage(PktParticleEvent.class, PktParticleEvent.class, id++, Side.CLIENT); //Generic particle event
        CHANNEL.registerMessage(PktCraftingTableFix.class, PktCraftingTableFix.class, id++, Side.CLIENT); //Sends a crafting table GUI-open packet that has a gui with proper data.

        //Constellation discovery (client -> server)
        CHANNEL.registerMessage(PktDiscoverConstellation.class, PktDiscoverConstellation.class, id++, Side.SERVER); //discover a constellation in gui and inform server.
    }

    public static NetworkRegistry.TargetPoint pointFromPos(World world, BlockPos pos, double range) {
        return new NetworkRegistry.TargetPoint(world.provider.getDimension(), pos.getX(), pos.getY(), pos.getZ(), range);
    }

}
