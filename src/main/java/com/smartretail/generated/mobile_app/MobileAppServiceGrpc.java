package mobile_app;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.62.2)",
    comments = "Source: mobile_app.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class MobileAppServiceGrpc {

  private MobileAppServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "mobile_app.MobileAppService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<oven.OvenProto.OvenControlRequest,
      oven.OvenProto.OvenControlResponse> getControlOvenMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ControlOven",
      requestType = oven.OvenProto.OvenControlRequest.class,
      responseType = oven.OvenProto.OvenControlResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<oven.OvenProto.OvenControlRequest,
      oven.OvenProto.OvenControlResponse> getControlOvenMethod() {
    io.grpc.MethodDescriptor<oven.OvenProto.OvenControlRequest, oven.OvenProto.OvenControlResponse> getControlOvenMethod;
    if ((getControlOvenMethod = MobileAppServiceGrpc.getControlOvenMethod) == null) {
      synchronized (MobileAppServiceGrpc.class) {
        if ((getControlOvenMethod = MobileAppServiceGrpc.getControlOvenMethod) == null) {
          MobileAppServiceGrpc.getControlOvenMethod = getControlOvenMethod =
              io.grpc.MethodDescriptor.<oven.OvenProto.OvenControlRequest, oven.OvenProto.OvenControlResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ControlOven"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  oven.OvenProto.OvenControlRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  oven.OvenProto.OvenControlResponse.getDefaultInstance()))
              .setSchemaDescriptor(new MobileAppServiceMethodDescriptorSupplier("ControlOven"))
              .build();
        }
      }
    }
    return getControlOvenMethod;
  }

  private static volatile io.grpc.MethodDescriptor<fridge.FridgeProto.FridgeControlRequest,
      fridge.FridgeProto.FridgeControlResponse> getControlFridgeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ControlFridge",
      requestType = fridge.FridgeProto.FridgeControlRequest.class,
      responseType = fridge.FridgeProto.FridgeControlResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<fridge.FridgeProto.FridgeControlRequest,
      fridge.FridgeProto.FridgeControlResponse> getControlFridgeMethod() {
    io.grpc.MethodDescriptor<fridge.FridgeProto.FridgeControlRequest, fridge.FridgeProto.FridgeControlResponse> getControlFridgeMethod;
    if ((getControlFridgeMethod = MobileAppServiceGrpc.getControlFridgeMethod) == null) {
      synchronized (MobileAppServiceGrpc.class) {
        if ((getControlFridgeMethod = MobileAppServiceGrpc.getControlFridgeMethod) == null) {
          MobileAppServiceGrpc.getControlFridgeMethod = getControlFridgeMethod =
              io.grpc.MethodDescriptor.<fridge.FridgeProto.FridgeControlRequest, fridge.FridgeProto.FridgeControlResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ControlFridge"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  fridge.FridgeProto.FridgeControlRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  fridge.FridgeProto.FridgeControlResponse.getDefaultInstance()))
              .setSchemaDescriptor(new MobileAppServiceMethodDescriptorSupplier("ControlFridge"))
              .build();
        }
      }
    }
    return getControlFridgeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<mobile_app.MobileAppProto.OvenMonitorRequest,
      oven.OvenProto.OvenStatusResponse> getMonitorOvenStatusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "MonitorOvenStatus",
      requestType = mobile_app.MobileAppProto.OvenMonitorRequest.class,
      responseType = oven.OvenProto.OvenStatusResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<mobile_app.MobileAppProto.OvenMonitorRequest,
      oven.OvenProto.OvenStatusResponse> getMonitorOvenStatusMethod() {
    io.grpc.MethodDescriptor<mobile_app.MobileAppProto.OvenMonitorRequest, oven.OvenProto.OvenStatusResponse> getMonitorOvenStatusMethod;
    if ((getMonitorOvenStatusMethod = MobileAppServiceGrpc.getMonitorOvenStatusMethod) == null) {
      synchronized (MobileAppServiceGrpc.class) {
        if ((getMonitorOvenStatusMethod = MobileAppServiceGrpc.getMonitorOvenStatusMethod) == null) {
          MobileAppServiceGrpc.getMonitorOvenStatusMethod = getMonitorOvenStatusMethod =
              io.grpc.MethodDescriptor.<mobile_app.MobileAppProto.OvenMonitorRequest, oven.OvenProto.OvenStatusResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "MonitorOvenStatus"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  mobile_app.MobileAppProto.OvenMonitorRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  oven.OvenProto.OvenStatusResponse.getDefaultInstance()))
              .setSchemaDescriptor(new MobileAppServiceMethodDescriptorSupplier("MonitorOvenStatus"))
              .build();
        }
      }
    }
    return getMonitorOvenStatusMethod;
  }

  private static volatile io.grpc.MethodDescriptor<mobile_app.MobileAppProto.FridgeMonitorRequest,
      fridge.FridgeProto.FridgeStatusResponse> getMonitorFridgeStatusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "MonitorFridgeStatus",
      requestType = mobile_app.MobileAppProto.FridgeMonitorRequest.class,
      responseType = fridge.FridgeProto.FridgeStatusResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<mobile_app.MobileAppProto.FridgeMonitorRequest,
      fridge.FridgeProto.FridgeStatusResponse> getMonitorFridgeStatusMethod() {
    io.grpc.MethodDescriptor<mobile_app.MobileAppProto.FridgeMonitorRequest, fridge.FridgeProto.FridgeStatusResponse> getMonitorFridgeStatusMethod;
    if ((getMonitorFridgeStatusMethod = MobileAppServiceGrpc.getMonitorFridgeStatusMethod) == null) {
      synchronized (MobileAppServiceGrpc.class) {
        if ((getMonitorFridgeStatusMethod = MobileAppServiceGrpc.getMonitorFridgeStatusMethod) == null) {
          MobileAppServiceGrpc.getMonitorFridgeStatusMethod = getMonitorFridgeStatusMethod =
              io.grpc.MethodDescriptor.<mobile_app.MobileAppProto.FridgeMonitorRequest, fridge.FridgeProto.FridgeStatusResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "MonitorFridgeStatus"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  mobile_app.MobileAppProto.FridgeMonitorRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  fridge.FridgeProto.FridgeStatusResponse.getDefaultInstance()))
              .setSchemaDescriptor(new MobileAppServiceMethodDescriptorSupplier("MonitorFridgeStatus"))
              .build();
        }
      }
    }
    return getMonitorFridgeStatusMethod;
  }

  private static volatile io.grpc.MethodDescriptor<mobile_app.MobileAppProto.HealthCheckRequest,
      mobile_app.MobileAppProto.HealthCheckResponse> getHealthCheckMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "HealthCheck",
      requestType = mobile_app.MobileAppProto.HealthCheckRequest.class,
      responseType = mobile_app.MobileAppProto.HealthCheckResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<mobile_app.MobileAppProto.HealthCheckRequest,
      mobile_app.MobileAppProto.HealthCheckResponse> getHealthCheckMethod() {
    io.grpc.MethodDescriptor<mobile_app.MobileAppProto.HealthCheckRequest, mobile_app.MobileAppProto.HealthCheckResponse> getHealthCheckMethod;
    if ((getHealthCheckMethod = MobileAppServiceGrpc.getHealthCheckMethod) == null) {
      synchronized (MobileAppServiceGrpc.class) {
        if ((getHealthCheckMethod = MobileAppServiceGrpc.getHealthCheckMethod) == null) {
          MobileAppServiceGrpc.getHealthCheckMethod = getHealthCheckMethod =
              io.grpc.MethodDescriptor.<mobile_app.MobileAppProto.HealthCheckRequest, mobile_app.MobileAppProto.HealthCheckResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "HealthCheck"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  mobile_app.MobileAppProto.HealthCheckRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  mobile_app.MobileAppProto.HealthCheckResponse.getDefaultInstance()))
              .setSchemaDescriptor(new MobileAppServiceMethodDescriptorSupplier("HealthCheck"))
              .build();
        }
      }
    }
    return getHealthCheckMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static MobileAppServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MobileAppServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MobileAppServiceStub>() {
        @java.lang.Override
        public MobileAppServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MobileAppServiceStub(channel, callOptions);
        }
      };
    return MobileAppServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static MobileAppServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MobileAppServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MobileAppServiceBlockingStub>() {
        @java.lang.Override
        public MobileAppServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MobileAppServiceBlockingStub(channel, callOptions);
        }
      };
    return MobileAppServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static MobileAppServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MobileAppServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MobileAppServiceFutureStub>() {
        @java.lang.Override
        public MobileAppServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MobileAppServiceFutureStub(channel, callOptions);
        }
      };
    return MobileAppServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     * <pre>
     * Unary RPC for controlling the oven
     * </pre>
     */
    default void controlOven(oven.OvenProto.OvenControlRequest request,
        io.grpc.stub.StreamObserver<oven.OvenProto.OvenControlResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getControlOvenMethod(), responseObserver);
    }

    /**
     * <pre>
     * Unary RPC for controlling the fridge
     * </pre>
     */
    default void controlFridge(fridge.FridgeProto.FridgeControlRequest request,
        io.grpc.stub.StreamObserver<fridge.FridgeProto.FridgeControlResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getControlFridgeMethod(), responseObserver);
    }

    /**
     * <pre>
     * Server Streaming RPC for displaying real-time status of oven
     * </pre>
     */
    default void monitorOvenStatus(mobile_app.MobileAppProto.OvenMonitorRequest request,
        io.grpc.stub.StreamObserver<oven.OvenProto.OvenStatusResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getMonitorOvenStatusMethod(), responseObserver);
    }

    /**
     * <pre>
     * Server Streaming RPC for displaying real-time status of fridge
     * </pre>
     */
    default void monitorFridgeStatus(mobile_app.MobileAppProto.FridgeMonitorRequest request,
        io.grpc.stub.StreamObserver<fridge.FridgeProto.FridgeStatusResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getMonitorFridgeStatusMethod(), responseObserver);
    }

    /**
     * <pre>
     * Server-side streaming RPC for health check
     * </pre>
     */
    default void healthCheck(mobile_app.MobileAppProto.HealthCheckRequest request,
        io.grpc.stub.StreamObserver<mobile_app.MobileAppProto.HealthCheckResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getHealthCheckMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service MobileAppService.
   */
  public static abstract class MobileAppServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return MobileAppServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service MobileAppService.
   */
  public static final class MobileAppServiceStub
      extends io.grpc.stub.AbstractAsyncStub<MobileAppServiceStub> {
    private MobileAppServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MobileAppServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MobileAppServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Unary RPC for controlling the oven
     * </pre>
     */
    public void controlOven(oven.OvenProto.OvenControlRequest request,
        io.grpc.stub.StreamObserver<oven.OvenProto.OvenControlResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getControlOvenMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Unary RPC for controlling the fridge
     * </pre>
     */
    public void controlFridge(fridge.FridgeProto.FridgeControlRequest request,
        io.grpc.stub.StreamObserver<fridge.FridgeProto.FridgeControlResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getControlFridgeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Server Streaming RPC for displaying real-time status of oven
     * </pre>
     */
    public void monitorOvenStatus(mobile_app.MobileAppProto.OvenMonitorRequest request,
        io.grpc.stub.StreamObserver<oven.OvenProto.OvenStatusResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getMonitorOvenStatusMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Server Streaming RPC for displaying real-time status of fridge
     * </pre>
     */
    public void monitorFridgeStatus(mobile_app.MobileAppProto.FridgeMonitorRequest request,
        io.grpc.stub.StreamObserver<fridge.FridgeProto.FridgeStatusResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getMonitorFridgeStatusMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Server-side streaming RPC for health check
     * </pre>
     */
    public void healthCheck(mobile_app.MobileAppProto.HealthCheckRequest request,
        io.grpc.stub.StreamObserver<mobile_app.MobileAppProto.HealthCheckResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getHealthCheckMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service MobileAppService.
   */
  public static final class MobileAppServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<MobileAppServiceBlockingStub> {
    private MobileAppServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MobileAppServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MobileAppServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Unary RPC for controlling the oven
     * </pre>
     */
    public oven.OvenProto.OvenControlResponse controlOven(oven.OvenProto.OvenControlRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getControlOvenMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Unary RPC for controlling the fridge
     * </pre>
     */
    public fridge.FridgeProto.FridgeControlResponse controlFridge(fridge.FridgeProto.FridgeControlRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getControlFridgeMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Server Streaming RPC for displaying real-time status of oven
     * </pre>
     */
    public java.util.Iterator<oven.OvenProto.OvenStatusResponse> monitorOvenStatus(
        mobile_app.MobileAppProto.OvenMonitorRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getMonitorOvenStatusMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Server Streaming RPC for displaying real-time status of fridge
     * </pre>
     */
    public java.util.Iterator<fridge.FridgeProto.FridgeStatusResponse> monitorFridgeStatus(
        mobile_app.MobileAppProto.FridgeMonitorRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getMonitorFridgeStatusMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Server-side streaming RPC for health check
     * </pre>
     */
    public java.util.Iterator<mobile_app.MobileAppProto.HealthCheckResponse> healthCheck(
        mobile_app.MobileAppProto.HealthCheckRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getHealthCheckMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service MobileAppService.
   */
  public static final class MobileAppServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<MobileAppServiceFutureStub> {
    private MobileAppServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MobileAppServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MobileAppServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Unary RPC for controlling the oven
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<oven.OvenProto.OvenControlResponse> controlOven(
        oven.OvenProto.OvenControlRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getControlOvenMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Unary RPC for controlling the fridge
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<fridge.FridgeProto.FridgeControlResponse> controlFridge(
        fridge.FridgeProto.FridgeControlRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getControlFridgeMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CONTROL_OVEN = 0;
  private static final int METHODID_CONTROL_FRIDGE = 1;
  private static final int METHODID_MONITOR_OVEN_STATUS = 2;
  private static final int METHODID_MONITOR_FRIDGE_STATUS = 3;
  private static final int METHODID_HEALTH_CHECK = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CONTROL_OVEN:
          serviceImpl.controlOven((oven.OvenProto.OvenControlRequest) request,
              (io.grpc.stub.StreamObserver<oven.OvenProto.OvenControlResponse>) responseObserver);
          break;
        case METHODID_CONTROL_FRIDGE:
          serviceImpl.controlFridge((fridge.FridgeProto.FridgeControlRequest) request,
              (io.grpc.stub.StreamObserver<fridge.FridgeProto.FridgeControlResponse>) responseObserver);
          break;
        case METHODID_MONITOR_OVEN_STATUS:
          serviceImpl.monitorOvenStatus((mobile_app.MobileAppProto.OvenMonitorRequest) request,
              (io.grpc.stub.StreamObserver<oven.OvenProto.OvenStatusResponse>) responseObserver);
          break;
        case METHODID_MONITOR_FRIDGE_STATUS:
          serviceImpl.monitorFridgeStatus((mobile_app.MobileAppProto.FridgeMonitorRequest) request,
              (io.grpc.stub.StreamObserver<fridge.FridgeProto.FridgeStatusResponse>) responseObserver);
          break;
        case METHODID_HEALTH_CHECK:
          serviceImpl.healthCheck((mobile_app.MobileAppProto.HealthCheckRequest) request,
              (io.grpc.stub.StreamObserver<mobile_app.MobileAppProto.HealthCheckResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getControlOvenMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              oven.OvenProto.OvenControlRequest,
              oven.OvenProto.OvenControlResponse>(
                service, METHODID_CONTROL_OVEN)))
        .addMethod(
          getControlFridgeMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              fridge.FridgeProto.FridgeControlRequest,
              fridge.FridgeProto.FridgeControlResponse>(
                service, METHODID_CONTROL_FRIDGE)))
        .addMethod(
          getMonitorOvenStatusMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              mobile_app.MobileAppProto.OvenMonitorRequest,
              oven.OvenProto.OvenStatusResponse>(
                service, METHODID_MONITOR_OVEN_STATUS)))
        .addMethod(
          getMonitorFridgeStatusMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              mobile_app.MobileAppProto.FridgeMonitorRequest,
              fridge.FridgeProto.FridgeStatusResponse>(
                service, METHODID_MONITOR_FRIDGE_STATUS)))
        .addMethod(
          getHealthCheckMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              mobile_app.MobileAppProto.HealthCheckRequest,
              mobile_app.MobileAppProto.HealthCheckResponse>(
                service, METHODID_HEALTH_CHECK)))
        .build();
  }

  private static abstract class MobileAppServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    MobileAppServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return mobile_app.MobileAppProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("MobileAppService");
    }
  }

  private static final class MobileAppServiceFileDescriptorSupplier
      extends MobileAppServiceBaseDescriptorSupplier {
    MobileAppServiceFileDescriptorSupplier() {}
  }

  private static final class MobileAppServiceMethodDescriptorSupplier
      extends MobileAppServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    MobileAppServiceMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (MobileAppServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new MobileAppServiceFileDescriptorSupplier())
              .addMethod(getControlOvenMethod())
              .addMethod(getControlFridgeMethod())
              .addMethod(getMonitorOvenStatusMethod())
              .addMethod(getMonitorFridgeStatusMethod())
              .addMethod(getHealthCheckMethod())
              .build();
        }
      }
    }
    return result;
  }
}
