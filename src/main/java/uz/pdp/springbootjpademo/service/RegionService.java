package uz.pdp.springbootjpademo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.springbootjpademo.entity.Region;
import uz.pdp.springbootjpademo.payload.ApiResponse;
import uz.pdp.springbootjpademo.payload.RegionDto;
import uz.pdp.springbootjpademo.repository.RegionRepository;

@Service
public class RegionService {
    @Autowired
    private RegionRepository regionRepository;

    public ApiResponse saveRegion(RegionDto regionDto){


        try {
            Region region=new Region();
            if (regionDto.getId()!=null){
                region=regionRepository.findById(regionDto.getId()).orElseThrow(() -> new IllegalArgumentException("Student not found"));
            }

            region.setName(regionDto.getName());
            regionRepository.save(region);
            return new ApiResponse(regionDto.getId()==null?"Saved":"Edited",true);
        } catch (Exception e){
            return new ApiResponse("Error in saving. . . ",false);
        }
    }

    public ApiResponse deleteRegion(Integer id){
        try {
            regionRepository.deleteById(id);
            return new ApiResponse("Deleted",true);
        }
        catch (Exception e){
            return new ApiResponse("Error",false);
        }
    }
}
