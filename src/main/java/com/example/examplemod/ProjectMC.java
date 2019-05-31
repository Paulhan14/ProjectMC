package com.example.examplemod;

import com.example.examplemod.proxy.CommonProxy;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = ProjectMC.MODID, name = ProjectMC.NAME, version = ProjectMC.VERSION)
public class ProjectMC
{
    public static final String MODID = "projectmc";
    public static final String NAME = "ProjectMC";
    public static final String VERSION = "0.0.1";

    //MOD实例
    @Mod.Instance(ProjectMC.MODID)
    public static ProjectMC instance;

    //代理（不知道是干啥的）
    @SidedProxy(clientSide = "com.example.examplemod.proxy.ClientProxy",
            serverSide = "com.example.examplemod.proxy.CommonProxy")
    public static CommonProxy proxy;

    private static Logger logger;
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        logger.info("pre");
        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        logger.info("init");
        proxy.init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        logger.info("post");
        proxy.postInit(event);
    }

}
