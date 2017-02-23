<!-- TOC depthFrom:1 depthTo:6 withLinks:1 updateOnSave:1 orderedList:0 -->

- [Spring整合问题](#spring整合问题)
	- [Spring整合Junit](#spring整合junit)
	- [Spring整合Web](#spring整合web)
	- [SSH整合](#ssh整合)

<!-- /TOC -->

# Spring整合问题

## Spring整合Junit

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

## SSH整合
