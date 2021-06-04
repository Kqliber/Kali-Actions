package me.kaliber.actionutil.actions.cmds.registry

import me.kaliber.actionutil.actions.cmds.ConsoleCommand
import me.kaliber.actionutil.actions.cmds.PlayerCommand
import me.kaliber.actionutil.base.Registerable
import me.kaliber.actionutil.ActionManager
import org.bukkit.plugin.Plugin

class CommandActionsRegistry(private val manager: ActionManager) : Registerable
{

    override fun register(plugin: Plugin)
    {
        listOf(
            ConsoleCommand(plugin),
            PlayerCommand(plugin)
        ).forEach(manager::register)
    }

}
