package org.eja.ejbannot;

import javax.ejb.Remote;
import javax.ejb.Stateless;

//@Stateless(name = "HelloBeanName")
//@EJBs({
//    @EJB(name = "java:global/GlobalHello",
//            beanInterface = org.eja.ejbannot.Hello.class)
//        ,
//    @EJB(name = "java:global/GlobalBye",
//            beanInterface = org.eja.ejbannot.Bye.class)
//})
//@Remote(Hello.class)
public class HelloBean implements Hello, Bye {

    @Override
    public String hello() {
        return "Hello";
    }

    @Override
    public String bye() {
        return "Bye";
    }

}
