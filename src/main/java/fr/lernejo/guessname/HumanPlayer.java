package fr.lernejo.guessname;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.util.Scanner;

public class HumanPlayer implements Player {

    private final Logger logger = LoggerFactory.getLogger("player");


    @Override
    public long askNextGuess() {
        Scanner input = new Scanner(System.in);
        Long userNumberInput = input.nextLong();
        return userNumberInput;
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        if (lowerOrGreater == false){
            logger.log("Plus grand");
        }else{
            logger.log("Plus petit");
        }
    }
}
