package rivers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import meshcomponents.MyMesh;

public class River {

    public void createRiver(MyMesh mesh){
        List <Integer> islandPoint = new ArrayList();

    }

    private int pickPoint(int numberOfVerticies){
        Random bag = new Random();

        return bag.nextInt(numberOfVerticies);
    }
}
