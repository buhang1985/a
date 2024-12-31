package iih.bl.inc.s.bp.validate;

import java.util.List;

import iih.bd.pp.hp.d.HPDO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 是否打印红冲发票
 * 
 * @author yang.lu
 *
 */
public class IsPrintRedIncBP {

	/**
	 * 是否打印红冲发票
	 * 
	 * @param entId
	 *            就诊ID
	 * @return FBoolean
	 * @throws BizException
	 * @author yang.lu
	 */
	public FBoolean exec(String entId) throws BizException {
		FBoolean hasRedbackInc = FBoolean.FALSE; // 是否打印红冲发票

		// 1.查询就这些的医保计划
		String id_hp = "";
		DAFacade dafacade = new DAFacade();
		String[] fields = { "id_hp" };
		List<PatiVisitDO> PatiVisitDOList = (List<PatiVisitDO>) dafacade.findByCond(PatiVisitDO.class, " id_ent='" + entId + "'", fields);
		if (PatiVisitDOList != null && PatiVisitDOList.size() > 0) {
			id_hp = PatiVisitDOList.toArray(new PatiVisitDO[] {})[0].getId_hp();// 主医保计划
		}

		FBoolean fG_SABINC = FBoolean.FALSE;
		Integer EU_SABINCPRN = 1;

		// 2.查询医保计划下，是否设置打印红冲票
		fields = new String[] { "fg_sabinc", "eu_sabincprn" };
		List<HPDO> HPDOList = (List<HPDO>) dafacade.findByCond(HPDO.class, " id_hp='" + id_hp + "'", fields);
		if (HPDOList != null && HPDOList.size() > 0) {
			fG_SABINC = HPDOList.toArray(new HPDO[] {})[0].getFg_sabinc();
			EU_SABINCPRN = HPDOList.toArray(new HPDO[] {})[0].getEu_sabincprn();
		}

		// 3.是否打印红冲票
		// String FPrintInsurRedInc =
		// BlParamUtils.getFPrintInsurRedInc(Context.get().getOrgId());
		FBoolean printRedInc = FBoolean.FALSE;

		// 4.结合2,3判断，是否打印红冲票
		if (fG_SABINC != null && EU_SABINCPRN != null && fG_SABINC.booleanValue()) {
			printRedInc = FBoolean.TRUE;
		}
		// else // 如果没有在医保计划（自费的可能会没有医保）中定义，则查配置参数
		// {
		// if ((new FBoolean(FPrintInsurRedInc)).booleanValue()) {
		// printRedInc = FBoolean.TRUE;
		// }
		// }
		return printRedInc;
	}
}
