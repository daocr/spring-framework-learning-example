##spring 容器 

### 简介

### 功能点

###参数



| swagger2             | **OpenAPI 3**                                                | 注解位置                           |
| -------------------- | ------------------------------------------------------------ | ---------------------------------- |
| `@Api`               | **@Tag(name = “接口类描述”)**                                | Controller 类上                    |
| `@ApiOperation`      | **@Operation(summary =“接口方法描述”)**                      | Controller 方法上                  |
| `@ApiImplicitParams` | **@Parameters**                                              | Controller 方法上                  |
| `@ApiImplicitParam`  | **@Parameter(description=“参数描述”)**                       | Controller 方法上 `@Parameters` 里 |
| `@ApiParam`          | **@Parameter(description=“参数描述”)**                       | Controller 方法的参数上            |
| `@ApiIgnore`         | **@Parameter(hidden = true)** 或 **@Operation(hidden = true)** 或 **@Hidden** | -                                  |
| `@ApiModel`          | **@Schema**                                                  | DTO类上                            |
| `@ApiModelProperty`  | **@Schema**                                                  | DTO属性|




```java

* 1、 {@link org.springframework.web.servlet.FrameworkServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)}
 *      2、 {@link FrameworkServlet#processRequest(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)}
 *           3、 {@link DispatcherServlet#doService(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)}
 *                  4、{@link DispatcherServlet#doDispatch(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)}
 *                             通过url 匹配 controller
 *                         4.1 {@link DispatcherServlet#getHandler(javax.servlet.http.HttpServletRequest)}
 *                             处理拦截器（HandlerInterceptor）、跨域配置
 *                             4.1.1 {@link AbstractHandlerMapping#getHandler(javax.servlet.http.HttpServletRequest)}
 *                                 通过反射，调用 controller 的方法
 *                         4.2 {@link AbstractHandlerMethodAdapter#handle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object)}
 *                                           4.2.1{@link RequestMappingHandlerAdapter#handleInternal(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, org.springframework.web.method.HandlerMethod)}
 *                                               4.2.1.1{@link RequestMappingHandlerAdapter#invokeHandlerMethod(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, org.springframework.web.method.HandlerMethod)}
 *                                                      4.2.1.1.1{@link ServletInvocableHandlerMethod#invokeAndHandle(org.springframework.web.context.request.ServletWebRequest, org.springframework.web.method.support.ModelAndViewContainer, java.lang.Object...)}
 *                                                          处理入参
 *                                                          4.2.1.1.1.1{@link InvocableHandlerMethod#invokeForRequest(org.springframework.web.context.request.NativeWebRequest, org.springframework.web.method.support.ModelAndViewContainer, java.lang.Object...)}
 *                                                          处理出参
 *                                                          4.2.1.1.1.2{@link HandlerMethodReturnValueHandlerComposite#handleReturnValue(java.lang.Object, org.springframework.core.MethodParameter, org.springframework.web.method.support.ModelAndViewContainer, org.springframework.web.context.request.NativeWebRequest)}
 *                                                                  4.2.1.1.1.2.1{@link RequestResponseBodyMethodProcessor#handleReturnValue(java.lang.Object, org.springframework.core.MethodParameter, org.springframework.web.method.support.ModelAndViewContainer, org.springframework.web.context.request.NativeWebRequest)}
 *                                                                                      适配 HttpMessageConverter
 *                                                                      4.2.1.1.1.2.1.1{@link AbstractMessageConverterMethodProcessor#writeWithMessageConverters(java.lang.Object, org.springframework.core.MethodParameter, org.springframework.http.server.ServletServerHttpRequest, org.springframework.http.server.ServletServerHttpResponse)}
 *                         4.2{@link DispatcherServlet#processDispatchResult(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, org.springframework.web.servlet.HandlerExecutionChain, org.springframework.web.servlet.ModelAndView, java.lang.Exception)}
 *                                    异常处理
 *                              4.2.1{@link DispatcherServlet#processHandlerException(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, java.lang.Exception)}
 *                                          页面渲染 例如 Thymeleaf
 *                                   4.2.1.1{@link DispatcherServlet#render(org.springframework.web.servlet.ModelAndView, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)}

```