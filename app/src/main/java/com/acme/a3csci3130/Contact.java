package com.acme.a3csci3130;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Class that defines how the data will be stored in the
 * Firebase databse. This is converted to a JSON format
 *
 * created by Juliano Franz, adapted by Devin Peck
 */

public class Contact implements Serializable {

    public  String uid;
    public  String businessNumber;
    public  String name;
    public  String primaryBusiness;
    public  String address;
    public  String province;

    public Contact() {
        // Default constructor required for calls to DataSnapshot.getValue
    }

    /**
     * constructor for the business.
     * @param uid
     * @param businessNumber
     * @param name
     * @param primaryBusiness
     * @param address
     * @param province
     */

    public Contact(String uid, String businessNumber, String name, String primaryBusiness, String address, String province){
        this.uid = uid;
        this.businessNumber = businessNumber;
        this.name = name;
        this.primaryBusiness = primaryBusiness;
        this.address = address;
        this.province = province;
    }

    @Exclude
    public Map<String, Object> toMap(){
        HashMap<String, Object> result = new HashMap<>();
        result.put("uid", uid);
        result.put("business number", businessNumber);
        result.put("name", name);
        result.put("primary business", primaryBusiness);
        result.put("address", address);
        result.put("province", province);

        return result;
    }
}
