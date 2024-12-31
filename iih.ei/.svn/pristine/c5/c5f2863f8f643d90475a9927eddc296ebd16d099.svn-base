package iih.ei.std.s.v1.bp.mp.downstockdata;


import java.util.ArrayList;
import java.util.List;

import iih.ei.std.d.v1.commdto.d.NoParamDTO;
import iih.ei.std.d.v1.mp.purchasedrug.d.PurchaseDrugParamDTO;
import iih.ei.std.s.v1.bp.IIHServiceBaseBP;
import xap.mw.core.data.BizException;
/**
 * 
* @ClassName: CallHisForPOsBp
* @Description: 生成采购入库（新建状态）数据
* @author zhy
* @date 2019年10月17日
*
 */
public class CallHisForPOsBp extends IIHServiceBaseBP<PurchaseDrugParamDTO, NoParamDTO>{
	
	/**
	 * 入参校验
	 */
	@Override
	protected void checkParam(PurchaseDrugParamDTO param) throws BizException {
		if (null == param || param.getPurchasedrugmajor().size() < 1) {
			throw new BizException("入参采购单数据为空，请确认字段是否匹配正确");
		}
	}

	@Override
	protected NoParamDTO process(PurchaseDrugParamDTO param) throws BizException {
		List<String> idList = new ArrayList<>();
		InsertPOsBP bp = new InsertPOsBP();
		bp.exec(param.getPurchasedrugmajor(),idList);
		if (idList.size() > 0) {
			throw new BizException("【插入失败数据序号：" + idList.toString()+ "】");
		}
		return new NoParamDTO();
	}

}
