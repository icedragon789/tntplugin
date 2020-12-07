package com.bplaczek;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;

public class TestCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return true;
        }
        Player player = (Player) sender;
        Bukkit.broadcastMessage(ChatColor.DARK_RED + "Boom");

        TNTPrimed tnt = player.getWorld().spawn(player.getEyeLocation(), TNTPrimed.class);
        tnt.setVelocity(player.getLocation().getDirection().multiply(300));

        return true;
    }


}
