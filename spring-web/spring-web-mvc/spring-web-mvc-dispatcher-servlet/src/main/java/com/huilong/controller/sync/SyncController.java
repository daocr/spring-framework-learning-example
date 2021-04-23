package com.huilong.controller.sync;

import com.huilong.model.bo.R;
import com.huilong.model.bo.Staff;
import com.huilong.utils.MockUtils;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;

import java.io.IOException;
import java.util.concurrent.Callable;

/**
 * 异步请求
 *
 * @author daocr
 * @date 2021/1/20
 */
@Api(tags = "异步处理")
@Slf4j
@RestController
@RequestMapping("/springmvc/sync")
public class SyncController {


    /**
     * @return
     */
    @Operation(summary = "deferred result 异步请求", description = "")
    @GetMapping("/sync-request-deferred-result")
    public DeferredResult<R<Staff>> syncRequestDeferredResult() {


        log.info("已进入 syncRequestDeferredResult");

        DeferredResult<R<Staff>> deferredResult = new DeferredResult<R<Staff>>();

        new Thread(() -> {

            try {
                log.info("开始休眠 5s");
                Thread.sleep(1000 * 10);
                log.info("结束休眠");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            R<Staff> success = R.success(MockUtils.mockDynamic());
            deferredResult.setResult(success);


        }).start();

        log.info("已退出 syncRequestDeferredResult");

        return deferredResult;
    }

    /**
     * @return
     */
    @Operation(summary = "callable   异步请求", description = "")
    @GetMapping("/sync-request-callable")
    public Callable<R<Staff>> syncRequestCallable() {

        log.info("已进入 com.huilong.controller.sync.SyncController.syncRequestCallable ");

        Callable<R<Staff>> callable = new Callable<>() {
            @Override
            public R<Staff> call() throws Exception {

                log.info("已进入 syncRequestCallable call ");

                Staff staff = MockUtils.mockDynamic();

                log.info("已退出 syncRequestCallable call ");
                return R.success(staff);
            }
        };

        log.info("已退出 com.huilong.controller.sync.SyncController.syncRequestCallable ");

        return callable;
    }

    /**
     * 异步流 返回
     *
     * @return
     */
    @Operation(summary = "streaming   异步请求", description = "")
    @GetMapping("/streaming")
    public ResponseBodyEmitter streaming() {

        ResponseBodyEmitter emitter = new ResponseBodyEmitter();

        // 模拟其他线程进行操作
        new Thread(() -> {

            for (int i = 0; i < 10; i++) {
                try {
                    emitter.send("我是序列" + i);

                    Thread.sleep(1000);
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
            }

            emitter.complete();

        }).start();


        // Save the emitter somewhere..
        return emitter;


    }


}
