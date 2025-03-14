package domain.entities

/**
 * Интерфейс, определяющий основные свойства и методы для всех элементов библиотеки.
 */
interface LibraryItem {
    val id: Int
    val title: String
    val isAvailable: Boolean

    /**
     * Получение краткой информации об элементе.
     * @return Строка с краткой информацией
     */
    fun getBriefInfo(): String

    /**
     * Получение подробной информации об элементе.
     * @return Строка с подробной информацией
     */
    fun getDetailedInfo(): String

    /**
     * Проверяет, может ли элемент быть взят на дом.
     * @return true, если элемент можно брать домой, false в противном случае
     */
    fun canBeTakenHome(): Boolean

    /**
     * Проверяет, может ли элемент быть прочитан/использован в библиотеке.
     * @return true, если элемент можно использовать в библиотеке, false в противном случае
     */
    fun canBeReadInLibrary(): Boolean

    /**
     * Возвращает отображаемое название типа элемента.
     * @return Строка с названием типа элемента (например, "Книга", "Газета", "Диск")
     */
    fun getDisplayTypeName(): String
}