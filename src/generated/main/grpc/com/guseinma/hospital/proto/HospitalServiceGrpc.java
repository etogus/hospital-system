package com.guseinma.hospital.proto;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.58.0)",
    comments = "Source: com/guseinma/hospital/hospital.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class HospitalServiceGrpc {

  private HospitalServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "com.guseinma.hospital.HospitalService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.guseinma.hospital.proto.Hospital,
      com.guseinma.hospital.proto.OperationResponse> getCreateHospitalMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateHospital",
      requestType = com.guseinma.hospital.proto.Hospital.class,
      responseType = com.guseinma.hospital.proto.OperationResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.guseinma.hospital.proto.Hospital,
      com.guseinma.hospital.proto.OperationResponse> getCreateHospitalMethod() {
    io.grpc.MethodDescriptor<com.guseinma.hospital.proto.Hospital, com.guseinma.hospital.proto.OperationResponse> getCreateHospitalMethod;
    if ((getCreateHospitalMethod = HospitalServiceGrpc.getCreateHospitalMethod) == null) {
      synchronized (HospitalServiceGrpc.class) {
        if ((getCreateHospitalMethod = HospitalServiceGrpc.getCreateHospitalMethod) == null) {
          HospitalServiceGrpc.getCreateHospitalMethod = getCreateHospitalMethod =
              io.grpc.MethodDescriptor.<com.guseinma.hospital.proto.Hospital, com.guseinma.hospital.proto.OperationResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateHospital"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.guseinma.hospital.proto.Hospital.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.guseinma.hospital.proto.OperationResponse.getDefaultInstance()))
              .setSchemaDescriptor(new HospitalServiceMethodDescriptorSupplier("CreateHospital"))
              .build();
        }
      }
    }
    return getCreateHospitalMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.guseinma.hospital.proto.Hospital,
      com.guseinma.hospital.proto.OperationResponse> getUpdateHospitalMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateHospital",
      requestType = com.guseinma.hospital.proto.Hospital.class,
      responseType = com.guseinma.hospital.proto.OperationResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.guseinma.hospital.proto.Hospital,
      com.guseinma.hospital.proto.OperationResponse> getUpdateHospitalMethod() {
    io.grpc.MethodDescriptor<com.guseinma.hospital.proto.Hospital, com.guseinma.hospital.proto.OperationResponse> getUpdateHospitalMethod;
    if ((getUpdateHospitalMethod = HospitalServiceGrpc.getUpdateHospitalMethod) == null) {
      synchronized (HospitalServiceGrpc.class) {
        if ((getUpdateHospitalMethod = HospitalServiceGrpc.getUpdateHospitalMethod) == null) {
          HospitalServiceGrpc.getUpdateHospitalMethod = getUpdateHospitalMethod =
              io.grpc.MethodDescriptor.<com.guseinma.hospital.proto.Hospital, com.guseinma.hospital.proto.OperationResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateHospital"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.guseinma.hospital.proto.Hospital.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.guseinma.hospital.proto.OperationResponse.getDefaultInstance()))
              .setSchemaDescriptor(new HospitalServiceMethodDescriptorSupplier("UpdateHospital"))
              .build();
        }
      }
    }
    return getUpdateHospitalMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.guseinma.hospital.proto.HospitalId,
      com.guseinma.hospital.proto.OperationResponse> getDeleteHospitalMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteHospital",
      requestType = com.guseinma.hospital.proto.HospitalId.class,
      responseType = com.guseinma.hospital.proto.OperationResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.guseinma.hospital.proto.HospitalId,
      com.guseinma.hospital.proto.OperationResponse> getDeleteHospitalMethod() {
    io.grpc.MethodDescriptor<com.guseinma.hospital.proto.HospitalId, com.guseinma.hospital.proto.OperationResponse> getDeleteHospitalMethod;
    if ((getDeleteHospitalMethod = HospitalServiceGrpc.getDeleteHospitalMethod) == null) {
      synchronized (HospitalServiceGrpc.class) {
        if ((getDeleteHospitalMethod = HospitalServiceGrpc.getDeleteHospitalMethod) == null) {
          HospitalServiceGrpc.getDeleteHospitalMethod = getDeleteHospitalMethod =
              io.grpc.MethodDescriptor.<com.guseinma.hospital.proto.HospitalId, com.guseinma.hospital.proto.OperationResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteHospital"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.guseinma.hospital.proto.HospitalId.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.guseinma.hospital.proto.OperationResponse.getDefaultInstance()))
              .setSchemaDescriptor(new HospitalServiceMethodDescriptorSupplier("DeleteHospital"))
              .build();
        }
      }
    }
    return getDeleteHospitalMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.guseinma.hospital.proto.Patient,
      com.guseinma.hospital.proto.OperationResponse> getCreatePatientMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreatePatient",
      requestType = com.guseinma.hospital.proto.Patient.class,
      responseType = com.guseinma.hospital.proto.OperationResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.guseinma.hospital.proto.Patient,
      com.guseinma.hospital.proto.OperationResponse> getCreatePatientMethod() {
    io.grpc.MethodDescriptor<com.guseinma.hospital.proto.Patient, com.guseinma.hospital.proto.OperationResponse> getCreatePatientMethod;
    if ((getCreatePatientMethod = HospitalServiceGrpc.getCreatePatientMethod) == null) {
      synchronized (HospitalServiceGrpc.class) {
        if ((getCreatePatientMethod = HospitalServiceGrpc.getCreatePatientMethod) == null) {
          HospitalServiceGrpc.getCreatePatientMethod = getCreatePatientMethod =
              io.grpc.MethodDescriptor.<com.guseinma.hospital.proto.Patient, com.guseinma.hospital.proto.OperationResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreatePatient"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.guseinma.hospital.proto.Patient.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.guseinma.hospital.proto.OperationResponse.getDefaultInstance()))
              .setSchemaDescriptor(new HospitalServiceMethodDescriptorSupplier("CreatePatient"))
              .build();
        }
      }
    }
    return getCreatePatientMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.guseinma.hospital.proto.Patient,
      com.guseinma.hospital.proto.OperationResponse> getUpdatePatientMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdatePatient",
      requestType = com.guseinma.hospital.proto.Patient.class,
      responseType = com.guseinma.hospital.proto.OperationResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.guseinma.hospital.proto.Patient,
      com.guseinma.hospital.proto.OperationResponse> getUpdatePatientMethod() {
    io.grpc.MethodDescriptor<com.guseinma.hospital.proto.Patient, com.guseinma.hospital.proto.OperationResponse> getUpdatePatientMethod;
    if ((getUpdatePatientMethod = HospitalServiceGrpc.getUpdatePatientMethod) == null) {
      synchronized (HospitalServiceGrpc.class) {
        if ((getUpdatePatientMethod = HospitalServiceGrpc.getUpdatePatientMethod) == null) {
          HospitalServiceGrpc.getUpdatePatientMethod = getUpdatePatientMethod =
              io.grpc.MethodDescriptor.<com.guseinma.hospital.proto.Patient, com.guseinma.hospital.proto.OperationResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdatePatient"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.guseinma.hospital.proto.Patient.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.guseinma.hospital.proto.OperationResponse.getDefaultInstance()))
              .setSchemaDescriptor(new HospitalServiceMethodDescriptorSupplier("UpdatePatient"))
              .build();
        }
      }
    }
    return getUpdatePatientMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.guseinma.hospital.proto.PatientId,
      com.guseinma.hospital.proto.OperationResponse> getDeletePatientMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeletePatient",
      requestType = com.guseinma.hospital.proto.PatientId.class,
      responseType = com.guseinma.hospital.proto.OperationResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.guseinma.hospital.proto.PatientId,
      com.guseinma.hospital.proto.OperationResponse> getDeletePatientMethod() {
    io.grpc.MethodDescriptor<com.guseinma.hospital.proto.PatientId, com.guseinma.hospital.proto.OperationResponse> getDeletePatientMethod;
    if ((getDeletePatientMethod = HospitalServiceGrpc.getDeletePatientMethod) == null) {
      synchronized (HospitalServiceGrpc.class) {
        if ((getDeletePatientMethod = HospitalServiceGrpc.getDeletePatientMethod) == null) {
          HospitalServiceGrpc.getDeletePatientMethod = getDeletePatientMethod =
              io.grpc.MethodDescriptor.<com.guseinma.hospital.proto.PatientId, com.guseinma.hospital.proto.OperationResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeletePatient"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.guseinma.hospital.proto.PatientId.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.guseinma.hospital.proto.OperationResponse.getDefaultInstance()))
              .setSchemaDescriptor(new HospitalServiceMethodDescriptorSupplier("DeletePatient"))
              .build();
        }
      }
    }
    return getDeletePatientMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.guseinma.hospital.proto.RegisterRequest,
      com.guseinma.hospital.proto.OperationResponse> getRegisterPatientMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RegisterPatient",
      requestType = com.guseinma.hospital.proto.RegisterRequest.class,
      responseType = com.guseinma.hospital.proto.OperationResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.guseinma.hospital.proto.RegisterRequest,
      com.guseinma.hospital.proto.OperationResponse> getRegisterPatientMethod() {
    io.grpc.MethodDescriptor<com.guseinma.hospital.proto.RegisterRequest, com.guseinma.hospital.proto.OperationResponse> getRegisterPatientMethod;
    if ((getRegisterPatientMethod = HospitalServiceGrpc.getRegisterPatientMethod) == null) {
      synchronized (HospitalServiceGrpc.class) {
        if ((getRegisterPatientMethod = HospitalServiceGrpc.getRegisterPatientMethod) == null) {
          HospitalServiceGrpc.getRegisterPatientMethod = getRegisterPatientMethod =
              io.grpc.MethodDescriptor.<com.guseinma.hospital.proto.RegisterRequest, com.guseinma.hospital.proto.OperationResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RegisterPatient"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.guseinma.hospital.proto.RegisterRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.guseinma.hospital.proto.OperationResponse.getDefaultInstance()))
              .setSchemaDescriptor(new HospitalServiceMethodDescriptorSupplier("RegisterPatient"))
              .build();
        }
      }
    }
    return getRegisterPatientMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.guseinma.hospital.proto.HospitalId,
      com.guseinma.hospital.proto.PatientList> getReadPatientsOfHospitalMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ReadPatientsOfHospital",
      requestType = com.guseinma.hospital.proto.HospitalId.class,
      responseType = com.guseinma.hospital.proto.PatientList.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.guseinma.hospital.proto.HospitalId,
      com.guseinma.hospital.proto.PatientList> getReadPatientsOfHospitalMethod() {
    io.grpc.MethodDescriptor<com.guseinma.hospital.proto.HospitalId, com.guseinma.hospital.proto.PatientList> getReadPatientsOfHospitalMethod;
    if ((getReadPatientsOfHospitalMethod = HospitalServiceGrpc.getReadPatientsOfHospitalMethod) == null) {
      synchronized (HospitalServiceGrpc.class) {
        if ((getReadPatientsOfHospitalMethod = HospitalServiceGrpc.getReadPatientsOfHospitalMethod) == null) {
          HospitalServiceGrpc.getReadPatientsOfHospitalMethod = getReadPatientsOfHospitalMethod =
              io.grpc.MethodDescriptor.<com.guseinma.hospital.proto.HospitalId, com.guseinma.hospital.proto.PatientList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ReadPatientsOfHospital"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.guseinma.hospital.proto.HospitalId.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.guseinma.hospital.proto.PatientList.getDefaultInstance()))
              .setSchemaDescriptor(new HospitalServiceMethodDescriptorSupplier("ReadPatientsOfHospital"))
              .build();
        }
      }
    }
    return getReadPatientsOfHospitalMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.guseinma.hospital.proto.PatientId,
      com.guseinma.hospital.proto.HospitalList> getReadHospitalsOfPatientMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ReadHospitalsOfPatient",
      requestType = com.guseinma.hospital.proto.PatientId.class,
      responseType = com.guseinma.hospital.proto.HospitalList.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.guseinma.hospital.proto.PatientId,
      com.guseinma.hospital.proto.HospitalList> getReadHospitalsOfPatientMethod() {
    io.grpc.MethodDescriptor<com.guseinma.hospital.proto.PatientId, com.guseinma.hospital.proto.HospitalList> getReadHospitalsOfPatientMethod;
    if ((getReadHospitalsOfPatientMethod = HospitalServiceGrpc.getReadHospitalsOfPatientMethod) == null) {
      synchronized (HospitalServiceGrpc.class) {
        if ((getReadHospitalsOfPatientMethod = HospitalServiceGrpc.getReadHospitalsOfPatientMethod) == null) {
          HospitalServiceGrpc.getReadHospitalsOfPatientMethod = getReadHospitalsOfPatientMethod =
              io.grpc.MethodDescriptor.<com.guseinma.hospital.proto.PatientId, com.guseinma.hospital.proto.HospitalList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ReadHospitalsOfPatient"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.guseinma.hospital.proto.PatientId.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.guseinma.hospital.proto.HospitalList.getDefaultInstance()))
              .setSchemaDescriptor(new HospitalServiceMethodDescriptorSupplier("ReadHospitalsOfPatient"))
              .build();
        }
      }
    }
    return getReadHospitalsOfPatientMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static HospitalServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<HospitalServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<HospitalServiceStub>() {
        @java.lang.Override
        public HospitalServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new HospitalServiceStub(channel, callOptions);
        }
      };
    return HospitalServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static HospitalServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<HospitalServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<HospitalServiceBlockingStub>() {
        @java.lang.Override
        public HospitalServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new HospitalServiceBlockingStub(channel, callOptions);
        }
      };
    return HospitalServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static HospitalServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<HospitalServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<HospitalServiceFutureStub>() {
        @java.lang.Override
        public HospitalServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new HospitalServiceFutureStub(channel, callOptions);
        }
      };
    return HospitalServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void createHospital(com.guseinma.hospital.proto.Hospital request,
        io.grpc.stub.StreamObserver<com.guseinma.hospital.proto.OperationResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateHospitalMethod(), responseObserver);
    }

    /**
     */
    default void updateHospital(com.guseinma.hospital.proto.Hospital request,
        io.grpc.stub.StreamObserver<com.guseinma.hospital.proto.OperationResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateHospitalMethod(), responseObserver);
    }

    /**
     */
    default void deleteHospital(com.guseinma.hospital.proto.HospitalId request,
        io.grpc.stub.StreamObserver<com.guseinma.hospital.proto.OperationResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteHospitalMethod(), responseObserver);
    }

    /**
     */
    default void createPatient(com.guseinma.hospital.proto.Patient request,
        io.grpc.stub.StreamObserver<com.guseinma.hospital.proto.OperationResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreatePatientMethod(), responseObserver);
    }

    /**
     */
    default void updatePatient(com.guseinma.hospital.proto.Patient request,
        io.grpc.stub.StreamObserver<com.guseinma.hospital.proto.OperationResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdatePatientMethod(), responseObserver);
    }

    /**
     */
    default void deletePatient(com.guseinma.hospital.proto.PatientId request,
        io.grpc.stub.StreamObserver<com.guseinma.hospital.proto.OperationResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeletePatientMethod(), responseObserver);
    }

    /**
     */
    default void registerPatient(com.guseinma.hospital.proto.RegisterRequest request,
        io.grpc.stub.StreamObserver<com.guseinma.hospital.proto.OperationResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRegisterPatientMethod(), responseObserver);
    }

    /**
     */
    default void readPatientsOfHospital(com.guseinma.hospital.proto.HospitalId request,
        io.grpc.stub.StreamObserver<com.guseinma.hospital.proto.PatientList> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getReadPatientsOfHospitalMethod(), responseObserver);
    }

    /**
     */
    default void readHospitalsOfPatient(com.guseinma.hospital.proto.PatientId request,
        io.grpc.stub.StreamObserver<com.guseinma.hospital.proto.HospitalList> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getReadHospitalsOfPatientMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service HospitalService.
   */
  public static abstract class HospitalServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return HospitalServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service HospitalService.
   */
  public static final class HospitalServiceStub
      extends io.grpc.stub.AbstractAsyncStub<HospitalServiceStub> {
    private HospitalServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HospitalServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new HospitalServiceStub(channel, callOptions);
    }

    /**
     */
    public void createHospital(com.guseinma.hospital.proto.Hospital request,
        io.grpc.stub.StreamObserver<com.guseinma.hospital.proto.OperationResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateHospitalMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateHospital(com.guseinma.hospital.proto.Hospital request,
        io.grpc.stub.StreamObserver<com.guseinma.hospital.proto.OperationResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateHospitalMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteHospital(com.guseinma.hospital.proto.HospitalId request,
        io.grpc.stub.StreamObserver<com.guseinma.hospital.proto.OperationResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteHospitalMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void createPatient(com.guseinma.hospital.proto.Patient request,
        io.grpc.stub.StreamObserver<com.guseinma.hospital.proto.OperationResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreatePatientMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updatePatient(com.guseinma.hospital.proto.Patient request,
        io.grpc.stub.StreamObserver<com.guseinma.hospital.proto.OperationResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdatePatientMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deletePatient(com.guseinma.hospital.proto.PatientId request,
        io.grpc.stub.StreamObserver<com.guseinma.hospital.proto.OperationResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeletePatientMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void registerPatient(com.guseinma.hospital.proto.RegisterRequest request,
        io.grpc.stub.StreamObserver<com.guseinma.hospital.proto.OperationResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRegisterPatientMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readPatientsOfHospital(com.guseinma.hospital.proto.HospitalId request,
        io.grpc.stub.StreamObserver<com.guseinma.hospital.proto.PatientList> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getReadPatientsOfHospitalMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readHospitalsOfPatient(com.guseinma.hospital.proto.PatientId request,
        io.grpc.stub.StreamObserver<com.guseinma.hospital.proto.HospitalList> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getReadHospitalsOfPatientMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service HospitalService.
   */
  public static final class HospitalServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<HospitalServiceBlockingStub> {
    private HospitalServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HospitalServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new HospitalServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.guseinma.hospital.proto.OperationResponse createHospital(com.guseinma.hospital.proto.Hospital request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateHospitalMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.guseinma.hospital.proto.OperationResponse updateHospital(com.guseinma.hospital.proto.Hospital request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateHospitalMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.guseinma.hospital.proto.OperationResponse deleteHospital(com.guseinma.hospital.proto.HospitalId request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteHospitalMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.guseinma.hospital.proto.OperationResponse createPatient(com.guseinma.hospital.proto.Patient request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreatePatientMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.guseinma.hospital.proto.OperationResponse updatePatient(com.guseinma.hospital.proto.Patient request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdatePatientMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.guseinma.hospital.proto.OperationResponse deletePatient(com.guseinma.hospital.proto.PatientId request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeletePatientMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.guseinma.hospital.proto.OperationResponse registerPatient(com.guseinma.hospital.proto.RegisterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRegisterPatientMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.guseinma.hospital.proto.PatientList readPatientsOfHospital(com.guseinma.hospital.proto.HospitalId request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getReadPatientsOfHospitalMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.guseinma.hospital.proto.HospitalList readHospitalsOfPatient(com.guseinma.hospital.proto.PatientId request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getReadHospitalsOfPatientMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service HospitalService.
   */
  public static final class HospitalServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<HospitalServiceFutureStub> {
    private HospitalServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HospitalServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new HospitalServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.guseinma.hospital.proto.OperationResponse> createHospital(
        com.guseinma.hospital.proto.Hospital request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateHospitalMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.guseinma.hospital.proto.OperationResponse> updateHospital(
        com.guseinma.hospital.proto.Hospital request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateHospitalMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.guseinma.hospital.proto.OperationResponse> deleteHospital(
        com.guseinma.hospital.proto.HospitalId request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteHospitalMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.guseinma.hospital.proto.OperationResponse> createPatient(
        com.guseinma.hospital.proto.Patient request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreatePatientMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.guseinma.hospital.proto.OperationResponse> updatePatient(
        com.guseinma.hospital.proto.Patient request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdatePatientMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.guseinma.hospital.proto.OperationResponse> deletePatient(
        com.guseinma.hospital.proto.PatientId request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeletePatientMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.guseinma.hospital.proto.OperationResponse> registerPatient(
        com.guseinma.hospital.proto.RegisterRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRegisterPatientMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.guseinma.hospital.proto.PatientList> readPatientsOfHospital(
        com.guseinma.hospital.proto.HospitalId request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getReadPatientsOfHospitalMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.guseinma.hospital.proto.HospitalList> readHospitalsOfPatient(
        com.guseinma.hospital.proto.PatientId request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getReadHospitalsOfPatientMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_HOSPITAL = 0;
  private static final int METHODID_UPDATE_HOSPITAL = 1;
  private static final int METHODID_DELETE_HOSPITAL = 2;
  private static final int METHODID_CREATE_PATIENT = 3;
  private static final int METHODID_UPDATE_PATIENT = 4;
  private static final int METHODID_DELETE_PATIENT = 5;
  private static final int METHODID_REGISTER_PATIENT = 6;
  private static final int METHODID_READ_PATIENTS_OF_HOSPITAL = 7;
  private static final int METHODID_READ_HOSPITALS_OF_PATIENT = 8;

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
        case METHODID_CREATE_HOSPITAL:
          serviceImpl.createHospital((com.guseinma.hospital.proto.Hospital) request,
              (io.grpc.stub.StreamObserver<com.guseinma.hospital.proto.OperationResponse>) responseObserver);
          break;
        case METHODID_UPDATE_HOSPITAL:
          serviceImpl.updateHospital((com.guseinma.hospital.proto.Hospital) request,
              (io.grpc.stub.StreamObserver<com.guseinma.hospital.proto.OperationResponse>) responseObserver);
          break;
        case METHODID_DELETE_HOSPITAL:
          serviceImpl.deleteHospital((com.guseinma.hospital.proto.HospitalId) request,
              (io.grpc.stub.StreamObserver<com.guseinma.hospital.proto.OperationResponse>) responseObserver);
          break;
        case METHODID_CREATE_PATIENT:
          serviceImpl.createPatient((com.guseinma.hospital.proto.Patient) request,
              (io.grpc.stub.StreamObserver<com.guseinma.hospital.proto.OperationResponse>) responseObserver);
          break;
        case METHODID_UPDATE_PATIENT:
          serviceImpl.updatePatient((com.guseinma.hospital.proto.Patient) request,
              (io.grpc.stub.StreamObserver<com.guseinma.hospital.proto.OperationResponse>) responseObserver);
          break;
        case METHODID_DELETE_PATIENT:
          serviceImpl.deletePatient((com.guseinma.hospital.proto.PatientId) request,
              (io.grpc.stub.StreamObserver<com.guseinma.hospital.proto.OperationResponse>) responseObserver);
          break;
        case METHODID_REGISTER_PATIENT:
          serviceImpl.registerPatient((com.guseinma.hospital.proto.RegisterRequest) request,
              (io.grpc.stub.StreamObserver<com.guseinma.hospital.proto.OperationResponse>) responseObserver);
          break;
        case METHODID_READ_PATIENTS_OF_HOSPITAL:
          serviceImpl.readPatientsOfHospital((com.guseinma.hospital.proto.HospitalId) request,
              (io.grpc.stub.StreamObserver<com.guseinma.hospital.proto.PatientList>) responseObserver);
          break;
        case METHODID_READ_HOSPITALS_OF_PATIENT:
          serviceImpl.readHospitalsOfPatient((com.guseinma.hospital.proto.PatientId) request,
              (io.grpc.stub.StreamObserver<com.guseinma.hospital.proto.HospitalList>) responseObserver);
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
          getCreateHospitalMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.guseinma.hospital.proto.Hospital,
              com.guseinma.hospital.proto.OperationResponse>(
                service, METHODID_CREATE_HOSPITAL)))
        .addMethod(
          getUpdateHospitalMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.guseinma.hospital.proto.Hospital,
              com.guseinma.hospital.proto.OperationResponse>(
                service, METHODID_UPDATE_HOSPITAL)))
        .addMethod(
          getDeleteHospitalMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.guseinma.hospital.proto.HospitalId,
              com.guseinma.hospital.proto.OperationResponse>(
                service, METHODID_DELETE_HOSPITAL)))
        .addMethod(
          getCreatePatientMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.guseinma.hospital.proto.Patient,
              com.guseinma.hospital.proto.OperationResponse>(
                service, METHODID_CREATE_PATIENT)))
        .addMethod(
          getUpdatePatientMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.guseinma.hospital.proto.Patient,
              com.guseinma.hospital.proto.OperationResponse>(
                service, METHODID_UPDATE_PATIENT)))
        .addMethod(
          getDeletePatientMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.guseinma.hospital.proto.PatientId,
              com.guseinma.hospital.proto.OperationResponse>(
                service, METHODID_DELETE_PATIENT)))
        .addMethod(
          getRegisterPatientMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.guseinma.hospital.proto.RegisterRequest,
              com.guseinma.hospital.proto.OperationResponse>(
                service, METHODID_REGISTER_PATIENT)))
        .addMethod(
          getReadPatientsOfHospitalMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.guseinma.hospital.proto.HospitalId,
              com.guseinma.hospital.proto.PatientList>(
                service, METHODID_READ_PATIENTS_OF_HOSPITAL)))
        .addMethod(
          getReadHospitalsOfPatientMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.guseinma.hospital.proto.PatientId,
              com.guseinma.hospital.proto.HospitalList>(
                service, METHODID_READ_HOSPITALS_OF_PATIENT)))
        .build();
  }

  private static abstract class HospitalServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    HospitalServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.guseinma.hospital.proto.HospitalServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("HospitalService");
    }
  }

  private static final class HospitalServiceFileDescriptorSupplier
      extends HospitalServiceBaseDescriptorSupplier {
    HospitalServiceFileDescriptorSupplier() {}
  }

  private static final class HospitalServiceMethodDescriptorSupplier
      extends HospitalServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    HospitalServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (HospitalServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new HospitalServiceFileDescriptorSupplier())
              .addMethod(getCreateHospitalMethod())
              .addMethod(getUpdateHospitalMethod())
              .addMethod(getDeleteHospitalMethod())
              .addMethod(getCreatePatientMethod())
              .addMethod(getUpdatePatientMethod())
              .addMethod(getDeletePatientMethod())
              .addMethod(getRegisterPatientMethod())
              .addMethod(getReadPatientsOfHospitalMethod())
              .addMethod(getReadHospitalsOfPatientMethod())
              .build();
        }
      }
    }
    return result;
  }
}
