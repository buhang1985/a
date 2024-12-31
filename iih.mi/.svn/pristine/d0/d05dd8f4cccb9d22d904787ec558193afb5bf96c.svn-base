package iih.mi.mc.mimcspec.s.bp;

import iih.mi.mc.mimcspec.d.MiMcSpecDrugDO;
import iih.mi.mc.mimcspec.i.IMiMcSpecDrugDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

public class MiMcSpecDrugCuBeforeBp {
	public void exec(MiMcSpecDrugDO miMcSpecDrugDO) throws BizException {
		
		if(miMcSpecDrugDO == null) {
			throw new BizException("入参为空。");
		}
		validaPara(miMcSpecDrugDO);
	}
	
	private void validaPara(MiMcSpecDrugDO miMcSpecDrugDO) throws BizException {
		String whereStr=" Id_hpspec='"+ miMcSpecDrugDO.getId_hpspec() 
				+"' and id_srv='"+ miMcSpecDrugDO.getId_srv() 
				+"' and id_mm='"+ miMcSpecDrugDO.getId_mm() +"'";
		if(!StringUtil.isEmpty(miMcSpecDrugDO.getId_hpspecdrug())){
			whereStr+=" and Id_hpspecdrug<>'"+ miMcSpecDrugDO.getId_hpspecdrug() +"'";
		}
		IMiMcSpecDrugDORService ser= ServiceFinder.find(IMiMcSpecDrugDORService.class);
		MiMcSpecDrugDO[] miMcSpecDrugDOArr=ser.find(whereStr, "", FBoolean.FALSE);
		if(!ArrayUtil.isEmpty(miMcSpecDrugDOArr)){
			throw new BizException("已存在相同记录");
		}
	}
}
