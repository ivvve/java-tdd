package coupon;

/**
 * 특정 상태나 모습을 대표하는 stub 객체
 */
public class StubCoupon implements ICoupon {
    @Override
    public String getName() {
        return "VIP 고객 한가위 감사쿠폰*";
    }

    @Override
    public boolean isValid() {
        return true;
    }

    @Override
    public int getDiscountPercent() {
        return 7;
    }

    @Override
    public boolean isAppliable(Item item) {
        return true;
    }

    @Override
    public void doExpire() {

    }
}
