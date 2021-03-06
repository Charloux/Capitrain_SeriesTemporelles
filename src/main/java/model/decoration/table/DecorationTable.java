package model.decoration.table;

import java.util.HashMap;
import java.util.Objects;

import model.decoration.table.element.Element;
import model.seed.transducer.ArcSemanticLetter;

/**
 * Java implementation of a Decoration Table
 * Basically a list of {@link Instruction} with a list of Register and Returns
 * @author Chloe GUILBAUD &amp Maël MAINCHAIN
 */
public class DecorationTable {

    /**
     * Name of the {@link DecorationTable}
     */
    private String name;
    /**
     * {@link HashMap} of the registers, instantiates as {@link Element}
     */
    private HashMap<String, Element> registers;
    /**
     * {@link HashMap} of the returns, instantiates as {@link Element}
     */
    private HashMap<String, Element> returns;
    /**
     * {@link HashMap} of {@link Instruction}
     * Sort with {@link InstructionKey}
     */
    private HashMap<InstructionKey, Instruction> instructions;

    /**
     * Constructor
     * @param name Name of the {@link DecorationTable}
     */
    public DecorationTable(String name) {
        this.name = name;
        this.registers = new HashMap<>();
        this.returns = new HashMap<>();
        this.instructions = new HashMap<>();
    }

    public String getName() {
        return this.name;
    }

    public void addRegister(String key, Element register) {
        this.registers.put(key, register);
    }

    public void addReturn(String key, Element returnElement) {
        this.returns.put(key, returnElement);
    }

    /**
     * Add an {@link Instruction} to the {@link Instruction}'s {@link HashMap}
     * thanks to an {@link InstructionKey} built with an {@link ArcSemanticLetter}
     * and an After
     * @param letter    {@link ArcSemanticLetter}
     * @param after     {@link Integer}
     * @param instruction   {@link Instruction}
     */
    public void addInstruction(ArcSemanticLetter letter, Integer after, Instruction instruction) {
        this.instructions.put(new InstructionKey(letter, after), instruction);
    }

    /**
     * Add an {@link Instruction} to the {@link Instruction}'s {@link HashMap}
     * thanks to an {@link InstructionKey} built with an {@link ArcSemanticLetter}
     * @param letter    {@link ArcSemanticLetter}
     * @param instruction   {@link Instruction}
     */
    public void addInstruction(ArcSemanticLetter letter, Instruction instruction) {
        this.instructions.put(new InstructionKey(letter), instruction);
    }

    public Element getRegister(String key) {
        return this.registers.get(key);
    }

    public Element getReturn(String key) {
        return this.returns.get(key);
    }

    public Instruction getInstruction(ArcSemanticLetter letter, int after) {
        return this.instructions.get(new InstructionKey(letter, after));
    }

    public HashMap<String, Element> getRegisters() {
        return this.registers;
    }

    public HashMap<String, Element> getReturns() {
        return this.returns;
    }

    public HashMap<InstructionKey, Instruction> getInstructions() {
        return this.instructions;
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        this.instructions.forEach((key, value) -> {
            buffer.append(key.toString() + " || " + value.toString() + "\n");
        });
        return buffer.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DecorationTable that = (DecorationTable) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(registers, that.registers) &&
                Objects.equals(returns, that.returns) &&
                Objects.equals(instructions, that.instructions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, registers, returns, instructions);
    }
}
