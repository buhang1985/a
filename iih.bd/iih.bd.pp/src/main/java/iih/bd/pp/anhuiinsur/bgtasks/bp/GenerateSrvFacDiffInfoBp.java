package iih.bd.pp.anhuiinsur.bgtasks.bp;

import java.util.ArrayList;

import iih.bd.pp.anhuiinsur.bgtasks.bp.sql.FindMedISrvFacCountDiffSql;
import iih.bd.pp.anhuiinsur.bgtasks.bp.sql.FindMedISrvFacDataDiffSql;
import iih.bd.pp.medinsurrecdiff.d.AHMedIRecDiffType;
import iih.bd.pp.medinsurrecdiff.d.MedInsurRecDiffDO;
import iih.bd.pp.medinsurrecdiff.d.MedInsurSrvFacRecDiffDO;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 根据差异描述生成服务设施差异信息业务逻辑
 * 
 * @author hao_wu
 *
 */
public class GenerateSrvFacDiffInfoBp {
	public void exec(MedInsurRecDiffDO recDiff) throws BizException {
		ArrayList<MedInsurSrvFacRecDiffDO> srvFacDiffDataList = new ArrayList<MedInsurSrvFacRecDiffDO>();

		MedInsurSrvFacRecDiffDO[] addDatas = GetAddDatas(recDiff);
		AddDiffDataToList(srvFacDiffDataList, addDatas);

		MedInsurSrvFacRecDiffDO[] delDatas = GetDelDatas(recDiff);
		AddDiffDataToList(srvFacDiffDataList, delDatas);

		MedInsurSrvFacRecDiffDO[] modifyDatas = GetModifyDatas(recDiff);
		AddDiffDataToList(srvFacDiffDataList, modifyDatas);

		SetDiffId(srvFacDiffDataList, recDiff);
		SaveDiffList(srvFacDiffDataList.toArray(new MedInsurSrvFacRecDiffDO[0]));
	}

	/**
	 * 设置差异主键
	 * 
	 * @param srvFacDiffDataList
	 * @param recDiff
	 */
	private void SetDiffId(ArrayList<MedInsurSrvFacRecDiffDO> srvFacDiffDataList, MedInsurRecDiffDO recDiff) {
		if (srvFacDiffDataList != null && srvFacDiffDataList.size() > 0) {
			String diffId = recDiff.getId_diff();
			for (MedInsurSrvFacRecDiffDO MedInsurSrvFacRecDiffDO : srvFacDiffDataList) {
				MedInsurSrvFacRecDiffDO.setId_diff(diffId);
			}
		}
	}

	/**
	 * 保存差异数据
	 * 
	 * @param diffDatas
	 * @throws BizException
	 */
	private void SaveDiffList(MedInsurSrvFacRecDiffDO[] diffDatas) throws BizException {
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
	private MedInsurSrvFacRecDiffDO[] GetModifyDatas(MedInsurRecDiffDO recDiff) throws BizException {
		ArrayList<MedInsurSrvFacRecDiffDO> modifyDataList = new ArrayList<MedInsurSrvFacRecDiffDO>();
		MedInsurSrvFacRecDiffDO[] beforeDatas = GetModifyBeforeDatas(recDiff);
		AddDiffDataToList(modifyDataList, beforeDatas);

		MedInsurSrvFacRecDiffDO[] afterDatas = GetModifyAfterDatas(recDiff);
		AddDiffDataToList(modifyDataList, afterDatas);

		return modifyDataList.toArray(new MedInsurSrvFacRecDiffDO[0]);
	}

	/**
	 * 获取修改前数据
	 * 
	 * @param recDiff
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private MedInsurSrvFacRecDiffDO[] GetModifyBeforeDatas(MedInsurRecDiffDO recDiff) throws BizException {
		FindMedISrvFacDataDiffSql sql = new FindMedISrvFacDataDiffSql(recDiff, AHMedIRecDiffType.BEFOREMODIFY);

		DAFacade daFacade = new DAFacade();
		ArrayList<MedInsurSrvFacRecDiffDO> diffList = (ArrayList<MedInsurSrvFacRecDiffDO>) daFacade.execQuery(
				sql.getQrySQLStr(), sql.getQryParameter(null), new BeanListHandler(MedInsurSrvFacRecDiffDO.class));
		MedInsurSrvFacRecDiffDO[] result = diffList.toArray(new MedInsurSrvFacRecDiffDO[0]);
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
	private MedInsurSrvFacRecDiffDO[] GetModifyAfterDatas(MedInsurRecDiffDO recDiff) throws BizException {
		FindMedISrvFacDataDiffSql sql = new FindMedISrvFacDataDiffSql(recDiff, AHMedIRecDiffType.AFTERMODIFY);

		DAFacade daFacade = new DAFacade();
		ArrayList<MedInsurSrvFacRecDiffDO> diffList = (ArrayList<MedInsurSrvFacRecDiffDO>) daFacade.execQuery(
				sql.getQrySQLStr(), sql.getQryParameter(null), new BeanListHandler(MedInsurSrvFacRecDiffDO.class));
		MedInsurSrvFacRecDiffDO[] result = diffList.toArray(new MedInsurSrvFacRecDiffDO[0]);
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
	private MedInsurSrvFacRecDiffDO[] GetDelDatas(MedInsurRecDiffDO recDiff) throws BizException {
		FindMedISrvFacCountDiffSql sql = new FindMedISrvFacCountDiffSql(recDiff, AHMedIRecDiffType.DEL);

		DAFacade daFacade = new DAFacade();
		ArrayList<MedInsurSrvFacRecDiffDO> diffList = (ArrayList<MedInsurSrvFacRecDiffDO>) daFacade.execQuery(
				sql.getQrySQLStr(), sql.getQryParameter(null), new BeanListHandler(MedInsurSrvFacRecDiffDO.class));
		MedInsurSrvFacRecDiffDO[] result = diffList.toArray(new MedInsurSrvFacRecDiffDO[0]);
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
	private MedInsurSrvFacRecDiffDO[] GetAddDatas(MedInsurRecDiffDO recDiff) throws BizException {
		FindMedISrvFacCountDiffSql sql = new FindMedISrvFacCountDiffSql(recDiff, AHMedIRecDiffType.ADD);

		DAFacade daFacade = new DAFacade();
		ArrayList<MedInsurSrvFacRecDiffDO> diffList = (ArrayList<MedInsurSrvFacRecDiffDO>) daFacade.execQuery(
				sql.getQrySQLStr(), sql.getQryParameter(null), new BeanListHandler(MedInsurSrvFacRecDiffDO.class));
		MedInsurSrvFacRecDiffDO[] result = diffList.toArray(new MedInsurSrvFacRecDiffDO[0]);
		return result;
	}

	/**
	 * 添加差异数据到差异数据列表
	 * 
	 * @param srvFacDiffDataList
	 * @param diffDatas
	 */
	private void AddDiffDataToList(ArrayList<MedInsurSrvFacRecDiffDO> srvFacDiffDataList,
			MedInsurSrvFacRecDiffDO[] diffDatas) {
		if (srvFacDiffDataList == null || diffDatas == null || diffDatas.length <= 0) {
			return;
		}
		for (MedInsurSrvFacRecDiffDO MedInsurSrvFacRecDiffDO : diffDatas) {
			srvFacDiffDataList.add(MedInsurSrvFacRecDiffDO);
		}
	}
}
