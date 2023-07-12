package ru.gb.jcore;

import java.io.IOException;
import java.io.File;
/**
 * Основной класс, использующий класс GameBoard для демонстрации
 * кодирование, запись, чтение, декодирование и печать состояния игрового поля.
 */
public class Main {
  public static void main(String[] args) {
    int[] initialState = {2, 1, 0, 2, 0, 2, 0, 1, 3};
    GameBoard gameBoard = new GameBoard(initialState);

    try {
      gameBoard.writeToFile("gameBoard.bin");
      gameBoard.readFromFile("gameBoard.bin");
    } catch (IOException e) {
      e.printStackTrace();
    }

    gameBoard.printBoard();

    // Создание объекта File для исходной директории
    File sourceFolder = new File("./sourceDirectory");
    // Создание объекта File для директории резервного копирования
    File backupFolder = new File("./backup");

    // Создание объекта класса DirectoryCopier
    CopyDirectory copier = new CopyDirectory(sourceFolder, backupFolder);

    // Выполнение копирования файлов
    copier.DirCopy();
  }

}
