package iih.ci.ord.s.bp;

import com.mysql.jdbc.StringUtils;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.bd.srv.diagdef.d.DiagDefDO;
import iih.bd.srv.diagdef.i.IDiagdefMDORService;
import iih.ci.ord.cior.d.CiorappsurgeryAggDO;
import iih.ci.ord.cior.d.OrdOpEmpDO;
import iih.ci.ord.cior.i.ICiorappsurgeryRService;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.log.OrdBizLogger;
import iih.sc.apt.out.ci.d.ScAddApplInParamDTO;
import iih.sc.apt.out.ci.d.ScAptOptEmpDTO;
import iih.sc.apt.out.i.ISc4CiCmdService;
import iih.sc.apt.scaptappl.d.EuAptmd;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

public class CiOrSufInfo4ScAptApplBp {

	/**
	 * 签署调用SC接口向sc回写手术申请单信息
	 * @param orders
	 * @throws BizException
	 */
	public void sendSugInfo4ScAptAppl(CiOrderDO[] orders) throws BizException{
		if (CiOrdUtils.isEmpty(orders)) return;
		ICiorappsurgeryRService iciorappsurgeryrservice = ServiceFinder.find(ICiorappsurgeryRService.class);
		ISc4CiCmdService isc4cicmdservice = ServiceFinder.find(ISc4CiCmdService.class);
		StringBuffer cond = new StringBuffer();
		for (CiOrderDO ciOrderDO : orders) {
			cond.delete(0, cond.length());
			cond.append("id_or = '").append(ciOrderDO.getId_or()).append("'");
			if(ciOrderDO.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_OP)){
				CiorappsurgeryAggDO[] aggDOs = iciorappsurgeryrservice.find(cond.toString(), null, FBoolean.FALSE); 
				if(CiOrdUtils.isEmpty(aggDOs)) continue;
				ScAddApplInParamDTO scaddapplinparamdto = new ScAddApplInParamDTO();
				FArrayList scaptoptempdto_list = new FArrayList();
				handleSugAgg4ScApt(ciOrderDO,aggDOs[0], scaddapplinparamdto, scaptoptempdto_list);
				isc4cicmdservice.addScAptAppl(scaddapplinparamdto);
			}
		}
	}
	
	private void handleSugAgg4ScApt(CiOrderDO ord,CiorappsurgeryAggDO aggDO,ScAddApplInParamDTO param,FArrayList scemplist) throws BizException{
		param.setFg_infection(aggDO.getParentDO().getFg_infection_sug());//是否感染手术
		param.setDt_effe_or(ord.getDt_effe());
		param.setId_or(ord.getId_or());
		param.setApplyno(ord.getApplyno());
		param.setContent_or(ord.getContent_or());
		param.setD_begin(aggDO.getParentDO().getDt_plan().getBeginDate());
		param.setDes_or(ord.getDes_or());
		param.setDt_appl(aggDO.getParentDO().getDt_plan());
		param.setFg_urgent(ord.getFg_urgent());
		param.setId_ent(ord.getId_en());
		param.setId_srv(ord.getId_srv());
		param.setName_or(ord.getName_or());
		param.setId_dep_mp(ord.getId_dep_mp());
		param.setId_dep_appl(ord.getId_dep_sign());//手术申请科室
		param.setId_emp_appl(ord.getId_emp_sign());//手术申请人员
		param.setSd_sctp(IScDictCodeConst.SD_SCTP_OT);//手术
		param.setSd_aptmd(EuAptmd.APPL.toString());
		param.setSd_sys_from(IScDictCodeConst.SD_SYS_FROM_IIH);
		param.setId_entp(ord.getId_entp());//就诊类型id
		param.setCode_entp(ord.getCode_entp());
		param.setCode_or(ord.getCode_or());
		param.setId_anestp(aggDO.getParentDO().getId_anestp());//麻醉方式id
		param.setSd_anestp(aggDO.getParentDO().getSd_anestp());//麻醉方式编码
		param.setSpecialreq(aggDO.getParentDO().getSpecialreq());//特殊用物
		param.setSpecialinstrument(aggDO.getParentDO().getSpecialinstrument());//特殊仪器
		param.setSpecialdes(aggDO.getParentDO().getSpecialdes());//特殊准备
		//FIXME bug 0139284: 手术预约里的诊断，要和手术申请单上的诊断一致
		//手术申请表中的id_di有两个用途，
		//1.当存在住院诊断时，id_di存ci_di_itm中的主键，此时Str_name_di和Str_code_di有值；
		//2.当不存在住院诊断时，id_di为bd_di_def中主键,此时Str_name_di和Str_code_di为空；
		if(StringUtils.isNullOrEmpty(aggDO.getParentDO().getName_diag())&&!StringUtils.isNullOrEmpty(aggDO.getParentDO().getId_di())){
			DiagDefDO diagDefDO = getDiagDefDO(aggDO.getParentDO().getId_di());
			if(diagDefDO!=null){
				param.setName_di(diagDefDO.getName());//诊断名称
				param.setCode_di(diagDefDO.getCode());//诊断编码
			}
		}else{
			param.setName_di(aggDO.getParentDO().getName_diag());//诊断名称
		}
		param.setAnnouncements(aggDO.getParentDO().getAnnouncements());//注意事项
		param.setSug_require(aggDO.getParentDO().getSug_require());//手术要求
		param.setId_surgical_site(aggDO.getParentDO().getId_surgical_site());//二次手术部位id
		param.setSd_surgical_site(aggDO.getParentDO().getSd_surgical_site());//二次手术部位编码
		OrdOpEmpDO[] ordopemps = aggDO.getOrdOpEmpDO();
		//通过手术申请表，向手术人员表中保存主刀医师和第一助手
		if (!StringUtil.isEmptyWithTrim(aggDO.getParentDO().getId_emp_operate())) {
			ScAptOptEmpDTO opEmp = new ScAptOptEmpDTO();
			opEmp.setSd_role(ICiDictCodeConst.SD_OP_ROLE_ZDYS);
			opEmp.setId_role(ICiDictCodeConst.ID_OP_ROLE_ZDYS);
			opEmp.setId_emp(aggDO.getParentDO().getId_emp_operate());
			opEmp.setId_aptappl(aggDO.getParentDO().getId_apop());
			scemplist.add(opEmp);
		}
		if (!StringUtil.isEmptyWithTrim(aggDO.getParentDO().getId_emp_helper())) {
			ScAptOptEmpDTO opEmp = new ScAptOptEmpDTO();
			opEmp.setSd_role(ICiDictCodeConst.SD_OP_ROLE_DYZS);
			opEmp.setId_role(ICiDictCodeConst.ID_OP_ROLE_DYZS);
			opEmp.setId_emp(aggDO.getParentDO().getId_emp_helper());
			opEmp.setId_aptappl(aggDO.getParentDO().getId_apop());
			scemplist.add(opEmp);
		}
		if(!CiOrdUtils.isEmpty(ordopemps)){
			for (OrdOpEmpDO ordOpEmpDO : ordopemps) {
				//判断是否主刀医师和第一助手，是就跳过
				if (ICiDictCodeConst.ID_OP_ROLE_ZDYS.equals(ordOpEmpDO.getId_role())
						|| ICiDictCodeConst.ID_OP_ROLE_DYZS.equals(ordOpEmpDO.getId_role()))
				{
					continue;
				}
				ScAptOptEmpDTO opEmp = new ScAptOptEmpDTO();
				opEmp.setSd_role(ordOpEmpDO.getSd_role());
				opEmp.setId_role(ordOpEmpDO.getId_role());
				opEmp.setId_emp(ordOpEmpDO.getId_emp());
				opEmp.setId_aptappl(ordOpEmpDO.getId_apop());
				scemplist.add(opEmp);
			}
		}
		param.setExtend(scemplist);
	}
	
	/**
	 * 撤销、删除、作废调用SC接口向sc回写手术申请撤回信息
	 * @param orders
	 * @throws BizException
	 */
	public void sendSugInfo4ScAptAppl(CiEnContextDTO ctx,CiOrderDO[] ciors) throws BizException{
		if(CiOrdUtils.isEmpty(ciors)) return;
		ISc4CiCmdService isc4cicmdservice = ServiceFinder.find(ISc4CiCmdService.class);
		for (CiOrderDO ciOrderDO : ciors) {
			if (ciOrderDO.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_OP) || ciOrderDO.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_RIS)|| ciOrderDO.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_LIS) 
					|| ciOrderDO.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_TREAT)) {
				try{
					if(ctx == null){
						isc4cicmdservice.cancScAptAppl(ciOrderDO.getId_or(), Context.get().getUserId(), CiOrdAppUtils.getServerDateTime(), ciOrderDO.getSd_su_or());
					}else{
						isc4cicmdservice.cancScAptAppl(ciOrderDO.getId_or(), ctx.getId_psndoc(), CiOrdAppUtils.getServerDateTime(), ciOrderDO.getSd_su_or());
					}
					
				}catch(Exception ex){
					OrdBizLogger.info(ctx, "手术取消预约失败：【"+ciOrderDO.getName_or()+"】,"+ciOrderDO.getCode_or());
				}
			}
		}
	}
	/**
	 * 查询诊断
	 * @param id_didef
	 * @return
	 * @throws BizException
	 */
	private DiagDefDO getDiagDefDO(String id_didef) throws BizException{
		IDiagdefMDORService diagService = ServiceFinder.find(IDiagdefMDORService.class);
		DiagDefDO diagDefDO = diagService.findById(id_didef);
		return diagDefDO;
	}
}
