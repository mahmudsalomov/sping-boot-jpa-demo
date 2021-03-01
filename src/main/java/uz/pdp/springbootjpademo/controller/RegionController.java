package uz.pdp.springbootjpademo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.springbootjpademo.payload.ApiResponse;
import uz.pdp.springbootjpademo.payload.RegionDto;
import uz.pdp.springbootjpademo.service.RegionService;

@RestController
@RequestMapping("/api/region")
public class RegionController {

    @Autowired
    private RegionService regionService;

    @PostMapping("/saveRegion")
    public HttpEntity<?> saveRegion(@RequestBody RegionDto regionDto){
        ApiResponse apiResponse=regionService.saveRegion(regionDto);
        return ResponseEntity.status(apiResponse.isSuccess()?apiResponse.getMessage().equals("Saved")?201:202:409)
                .body(apiResponse);
    }

    @DeleteMapping("/deleteRegion/{id}")
    public HttpEntity<?> deleteRegion(@PathVariable("id") Integer id){
        ApiResponse apiResponse=regionService.deleteRegion(id);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }

}
