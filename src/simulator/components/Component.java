package simulator.components;

import java.util.ArrayList;

public abstract class Component implements Runnable {
    protected String label;
    protected ArrayList<Wire> inputs;
    protected ArrayList<Wire> outputs;
    protected long delay;
    protected Thread thread;

    protected Component(String label, Wire ... inputs) {
        this(label, 0, inputs);
    }

    protected Component(String label, long delay, Wire ... inputs) {
        this.label = label;
        this.delay = delay;
        outputs = new ArrayList<>();
        this.inputs = new ArrayList<>();
        for (Wire w : inputs) {
            this.inputs.add(w);
        }
        thread = new Thread(this);
        thread.start();
    }

    public abstract void runComponent();

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            runComponent();
        }
    }

    public void addInput(Wire w) {
        inputs.add(w);
    }

    public void setInput(Wire inputWire, int inputIndex) {
        if(getInputs().size() <= inputIndex) {
            while (getInputs().size() < inputIndex) {
                addInput(new Wire());
            }
            addInput(inputWire);
        } else {
            inputs.set(inputIndex, inputWire);
        }
    }

    public String getLabel() {
        return label;
    }

    public Wire getOutput(int index) {
        return outputs.get(index);
    }

    public ArrayList<Wire> getOutputs() {
        return outputs;
    }


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