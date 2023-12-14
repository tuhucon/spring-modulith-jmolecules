package com.example.springmodulithjmolecules.product.appcore.service;

import com.example.springmodulithjmolecules.common.model.Money;
import org.springframework.modulith.NamedInterface;

@NamedInterface
public interface ProductInternalAPI {

    Money getPriceOfProduct(Long productId);

}
