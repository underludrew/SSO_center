package only.yyq.SSOCenter.Services;

import only.yyq.SSOCenter.Entity.admins;
import only.yyq.SSOCenter.Services.serviceImpl.loginCheckImpl;
import org.springframework.beans.factory.annotation.Autowired;

public class loginCheck implements loginCheckImpl {
    @Autowired
    private admins admin;

    @Override
    public String check(admins admin){
        System.out.println("enter checking");
        this.admin=admin;

        return hasUser(admin)&&iscorrect(admin)?"login succeed":"fail" ;
    }


    @Override
    public boolean hasUser(admins admin) {
        return false;
    }

    @Override
    public boolean iscorrect(admins admin) {
        return false;
    }
}
