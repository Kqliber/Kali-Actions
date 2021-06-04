package me.kaliber.actionutil.actions.misc

import me.kaliber.actionutil.base.Action
import me.kaliber.actionutil.extensions.log
import org.bukkit.entity.Player
import org.bukkit.plugin.Plugin

const val SOUND_FORMAT = "[SOUND] <SOUND>;<VOLUME>;<PITCH>"

class PlaySound(private val plugin: Plugin) : Action
{
    override val id = "sound"
    override val aliases = listOf("sound", "playsound")

    override fun run(player: Player, action: String)
    {
        val (sound, volume, pitch) = action.split(';').takeIf { it.size >= 3 }
            ?: return "please enter a sound in the valid format: $SOUND_FORMAT".log(plugin)

        player.playSound(player.location, sound, volume.toFloat(), pitch.toFloat())
    }
}
