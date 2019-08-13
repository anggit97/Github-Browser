package com.anggit97.core.base

import androidx.lifecycle.ViewModel
import com.anggit97.core.utils.thread.SchedulerProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.isActive
import kotlin.coroutines.CoroutineContext

/**
 * Created by Anggit PRayogo on 2019-08-13.
 * github : @anggit97
 */
abstract class BaseViewModel(private val baseDispatcher: SchedulerProvider): ViewModel(), CoroutineScope {

    private val supervisorJob = SupervisorJob()

    override val coroutineContext: CoroutineContext
        get() = baseDispatcher.ui() + supervisorJob

    open fun clear() {
        if (isActive && !supervisorJob.isCancelled) {
            supervisorJob.children.map {
                it.cancel()
            }
        }
    }

}