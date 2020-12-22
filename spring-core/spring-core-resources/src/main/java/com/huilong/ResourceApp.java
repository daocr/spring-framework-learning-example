package com.huilong;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * 文件资源管理
 *
 * <pre>
 *      Prefix	            Example	                            Explanation
 *
 *     classpath:           classpath:com/myapp/config.xml      Loaded from the classpath.
 *     file:                file:///data/config.xml             Loaded as a URL from the filesystem. See also FileSystemResource Caveats.
 *     http:                https://myserver/logo.png           Loaded as a URL.
 *     (none)               /data/config.xml                    Depends on the underlying ApplicationContext.
 *
 * </pre>
 *
 * @see org.springframework.util.ResourceUtils
 */
@Slf4j
public class ResourceApp {
    public static void main(String[] args) throws IOException {


        // 1、读取网络资源
        printUrlResource();

        //2、读取classpath 下的资源，包括jar包内的
        printClassPathResource();

        //3、从系统文件中读取资源
        printFileSystemResource();

        // 4、通过 Prefix 适配查找文件
        PathMatchingResourcePatternResolver pathMatchingResourcePatternResolver = new PathMatchingResourcePatternResolver();

        Resource[] resources = pathMatchingResourcePatternResolver.getResources("classpath*:META-INF/spring.factories");
        Resource resource = resources[0];
        String content = StreamUtils.copyToString(resource.getInputStream(), StandardCharsets.UTF_8);

        log.info("PathMatchingResourcePatternResolver, contentLength:{} 读取内容：{}", resource.contentLength(), content);

    }

    private static void printFileSystemResource() throws IOException {

        FileSystemResource fileSystemResource = new FileSystemResource("/Users/daocr/IdeaProjects/study/Spring-Framework-Study/spring-core/spring-core-resources/src/main/resources/说明.txt");

        String content = StreamUtils.copyToString(fileSystemResource.getInputStream(), StandardCharsets.UTF_8);

        log.info("FileSystemResource , contentLength:{} 读取内容：{}", fileSystemResource.contentLength(), content);
    }

    /**
     * 从classpath 加载 文件
     *
     * @throws IOException
     */
    private static void printClassPathResource() throws IOException {

        ClassPathResource classPathResource = new ClassPathResource("META-INF/spring.factories");

        String content = StreamUtils.copyToString(classPathResource.getInputStream(), StandardCharsets.UTF_8);

        log.info("ClassPathResource 加载资源  , contentLength:{} 读取内容：{}", classPathResource.contentLength(), content);

    }

    /**
     * 从url 中加载文件资源
     *
     * @throws IOException
     */
    private static void printUrlResource() throws IOException {
        UrlResource urlResource = new UrlResource("https://www.baidu.com/img/flexible/logo/pc/result.png");

        String description = urlResource.getDescription();
        long contentLength = urlResource.contentLength();

        log.info("UrlResource 加载资源 description : {} contentLength:{}", description, contentLength);
    }
}
