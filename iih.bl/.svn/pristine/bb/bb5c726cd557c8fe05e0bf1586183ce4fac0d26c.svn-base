package iih.bl.hp.s.bp;

import iih.bd.pp.hp.d.BdHpPatcaDO;
import iih.bd.pp.hp.i.IBdHpPatcaDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 获取就诊是否是全保内
 * @author yang.lu 2018年1月25日
 *
 */
public class IsAllInHpBP {
	/**
	 * 获取就诊是否是全保内
	 * @param idEn
	 * @return
	 * @throws BizException
	 */
	public FBoolean exec(String idEn) throws BizException {
		IBdHpPatcaDORService service = ServiceFinder.find(IBdHpPatcaDORService.class);
		String whereStr = " ID_HPPATCA||ID_HP IN (SELECT ID_HPPATCA||ID_HP FROM EN_ENT_HP WHERE FG_MAJ='Y' AND ID_ENT='" + idEn + "')";
		BdHpPatcaDO[] dos = (BdHpPatcaDO[]) service.find(whereStr, "", FBoolean.FALSE);
		if (!ArrayUtil.isEmpty(dos) && dos.length > 0) {
			if (FBoolean.TRUE.equals(dos[0].getFg_allinhp())) {
				return FBoolean.TRUE;
			}
		}
		return FBoolean.FALSE;
	}
}
