package simulator.components;

public class Clock extends Component {
    private boolean state;

    public Clock(String label, long delay, Wire... inputs) {
        super(label, delay, inputs);
        state = false;
        outputs.add(new Wire(false));
    }

    private void toggle() {
        state = !state;
    }

    @Override
    public void runComponent() {
        toggle();
        getOutput(0).setSignal(state);
    }
}
