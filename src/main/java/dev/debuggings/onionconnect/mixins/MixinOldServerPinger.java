package dev.debuggings.onionconnect.mixins;

import dev.debuggings.onionconnect.OnionConnect;
import net.minecraft.client.network.OldServerPinger;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(OldServerPinger.class)
public class MixinOldServerPinger {

    @ModifyArg(method = "ping", at = @At(value = "INVOKE", target = "Ljava/net/InetAddress;getByName(Ljava/lang/String;)Ljava/net/InetAddress;"))
    private String onionconnect$skipInetAdressResolve(String ip) {
        OnionConnect.Companion.getConnectingIP().set(ip);
        return "127.0.0.1";
    }
}
