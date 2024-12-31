package iih.bd.pp.anhuisrvorca.s.bp;

import java.util.ArrayList;

import iih.bd.base.utils.SqlUtils;
import iih.bd.pp.anhuisrvorca.d.FwssCompDTO;
import iih.bd.pp.anhuisrvorca.s.bp.sql.DeleteFwssCompSql;
import iih.bd.pp.hpsrvorca.d.HPSrvorcaDO;
import iih.bd.pp.hpsrvorca.d.HpSrvTpEnum;
import iih.bd.pp.hpsrvorca.d.HpStatusEnum;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 删除服务设施对照业务逻辑
 * 
 * @author hao_wu
 *
 */
public class DeleteFwssCompBp {

	public FwssCompDTO[] exec(FwssCompDTO[] fwssCompDTOs) throws BizException {
		if (fwssCompDTOs == null || fwssCompDTOs.length <= 0) {
			return null;
		}
		FwssCompDTO[] result = DeleteFwssComp(fwssCompDTOs);
		if (result != null && result.length > 0) {
			AutoGenerateSrvctr(result[0].getId_hp());
		}
		return result;
	}

	/**
	 * 自动生成医保计划控制策略
	 * 
	 * @throws BizException
	 */
	private void AutoGenerateSrvctr(String hpId) throws BizException {
		AutoGenerateSrvctrBp bp = new AutoGenerateSrvctrBp();
		bp.exec(hpId, HpSrvTpEnum.FWSS);
	}

	/**
	 * 删除医保服务设施目录对照数据
	 * 
	 * @param fwssCompDTOs
	 * @return
	 * @throws BizException
	 */
	private FwssCompDTO[] DeleteFwssComp(FwssCompDTO[] fwssCompDTOs) throws BizException {
		String wherePart = GetWherePart(fwssCompDTOs);
		DeleteFwssCompSql sql = new DeleteFwssCompSql(wherePart);
		DAFacade daFacade = new DAFacade();
		daFacade.execUpdate(sql.getQrySQLStr(), sql.getQryParameter(null));
		UpdateFwssCompDTO(fwssCompDTOs);
		return fwssCompDTOs;
	}

	/**
	 * 获取条件语句
	 * 
	 * @param fwssCompDTOs
	 * @return
	 */
	private String GetWherePart(FwssCompDTO[] fwssCompDTOs) {
		String[] idhpsrvorcaArr = GetIdHpSrvorcaArr(fwssCompDTOs);
		String wherePart = SqlUtils.getInSqlByIds(HPSrvorcaDO.ID_HPSRVORCA, idhpsrvorcaArr);
		return wherePart;
	}

	/**
	 * 更新DTO数据
	 * 
	 * @param fwssCompDTOs
	 */
	private void UpdateFwssCompDTO(FwssCompDTO[] fwssCompDTOs) {
		for (FwssCompDTO fwssCompDTO : fwssCompDTOs) {
			ClearInsurFwssDataBp bp = new ClearInsurFwssDataBp();
			bp.exec(fwssCompDTO);
			fwssCompDTO.setEu_status(HpStatusEnum.NOT_MATCHED);
			fwssCompDTO.setStatus(DOStatus.UNCHANGED);
		}
	}

	/**
	 * 获取对照主键列表
	 * 
	 * @param fwssCompDTOs
	 * @return
	 */
	private String[] GetIdHpSrvorcaArr(FwssCompDTO[] fwssCompDTOs) {
		ArrayList<String> pkList = new ArrayList<String>();
		for (FwssCompDTO hpDiVsHisDTO : fwssCompDTOs) {
			pkList.add(hpDiVsHisDTO.getId_hpsrvorca());
		}
		return pkList.toArray(new String[0]);
	}
}
