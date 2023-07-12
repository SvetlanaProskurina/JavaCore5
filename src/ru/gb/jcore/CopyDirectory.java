package ru.gb.jcore;

import java.io.File;
    import java.io.IOException;
    import java.nio.file.Files;

/**
 * Класс DirectoryCopier предоставляет метод для копирования всех файлов из одной директории в
 * другую. Конструктор этого класса принимает два объекта File - исходную и целевую директории.
 * Метод copyDirectory() выполняет копирование файлов.
 */
public class CopyDirectory {

  private File soursceDirectory;
  private File targetDirectory;

  /**
   * Конструктор класса DirectoryCopier.
   *
   * @param soursceDirectory Исходная директория, откуда будут копироваться файлы. Должна быть
   *                         директорией, содержащей файлы.
   * @param targetDirectory  Целевая директория, куда будут копироваться файлы. Если такой
   *                         директории не существует, она будет создана.
   */
  public CopyDirectory(File soursceDirectory, File targetDirectory) {
    this.soursceDirectory = soursceDirectory;
    this.targetDirectory = targetDirectory;
  }

  /**
   * Метод DirCopy() выполняет копирование файлов из исходной директории в целевую. Если
   * целевая директория не существует, она будет создана. Если в исходной директории присутствуют
   * поддиректории, они не будут скопированы.
   */
  public void DirCopy() {
    // Если целевая директория не существует, создаем ее
    if (!targetDirectory.exists()) {
      targetDirectory.mkdir();
    }
    // Получаем все файлы из исходной директории
    File[] files = soursceDirectory.listFiles();
    // Если в исходной директории есть файлы то
    if (files != null) {
      // Перебираем каждый файл
      for (File file : files) {
        // Если это файл (не папка)
        if (file.isFile()) {
          // Создаем объект File для файла резервной копии
          File backupFile = new File(targetDirectory, file.getName());
          try {
            // Копируем исходный файл в файл резервной копии
            Files.copy(file.toPath(), backupFile.toPath());
            System.out.println("Копирование файла " + file.getName() + " успешно завершено.");
          } catch (IOException e) {
            // Если произошла ошибка ввода-вывода, выводим информацию об ошибке
            e.printStackTrace();
          }
        }
      }
    }
  }
}