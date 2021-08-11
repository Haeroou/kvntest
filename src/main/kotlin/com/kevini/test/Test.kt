package com.kevini.test

import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin

class Test : JavaPlugin() {
    override fun onEnable() {
        server.pluginManager.registerEvents(Event(), this)
        Bukkit.getLogger().info("§f[§e 무언가 서버가 켜진듯한 연출 §f]")
    }

    override fun onDisable() {
    }
}