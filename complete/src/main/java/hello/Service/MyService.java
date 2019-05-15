package hello.Service;

import org.springframework.stereotype.Component;

@Component
public class MyService {

    public String sayHello(){
        return "Hello SpringBoot calling from test1" ;
    }

}