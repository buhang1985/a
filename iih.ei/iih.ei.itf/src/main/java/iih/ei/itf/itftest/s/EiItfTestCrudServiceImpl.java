package iih.ei.itf.itftest.s;

import iih.ei.itf.itftest.d.EiItfTransferInfoDTO;
import iih.ei.itf.itftest.i.IEiItfTestCudService;
import iih.ei.itf.itftest.i.IEiItfTestRService;
import iih.ei.itf.itftest.s.bp.GetItfTransferInfoBp;
import xap.mw.core.data.BizException;

/**
 * 接口测试服务
 * 
 * @author hao_wu 2019-9-27
 *
 */
public class EiItfTestCrudServiceImpl implements IEiItfTestCudService, IEiItfTestRService {

	@Override
	public EiItfTransferInfoDTO getItfTransferInfo(String itfId) throws BizException {
		GetItfTransferInfoBp bp = new GetItfTransferInfoBp();
		EiItfTransferInfoDTO transferInfoDTO = bp.exec(itfId);
		return transferInfoDTO;
	}

}
