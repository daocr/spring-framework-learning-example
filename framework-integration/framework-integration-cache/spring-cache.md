







| Name          | Location           | Description                                                  | Example                                                      |
| :------------ | :----------------- | :----------------------------------------------------------- | :----------------------------------------------------------- |
| `methodName`  | Root object        | The name of the method being invoked                         | `#root.methodName`                                           |
| `method`      | Root object        | The method being invoked                                     | `#root.method.name`                                          |
| `target`      | Root object        | The target object being invoked                              | `#root.target`                                               |
| `targetClass` | Root object        | The class of the target being invoked                        | `#root.targetClass`                                          |
| `args`        | Root object        | The arguments (as array) used for invoking the target        | `#root.args[0]`                                              |
| `caches`      | Root object        | Collection of caches against which the current method is run | `#root.caches[0].name`                                       |
| Argument name | Evaluation context | Name of any of the method arguments. If the names are not available (perhaps due to having no debug information), the argument names are also available under the `#a<#arg>` where `#arg` stands for the argument index (starting from `0`). | `#iban` or `#a0` (you can also use `#p0` or `#p<#arg>` notation as an alias). |
| `result`      | Evaluation context | The result of the method call (the value to be cached). Only available in `unless` expressions, `cache put` expressions (to compute the `key`), or `cache evict` expressions (when `beforeInvocation` is `false`). For supported wrappers (such as `Optional`), `#result` refers to the actual object, not the wrapper. |                                                              |


### 参考
https://docs.spring.io/spring-framework/docs/current/reference/html/integration.html#cache