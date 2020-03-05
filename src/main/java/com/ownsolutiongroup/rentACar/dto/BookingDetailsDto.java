package com.ownsolutiongroup.rentACar.dto;

import java.util.List;

public class BookingDetailsDto {
    private Long id;
    List<Long> vehicleDtoList;
    List<Long> driverDtoList;
    BookDto bookDto;
    private String book_ytpe;
    private Integer rented_date;
    private Integer start_mileage;
    private Integer end_mileage;
    private Double rented_cost;
    private Double additional_cost;
    private Double damage_cost;
    private String booking_status;
    private Integer isEnable;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Long> getVehicleDtoList() {
        return vehicleDtoList;
    }

    public void setVehicleDtoList(List<Long> vehicleDtoList) {
        this.vehicleDtoList = vehicleDtoList;
    }

    public List<Long> getDriverDtoList() {
        return driverDtoList;
    }

    public void setDriverDtoList(List<Long> driverDtoList) {
        this.driverDtoList = driverDtoList;
    }

    public BookDto getBookDto() {
        return bookDto;
    }

    public void setBookDto(BookDto bookDto) {
        this.bookDto = bookDto;
    }

    public String getBook_ytpe() {
        return book_ytpe;
    }

    public void setBook_ytpe(String book_ytpe) {
        this.book_ytpe = book_ytpe;
    }

    public Integer getRented_date() {
        return rented_date;
    }

    public void setRented_date(Integer rented_date) {
        this.rented_date = rented_date;
    }

    public Integer getStart_mileage() {
        return start_mileage;
    }

    public void setStart_mileage(Integer start_mileage) {
        this.start_mileage = start_mileage;
    }

    public Integer getEnd_mileage() {
        return end_mileage;
    }

    public void setEnd_mileage(Integer end_mileage) {
        this.end_mileage = end_mileage;
    }

    public Double getRented_cost() {
        return rented_cost;
    }

    public void setRented_cost(Double rented_cost) {
        this.rented_cost = rented_cost;
    }

    public Double getAdditional_cost() {
        return additional_cost;
    }

    public void setAdditional_cost(Double additional_cost) {
        this.additional_cost = additional_cost;
    }

    public Double getDamage_cost() {
        return damage_cost;
    }

    public void setDamage_cost(Double damage_cost) {
        this.damage_cost = damage_cost;
    }

    public String getBooking_status() {
        return booking_status;
    }

    public void setBooking_status(String booking_status) {
        this.booking_status = booking_status;
    }

    public Integer getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(Integer isEnable) {
        this.isEnable = isEnable;
    }
}
