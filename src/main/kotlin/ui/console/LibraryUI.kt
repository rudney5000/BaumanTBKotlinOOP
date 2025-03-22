package ui.console

import domain.repositories.LibraryRepository
import ui.menus.MainMenu

/**
 * Основной класс пользовательского интерфейса библиотеки.
 * @param repository Репозиторий для доступа к данным
 */
class LibraryUI(private val repository: LibraryRepository) {

    /**
     * Запуск пользовательского интерфейса.
     */
    fun start() {
        println("Добро пожаловать в систему управления библиотекой!")
        MainMenu(repository).display()
        println("Спасибо за использование системы. До свидания!")
    }
}