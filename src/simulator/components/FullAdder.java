package simulator.components;

import simulator.components.Gates.Or;

public class FullAdder extends Component {

    public FullAdder(String label, Wire a, Wire b, Wire cin) {
        super(label, a, b, cin);
        outputs.add(new Wire(false));
        outputs.add(new Wire(false));
    }

    @Override
    protected void runComponent() {
        HalfAdder halfAdder1 = new HalfAdder("half_1", getInput(0), getInput(1));
        halfAdder1.startComponent();
        HalfAdder halfAdder2 = new HalfAdder("half_2", getInput(2), halfAdder1.getOutput(0));
        halfAdder2.startComponent();
        Or or = new Or("or_1", halfAdder1.getOutput(1), halfAdder2.getOutput(1));
        outputs.set(0, halfAdder2.getOutput(0));
        outputs.set(1, or.getOutput(0));
    }
}
