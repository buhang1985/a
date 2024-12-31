package iih.ci.ord.s.bp.ems.save.validate;

import xap.mw.coreitf.d.FBoolean;

/**
 * 医嘱开单校验，工厂
 * @author zhangwq
 *
 */
public class SaveValidateFactory {
	public static BaseSaveValidateBP getValidate(String sd_srvtp,String code_entp,FBoolean fg_presoutp){
		return new BaseSaveValidateBP();
	}
	
}
