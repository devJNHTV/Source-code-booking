package com.poly.DTO.response;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Message {
    boolean status;
    String message;
    int code;
    Object data;
}
