package iih.ci.ord.s.ortmpl.bp;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mysql.jdbc.StringUtils;

import iih.bd.base.utils.SqlUtils;
import iih.bd.srv.ortpl.dto.OrTmplDTO;
import iih.ci.ord.s.ortmpl.bp.qry.getOrTmplDTOsQry;

/**
 * 查询医嘱模板分类关系
 * @author Young
 *
 */
public class getOrTmplDTOsBP {

	public OrTmplDTO[] exec(String code_entp, String id_ortmplca,String sd_ortmpltp) throws BizException{
		ITransQry qry = new getOrTmplDTOsQry(code_entp, id_ortmplca, sd_ortmpltp);
		OrTmplDTO[] rtns = (OrTmplDTO[]) AppFwUtil.getDORstWithDao(qry, OrTmplDTO.class);
		getTmplRefDif(rtns);
		return rtns;
	}
	/**
	 * 填充模板关联的诊断
	 * @param rtns
	 * @throws DAException
	 */
	private void getTmplRefDif(OrTmplDTO[] rtns) throws DAException{
		if(rtns == null || rtns.length==0){
			return;
		}
		List<String> tmplIds = new ArrayList<String>();
		Map<String,OrTmplDTO> tempTmplMap = new HashMap<String,OrTmplDTO>();
		for(OrTmplDTO tmpl : rtns){
			tmplIds.add(tmpl.getId_ortmpl());
			tempTmplMap.put(tmpl.getId_ortmpl(), tmpl);
		}
		if(tmplIds.size() > 0){
			SqlParam param = new SqlParam();
			List<OrTmplDTO> didefs = (List<OrTmplDTO>)new DAFacade().execQuery(getSql(tmplIds), param, new BeanListHandler(OrTmplDTO.class));
			if(didefs!=null && didefs.size()>0){
				for(OrTmplDTO tmpl : didefs){
					if(StringUtils.isNullOrEmpty(tmpl.getName())){
						continue;
					}
					String id_ortmpl = tmpl.getId_ortmpl();
					if(tempTmplMap.containsKey(id_ortmpl)){
						String[] name_didefs = tmpl.getName().split(",");
						List<String> stringB = Arrays.asList(name_didefs);
						FArrayList flist = new FArrayList();
						flist.addAll(stringB);
						tempTmplMap.get(id_ortmpl).setNameDidefRef(flist);
					}
				}
			}
		}else{
			return;
		}
	}
	/**
	 * 查询模板关联的诊断sql
	 * @return
	 */
	private String getSql(List<String> tmplIds){
		StringBuilder sb = new StringBuilder();
		sb.append("select tmpl.id_ortmpl,to_char(listagg(di.name,',') within group(order by di.code)) name ");
		sb.append(" from bd_srv_ortmpl tmpl ");
		sb.append(" left join bd_di_def di "); 
		sb.append(" on nvl(tmpl.id_didef_ref,'~')<>'~' and tmpl.id_didef_ref like '%'||di.id_didef||'%' ");
		sb.append(" where "+SqlUtils.getInSqlByIds("tmpl.id_ortmpl",tmplIds)+" and ");
		sb.append(" di.id_didef is not null ");
		sb.append(" group by tmpl.id_ortmpl");
		return sb.toString();
	}
}
