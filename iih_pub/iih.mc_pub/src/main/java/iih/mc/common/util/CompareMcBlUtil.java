package iih.mc.common.util;

import java.util.List;

import iih.bd.bc.udi.pub.IBdMmDictCodeConst;
import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.mm.meterial.i.ds.IMeterialService;
import iih.mc.bl.stockbl.d.McStockBlDO;
import iih.mm.bl.stockbl.d.StockBlDO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;



public class CompareMcBlUtil {

	public static void exec(String id_mm, List<McStockBlDO> blList) throws BizException {

		IMeterialService meterialService = ServiceFinder.find(IMeterialService.class);
		
		MeterialDO mmDO = meterialService.findMaterialByID(id_mm);
		if(mmDO.getFg_batch().booleanValue()) {
			
			if(IBdMmDictCodeConst.SD_OUTMODE_FIFO.equals(mmDO.getSd_outmode())) {
			
				//先进先出
				fifoOut(blList);
			} else if(IBdMmDictCodeConst.SD_OUTMODE_PERIOD.equals(mmDO.getSd_outmode())) {
				
				//效期优先
				periodOut(blList);
			} else if(IBdMmDictCodeConst.SD_OUTMODE_LILO.equals(mmDO.getSd_outmode())) {
				
				//后进先出
				liloOut(blList);
			} else {
				
				//默认先进先出
				fifoOut(blList);
			}
		} else {
			
			//默认可用数量大的库存优先出库
			maxNumOut(blList);
		}
	}
	
	private static void fifoOut(List<McStockBlDO> blList) {
		
		for(int i = 0; i < blList.size(); i++) {
			
			McStockBlDO blDO_i = blList.get(i);
			for(int j = i + 1; j < blList.size(); j++) {
				
				McStockBlDO blDO_j = blList.get(j);
                if(blDO_j.getBatch() == null && blDO_i.getBatch() == null) {
					
					continue;
				} else if(blDO_j.getBatch() != null && blDO_i.getBatch() == null) {
					
					blList.set(i, blDO_j);
					blList.set(j, blDO_i);
					blDO_i = blList.get(i);
				} else if(blDO_j.getBatch() == null && blDO_i.getBatch() != null) {
					
					continue;
				} else if(blDO_j.getBatch().compareTo(blDO_i.getBatch()) < 0) {
					
					blList.set(i, blDO_j);
					blList.set(j, blDO_i);
					blDO_i = blList.get(i);
				}
			}
		}
	}
	
	private static void periodOut(List<McStockBlDO> blList) {
		
		for(int i = 0; i < blList.size(); i++) {
			
			McStockBlDO blDO_i = blList.get(i);
			for(int j = i + 1; j < blList.size(); j++) {
				
				McStockBlDO blDO_j = blList.get(j);
				if(blDO_j.getDate_expi() == null && blDO_i.getDate_expi() == null) {
					
					continue;
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
				}
			}
		}
	}

	private static void liloOut(List<McStockBlDO> blList) {
		
        for(int i = 0; i < blList.size(); i++) {
			
        	McStockBlDO blDO_i = blList.get(i);
			for(int j = i + 1; j < blList.size(); j++) {
				
				McStockBlDO blDO_j = blList.get(j);
				 if(blDO_j.getBatch() == null && blDO_i.getBatch() == null) {
						
						continue;
					} else if(blDO_j.getBatch() != null && blDO_i.getBatch() == null) {
						
						blList.set(i, blDO_j);
						blList.set(j, blDO_i);
						blDO_i = blList.get(i);
					} else if(blDO_j.getBatch() == null && blDO_i.getBatch() != null) {
						
						continue;
					} else if(blDO_j.getBatch().compareTo(blDO_i.getBatch()) > 0) {
					
					blList.set(i, blDO_j);
					blList.set(j, blDO_i);
					blDO_i = blList.get(i);
				}
			}
		}
	}

	private static void maxNumOut(List<McStockBlDO> blList) {
		
        for(int i = 0; i < blList.size(); i++) {
			
        	McStockBlDO blDO_i = blList.get(i);
			for(int j = i + 1; j < blList.size(); j++) {
				
				McStockBlDO blDO_j = blList.get(j);
				if(blDO_j.getQuan_usable().compareTo(blDO_i.getQuan_usable()) > 0) {
					
					blList.set(i, blDO_j);
					blList.set(j, blDO_i);
					blDO_i = blList.get(i);
				}
			}
		}
	}
}
