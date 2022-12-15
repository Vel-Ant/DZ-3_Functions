package ru.netology

import java.util.*

val count = 85_000
val amountOfTransfersPerMonthCard = 400_000   // сумма перевода(ов) в месяц (для всех карт)
val amountOfTransfersPerDayCard = 10_000 // сумма перевода(ов) в сутки (для карт)
val maxAmountOfTransfersAtOneTimeVK = 15_000 // максимальная сумма перевода за раз (для VK Pay)
val amountOfTransfersPerMonthVK = 20_000 // сумма перевода(ов) в месяц (для VK Pay)
val cardBillType = "VK Pay"

fun main() {

    if (limit(count, cardBillType)) {
        val amount = (count + commission(count, cardBillType))
        println("Сумма перевода с комиcсией по $cardBillType составит: $amount рублей")
    } else println("Превышен лимит. Операция отклонена")
}

fun commission(count: Int, cardBillType: String) = when (cardBillType) {
    "MasterCard", "Maestro" -> if (count >= 75_000) ((count * 0.006) + 20).toInt() else 0
    "Visa", "МИР" -> if (count * 0.0075 < 35) 35 else (count * 0.0075).toInt()
    else -> 0
}

fun limit(count: Int, cardBillType: String) = when (cardBillType) {
    "MasterCard", "Maestro", "Visa", "МИР" -> amountOfTransfersPerDayCard + count <= 150_000 && amountOfTransfersPerMonthCard + count <= 600_000
    "VK Pay" -> maxAmountOfTransfersAtOneTimeVK >= count && amountOfTransfersPerMonthVK + count <= 40_000
    else -> false
}