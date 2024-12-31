package iih.bl.cg.s.bp;

import iih.bd.pp.pripm.i.IBdPripmCodeConst;
import iih.bl.st.blpaypatoep.d.BlPayItmPatOepDO;
import iih.bl.st.blpaypatoep.i.IBlPayItmPatOepDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 根据记账主表 编号获取费医保交付金额
 * @author Administrator
 *
 */
public class GetPatAmtByCgIdBP {

	public double exec(String idcg) throws BizException {
		FDouble retDouble = FDouble.ZERO_DBL;
		if (!StringUtil.isEmpty(idcg)) {
			IBlPayItmPatOepDORService service = ServiceFinder.find(IBlPayItmPatOepDORService.class);
			String sqlWhere = " ID_PAYPATOEP in (SELECT ID_PAYPATOEP FROM  BL_ST_OEP WHERE ID_STOEP=(SELECT ID_STOEP FROM BL_CG_ITM_OEP WHERE ID_CGOEP='" + idcg + "' AND ROWNUM=1))";
			BlPayItmPatOepDO[] dos = service.find(sqlWhere, "", FBoolean.FALSE);
			if (dos != null && dos.length != 0) {
				for (BlPayItmPatOepDO paydo : dos) {
					if (!IBdPripmCodeConst.ID_PRI_PM_INSURPERSONALACCOUNT.equals(paydo.getId_pm()) && !IBdPripmCodeConst.ID_PRI_PM_INSUR.equals(paydo.getId_pm())) {
						retDouble = retDouble.add(paydo.getAmt());
					}
				}
			}

		}
		return retDouble.toDouble();
	}
}
