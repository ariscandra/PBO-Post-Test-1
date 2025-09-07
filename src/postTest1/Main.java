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