package iih.bd.pp.anhuisrvorca.s.bp;

import java.util.ArrayList;

import iih.bd.base.utils.SqlUtils;
import iih.bd.pp.anhuisrvorca.d.DrugCompDTO;
import iih.bd.pp.anhuisrvorca.s.bp.sql.RevokeMediReportSql;
import iih.bd.pp.hpsrvorca.d.HPSrvorcaDO;
import iih.bd.pp.hpsrvorca.d.HpSrvTpEnum;
import iih.bd.pp.hpsrvorca.d.HpStatusEnum;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;

public class RevokeMediReportBp {

	/**
	 * 医保上报撤销
	 * @param drugCompDTOs
	 * @return
	 * @throws BizException
	 */
	public DrugCompDTO[] exec(DrugCompDTO[] drugCompDTOs) throws BizException {
		if(drugCompDTOs == null || drugCompDTOs.length ==0){
			return null;
		}
		DrugCompDTO[] result = revokeMediReport(drugCompDTOs);
		if (result != null && result.length > 0) {
			AutoGenerateSrvctr(result[0].getId_hp());
		}
		return result;
	}

	/**
	 * 自动生成医保计划控制策略
	 * @param id_hp
	 * @throws BizException
	 */
	private void AutoGenerateSrvctr(String id_hp) throws BizException {
		AutoGenerateSrvctrBp bp = new AutoGenerateSrvctrBp();
		bp.exec(id_hp, HpSrvTpEnum.DRUG);
	}

	/**
	 * 执行SQL
	 * @param drugCompDTOs
	 * @return
	 * @throws DAException
	 */
	private DrugCompDTO[] revokeMediReport(DrugCompDTO[] drugCompDTOs) throws DAException {
		String wherePart = getWherePart(drugCompDTOs);
		RevokeMediReportSql sql = new RevokeMediReportSql(wherePart);
		DAFacade daFacade = new DAFacade();
		daFacade.execUpdate(sql.getQrySQLStr());
		
		UpdateDrugCompDTO(drugCompDTOs);
		return drugCompDTOs;
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
	
	
	private String getWherePart(DrugCompDTO[] drugCompDTOs) {
		ArrayList<String> list = new ArrayList<String>();
		for (DrugCompDTO drugCompDTO : drugCompDTOs) {
			list.add(drugCompDTO.getId_hpsrvorca());
		}
		String[] id_hpsrvorca = list.toArray(new String[0]);
		
		String wherePart = SqlUtils.getInSqlByIds(HPSrvorcaDO.ID_HPSRVORCA, id_hpsrvorca);
		return wherePart;
	}

}
