package iih.en.que.s.bp;

import iih.bd.fc.que.d.QueDO;
import iih.bd.fc.que.i.IQueRService;
import iih.bd.fc.quesite.d.QueSiteDO;
import iih.bd.fc.quesite.i.IQuesiteRService;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnSqlUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.que.dto.d.MedTechAppDTO;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.orgfw.dept.d.DeptDO;
import xap.sys.orgfw.dept.i.IDeptRService;
import xap.sys.xbd.udi.d.UdidocDO;
import xap.sys.xbd.udi.i.IUdidocRService;

/**
 * 查询站点  患者信息
 * @author Administrator
 *
 */
public class MedTechAppBySiteAndQueBP {
	
	/**
	 * 查询站点  患者信息
	 * @param quesiteId
	 * @param acptStatus
	 * @param id_que
	 * @param id_dayslot
	 * @return
	 * @throws BizException
	 */
	public MedTechAppDTO[] exec(String quesiteId, String[] acptStatus,String id_que,String id_dayslot)
			throws BizException {

		FDateTime datetime = EnAppUtils.getServerDateTime();
		if (acptStatus.length == 0)
			return null;
		StringBuilder sb = this.getMedSql(null, null);
		sb.append(" where eq.fg_active = 'Y' and eq.id_que_site = ? and substr(eq.dt_in,0,10) =? ");
		sb.append(" and ").append(EnSqlUtils.getInSqlByIds("eq.sd_status_acpt", acptStatus));
		IQueRService queService = ServiceFinder.find(IQueRService.class);
		QueDO queDO= queService.findById(id_que);
		if(queDO.getEu_sorttp() == null)
		{
			sb.append("  order by eq.level_pri desc,eq.dt_in ASC");
		}
		else if(queDO.getEu_sorttp().equals(0))//预约顺序号
		{
			sb.append("  order by eq.level_pri desc,eq.sortno ASC");
		}
		else if(queDO.getEu_sorttp().equals(1))//签到时间
		{
			sb.append("  order by eq.level_pri desc,eq.dt_in ASC");
		}
		
		// 加上eq.level_pri desc(zhengcm 2016-09-13)
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(quesiteId);
		sqlParam.addParam(datetime.getDate());
		List<MedTechAppDTO> result = null;
		result = (List<MedTechAppDTO>) new DAFacade().execQuery(sb.toString(), sqlParam,
				new BeanListHandler(MedTechAppDTO.class));

		IQuesiteRService quesiteService = ServiceFinder.find(IQuesiteRService.class);
		QueSiteDO quesiteDO = quesiteService.findById(quesiteId);
		if (quesiteDO != null) {
			for (MedTechAppDTO medDTO : result) {
				medDTO.setQuesite_name(quesiteDO.getName());
			}
		}
		if (!EnValidator.isEmpty(result)) {
			this.getSexName(result);
			this.loadMpDepInfo(result, null);
			return result.toArray(new MedTechAppDTO[0]);
		} else
			return null;

	}
	
	/**
	 * 加载执行科室信息
	 * 
	 * @param mtAppDTOList
	 * @param benId 分诊台id
	 * @throws BizException
	 */
	private List<MedTechAppDTO> loadMpDepInfo(List<MedTechAppDTO> mtAppDTOList, String benId)
			throws BizException {
		SqlParam sqlParam = new SqlParam();
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("select distinct srv.ID_OR, srv.id_dep_mp ");
		sqlBuilder.append(" from ci_or_srv srv "); // 适当换行
		sqlBuilder.append(" where ").append(EnSqlUtils.getInSqlByIds("srv.ID_OR", EnAppUtils.getKeyPropArrayFromDO("Id_or", mtAppDTOList.toArray(new MedTechAppDTO[0]))));
		// if(!EnValidator.isEmpty(benId)){
		// sqlBuilder.append(" and srv.id_dep_mp in (SELECT ID_DEP FROM BD_QUE WHERE ID_QUEBEN =?)  ");
		// sqlParam.addParam(benId);
		// }
		@SuppressWarnings("unchecked")
		List<OrdSrvDO> ordSrvList = (List<OrdSrvDO>) new DAFacade().execQuery(
				sqlBuilder.toString(), sqlParam, new BeanListHandler(OrdSrvDO.class));

		List<String> idlist = new ArrayList<String>();
		for (OrdSrvDO depInfo : ordSrvList) {
			idlist.add(depInfo.getId_dep_mp());
		}
		IDeptRService depService = ServiceFinder.find(IDeptRService.class);
		DeptDO[] deptdos = depService.findByIds(idlist.toArray(new String[0]), FBoolean.FALSE);

		for (OrdSrvDO depInfo : ordSrvList) {
			for (DeptDO dep : deptdos) {
				if (depInfo.getId_dep_mp().equals(dep.getId_dep())) {
					depInfo.setDep_mp_name(dep.getName());
				}
			}

		}
		for (OrdSrvDO depInfo : ordSrvList) {
			for (MedTechAppDTO mtDTO : mtAppDTOList) {
				if (mtDTO.getId_or() == depInfo.getId_or()) {
					mtDTO.setId_ben(benId);
					mtDTO.setId_dep_mp(depInfo.getId_dep_mp());
					mtDTO.setDep_mp_name(depInfo.getDep_mp_name());
					break;
				}
			}
		}
		return mtAppDTOList;
	}
	
	/**
	 * 查询所有医技申请单SQL
	 * 
	 * @param lest
	 * @param jions
	 * @return
	 */
	private StringBuilder getMedSql(String lest, String jions) {
		StringBuilder sb = new StringBuilder();
		sb.append(" select distinct apt.id_sch, ");
		sb.append(" apt.id_apt, ");
		sb.append(" appl.id_aptappl as id_apt_appl,");
		sb.append(" apt.dt_b as Apt_dt_b, ");
		sb.append(" apt.id_dateslot,");
		sb.append(" en.code_entp,");
		sb.append(" dep.name as  Dep_apply_name,");
		sb.append(" en.id_sex_pat,");
		sb.append(" en.id_pat,");
		sb.append(" en.id_ent,");
		sb.append(" en.sd_sex_pat,");
		sb.append(" en.id_sex_pat,");
		sb.append(" en.name_pat,");
		sb.append(" eq.dt_in,");
		sb.append(" eq.id_que,");
		sb.append(" eq.id_que_site,");
		sb.append(" eq.id_ent_que,");
		sb.append(" eq.id_tick,");
		sb.append(" eq.level_pri,");
		sb.append(" eq.sortno,  ");
		sb.append(" eq.sd_status_acpt, ");// --- 接受状态 1 未到诊 0 到诊，1-叫号，2. 叫号未到， 3 已接受。
		sb.append(" eq.dt_regist, ");//--就诊日期
		sb.append(" eq.code_entp,");//-- 就诊类型 zhengcm 2017-02-14
		sb.append(" q.name que_name, ");// --队列名称
		sb.append(" appl.id_or,");
		sb.append(" appl.dt_effe_or appointment,");
		sb.append(" appl.dt_effe_or Dt_pis_plan,");
		sb.append(" appl.des as des_or,");
		sb.append(" appl.content_or,");
		sb.append(" appl.id_dep_appl as id_dep_apply,");
		sb.append(" appl.id_emp_appl id_emp_ap,");
		sb.append(" appl.applyno as no_applyform,");
		sb.append(" appl.d_b as dt_plan,");
		sb.append(" appl.id_dep_mp,");
		sb.append(" CASE WHEN (eq.sd_status_acpt = '0' and ");
		sb.append(" (eq.id_que_site != '~' or eq.id_que_site is not null)) THEN '1' ");
		sb.append(" WHEN eq.sd_status_acpt = '0' THEN  '0' ");
		sb.append(" WHEN (eq.sd_status_acpt = '1' or eq.sd_status_acpt = '2') THEN '2' ");
		sb.append(" WHEN eq.sd_status_acpt = '7' THEN  '3' ");
		sb.append(" WHEN eq.sd_status_acpt = '8' THEN  '4' ");
		sb.append("     END AS triage_status ");
		sb.append("     from en_ent_que eq ");
		sb.append("     left outer join bd_que q ");
		sb.append("     on eq.id_que = q.id_que ");
		sb.append("     inner join en_ent en ");
		sb.append("     on eq.id_ent = en.id_ent ");
		sb.append("     inner join sc_apt_appl appl on appl.id_or = eq.id_ord");
		sb.append("     left join sc_apt_mt mt on mt.id_aptappl = appl.id_aptappl ");
		sb.append("     inner join sc_apt apt on appl.id_scapt = apt.id_apt and apt.fg_canc = 'N' ");
		sb.append("     left join bd_dep dep ");
		sb.append("     on dep.id_dep = appl.id_dep_appl");
		return sb;
	}
	/**
	 * 根据性别id获取性别名称
	 * 
	 * @param mtAppDTOList
	 * @throws BizException
	 */
	private void getSexName(List<MedTechAppDTO> mtAppDTOList) throws BizException {
		for (MedTechAppDTO medTechAppDTO : mtAppDTOList) {
			if (!EnValidator.isEmpty(medTechAppDTO.getId_sex_pat())) {
				IUdidocRService sexService = ServiceFinder.find(IUdidocRService.class);
				UdidocDO udiSexDO = sexService.findById(medTechAppDTO.getId_sex_pat());
				if (udiSexDO != null && !EnValidator.isEmpty(udiSexDO.getName())) {
					medTechAppDTO.setName_sex(udiSexDO.getName());
				}
			}

		}
	}

}
