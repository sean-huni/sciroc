package io.game.sciroc.exception;

/**
 * PROJECT   : sciroc
 * PACKAGE   : io.game.sciroc.exceptions
 * USER      : sean
 * DATE      : 16-Sun-Sep-2018
 * TIME      : 14:17
 * E-MAIL    : kudzai@bcs.org
 * CELL      : +27-64-906-8809
 */
public final class ConstructorAccessException extends IllegalAccessException {

    /**
     * Constructs an <code>IllegalAccessException</code> with a detail message.
     *
     * @param s the detail message.
     */
    public ConstructorAccessException(String s) {
        super(s);
    }
}
