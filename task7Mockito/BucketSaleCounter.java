import java.math.BigDecimal;

public class BucketSaleCounter implements BucketService {
    private final DiscountRepository discountRepository;

    public BucketSaleCounter(DiscountRepository discountRepository) {
        this.discountRepository = discountRepository;
    }


    @Override
    public Bucket calculateDiscountForBucket(long userId, Bucket bucket) {
        double discount = discountRepository.getDiscountForUser(userId);
        for (Purchase purchase : bucket.getPurchases()) {
            purchase.setCost(purchase.getCost().multiply(BigDecimal.valueOf(100 - discount)).divide(BigDecimal.valueOf(100)));
        }
        return bucket;
    }
}
