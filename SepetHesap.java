/*
 * Ad Soyad: NEHİR KÖKTEN
 * Ogrenci No: 250541039
 * Tarih:13.11.2025
 * Aciklama: Gorev 3 - E-Ticaret Sepet Hesaplayici
 *
 * Bu program 3 adet urunun sepet tutarini
 * KDV, indirim ve kargo dahil hesaplar.
 */

import java.util.Scanner;
import java.util.Locale; // Çıktıdaki ondalık sayılar için (örn: 507.89)

/**
 * Görev 3: E-Ticaret Sepet Hesaplayıcı
 * * Kullanıcıdan 3 farklı ürünün fiyat ve adet bilgisini alarak
 * ve zorunlu metotları kullanarak sepetin genel toplamını hesaplayan program.
 */
public class SepetHesap {

    // Formüller ve Sabitler (Görsel 3'e göre)
    // final: Bu değişkenlerin değerinin değiştirilemez (sabit) olduğunu belirtir.
    // static: Bu değişkenlere sınıf adıyla (SepetHesap.VAT_RATE) erişilebilmesini sağlar.
    final static double VAT_RATE = 0.18;       // KDV Oranı (%18)
    final static double SHIPPING_FEE = 29.99;  // Sabit kargo ücreti (TL)

    /**
     * Programın ana giriş noktası.
     * Kullanıcıdan girdileri alır, hesaplamaları yapar ve sonucu yazdırır.
     */
    public static void main(String[] args) {

        // Kullanıcıdan veri almak için Scanner nesnesi oluşturulur.
        // Locale.US kullanmak, kullanıcının 100.50 gibi ondalık sayıları
        // nokta ile girmesini bekler (Türkçe'de genelde virgül kullanılır).
        // Girdinin virgülle (örn: 50,5) de çalışması için Locale.US *kullanılmamıştır*.
        // Çıktının noktalı olması (örn: 200.00) printf içinde ayarlanmıştır.
        Scanner scanner = new Scanner(System.in);

        // === GİRDİ ALMA (Örnek Çalışma - Görsel 1) ===

        System.out.println("=== E-TICARET SEPET HESAPLAYICI ===");
        System.out.println("\nLutfen 3 urunun bilgilerini girin:");

        // Ürün 1 Girdileri
        System.out.println("\nURUN 1:");
        System.out.print("Birim Fiyat (TL): ");
        double fiyat1 = scanner.nextDouble();
        System.out.print("Adet: ");
        int adet1 = scanner.nextInt();

        // Ürün 2 Girdileri
        System.out.println("\nURUN 2:");
        System.out.print("Birim Fiyat (TL): ");
        double fiyat2 = scanner.nextDouble();
        System.out.print("Adet: ");
        int adet2 = scanner.nextInt();

        // Ürün 3 Girdileri
        System.out.println("\nURUN 3:");
        System.out.print("Birim Fiyat (TL): ");
        double fiyat3 = scanner.nextDouble();
        System.out.print("Adet: ");
        int adet3 = scanner.nextInt();

        // İndirim Yüzdesi Girdisi
        System.out.print("\nIndirim Kuponu Yuzdesi (%): ");
        double indirimYuzdesi = scanner.nextDouble();

        // Girdiler alındıktan sonra tarayıcı (scanner) kapatılır.
        scanner.close();

        // === HESAPLAMALAR (Zorunlu Metotlar Kullanılarak - Görsel 3) ===

        // 1. Her bir ürünün satır toplamı hesaplanır
        double satirTop1 = calculateLineTotal(fiyat1, adet1);
        double satirTop2 = calculateLineTotal(fiyat2, adet2);
        double satirTop3 = calculateLineTotal(fiyat3, adet3);

        // 2. Sepetteki 3 ürünün ara toplamı hesaplanır
        double araToplam = calculateSubtotal(satirTop1, satirTop2, satirTop3);

        // 3. İndirim tutarı hesaplanır
        double indirimTutari = calculateDiscountAmount(araToplam, indirimYuzdesi);

        // 4. İndirimli fiyat (ara toplamdan indirim düşülmüş hali) hesaplanır
        double indirimliToplam = applyDiscount(araToplam, indirimTutari);

        // 5. KDV tutarı (indirimli toplam üzerinden) hesaplanır
        double kdvTutari = calculateVAT(indirimliToplam, VAT_RATE);

        // 6. Genel toplam (indirimli toplam + KDV + kargo) hesaplanır
        double genelToplam = calculateGrandTotal(indirimliToplam, kdvTutari, SHIPPING_FEE);


        // === ÇIKTI (SİPARİŞ ÖZETİ - Görsel 4) ===

        System.out.println("\n\n=================================");
        System.out.println("        SIPARIS OZETI");
        System.out.println("=================================");

        // printf metodu, formatlı yazdırma işlemi yapar.
        // Locale.US : Ondalık sayı ayıracının virgül (,) yerine nokta (.) olmasını garantiler (Görsel 4'teki gibi).
        // %.2f : float/double türündeki sayıyı virgülden sonra 2 basamakla yazdırır (örn: 200.00).
        // %d : integer (tam sayı) yazar.
        // \n : Yeni satıra geçer.
        // \t : Tab boşluğu bırakır (hizalamaya yardımcı olur).

        System.out.printf(Locale.US, "Urun 1 Toplam (%.2f TL x %d): %.2f TL\n", fiyat1, adet1, satirTop1);
        System.out.printf(Locale.US, "Urun 2 Toplam (%.2f TL x %d): %.2f TL\n", fiyat2, adet2, satirTop2);
        System.out.printf(Locale.US, "Urun 3 Toplam (%.2f TL x %d): %.2f TL\n", fiyat3, adet3, satirTop3);

        System.out.println("---------------------------------");

        System.out.printf(Locale.US, "Ara Toplam \t\t: %.2f TL\n", araToplam);
        // İndirim yüzdesini (%10) dinamik olarak yazdırmak için:
        System.out.printf(Locale.US, "Indirim Tutari (%%%d)\t: -%.2f TL\n", (int)indirimYuzdesi, indirimTutari);
        System.out.printf(Locale.US, "Indirimli Toplam\t: %.2f TL\n", indirimliToplam);

        System.out.println(); // Boşluklu satır

        // KDV yüzdesini (%18) dinamik olarak yazdırmak için:
        System.out.printf(Locale.US, "KDV Tutari (%%%d)\t: +%.2f TL\n", (int)(VAT_RATE * 100), kdvTutari);
        System.out.printf(Locale.US, "Kargo Ucreti\t\t: +%.2f TL\n", SHIPPING_FEE);

        System.out.println(); // Boşluklu satır

        System.out.printf(Locale.US, "GENEL TOPLAM\t\t: %.2f TL\n", genelToplam);
        System.out.println("=================================");
    }


    // --- ZORUNLU METOTLAR (Görsel 3'teki tanımlara göre) ---

    /**
     * 1. Bir urunun toplam fiyatini hesaplar (fiyat * adet)
     */
    public static double calculateLineTotal(double price, int quantity) {
        return price * quantity;
    }

    /**
     * 2. Sepetteki 3 urunun ara toplamini hesaplar
     */
    public static double calculateSubtotal(double line1, double line2, double line3) {
        return line1 + line2 + line3;
    }

    /**
     * 3. Indirim tutarini hesaplar (AraToplam * (IndirimYuzdesi / 100))
     */
    public static double calculateDiscountAmount(double subtotal, double discountPercentage) {
        return subtotal * (discountPercentage / 100.0);
    }

    /**
     * 4. Indirimli fiyati hesaplar (araToplam - indirimTutari)
     */
    public static double applyDiscount(double subtotal, double discountAmount) {
        return subtotal - discountAmount;
    }

    /**
     * 5. KDV tutarini hesaplar (IndirimliTutar * KDVOrani)
     */
    public static double calculateVAT(double discountedTotal, double vatRate) {
        return discountedTotal * vatRate;
    }

    /**
     * 6. Genel toplami hesaplar (IndirimliTutar + KDV + Kargo)
     */
    public static double calculateGrandTotal(double discountedTotal, double vatAmount, double shippingFee) {
        return discountedTotal + vatAmount + shippingFee;
    }
}
