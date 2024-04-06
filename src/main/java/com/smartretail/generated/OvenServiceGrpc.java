package com.smartretail.generated;

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
  private static volatile io.grpc.MethodDescriptor<OvenProto.OvenStatusRequest,
          OvenProto.OvenStatusResponse> getGetOvenStatusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getOvenStatus",
      requestType = OvenProto.OvenStatusRequest.class,
      responseType = OvenProto.OvenStatusResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<OvenProto.OvenStatusRequest,
          OvenProto.OvenStatusResponse> getGetOvenStatusMethod() {
    io.grpc.MethodDescriptor<OvenProto.OvenStatusRequest, OvenProto.OvenStatusResponse> getGetOvenStatusMethod;
    if ((getGetOvenStatusMethod = OvenServiceGrpc.getGetOvenStatusMethod) == null) {
      synchronized (OvenServiceGrpc.class) {
        if ((getGetOvenStatusMethod = OvenServiceGrpc.getGetOvenStatusMethod) == null) {
          OvenServiceGrpc.getGetOvenStatusMethod = getGetOvenStatusMethod =
              io.grpc.MethodDescriptor.<OvenProto.OvenStatusRequest, OvenProto.OvenStatusResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getOvenStatus"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  OvenProto.OvenStatusRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  OvenProto.OvenStatusResponse.getDefaultInstance()))
              .setSchemaDescriptor(new OvenServiceMethodDescriptorSupplier("getOvenStatus"))
              .build();
        }
      }
    }
    return getGetOvenStatusMethod;
  }

  private static volatile io.grpc.MethodDescriptor<OvenProto.OvenControlRequest,
          OvenProto.OvenControlResponse> getControlOvenMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ControlOven",
      requestType = OvenProto.OvenControlRequest.class,
      responseType = OvenProto.OvenControlResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<OvenProto.OvenControlRequest,
          OvenProto.OvenControlResponse> getControlOvenMethod() {
    io.grpc.MethodDescriptor<OvenProto.OvenControlRequest, OvenProto.OvenControlResponse> getControlOvenMethod;
    if ((getControlOvenMethod = OvenServiceGrpc.getControlOvenMethod) == null) {
      synchronized (OvenServiceGrpc.class) {
        if ((getControlOvenMethod = OvenServiceGrpc.getControlOvenMethod) == null) {
          OvenServiceGrpc.getControlOvenMethod = getControlOvenMethod =
              io.grpc.MethodDescriptor.<OvenProto.OvenControlRequest, OvenProto.OvenControlResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ControlOven"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  OvenProto.OvenControlRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  OvenProto.OvenControlResponse.getDefaultInstance()))
              .setSchemaDescriptor(new OvenServiceMethodDescriptorSupplier("ControlOven"))
              .build();
        }
      }
    }
    return getControlOvenMethod;
  }

  private static volatile io.grpc.MethodDescriptor<OvenProto.OvenMonitorRequest,
          OvenProto.OvenStatusResponse> getMonitorOvenMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "MonitorOven",
      requestType = OvenProto.OvenMonitorRequest.class,
      responseType = OvenProto.OvenStatusResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<OvenProto.OvenMonitorRequest,
          OvenProto.OvenStatusResponse> getMonitorOvenMethod() {
    io.grpc.MethodDescriptor<OvenProto.OvenMonitorRequest, OvenProto.OvenStatusResponse> getMonitorOvenMethod;
    if ((getMonitorOvenMethod = OvenServiceGrpc.getMonitorOvenMethod) == null) {
      synchronized (OvenServiceGrpc.class) {
        if ((getMonitorOvenMethod = OvenServiceGrpc.getMonitorOvenMethod) == null) {
          OvenServiceGrpc.getMonitorOvenMethod = getMonitorOvenMethod =
              io.grpc.MethodDescriptor.<OvenProto.OvenMonitorRequest, OvenProto.OvenStatusResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "MonitorOven"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  OvenProto.OvenMonitorRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  OvenProto.OvenStatusResponse.getDefaultInstance()))
              .setSchemaDescriptor(new OvenServiceMethodDescriptorSupplier("MonitorOven"))
              .build();
        }
      }
    }
    return getMonitorOvenMethod;
  }

  private static volatile io.grpc.MethodDescriptor<OvenProto.OvenStatusResponse,
          OvenProto.OvenControlRequest> getOptimizeOvenMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "OptimizeOven",
      requestType = OvenProto.OvenStatusResponse.class,
      responseType = OvenProto.OvenControlRequest.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<OvenProto.OvenStatusResponse,
          OvenProto.OvenControlRequest> getOptimizeOvenMethod() {
    io.grpc.MethodDescriptor<OvenProto.OvenStatusResponse, OvenProto.OvenControlRequest> getOptimizeOvenMethod;
    if ((getOptimizeOvenMethod = OvenServiceGrpc.getOptimizeOvenMethod) == null) {
      synchronized (OvenServiceGrpc.class) {
        if ((getOptimizeOvenMethod = OvenServiceGrpc.getOptimizeOvenMethod) == null) {
          OvenServiceGrpc.getOptimizeOvenMethod = getOptimizeOvenMethod =
              io.grpc.MethodDescriptor.<OvenProto.OvenStatusResponse, OvenProto.OvenControlRequest>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "OptimizeOven"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  OvenProto.OvenStatusResponse.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  OvenProto.OvenControlRequest.getDefaultInstance()))
              .setSchemaDescriptor(new OvenServiceMethodDescriptorSupplier("OptimizeOven"))
              .build();
        }
      }
    }
    return getOptimizeOvenMethod;
  }

  private static volatile io.grpc.MethodDescriptor<OvenProto.HealthCheckRequest,
          OvenProto.HealthCheckResponse> getHealthCheckMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "HealthCheck",
      requestType = OvenProto.HealthCheckRequest.class,
      responseType = OvenProto.HealthCheckResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<OvenProto.HealthCheckRequest,
          OvenProto.HealthCheckResponse> getHealthCheckMethod() {
    io.grpc.MethodDescriptor<OvenProto.HealthCheckRequest, OvenProto.HealthCheckResponse> getHealthCheckMethod;
    if ((getHealthCheckMethod = OvenServiceGrpc.getHealthCheckMethod) == null) {
      synchronized (OvenServiceGrpc.class) {
        if ((getHealthCheckMethod = OvenServiceGrpc.getHealthCheckMethod) == null) {
          OvenServiceGrpc.getHealthCheckMethod = getHealthCheckMethod =
              io.grpc.MethodDescriptor.<OvenProto.HealthCheckRequest, OvenProto.HealthCheckResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "HealthCheck"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  OvenProto.HealthCheckRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  OvenProto.HealthCheckResponse.getDefaultInstance()))
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
     */
    default void getOvenStatus(OvenProto.OvenStatusRequest request,
                               io.grpc.stub.StreamObserver<OvenProto.OvenStatusResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetOvenStatusMethod(), responseObserver);
    }

    /**
     */
    default void controlOven(OvenProto.OvenControlRequest request,
                             io.grpc.stub.StreamObserver<OvenProto.OvenControlResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getControlOvenMethod(), responseObserver);
    }

    /**
     */
    default void monitorOven(OvenProto.OvenMonitorRequest request,
                             io.grpc.stub.StreamObserver<OvenProto.OvenStatusResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getMonitorOvenMethod(), responseObserver);
    }

    /**
     */
    default io.grpc.stub.StreamObserver<OvenProto.OvenStatusResponse> optimizeOven(
        io.grpc.stub.StreamObserver<OvenProto.OvenControlRequest> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getOptimizeOvenMethod(), responseObserver);
    }

    /**
     * <pre>
     * Server-side streaming RPC for health check
     * </pre>
     */
    default void healthCheck(OvenProto.HealthCheckRequest request,
                             io.grpc.stub.StreamObserver<OvenProto.HealthCheckResponse> responseObserver) {
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
     */
    public void getOvenStatus(OvenProto.OvenStatusRequest request,
                              io.grpc.stub.StreamObserver<OvenProto.OvenStatusResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetOvenStatusMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void controlOven(OvenProto.OvenControlRequest request,
                            io.grpc.stub.StreamObserver<OvenProto.OvenControlResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getControlOvenMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void monitorOven(OvenProto.OvenMonitorRequest request,
                            io.grpc.stub.StreamObserver<OvenProto.OvenStatusResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getMonitorOvenMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<OvenProto.OvenStatusResponse> optimizeOven(
        io.grpc.stub.StreamObserver<OvenProto.OvenControlRequest> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getOptimizeOvenMethod(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     * Server-side streaming RPC for health check
     * </pre>
     */
    public void healthCheck(OvenProto.HealthCheckRequest request,
                            io.grpc.stub.StreamObserver<OvenProto.HealthCheckResponse> responseObserver) {
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
     */
    public OvenProto.OvenStatusResponse getOvenStatus(OvenProto.OvenStatusRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetOvenStatusMethod(), getCallOptions(), request);
    }

    /**
     */
    public OvenProto.OvenControlResponse controlOven(OvenProto.OvenControlRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getControlOvenMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<OvenProto.OvenStatusResponse> monitorOven(
        OvenProto.OvenMonitorRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getMonitorOvenMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Server-side streaming RPC for health check
     * </pre>
     */
    public java.util.Iterator<OvenProto.HealthCheckResponse> healthCheck(
        OvenProto.HealthCheckRequest request) {
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
     */
    public com.google.common.util.concurrent.ListenableFuture<OvenProto.OvenStatusResponse> getOvenStatus(
        OvenProto.OvenStatusRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetOvenStatusMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<OvenProto.OvenControlResponse> controlOven(
        OvenProto.OvenControlRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getControlOvenMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_OVEN_STATUS = 0;
  private static final int METHODID_CONTROL_OVEN = 1;
  private static final int METHODID_MONITOR_OVEN = 2;
  private static final int METHODID_HEALTH_CHECK = 3;
  private static final int METHODID_OPTIMIZE_OVEN = 4;

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
          serviceImpl.getOvenStatus((OvenProto.OvenStatusRequest) request,
              (io.grpc.stub.StreamObserver<OvenProto.OvenStatusResponse>) responseObserver);
          break;
        case METHODID_CONTROL_OVEN:
          serviceImpl.controlOven((OvenProto.OvenControlRequest) request,
              (io.grpc.stub.StreamObserver<OvenProto.OvenControlResponse>) responseObserver);
          break;
        case METHODID_MONITOR_OVEN:
          serviceImpl.monitorOven((OvenProto.OvenMonitorRequest) request,
              (io.grpc.stub.StreamObserver<OvenProto.OvenStatusResponse>) responseObserver);
          break;
        case METHODID_HEALTH_CHECK:
          serviceImpl.healthCheck((OvenProto.HealthCheckRequest) request,
              (io.grpc.stub.StreamObserver<OvenProto.HealthCheckResponse>) responseObserver);
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
        case METHODID_OPTIMIZE_OVEN:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.optimizeOven(
              (io.grpc.stub.StreamObserver<OvenProto.OvenControlRequest>) responseObserver);
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
                    OvenProto.OvenStatusRequest,
                    OvenProto.OvenStatusResponse>(
                service, METHODID_GET_OVEN_STATUS)))
        .addMethod(
          getControlOvenMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
                    OvenProto.OvenControlRequest,
                    OvenProto.OvenControlResponse>(
                service, METHODID_CONTROL_OVEN)))
        .addMethod(
          getMonitorOvenMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
                    OvenProto.OvenMonitorRequest,
                    OvenProto.OvenStatusResponse>(
                service, METHODID_MONITOR_OVEN)))
        .addMethod(
          getOptimizeOvenMethod(),
          io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
            new MethodHandlers<
                    OvenProto.OvenStatusResponse,
                    OvenProto.OvenControlRequest>(
                service, METHODID_OPTIMIZE_OVEN)))
        .addMethod(
          getHealthCheckMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
                    OvenProto.HealthCheckRequest,
                    OvenProto.HealthCheckResponse>(
                service, METHODID_HEALTH_CHECK)))
        .build();
  }

  private static abstract class OvenServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    OvenServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return OvenProto.getDescriptor();
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
              .addMethod(getMonitorOvenMethod())
              .addMethod(getOptimizeOvenMethod())
              .addMethod(getHealthCheckMethod())
              .build();
        }
      }
    }
    return result;
  }
}
