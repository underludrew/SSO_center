package only.yyq.SSOCenter.Services.serviceImpl;

import only.yyq.SSOCenter.Entity.admins;

import java.util.Map;

public interface admins_Service_Impl {
    admins hasAdmin(admins admin);
    Map<Integer,admins> checkPassword(String name, String password);
    admins getAdminByName(String name);
    admins getAdminById(int id);
    boolean addAdmin(String admin_name,String admin_password,String admin_permission,String period);
}
