package com.rc.clickr.api;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


@Data
@RequiredArgsConstructor
@NoArgsConstructor
class ClickDto{
    @NonNull
    private String session;
    @NonNull
    private String userName;
}


@Data
@RequiredArgsConstructor
class ClickRegisterDto  extends  ClickDto {
    @NonNull
    private String colour;

}