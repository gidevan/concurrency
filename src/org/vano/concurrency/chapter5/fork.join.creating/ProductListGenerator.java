package org.vano.concurrency.chapter5.fork.join.creating;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Ivan_Pukhau
 * Date: 8/15/13
 * Time: 4:19 PM
 * To change this template use File | Settings | File Templates.
 */
public class ProductListGenerator {

    public List<Product> generate(int size) {
        List<Product> ret = new ArrayList<>();
        for(int i = 0; i < size; i++) {
            Product product = new Product();
            product.setName("Product-" + i);
            product.setPrice(10);
            ret.add(product);
        }
        return ret;
    }
}
