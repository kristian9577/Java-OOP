import models.boat.Boat;
import models.boat.PowerBoat;
import models.boat.Yacht;
import models.engine.Engine;
import models.engine.JetEngine;
import exceptions.ArgumentException;
import exceptions.DuplicateModelException;
import models.race.Race;

public class Main {
    public static void main(String[] args) throws DuplicateModelException, ArgumentException {
        Race race = new Race(1.0, 1.0, 1.0, true);
        Engine engine = new JetEngine("Engine model", 123, 1200);
        Boat racer1 = new Yacht("Yacht12", 12, engine, 123);
        Boat racer2 = new PowerBoat("Yacht12", 12, engine, engine);

        race.addParticipant(racer1);
        race.addParticipant(racer2);
    }
}
