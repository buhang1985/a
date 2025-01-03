/**
 * 医嘱助手 医疗服务项目分类,定位到物品
 */
package iih.ci.ord.s.bp;

import java.util.List;

import iih.bd.srv.medsrv.d.MedSrvDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * @ClassName: GetClassMedSrvMMDOSBP
 * @Description: TODO
 * @author Comsys-zhangwq
 * @date 2019年4月22日 上午10:16:29
 * @Package iih.ci.ord.s.bp Copyright: Copyright (c) 2011 Company: 北大医疗信息技术有限责任公司
 */
public class GetClassMedSrvMmDOSBP extends getClassMedSrvDOSBP{
	public MedSrvDO[] exe(String condition, String orderColumn, FBoolean isLazy,FMap2 medSrvMap) throws BizException {
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(Context.get().getOrgId());
		sqlParam.addParam(Context.get().getGroupId());
		
		condition += " and a0.ds=0 ";		
		String sql = "select a0.id_srv ,"
				+ "case when a0.fg_mm='Y' and mm.id_mm is not null then mm.name else a0.name end || CASE   WHEN mm.spec IS NOT NULL THEN '  ('|| mm.spec ||')  ' ELSE ''END || CASE  WHEN mm.sup_name IS NOT NULL THEN '['|| mm.sup_name ||']' ELSE '' END as name"
				+ ",a0.Pycode,a0.Fg_mm,a0.Fg_set,a0.sd_srvtp,mm.id_mm from bd_srv a0" 
				+ " left join bd_mm mm "
				+ " on mm.id_srv =  a0.id_srv "
				+ " where " + condition +" AND ((mm.fg_active  ='Y' and mm.fg_out='N') or a0.fg_mm='N') "
				+ "and a0.id_org= ? and a0.id_grp= ? order by a0.pycode";
		List<MedSrvDO> queryResult = (List<MedSrvDO>) new DAFacade().execQuery(sql, sqlParam, new BeanListHandler(MedSrvDO.class));
		
		return sortPinyinCode(queryResult.toArray(new MedSrvDO[queryResult.size()]),medSrvMap);
	}

}
