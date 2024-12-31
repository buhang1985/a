package iih.bd.mm.iemsg.qry;

import java.util.ArrayList;

import iih.bd.mm.iemsg.d.MeasdocDTO;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.xbd.measdoc.d.MeasDocDO;

public class MeasdocEventSql {

	public MeasdocDTO[] setByStatu(MeasDocDO[] mealist,String eventtype) {
		
		ArrayList<MeasdocDTO> rtn=new ArrayList<MeasdocDTO>();
		
		//遍历
		for(MeasDocDO meado: mealist ){
			
			MeasdocDTO measDTO = new MeasdocDTO();
			measDTO.setId_meas(meado.getId_measdoc());
			measDTO.setCode(meado.getCode());
			measDTO.setName(meado.getName());
			measDTO.setPycode(meado.getPycode());
			
			if(IEventType.TYPE_UPDATE_AFTER.equals(eventtype))
			{
				measDTO.setMessagetype("update");								
			}else if(IEventType.TYPE_INSERT_AFTER.equals(eventtype)){
				
				measDTO.setMessagetype("insert");								
			} else if(IEventType.TYPE_DELETE_AFTER.equals(eventtype)){	
				
				measDTO.setMessagetype("delete");								
			} else{				
				continue;
			}
			rtn.add(measDTO);
		}
		
		return rtn.toArray(new MeasdocDTO[0]);
	}

}
