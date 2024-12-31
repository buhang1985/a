package iih.bl.inc.s.bp.ecinc;

import iih.bl.inc.dto.blecinctrasinfodto.d.BlecinctrasInfoDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
import xap.sys.jdbc.kernel.SqlParam;

public class FindBlecinctrasInfoBP {
	/**
	 * 
	 * 根据时间，就诊类型，患者来查找对应的信息
	 */
	public PagingRtnData<BlecinctrasInfoDTO> exec(QryRootNodeDTO qry,PaginationInfo pg) throws BizException{
		return getsql(qry,pg);
	}

	private PagingRtnData<BlecinctrasInfoDTO> getsql(QryRootNodeDTO qry,PaginationInfo pg) throws BizException{
		IQrySQLGeneratorService qrySQLGeneratorService = ServiceFinder.find(IQrySQLGeneratorService.class);
		//获取查询模板里的条件语句
		String whereSql = qrySQLGeneratorService.getQueryStringWithoutDesc(qry);
		SqlParam sqlParam = new SqlParam();
		StringBuffer sql = new StringBuffer();
		sql.append("select ecinc.id_ecinctras, ");
		sql.append("pat.code as code_pat, ");
		sql.append("pat.name as name_pat, ");
		sql.append("ecinc.bizno code_st, ");
		sql.append("ecinc.dt_oper, ");
		sql.append("ecinc.eu_inctype, ");
		sql.append("ecinc.eu_transtype, ");
		sql.append("ecinc.outputinfo errormsg ");
		sql.append("from bl_ec_inc_tras ecinc ");
		sql.append("inner join pi_pat pat on pat.id_pat = ecinc.id_pat ");

		sql.append("WHERE ecinc.fg_active = 'Y' and ecinc.eu_transstatus = '1'");
		if(!StringUtil.isEmpty(whereSql)){
			sql.append("and ");
			sql.append(whereSql);
		}
	    //获取数据
		BlecinctrasInfoDTO regInfo = new BlecinctrasInfoDTO();
		PagingServiceImpl<BlecinctrasInfoDTO> pageQryService = new PagingServiceImpl<BlecinctrasInfoDTO>();	
		PagingRtnData<BlecinctrasInfoDTO> pgRtData = pageQryService.findByPageInfo(regInfo, pg, sql.toString(), null,sqlParam);
		return pgRtData;

	 }

}
