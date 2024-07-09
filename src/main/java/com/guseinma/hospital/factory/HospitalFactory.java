package com.guseinma.hospital.factory;

import com.guseinma.hospital.model.Hospital;

public class HospitalFactory {
    public static Hospital createFromRequest(com.guseinma.hospital.proto.Hospital request) {
        Hospital hospital = new Hospital();
        hospital.setName(request.getName());
        hospital.setAddress(request.getAddress());
        hospital.setPhoneNumber(request.getPhoneNumber());
        return hospital;
    }

    public static void updateFromRequest(Hospital hospital, com.guseinma.hospital.proto.Hospital request) {
        hospital.setName(request.getName());
        hospital.setAddress(request.getAddress());
        hospital.setPhoneNumber(request.getPhoneNumber());
    }
}
