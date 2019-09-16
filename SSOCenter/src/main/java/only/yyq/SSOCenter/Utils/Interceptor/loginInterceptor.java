package only.yyq.SSOCenter.Utils.Interceptor;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class loginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String url=request.getRequestURI();
        System.out.println(request.getRequestURI());

        if (url.equals("/admin")||url.equals("/login")||url.equals("/logincheck")||url.equals("/set")||url.equals("/query")){
            return true;
        }else{
            if(request.getCookies()==null){

                     response.sendRedirect("/login");
            }else{
                Cookie[] cookie=request.getCookies();
                System.out.println(cookie[0].getValue());
            }

        }

        return true;
    }






//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
//        System.out.println("postHandle");
//    }
//
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
//        System.out.println("afterCompletion");
//    }

}
