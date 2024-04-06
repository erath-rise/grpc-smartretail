package com.smartretail.generated;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.62.2)",
    comments = "Source: mobile_app.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class MobileAppServiceGrpc {

  private MobileAppServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "MobileAppService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<OvenProto.OvenStatusRequest,
          OvenProto.OvenStatusResponse> getGetOvenStatusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetOvenStatus",
      requestType = OvenProto.OvenStatusRequest.class,
      responseType = OvenProto.OvenStatusResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<OvenProto.OvenStatusRequest,
          OvenProto.OvenStatusResponse> getGetOvenStatusMethod() {
    io.grpc.MethodDescriptor<OvenProto.OvenStatusRequest, OvenProto.OvenStatusResponse> getGetOvenStatusMethod;
    if ((getGetOvenStatusMethod = MobileAppServiceGrpc.getGetOvenStatusMethod) == null) {
      synchronized (MobileAppServiceGrpc.class) {
        if ((getGetOvenStatusMethod = MobileAppServiceGrpc.getGetOvenStatusMethod) == null) {
          MobileAppServiceGrpc.getGetOvenStatusMethod = getGetOvenStatusMethod =
              io.grpc.MethodDescriptor.<OvenProto.OvenStatusRequest, OvenProto.OvenStatusResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetOvenStatus"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  OvenProto.OvenStatusRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  OvenProto.OvenStatusResponse.getDefaultInstance()))
              .setSchemaDescriptor(new MobileAppServiceMethodDescriptorSupplier("GetOvenStatus"))
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
    if ((getControlOvenMethod = MobileAppServiceGrpc.getControlOvenMethod) == null) {
      synchronized (MobileAppServiceGrpc.class) {
        if ((getControlOvenMethod = MobileAppServiceGrpc.getControlOvenMethod) == null) {
          MobileAppServiceGrpc.getControlOvenMethod = getControlOvenMethod =
              io.grpc.MethodDescriptor.<OvenProto.OvenControlRequest, OvenProto.OvenControlResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ControlOven"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  OvenProto.OvenControlRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  OvenProto.OvenControlResponse.getDefaultInstance()))
              .setSchemaDescriptor(new MobileAppServiceMethodDescriptorSupplier("ControlOven"))
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
    if ((getMonitorOvenMethod = MobileAppServiceGrpc.getMonitorOvenMethod) == null) {
      synchronized (MobileAppServiceGrpc.class) {
        if ((getMonitorOvenMethod = MobileAppServiceGrpc.getMonitorOvenMethod) == null) {
          MobileAppServiceGrpc.getMonitorOvenMethod = getMonitorOvenMethod =
              io.grpc.MethodDescriptor.<OvenProto.OvenMonitorRequest, OvenProto.OvenStatusResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "MonitorOven"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  OvenProto.OvenMonitorRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  OvenProto.OvenStatusResponse.getDefaultInstance()))
              .setSchemaDescriptor(new MobileAppServiceMethodDescriptorSupplier("MonitorOven"))
              .build();
        }
      }
    }
    return getMonitorOvenMethod;
  }

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
    if ((getGetFridgeStatusMethod = MobileAppServiceGrpc.getGetFridgeStatusMethod) == null) {
      synchronized (MobileAppServiceGrpc.class) {
        if ((getGetFridgeStatusMethod = MobileAppServiceGrpc.getGetFridgeStatusMethod) == null) {
          MobileAppServiceGrpc.getGetFridgeStatusMethod = getGetFridgeStatusMethod =
              io.grpc.MethodDescriptor.<FridgeProto.FridgeStatusRequest, FridgeProto.FridgeStatusResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetFridgeStatus"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  FridgeProto.FridgeStatusRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  FridgeProto.FridgeStatusResponse.getDefaultInstance()))
              .setSchemaDescriptor(new MobileAppServiceMethodDescriptorSupplier("GetFridgeStatus"))
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
    if ((getControlFridgeMethod = MobileAppServiceGrpc.getControlFridgeMethod) == null) {
      synchronized (MobileAppServiceGrpc.class) {
        if ((getControlFridgeMethod = MobileAppServiceGrpc.getControlFridgeMethod) == null) {
          MobileAppServiceGrpc.getControlFridgeMethod = getControlFridgeMethod =
              io.grpc.MethodDescriptor.<FridgeProto.ControlFridgeRequest, FridgeProto.ControlFridgeResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ControlFridge"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  FridgeProto.ControlFridgeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  FridgeProto.ControlFridgeResponse.getDefaultInstance()))
              .setSchemaDescriptor(new MobileAppServiceMethodDescriptorSupplier("ControlFridge"))
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
    if ((getMonitorFridgeMethod = MobileAppServiceGrpc.getMonitorFridgeMethod) == null) {
      synchronized (MobileAppServiceGrpc.class) {
        if ((getMonitorFridgeMethod = MobileAppServiceGrpc.getMonitorFridgeMethod) == null) {
          MobileAppServiceGrpc.getMonitorFridgeMethod = getMonitorFridgeMethod =
              io.grpc.MethodDescriptor.<FridgeProto.MonitorFridgeRequest, FridgeProto.FridgeStatusResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "MonitorFridge"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  FridgeProto.MonitorFridgeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  FridgeProto.FridgeStatusResponse.getDefaultInstance()))
              .setSchemaDescriptor(new MobileAppServiceMethodDescriptorSupplier("MonitorFridge"))
              .build();
        }
      }
    }
    return getMonitorFridgeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<MobileAppProto.NotificationRequest,
          MobileAppProto.NotificationResponse> getReceiveNotificationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ReceiveNotification",
      requestType = MobileAppProto.NotificationRequest.class,
      responseType = MobileAppProto.NotificationResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<MobileAppProto.NotificationRequest,
          MobileAppProto.NotificationResponse> getReceiveNotificationMethod() {
    io.grpc.MethodDescriptor<MobileAppProto.NotificationRequest, MobileAppProto.NotificationResponse> getReceiveNotificationMethod;
    if ((getReceiveNotificationMethod = MobileAppServiceGrpc.getReceiveNotificationMethod) == null) {
      synchronized (MobileAppServiceGrpc.class) {
        if ((getReceiveNotificationMethod = MobileAppServiceGrpc.getReceiveNotificationMethod) == null) {
          MobileAppServiceGrpc.getReceiveNotificationMethod = getReceiveNotificationMethod =
              io.grpc.MethodDescriptor.<MobileAppProto.NotificationRequest, MobileAppProto.NotificationResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ReceiveNotification"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  MobileAppProto.NotificationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  MobileAppProto.NotificationResponse.getDefaultInstance()))
              .setSchemaDescriptor(new MobileAppServiceMethodDescriptorSupplier("ReceiveNotification"))
              .build();
        }
      }
    }
    return getReceiveNotificationMethod;
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
    default void getFridgeStatus(FridgeProto.FridgeStatusRequest request,
                                 io.grpc.stub.StreamObserver<FridgeProto.FridgeStatusResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetFridgeStatusMethod(), responseObserver);
    }

    /**
     */
    default void controlFridge(FridgeProto.ControlFridgeRequest request,
                               io.grpc.stub.StreamObserver<FridgeProto.ControlFridgeResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getControlFridgeMethod(), responseObserver);
    }

    /**
     */
    default void monitorFridge(FridgeProto.MonitorFridgeRequest request,
                               io.grpc.stub.StreamObserver<FridgeProto.FridgeStatusResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getMonitorFridgeMethod(), responseObserver);
    }

    /**
     */
    default void receiveNotification(MobileAppProto.NotificationRequest request,
                                     io.grpc.stub.StreamObserver<MobileAppProto.NotificationResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getReceiveNotificationMethod(), responseObserver);
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
    public void getFridgeStatus(FridgeProto.FridgeStatusRequest request,
                                io.grpc.stub.StreamObserver<FridgeProto.FridgeStatusResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetFridgeStatusMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void controlFridge(FridgeProto.ControlFridgeRequest request,
                              io.grpc.stub.StreamObserver<FridgeProto.ControlFridgeResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getControlFridgeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void monitorFridge(FridgeProto.MonitorFridgeRequest request,
                              io.grpc.stub.StreamObserver<FridgeProto.FridgeStatusResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getMonitorFridgeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void receiveNotification(MobileAppProto.NotificationRequest request,
                                    io.grpc.stub.StreamObserver<MobileAppProto.NotificationResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getReceiveNotificationMethod(), getCallOptions()), request, responseObserver);
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
     */
    public FridgeProto.FridgeStatusResponse getFridgeStatus(FridgeProto.FridgeStatusRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetFridgeStatusMethod(), getCallOptions(), request);
    }

    /**
     */
    public FridgeProto.ControlFridgeResponse controlFridge(FridgeProto.ControlFridgeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getControlFridgeMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<FridgeProto.FridgeStatusResponse> monitorFridge(
        FridgeProto.MonitorFridgeRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getMonitorFridgeMethod(), getCallOptions(), request);
    }

    /**
     */
    public MobileAppProto.NotificationResponse receiveNotification(MobileAppProto.NotificationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getReceiveNotificationMethod(), getCallOptions(), request);
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

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<FridgeProto.FridgeStatusResponse> getFridgeStatus(
        FridgeProto.FridgeStatusRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetFridgeStatusMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<FridgeProto.ControlFridgeResponse> controlFridge(
        FridgeProto.ControlFridgeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getControlFridgeMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<MobileAppProto.NotificationResponse> receiveNotification(
        MobileAppProto.NotificationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getReceiveNotificationMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_OVEN_STATUS = 0;
  private static final int METHODID_CONTROL_OVEN = 1;
  private static final int METHODID_MONITOR_OVEN = 2;
  private static final int METHODID_GET_FRIDGE_STATUS = 3;
  private static final int METHODID_CONTROL_FRIDGE = 4;
  private static final int METHODID_MONITOR_FRIDGE = 5;
  private static final int METHODID_RECEIVE_NOTIFICATION = 6;

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
        case METHODID_RECEIVE_NOTIFICATION:
          serviceImpl.receiveNotification((MobileAppProto.NotificationRequest) request,
              (io.grpc.stub.StreamObserver<MobileAppProto.NotificationResponse>) responseObserver);
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
          getReceiveNotificationMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
                    MobileAppProto.NotificationRequest,
                    MobileAppProto.NotificationResponse>(
                service, METHODID_RECEIVE_NOTIFICATION)))
        .build();
  }

  private static abstract class MobileAppServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    MobileAppServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return MobileAppProto.getDescriptor();
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
              .addMethod(getGetOvenStatusMethod())
              .addMethod(getControlOvenMethod())
              .addMethod(getMonitorOvenMethod())
              .addMethod(getGetFridgeStatusMethod())
              .addMethod(getControlFridgeMethod())
              .addMethod(getMonitorFridgeMethod())
              .addMethod(getReceiveNotificationMethod())
              .build();
        }
      }
    }
    return result;
  }
}
