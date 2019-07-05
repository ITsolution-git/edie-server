package com.securegion.eddieui.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Cheng on 2/18/17.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Result<E> {
    private boolean success;
    private E object;
    private String info;
}
