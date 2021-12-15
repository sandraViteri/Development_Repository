package com.endava.store.storepets.service;

import com.endava.store.storepets.constants.Constants;
import com.endava.store.storepets.dto.DetailDto;
import com.endava.store.storepets.model.DetailModel;
import com.endava.store.storepets.repository.DetailRepository;
import com.endava.store.storepets.utilities.DetailUtilities;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DetailService extends GenericService {

    @Autowired
    private DetailRepository detailRepository;

    public List<DetailDto> getDetails() {
        List<DetailModel> listModel = detailRepository.findAll();
        return DetailUtilities.convertListModelToListDto(listModel);
    }

    public DetailDto getDetail(UUID id) {
        DetailModel model = detailRepository.getById(id);
        return DetailUtilities.convertModelToDetailsDto(model);
    }

    public List<DetailDto> saveDetails(List<DetailDto> listDto){
        List<DetailModel> listModel = detailRepository.saveAll(DetailUtilities.convertListDtoToListModel(listDto));
        return DetailUtilities.convertListModelToListDto(listModel);
    }

    public DetailDto updateDetails(DetailDto dto) throws NotFoundException {
        exist(detailRepository,dto.getId(),Constants.DETAIL);
        DetailModel model = DetailUtilities.convertDtoToDetailsModel(dto);
        return DetailUtilities.convertModelToDetailsDto(detailRepository.save(model));
    }

    public void deleteDetail(UUID id) throws NotFoundException {
        delete(detailRepository,id,Constants.DETAIL);
    }
}
