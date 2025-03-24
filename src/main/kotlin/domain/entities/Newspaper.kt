package domain.entities

import domain.digitization.Digitizable
import java.util.*

/**
 * Класс, представляющий газету в библиотеке.
 * Наследуется от BaseLibraryItem и добавляет номер выпуска и месяц выпуска.
 */
data class Newspaper(
    override val id: Int,
    override val title: String,
    override var isAvailable: Boolean,
    val issueNumber: Int,
    val month: Month
) : BaseLibraryItem(id, title, isAvailable), Digitizable {

    /**
     * Получение подробной информации о газете.
     * @return Строка в формате "выпуск: номерВыпуска газеты наименование с id: id доступен: Да/Нет"
     */
    override fun getDetailedInfo(): String {
        return "выпуск: $issueNumber за ${month.getDisplayName(Locale("ru"))} газеты $title с id: $id доступен: ${if (isAvailable) "Да" else "Нет"}"
    }

    /**
     * Газеты нельзя брать домой.
     * @return false, так как газеты не предназначены для выноса из библиотеки
     */
    override fun canBeTakenHome(): Boolean = false

    /**
     * Газеты можно читать в библиотеке.
     * @return true, так как газеты можно читать в библиотеке
     */
    override fun canBeReadInLibrary(): Boolean = true

    /**
     * Возвращает отображаемое название типа.
     * @return "Газета"
     */
    override fun getDisplayTypeName(): String = "Газета"

    override fun digitize(): String {
        return "Оцифрованная газета: $title, выпуск $issueNumber за ${month.getDisplayName(Locale("ru"))}"
    }

    override fun toDigitalFormat(): Disk {
        return Disk(
            id = 0,
            title = "Цифровая версия газеты: $title, выпуск $issueNumber за ${month.getDisplayName(Locale("ru"))}",
            isAvailable = true,
            type = DiskType.DVD
        )
    }
}