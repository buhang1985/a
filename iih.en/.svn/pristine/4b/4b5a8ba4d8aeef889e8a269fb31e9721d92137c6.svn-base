package iih.en.pv.s.bp.ip.qry;

import iih.en.comm.validator.EnValidator;
import iih.pi.reg.pat.d.PatDO;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;

/***
 * 根据患者id获取患者真实头像
 * @author zhangpp
 *
 */
public class GetImageByPatIdBP {

	public PatDO getImageByPatId(String patId) throws BizException {
		if (EnValidator.isEmpty(patId)) {
			return null;
		}
		PatDO image = getImage(patId);
		return image;
	}

	private PatDO getImage(String patId) throws BizException {
		return (PatDO) new DAFacade().findByPK(PatDO.class, patId, new String[] { PatDO.ID_PAT, PatDO.PHOTO });
	}
	
}
