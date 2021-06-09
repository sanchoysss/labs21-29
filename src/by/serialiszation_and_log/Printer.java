package by.serialiszation_and_log;

import by.flowers.Pion;
import by.flowers.Rose;
import by.flowers.Tulip;

import java.io.*;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Printer {

    public static void serialization() {
        Rose rose = new Rose();
        Tulip tulip = new Tulip();

        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("Flowers.dat"));
            outputStream.writeObject(rose);
            outputStream.writeObject(tulip);

            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("Flowers.dat"));
            Rose loadRose = (Rose) inputStream.readObject();
            Tulip loadTulip = (Tulip) inputStream.readObject();
            System.out.println(loadRose);
            System.out.println(loadTulip);
        } catch (IOException exception) {
            System.out.println(exception);
        } catch (ClassNotFoundException exception) {
            System.out.println(exception);
        }
    }

    public static void serializeBytes() {
        Pion pion = new Pion();
        ByteArrayOutputStream b;
        try {
            b = new ByteArrayOutputStream();
            ObjectOutputStream obj = new ObjectOutputStream(b);
            obj.writeObject(pion);
            byte[] bytes = b.toByteArray();

            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
            ObjectInputStream inputStream = new ObjectInputStream(byteArrayInputStream);
            Pion pionRead = (Pion) inputStream.readObject();
            System.out.println(pionRead);
        } catch(IOException | ClassNotFoundException exception) {
            System.out.println(exception);
        }

    }

    public static void log() {
        Logger logger = Logger.getLogger("MyLog");
        FileHandler fh;
        Rose rose = new Rose();
        Tulip tulip = new Tulip("Red", 20, 20);
        try {
            fh = new FileHandler("LogFile.log");
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
            logger.info(rose.toString());
        } catch(SecurityException e) {
            e.printStackTrace();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        logger.info(tulip.toString());
    }
}
