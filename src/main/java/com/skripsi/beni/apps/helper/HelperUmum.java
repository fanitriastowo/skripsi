package com.skripsi.beni.apps.helper;

import java.math.BigDecimal;

public class HelperUmum {

	/**
	 * Gunakan method ini untuk membuat angka dibelakang koma sesuai keinginan
	 * 
	 * @param bilangan desimalnya
	 * @param berapa angka dibelakang koma
	 * @return round
	 */
	public static double angkaBelakangKoma(double x, int scale) {
		return round(x, scale, BigDecimal.ROUND_HALF_EVEN);
	}

	public static double round(double x, int scale, int roundingMethod) {
		try {
			return (new BigDecimal(Double.toString(x)).setScale(scale, roundingMethod)).doubleValue();
		} catch (NumberFormatException ex) {
			if (Double.isInfinite(x)) {
				return x;
			} else {
				return Double.NaN;
			}
		}
	}
}
