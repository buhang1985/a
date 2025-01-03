package iih.ci.ord.s.external.bp;

import java.util.List;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.cior.d.OrdApOpDO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.i.ICiorderMDOCudService;
import iih.ci.ord.ciorder.i.ICiorderMDORService;
import iih.ci.ord.content.d.OpTaiCiOrContentFactory;
import iih.ci.ord.i.external.provide.meta.en.ReservedSurgeryAppDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.cache.PatInfoCache;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**\
 * 就诊手术预约相关的接口业务逻辑实现
 * @author wangqingzhu
 *
 */
public class SurgeryAppointmentApplicationBP {
	/**
	 * 更新手术申请单相关的预约状态
	 * 
	 * @param id_or
	 * @param dt_b
	 * @param id_operator
	 * @return
	 */
	public boolean UpdateAppSurgeryAppointmentStatus(String id_or, FDateTime dt_b, String id_operator) throws BizException {
		// 1、有效性判断
		if (CiOrdUtils.isEmpty(id_or) || CiOrdUtils.isEmpty(dt_b)) {
			// throw new BizException ("预约手术医嘱的ID为空，或者预约开始时间为空");
			return false;
		}

		DAFacade dafacade = new DAFacade();
		// 2、查询已经申请预约的手术申请单
		List<OrdApOpDO> rstInfo = (List<OrdApOpDO>) dafacade.findByCond(OrdApOpDO.class,
				String.format(" id_or = '%s' and %s = '%s' ", id_or, OrdApOpDO.SD_SU_OP,ICiDictCodeConst.SD_CI_OPER_YSQ),
				new String[] { OrdApOpDO.ID_OR, OrdApOpDO.SD_SU_OP, OrdApOpDO.DT_PLAN });
		if (null == rstInfo || rstInfo.size() == 0) {
			return false;
		}
		// 3、 更新预约时间和预约状态
		OrdApOpDO ordApOpInfo = rstInfo.get(0);
		ordApOpInfo.setDt_plan(dt_b);
		ordApOpInfo.setId_su_op(ICiDictCodeConst.ID_CI_OPER_YYY);// 已经预约
		ordApOpInfo.setSd_su_op(ICiDictCodeConst.SD_CI_OPER_YYY); // 已经预约
		dafacade.updateDO(ordApOpInfo, new String[] { OrdApOpDO.SD_SU_OP, OrdApOpDO.DT_PLAN });
		// 更新医嘱内容
		CiOrderDO[] szOrders = ServiceFinder.find(ICiorderMDORService.class).findByAttrValString(CiOrderDO.ID_OR, id_or);
		if(null != szOrders && szOrders.length > 0){
			szOrders[0].setStatus(DOStatus.UPDATED);
			szOrders[0].setContent_or(new OpTaiCiOrContentFactory().updContentOr(szOrders[0].getContent_or(), dt_b));
			ServiceFinder.find(ICiorderMDOCudService.class).save(szOrders);
		}
		
		return true;
	}
	
	/**
	 * 取消手术预约状态
	 * @param id_or
	 * @return
	 * @throws BizException
	 */
	public boolean CancelAppSurgeryAppointmentStatus(String id_or, String id_operator) throws BizException {
		// 1、有效性判断
		if (CiOrdUtils.isEmpty(id_or)) {
			// throw new BizException ("预约手术医嘱的ID为空，或者预约开始时间为空");
			return false;
		}

		DAFacade dafacade = new DAFacade();
		// 2、查询已经申请预约的手术申请单
		List<OrdApOpDO> rstInfo = (List<OrdApOpDO>) dafacade.findByCond(OrdApOpDO.class,
				String.format(" id_or = '%s' and %s = '%s' ", id_or, OrdApOpDO.SD_SU_OP,ICiDictCodeConst.SD_CI_OPER_YYY),
				new String[] { OrdApOpDO.ID_APOP, OrdApOpDO.SD_SU_OP, OrdApOpDO.DT_PLAN });
		if (null == rstInfo || rstInfo.size() == 0) {
			return false;
		}
		// 3、 更新预约时间和预约状态
		OrdApOpDO ordApOpInfo = rstInfo.get(0);
		
		ordApOpInfo.setId_su_op(ICiDictCodeConst.ID_CI_OPER_YSQ);// 已经申请
		ordApOpInfo.setSd_su_op(ICiDictCodeConst.SD_CI_OPER_YSQ); // 已经申请
		dafacade.updateDO(ordApOpInfo, new String[] { OrdApOpDO.ID_SU_OP, OrdApOpDO.SD_SU_OP});
		return true;
	}
	
	/**
	 * 查询待预约手术申请
	 * @param id_pat
	 * @param id_or
	 * @return
	 * @throws BizException
	 */
	public ReservedSurgeryAppDTO[] GetReservedSurgeryAppInfos(String id_pat, String id_or, boolean status) throws BizException {
		// 1、有效性验证
		if (CiOrdUtils.isEmpty(id_pat) && CiOrdUtils.isEmpty(id_or)){
			return null;
		}
		// 2、查询
		StringBuilder sqlSB = new StringBuilder();
		sqlSB.append(" select srv.id_pat,srv.id_or,srv.id_orsrv,srv.id_srv,srv.id_en,srv.code_entp,srv.id_dep_srv as id_dep_app,srv.id_dep_mp ,");
		sqlSB.append(" ord.name_or, ord.content_or,ord.fg_urgent,ord.id_emp_or id_emp_app,psn.name as name_emp_app,ord.dt_effe dt_app,");
		sqlSB.append(" sug.dt_plan, sug.no_applyform, ");
		sqlSB.append(" dep1.name as name_dep_app, dep2.name as name_dep_mp ");
		sqlSB.append(" from ci_or_srv srv ");
		sqlSB.append(" left join ci_order ord on srv.id_or=ord.id_or ");
		sqlSB.append(" left join ci_ap_sug sug on srv.id_or = sug.id_or ");
		sqlSB.append(" left join bd_dep dep1 on dep1.id_dep = srv.id_dep_srv ");
		sqlSB.append(" left join bd_dep dep2 on dep2.id_dep = srv.id_dep_mp ");
		sqlSB.append(" left join bd_psndoc psn on psn.id_psndoc = ord.id_emp_or ");//ord.fg_sign = 'N' and sug.sd_su_op = '00' and 
		sqlSB.append(" where ord.sd_srvtp like '04%' and ord.fg_canc = 'N' and ord.sd_su_mp = '0' and ord.sd_su_bl != '2' and ");
		sqlSB.append(" ord.fg_sign = '").append(status?"Y":"N").append("' and " );
		sqlSB.append(CiOrdUtils.isEmpty(id_pat)?String.format(" srv.id_or =?"):String.format(" srv.id_pat = ?"));
		
		SqlParam param = new SqlParam();
		if(CiOrdUtils.isEmpty(id_pat)){
			param.addParam(id_or);
		}else{
			param.addParam(id_pat);
		}
		// 3、查询数据库
		DAFacade dafacade = new DAFacade();
		List<ReservedSurgeryAppDTO> listRst = (List<ReservedSurgeryAppDTO>)dafacade.execQuery(sqlSB.toString(), param,new  BeanListHandler(ReservedSurgeryAppDTO.class));
		
		// 4、赋值患者信息
		for (ReservedSurgeryAppDTO item : listRst){
			item.setName_pat(PatInfoCache.GetPatName(item.getId_pat()));
			item.setDt_pat_sex(PatInfoCache.GetPatSex(item.getId_pat()));
			item.setDt_pat_birth(PatInfoCache.GetPatBirth(item.getId_pat()));
			
		}
		return CiOrdUtils.isEmpty(listRst)?null:listRst.toArray(new ReservedSurgeryAppDTO[listRst.size()]);
		
	}
}
