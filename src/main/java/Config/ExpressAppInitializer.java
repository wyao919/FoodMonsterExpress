package Config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ExpressAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {

		Class[] arr = {ExpressConfig.class};
		return arr;
	}

	@Override
	protected String[] getServletMappings() {

		String[] arr = {"/"};
		return arr;
	}

}
