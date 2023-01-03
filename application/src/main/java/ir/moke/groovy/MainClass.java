package ir.moke.groovy;

import java.nio.file.*;

public class MainClass {

    private static final Path SCRIPT_PATH = Paths.get("/home/mah454/groovy-scripts");

    public static void main(String[] args) {

        OperatorManager.run(SCRIPT_PATH.resolve("Cisco_9000_001.groovy").toFile());

//        try (WatchService watchService = FileSystems.getDefault().newWatchService()) {
//            SCRIPT_PATH.register(watchService, StandardWatchEventKinds.ENTRY_MODIFY, StandardWatchEventKinds.ENTRY_DELETE);
//
//            WatchKey key;
//            while ((key = watchService.take()) != null) {
//                for (WatchEvent<?> event : key.pollEvents()) {
//                    System.out.println(event.kind() + "         " + event.context());
//                }
//                key.reset();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

    }
}

