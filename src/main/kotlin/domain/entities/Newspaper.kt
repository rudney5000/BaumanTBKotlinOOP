package domain.entities

/**
 * Класс, представляющий газету в библиотеке.
 * Наследуется от BaseLibraryItem и добавляет номер выпуска.
 */
class Newspaper(
    id: Int,
    title: String,
    isAvailable: Boolean,
    val issueNumber: Int
) : BaseLibraryItem(id, title, isAvailable) {

    /**
     * Получение подробной информации о газете.
     * @return Строка в формате "выпуск: номерВыпуска газеты наименование с id: id доступен: Да/Нет"
     */
    override fun getDetailedInfo(): String {
        return "выпуск: $issueNumber газеты $title с id: $id доступен: ${if (isAvailable) "Да" else "Нет"}"
    }
}