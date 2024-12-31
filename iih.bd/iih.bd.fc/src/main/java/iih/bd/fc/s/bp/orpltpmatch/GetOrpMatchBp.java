package iih.bd.fc.s.bp.orpltpmatch;

import iih.bd.fc.ormatchorpltp.d.OrpltpMatchParamDTO;
import iih.bd.fc.orpltp.d.OrpltpDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

/**
 * @Description:医嘱闭环匹配处理
 * @author: tian.cj
 * @version：2019年11月7日 上午10:41:11 创建
 */
public class GetOrpMatchBp {

	/**
	 * 医嘱闭环匹配
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public OrpltpDO[] ordltpMatch(OrpltpMatchParamDTO param) throws BizException {
		String orpltp_match = this.getMatchVer();
		if ("1".equals(orpltp_match)) {
			// 1.0版本匹配
			GetOrpltpMatchBp bp = new GetOrpltpMatchBp();
			OrpltpDO rtn = bp.exec(param);
			return new OrpltpDO[] { rtn };
		} else {
			// 2.0版本匹配
			GetOrpltpMatchAttrBp bp = new GetOrpltpMatchAttrBp();
			OrpltpDO rtn = bp.exec(param);
			return new OrpltpDO[] { rtn };
		}
	}

	/**
	 * 获取闭环匹配版本
	 * @return
	 * @throws BizException
	 */
	private String getMatchVer() throws BizException {
		return ParamsetQryUtil.getParaString(Context.get().getOrgId(), "BDFC0002");
	}
}
