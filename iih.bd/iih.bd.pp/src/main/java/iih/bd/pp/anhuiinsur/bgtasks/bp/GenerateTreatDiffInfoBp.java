package iih.bd.pp.anhuiinsur.bgtasks.bp;

import java.util.ArrayList;

import iih.bd.pp.anhuiinsur.bgtasks.bp.sql.FindMedITreatCountDiffSql;
import iih.bd.pp.anhuiinsur.bgtasks.bp.sql.FindMedITreatDataDiffSql;
import iih.bd.pp.medinsurrecdiff.d.AHMedIRecDiffType;
import iih.bd.pp.medinsurrecdiff.d.MedInsurRecDiffDO;
import iih.bd.pp.medinsurrecdiff.d.MedInsurTreatRecDiffDO;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 根据差异描述生成诊疗差异信息业务逻辑
 * 
 * @author hao_wu
 *
 */
public class GenerateTreatDiffInfoBp {
	public void exec(MedInsurRecDiffDO recDiff) throws BizException {
		ArrayList<MedInsurTreatRecDiffDO> treatDiffDataList = new ArrayList<MedInsurTreatRecDiffDO>();

		MedInsurTreatRecDiffDO[] addDatas = GetAddDatas(recDiff);
		AddDiffDataToList(treatDiffDataList, addDatas);

		MedInsurTreatRecDiffDO[] delDatas = GetDelDatas(recDiff);
		AddDiffDataToList(treatDiffDataList, delDatas);

		MedInsurTreatRecDiffDO[] modifyDatas = GetModifyDatas(recDiff);
		AddDiffDataToList(treatDiffDataList, modifyDatas);

		SetDiffId(treatDiffDataList, recDiff);
		SaveDiffList(treatDiffDataList.toArray(new MedInsurTreatRecDiffDO[0]));
	}

	/**
	 * 设置差异主键
	 * 
	 * @param treatDiffDataList
	 * @param recDiff
	 */
	private void SetDiffId(ArrayList<MedInsurTreatRecDiffDO> treatDiffDataList, MedInsurRecDiffDO recDiff) {
		if (treatDiffDataList != null && treatDiffDataList.size() > 0) {
			String diffId = recDiff.getId_diff();
			for (MedInsurTreatRecDiffDO MedInsurTreatRecDiffDO : treatDiffDataList) {
				MedInsurTreatRecDiffDO.setId_diff(diffId);
			}
		}
	}

	/**
	 * 保存差异数据
	 * 
	 * @param diffDatas
	 * @throws BizException
	 */
	private void SaveDiffList(MedInsurTreatRecDiffDO[] diffDatas) throws BizException {
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
	private MedInsurTreatRecDiffDO[] GetModifyDatas(MedInsurRecDiffDO recDiff) throws BizException {
		ArrayList<MedInsurTreatRecDiffDO> modifyDataList = new ArrayList<MedInsurTreatRecDiffDO>();
		MedInsurTreatRecDiffDO[] beforeDatas = GetModifyBeforeDatas(recDiff);
		AddDiffDataToList(modifyDataList, beforeDatas);

		MedInsurTreatRecDiffDO[] afterDatas = GetModifyAfterDatas(recDiff);
		AddDiffDataToList(modifyDataList, afterDatas);

		return modifyDataList.toArray(new MedInsurTreatRecDiffDO[0]);
	}

	/**
	 * 获取修改前数据
	 * 
	 * @param recDiff
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private MedInsurTreatRecDiffDO[] GetModifyBeforeDatas(MedInsurRecDiffDO recDiff) throws BizException {
		FindMedITreatDataDiffSql sql = new FindMedITreatDataDiffSql(recDiff, AHMedIRecDiffType.BEFOREMODIFY);
		DAFacade daFacade = new DAFacade();
		ArrayList<MedInsurTreatRecDiffDO> diffList = (ArrayList<MedInsurTreatRecDiffDO>) daFacade.execQuery(
				sql.getQrySQLStr(), sql.getQryParameter(null), new BeanListHandler(MedInsurTreatRecDiffDO.class));
		MedInsurTreatRecDiffDO[] result = diffList.toArray(new MedInsurTreatRecDiffDO[0]);
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
	private MedInsurTreatRecDiffDO[] GetModifyAfterDatas(MedInsurRecDiffDO recDiff) throws BizException {
		FindMedITreatDataDiffSql sql = new FindMedITreatDataDiffSql(recDiff, AHMedIRecDiffType.AFTERMODIFY);

		DAFacade daFacade = new DAFacade();
		ArrayList<MedInsurTreatRecDiffDO> diffList = (ArrayList<MedInsurTreatRecDiffDO>) daFacade.execQuery(
				sql.getQrySQLStr(), sql.getQryParameter(null), new BeanListHandler(MedInsurTreatRecDiffDO.class));
		MedInsurTreatRecDiffDO[] result = diffList.toArray(new MedInsurTreatRecDiffDO[0]);
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
	private MedInsurTreatRecDiffDO[] GetDelDatas(MedInsurRecDiffDO recDiff) throws BizException {
		FindMedITreatCountDiffSql sql = new FindMedITreatCountDiffSql(recDiff, AHMedIRecDiffType.DEL);

		DAFacade daFacade = new DAFacade();
		ArrayList<MedInsurTreatRecDiffDO> diffList = (ArrayList<MedInsurTreatRecDiffDO>) daFacade.execQuery(
				sql.getQrySQLStr(), sql.getQryParameter(null), new BeanListHandler(MedInsurTreatRecDiffDO.class));
		MedInsurTreatRecDiffDO[] result = diffList.toArray(new MedInsurTreatRecDiffDO[0]);
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
	private MedInsurTreatRecDiffDO[] GetAddDatas(MedInsurRecDiffDO recDiff) throws BizException {
		FindMedITreatCountDiffSql sql = new FindMedITreatCountDiffSql(recDiff, AHMedIRecDiffType.ADD);

		DAFacade daFacade = new DAFacade();
		ArrayList<MedInsurTreatRecDiffDO> diffList = (ArrayList<MedInsurTreatRecDiffDO>) daFacade.execQuery(
				sql.getQrySQLStr(), sql.getQryParameter(null), new BeanListHandler(MedInsurTreatRecDiffDO.class));
		MedInsurTreatRecDiffDO[] result = diffList.toArray(new MedInsurTreatRecDiffDO[0]);
		return result;
	}

	/**
	 * 添加差异数据到差异数据列表
	 * 
	 * @param treatDiffDataList
	 * @param diffDatas
	 */
	private void AddDiffDataToList(ArrayList<MedInsurTreatRecDiffDO> treatDiffDataList,
			MedInsurTreatRecDiffDO[] diffDatas) {
		if (treatDiffDataList == null || diffDatas == null || diffDatas.length <= 0) {
			return;
		}
		for (MedInsurTreatRecDiffDO MedInsurTreatRecDiffDO : diffDatas) {
			treatDiffDataList.add(MedInsurTreatRecDiffDO);
		}
	}
}
