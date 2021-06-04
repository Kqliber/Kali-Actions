package me.kaliber.actionutil.actions.messages

import me.kaliber.actionutil.base.Action
import org.bukkit.entity.Player

class PlayerMessage : Action
{

    override val id = "message"
    override val aliases = listOf("message", "msg")

    override fun run(player: Player, action: String)
    {
        player.sendMessage(action)
    }

}
