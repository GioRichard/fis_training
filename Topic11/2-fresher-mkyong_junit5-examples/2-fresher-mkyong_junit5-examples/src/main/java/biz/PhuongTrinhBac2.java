package biz;

public class PhuongTrinhBac2 {
	private int a;
	private int b;
	private int c;
	
	public PhuongTrinhBac2(int a, int b, int c) 
			throws IllegalArgumentException 
	{
		super();
		if (this.a == 0) throw new IllegalArgumentException();
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	/*
	 * 1. 2 nghiem phan biet
	 * 2. 1 nghiem kep
	 * 3. vo nghiem
	 * 4. vo so nghiem 
	 */
	public Nghiem tinhNghiem() {
		return null;
	}
	
	public enum KetQua{
		HAI_NGHIEM,
		MOT_NGHIEM_KEP,
		VO_NGHIEM,
		VO_SO_NGHIEM
	}
	
	public class Nghiem {
		private KetQua ketQua; 
		private double nghiem1;
		private double nghiem2;
		
		public KetQua getKetQua() {
			return ketQua;
		}
		public void setKetQua(KetQua ketQua) {
			this.ketQua = ketQua;
		}
		public double getNghiem1() {
			return nghiem1;
		}
		public void setNghiem1(double nghiem1) {
			this.nghiem1 = nghiem1;
		}
		public double getNghiem2() {
			return nghiem2;
		}
		public void setNghiem2(double nghiem2) {
			this.nghiem2 = nghiem2;
		}
		
		
	}
}
