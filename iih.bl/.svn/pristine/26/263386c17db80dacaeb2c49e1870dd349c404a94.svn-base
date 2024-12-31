package iih.bl.cg.ip.s.bp;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.pp.feeprojectrejectplan.d.ExclusiveDetailDO;
import iih.bd.pp.feeprojectrejectplan.i.IExclusiveDetailDORService;
import iih.bd.pp.priusg.d.PriUsgDO;
import iih.bd.pp.priusg.d.desc.PriUsgDODesc;
import iih.bd.pp.priusg.i.IPriusgRService;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 用法关联费用接口
 * @author yangyang
 * @Date 2017-10-10
 */
public class UsageWithBillStrategyBp {
	public PriUsgDO[] exec(String strIdRoute,String strIdOrg,String strIdDept) throws BizException
	{
		IPriusgRService rservice=ServiceFinder.find(IPriusgRService.class);
		String strSqlCond="";
		//表别名
		String alis=PriUsgDODesc.TABLE_ALIAS_NAME;
		String strSqlOrgid =alis + ".eu_scope='" + IBdSrvDictCodeConst.SD_OWTP_HOSPIAL + "'";
		if (!StringUtil.isEmpty(strIdDept)) {
			String strSqlDept = alis + ".id_dep_nur='" + strIdDept + "'";
			strSqlCond=" and ("+strSqlOrgid +" or "+strSqlDept+")";
		} else {
			strSqlCond= " and " + strSqlOrgid;
		}
		
		//用法关联出的服务
		PriUsgDO[] usgDoArr=rservice.find(alis+".id_route='"+strIdRoute+"'"+strSqlCond,"eu_scope,sortno", FBoolean.FALSE);
		
		if(ArrayUtil.isEmpty(usgDoArr))
			return null;
		IExclusiveDetailDORService exclusiveService=ServiceFinder.find(IExclusiveDetailDORService.class);
		List<PriUsgDO> usgDoLst=new ArrayList<PriUsgDO>();
		for(PriUsgDO usgDo:usgDoArr)
		{
			//查找规则,互补策略
			ExclusiveDetailDO[] exclusiveDetailDtoArr=exclusiveService.findByAttrValString("Id_srv",usgDo.getId_srv());
			//如果排斥策略里没有该服务，则医嘱直接带入
			if(ArrayUtil.isEmpty(exclusiveDetailDtoArr))
				usgDoLst.add(usgDo);
		}
		if(ListUtil.isEmpty(usgDoLst))
		{
			return null;
		}
		return usgDoLst.toArray(new PriUsgDO[usgDoLst.size()]);
	}
}
