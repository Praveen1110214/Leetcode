import java.util.ArrayDeque;
import java.util.Deque;

public class SimplifyPath {
    public static void main(String[] args) {
        String path = "/.../a/../b/c/../d/./";
        System.out.println(simplifyPath(path));
    }
    static String simplifyPath(String path){
        Deque<String> stack = new ArrayDeque<>();
        String[] components = path.split("/");
        for(String component : components){
            if(component.equals(".") || component.isEmpty()){
                continue;
            }
            if(component.equals("..")) stack.pollLast();
            else stack.offerLast(component);
        }
        return "/" + String.join("/", stack);
    }
}
