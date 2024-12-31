package iih.ei.een.s.bp.qry;

import iih.ei.een.ws.bean.GetEmpListBean;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.sys.bdfw.cenum.d.ActiveStateEnum;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取人员信息
 * 
 * 
 * @author liubin
 * 
 * 下午4:06:25
 */
public class GetEmpListBP {
	/**
	 * 获取人员信息
	 * 
	 * @author liubin
	 * 
	 * @param code_dept
	 * @return
	 * @throws BizException
	 */
	public GetEmpListBean[] exec(String code_dept) throws BizException{
		SqlParam param = new SqlParam();
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("SELECT EMP.ID_PSNDOC AS ID_EMP,");
		sqlBuilder.append("EMP.CODE AS CODE,");
		sqlBuilder.append("EMP.NAME AS NAME,");
		sqlBuilder.append("SEX.CODE AS SD_SEX,");
		sqlBuilder.append("EMP.BIRTHDAY AS DT_BIRTHDAY,");
		sqlBuilder.append("DEP.CODE AS CODE_DEP,");
		sqlBuilder.append("DEP.NAME AS NAME_DEP,");
		sqlBuilder.append("SU.CODE AS NAME_LOGIN ");
		sqlBuilder.append("FROM BD_PSNDOC  EMP ");
		sqlBuilder.append("INNER JOIN BD_DEP DEP ON EMP.ID_DEP = DEP.ID_DEP ");
		sqlBuilder.append("LEFT JOIN BD_UDIDOC SEX ON EMP.SEX = SEX.ID_UDIDOC ");
		sqlBuilder.append("LEFT JOIN SYS_USER SU ON EMP.ID_PSNDOC = SU.ID_PSN ");
		sqlBuilder.append(" WHERE DEP.ACTIVESTATE = ? ");
		param.addParam(ActiveStateEnum.ACTIVE);
		if(!StringUtil.isEmptyWithTrim(code_dept)){
			sqlBuilder.append("AND DEP.CODE = ? ");
			param.addParam(code_dept);
		}
		sqlBuilder.append("ORDER BY EMP.ID_DEP, EMP.CODE ");
		List<GetEmpListBean> list = (List<GetEmpListBean>) new DAFacade().execQuery(sqlBuilder.toString(), param, new BeanListHandler(GetEmpListBean.class));
		return ListUtil.isEmpty(list)?null:list.toArray(new GetEmpListBean[0]);
	}
}
