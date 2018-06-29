import java.util.List;
import java.util.ArrayList;

// Square is a composite, making up the Composite pattern (contains components)
public class Square extends BoardComponent {
    private final List<BoardComponent> children;
    private final List<Building> buildings;
    private BoardComponent parent;

    public Square() {
        super();
        children = new ArrayList<BoardComponent>();
        buildings = new ArrayList<>();
    }

    @Override
    public void Operation() {
        ArrayList<BoardComponent> childrenCopy = new ArrayList<BoardComponent>(children);
        for (int i = 0; i < childrenCopy.size(); i++) {
            BoardComponent child = childrenCopy.get(i);
            child.Operation();
        }
    }

    @Override
    public void Add(BoardComponent child) {
        // I am now this child's parent.
        children.add(child);
        if (child instanceof Building) {
            buildings.add((Building) child);
        }
        child.SetParent(this);
    }

    @Override
    public void Remove(BoardComponent child) {
        children.remove(child);
        if (child instanceof Building) {
            buildings.remove(child);
        }
    }

    public void addTheShield() {
        for (Building building: buildings) {
            building.setProtectedByShield(true);
        }
    }

    public void removeTheShield() {
        for (Building building: buildings) {
            building.setProtectedByShield(false);
        }
    }

    public List<Building> getBuildings() {
        return this.buildings;
    }

    public List<BoardComponent> getChildren() {
        return this.children;
    }
}