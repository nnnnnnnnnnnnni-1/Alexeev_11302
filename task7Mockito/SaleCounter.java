import java.util.Random;

public class SaleCounter implements DiscountRepository {

    @Override
    public int getDiscountForUser(Long userId) {
        return 10;
    }
}
