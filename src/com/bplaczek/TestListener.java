package com.bplaczek;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class TestListener implements Listener {

    public TestListener(Test plugin){}

    //variable if you want to trace tnt spawns for no reason
    static int myTntCount = 0;

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event)
    {
        Bukkit.broadcastMessage("Welcome to the server!");
    }


    @EventHandler
    public void onTNTBoomBoom(EntityExplodeEvent event) {

        Location location = event.getLocation();
        Bukkit.broadcastMessage("TNT DETONATED at X: " + location.getX() + "Y: " + location.getY() + "Z: " + location.getZ());

        if (event.getEntity() instanceof TNTPrimed) {
            if (event.isCancelled()) return;
            Entity entity = event.getEntity();
            entity.getWorld();
            TNTPrimed tnt = entity.getWorld().spawn(location, TNTPrimed.class);
            tnt.setVelocity(location.getDirection().multiply(150));
        }

    }
}
