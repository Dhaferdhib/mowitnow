package io.dhafer.mowitnow;

import io.dhafer.mowitnow.entities.Ground;
import io.dhafer.mowitnow.entities.Position;
import io.dhafer.mowitnow.enumerations.ActionEnum;
import io.dhafer.mowitnow.enumerations.OrientationEnum;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        if(args.length == 1){
            File testCasesFile = new File(args[0]);
            Main main = new Main();
            main.resolveMower(testCasesFile);

        }else{
            throw new IllegalArgumentException();
        }
    }

    public void resolveMower(File file) throws IOException {
        if(!file.isFile()){
            //throw exception
        }else{
            Scanner in = new Scanner(file);
            Position maxPosition = new Position(in.nextLong(), in.nextLong());
            while(in.hasNext()){
                Position mowerPosition = new Position(in.nextLong(), in.nextLong());
                OrientationEnum mowerOrientation = OrientationEnum.valueOf(in.next());
                Ground ground = new Ground(maxPosition, mowerPosition, mowerOrientation);
                String actions = in.next();
                if(actions.length() < 0){
                    //throw exception
                }else{
                    List<String> actionList = Arrays.asList(actions.split(""));
                    actionList.stream().map(ActionEnum::valueOf).forEach(ground::moveMower);
                    System.out.println(ground);
                }

            }
        }
    }
}
