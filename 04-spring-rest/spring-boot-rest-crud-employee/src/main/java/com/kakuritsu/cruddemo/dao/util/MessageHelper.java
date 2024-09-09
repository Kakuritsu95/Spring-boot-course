package com.kakuritsu.cruddemo.dao.util;

public class MessageHelper {
    public static String employeeNotFound(int employeeId){
        return String.format("Employee with id: %s was not found", employeeId);
    }
    public static String employeeDeleted(int employeeId){
        return String.format("Employee with id: %s Successfully deleted", employeeId);
    }
}
