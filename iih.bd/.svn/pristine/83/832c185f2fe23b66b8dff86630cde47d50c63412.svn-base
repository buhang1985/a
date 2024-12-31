package iih.bd.mm.iemsg.qry;

import java.util.ArrayList;

import iih.bd.mm.iemsg.d.PricemmDTO;
import iih.mm.st.stockpriceadjust.d.StockPriceAdjustDO;
import xap.sys.appfw.businessevent.IEventType;

public class MmPriceSql {

	public PricemmDTO[] setByStatu(StockPriceAdjustDO[] newObjs,String eventtype) {
		ArrayList<PricemmDTO> rtn=new ArrayList<PricemmDTO>();
		
		//遍历
		for(StockPriceAdjustDO prido: newObjs ){
			//if(!eventtype.equals("4150907"))continue;
								
			PricemmDTO mmpriDTO = new PricemmDTO();
			mmpriDTO.setId_mm(prido.getId_mm());
			mmpriDTO.setCode(prido.getMm_code());
			mmpriDTO.setId_unit_pkgsp(prido.getId_mmpkgu_sales());
			mmpriDTO.setName(prido.getMm_name());
			mmpriDTO.setPri_new_sales(prido.getPri_new_sales());
			mmpriDTO.setDt_pri(prido.getDt_pri().getDate());
			
			if(IEventType.TYPE_UPDATE_AFTER.equals(eventtype))
			{
				mmpriDTO.setMessagetype("update");								
			}else if(IEventType.TYPE_INSERT_AFTER.equals(eventtype)){
				
				mmpriDTO.setMessagetype("insert");								
			} else if(IEventType.TYPE_DELETE_AFTER.equals(eventtype)){	
				
				mmpriDTO.setMessagetype("delete");								
			} else if(eventtype.equals("4150907")){	
				
				mmpriDTO.setMessagetype("update");								
			} else{				
				continue;
			}
			
			rtn.add(mmpriDTO);	
		}				
		return rtn.toArray(new PricemmDTO[0]);
	}

}
