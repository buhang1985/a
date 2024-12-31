package iih.bl.cc.ebs.bp;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDate;
import xap.sys.appfw.orm.utils.AppFwUtil;
import iih.bl.cc.ebs.bp.qry.GetChargeIfaceDTOQty;
import iih.bl.cc.ebs.d.HisChargeIfaceDTO;

/**
 * 获取主表对应子数据
 * 
 * @author Administrator
 * 
 */
public class GetChargeIfaceDTOsBP {
	/**
	 * 执行方法
	 * 
	 * @param 主表编号
	 * @return
	 * @throws BizException
	 */
	public HisChargeIfaceDTO[] exec(Integer Iface_batch_id, FDate execDate) throws BizException {
		HisChargeIfaceDTO[] retValue = (HisChargeIfaceDTO[]) AppFwUtil.getDORstWithDao(new GetChargeIfaceDTOQty(Iface_batch_id, execDate), HisChargeIfaceDTO.class);
		return retValue;
	}
}
