package com.ll.springcloud.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component          //加入到Spring容器中
public class LoginFilter extends ZuulFilter {

     public Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 返回值取值
     * @return
     *  - pre : 在路由请求之前执行
     *  - route : 在路由请求时调用
     *  - post : 在路由请求完成之后调用，也就是在route和error过滤器之后进行调用
     *  - error : 处理请求发生错误请求错误时调用
     */
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;       //返回值会根据返回值的大小定义过滤器的执行顺序。值越小优先级越高
    }

    @Override
    public boolean shouldFilter() {
        return true;    //当前过滤器是否会执行
    }

    //定义 过滤功能
    @Override
    public Object run() throws ZuulException {
        //如果请求带了一个token值，则表示已经登陆过
        //1. 获取请求上下文
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        String token = request.getParameter("token");
        //2. 如果token是空则代表没有登陆过，则拒绝
        if("".equals(token) || token == null){
            logger.warn("此操作需要先登录系统！！！！");
            //没有登录过，则不进行路由转发
            requestContext.setSendZuulResponse(false);      //拒绝访问
            requestContext.setResponseStatusCode(200);      //响应状态码
            try {
                requestContext.getResponse().getWriter().write("token is empty ...");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
        logger.info("all right serviced 。。。 please wait a moment 。。。");
        //通过，会进行路由转发
        return null;
    }
}
