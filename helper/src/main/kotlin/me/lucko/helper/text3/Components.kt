package me.lucko.helper.text3

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.TranslatableComponent
import net.kyori.adventure.text.minimessage.MiniMessage

////// Component //////

val String?.mini: Component
    get() = if (this == null) Component.empty() else MiniMessage.miniMessage().deserialize(this)

val List<String>?.mini: List<Component>
    get() = this?.map(String::mini) ?: emptyList()

////// TranslatableComponent ///////

val String?.translatable: TranslatableComponent
    get() = if (this == null) error("key must be not null") else Component.translatable(this)

val List<String>?.translatable: List<TranslatableComponent>
    get() = this?.map(String::translatable) ?: emptyList()

fun TranslatableComponent.arguments(vararg args: String): TranslatableComponent =
    arguments(args.toList().mini)

fun TranslatableComponent.arguments(args: List<String>): TranslatableComponent =
    arguments(args.mini)

fun TranslatableComponent.Builder.arguments(vararg args: String): TranslatableComponent.Builder =
    arguments(args.toList().mini)

fun TranslatableComponent.Builder.arguments(args: List<String>): TranslatableComponent.Builder =
    arguments(args.mini)