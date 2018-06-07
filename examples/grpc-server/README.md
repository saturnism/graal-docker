NOTE: This example doesn't work yet.

This is an example of building a small service using gRPC, and compile into a static binary.

## Build & Run

Pure Java:
```
$ mvn package
$ java -jar target/grpc-server-1.0-SNAPSHOT.jar
$ java -cp target/grpc-server-1.0-SNAPSHOT.jar com.example.Client localhost:8080 Ray
```

Graal (with Docker):

```
$ docker build -t grpc-server
$ docker run -ti --rm grpc-server -p 8080:8080 helloworld-server
$ java -cp target/grpc-server-1.0-SNAPSHOT.jar com.example.Client localhost:8080 Ray
```

This produces an error on the server side:
```
[ [ SubstrateSegfaultHandler caught signal 11 ] ]

General Purpose Register Set Values: 

  RAX 00007fa3c0003680
  RBX 00000000011976c8
  RCX 0000000000000000
  RDX 0000000000000008
  RBP 0000000000000000
  RSI 0000000000000000
  RDI 00000000011976c8
  RSP 00007fb21f1fe5d0
  R8  0000000000000003
  R9  00007fb21e84bed8
  R10 00007fb21e84bed8
  R11 00007fb21e856a90
  R12 0000000000004000
  R13 0000000000000400
  R14 0000000000000400
  R15 00007fb214000b20
  EFL 0000000000010202
  RIP 000000000058e04b
  

JavaFrameAnchor dump:

  No anchors
  
DeoptStubPointer address: 0000000000000000

TopFrame info:

  Lookup TotalFrameSize in CodeInfoTable:
  SourceTotalFrameSize 48
  
VMThreads info:

  VMThread 00007fb214000b20  STATUS_IN_JAVA (safepoints disabled)
  VMThread 00007fb210000b20  STATUS_IN_NATIVE
  VMThread 00007fb218000b20  STATUS_IN_NATIVE
  VMThread 00000000013ecb20  STATUS_IN_NATIVE
  
VM Thread State for current thread 00007fb214000b20:

  0 (8 bytes): com.oracle.svm.core.genscavenge.PinnedAllocatorImpl.openPinnedAllocator = null
  8 (8 bytes): com.oracle.svm.core.heap.NoAllocationVerifier.openVerifiers = null
  16 (8 bytes): com.oracle.svm.core.jdk.IdentityHashCodeSupport.hashCodeGeneratorTL = java.util.SplittableRandom  00007fb21e8016b8
  24 (8 bytes): com.oracle.svm.core.snippets.SnippetRuntime.currentException = null
  32 (8 bytes): com.oracle.svm.core.thread.JavaThreads.currentThread = io.netty.util.concurrent.FastThreadLocalThread  00007fb21f203400
  40 (8 bytes): com.oracle.svm.core.thread.ThreadingSupportImpl.activeTimer = null
  48 (32 bytes): com.oracle.svm.core.genscavenge.ThreadLocalAllocation.pinnedTLAB = 
    00007fb214000b50: 0000000000000000 0000000000000000
    00007fb214000b60: 0000000000000000 0000000000000000
    
  
  80 (32 bytes): com.oracle.svm.core.genscavenge.ThreadLocalAllocation.regularTLAB = 
    00007fb214000b70: 00007fb21e800000 00007fb21e900000
    00007fb214000b80: 00007fb21e856b48 0000000000000000
    
  
  112 (8 bytes): com.oracle.svm.core.genscavenge.ThreadLocalAllocation.freeList = 0  0000000000000000
  120 (8 bytes): com.oracle.svm.core.posix.thread.PosixVMThreads.IsolateTL = 94598687557484880  0150150150150150
  128 (8 bytes): com.oracle.svm.core.stack.JavaFrameAnchors.lastAnchor = 0  0000000000000000
  136 (8 bytes): com.oracle.svm.core.thread.VMThreads.nextTL = 140402749344544  00007fb210000b20
  144 (4 bytes): com.oracle.svm.core.thread.Safepoint.safepointRequested = -15474  ffffc38e
  148 (4 bytes): com.oracle.svm.core.thread.Safepoint.safepointRequestedValueBeforeSafepoint = 0  00000000
  152 (4 bytes): com.oracle.svm.core.thread.VMOperationControl.isLockOwner = 0  00000000
  156 (4 bytes): com.oracle.svm.core.thread.VMThreads$StatusSupport.safepointsDisabledTL = 1  00000001
  160 (4 bytes): com.oracle.svm.core.thread.VMThreads$StatusSupport.statusTL = 1  00000001
  
VMOperation dump:

  No VMOperation in progress
  

RuntimeCodeCache dump:

  == [Recent RuntimeCodeCache operations: ]
  
  == [RuntimeCodeCache: 0 methods]
  
Deoptimizer dump:

  == [Recent Deoptimizer Events: 
  ]
  
Dump Counters:

  
Raw Stacktrace:

  00007fb21f1fe5d0: 00000000011976c8 00000000005441fc
  00007fb21f1fe5e0: 00007fb21f2031b0 0000000000000008
  00007fb21f1fe5f0: 00000000011976c8 00000000005478ac
  00007fb21f1fe600: 0000000000000010 000000000054623f
  00007fb21f1fe610: 00007fb21e803d60 0000000020c1bf80
  00007fb21f1fe620: 00000000011976c8 000000000057e675
  00007fb21f1fe630: 00007fb21e84bed8 00000000005441fc
  00007fb21f1fe640: 00007fb21e803e30 0000000000000008
  00007fb21f1fe650: 00007fb21e804388 0000000000593d85
  00007fb21f1fe660: 00007fb21e804388 00000000005948df
  00007fb21f1fe670: 00007fb21e803e30 00000000004ee33c
  00007fb21f1fe680: 00007fb21e8043b8 00000000005590eb
  00007fb21f1fe690: 0000000000000000 00007fb21e803650
  00007fb21f1fe6a0: 00007fb21f202bd0 505249202a204854
  00007fb21f1fe6b0: 0000000000d24d90 0000000000000003
  00007fb21f1fe6c0: 0000000000547870 0000000000593d50
  00007fb21f1fe6d0: 000000001f202e00 0000000000d1e438
  00007fb21f1fe6e0: 000000031e803650 0000000000d1a2f8
  00007fb21f1fe6f0: 0000000000000018 00007fb21e8043b8
  00007fb21f1fe700: 000000001f202e00 00007fb21e84bed8
  00007fb21f1fe710: 0000000000d15d30 0000000000614a5b
  00007fb21f1fe720: 00007fb21f202de8 000000000049b805
  00007fb21f1fe730: 00007fb21e804480 0000001000842e05
  00007fb21f1fe740: 00007fb21e8043b8 000000001f202de8
  00007fb21f1fe750: 0000000000548960 00000018005d4727
  00007fb21f1fe760: 0000000000548920 000000181f202948
  00007fb21f1fe770: 0000000000d1a2f8 00007fb21e84bed8
  00007fb21f1fe780: 00007fb21e804360 000000000061462c
  00007fb21f1fe790: 00007fb21e803820 00000000009ed460
  00007fb21f1fe7a0: 00000000009ed630 00007fb21e856a90
  00007fb21f1fe7b0: 00007fb21e84bed8 00007fb21e804080
  00007fb21f1fe7c0: 00007fb21e804360 0000000000616eb7
  00007fb21f1fe7d0: 00007fb21e84bfa8 00007fb21e856a90
  00007fb21f1fe7e0: 00007fb21e84bed8 00007fb21e804080
  00007fb21f1fe7f0: 00007fb21e803190 00000000005d754b
  00007fb21f1fe800: 00007fb21e803a30 00007fb21e803298
  00007fb21f1fe810: 00007fb21e803a30 00007fb21e856a90
  00007fb21f1fe820: 00007fb21e84bed8 00007fb21e804080
  00007fb21f1fe830: 00007fb21e803190 00000000005d5f02
  00007fb21f1fe840: 00007fb21f203400 00007fb21e8033a8
  00007fb21f1fe850: 00000000009ed460 000000000064ee2a
  00007fb21f1fe860: 000000011e801500 0000000100000000
  00007fb21f1fe870: 00007fb21e855f18 0000003900000000
  00007fb21f1fe880: 0000000000548920 0000000000547d10
  00007fb21f1fe890: 00007fb21e856a90 00007fb21e84bed8
  00007fb21f1fe8a0: 00007fb21e804080 00007fb21e803190
  00007fb21f1fe8b0: 0000000100000000 00000000005d6eb3
  00007fb21f1fe8c0: 00007fb21e855ed8 000000000049b805
  00007fb21f1fe8d0: 0000000000d1aa18 00007fb21f202778
  00007fb21f1fe8e0: 0000000000000000 00007fb21e856a90
  00007fb21f1fe8f0: 00007fb21e84bed8 00007fb21e804080
  00007fb21f1fe900: 00007fb21e803190 00000000005a3974
  00007fb21f1fe910: 00007fb21f2029d0 00000000005a21bb
  00007fb21f1fe920: 00007fb21f202948 00007fb21e84bed8
  00007fb21f1fe930: 00007fb21e804080 00000000005a3a6b
  00007fb21f1fe940: 00007fb21e855e98 00007fb21f202830
  00007fb21f1fe950: 0000000000000039 00007fb21e84bed8
  00007fb21f1fe960: 00007fb220c1bf80 00007fb21e804080
  00007fb21f1fe970: 00007fb21e84bed8 00000000005a2414
  00007fb21f1fe980: 0000000000d1a2f8 00007fb21e855e98
  00007fb21f1fe990: 00007fb21e84bed8 00007fb21e84bed8
  00007fb21f1fe9a0: 00007fb21f202cf8 00000000005b6c87
  00007fb21f1fe9b0: 00007fb21f202830 00007fb220c1bf80
  00007fb21f1fe9c0: 00007fb21e84bed8 00007fb21f202cf8
  
Stacktrace Stage0:

  RSP 00007fb21f1fe5d0 RIP 000000000058e04b FrameSize 48
  RSP 00007fb21f1fe600 RIP 00000000005478ac FrameSize 48
  RSP 00007fb21f1fe630 RIP 000000000057e675 FrameSize 48
  RSP 00007fb21f1fe660 RIP 0000000000593d85 FrameSize 48
  RSP 00007fb21f1fe690 RIP 00000000005590eb FrameSize 144
  RSP 00007fb21f1fe720 RIP 0000000000614a5b FrameSize 112
  RSP 00007fb21f1fe790 RIP 000000000061462c FrameSize 64
  RSP 00007fb21f1fe7d0 RIP 0000000000616eb7 FrameSize 48
  RSP 00007fb21f1fe800 RIP 00000000005d754b FrameSize 64
  RSP 00007fb21f1fe840 RIP 00000000005d5f02 FrameSize 128
  RSP 00007fb21f1fe8c0 RIP 00000000005d6eb3 FrameSize 80
  RSP 00007fb21f1fe910 RIP 00000000005a3974 FrameSize 48
  RSP 00007fb21f1fe940 RIP 00000000005a3a6b FrameSize 64
  RSP 00007fb21f1fe980 RIP 00000000005a2414 FrameSize 48
  RSP 00007fb21f1fe9b0 RIP 00000000005b6c87 FrameSize 48
  RSP 00007fb21f1fe9e0 RIP 00000000005a3974 FrameSize 48
  RSP 00007fb21f1fea10 RIP 00000000005a3a6b FrameSize 64
  RSP 00007fb21f1fea50 RIP 00000000005c461b FrameSize 96
  RSP 00007fb21f1feab0 RIP 00000000005ca048 FrameSize 80
  RSP 00007fb21f1feb00 RIP 00000000005ca96b FrameSize 128
  RSP 00007fb21f1feb80 RIP 00000000005ca41b FrameSize 32
  RSP 00007fb21f1feba0 RIP 00000000005cbeab FrameSize 80
  RSP 00007fb21f1febf0 RIP 0000000000654fc8 FrameSize 160
  RSP 00007fb21f1fec90 RIP 000000000064fedf FrameSize 32
  RSP 00007fb21f1fecb0 RIP 00000000006b283f FrameSize 32
  RSP 00007fb21f1fecd0 RIP 00000000004df687 FrameSize 96
  RSP 00007fb21f1fed30 RIP 00000000004a0ca4 FrameSize 144
  
Stacktrace Stage1:

  RSP 00007fb21f1fe5d0 RIP 000000000058e04b  com.oracle.svm.core.code.ImageCodeInfo@0xce20e0 name = image code
  RSP 00007fb21f1fe600 RIP 00000000005478ac  com.oracle.svm.core.code.ImageCodeInfo@0xce20e0 name = image code
  RSP 00007fb21f1fe630 RIP 000000000057e675  com.oracle.svm.core.code.ImageCodeInfo@0xce20e0 name = image code
  RSP 00007fb21f1fe660 RIP 0000000000593d85  com.oracle.svm.core.code.ImageCodeInfo@0xce20e0 name = image code
  RSP 00007fb21f1fe690 RIP 00000000005590eb  com.oracle.svm.core.code.ImageCodeInfo@0xce20e0 name = image code
  RSP 00007fb21f1fe720 RIP 0000000000614a5b  com.oracle.svm.core.code.ImageCodeInfo@0xce20e0 name = image code
  RSP 00007fb21f1fe790 RIP 000000000061462c  com.oracle.svm.core.code.ImageCodeInfo@0xce20e0 name = image code
  RSP 00007fb21f1fe7d0 RIP 0000000000616eb7  com.oracle.svm.core.code.ImageCodeInfo@0xce20e0 name = image code
  RSP 00007fb21f1fe800 RIP 00000000005d754b  com.oracle.svm.core.code.ImageCodeInfo@0xce20e0 name = image code
  RSP 00007fb21f1fe840 RIP 00000000005d5f02  com.oracle.svm.core.code.ImageCodeInfo@0xce20e0 name = image code
  RSP 00007fb21f1fe8c0 RIP 00000000005d6eb3  com.oracle.svm.core.code.ImageCodeInfo@0xce20e0 name = image code
  RSP 00007fb21f1fe910 RIP 00000000005a3974  com.oracle.svm.core.code.ImageCodeInfo@0xce20e0 name = image code
  RSP 00007fb21f1fe940 RIP 00000000005a3a6b  com.oracle.svm.core.code.ImageCodeInfo@0xce20e0 name = image code
  RSP 00007fb21f1fe980 RIP 00000000005a2414  com.oracle.svm.core.code.ImageCodeInfo@0xce20e0 name = image code
  RSP 00007fb21f1fe9b0 RIP 00000000005b6c87  com.oracle.svm.core.code.ImageCodeInfo@0xce20e0 name = image code
  RSP 00007fb21f1fe9e0 RIP 00000000005a3974  com.oracle.svm.core.code.ImageCodeInfo@0xce20e0 name = image code
  RSP 00007fb21f1fea10 RIP 00000000005a3a6b  com.oracle.svm.core.code.ImageCodeInfo@0xce20e0 name = image code
  RSP 00007fb21f1fea50 RIP 00000000005c461b  com.oracle.svm.core.code.ImageCodeInfo@0xce20e0 name = image code
  RSP 00007fb21f1feab0 RIP 00000000005ca048  com.oracle.svm.core.code.ImageCodeInfo@0xce20e0 name = image code
  RSP 00007fb21f1feb00 RIP 00000000005ca96b  com.oracle.svm.core.code.ImageCodeInfo@0xce20e0 name = image code
  RSP 00007fb21f1feb80 RIP 00000000005ca41b  com.oracle.svm.core.code.ImageCodeInfo@0xce20e0 name = image code
  RSP 00007fb21f1feba0 RIP 00000000005cbeab  com.oracle.svm.core.code.ImageCodeInfo@0xce20e0 name = image code
  RSP 00007fb21f1febf0 RIP 0000000000654fc8  com.oracle.svm.core.code.ImageCodeInfo@0xce20e0 name = image code
  RSP 00007fb21f1fec90 RIP 000000000064fedf  com.oracle.svm.core.code.ImageCodeInfo@0xce20e0 name = image code
  RSP 00007fb21f1fecb0 RIP 00000000006b283f  com.oracle.svm.core.code.ImageCodeInfo@0xce20e0 name = image code
  RSP 00007fb21f1fecd0 RIP 00000000004df687  com.oracle.svm.core.code.ImageCodeInfo@0xce20e0 name = image code
  RSP 00007fb21f1fed30 RIP 00000000004a0ca4  com.oracle.svm.core.code.ImageCodeInfo@0xce20e0 name = image code
  
Full Stacktrace:

  
  RSP 00007fb21f1fe600 RIP 00000000005478ac  [image code] io.netty.buffer.AbstractByteBuf.getLong(AbstractByteBuf.java:444)
  RSP 00007fb21f1fe630 RIP 000000000057e675  [image code] io.netty.buffer.ReadOnlyByteBuf.getLong(ReadOnlyByteBuf.java:373)
  RSP 00007fb21f1fe660 RIP 0000000000593d85  [image code] io.netty.buffer.WrappedByteBuf.getLong(WrappedByteBuf.java:294)
  RSP 00007fb21f1fe690 RIP 00000000005590eb  [image code] io.netty.buffer.ByteBufUtil.equals(ByteBufUtil.java:230)
  RSP 00007fb21f1fe720 RIP 0000000000614a5b  [image code] io.netty.handler.codec.http2.Http2ConnectionHandler$PrefaceDecoder.readClientPrefaceString(Http2ConnectionHandler.java:306)
  RSP 00007fb21f1fe790 RIP 000000000061462c  [image code] io.netty.handler.codec.http2.Http2ConnectionHandler$PrefaceDecoder.decode(Http2ConnectionHandler.java:251)
  RSP 00007fb21f1fe7d0 RIP 0000000000616eb7  [image code] io.netty.handler.codec.http2.Http2ConnectionHandler.decode(Http2ConnectionHandler.java:450)
  RSP 00007fb21f1fe800 RIP 00000000005d754b  [image code] io.netty.handler.codec.ByteToMessageDecoder.decodeRemovalReentryProtection(ByteToMessageDecoder.java:489)
  RSP 00007fb21f1fe840 RIP 00000000005d5f02  [image code] io.netty.handler.codec.ByteToMessageDecoder.callDecode(ByteToMessageDecoder.java:428)
  RSP 00007fb21f1fe8c0 RIP 00000000005d6eb3  [image code] io.netty.handler.codec.ByteToMessageDecoder.channelRead(ByteToMessageDecoder.java:265)
  RSP 00007fb21f1fe910 RIP 00000000005a3974  [image code] io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:362)
  RSP 00007fb21f1fe940 RIP 00000000005a3a6b  [image code] io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:348)
  RSP 00007fb21f1fe980 RIP 00000000005a2414  [image code] io.netty.channel.AbstractChannelHandlerContext.fireChannelRead(AbstractChannelHandlerContext.java:340)
  RSP 00007fb21f1fe9b0 RIP 00000000005b6c87  [image code] io.netty.channel.DefaultChannelPipeline$HeadContext.channelRead(DefaultChannelPipeline.java:1414)
  RSP 00007fb21f1fe9e0 RIP 00000000005a3974  [image code] io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:362)
  RSP 00007fb21f1fea10 RIP 00000000005a3a6b  [image code] io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:348)
  RSP 00007fb21f1fea50 RIP 00000000005c461b  [image code] io.netty.channel.DefaultChannelPipeline.fireChannelRead(DefaultChannelPipeline.java:945)
  RSP 00007fb21f1fea50 RIP 00000000005c461b  [image code] io.netty.channel.nio.AbstractNioByteChannel$NioByteUnsafe.read(AbstractNioByteChannel.java:146)
  RSP 00007fb21f1feab0 RIP 00000000005ca048  [image code] io.netty.channel.nio.NioEventLoop.processSelectedKey(NioEventLoop.java:645)
  RSP 00007fb21f1feb00 RIP 00000000005ca96b  [image code] io.netty.channel.nio.NioEventLoop.processSelectedKeysPlain(NioEventLoop.java:545)
  RSP 00007fb21f1feb80 RIP 00000000005ca41b  [image code] io.netty.channel.nio.NioEventLoop.processSelectedKeys(NioEventLoop.java:499)
  RSP 00007fb21f1feba0 RIP 00000000005cbeab  [image code] io.netty.channel.nio.NioEventLoop.run(NioEventLoop.java:459)
  RSP 00007fb21f1febf0 RIP 0000000000654fc8  [image code] io.netty.util.concurrent.SingleThreadEventExecutor$5.run(SingleThreadEventExecutor.java:886)
  RSP 00007fb21f1fec90 RIP 000000000064fedf  [image code] io.netty.util.concurrent.FastThreadLocalRunnable.run(FastThreadLocalRunnable.java:30)
  RSP 00007fb21f1fecb0 RIP 00000000006b283f  [image code] java.lang.Thread.run(Thread.java:748)
  RSP 00007fb21f1fecd0 RIP 00000000004df687  [image code] com.oracle.svm.core.posix.thread.PosixJavaThreads.pthreadStartRoutine(PosixJavaThreads.java:224)
  RSP 00007fb21f1fed30 RIP 00000000004a0ca4  [image code] com.oracle.svm.core.code.CEntryPointCallStubs.com_002eoracle_002esvm_002ecore_002eposix_002ethread_002ePosixJavaThreads_002epthreadStartRoutine_0028com_002eoracle_002esvm_002ecore_002eposix_002ethread_002ePosixJavaThreads_0024ThreadStartData_0029(generated:0)
  
Use runtime option -R:-InstallSegfaultHandler if you don't want to use SubstrateSegfaultHandler.

Bye bye ...
```

## Graal Native Image
This example uses Graal to compile the fat JAR into a single statically linked binary.
The JAR itself is ~9MB, but of course, it'll require a JVM to run. But the statically linked binary is only ~14MB!

In the [Dockerfile](Dockerfile), I used multi-stage build:
1. Use Maven to build the fat JAR
1. Use Graal to build the statically linked binary
1. Copy the binary into `scratch` container base image.

This produces a 14MB image.

## Dealing with Unsafe
There are several uses of `sun.misc.Unsafe` in Protobuf's `com.google.protobuf.UnsafeUtil`. The static initializer is attempting to use `Unsafe` to determine offsets and index scale. I used `@RecomputeFieldValue` to replace the value generated by Graal. See [](src/main/java/com/example/graal/Target_com_google_protobuf_UnsafeUtil.java).

## Ctrl+C?
When running the JAR in JVM, I can Ctrl+C to stop the server. However, when running the statically linked binary, Ctrl+C seems broken. To stop the server, I needed to kill it explicitly:

```
$ docker ps   <-- find the container ID
$ docker kill [the container ID]
```
