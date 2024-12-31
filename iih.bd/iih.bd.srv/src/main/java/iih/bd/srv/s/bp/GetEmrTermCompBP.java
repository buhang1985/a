package iih.bd.srv.s.bp;

import org.apache.commons.lang3.StringUtils;

import iih.bd.srv.emrterm.d.EmrEvent4TermDO;
import iih.bd.srv.emrterm.d.EmrTermCompDO;
import iih.bd.srv.s.bp.qry.GetEmrTermCompQry;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * 获取术语事件关联的组件
 * 
 * @author hums
 *
 */
public class GetEmrTermCompBP {

	/**
	 * 根据术语事件获取对应组件
	 * @param emrEvent4Term 术语事件
	 * @return 关联组件
	 * @throws BizException
	 */
	public EmrTermCompDO[] exec(EmrEvent4TermDO emrEvent4Term) throws BizException {

		// 验证入参是否合法
		if (validate(emrEvent4Term) == FBoolean.FALSE) {
			return new EmrTermCompDO[0];
		}

		GetEmrTermCompQry qry = new GetEmrTermCompQry(emrEvent4Term);
		EmrTermCompDO[] rtn = (EmrTermCompDO[]) AppFwUtil.getDORstWithDao(qry, EmrTermCompDO.class);
		return rtn;
	}

	/**
	 * 验证参数是否正确
	 * 
	 * @param emrEvent4Term
	 *            验证参数
	 * @return
	 */
	private FBoolean validate(EmrEvent4TermDO emrEvent4Term) {

		if (StringUtils.isBlank(emrEvent4Term.getId_mraet())) {
			return FBoolean.FALSE;
		}
		return FBoolean.TRUE;
	}
}
