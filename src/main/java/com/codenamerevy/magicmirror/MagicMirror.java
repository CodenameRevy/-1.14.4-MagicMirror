/*MIT License

Copyright (c) 2021 Marko Dujović

Permission is hereby granted, free of charge, to any person obtaining
a copy of this software and associated documentation files (the
"Software"), to deal in the Software without restriction, including
without limitation the rights to use, copy, modify, merge, publish,
distribute, sublicense, and/or sell copies of the Software, and to
permit persons to whom the Software is furnished to do so, subject to
the following conditions:

The above copyright notice and this permission notice shall be
included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY
CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT,
TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE
SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.*/

package com.codenamerevy.magicmirror;

import com.codenamerevy.magicmirror.client.particle.ParticleHandler;
//import com.codenamerevy.magicmirror.config.Config;
import com.codenamerevy.magicmirror.init.ItemInit;
import com.codenamerevy.magicmirror.init.ParticleInit;
import com.codenamerevy.magicmirror.init.SoundInit;
//import com.codenamerevy.magicmirror.util.handler.*;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
//import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
//import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(MagicMirror.MODID)
public class MagicMirror
{
    public static final String MODID = "magicmirror";
    public static final Logger LOGGER = LogManager.getLogger();

    public MagicMirror()
    {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModLoadingContext eventCtx = ModLoadingContext.get();

        //ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.COMMON_CONFIG);

        eventBus.addListener(this::clientSetup);
        eventBus.addListener(this::commonSetup);

        ItemInit.ITEMS.register(eventBus);

        eventBus.addListener(ParticleHandler::registerParticleFactory);
        ParticleInit.PARTICLES.register(eventBus);
        SoundInit.SOUNDS.register(eventBus);

        MinecraftForge.EVENT_BUS.register(this);
    }
    @SubscribeEvent
    public void commonSetup (final FMLCommonSetupEvent event)
    {
        //MinecraftForge.EVENT_BUS.register(EventHandler.class);
    }

    @SubscribeEvent
    public void clientSetup(final FMLClientSetupEvent event)
    {

    }
}

