package fr.lernejo.guessname;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.util.Scanner;

public class HumanPlayer implements Player {

    private final Logger logger = LoggerFactory.getLogger("player");


    @Override
    public long askNextGuess() {
        logger.log("Entrez un nombre entre 1 et 100");
        Scanner input = new Scanner(System.in);
        Long userNumberInput = input.nextLong();
        return userNumberInput;
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        if (lowerOrGreater == false){
            logger.log("grand");
        }else{
            logger.log("petit");
        }
    }
}
