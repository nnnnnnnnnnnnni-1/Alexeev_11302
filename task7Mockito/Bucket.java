import java.util.List;
import java.util.Objects;

public class Bucket {
    private List<Purchase> purchases;
    public Bucket(List<Purchase> purchases) {
        this.purchases = purchases;
    }
    public List<Purchase> getPurchases() {
        return purchases;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bucket bucket = (Bucket) o;
        return Objects.equals(purchases, bucket.purchases);
    }

    @Override
    public int hashCode() {
        return Objects.hash(purchases);
    }
}

