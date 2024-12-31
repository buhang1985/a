package iih.mc.st.inspection.i;

import iih.mc.po.pruchase.d.McPurchaseOrderDO;
import iih.mc.st.inspection.d.InspectionAggDO;
import xap.mw.core.data.BizException;

public interface IInspectionMaintainService {
	
	/**
	 * 初始化高值耗材验收单
	 * @throws BizException
	 */
	public InspectionAggDO initAggDo() throws BizException;
	
	/**
	 * 采购单主表装验收单aggDO
	 * @param purshDo
	 * @return
	 * @throws BizException
	 */
	public InspectionAggDO purchToInspetionAggDo(McPurchaseOrderDO purshDo)  throws BizException;

}
