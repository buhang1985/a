package iih.bl.prop.s.bp;


import iih.bl.prop.blproparoep.d.BlproparoepAggDO;
import iih.bl.prop.blproparoep.d.desc.BlPropArOepDODesc;
import iih.bl.prop.blproparoep.i.IBlproparoepRService;
import iih.bl.prop.blpropoep.d.BlPropOepDO;
import iih.bl.prop.blpropoep.i.IBlpropoepRService;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap;
import xap.mw.core.data.FMap2;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 根据门诊结算id获取医保结算分摊数据
 * 
 * @author liwq
 *
 */
public class GetOepHpPropAggDOBP {

	@SuppressWarnings("unchecked")
	public FMap2 exec(String id_stoep) throws BizException {
		//1、分摊结算关系表
		IBlpropoepRService propService = ServiceFinder.find(IBlpropoepRService.class);
		BlPropOepDO[] propDos = propService.findByAttrValString("Id_stoep", id_stoep);
		if(ArrayUtil.isEmpty(propDos)) {
			throw new BizException("未查询到对应的医保结算分摊数据！");
		}
		//2、分摊AGGDO
		IBlproparoepRService propArService = ServiceFinder.find(IBlproparoepRService.class);
		String strWhere = BlPropArOepDODesc.TABLE_ALIAS_NAME + ".ID_PROPOEP='" + propDos[0].getId_propoep() + "'";
		BlproparoepAggDO[] propArOepAggDoArr = propArService.find(strWhere, "", FBoolean.FALSE);
		
		FMap2 map = new FMap2();
		map.put("PropOep",propDos[0]);
		map.put("PropArOepAgg",propArOepAggDoArr[0]);		
		return map;		
	}
}
