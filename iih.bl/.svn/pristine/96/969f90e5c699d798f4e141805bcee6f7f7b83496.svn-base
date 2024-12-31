package iih.bl.cg.s.bp;


import iih.bd.base.utils.SqlUtils;
import iih.bd.res.params.BdResParams;
import iih.bl.cg.dto.d.ObsInfo4ChisDTO;
import iih.bl.comm.IBlConst;
import iih.bl.params.BlParams;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.log.logging.Logger;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.PersistMgr;
import xap.sys.jdbc.kernel.PersistSession;

public class SendChisProcBP {

	/**
	 * 收/退费，记账，取消记账 调用检查检验接口
	 * 
	 * @param cgIdList
	 *            记账编码集合
	 * @param directEu
	 *            方向
	 * @throws BizException
	 */
	public void exec(List<String> cgIdList, int directEu) throws BizException {
		FBoolean fgChis = BlParams.BLSTOEP0014();
		//检查收费是否通知CHis
		if(FBoolean.TRUE.equals(fgChis)){
			// 1、组织检查数据
			ObsInfo4ChisDTO[] obsArray = this.wrapObsInfo(cgIdList,directEu);

			// 2、通知CHIS
			int length = obsArray == null ? 0 : obsArray.length;
			for (int i = 0; i < length; i++) {
				
				this.execChisProc(obsArray[i],directEu);
			}
		}
		
	
	}

	/**
	 * 执行CHIS的存储过程
	 * 
	 * @param obsInfo
	 *            检查信息
	 * @throws BizException
	 */
	private void execChisProc(ObsInfo4ChisDTO obsInfo,int directEu) throws BizException {
		String dataSource = new BdResParams().CHISDB();
		if (StringUtil.isEmpty(dataSource)) {
			throw new BizException("chis数据源未定义，请定义数据源");
		}

		PersistMgr persistence = null;
		try {
			persistence = (PersistMgr) PersistMgr.getInstance(dataSource);
			PersistSession session = persistence.getPersistSession();

			Connection conn = session.getConnection();
			CallableStatement ps = null;
			try {
				// TODO 设置参数数量
				ps = conn
						.prepareCall("{call jk_items_trans_jcjy_apply(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
				this.setParam(ps, obsInfo,directEu);
				ps.registerOutParameter(18, java.sql.Types.VARCHAR);// 按照index注入类型
				ps.registerOutParameter(19, java.sql.Types.VARCHAR);// 按照index注入类型
				ps.registerOutParameter(20, java.sql.Types.INTEGER);// 按照index注入类型
				ps.execute();
			} finally {
				try {
					if (ps != null)
						ps.close();
				} catch (SQLException e) {
					Logger.error(e.getMessage(), e);
				} finally {
					if (conn != null)
						conn.close();
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			Logger.error(ex.getMessage(), ex);
			throw new BizException("chis执行失败,原因:" + ex.getMessage());
		} finally {
			if (persistence != null) {
				try {
					persistence.release();
				} catch (Exception e) {
				}
			}
		}
	}

	/**
	 * 设置参数
	 * 
	 * @param ps
	 * @param obsInfo
	 * @throws SQLException
	 */
	private void setParam(CallableStatement ps, ObsInfo4ChisDTO obsInfo,int directEu)
			throws SQLException {
		// 从1开始
		ps.setInt(1, Integer.parseInt(obsInfo.getCode_apply()));// 无用，传申请单号
		ps.setString(2, obsInfo.getCode_pat());
		ps.setInt(3, obsInfo.getTimes());
		ps.setInt(4, Integer.parseInt(obsInfo.getCode_st()));
		ps.setInt(5, Integer.parseInt(obsInfo.getCode_apply())); // 无用，传申请单号
		ps.setString(6, obsInfo.getItem_no());// 项目编码
		ps.setString(7, obsInfo.getRegion_code());
		ps.setInt(8, java.sql.Types.INTEGER);// 数量传空值
		ps.setString(9, "A"); // -此处区分检查和检验申请A:检查；L:检验
		ps.setString(10, obsInfo.getCode_dep_or());
		ps.setString(11, obsInfo.getCode_emp_or());
		ps.setString(12, obsInfo.getCode_emp_or()); // 操作员code
		ps.setString(13, obsInfo.getCode_dep_mp());
		ps.setString(14, ""); // 子系统传空
		ps.setString(15, "3"); // 支付标志？ ，obsInfo.getPay_mark()
		if(directEu == 1 ){
			ps.setString(16, "3");	//操作标志，收费时传3，退费时传2 表示删除项
		}else{
			ps.setString(16, "2");
		}
		ps.setString(17, "IIH");

		
		/*
		 * @check_id 无用，传申请单号
		 * 
		 * @patient_id 病人id
		 * 
		 * @times 就诊次数
		 * 
		 * @charge_no His收费流水号
		 * 
		 * @item_no 无用，传申请单号
		 * 
		 * @apply_item_code 检查项目编码
		 * 
		 * @region_code 部位编码
		 * 
		 * @charge_amount 数量
		 * 
		 * @his_cast_type -此处区分检查和检验申请A:检查；L:检验
		 * 
		 * @apply_unit 申请科室
		 * 
		 * @applicant 申请医生
		 * 
		 * @operator 操作员
		 * 
		 * @exec_unit 执行科室
		 * 
		 * @lis_group 传空
		 * 
		 * @pay_mark 1 收费；2记帐 ；IIH传3
		 * 
		 * @oper_flag 1 新增项;2 删除项；IIH传3
		 * 
		 * @subsys_id 系统标识，体检一直用jk，IIH传IIH
		 */
	}

	/**
	 * 封装检查信息
	 * 
	 * @param cgIdList
	 *            记账ID集合
	 * @return
	 * @throws BizException
	 */
	private ObsInfo4ChisDTO[] wrapObsInfo(List<String> cgIdList,int directEu)
			throws BizException {
		if (ListUtil.isEmpty(cgIdList)) {
			return null;
		}
		List<ObsInfo4ChisDTO> list1 = this.getSrvSetItmList(cgIdList,directEu);
		List<ObsInfo4ChisDTO> list2 = this.getSrvCgItmList(cgIdList,directEu);
		List<ObsInfo4ChisDTO> listAll = new ArrayList<ObsInfo4ChisDTO>();
		listAll.addAll(list1);
		listAll.addAll(list2);
		if (ListUtil.isEmpty(listAll)) {
			return null;
		}

		return listAll.toArray(new ObsInfo4ChisDTO[0]);
	}

	/**
	 * 查出所有服务套的医嘱记账明细
	 * 
	 * @param cgIdList
	 *            记账ID集合
	 * @return
	 * @throws BizException
	 */
	private List<ObsInfo4ChisDTO> getSrvSetItmList(List<String> cgIdList,int directEu)
			throws BizException {
		StringBuffer sql1 = new StringBuffer();
		sql1.append("select distinct cior.id_pat, cior.applyno as code_apply, ");
		sql1.append("  pat.code  as code_pat, entop.times_op  as times,      ");
		sql1.append("  cior.code_or as code_st, srv.code      as item_no,    ");
		sql1.append("  orsrvset.sd_body as region_code,cior.id_or,cior.dt_sign,");
		sql1.append("  dep.code  as Code_dep_or,dep.name  as Name_dep_or,     ");
		sql1.append("  psn.code   as Code_emp_or, psn.name  as name_emp_or,   ");
		sql1.append("  depmp.code as Code_dep_mp, depmp.name as name_dep_mp   ");
		sql1.append("from ci_order cior                                       ");
		sql1.append("  inner join en_ent_op entop   on cior.id_en = entop.id_ent");
		sql1.append("  left join bd_dep dep    on cior.id_dep_or = dep.id_dep   ");
		sql1.append("  left join bd_psndoc psn on cior.id_emp_or = psn.id_psndoc");
		sql1.append("  left join bd_dep depmp  on cior.id_dep_mp = depmp.id_dep ");
		sql1.append("  inner join pi_pat pat    on pat.id_pat = cior.id_pat     ");
		sql1.append("  inner join bd_srv srv    on cior.id_srv = srv.id_srv     ");
		sql1.append("  inner join ci_or_srv orsrv on cior.id_or = orsrv.id_or   ");
		sql1.append("  left join ci_or_srv_set orsrvset on orsrvset.id_or = cior.id_or ");
		sql1.append("where   srv.sd_srvtp like '02%'  "); // 02表示服务项目是检验类的
	    sql1.append("        and srv.fg_or = 'Y'      ");
		sql1.append("        and cior.fg_set = 'Y'    ");
		sql1.append("        and orsrvset.fg_clinical = 'Y' ");
		sql1.append("        and cior.id_or in (select cgitm.id_or from bl_cg_itm_oep cgitm join bl_cg_oep cgoep on cgitm.id_cgoep = cgoep.id_cgoep  where ");
		if(directEu == 1 )
		{
	       sql1.append("cgitm.fg_refund='N'  and cgoep.eu_direct='1'  "); // 过滤出正常收的数据和若有退费，退费后又重收的那些重收数据
		}else{
		  sql1.append("cgoep.eu_direct='-1'  "); 
		}
		sql1.append("and ").append(SqlUtils.getInSqlByIds("cgitm.id_cgitmoep", cgIdList)).append(")");
		sql1.append(" order by  cior.dt_sign desc ");

		// System.out.println("测试检查申请接口服务套：" +sql1.toString());
		@SuppressWarnings("unchecked")
		List<ObsInfo4ChisDTO> list1 = (List<ObsInfo4ChisDTO>) new DAFacade()
				.execQuery(sql1.toString(), new BeanListHandler(
						ObsInfo4ChisDTO.class));
		return list1;
	}

	/**
	 * 查出非服务套的医嘱记账明细
	 * 
	 * @param cgIdList
	 * @return
	 * @throws BizException
	 */
	private List<ObsInfo4ChisDTO> getSrvCgItmList(List<String> cgIdList,int directEu)
			throws BizException {
		// 查出所有非服务套的医嘱记账明细
		StringBuffer sb = new StringBuffer();
		sb.append("select distinct cior.id_pat ,cior.applyno as code_apply, pat.code as  code_pat,  ");
		sb.append("  entop.times_op as times,cior.code_or as code_st,cior.dt_sign, ");
		sb.append("  srv.code  as item_no,obs.sd_body as region_code,");
		sb.append("  dep.code as Code_dep_or,dep.name as Name_dep_or, ");
		sb.append("  psn.code as Code_emp_or,psn.name as name_emp_or, ");
		sb.append("  depmp.code as Code_dep_mp,depmp.name as name_dep_mp, ");
		sb.append("   cior.fg_set  ");
		sb.append(" from  ci_order cior ");
		sb.append("  inner join  en_ent_op  entop on cior.id_en = entop.id_ent ");
		sb.append("  left join  bd_dep     dep   on cior.id_dep_or = dep.id_dep  ");
		sb.append("  left join  bd_psndoc psn    on cior.id_emp_or = psn.id_psndoc   ");
		sb.append("  left join  bd_dep    depmp  on cior.id_dep_mp = depmp.id_dep   ");
		sb.append("  inner join  pi_pat    pat    on pat.id_pat   = cior.id_pat ");
		sb.append("  inner join  bd_srv   srv    on  cior.id_srv = srv.id_srv   ");
		sb.append("  inner join  ci_or_srv orsrv  on  cior.id_or = orsrv.id_or  ");
		sb.append("  left outer join  bd_srv_obs  obs on  srv.id_srv = obs.id_srv  ");
		sb.append(" where   "); // 表示只查出已经付款的数据
		sb.append("  srv.sd_srvtp like '02%' and srv.fg_or='Y' and nvl(cior.fg_set,'N') ='N' "); // 02表示服务项目是检验类的,
		sb.append("  and cior.id_or in (select cgitm.id_or from bl_cg_itm_oep cgitm join bl_cg_oep cgoep on cgitm.id_cgoep = cgoep.id_cgoep  where ");
		if(directEu == 1 )
		{
	       sb.append(" (cgitm.fg_st= 'Y' OR cgitm.FG_ACC='Y' OR cgitm.FG_HPCG='Y') and cgitm.fg_refund='N'  and cgoep.eu_direct='1'  "); // 过滤出正常收的数据和若有退费，退费后又重收的那些重收数据
		}else{
		   sb.append("  cgoep.eu_direct='-1'  "); // 退的数据
		}
		sb.append("  and ").append(SqlUtils.getInSqlByIds("cgitm.id_cgitmoep", cgIdList)).append(")");
		sb.append("  order by cior.dt_sign  desc  ");

		@SuppressWarnings("unchecked")
		List<ObsInfo4ChisDTO> list2 = (List<ObsInfo4ChisDTO>) new DAFacade()
				.execQuery(sb.toString(), new BeanListHandler(
						ObsInfo4ChisDTO.class));
		return list2;
	}

}
