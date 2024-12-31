package iih.ei.een.s.bp.qry;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.fc.que.d.QueDO;
import iih.bd.utils.BdEnvContextUtil;
import iih.ei.een.ws.bean.GetOpQueListBean;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 取门诊有效的医生排班队列
 * 
 * @author Anninglbj
 *
 */
public class GetOpQueListBP {
	/**
	 * 取门诊有效的医生排班队列
	 * 
	 * @param code_dept
	 * @return
	 * @throws BizException
	 */
	public GetOpQueListBean[] exec(String code_dept) throws BizException{
		SqlParam param = new SqlParam();
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append(" SELECT QUE.ID_QUE AS ID_QUE, ");
		sqlBuilder.append(" QUE.CODE AS CODE_QUE, ");
		sqlBuilder.append(" QUE.NAME AS NAME_QUE, ");
		sqlBuilder.append(" QUE.DES AS DES_QUE, ");
		sqlBuilder.append(" DEP.CODE AS CODE_DEP, ");
		sqlBuilder.append(" DEP.NAME AS NAME_DEP ");
		sqlBuilder.append(" FROM BD_QUE QUE ");
		sqlBuilder.append(" INNER JOIN BD_DEP DEP ON QUE.ID_DEP = DEP.ID_DEP ");
		sqlBuilder.append(" WHERE QUE.SD_QUETP = ? ");
		param.addParam(IBdFcDictCodeConst.SD_QUETP_EMP);
		sqlBuilder.append(" AND QUE.FG_ACTIVE = ? ");
		param.addParam(FBoolean.TRUE);
		String env = BdEnvContextUtil.processEnvContext(new QueDO(), "QUE");
		if(!StringUtil.isEmptyWithTrim(env)){
			sqlBuilder.append(" AND " + env);
		}
		if(!StringUtil.isEmptyWithTrim(code_dept)){
			sqlBuilder.append(" AND DEP.CODE = ? ");
			param.addParam(code_dept);
		}
		sqlBuilder.append(" ORDER BY QUE.ID_DEP,QUE.CODE ");
		List<GetOpQueListBean> list = (List<GetOpQueListBean>) new DAFacade().execQuery(sqlBuilder.toString(), param, new BeanListHandler(GetOpQueListBean.class));
		return ListUtil.isEmpty(list)?null:list.toArray(new GetOpQueListBean[0]);
	}
}
