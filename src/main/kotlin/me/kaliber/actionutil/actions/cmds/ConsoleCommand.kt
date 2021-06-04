package me.kaliber.actionutil.actions.cmds

import me.kaliber.actionutil.base.Action
import me.kaliber.actionutil.extensions.runTask
import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.bukkit.plugin.Plugin

class ConsoleCommand(private val plugin: Plugin) : Action
{
    override val id = "console"
    override val aliases: List<String> = listOf("console", "consolecommand")

    override fun run(player: Player, action: String)
    {
        plugin.runTask { Bukkit.dispatchCommand(Bukkit.getConsoleSender(), action) }
    }

}
