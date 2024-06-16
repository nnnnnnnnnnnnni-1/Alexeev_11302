import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.jupiter.api.*;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class SaleCounterTest {

    @Mock
    private DiscountRepository discountRepository;
    private BucketService bucketService;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        bucketService = new BucketSaleCounter(discountRepository);
    }

    @Test
    public void testRecalculateBucketCost() {
        Purchase purchase1 = Mockito.mock(Purchase.class);
        when(purchase1.getCost()).thenReturn(BigDecimal.valueOf(100));
        when(purchase1.getGoodId()).thenReturn(1L);
        Purchase purchase2 = Mockito.mock(Purchase.class);
        when(purchase1.getCost()).thenReturn(BigDecimal.valueOf(200));
        when(purchase1.getGoodId()).thenReturn(2L);

        List<Purchase> purchases = Arrays.asList(purchase1, purchase2);
        Bucket bucket = new Bucket(purchases);
        long userId = 3L;

        when(discountRepository.getDiscountForUser(userId)).thenReturn(10);

        double expectedCost = 270.0;
        assertEquals(bucket.getPurchases().stream().map(Purchase::getCost).reduce(BigDecimal.ZERO, BigDecimal::add), BigDecimal.valueOf(expectedCost));
        verify(discountRepository, times(1)).getDiscountForUser(userId);
    }
}
