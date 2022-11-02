package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pojo.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 获取请求参数的方式：
 * 1.通过servletAPI获取
 * 只需要在控制台方法的形参位置设置HttpServletRequest类型的形参，就可以在控制器方法中使用request对象获取请求参数
 * 2.通过控制器方法的形参获取
 * 只需要在控制器方法的形参位置设置一个形参，形参的名字和请求参数的名字一致即可
 * 3.@RequestParam：将请求参数和控制器方法的形参绑定
 * @RequestParam注解的三个属性：value，required，defaultValue
 * value：设置和形参绑定的请求参数的名字
 * required：设置是否必须传输value所对应的请求参数（默认值为true-->400，false-->形参值为null）
 * defaultValue：设置当没有传输value所对应的请求参数时，为形参设置的默认值，此时和required属性值无关
 * 4.@RequestHeader：将请求头信息和控制器方法的形参绑定
 * 5.@CookieValue：将cookie数据与控制器方法的形参绑定
 * 6.通过控制器方法的形参位置设置实体类类型的形参，要保证实体类中的属性的属性名和请求参数的名字一致
 * 可以通过实体类类型的形参获取请求参数
 *
 * 获取请求参数的乱码问题：web.xml
 * SpringMVC中处理编码的过滤器一定要配置到其他过滤器之前，否则无效
 */

@Controller
public class TestParamController {

    @RequestMapping("/param/servletAPI")
    public String getParamServletAPI(HttpServletRequest request){
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username："+username+"，password："+password);
        return "success";
    }

    @RequestMapping("/param")
    public String getParam(
            @RequestParam(value = "userName",required = true,defaultValue = "hello")String username,
            String password,
            @RequestHeader("referer") String referer,
            @CookieValue("JSESSIONID") String jsessionId
    ){
        System.out.println("jsessionId:"+jsessionId);
        System.out.println("referer:"+referer);
        System.out.println("username:"+username+",password:"+password);
        return "success";
    }

    @RequestMapping("/param/pojo")
    public String getParamByPojo(User user){
        System.out.println(user);
        return "success";
    }

}
