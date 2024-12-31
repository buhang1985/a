package iih.ci.ord.s.external.bp.mm;

import java.util.ArrayList;
import java.util.List;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.i.external.provide.meta.mm.CiOrderPendingAccountDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDouble;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取待记账医嘱对象
 * 
 * @author HUMS
 * @version hao_wu 2018-5-27 修正因医保等级为空导致的项目查询不到的问题；修正sql语句，使用Left Join
 * @version hao_wu 2018-5-27 修正金额计算错误的问题；mod->multiply
 *
 */
public class GetPendingAccontOrdersBP {

	/**
	 * 根据医嘱id集合查询
	 * 
	 * @param id_ors
	 *            医嘱id集合
	 * @return 未记账的医嘱未记账对象集合
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public List<String> exec(String[] id_ors) throws BizException {

		if (id_ors == null || id_ors.length == 0) {

			return new ArrayList<String>();
		}

		DAFacade dafacade = new DAFacade();
		StringBuffer sqlb = new StringBuffer();

		SqlParam param = new SqlParam();
		param.addParam(ICiDictCodeConst.SD_SU_BL_NONE_ID);
		param.addParam("Y");

		for (String id_or : id_ors) {
			param.addParam(id_or);
			sqlb.append(",?");
		}
		StringBuilder qrySql = new StringBuilder();
		qrySql.append("select distinct ci.id_or from ci_order ci left join ci_or_srv srv ");
		qrySql.append("on ci.id_or = srv.id_or ");
		qrySql.append("where ci.id_su_bl=? and ci.fg_sign =? and srv.fg_self='N' and ci.id_or in (" + sqlb.substring(1)+")");
		List<String> resultList = (List<String>) dafacade.execQuery(qrySql.toString(), param, new ColumnListHandler());
		return resultList;
	}

	/**
	 * 获取门诊待记账服务项目数据
	 * 
	 * @param id_pat
	 *            患者id
	 * @param id_dep_mp
	 *            执行科室
	 * @param excludeMm
	 *            是否排除物品，true 排除， false 不排除
	 * @return 待记账服务项目数据
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public List<CiOrderPendingAccountDTO> getPendingAccountOrders(String id_pat, String id_dep_mp, boolean excludeMm)
			throws BizException {

		DAFacade dafacade = new DAFacade();

		SqlParam param = new SqlParam();
		param.addParam(ICiDictCodeConst.SD_SU_BL_NONE_ID);
		param.addParam(id_pat);
		param.addParam(id_dep_mp);

		StringBuffer qryBuffer = new StringBuffer();

		qryBuffer.append("SELECT ord.id_en, ord.id_or, ord.code_or, ord.name_or, ord.id_srv AS ord_id_srv,");
		qryBuffer.append("ord.dt_sign,");
		qryBuffer
				.append("ord.code_entp, srv.id_orsrv, srv.id_srv AS orsrv_id_srv, srv.code_srv, srv.name AS name_srv,");
		qryBuffer.append("srv.id_freq, freq.name AS name_freq, srv.pri, srv.pri_ratio, srv.quan_medu,");
		qryBuffer.append("srv.id_medu, medu.name AS medu_name, srv.quan_total_medu, srv.id_dep_srv,");
		qryBuffer.append("dep.name AS dep_name, srv.id_emp_srv, psn.name AS emp_name, srv.id_su_bl,");
		qryBuffer.append("srv.sd_su_bl, bludidoc.name AS su_bl_name, srv.id_hp, srv.id_hpsrvtp,");
		qryBuffer.append("srv.sd_hpsrvtp, hpudidoc.name AS name_hpsrvtp, srv.fg_mm ");
		qryBuffer.append("FROM ci_or_srv srv ");
		qryBuffer.append("LEFT JOIN ci_order ord ON srv.id_or = ord.id_or ");
		qryBuffer.append("LEFT JOIN bd_freq freq ON srv.id_freq = freq.id_freq ");
		qryBuffer.append("LEFT JOIN bd_measdoc medu ON srv.id_medu = medu.id_measdoc ");
		qryBuffer.append("LEFT JOIN bd_dep dep ON srv.id_dep_srv = dep.id_dep ");
		qryBuffer.append("LEFT JOIN bd_psndoc psn ON srv.id_emp_srv = psn.id_psndoc ");
		qryBuffer.append("LEFT JOIN bd_udidoc hpudidoc ON srv.id_hpsrvtp = hpudidoc.id_udidoc ");
		qryBuffer.append("LEFT JOIN bd_udidoc bludidoc ON srv.id_su_bl = bludidoc.id_udidoc ");
		qryBuffer.append("WHERE ord.ds = 0 AND ord.code_entp ='00' ");
		qryBuffer.append("AND ord.fg_sign = 'Y' AND ord.fg_canc = 'N' ");
		qryBuffer.append("AND srv.id_su_bl = ? AND srv.fg_bl ='Y' ");
		qryBuffer.append("AND ord.id_pat = ? AND ord.id_dep_mp = ? ");
		//自备药服务排除
		qryBuffer.append("AND srv.fg_self = 'N' ");
		// 是否排除物品
		if (excludeMm) {
			qryBuffer.append("and srv.fg_mm='N'");
		}

		List<CiOrderPendingAccountDTO> pendingAccountList = (List<CiOrderPendingAccountDTO>) dafacade
				.execQuery(qryBuffer.toString(), param, new BeanListHandler(CiOrderPendingAccountDTO.class));

		for (CiOrderPendingAccountDTO pendingAccount : pendingAccountList) {

			if (pendingAccount.getPri() == null || pendingAccount.getQuan_total_medu() == null) {
				pendingAccount.setTotal_pri(FDouble.ZERO_DBL);
			} else {
				pendingAccount.setTotal_pri(pendingAccount.getPri().multiply(pendingAccount.getQuan_total_medu()));
			}
		}

		return pendingAccountList;
	}

}
