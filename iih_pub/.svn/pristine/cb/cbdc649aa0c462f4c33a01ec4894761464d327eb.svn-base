package iih.bd.pp.service.i;

import iih.bd.pp.anhuisrvorca.d.SrvCompDTO;
import iih.bd.pp.hpdivshisdto.d.HpDiVsHisDTO;
import xap.mw.core.data.BizException;

public interface IPpHpQryService {

	/** 获取医保诊断和his诊断的对照信息
	 * @param strIdHpArr 医保计划ID
	 * @return
	 */
	public abstract HpDiVsHisDTO[] getHpDiVsHisDi(String strIdHp,String[] strHisIdDiArr) throws BizException;
	
	/**获取服务对照信息
	 * @param strIdHp 基本信息
	 * @param strIdSrv
	 * @return
	 * @throws BizException
	 */
	public abstract SrvCompDTO[] getSrvCompDtoLst(String strIdHp,String[] strIdSrv) throws BizException;
}
