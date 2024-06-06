package com.example.tk.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor

public class Customer {

    @Id
    @PositiveOrZero(message = "Id phải là số không âm")
    private int id;

    @NotBlank(message = "Tên không được để trống")
    @Size(min = 3, max = 50, message = "Tên phải có từ 3 đến 50 ký tự")
    private String name;

    @NotNull(message = "Số điện thoại không được để trống")
    @Digits(integer = 10, fraction = 0, message = "Số điện thoại phải là số nguyên có tối đa 10 chữ số")
    private long phone;

    @NotBlank(message = "Email không được để trống")
    @Email(message = "Email không đúng định dạng")
    private String email;
    @OneToMany(mappedBy = "customer")
    private Set<Order> orders;
}
