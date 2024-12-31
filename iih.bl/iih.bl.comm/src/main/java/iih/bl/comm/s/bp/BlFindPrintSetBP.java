package iih.bl.comm.s.bp;

import iih.bl.inc.dto.blprintset.d.BlPrintSetDTO;
import iih.bl.params.BlParamConst;
import iih.bl.params.BlParams;

import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.utils.StringUtil;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

/**
 * 查询费用域打印配置
 * @author ly 2018/06/19
 *
 */
public class BlFindPrintSetBP {

	private final static String[] PRINT_PARAM = new String[] {
			BlParamConst.BLINC0001, BlParamConst.BLINC0002,
			BlParamConst.BLINC0003, BlParamConst.BLINC0004,
			BlParamConst.BLINC0005, BlParamConst.BLINC0006,
			BlParamConst.BLINC0007, BlParamConst.BLINC0008, 
			BlParamConst.BLINC0039, BlParamConst.BLINC0040};
	
	/**
	 * 查询费用域打印配置
	 * @param printType 打印类型 TODO
	 * @return 打印机配置
	 * @throws BizException
	 */
	public BlPrintSetDTO exec(String printType) throws BizException{
		
		BlPrintSetDTO rlt = new BlPrintSetDTO();
		
		String pcId = BlParams.getRealPcId(Context.get().getClientHost());
		if(StringUtil.isEmpty(pcId))
			return rlt;
		
		Map<String,String> paramMap = ParamsetQryUtil.getParasStringByInstance(pcId, PRINT_PARAM);
		
		rlt.setBl_cc_priner(paramMap.get(BlParamConst.BLINC0001));//结账
		rlt.setBl_ip_invoice_printer(paramMap.get(BlParamConst.BLINC0002));//住院发票
		rlt.setBl_ip_itmdetail_printer(paramMap.get(BlParamConst.BLINC0003)); //住院费用明细
		rlt.setBl_ip_prepay_printer(paramMap.get(BlParamConst.BLINC0004));//住院预交金
		rlt.setBl_oep_prepay_printer(paramMap.get(BlParamConst.BLINC0005));//门诊预交金
		rlt.setBl_oep_itmdetail_printer(paramMap.get(BlParamConst.BLINC0006));//门诊费用明细
		rlt.setBl_oep_invoice_printer(paramMap.get(BlParamConst.BLINC0007));//门诊发票
		rlt.setBl_rpt_printer(paramMap.get(BlParamConst.BLINC0008));//报表
		rlt.setBl_onedaycostlist_printer(paramMap.get(BlParamConst.BLINC0039));//一日费用清单
		rlt.setBl_ipcostlist_printer(paramMap.get(BlParamConst.BLINC0040));//住院费用清单
		
		return rlt;
	}
}