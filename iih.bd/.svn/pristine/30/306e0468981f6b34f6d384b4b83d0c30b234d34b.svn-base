package iih.bd.pp.anhuisrvorca.s.bp;

import java.util.ArrayList;

import iih.bd.base.utils.SqlUtils;
import iih.bd.pp.anhuisrvorca.d.DrugCompDTO;
import iih.bd.pp.hpsrvorca.d.HPSrvorcaDO;
import iih.bd.pp.hpsrvorca.d.HpStatusEnum;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 医保药品对照上报撤销业务逻辑
 * 
 * @author hao_wu
 *
 */
public class DrugCompRevokeReportBp {

	public DrugCompDTO[] exec(DrugCompDTO[] drugCompDtos) throws BizException {

		String[] idSrvorcaArr = GetIdSrvorcaArr(drugCompDtos);
		UpdataSrvorcaStatus(idSrvorcaArr);
		for (DrugCompDTO drugCompDTO : drugCompDtos) {
			drugCompDTO.setEu_status(HpStatusEnum.CONTRAST);
		}
		return drugCompDtos;
	}

	/**
	 * 更新医保目录对照状态到已对照
	 * 
	 * @param idSrvorcaArr
	 * @throws BizException
	 */
	private void UpdataSrvorcaStatus(String[] idSrvorcaArr) throws BizException {
		DAFacade daFacade = new DAFacade();
		String sql = GetUpdateSql(idSrvorcaArr);
		daFacade.execUpdate(sql);
	}

	/**
	 * 获取更新Sql
	 * 
	 * @param idSrvorcaArr
	 * @return
	 */
	private String GetUpdateSql(String[] idSrvorcaArr) {
		String baseSql = String.format("UPDATE BD_HP_SRVORCA SET EU_STATUS = '%s'", HpStatusEnum.CONTRAST);
		String whereInPart = SqlUtils.getInSqlByIds(HPSrvorcaDO.ID_HPSRVORCA, idSrvorcaArr);
		return String.format("%s WHERE %s", baseSql, whereInPart);
	}

	/**
	 * 获取医保目录对照主键列表
	 * 
	 * @param drugCompDtos
	 * @return
	 */
	private String[] GetIdSrvorcaArr(DrugCompDTO[] drugCompDtos) {
		ArrayList<String> IdSrvorcaArr = new ArrayList<String>();
		for (DrugCompDTO drugCompDTO : drugCompDtos) {
			IdSrvorcaArr.add(drugCompDTO.getId_hpsrvorca());
		}
		return IdSrvorcaArr.toArray(new String[0]);
	}
}
