package Pattern;

interface house {
    void rent();
}

class host implements house {

    @Override
    public void rent() {
        System.out.println("host 房东出租房子");
    }
}

public class Proxy implements house {
    private house host = new host();

    @Override
    public void rent() {
        getTime();
        getPrice();
        System.out.println("中介出租成功");
        host.rent();
    }

    public void getTime() {
        System.out.println("约时间");
    }

    public void getPrice() {
        System.out.println("讲价钱");
    }

    public static void main(String[] args) {
        Proxy proxy = new Proxy();
        proxy.rent();
    }
}
