package only.yyq.SSOCenter.Utils.SessionControl;

import only.yyq.SSOCenter.Entity.Users;
import only.yyq.SSOCenter.Entity.admins;

public class generateSession {

    public String generate(String url, admins admin){

//      String timesec=(Sys)
        String session=url+"@#"+admin.getAdmin_id()+"@#"+admin.getAdmin_name();
        return session;

    }
}
