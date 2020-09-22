package com.noyo0123.backoffice.controller.ifs;

import com.noyo0123.backoffice.model.network.Header;
import com.noyo0123.backoffice.model.network.request.UserApiRequest;
import com.noyo0123.backoffice.model.network.response.UserApiResponse;

public interface CrudInterface<Req, Res> {

//    Header<UserApiResponse> create(UserApiRequest request); 제네릭으로 쓰면 CrudInterface를 더 범용적으로 쓸 수 있잖아요.

    Header<Res> create(Header<Req> req);

    Header<Res> read(Long id);

    Header<Res> update(Header<Req> req);

    Header delete(Long id);
}
