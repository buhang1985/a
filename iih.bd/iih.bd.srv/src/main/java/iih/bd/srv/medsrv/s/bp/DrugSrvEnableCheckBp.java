package iih.bd.srv.medsrv.s.bp;

import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvDrugDO;
import iih.bd.srv.medsrv.i.IMedSrvDrugDORService;
import iih.bd.srv.medsrv.s.rule.bp.MedSrvDrugCheckRoutBp;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 药品类服务启用检查业务逻辑
 * 
 * @author hao_wu
 *
 */
public class DrugSrvEnableCheckBp {

	public void exec(MedSrvDO medSrvDO) throws BizException {
		if (medSrvDO == null) {
			return;
		}

		CheckDrug(medSrvDO);
	}

	/**
	 * 检查药品属性
	 * 
	 * @param medSrvDO
	 * @throws BizException
	 */
	private void CheckDrug(MedSrvDO medSrvDO) throws BizException {

		MedSrvDrugDO medSrvDrugDO = GetMedSrvDrug(medSrvDO);
		if (medSrvDrugDO == null) {
			String msg = String.format("医疗服务\"%s\"药品属性表为空。", medSrvDO.getName());
			throw new BizException(msg);
		}

		CheckDrugNullProp(medSrvDrugDO, medSrvDO);
		CheckRoute(medSrvDO, medSrvDrugDO);
		if (medSrvDO.getFg_ctm() != null && medSrvDO.getFg_ctm().equals(FBoolean.FALSE)) {
			CheckRelMm(medSrvDO);
		}
	}

	/**
	 * 检查关联物品
	 * 
	 * @param medsrvDo
	 * @throws BizException
	 */
	private void CheckRelMm(MedSrvDO medsrvDo) throws BizException {
		DrugSrvEnableCheckRelMmBp bp = new DrugSrvEnableCheckRelMmBp();
		bp.exec(medsrvDo);
	}

	/**
	 * 检查用法是否符合剂型
	 * 
	 * @param medSrvDO
	 * @param medSrvDrugDO
	 * @throws BizException
	 */
	private void CheckRoute(MedSrvDO medSrvDO, MedSrvDrugDO medSrvDrugDO) throws BizException {
		MedSrvDrugCheckRoutBp bp = new MedSrvDrugCheckRoutBp();
		bp.exec(new MedSrvDrugDO[] { medSrvDrugDO }, medSrvDO);
	}

	/**
	 * 检查药品属性空字段
	 * 
	 * @param medSrvDrugDO
	 * @throws BizException
	 */
	private void CheckDrugNullProp(MedSrvDrugDO medSrvDrugDO, MedSrvDO medSrvDO) throws BizException {
		String msg = String.format("医疗服务\"%s\"药品属性中", medSrvDO.getName());
		if (StringUtil.isEmpty(medSrvDrugDO.getId_dosage())) {
			msg = String.format("%s药品剂型为空。", msg);
			throw new BizException(msg);
		}
		if (StringUtil.isEmpty(medSrvDrugDO.getSd_dosage())) {
			msg = String.format("%s药品剂型编码为空。", msg);
			throw new BizException(msg);
		}
		if (StringUtil.isEmpty(medSrvDrugDO.getId_pois())) {
			msg = String.format("%s毒麻分类为空。", msg);
			throw new BizException(msg);
		}
		if (StringUtil.isEmpty(medSrvDrugDO.getSd_pois())) {
			msg = String.format("%s毒麻分类编码为空。", msg);
			throw new BizException(msg);
		}
		if (StringUtil.isEmpty(medSrvDrugDO.getId_anti())) {
			msg = String.format("%s抗菌药分类为空。", msg);
			throw new BizException(msg);
		}
		if (StringUtil.isEmpty(medSrvDrugDO.getSd_anti())) {
			msg = String.format("%s抗菌药分类编码为空。", msg);
			throw new BizException(msg);
		}
	}

	/**
	 * 获取药品属性信息
	 * 
	 * @param medSrvDO
	 * @return
	 * @throws BizException
	 */
	private MedSrvDrugDO GetMedSrvDrug(MedSrvDO medSrvDO) throws BizException {
		IMedSrvDrugDORService medSrvDrugDORService = ServiceFinder.find(IMedSrvDrugDORService.class);
		MedSrvDrugDO[] result = medSrvDrugDORService.findByAttrValString(MedSrvDrugDO.ID_SRV, medSrvDO.getId_srv());
		if (result != null && result.length > 0) {
			return result[0];
		}
		return null;
	}

}
