package com.example.scopes

import javax.inject.Scope
import kotlin.reflect.KClass

@Scope
annotation class SingleIn(val scopeClass: KClass<*>)