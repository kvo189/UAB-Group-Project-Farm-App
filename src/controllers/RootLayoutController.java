package controllers;

public class RootLayoutController {
    private static RootLayoutController rootLayout;
    private RootLayoutController() {}

    public static RootLayoutController getInstance() {
        if (rootLayout == null) {
            rootLayout = new RootLayoutController();
        }
        return rootLayout;
    }
}
