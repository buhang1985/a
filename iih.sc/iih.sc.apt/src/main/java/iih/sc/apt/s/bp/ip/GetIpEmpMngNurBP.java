package iih.sc.apt.s.bp.ip;

import iih.sc.comm.ScContextUtils;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.orgfw.dept.d.DeptDO;

/***
 * 获取当前登录人员所管理病区
 * @author fanlq
 *
 */
public class GetIpEmpMngNurBP {

	public String[] exec() throws BizException{
		String psnId = ScContextUtils.getPsnId();
		StringBuilder sb = new StringBuilder();
		SqlParam param = new SqlParam();
		sb.append("select distinct dep.id_dep as id_dep ");
		sb.append("from bd_wg_bed wgbed ");
		sb.append("left join bd_wg wg on wg.id_wg = wgbed.id_wg ");
		sb.append("left join bd_emp_wg empwg on empwg.id_wg = wg.id_wg ");
		sb.append("left join bd_psndoc doc on doc.id_psndoc = empwg.id_emp ");
		sb.append("left join bd_bed bed on bed.id_bed = wgbed.id_bed ");
		sb.append("left join bd_dep dep on dep.id_dep = bed.id_dep_belong ");
		sb.append("where 1=1 ");
		if(psnId != null && !psnId.isEmpty()){
			sb.append("and doc.id_psndoc = ? ");
			param.addParam(psnId);
		}	
		@SuppressWarnings({ "unchecked", "rawtypes" })
		List<DeptDO> list = (List<DeptDO>) new DAFacade().execQuery(sb.toString(), param, new BeanListHandler(DeptDO.class));
		if(list != null && list.size() > 0){
			List<String> depIds = new ArrayList<String>();
			for(DeptDO deptDO : list){
				if(!depIds.contains(deptDO.getId_dep())){
					depIds.add(deptDO.getId_dep());
				}
			}
			return depIds.toArray(new String[0]);
		}
		return null;
	}
}
