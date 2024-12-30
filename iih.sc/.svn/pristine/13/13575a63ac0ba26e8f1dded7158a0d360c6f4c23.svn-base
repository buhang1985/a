package iih.sc.scbd.s.bp;

import iih.bd.res.empdep.d.DepsEmpDTO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

import com.mysql.jdbc.StringUtils;
/***
 * 根据业务组DO获取该业务组人员信息
 * @author fanlq
 *
 */
public class GetEmpListByGroupBP {

	/***
	 * 根据业务组DO获取该业务组人员信息
	 * @param droupDO 业务组DO
	 * @return
	 * @throws BizException
	 */
	public DepsEmpDTO[] exec(String wgId) throws BizException{	
		StringBuilder sb = new StringBuilder();
		SqlParam sp = new SqlParam();
		sb.append("select doc.code as Code_emp,doc.name as Name_emp,dep.name as Name_dep_belong ");
		sb.append("from bd_psndoc doc ");
		sb.append("inner join bd_emp_wg emp on emp.id_emp = doc.id_psndoc ");
		sb.append("inner join bd_wg wg on wg.id_wg = emp.id_wg ");
		sb.append("inner join bd_dep dep on dep.id_dep = doc.id_dep ");
		sb.append("where 1=1 ");
		if(!StringUtils.isNullOrEmpty(wgId)){
			sb.append("and wg.id_wg = ? ");
			sp.addParam(wgId);
		}
		@SuppressWarnings("unchecked")
			List<DepsEmpDTO> datas = (List<DepsEmpDTO>) new DAFacade().execQuery(sb.toString(),
					sp, new BeanListHandler(DepsEmpDTO.class));
		   if(ListUtil.isEmpty(datas))
			  return null;	  
			return datas.toArray(new DepsEmpDTO[]{});
		}
}
