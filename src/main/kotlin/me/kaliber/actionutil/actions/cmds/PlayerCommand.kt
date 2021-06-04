package me.kaliber.actionutil.actions.cmds

import me.kaliber.actionutil.base.Action
import me.kaliber.actionutil.extensions.runTask
import org.bukkit.entity.Player
import org.bukkit.plugin.Plugin

class PlayerCommand(private val plugin: Plugin) : Action
{
    override val id = "player"
    override val aliases = listOf("player", "playercommand")

    override fun run(player: Player, action: String)
    {
        plugin.runTask{ player.chat("/$action") }
    }

}
