package filter;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FirstFilter implements Filter {

    public FilterConfig config;

    /**
     *检测字符串包含关系
     * @param container     被检测的字符串
     * @param regx          是否包含这些内容
     * @return
     */
    public boolean iscontains(String container, String[] regx){

        for(int i = 0; i < regx.length; i ++){
            if(container.indexOf(regx[i]) != -1){
                return true;
            }
        }

        return false;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        config = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest hrequest = (HttpServletRequest) servletRequest;
        HttpServletResponse hresponse = (HttpServletResponse) servletResponse;

        String logStrings = config.getInitParameter("logStrings");
        String includeStrings = config.getInitParameter("includeStrings");
        String redirectPath = config.getInitParameter("redirectPath");
        String disableFilter = config.getInitParameter("disableFilter");

        //判断是否禁用过滤器
        if(disableFilter.toUpperCase().equals("Y")){
            filterChain.doFilter(hrequest,hresponse);
            return;
        }

        //不过滤的路径
        String[] logList = logStrings.split(";");
        //需过滤的路径
        String[] includeList = includeStrings.split(";");

        //判断请求的URI是否包含需要过滤的路径
        if(!iscontains(hrequest.getRequestURI(),includeList)){
            filterChain.doFilter(hrequest,hresponse);
            return;
        }

        //判断是否包含不需要过滤的路径
        if(iscontains(hrequest.getRequestURI(),logList)){
            filterChain.doFilter(hrequest,hresponse);
            return;
        }

        //判断是否有用户成功登录
        String username = (String) hrequest.getSession().getAttribute("user1");
        if(username == null){
            hresponse.sendRedirect(hrequest.getContextPath()+"/"+config.getInitParameter("redirectPath"));
            return;
        }else {
            filterChain.doFilter(hrequest,hresponse);
            return;
        }

    }

    @Override
    public void destroy() {

    }
}
