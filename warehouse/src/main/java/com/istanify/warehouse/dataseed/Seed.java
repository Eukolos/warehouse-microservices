package com.istanify.warehouse.dataseed;

import com.istanify.warehouse.client.ProductClient;
import com.istanify.warehouse.dto.ProductDto;
import com.istanify.warehouse.model.StockItem;
import com.istanify.warehouse.model.Supplier;
import com.istanify.warehouse.model.Waybill;
import com.istanify.warehouse.repository.StockItemRepository;
import com.istanify.warehouse.repository.SupplierRepository;
import com.istanify.warehouse.repository.WaybillRepository;
import org.springframework.boot.CommandLineRunner;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;

public class Seed implements CommandLineRunner {
    private final StockItemRepository stockItemRepository;
    private final SupplierRepository supplierRepository;
    private final WaybillRepository waybillRepository;
    private final ProductClient productClient;


    public Seed(StockItemRepository stockItemRepository, SupplierRepository supplierRepository, WaybillRepository waybillRepository, ProductClient productClient) {
        this.stockItemRepository = stockItemRepository;
        this.supplierRepository = supplierRepository;
        this.waybillRepository = waybillRepository;
        this.productClient = productClient;
    }

    @Override
    public void run(String... args) {
        if (stockItemRepository.count() > 0) {
            return;
        }
        List<ProductDto> products = productClient.getProductList();
        List<String> productIds = products.stream().map(ProductDto::id).toList();

        Supplier supplier1 = supplierRepository.save(new Supplier("PT. Istana", "Jl. Istana", "08123456789", 1234567890, "info@istana.com"));
        Supplier supplier2 = supplierRepository.save( new Supplier("PT. Kita", "Jl. Kita", "08123456789", 1234567890, "warehouse@kita.com"));
        Supplier supplier3 = supplierRepository.save( new Supplier("PT. Saya", "Jl. Saya", "08123456789", 1234567890, "info@saya.com"));
        Supplier supplier4 = supplierRepository.save( new Supplier("PT. Anda", "Jl. Anda", "08123456789", 1234567890, "warehouse@anda.com"));
        Supplier supplier5 = supplierRepository.save( new Supplier("PT. Kami", "Jl. Kami", "08123456789", 1234567890, "info@kami.com"));


        StockItem stockItem1 = stockItemRepository.save(new StockItem(new BigDecimal(280), new BigDecimal(360), LocalDate.now(), 100, "A1",  productIds.get(new Random().nextInt(productIds.size()))));
        StockItem stockItem2 = stockItemRepository.save(new StockItem(new BigDecimal(50), new BigDecimal(200), LocalDate.now(), 100, "A2",  productIds.get(new Random().nextInt(productIds.size()))));
        StockItem stockItem3 = stockItemRepository.save(new StockItem(new BigDecimal(20), new BigDecimal(50), LocalDate.now(), 100, "A3",  productIds.get(new Random().nextInt(productIds.size()))));
        StockItem stockItem4 = stockItemRepository.save(new StockItem(new BigDecimal(1000), new BigDecimal(1500), LocalDate.now(), 100, "A4",  productIds.get(new Random().nextInt(productIds.size()))));


    }
}
