package iih.bd.fc.wf.s.bp;

import iih.bd.fc.wf.d.WfDO;
import iih.bd.fc.wf.d.WfSrvtpDO;
import iih.bd.fc.wf.i.IWfSrvtpDORService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 包装主DO
 * 
 * @author hao_wu
 *
 */
public class packageWfMDOBp {

	private IWfSrvtpDORService wfSrvtpDORService = ServiceFinder
			.find(IWfSrvtpDORService.class);

	/**
	 * 医嘱流向配置，组装主DO
	 * 
	 * @param wfDO
	 *            主DO
	 * @param wfsrvtpList
	 *            服务类型列表 可为空
	 * @throws BizException
	 */
	public void exec(WfDO wfDO, WfSrvtpDO[] wfsrvtpList) throws BizException {

		// 1、参数验证
		if (vilationData(wfDO)) {
			return;
		}

		// 2、组装数据
		packageWfDO(wfDO, wfsrvtpList);
	}

	/**
	 * 参数验证
	 * 
	 * @param wfDO
	 *            主DO
	 * @return 是否为空
	 */
	private boolean vilationData(WfDO wfDO) {
		if (wfDO == null) {
			return true;
		}
		return false;
	}

	/**
	 * 设置主DO服务类型属性
	 * 
	 * @param wfDO
	 *            主DO
	 * @param wfsrvtpList
	 *            服务类型列表 为空会去数据库查询
	 * @throws BizException
	 */
	private void packageWfDO(WfDO wfDO, WfSrvtpDO[] wfsrvtpList)
			throws BizException {
		WfSrvtpDO[] wfsrvtpArray = null;
		if (wfsrvtpList == null) {
			String where = String.format("a1.id_wf = '%s'", wfDO.getId_wf());
			wfsrvtpArray = wfSrvtpDORService.find(where, "", FBoolean.FALSE);
		} else {
			wfsrvtpArray = wfsrvtpList;
		}
		if (wfsrvtpArray == null) {
			return;
		}
		setupMdoSrvtp(wfDO, wfsrvtpArray);
	}

	/**
	 * 安装主DO的服务类型字段
	 * 
	 * @param parentDO
	 *            主DO
	 * @param wfSrvtpDO
	 *            服务类型列表
	 * @author hao_wu
	 */
	private void setupMdoSrvtp(WfDO parentDO, WfSrvtpDO[] wfSrvtpDO) {
		String Id_srvtps = "";
		String Code_srvtps = "";
		String Name_srvtps = "";

		if (wfSrvtpDO != null) {

			for (WfSrvtpDO srvtp : wfSrvtpDO) {
				Id_srvtps += (Id_srvtps.length() == 0 ? "" : ",")
						+ srvtp.getId_srvtp();// 服务类型ID
				Code_srvtps += (Code_srvtps.length() == 0 ? "" : ",")
						+ srvtp.getSd_srvtp();// 服务类型编码
				Name_srvtps += (Name_srvtps.length() == 0 ? "" : ",")
						+ srvtp.getName();// 服务类型名称
			}
		}

		parentDO.setId_srvtp(Id_srvtps);
		parentDO.setCode_srvtp(Code_srvtps);
		parentDO.setName_srvtp(Name_srvtps);
	}
}
