package dev.debuggings.onionconnect

import net.minecraft.client.gui.GuiMultiplayer
import net.minecraftforge.client.event.GuiScreenEvent
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.fml.client.config.GuiCheckBox
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.event.FMLInitializationEvent
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent

@Mod(
    modid = OnionConnect.MOD_ID,
    name = OnionConnect.MOD_NAME,
    version = OnionConnect.VERSION
)
class OnionConnect {

    companion object {
        const val MOD_ID = "onionconnect"
        const val MOD_NAME = "OnionConnect"
        const val VERSION = "1.0"
        val connectingIP: ThreadLocal<String> = ThreadLocal()
        var toggleProxy = false
    }

    @Mod.EventHandler
    fun init(event: FMLInitializationEvent) {
        MinecraftForge.EVENT_BUS.register(this)
    }

    @SubscribeEvent
    fun initGui(event: GuiScreenEvent.InitGuiEvent.Post) {
        if (event.gui !is GuiMultiplayer) return

        val checkbox = GuiCheckBox(
            555,
            5,
            5,
            "Toggle Tor Proxy",
            toggleProxy
        )

        event.buttonList.add(checkbox)
    }

    @SubscribeEvent
    fun actionPerformed(event: GuiScreenEvent.ActionPerformedEvent.Post) {
        if (
            event.gui is GuiMultiplayer &&
            event.button is GuiCheckBox &&
            event.button.id == 555
        ) {
            val button = event.button as GuiCheckBox

            toggleProxy = button.isChecked
        }
    }
}
