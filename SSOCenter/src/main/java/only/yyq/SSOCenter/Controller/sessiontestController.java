package only.yyq.SSOCenter.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;


@RestController
public class sessiontestController {
    @RequestMapping("/set")
    String set(HttpServletRequest req) {
        req.getSession().setAttribute("testKey", "testValue");
        return "设置session:testKey=testValue";
    }

    @RequestMapping("/query")
    String query(HttpServletRequest req){
        Object value = req.getSession().getAttribute("testKey");
        return "查询Session：\"testKey\"=" + value;
    }
    @RequestMapping("/query2")
    String query2(HttpServletRequest req) {
        Object value = req.getSession().getAttribute("admin");
        return "查询Session：\"testKey\"=" + value;
    }

}
