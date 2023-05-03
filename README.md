# mini-rpc
本项目是基于Spring、Netty和ZooKeeper实现的一个轻量级RPC框架：
 使用 Netty实现网络传输，Netty 重用 Channel 避免重复连接服务端，实现了心跳机制，保证客户端和服务端的连接不被断掉，避免重连
 使用开源的序列化机制protostuff替代 JDK 自带的序列化机制
 使用 Zookeeper 作为注册中心，管理相关服务地址信息
 使用 CompletableFuture 包装接受客户端返回结果
 客户端调用远程服务的时候通过一致性哈希算法实现负载均衡 ，用服务的时候，从很多服务地址中根据相应的负载均衡算法选取一个服务地址
 通过自定义注解配合BeanPostProcessor机制实现了服务启动时的自动发布功能
 项目中对JDK的SPI进行优化，实现了一个支持可插拔式扩展组件及对实现类按需实例化的SPI机制
