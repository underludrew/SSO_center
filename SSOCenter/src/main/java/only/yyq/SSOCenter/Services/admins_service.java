package only.yyq.SSOCenter.Services;

import only.yyq.SSOCenter.Entity.admins;
import only.yyq.SSOCenter.Mappers.adminsMapper;
import only.yyq.SSOCenter.Services.serviceImpl.admins_Service_Impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class admins_service implements admins_Service_Impl {

    @Autowired
    private adminsMapper adminsdao;
    @Override
    public admins hasAdmin(admins admin) {
        List<admins> ads= adminsdao.getAdminByName(admin.getAdmin_name());

        return ads.get(0);
    }

    /*
    登录验证
     */
    @Override
    public Map<Integer,admins> checkPassword(String username, String password) {
        Map<Integer,admins> m=new HashMap<>();
        List<admins> ads= adminsdao.getAdminByName(username);
        try {
            if (ads!=null&&ads.get(0)!=null&&ads.get(0).getAdmin_password().equals(password)){
                m.put(1,ads.get(0));
            }else  m.put(0,null);
        }catch (IndexOutOfBoundsException e){
            m.put(-1,null);
        }
        return m;
    }

    @Override
    public admins getAdminByName(String name) {
        return null;
    }

    @Override
    public admins getAdminById(int id) {
        return null;
    }

    @Override
    public boolean addAdmin(String admin_name,String admin_password,String admin_permission,String period){
        if(adminsdao.addAdmin(admin_name,admin_password,admin_permission,period)){
            return true;
        }
        else{
            return false;
        }
//        return false;
    }
}
