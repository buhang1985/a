package iih.mm.common;

import iih.bd.bc.udi.pub.IBdMmDictCodeConst;
import iih.bd.mm.common.CalOperation;
import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.mm.meterial.i.ds.IMeterialService;
import iih.mm.bl.stockbl.d.StockBlDO;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

public class CompareMmBlBp {
	
	public static void exec(String id_mm, List<StockBlDO> blList) throws BizException {
		
		IMeterialService meterialService = ServiceFinder.find(IMeterialService.class);
		
		MeterialDO mmDO = meterialService.findMaterialByID(id_mm);
		if(mmDO.getFg_batch().booleanValue()) {
			
			if(IBdMmDictCodeConst.SD_OUTMODE_FIFO.equals(mmDO.getSd_outmode())) {
			
				//先进先出
				fifoOut(blList, FBoolean.FALSE);
			} else if(IBdMmDictCodeConst.SD_OUTMODE_PERIOD.equals(mmDO.getSd_outmode())) {
				
				//效期优先
				periodOut(blList, FBoolean.FALSE);
			} else if(IBdMmDictCodeConst.SD_OUTMODE_LILO.equals(mmDO.getSd_outmode())) {
				
				//后进先出
				liloOut(blList);
			} else {
				
				//默认先进先出
				fifoOut(blList, FBoolean.FALSE);
			}
		} else {
			
			//默认可用数量大的库存优先出库
			maxNumOut(blList);
		}
	}
	
	private static void fifoOut(List<StockBlDO> blList, FBoolean fg_periodSame) {
		
		for(int i = 0; i < blList.size(); i++) {
			
			StockBlDO blDO_i = blList.get(i);
			for(int j = i + 1; j < blList.size(); j++) {
				
				StockBlDO blDO_j = blList.get(j);
				if(blDO_j.getDate_expi() == null && blDO_i.getDate_expi() == null && 
						StringUtils.isBlank(blDO_j.getBatch()) && StringUtils.isBlank(blDO_i.getBatch())) {
					continue;
				}
				if(blDO_i.getFg_expired().booleanValue() && !blDO_j.getFg_expired().booleanValue()) {
					blList.set(i, blDO_j);
					blList.set(j, blDO_i);
					blDO_i = blList.get(i);
					continue;
				} else if(!blDO_i.getFg_expired().booleanValue() && blDO_j.getFg_expired().booleanValue()) {
					continue;
				}
				if(StringUtils.isBlank(blDO_j.getBatch()) && StringUtils.isBlank(blDO_i.getBatch())) {
					List<StockBlDO> stockList = new ArrayList<StockBlDO>();
					stockList.add(blDO_i);
					stockList.add(blDO_j);
					periodOut(stockList, FBoolean.TRUE);
					blList.set(i, stockList.get(0));
					blList.set(j, stockList.get(1));
					blDO_i = blList.get(i);
				} else if(!StringUtils.isBlank(blDO_j.getBatch()) && StringUtils.isBlank(blDO_i.getBatch())) {
					blList.set(i, blDO_j);
					blList.set(j, blDO_i);
					blDO_i = blList.get(i);
				} else if(StringUtils.isBlank(blDO_j.getBatch()) && !StringUtils.isBlank(blDO_i.getBatch())) {
					continue;
				} else if(blDO_j.getBatch().compareTo(blDO_i.getBatch()) < 0) {
					blList.set(i, blDO_j);
					blList.set(j, blDO_i);
					blDO_i = blList.get(i);
				} else if(blDO_j.getBatch().compareTo(blDO_i.getBatch()) == 0 && !fg_periodSame.booleanValue()) {
					List<StockBlDO> stockList = new ArrayList<StockBlDO>();
					stockList.add(blDO_i);
					stockList.add(blDO_j);
					periodOut(stockList, FBoolean.TRUE);
					blList.set(i, stockList.get(0));
					blList.set(j, stockList.get(1));
					blDO_i = blList.get(i);
				}
			}
		}
	}
	
	private static void periodOut(List<StockBlDO> blList, FBoolean fg_batchSame) {
		
		for(int i = 0; i < blList.size(); i++) {
			
			StockBlDO blDO_i = blList.get(i);
			for(int j = i + 1; j < blList.size(); j++) {
				
				StockBlDO blDO_j = blList.get(j);
				if(blDO_j.getDate_expi() == null && blDO_i.getDate_expi() == null && 
						StringUtils.isBlank(blDO_j.getBatch()) && StringUtils.isBlank(blDO_i.getBatch())) {
					continue;
				}
				if(blDO_i.getFg_expired().booleanValue() && !blDO_j.getFg_expired().booleanValue()) {
					blList.set(i, blDO_j);
					blList.set(j, blDO_i);
					blDO_i = blList.get(i);
					continue;
				} else if(!blDO_i.getFg_expired().booleanValue() && blDO_j.getFg_expired().booleanValue()) {
					continue;
				}
				if(blDO_j.getDate_expi() == null && blDO_i.getDate_expi() == null) {
					List<StockBlDO> stockList = new ArrayList<StockBlDO>();
					stockList.add(blDO_i);
					stockList.add(blDO_j);
					fifoOut(stockList, FBoolean.TRUE);
					blList.set(i, stockList.get(0));
					blList.set(j, stockList.get(1));
					blDO_i = blList.get(i);
				} else if(blDO_j.getDate_expi() != null && blDO_i.getDate_expi() == null) {
					blList.set(i, blDO_j);
					blList.set(j, blDO_i);
					blDO_i = blList.get(i);
				} else if(blDO_j.getDate_expi() == null && blDO_i.getDate_expi() != null) {
					continue;
				} else if(blDO_j.getDate_expi().compareTo(blDO_i.getDate_expi()) < 0) {
					blList.set(i, blDO_j);
					blList.set(j, blDO_i);
					blDO_i = blList.get(i);
				} else if(blDO_j.getDate_expi().compareTo(blDO_i.getDate_expi()) == 0 && !fg_batchSame.booleanValue()) {
					List<StockBlDO> stockList = new ArrayList<StockBlDO>();
					stockList.add(blDO_i);
					stockList.add(blDO_j);
					fifoOut(stockList, FBoolean.TRUE);
					blList.set(i, stockList.get(0));
					blList.set(j, stockList.get(1));
					blDO_i = blList.get(i);
				}
			}
		}
	}

	private static void liloOut(List<StockBlDO> blList) {
		
        for(int i = 0; i < blList.size(); i++) {
			
			StockBlDO blDO_i = blList.get(i);
			for(int j = i + 1; j < blList.size(); j++) {
				
				StockBlDO blDO_j = blList.get(j);
				if(blDO_j.getDate_expi() == null && blDO_i.getDate_expi() == null && 
						StringUtils.isBlank(blDO_j.getBatch()) && StringUtils.isBlank(blDO_i.getBatch())) {
					continue;
				}
				if(blDO_i.getFg_expired().booleanValue() && !blDO_j.getFg_expired().booleanValue()) {
					blList.set(i, blDO_j);
					blList.set(j, blDO_i);
					blDO_i = blList.get(i);
					continue;
				} else if(!blDO_i.getFg_expired().booleanValue() && blDO_j.getFg_expired().booleanValue()) {
					continue;
				}
				if(StringUtils.isBlank(blDO_j.getBatch()) && StringUtils.isBlank(blDO_i.getBatch())) {
					List<StockBlDO> stockList = new ArrayList<StockBlDO>();
					stockList.add(blDO_i);
					stockList.add(blDO_j);
					periodOut(stockList, FBoolean.TRUE);
					blList.set(i, stockList.get(0));
					blList.set(j, stockList.get(1));
					blDO_i = blList.get(i);
				} else if(!StringUtils.isBlank(blDO_j.getBatch()) && StringUtils.isBlank(blDO_i.getBatch())) {
					continue;
				} else if(StringUtils.isBlank(blDO_j.getBatch()) && !StringUtils.isBlank(blDO_i.getBatch())) {
					blList.set(i, blDO_j);
					blList.set(j, blDO_i);
					blDO_i = blList.get(i);
				} else if(blDO_j.getBatch().compareTo(blDO_i.getBatch()) > 0) {
					blList.set(i, blDO_j);
					blList.set(j, blDO_i);
					blDO_i = blList.get(i);
				} else if(blDO_j.getBatch().compareTo(blDO_i.getBatch()) == 0) {
					List<StockBlDO> stockList = new ArrayList<StockBlDO>();
					stockList.add(blDO_i);
					stockList.add(blDO_j);
					periodOut(stockList, FBoolean.TRUE);
					blList.set(i, stockList.get(0));
					blList.set(j, stockList.get(1));
					blDO_i = blList.get(i);
				}
			}
		}
	}

	private static void maxNumOut(List<StockBlDO> blList) {
		
        for(int i = 0; i < blList.size(); i++) {
			
			StockBlDO blDO_i = blList.get(i);
			for(int j = i + 1; j < blList.size(); j++) {
				
				StockBlDO blDO_j = blList.get(j);
				if(blDO_i.getFg_expired().booleanValue() && !blDO_j.getFg_expired().booleanValue()) {
					blList.set(i, blDO_j);
					blList.set(j, blDO_i);
					blDO_i = blList.get(i);
					continue;
				} else if(!blDO_i.getFg_expired().booleanValue() && blDO_j.getFg_expired().booleanValue()) {
					continue;
				}
				if(blDO_j.getQuan_usable().compareTo(blDO_i.getQuan_usable()) > 0) {
					
					blList.set(i, blDO_j);
					blList.set(j, blDO_i);
					blDO_i = blList.get(i);
				}
			}
		}
	}
	
    public static String getKeyByWhMm(String id_wh, String id_mm, String onlyCode, String batch, FDate expi, FDouble pri_act_base, FDouble pri_sale) throws BizException {
		
		IMeterialService materialSrv = ServiceFinder.find(IMeterialService.class);
		
		MeterialDO mmDO = materialSrv.findMaterialByID(id_mm);
		String key = id_wh + " " + id_mm + " ";
		//进价_基本单位
		key = key + CalOperation.RoundBlPrice(pri_act_base) + " ";
		//售价_零售单位
		key = key + CalOperation.RoundBlPrice(pri_sale) + " ";
		//唯一码
		if(StringUtils.isBlank(onlyCode)) {
			
			key = key + " ";
		} else {
			
			key = key + onlyCode + " ";
		}
		//批次
		if(mmDO.getFg_batch().booleanValue() && !StringUtils.isBlank(batch)) {
			
			key = key + batch + " ";
		} else {
			
			key = key + " ";
		}
		//失效期
		if(mmDO.getFg_effective().booleanValue() && expi != null) {
			
			key = key + expi + " ";
		} else {
			
			key = key + " ";
		}
		
		return key;
	}
}
