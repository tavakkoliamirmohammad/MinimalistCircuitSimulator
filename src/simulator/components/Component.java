package simulator.components;

import simulator.control.Circuit;

import java.util.ArrayList;

public abstract class Component implements Runnable, Connectable {
    protected String label;
    protected ArrayList<Wire> inputs;
    protected ArrayList<Wire> outputs;
    protected long delay;
//    protected Thread thread;

    protected Component(String label, Wire... inputs) {
        this(label, 0, inputs);
    }

    protected Component(String label, long delay, Wire... inputs) {
        this.label = label;
        this.delay = delay;
        outputs = new ArrayList<>();
        this.inputs = new ArrayList<>();
        for (Wire w : inputs) {
            this.inputs.add(w);
        }
//        thread = new Thread(this);
//        Circuit.addComponent(this);
    }

    protected abstract void runComponent();

    @Override
    public void run() {
//        try {
//            Thread.sleep(delay);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        runComponent();
    }

    public void startComponent() {
        run();
//        thread.start();
    }

    public void addInput(Wire... inputWires) {
        for (Wire w : inputWires) {
            inputs.add(w);
        }
    }

    @Override
    public void setInput(Wire inputWire, int inputIndex) {
        if (getInputs().size() <= inputIndex) {
            while (getInputs().size() < inputIndex) {
                addInput(new Wire());
            }
            addInput(inputWire);
        } else {
            inputs.set(inputIndex, inputWire);
        }
    }

    @Override
    public Wire getOutput(int index) {
        return outputs.get(index);
    }

    @Override
    public Wire getInput(int index) {
        return inputs.get(index);
    }

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public ArrayList<Wire> getOutputs() {
        return outputs;
    }

    @Override
    public ArrayList<Wire> getInputs() {
        return inputs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Component component = (Component) o;

        return label.equals(component.label);
    }

    @Override
    public int hashCode() {
        return label.hashCode();
    }
}
