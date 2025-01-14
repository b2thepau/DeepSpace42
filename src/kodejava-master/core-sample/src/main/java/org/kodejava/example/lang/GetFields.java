package org.kodejava.example.lang;

import java.lang.reflect.Field;
import java.util.Date;

public class GetFields {
    public Long id;
    protected String name;
    private Date birthDate;
    Double weight;

    public static void main(String[] args) {
        GetFields object = new GetFields();
        Class clazz = object.getClass();

        //
        // Get all object fields including public, protected, package and private
        // access fields.
        //
        Field[] fields = clazz.getDeclaredFields();
        System.out.println("Number of fields = " + fields.length);
        for (Field field : fields) {
            System.out.println("Field name = " + field.getName());
            System.out.println("Field type = " + field.getType().getName());
        }

        System.out.println("\n----------------------------------------\n");

        //
        // Get all object accessible public fields.
        //
        fields = clazz.getFields();
        System.out.println("Number of fields = " + fields.length);
        for (Field field : fields) {
            System.out.println("Field name = " + field.getName());
            System.out.println("Field type = " + field.getType().getName());
        }

        System.out.println("\n----------------------------------------\n");

        try {
            //
            // Get field name id with public access modifier
            //
            Field field = clazz.getField("id");
            System.out.println("Field name = " + field.getName());
            System.out.println("Field type = " + field.getType().getName());
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
