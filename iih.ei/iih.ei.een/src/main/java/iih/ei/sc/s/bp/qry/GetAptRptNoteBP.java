package iih.ei.sc.s.bp.qry;

import java.util.ArrayList;
import java.util.List;
import iih.ei.sc.ws.bean.GetAptRptNoteBean;
import iih.sc.scbd.bdsrv.d.ScBdsrvDO;
import iih.sc.scbd.bdsrv.i.IScbdsrvMDORService;
import iih.sc.scbd.schedulesrv.d.ScheduleSrvDO;
import iih.sc.scbd.schedulesrv.d.ScheduleSrvRelDO;
import iih.sc.scbd.schedulesrv.i.IScheduleSrvRelDORService;
import iih.sc.scbd.schedulesrv.i.ISchedulesrvMDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.kernel.SqlParam;

public class GetAptRptNoteBP {
	/**
	 * 根据诊疗项目id获取打印模板上的预约须知
	 * @param id_srv
	 * @return
	 * @throws BizException
	 */
	public GetAptRptNoteBean[] exec(String id_srv,String code_prt_tmpl_dep,String id_prt_tmpl_dep) throws BizException {
		GetAptRptNoteBean bean = this.getAptRptNote(id_srv, code_prt_tmpl_dep,id_prt_tmpl_dep);	
		return new GetAptRptNoteBean[]{bean};
	}
	
	private GetAptRptNoteBean getAptRptNote(String id_srv,String code_prt_tmpl_dep,String id_prt_tmpl_dep) throws BizException{
		
		GetAptRptNoteBean bean = new GetAptRptNoteBean();
		String id_scca = "";
		String scsrv_cond = "";
		ScBdsrvDO scbdsrv = this.getScBdSrv(id_srv);
		if(scbdsrv != null){
			id_scca = scbdsrv.getId_scca();
		}
		List<String> id_scsrv_list = new ArrayList<String>();
		ScheduleSrvRelDO[] scsrvrels = this.getScSrvRel(id_srv);
		if(scsrvrels != null){
			for (ScheduleSrvRelDO scheduleSrvRelDO : scsrvrels) {
				id_scsrv_list.add(scheduleSrvRelDO.getId_scsrv());
			}
			scsrv_cond = this.buildIdStr(id_scsrv_list);
		}
		String desc_text = this.getAptRptNoteByTmpl(id_srv, id_scca, StringUtil.isEmpty(scsrv_cond)?"":scsrv_cond, code_prt_tmpl_dep,id_prt_tmpl_dep);
		if(StringUtil.isEmpty(desc_text)){
			throw new BizException("未查询到该服务id_srv:"+id_srv+",的告知单须知数据,请检查配置!");
		}
		bean.setDesc_text(desc_text);
		return bean;
	}
	/**
	 * 获取医疗排班项目信息
	 * @param id_srv
	 * @return
	 * @throws BizException
	 */
	private ScBdsrvDO getScBdSrv(String id_srv) throws BizException{
		IScbdsrvMDORService iscbdsrvmdorservice = ServiceFinder.find(IScbdsrvMDORService.class);
		ScBdsrvDO[] bdsrvs = iscbdsrvmdorservice.find("id_srv='"+id_srv+"'", null, FBoolean.FALSE);
		if(ArrayUtil.isEmpty(bdsrvs)) return null;
		return bdsrvs[0];
	}
	/**
	 * 获取服务信息
	 * @param id_scca
	 * @return
	 * @throws BizException
	 */
	private ScheduleSrvDO[] getScSrv(String id_scca) throws BizException{
		ISchedulesrvMDORService ischedulesrvmdorservice = ServiceFinder.find(ISchedulesrvMDORService.class);
		ScheduleSrvDO[] scsrvs = ischedulesrvmdorservice.find("id_scca='"+id_scca+"'", null, FBoolean.FALSE);
		if(ArrayUtil.isEmpty(scsrvs)) return null;
		return scsrvs;
	}
	/**
	 * 获取诊疗项目对应的排班服务
	 * @param id_srv
	 * @return
	 * @throws BizException
	 */
	private ScheduleSrvRelDO[] getScSrvRel(String id_srv) throws BizException{
		IScheduleSrvRelDORService ischedulesrvreldorservice = ServiceFinder.find(IScheduleSrvRelDORService.class);
		ScheduleSrvRelDO[] scsrvrels = ischedulesrvreldorservice.find("id_mdsrv='"+id_srv+"'", null, FBoolean.FALSE);
		if(ArrayUtil.isEmpty(scsrvrels)) return null;
		return scsrvrels;
	}
	/**
	 * 获取模板的预约须知文本
	 * @param id_prttmpl
	 * @return
	 * @throws BizException
	 */
	private String getAptRptNoteByTmpl(String id_srv,String id_scca,String id_scsrvs,String code_prt_tmpl_dep,String id_prt_tmpl_dep) throws BizException{
		StringBuilder sql = new StringBuilder();
		SqlParam param = new SqlParam();
		sql.append(" select tmpl.desc_text");
		sql.append(" from sc_prt_cfg scg");
		sql.append(" inner join sc_prt_tmpl tmpl");
		sql.append(" on tmpl.id_prttmpl = scg.id_prttmpl");
		sql.append(" left join bd_dep dep on scg.id_dep = dep.id_dep");
		sql.append(" where scg.sd_rpttp = '01'");
		if(!StringUtil.isEmpty(code_prt_tmpl_dep)){
			sql.append(" and  (dep.code = ? or scg.id_dep  = '~' or scg.id_dep  is null)");
			param.addParam(code_prt_tmpl_dep);
		}
		if(!StringUtil.isEmpty(id_prt_tmpl_dep)){
			sql.append(" and  (scg.id_dep = ? or scg.id_dep  = '~' or scg.id_dep  is null)");
			param.addParam(id_prt_tmpl_dep);
		}/*else{
			sql.append(" and  (scg.id_dep  = '~' or scg.id_dep  is null)");
		}*/
		sql.append(" and (scg.id_scca = ? or scg.id_scca  = '~' or scg.id_scca  is null)");
		if(!StringUtil.isEmpty(id_scsrvs)){
		sql.append(" and (scg.id_scsrv in (");
		sql.append(id_scsrvs).append(") or scg.id_scsrv  = '~' or scg.id_scsrv  is null)");
		}else{
			sql.append(" and (scg.id_scsrv  = '~' or scg.id_scsrv  is null)");
		}
		sql.append(" and (scg.ids_bdsrv like ? or scg.ids_bdsrv = '~' or scg.ids_bdsrv is null )");
		sql.append(" and scg.id_org = ? ");
		sql.append(" order by scg.level_pri desc");
		param.addParam(id_scca);
		param.addParam("%"+id_srv+"%");
		param.addParam(Context.get().getOrgId());
		List<String> list = (List<String>) new DAFacade().execQuery(sql.toString(),param,new ColumnListHandler());
		if(list.size()>0)
		{
			return list.get(0);
		}
		return null;
	}
	
	/**
	 * 生成id的查询串
	 * 
	 * @param idList id集合
	 * @return
	 */
	public static String buildIdStr(List<String> idList) {
		if (ListUtil.isEmpty(idList)) {
			return null;
		}

		StringBuilder builder = new StringBuilder();
		boolean first = true;
		for (String id : idList) {
			if (StringUtil.isEmpty(id)) {
				continue;
			}
			if (first) {
				first = false;
			} else {
				builder.append(",");
			}
			builder.append(String.format("'%s'", id));
		}

		return builder.toString();
	}
}
