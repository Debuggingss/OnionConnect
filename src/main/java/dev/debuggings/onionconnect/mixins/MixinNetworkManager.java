package dev.debuggings.onionconnect.mixins;

import dev.debuggings.onionconnect.OnionConnect;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import net.minecraft.network.NetworkManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.net.InetAddress;

@Mixin(value = NetworkManager.class, priority = 2000)
public class MixinNetworkManager {

    @Redirect(method = "createNetworkManagerAndConnect", at = @At(value = "INVOKE", target = "Lio/netty/bootstrap/Bootstrap;connect(Ljava/net/InetAddress;I)Lio/netty/channel/ChannelFuture;", remap = false))
    private static ChannelFuture onionconnect$redirectConnect(Bootstrap instance, InetAddress inetHost, int inetPort) {
        return instance.connect(OnionConnect.Companion.getConnectingIP().get(), inetPort);
    }
}
