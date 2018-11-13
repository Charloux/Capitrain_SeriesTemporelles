package parser.decoration.table.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class RegistersPOJO {

    private String name;
    private String index;
    private ValuePOJO value;

    public String getName() {
        return name;
    }

    public String getIndex() {
        return index;
    }

    public ValuePOJO getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "RegistersPOJO{" +
                "name='" + name + '\'' +
                ", index='" + index + '\'' +
                ", value=" + value +
                '}';
    }
}
