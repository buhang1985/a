package iih.bl.cc.ebs.i;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDate;
import iih.bl.cc.ebs.d.HisBatchIfaceDTO;
import iih.bl.cc.ebs.d.HisChargeIfaceDTO;

/**
 * 获取EBS接口需求数据接口
 * 
 * @author Administrator
 * 
 */
public interface IBLCcEBSQryService {
	/**
	 * 获取导入规则主表
	 * 
	 * @return
	 */
	HisBatchIfaceDTO[] getBatchIfaceDTOs() throws BizException;

	/**
	 * 获取规则主表列表
	 * 
	 * @param 主表序号
	 * @param 查询日期
	 * @return
	 */
	HisChargeIfaceDTO[] getChargeIfaceDTOs(Integer Iface_batch_id, FDate execDate) throws BizException;

}
