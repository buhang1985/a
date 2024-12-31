package iih.bd.pp.anhuisrvorca.s.bp;

import java.util.ArrayList;

import iih.bd.base.utils.SqlUtils;
import iih.bd.pp.anhuisrvorca.d.TreatCompDTO;
import iih.bd.pp.anhuisrvorca.s.bp.sql.DeleteTreatCompSql;
import iih.bd.pp.hpsrvorca.d.HPSrvorcaDO;
import iih.bd.pp.hpsrvorca.d.HpSrvTpEnum;
import iih.bd.pp.hpsrvorca.d.HpStatusEnum;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 删除诊疗对照业务逻辑
 * 
 * @author hao_wu
 *
 */
public class DeleteTreatCompBp {

	public TreatCompDTO[] exec(TreatCompDTO[] treatCompDTOs) throws BizException {
		if (treatCompDTOs == null || treatCompDTOs.length <= 0) {
			return null;
		}
		TreatCompDTO[] result = DeleteTreatComp(treatCompDTOs);
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
		bp.exec(hpId, HpSrvTpEnum.ZL);
	}

	/**
	 * 删除医保诊疗目录对照数据
	 * 
	 * @param treatCompDTOs
	 * @return
	 * @throws BizException
	 */
	private TreatCompDTO[] DeleteTreatComp(TreatCompDTO[] treatCompDTOs) throws BizException {
		String wherePart = GetWherePart(treatCompDTOs);
		DeleteTreatCompSql sql = new DeleteTreatCompSql(wherePart);
		DAFacade daFacade = new DAFacade();
		daFacade.execUpdate(sql.getQrySQLStr(), sql.getQryParameter(null));
		UpdateTreatCompDTO(treatCompDTOs);
		return treatCompDTOs;
	}

	/**
	 * 获取条件语句
	 * 
	 * @param treatCompDTOs
	 * @return
	 */
	private String GetWherePart(TreatCompDTO[] treatCompDTOs) {
		String[] idhpsrvorcaArr = GetIdHpSrvorcaArr(treatCompDTOs);
		String wherePart = SqlUtils.getInSqlByIds(HPSrvorcaDO.ID_HPSRVORCA, idhpsrvorcaArr);
		return wherePart;
	}

	/**
	 * 更新DTO数据
	 * 
	 * @param treatCompDTOs
	 */
	private void UpdateTreatCompDTO(TreatCompDTO[] treatCompDTOs) {
		for (TreatCompDTO treatCompDTO : treatCompDTOs) {
			ClearInsurTreatDataBp bp = new ClearInsurTreatDataBp();
			bp.exec(treatCompDTO);
			treatCompDTO.setEu_status(HpStatusEnum.NOT_MATCHED);
			treatCompDTO.setStatus(DOStatus.UNCHANGED);
		}
	}

	/**
	 * 获取对照主键列表
	 * 
	 * @param treatCompDTOs
	 * @return
	 */
	private String[] GetIdHpSrvorcaArr(TreatCompDTO[] treatCompDTOs) {
		ArrayList<String> pkList = new ArrayList<String>();
		for (TreatCompDTO hpDiVsHisDTO : treatCompDTOs) {
			pkList.add(hpDiVsHisDTO.getId_hpsrvorca());
		}
		return pkList.toArray(new String[0]);
	}
}
