public class Calculator
{
    private static Operation operation;

    public static int Divide(int left, int right)
    {
        operation = new DivideOperation();
        MathOperation op = new MathOperation(operation, left, right);
        return op.GetResult();
    }

    public static int Multiply(int left, int right)
    {
        operation = new MultiplyOperation();
        MathOperation op = new MathOperation(operation, left, right);
        return op.GetResult();
    }

    public static int Add(int left, int right)
    {
        operation = new AddOperation();
        MathOperation op = new MathOperation(operation, left, right);
        return op.GetResult();
    }

    public static int Subtract(int left, int right)
    {
        operation = new SubtractOperation();
        MathOperation op = new MathOperation(operation, left, right);
        return op.GetResult();
    }
}
