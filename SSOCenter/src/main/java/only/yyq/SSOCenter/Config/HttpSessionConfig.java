package only.yyq.SSOCenter.Config;

import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
/*
配置比较简单，主要是添加@EnableRedisHttpSession注解即可，
该注解会创建一个名字叫springSessionRepositoryFilter的Spring Bean，
其实就是一个Filter，这个Filter负责用Spring Session来替换原先的默认HttpSession实现，
在这个例子中，Spring Session是用Redis来实现的。
 */
@EnableRedisHttpSession
public class HttpSessionConfig {

}