package iih.bl.st.blauditip.bp;

import iih.bd.base.utils.SqlUtils;
import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.bl.cg.service.d.OperatorInfoDTO;
import iih.bl.params.BlParams;
import iih.bl.st.blauditip.d.BlAuditIp;
import iih.bl.st.blauditip.d.BlAuditLogIp;
import iih.bl.st.blauditip.d.BlauditipAggDO;
import iih.bl.st.blauditip.i.IBlauditipCudService;
import iih.bl.st.blauditip.i.IBlauditipMDORService;
import iih.bl.st.dto.d.BlAuditLogIpDTO;
import iih.bl.st.dto.d.BlIpAuditCiDTO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.i.ICiorderMDORService;
import iih.en.pv.enfee.d.EnAccountDO;
import iih.en.pv.enfee.d.EnaccountAggDO;
import iih.en.pv.enfee.d.EntAccActDO;
import iih.en.pv.enfee.i.IEnaccountCudService;
import iih.en.pv.enfee.i.IEnaccountRService;
import iih.en.pv.i.IEnOutQryService;
import iih.en.pv.inpatient.d.NewbornDO;
import iih.en.pv.inpatient.i.INewbornRService;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitRService;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.lang.ArrayUtils;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.service.time.TimeService;
import xap.mw.core.service.time.impl.TimeServiceImpl;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 住院费用审核 业务控制相关函数
 * 
 * @author liwq
 *
 */
public class BlAuditIpBp {
	/**
	 * 根据就诊id获取患者就诊账户封账状态
	 * 
	 * @param id_ent
	 *            就诊id
	 * @return FBoolean
	 * @throws BizException
	 * @author liwq
	 * @throws DAException
	 * */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public FBoolean getPatiEntAccStatusInfo(String id_ent) throws BizException {
		FBoolean fBool = FBoolean.FALSE;
		if (id_ent == null)
			return fBool;
		// 1 、拼写sql查询就诊账户状态
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT FG_FREEZE FROM EN_ENT_ACC WHERE ID_ENT = ? ");
		SqlParam param = new SqlParam();
		param.addParam(id_ent);

		List<String> list = (List<String>) new DAFacade().execQuery(
				sql.toString(), param, new ColumnListHandler());
		if (list == null || list.size() <= 0) {
			return fBool;
		}

		if (list.get(0) != null && list.get(0).equals("Y")) {
			fBool = FBoolean.TRUE;
		} else {
			fBool = FBoolean.FALSE;
		}
		return fBool;
	}

	/**
	 * 根据就诊id获取住院费用审核是否有启用审核记录
	 * 
	 * @param id_ent
	 *            就诊id
	 * @return BlAuditIp[]
	 * @throws BizException
	 * @author liwq
	 * @throws DAException
	 * */
	public BlAuditIp[] getPatiIpAuditInfo(String id_ent) throws BizException {
		if (id_ent == null)
			return null;
		List<BlAuditIp> datas = null;
		datas = new ArrayList<BlAuditIp>();
		// 1、通过标准服务查询bl_audit_ip表中对应的审核数据
		IBlauditipMDORService iBlauditipMDORService = ServiceFinder
				.find(IBlauditipMDORService.class);
		// IBlauditipMDOCudService iBlauditipMDOCudService =
		// ServiceFinder.find(IBlauditipMDOCudService.class);

		BlAuditIp[] blAuditIpArr = iBlauditipMDORService.find(
				"fg_active = 'Y' and id_ent = '" + id_ent + "'", "",
				FBoolean.TRUE);

		// 2、返回查询结果集 若查询结果集为null 则默认未通过
		if (blAuditIpArr == null || blAuditIpArr.length <= 0) {
			BlAuditIp itmDo = new BlAuditIp();
			itmDo.setFg_pass_clinic(FBoolean.FALSE);
			itmDo.setFg_pass_hp(FBoolean.FALSE);
			datas.add(itmDo);
			BlAuditIp[] datasArr = datas.toArray(new BlAuditIp[] {});
			return datasArr;
		}
		return blAuditIpArr;
	}

	/**
	 * 保存住院审核（insert新记录）
	 * 
	 * @param 患者就诊id_ent
	 * @param OperatorInfoDTO
	 *            个人信息DTO
	 * @author liwq
	 * @return BlAuditIp
	 */
	public BlAuditIp saveIpAudit(String id_ent, OperatorInfoDTO operatorInfoDTO)
			throws BizException {
		TimeService timeService = new TimeServiceImpl();
		FDateTime Dt_audit = timeService.getUFDateTime();
		// 通过id_ent查询表中是否存在该患者已启用状态的费用审核记录
		IBlauditipMDORService iBlauditipMDORService = ServiceFinder
				.find(IBlauditipMDORService.class);
		BlAuditIp[] blAuditIpArr = iBlauditipMDORService.find(
				"fg_active = 'Y' and id_ent = '" + id_ent + "'", null,
				FBoolean.TRUE);
		// 1、费用审核表中含有启用的费用审核记录
		if (blAuditIpArr != null && blAuditIpArr.length > 0) {

			List<BlauditipAggDO> list = new ArrayList<BlauditipAggDO>();

			for (BlAuditIp blAuditIp : blAuditIpArr) {
				BlauditipAggDO blauditipAggDO = new BlauditipAggDO();
				// 1.1 赋值主表新数据
				// BlAuditIp blAuditIp = blauditipAggDOItm.getParentDO();
				blAuditIp.setFg_pass_clinic(FBoolean.TRUE);
				blAuditIp.setId_emp_clinic(operatorInfoDTO.getId_emp());
				blAuditIp.setDt_audit_clinic(Dt_audit);
				blAuditIp.setId_emp_canc_clinic(null);
				blAuditIp.setDt_audit_canc_clinic(null);
				blAuditIp.setFg_active(FBoolean.TRUE);
				blAuditIp.setStatus(DOStatus.UPDATED);
				blAuditIp.setId_org(operatorInfoDTO.getId_org_emp());
				blAuditIp.setId_grp(operatorInfoDTO.getId_grp());

				// 1.2 赋值子表新数据
				BlAuditLogIp blAuditLogIp = new BlAuditLogIp();
				blAuditLogIp.setId_auditlogip(null);
				blAuditLogIp.setId_auditip(blAuditIp.getId_auditip());
				blAuditLogIp.setEu_act("10");
				blAuditLogIp.setDt_act(Dt_audit);
				blAuditLogIp.setStatus(DOStatus.NEW);
				BlAuditLogIp[] blAuditLogIps = new BlAuditLogIp[] { blAuditLogIp };
				// 1.3 将主子表数据添加到aggDO中
				blauditipAggDO.setParentDO(blAuditIp);
				blauditipAggDO.setBlAuditLogIp(blAuditLogIps);

				list.add(blauditipAggDO);
			}
			BlauditipAggDO[] blauditipAggDOArr = list
					.toArray(new BlauditipAggDO[] {});

			// 1.4 通过aggDO标准服务进行保存
			IBlauditipCudService iBlauditipCudService = ServiceFinder
					.find(IBlauditipCudService.class);
			BlauditipAggDO[] saveAggDOs = iBlauditipCudService
					.save(blauditipAggDOArr);

			return saveAggDOs[0].getParentDO();
		} else {// 2、 （没有已启用的费用审核记录）保存主表数据
			BlauditipAggDO blauditipAggDO = new BlauditipAggDO();

			// 2.1 赋值主表数据
			BlAuditIp headDO = new BlAuditIp();
			headDO.setId_auditip(null);
			headDO.setId_ent(id_ent);
			headDO.setFg_pass_clinic(FBoolean.TRUE);
			headDO.setId_emp_clinic(operatorInfoDTO.getId_emp());
			headDO.setDt_audit_clinic(Dt_audit);
			headDO.setFg_active(FBoolean.TRUE);
			headDO.setStatus(DOStatus.NEW);
			headDO.setId_org(operatorInfoDTO.getId_org_emp());
			headDO.setId_grp(operatorInfoDTO.getId_grp());
			blauditipAggDO.setParentDO(headDO);
			// 2.2 赋值子表数据
			List<BlAuditLogIp> dosLogIpsList = new ArrayList<BlAuditLogIp>();
			BlAuditLogIp dosLogIp = new BlAuditLogIp();
			dosLogIp.setId_auditlogip(null);
			dosLogIp.setId_auditip(null);
			dosLogIp.setEu_act("10");
			dosLogIp.setDt_act(Dt_audit);
			dosLogIp.setId_emp_act(operatorInfoDTO.getId_emp());
			dosLogIp.setStatus(DOStatus.NEW);

			dosLogIpsList.add(dosLogIp);
			BlAuditLogIp[] dosLogIpsArr = dosLogIpsList
					.toArray(new BlAuditLogIp[] {});
			blauditipAggDO.setBlAuditLogIp(dosLogIpsArr);

			BlauditipAggDO[] blauditipAggDOArr = new BlauditipAggDO[] { blauditipAggDO };
			// 2.3 通过aggDo服务进行保存
			IBlauditipCudService iBlauditipCudService = ServiceFinder
					.find(IBlauditipCudService.class);
			BlauditipAggDO[] saveAggDOs = iBlauditipCudService
					.save(blauditipAggDOArr);

			return saveAggDOs[0].getParentDO();
		}
	}

	/**
	 * 取消住院审核（更新住院审核标志）
	 * 
	 * @param 费用已审核记录主键id_auditip
	 * @param OperatorInfoDTO
	 *            个人信息DTO
	 * @author liwq
	 * @return BlAuditIp
	 */
	public BlAuditIp cancelIpAudit(BlAuditIp auditIp,
			OperatorInfoDTO operatorInfoDTO) throws BizException {
		BlauditipAggDO blauditipAggDO = new BlauditipAggDO();
		TimeService timeService = new TimeServiceImpl();
		FDateTime dt_cancel = timeService.getUFDateTime();
		// 1、保存主表取消操作数据
		auditIp.setFg_pass_clinic(FBoolean.FALSE);
		auditIp.setId_emp_clinic(null);
		auditIp.setDt_audit_clinic(null);
		//auditIp.setFg_active(FBoolean.FALSE);
		auditIp.setId_emp_canc_clinic(operatorInfoDTO.getId_emp());
		auditIp.setDt_audit_canc_clinic(dt_cancel);
		auditIp.setStatus(DOStatus.UPDATED);
		auditIp.setId_org(operatorInfoDTO.getId_org_emp());
		auditIp.setId_grp(operatorInfoDTO.getId_grp());
		blauditipAggDO.setParentDO(auditIp);

		// 2、保存子表取消日志数据
		BlAuditLogIp blAuditLogIp = new BlAuditLogIp();

		blAuditLogIp.setId_auditlogip(null);
		blAuditLogIp.setId_auditip(auditIp.getId_auditip());
		blAuditLogIp.setEu_act("11");
		blAuditLogIp.setDt_act(dt_cancel);
		blAuditLogIp.setId_emp_act(operatorInfoDTO.getId_emp());
		blAuditLogIp.setStatus(DOStatus.NEW);

		BlAuditLogIp[] blAuditLogIps = new BlAuditLogIp[] { blAuditLogIp };
		blauditipAggDO.setBlAuditLogIp(blAuditLogIps);
		// 3、通过aggDO更新
		BlauditipAggDO[] blauditipAggDOs = new BlauditipAggDO[] { blauditipAggDO };
		IBlauditipCudService iBlauditipCudService = ServiceFinder
				.find(IBlauditipCudService.class);
		BlauditipAggDO[] updateAggDOs = iBlauditipCudService
				.save(blauditipAggDOs);
		return updateAggDOs[0].getParentDO();
	}

	/**
	 * 医保审核（更新医保审核标志）
	 * 
	 * @param 费用已审核记录主键id_auditip
	 * @param OperatorInfoDTO
	 *            个人信息DTO
	 * @author liwq
	 * @return BlAuditIp
	 */
	public BlAuditIp saveHpAudit(String id_ent, OperatorInfoDTO operatorInfoDTO)
			throws BizException {

		TimeService timeService = new TimeServiceImpl();
		FDateTime Dt_audit = timeService.getUFDateTime();
		// 通过id_ent查询表中是否存在该患者已启用状态的费用住院审核记录
		IBlauditipMDORService iBlauditipMDORService = ServiceFinder
				.find(IBlauditipMDORService.class);
		BlAuditIp[] blAuditIpArr = iBlauditipMDORService.find(
				"fg_active = 'Y' and id_ent = '" + id_ent + "'", null,
				FBoolean.TRUE);
		List<BlauditipAggDO> list = new ArrayList<BlauditipAggDO>();
		if (blAuditIpArr == null || blAuditIpArr.length <= 0) {
			// 1、费用审核表中不含有启用的费用审核记录

			BlauditipAggDO blauditipAggDO = new BlauditipAggDO();
			BlAuditIp blAuditIp = new BlAuditIp();
			// 1.1 赋值主表新数据
			blAuditIp.setId_auditip(null);
			blAuditIp.setFg_pass_hp(FBoolean.TRUE);
			blAuditIp.setId_emp_hp(operatorInfoDTO.getId_emp());
			blAuditIp.setDt_audit_hp(Dt_audit);
			blAuditIp.setId_emp_canc_hp(null);
			blAuditIp.setDt_audit_canc_hp(null);
			blAuditIp.setFg_active(FBoolean.TRUE);
			blAuditIp.setStatus(DOStatus.NEW);
			blAuditIp.setId_org(operatorInfoDTO.getId_org_emp());
			blAuditIp.setId_grp(operatorInfoDTO.getId_grp());

			// 1.2 赋值子表新数据
			BlAuditLogIp blAuditLogIp = new BlAuditLogIp();
			blAuditLogIp.setId_auditlogip(null);
			blAuditLogIp.setId_auditip(null);
			blAuditLogIp.setEu_act("20");
			blAuditLogIp.setDt_act(Dt_audit);
			blAuditLogIp.setStatus(DOStatus.NEW);
			BlAuditLogIp[] blAuditLogIps = new BlAuditLogIp[] { blAuditLogIp };
			// 1.3 将主子表数据添加到aggDO中
			blauditipAggDO.setParentDO(blAuditIp);
			blauditipAggDO.setBlAuditLogIp(blAuditLogIps);

			list.add(blauditipAggDO);
			BlauditipAggDO[] blauditipAggDOArr = list
					.toArray(new BlauditipAggDO[] {});

			// 1.4 通过aggDO标准服务进行保存
			IBlauditipCudService iBlauditipCudService = ServiceFinder
					.find(IBlauditipCudService.class);
			BlauditipAggDO[] saveAggDOs = iBlauditipCudService
					.save(blauditipAggDOArr);

			return saveAggDOs[0].getParentDO();
		} else {
			// 2、费用审核表中含有启用的费用审核记录
			BlauditipAggDO blauditipAggDO = new BlauditipAggDO();
			for (BlAuditIp blAuditIpBp : blAuditIpArr) {
				// 2.1 赋值主表新数据
				blAuditIpBp.setFg_pass_hp(FBoolean.TRUE);
				blAuditIpBp.setId_emp_hp(operatorInfoDTO.getId_emp());
				blAuditIpBp.setDt_audit_hp(Dt_audit);
				blAuditIpBp.setId_emp_canc_hp(null);
				blAuditIpBp.setDt_audit_canc_hp(null);

				blAuditIpBp.setStatus(DOStatus.UPDATED);
				blAuditIpBp.setId_org(operatorInfoDTO.getId_org_emp());
				blAuditIpBp.setId_grp(operatorInfoDTO.getId_grp());

				// 2.2 赋值子表新数据
				BlAuditLogIp blAuditLogIp = new BlAuditLogIp();
				blAuditLogIp.setId_auditlogip(null);
				blAuditLogIp.setId_auditip(blAuditIpArr[0].getId_auditip());
				blAuditLogIp.setEu_act("20");
				blAuditLogIp.setDt_act(Dt_audit);
				blAuditLogIp.setStatus(DOStatus.NEW);
				BlAuditLogIp[] blAuditLogIps = new BlAuditLogIp[] { blAuditLogIp };
				// 2.3 将主子表数据添加到aggDO中
				blauditipAggDO.setParentDO(blAuditIpArr[0]);
				blauditipAggDO.setBlAuditLogIp(blAuditLogIps);

				list.add(blauditipAggDO);
			}
			BlauditipAggDO[] blauditipAggDOArr = list
					.toArray(new BlauditipAggDO[] {});

			// 2.4 通过aggDO标准服务进行保存
			IBlauditipCudService iBlauditipCudService = ServiceFinder
					.find(IBlauditipCudService.class);
			BlauditipAggDO[] saveAggDOs = iBlauditipCudService
					.save(blauditipAggDOArr);

			return saveAggDOs[0].getParentDO();
		}
	}

	/**
	 * 取消医保审核（更新医保审核标志）
	 * 
	 * @param id_auditip
	 * @param OperatorInfoDTO
	 *            个人信息DTO
	 * @author liwq
	 * @return FBoolean
	 */
	public BlAuditIp cancelHpAudit(BlAuditIp blAuditIp,
			OperatorInfoDTO operatorInfoDTO) throws BizException {
		BlauditipAggDO blauditipAggDO = new BlauditipAggDO();
		TimeService timeService = new TimeServiceImpl();
		FDateTime dt_cancel = timeService.getUFDateTime();
		// 1、保存主表取消操作数据
		blAuditIp.setFg_pass_hp(FBoolean.FALSE);
		blAuditIp.setId_emp_hp(null);
		blAuditIp.setDt_audit_hp(null);
		blAuditIp.setId_emp_canc_hp(operatorInfoDTO.getId_emp());
		blAuditIp.setDt_audit_canc_hp(dt_cancel);
		// blAuditIp.setFg_active(FBoolean.TRUE);
		blAuditIp.setStatus(DOStatus.UPDATED);
		blAuditIp.setId_org(operatorInfoDTO.getId_org_emp());
		blAuditIp.setId_grp(operatorInfoDTO.getId_grp());
		blauditipAggDO.setParentDO(blAuditIp);

		// 2、保存子表取消日志数据
		BlAuditLogIp blAuditLogIp = new BlAuditLogIp();

		blAuditLogIp.setId_auditlogip(null);
		blAuditLogIp.setId_auditip(blAuditIp.getId_auditip());
		blAuditLogIp.setEu_act("21");
		blAuditLogIp.setDt_act(dt_cancel);
		blAuditLogIp.setId_emp_act(operatorInfoDTO.getId_emp());
		blAuditLogIp.setStatus(DOStatus.NEW);

		BlAuditLogIp[] blAuditLogIps = new BlAuditLogIp[] { blAuditLogIp };
		blauditipAggDO.setBlAuditLogIp(blAuditLogIps);
		// 3、通过aggDO更新
		BlauditipAggDO[] blauditipAggDOs = new BlauditipAggDO[] { blauditipAggDO };
		IBlauditipCudService iBlauditipCudService = ServiceFinder
				.find(IBlauditipCudService.class);
		BlauditipAggDO[] updateAggDOs = iBlauditipCudService
				.save(blauditipAggDOs);

		return updateAggDOs[0].getParentDO();
	}

	/**
	 * 根据就诊id 获取医嘱内容
	 * 
	 * @param id_ent
	 * @return BlIpAuditCiDTO[]
	 * @author liwq
	 */
	@SuppressWarnings("unchecked")
	public BlIpAuditCiDTO[] getBlIpAuditCiInfo(BlIpAuditCiDTO auditCiDto)
			throws BizException {
		if (auditCiDto == null)
			return null;
		String id_ent = auditCiDto.getId_ent();
		List<BlIpAuditCiDTO> list = new ArrayList<BlIpAuditCiDTO>();

		// 从CI域查询医嘱信息
		// 查询就诊id是否是母婴关系就诊
		FBoolean isMerge =  BlParams.BLSTIP0005();
		IEnOutQryService enService = ServiceFinder.find(IEnOutQryService.class);
		NewbornDO entNewBorn = enService.getNewbornDO(id_ent);
		
		//判断当前id_ent 是婴儿的就诊id
		String[] entIdArr = null;
		if(entNewBorn == null && FBoolean.TRUE.equals(isMerge)) { 
			// 当前就诊id是母亲的，则查询所有婴儿BB的就诊id
			INewbornRService nbService = ServiceFinder.find(INewbornRService.class);
			NewbornDO[] newborn = nbService.find("id_ent_mom = '" + id_ent + "'", "", FBoolean.FALSE);
			entIdArr = new String[newborn.length + 1];
			for (int i = 0; i < newborn.length + 1; i++) {
				if (i != newborn.length)
					entIdArr[i] = newborn[i].getId_ent_bb();
				else
					entIdArr[i] = id_ent;
			}					
		} else {
			entIdArr = new String[]{id_ent};
		}	 
		
		ICiorderMDORService iCiorderMDORService = ServiceFinder.find(ICiorderMDORService.class);		
		String whereStr = SqlUtils.getInSqlByIds("id_en", entIdArr);
		CiOrderDO[] ciOrderArr = iCiorderMDORService.find(whereStr," dt_effe ", FBoolean.TRUE);

		if (ArrayUtils.isEmpty(ciOrderArr)) {
			return null;
		}
		for (CiOrderDO ciOrderItm : ciOrderArr) {
			BlIpAuditCiDTO auditCiItm = new BlIpAuditCiDTO();
			auditCiItm.setId_ent(ciOrderItm.getId_en()); //使用个人就诊id
			auditCiItm.setId_or(ciOrderItm.getId_or());
			auditCiItm.setName_srv(ciOrderItm.getContent_or()); // 医嘱内容
			auditCiItm.setName_or(ciOrderItm.getName_or()); // 服务名称拼接
			auditCiItm.setFg_long(ciOrderItm.getFg_long().toString());

			auditCiItm.setDt_effe(ciOrderItm.getDt_effe().toString());
			TimeService timeService = new TimeServiceImpl();
			FDateTime dt_NowFDateTime = timeService.getUFDateTime();
			String strEnd = "";
			if (ciOrderItm.getDt_end() != null)
				strEnd = (ciOrderItm.getDt_end().getYear() - dt_NowFDateTime.getYear()) > 2 ? null : ciOrderItm.getDt_end().toString();
			auditCiItm.setDt_end(strEnd);
			auditCiItm.setId_emp_or(ciOrderItm.getId_emp_or());

			String sqlEmp = "select name from bd_psndoc where id_psndoc = '"
					+ ciOrderItm.getId_emp_or() + "'";
			List<String> nameList = (List<String>) new DAFacade().execQuery(
					sqlEmp, new ColumnListHandler());

			auditCiItm.setEmp_name_or(nameList.get(0));

			list.add(auditCiItm);
		}

		BlIpAuditCiDTO[] dataArr = list.toArray(new BlIpAuditCiDTO[] {});

		return dataArr;
	}
	
	/**
	 * 获取医嘱内容对应的记账明细(分页)
	 * @param BlIpAuditCiDTO  合计项dto
	 * @param PaginationInfo
	 * @author liwq
	 * @param pageInfo 
	 * @throws BizException 
	 * @throws DAException
	 */
	public PagingRtnData<BlIpAuditCiDTO> getIpCiCgFeePageInfo(
			BlIpAuditCiDTO auditCiDto, PaginationInfo pageInfo) throws BizException {
		// TODO Auto-generated method stub
		if (auditCiDto == null)
			return null;
		
		PagingRtnData<BlIpAuditCiDTO> pageCiCgDto = new PagingRtnData<BlIpAuditCiDTO>();
		PagingServiceImpl<BlIpAuditCiDTO> service =new PagingServiceImpl();
		
		String id_ent = auditCiDto.getId_ent();
		List<BlIpAuditCiDTO> list = new ArrayList<BlIpAuditCiDTO>();
		if (auditCiDto.getId_or() != null) {
			// 查询医嘱记账明细
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT  to_char(A0.AMT_RATIO * A0.EU_DIRECT, '99999990.00')  AS AMT_RATIO, ");
			sql.append("A0.NAME_SRV, to_char(A0.QUAN*A0.EU_DIRECT , '99999990.00') as quan, A0.SPEC, to_char(A0.PRICE, '99999990.0000') as PRICE,to_char(A0.PRICE_RATIO, '99999990.0000') as PRICE_RATIO, ");
			sql.append("A0.ID_SRV, A0.ID_ENT,CI.ID_OR, ");
			sql.append("A0.ID_EMP_OR, B0.NAME AS EMP_NAME_OR, ");
			sql.append("CI.FG_LONG,CI.DT_EFFE AS DT_EFFE,CI.DT_END AS DT_END, a0.note,a0.dt_cg ");
			sql.append("FROM BL_CG_IP A0 ");
			sql.append("LEFT JOIN BD_PSNDOC B0 ON A0.ID_EMP_OR = B0.ID_PSNDOC  ");
			sql.append("INNER JOIN CI_ORDER CI ON A0.ID_OR = CI.ID_OR ");
			sql.append("WHERE  A0.ID_ENT = ?  ");
			sql.append("AND A0.ID_OR = ? ");

			SqlParam param = new SqlParam();
			param.addParam(id_ent);
			param.addParam(auditCiDto.getId_or());


			pageCiCgDto = service.findByPageInfo(new BlIpAuditCiDTO(), pageInfo, sql.toString(), "", param);
			
		}
		
		return pageCiCgDto;
	}
	/**
	 * 根据就诊id对患者就诊账户进行冻结或解封
	 * 
	 * @param bFlag
	 *            真：冻结 假：解封
	 * @param id_ent
	 * @author liwq
	 */
	public FBoolean doFreezeEnAccBoolean(String id_ent, String id_emp,
			FBoolean bFlag) throws BizException {
		// 1、根据enaccountAggDO标准服务查询en_ent_acc原有数据
		IEnaccountRService iEnaccountRService = ServiceFinder
				.find(IEnaccountRService.class);
		EnaccountAggDO[] enaccountAggDOsTmp = iEnaccountRService.find(
				"id_ent = '" + id_ent + "'", null, FBoolean.TRUE);

		if (enaccountAggDOsTmp == null || enaccountAggDOsTmp.length <= 0)
			return FBoolean.FALSE;
		EnAccountDO enAccountDO = enaccountAggDOsTmp[0].getParentDO();
		// 判断是冻结还是解封
		if (bFlag.booleanValue()) {
			enAccountDO.setFg_freeze(FBoolean.TRUE);
		} else {
			enAccountDO.setFg_freeze(FBoolean.FALSE);
		}
		enAccountDO.setStatus(DOStatus.UPDATED);
		// 2、添加子表操作明细数据
		EntAccActDO entAccActDO = new EntAccActDO();
		entAccActDO.setId_entaccact(null);
		entAccActDO.setId_entacc(enAccountDO.getId_entacc());
		entAccActDO.setId_accacttp(IPiDictCodeConst.ID_ACCACTTP_LOCKCRED);
		entAccActDO.setSd_accacttp(IPiDictCodeConst.SD_ACCACTTP_LOCKCRED);
		entAccActDO.setAccfileno(null);
		TimeService timeService = new TimeServiceImpl();
		FDateTime Oricret = timeService.getUFDateTime();
		entAccActDO.setOricret(Oricret);
		// 判断是冻结还是解封的操作方向
		if (bFlag.booleanValue()) {
			entAccActDO.setNewcret(1);
		} else {
			entAccActDO.setNewcret(-1);
		}

		entAccActDO.setCred(enAccountDO.getAmt_prepay());
		entAccActDO.setId_emp(id_emp);
		entAccActDO.setStatus(DOStatus.NEW);

		EntAccActDO[] entAccActDOs = new EntAccActDO[] { entAccActDO };
		// 3、通过aggDo 进行更新保存
		EnaccountAggDO enaccountAggDO = new EnaccountAggDO();
		enaccountAggDO.setParentDO(enAccountDO);
		enaccountAggDO.setEntAccActDO(entAccActDOs);
		EnaccountAggDO[] enaccountAggDOs = new EnaccountAggDO[] { enaccountAggDO };

		IEnaccountCudService iEnaccountCudService = ServiceFinder
				.find(IEnaccountCudService.class);

		EnaccountAggDO[] enaccountAggDOsRtn = iEnaccountCudService
				.save(enaccountAggDOs);

		if (enaccountAggDOsRtn == null || enaccountAggDOsRtn.length <= 0)
			return FBoolean.FALSE;

		return FBoolean.TRUE;
	}

	/**
	 * 获取就诊审核状态
	 * 
	 * @throws BizException
	 * */
	public FBoolean getAuditIpStatus(String id_ent) throws BizException {
		// 查询患者姓名
		IPativisitRService iPativisitRService = ServiceFinder
				.find(IPativisitRService.class);
		PatiVisitDO patiVisitDO = iPativisitRService.findById(id_ent);
		// 判断封账状态
		FBoolean accStatue = this.getPatiEntAccStatusInfo(id_ent);
		if (accStatue.booleanValue()) {
			throw new BizException(patiVisitDO.getName_pat()+"，患者的费用已经封账，禁止执行补/退费操作！");
		}
		// 判断审核状态
		BlAuditIp[] blAuditIpArr = this.getPatiIpAuditInfo(id_ent);
		if (blAuditIpArr != null && blAuditIpArr.length > 0
				&& blAuditIpArr[0].getId_auditip() != null) {
			if (blAuditIpArr[0].getFg_pass_clinic().booleanValue()
					|| blAuditIpArr[0].getFg_pass_hp().booleanValue()) // by
																		// liwq
																		// 与补退费条件一致
				throw new BizException(patiVisitDO.getName_pat()+"，患者的费用正在审核结算流程中，禁止执行操作！");
		}
		return FBoolean.TRUE;
	}	

	/**
	 * 获取审核记录的子记录
	 * @param id_auditIp
	 * @return
	 * @throws BizException
	 */
	public BlAuditLogIpDTO [] geAuditLogIpDTOs(String id_auditIp)throws BizException{
		if (StringUtil.isEmpty(id_auditIp)) {
			return null;
		}
		StringBuilder sbsql=new StringBuilder();
		sbsql.append(" select log.id_auditlogip, ");
		sbsql.append(" log.id_auditip, ");
		sbsql.append(" log.eu_act as eu_act_code, ");
		sbsql.append(" log.dt_act, ");
		sbsql.append(" doc.name as name_emp_act, ");
		sbsql.append(" (case eu_act when '10' then '住院审核通过' "
				+ "when '11' then '住院审核取消' "
				+ "when '20' then '医保审核通过' "
				+ "when '21' then '医保审核取消' "
				+ "when '90' then '结算' "
				+ "when '91' then '取消结算'"
				+ "when '80' then '取消出纳' "
				+ "when '70' then '退费重算' "
				+ "else '其它' end ) eu_act_name ");
		sbsql.append("  from bl_audit_log_ip  log ");
		sbsql.append(" left join bd_psndoc doc  on doc.id_psndoc=log.id_emp_act ");
		sbsql.append(" where id_auditip='").append(id_auditIp).append("'");
		sbsql.append(" order by log.dt_act desc ");
		List<BlAuditLogIpDTO> cgList = (List<BlAuditLogIpDTO>) new DAFacade().execQuery(sbsql.toString(),
				new BeanListHandler(BlAuditLogIpDTO.class));
		if (ListUtil.isEmpty(cgList)) {
			return null;
		}
		return cgList.toArray(new BlAuditLogIpDTO[]{});
	}

}
