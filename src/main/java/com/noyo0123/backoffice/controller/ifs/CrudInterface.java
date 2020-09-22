package com.noyo0123.backoffice.controller.ifs;

import com.noyo0123.backoffice.model.network.Header;

public interface CrudInterface {

    Header create();

    Header read(Long id);

    Header update();

    Header delete(Long id);
}
