package simulator.components;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Layer extends Component {
    private List<Component> componentList;

    public Layer(String label) {
        super(label);
        componentList = new ArrayList<>();
    }


    public void addComponent(Component... component) {
        componentList.addAll(Arrays.asList(component));
    }

    @Override
    protected void runComponent() {
        for (Component c : componentList)
            c.startComponent();
    }

    public List<Wire> layerOutputs() {
        List<Wire> wires = new ArrayList<>();
        for (Component c : componentList) {
            wires.addAll(c.outputs);
        }
        return wires;
    }
}
