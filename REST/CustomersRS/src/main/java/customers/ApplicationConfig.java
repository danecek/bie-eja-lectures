/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customers;

import java.util.Collections;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;


@ApplicationPath("/customersApp")
public class ApplicationConfig extends Application {

    @Override
    public Set<Object> getSingletons() {
        return Collections.singleton(new CustomersResource());
    }

}
