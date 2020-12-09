import java.util.Random;
import java.util.Scanner;

public class MAÝN {
	static Random r = new Random();

	public static void yerleþtirme(int sayi, OTOPARK oto, ARABA minibus,int s) {

		for (int i = 0; i <sayi; i++) {
			int j = r.nextInt(20);

			if (oto.yeri[j] == 1) {
				i--;
			} else
				oto.yeri[j] = 1;
		}
		for (int i = 0; i < minibus.sayi; i++) {
			int j = r.nextInt(20);
			if(minibus.sayi>s) {
				System.out.println("fazla minibus geldi");
				break;
			}

			if (oto.yeri[j] == 2) {
				i--;
			}

			else if (oto.yeri[j] == 1) {
				i--;
			} else
				oto.yeri[j] = 2;
		}
	}

	public static void yazdirma(OTOPARK oto) {
		for (int i = 0; i < 20; i++) {
			if (oto.yeri[i] == 0)
				System.out.println(i + ". indisinin yerinde arac yok");
			else if (oto.yeri[i] == 1)
				System.out.println(i + ". indisin yerinde araba var");
			else
				System.out.println(i + ". indisin yerinde mini var");
		}
	}

	public static void main(String[] args) {
		Scanner klavye = new Scanner(System.in);

		OTOPARK otoparkyeri = new OTOPARK();
		System.out.println("mini oto yeri sayisini giriniz");
		int s = klavye.nextInt();
		System.out.println("park edecek araba sayisini giriniz");
		int sayi = klavye.nextInt();
		ARABA araclar = new ARABA(sayi);
		System.out.println("park edecek minibus sayisini giriniz");
		int sayi2 = klavye.nextInt();
		ARABA minibus = new ARABA(sayi2);
		if((20-s)==0)
			System.out.println("yeterli alan yok araç park etmeye");
		else {
		yerleþtirme(sayi, otoparkyeri, minibus,s);
		yazdirma(otoparkyeri);
		}

	}

}
