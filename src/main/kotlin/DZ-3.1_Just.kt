package ru.netology

fun main() {

    println("Alex ${agoToText(60)}")    // был(а) только что
    println("Вася ${agoToText(61)}")    // был(а) $minute минуту назад
    println("Женя ${agoToText(200)}")   // был(а) $minute минуты назад
    println("Жора ${agoToText(350)}")   // был(а) $minute минут назад
    println("Bob ${agoToText(4_000)}")  // был(а) в сети $hour час назад
    println("Molly ${agoToText(36_500)}")   // был(а) в сети $hour часов назад
    println("Сеня ${agoToText(75_700)}")    // был(а) в сети $hour часа назад
    println("Александра ${agoToText(86_500)}")  // был(а) в сети вчера
    println("Вячеслав ${agoToText(192_000)}")   // был(а) в сети позавчера
    println("Duke ${agoToText(300_000)}")   // был(а) в сети давно

    val sec = (0..300_000).random()
    println("RANDOM ${agoToText(sec)} ($sec секунд)")    // рандомно
}

fun agoToText(sec: Int): String {
    val minute = sec / 60
    val hour = sec / 3600

    val textTime = when (sec) {
        in 0..60 -> "был(а) только что"
        in 61..3_600 -> minGone(minute)
        in 3_601..86_400 -> hourGone(hour)
        in 86_401..172_800-> "был(а) в сети вчера"
        in 172_801..259_200 -> "был(а) в сети позавчера"
        else -> "был(а) в сети давно"
    }
    return textTime
}

fun minGone(minute: Int) = when (minute) {
    1,21,31,41,51 -> "был(а) $minute минуту назад"
    2,3,4,22,23,24,32,33,34,42,43,44,52,53,54 -> "был(а) $minute минуты назад"
    else -> "был(а) $minute минут назад"
}
fun hourGone(hour: Int) = when (hour) {
    1,21 -> "был(а) в сети $hour час назад"
    2,3,4,22,23 -> "был(а) в сети $hour часа назад"
    else -> "был(а) в сети $hour часов назад"
}