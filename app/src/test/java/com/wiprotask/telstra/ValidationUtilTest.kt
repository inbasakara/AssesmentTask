package com.wiprotask.telstra

import com.wiprotask.telstra.util.Validation
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4




@RunWith(JUnit4::class)
class ValidationUtilTest {

    @Test
    fun validateFactTest() {
        val fact = Fact("test","testUrl","testdecription")
        assertEquals(true, Validation.validateFact(fact))
    }

    @Test
    fun validateFactEmptyTest() {
        val fact = Fact("","sampletestUrl","testdecription")
        assertEquals(false, Validation.validateFact(fact))
    }

}