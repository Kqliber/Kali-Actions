package me.kaliber.actionutil

import me.kaliber.actionutil.extensions.format
import me.kaliber.actionutil.extensions.log
import org.bukkit.entity.Player
import org.bukkit.plugin.Plugin

class ActionHandler(private val manager: ActionManager, private val plugin: Plugin)
{

    fun executeAction(player: Player, line: String)
    {
        val id = line.substringAfter('[').substringBefore(']').lowercase()
        val action = manager[id] ?: return "[$id] is not a valid action identifier!".log(plugin)
        val data = line.substringAfter(']').trim().format(player)

        action.run(player, data)
    }

}
