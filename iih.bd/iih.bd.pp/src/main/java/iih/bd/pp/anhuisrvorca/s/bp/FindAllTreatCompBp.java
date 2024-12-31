package iih.bd.pp.anhuisrvorca.s.bp;

import java.util.ArrayList;

import iih.bd.pp.anhuisrvorca.d.TreatCompDTO;
import iih.bd.pp.anhuisrvorca.s.bp.sql.FindTreatCompSql;
import iih.bd.pp.hp.d.HPDO;
import iih.bd.pp.hpsrvorca.d.HpStatusEnum;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 获取可同步审批的诊疗对照信息业务逻辑
 * 
 * @author hao_wu
 *
 */
public class FindAllTreatCompBp {

	@SuppressWarnings("unchecked")
	public TreatCompDTO[] exec(String hpCode) throws BizException {
		String hpId = GetHpId(hpCode);
		String wherePart = String.format("SRVORCA.EU_STATUS IN ('%s','%s')", HpStatusEnum.UPLOAD, HpStatusEnum.REVIEW);
		FindTreatCompSql sql = new FindTreatCompSql(hpId, wherePart);

		DAFacade daFacade = new DAFacade();
		TreatCompDTO[] result = ((ArrayList<TreatCompDTO>) daFacade.execQuery(sql.getQrySQLStr(),
				sql.getQryParameter(null), new BeanListHandler(TreatCompDTO.class))).toArray(new TreatCompDTO[0]);
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
