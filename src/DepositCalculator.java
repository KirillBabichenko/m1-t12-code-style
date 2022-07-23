import java.util.Scanner;

public class DepositCalculator {
    double calculateComplexPercent(double depositAmount, double yearRate, int depositPeriod) {
        double payment = depositAmount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
        return calculatePercent(payment, 2);
    }

    double calculateSimplePercent(double depositAmount, double yearRate, int depositPeriod) {
        return calculatePercent(depositAmount + depositAmount * yearRate * depositPeriod, 2);
    }

    double calculatePercent(double value, int exponent) {
        double scale= Math.pow(10, exponent);
        return Math.round(value * scale) / scale;
    }

    void calculateDeposit( ) {
        int depositPeriod;
        int userAction;
        int depositAmount;
        double depositPlusInterest = 0;
        Scanner userInput = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:");
        depositAmount = userInput.nextInt();
        System.out.println("Введите срок вклада в годах:");
        depositPeriod = userInput.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        userAction = userInput.nextInt();
        if (userAction == 1) {
            depositPlusInterest = calculateSimplePercent(depositAmount, 0.06, depositPeriod);
        } else if (userAction == 2) {
            depositPlusInterest = calculateComplexPercent(depositAmount, 0.06, depositPeriod);
        }
        System.out.println("Результат вклада: " + depositAmount + " за " + depositPeriod + " лет превратятся в " +
                depositPlusInterest);
    }

    public static void main(String[] args) {
        new DepositCalculator().calculateDeposit();
    }
}
