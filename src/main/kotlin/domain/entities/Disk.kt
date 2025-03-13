package domain.entities

/**
 * Класс, представляющий диск в библиотеке.
 * Наследуется от BaseLibraryItem и добавляет тип диска.
 */
class Disk(
    id: Int,
    title: String,
    isAvailable: Boolean,
    val type: DiskType
) : BaseLibraryItem(id, title, isAvailable) {

    /**
     * Получение подробной информации о диске.
     * @return Строка в формате "типДиска наименование доступен: Да/Нет"
     */
    override fun getDetailedInfo(): String {
        return "$type $title доступен: ${if (isAvailable) "Да" else "Нет"}"
    }
}