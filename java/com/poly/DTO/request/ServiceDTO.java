package com.poly.DTO.request;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ServiceDTO {
    String name;
    String description;
    Double price;
    String photo;
}
