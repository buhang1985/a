package iih.bd.mm.iemsg.qry;

import java.util.ArrayList;

import iih.bd.mm.iemsg.d.MmUdidocDTO;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.xbd.udi.d.UdidocDO;

public class MmUdiEventSql {

	public MmUdidocDTO[] setByStatu(UdidocDO[] udilist,String eventtype) {

		ArrayList<MmUdidocDTO> rtn=new ArrayList<MmUdidocDTO>();
		
		//遍历
		for(UdidocDO mmudido: udilist ){
			
			MmUdidocDTO mmUdiDTO = new MmUdidocDTO();
			mmUdiDTO.setId_udi(mmudido.getId_udidoc());
			mmUdiDTO.setCode(mmudido.getCode());
			mmUdiDTO.setName(mmudido.getName());
			mmUdiDTO.setPycode(mmudido.getPycode());
			
			if(IEventType.TYPE_UPDATE_AFTER.equals(eventtype))
			{
				mmUdiDTO.setMessagetype("update");								
			}else if(IEventType.TYPE_INSERT_AFTER.equals(eventtype)){
				
				mmUdiDTO.setMessagetype("insert");								
			} else if(IEventType.TYPE_DELETE_AFTER.equals(eventtype)){	
				
				mmUdiDTO.setMessagetype("delete");								
			} else{				
				continue;
			}
			rtn.add(mmUdiDTO);
		}
		
		return rtn.toArray(new MmUdidocDTO[0]);
	}

}
