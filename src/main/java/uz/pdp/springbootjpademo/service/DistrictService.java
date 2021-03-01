package uz.pdp.springbootjpademo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.springbootjpademo.entity.District;
import uz.pdp.springbootjpademo.entity.Region;
import uz.pdp.springbootjpademo.payload.ApiResponse;
import uz.pdp.springbootjpademo.payload.DistrictDto;
import uz.pdp.springbootjpademo.payload.RegionDto;
import uz.pdp.springbootjpademo.repository.DistrictRepository;
import uz.pdp.springbootjpademo.repository.RegionRepository;

@Service
public class DistrictService {
    @Autowired
    private DistrictRepository districtRepository;

    @Autowired
    private RegionRepository regionRepository;

    public ApiResponse saveDistrict(DistrictDto districtDto){


        try {
            District district=new District();
            if (districtDto.getId()!=null){
                district=districtRepository.findById(districtDto.getId()).orElseThrow(() -> new IllegalArgumentException("District not found"));
            }
            if (districtDto.getRegionId()!=null){
                district.setRegion(regionRepository.findById(districtDto.getRegionId()).orElseThrow(() -> new IllegalArgumentException("Region not found")));
            }
            district.setName(districtDto.getName());
            districtRepository.save(district);
            return new ApiResponse(districtDto.getId()==null?"Saved":"Edited",true);
        } catch (Exception e){
            return new ApiResponse("Error in saving. . . ",false);
        }
    }

    public ApiResponse deleteDistrict(Integer id){
        try {
            districtRepository.deleteById(id);
            return new ApiResponse("Deleted",true);
        }
        catch (Exception e){
            return new ApiResponse("Error",false);
        }
    }
}
