package iih.bd.srv.s.bp;

import iih.bd.srv.emrterm.d.EmrTermCaDO;
import iih.bd.srv.s.bp.qry.GetEmrTermCaTreeQry;
import org.apache.commons.lang.StringUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * 获取病例术语分类树数据BP
 * 
 * @author hums
 */
public class GetEmrTermCaTreeBP {

    // 适用范围编码：科室
    private static String EMR_TERM_CA_CODE_KS = "1";
    // 适用范围编码：个人
    private static String EMR_TERM_CA_CODE_GR = "2";
    
	/**
	 * 获取 病例术语分类树
	 * 
	 * @param emrTermCa
	 */
	public EmrTermCaDO[] exec(EmrTermCaDO emrTermCaDO) throws BizException {

		if (validate(emrTermCaDO) == FBoolean.FALSE) {
			return new EmrTermCaDO[0];
		}

		GetEmrTermCaTreeQry qry = new GetEmrTermCaTreeQry(emrTermCaDO);
		EmrTermCaDO[] rtn = (EmrTermCaDO[]) AppFwUtil.getDORstWithDao(qry, EmrTermCaDO.class);
		return rtn;
	}

	/**
	 * 验证传入参数是否符合查询条件规则
	 * 
	 * @param emrTermCaDO
	 * @return
	 */
	private FBoolean validate(EmrTermCaDO emrTermCaDO) {

		// 术语体系编码,适用范围编码(个人、科室、全院) 不能为空
		if (StringUtils.isBlank(emrTermCaDO.getSd_mrtermsys()) || StringUtils.isBlank(emrTermCaDO.getSd_scopetp())) {
			return FBoolean.FALSE;
		}
		// 如果是科室，科室id不能为空
		if(EMR_TERM_CA_CODE_KS.equals(emrTermCaDO.getSd_scopetp()) && StringUtils.isBlank(emrTermCaDO.getId_dep())){
			return FBoolean.FALSE;
		}
		// 如果是个人，创建人id不能为空
		if(EMR_TERM_CA_CODE_GR.equals(emrTermCaDO.getSd_scopetp()) && StringUtils.isBlank(emrTermCaDO.getCreatedby())){
			return FBoolean.FALSE;
		}

		return FBoolean.TRUE;
	}
}
