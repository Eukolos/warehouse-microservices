package com.istanify.accounting.seed;

import com.istanify.accounting.model.Account;
import com.istanify.accounting.repository.AccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class Seed implements CommandLineRunner {

    private final AccountRepository accountRepository;

    public Seed(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (accountRepository.count() == 0) {
            Account kasa = new Account("Kasa", "Nakit varlıklar", 0.0, 100);
            Account alinanCekler = new Account("Alınan Çekler", "Nakit varlıklar", 0.0, 101);

            Account ticariAlacaklar = new Account("Ticari Alacaklar", "Alacaklar", 0.0, 120);
            Account alacakSenetleri = new Account("Alacak Senetleri", "Alacaklar", 0.0, 121);
            Account digerTicariAlacaklar = new Account("Diğer Ticari Alacaklar", "Alacaklar", 0.0, 126);

            Account araziVeArsalar = new Account("Arazi ve Arsalar", "Maddi Duran Varlıklar", 0.0, 250);
            Account binalar = new Account("Binalar", "Maddi Duran Varlıklar", 0.0, 252);
            Account tasitlar = new Account("Taşıtlar", "Maddi Duran Varlıklar", 0.0, 254);

            Account bankaKredileriKisaVadeli = new Account("Banka Kredileri", "Kısa Vadeli Borçlar", 0.0, 300);
            Account finansalKiralamaBorclariKisaVadeli = new Account("Finansal Kiralama İşlemlerinden Borçlar", "Kısa Vadeli Borçlar", 0.0, 301);
            Account digerMaliBorclarKisaVadeli = new Account("Diğer Mali Borçlar", "Kısa Vadeli Borçlar", 0.0, 309);

            Account bankaKredileriUzunVadeli = new Account("Banka Kredileri", "Uzun Vadeli Borçlar", 0.0, 400);
            Account finansalKiralamaBorclariUzunVadeli = new Account("Finansal Kiralama İşlemlerinden Borçlar", "Uzun Vadeli Borçlar", 0.0, 401);
            Account digerMaliBorclarUzunVadeli = new Account("Diğer Mali Borçlar", "Uzun Vadeli Borçlar", 0.0, 409);

            Account sermaye = new Account("Sermaye", "Öz Kaynaklar", 0.0, 500);
            Account sermayeDuzeltmesiOlumluFarklar = new Account("Sermaye Düzeltmesi Olumlu Farkları", "Öz Kaynaklar", 0.0, 502);
            Account sermayeDuzeltmesiOlumsuzFarklar = new Account("Sermaye Düzeltmesi Olumsuz Farkları", "Öz Kaynaklar", 0.0, 503);

            Account brutSatislar = new Account("Brüt Satışlar", "Gelir Tablosu Hesapları", 0.0, 600);
            Account satisIndirimleri = new Account("Satış İndirimleri", "Gelir Tablosu Hesapları", 0.0, 610);
            Account satislarinMaliyeti = new Account("Satışların Maliyeti", "Gelir Tablosu Hesapları", 0.0, 620);

            accountRepository.saveAll(
                    List.of(
                            kasa, alinanCekler,
                            ticariAlacaklar, alacakSenetleri, digerTicariAlacaklar,
                            araziVeArsalar, binalar, tasitlar,
                            bankaKredileriKisaVadeli, finansalKiralamaBorclariKisaVadeli, digerMaliBorclarKisaVadeli,
                            bankaKredileriUzunVadeli, finansalKiralamaBorclariUzunVadeli, digerMaliBorclarUzunVadeli,
                            sermaye, sermayeDuzeltmesiOlumluFarklar, sermayeDuzeltmesiOlumsuzFarklar,
                            brutSatislar, satisIndirimleri, satislarinMaliyeti
                    )
            );
        }


    }
}
