package iih.ci.ord.s.ems.op.fee;

import iih.ci.sdk.utils.StringUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 
 * @ClassName:  OprFeelBP   
 * @description 费用操作BP
 * @author      chenxiang
 * @date        2020年6月17日 
 * @version:    1.0
 */
public class OprFeelBP {

	/**
	 * 	临床费用项目数量是否可调整
	 * 
	 * @param code_or	医嘱编码
	 * @param id_srv_bl 定价服务id
	 * @return
	 * @throws BizException
	 */
	public FBoolean isQuantityAdjustable(String code_or, String id_srv_bl) throws BizException {
		StringBuilder sb = new StringBuilder();
		SqlParam param = new SqlParam();
		sb.append("select a.fg_adjustable ")
		  .append("from bd_pri_srv_comp a ")
		  .append("join ci_or_srv b on a.id_srv = b.id_srv ")
		  .append("join ci_order c on b.id_or = c.id_or and c.code_or = ? ")
		  .append("where a.id_srv_bl = ? and a.ds = 0 ");
		param.addParam(code_or);
		param.addParam(id_srv_bl);
		String fg_adjustable = (String) new DAFacade().execQuery(sb.toString(), param, new ColumnHandler());
		if (StringUtils.isNotEmpty(fg_adjustable) && "Y".equals(fg_adjustable)) {
			return FBoolean.TRUE;
		}
		return FBoolean.FALSE;
	}
}
