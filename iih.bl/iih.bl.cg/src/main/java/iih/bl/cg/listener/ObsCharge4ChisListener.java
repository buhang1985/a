package iih.bl.cg.listener;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import iih.bd.base.utils.SqlUtils;
import iih.bd.bc.event.pub.IBlEventConst;
import iih.bd.res.params.BdResParams;
import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.dto.d.ObsInfo4ChisDTO;
import iih.bl.cg.dto.d.OpCharge4EsDTO;
import iih.bl.cg.i.IBlCgCmdService;
import iih.bl.comm.IBlConst;
import iih.bl.comm.IBlMsgConst;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.log.logging.Logger;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.BusinessEvent.BusinessUserObj;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.PersistMgr;
import xap.sys.jdbc.kernel.PersistSession;

/**
 * 检查收费通知CHIS监听器
 * 
 * @author yankan
 * @author lpy
 * 
 */
public class ObsCharge4ChisListener implements IBusinessListener {
	/**
	 * 执行
	 * 
	 * @param event 事件
	 */
	@Override
	public void doAction(IBusinessEvent event) throws BizException {
		
		//1.校驗
		this.validate(event);
		
		// 2、获取事件的记账ID
		List<String> cgIdList = this.getEsCgIdList(event);

		// 3、调用发送第三方预约检查接口功能
		IBlCgCmdService iBlCgCmdService = ServiceFinder.find(IBlCgCmdService.class);
		iBlCgCmdService.sendChisProc(cgIdList, IBlConst.BL_CHARGES);
	
	}

	/**
	 * 验证事件
	 * 
	 * @param event
	 */
	private void validate(IBusinessEvent event) throws BizException {
		if (!IBlEventConst.EVENT_SOURCE_OP_CHARGE.equalsIgnoreCase(event.getSourceID())
				|| !IBlEventConst.EVENT_TYPE_BL_OP_CHARGE.equals(event.getEventType())) {
			throw new BizException(IBlMsgConst.ERROR_LISTENER_NOT_MATCH_EVENT);
		}
	}

	/**
	 * 根据事件源获取记账ID集合
	 * 
	 * @param event
	 * @return
	 * @throws BizException
	 */
	private List<String> getEsCgIdList(IBusinessEvent event) throws BizException {
		List<String> cgIdList = new ArrayList<String>();
		BusinessUserObj bizUserObj = (BusinessUserObj) event.getUserObject();
		if (IBlEventConst.EVENT_SOURCE_OP_CHARGE.equalsIgnoreCase(event.getSourceID())) {
			// 此类只监听门诊收费的
			OpCharge4EsDTO eventSourceDTO = (OpCharge4EsDTO) bizUserObj.getUserObj();
			FArrayList cgIds = eventSourceDTO.getIds_cgitm();
			if (cgIds != null && cgIds.size() > 0) {
				for (Object obj : cgIds) {
					String cgId = (String) obj;
					if (!StringUtil.isEmpty(cgId) && !cgIdList.contains(cgId)) {
						cgIdList.add(cgId);
					}
				}
			}
	    }
		//只查出非商保、预交金记账的记账id
		StringBuffer sql1 = new StringBuffer();
		sql1.append(" select distinct cgitm.id_cgitmoep  from bl_cg_itm_oep cgitm where ").append(SqlUtils.getInSqlByIds("cgitm.id_cgitmoep", cgIdList))	;
		sql1.append(" and   cgitm.FG_ACC !='Y' and  cgitm.FG_HPCG !='Y' ");
		@SuppressWarnings("unchecked")
		List<BlCgItmOepDO> cgItmlist = (List<BlCgItmOepDO>) new DAFacade().execQuery(sql1.toString(),new BeanListHandler(BlCgItmOepDO.class));
		List<String> cgIdList_qry = new ArrayList<String>();
		if (cgItmlist != null && cgItmlist.size() > 0) {
			for (BlCgItmOepDO blCgItmOepDO : cgItmlist) {
				if (!StringUtil.isEmpty(blCgItmOepDO.getId_cgitmoep()) && !cgIdList_qry.contains(blCgItmOepDO.getId_cgitmoep())) {
					cgIdList_qry.add(blCgItmOepDO.getId_cgitmoep());
				}
			}
		}
		return cgIdList_qry;
	}

	/**
	 * 封装检查信息
	 * 
	 * @param cgIdList 记账ID集合
	 * @return
	 * @throws BizException
	 */
	private ObsInfo4ChisDTO[] wrapObsInfo(List<String> cgIdList) throws BizException {
		if (ListUtil.isEmpty(cgIdList)) {
			return null;
		}
		List<ObsInfo4ChisDTO> list1 = this.getSrvSetItmList(cgIdList);
		List<ObsInfo4ChisDTO> list2 = this.getSrvCgItmList(cgIdList);
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
	 * @param cgIdList 记账ID集合
	 * @return
	 * @throws BizException
	 */
	private List<ObsInfo4ChisDTO> getSrvSetItmList(List<String> cgIdList) throws BizException {
		StringBuffer sql1 = new StringBuffer();
		sql1.append(" select distinct id_pat, code_apply,code_pat, times, code_st,");
		sql1.append("to_char(wm_concat( distinct sd_body)) as region_code,  ");
		sql1.append("item_no, quan,id_or,Code_dep_or, Name_dep_or, Code_emp_or,");
		sql1.append("name_emp_or,Code_dep_mp, name_dep_mp       ");
		sql1.append(" from (select  cgitm.id_pat,cior.applyno as code_apply ,pat.code as code_pat, entop.times_op as times, cgoep.code_cg as code_st,    ");
		sql1.append("               cgoep.dt_cg,srv.code as item_no, cgitm.quan, orsrvset.sd_body,cior.id_or, cgitm.id_orsrv, ");
		sql1.append("             orsrvset.id_srvset,dep.code as Code_dep_or,dep.name  as Name_dep_or, psn.code as Code_emp_or,");
		sql1.append("             psn.name  as name_emp_or,depmp.code as Code_dep_mp,depmp.name as name_dep_mp ");
		sql1.append("           from bl_cg_itm_oep cgitm ");
		sql1.append("              inner join bl_cg_oep cgoep on cgoep.id_cgoep = cgitm.id_cgoep ");
		sql1.append("              inner join bl_st_oep stoep on stoep.id_stoep = cgitm.id_stoep ");
		sql1.append("              inner join en_ent_op entop on cgitm.id_ent = entop.id_ent ");
		sql1.append("              left join bd_dep dep       on cgitm.id_dep_or = dep.id_dep ");
		sql1.append("              left join bd_psndoc psn    on cgitm.id_emp_or = psn.id_psndoc ");
		sql1.append("              left join bd_dep depmp     on cgitm.id_dep_mp = depmp.id_dep ");
		sql1.append("              inner join pi_pat pat      on pat.id_pat = cgitm.id_pat ");
		sql1.append("              inner join ci_order cior   on cgitm.id_or = cior.id_or ");
		sql1.append("              inner join bd_srv   srv    on cior.id_srv = srv.id_srv ");
		sql1.append("              inner join ci_or_srv orsrv on cgitm.id_orsrv = orsrv.id_orsrv ");
		sql1.append("              left join ci_or_srv_set orsrvset on orsrvset.id_or = cior.id_or  ");
		sql1.append("           where   srv.sd_srvtp like '02%'  ");                        //02表示服务项目是检验类的
	//	sql1.append("               and cgitm.fg_refund='N'  and cgoep.eu_direct='1'  ");   // 过滤出正常收的数据和若有退费  ，退费后又重收的那些重收数据
		sql1.append("               and srv.fg_or = 'Y' ");
		sql1.append("               and cior.fg_set = 'Y' ");
		sql1.append("               and orsrvset.fg_clinical = 'Y' ");
		sql1.append("  and ").append(SqlUtils.getInSqlByIds("cgitm.id_cgitmoep", cgIdList));
		sql1.append("               order by cgoep.dt_cg desc ");
		sql1.append("            ) x           ");
		sql1.append("  group by id_pat,code_apply,code_pat,times, code_st,quan,item_no,Code_dep_or,Name_dep_or, ");
		sql1.append("  Code_emp_or,name_emp_or,Code_dep_mp,name_dep_mp,id_or    order by  id_or desc ");
		
		//System.out.println("测试检查申请接口服务套：" +sql1.toString());
		@SuppressWarnings("unchecked")
		List<ObsInfo4ChisDTO> list1 = (List<ObsInfo4ChisDTO>) new DAFacade().execQuery(sql1.toString(),
				new BeanListHandler(ObsInfo4ChisDTO.class));
		return list1;
	}

	/**
	 * 查出非服务套的医嘱记账明细
	 * 
	 * @param cgIdList
	 * @return
	 * @throws BizException
	 */
	private List<ObsInfo4ChisDTO> getSrvCgItmList(List<String> cgIdList) throws BizException {
		// 查出所有非服务套的医嘱记账明细
		StringBuffer sb = new StringBuffer();
		sb.append("select distinct cgitm.id_pat ,cior.applyno as code_apply, pat.code as  code_pat,  ");
		sb.append("  entop.times_op as times,cgoep.code_cg as code_st, st.dt_st,");
		sb.append("  srv.code  as item_no,cgitm.quan,obs.sd_body as region_code,");
		sb.append("  dep.code as Code_dep_or,dep.name as Name_dep_or, ");
		sb.append("  psn.code as Code_emp_or ,psn.name as name_emp_or, ");
		sb.append("  depmp.code as Code_dep_mp,depmp.name as name_dep_mp, ");
		sb.append("  orsrv.sd_su_bl as pay_mark,  cior.fg_set  ");
		sb.append(" from  bl_cg_itm_oep cgitm  ");
		sb.append("  inner join  bl_cg_oep cgoep  on cgoep.id_cgoep = cgitm.id_cgoep ");
		sb.append("  inner join  bl_st_oep  st    on cgitm.id_stoep = st.id_stoep   ");
		sb.append("  inner join  en_ent_op  entop on cgitm.id_ent = entop.id_ent ");
		sb.append("  left join  bd_dep     dep   on cgitm.id_dep_or = dep.id_dep  ");
		sb.append("  left join  bd_psndoc psn    on cgitm.id_emp_or = psn.id_psndoc   ");
		sb.append("  left join  bd_dep    depmp  on cgitm.id_dep_mp = depmp.id_dep   ");
		sb.append("  inner join  pi_pat    pat    on pat.id_pat   = cgitm.id_pat ");
	    sb.append("  inner join  ci_order cior   on cgitm.id_or = cior.id_or  ");
		sb.append("  inner join  bd_srv   srv    on  cior.id_srv = srv.id_srv   ");
		sb.append("  inner join  ci_or_srv orsrv  on  cgitm.id_orsrv = orsrv.id_orsrv  ");
		sb.append("  left outer join  bd_srv_obs  obs on  srv.id_srv = obs.id_srv  ");
		sb.append(" where  st.id_paypatoep is not null and st.id_paypatoep != '~'  "); // 表示只查出已经付款的数据
		sb.append("  and srv.sd_srvtp like '02%' and srv.fg_or='Y' and cior.fg_set ='N' "); // 02表示服务项目是检验类的,
		sb.append("  and ").append(SqlUtils.getInSqlByIds("cgitm.id_cgitmoep", cgIdList));
		sb.append("  order by st.dt_st  desc  ");
		
		@SuppressWarnings("unchecked")
		List<ObsInfo4ChisDTO> list2 = (List<ObsInfo4ChisDTO>) new DAFacade().execQuery(sb.toString(),
				new BeanListHandler(ObsInfo4ChisDTO.class));
		return list2;
	}

	/**
	 * 执行CHIS的存储过程
	 * 
	 * @param obsInfo 检查信息
	 * @throws BizException
	 */
	private void execChisProc(ObsInfo4ChisDTO obsInfo) throws BizException {
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
				ps = conn.prepareCall("{call jk_items_trans_jcjy_apply(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
				this.setParam(ps, obsInfo);
				ps.registerOutParameter(18, java.sql.Types.VARCHAR);//按照index注入类型
				ps.registerOutParameter(19, java.sql.Types.VARCHAR);//按照index注入类型
				ps.registerOutParameter(20, java.sql.Types.INTEGER);//按照index注入类型
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
			throw new BizException("chis创建患者失败,原因:" + ex.getMessage());
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
	private void setParam(CallableStatement ps, ObsInfo4ChisDTO obsInfo) throws SQLException {
		// 从1开始
		ps.setInt(1, Integer.parseInt(obsInfo.getCode_apply()));// 无用，传申请单号
		ps.setString(2, obsInfo.getCode_pat());   
		ps.setInt(3, obsInfo.getTimes());
		ps.setInt(4,Integer.parseInt(obsInfo.getCode_st()));
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
		ps.setString(16, "3");
		ps.setString(17, "IIH");
		
		
		
//		ps.setString(1, "");// 无用，传申请单号
//		ps.setString(2, obsInfo.getCode_pat());
//		ps.setInt(3, obsInfo.getTimes());
//		ps.setString(4, obsInfo.getCode_st());
//		ps.setString(5, ""); // 无用，传申请单号
//		ps.setString(6, obsInfo.getItem_no());// 项目编码
//		ps.setString(7, obsInfo.getRegion_code());
//		ps.setString(8, "");// 数量传空值
//		ps.setString(9, "A"); // -此处区分检查和检验申请A:检查；L:检验
//		ps.setString(10, obsInfo.getCode_dep_or());
//		ps.setString(11, obsInfo.getCode_emp_or());
//		ps.setString(12, obsInfo.getCode_emp_or()); // 操作员code
//	    ps.setString(13, obsInfo.getCode_dep_mp());
//		ps.setString(14, ""); // 子系统传空
//		ps.setString(15, "3"); // 支付标志？ ，obsInfo.getPay_mark()
//		ps.setString(16, "3");
//		ps.setString(17, "IIH");
		/*
		 * @check_id 无用，传申请单号
		 * @patient_id 病人id
		 * @times 就诊次数
		 * @charge_no His收费流水号
		 * @item_no 无用，传申请单号
		 * @apply_item_code 检查项目编码
		 * @region_code 部位编码
		 * @charge_amount 数量
		 * @his_cast_type -此处区分检查和检验申请A:检查；L:检验
		 * @apply_unit 申请科室
		 * @applicant 申请医生
		 * @operator 操作员
		 * @exec_unit 执行科室
		 * @lis_group 传空
		 * @pay_mark 1 收费；2记帐 ；IIH传3
		 * @oper_flag 1 新增项;2 删除项；IIH传3
		 * @subsys_id 系统标识，体检一直用jk，IIH传IIH
		 */
	}
}