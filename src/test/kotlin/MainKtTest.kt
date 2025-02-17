import org.junit.Assert.*
import org.junit.Test

class calculateCommission {
    @Test
    fun cardMir() {
        val cardType: String = "Мир"
        val previousTransfersAmount: Double = 60_000.0
        val transferAmount: Double = 120_000.0

        val result = calculateCommission(cardType, previousTransfersAmount, transferAmount)

        assertEquals(0.0, result, 0.1)

    }

    @Test
    fun cardVisa() {
        val cardType: String = "Visa"
        val previousTransfersAmount: Double = 60_000.0
        val transferAmount: Double = 120_000.0

        val result = calculateCommission(cardType, previousTransfersAmount, transferAmount)

        assertEquals(900.0, result, 0.1)
    }


    @Test
    fun cardMasterCard() {
        val cardType: String = "Mastercard"
        val previousTransfersAmount: Double = 60_000.0
        val transferAmount: Double = 120_000.0

        val result = calculateCommission(cardType, previousTransfersAmount, transferAmount)
        assertEquals(740.0, result, 0.1)
    }

    @Test
    fun noLimitTransferAmount() {
        val cardType: String = "Mastercard"
        val previousTransfersAmount: Double = 60_000.0
        val transferAmount: Double = 1120_000.0

        //val result = calculateCommission(cardType, previousTransfersAmount, transferAmount)
        //assertEquals(740.0, result  , 0.1)

        try {
            calculateCommission(cardType, previousTransfersAmount, transferAmount)
            fail("Expected IllegalArgumentException but no exception was thrown")
        } catch (e: IllegalArgumentException) {
            assertEquals("Превышен суточный лимит перевода", e.message)
        }
    }


    @Test
    fun noLimitTransfersAmount() {
        val cardType: String = "Mastercard"
        val previousTransfersAmount: Double = 6_000_000.0
        val transferAmount: Double = 120_000.0

        //val result = calculateCommission(cardType, previousTransfersAmount, transferAmount)
        //assertEquals(740.0, result  , 0.1)

        try {
            calculateCommission(cardType, previousTransfersAmount, transferAmount)
            fail("Expected IllegalArgumentException but no exception was thrown")
        } catch (e: IllegalArgumentException) {
            assertEquals("Превышен месячный лимит перевода", e.message)
        }
    }

    @Test
    fun unknownCard() {
        val cardType: String = "Worldcard"
        val previousTransfersAmount: Double = 60_000.0
        val transferAmount: Double = 120_000.0

        //val result = calculateCommission(cardType, previousTransfersAmount, transferAmount)
        //assertEquals(740.0, result  , 0.1)

        try {
            calculateCommission(cardType, previousTransfersAmount, transferAmount)
            fail("Expected IllegalArgumentException but no exception was thrown")
        } catch (e: IllegalArgumentException) {
            assertEquals("Неизвестный тип карты", e.message)
        }
    }

    @Test
    fun miniTransfer() {
        val cardType: String = "Mastercard"
        val previousTransfersAmount: Double = 60_000.0
        val transferAmount: Double = 120.0

        val result = calculateCommission(cardType, previousTransfersAmount, transferAmount)
        assertEquals(0.0, result  , 0.1)


    }

}


//class MainKtTest {
//
//    @Test
//    fun calculateCommission() {
//        // val cardType: String = "Мир"
//        val cardType: String = "Visa"
//        val previousTransfersAmount: Double = 60_000.0
//        val transferAmount: Double = 120_000.0
//
//        // Проверяем лимиты на сумму перевода
//        if (transferAmount > 150_000) {
//            throw IllegalArgumentException("Превышен суточный лимит перевода")
//        }
//        if (previousTransfersAmount + transferAmount > 600000) {
//            throw IllegalArgumentException("Превышен месячный лимит перевода")
//        }
//
//        // Рассчитываем комиссию в зависимости от типа карты
//        val commission: Double = when (cardType) {
//            "Mastercard" -> {
//                if (previousTransfersAmount + transferAmount > 75000) {
//                    transferAmount * 0.006 + 20
//                } else {
//                    0.0
//                }
//            }
//
//            "Visa" -> {
//                maxOf(transferAmount * 0.0075, 35.0)
//            }
//
//            "Мир" -> {
//                0.0
//            }
//
//            else -> {
//                throw IllegalArgumentException("Неизвестный тип карты")
//            }
//        }
//
//        assertEquals(900.0, commission, 0.1)
//    }
//
//    @Test
//    fun calculateCommission111() {
//        // val cardType: String = "Мир"
//        val cardType: String = "Visa"
//        val previousTransfersAmount: Double = 60_000.0
//        val transferAmount: Double = 120_000.0
//
//        // Проверяем лимиты на сумму перевода
//        if (transferAmount > 150_000) {
//            throw IllegalArgumentException("Превышен суточный лимит перевода")
//        }
//        if (previousTransfersAmount + transferAmount > 600000) {
//            throw IllegalArgumentException("Превышен месячный лимит перевода")
//        }
//
//        // Рассчитываем комиссию в зависимости от типа карты
//        val commission: Double = when (cardType) {
//            "Mastercard" -> {
//                if (previousTransfersAmount + transferAmount > 75000) {
//                    transferAmount * 0.006 + 20
//                } else {
//                    0.0
//                }
//            }
//
//            "Visa" -> {
//                maxOf(transferAmount * 0.0075, 35.0)
//            }
//
//            "Мир" -> {
//                0.0
//            }
//
//            else -> {
//                throw IllegalArgumentException("Неизвестный тип карты")
//            }
//        }
//
//        assertEquals(90.0, commission, 0.1)
//    }
//}