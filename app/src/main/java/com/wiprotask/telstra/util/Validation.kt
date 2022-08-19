package com.wiprotask.telstra.util

import com.wiprotask.telstra.Fact

object Validation {

    fun validateFact(fact: Fact) : Boolean {
        // check tile and image is not empty
        if (fact.title.isNotEmpty()&& fact.poster.isNotEmpty()) {
            return true
        }
        return false
    }

}