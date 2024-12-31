package iih.ei.een.s.bp.qry;

import iih.bd.utils.BdEnvContextUtil;
import iih.ei.een.ws.bean.GetDepListBean;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.bdfw.cenum.d.ActiveStateEnum;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.orgfw.dept.d.DeptDO;

/**
 * 
 * 获取科室信息
 * 
 * @author liubin
 * 
 * 下午3:42:42
 */
public class GetDepListBP {
	
	/**
	 * 获取科室信息
	 * 
	 * @author liubin
	 * 
	 * @param fg_only_leaf
	 * @return
	 * @throws BizException
	 */
	public GetDepListBean[] exec(String fg_only_leaf) throws BizException {
		SqlParam param = new SqlParam();
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append(" SELECT DEP.ID_DEP AS ID_DEP, ");
		sqlBuilder.append(" DEP.CODE AS CODE, ");
		sqlBuilder.append(" DEP.NAME AS NAME, ");
		sqlBuilder.append(" DEP.SD_DEPTTP AS SD_DEPTP, ");
		sqlBuilder.append(" DEP.SHORTNAME AS SHORT_NAME, ");
		sqlBuilder.append(" DEP.DES AS DES, ");
		sqlBuilder.append(" NVL(DEP.FG_LEAF,'Y') AS FG_LEAF ");
		sqlBuilder.append(" FROM BD_DEP DEP ");
		sqlBuilder.append(" WHERE DEP.ACTIVESTATE = ? ");
		param.addParam(ActiveStateEnum.ACTIVE);
		String env = BdEnvContextUtil.processEnvContext(new DeptDO(), "DEP");
		if(!StringUtil.isEmptyWithTrim(env)){
			sqlBuilder.append(" AND " + env);
		}
		if(FBoolean.TRUE.equals(new FBoolean(fg_only_leaf))){
			sqlBuilder.append(" AND DEP.FG_LEAF = ? ");
			param.addParam(FBoolean.TRUE);
		}
		sqlBuilder.append("ORDER BY CODE ");
		List<GetDepListBean> list = (List<GetDepListBean>) new DAFacade().execQuery(sqlBuilder.toString(), param, new BeanListHandler(GetDepListBean.class));
		return ListUtil.isEmpty(list)?null:list.toArray(new GetDepListBean[0]);
	}
}
