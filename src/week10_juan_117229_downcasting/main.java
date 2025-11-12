package week10_juan_117229_downcasting;

import week10_juan_117229.Pekerja;

public class main {
	
    public static void main(String[] args) {
    	
        // contoh downcasting
        CEO c = new CEO();
        Pekerja p = new CEO();
        c = (CEO) p;
        c.tanyaPendapatan();
    }
}