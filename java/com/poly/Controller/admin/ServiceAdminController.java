package com.poly.Controller.admin;


import com.poly.DTO.request.ServiceDTO;
import com.poly.DTO.response.Message;
import com.poly.Entity.Service;
import com.poly.Service.ServiceHotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/api/service")
@RequiredArgsConstructor
public class ServiceAdminController {

    private final ServiceHotelService serviceHotelService;


    @GetMapping("")
    public ResponseEntity<Message> getService() {
        return new ResponseEntity<>(Message.builder()
                .status(true)
                .message("Danh sách Service")
                .code(200)
                .data(serviceHotelService.findAll()).build(), HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Message> getServiceByID(@PathVariable Integer id) {
        return new ResponseEntity<>(Message.builder()
                .status(true)
                .message("Service" + id)
                .code(200)
                .data(serviceHotelService.findByID(id)).build(), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Message> saveService(@RequestBody ServiceDTO serviceDTO) {
        Service service = Service.builder()
                .name(serviceDTO.getName())
                .price(serviceDTO.getPrice())
                .photo(serviceDTO.getPhoto())
                .description(serviceDTO.getDescription())
                .build();
        serviceHotelService.save(service);
        return new ResponseEntity<>(Message.builder()
                .status(true)
                .message("Lưu Service thành công!")
                .code(200)
                .build(), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Message> updateService( @PathVariable Integer id ,@RequestBody ServiceDTO serviceDTO) {
        Service service = Service.builder()
                .name(serviceDTO.getName())
                .price(serviceDTO.getPrice())
                .photo(serviceDTO.getPhoto())
                .description(serviceDTO.getDescription())
                .build();
        Service update = serviceHotelService.update(service, id);
        if(update== null) {
            return new ResponseEntity<>(Message.builder()
                    .status(true)
                    .message("Cập nhật Service thất bại!")
                    .code(500)
                    .build(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(Message.builder()
                .status(true)
                .message("Lưu Service thành công!")
                .code(200)
                .build(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Message> deleteService(@PathVariable int id) {
        serviceHotelService.delete(id);
        return new ResponseEntity<>(Message.builder()
                .status(true)
                .message("Xoá Service thành công")
                .code(200)
                .build(), HttpStatus.OK);
    }

}
