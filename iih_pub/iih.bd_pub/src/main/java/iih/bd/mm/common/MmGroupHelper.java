package iih.bd.mm.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.bc.udi.pub.IBdMmDictCodeConst;
import iih.bd.mm.mmgrp.d.MmGrpDO;
import iih.bd.mm.mmgrp.i.IMmgrpRService;
import iih.bd.mm.mmgrpitm.d.MmGrpItmDO;
import iih.bd.mm.mmgrpitm.i.IMmgrpitmRService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

public class MmGroupHelper {
	
	public static Map<String, List<String>> getMmGroupLsit(String[] id_mms) throws BizException {
		Map<String, List<String>> result = new HashMap<String, List<String>>();
		if(id_mms == null || id_mms.length <= 0) {
			return result;
		}
		IMmgrpitmRService mmgrpItmRService = ServiceFinder.find(IMmgrpitmRService.class);
		IMmgrpRService mmgrpRService = ServiceFinder.find(IMmgrpRService.class);
		MmGrpItmDO[] groupItemDOS = mmgrpItmRService.findByAttrValStrings(MmGrpItmDO.ID_MM, id_mms);
		if(groupItemDOS == null || groupItemDOS.length <= 0) {
			return result;
		}
		Map<String, Map<String, MmGrpItmDO>> itemMap = new HashMap<String, Map<String, MmGrpItmDO>>();
		for(MmGrpItmDO itemDO : groupItemDOS) {
			if(itemMap.containsKey(itemDO.getId_mmgrp())) {
				Map<String, MmGrpItmDO> mmMap = itemMap.get(itemDO.getId_mmgrp());
				mmMap.put(itemDO.getId_mm(), itemDO);
			} else {
				Map<String, MmGrpItmDO> mmMap = new HashMap<String, MmGrpItmDO>();
				mmMap.put(itemDO.getId_mm(), itemDO);
				itemMap.put(itemDO.getId_mmgrp(), mmMap);
			}
		}
		MmGrpDO[] groupDOS = mmgrpRService.findByBIds(itemMap.keySet().toArray(new String[0]), FBoolean.TRUE);
		if(groupDOS == null || groupDOS.length <= 0) {
			return result;
		}
		for(MmGrpDO groupDO : groupDOS) {
			if(!groupDO.getFg_active().booleanValue()) {
				continue;
			}
			Map<String, MmGrpItmDO> mmMap = itemMap.get(groupDO.getId_mmgrp());
			for(String id_mm : mmMap.keySet()) {
				if(result.containsKey(id_mm)) {
					List<String> groupTpList = result.get(id_mm);
					groupTpList.add(groupDO.getSd_mmgrptp());
				} else {
					List<String> groupTpList = new ArrayList<String>();
					groupTpList.add(groupDO.getSd_mmgrptp());
					result.put(id_mm, groupTpList);
				}
			}
		}
		return result;
	}
	
	public static FBoolean isMmDeductionGroup(String id_mm, Map<String, List<String>> groupMap) throws BizException {
		if(groupMap == null || groupMap.size() <= 0) {
			return FBoolean.FALSE;
		}
		if(!groupMap.containsKey(id_mm)) {
			return FBoolean.FALSE;
		}
		List<String> groupList = groupMap.get(id_mm);
		if(groupList.contains(IBdMmDictCodeConst.SD_MMGRPTP_DEDUCTION)) {
			return FBoolean.TRUE;
		}
		return FBoolean.FALSE;
	}
}
