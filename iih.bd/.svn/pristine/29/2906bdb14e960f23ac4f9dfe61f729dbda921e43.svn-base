package iih.bd.res.bed.bp;

import java.util.HashMap;
import java.util.Map;

import iih.bd.res.bed.d.BedAttrDO;
import iih.bd.res.bed.d.BedAttrDefDO;
import iih.bd.res.bed.i.IBedattrdefRService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

public class GetAttrValBP {
	public void exe(BedAttrDO[] aptIpAttrDOs) throws BizException	{
		if(ArrayUtil.isEmpty(aptIpAttrDOs))
			return ;		
		Map<String,BedAttrDefDO> map =  this.ChangAllDataTOMap();//把所有的值都取出来
		if(map == null)
			return;
		for(BedAttrDO attrDO : aptIpAttrDOs ){//
			if(!StringUtil.isEmptyWithTrim(attrDO.getSd_bedattr_tp())&& !StringUtil.isEmptyWithTrim(attrDO.getVal())){	
				BedAttrDefDO bedAttrDefDO = map.get(attrDO.getSd_bedattr_tp()+attrDO.getVal());
				if(bedAttrDefDO == null)
					continue;
				attrDO.setAttrdef_name(bedAttrDefDO.getName());
				attrDO.setId_attrdef(bedAttrDefDO.getId_bedattrdef());
			}
		}
	}
	
	/**
	 * 把值定义全取出来，存在map中避免多次查数据库
	 * @return
	 * @throws BizException
	 */
	private Map<String,BedAttrDefDO>  ChangAllDataTOMap() throws BizException
	{
		IBedattrdefRService attrService = ServiceFinder.find(IBedattrdefRService.class);
		BedAttrDefDO[] attrDefDOs= attrService.find("1=1", "", FBoolean.FALSE);
		if(ArrayUtil.isEmpty(attrDefDOs)){
			return null;
		}
		Map<String,BedAttrDefDO> map = new HashMap<String,BedAttrDefDO>();
		for(BedAttrDefDO attrDef :attrDefDOs){
			map.put(attrDef.getSd_bedattr_tp()+attrDef.getVal(), attrDef);
		}
		
		return map;
	}
	 /** @Override
	    public AptIpAttrDO[] find(String whereStr, String orderStr, FBoolean isLazy)
	    		throws BizException {
	    	// TODO Auto-generated method stub
	    	AptIpAttrDO[] aptIpAttrDOs = super.find(whereStr, orderStr, isLazy);
	    	if(ArrayUtil.isEmpty(aptIpAttrDOs))
	    		return null;
	    	GetValForAptIpAttrDOBP getvalBP = new GetValForAptIpAttrDOBP();
	    	getvalBP.exe(aptIpAttrDOs);
	    	return aptIpAttrDOs;
	    }
	    **/
}
