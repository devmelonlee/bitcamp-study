package bitcamp.myapp.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class AdminWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

  public AdminWebApplicationInitializer() {
    System.out.println("AdminWebApplicationInitializer 생성됨");
  }

  @Override
  protected String getServletName() {
    return "admin";
  }
  // 충돌날 수 있어서 2개 이상은 이렇게 이름을 따로 지정해줘야함

  @Override
  protected Class<?>[] getRootConfigClasses() {
    // ContextLoaderListener의 IoC 컨테이너가 사용할 java config 클래스를 지정한다.
    // => AppWebApplicationInitializer에서 RootConfig를 가지고 ContextLoaderListner를 만들었기 때문에
    // 여기에서는 설정하지 않는다. 여러게의 dispatcher 중에서 하나만 root를 만들어주면 된다.
    return null;
  }

  @Override
  protected Class<?>[] getServletConfigClasses() {
    // DispatcherServlet의 IoC 컨테이너가 사용할 java config 클래스를 지정한다.
    return new Class[] {AppConfig.class};
  }

  @Override
  protected String[] getServletMappings() {
    // DispatcherServlet의 URL을 지정한다.
    return new String[] {"/app/*"};
  }

  @Override
  protected void customizeRegistration(ServletRegistration.Dynamic registration) {
    registration.setMultipartConfig(new MultipartConfigElement("temp", 10000000, 15000000, 1000000));
  }
}
