package iih.bd.mm.iemsg.qry;

import java.util.ArrayList;

import iih.bd.mm.iemsg.d.MmcaEventDTO;
import iih.bd.mm.mmcategory.d.MMCategoryDO;
import xap.sys.appfw.businessevent.IEventType;


public class MmcaEventSql {

	public MmcaEventDTO[] setByStatu(MMCategoryDO[] mmcalist,String eventtype) {
	
		ArrayList<MmcaEventDTO> rtn=new ArrayList<MmcaEventDTO>();
		
		//遍历
		for(MMCategoryDO mmcado: mmcalist ){
			
			MmcaEventDTO mmcaDTO = new MmcaEventDTO();
			mmcaDTO.setId_mmca(mmcado.getId_mmca());
			mmcaDTO.setCode(mmcado.getCode());
			mmcaDTO.setName(mmcado.getName());
			mmcaDTO.setPycode(mmcado.getPycode());
			
			if(IEventType.TYPE_UPDATE_AFTER.equals(eventtype))
			{
				mmcaDTO.setMessagetype("update");								
			}else if(IEventType.TYPE_INSERT_AFTER.equals(eventtype)){
				
				mmcaDTO.setMessagetype("insert");								
			} else if(IEventType.TYPE_DELETE_AFTER.equals(eventtype)){	
				
				mmcaDTO.setMessagetype("delete");								
			} else{				
				continue;
			}
			
			rtn.add(mmcaDTO);
		}
		
		return rtn.toArray(new MmcaEventDTO[0]);
	}

}
