package com.noyo0123.backoffice.service;

import com.noyo0123.backoffice.controller.ifs.CrudInterface;
import com.noyo0123.backoffice.model.entity.Item;
import com.noyo0123.backoffice.model.network.Header;
import com.noyo0123.backoffice.model.network.request.ItemApiRequest;
import com.noyo0123.backoffice.model.network.response.ItemApiResponse;
import com.noyo0123.backoffice.repository.ItemRepository;
import com.noyo0123.backoffice.repository.PartnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ItemApiService implements CrudInterface<ItemApiRequest, ItemApiResponse> {


    @Autowired
    private PartnerRepository partnerRepository;

    @Autowired
    private ItemRepository itemRepository;


    @Override
    public Header<ItemApiResponse> create(Header<ItemApiRequest> req) {

        ItemApiRequest itemApiRequest = req.getData();

        Item item = Item.builder()
                .status(itemApiRequest.getStatus())
                .name(itemApiRequest.getName())
                .title(itemApiRequest.getTitle())
                .content(itemApiRequest.getContent())
                .price(itemApiRequest.getPrice())
                .brandName(itemApiRequest.getBrandName())
                .registeredAt(LocalDateTime.now())
                .partner(partnerRepository.getOne(itemApiRequest.getPartnerId())).build();
        Item newItem = itemRepository.save(item);
        return response(newItem);
    }

    @Override
    public Header<ItemApiResponse> read(Long id) {
        Optional<Item> optional = itemRepository.findById(id);
        return optional.map(item -> response(item)).orElseGet(() -> Header.ERROR("상품이 없음"));
    }

    @Override
    public Header<ItemApiResponse> update(Header<ItemApiRequest> req) {
        ItemApiRequest itemApiRequest = req.getData();

        return itemRepository.findById(itemApiRequest.getId())
                .map(item -> {
                    item.setName(itemApiRequest.getName())
                            .setStatus(itemApiRequest.getStatus())
                            .setTitle(itemApiRequest.getTitle())
                            .setContent(itemApiRequest.getContent())
                            .setPrice(itemApiRequest.getPrice())
                            .setBrandName(itemApiRequest.getBrandName())
                            .setRegisteredAt(itemApiRequest.getRegisteredAt())
                            .setUnregisteredAt(itemApiRequest.getUnregisteredAt());
                    return item;
                })
                .map(item -> itemRepository.save(item)) // save시 저장된 Entity가 반환됌
                .map(item -> response(item))
                .orElseGet(()-> Header.ERROR("상품 없음"));
    }

    @Override
    public Header delete(Long id) {
        return itemRepository.findById(id)
                .map(item -> {
                    itemRepository.delete(item);
                    return Header.OK();
                })
                .orElseGet(()-> Header.ERROR("상품 없음"));
    }

    //response로 item 객체를 리턴하기 때문에 공통 메서드로 생성
    private Header<ItemApiResponse> response(Item item) {
        ItemApiResponse itemApiResponse = ItemApiResponse.builder()
                .id(item.getId())
                .status(item.getStatus())
                .name(item.getName())
                .content(item.getContent())
                .price(item.getPrice())
                .brandName(item.getBrandName())
                .registeredAt(item.getRegisteredAt())
                .unregisteredAt(item.getUnregisteredAt())
                .partnerId(item.getPartner().getId())
                .build();

        return Header.OK(itemApiResponse);
    }
}
