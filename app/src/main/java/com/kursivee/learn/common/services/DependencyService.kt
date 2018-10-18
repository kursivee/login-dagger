package com.kursivee.learn.common.services

import javax.inject.Inject
import javax.inject.Singleton

// If we know we want this to be a singleton, we can mark it
// as one here and add an empty @Inject constructor. If we
// do that, we don't need to provide it in an @Module.
@Singleton
class DependencyService @Inject constructor() {
    var text = "Text"
}