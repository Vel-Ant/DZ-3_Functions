package ru.netology

import java.util.*

val count = 15_000
val amountOfTransfersPerMonthCard = 0   // сумма перевода(ов) в месяц (для всех карт)
val amountOfTransfersPerDayCard = 0 // сумма перевода(ов) в сутки (для карт)
val maxAmountOfTransfersAtOneTimeVK = 15_000 // максимальная сумма перевода за раз (для VK Pay)
val amountOfTransfersPerMonthVK = 0 // сумма перевода(ов) в месяц (для VK Pay)
val cardBillType = "VK Pay"

fun main() {

    if (limit(cardBillType)) {
         val amount = (count + commission(cardBillType))
         println("Сумма перевода с комиcсией по $cardBillType составит: $amount рублей")
    } else println("Превышен лимит. Операция отклонена")
}

fun commission(cardBillType: String) = when(cardBillType) {
    "MasterCard", "Maestro" -> if (count >= 75_000) ((count * 0.006) + 20).toInt() else 0
    "Visa", "МИР"-> if (count * 0.0075 < 35) 35 else (count * 0.0075).toInt()
    else -> 0
}

fun limit(cardBillType: String) = when(cardBillType) {
    "MasterCard", "Maestro", "Visa", "МИР" -> amountOfTransfersPerDayCard + count <= 150_000 && amountOfTransfersPerMonthCard + count <= 600_000
    "VK Pay" -> maxAmountOfTransfersAtOneTimeVK >= count && amountOfTransfersPerMonthVK + count <= 40_000
    else -> false
}