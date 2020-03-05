package com.ownsolutiongroup.rentACar.dto;

public class DriverDto {
    private Long id;
    private String driver_name;
    private String driver_nic;
    private String driver_licence_no;
    private Integer driver_age;
    private String driver_address;
    private String driver_tel;
    private String driver_status;
    private Integer isEnable;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDriver_name() {
        return driver_name;
    }

    public void setDriver_name(String driver_name) {
        this.driver_name = driver_name;
    }

    public String getDriver_nic() {
        return driver_nic;
    }

    public void setDriver_nic(String driver_nic) {
        this.driver_nic = driver_nic;
    }

    public String getDriver_licence_no() {
        return driver_licence_no;
    }

    public void setDriver_licence_no(String driver_licence_no) {
        this.driver_licence_no = driver_licence_no;
    }

    public Integer getDriver_age() {
        return driver_age;
    }

    public void setDriver_age(Integer driver_age) {
        this.driver_age = driver_age;
    }

    public String getDriver_address() {
        return driver_address;
    }

    public void setDriver_address(String driver_address) {
        this.driver_address = driver_address;
    }

    public String getDriver_tel() {
        return driver_tel;
    }

    public void setDriver_tel(String driver_tel) {
        this.driver_tel = driver_tel;
    }

    public String getDriver_status() {
        return driver_status;
    }

    public void setDriver_status(String driver_status) {
        this.driver_status = driver_status;
    }

    public Integer getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(Integer isEnable) {
        this.isEnable = isEnable;
    }
}
