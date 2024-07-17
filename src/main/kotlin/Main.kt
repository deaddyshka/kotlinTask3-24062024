//тестирую все работает
fun calculateCommission(
    cardType: String = "Мир",
    previousTransfersAmount: Double = 0.0,
    transferAmount: Double
): Double {
    // Проверяем лимиты на сумму перевода
    if (transferAmount > 150_000) {
        throw IllegalArgumentException("Превышен суточный лимит перевода")
    }
    if (previousTransfersAmount + transferAmount > 600_000) {
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
    return commission
}


fun main() {
    val commission = calculateCommission(
        cardType = "Mastercard",
        previousTransfersAmount = 70000.0,
        transferAmount = 100000.0
    )
    println("Сумма комиссии: $commission рублей")
}