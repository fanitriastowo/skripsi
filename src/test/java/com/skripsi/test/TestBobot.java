package com.skripsi.test;

public class TestBobot {

	public static void main(String[] args) {

		final byte jumlahSiswaBobot = 4;
		final byte kondisiKelasBObot = 5;
		final byte keaktifanSiswaBobot = 5;
		final byte kualitasPengajarBobot = 5;
		final byte fasilitasBobot = 3;

		// jumlahkan semua bobot
		final byte jumlahBobot = jumlahSiswaBobot + kondisiKelasBObot + 
								 keaktifanSiswaBobot + kualitasPengajarBobot + fasilitasBobot;
		
		// konversi ke float variable diatas
		float nJumlahSiswaBobot = Float.valueOf(jumlahSiswaBobot) / jumlahBobot;
		float nKondisiKelasBobot = Float.valueOf(kondisiKelasBObot) / jumlahBobot;
		float nKeaktifanSiswaBobot = Float.valueOf(keaktifanSiswaBobot) / jumlahBobot;
		float nKualitasPengajarBobot = Float.valueOf(keaktifanSiswaBobot) / jumlahBobot;
		float nFasilitasBobot = Float.valueOf(fasilitasBobot) / jumlahBobot;
		
		System.out.println(nJumlahSiswaBobot);
		System.out.println(nKondisiKelasBobot);
		System.out.println(nKeaktifanSiswaBobot);
		System.out.println(nKualitasPengajarBobot);
		System.out.println(nFasilitasBobot);
		
	}

}
