package iih.ei.itf.itftest.i;

import iih.ei.itf.itftest.d.EiItfTransferInfoDTO;
import xap.mw.core.data.BizException;

/**
 * 接口测试接口
 * 
 * @author hao_wu 2019-9-27
 *
 */
public interface IEiItfTestRService {

	/**
	 * 获取接口调用信息
	 * 
	 * @param itfId 接口主键
	 * @return 接口调用信息
	 */
	public abstract EiItfTransferInfoDTO getItfTransferInfo(String itfId) throws BizException;
}
