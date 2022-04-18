import au.com.bytecode.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int column;
        if (args.length == 0) {
            column = 2;
        } else {
            column = Integer.parseInt(args[0]);
        }

        if (column <= 0 || column > 14) {
            System.out.println("Программа завершила свою работу с ошибкой, т.к. вы выбрали номер столбца в таблице больше 14-го. " +
                    "В таблице - 14 столбцов. Выберите номер одного из них при следующем запуске приложения.");
            return;
        }
        int finalColumn = column;

        System.out.println("Введите строку:");
        Scanner scanner = new Scanner(System.in);
        String desired = scanner.nextLine();

        long startSearch = System.currentTimeMillis();
        ArrayList<Airport> desiredAirports = new ArrayList<>();
        try {
            CSVReader reader = new CSVReader(new FileReader(
                    "C:/Users/chup9/IdeaProjects/Airports/target/classes/airports.csv",
                    StandardCharsets.UTF_8
            ));
            ArrayList<String[]> allRows = (ArrayList<String[]>) reader.readAll();
            reader.close();

            for (String[] row : allRows) {
                if (row[finalColumn - 1].startsWith(desired)) {
                    desiredAirports.add(Airport.airportFromStringArray(row));
                }
            }
        }
        catch (IOException | WrongSizeOfArrayException ex) {
            ex.printStackTrace();
        }

        int searchTime = (int) (System.currentTimeMillis() - startSearch);

        if (!desiredAirports.isEmpty()) {
            desiredAirports.sort(Comparator.comparing(airport -> airport.getAllVariables()[finalColumn - 1]));
            desiredAirports.forEach(airport -> System.out.println(airport.toString(finalColumn)));
        }
        System.out.println("\nКоличество найденных строк: " + desiredAirports.size() + ". Время, затраченное на поиск: " + searchTime + " мс.");
    }
}
