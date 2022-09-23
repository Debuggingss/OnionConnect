package dev.debuggings.onionconnect.mixins;

import dev.debuggings.onionconnect.OnionConnect;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(targets = "net.minecraft.client.multiplayer.GuiConnecting$1")
public class MixinGuiConnecting {

    @ModifyArg(method = "run", at = @At(value = "INVOKE", target = "Ljava/net/InetAddress;getByName(Ljava/lang/String;)Ljava/net/InetAddress;"))
    private String onionconnect$skipInetAdressResolve(String ip) {
        OnionConnect.Companion.getConnectingIP().set(ip);
        return "127.0.0.1";
    }
}
