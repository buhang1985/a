package iih.bd.mm.iemsg.qry;

import java.util.ArrayList;

import iih.bd.mm.iemsg.d.WarehouseDTO;
import iih.bd.res.warehouse.d.WarehouseDO;
import xap.sys.appfw.businessevent.IEventType;

public class WarehouseSql {

	public WarehouseDTO[] setByStatu(WarehouseDO[] newObjs,String eventtype) {
		
		ArrayList<WarehouseDTO> rtn=new ArrayList<WarehouseDTO>();
		
		//遍历
		for(WarehouseDO waredo: newObjs ){
			
			WarehouseDTO warehouseDTO = new WarehouseDTO();
			warehouseDTO.setId_wh(waredo.getId_wh());
			warehouseDTO.setWh_code(waredo.getCode());
			warehouseDTO.setDep_code(waredo.getDep_code());
			warehouseDTO.setWh_name(waredo.getName());
			warehouseDTO.setPycode(waredo.getPycode());
			if(IEventType.TYPE_UPDATE_AFTER.equals(eventtype))
			{
				warehouseDTO.setMessagetype("update");								
			}else if(IEventType.TYPE_INSERT_AFTER.equals(eventtype)){
				
				warehouseDTO.setMessagetype("insert");								
			} else if(IEventType.TYPE_DELETE_AFTER.equals(eventtype)){	
				
				warehouseDTO.setMessagetype("delete");								
			} else{				
				continue;
			}
			
			rtn.add(warehouseDTO);
		}
		
		return rtn.toArray(new WarehouseDTO[0]);
	}

}
