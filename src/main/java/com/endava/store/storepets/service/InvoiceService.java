package com.endava.store.storepets.service;

import com.endava.store.storepets.constants.Constants;
import com.endava.store.storepets.dto.InvoiceDto;
import com.endava.store.storepets.model.InvoiceModel;
import com.endava.store.storepets.repository.InvoiceRepository;
import com.endava.store.storepets.utilities.InvoiceUtilities;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class InvoiceService extends GenericService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    public List<InvoiceDto> getInvoices() {
        List<InvoiceModel> listModel = invoiceRepository.findAll();
        return InvoiceUtilities.convertListModelToListDto(listModel);
    }

    public InvoiceDto getInvoice(UUID id) {
        InvoiceModel model = invoiceRepository.getById(id);
        return InvoiceUtilities.convertModelToInvoicesDto(model);
    }

    public List<InvoiceDto> saveInvoices(List<InvoiceDto> listDto){
        List<InvoiceModel> listModel = invoiceRepository.saveAll(InvoiceUtilities.convertListDtoToListModel(listDto));
        return InvoiceUtilities.convertListModelToListDto(listModel);
    }

    public InvoiceDto updateInvoices(InvoiceDto dto) throws NotFoundException {
        exist(invoiceRepository,dto.getId(),Constants.INVOICE);
        InvoiceModel model = InvoiceUtilities.convertDtoToInvoicesModel(dto);
        return InvoiceUtilities.convertModelToInvoicesDto(invoiceRepository.save(model));
    }

    public void deleteInvoice(UUID id) throws NotFoundException {
        delete(invoiceRepository,id,Constants.INVOICE);
    }
}
