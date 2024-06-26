package oven;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.62.2)",
    comments = "Source: oven.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class OvenServiceGrpc {

  private OvenServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "oven.OvenService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<oven.OvenProto.OvenStatusRequest,
      oven.OvenProto.OvenStatusResponse> getGetOvenStatusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetOvenStatus",
      requestType = oven.OvenProto.OvenStatusRequest.class,
      responseType = oven.OvenProto.OvenStatusResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<oven.OvenProto.OvenStatusRequest,
      oven.OvenProto.OvenStatusResponse> getGetOvenStatusMethod() {
    io.grpc.MethodDescriptor<oven.OvenProto.OvenStatusRequest, oven.OvenProto.OvenStatusResponse> getGetOvenStatusMethod;
    if ((getGetOvenStatusMethod = OvenServiceGrpc.getGetOvenStatusMethod) == null) {
      synchronized (OvenServiceGrpc.class) {
        if ((getGetOvenStatusMethod = OvenServiceGrpc.getGetOvenStatusMethod) == null) {
          OvenServiceGrpc.getGetOvenStatusMethod = getGetOvenStatusMethod =
              io.grpc.MethodDescriptor.<oven.OvenProto.OvenStatusRequest, oven.OvenProto.OvenStatusResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetOvenStatus"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  oven.OvenProto.OvenStatusRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  oven.OvenProto.OvenStatusResponse.getDefaultInstance()))
              .setSchemaDescriptor(new OvenServiceMethodDescriptorSupplier("GetOvenStatus"))
              .build();
        }
      }
    }
    return getGetOvenStatusMethod;
  }

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
    if ((getControlOvenMethod = OvenServiceGrpc.getControlOvenMethod) == null) {
      synchronized (OvenServiceGrpc.class) {
        if ((getControlOvenMethod = OvenServiceGrpc.getControlOvenMethod) == null) {
          OvenServiceGrpc.getControlOvenMethod = getControlOvenMethod =
              io.grpc.MethodDescriptor.<oven.OvenProto.OvenControlRequest, oven.OvenProto.OvenControlResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ControlOven"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  oven.OvenProto.OvenControlRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  oven.OvenProto.OvenControlResponse.getDefaultInstance()))
              .setSchemaDescriptor(new OvenServiceMethodDescriptorSupplier("ControlOven"))
              .build();
        }
      }
    }
    return getControlOvenMethod;
  }

  private static volatile io.grpc.MethodDescriptor<oven.OvenProto.OvenMonitorRequest,
      oven.OvenProto.OvenStatusResponse> getMonitorOvenStatusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "MonitorOvenStatus",
      requestType = oven.OvenProto.OvenMonitorRequest.class,
      responseType = oven.OvenProto.OvenStatusResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<oven.OvenProto.OvenMonitorRequest,
      oven.OvenProto.OvenStatusResponse> getMonitorOvenStatusMethod() {
    io.grpc.MethodDescriptor<oven.OvenProto.OvenMonitorRequest, oven.OvenProto.OvenStatusResponse> getMonitorOvenStatusMethod;
    if ((getMonitorOvenStatusMethod = OvenServiceGrpc.getMonitorOvenStatusMethod) == null) {
      synchronized (OvenServiceGrpc.class) {
        if ((getMonitorOvenStatusMethod = OvenServiceGrpc.getMonitorOvenStatusMethod) == null) {
          OvenServiceGrpc.getMonitorOvenStatusMethod = getMonitorOvenStatusMethod =
              io.grpc.MethodDescriptor.<oven.OvenProto.OvenMonitorRequest, oven.OvenProto.OvenStatusResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "MonitorOvenStatus"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  oven.OvenProto.OvenMonitorRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  oven.OvenProto.OvenStatusResponse.getDefaultInstance()))
              .setSchemaDescriptor(new OvenServiceMethodDescriptorSupplier("MonitorOvenStatus"))
              .build();
        }
      }
    }
    return getMonitorOvenStatusMethod;
  }

  private static volatile io.grpc.MethodDescriptor<oven.OvenProto.OvenStatusResponse,
      oven.OvenProto.OvenControlRequest> getOptimizeEnergyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "OptimizeEnergy",
      requestType = oven.OvenProto.OvenStatusResponse.class,
      responseType = oven.OvenProto.OvenControlRequest.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<oven.OvenProto.OvenStatusResponse,
      oven.OvenProto.OvenControlRequest> getOptimizeEnergyMethod() {
    io.grpc.MethodDescriptor<oven.OvenProto.OvenStatusResponse, oven.OvenProto.OvenControlRequest> getOptimizeEnergyMethod;
    if ((getOptimizeEnergyMethod = OvenServiceGrpc.getOptimizeEnergyMethod) == null) {
      synchronized (OvenServiceGrpc.class) {
        if ((getOptimizeEnergyMethod = OvenServiceGrpc.getOptimizeEnergyMethod) == null) {
          OvenServiceGrpc.getOptimizeEnergyMethod = getOptimizeEnergyMethod =
              io.grpc.MethodDescriptor.<oven.OvenProto.OvenStatusResponse, oven.OvenProto.OvenControlRequest>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "OptimizeEnergy"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  oven.OvenProto.OvenStatusResponse.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  oven.OvenProto.OvenControlRequest.getDefaultInstance()))
              .setSchemaDescriptor(new OvenServiceMethodDescriptorSupplier("OptimizeEnergy"))
              .build();
        }
      }
    }
    return getOptimizeEnergyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<oven.OvenProto.HealthCheckRequest,
      oven.OvenProto.HealthCheckResponse> getHealthCheckMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "HealthCheck",
      requestType = oven.OvenProto.HealthCheckRequest.class,
      responseType = oven.OvenProto.HealthCheckResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<oven.OvenProto.HealthCheckRequest,
      oven.OvenProto.HealthCheckResponse> getHealthCheckMethod() {
    io.grpc.MethodDescriptor<oven.OvenProto.HealthCheckRequest, oven.OvenProto.HealthCheckResponse> getHealthCheckMethod;
    if ((getHealthCheckMethod = OvenServiceGrpc.getHealthCheckMethod) == null) {
      synchronized (OvenServiceGrpc.class) {
        if ((getHealthCheckMethod = OvenServiceGrpc.getHealthCheckMethod) == null) {
          OvenServiceGrpc.getHealthCheckMethod = getHealthCheckMethod =
              io.grpc.MethodDescriptor.<oven.OvenProto.HealthCheckRequest, oven.OvenProto.HealthCheckResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "HealthCheck"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  oven.OvenProto.HealthCheckRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  oven.OvenProto.HealthCheckResponse.getDefaultInstance()))
              .setSchemaDescriptor(new OvenServiceMethodDescriptorSupplier("HealthCheck"))
              .build();
        }
      }
    }
    return getHealthCheckMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static OvenServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<OvenServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<OvenServiceStub>() {
        @java.lang.Override
        public OvenServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new OvenServiceStub(channel, callOptions);
        }
      };
    return OvenServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static OvenServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<OvenServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<OvenServiceBlockingStub>() {
        @java.lang.Override
        public OvenServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new OvenServiceBlockingStub(channel, callOptions);
        }
      };
    return OvenServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static OvenServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<OvenServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<OvenServiceFutureStub>() {
        @java.lang.Override
        public OvenServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new OvenServiceFutureStub(channel, callOptions);
        }
      };
    return OvenServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     * <pre>
     * Unary RPC for getting oven status
     * </pre>
     */
    default void getOvenStatus(oven.OvenProto.OvenStatusRequest request,
        io.grpc.stub.StreamObserver<oven.OvenProto.OvenStatusResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetOvenStatusMethod(), responseObserver);
    }

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
     * Server Streaming RPC for real-time monitoring of oven status
     * </pre>
     */
    default void monitorOvenStatus(oven.OvenProto.OvenMonitorRequest request,
        io.grpc.stub.StreamObserver<oven.OvenProto.OvenStatusResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getMonitorOvenStatusMethod(), responseObserver);
    }

    /**
     * <pre>
     * Bidirectional Streaming RPC for energy optimization
     * </pre>
     */
    default io.grpc.stub.StreamObserver<oven.OvenProto.OvenStatusResponse> optimizeEnergy(
        io.grpc.stub.StreamObserver<oven.OvenProto.OvenControlRequest> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getOptimizeEnergyMethod(), responseObserver);
    }

    /**
     * <pre>
     * Server-side streaming RPC for health check
     * </pre>
     */
    default void healthCheck(oven.OvenProto.HealthCheckRequest request,
        io.grpc.stub.StreamObserver<oven.OvenProto.HealthCheckResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getHealthCheckMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service OvenService.
   */
  public static abstract class OvenServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return OvenServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service OvenService.
   */
  public static final class OvenServiceStub
      extends io.grpc.stub.AbstractAsyncStub<OvenServiceStub> {
    private OvenServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OvenServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new OvenServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Unary RPC for getting oven status
     * </pre>
     */
    public void getOvenStatus(oven.OvenProto.OvenStatusRequest request,
        io.grpc.stub.StreamObserver<oven.OvenProto.OvenStatusResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetOvenStatusMethod(), getCallOptions()), request, responseObserver);
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
     * Server Streaming RPC for real-time monitoring of oven status
     * </pre>
     */
    public void monitorOvenStatus(oven.OvenProto.OvenMonitorRequest request,
        io.grpc.stub.StreamObserver<oven.OvenProto.OvenStatusResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getMonitorOvenStatusMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Bidirectional Streaming RPC for energy optimization
     * </pre>
     */
    public io.grpc.stub.StreamObserver<oven.OvenProto.OvenStatusResponse> optimizeEnergy(
        io.grpc.stub.StreamObserver<oven.OvenProto.OvenControlRequest> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getOptimizeEnergyMethod(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     * Server-side streaming RPC for health check
     * </pre>
     */
    public void healthCheck(oven.OvenProto.HealthCheckRequest request,
        io.grpc.stub.StreamObserver<oven.OvenProto.HealthCheckResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getHealthCheckMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service OvenService.
   */
  public static final class OvenServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<OvenServiceBlockingStub> {
    private OvenServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OvenServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new OvenServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Unary RPC for getting oven status
     * </pre>
     */
    public oven.OvenProto.OvenStatusResponse getOvenStatus(oven.OvenProto.OvenStatusRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetOvenStatusMethod(), getCallOptions(), request);
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
     * Server Streaming RPC for real-time monitoring of oven status
     * </pre>
     */
    public java.util.Iterator<oven.OvenProto.OvenStatusResponse> monitorOvenStatus(
        oven.OvenProto.OvenMonitorRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getMonitorOvenStatusMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Server-side streaming RPC for health check
     * </pre>
     */
    public java.util.Iterator<oven.OvenProto.HealthCheckResponse> healthCheck(
        oven.OvenProto.HealthCheckRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getHealthCheckMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service OvenService.
   */
  public static final class OvenServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<OvenServiceFutureStub> {
    private OvenServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OvenServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new OvenServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Unary RPC for getting oven status
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<oven.OvenProto.OvenStatusResponse> getOvenStatus(
        oven.OvenProto.OvenStatusRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetOvenStatusMethod(), getCallOptions()), request);
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
  }

  private static final int METHODID_GET_OVEN_STATUS = 0;
  private static final int METHODID_CONTROL_OVEN = 1;
  private static final int METHODID_MONITOR_OVEN_STATUS = 2;
  private static final int METHODID_HEALTH_CHECK = 3;
  private static final int METHODID_OPTIMIZE_ENERGY = 4;

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
        case METHODID_GET_OVEN_STATUS:
          serviceImpl.getOvenStatus((oven.OvenProto.OvenStatusRequest) request,
              (io.grpc.stub.StreamObserver<oven.OvenProto.OvenStatusResponse>) responseObserver);
          break;
        case METHODID_CONTROL_OVEN:
          serviceImpl.controlOven((oven.OvenProto.OvenControlRequest) request,
              (io.grpc.stub.StreamObserver<oven.OvenProto.OvenControlResponse>) responseObserver);
          break;
        case METHODID_MONITOR_OVEN_STATUS:
          serviceImpl.monitorOvenStatus((oven.OvenProto.OvenMonitorRequest) request,
              (io.grpc.stub.StreamObserver<oven.OvenProto.OvenStatusResponse>) responseObserver);
          break;
        case METHODID_HEALTH_CHECK:
          serviceImpl.healthCheck((oven.OvenProto.HealthCheckRequest) request,
              (io.grpc.stub.StreamObserver<oven.OvenProto.HealthCheckResponse>) responseObserver);
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
        case METHODID_OPTIMIZE_ENERGY:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.optimizeEnergy(
              (io.grpc.stub.StreamObserver<oven.OvenProto.OvenControlRequest>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getGetOvenStatusMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              oven.OvenProto.OvenStatusRequest,
              oven.OvenProto.OvenStatusResponse>(
                service, METHODID_GET_OVEN_STATUS)))
        .addMethod(
          getControlOvenMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              oven.OvenProto.OvenControlRequest,
              oven.OvenProto.OvenControlResponse>(
                service, METHODID_CONTROL_OVEN)))
        .addMethod(
          getMonitorOvenStatusMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              oven.OvenProto.OvenMonitorRequest,
              oven.OvenProto.OvenStatusResponse>(
                service, METHODID_MONITOR_OVEN_STATUS)))
        .addMethod(
          getOptimizeEnergyMethod(),
          io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
            new MethodHandlers<
              oven.OvenProto.OvenStatusResponse,
              oven.OvenProto.OvenControlRequest>(
                service, METHODID_OPTIMIZE_ENERGY)))
        .addMethod(
          getHealthCheckMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              oven.OvenProto.HealthCheckRequest,
              oven.OvenProto.HealthCheckResponse>(
                service, METHODID_HEALTH_CHECK)))
        .build();
  }

  private static abstract class OvenServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    OvenServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return oven.OvenProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("OvenService");
    }
  }

  private static final class OvenServiceFileDescriptorSupplier
      extends OvenServiceBaseDescriptorSupplier {
    OvenServiceFileDescriptorSupplier() {}
  }

  private static final class OvenServiceMethodDescriptorSupplier
      extends OvenServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    OvenServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (OvenServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new OvenServiceFileDescriptorSupplier())
              .addMethod(getGetOvenStatusMethod())
              .addMethod(getControlOvenMethod())
              .addMethod(getMonitorOvenStatusMethod())
              .addMethod(getOptimizeEnergyMethod())
              .addMethod(getHealthCheckMethod())
              .build();
        }
      }
    }
    return result;
  }
}
