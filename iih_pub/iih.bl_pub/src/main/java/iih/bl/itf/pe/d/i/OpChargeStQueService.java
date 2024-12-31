package iih.bl.itf.pe.d.i;

import iih.bl.cg.blorderappendbillparamdto.d.BlOrderAppendBillParamDTO;
import xap.mw.core.data.BizException;
/**
 * 体检费用查询
 * @author zhangxin
 *
 */
public interface OpChargeStQueService {
	 /**
		 * 调入第三方体检费用
		 * @param patId 患者id
		 * @return 门诊费用信息
		 * @author ly 2018/08/27
		 */
		public abstract BlOrderAppendBillParamDTO[] getPeFeeInfo(String patId,String peCode) throws BizException;
}
