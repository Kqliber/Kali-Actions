package me.kaliber.actionutil.actions.misc.registry

import me.kaliber.actionutil.ActionManager
import me.kaliber.actionutil.actions.misc.PlaySound
import me.kaliber.actionutil.base.Registerable
import org.bukkit.plugin.Plugin

class MiscActionsRegistry(private val manager: ActionManager) : Registerable
{

    override fun register(plugin: Plugin)
    {
        listOf(
            PlaySound(plugin)
        ).forEach(manager::register)
    }

}
