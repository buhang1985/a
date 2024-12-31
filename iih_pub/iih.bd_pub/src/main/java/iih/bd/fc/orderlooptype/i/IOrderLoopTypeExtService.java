package iih.bd.fc.orderlooptype.i;

import iih.bd.fc.orderlooptype.d.OrpltpInfoDTO;
import iih.bd.fc.ormatchorpltp.d.SrvtpTreeDTO;
import iih.bd.fc.orpltpmtpara.d.OrpltpmtParaDO;
import xap.mw.core.data.BizException;

public interface IOrderLoopTypeExtService {

	/**
	 * 获取服务类型树
	 * 
	 * @return
	 * @throws BizException
	 */
	public abstract SrvtpTreeDTO[] getSrvtpTreeDTO() throws BizException;

	/**
	 * 获取医嘱执行闭环配置列表
	 * 
	 * @param DTO
	 * @return
	 * @throws BizException
	 */
	public abstract OrpltpmtParaDO[] getOrpltpmtParaDO() throws BizException;

	/**
	 * 获取闭环明细（键：id_orpltp，值：闭环状态明细）
	 * 
	 * @return
	 * @throws BizException
	 */
	public abstract OrpltpInfoDTO[] getOrpltpInfo() throws BizException;
}
