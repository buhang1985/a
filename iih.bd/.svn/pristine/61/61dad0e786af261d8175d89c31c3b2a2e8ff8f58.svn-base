package iih.bd.srv.medsrv.s.rule.bp;

import java.util.ArrayList;

import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvDrugDO;
import iih.bd.srv.medsrv.d.MedsrvAggDO;
import xap.mw.core.data.BizException;

/**
 * 医疗服务插入或更新前规则业务逻辑
 * 
 * @author hao_wu
 *
 */
public class MedsrvAggInsertOrUpdateBeforeRuleBp {

	public void exec(MedsrvAggDO[] medSrvAggArr) throws BizException {
		if (medSrvAggArr == null || medSrvAggArr.length <= 0) {
			return;
		}

		MedSrvDO[] medsrvDoArray = getMedSrvArray(medSrvAggArr);

		CheckNameUnique(medsrvDoArray);
		CheckSrvSet(medSrvAggArr);
		CheckUnitMed(medsrvDoArray);
		checkRout(medSrvAggArr);
		setAliasMnecode(medSrvAggArr);
		updateDrugDO(medSrvAggArr);
	}

	/**
	 * 检查服务套
	 * 
	 * @param medSrvAggArr
	 * @throws BizException
	 */
	private void CheckSrvSet(MedsrvAggDO[] medSrvAggArr) throws BizException {
		CheckSrvSetBp bp = new CheckSrvSetBp();
		bp.exec(medSrvAggArr);
	}

	/**
	 * 检查默认用量单位
	 * 
	 * @param medsrvDoArray
	 * @throws BizException
	 */
	private void CheckUnitMed(MedSrvDO[] medsrvDoArray) throws BizException {
		CheckUnitMedBp bp = new CheckUnitMedBp();
		bp.exec(medsrvDoArray);
	}

	/**
	 * 检查名称唯一性
	 * 
	 * @param medSrvAggArr
	 * @throws BizException
	 */
	private void CheckNameUnique(MedSrvDO[] medSrvArr) throws BizException {
		CheckNameUniqueBp bp = new CheckNameUniqueBp();
		bp.exec(medSrvArr);
	}

	/**
	 * 获取主DO数组
	 * 
	 * @param medSrvAggArr
	 * @return
	 */
	private MedSrvDO[] getMedSrvArray(MedsrvAggDO[] medSrvAggArr) {
		ArrayList<MedSrvDO> medsrvList = new ArrayList<MedSrvDO>();
		for (MedsrvAggDO medsrvAggDO : medSrvAggArr) {
			MedSrvDO medSrvDO = medsrvAggDO.getParentDO();
			medsrvList.add(medSrvDO);
		}
		return medsrvList.toArray(new MedSrvDO[0]);
	}

	/**
	 * 更新药品属性信息
	 */
	private void updateDrugDO(MedsrvAggDO[] medSrvAggArr) {
		MedSrvUpdateDrugDOBp bp = new MedSrvUpdateDrugDOBp();
		for (MedsrvAggDO medsrvAggDO : medSrvAggArr) {
			MedSrvDrugDO[] medSrvDrugArr = medsrvAggDO.getMedSrvDrugDO();
			bp.exec(medSrvDrugArr);
		}
	}

	/**
	 * 设置别名集助记码
	 * 
	 * @param medSrvAggArr
	 */
	private void setAliasMnecode(MedsrvAggDO[] medSrvAggArr) {
		for (MedsrvAggDO medsrvAggDO : medSrvAggArr) {
			MedsrvAggSetAliasMnecodeBp bp = new MedsrvAggSetAliasMnecodeBp();
			bp.exec(medsrvAggDO);
		}
	}

	/**
	 * 检查用法
	 * 
	 * @param medSrvAggArr
	 * @throws BizException
	 */
	private void checkRout(MedsrvAggDO[] medSrvAggArr) throws BizException {
		MedSrvDrugCheckRoutBp bp = new MedSrvDrugCheckRoutBp();
		for (MedsrvAggDO medsrvAggDO : medSrvAggArr) {
			MedSrvDO medSrvDo = medsrvAggDO.getParentDO();
			MedSrvDrugDO[] drugArr = medsrvAggDO.getMedSrvDrugDO();
			bp.exec(drugArr, medSrvDo);
		}
	}
}
