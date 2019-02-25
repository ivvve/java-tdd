package coupon;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CouponStubTest {

    @Test
    public void testGetLastOccupiedCoupon() {
        User user = new User("area88");

        ICoupon eventCoupon = new StubCoupon();
        user.addCoupon(eventCoupon);
        ICoupon lastCoupon = user.getLastOccupiedCoupon();

        assertEquals("쿠폰 할인률", 7, lastCoupon.getDiscountPercent());
        assertEquals("쿠폰 이름", "VIP 고객 한가위 감사쿠폰*", lastCoupon.getName());
    }

    @Test
    public void testGetOrderPrice_discountableItem() {
        PriceCalculator calculator = new PriceCalculator();
        Item item = new Item("LightSavor", "부엌칼", 100000);
        ICoupon coupon = new StubCoupon();

        assertEquals("쿠폰으로 인해 할인된 가격", 93000, calculator.getOrderPrice(item, coupon));
    }
}
