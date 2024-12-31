package iih.ci.ord.s.bp.validate.assi;

import iih.ci.ord.s.bp.validate.assi.op.OpCiEmsValidate;

/**
 * 医疗单校验工厂
 * @author zhangwq
 *
 */
public class CiEmsValidateFactory {
	public static CiEmsValidate getInstance(String code_entp){
		//门诊
		if("00".equals(code_entp)){
			return new OpCiEmsValidate();
		}else if("10".equals(code_entp)){//住院
			return new CiEmsValidate();
		}else{
			return new CiEmsValidate();
		}
	}
}
