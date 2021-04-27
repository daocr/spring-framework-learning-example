##spring 容器 

### 简介

### 功能点

###参数

| Name                     | Type    | Description                                                  |
| ------------------------ | ------- | ------------------------------------------------------------ |
| mail.debug               | boolean | The initial debug mode. Default is false.                    |
| mail.from                | String  | The return email address of the current user, used by the `InternetAddress` method `getLocalAddress`. |
| mail.mime.address.strict | boolean | The MimeMessage class uses the `InternetAddress` method `parseHeader` to parse headers in messages. This property controls the strict flag passed to the `parseHeader` method. The default is true. |
| mail.host                | String  | The default host name of the mail server for both Stores and Transports. Used if the `mail.*protocol*.host` property isn't set. |
| mail.store.protocol      | String  | Specifies the default message access protocol. The `Session` method `getStore()` returns a Store object that implements this protocol. By default the first Store provider in the configuration files is returned. |
| mail.transport.protocol  | String  | Specifies the default message transport protocol. The `Session` method `getTransport()` returns a Transport object that implements this protocol. By default the first Transport provider in the configuration files is returned. |
| mail.user                | String  | The default user name to use when connecting to the mail server. Used if the `mail.*protocol*.user` property isn't set. |
| mail.*protocol*.class    | String  | Specifies the fully qualified class name of the provider for the specified protocol. Used in cases where more than one provider for a given protocol exists; this property can be used to specify which provider to use by default. The provider must still be listed in a configuration file. |
| mail.*protocol*.host     | String  | The host name of the mail server for the specified protocol. Overrides the `mail.host` property. |
| mail.*protocol*.port     | int     | The port number of the mail server for the specified protocol. If not specified the protocol's default port number is used. |
| mail.*protocol*.user     | String  | The user name to use when connecting to mail servers using the specified protocol. Overrides the `mail.user` property. |



| Name                                   | Type                          | Description                                                  |
| -------------------------------------- | ----------------------------- | ------------------------------------------------------------ |
| mail.debug.auth                        | boolean                       | Include protocol authentication commands (including usernames and passwords) in the debug output. Default is false. |
| mail.debug.auth.username               | boolean                       | Include the user name in non-protocol debug output. Default is true. |
| mail.debug.auth.password               | boolean                       | Include the password in non-protocol debug output. Default is false. |
| mail.transport.protocol.*address-type* | String                        | Specifies the default message transport protocol for the specified address type. The `Session` method `getTransport(Address)` returns a Transport object that implements this protocol when the address is of the specified type (e.g., "rfc822" for standard internet addresses). By default the first Transport configured for that address type is used. This property can be used to override the behavior of the [`send`](https://eclipse-ee4j.github.io/mail/docs/api/jakarta.mail/jakarta/mail/Transport.html#send(jakarta.mail.Message)) method of the [`Transport`](https://eclipse-ee4j.github.io/mail/docs/api/jakarta.mail/jakarta/mail/Transport.html) class so that (for example) the "smtps" protocol is used instead of the "smtp" protocol by setting the property `mail.transport.protocol.rfc822` to `"smtps"`. |
| mail.event.scope                       | String                        | Controls the scope of events. (See the jakarta.mail.event package.) By default, a separate event queue and thread is used for events for each Store, Transport, or Folder. If this property is set to "session", all such events are put in a single event queue processed by a single thread for the current session. If this property is set to "application", all such events are put in a single event queue processed by a single thread for the current application. (Applications are distinguished by their context class loader.) |
| mail.event.executor                    | java.util.concurrent.Executor | By default, a new Thread is created for each event queue. This thread is used to call the listeners for these events. If this property is set to an instance of an Executor, the Executor.execute method is used to run the event dispatcher for an event queue. The event dispatcher runs until the event queue is no longer in use. |



| ogger Name   | Logging Level | Purpose                      |
| ------------ | ------------- | ---------------------------- |
| jakarta.mail | CONFIG        | Configuration of the Session |
| jakarta.mail | FINE          | General debugging output     |

### 参考

https://docs.spring.io/spring-framework/docs/current/reference/html/integration.html#mail
https://eclipse-ee4j.github.io/mail/#Download_Jakarta_Mail_Release
https://eclipse-ee4j.github.io/mail/docs/api/

