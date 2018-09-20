package io.game.sciroc.utils;

import io.game.sciroc.exception.ConstructorAccessException;

/**
 * PROJECT   : sciroc
 * PACKAGE   : io.game.sciroc.constants
 * USER      : sean
 * DATE      : 16-Sun-Sep-2018
 * TIME      : 14:15
 * E-MAIL    : kudzai@bcs.org
 * CELL      : +27-64-906-8809
 */
public final class Constants {
    public static final String HOME_TITLE = "Game - Rock-Paper-Scissors";

    //Resources-URI
    private static final String EXTERNAL_URI_RESOURCES_CSS = "css/**";
    private static final String EXTERNAL_URI_RESOURCES_PUB = "pub/**";
    private static final String EXTERNAL_URI_RESOURCES_STATIC = "static/**";
    private static final String EXTERNAL_URI_RESOURCES_JS = "js/**";
    //Resources-URI Array
    public static final String[] EXTERNAL_REF_URI_RESOURCES = {EXTERNAL_URI_RESOURCES_CSS, EXTERNAL_URI_RESOURCES_PUB,
            EXTERNAL_URI_RESOURCES_STATIC, EXTERNAL_URI_RESOURCES_JS};
    private static final String INTERNAL_URI_RESOURCES_PUB = "classpath:/pub/";
    private static final String INTERNAL_URI_RESOURCES_STATIC = "classpath:/static/";
    private static final String INTERNAL_URI_RESOURCES_CSS = "classpath:/static/css/";
    private static final String INTERNAL_URI_RESOURCES_JS = "classpath:/js/";
    public static final String[] INTERNAL_REF_URI_RESOURCES = {INTERNAL_URI_RESOURCES_PUB,
            INTERNAL_URI_RESOURCES_STATIC, INTERNAL_URI_RESOURCES_CSS, INTERNAL_URI_RESOURCES_JS};

    /**
     * Instantiation of the class is not permitted.
     *
     * @throws ConstructorAccessException if an attempt to instantiate the class is picked up.
     */
    private Constants() throws ConstructorAccessException {
        throw new ConstructorAccessException("Not allowed to access Constants-Constructor.");
    }
}
