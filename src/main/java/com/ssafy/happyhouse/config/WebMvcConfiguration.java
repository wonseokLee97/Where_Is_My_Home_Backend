package com.ssafy.happyhouse.config;

import java.util.Arrays;
import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;

import com.ssafy.happyhouse.interceptor.ConfirmInterceptor;

@Configuration
@EnableAspectJAutoProxy
@MapperScan(basePackages = { "com.ssafy.happyhouse.**.mapper" }) // ** 모든 depth
public class WebMvcConfiguration implements WebMvcConfigurer {

	private final List<String> patterns = Arrays.asList("/user/*", "/home/*");
	private final List<String> expatterns = Arrays.asList("/", "/user/login", "/user/findpw", "/user/join", "/user/home", "/user/idcheck");

	@Autowired
	private ConfirmInterceptor confirmInterceptor;

	private final String uploadFilePath;

	// see: application.properties: file.path.upload-files=C:/board/upload/fileUpload/
	public WebMvcConfiguration(@Value("${file.path.upload-files}") String uploadFilePath) {
		this.uploadFilePath = uploadFilePath;
	}

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedOrigins("*")
//			.allowedOrigins("http://localhost:8080", "http://localhost:8081")
				.allowedMethods(HttpMethod.GET.name(), HttpMethod.POST.name(), HttpMethod.PUT.name(),
						HttpMethod.DELETE.name(), HttpMethod.HEAD.name(), HttpMethod.OPTIONS.name(),
						HttpMethod.PATCH.name())
//				.allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "PATCH", "HEAD")
				.maxAge(1800);
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(confirmInterceptor)
			.addPathPatterns(patterns)
			.excludePathPatterns(expatterns);
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/upload/file/**").addResourceLocations("file:///" + uploadFilePath + "/")
				.setCachePeriod(3600).resourceChain(true).addResolver(new PathResourceResolver());
	}

}
