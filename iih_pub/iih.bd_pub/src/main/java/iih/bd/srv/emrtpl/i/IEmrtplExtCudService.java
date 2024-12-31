package iih.bd.srv.emrtpl.i;

import iih.bd.srv.emrtpl.d.EmrTplDO;
import iih.bd.srv.mrtplstream.d.EmrTplStreamDO;
import xap.mw.core.data.BizException;

/**
 * 医疗记录模板扩展Cud服务接口
 * 
 * @author hao_wu
 *
 */
public interface IEmrtplExtCudService {
	/**
	 * 保存医疗记录模板及其流文件
	 * 
	 * @param emrTplDo
	 *            医疗记录模板
	 * @param streamDO
	 *            流文件
	 * @return
	 * @throws BizException
	 */
	public abstract void Save(EmrTplDO emrTplDo, EmrTplStreamDO streamDO) throws BizException;

	/**
	 * 设置默认医疗记录模板
	 * 
	 * @param emrTplDO
	 *            默认医疗记录模板
	 * @return
	 * @throws BizException
	 */
	public abstract EmrTplDO SetDefaultMrTpl(EmrTplDO emrTplDO) throws BizException;

	/**
	 * 医疗记录模板流数据迁移
	 * 
	 * @param oldOrderid 
	 *            复制模版id
	 * @param newOrderid 
	 *            目标模版id       
	 * @return
	 * @throws BizException
	 */
	public abstract void CopyEmrTplStream(String oldOrderid,String newOrderid) throws BizException;
}
