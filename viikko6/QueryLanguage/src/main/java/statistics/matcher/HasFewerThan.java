/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statistics.matcher;

import java.lang.reflect.Method;
import statistics.Player;

/**
 *
 * @author Jani
 */
public class HasFewerThan implements Matcher {

    private int value;
    private String methodName;

    public HasFewerThan(int value, String text) {
        this.value = value;
        this.methodName = "get" + Character.toUpperCase(text.charAt(0)) + text.substring(1, text.length());
    }

    @Override
    public boolean matches(Player p) {
        try {
            Method method = p.getClass().getMethod(methodName);
            int playersValue = (Integer) method.invoke(p);
            return playersValue < value;
        } catch (Exception e) {
            System.out.println(e);
            throw new IllegalStateException("error");
        }
    }

}
