package com.hujingli.spring.ioc.domain;

import com.hujingli.spring.ioc.annotation.Super;

/**
 * @author huh20
 * @since
 */
@Super
public class SuperUser  extends User{

    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "SuperUser{" +
                "address='" + address + '\'' +
                "} " + super.toString();
    }
}
