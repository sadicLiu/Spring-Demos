<!-- TOC depthFrom:1 depthTo:6 withLinks:1 updateOnSave:1 orderedList:0 -->

- [Spring整合问题](#spring整合问题)
	- [Spring整合Junit](#spring整合junit)
	- [Spring整合Web](#spring整合web)
	- [SSH整合](#ssh整合)

<!-- /TOC -->

# Spring整合问题

## Spring整合Junit
> 1400_Spring_with_Junit

- jar包：`spring-test`
- 单元测试写法
	```
	@RunWith(SpringJUnit4ClassRunner.class)
	@ContextConfiguration("classpath:applicationContext.xml")
	public class TestUnion {
			@Autowired
			@Qualifier("userService")
			private UserService userService;

			@Test
			public void testService() {
					userService.addUser();
			}
	}
	```

## Spring整合Web
> 1500_Spring_with_Web

- 主要解决的是启动Tomcat时立即加载spring配置文件的问题

- jar包：spring-web

- 在web环境下加载配置文件的几种办法
	1. servlet --> init(ServletConfig) --> <load-on-startup>2
	2. filter --> init(FilterConfig)  --> web.xml注册过滤器自动调用初始化
	3. listener --> ServletContextListener --> servletContext对象监听
	4. spring提供监听器 ContextLoaderListener  --> web.xml  <listener><listener-class>....
		如果只配置监听器，默认加载xml位置：`/WEB-INF/applicationContext.xml`

- `web.xml`配置
	```
	<!-- 确定配置文件位置 -->
	<context-param>
			<param-name>contextConfigLocation</param-name>
			<param-value>classpath:applicationContext.xml</param-value>
	</context-param>

	<!-- 配置spring 监听器，加载xml配置文件 -->
	<listener>
			<listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
	</listener>
	```

- Servlet
	```
	@WebServlet(name = "HelloServlet", urlPatterns = "/HelloServlet")
	public class HelloServlet extends HttpServlet {
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				// 从application作用域（ServletContext）获得spring容器
				//方式1： 手动从作用域获取
				ApplicationContext applicationContext =
								(ApplicationContext) this.getServletContext().getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
				//方式2：通过工具获取
				ApplicationContext apppApplicationContext2 =
								WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());

				UserService userService = (UserService) applicationContext.getBean("userService");
				userService.addUser();
		}
	}
	```


## SSH整合
