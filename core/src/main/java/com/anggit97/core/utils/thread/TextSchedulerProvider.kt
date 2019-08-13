package com.anggit97.core.utils.thread

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

/**
 * Created by Anggit PRayogo on 2019-08-13.
 * github : @anggit97
 */
class TestSchedulerProvider : SchedulerProvider {
    override fun ui(): CoroutineDispatcher = Dispatchers.Unconfined
}