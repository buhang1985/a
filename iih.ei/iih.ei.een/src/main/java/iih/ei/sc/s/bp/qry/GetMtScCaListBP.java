package iih.ei.sc.s.bp.qry;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.ei.sc.ws.bean.GetMtScCaListBean;
import java.util.List;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 
 * 获取科室信息
 * 
 * @author yzh
 * 
 * @date 2018年10月29日 14:33:08
 */
public class GetMtScCaListBP {
	
	/**
	 * 获取医技项目分类字典
	 * 
	 * @author yzh
	 * @return
	 * @throws BizException
	 */
	public GetMtScCaListBean[] exec() throws BizException {
		SqlParam param = new SqlParam();
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("select id_scca as idScca,code,name,wbcode,pycode from sc_ca where sd_sctp =? and fg_active=? ");
		param.addParam(IScDictCodeConst.SD_SCTP_MT);
		param.addParam("Y");
		sqlBuilder.append("ORDER BY CODE ");
		List<GetMtScCaListBean> list = (List<GetMtScCaListBean>) new DAFacade().execQuery(sqlBuilder.toString(), param, new BeanListHandler(GetMtScCaListBean.class));
		return ListUtil.isEmpty(list)?null:list.toArray(new GetMtScCaListBean[0]);
	}
}
