package task2;

import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Order order = new Order.OrderBuilder(1, List.of("kiwi", "apple"), 200)
                .withDeliveryAddress("Київ, вул. Контрактова площа 1")
                .withGiftWrap(true)
                .withNote("Зателефонуйте мені як прийде замовлення")
                .build();

        Order order2 = new Order.OrderBuilder(1, List.of("zucchini", "eggplant"), 300)
                .withGiftWrap(true)
                .withNote("Зателефонуйте мені як прийде замовлення")
                .withCouponCode("121451asdFrfgAfrfArggt158234")
                .build();
    }
}


class Order {
    private int id;
    private List<String> items;
    private double totalPrice;
    private String deliveryAddress;
    private boolean giftWrap;
    private String note;
    private Date deliveryDate;
    private String couponCode;

    private Order(int id,
                  List<String> items,
                  double totalPrice,
                  String deliveryAddress,
                  boolean giftWrap,
                  String note,
                  Date deliveryDate,
                  String couponCode) {
        this.id = id;
        this.items = items;
        this.totalPrice = totalPrice;
        this.deliveryAddress = deliveryAddress;
        this.giftWrap = giftWrap;
        this.note = note;
        this.deliveryDate = deliveryDate;
        this.couponCode = couponCode;
    }

    public static OrderBuilder builder(int id, List<String> items, double totalPrice) {
        return new OrderBuilder(id, items, totalPrice);
    }

    public static class OrderBuilder {
        private int id;
        private List<String> items;
        private double totalPrice;
        private String deliveryAddress;
        private boolean giftWrap;
        private String note;
        private Date deliveryDate;
        private String couponCode;

        public OrderBuilder(int id, List<String> items, double totalPrice) {
            this.id = id;
            this.items = items;
            this.totalPrice = totalPrice;
        }

        public OrderBuilder withDeliveryAddress(String deliveryAddress) {
            this.deliveryAddress = deliveryAddress;
            return this;
        }

        public OrderBuilder withGiftWrap(boolean giftWrap) {
            this.giftWrap = giftWrap;
            return this;
        }

        public OrderBuilder withNote(String note) {
            this.note = note;
            return this;
        }

        public OrderBuilder withDeliveryDate(Date deliveryDate) {
            this.deliveryDate = deliveryDate;
            return this;
        }

        public OrderBuilder withCouponCode(String couponCode) {
            this.couponCode = couponCode;
            return this;
        }

        public Order build() {
            return new Order(id, items, totalPrice, deliveryAddress, giftWrap, note, deliveryDate, couponCode);
        }
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public boolean isGiftWrap() {
        return giftWrap;
    }

    public void setGiftWrap(boolean giftWrap) {
        this.giftWrap = giftWrap;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }
}