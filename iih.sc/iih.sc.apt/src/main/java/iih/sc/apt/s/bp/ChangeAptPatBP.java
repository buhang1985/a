package iih.sc.apt.s.bp;

import iih.sc.apt.s.ep.AptEP;
import iih.sc.apt.scapt.d.ScAptDO;
import iih.sc.comm.ScValidator;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;

/**
 * 更换预约患者BP
 * 
 * @author zhengcm
 * @date 2017-11-03 08:55:47
 *
 */
public class ChangeAptPatBP {

	/**
	 * 更换预约患者
	 *
	 * @author zhengcm
	 * 
	 * @param id_apt
	 * @param id_pat
	 * @throws BizException
	 */
	public void exec(String id_apt, String id_pat) throws BizException {
		// 检查参数
		ScValidator.validateParam("id_apt", id_apt);
		ScValidator.validateParam("id_pat", id_pat);
		// 预约DO
		ScAptDO aptDO = new AptEP().getById(id_apt);
		if (null == aptDO) {
			return;
		}
		// 更换患者
		aptDO.setStatus(DOStatus.UPDATED);
		aptDO.setId_pat(id_pat);
		new AptEP().save(aptDO);
	}

}
