package iih.bd.pp.anhuisrvorca.s.bp;

import java.util.ArrayList;

import iih.bd.pp.anhuisrvorca.d.FwssCompDTO;
import iih.bd.pp.anhuisrvorca.s.bp.sql.FindFwssCompSql;
import iih.bd.pp.hp.d.HPDO;
import iih.bd.pp.hpsrvorca.d.HpStatusEnum;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 查询所有可同步审批的服务设施对照信息业务逻辑
 * 
 * @author hao_wu
 *
 */
public class FindAllFwssCompBp {

	@SuppressWarnings("unchecked")
	public FwssCompDTO[] exec(String hpCode) throws BizException {
		String hpId = GetHpId(hpCode);

		String wherePart = String.format("SRVORCA.EU_STATUS IN ('%s','%s')", HpStatusEnum.UPLOAD, HpStatusEnum.REVIEW);
		FindFwssCompSql sql = new FindFwssCompSql(hpId, wherePart);

		DAFacade daFacade = new DAFacade();
		FwssCompDTO[] result = ((ArrayList<FwssCompDTO>) daFacade.execQuery(sql.getQrySQLStr(),
				sql.getQryParameter(null), new BeanListHandler(FwssCompDTO.class))).toArray(new FwssCompDTO[0]);
		return result;
	}

	/**
	 * 获取医保计划主键
	 * 
	 * @param hpCode
	 * @return
	 * @throws BizException
	 */
	private String GetHpId(String hpCode) throws BizException {
		FindHpDoByCodeBp bp = new FindHpDoByCodeBp();
		HPDO hpdo = bp.exec(hpCode);
		return hpdo.getId_hp();
	}
}
