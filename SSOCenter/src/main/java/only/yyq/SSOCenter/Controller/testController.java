package only.yyq.SSOCenter.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import only.yyq.SSOCenter.Entity.admins;
import only.yyq.SSOCenter.Services.admins_service;
import only.yyq.SSOCenter.Utils.SessionControl.generateSession;
import only.yyq.SSOCenter.Utils.jsonUtil.jsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class testController {
    @Autowired
    admins_service adminsservice;

    @RequestMapping(value = "/")
    public String  test(){
        return "index";
    }

    @RequestMapping(value = "/admin")
    public String signin(){
        return "signin/index";
    }

    @RequestMapping(value = "/home")
    public String home(HttpServletRequest request,HttpServletResponse respinse){

        Cookie[] cs=request.getCookies();

        System.out.println("cookie num:"+cs.length);
        System.out.println("--------------"+request.getCookies()[1].getValue());
        return "ControllCenter/index";
    }


    @RequestMapping(value = "/logincheck",method = POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String logincheck(@RequestBody Map o,HttpServletRequest request, HttpServletResponse resp){
        Map<String,Object> m=new HashMap<String,Object>();

        String username=(String) o.get("username");
        String password=(String) o.get("password");

        System.out.println(username+"    "+password);
        Map flag=adminsservice.checkPassword(username,password);
        String data="";

        if(flag.containsKey(1)){
            System.out.println("login success");
            admins a=(admins)flag.get(1);
            //session生成
            generateSession gensession=new generateSession();
            String se=gensession.generate(request.getRequestURL().toString(),a);
            request.getSession().setAttribute(username, se);//存储session
//            Cookie[] cookie=request.getCookies();
//           System.out.println("cookie is  "+request.getCookies()[0].getValue());
            //设置cookie,加上时间戳
            System.currentTimeMillis();
            Cookie c=new Cookie("Token",se);
            System.out.println("url is "+request.getRequestURI());
            data=new jsonUtil().get("success","home");
            m.put("result","success");
            Object value = request.getSession().getAttribute(username);
            System.out.println("value is  "+value);
            resp.addCookie(new Cookie("session",se));
        }else if(flag.containsKey(0)){
            data=new jsonUtil().get("false","admin");
//            m.put("result","false");

        }else{
            data=new jsonUtil().get("null","admin");
        }

        return data;

    }

    @RequestMapping(value = "/logincheckpass",produces = "text/html;charset=utf-8")
    public ModelAndView test(HttpServletResponse response){
        System.out.println("to here");
        ModelAndView mav=new ModelAndView("ControllCenter/index");

        return mav;
    }

    @RequestMapping(value = "/addAdmin",method = POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Map<String,Object> addAdmin(@RequestBody Map o){
        Map<String,Object> m=new HashMap<String,Object>();
        String admin_name=(String)o.get("admin_name");
        String admin_password=(String)o.get("admin_password");
        String admin_permission=(String)o.get("admin_permission");
        String period=(String)o.get("period");
        boolean isAddSuccees=adminsservice.addAdmin(admin_name,admin_password,admin_permission,period);
        if(isAddSuccees){
            m.put("result","1");
        }
        else{
            m.put("result","false");
        }

        return m;
    }

}
