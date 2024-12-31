package iih.bd.srv.medsrv.s.bp;

import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvOpDO;
import iih.bd.srv.medsrv.i.IMedSrvOpDORService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 手术类型医疗服务启用检查业务逻辑
 * 
 * @author hao_wu
 *
 */
public class OpSrvEnableCheckBp {

	public void exec(MedSrvDO medSrvDO) throws BizException {
		if (medSrvDO == null) {
			return;
		}

		CheckOp(medSrvDO);
	}

	/**
	 * 检查医疗服务手术属性
	 * 
	 * @param medSrvDO
	 * @throws BizException
	 */
	private void CheckOp(MedSrvDO medSrvDO) throws BizException {
		MedSrvOpDO medSrvOpDO = GetOpData(medSrvDO);
		if (medSrvOpDO == null) {
			String msg = String.format("医疗服务\"%s\"手术属性表为空。", medSrvDO.getName());
			throw new BizException(msg);
		}

		CheckOpNullProp(medSrvOpDO, medSrvDO);
	}

	/**
	 * 检查医疗服务手术属性空属性值
	 * 
	 * @param medSrvOpDO
	 * @throws BizException
	 */
	private void CheckOpNullProp(MedSrvOpDO medSrvOpDO, MedSrvDO medSrvDO) throws BizException {
		// String msg = String.format("医疗服务\"%s\"手术属性中", medSrvDO.getName());
		// 可以为空 吴浩 已与PO确认
		// if (StringUtil.isEmpty(medSrvOpDO.getId_opclass())) {
		// msg = String.format("%s手术级别为空。", msg);
		// throw new BizException(msg);
		// }
		// if (StringUtil.isEmpty(medSrvOpDO.getSd_opclass())) {
		// msg = String.format("%s手术级别编码为空。", msg);
		// throw new BizException(msg);
		// }
		// if (StringUtil.isEmpty(medSrvOpDO.getId_didef())) {
		// msg = String.format("%s关联诊断为空。", msg);
		// throw new BizException(msg);
		// }
	}

	/**
	 * 获取医疗服务手术属性
	 * 
	 * @param medSrvDO
	 * @return
	 * @throws BizException
	 */
	private MedSrvOpDO GetOpData(MedSrvDO medSrvDO) throws BizException {
		IMedSrvOpDORService medSrvOpDORService = ServiceFinder.find(IMedSrvOpDORService.class);
		MedSrvOpDO[] result = medSrvOpDORService.findByAttrValString(MedSrvOpDO.ID_SRV, medSrvDO.getId_srv());
		if (result != null && result.length > 0) {
			return result[0];
		}
		return null;
	}
}
