package ru.netology
import org.junit.Test

import org.junit.Assert.*

class DZ_3_2_CommissionKtTest {

    @Test
    fun limitVKTrue() {
        val count = 1_000
        val cardBillType = "VK Pay"

        val result = limit(count, cardBillType)

        assertEquals(true, result)
    }

    @Test
    fun limitVKFalse() {
        val count = 18_000
        val cardBillType = "VK Pay"

        val result = limit(count, cardBillType)

        assertEquals(false, result)
    }

    @Test
    fun limitCardTrue() {
        val count = 5_000
        val cardBillType = "MasterCard"

        val result = limit(count, cardBillType)

        assertEquals(true, result)
    }

    @Test
    fun limitCardFalse() {
        val count = 200_000
        val cardBillType = "MasterCard"

        val result = limit(count, cardBillType)

        assertEquals(false, result)
    }

    @Test
    fun limitElse() {
        val count = 85_000
        val cardBillType = "Else"

        val result = limit(count, cardBillType)

        assertEquals(false, result)
    }

    @Test
    fun commissionVK() {
        val count = 1_000
        val cardBillType = "VK Pay"

        val result = commission(count, cardBillType)

        assertEquals(0, result)
    }

    @Test
    fun commissionMasterCardZero() {
        val count = 1_000
        val cardBillType = "MasterCard"

        val result = commission(count, cardBillType)

        assertEquals(0, result)
    }

    @Test
    fun commissionMasterCardPercent() {
        val count = 85_000
        val cardBillType = "MasterCard"

        val result = commission(count, cardBillType)

        assertEquals(530, result)
    }

    @Test
    fun commissionVisa35() {
        val count = 1_000
        val cardBillType = "Visa"

        val result = commission(count, cardBillType)

        assertEquals(35, result)
    }

    @Test
    fun commissionVisaPercent() {
        val count = 85_000
        val cardBillType = "Visa"

        val result = commission(count, cardBillType)

        assertEquals(637, result)
    }
}