package hello.core.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

//Use Bean
public class NetworkClient2{

    private String url;

    public NetworkClient2() {
        System.out.println("생성자 호출 url = " + url);
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void connect(){
        System.out.println("connect : " + url);
    }

    public void call(String message){
        System.out.println("call: " + url + "message = " + message);
    }

    //서비스 종료 시 호출
    public void disconnect(){
        System.out.println("close = " + url);
    }

    //의존관계 주입이 끝나면 호출
    public void init() throws Exception {
        System.out.println("init  ");
        connect();
        call("초기화 연결 메시지");
    }

    public void close() throws Exception {
        System.out.println("!!!!!close!!!!!");
        disconnect();
    }
}