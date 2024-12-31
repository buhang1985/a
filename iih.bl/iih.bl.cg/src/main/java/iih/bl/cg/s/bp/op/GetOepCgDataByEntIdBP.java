package iih.bl.cg.s.bp.op;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import iih.bd.base.utils.SqlUtils;
import iih.bl.cg.dto.oepcg4en.d.BlCgOep4EnDTO;
import iih.bl.cg.dto.oepcg4en.d.OrEmpDTO;
import iih.bl.cg.s.bp.qry.GetOepCgDataByEntIdQry;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.sie.common.utils.StringUtils;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 根据就诊主键查询门诊记账数据
 * @author ly 2018/10/30
 *
 */
public class GetOepCgDataByEntIdBP {
	
	/**
	 * 根据就诊主键查询门诊记账数据
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	public BlCgOep4EnDTO[] exec(String entId) throws BizException{
		
		if(StringUtil.isEmpty(entId))
			return null;
		
		GetOepCgDataByEntIdQry qry = new GetOepCgDataByEntIdQry(entId);
		BlCgOep4EnDTO[] rlt = (BlCgOep4EnDTO[])AppFwUtil.getDORstWithDao(qry, BlCgOep4EnDTO.class);
		
		if(ArrayUtil.isEmpty(rlt))
			return null;
		
		// 再根据id_or更新一遍执行人,记录需要查询的id_or
		HashSet<String> id_ors = new HashSet<String>();
		for(int i = 0; i < rlt.length; i++){
			if(!StringUtils.isEmpty(rlt[i].getId_or()))
			id_ors.add(rlt[i].getId_or());
		}
		
		if(id_ors.size() == 0)
			return rlt;
		
		// 根据id_or查询执行人
		Map<String, OrEmpDTO> empMaps = getOepMpEmpByIdOR(id_ors.toArray(new String[0]));
		for(int i= 0; i< rlt.length; i++){
			OrEmpDTO tempEmp = empMaps.get(rlt[i].getId_or());
			if(tempEmp!=null )
				rlt[i].setName_emp_confirm(tempEmp.getName_emp_mp());
		}
		
		return rlt;
	}
	
	
	private Map<String, OrEmpDTO> getOepMpEmpByIdOR(String[] id_ors) throws DAException{
		Map<String, OrEmpDTO> emps = new HashMap<String, OrEmpDTO>();
		StringBuffer sql = new StringBuffer();
		sql.append("select a.id_or, b.name Name_emp_mp, a.dt_mp_confirm ");
		sql.append("  from mp_or_pr a " );
		sql.append(" inner join bd_psndoc b " );
		sql.append("    on a.id_emp_confirm = b.id_psndoc " );
		sql.append(" where 1 = 1 " );
		sql.append("   and  " + SqlUtils.getInSqlByIds("a.id_or", id_ors) );
		sql.append("   and a.eu_su = 4 " );
		sql.append("   and a.code_entp = '00' " );
		sql.append(" order by a.id_or, a.dt_mp_confirm desc " );

		SqlParam sp = new SqlParam();

		// 执行sql语句
		@SuppressWarnings("unchecked")
		List<OrEmpDTO> list = (List<OrEmpDTO>) new DAFacade().execQuery(sql.toString(), sp,
				new BeanListHandler(OrEmpDTO.class));
		
		for(int i= 0; i< list.size(); i++){
			if(emps.containsKey(list.get(i).getId_or())){
				OrEmpDTO tempemp = emps.get(list.get(i).getId_or());
				if(tempemp.getDt_mp_confirm().before(list.get(i).getDt_mp_confirm())){
					emps.put(list.get(i).getId_or(), list.get(i));
				}
			}
			else {
				emps.put(list.get(i).getId_or(), list.get(i));
			}
		}
		return emps;
	}
}
