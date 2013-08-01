package org.vano.concurrency.chapter4.multiple.tasks.first.result.processing;

import java.util.concurrent.Callable;

/**
 * Created with IntelliJ IDEA.
 * User: Ivan_Pukhau
 * Date: 6/12/13
 * Time: 6:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class TaskValidator implements Callable<String> {

    private UserValidator validator;

    private String user;
    private String password;

    public TaskValidator(UserValidator validator, String user, String password) {
        this.validator = validator;
        this.user = user;
        this.password = password;
    }

    @Override
    public String call() throws Exception {
        if(!validator.validate(user, password)) {
            System.out.printf("%s: The user has not been found\n", validator.getName());
            throw new Exception("Error validating user");
        }
        System.out.printf("%s: The user has been found\n", validator.getName());
        return validator.getName();
    }
}
