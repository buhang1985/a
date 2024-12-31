package iih.bd.pp.anhuisrvorca.s.bp;

import java.util.ArrayList;

import iih.bd.base.utils.SqlUtils;
import iih.bd.pp.anhuisrvorca.d.FwssCompDTO;
import iih.bd.pp.hpsrvorca.d.HPSrvorcaDO;
import iih.bd.pp.hpsrvorca.d.HpStatusEnum;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 安徽东软医保_服务设施对照审核驳回业务逻辑
 * 
 * @author hao_wu
 *
 */
public class FwssCompRejectBp {
	public FwssCompDTO[] exec(FwssCompDTO[] fwssCompDTOs) throws BizException {
		String[] idSrvorcaArr = GetIdSrvorcaArr(fwssCompDTOs);
		UpdataSrvorcaStatus(idSrvorcaArr);
		for (FwssCompDTO fwssCompDTO : fwssCompDTOs) {
			fwssCompDTO.setEu_status(HpStatusEnum.REJECT);
		}
		return fwssCompDTOs;
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
		String baseSql = String.format("UPDATE BD_HP_SRVORCA SET EU_STATUS = '%s'", HpStatusEnum.REJECT);
		String whereInPart = SqlUtils.getInSqlByIds(HPSrvorcaDO.ID_HPSRVORCA, idSrvorcaArr);
		return String.format("%s WHERE %s", baseSql, whereInPart);
	}

	/**
	 * 获取医保目录对照主键列表
	 * 
	 * @param drugCompDtos
	 * @return
	 */
	private String[] GetIdSrvorcaArr(FwssCompDTO[] fwssCompDTOs) {
		ArrayList<String> IdSrvorcaArr = new ArrayList<String>();
		for (FwssCompDTO fwssCompDTO : fwssCompDTOs) {
			IdSrvorcaArr.add(fwssCompDTO.getId_hpsrvorca());
		}
		return IdSrvorcaArr.toArray(new String[0]);
	}
}
