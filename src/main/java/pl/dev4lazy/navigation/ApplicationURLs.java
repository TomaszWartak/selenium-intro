package pl.dev4lazy.navigation;

import pl.dev4lazy.configuration.AppProperties;

public class ApplicationURLs {
    public static final String APPLICATION_URL = AppProperties.getApplicationUrl();
    public static final String TOP_MENU_URL = APPLICATION_URL + "actions/Catalog.action";
    public static final String LOGIN_URL = APPLICATION_URL + "actions/Account.action?signonForm=";
    public static final String FISH_CATEGORY_URL
            = APPLICATION_URL + "actions/Catalog.action?viewCategory=&categoryId=FISH";
    public static final String DOGS_CATEGORY_URL
            = APPLICATION_URL + "actions/Catalog.action?viewCategory=&categoryId=DOGS";
    public static final String CATS_CATEGORY_URL
            = APPLICATION_URL + "actions/Catalog.action?viewCategory=&categoryId=CATS";
    public static final String REPTILES_CATEGORY_URL
            = APPLICATION_URL + "actions/Catalog.action?viewCategory=&categoryId=REPTILES";
    public static final String BIRDS_CATEGORY_URL
            = APPLICATION_URL + "actions/Catalog.action?viewCategory=&categoryId=BIRDS";
}
