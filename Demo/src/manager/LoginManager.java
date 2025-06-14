
package manager;
import java.util.ArrayList;
import model.*;

public class LoginManager{
     
    public User login(String u,String p,ArrayList<User> users){
        for(User user: users){
            String tempUsername=user.getusername();
            String tempPassword=user.getpassword();
            if(tempUsername.equals(u)&& tempPassword.equals(p)){
                return user;
            }
        }
        return null;
    }
}