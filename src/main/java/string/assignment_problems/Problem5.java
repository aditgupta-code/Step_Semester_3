public class Problem5 {
    static class Cart {
        private final double[] prices;
        private int count;
        private final String cartId;
        public Cart(String cartId, int maxItems){
            this.cartId = cartId;
            this.prices = new double[maxItems];
            this.count = 0;
        }
        public void addItem(double price) {
            if (count < prices.length) {
                prices[count] = price;
                count++;
            }
        }
        public double getTotal() {
            double total = 0;
            for (int i = 0; i < count; i++) {
                total += prices[i];
            }
            return total;
        }
        public int getItemCount() {
            return count;
        }
    }
    public static void main(String[] args){
        Cart cart = new Cart("CART-5", 20);
        cart.addItem(250);
        cart.addItem(99);
        cart.addItem(151);
        System.out.println("getTotal() -> " + cart.getTotal());
        System.out.println("getItemCount() -> " + cart.getItemCount());
    }
}