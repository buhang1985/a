package iih.bd.srv.medsrv.i.ext;

import iih.bd.srv.medsrv.d.MedSrvDO;
import xap.mw.core.data.BizException;

/**
 * 医疗服务启用服务接口
 * 
 * @author hao_wu
 *
 */
public interface IMedSrvEnableService {

	/**
	 * 启用
	 * 
	 * @param medSrvDOs
	 *            医疗服务列表
	 * @return
	 */
	public abstract MedSrvDO[] Enable(MedSrvDO[] medSrvDOs) throws BizException;

	/**
	 * 停用
	 * 
	 * @param medSrvDOs
	 *            医疗服务列表
	 * @return
	 */
	public abstract MedSrvDO[] Disable(MedSrvDO[] medSrvDOs) throws BizException;

}
