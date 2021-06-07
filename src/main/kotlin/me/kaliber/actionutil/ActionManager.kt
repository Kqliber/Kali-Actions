package me.kaliber.actionutil

import me.kaliber.actionutil.actions.messages.registry.PlayerActionsRegistry
import me.kaliber.actionutil.actions.cmds.registry.CommandActionsRegistry
import me.kaliber.actionutil.actions.misc.registry.MiscActionsRegistry
import me.kaliber.actionutil.base.Action
import org.bukkit.entity.Player
import org.bukkit.plugin.Plugin

class ActionManager(private val plugin: Plugin, defaults: Boolean = true)
{

    init
    {
        if (defaults)
        {
            registerDefaults()
        }
    }

    private val actions = mutableMapOf<String, Action>()

    private val actionHandler = ActionHandler(this, plugin)

    private val defaultsList = listOf(
        CommandActionsRegistry(this),
        PlayerActionsRegistry(this),
        MiscActionsRegistry(this)
    )

    operator fun get(actionId: String): Action?
    {
        return actions[actionId]
    }

    operator fun minusAssign(actionId: String)
    {
        actions -= actionId
    }

    fun register(action: Action)
    {
        actions[action.id] = action
    }

    private fun registerDefaults()
    {
        defaultsList.forEach { it.register(plugin) }
    }

    fun execute(player: Player, data: String)
    {
        actionHandler.executeAction(player, data)
    }

    fun execute(player: Player, data: List<String>)
    {
        data.forEach { execute(player, it) }
    }

}
