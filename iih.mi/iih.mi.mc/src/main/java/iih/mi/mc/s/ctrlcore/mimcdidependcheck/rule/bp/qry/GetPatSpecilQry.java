package iih.mi.mc.s.ctrlcore.mimcdidependcheck.rule.bp.qry;

import iih.bd.base.utils.SqlUtils;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;

/**
 * 判断删除的诊断是否在患者特殊病中存在
 * @author LIM
 *
 */
public class GetPatSpecilQry {
	/**
	 * 判断删除的诊断是否在患者特殊病中存在
	 * @param id_ent 就诊id
	 * @param id_hp 医保计划id
	 * @param diIds 诊断数组
	 * @return
	 * @throws DAException
	 */
	public FBoolean exec(String id_ent,String id_hp,String[] diIds) throws BizException{
		FBoolean bExist = FBoolean.FALSE;
		DAFacade dafacade = new DAFacade();		
		String sql = getSql(id_ent,id_hp,diIds);
		@SuppressWarnings("unchecked")
		List<String> list = (List<String>) dafacade.execQuery(sql, new ColumnListHandler());		
		if(!ListUtil.isEmpty(list)){
			bExist = FBoolean.TRUE;
		}
		return bExist;
	}
	
	/**
	 *  查询患者特殊病诊断信息
	 * @param diIds
	 * @return
	 */
	private String getSql(String id_ent,String id_hp,String[] diIds){
		StringBuilder sb = new StringBuilder();
		sb.append(" select ");
		sb.append(" specdi.code_di ");
		sb.append(" from en_ent_hp enthp ");
		sb.append(" inner join MI_MC_SPEC spec on enthp.id_hp=spec.id_hp ");
		sb.append(" inner join mi_mc_pat_spec patspec  on patspec.id_hp=enthp.id_hp and  substr(patspec.no_hp,1,9)=substr(enthp.no_hp,1,9)  ");
		sb.append(" inner join mi_mc_pat_spec_di specdi on patspec.id_mimcpatspec=specdi.id_mimcpatspec and spec.code_di=specdi.code_di  ");
		sb.append(" where enthp.id_ent='");
		sb.append(id_ent);
		sb.append("' ");
		sb.append(" and enthp.id_hp='"+ id_hp +"'");
		sb.append(SqlUtils.getInSqlByBigIds(" and specdi.code_di  ", diIds));
		return sb.toString();
	}	
}
