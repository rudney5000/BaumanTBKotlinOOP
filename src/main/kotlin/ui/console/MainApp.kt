package ui.console

import data.datasources.InMemoryDataSource
import data.repositories.LibraryRepositoryImpl

/**
 * Объект для запуска и настройки приложения.
 */
object MainApp {
    /**
     * Инициализация и запуск приложения.
     */
    fun run() {
        // Инициализация компонентов
        val dataSource = InMemoryDataSource()
        val repository = LibraryRepositoryImpl(dataSource)

        // Запуск UI
        val libraryUI = LibraryUI(repository)
        libraryUI.start()
    }
}