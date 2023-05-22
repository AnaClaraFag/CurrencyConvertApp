package com.example.currencyconvert.core.extensions

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

fun LifecycleOwner.repeatWhenStarted(block: suspend CoroutineScope.() -> Unit) =
    lifecycleScope.launch {
        this@repeatWhenStarted.repeatOnLifecycle(Lifecycle.State.STARTED, block)
    }