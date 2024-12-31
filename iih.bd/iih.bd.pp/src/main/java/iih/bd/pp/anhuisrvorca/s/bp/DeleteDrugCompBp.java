package iih.bd.pp.anhuisrvorca.s.bp;

import java.util.ArrayList;

import iih.bd.base.utils.SqlUtils;
import iih.bd.pp.anhuisrvorca.d.DrugCompDTO;
import iih.bd.pp.anhuisrvorca.s.bp.sql.DeleteDrugCompSql;
import iih.bd.pp.hpsrvorca.d.HPSrvorcaDO;
import iih.bd.pp.hpsrvorca.d.HpSrvTpEnum;
import iih.bd.pp.hpsrvorca.d.HpStatusEnum;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 删除药品对照业务逻辑
 * 
 * @author hao_wu
 *
 */
public class DeleteDrugCompBp {

	public DrugCompDTO[] exec(DrugCompDTO[] drugCompDTOs) throws BizException {
		if (drugCompDTOs == null || drugCompDTOs.length <= 0) {
			return null;
		}
		DrugCompDTO[] result = DeleteDrugComp(drugCompDTOs);
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
		bp.exec(hpId, HpSrvTpEnum.DRUG);
	}

	/**
	 * 删除医保药品目录对照数据
	 * 
	 * @param drugCompDTOs
	 * @return
	 * @throws BizException
	 */
	private DrugCompDTO[] DeleteDrugComp(DrugCompDTO[] drugCompDTOs) throws BizException {
		String wherePart = GetWherePart(drugCompDTOs);
		DeleteDrugCompSql sql = new DeleteDrugCompSql(wherePart);
		DAFacade daFacade = new DAFacade();
		daFacade.execUpdate(sql.getQrySQLStr(), sql.getQryParameter(null));
		UpdateDrugCompDTO(drugCompDTOs);
		return drugCompDTOs;
	}

	/**
	 * 获取条件语句
	 * 
	 * @param drugCompDTOs
	 * @return
	 */
	private String GetWherePart(DrugCompDTO[] drugCompDTOs) {
		String[] idhpsrvorcaArr = GetIdHpSrvorcaArr(drugCompDTOs);
		String wherePart = SqlUtils.getInSqlByIds(HPSrvorcaDO.ID_HPSRVORCA, idhpsrvorcaArr);
		return wherePart;
	}

	/**
	 * 更新DTO数据
	 * 
	 * @param drugCompDTOs
	 */
	private void UpdateDrugCompDTO(DrugCompDTO[] drugCompDTOs) {
		for (DrugCompDTO drugCompDTO : drugCompDTOs) {
			ClearInsurDrugDataBp bp = new ClearInsurDrugDataBp();
			bp.exec(drugCompDTO);
			drugCompDTO.setEu_status(HpStatusEnum.NOT_MATCHED);
			drugCompDTO.setStatus(DOStatus.UNCHANGED);
		}
	}

	/**
	 * 获取对照主键列表
	 * 
	 * @param drugCompDTOs
	 * @return
	 */
	private String[] GetIdHpSrvorcaArr(DrugCompDTO[] drugCompDTOs) {
		ArrayList<String> pkList = new ArrayList<String>();
		for (DrugCompDTO hpDiVsHisDTO : drugCompDTOs) {
			pkList.add(hpDiVsHisDTO.getId_hpsrvorca());
		}
		return pkList.toArray(new String[0]);
	}
}
