package test.rptbean;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class TestSaleBeanList {
	
	public Iterator<SaleBean> getSaleIter(int cnt) {
		ArrayList<SaleBean> sale_list = new ArrayList<SaleBean>();
		this._fillData(sale_list, cnt);
		
		return sale_list.iterator();
	}
	
	private void _fillData(ArrayList<SaleBean> saleList, int cnt) {
		Random rand = new Random(100);
		int rand_min = 100, rand_max = 1000;
		
		int year=0, month = 0;
		float count = 0;
		for(int ix=0; ix<cnt; ix++) {
			year = 1990 + ix / 12;
			month = 1 + ix % 12;
			
			for(int areaix=0; areaix<5; areaix++) {
				SaleBean bean = new SaleBean(year, month, "地区_"+areaix);
				saleList.add(bean);
				
				count = rand_min + rand.nextInt(rand_max - rand_min + 1);
				bean.setCount(count);
			}
		}
	}
}
