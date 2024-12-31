package iih.ei.sc.s.bp.qry;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.bd.utils.BdEnvContextUtil;
import iih.ei.een.ws.bean.GetDepListBean;
import iih.ei.sc.s.param.GetScQryListParam;
import iih.ei.sc.ws.bean.GetMtScCaListBean;
import iih.ei.sc.ws.bean.GetMtScDbSrvListBean;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.bdfw.cenum.d.ActiveStateEnum;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.orgfw.dept.d.DeptDO;

/**
 * 
 * 获取科室信息
 * 
 * @author yzh
 * 
 * 下午3:42:42
 */
public class GetMtScDbSrvListBP {
	
	/**
	 * 获取医技项目分类字典
	 * 
	 * @author yzh
	 * @param idScca
	 * @return
	 * @throws BizException
	 */
	public GetMtScDbSrvListBean[] exec(String idScca) throws BizException {
		String orgId = Context.get().getOrgId();
		SqlParam param = new SqlParam();
		StringBuilder sqlBuilder = new StringBuilder();
		String pripatCode = this.getPatPriCode(orgId);
		sqlBuilder.append(" select rel.id_mdsrv as idSrv,srv.code as codeSrv,")
		.append(" srv.name as nameSrv,srv.pycode,srv.wbcode,scsrv.id_scca as idScca,ca.name as nameScca,")
		.append(" price.price_std as price")
		.append(" from sc_srv_rel rel")
		.append(" inner join sc_srv scsrv on scsrv.id_scsrv = rel.id_scsrv")
		.append(" inner join bd_srv srv on rel.id_mdsrv = srv.id_srv")
		.append(" inner join view_price_rp price on rel.id_mdsrv = price.id_srv")
		.append(" inner join bd_pri_pat pripat on pripat.id_pripat = price.id_pripat")
		.append(" inner join sc_ca ca on scsrv.id_scca = ca.id_scca")
		.append(" and pripat.code = ? and pripat.id_org = ?");
		if (!StringUtil.isEmpty(idScca)) {
			sqlBuilder.append(" and scsrv.id_scca = ? ");
		}
		sqlBuilder.append(" inner join sc_ca scca on scca.id_scca = scsrv.id_scca");
		param.addParam(pripatCode);
		param.addParam(orgId);
		if (!StringUtil.isEmpty(idScca)) {
			param.addParam(idScca);
		}
		List<GetMtScDbSrvListBean> list = (List<GetMtScDbSrvListBean>) new DAFacade().execQuery(sqlBuilder.toString(), param, new BeanListHandler(GetMtScDbSrvListBean.class));
		return ListUtil.isEmpty(list)?null:list.toArray(new GetMtScDbSrvListBean[0]);
	}
	/**
	 * 查询当前组织下默认的患者加个分类
	 * @param orgId
	 * @return
	 * @throws DAException
	 */
	private String getPatPriCode(String orgId) throws DAException{
		SqlParam param = new SqlParam();
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("select pripat.code from pi_pat_ca ca left join bd_pri_pat pripat on ca.id_patpritp = pripat.id_pripat ")
		.append("where ca.fg_def = 'Y' and ca.id_org =?");
		param.addParam(orgId);
		DAFacade dafacade = new DAFacade();
		List<String> list = (List<String>) dafacade.execQuery(sqlBuilder.toString(), param, new ColumnListHandler());
		if(ListUtil.isEmpty(list)){
			return null;
		}else{
			return list.get(0);
		}
		
	}
}
