public class LambdaVsAnonymous {

   public static void main(String args[]) {

       Customer customer = new Customer();

       customer.order(new Order() {
           public String something(String menu, String size) {
               String receipt = "menu : " + menu + ", size : " + size;
               return receipt;
           }
       });

       customer.order((menu, size) -> {
           String receipt = "menu : " + menu + ", size : " + size;
           return receipt;
       });


    }

    @FunctionalInterface
    interface  Order {
        String something(String menu, String size);
    }

    static class Customer {
        public void order(Order coffee) {

            String receipt = coffee.something("vanilla_latte", "tall");
            System.out.println("receipt = " + receipt);
        }
    }

}
