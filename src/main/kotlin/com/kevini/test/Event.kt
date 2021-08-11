package com.kevini.test

import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerQuitEvent
import org.bukkit.event.player.PlayerSwapHandItemsEvent
import org.bukkit.inventory.ItemStack

class Event : Listener {
    @Suppress("DEPRECATION")
    @EventHandler
    fun join(e: PlayerJoinEvent) {
        val p = e.player
        e.joinMessage = "§f[§a+§f] ${p.name} 가 접속했습니다"
    }

    @Suppress("DEPRECATION")
    @EventHandler
    fun quit(e: PlayerQuitEvent) {
        val p = e.player
        e.quitMessage = "§f[§c-§f] ${p.name} 가 퇴장했습니다"
    }

    @Suppress("DEPRECATION")
    @EventHandler
    fun menu(e: PlayerSwapHandItemsEvent){
        val p = e.player
        if (p.isSneaking) {
            e.isCancelled = true
            val inv = Bukkit.createInventory(null, 27, "메뉴")
            /*val i1 = ItemStack(Material.PUFFERFISH)
            val i1meta = i1.itemMeta
            i1meta.setDisplayName("§a복어 확인")
            i1meta.lore = arrayListOf("§f가진 복어를 확인합니다.","§f복어는 낚시를 하거나, 어망을 획득하면","§f자연스레 획득할 수 있습니다.","","§e클릭시 확인합니다.")
            i1.itemMeta = i1meta
            inv.setItem(13, i1)*/

            val lore = arrayListOf("§f가진 지식을 확인합니다.","지식은 책을 읽거나, 경험을 쌓으면","자연스레 획득할 수 있습니다.","§e클릭 시 확인합니다.")
            val item1 = Util.guiitem(Material.BOOK, 1, "§a지식 확인", lore, 1)
            inv.setItem(13, item1)

            // 장식용 창 만들기
            val list = arrayListOf(3,4,5,12,14,21,22,23)
            val itemDeco = Util.guiitem(Material.WHITE_STAINED_GLASS_PANE, 1, "§o", arrayListOf("",""), 1)
            for (n in list){
                inv.setItem(n, itemDeco)
            }



            p.openInventory(inv)

            /*for (n in arrayOf(3,4,5,12,14,21,22,23)) {
                val i2 = ItemStack(Material.YELLOW_STAINED_GLASS_PANE)
                val i2meta = i2.itemMeta
                i2meta.setDisplayName("abc")
                i2.itemMeta = i2meta
                inv.setItem(n, i2)
            }*/
        }
    }
    

    }

    @Suppress("DEPRECATION")
    @EventHandler
    fun invclick(e: InventoryClickEvent){
        val p = e.whoClicked
        if (e.view.title==("메뉴")){
            e.isCancelled = true
        }
    }