package iih.bd.fc.i;

import iih.bd.fc.ormatchorpltp.d.OrpltpMatchParamDTO;
import iih.bd.fc.orpltp.d.OrpltpDO;
import iih.bd.fc.orpltp.d.OrpltpStaDO;
import iih.bd.fc.orpltpfunparam.d.OrpltpFunDTO;
import iih.bd.fc.orpltpstafunc.d.OrpltpStaFuncDO;
import xap.mw.core.data.BizException;

public interface IOrpltpmtParaService {
	
	/** 医嘱执行闭环类型匹配参数查询
	  * @param orpltpMatParDTO 医嘱闭环匹配参数
	 * @return
	 * @throws BizException
	 */
	public abstract OrpltpDO[] GetOrpltp(OrpltpMatchParamDTO orpltpMatParDTO) throws BizException;

	/**
	 * 医嘱执行闭环节点状态匹配
	 * @param DTO
	 * @return
	 * @throws BizException
	 */
	public abstract OrpltpStaDO[] GetOrpltpFun(OrpltpFunDTO[] DTO) throws BizException;

	/**
	 * 返回闭环类型集合
	 * @param funcode节点编码
	 * @return
	 * @throws BizException
	 */
	public abstract OrpltpStaFuncDO[] getIdOrpltpsByFuncode(String funcode) throws BizException;
}
