package iih.bl.itf.trasnsferandqry.bp;

import org.apache.commons.lang.StringUtils;

import iih.bl.itf.trdtrans.d.BlThirdTransRcdDO;
import iih.bl.itf.trdtrans.d.desc.BlThirdTransRcdDODesc;
import iih.bl.itf.trdtrans.i.ITrdtransrcdRService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.QuerySQLFactory;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 根据业务组查询第三方交易记录
 * @author hanjq
 *
 */
public class FindBlThirdTransByBizGroupBP {

	public PagingRtnData<BlThirdTransRcdDO> exec(QryRootNodeDTO qryRootNodeDTO, String idEmp, String orderStr,
			PaginationInfo pg) throws BizException {
		BlThirdTransRcdDODesc desc = new BlThirdTransRcdDODesc();
		ITrdtransrcdRService service = ServiceFinder.find(ITrdtransrcdRService.class);
		String whereSQLOnly = "1=1";
		if ((qryRootNodeDTO != null) && (qryRootNodeDTO.getChildCount() > 0)) {
			whereSQLOnly = new QuerySQLFactory().getQueryString(qryRootNodeDTO, desc);
		}
		String now = "'"+new FDateTime().toString()+"'";
		idEmp = "'"+idEmp+"'";
		StringBuilder where = new StringBuilder();
		if(StringUtils.isBlank(whereSQLOnly)){
			whereSQLOnly = "1=1";
		}
		where.append(whereSQLOnly);
		where.append(" and ").append(BlThirdTransRcdDODesc.TABLE_ALIAS_NAME).append(".").append(BlThirdTransRcdDO.ID_EMP_OPER);
		where.append(" in (");
		where.append(" select distinct ewg.id_emp ");
		where.append(" from bd_wg wg ");
		where.append(" join bd_emp_wg ewg on ewg.id_wg = wg.id_wg ");
		where.append(" where wg.fg_active = 'Y' ");
		where.append(" and wg.sd_wgtp in ('0301','0302' ) ");
		where.append(" and (ewg.id_emp = ").append(idEmp).append(" or ewg.id_emp_leader = ").append(idEmp).append(")");
		where.append(" and ewg.d_b <= ").append(now).append(" and ewg.d_e >= ").append(now);
		where.append(" )");
		
		return service.findByPageInfo(pg, where.toString(), orderStr);
	}

}
