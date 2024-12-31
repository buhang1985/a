package iih.bd.srv.reportcardtpl.s;

import java.util.ArrayList;

import iih.bd.srv.reportcardtpl.d.ReportCardTplDo;
import iih.bd.srv.reportcardtpl.i.IReportcardtpldtoCurdService;
import iih.bd.srv.reportcardtpldto.d.Reportcardtpldto;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.permfw.pub.EnvContextUtil;

/**
 * @author wang.yulong
 * 报卡模板dto查询实现类
 */
@Service(serviceInterfaces={IReportcardtpldtoCurdService.class}, binding=Binding.JSONRPC)
public class ReportcardtpldtoCurdServiceImpl extends PagingServiceImpl<Reportcardtpldto> implements IReportcardtpldtoCurdService {

	
	/**
	 * @param reportCardTplId 报卡模板Id
	 * @param pageInx 页号
	 * @return 当前页的dto集合
	 * @throws BizException 
	 * @throws BizException 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Reportcardtpldto[] findTplDtos(String reportcardTypeId, int pageInx) throws BizException {
		
		String sql = bulidSql(reportcardTypeId);
		
		DAFacade daFacade = new DAFacade();
		ArrayList<Reportcardtpldto> result = (ArrayList<Reportcardtpldto>) daFacade.execQuery(sql,new BeanListHandler(Reportcardtpldto.class));
		System.out.println("-----"+result);
		
		Reportcardtpldto[] tplDtoArrays = new Reportcardtpldto[result.size()]; 
		result.toArray(tplDtoArrays);
		return tplDtoArrays;
	}
	
	
	/**
	 * 适配框架，分页查询接口
	 * @param reportcardTypeId
	 * @param paginationInfo
	 * @return
	 */
	@Override
	public PagingRtnData<Reportcardtpldto> findTplDtosByPageInfo(String reportcardTypeId,PaginationInfo paginationInfo) throws BizException
	{
		String sql = bulidSql(reportcardTypeId);
		
		PagingRtnData<Reportcardtpldto> pagingRtnData = super.findByPageInfo(new Reportcardtpldto(), paginationInfo, sql, "", null);
		return pagingRtnData;
	}
	
	//构建查询报卡模板dto相关sql
	private String bulidSql(String reportcardTypeId)
	{
		StringBuilder sql = new StringBuilder();
		sql.append("select distinct ");
		sql.append("bd_rcm_tpl.id_bd_rcm_tpl as id_bd_rcm_tpl,");
		sql.append("bd_rcm_tpl.id_bd_rcm_tp as id_bd_rcm_tp,");
		sql.append("bd_rcm_tpl.id_org as id_org,");
		sql.append("bd_rcm_tpl.name as name,");
		sql.append("bd_rcm_tpl.code as code,");
		sql.append("bd_rcm_tpl.wbcode as wbcode,");
		sql.append("bd_rcm_tpl.pycode as pycode,");
		sql.append("bd_rcm_tpl.mnecode as mnecode,");
		sql.append("bd_rcm_tpl.des as des,");
		sql.append("bd_rcm_tpl.fg_active as fg_active,");
		sql.append("bd_rcm_tpl.mred_name as name_mred,");
		sql.append("bd_rcm_tpl.name_savemodel as savemodel,");
		sql.append("bd_rcm_tpl.name_sign as name_sign,"); //审签人
		sql.append("bd_rcm_tpl.fg_sign as fg_sign,");
		sql.append("bd_rcm_tpl.fg_def as fg_def,");
		sql.append("bd_rcm_tpl.createdtime as createdtime ");
		sql.append(" from bd_rcm_tpl bd_rcm_tpl ");
		sql.append(" where bd_rcm_tpl.id_bd_rcm_tp = '"+reportcardTypeId+"' ");
		sql.append(" and "+EnvContextUtil.processEnvContext("",new ReportCardTplDo(),false) );
		sql.append(" order by bd_rcm_tpl.createdtime desc");
		
		return sql.toString();
	}

}
