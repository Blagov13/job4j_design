package ru.job4j.io;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleChat {
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private final String path;
    private final String botAnswers;

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() {
        List<String> log = new ArrayList<>();
        List<String> chatBot = readPhrases();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Начали");
        String msg;
        do {
            msg = scanner.nextLine();
            log.add(msg);
            if (STOP.equals(msg)) {
                System.out.println("Не отвечаю");
                Scanner scanner1 = new Scanner(System.in);
                String in;
                do {
                    in = scanner1.nextLine();
                } while (!CONTINUE.equals(in));
            } else {
                String answer = chatBot.get((int) (Math.random() * (chatBot.size())));
                log.add(answer);
                System.out.println(answer);
            }
        } while (!OUT.equals(msg));
        saveLog(log);
    }

    private List<String> readPhrases() {
        List<String> phrases = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(botAnswers, Charset.forName("WINDOWS-1251")))) {
            reader.lines().forEach(phrases::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return phrases;
    }

    private void saveLog(List<String> log) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(path, Charset.forName("WINDOWS-1251"), true))) {
            log.forEach(writer::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ConsoleChat consoleChat = new ConsoleChat("/Users/aleksandrblagov/job4j_design/data/chat.txt", "/Users/aleksandrblagov/job4j_design/data/botAnswer.txt");
        consoleChat.run();
    }
}
