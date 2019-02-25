package coupon;

import org.junit.Test;

import static org.junit.Assert.*;

public class CouponDummyTest {

    @Test
    public void testAddCoupon() {
        User user = new User("area88");
        assertEquals(0, user.getTotalCouponCount());

        ICoupon coupon = new DummyCoupon();

        user.addCoupon(coupon);
        assertEquals(1, user.getTotalCouponCount());
    }
}
