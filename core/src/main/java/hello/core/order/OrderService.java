package hello.core.order;

public interface OrderService {
    // 메소드,,
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
