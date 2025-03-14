package domain.entities

/**
 * Абстрактный базовый класс для всех элементов библиотеки.
 * Реализует основные функции интерфейса LibraryItem.
 */
abstract class BaseLibraryItem(
    override val id: Int,
    override val title: String,
    override var isAvailable: Boolean
) : LibraryItem {

    /**
     * Получение краткой информации об элементе библиотеки.
     * @return Строка в формате "наименование доступна: Да/Нет"
     */
    override fun getBriefInfo(): String {
        return "$title доступна: ${if (isAvailable) "Да" else "Нет"}"
    }

    /**
     * Абстрактный метод для получения подробной информации.
     * Должен быть реализован в дочерних классах.
     */
    abstract override fun getDetailedInfo(): String

    /**
     * Изменение доступности элемента.
     * @param newAvailability Новое состояние доступности
     */
    fun changeAvailability(newAvailability: Boolean) {
        isAvailable = newAvailability
    }

    /**
     * Проверяет, может ли элемент быть взят на дом.
     * По умолчанию возвращает true, но может быть переопределен в подклассах.
     * @return true, если элемент можно брать домой
     */
    open override fun canBeTakenHome(): Boolean = true

    /**
     * Проверяет, может ли элемент быть прочитан/использован в библиотеке.
     * По умолчанию возвращает true, но может быть переопределен в подклассах.
     * @return true, если элемент можно использовать в библиотеке
     */
    open override fun canBeReadInLibrary(): Boolean = true

    /**
     * Абстрактный метод, возвращающий отображаемое название типа элемента.
     * Должен быть реализован в дочерних классах.
     * @return Строка с названием типа элемента
     */
    abstract override fun getDisplayTypeName(): String
}