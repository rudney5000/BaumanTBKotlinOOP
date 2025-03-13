package utils.extensions

/**
 * Расширение для строки, делающее первую букву заглавной.
 * @return Строка с первой заглавной буквой
 */
fun String.capitalize(): String {
    return if (this.isEmpty()) this else this[0].uppercase() + this.substring(1)
}