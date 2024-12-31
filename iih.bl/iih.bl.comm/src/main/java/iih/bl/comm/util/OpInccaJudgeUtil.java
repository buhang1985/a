package iih.bl.comm.util;

import iih.bd.bc.udi.pub.IBdPpCodeTypeConst;
import iih.bl.params.BlParams;
import iih.bl.st.blstoep.d.BlStOepDO;
import iih.bl.st.blstoep.d.StTypeEnum;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 门诊发票票据类型判断工具
 * @author ly 2019/11/01
 *
 */
public class OpInccaJudgeUtil {

	/**
	 * 获取票据类型
	 * @param stId
	 * @return
	 * @throws BizException
	 */
	public static String getInvoiceTp(String stId) throws BizException {
		
		String regInccaCode = BlParams.BLINC0026();
		if(IBdPpCodeTypeConst.SD_OUTPATIENT_INVOICE.equals(regInccaCode)){
			return IBdPpCodeTypeConst.ID_OUTPATIENT_INVOICE;
		}
		
		DAFacade daf = new DAFacade();
		BlStOepDO blStDO= (BlStOepDO)daf.findByPK(BlStOepDO.class, stId, new String[]{BlStOepDO.ID_STOEP,BlStOepDO.EU_STTP});
		return StTypeEnum.ST_OEP_REG.equals(blStDO.getEu_sttp()) ? IBdPpCodeTypeConst.ID_OUTREGISTER_INVIOCE : IBdPpCodeTypeConst.ID_OUTPATIENT_INVOICE;
	}
}
