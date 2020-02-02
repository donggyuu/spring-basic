public class LambdaInThread {

    // 표준 함수형 인터페이스
    // https://sjh836.tistory.com/173
    public static void main(String[] args) {

        Runnable runnable = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
    }
}