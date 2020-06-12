package com.kaike.servicebase.exceptionhandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KaikeException extends RuntimeException {

    private Integer code;

    private String msg;

}
