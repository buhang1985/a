package iih.bd.pp.anhuisrvorca.s.bp;

import java.util.ArrayList;

import iih.bd.pp.anhuisrvorca.d.DrugCompDTO;
import iih.bd.pp.anhuisrvorca.s.bp.sql.FindDrugCompSql;
import iih.bd.pp.hp.d.HPDO;
import iih.bd.pp.hpsrvorca.d.HpStatusEnum;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

public class FindAllDrugCompBp {

	@SuppressWarnings("unchecked")
	public DrugCompDTO[] exec(String hpCode) throws BizException {
		String hpId = GetHpId(hpCode);

		String wherePart = String.format("SRVORCA.EU_STATUS IN ('%s','%s','%s','%s')", HpStatusEnum.UPLOAD,
				HpStatusEnum.REVIEW, HpStatusEnum.CONTRAST, HpStatusEnum.REJECT);
		FindDrugCompSql sql = new FindDrugCompSql(hpId, wherePart);

		DAFacade daFacade = new DAFacade();
		DrugCompDTO[] result = ((ArrayList<DrugCompDTO>) daFacade.execQuery(sql.getQrySQLStr(),
				sql.getQryParameter(null), new BeanListHandler(DrugCompDTO.class))).toArray(new DrugCompDTO[0]);
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
