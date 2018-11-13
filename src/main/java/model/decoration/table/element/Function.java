package model.decoration.table.element;

import model.decoration.table.element.Element;

import java.util.List;

public class Function extends Element {

    private String name;
    private List<Element> parameters;

    public Function(String name, List<Element> parameters) {
        this.name = name;
        this.parameters = parameters;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Element> getParameters() {
        return parameters;
    }

    public void setParameters(List<Element> parameters) {
        this.parameters = parameters;
    }

    @Override
    public String toString() {
        return "Function{" +
                "name='" + name + '\'' +
                ", parameters=" + parameters +
                '}';
    }

}