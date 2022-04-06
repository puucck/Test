package reflection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author www
 * @version 1.0
 * @date 2021/9/23
 * @effect
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    private Long id;
    private String name;
    private int age;
    public Customer(String name,int age){
        this.name=name;
        this.age=age;
    }
}
