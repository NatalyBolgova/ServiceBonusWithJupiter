public class Main {
    public static void main(String[] args) {
        BonusService service = new BonusService();

        long amount = 1000_60;
        boolean registered = true;
        long expected = 30;

        long actual = service.calculate(amount, registered);
        boolean passed = actual == expected;

        System.out.println(passed);

        long bonusOverLimitForRegistered = service.calculate(1000000_60, true);
        System.out.println(bonusOverLimitForRegistered);

        long bonusUnderLimitForUnRegistered = service.calculate(1000_60, false);
        System.out.println(bonusUnderLimitForUnRegistered);

        long bonusOverLimitForUnRegistered = service.calculate(1000000_60, false);
        System.out.println(bonusOverLimitForUnRegistered);

        long bonusUnderLimitForRegistered = service.calculate(150000_60, true);
        System.out.println(bonusUnderLimitForRegistered);

    }
}


