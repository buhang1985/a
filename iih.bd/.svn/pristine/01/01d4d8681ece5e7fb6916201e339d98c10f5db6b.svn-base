package iih.bd.srv.medsrv.s.bp;

import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvLisDO;
import iih.bd.srv.medsrv.i.IMedSrvLisDORService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 检验类型服务启用检查业务逻辑
 * 
 * @author hao_wu
 *
 */
public class LisSrvEnableCheckBp {

	public void exec(MedSrvDO medSrvDO) throws BizException {
		if (medSrvDO == null) {
			return;
		}

		CheckLis(medSrvDO);
	}

	/**
	 * 检查医疗服务检检验属性
	 * 
	 * @param medSrvDO
	 * @throws BizException
	 */
	private void CheckLis(MedSrvDO medSrvDO) throws BizException {
		if (medSrvDO.getFg_set() != null && medSrvDO.getFg_set().equals(FBoolean.TRUE)) {
			// 服务套不检查检验属性
			return;
		}
		MedSrvLisDO medSrvLisDO = GetLisData(medSrvDO);
		if (medSrvLisDO == null) {
			String msg = String.format("医疗服务\"%s\"检验属性表为空。", medSrvDO.getName());
			throw new BizException(msg);
		}

		CheckLisNullProp(medSrvLisDO, medSrvDO);
	}

	/**
	 * 检查医疗服务检检属性空字段值
	 * 
	 * @param medSrvLisDO
	 * @throws BizException
	 */
	private void CheckLisNullProp(MedSrvLisDO medSrvLisDO, MedSrvDO medSrvDO) throws BizException {
		// 允许为空 吴浩 已与PO确认 20171016
		// String msg = String.format("医疗服务\"%s\"检检属性中", medSrvDO.getName());
		// if (StringUtil.isEmpty(medSrvLisDO.getId_samptp())) {
		// msg = String.format("%s标本类型为空。", msg);
		// throw new BizException(msg);
		// }
		// if (StringUtil.isEmpty(medSrvLisDO.getSd_samptp())) {
		// msg = String.format("%s标本类型编码为空。", msg);
		// throw new BizException(msg);
		// }
		// if (StringUtil.isEmpty(medSrvLisDO.getId_unit_quan())) {
		// msg = String.format("%s标本需求量单位为空。", msg);
		// throw new BizException(msg);
		// }
		// if (StringUtil.isEmpty(medSrvLisDO.getId_labgroup())) {
		// msg = String.format("%s检验分组为空。", msg);
		// throw new BizException(msg);
		// }
		// if (StringUtil.isEmpty(medSrvLisDO.getSd_labgroup())) {
		// msg = String.format("%s检验分组编码为空。", msg);
		// throw new BizException(msg);
		// }
		// if (StringUtil.isEmpty(medSrvLisDO.getId_contp())) {
		// msg = String.format("%s容器类型为空。", msg);
		// throw new BizException(msg);
		// }
		// if (StringUtil.isEmpty(medSrvLisDO.getSd_contp())) {
		// msg = String.format("%s容器类型编码为空。", msg);
		// throw new BizException(msg);
		// }
	}

	/**
	 * 获取医疗服务检检验属性
	 * 
	 * @param medSrvDO
	 * @return
	 * @throws BizException
	 */
	private MedSrvLisDO GetLisData(MedSrvDO medSrvDO) throws BizException {
		IMedSrvLisDORService medSrvLisDORService = ServiceFinder.find(IMedSrvLisDORService.class);
		MedSrvLisDO[] result = medSrvLisDORService.findByAttrValString(MedSrvLisDO.ID_SRV, medSrvDO.getId_srv());
		if (result != null && result.length > 0)
			return result[0];
		return null;
	}

}
