package com.crud.crud; // Mendefinisikan package (paket) tempat class ini berada

import org.springframework.boot.SpringApplication; // Import class SpringApplication untuk menjalankan aplikasi Spring Boot
import org.springframework.boot.autoconfigure.SpringBootApplication; // Import anotasi SpringBootApplication

// Anotasi @SpringBootApplication menandakan bahwa ini adalah class utama untuk aplikasi Spring Boot
// Anotasi ini juga mengaktifkan auto-configuration dan component scanning
@SpringBootApplication
public class CrudApplication { // Mendefinisikan class public bernama CrudApplication

	// Method main adalah titik awal (entry point) dari mana aplikasi Java dijalankan
	public static void main(String[] args) {
		// Perintah ini menjalankan aplikasi Spring Boot
		// CrudApplication.class adalah referensi ke class ini sendiri
		// args adalah argumen baris perintah yang diteruskan ke aplikasi
		SpringApplication.run(CrudApplication.class, args);
	}
}
