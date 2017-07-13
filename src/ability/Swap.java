package ability;

import main.AbilityLogic;
import main.Target;

import java.util.List;

public class Swap extends AbilityLogic {

    private Target source;
    private Target destination;

    public Swap(List<String> logic) {
        super("swap");
        this.logic = logic;
        parse();
    }

    public void parse() {

        if (!logic.get(0).equals("source")) {
            throw new IllegalArgumentException("Expecting word 'source'");
        }
        logic.remove(0);

        // Parse Source
        this.source = new Target(logic);
        this.logic = source.getLogic();

        if (!logic.get(0).equals("destination")) {
            throw new IllegalArgumentException("Expecting word 'destination'");
        }
        logic.remove(0);

        // Parse Destination
        this.destination = new Target(logic);
        this.logic = destination.getLogic();

    }

    @Override
    public String toString() {
        return "Swap{" +
                "source=" + source +
                ", destination=" + destination +
                '}';
    }
}
