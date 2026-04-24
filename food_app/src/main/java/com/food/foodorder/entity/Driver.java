package com.team11.foodorder.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@DiscriminatorValue("Driver")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Driver extends AppUser {
    private String vehicleNumber;
}
