package com.store.bachend.shift.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "store.pc")
@NoArgsConstructor
@AllArgsConstructor
public class PcEntity extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "serial_number")
    private String serialNumber;

    @Column(name = "creator")
    private String creator;

    @Column(name = "price")
    private Integer price;

    @Column(name = "count_in_store")
    private Integer countInStore;

    @Column(name = "form_factor")
    private String formFactor;

}

