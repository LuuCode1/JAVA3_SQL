package com.example.tk.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
public class Order {
    @Id
    @PositiveOrZero(message = "Id phải là số không âm")
    @NotNull(message = "Không được để trống")
    private Integer  id;

    @NotBlank(message = "Tên đơn hàng không được để trống")
    @Size(max = 100, message = "Tên đơn hàng không được quá 100 ký tự")
    private String nameorder;

    @PositiveOrZero(message = "Số lượng phải là số không âm")
    @NotNull(message = "Không được để trống")
    private Integer quantity;

    @Positive(message = "Giá phải là số dương")
    @NotNull(message = "Không được để trống")
    private Double price;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;


}
