package only.yyq.SSOCenter.Mappers;

import only.yyq.SSOCenter.Entity.admins;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Mapper
public interface adminsMapper {
    @Select("select * from admins where admin_name=#{admin_name}")
    List<admins> getAdminByName(@Param("admin_name")String admin_name);
    @Insert("insert into admins (admin_name,admin_password,admin_permission,period) values(#{admin_name},#{admin_password},#{admin_permission},#{period})")
    boolean addAdmin(@Param("admin_name")String admin_name,@Param("admin_password")String admin_password,@Param("admin_permission")String admin_permission,@Param("period")String period);
}
