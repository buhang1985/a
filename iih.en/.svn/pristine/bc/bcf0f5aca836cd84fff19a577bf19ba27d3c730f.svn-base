package iih.en.er.bp.inouttransmgr;

import iih.en.comm.validator.EnValidator;
import iih.en.er.dto.d.UrgInOutTransMgrDTO;
import xap.mw.core.data.BizException;

/**
 * 急诊入出转操作base类
 * 
 * @author liubin
 *
 */
abstract class InOutTransMgrBaseAbstract implements IInOutTransMgr {

	@Override
	public UrgInOutTransMgrDTO exec(UrgInOutTransMgrDTO data)
			throws BizException {
		//参数校验
		this.validate(data);
		//处理
		this.handle(data);
		//返回最新数据
		IGetInOutTransMgr bp = new GetInOutTransMgrBaseBP();
		return bp.exec(data.getId_ent());
	}
	/**
	 * 处理
	 * 
	 * @param data
	 * @throws BizException
	 */
	protected abstract void handle(UrgInOutTransMgrDTO data) throws BizException;
	/**
	 * 参数校验
	 * 
	 * @param data
	 * @throws BizException
	 */
	protected void validate(UrgInOutTransMgrDTO data) throws BizException {
		if(data == null)
			throw new BizException("就诊数据不能为空！");
		if(EnValidator.isEmpty(data.getId_ent()))
			throw new BizException("就诊数据不能为空！");
	}
}
