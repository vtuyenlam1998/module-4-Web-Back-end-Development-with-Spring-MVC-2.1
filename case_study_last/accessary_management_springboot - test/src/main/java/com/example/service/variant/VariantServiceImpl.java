package com.example.service.variant;

import com.example.model.Product;
import com.example.model.Variant;
import com.example.repository.VariantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VariantServiceImpl implements VariantService {
    @Autowired
    private VariantRepository variantRepository;

    @Override
    public Iterable<Variant> findAll() {
        return variantRepository.findAllByIsActiveTrue();
    }

    @Override
    public Optional<Variant> findById(Long id) {
        return variantRepository.findByIdAndIsActiveTrue(id);
    }

    @Override
    public void save(Variant variant) {
        variantRepository.save(variant);
    }

    @Override
    public void softDelete(Long id) {
        variantRepository.updateByIsActiveFalse(id);
    }
}
