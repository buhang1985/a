package iih.bl.comm.util;

import java.util.List;

import iih.bd.base.utils.SqlUtils;
import iih.bl.cg.dto.blcgprinfo.d.BlCgPrInfoDTO;
import iih.bl.cg.dto.cglogic.d.BlCgApplyDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 费用域sql查询帮助类
 * @author ly 2019/05/31
 *
 */
public class BlSqlQueryUtil {

	/**
	 * 查询处方号
	 * @param orsrvIds
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public static BlCgApplyDTO[] getPresCode(String[] orsrvIds) throws BizException {
		
		StringBuilder sqlSb = new StringBuilder();
		sqlSb.append("select orsrv.id_orsrv id_key,pres.code applyno,'01' applytp ");
		sqlSb.append("from ci_pres pres ");
		sqlSb.append("inner join ci_or_srv orsrv ");
		sqlSb.append("on pres.id_pres = orsrv.id_pres ");
		sqlSb.append("where ");
		sqlSb.append(SqlUtils.getInSqlByIds("orsrv.id_orsrv", orsrvIds));
		
		DAFacade daf = new DAFacade();
		List<BlCgApplyDTO> rlt = (List<BlCgApplyDTO>)daf.execQuery(sqlSb.toString(), new BeanListHandler(BlCgApplyDTO.class));
		
		if(ListUtil.isEmpty(rlt))
			return null;
		
		return rlt.toArray(new BlCgApplyDTO[0]);
	}
	
	/**
	 * 查询检查申请单号
	 * @param orIds
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public static BlCgApplyDTO[] getRisCode(String[] orIds) throws BizException {
		
		StringBuilder sqlSb = new StringBuilder();
		sqlSb.append("select risor.id_or id_key,ris.code_app applyno,'02' applytp ");
		sqlSb.append("from ci_app_ris_or risor ");
		sqlSb.append("inner join ci_app_ris ris  ");
		sqlSb.append("on risor.id_ciapprissheet = ris.id_ciapprissheet ");
		sqlSb.append("where ");
		sqlSb.append(SqlUtils.getInSqlByIds("risor.id_or", orIds));
		
		DAFacade daf = new DAFacade();
		List<BlCgApplyDTO> rlt = (List<BlCgApplyDTO>)daf.execQuery(sqlSb.toString(), new BeanListHandler(BlCgApplyDTO.class));
		
		if(ListUtil.isEmpty(rlt))
			return null;
		
		return rlt.toArray(new BlCgApplyDTO[0]);
	}
	
	/**
	 * 查询检验申请单号
	 * @param orIds
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public static BlCgApplyDTO[] getLisCode(String[] orIds) throws BizException {
		
		StringBuilder sqlSb = new StringBuilder();
		sqlSb.append("select lisor.id_or id_key,lis.code_app applyno,'03' applytp ");
		sqlSb.append("from ci_app_lis_or lisor ");
		sqlSb.append("inner join ci_app_lis lis  ");
		sqlSb.append("on lisor.id_ciapplissheet = lis.id_ciapplissheet ");
		sqlSb.append("where ");
		sqlSb.append(SqlUtils.getInSqlByIds("lisor.id_or", orIds));
		
		DAFacade daf = new DAFacade();
		List<BlCgApplyDTO> rlt = (List<BlCgApplyDTO>)daf.execQuery(sqlSb.toString(), new BeanListHandler(BlCgApplyDTO.class));
		
		if(ListUtil.isEmpty(rlt))
			return null;
		
		return rlt.toArray(new BlCgApplyDTO[0]);
	}
	
	/**
	 * 查询病理申请单号
	 * @param orIds
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public static BlCgApplyDTO[] getBingliCode(String[] orIds) throws BizException {
		
		StringBuilder sqlSb = new StringBuilder();
		sqlSb.append("select pathgy.id_or id_key,pathgy.code_app applyno,'04' applytp ");
		sqlSb.append("from ci_app_pathgy pathgy ");
		sqlSb.append("where ");
		sqlSb.append(SqlUtils.getInSqlByIds("pathgy.id_or", orIds));
		
		DAFacade daf = new DAFacade();
		List<BlCgApplyDTO> rlt = (List<BlCgApplyDTO>)daf.execQuery(sqlSb.toString(), new BeanListHandler(BlCgApplyDTO.class));
		
		if(ListUtil.isEmpty(rlt))
			return null;
		
		return rlt.toArray(new BlCgApplyDTO[0]);
	}
	
	/**
	 * 查询其他打印单号
	 * @param orIds
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public static BlCgApplyDTO[] getOtherPrnCode(String[] orsrvIds) throws BizException {
		
		StringBuilder sqlSb = new StringBuilder();
		sqlSb.append("select prnitm.id_biz id_key,prn.code_prn applyno,'05' applytp ");
		sqlSb.append("from ci_prn_item prnitm ");
		sqlSb.append("inner join ci_prn prn ");
		sqlSb.append("on prnitm.id_ciprn = prn.id_ciprn ");
		sqlSb.append("where ");
		sqlSb.append(SqlUtils.getInSqlByIds("prnitm.id_biz", orsrvIds));
		
		DAFacade daf = new DAFacade();
		List<BlCgApplyDTO> rlt = (List<BlCgApplyDTO>)daf.execQuery(sqlSb.toString(), new BeanListHandler(BlCgApplyDTO.class));
		
		if(ListUtil.isEmpty(rlt))
			return null;
		
		return rlt.toArray(new BlCgApplyDTO[0]);
	}
	
	/**
	 * 获取医嘱执行信息
	 * @param ordIds
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public static BlCgPrInfoDTO[] getOrdPrInfo(String[] ordIds) throws BizException {
		
		StringBuilder sqlSb = new StringBuilder();
		sqlSb.append("select orpr.id_or,");
		sqlSb.append("orpr.eu_su,");
		sqlSb.append("case orpr.eu_su when 0 then '未执行' when 1 then '开始执行' when 2 then '不执行' when 3 then '已取消' when 4 then '执行完毕' else '未知' end name_eusu,");
		sqlSb.append("orpr.id_emp_confirm id_emp_mp,");
		sqlSb.append("psn.name name_emp_mp,");
		sqlSb.append("orpr.id_dep_confirm id_dep_mp,");
		sqlSb.append("dep.name name_dep_mp,");
		sqlSb.append("orpr.dt_mp_confirm dt_mp ");
		sqlSb.append("from mp_or_pr orpr ");
		sqlSb.append("inner join ");
		sqlSb.append("(select id_or,max(dt_mp_plan) dt_mp_plan ");
		sqlSb.append("from mp_or_pr ");
		sqlSb.append("where ");
		sqlSb.append(SqlUtils.getInSqlByIds("id_or", ordIds));
		sqlSb.append(" group by id_or ");
		sqlSb.append(") mpmax ");
		sqlSb.append("on orpr.id_or = mpmax.id_or ");
		sqlSb.append("and orpr.dt_mp_plan = mpmax.dt_mp_plan ");
		sqlSb.append("left join bd_psndoc psn ");
		sqlSb.append("on orpr.id_emp_confirm = psn.id_psndoc ");
		sqlSb.append("left join bd_dep dep ");
		sqlSb.append("on orpr.id_dep_confirm = dep.id_dep ");
		
		DAFacade daf = new DAFacade();
		List<BlCgPrInfoDTO> rlt = (List<BlCgPrInfoDTO>)daf.execQuery(sqlSb.toString(), new BeanListHandler(BlCgPrInfoDTO.class));
		
		if(ListUtil.isEmpty(rlt))
			return null;
		
		return rlt.toArray(new BlCgPrInfoDTO[0]);
	}
}
