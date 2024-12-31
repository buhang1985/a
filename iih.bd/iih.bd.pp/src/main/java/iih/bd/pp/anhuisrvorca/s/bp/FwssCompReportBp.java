package iih.bd.pp.anhuisrvorca.s.bp;

import java.util.ArrayList;

import iih.bd.base.utils.SqlUtils;
import iih.bd.pp.anhuisrvorca.d.FwssCompDTO;
import iih.bd.pp.hpsrvorca.d.HPSrvorcaDO;
import iih.bd.pp.hpsrvorca.d.HpStatusEnum;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 医保服务设施对照上报业务逻辑
 * 
 * @author hao_wu
 *
 */
public class FwssCompReportBp {
	public FwssCompDTO[] exec(FwssCompDTO[] fwssCompDtos) throws BizException {

		String[] idSrvorcaArr = GetIdSrvorcaArr(fwssCompDtos);
		UpdataSrvorcaStatus(idSrvorcaArr);
		for (FwssCompDTO drugCompDTO : fwssCompDtos) {
			drugCompDTO.setEu_status(HpStatusEnum.UPLOAD);
		}
		return fwssCompDtos;
	}

	/**
	 * 更新医保目录对照状态到已上传
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
		String baseSql = String.format("UPDATE BD_HP_SRVORCA SET EU_STATUS = '%s'", HpStatusEnum.UPLOAD);
		String whereInPart = SqlUtils.getInSqlByIds(HPSrvorcaDO.ID_HPSRVORCA, idSrvorcaArr);
		return String.format("%s WHERE %s", baseSql, whereInPart);
	}

	/**
	 * 获取医保目录对照主键列表
	 * 
	 * @param fwssCompDtos
	 * @return
	 */
	private String[] GetIdSrvorcaArr(FwssCompDTO[] fwssCompDtos) {
		ArrayList<String> IdSrvorcaArr = new ArrayList<String>();
		for (FwssCompDTO drugCompDTO : fwssCompDtos) {
			IdSrvorcaArr.add(drugCompDTO.getId_hpsrvorca());
		}
		return IdSrvorcaArr.toArray(new String[0]);
	}

}
