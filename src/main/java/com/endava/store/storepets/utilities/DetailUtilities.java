package com.endava.store.storepets.utilities;

import com.endava.store.storepets.dto.DetailDto;
import com.endava.store.storepets.model.DetailModel;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DetailUtilities {

    public static DetailDto convertModelToDetailsDto(DetailModel model) {
        return new DetailDto(model.getId(), model.getInvoice(), model.getProduct(), model.getAmount(),model.getValue());
    }

    public static DetailModel convertDtoToDetailsModel(DetailDto dto) {
        return new DetailModel(dto.getId(), dto.getInvoice(), dto.getProduct(), dto.getAmount(), dto.getValue());
    }

    public static List<DetailDto> convertListModelToListDto(List<DetailModel> listModel) {
        return listModel.stream().map(DetailUtilities::convertModelToDetailsDto).collect(Collectors.toList());
    }

    public static List<DetailModel> convertListDtoToListModel(List<DetailDto> listDto) {
        return listDto.stream().map(DetailUtilities::convertDtoToDetailsModel).collect(Collectors.toList());
    }
}