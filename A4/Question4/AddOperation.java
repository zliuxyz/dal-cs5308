public class AddOperation implements Operation
{
    @Override
    public int operate(int leftOperand, int rightOperand)
    {
        return leftOperand + rightOperand;
    }
}
