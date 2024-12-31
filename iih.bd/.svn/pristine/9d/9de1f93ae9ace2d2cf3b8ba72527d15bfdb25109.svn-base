package iih.bd.pp.anhuisrvorca.s.bp;

import java.util.ArrayList;

import iih.bd.base.utils.SqlUtils;
import iih.bd.pp.anhuisrvorca.d.TreatCompDTO;
import iih.bd.pp.hpsrvorca.d.HPSrvorcaDO;
import iih.bd.pp.hpsrvorca.d.HpStatusEnum;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 医保诊疗对照上报撤销业务逻辑
 * 
 * @author hao_wu
 *
 */
public class TreatCompRevokeReportBp {
	public TreatCompDTO[] exec(TreatCompDTO[] treatCompDtos) throws BizException {

		String[] idSrvorcaArr = GetIdSrvorcaArr(treatCompDtos);
		UpdataSrvorcaStatus(idSrvorcaArr);
		for (TreatCompDTO treatCompDTO : treatCompDtos) {
			treatCompDTO.setEu_status(HpStatusEnum.CONTRAST);
		}
		return treatCompDtos;
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
	 * @param treatCompDtos
	 * @return
	 */
	private String[] GetIdSrvorcaArr(TreatCompDTO[] treatCompDtos) {
		ArrayList<String> IdSrvorcaArr = new ArrayList<String>();
		for (TreatCompDTO treatCompDTO : treatCompDtos) {
			IdSrvorcaArr.add(treatCompDTO.getId_hpsrvorca());
		}
		return IdSrvorcaArr.toArray(new String[0]);
	}

}
