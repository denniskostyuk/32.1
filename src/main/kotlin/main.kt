fun main() {


    val cardType = "Maestro"    // Варианты: Visa, Мир, Mastercard, Maestro, VK Pay
    val totalHasTransfered = 50_000.0   // Сумма переводов за этот месяц
    val sumTransfer = 30_000.0    // Сумма к переводу

    val result = sumFee(sumTransfer,totalHasTransfered, cardType)

    if (result > 0) {
        println("Сумма комиссии = $result")
    }
    else if (result == -1.0) {
        println("Ошибка превышения лимитов")
    } else {
        println("Ошибка типа карты")
    }
}

fun sumFee (sumTransfer : Double, totalHasTransfered : Double = 0.0, cardType : String = "Мир") : Double {
    val ERROR_LIMIT : Double =-1.0
    val ERROR_CARD_TYPE : Double =-2.0

    val dayLimit = 150_000.0
    val monthLimit = 600_000.0
    var res : Double

    if (sumTransfer > dayLimit || totalHasTransfered + sumTransfer > monthLimit) {
        return ERROR_LIMIT
    }

    res = when (cardType) {
        "Visa", "Мир" -> if (sumTransfer * 0.0075 < 35.0) 35.0 else sumTransfer * 0.0075
        "Mastercard", "Maestro" -> if (sumTransfer+totalHasTransfered <= 75_000.0 && sumTransfer >= 300.0) 0.0 else if (totalHasTransfered >= 75_000.0 || sumTransfer < 300.0) sumTransfer * 0.006 + 20.0 else (totalHasTransfered+sumTransfer-75_000.0) * 0.006 + 20.0
        "VK Pay" -> if (sumTransfer > 15_000.0 || sumTransfer+totalHasTransfered > 40_000.0) ERROR_LIMIT else 0.0
        else -> ERROR_CARD_TYPE
    }
    return res;
}