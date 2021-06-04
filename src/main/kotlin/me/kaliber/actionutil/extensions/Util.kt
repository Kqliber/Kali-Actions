package me.kaliber.actionutil.extensions

import me.clip.placeholderapi.PlaceholderAPI
import org.bukkit.entity.Player
import org.bukkit.plugin.Plugin
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import java.util.logging.Level

fun Plugin.runTask(task: () -> Unit)
{
    Bukkit.getScheduler().runTask(this, task)
}

const val PREFIX = "[Kali-Actions]"
fun String.log(plugin: Plugin)
{
    plugin.logger.log(Level.WARNING, "$PREFIX $this")
}

fun String.format(player: Player): String
{
    return colour().replacePlaceholders(player)
}

private fun String.colour(): String
{
    return ChatColor.translateAlternateColorCodes('&', this)
}

private fun String.replacePlaceholders(player: Player): String
{
    if (Bukkit.getPluginManager().isPluginEnabled("PlaceholderAPI"))
    {
       return PlaceholderAPI.setPlaceholders(player, this)
    }
    return this
}
