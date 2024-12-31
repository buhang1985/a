package iih.bd.srv.s.bp;

import iih.bd.srv.emrterm.d.EmrTermDO;
import iih.bd.srv.s.bp.qry.GetEmrTermQry;
import org.apache.commons.lang.StringUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * 获取术语BP
 * 
 * @author hums
 *
 */
public class GetEmrTermBP {

	/**
	 * 获取 获取病例术语分类树
	 * 
	 * @param emrTermCa
	 */
	public EmrTermDO[] exec(EmrTermDO emrTermDO, String inputStr) throws BizException {

		if (validate(emrTermDO) == FBoolean.FALSE) {
			return new EmrTermDO[0];
		}

		GetEmrTermQry qry = new GetEmrTermQry(emrTermDO,inputStr);
		EmrTermDO[] rtn = (EmrTermDO[]) AppFwUtil.getDORstWithDao(qry, EmrTermDO.class);
		return rtn;
	}

	/**
	 * 验证必要的查询条件是否为空
	 * @param emrTermDO 查询条件
	 * @return
	 */
	private FBoolean validate(EmrTermDO emrTermDO) {

		// 术语体系,所属科室,适用范围：个人、科室、全院
		if (StringUtils.isBlank(emrTermDO.getSd_mrtermsys()) || StringUtils.isBlank(emrTermDO.getId_mratermca())) {
			return FBoolean.FALSE;
		}

		return FBoolean.TRUE;
	}

}
