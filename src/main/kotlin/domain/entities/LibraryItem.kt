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
}