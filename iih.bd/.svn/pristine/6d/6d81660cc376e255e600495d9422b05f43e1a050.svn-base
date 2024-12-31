package iih.bd.srv.medsrv.s.bp;

import iih.bd.srv.medsrv.d.MedSrvConsDO;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.i.IMedSrvConsDORService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 会诊类型医疗服务启用检查业务逻辑
 * 
 * @author hao_wu
 *
 */
public class ConsSrvEnableCheckBp {

	public void exec(MedSrvDO medSrvDO) throws BizException {
		if (medSrvDO == null) {
			return;
		}

		CheckCons(medSrvDO);
	}

	/**
	 * 检查医疗服务会诊属性
	 * 
	 * @param medSrvDO
	 * @throws BizException
	 */
	private void CheckCons(MedSrvDO medSrvDO) throws BizException {
		MedSrvConsDO medSrvConsDO = GetConsData(medSrvDO);
		if (medSrvConsDO == null) {
			String msg = String.format("医疗服务\"%s\"会诊属性表为空。", medSrvDO.getName());
			throw new BizException(msg);
		}
		CheckConsNullProp(medSrvConsDO, medSrvDO);
	}

	/**
	 * 检查医疗服务会诊属性空属性值
	 * 
	 * @param medSrvConsDO
	 * @throws BizException
	 */
	private void CheckConsNullProp(MedSrvConsDO medSrvConsDO, MedSrvDO medSrvDO) throws BizException {
		String msg = String.format("医疗服务\"%s\"检检属性中", medSrvDO.getName());
		if (medSrvConsDO.getFg_inorg() == null) {
			msg = String.format("%s是否院内会诊标识为空。", msg);
			throw new BizException(msg);
		}
		if (medSrvConsDO.getFg_deps() == null) {
			msg = String.format("%s是否多科室会诊标识为空。", msg);
			throw new BizException(msg);
		}
		if (medSrvConsDO.getFg_audit_clidep() == null) {
			msg = String.format("%s是否需科室审批标识为空。", msg);
			throw new BizException(msg);
		}
		if (medSrvConsDO.getFg_audit_admdep() == null) {
			msg = String.format("%s是否需医务部审批标识为空。", msg);
			throw new BizException(msg);
		}
		// 允许为空 吴浩 20171016 妍妍需求
		// if (medSrvConsDO.getQuan_constimelimit() == null) {
		// msg = String.format("%s会诊时效为空。", msg);
		// throw new BizException(msg);
		// }
		// if (StringUtil.isEmpty(medSrvConsDO.getId_unit())) {
		// msg = String.format("%s时效单位为空。", msg);
		// throw new BizException(msg);
		// }
		// if (medSrvConsDO.getQuan_urg_constimelimit() == null) {
		// msg = String.format("%s加急时效为空。", msg);
		// throw new BizException(msg);
		// }
		// if (StringUtil.isEmpty(medSrvConsDO.getId_unit_urg())) {
		// msg = String.format("%s加急时效单位为空。", msg);
		// throw new BizException(msg);
		// }
	}

	/**
	 * 获取医疗服务会诊属性
	 * 
	 * @param medSrvDO
	 * @return
	 * @throws BizException
	 */
	private MedSrvConsDO GetConsData(MedSrvDO medSrvDO) throws BizException {
		IMedSrvConsDORService medSrvConsDORService = ServiceFinder.find(IMedSrvConsDORService.class);
		MedSrvConsDO[] result = medSrvConsDORService.findByAttrValString(MedSrvConsDO.ID_SRV, medSrvDO.getId_srv());
		if (result != null && result.length > 0) {
			return result[0];
		}
		return null;
	}
}
