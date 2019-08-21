package net.rooban;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

@org.springframework.stereotype.Service
public class Service {
    private static Logger logger = Logger.getLogger(Service.class.getName());

    public void renameMethod() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command("bash", "-c", "ls /home/rooban");
        boolean status = runCommand(processBuilder);
    }

    public boolean runCommand(ProcessBuilder processBuilder){
        try {
            Process process = processBuilder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            //For testing
            while ((line = reader.readLine()) != null) {
                logger.log(Level.INFO, "Output of line {0}", line);
            }
            int exitCode = process.waitFor();
            if (exitCode != 0) {
                logger.log(Level.WARNING, "Exited with error code: ", exitCode);
                return false;
            } else
                return true;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Exception: ", e);
            return false;
        }
    }
}
