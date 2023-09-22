package tsukiyomi_engine;

import org.lwjgl.*;
import org.lwjgl.glfw.*;
import org.lwjgl.opengl.*;
import org.lwjgl.system.*;
import static org.lwjgl.glfw.Callbacks.*;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL15.GL_STATIC_DRAW;
import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL30.glBindVertexArray;
import static org.lwjgl.opengl.GL30.glGenVertexArrays;
import static org.lwjgl.system.MemoryStack.*;
import static org.lwjgl.system.MemoryUtil.*;
import java.nio.*;
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

        if( !glfwInit() ){
            throw new IllegalStateException("Unable to initialize GLFW");
        }
        // Configure GLFW
        glfwDefaultWindowHints();
        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);
        glfwWindowHint(GLFW_RESIZABLE,GLFW_TRUE);

        // Create the window
        glfwWindow = glfwCreateWindow(width, height, title, NULL, NULL);
        if ( glfwWindow == NULL) throw new RuntimeException("Failed to create the GLFW window");
        //glfwSetCursorPosCallback( glfwWindow, MouseListener::mousePosCallback);

        glfwSetKeyCallback(glfwWindow, (glfwWindow, key, scancode, action, mods) -> {
            if ( key == GLFW_KEY_ESCAPE && action == GLFW_RELEASE )
                glfwSetWindowShouldClose(glfwWindow, true); // We will detect this in the rendering loop
        });

        // Make the OpenGL context current
        glfwMakeContextCurrent(glfwWindow);

        // Enable V-Sync
        glfwSwapInterval(1);

        // Make the window visible
        glfwShowWindow(glfwWindow);

        GL.createCapabilities();

    }

    public void loop(){

        // Set the clear color
        glClearColor(1.0f, 0.0f, 0.0f, 0.0f);
        while ( !glfwWindowShouldClose(glfwWindow)){
            glfwPollEvents();
            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);


            glfwSwapBuffers(glfwWindow);
        }
    }

}
