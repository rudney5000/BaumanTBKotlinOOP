package utils.extensions

import java.util.*

private val scanner = Scanner(System.`in`)

/**
 * Чтение целого числа с консоли с проверкой ввода.
 * @param prompt Подсказка для пользователя
 * @return Введенное число
 */
fun readInt(prompt: String): Int {
    print("$prompt ")
    while (true) {
        try {
            return scanner.nextInt().also { scanner.nextLine() }
        } catch (e: Exception) {
            scanner.nextLine()
            println("Некорректный ввод. Пожалуйста, введите число.")
            print("$prompt ")
        }
    }
}