package iih.sc.scbd.s.bp;

import javax.servlet.jsp.tagext.PageData;

import iih.sc.apt.dto.d.OralAptMgrDTO;
import iih.sc.scbd.log.d.ScLogRecDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取日志
 * @author renying
 *
 */
public class GetLogRecByQryConditionBP {
	/**
	 * 根据查询条件获取日志
	 * @param qryRootNodeDTO
	 * @param fmap
	 * @return
	 * @throws BizException 
	 */
	public PagingRtnData<ScLogRecDO>  exec(QryRootNodeDTO qryRootNodeDTO,String dataId,PaginationInfo pg ) throws BizException{				
		IQrySQLGeneratorService serv = ServiceFinder.find(IQrySQLGeneratorService.class);		
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT  psndoc.name Name_emp,rec.*");
		sb.append(" FROM sc_log_rec rec");
		sb.append(" inner join bd_psndoc  psndoc ");
		sb.append(" on psndoc.id_psndoc = rec.id_emp ");
		sb.append(" where 1=1 ");
		SqlParam param = new SqlParam();
		if(!StringUtil.isEmpty(dataId)){
			 sb.append("and (id_data = ? or id_parent_data =?)");			
			 param.addParam(dataId);
			 param.addParam(dataId);
		}

		String wherePart = serv.getQueryStringWithoutDesc(qryRootNodeDTO);
		if(!StringUtil.isEmpty(wherePart)){
			 sb.append(" and");
			 sb.append(wherePart);
		}			
		PagingServiceImpl<ScLogRecDO> pageQryService = new PagingServiceImpl<ScLogRecDO>();		
		PagingRtnData<ScLogRecDO> pgRtData = pageQryService.findByPageInfo( new ScLogRecDO(), pg, sb.toString(),  "dt_log DESC",param);		 
		FArrayList data = pgRtData.getPageData();
		if(ListUtil.isEmpty(data)){
			pgRtData.getPagingInfo().setPageCount(0);
		}
		return pgRtData;
		
	}
}
