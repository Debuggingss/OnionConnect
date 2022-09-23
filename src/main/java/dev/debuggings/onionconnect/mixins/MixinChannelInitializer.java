package dev.debuggings.onionconnect.mixins;

import dev.debuggings.onionconnect.OnionConnect;
import io.netty.channel.Channel;
import io.netty.handler.proxy.Socks5ProxyHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.net.InetSocketAddress;

@Mixin(targets = "net.minecraft.network.NetworkManager$5")
public class MixinChannelInitializer {

    @Inject(method = "initChannel", at = @At("HEAD"), remap = false)
    private void onionconnect$initChannel(Channel p_initChannel_1_, CallbackInfo ci) {
        if (!OnionConnect.Companion.getToggleProxy()) return;
        p_initChannel_1_.pipeline().addFirst(new Socks5ProxyHandler(new InetSocketAddress("127.0.0.1", 9050)));
    }
}
