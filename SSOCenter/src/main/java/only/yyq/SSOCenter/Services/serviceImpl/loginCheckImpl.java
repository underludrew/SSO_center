package only.yyq.SSOCenter.Services.serviceImpl;

import only.yyq.SSOCenter.Entity.admins;

public interface loginCheckImpl {
    boolean hasUser(admins admin);
    boolean  iscorrect(admins admin);
    String check(admins admin);
}
