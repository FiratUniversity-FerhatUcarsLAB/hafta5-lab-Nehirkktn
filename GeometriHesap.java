/*
 * Ad Soyad: NEHİR KÖKTEN
 * Ogrenci No: 250541039
 * Tarih:13.11.2025
 * Aciklama: Gorev 1 - Geometrik Sekil Hesaplayici
 * 
 * Bu program temel geometrik sekillerin alan ve
 * cevre hesaplamalarini yapar.
 */

import java.util.Scanner;
import java.util.Locale;

public class GeometriHesap {

    public static void main(String[] args) {
        
        // Girdilerde ondalık sayı için virgül yerine nokta kullanılmasını sağlar
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.println("=== GEOMETRIK SEKIL HESAPLAYICI ===");
        System.out.println();

        // --- 1. KULLANICI GİRDİLERİNİ ALMA ---

        // Kare Girdisi
        System.out.println("KARE:");
        System.out.print("Kenar uzunlugu (cm): ");
        double squareSide = scanner.nextDouble();

        // Dikdörtgen Girdileri
        System.out.println("\nDIKDORTGEN:");
        System.out.print("Kisa kenar (cm): ");
        double rectShort = scanner.nextDouble();
        System.out.print("Uzun kenar (cm): ");
        double rectLong = scanner.nextDouble();

        // Daire Girdisi
        System.out.println("\nDAIRE:");
        System.out.print("Yaricap (cm): ");
        double circleRadius = scanner.nextDouble();

        // Üçgen Girdileri
        System.out.println("\nUCGEN:");
        System.out.print("Taban (cm): ");
        double triangleBase = scanner.nextDouble();
        System.out.print("Yukseklik (cm): ");
        double triangleHeight = scanner.nextDouble();
        System.out.print("1. kenar (cm): ");
        double triangleA = scanner.nextDouble();
        System.out.print("2. kenar (cm): ");
        double triangleB = scanner.nextDouble();
        System.out.print("3. kenar (cm): ");
        double triangleC = scanner.nextDouble();

        // --- 2. HESAPLAMALAR ---

        // Kare hesaplamaları
        double sqArea = calculateSquareArea(squareSide);
        double sqPerimeter = calculateSquarePerimeter(squareSide);

        // Dikdörtgen hesaplamaları
        double rectArea = calculateRectangleArea(rectShort, rectLong);
        double rectPerimeter = calculateRectanglePerimeter(rectShort, rectLong);

        // Daire hesaplamaları
        double circArea = calculateCircleArea(circleRadius);
        double circCircumference = calculateCircleCircumference(circleRadius);

        // Üçgen hesaplamaları
        double triArea = calculateTriangleArea(triangleBase, triangleHeight);
        double triPerimeter = calculateTrianglePerimeter(triangleA, triangleB, triangleC);
        
        // --- 3. SONUÇLARI YAZDIRMA ---

        System.out.println("\n===============================");
        System.out.println("HESAPLAMA SONUCLARI");
        System.out.println("===============================");

        // Kare Sonuçları
        // printf ile "%.1f" virgülden sonra 1 basamak, "%.2f" 2 basamak gösterir
        System.out.printf("\nKARE (kenar: %.1f cm):\n", squareSide);
        System.out.printf("Alan    : %.2f cm²\n", sqArea);
        System.out.printf("Cevre   : %.2f cm\n", sqPerimeter);

        // Dikdörtgen Sonuçları
        System.out.printf("\nDIKDORTGEN (%.1f x %.1f cm):\n", rectShort, rectLong);
        System.out.printf("Alan    : %.2f cm²\n", rectArea);
        System.out.printf("Cevre   : %.2f cm\n", rectPerimeter);

        // Daire Sonuçları
        System.out.printf("\nDAIRE (yaricap: %.1f cm):\n", circleRadius);
        System.out.printf("Alan    : %.2f cm²\n", circArea);
        System.out.printf("Cevre   : %.2f cm\n", circCircumference);

        // Üçgen Sonuçları (Örnek çıktıya göre taban ve yükseklik bilgisiyle)
        System.out.printf("\nUCGEN (taban: %.1f, yukseklik: %.1f cm):\n", triangleBase, triangleHeight);
        System.out.printf("Alan    : %.2f cm²\n", triArea);
        System.out.printf("Cevre   : %.2f cm\n", triPerimeter);
        
        System.out.println("\n===============================");

        // Scanner'ı kapat
        scanner.close();
    }

    // --- ZORUNLU METOTLAR ---

    // 1. Kare alanı
    public static double calculateSquareArea(double side) {
        return side * side;
    }

    // 2. Kare çevresi
    public static double calculateSquarePerimeter(double side) {
        return 4 * side;
    }

    // 3. Dikdörtgen alanı
    public static double calculateRectangleArea(double width, double height) {
        return width * height;
    }

    // 4. Dikdörtgen çevresi
    public static double calculateRectanglePerimeter(double width, double height) {
        return 2 * (width + height);
    }

    // 5. Daire alanı
    public static double calculateCircleArea(double radius) {
        // Math.PI kullanarak Pi sayısını alıyoruz
        return Math.PI * radius * radius;
    }

    // 6. Daire çevresi
    public static double calculateCircleCircumference(double radius) {
        return 2 * Math.PI * radius;
    }

    // 7. Üçgen alanı (taban ve yükseklik ile)
    public static double calculateTriangleArea(double base, double height) {
        return (base * height) / 2;
    }

    // 8. Üçgen çevresi
    public static double calculateTrianglePerimeter(double a, double b, double c) {
        return a + b + c;
    }
}
