package simulator.components.Gates;

import simulator.components.Component;
import simulator.components.Wire;

public class Not extends Component {
    public Not(String label, Wire... inputs) {
        super(label, inputs);
        for(int i = 0; i < inputs.length; ++i) {
           outputs.add(new Wire(false));
        }
    }

    @Override
    protected void runComponent() {
        for(int i = 0; i < inputs.size(); ++i) {
            outputs.get(i).setSignal(!inputs.get(i).getSignal());
        }
    }
}
