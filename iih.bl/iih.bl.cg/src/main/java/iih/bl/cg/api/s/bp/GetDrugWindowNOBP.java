package iih.bl.cg.api.s.bp;

import iih.bl.cg.api.d.GetDrugWindowsNoParam;
import iih.mp.dg.i.IMpDgConst;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 第三方结算--获取取药窗口
 * @author ly 2017/06/05
 *
 */
public class GetDrugWindowNOBP {

	private final String DIVIDE = ", ";//分隔符
	
	/**
	 * 获取取药窗口
	 * @param param 患者id，结算编码
	 * @return 取药窗口信息(窗口名称),多张处方的取药窗口不同，则按照规则拼接
	 *         注：规则是使用1个逗号 + 1个空格做分隔符
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public String exec(String patId,String stCode) throws BizException{
		
		this.validate(patId,stCode);
		
		DAFacade daf = new DAFacade();
		String sql = this.getSql();
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(patId);
		sqlParam.addParam(stCode);
		sqlParam.addParam(patId);
		sqlParam.addParam(stCode);
		
		List<Object> rlt =  (List<Object>)daf.execQuery(
				sql, sqlParam, new ColumnListHandler());
		
		if(ListUtil.isEmpty(rlt))
			return "";
		
		String win = "";
		for (Object obj : rlt) {
			if(win.length() > 0){
				win += DIVIDE;
			}
			win += obj + "";
		}
		
		return win;
	}
	
	/**
	 * 入参校验
	 * @param param
	 * @throws BizException
	 */
	private void validate(String patId,String stCode) throws BizException{
		
		if(StringUtil.isEmpty(patId)){
			throw new BizException(String.format("入参%s为空", "患者id"));
		}
		
		if(StringUtil.isEmpty(stCode)){
			throw new BizException(String.format("入参%s为空", "结算号"));
		}
	}
	private String getSql(){
		StringBuilder sb = new StringBuilder();
		sb.append(getMedWinSql());
		sb.append(" union all ");
		sb.append(getCheckWinSql());
		return sb.toString();
	}
	/**
	 * 查询sql
	 * @return
	 */
	private String getMedWinSql(){
		
		StringBuilder sqlSb = new StringBuilder();
		//药品窗口
		sqlSb.append("select ");
		sqlSb.append("distinct ");
		sqlSb.append("case when win.id_quesite_pl = '"+IMpDgConst.SYN+"' then '"+IMpDgConst.SYN_NAME
				+"' else site.name end name ");

		sqlSb.append("from ");
		sqlSb.append("mp_dg_win win ");
		sqlSb.append("left join bd_que_site site ");
		sqlSb.append("on win.id_quesite_pl = site.id_quesite ");

		sqlSb.append("where win.id_pres in (");
		sqlSb.append("select ");
		sqlSb.append("  distinct pres.id_pres");
		sqlSb.append("  from bl_st_oep st");
		sqlSb.append("  inner join bl_cg_itm_oep cgitm");
		sqlSb.append("  on st.id_stoep = cgitm.id_stoep");
		sqlSb.append("  inner join ci_pres pres");
		sqlSb.append("  on cgitm.id_pres = pres.id_pres");
		sqlSb.append("  inner join pi_pat pat");
		sqlSb.append("  on st.id_pat = pat.id_pat");
		sqlSb.append("  where pat.code = ? ");
		sqlSb.append("  and st.code_st = ? ");
		sqlSb.append("  )");
		
		return sqlSb.toString();
	}
	/**
	 * 查询检查检验执行科室sql
	 * @return
	 */
	private String getCheckWinSql(){
		
		StringBuilder sb = new StringBuilder();
		sb.append("select ");
		sb.append("distinct ");
		sb.append(" dep.id_plc as name  ");
		sb.append("from ");
		sb.append(" bl_cg_itm_oep itm ");
		sb.append(" inner join  bl_st_oep st on itm.id_stoep=st.id_stoep ");
		sb.append(" inner join bd_dep dep on itm.id_dep_mp =dep.id_dep");
		sb.append(" inner join pi_pat pat on  st.id_pat = pat.id_pat");
		sb.append(" where itm.fg_mm='N' and nvl(dep.id_plc,'~')<>'~'");
		sb.append("  and pat.code = ? ");
		sb.append("  and st.code_st = ? ");
		
		return sb.toString();
	}
}
