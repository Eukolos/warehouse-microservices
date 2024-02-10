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
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;

@Component
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
        List<ProductDto> products = productClient.getProductList();
        List<String> productIds = products.stream().map(ProductDto::id).toList();
        System.out.println(productIds);

        Supplier supplier1 = supplierRepository.save(new Supplier("PT. Istana", "Jl. Istana", "08123456789", 1234567890, "info@istana.com"));
        Supplier supplier2 = supplierRepository.save( new Supplier("PT. Kita", "Jl. Kita", "08123456789", 1234567890, "warehouse@kita.com"));
        Supplier supplier3 = supplierRepository.save( new Supplier("PT. Saya", "Jl. Saya", "08123456789", 1234567890, "info@saya.com"));
        Supplier supplier4 = supplierRepository.save( new Supplier("PT. Anda", "Jl. Anda", "08123456789", 1234567890, "warehouse@anda.com"));
        Supplier supplier5 = supplierRepository.save( new Supplier("PT. Kami", "Jl. Kami", "08123456789", 1234567890, "info@kami.com"));

        System.out.println(supplier1.getName()+" "+supplier2.getName()+" "+supplier3.getName()+" "+supplier4.getName()+" "+supplier5.getName()  );

        StockItem stockItem1 = new StockItem(new BigDecimal(280), new BigDecimal(360), LocalDate.now(), 100, "A1",  productIds.get(new Random().nextInt(productIds.size())));
        StockItem stockItem2 = new StockItem(new BigDecimal(50), new BigDecimal(200), LocalDate.now(), 100, "A2",  productIds.get(new Random().nextInt(productIds.size())));
        StockItem stockItem4 = new StockItem(new BigDecimal(1000), new BigDecimal(1500), LocalDate.now(), 100, "A4",  productIds.get(new Random().nextInt(productIds.size())));
        StockItem stockItem3 = new StockItem(new BigDecimal(20), new BigDecimal(50), LocalDate.now(), 100, "A3",  productIds.get(new Random().nextInt(productIds.size())));
        StockItem stockItem5 = new StockItem(new BigDecimal(200), new BigDecimal(300), LocalDate.now(), 100, "A5",  productIds.get(new Random().nextInt(productIds.size())));
        StockItem stockItem6 = new StockItem(new BigDecimal(100), new BigDecimal(200), LocalDate.now(), 100, "A6",  productIds.get(new Random().nextInt(productIds.size())));
        StockItem stockItem7 = new StockItem(new BigDecimal(100), new BigDecimal(200), LocalDate.now(), 100, "A7",  productIds.get(new Random().nextInt(productIds.size())));
        StockItem stockItem8 = new StockItem(new BigDecimal(100), new BigDecimal(200), LocalDate.now(), 100, "A8",  productIds.get(new Random().nextInt(productIds.size())));
        StockItem stockItem9 = new StockItem(new BigDecimal(100), new BigDecimal(200), LocalDate.now(), 100, "A9",  productIds.get(new Random().nextInt(productIds.size())));
        StockItem stockItem10 = new StockItem(new BigDecimal(100), new BigDecimal(200), LocalDate.now(), 100, "A10",  productIds.get(new Random().nextInt(productIds.size())));

        System.out.println(stockItem1.getQuantity()+" "+stockItem2.getQuantity()+" "+stockItem3.getQuantity()+" "+stockItem4.getQuantity()+" "+stockItem5.getQuantity()+" "+stockItem6.getQuantity()+" "+stockItem7.getQuantity()+" "+stockItem8.getQuantity()+" "+stockItem9.getQuantity()+" "+stockItem10.getQuantity()  );

        Waybill waybill1 = waybillRepository.save(new Waybill("123", LocalDate.now(), supplier1, LocalDate.now(), List.of(stockItem1, stockItem2)));
        Waybill waybill2 = waybillRepository.save(new Waybill("124", LocalDate.now(), supplier2, LocalDate.now(), List.of(stockItem3, stockItem4)));
        Waybill waybill3 = waybillRepository.save(new Waybill("125", LocalDate.now(), supplier3, LocalDate.now(), List.of(stockItem5, stockItem6)));
        Waybill waybill4 = waybillRepository.save(new Waybill("126", LocalDate.now(), supplier4, LocalDate.now(), List.of(stockItem7, stockItem8)));
        Waybill waybill5 = waybillRepository.save(new Waybill("127", LocalDate.now(), supplier5, LocalDate.now(), List.of(stockItem9, stockItem10)));

        System.out.println(waybill1.getWaybillNumber()+" "+waybill2.getWaybillNumber()+" "+waybill3.getWaybillNumber()+" "+waybill4.getWaybillNumber()+" "+waybill5.getWaybillNumber()  );
    }
}
