package tictactoe.csv;

import tictactoe.Player;

import java.io.*;

public class CsvManager {
    private String csvPath = "D:\\mine\\java\\tdd\\tictactoe.csv";

    public CsvManager() {
    }

    public CsvManager(String csvPath) {
        this.csvPath = csvPath;
    }

    public Player savePlayer(Player player) {
        try (FileWriter fileWriter = new FileWriter(csvPath, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);) {

            bufferedWriter.append(player.csvFormat());
            bufferedWriter.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return player;
    }

    public Player readPlayer(Player player) throws IOException {
//        try(FileReader fileReader = new FileReader(csvPath);
//            BufferedReader bufferedReader = new BufferedReader(fileReader)) {
//            Player savedPlayer = bufferedReader.lines()
//                    .filter(line -> player.csvFormat().equals(line))
//                    .findFirst()
//                    .map(csv -> {
//                        String[] playerProperties = csv.split(",");
//                        Record record = new Record(Integer.parseInt(playerProperties[1]), Integer.parseInt(playerProperties[2]));
//                        return new Player(playerProperties[0], record);
//                    })
//                    .orElse(null);
//
//            return savedPlayer;
//        } catch (FileNotFoundException e) {
            return null;
//        } catch (IOException e) {
//            System.out.println("save 파일을 읽어오는데 실패했습니다.");
//            throw new IOException(e);
//        }
    }
}
