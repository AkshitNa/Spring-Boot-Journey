package nautiDevelopers.RestfulCRUD.Service;

import nautiDevelopers.RestfulCRUD.DTO.CollegeInfoDTO;
import nautiDevelopers.RestfulCRUD.Model.CollegeInfo;
import nautiDevelopers.RestfulCRUD.Repository.CollegeInfoRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollegeInfoServiceImpl implements CollegeInfoService {

    @Autowired
    CollegeInfoRepo collegeRepo; // It has all CRUD Functions provided by Repository

    @Autowired
    private ModelMapper modelMapper; //package

    public CollegeInfoServiceImpl(CollegeInfoRepo collegeRepo){
        this.collegeRepo = collegeRepo;
    }

    public List<CollegeInfoDTO> findAllColleges() {
        List<CollegeInfo> colleges = collegeRepo.findAll();
        return colleges.stream()
                .map(college -> modelMapper.map(college, CollegeInfoDTO.class))
                .toList();
    }

/* No need of CollegeInfoMapper Class

    public List<CollegeInfoDTO> findAllColleges() {
        List<CollegeInfo> colleges = collegeRepo.findAll();
        return colleges.stream()
                .map(CollegeInfoMapper::toDTO)
                .toList();
    }
*/
}

