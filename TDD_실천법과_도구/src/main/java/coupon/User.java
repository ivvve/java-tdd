package coupon;

import java.util.ArrayList;
import java.util.List;

public class User {
    public String name;
    public List<ICoupon> couponList = new ArrayList<>();

    public User(String name) {
        this.name = name;
    }

    public int getTotalCouponCount() {
        return couponList.size();
    }

    public void addCoupon(ICoupon coupon) {
        couponList.add(coupon);
    }

    public ICoupon getLastOccupiedCoupon() {
        return couponList.get(couponList.size() - 1);
    }
}
