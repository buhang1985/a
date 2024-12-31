package iih.ci.mrfp.cmis.i;

import iih.ci.mrfp.cmis.d.CiMrFpMsgDTO;
import xap.mw.core.data.BizException;

public interface ICMISService {

	/**
	 *  获取病案首页所有信息
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	public abstract CiMrFpMsgDTO getCimrfpdtoAggDTO(String id_ent) throws BizException;
}
