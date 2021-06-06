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

    fun register(action: Action)
    {
        actions[action.id] = action
    }

    private fun registerDefaults()
    {
        defaultsList.forEach { it.register(plugin) }
    }

    fun String.execute(player: Player)
    {
        actionHandler.executeAction(player, this)
    }

    fun List<String>.execute(player: Player)
    {
        forEach { it.execute(player) }
    }

}
