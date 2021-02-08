package com.huilong.controller.cache;

import com.huilong.config.MyWebMvcConfigurer;
import com.huilong.model.vo.Staff;
import com.huilong.utils.MockUtils;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.util.DigestUtils;
import org.springframework.util.SerializationUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import springfox.documentation.annotations.ApiIgnore;

import java.util.concurrent.TimeUnit;

/**
 * 缓存
 * <p>
 * 缓存全局配置：{@link MyWebMvcConfigurer#addResourceHandlers(org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry)}
 *
 * @author daocr
 * @date 2021/1/20
 */
@Slf4j
@RestController
@RequestMapping("/springmvc/cache")
@Api(tags = "缓存")
public class CacheController {


    /**
     * 协商使用缓存
     * <p>
     *
     * <pre>
     *     不使用本地缓存。需要使用缓存协商，先与服务器确认返回的响应是否被更改，如果之前的响应中存在ETag，那么请求的时候会与服务端验证，如果资源未被更改，则可以避免重新下载。
     * </pre>
     *
     * @return
     */
    @GetMapping("/no-cache")
    @Operation(summary = "不使用本地缓存。需要使用缓存协商使用缓存", description = "不使用本地缓存。需要使用缓存协商，先与服务器确认返回的响应是否被更改，如果之前的响应中存在ETag，那么请求的时候会与服务端验证，如果资源未被更改，则可以避免重新下载。")
    public ResponseEntity<Staff> noCache() {

        Staff person = MockUtils.mockStatic();

        String md5DigestAsHex = DigestUtils.md5DigestAsHex(SerializationUtils.serialize(person));

        ResponseEntity<Staff> body = ResponseEntity.ok()
                .cacheControl(CacheControl.noCache())
                .eTag(md5DigestAsHex)
                .body(person);

        return body;
    }


    /**
     * 不缓存
     * <p>
     * 直接禁止游览器缓存数据，每次用户请求该资源，都会向服务器发送一个请求，每次都会下载完整的资源。
     *
     * @return
     */
    @GetMapping("/no-store")
    @Operation(summary = "禁止浏览器缓存", description = "直接禁止游览器缓存数据，每次用户请求该资源，都会向服务器发送一个请求，每次都会下载完整的资源。")
    public ResponseEntity<Staff> noStore() {

        Staff person = MockUtils.mockStatic();

        ResponseEntity<Staff> body = ResponseEntity.ok()
                .cacheControl(CacheControl.noStore())
                .body(person);

        return body;
    }


    /**
     * 可以被所有的用户缓存，包括终端用户和CDN等中间代理服务器。
     * <p>
     * 表示该响应可以再浏览器或者任何中继的Web代理中缓存，public是默认值，即Cache-Control:max-age=60等同于Cache-Control:public, max-age=60。
     *
     * @return
     */
    @GetMapping("/cache-public")
    @Operation(summary = "禁止所有类型缓存", description = "1、直接禁止游览器缓存数据，每次用户请求该资源，都会向服务器发送一个请求，每次都会下载完整的资源。" +
            "\n2、表示该响应可以再浏览器或者任何中继的Web代理中缓存，public是默认值，即Cache-Control:max-age=60等同于Cache-Control:public, max-age=60。\n")
    public ResponseEntity<Staff> publicCache() {

        Staff person = MockUtils.mockStatic();

        String md5DigestAsHex = DigestUtils.md5DigestAsHex(SerializationUtils.serialize(person));

        ResponseEntity<Staff> body = ResponseEntity.ok()
                .cacheControl(CacheControl.maxAge(30, TimeUnit.MINUTES).cachePublic())
                .eTag(md5DigestAsHex)
                .body(person);

        return body;
    }


    /**
     * 只可被终端用户的浏览器缓存，不允许CDN等中继服务器对其缓存。
     *
     * @return
     */
    @GetMapping("/cache-private")
    @Operation(summary = "不允许CDN等中继服务器对其缓存", description = "1、只可被终端用户的浏览器缓存，不允许CDN等中继服务器对其缓存。" +
            "\n 2、默认值：Cache-Control:public, max-age=60。")
    public ResponseEntity<Staff> privateCache() {


        Staff person = MockUtils.mockStatic();

        String md5DigestAsHex = DigestUtils.md5DigestAsHex(SerializationUtils.serialize(person));

        ResponseEntity<Staff> body = ResponseEntity.ok()
                .cacheControl(CacheControl.maxAge(30, TimeUnit.MINUTES).cachePrivate())
                .eTag(md5DigestAsHex)
                .body(person);

        return body;
    }


    /**
     * 缓存 30 分钟
     *
     * @return
     */
    @GetMapping("/cache-30-minutes")
    @Operation(summary = " 缓存 30 分钟")
    public ResponseEntity<Staff> cache3Minutes() {


        Staff person = MockUtils.mockStatic();

        String md5DigestAsHex = DigestUtils.md5DigestAsHex(SerializationUtils.serialize(person));

        ResponseEntity<Staff> body = ResponseEntity.ok()
                .cacheControl(CacheControl.maxAge(30, TimeUnit.MINUTES))
                .eTag(md5DigestAsHex)
                .body(person);

        return body;
    }


    /**
     * etag 缓存
     * <p>
     * <pre>
     *      这两个值是由服务器生成的每个资源的唯一标识符，只有资源变化的时候这个值就会
     * 改变，与last-Modified区别是，当服务器返回304 Not-Modified的时候由于Etag
     * 重新生成过，response还是会把Etag返回，即使Etag和之前的相比没有变化。
     *
     * </pre>
     *
     * @return
     */
    @Operation(summary = "etag 缓存", description = "这两个值是由服务器生成的每个资源的唯一标识符，只有资源变化的时候这个值就会改变，与last-Modified区别是，当服务器返回304 Not-Modified的时候由于Etag重新生成过，response还是会把Etag返回，即使Etag和之前的相比没有变化。")
    @GetMapping("/cache-etag")
    public ResponseEntity<Staff> etag(@ApiIgnore WebRequest webRequest) {

        Staff person = MockUtils.mockStatic();

        String md5DigestAsHex = DigestUtils.md5DigestAsHex(SerializationUtils.serialize(person));

        // 如果返回的数据变化，则不需要返回数据，浏览器直接从缓存中加载
        if (webRequest.checkNotModified(md5DigestAsHex)) {
            return null;
        }

        ResponseEntity<Staff> body = ResponseEntity.ok()
                .eTag(md5DigestAsHex)
                .body(person);

        return body;
    }


}
