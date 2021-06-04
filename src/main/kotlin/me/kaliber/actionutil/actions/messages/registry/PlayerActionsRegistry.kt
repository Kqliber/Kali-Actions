package me.kaliber.actionutil.actions.messages.registry

import me.kaliber.actionutil.ActionManager
import me.kaliber.actionutil.actions.messages.PlayerMessage
import me.kaliber.actionutil.base.Registerable
import org.bukkit.plugin.Plugin

class PlayerActionsRegistry(private val manager: ActionManager) : Registerable
{

    override fun register(plugin: Plugin)
    {
        listOf(
            PlayerMessage()
        ).forEach(manager::register)
    }

}
