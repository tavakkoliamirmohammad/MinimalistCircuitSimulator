package simulator.components;

import simulator.components.Gates.And;
import simulator.components.Gates.Xor;

public class HalfAdder extends Component {
    public HalfAdder(String label, Wire a, Wire b) {
        super(label, a, b);
        outputs.add(new Wire());
        outputs.add(new Wire());
    }

    @Override
    protected void runComponent() {
        Xor sum = new Xor("xor_1", getInput(0), getInput(1));
        And carry = new And("and_1", getInput(0), getInput(1));
        Layer layer = new Layer("layer_1");
        layer.addComponent(sum, carry);
        layer.startComponent();
        for (int i = 0; i < outputs.size(); ++i) {
            outputs.set(i, layer.layerOutputs().get(i));
        }
    }
}
