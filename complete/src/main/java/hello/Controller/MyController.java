package hello.Controller;

import hello.Bean.Greeting;
import hello.Service.MyService;
import hello.Bean.PersonBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Component
@RequestMapping("/demo")
public class MyController {

    private MyService myService;

    @Autowired
    public void setService(MyService myService){
        System.out.println("myService is injected!");
        this.myService = myService;
    }

    @ResponseBody
    @RequestMapping(value = "/test1" , method = RequestMethod.GET)
    public String deal_request_1(){
        return myService.sayHello();
    }

    @ResponseBody
    @RequestMapping(value = "/test2" ,method = RequestMethod.GET)
    public String deal_request_2(String name,int age){
        return "Hello SpringBoot, this is " + name + " age " + age  + "calling from test2" ;
    }

    @ResponseBody
    @RequestMapping(value = "/test3/{name}/{age}" ,method = RequestMethod.GET)
    public String deal_request_3(@PathVariable String name,@PathVariable int age){
        return "Hello SpringBoot, this is " + name + " age " + age  + "calling from test3";
    }

    //通过Bean来传递数据
    @ResponseBody
    @Autowired
    @RequestMapping(value = "/test4" , method = RequestMethod.GET)
    public String deal_request_4(PersonBean mPersonBean){
        return "Hello SpringBoot, this is " + mPersonBean.getName() + " age " + mPersonBean.getAge()  + "calling from test4";
    }

    //通过Bean来传递数据
    @ResponseBody
    @Autowired
    @RequestMapping(value = "/test5" , method = RequestMethod.POST)
    public String deal_request_5(PersonBean mPersonBean){
        return "Hello SpringBoot, this is " + mPersonBean.getName() + " age " + mPersonBean.getAge()  + "calling from test5";
    }

    //通过JSON来传递数据
    @ResponseBody
    @Autowired
    @RequestMapping(value = "/test6" , method = RequestMethod.POST)
    public String deal_request_6(@RequestBody PersonBean mPersonBean){
        return "Hello SpringBoot, this is " + mPersonBean.getName() + " age " + mPersonBean.getAge()  + "calling from test6";
    }

    //传入json传出json，zrt
    @ResponseBody
    @RequestMapping(value = "/test7" , method = RequestMethod.POST)
    public Greeting deal_request_7(@RequestBody PersonBean mPersonBean){
        return new Greeting(5, "hello");
    }

}
