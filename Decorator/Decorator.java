package designPattern.decorator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * иногда нужно добавить новые обязаности существующему объекту(не всему классу).
 * Для этого есть паттерн проектирования декоратор. Он позволяет добавлять новую
 * функциональность объекту динамически.
 *
 * Декоратор хорошо подходит для следующих задач:
 * - кэширование результатов работы
 * - измерение времени работы конкретного метода
 * - для контроля доступа пользователей
 *
 */
interface FileData {
    String read();
    void write(String str);
}

class ConcreteFileData implements FileData{
    String fileName;

    public ConcreteFileData(String fileName) {
        this.fileName = fileName;
    }

    public String read() {
        String str = null;

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            str = reader.readLine();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    public void write(String str) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(str);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}

class FileDataCipher implements FileData {

    FileData concreteFD;
    int key = 11;

    public FileDataCipher(FileData concreteFD) {
        this.concreteFD = concreteFD;
        this.key = key;
    }

    public String encrypt(String str) {
        StringBuilder result = new StringBuilder();

        for (Character letter : str.toCharArray()) {
            result.append((char)(letter + key));
        }
        return result.toString();
    }

    public String decrypt(String str) {
        StringBuilder result = new StringBuilder();

        for (Character letter : str.toCharArray()) {
            result.append((char)(letter - key));
        }
        return result.toString();
    }

    @Override
    public String read() {
        String data = concreteFD.read();
        System.out.println("");
        return decrypt(data);
    }

    @Override
    public void write(String str) {
        concreteFD.write(encrypt(str));
    }
}

public class Decorator {
    public static void main(String[] args) {
        FileData cfl = new FileDataCipher(new ConcreteFileData("lol"));
        cfl.write("hello, world!");

        System.out.println(cfl.read());
    }
}