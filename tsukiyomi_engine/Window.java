package tsukiyomi_engine;

import org.lwjgl.Version;
import org.lwjgl.glfw.GLFWErrorCallback;

public class Window {
    private int width,height;
    private String title;
    private long glfwWindow;
    private static Window window = null;

    private Window(){
        this.width = 1920;
        this.height = 1080;
        this.title = "Tsukiyomi";
    }

    public static Window get(){
        if( Window.window == null){
            Window.window = new Window();
        }
        return Window.window;
    }

    public void run(){
        System.out.println("Hello LWJGL "+ Version.getVersion()+"!");

        init();
        loop();

    }

    public void init(){
        GLFWErrorCallback.createPrint(System.err).set();

    }
}
