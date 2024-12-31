package iih.bd.srv.s.bp;

import java.util.ArrayList;
import java.util.List;

import iih.bd.srv.s.bp.qry.GetDpBillFormInfoDOBPSql;
import xap.dp.bfdesigner.d.DpBillFormTDO;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * @author hums
 *
 */
public class GetDpBillFormInfoDOBP {

	/**
	 * 获取表单定义信息
	 * @param metadataclass
	 * @return
	 */
	public DpBillFormTDO[] execQueryBillForm(String metadataclass) throws BizException{
		
		GetDpBillFormInfoDOBPSql bpSql = new GetDpBillFormInfoDOBPSql();
		String sql = bpSql.getBillFormDOSql();
		
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(metadataclass);
		
		List<DpBillFormTDO> formDO = (ArrayList<DpBillFormTDO>)new DAFacade().execQuery(sql, sqlParam, new BeanListHandler(DpBillFormTDO.class));
		return formDO.toArray(new DpBillFormTDO[0]);
		
	}
	
}

