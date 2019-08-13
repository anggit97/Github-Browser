package com.anggit97.core.utils.thread

import kotlinx.coroutines.CoroutineDispatcher

/**
 * Created by Anggit PRayogo on 2019-08-13.
 * github : @anggit97
 */
interface SchedulerProvider {
    fun ui(): CoroutineDispatcher
}