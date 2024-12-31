package iih.mi.itf2.service.bp.bdservice.drug;

import java.util.ArrayList;

import iih.bd.base.utils.SqlUtils;
import iih.bd.pp.hpsrvorca.d.HPSrvorcaDO;
import iih.mi.itf2.dto.drugmanualcomp.d.DrugManualCompDTO;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;

public class ReplaceDataBP {
	public DrugManualCompDTO[] exec(DrugManualCompDTO[] drugManualCompList) throws BizException{
		String[] idSrvorcaArr = GetIdSrvorcaArr(drugManualCompList);
		UpdataSrvorcaStatus(idSrvorcaArr,drugManualCompList[0].getEu_status());
		return drugManualCompList;
	}
	
	/**
	 * 更新医保目录对照状态到已审核
	 * 
	 * @param idSrvorcaArr
	 * @throws BizException
	 */
	private void UpdataSrvorcaStatus(String[] idSrvorcaArr,String eu_status) throws BizException {
		DAFacade daFacade = new DAFacade();
		String sql = GetUpdateSql(idSrvorcaArr,eu_status);
		daFacade.execUpdate(sql);
	}
	
	/**
	 * 获取更新Sql
	 * 
	 * @param idSrvorcaArr
	 * @return
	 */
	private String GetUpdateSql(String[] idSrvorcaArr,String eu_status) {
		String baseSql = String.format("UPDATE BD_HP_SRVORCA SET EU_STATUS = '%s'", eu_status);
		String whereInPart = SqlUtils.getInSqlByIds(HPSrvorcaDO.ID_HPSRVORCA, idSrvorcaArr);
		return String.format("%s WHERE %s", baseSql, whereInPart);
	}
	
	/**
	 * 获取医保目录对照主键列表
	 * 
	 * @param drugCompDtos
	 * @return
	 */
	private String[] GetIdSrvorcaArr(DrugManualCompDTO[] drugManualCompList) {
		ArrayList<String> IdSrvorcaArr = new ArrayList<String>();
		for (DrugManualCompDTO drugManualCompDTO : drugManualCompList) {
			IdSrvorcaArr.add(drugManualCompDTO.getId_hpsrvorca());
		}
		return IdSrvorcaArr.toArray(new String[0]);
	}
}
