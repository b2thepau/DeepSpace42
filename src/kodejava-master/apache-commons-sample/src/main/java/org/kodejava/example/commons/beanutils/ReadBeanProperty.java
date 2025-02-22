package org.kodejava.example.commons.beanutils;

import org.apache.commons.beanutils.PropertyUtils;

import java.lang.reflect.InvocationTargetException;

public class ReadBeanProperty {
    public static void main(String[] args) {
        Track track = new Track();
        track.setTitle("Till There Was You");

        try {
            String title = (String) PropertyUtils.getSimpleProperty(track, "title");
            System.out.println("Title = " + title);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
