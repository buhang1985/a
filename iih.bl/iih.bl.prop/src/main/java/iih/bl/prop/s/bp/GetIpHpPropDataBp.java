package iih.bl.prop.s.bp;

import iih.bl.prop.blproparip.d.BlPropArIpDO;
import iih.bl.prop.blproparip.d.BlproparipAggDO;
import iih.bl.prop.blproparip.d.desc.BlPropArIpDODesc;
import iih.bl.prop.blproparip.i.IBlproparipRService;
import iih.bl.prop.blproparoep.d.BlproparoepAggDO;
import iih.bl.prop.blpropip.d.BlPropIpDO;
import iih.bl.prop.blpropip.i.IBlpropipRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap2;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 获取原住院分摊信息
 * @author yangyang
 *
 */
public class GetIpHpPropDataBp {

	@SuppressWarnings("unchecked")
	public FMap2 exec(String id_stoep) throws BizException {
		//1、分摊结算关系表
		IBlpropipRService propService = ServiceFinder.find(IBlpropipRService.class);
		BlPropIpDO[] propDos = propService.findByAttrValString(BlPropIpDO.ID_STIP, id_stoep);
		if(ArrayUtil.isEmpty(propDos)) {
			throw new BizException("未查询到对应的医保结算分摊数据！");
		}
		//2、分摊AGGDO
		IBlproparipRService propArService = ServiceFinder.find(IBlproparipRService.class);
		String strWhere = BlPropArIpDODesc.TABLE_ALIAS_NAME + ".ID_PROPIP='" + propDos[0].getId_propip() + "'";
		BlproparipAggDO[] propArIpAggDoArr = propArService.find(strWhere, "", FBoolean.FALSE);
		
		FMap2 map = new FMap2();
		map.put("PropIp",propDos[0]);
		map.put("PropArIpAgg",propArIpAggDoArr[0]);		
		return map;		
	}
}
