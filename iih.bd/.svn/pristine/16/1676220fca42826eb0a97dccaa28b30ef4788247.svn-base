package iih.bd.srv.medsrv.s.bp;

import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvSetItemDO;
import iih.bd.srv.medsrv.i.IMedSrvSetItemDORService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 服务套启用检查业务逻辑
 * 
 * @author hao_wu
 *
 */
public class SrvSetEnableCheckBp {

	public void exec(MedSrvDO medSrvDO) throws BizException {
		if (medSrvDO == null) {
			return;
		}

		CheckSrvSet(medSrvDO);
	}

	/**
	 * 检查服务套
	 * 
	 * @param medSrvDO
	 * @throws BizException
	 */
	private void CheckSrvSet(MedSrvDO medSrvDO) throws BizException {
		MedSrvSetItemDO[] srvSetItemArr = GetSrvSetItemArray(medSrvDO);
		if (srvSetItemArr == null || srvSetItemArr.length <= 0) {
			String msg = String.format("服务套\"%s\"套内项目为空。", medSrvDO.getName());
			throw new BizException(msg);
		}
	}

	/**
	 * 获取套内项目
	 * 
	 * @param medSrvDO
	 * @return
	 * @throws BizException
	 */
	private MedSrvSetItemDO[] GetSrvSetItemArray(MedSrvDO medSrvDO) throws BizException {
		IMedSrvSetItemDORService medSrvSetItemDORService = ServiceFinder.find(IMedSrvSetItemDORService.class);
		MedSrvSetItemDO[] result = medSrvSetItemDORService.findByAttrValString(MedSrvSetItemDO.ID_SRV,
				medSrvDO.getId_srv());
		return result;
	}

}
