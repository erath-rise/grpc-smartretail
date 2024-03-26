package com.smartretail;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.62.2)",
    comments = "Source: SmartShelf.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class SmartShelfServiceGrpc {

  private SmartShelfServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "smartretail.inventory.SmartShelfService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.smartretail.SmartShelfProto.GetShelfInfoRequest,
      com.smartretail.SmartShelfProto.GetShelfInfoResponse> getGetShelfInfoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetShelfInfo",
      requestType = com.smartretail.SmartShelfProto.GetShelfInfoRequest.class,
      responseType = com.smartretail.SmartShelfProto.GetShelfInfoResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.smartretail.SmartShelfProto.GetShelfInfoRequest,
      com.smartretail.SmartShelfProto.GetShelfInfoResponse> getGetShelfInfoMethod() {
    io.grpc.MethodDescriptor<com.smartretail.SmartShelfProto.GetShelfInfoRequest, com.smartretail.SmartShelfProto.GetShelfInfoResponse> getGetShelfInfoMethod;
    if ((getGetShelfInfoMethod = SmartShelfServiceGrpc.getGetShelfInfoMethod) == null) {
      synchronized (SmartShelfServiceGrpc.class) {
        if ((getGetShelfInfoMethod = SmartShelfServiceGrpc.getGetShelfInfoMethod) == null) {
          SmartShelfServiceGrpc.getGetShelfInfoMethod = getGetShelfInfoMethod =
              io.grpc.MethodDescriptor.<com.smartretail.SmartShelfProto.GetShelfInfoRequest, com.smartretail.SmartShelfProto.GetShelfInfoResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetShelfInfo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.smartretail.SmartShelfProto.GetShelfInfoRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.smartretail.SmartShelfProto.GetShelfInfoResponse.getDefaultInstance()))
              .setSchemaDescriptor(new SmartShelfServiceMethodDescriptorSupplier("GetShelfInfo"))
              .build();
        }
      }
    }
    return getGetShelfInfoMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.smartretail.SmartShelfProto.UpdateShelfInfoRequest,
      com.smartretail.SmartShelfProto.UpdateShelfInfoResponse> getUpdateShelfInfoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateShelfInfo",
      requestType = com.smartretail.SmartShelfProto.UpdateShelfInfoRequest.class,
      responseType = com.smartretail.SmartShelfProto.UpdateShelfInfoResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.smartretail.SmartShelfProto.UpdateShelfInfoRequest,
      com.smartretail.SmartShelfProto.UpdateShelfInfoResponse> getUpdateShelfInfoMethod() {
    io.grpc.MethodDescriptor<com.smartretail.SmartShelfProto.UpdateShelfInfoRequest, com.smartretail.SmartShelfProto.UpdateShelfInfoResponse> getUpdateShelfInfoMethod;
    if ((getUpdateShelfInfoMethod = SmartShelfServiceGrpc.getUpdateShelfInfoMethod) == null) {
      synchronized (SmartShelfServiceGrpc.class) {
        if ((getUpdateShelfInfoMethod = SmartShelfServiceGrpc.getUpdateShelfInfoMethod) == null) {
          SmartShelfServiceGrpc.getUpdateShelfInfoMethod = getUpdateShelfInfoMethod =
              io.grpc.MethodDescriptor.<com.smartretail.SmartShelfProto.UpdateShelfInfoRequest, com.smartretail.SmartShelfProto.UpdateShelfInfoResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateShelfInfo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.smartretail.SmartShelfProto.UpdateShelfInfoRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.smartretail.SmartShelfProto.UpdateShelfInfoResponse.getDefaultInstance()))
              .setSchemaDescriptor(new SmartShelfServiceMethodDescriptorSupplier("UpdateShelfInfo"))
              .build();
        }
      }
    }
    return getUpdateShelfInfoMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SmartShelfServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SmartShelfServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SmartShelfServiceStub>() {
        @java.lang.Override
        public SmartShelfServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SmartShelfServiceStub(channel, callOptions);
        }
      };
    return SmartShelfServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SmartShelfServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SmartShelfServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SmartShelfServiceBlockingStub>() {
        @java.lang.Override
        public SmartShelfServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SmartShelfServiceBlockingStub(channel, callOptions);
        }
      };
    return SmartShelfServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SmartShelfServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SmartShelfServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SmartShelfServiceFutureStub>() {
        @java.lang.Override
        public SmartShelfServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SmartShelfServiceFutureStub(channel, callOptions);
        }
      };
    return SmartShelfServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void getShelfInfo(com.smartretail.SmartShelfProto.GetShelfInfoRequest request,
        io.grpc.stub.StreamObserver<com.smartretail.SmartShelfProto.GetShelfInfoResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetShelfInfoMethod(), responseObserver);
    }

    /**
     */
    default void updateShelfInfo(com.smartretail.SmartShelfProto.UpdateShelfInfoRequest request,
        io.grpc.stub.StreamObserver<com.smartretail.SmartShelfProto.UpdateShelfInfoResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateShelfInfoMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service SmartShelfService.
   */
  public static abstract class SmartShelfServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return SmartShelfServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service SmartShelfService.
   */
  public static final class SmartShelfServiceStub
      extends io.grpc.stub.AbstractAsyncStub<SmartShelfServiceStub> {
    private SmartShelfServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SmartShelfServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SmartShelfServiceStub(channel, callOptions);
    }

    /**
     */
    public void getShelfInfo(com.smartretail.SmartShelfProto.GetShelfInfoRequest request,
        io.grpc.stub.StreamObserver<com.smartretail.SmartShelfProto.GetShelfInfoResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getGetShelfInfoMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateShelfInfo(com.smartretail.SmartShelfProto.UpdateShelfInfoRequest request,
        io.grpc.stub.StreamObserver<com.smartretail.SmartShelfProto.UpdateShelfInfoResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateShelfInfoMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service SmartShelfService.
   */
  public static final class SmartShelfServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<SmartShelfServiceBlockingStub> {
    private SmartShelfServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SmartShelfServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SmartShelfServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<com.smartretail.SmartShelfProto.GetShelfInfoResponse> getShelfInfo(
        com.smartretail.SmartShelfProto.GetShelfInfoRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getGetShelfInfoMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.smartretail.SmartShelfProto.UpdateShelfInfoResponse updateShelfInfo(com.smartretail.SmartShelfProto.UpdateShelfInfoRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateShelfInfoMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service SmartShelfService.
   */
  public static final class SmartShelfServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<SmartShelfServiceFutureStub> {
    private SmartShelfServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SmartShelfServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SmartShelfServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.smartretail.SmartShelfProto.UpdateShelfInfoResponse> updateShelfInfo(
        com.smartretail.SmartShelfProto.UpdateShelfInfoRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateShelfInfoMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_SHELF_INFO = 0;
  private static final int METHODID_UPDATE_SHELF_INFO = 1;

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
        case METHODID_GET_SHELF_INFO:
          serviceImpl.getShelfInfo((com.smartretail.SmartShelfProto.GetShelfInfoRequest) request,
              (io.grpc.stub.StreamObserver<com.smartretail.SmartShelfProto.GetShelfInfoResponse>) responseObserver);
          break;
        case METHODID_UPDATE_SHELF_INFO:
          serviceImpl.updateShelfInfo((com.smartretail.SmartShelfProto.UpdateShelfInfoRequest) request,
              (io.grpc.stub.StreamObserver<com.smartretail.SmartShelfProto.UpdateShelfInfoResponse>) responseObserver);
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
          getGetShelfInfoMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              com.smartretail.SmartShelfProto.GetShelfInfoRequest,
              com.smartretail.SmartShelfProto.GetShelfInfoResponse>(
                service, METHODID_GET_SHELF_INFO)))
        .addMethod(
          getUpdateShelfInfoMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.smartretail.SmartShelfProto.UpdateShelfInfoRequest,
              com.smartretail.SmartShelfProto.UpdateShelfInfoResponse>(
                service, METHODID_UPDATE_SHELF_INFO)))
        .build();
  }

  private static abstract class SmartShelfServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SmartShelfServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.smartretail.SmartShelfProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SmartShelfService");
    }
  }

  private static final class SmartShelfServiceFileDescriptorSupplier
      extends SmartShelfServiceBaseDescriptorSupplier {
    SmartShelfServiceFileDescriptorSupplier() {}
  }

  private static final class SmartShelfServiceMethodDescriptorSupplier
      extends SmartShelfServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    SmartShelfServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (SmartShelfServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SmartShelfServiceFileDescriptorSupplier())
              .addMethod(getGetShelfInfoMethod())
              .addMethod(getUpdateShelfInfoMethod())
              .build();
        }
      }
    }
    return result;
  }
}
