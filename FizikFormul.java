/*
 * Ad Soyad: NEHİR KÖKTEN
 * Ogrenci No:250541039
 * Tarih: 13.11.2025
 * Aciklama: Gorev 2 - Fizik Formulu Asistani
 *
 * Bu program temel fizik formullerini kullanarak
 * hesaplamalar yapar.
 */

import java.util.Scanner; // Kullanıcıdan veri almak için kütüphaneyi içe aktar
import java.util.Locale; // Ondalık ayracı (nokta) garantilemek için eklendi

/**
 * Görev 2: Fizik Formül Asistanı
 * Bu program, kullanıcıdan temel fiziksel büyüklükleri alarak
 * hız, ivme, kuvvet, iş, güç, kinetik enerji, potansiyel enerji
 * ve momentum hesaplamaları yapar. (Kullanıcı Girdili Versiyon)
 */
public class FizikFormul {

    // === Formüller ve Sabitler ===
    // Yerçekimi ivmesi (m/s^2)
    public static final double GRAVITY = 9.8;

    // === Zorunlu Metotlar ===

    /**
     * 1. Hız hesapla (v = s / t)
     */
    public static double calculateVelocity(double distance, double time) {
        if (time == 0) return 0; // Sıfıra bölme hatasını engelle
        return distance / time;
    }

    /**
     * 2. İvme hesapla (a = Δv / t)
     */
    public static double calculateAcceleration(double velocityChange, double time) {
        if (time == 0) return 0; // Sıfıra bölme hatasını engelle
        return velocityChange / time;
    }

    /**
     * 3. Kuvvet hesapla (F = m * a)
     */
    public static double calculateForce(double mass, double acceleration) {
        return mass * acceleration;
    }

    /**
     * 4. İş hesapla (W = F * d)
     */
    public static double calculateWork(double force, double distance) {
        return force * distance;
    }

    /**
     * 5. Güç hesapla (P = W / t)
     */
    public static double calculatePower(double work, double time) {
        if (time == 0) return 0; // Sıfıra bölme hatasını engelle
        return work / time;
    }

    /**
     * 6. Kinetik enerji hesapla (KE = 0.5 * m * v^2)
     */
    public static double calculateKineticEnergy(double mass, double velocity) {
        return 0.5 * mass * velocity * velocity;
    }

    /**
     * 7. Potansiyel enerji hesapla (PE = m * g * h)
     */
    public static double calculatePotentialEnergy(double mass, double gravity, double height) {
        return mass * gravity * height;
    }

    /**
     * 8. Momentum hesapla (p = m * v)
     */
    public static double calculateMomentum(double mass, double velocity) {
        return mass * velocity;
    }

    /**
     * Ana program metodu (main)
     * Kullanıcıdan girdileri alır ve hesaplamaları yaparak sonuçları yazdırır.
     */
    public static void main(String[] args) {
        // Scanner'ı oluştururken Locale.US kullanarak ondalık ayraç olarak
        // VİRGÜL (,) yerine NOKTA (.) kullanılmasını garantileriz.
        // Bu, InputMismatchException hatasını önler.
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        // === Başlık ===
        System.out.println("=== FIZIK FORMUL ASISTANI ===");
        System.out.println();

        // === TEMEL OLCUMLER (Kullanıcı Girdileri) ===
        // Lütfen ondalıklı sayıları 10.5 gibi NOKTA ile girin.
        System.out.println("TEMEL OLCUMLER:");
        System.out.print("Kutle (kg): ");
        double k_mass = scanner.nextDouble();

        System.out.print("Mesafe (m): ");
        double k_distance = scanner.nextDouble();

        System.out.print("Zaman (s): ");
        double k_time = scanner.nextDouble();

        System.out.print("Hiz degisimi (m/s): ");
        double k_velocityChange = scanner.nextDouble();

        System.out.print("Yukseklik (m): ");
        double k_height = scanner.nextDouble();

        scanner.close(); // Kaynakları serbest bırak

        // === HESAPLAMALAR ===
        double velocity = calculateVelocity(k_distance, k_time);
        double acceleration = calculateAcceleration(k_velocityChange, k_time);
        double force = calculateForce(k_mass, acceleration);
        double work = calculateWork(force, k_distance);
        double power = calculatePower(work, k_time);
        double kineticEnergy = calculateKineticEnergy(k_mass, velocity);
        double potentialEnergy = calculatePotentialEnergy(k_mass, GRAVITY, k_height);
        double totalEnergy = kineticEnergy + potentialEnergy; 
        double momentum = calculateMomentum(k_mass, velocity);

        // === HESAPLAMA SONUCLARI (Hizalaması Düzeltilmiş Çıktı) ===
        System.out.println();
        System.out.println("==================================");
        System.out.println("HESAPLAMA SONUCLARI");
        System.out.println("==================================");
        System.out.println();

        // HIZ VE HAREKET
        System.out.println("HIZ VE HAREKET:");
        System.out.printf("%-25s : %.2f m/s\n", "Hiz (v = s/t)", velocity);
        System.out.printf("%-25s : %.2f m/s²\n", "Ivme (a = Δv/t)", acceleration);
        System.out.println();

        // KUVVET VE IS
        System.out.println("KUVVET VE IS:");
        System.out.printf("%-25s : %.2f N\n", "Kuvvet (F = m*a)", force);
        System.out.printf("%-25s : %.2f J\n", "Is (W = F*d)", work);
        System.out.printf("%-25s : %.2f W\n", "Guc (P = W/t)", power);
        System.out.println();

        // ENERJI
        System.out.println("ENERJI:");
        System.out.printf("%-25s : %.2f J\n", "Kinetik Enerji (KE)", kineticEnergy);
        System.out.printf("%-25s : %.2f J\n", "Potansiyel Enerji (PE)", potentialEnergy);
        System.out.printf("%-25s : %.2f J\n", "Toplam Enerji", totalEnergy); 
        System.out.println();

        // MOMENTUM
        System.out.println("MOMENTUM:");
        System.out.printf("%-25s : %.2f kg·m/s\n", "Momentum (p = m*v)", momentum);
    }
}
