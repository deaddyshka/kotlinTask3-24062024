import org.junit.Assert.*
import org.junit.Test

class MainKtTest {

    @Test
    fun calculateCommission() {
        // val cardType: String = "Мир"
        val cardType: String = "Visa"
        val previousTransfersAmount: Double = 60_000.0
        val transferAmount: Double = 120_000.0

        // Проверяем лимиты на сумму перевода
        if (transferAmount > 150_000) {
            throw IllegalArgumentException("Превышен суточный лимит перевода")
        }
        if (previousTransfersAmount + transferAmount > 600000) {
            throw IllegalArgumentException("Превышен месячный лимит перевода")
        }

        // Рассчитываем комиссию в зависимости от типа карты
        val commission: Double = when (cardType) {
            "Mastercard" -> {
                if (previousTransfersAmount + transferAmount > 75000) {
                    transferAmount * 0.006 + 20
                } else {
                    0.0
                }
            }

            "Visa" -> {
                maxOf(transferAmount * 0.0075, 35.0)
            }

            "Мир" -> {
                0.0
            }

            else -> {
                throw IllegalArgumentException("Неизвестный тип карты")
            }
        }

        assertEquals(900.0, commission, 0.1)
    }

    @Test
    fun calculateCommission111() {
        // val cardType: String = "Мир"
        val cardType: String = "Visa"
        val previousTransfersAmount: Double = 60_000.0
        val transferAmount: Double = 120_000.0

        // Проверяем лимиты на сумму перевода
        if (transferAmount > 150_000) {
            throw IllegalArgumentException("Превышен суточный лимит перевода")
        }
        if (previousTransfersAmount + transferAmount > 600000) {
            throw IllegalArgumentException("Превышен месячный лимит перевода")
        }

        // Рассчитываем комиссию в зависимости от типа карты
        val commission: Double = when (cardType) {
            "Mastercard" -> {
                if (previousTransfersAmount + transferAmount > 75000) {
                    transferAmount * 0.006 + 20
                } else {
                    0.0
                }
            }

            "Visa" -> {
                maxOf(transferAmount * 0.0075, 35.0)
            }

            "Мир" -> {
                0.0
            }

            else -> {
                throw IllegalArgumentException("Неизвестный тип карты")
            }
        }

        assertEquals(90.0, commission, 0.1)
    }
}