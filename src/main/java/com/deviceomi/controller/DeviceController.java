package com.deviceomi.controller;

import com.deviceomi.payload.request.DeviceRequest;
import com.deviceomi.payload.request.DeviceTestRequest;
import com.deviceomi.payload.request.DeviceWorkRequest;
import com.deviceomi.service.DeviceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
@Api(value = "Device APIs")
public class DeviceController {

    @Autowired
    DeviceService deviceService;

//    @ApiOperation(value = "Tạo thiết bị làm việc")
//    @PostMapping("/device")
//    public ResponseEntity<?> createDeviceWork(@ApiParam(value = "Tạo thiết bị làm việc") @Valid @RequestBody DeviceWorkRequest deviceWorkRequest) {
//        deviceService.saveOrUpdate(deviceWorkRequest);
//        return new ResponseEntity<>(deviceWorkRequest, HttpStatus.OK);
//    }
//
//    @ApiOperation(value = "Cập nhập thiết bị làm việc")
//    @PutMapping("/device")
//    public ResponseEntity<?> updateDeviceWork(@ApiParam(value = "Cập nhập thiết bị làm việc") @Valid @RequestBody DeviceWorkRequest deviceWorkRequest) {
//        deviceService.saveOrUpdate(deviceWorkRequest);
//        return new ResponseEntity<>(deviceWorkRequest, HttpStatus.OK);
//    }
//
//    @ApiOperation(value = "Hiển thị tất cả thiết bị làm việc")
//    @GetMapping("/device")
//    public ResponseEntity<?> showDeviceWork(@ApiParam(value = "Hiển thị tất cả thiết bị làm việc") @Valid @RequestBody DeviceWorkRequest deviceWorkRequest) {
//        deviceService.saveOrUpdate(deviceWorkRequest);
//        return new ResponseEntity<>(deviceWorkRequest, HttpStatus.OK);
//    }
//
//    @ApiOperation(value = "Tạo thiết bị test")
//    @PostMapping("/testNew")
//    public ResponseEntity<?> createDeviceTest(@ApiParam(value = "Tạo thiết bị test") @Valid @RequestBody DeviceTestRequest deviceTestRequest) {
//        deviceService.saveOrUpdate(deviceTestRequest);
//        return new ResponseEntity<>(deviceTestRequest, HttpStatus.OK);
//    }
//
//    @ApiOperation(value = "Cập nhập thiết bị làm việc")
//    @PutMapping("/testUpdate")
//    public ResponseEntity<?> updateDeviceTest(@ApiParam(value = "Cập nhập thiết bị test") @Valid @RequestBody DeviceTestRequest deviceTestRequest) {
//        deviceService.saveOrUpdate(deviceTestRequest);
//        return new ResponseEntity<>(deviceTestRequest, HttpStatus.OK);
//    }

    @ApiOperation(value = "Tạo thiết bị")
    @PostMapping("/device")
    public ResponseEntity<?> createDeviceWork(@ApiParam(value = "Tạo thiết bị") @Valid @RequestBody DeviceRequest deviceRequest) {
        if (deviceService.save(deviceRequest) != null)
            return new ResponseEntity<>(deviceRequest, HttpStatus.OK);
        return new ResponseEntity<>(deviceRequest, HttpStatus.BAD_REQUEST);
    }

    @ApiOperation(value = "Cập nhập thiết bị")
    @PutMapping("/device")
    public ResponseEntity<?> updateDeviceWork(@ApiParam(value = "Cập nhập thiết bị") @Valid @RequestBody DeviceRequest deviceRequest) {
        if (deviceService.save(deviceRequest) != null)
            return new ResponseEntity<>(deviceRequest, HttpStatus.OK);
        return new ResponseEntity<>(deviceRequest, HttpStatus.BAD_REQUEST);
    }

    @ApiOperation(value = "Xóa thiết bị")
    @DeleteMapping("/device/{id}")
    public void deleteDevice(@PathVariable Long id) {
        if (id == null)
            return;
        deviceService.delete(id);
    }

    /**
     * tuan
     * show all device database
     * */
    @ApiOperation(value = "Hiển thị tất cả thiết bị cho mượn trả và sửa chưa")
    @GetMapping("/device/all")
    public ResponseEntity<?> showDeviceAll() {
        return new ResponseEntity<>(deviceService.getAllDevice(), HttpStatus.OK);
    }

    @ApiOperation(value = "Hiển thị tất cả thiết bị")
    @GetMapping("/devices")
    public ResponseEntity<?> showDevices() {
        return new ResponseEntity<>(deviceService.getDevices(), HttpStatus.OK);
    }

    @ApiOperation(value = "Lấy thiết bị theo ID")
    @GetMapping("/device/{id}")
    public ResponseEntity<?> showDeviceById(@ApiParam(value = "Lấy thiết bị theo ID")@PathVariable Long id) {
        return new ResponseEntity<>(deviceService.getDeviceById(id), HttpStatus.OK);
    }
}