package com.noyo0123.backoffice.controller.api;

import com.noyo0123.backoffice.controller.ifs.CrudInterface;
import com.noyo0123.backoffice.model.network.Header;
import com.noyo0123.backoffice.model.network.request.OrderGroupApiRequest;
import com.noyo0123.backoffice.model.network.response.OrderGroupApiResponse;
import com.noyo0123.backoffice.service.OrderGroupApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orderGroup")
public class OrderGroupApiController implements CrudInterface<OrderGroupApiRequest, OrderGroupApiResponse> {

    @Autowired
    OrderGroupApiService orderGroupApiService;

    @Override
    @PostMapping("")
    public Header<OrderGroupApiResponse> create(@RequestBody Header<OrderGroupApiRequest> req) {
        return this.orderGroupApiService.create(req);
    }

    @Override
    @GetMapping("{id}")
    public Header<OrderGroupApiResponse> read(@PathVariable Long id) {
        return this.orderGroupApiService.read(id);
    }

    @Override
    @PutMapping("")
    public Header<OrderGroupApiResponse> update(@RequestBody Header<OrderGroupApiRequest> req) {
        return this.orderGroupApiService.update(req);
    }

    @Override
    @DeleteMapping("")
    public Header delete(@PathVariable Long id) {
        return null;
    }
}
