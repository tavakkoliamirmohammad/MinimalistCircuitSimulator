//Dedicated to Goli

package simulator;

import simulator.components.*;
import simulator.control.*;

public class Main {

    public static void main(String[] args) {
        Wire a0 = new Wire(true);
        Wire a1 = new Wire(true);
        FullAdder fullAdder = new FullAdder("my_half", a0, a1, new Wire(true));
        fullAdder.startComponent();
        for (Wire x : fullAdder.getOutputs()) {
            System.out.println(x.getSignal());
        }

    }
}
