package domain.entities

/**
 * Класс, представляющий книгу в библиотеке.
 * Наследуется от BaseLibraryItem и добавляет специфичные для книги свойства.
 */
class Book(
    id: Int,
    title: String,
    isAvailable: Boolean,
    val pages: Int,
    val author: String
) : BaseLibraryItem(id, title, isAvailable) {

    /**
     * Получение подробной информации о книге.
     * @return Строка в формате "книга: наименование (количествоСтраниц стр.) автора: автор с id: id доступна: Да/Нет"
     */
    override fun getDetailedInfo(): String {
        return "книга: $title ($pages стр.) автора: $author с id: $id доступна: ${if (isAvailable) "Да" else "Нет"}"
    }
}