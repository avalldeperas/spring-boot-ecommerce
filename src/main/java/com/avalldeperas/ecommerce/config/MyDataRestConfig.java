package com.avalldeperas.ecommerce.config;

import com.avalldeperas.ecommerce.dao.ProductRepository;
import com.avalldeperas.ecommerce.entity.Product;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;

/**
 * Disable HTTP methods: PUT, POST, DELETE for now.
 */
@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        HttpMethod[] unsupportedMethods = { HttpMethod.PUT, HttpMethod.POST, HttpMethod.DELETE };

        config.getExposureConfiguration()
            .forDomainType(Product.class) // applying only for Product Repository
            .withItemExposure((metadata, httpMethods) -> httpMethods.disable(unsupportedMethods)) //for given product item
            .withCollectionExposure(((metadata, httpMethods) -> httpMethods.disable(unsupportedMethods))); // for given product list

        config.getExposureConfiguration()
                .forDomainType(ProductRepository.class) // applying only for Product Repository
                .withItemExposure((metadata, httpMethods) -> httpMethods.disable(unsupportedMethods)) //for given product item
                .withCollectionExposure(((metadata, httpMethods) -> httpMethods.disable(unsupportedMethods))); // for given product list
    }
}
