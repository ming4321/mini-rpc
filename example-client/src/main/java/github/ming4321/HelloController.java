package github.ming4321;

import github.ming4321.annotation.RpcReference;
import org.springframework.stereotype.Component;


@Component
public class HelloController {

    @RpcReference(version = "version1", group = "test1")
    private HelloService helloService;

    public void test() throws InterruptedException {
        String hello = this.helloService.hello(new Hello("1111111", "first"));

        assert "Hello description is 222".equals(hello);
        Thread.sleep(12000);
        for (int i = 0; i < 10; i++) {
            System.out.println(helloService.hello(new Hello("1111111", "first")));
        }
    }
}
