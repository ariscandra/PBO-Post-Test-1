<a name="top"></a>
    
# PBO | Post-Test 1 | Manajemen Pets Daycare Breakdown

## 📚 Daftar Isi
- [👥 Deskripsi Program](#-deskripsi-program)
- [📖 Penjelasan Kode](#-penjelasan-kode)
- [🖥️ Penjelasan Alur Program](#️-penjelasan-alur-program)

## 👥 Deskripsi Program
**Manajemen Pets Daycare**

Program ini adalah aplikasi manajemen penitipan hewan (Pets Daycare) yang dikembangkan dengan bahasa pemrograman Java. Berikut ini adalah komponen utamanya:

**1. Fitur Utama**

- CRUD: Program mampu melakukan operasi Create, Read, Update, dan Delete data peliharaan yang dititipkan
- Manajemen Data Pets: Mengelola informasi lengkap tentang hewan yang dititipkan termasuk nama, jenis, umur, dan pemilik

**2. Struktur Data**

- ArrayList: Digunakan untuk menyimpan data hewan dalam bentuk array of String, di mana setiap array merepresentasikan data satu hewan
- String Arrays: Setiap hewan disimpan sebagai array dengan format [ID, Nama, Jenis, Umur, Pemilik]

**3. Validasi Input**

- hanyaHurufDanSpasi(): Memvalidasi bahwa input hanya mengandung huruf dan spasi (untuk nama, jenis, dan nama pemilik)
- hanyaAngka(): Memvalidasi bahwa input hanya mengandung angka (untuk field umur)
- Batas Panjang Input: Membatasi panjang input untuk setiap field (nama max 30 karakter, jenis max 20 karakter, dll)
- Rentang Nilai: Memastikan umur hewan berada dalam rentang yang wajar (0-30 tahun)

**4. Alur Program**

- Program menampilkan menu utama dengan opsi-opsi CRUD
- Pengguna dapat memilih opsi untuk menambah, melihat, mengupdate, atau menghapus data hewan
- Setiap opsi akan memandu pengguna melalui proses input dengan validasi
- Program akan terus berjalan sampai pengguna memilih opsi keluar

**5. Keamanan Data**

- Program mencegah input yang tidak valid melalui berbagai lapisan validasi
- Menghindari error dengan penanganan exception untuk konversi tipe data
- Memastikan konsistensi data dengan batasan-batasan yang jelas

**6. Kesimpulan**

Program ini memberikan solusi sederhana namun efektif untuk mengelola data penitipan hewan harian.

## 📖 Penjelasan Kode

<details>
  <summary><h3>Penjelasan Kode</h3></summary>

**1. Package dan Import Library**
```java
package postTest1;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
```

- Program berada dalam package postTest1.
- Mengimpor kelas untuk struktur data (ArrayList), input pengguna (Scanner), dan regex untuk validasi input (Pattern, Matcher).

**2. Method Validasi Input**
```java
	// BUAT VALIDASI CUMA HURUF AMA SPASI
	public static boolean hanyaHurufDanSpasi(String input) {
        Pattern pattern = Pattern.compile("^[a-zA-Z\\s]+$");
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }
	// BUAT VALIDASI CUMA ANGKA
	public static boolean hanyaAngka(String input) {
        Pattern pattern = Pattern.compile("^[0-9]+$");
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }
```

- hanyaHurufDanSpasi: Memvalidasi bahwa input hanya mengandung huruf (a-Z, A-Z) dan spasi.
- hanyaAngka: Memvalidasi bahwa input hanya mengandung angka (0-9).

**3. Method Main & Inisialisasi**
```java
public static void main(String[] args) {
        ArrayList<String[]> pets = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int pilihan;
        int idOtomatis = 1;
```

- pets: ArrayList untuk menyimpan data pets (setiap pets direpresentasikan sebagai array string: [ID, Nama, Jenis, Umur, Pemilik]).
- scanner: Untuk membaca input dari pengguna.
- idOtomatis: Supaya ID otomatis (pakai increment).

**4. Loop Menu Utama**
```java
do {
    String keren = """
        			   _____     _              _       
        			  |  __ \\   | |            (_)      
        			  | |__) |__| |_ ___  _ __  _  __ _ 
        			  |  ___/ _ \\ __/ _ \\| '_ \\| |/ _` |
        			  | |  |  __/ || (_) | |_) | | (_| |
        			  |_|   \\___|\\__\\___/| .__/|_|\\__,_|
        			                     | |            
        			                     |_|            
        			""";
        	// INI MENU UTAMA WOOIIIIIII
        	System.out.print(keren);
        	System.out.println("\n=== Haloooo Admin Aris, Good to see you back! Moga sehat selalu! ===");
            System.out.println("\n+==== Petopia Pets Daycare ====+");
            System.out.println("| [1] Tambah Data Pets         |");
            System.out.println("| [2] Lihat Semua Data Pets    |");
            System.out.println("| [3] Update Data Pets         |");
            System.out.println("| [4] Hapus Data Pets          |");
            System.out.println("| [0] Keluar                   |");
            System.out.println("+==============================+");
            System.out.print("Pilih menu (0-4): ");
			// Sampai baris kode di bawah ini.
} while (pilihan != 0);
```

- Menampilkan menu utama dengan opsi: Tambah, Lihat, Update, Hapus, Keluar.
- Program akan terus berjalan hingga pengguna memilih keluar (0).

**5. Fitur CRUD: Tambah Data (Case 1)**
```java
				case 1:
                    // INI TAMBAH WOOOOOIIIIIII
                    System.out.println("\n--- Tambah Data Pet ---");
                    String[] newPet = new String[5];
                    newPet[0] = String.valueOf(idOtomatis);
                    System.out.println("ID Pet: " + idOtomatis);
                    // INI BUAT VALIDASI NAMA YG VALID WOIIII
                    boolean inputNamaValid = false;
                    while (!inputNamaValid) {
                        System.out.print("Nama pet: ");
                        String namaInput = scanner.nextLine();
                        
                        if (namaInput.length() > 30) {
                            System.out.println("Error: Nama tidak boleh lebih dari 30 karakter.");
                            continue;
                        }
                        
                        if (hanyaHurufDanSpasi(namaInput)) {
                            newPet[1] = namaInput;
                            inputNamaValid = true;
                        } else {
                            System.out.println("Error: Nama hanya boleh mengandung huruf dan spasi.");
                        }
                    }
                    
                    // INI BUAT VALIDASI JENIS YG VALID WOIIII
                    boolean inputJenisValid = false;
                    while (!inputJenisValid) {
                        System.out.print("Jenis pet: ");
                        String jenisInput = scanner.nextLine();
                        
                        if (jenisInput.length() > 20) {
                            System.out.println("Error: Jenis pet tidak boleh lebih dari 20 karakter.");
                            continue;
                        }
                        
                        if (hanyaHurufDanSpasi(jenisInput)) {
                            newPet[2] = jenisInput;
                            inputJenisValid = true;
                        } else {
                            System.out.println("Error: Jenis pet hanya boleh mengandung huruf dan spasi.");
                        }
                    }
                    
                    // INI BUAT VALIDASI UMUR YG VALID WOIIII
                    boolean inputUmurValid = false;
                    while (!inputUmurValid) {
                        System.out.print("Umur: ");
                        String umurInput = scanner.nextLine();
                        
                        if (umurInput.length() > 2) {
                            System.out.println("Error: Umur tidak boleh lebih dari 2 digit dan harus angka.");
                            continue;
                        }
                        
                        if (hanyaAngka(umurInput)) {
                            try {
                                int umur = Integer.parseInt(umurInput);
                                
                                if (umur < 0 || umur > 30) {
                                    System.out.println("Error: Umur harus antara 0 dan 30 tahun.");
                                    continue;
                                }
                                
                                newPet[3] = umurInput;
                                inputUmurValid = true;
                            } catch (NumberFormatException e) {
                                System.out.println("Error: Format angka tidak valid. Silakan masukkan angka yang benar.");
                            }
                        } else {
                            System.out.println("Error: Umur hanya boleh mengandung angka.");
                        }
                    }
                    
                    // INI BUAT VALIDASI NAMA PEMILIK YG VALID WOIIII
                    boolean inputPemilikValid = false;
                    while (!inputPemilikValid) {
                        System.out.print("Nama Pemilik: ");
                        String pemilikInput = scanner.nextLine();
                        
                        if (pemilikInput.length() > 40) {
                            System.out.println("Error: Nama pemilik tidak boleh lebih dari 40 karakter.");
                            continue;
                        }
                        
                        if (hanyaHurufDanSpasi(pemilikInput)) {
                            newPet[4] = pemilikInput;
                            inputPemilikValid = true;
                        } else {
                            System.out.println("Error: Nama pemilik hanya boleh mengandung huruf dan spasi.");
                        }
                    }
                    
                    pets.add(newPet);
                    System.out.println(newPet[1] + " berhasil ditambahkan dengan ID: " + idOtomatis);
                    idOtomatis++;
                    break;
```

- Meminta input nama, jenis, umur, dan pemilik dengan validasi ketat:
	- Panjang maksimum dan format karakter (huruf/angka).
	- Umur harus antara 0-30 tahun.
- Data disimpan ke ArrayList pets.

**6. Fitur CRUD: Lihat Data (Case 2)**
```java
                case 2:
                	// INI LIAT DAFTAR WOIIIIIII
                    System.out.println("\n--- Daftar Pets di Petopia ---");
                    if (pets.isEmpty()) {
                        System.out.println("Belum ada pets yang dititipkan :(\n");
                    } else {
                        System.out.println("ID | Nama | Jenis | Umur | Pemilik");
                        System.out.println("------------------------------------");
                        for (String[] pet : pets) {
                            System.out.println(
                                pet[0] + " | " +
                                pet[1] + " | " +
                                pet[2] + " | " +
                                pet[3] + " Tahun | " +
                                pet[4]
                            );
                            System.out.println("------------------------------------\n");
                        }
                    }
                    break;
```

- Menampilkan semua data hewan dalam format tabel.
- Jika tidak ada data, menampilkan pesan bahwa belum ada hewan yang dititipkan.

**7. Fitur CRUD: Update Data (Case 3)**
```java
                case 3:
                    // INI UPDATE WOOIIIIII
                    System.out.println("\n--- Update Data Pet ---");
                    System.out.print("Masukkan ID pet yang akan diupdate: ");
                    String updateId = scanner.nextLine();
                    boolean cocok = false;
                    
                    for (String[] pet : pets) {
                        if (pet[0].equals(updateId)) {
                            System.out.println("Data saat ini:");
                            System.out.println("Nama: " + pet[1]);
                            System.out.println("Jenis: " + pet[2]);
                            System.out.println("Umur: " + pet[3]);
                            System.out.println("Pemilik: " + pet[4]);
                            System.out.println("\nMasukkan data pet yang baru:");
                            
                            boolean namaBaruValid = false;
                            while (!namaBaruValid) {
                                System.out.print("Nama Baru: ");
                                String namaBaru = scanner.nextLine();
                                
                                if (namaBaru.length() > 30) {
                                    System.out.println("Error: Nama tidak boleh lebih dari 30 karakter.");
                                    continue;
                                }
                                
                                if (hanyaHurufDanSpasi(namaBaru)) {
                                    pet[1] = namaBaru;
                                    namaBaruValid = true;
                                } else {
                                    System.out.println("Error: Nama hanya boleh mengandung huruf dan spasi.");
                                }
                            }
                            
                            boolean jenisBaruValid = false;
                            while (!jenisBaruValid) {
                                System.out.print("Jenis Baru: ");
                                String jenisBaru = scanner.nextLine();
                                
                                if (jenisBaru.length() > 20) {
                                    System.out.println("Error: Jenis pet tidak boleh lebih dari 20 karakter.");
                                    continue;
                                }
                                
                                if (hanyaHurufDanSpasi(jenisBaru)) {
                                    pet[2] = jenisBaru;
                                    jenisBaruValid = true;
                                } else {
                                    System.out.println("Error: Jenis pet hanya boleh mengandung huruf dan spasi.");
                                }
                            }
                            
                            boolean umurBaruValid = false;
                            while (!umurBaruValid) {
                                System.out.print("Umur: ");
                                String umurBaru = scanner.nextLine();
                                
                                if (umurBaru.length() > 2) {
                                    System.out.println("Error: Umur tidak boleh lebih dari 2 digit dan harus angka.");
                                    continue;
                                }
                                
                                if (hanyaAngka(umurBaru)) {
                                    try {
                                        int umur = Integer.parseInt(umurBaru);
                                        
                                        if (umur < 0 || umur > 30) {
                                            System.out.println("Error: Umur harus antara 0 dan 30 tahun.");
                                            continue;
                                        }
                                        
                                        pet[3] = umurBaru;
                                        umurBaruValid = true;
                                    } catch (NumberFormatException e) {
                                        System.out.println("Error: Format angka tidak valid. Silakan masukkan angka yang benar.");
                                    }
                                } else {
                                    System.out.println("Error: Umur hanya boleh mengandung angka.");
                                }
                            }
                            
                            boolean pemilikBaruValid = false;
                            while (!pemilikBaruValid) {
                                System.out.print("Pemilik Baru: ");
                                String pemilikBaru = scanner.nextLine();
                                
                                if (pemilikBaru.length() > 40) {
                                    System.out.println("Error: Nama pemilik tidak boleh lebih dari 40 karakter.");
                                    continue;
                                }
                                
                                if (hanyaHurufDanSpasi(pemilikBaru)) {
                                    pet[4] = pemilikBaru;
                                    pemilikBaruValid = true;
                                } else {
                                    System.out.println("Error: Nama pemilik hanya boleh mengandung huruf dan spasi.");
                                }
                            }
                            
                            System.out.println("Data pet berhasil diupdate!");
                            cocok = true;
                            break;
                        }
                    }
                    
                    if (!cocok) {
                        System.out.println("Pet dengan ID " + updateId + " tidak ada, min!");
                    }
                    break;
```

- Meminta ID hewan yang akan diupdate.
- Validasi input untuk setiap field (sama seperti tambah data).
- Memperbarui data yang sudah ada.

**8. Fitur CRUD: Hapus Data (Case 4)**
```java
                case 4:
                    // INI DELETE WOOOOOOOOIIII
                    System.out.println("\n--- Hapus Data Pet ---");
                    System.out.print("Masukkan ID pet yang akan dihapus: ");
                    String deleteId = scanner.nextLine();
                    boolean hapus = false;
                    
                    for (int i = 0; i < pets.size(); i++) {
                        if (pets.get(i)[0].equals(deleteId)) {
                            String[] deletedPet = pets.remove(i);
                            System.out.println("Pet dengan ID " + deleteId + " (" + deletedPet[1] + ") berhasil dihapus!");
                            hapus = true;
                            break;
                        }
                    }
                    
                    if (!hapus) {
                        System.out.println("Pet dengan ID " + deleteId + " tidak ada, min!");
                    }
                    break;
```

<p align="justify">Menghapus data hewan berdasarkan ID.</p>

**9. Keluar Program (Case 0)**
```java
                case 0:
                	// INI KELUAR WOIIIIIIIIIII
                    System.out.println("Program selesai. See you soon Mimin!");
                    break;
```

<p align="justify">Menampilkan pesan penutup dan menghentikan program.</p>
</details>

<details>
  <summary><h3>Full Code</h3></summary>

  
```java
package postTest1;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Main {
	// BUAT VALIDASI CUMA HURUF AMA SPASI
	public static boolean hanyaHurufDanSpasi(String input) {
        Pattern pattern = Pattern.compile("^[a-zA-Z\\s]+$");
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }
	// BUAT VALIDASI CUMA ANGKA
	public static boolean hanyaAngka(String input) {
        Pattern pattern = Pattern.compile("^[0-9]+$");
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }
    public static void main(String[] args) {
        ArrayList<String[]> pets = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int pilihan;
        int idOtomatis = 1;
        
        do {
        	String keren = """
        			   _____     _              _       
        			  |  __ \\   | |            (_)      
        			  | |__) |__| |_ ___  _ __  _  __ _ 
        			  |  ___/ _ \\ __/ _ \\| '_ \\| |/ _` |
        			  | |  |  __/ || (_) | |_) | | (_| |
        			  |_|   \\___|\\__\\___/| .__/|_|\\__,_|
        			                     | |            
        			                     |_|            
        			""";
        	// INI MENU UTAMA WOOIIIIIII
        	System.out.print(keren);
        	System.out.println("\n=== Haloooo Admin Aris, Good to see you back! Moga sehat selalu! ===");
            System.out.println("\n+==== Petopia Pets Daycare ====+");
            System.out.println("| [1] Tambah Data Pets         |");
            System.out.println("| [2] Lihat Semua Data Pets    |");
            System.out.println("| [3] Update Data Pets         |");
            System.out.println("| [4] Hapus Data Pets          |");
            System.out.println("| [0] Keluar                   |");
            System.out.println("+==============================+");
            System.out.print("Pilih menu (0-4): ");
            
            pilihan = scanner.nextInt();
            scanner.nextLine();
            
            switch (pilihan) {
                case 1:
                    // INI TAMBAH WOOOOOIIIIIII
                    System.out.println("\n--- Tambah Data Pet ---");
                    String[] newPet = new String[5];
                    newPet[0] = String.valueOf(idOtomatis);
                    System.out.println("ID Pet: " + idOtomatis);
                    // INI BUAT VALIDASI NAMA YG VALID WOIIII
                    boolean inputNamaValid = false;
                    while (!inputNamaValid) {
                        System.out.print("Nama pet: ");
                        String namaInput = scanner.nextLine();
                        
                        if (namaInput.length() > 30) {
                            System.out.println("Error: Nama tidak boleh lebih dari 30 karakter.");
                            continue;
                        }
                        
                        if (hanyaHurufDanSpasi(namaInput)) {
                            newPet[1] = namaInput;
                            inputNamaValid = true;
                        } else {
                            System.out.println("Error: Nama hanya boleh mengandung huruf dan spasi.");
                        }
                    }
                    
                    // INI BUAT VALIDASI JENIS YG VALID WOIIII
                    boolean inputJenisValid = false;
                    while (!inputJenisValid) {
                        System.out.print("Jenis pet: ");
                        String jenisInput = scanner.nextLine();
                        
                        if (jenisInput.length() > 20) {
                            System.out.println("Error: Jenis pet tidak boleh lebih dari 20 karakter.");
                            continue;
                        }
                        
                        if (hanyaHurufDanSpasi(jenisInput)) {
                            newPet[2] = jenisInput;
                            inputJenisValid = true;
                        } else {
                            System.out.println("Error: Jenis pet hanya boleh mengandung huruf dan spasi.");
                        }
                    }
                    
                    // INI BUAT VALIDASI UMUR YG VALID WOIIII
                    boolean inputUmurValid = false;
                    while (!inputUmurValid) {
                        System.out.print("Umur: ");
                        String umurInput = scanner.nextLine();
                        
                        if (umurInput.length() > 2) {
                            System.out.println("Error: Umur tidak boleh lebih dari 2 digit dan harus angka.");
                            continue;
                        }
                        
                        if (hanyaAngka(umurInput)) {
                            try {
                                int umur = Integer.parseInt(umurInput);
                                
                                if (umur < 0 || umur > 30) {
                                    System.out.println("Error: Umur harus antara 0 dan 30 tahun.");
                                    continue;
                                }
                                
                                newPet[3] = umurInput;
                                inputUmurValid = true;
                            } catch (NumberFormatException e) {
                                System.out.println("Error: Format angka tidak valid. Silakan masukkan angka yang benar.");
                            }
                        } else {
                            System.out.println("Error: Umur hanya boleh mengandung angka.");
                        }
                    }
                    
                    // INI BUAT VALIDASI NAMA PEMILIK YG VALID WOIIII
                    boolean inputPemilikValid = false;
                    while (!inputPemilikValid) {
                        System.out.print("Nama Pemilik: ");
                        String pemilikInput = scanner.nextLine();
                        
                        if (pemilikInput.length() > 40) {
                            System.out.println("Error: Nama pemilik tidak boleh lebih dari 40 karakter.");
                            continue;
                        }
                        
                        if (hanyaHurufDanSpasi(pemilikInput)) {
                            newPet[4] = pemilikInput;
                            inputPemilikValid = true;
                        } else {
                            System.out.println("Error: Nama pemilik hanya boleh mengandung huruf dan spasi.");
                        }
                    }
                    
                    pets.add(newPet);
                    System.out.println(newPet[1] + " berhasil ditambahkan dengan ID: " + idOtomatis);
                    idOtomatis++;
                    break;
                    
                case 2:
                	// INI LIAT DAFTAR WOIIIIIII
                    System.out.println("\n--- Daftar Pets di Petopia ---");
                    if (pets.isEmpty()) {
                        System.out.println("Belum ada pets yang dititipkan :(\n");
                    } else {
                        System.out.println("ID | Nama | Jenis | Umur | Pemilik");
                        System.out.println("------------------------------------");
                        for (String[] pet : pets) {
                            System.out.println(
                                pet[0] + " | " +
                                pet[1] + " | " +
                                pet[2] + " | " +
                                pet[3] + " Tahun | " +
                                pet[4]
                            );
                            System.out.println("------------------------------------\n");
                        }
                    }
                    break;
                    
                case 3:
                    // INI UPDATE WOOIIIIII
                    System.out.println("\n--- Update Data Pet ---");
                    System.out.print("Masukkan ID pet yang akan diupdate: ");
                    String updateId = scanner.nextLine();
                    boolean cocok = false;
                    
                    for (String[] pet : pets) {
                        if (pet[0].equals(updateId)) {
                            System.out.println("Data saat ini:");
                            System.out.println("Nama: " + pet[1]);
                            System.out.println("Jenis: " + pet[2]);
                            System.out.println("Umur: " + pet[3]);
                            System.out.println("Pemilik: " + pet[4]);
                            System.out.println("\nMasukkan data pet yang baru:");
                            
                            boolean namaBaruValid = false;
                            while (!namaBaruValid) {
                                System.out.print("Nama Baru: ");
                                String namaBaru = scanner.nextLine();
                                
                                if (namaBaru.length() > 30) {
                                    System.out.println("Error: Nama tidak boleh lebih dari 30 karakter.");
                                    continue;
                                }
                                
                                if (hanyaHurufDanSpasi(namaBaru)) {
                                    pet[1] = namaBaru;
                                    namaBaruValid = true;
                                } else {
                                    System.out.println("Error: Nama hanya boleh mengandung huruf dan spasi.");
                                }
                            }
                            
                            boolean jenisBaruValid = false;
                            while (!jenisBaruValid) {
                                System.out.print("Jenis Baru: ");
                                String jenisBaru = scanner.nextLine();
                                
                                if (jenisBaru.length() > 20) {
                                    System.out.println("Error: Jenis pet tidak boleh lebih dari 20 karakter.");
                                    continue;
                                }
                                
                                if (hanyaHurufDanSpasi(jenisBaru)) {
                                    pet[2] = jenisBaru;
                                    jenisBaruValid = true;
                                } else {
                                    System.out.println("Error: Jenis pet hanya boleh mengandung huruf dan spasi.");
                                }
                            }
                            
                            boolean umurBaruValid = false;
                            while (!umurBaruValid) {
                                System.out.print("Umur: ");
                                String umurBaru = scanner.nextLine();
                                
                                if (umurBaru.length() > 2) {
                                    System.out.println("Error: Umur tidak boleh lebih dari 2 digit dan harus angka.");
                                    continue;
                                }
                                
                                if (hanyaAngka(umurBaru)) {
                                    try {
                                        int umur = Integer.parseInt(umurBaru);
                                        
                                        if (umur < 0 || umur > 30) {
                                            System.out.println("Error: Umur harus antara 0 dan 30 tahun.");
                                            continue;
                                        }
                                        
                                        pet[3] = umurBaru;
                                        umurBaruValid = true;
                                    } catch (NumberFormatException e) {
                                        System.out.println("Error: Format angka tidak valid. Silakan masukkan angka yang benar.");
                                    }
                                } else {
                                    System.out.println("Error: Umur hanya boleh mengandung angka.");
                                }
                            }
                            
                            boolean pemilikBaruValid = false;
                            while (!pemilikBaruValid) {
                                System.out.print("Pemilik Baru: ");
                                String pemilikBaru = scanner.nextLine();
                                
                                if (pemilikBaru.length() > 40) {
                                    System.out.println("Error: Nama pemilik tidak boleh lebih dari 40 karakter.");
                                    continue;
                                }
                                
                                if (hanyaHurufDanSpasi(pemilikBaru)) {
                                    pet[4] = pemilikBaru;
                                    pemilikBaruValid = true;
                                } else {
                                    System.out.println("Error: Nama pemilik hanya boleh mengandung huruf dan spasi.");
                                }
                            }
                            
                            System.out.println("Data pet berhasil diupdate!");
                            cocok = true;
                            break;
                        }
                    }
                    
                    if (!cocok) {
                        System.out.println("Pet dengan ID " + updateId + " tidak ada, min!");
                    }
                    break;
                    
                case 4:
                    // INI DELETE WOOOOOOOOIIII
                    System.out.println("\n--- Hapus Data Pet ---");
                    System.out.print("Masukkan ID pet yang akan dihapus: ");
                    String deleteId = scanner.nextLine();
                    boolean hapus = false;
                    
                    for (int i = 0; i < pets.size(); i++) {
                        if (pets.get(i)[0].equals(deleteId)) {
                            String[] deletedPet = pets.remove(i);
                            System.out.println("Pet dengan ID " + deleteId + " (" + deletedPet[1] + ") berhasil dihapus!");
                            hapus = true;
                            break;
                        }
                    }
                    
                    if (!hapus) {
                        System.out.println("Pet dengan ID " + deleteId + " tidak ada, min!");
                    }
                    break;
                    
                case 0:
                	// INI KELUAR WOIIIIIIIIIII
                    System.out.println("Program selesai. See you soon Mimin!");
                    break;
                    
                default:
                    System.out.println("Pilihan tidak valid, min! Silakan pilih 0-4.");
            }
        } while (pilihan != 0);
        
        scanner.close();
    }
}
```
</details>

## 🖥️ Penjelasan Alur Program
<details>
<summary><h3>Menu Utama</h3></summary>

<div align="center">
  <img src="https://github.com/user-attachments/assets/160529b6-3faa-4619-a260-b163aa4f6c1e" alt="" width="500px">
</div>

<p align="justify">Gambar di atas merupakan tampilan menu utama program ketika pertama dijalankan.</p>

**1. Jika input tidak valid**
<div align="center">
  <img src="https://github.com/user-attachments/assets/f3498574-ac7e-4051-9a81-2c6808623bb8" alt="" width="500px">
</div>

<p align="justify">Jika pengguna menginput di luar daripada opsi (0-4) di menu utama, maka akan ada dialog teks seperti pada gambar di atas. Menu akan diulang, pengguna diminta untuk menginput lagi.</p>

**2. Jika opsi 0(Keluar) dipilih**
<div align="center">
  <img src="https://github.com/user-attachments/assets/17ec4145-6c43-4fd0-a33c-2ef6d7d46657" alt="" width="500px">
</div>

<p align="justify">Program akan berhenti berjalan jika pengguna menginput opsi untuk keluar (0). Menu akan berhenti berulang, program selesai.</p>

</details>

<details>
<summary><h3>Menambah Data Pet</h3></summary>

**1. Validasi input dan jika berupa selain huruf dan spasi**
<div align="center">
  <img src="https://github.com/user-attachments/assets/b80c4e30-3f77-4224-8042-927d36d062fb" alt="" width="500px">
</div>

<p align="justify">Jika pengguna mengisi field input nama pet, jenis, dan nama pemilik dengan angka. Maka, akan muncul dialog teks di atas. Pengguna diminta mengulang inputnya.</p>

**2. Validasi input dan jika lebih dari jumlah karakter yang ditentukan**
<div align="center">
  <img src="https://github.com/user-attachments/assets/0e9d08cc-c6d7-4a1b-90a5-4ec632b2fc40" alt="" width="500px">
</div>

<p align="justify">Jika pengguna mengisi field input nama pet dengan karakter lebih dari 30, jenis lebih dari 20, dan nama pemilik lebih dari 40 karakter. Maka, akan muncul dialog teks di atas. Pengguna diminta mengulang inputnya hingga validasi sukses.</p>

**3. Validasi input dan jika umur lebih dari 2 digit atau berupa selain angka**
<div align="center">
  <img src="https://github.com/user-attachments/assets/3042bf6c-fc79-41ad-b6d0-3c27d1fee06a" alt="" width="500px">
</div>

<p align="justify">Jika pengguna menginput lebih dari 3 digit angka atau memasukkan huruf pada field input umur. Maka, akan muncul dialog teks seperti pada gambar di atas.</p>

**4. Validasi input dan jika umur di luar rentang 0-30 tahun**
<div align="center">
  <img src="https://github.com/user-attachments/assets/dcd1329d-d8ca-4a34-9b85-ef5ca8b74d51" alt="" width="500px">
</div>

<p align="justify">Jika pengguna memasukkan umur pet di bawah 0 atau lebih dari 30 tahun, maka akan diminta input ulang.</p>

**5. Berhasil menambah data**
<div align="center">
  <img src="https://github.com/user-attachments/assets/4805e553-e2fa-4d30-9019-6c85aad5afa3" alt="" width="500px">
</div>

<p align="justify">Pada gambar di atas merupakan tampilan apabila proses penambahan data pet berhasil.</p>

</details>

<details>
<summary><h3>Melihat Data Pet</h3></summary>

**1. Jika data pet pada ArrayList masih kosong**
<div align="center">
  <img src="https://github.com/user-attachments/assets/bf990e63-b24d-4c18-82a5-d06b7f12f08e" alt="" width="500px">
</div>

<p align="justify">Akan muncul teks seperti pada gambar di atas jika ArrayList masih kosong.</p>

**2. Tampilan daftar pet jika memiliki data**
<div align="center">
  <img src="https://github.com/user-attachments/assets/dee21aad-ba92-4776-8112-85424dfece3e" alt="" width="500px">
</div>

</details>

<details>
<summary><h3>Memperbarui Data Pet</h3></summary>

**1. Validasi ID dan jika gagal**
<div align="center">
  <img src="https://github.com/user-attachments/assets/64e5fc8c-6b99-430b-80b2-d836fca3e4ca" alt="" width="500px">
</div>

<p align="justify">Jika pengguna memasukkan id yang tidak ada atau tidak cocok dengan yang ada pada ArrayList. Maka, akan muncul teks seperti pada gambar.</p>

**2. Tampilan pembaruan data pet jika berhasil**
<div align="center">
  <img src="https://github.com/user-attachments/assets/e7fa40c6-8ef8-467d-a361-3efef7c821ca" alt="" width="500px">
</div>

<p align="justify">Perlu diketahui, bahwa logika dan proses validasi input seperti batas karakter, rentang umur, dll. pada bagian update ini kurang lebih sama dengan yang ada pada proses penambahan data pet. Bedanya, hanya di cara penyimpanannya di ArrayList menggunakan variabel khusus untuk bagian update. Pada gambar di atas merupakan tampilan jika pembaruan data pet berhasil.</p>

</details>

<details>

<summary><h3>Menghapus Data Pet</h3></summary>

**1. Validasi ID dan jika gagal**
<div align="center">
  <img src="https://github.com/user-attachments/assets/ae6042d6-9e36-43b4-aec3-7a0077e32df5" alt="" width="500px">
</div>

<p align="justify">Sama seperti di bagian update, pengguna diminta memasukkan ID pet, dan jika proses validasi gagal. Maka akan diminta input ulang.</p>

**2. Jika data pet berhasil dihapus**
<div align="center">
  <img src="https://github.com/user-attachments/assets/2bfe34c2-344e-42b7-bf99-91809a0ea644" alt="" width="500px">
</div>

<p align="justify">Jika proses validasi berhasil (ID cocok dengan data dalam ArrayList). Maka, data berhasil dihapus.</p>

</details>


---
> [!NOTE]
> **🎉 Terimakasih! 🎉**
> Vouloir, c’est pouvoir. 🙏

---
[⬆️ Kembali ke Atas](#top)
