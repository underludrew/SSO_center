package only.yyq.SSOCenter.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class UsersController {

    @RequestMapping(value = "/login")
     public String usersLogin(){

        return "userLoginPage/login";

     }

}
