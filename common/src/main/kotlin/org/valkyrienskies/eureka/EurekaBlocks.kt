package org.valkyrienskies.eureka

import me.shedaniel.architectury.registry.DeferredRegister
import net.minecraft.core.Registry
import net.minecraft.world.item.BlockItem
import net.minecraft.world.item.Item
import net.minecraft.world.level.block.Block
import org.valkyrienskies.eureka.block.Anchor
import org.valkyrienskies.eureka.block.ShipHelm
import kotlin.reflect.KProperty

@Suppress("unused")
object EurekaBlocks {
    private val BLOCKS = DeferredRegister.create(EurekaMod.MOD_ID, Registry.BLOCK_REGISTRY)

    val SHIP_HELM = ShipHelm byName "ship_helm"
    val ANCHOR = Anchor byName "anchor"


    fun register() {
        BLOCKS.register()
    }

    //Blocks should also be registered as items, if you want them to be able to be held
    // aka all blocks
    fun registerItems(items: DeferredRegister<Item>) {
        BLOCKS.iterator().forEach {
            items.register(it.id) { BlockItem(it.get(), Item.Properties().tab(EurekaItems.TAB)) }
        }
    }

    private infix fun Block.byName(name: String) = BLOCKS.register(name) { this }
}