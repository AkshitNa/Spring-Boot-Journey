package nautiDevelopers.RestfulCRUD.Mapper;

import nautiDevelopers.RestfulCRUD.DTO.CollegeInfoDTO;
import nautiDevelopers.RestfulCRUD.Model.CollegeInfo;

public class CollegeInfoMapper {

    // Converts CollegeInfo to CollegeInfoDTO
    public static CollegeInfoDTO toDTO(CollegeInfo collegeInfo) {
        CollegeInfoDTO dto = new CollegeInfoDTO();
        dto.setCollegeName(collegeInfo.getCollegeName());
        dto.setRatings(collegeInfo.getRatings());
        dto.setCapacity(collegeInfo.getCapacity());
        return dto;
    }

    // Converts CollegeInfoDTO to CollegeInfo (if needed)
    public static CollegeInfo toEntity(CollegeInfoDTO dto) {
        CollegeInfo collegeInfo = new CollegeInfo();
        collegeInfo.setCollegeName(dto.getCollegeName());
        collegeInfo.setRatings(dto.getRatings());
        collegeInfo.setCapacity(dto.getCapacity());
        return collegeInfo;
    }
}

