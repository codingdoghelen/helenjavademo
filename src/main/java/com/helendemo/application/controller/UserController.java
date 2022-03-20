package com.helendemo.application.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/user")
@Api(value = "User Resource REST Endpoint", description = "Shows the user info")
public class UserController {

    @GetMapping
    public List<User> getUsers() {

        return Arrays.asList(
                new User("Sam", 2000L,"id01"),
                new User("Peter", 1000L,"id02")
        );
    }

    @GetMapping("/{userName}")
    public User getUser(@PathVariable("userName") final String userName) {
        return new User(userName, 1000L,"idTesting");
    }

    private class User {

        @ApiModelProperty(notes = "name of the User", required = true)
        private String userName;

        @ApiModelProperty(notes = "salary of the user")
        private Long salary;

        @ApiModelProperty(notes = "id of the user")
        private String userId;

        public User(String userName, Long salary, String userId) {
            this.userName = userName;
            this.salary = salary;
            this.userId = userId;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public Long getSalary() {
            return salary;
        }

        public void setSalary(Long salary) {
            this.salary = salary;
        }
    }
}
