public class MathOperation
{
    private int leftOperand;
    private int rightOperand;
    private Operation operation;

    public MathOperation(Operation operation, int leftOperand, int rightOperand)
    {
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
        this.operation = operation;
    }

    public int GetResult()
    {
        return operation.operate(leftOperand, rightOperand);
    }
}
