import java.util.*;

class BrowserHistory {
    Stack<String> back = new Stack<>();
    Stack<String> forward = new Stack<>();
    
    // Constructor to initialize object with homepage
    BrowserHistory(String homepage) {
        back.push(homepage); 
    }
    
    // Visit current URL
    void visit(String url) {
        forward.clear();  // this "clear" method basically inherited from vector class
        back.push(url);
    }
    
      String back(int steps) {
        while (!back.isEmpty() && steps-- > 0) {
            
            if (back.size() > 1) {
                forward.push(back.pop());
            } else {
                break; 
            }
        }
        return back.peek(); 
    }
    
    // Move 'steps' forward and return current page
    String forward(int steps) {
        while (!forward.isEmpty() && steps-- > 0) {
            back.push(forward.pop());
        }
        return back.peek(); 
    }
}