package com.noyo0123.backoffice.controller.api;

import com.noyo0123.backoffice.controller.ifs.CrudInterface;
import com.noyo0123.backoffice.model.network.Header;
import com.noyo0123.backoffice.model.network.request.ItemApiRequest;
import com.noyo0123.backoffice.model.network.response.ItemApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/item")
public class ItemApiController implements CrudInterface<ItemApiRequest, ItemApiResponse> {
    @Override
    @PostMapping("") // /api/item
    public Header<ItemApiResponse> create(@RequestBody Header<ItemApiRequest> req) {
        return null;
    }

    @Override
    @GetMapping("{id}") // /api/item/id
    public Header<ItemApiResponse> read(@PathVariable Long id) {
        return null;
    }

    @Override
    @PutMapping("") // /api/item
    public Header<ItemApiResponse> update(@RequestBody Header<ItemApiRequest> req) {
        return null;
    }

    @Override
    @DeleteMapping("{id}") // /api/item/id
    public Header delete(@PathVariable Long id) {
        return null;
    }
}
