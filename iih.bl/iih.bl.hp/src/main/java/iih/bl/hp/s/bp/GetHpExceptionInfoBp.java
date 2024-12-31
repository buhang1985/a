package iih.bl.hp.s.bp;

import iih.bl.hp.hpentcode.d.HpEntCodeDO;
import iih.bl.hp.hpentcode.i.IHpentcodeRService;
import iih.bl.hp.hpexceptioninfodto.d.HpExceptionInfoDTO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitRService;


import org.apache.commons.lang3.ArrayUtils;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

public class GetHpExceptionInfoBp {

	public HpExceptionInfoDTO exec( String id_ent) throws BizException {
		if(StringUtil.isEmpty(id_ent)){
			return null;
		}
		HpExceptionInfoDTO exceptionInfo = new HpExceptionInfoDTO();
		IPativisitRService patiVisitSer = ServiceFinder.find(IPativisitRService.class);
		PatiVisitDO[] patiDo = patiVisitSer.findByAttrValString("Id_ent", id_ent);
//		String orgSql = EnvContextUtil.processEnvContext("", new HpEntCodeDO(), false);
		IHpentcodeRService hpEntSer = ServiceFinder.find(IHpentcodeRService.class);
		
		
		HpEntCodeDO[] hpEntDOs = hpEntSer.find(" fg_active = 'Y' and id_ent = '" + id_ent +"' ", "", FBoolean.FALSE);
		
		if(!ArrayUtils.isEmpty(hpEntDOs)) {
			if(hpEntDOs[0].getFg_lock().booleanValue() ){
//				IMiproparipneusofthnRService miPropSer = ServiceFinder.find(IMiproparipneusofthnRService.class);
//				MiPropArIpHnNeusoftDO[] miPropDos =miPropSer.findByAttrValString("Id_ent", id_ent);
				
				exceptionInfo.setId_ent(id_ent);
				exceptionInfo.setId_pat(hpEntDOs[0].getId_pat());
				exceptionInfo.setNo_hp(hpEntDOs[0].getNo_hp());
				exceptionInfo.setHp_ent_serial_no(hpEntDOs[0].getHp_ent_serial_no());
				exceptionInfo.setCode_his_reg(hpEntDOs[0].getCode_his());
//				exceptionInfo.setDt_reg(hpEntDOs[0].getDt_reg().toString());
				exceptionInfo.setNote("医保登记异常");
				exceptionInfo.setFg_lock(hpEntDOs[0].getFg_lock());
//				if(!ArrayUtils.isEmpty(miPropDos)) {
//					exceptionInfo.setCode_his_settled(miPropDos[0].getCode_his());
////					exceptionInfo.setDt_st(miPropDos[0].);
//					exceptionInfo.setNote("医保结算异常");
//				}		
				exceptionInfo.setId_hp(patiDo[0].getId_hp());
			}
		}
		
		return exceptionInfo;
	}
}
