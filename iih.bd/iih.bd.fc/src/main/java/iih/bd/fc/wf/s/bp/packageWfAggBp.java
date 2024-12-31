package iih.bd.fc.wf.s.bp;

import iih.bd.fc.wf.d.WfAggDO;
import xap.mw.core.data.BizException;

public class packageWfAggBp {

	/**
	 * 医嘱流向配置，组装AggDO
	 * 
	 * @return
	 * @throws BizException
	 */
	public void exec(WfAggDO[] aggDOS) throws BizException {

		// 1、参数验证
		if (vilationData(aggDOS)) {
			return;
		}

		// 2、组装数据
		packageAgg(aggDOS);
	}

	/**
	 * 
	 * 参数验证
	 * 
	 * @param aggDOS
	 * @return
	 */
	private boolean vilationData(WfAggDO[] aggDOS) {
		if (aggDOS == null) {
			return true;
		}
		return false;
	}

	/**
	 * 组装流向AggDO，将子表服务类型字段组装到主DO的计算字段Id_srvtp中
	 * 
	 * @param aggDOS
	 * @throws BizException
	 */
	private void packageAgg(WfAggDO[] aggDOS) throws BizException {
		packageWfMDOBp bp = new packageWfMDOBp();
		for (WfAggDO wfAggDO : aggDOS) {
			bp.exec(wfAggDO.getParentDO(), wfAggDO.getWfSrvtpDO());
			// String Id_srvtps = "";
			// String Code_srvtps = "";
			// String Name_srvtps = "";
			//
			// if (wfAggDO.getWfSrvtpDO() != null) {
			//
			// for (WfSrvtpDO srvtp : wfAggDO.getWfSrvtpDO()) {
			//
			// Id_srvtps += (Id_srvtps.length() == 0 ? "" : ",")
			// + srvtp.getId_srvtp();// 服务类型ID
			// Code_srvtps += (Code_srvtps.length() == 0 ? "" : ",")
			// + srvtp.getSd_srvtp();// 服务类型编码
			// Name_srvtps += (Name_srvtps.length() == 0 ? "" : ",")
			// + srvtp.getName();// 服务类型名称
			// }
			// }
			//
			// wfAggDO.getParentDO().setId_srvtp(Id_srvtps);
			// wfAggDO.getParentDO().setCode_srvtp(Code_srvtps);
			// wfAggDO.getParentDO().setName_srvtp(Name_srvtps);
		}
	}
}
