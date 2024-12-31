package iih.bd.mm.iemsg.qry;

import java.util.ArrayList;

import iih.bd.mm.iemsg.d.SuppliersDTO;
import iih.bd.mm.supplier.d.SupplierDO;
import xap.sys.appfw.businessevent.IEventType;

public class SuppliEventSql {


	public SuppliersDTO[] setByStatu(SupplierDO[] suplist,String eventtype) {

		ArrayList<SuppliersDTO> rtn=new ArrayList<SuppliersDTO>();
		
		//遍历
		for(SupplierDO supdo: suplist ){
			
			SuppliersDTO supDTO = new SuppliersDTO();
			supDTO.setId_sup(supdo.getId_sup());
			supDTO.setCode(supdo.getCode());
			supDTO.setName(supdo.getName());
			supDTO.setPycode(supdo.getPycode());
			supDTO.setPostcode(supdo.getPostcode());
			supDTO.setAddr(supdo.getAddr());
			supDTO.setTel(supdo.getTel());
			supDTO.setMmrange(supdo.getMmrange());
			supDTO.setDes(supdo.getDes());
			supDTO.setLinkman(supdo.getLinkman());						
			
			if(IEventType.TYPE_UPDATE_AFTER.equals(eventtype))
			{
				supDTO.setMessagetype("update");								
			}else if(IEventType.TYPE_INSERT_AFTER.equals(eventtype)){
				
				supDTO.setMessagetype("insert");								
			} else if(IEventType.TYPE_DELETE_AFTER.equals(eventtype)){	
				
				supDTO.setMessagetype("delete");								
			} else{				
				continue;
			}
			rtn.add(supDTO);
		}
		
		return rtn.toArray(new SuppliersDTO[0]);
	}

}
