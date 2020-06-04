package simulator.components.Gates;

import simulator.components.Component;
import simulator.components.Wire;

public class And extends Component {
    public And(String label, Wire... inputs) {
        super(label, inputs);
        outputs.add(new Wire(false));
    }

    @Override
    protected void runComponent() {
        Wire result = new Wire(true);
        for (Wire w: inputs) {
            result.setSignal(result.getSignal() && w.getSignal());
        }

        getOutput(0).setSignal(result.getSignal());
    }
}
