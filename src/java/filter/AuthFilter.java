package filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebFilter("/*")
public class AuthFilter implements Filter {

    // Danh sách các URL yêu cầu đăng nhập (protected)
    private static final List<String> PROTECTED_URLS = Arrays.asList(
        "/add-listing.html",
        "/bookmark.html",
        "/courses.html",
        "/review.html",
        "/teacher-profile.html",
        "/user-profile.html",
        "/basic-calendar.html",
        "/list-view-calendar.html",
        "/mailbox-compose.html",
        "/mailbox-read.html",
        "/mailbox.html"
    );
    
    // Danh sách các URL public không cần đăng nhập
    private static final List<String> PUBLIC_URLS = Arrays.asList(
        "/login.html",
        "/register.html",
        "/forget-password.html",
        "/index.html",
        "/index-2.html",
        "/about-1.html",
        "/about-2.html",
        "/assets/",
        "/blog-",
        "/contact-",
        "/courses-details.html",
        "/event.html",
        "/events-details.html",
        "/faq-1.html",
        "/faq-2.html",
        "/error-404.html",
        "/home.html"
    );

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        // Lấy đường dẫn sau context path
        String path = httpRequest.getRequestURI().substring(httpRequest.getContextPath().length());
        
        // Nếu đường dẫn là public thì cho qua
        if (isPublic(path)) {
            chain.doFilter(request, response);
            return;
        }
        
        // Nếu URL bắt đầu bằng /admin/ hoặc nằm trong danh sách protected thì kiểm tra đăng nhập
        if ( path.startsWith("/admin/") || isProtected(path) ) {
            HttpSession session = httpRequest.getSession(false);
            if (session == null || session.getAttribute("user") == null) {
                httpResponse.sendRedirect(httpRequest.getContextPath() + "/login");
                return;
            }
        }
        
        chain.doFilter(request, response);
    }
    
    // Kiểm tra URL có thuộc danh sách protected không
    private boolean isProtected(String path) {
        return PROTECTED_URLS.stream().anyMatch(url -> path.equals(url));
    }
    
    // Kiểm tra URL có thuộc danh sách public không
    private boolean isPublic(String path) {
        return PUBLIC_URLS.stream().anyMatch(url ->
            path.startsWith(url) || path.contains(url.replace("-", ""))
        );
    }
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Khởi tạo nếu cần
    }
    
    @Override
    public void destroy() {
        // Dọn dẹp nếu cần
    }
}
