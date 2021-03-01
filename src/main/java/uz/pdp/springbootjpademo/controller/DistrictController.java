package uz.pdp.springbootjpademo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.springbootjpademo.payload.ApiResponse;
import uz.pdp.springbootjpademo.payload.DistrictDto;
import uz.pdp.springbootjpademo.payload.RegionDto;
import uz.pdp.springbootjpademo.service.DistrictService;
import uz.pdp.springbootjpademo.service.RegionService;

@RestController
@RequestMapping("/api/district")
public class DistrictController {

    @Autowired
    private DistrictService districtService;

    @PostMapping("/saveDistrict")
    public HttpEntity<?> saveDistrict(@RequestBody DistrictDto districtDto){
        ApiResponse apiResponse=districtService.saveDistrict(districtDto);
        return ResponseEntity.status(apiResponse.isSuccess()?apiResponse.getMessage().equals("Saved")?201:202:409)
                .body(apiResponse);
    }

    @DeleteMapping("/deleteDistrict/{id}")
    public HttpEntity<?> deleteDistrict(@PathVariable("id") Integer id){
        ApiResponse apiResponse=districtService.deleteDistrict(id);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }

}
