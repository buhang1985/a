package iih.sc.sch.s.bp;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.orgfw.dept.d.DeptDO;

/**
 * 获取已经排班的科室
 * @author ccj
 *
 */
public class GetHaveSchDeptBp {
	
	/**
	 * 根据排班分类查询有排班的科室
	 * @param sctp  排班类型分类
	 * @param fg_active 是否过滤计划启用  true 过滤 false 不过滤
	 * @return list 有排班科室信息
	 * @throws BizException
	 */
	public List<DeptDO>  exec(String sctp,FBoolean fg_active) throws BizException {
		StringBuffer sb = new StringBuffer();
		SqlParam param = new SqlParam();
		sb.append("select * from bd_dep where ");
		sb.append("id_dep in (select distinct id_dep from sc_pl where sc_pl.ds = 0 ");
		if(StringUtils.isNotEmpty(sctp)){
			sb.append("and sc_pl.sd_sctp = ? ");
			param.addParam(sctp);
		}
		if(fg_active.booleanValue()){
			sb.append("and sc_pl.fg_active = 'Y' ");
		}
		sb.append(")");
		
		List<DeptDO> list = (List<DeptDO>) new DAFacade().execQuery(sb.toString(), param, new BeanListHandler(DeptDO.class));
		return list;
	}
}
