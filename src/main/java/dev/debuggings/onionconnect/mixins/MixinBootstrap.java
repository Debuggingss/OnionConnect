package dev.debuggings.onionconnect.mixins;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Bootstrap.class)
public class MixinBootstrap {

    @Inject(method = "checkAddress", at = @At("HEAD"), cancellable = true, remap = false)
    private void checkAddress(CallbackInfoReturnable<ChannelFuture> cir) {
        cir.setReturnValue(null);
    }
}
