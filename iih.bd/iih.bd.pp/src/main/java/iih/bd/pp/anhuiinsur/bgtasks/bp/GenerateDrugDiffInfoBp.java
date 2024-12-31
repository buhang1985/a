package iih.bd.pp.anhuiinsur.bgtasks.bp;

import java.util.ArrayList;

import iih.bd.pp.anhuiinsur.bgtasks.bp.sql.FindMedIDrugCountDiffSql;
import iih.bd.pp.anhuiinsur.bgtasks.bp.sql.FindMedIDrugDataDiffSql;
import iih.bd.pp.medinsurrecdiff.d.AHMedIRecDiffType;
import iih.bd.pp.medinsurrecdiff.d.MedInsurDrugRecDiffDO;
import iih.bd.pp.medinsurrecdiff.d.MedInsurRecDiffDO;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 根据差异描述生成药品差异信息业务逻辑
 * 
 * @author hao_wu
 */
public class GenerateDrugDiffInfoBp {

	public void exec(MedInsurRecDiffDO recDiff) throws BizException {
		ArrayList<MedInsurDrugRecDiffDO> drugDiffDataList = new ArrayList<MedInsurDrugRecDiffDO>();

		MedInsurDrugRecDiffDO[] addDatas = GetAddDatas(recDiff);
		AddDiffDataToList(drugDiffDataList, addDatas);

		MedInsurDrugRecDiffDO[] delDatas = GetDelDatas(recDiff);
		AddDiffDataToList(drugDiffDataList, delDatas);

		MedInsurDrugRecDiffDO[] modifyDatas = GetModifyDatas(recDiff);
		AddDiffDataToList(drugDiffDataList, modifyDatas);

		SetDiffId(drugDiffDataList, recDiff);
		SaveDiffList(drugDiffDataList.toArray(new MedInsurDrugRecDiffDO[0]));
	}

	/**
	 * 设置差异主键
	 * 
	 * @param drugDiffDataList
	 * @param recDiff
	 */
	private void SetDiffId(ArrayList<MedInsurDrugRecDiffDO> drugDiffDataList, MedInsurRecDiffDO recDiff) {
		if (drugDiffDataList != null && drugDiffDataList.size() > 0) {
			String diffId = recDiff.getId_diff();
			for (MedInsurDrugRecDiffDO medInsurDrugRecDiffDO : drugDiffDataList) {
				medInsurDrugRecDiffDO.setId_diff(diffId);
			}
		}
	}

	/**
	 * 保存差异数据
	 * 
	 * @param diffDatas
	 * @throws BizException
	 */
	private void SaveDiffList(MedInsurDrugRecDiffDO[] diffDatas) throws BizException {
		if (diffDatas != null && diffDatas.length > 0) {
			DAFacade daFacade = new DAFacade();
			daFacade.insertDOs(diffDatas);
		}
	}

	/**
	 * 获取修改数据
	 * 
	 * @param recDiff
	 * @return
	 * @throws BizException
	 */
	private MedInsurDrugRecDiffDO[] GetModifyDatas(MedInsurRecDiffDO recDiff) throws BizException {
		ArrayList<MedInsurDrugRecDiffDO> modifyDataList = new ArrayList<MedInsurDrugRecDiffDO>();
		MedInsurDrugRecDiffDO[] beforeDatas = GetModifyBeforeDatas(recDiff);
		AddDiffDataToList(modifyDataList, beforeDatas);

		MedInsurDrugRecDiffDO[] afterDatas = GetModifyAfterDatas(recDiff);
		AddDiffDataToList(modifyDataList, afterDatas);

		return modifyDataList.toArray(new MedInsurDrugRecDiffDO[0]);
	}

	/**
	 * 获取修改前数据
	 * 
	 * @param recDiff
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private MedInsurDrugRecDiffDO[] GetModifyBeforeDatas(MedInsurRecDiffDO recDiff) throws BizException {
		FindMedIDrugDataDiffSql sql = new FindMedIDrugDataDiffSql(recDiff, AHMedIRecDiffType.BEFOREMODIFY);

		DAFacade daFacade = new DAFacade();
		ArrayList<MedInsurDrugRecDiffDO> diffList = (ArrayList<MedInsurDrugRecDiffDO>) daFacade.execQuery(
				sql.getQrySQLStr(), sql.getQryParameter(null), new BeanListHandler(MedInsurDrugRecDiffDO.class));
		MedInsurDrugRecDiffDO[] result = diffList.toArray(new MedInsurDrugRecDiffDO[0]);
		return result;
	}

	/**
	 * 获取修改后数据
	 * 
	 * @param recDiff
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private MedInsurDrugRecDiffDO[] GetModifyAfterDatas(MedInsurRecDiffDO recDiff) throws BizException {
		FindMedIDrugDataDiffSql sql = new FindMedIDrugDataDiffSql(recDiff, AHMedIRecDiffType.AFTERMODIFY);

		DAFacade daFacade = new DAFacade();
		ArrayList<MedInsurDrugRecDiffDO> diffList = (ArrayList<MedInsurDrugRecDiffDO>) daFacade.execQuery(
				sql.getQrySQLStr(), sql.getQryParameter(null), new BeanListHandler(MedInsurDrugRecDiffDO.class));
		MedInsurDrugRecDiffDO[] result = diffList.toArray(new MedInsurDrugRecDiffDO[0]);
		return result;
	}

	/**
	 * 
	 * 获取删除数据
	 * 
	 * @param recDiff
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private MedInsurDrugRecDiffDO[] GetDelDatas(MedInsurRecDiffDO recDiff) throws BizException {
		FindMedIDrugCountDiffSql sql = new FindMedIDrugCountDiffSql(recDiff, AHMedIRecDiffType.DEL);

		DAFacade daFacade = new DAFacade();
		ArrayList<MedInsurDrugRecDiffDO> diffList = (ArrayList<MedInsurDrugRecDiffDO>) daFacade.execQuery(
				sql.getQrySQLStr(), sql.getQryParameter(null), new BeanListHandler(MedInsurDrugRecDiffDO.class));
		MedInsurDrugRecDiffDO[] result = diffList.toArray(new MedInsurDrugRecDiffDO[0]);
		return result;
	}

	/**
	 * 获取新增数据
	 * 
	 * @param recDiff
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private MedInsurDrugRecDiffDO[] GetAddDatas(MedInsurRecDiffDO recDiff) throws BizException {
		FindMedIDrugCountDiffSql sql = new FindMedIDrugCountDiffSql(recDiff, AHMedIRecDiffType.ADD);

		DAFacade daFacade = new DAFacade();
		ArrayList<MedInsurDrugRecDiffDO> diffList = (ArrayList<MedInsurDrugRecDiffDO>) daFacade.execQuery(
				sql.getQrySQLStr(), sql.getQryParameter(null), new BeanListHandler(MedInsurDrugRecDiffDO.class));
		MedInsurDrugRecDiffDO[] result = diffList.toArray(new MedInsurDrugRecDiffDO[0]);
		return result;
	}

	/**
	 * 添加差异数据到差异数据列表
	 * 
	 * @param drugDiffDataList
	 * @param diffDatas
	 */
	private void AddDiffDataToList(ArrayList<MedInsurDrugRecDiffDO> drugDiffDataList,
			MedInsurDrugRecDiffDO[] diffDatas) {
		if (drugDiffDataList == null || diffDatas == null || diffDatas.length <= 0) {
			return;
		}
		for (MedInsurDrugRecDiffDO medInsurDrugRecDiffDO : diffDatas) {
			drugDiffDataList.add(medInsurDrugRecDiffDO);
		}
	}
}
