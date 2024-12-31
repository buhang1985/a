package iih.bd.fc.orderlooptype.s;

import iih.bd.fc.orderlooptype.d.OrpltpInfoDTO;
import iih.bd.fc.orderlooptype.i.IOrderLoopTypeExtService;
import iih.bd.fc.orderlooptype.s.bp.GetOrpltpmtParaDObp;
import iih.bd.fc.orderlooptype.s.bp.GetSrvtpTreeDTOBp;
import iih.bd.fc.orderlooptype.s.bp.getOrpltpInfoBp;
import iih.bd.fc.ormatchorpltp.d.SrvtpTreeDTO;
import iih.bd.fc.orpltpmtpara.d.OrpltpmtParaDO;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;

@Service(serviceInterfaces = { IOrderLoopTypeExtService.class }, binding = Binding.JSONRPC)
public class IOrderLoopTypeExtServiceImpl implements IOrderLoopTypeExtService {

	/**
	 * 获取服务类型树
	 */
	@Override
	public SrvtpTreeDTO[] getSrvtpTreeDTO() throws BizException {

		// GetTestDataBp bpTest=new GetTestDataBp();
		//
		// bpTest.exec();

		GetSrvtpTreeDTOBp bp = new GetSrvtpTreeDTOBp();

		return bp.exec();
	}

	/**
	 * 获取医嘱闭环列表
	 */
	@Override
	public OrpltpmtParaDO[] getOrpltpmtParaDO() throws BizException {

		GetOrpltpmtParaDObp bp = new GetOrpltpmtParaDObp();

		return bp.exec();
	}

	/**
	 * 获取闭环明细（键：id_orpltp，值：闭环状态明细）
	 */
	@Override
	public OrpltpInfoDTO[] getOrpltpInfo() throws BizException {

		getOrpltpInfoBp bp = new getOrpltpInfoBp();

		return bp.exec();
	}
}
