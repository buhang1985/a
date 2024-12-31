package iih.bd.fc.s.bp;

import iih.bd.fc.orwf.d.OrWfExDeptParamDTO;
import iih.bd.fc.pub.BdFcAppUtils;
import iih.bd.fc.pub.BdFcUtils;
import iih.bd.mm.warehouseinfo.d.WarehouseInfoDO;
import iih.bd.mm.warehouseinfo.d.desc.WarehouseInfoDODesc;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/*
 * 是否是基数药的判断逻辑操作BP
 */
public class IsCardinalPharmBP {
	/**
	 * 是否是基数药的判断
	 * @param wforinfo
	 * @return
	 * @throws BizException
	 */
	public String exec(OrWfExDeptParamDTO param) throws BizException{
		//有效性判断
		if(param==null || BdFcUtils.isEmpty(param.getId_mm()))return null;
		if(BdFcUtils.isEmpty(param.getId_dept_en()) && BdFcUtils.isEmpty(param.getId_dept_ns()))return null;
		
		//门急诊逻辑
		if(BdFcUtils.isOpUrgentWf(param.getCode_entp())){
			if(isCardinalPharm(param.getId_mm(),param.getId_dept_en()))return param.getId_dept_en();
			return null;
		}
		
		//住院逻辑
		if(BdFcUtils.isIpWf(param.getCode_entp())){
			if(isCardinalPharm(param.getId_mm(),param.getId_dept_ns()))return param.getId_dept_ns();
			return null;
		}
		
		//返回
		return null;
	}
	
	/**
	 * 是否基数药管理
	 * @return
	 * @throws BizException 
	 */
	private boolean isCardinalPharm(String id_mm,String id_dept) throws BizException{
		if(BdFcUtils.isEmpty(id_mm) || BdFcUtils.isEmpty(id_dept))return false;
		
		//调用基数药管理接口
		String whereStr=getWhereStr(id_mm,id_dept);
		WarehouseInfoDO[] dos=BdFcAppUtils.getWarehouseinfoQryService().find(whereStr, "", FBoolean.TRUE);
		
		if(BdFcUtils.isEmpty(dos))return false; 
		return true;
	}
	private String getWhereStr(String id_mm,String id_dept){
		String aliasName=WarehouseInfoDODesc.TABLE_ALIAS_NAME+".";
		return aliasName+"id_dep='' and "+aliasName+"id_mm='' and "+aliasName+"fg_base='Y' and "+aliasName+"fg_active='Y' and "+aliasName+"ds='0'";
	}
}
