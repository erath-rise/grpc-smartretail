package com.smartretail.generated;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.62.2)",
    comments = "Source: fridge.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class FridgeServiceGrpc {

  private FridgeServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "fridge.FridgeService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<FridgeProto.FridgeStatusRequest,
      FridgeProto.FridgeStatusResponse> getGetFridgeStatusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetFridgeStatus",
      requestType = FridgeProto.FridgeStatusRequest.class,
      responseType = FridgeProto.FridgeStatusResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<FridgeProto.FridgeStatusRequest,
      FridgeProto.FridgeStatusResponse> getGetFridgeStatusMethod() {
    io.grpc.MethodDescriptor<FridgeProto.FridgeStatusRequest, FridgeProto.FridgeStatusResponse> getGetFridgeStatusMethod;
    if ((getGetFridgeStatusMethod = FridgeServiceGrpc.getGetFridgeStatusMethod) == null) {
      synchronized (FridgeServiceGrpc.class) {
        if ((getGetFridgeStatusMethod = FridgeServiceGrpc.getGetFridgeStatusMethod) == null) {
          FridgeServiceGrpc.getGetFridgeStatusMethod = getGetFridgeStatusMethod =
              io.grpc.MethodDescriptor.<FridgeProto.FridgeStatusRequest, FridgeProto.FridgeStatusResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetFridgeStatus"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  FridgeProto.FridgeStatusRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  FridgeProto.FridgeStatusResponse.getDefaultInstance()))
              .setSchemaDescriptor(new FridgeServiceMethodDescriptorSupplier("GetFridgeStatus"))
              .build();
        }
      }
    }
    return getGetFridgeStatusMethod;
  }

  private static volatile io.grpc.MethodDescriptor<FridgeProto.ControlFridgeRequest,
      FridgeProto.ControlFridgeResponse> getControlFridgeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ControlFridge",
      requestType = FridgeProto.ControlFridgeRequest.class,
      responseType = FridgeProto.ControlFridgeResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<FridgeProto.ControlFridgeRequest,
      FridgeProto.ControlFridgeResponse> getControlFridgeMethod() {
    io.grpc.MethodDescriptor<FridgeProto.ControlFridgeRequest, FridgeProto.ControlFridgeResponse> getControlFridgeMethod;
    if ((getControlFridgeMethod = FridgeServiceGrpc.getControlFridgeMethod) == null) {
      synchronized (FridgeServiceGrpc.class) {
        if ((getControlFridgeMethod = FridgeServiceGrpc.getControlFridgeMethod) == null) {
          FridgeServiceGrpc.getControlFridgeMethod = getControlFridgeMethod =
              io.grpc.MethodDescriptor.<FridgeProto.ControlFridgeRequest, FridgeProto.ControlFridgeResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ControlFridge"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  FridgeProto.ControlFridgeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  FridgeProto.ControlFridgeResponse.getDefaultInstance()))
              .setSchemaDescriptor(new FridgeServiceMethodDescriptorSupplier("ControlFridge"))
              .build();
        }
      }
    }
    return getControlFridgeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<FridgeProto.MonitorFridgeRequest,
      FridgeProto.FridgeStatusResponse> getMonitorFridgeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "MonitorFridge",
      requestType = FridgeProto.MonitorFridgeRequest.class,
      responseType = FridgeProto.FridgeStatusResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<FridgeProto.MonitorFridgeRequest,
      FridgeProto.FridgeStatusResponse> getMonitorFridgeMethod() {
    io.grpc.MethodDescriptor<FridgeProto.MonitorFridgeRequest, FridgeProto.FridgeStatusResponse> getMonitorFridgeMethod;
    if ((getMonitorFridgeMethod = FridgeServiceGrpc.getMonitorFridgeMethod) == null) {
      synchronized (FridgeServiceGrpc.class) {
        if ((getMonitorFridgeMethod = FridgeServiceGrpc.getMonitorFridgeMethod) == null) {
          FridgeServiceGrpc.getMonitorFridgeMethod = getMonitorFridgeMethod =
              io.grpc.MethodDescriptor.<FridgeProto.MonitorFridgeRequest, FridgeProto.FridgeStatusResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "MonitorFridge"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  FridgeProto.MonitorFridgeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  FridgeProto.FridgeStatusResponse.getDefaultInstance()))
              .setSchemaDescriptor(new FridgeServiceMethodDescriptorSupplier("MonitorFridge"))
              .build();
        }
      }
    }
    return getMonitorFridgeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<FridgeProto.HealthCheckRequest,
      FridgeProto.HealthCheckResponse> getHealthCheckMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "HealthCheck",
      requestType = FridgeProto.HealthCheckRequest.class,
      responseType = FridgeProto.HealthCheckResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<FridgeProto.HealthCheckRequest,
      FridgeProto.HealthCheckResponse> getHealthCheckMethod() {
    io.grpc.MethodDescriptor<FridgeProto.HealthCheckRequest, FridgeProto.HealthCheckResponse> getHealthCheckMethod;
    if ((getHealthCheckMethod = FridgeServiceGrpc.getHealthCheckMethod) == null) {
      synchronized (FridgeServiceGrpc.class) {
        if ((getHealthCheckMethod = FridgeServiceGrpc.getHealthCheckMethod) == null) {
          FridgeServiceGrpc.getHealthCheckMethod = getHealthCheckMethod =
              io.grpc.MethodDescriptor.<FridgeProto.HealthCheckRequest, FridgeProto.HealthCheckResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "HealthCheck"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  FridgeProto.HealthCheckRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  FridgeProto.HealthCheckResponse.getDefaultInstance()))
              .setSchemaDescriptor(new FridgeServiceMethodDescriptorSupplier("HealthCheck"))
              .build();
        }
      }
    }
    return getHealthCheckMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static FridgeServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FridgeServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FridgeServiceStub>() {
        @java.lang.Override
        public FridgeServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FridgeServiceStub(channel, callOptions);
        }
      };
    return FridgeServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static FridgeServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FridgeServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FridgeServiceBlockingStub>() {
        @java.lang.Override
        public FridgeServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FridgeServiceBlockingStub(channel, callOptions);
        }
      };
    return FridgeServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static FridgeServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FridgeServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FridgeServiceFutureStub>() {
        @java.lang.Override
        public FridgeServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FridgeServiceFutureStub(channel, callOptions);
        }
      };
    return FridgeServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void getFridgeStatus(FridgeProto.FridgeStatusRequest request,
                                 io.grpc.stub.StreamObserver<FridgeProto.FridgeStatusResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetFridgeStatusMethod(), responseObserver);
    }

    /**
     * <pre>
     * control the fridge ON/OFF
     * </pre>
     */
    default void controlFridge(FridgeProto.ControlFridgeRequest request,
                               io.grpc.stub.StreamObserver<FridgeProto.ControlFridgeResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getControlFridgeMethod(), responseObserver);
    }

    /**
     * <pre>
     * Stream for real-time monitoring of the fridge's status
     * </pre>
     */
    default void monitorFridge(FridgeProto.MonitorFridgeRequest request,
                               io.grpc.stub.StreamObserver<FridgeProto.FridgeStatusResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getMonitorFridgeMethod(), responseObserver);
    }

    /**
     */
    default void healthCheck(FridgeProto.HealthCheckRequest request,
                             io.grpc.stub.StreamObserver<FridgeProto.HealthCheckResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getHealthCheckMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service FridgeService.
   */
  public static abstract class FridgeServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return FridgeServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service FridgeService.
   */
  public static final class FridgeServiceStub
      extends io.grpc.stub.AbstractAsyncStub<FridgeServiceStub> {
    private FridgeServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FridgeServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FridgeServiceStub(channel, callOptions);
    }

    /**
     */
    public void getFridgeStatus(FridgeProto.FridgeStatusRequest request,
                                io.grpc.stub.StreamObserver<FridgeProto.FridgeStatusResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetFridgeStatusMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * control the fridge ON/OFF
     * </pre>
     */
    public void controlFridge(FridgeProto.ControlFridgeRequest request,
                              io.grpc.stub.StreamObserver<FridgeProto.ControlFridgeResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getControlFridgeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Stream for real-time monitoring of the fridge's status
     * </pre>
     */
    public void monitorFridge(FridgeProto.MonitorFridgeRequest request,
                              io.grpc.stub.StreamObserver<FridgeProto.FridgeStatusResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getMonitorFridgeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void healthCheck(FridgeProto.HealthCheckRequest request,
                            io.grpc.stub.StreamObserver<FridgeProto.HealthCheckResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getHealthCheckMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service FridgeService.
   */
  public static final class FridgeServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<FridgeServiceBlockingStub> {
    private FridgeServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FridgeServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FridgeServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public FridgeProto.FridgeStatusResponse getFridgeStatus(FridgeProto.FridgeStatusRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetFridgeStatusMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * control the fridge ON/OFF
     * </pre>
     */
    public FridgeProto.ControlFridgeResponse controlFridge(FridgeProto.ControlFridgeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getControlFridgeMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Stream for real-time monitoring of the fridge's status
     * </pre>
     */
    public java.util.Iterator<FridgeProto.FridgeStatusResponse> monitorFridge(
        FridgeProto.MonitorFridgeRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getMonitorFridgeMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<FridgeProto.HealthCheckResponse> healthCheck(
        FridgeProto.HealthCheckRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getHealthCheckMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service FridgeService.
   */
  public static final class FridgeServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<FridgeServiceFutureStub> {
    private FridgeServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FridgeServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FridgeServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<FridgeProto.FridgeStatusResponse> getFridgeStatus(
        FridgeProto.FridgeStatusRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetFridgeStatusMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * control the fridge ON/OFF
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<FridgeProto.ControlFridgeResponse> controlFridge(
        FridgeProto.ControlFridgeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getControlFridgeMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_FRIDGE_STATUS = 0;
  private static final int METHODID_CONTROL_FRIDGE = 1;
  private static final int METHODID_MONITOR_FRIDGE = 2;
  private static final int METHODID_HEALTH_CHECK = 3;

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
        case METHODID_GET_FRIDGE_STATUS:
          serviceImpl.getFridgeStatus((FridgeProto.FridgeStatusRequest) request,
              (io.grpc.stub.StreamObserver<FridgeProto.FridgeStatusResponse>) responseObserver);
          break;
        case METHODID_CONTROL_FRIDGE:
          serviceImpl.controlFridge((FridgeProto.ControlFridgeRequest) request,
              (io.grpc.stub.StreamObserver<FridgeProto.ControlFridgeResponse>) responseObserver);
          break;
        case METHODID_MONITOR_FRIDGE:
          serviceImpl.monitorFridge((FridgeProto.MonitorFridgeRequest) request,
              (io.grpc.stub.StreamObserver<FridgeProto.FridgeStatusResponse>) responseObserver);
          break;
        case METHODID_HEALTH_CHECK:
          serviceImpl.healthCheck((FridgeProto.HealthCheckRequest) request,
              (io.grpc.stub.StreamObserver<FridgeProto.HealthCheckResponse>) responseObserver);
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
          getGetFridgeStatusMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              FridgeProto.FridgeStatusRequest,
              FridgeProto.FridgeStatusResponse>(
                service, METHODID_GET_FRIDGE_STATUS)))
        .addMethod(
          getControlFridgeMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              FridgeProto.ControlFridgeRequest,
              FridgeProto.ControlFridgeResponse>(
                service, METHODID_CONTROL_FRIDGE)))
        .addMethod(
          getMonitorFridgeMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              FridgeProto.MonitorFridgeRequest,
              FridgeProto.FridgeStatusResponse>(
                service, METHODID_MONITOR_FRIDGE)))
        .addMethod(
          getHealthCheckMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              FridgeProto.HealthCheckRequest,
              FridgeProto.HealthCheckResponse>(
                service, METHODID_HEALTH_CHECK)))
        .build();
  }

  private static abstract class FridgeServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    FridgeServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return FridgeProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("FridgeService");
    }
  }

  private static final class FridgeServiceFileDescriptorSupplier
      extends FridgeServiceBaseDescriptorSupplier {
    FridgeServiceFileDescriptorSupplier() {}
  }

  private static final class FridgeServiceMethodDescriptorSupplier
      extends FridgeServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    FridgeServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (FridgeServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new FridgeServiceFileDescriptorSupplier())
              .addMethod(getGetFridgeStatusMethod())
              .addMethod(getControlFridgeMethod())
              .addMethod(getMonitorFridgeMethod())
              .addMethod(getHealthCheckMethod())
              .build();
        }
      }
    }
    return result;
  }
}