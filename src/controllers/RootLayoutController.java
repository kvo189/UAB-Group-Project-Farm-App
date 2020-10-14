package controllers;

public class RootLayoutController {
    private static RootLayoutController RootLayout;
    private RootLayoutController() {}

    public static RootLayoutController getInstance() {
        if (RootLayout == null) {
            RootLayout = new RootLayoutController();
        }
        return RootLayout;
    }
}
