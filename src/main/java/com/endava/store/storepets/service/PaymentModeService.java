package com.endava.store.storepets.service;

import com.endava.store.storepets.constants.Constants;
import com.endava.store.storepets.dto.PaymentModeDto;
import com.endava.store.storepets.model.PaymentModeModel;
import com.endava.store.storepets.repository.PaymentModeRepository;
import com.endava.store.storepets.utilities.PaymentModeUtilities;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PaymentModeService extends GenericService {

    @Autowired
    private PaymentModeRepository paymentModeRepository;

    public List<PaymentModeDto> getPaymentModes() {
        List<PaymentModeModel> listModel = paymentModeRepository.findAll();
        return PaymentModeUtilities.convertListModelToListDto(listModel);
    }

    public PaymentModeDto getPaymentMode(UUID id) {
        PaymentModeModel obj = paymentModeRepository.getById(id);
        return PaymentModeUtilities.convertModelToPaymentModeDto(obj);
    }

    public List<PaymentModeDto> savePaymentModes(List<PaymentModeDto> listDto) {
        List<PaymentModeModel> listModel = paymentModeRepository.saveAll(
                PaymentModeUtilities.convertListDtoToListModel(listDto));
        return PaymentModeUtilities.convertListModelToListDto(listModel);
    }

    public PaymentModeDto updatePaymentMode(PaymentModeDto dto) throws NotFoundException {
        exist(paymentModeRepository, dto.getId(), Constants.PAYMENT_MODE);
        PaymentModeModel model = PaymentModeUtilities.convertDtoToPaymentModeModel(dto);
        return PaymentModeUtilities.convertModelToPaymentModeDto(paymentModeRepository.save(model));
    }

    public void deletePaymentMode(UUID id) throws NotFoundException {
        delete(paymentModeRepository,id,Constants.PAYMENT_MODE);
    }
}
