package com.auxolabs.configs;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;

@Data
public class ResponseModel {
    //these variable with datatype must be the same as in api
    //more variables can be added here or in api

    private String id1;
    private String n1;
    private String n2;
    ArrayList<String> a=new ArrayList<String>();
    HashMap<Integer,String> hm=new HashMap();
    String check;
}
