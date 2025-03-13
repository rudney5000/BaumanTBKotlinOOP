package ui.console

import domain.usecases.LibraryUseCases
import ui.menus.MainMenu

/**
 * Основной класс пользовательского интерфейса библиотеки.
 * @param libraryUseCases Объект с бизнес-логикой
 */
class LibraryUI(private val libraryUseCases: LibraryUseCases) {

    /**
     * Запуск пользовательского интерфейса.
     */
    fun start() {
        println("Добро пожаловать в систему управления библиотекой!")
        MainMenu(libraryUseCases).display()
        println("Спасибо за использование системы. До свидания!")
    }
}