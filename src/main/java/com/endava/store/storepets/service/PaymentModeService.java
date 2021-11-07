package com.endava.store.storepets.service;

import com.endava.store.storepets.dto.PaymentModeDto;
import com.endava.store.storepets.model.PaymentModeModel;
import com.endava.store.storepets.repository.PaymentModeRepository;
import com.endava.store.storepets.util.PaymentModeUtilities;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PaymentModeService {

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

    public void existPaymentMode(UUID id) throws NotFoundException {
        if (!paymentModeRepository.existsById(id)) {
            throw new NotFoundException("The PaymentMode was not found!");
        }
    }

    public PaymentModeDto updatePaymentMode(PaymentModeDto dto) throws NotFoundException {
        existPaymentMode(dto.getId());
        PaymentModeModel model = PaymentModeUtilities.convertDtoToPaymentModeModel(dto);
        return PaymentModeUtilities.convertModelToPaymentModeDto(paymentModeRepository.save(model));
    }

    public void deletePaymentMode(UUID id) throws NotFoundException {
        existPaymentMode(id);
        paymentModeRepository.deleteById(id);
    }
}
