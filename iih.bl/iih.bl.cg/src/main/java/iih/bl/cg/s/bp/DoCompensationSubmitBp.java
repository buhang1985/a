package iih.bl.cg.s.bp;

import java.util.ArrayList;
import java.util.List;

import iih.bl.cg.dto.cglogic.d.BlCgAccountDTO;
import iih.bl.cg.dto.cglogic.d.BlCgAccountRltDTO;
import iih.bl.cg.dto.cglogic.d.BlCgAccountSetDTO;
import iih.bl.cg.dto.cglogic.d.BlCgErrorDTO;
import iih.bl.cg.dto.d.BlNurSubsidyErrorReturnDTO;
import iih.bl.cg.dto.d.NurseCompFeeItmDTO;
import iih.bl.cg.i.IBlCgAccountService;
import iih.bl.comm.IBlCgFuncConst;
import iih.bl.comm.util.BlFlowContextUtil;
import iih.bl.pay.blpaypat.d.BookRtnDirectEnum;
import iih.en.pv.inpatient.d.InpatientDO;
import iih.en.pv.inpatient.i.IInpatientRService;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitRService;
import xap.lui.core.xml.StringUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;

/**
 * 住院退补费-进行补费确认
 * @param dtoArr
 * @author liwq
 * @since 2018年3月31日6:04:03
 * @return
 * @throws BizException
 */
public class DoCompensationSubmitBp {

	public BlNurSubsidyErrorReturnDTO[] exec (NurseCompFeeItmDTO[] dtoArr, String[] list_id_ent) throws BizException {
		
		if(dtoArr == null || dtoArr.length == 0){
			return null;
		}
		
		List<BlCgAccountDTO> blCgAccountDTOs=new ArrayList<>();
		
		PatiVisitDO []patiVisitDOs=this.getPatiVisitDO(list_id_ent);
		if(ArrayUtil.isEmpty(patiVisitDOs)){
			throw new BizException("未查询到补费的患者！");
		}
		
		if(!IsCancle(list_id_ent)){
			throw new BizException("患者已退诊疗或取消入科");
		}
		
		for (PatiVisitDO pVisitDO : patiVisitDOs) {
			if(StringUtils.isEmptyWithTrim(pVisitDO.getId_ent())) {
				throw new BizException("对患者进行补费时，就诊id不能为空！");
			}
			
			//获取就诊信息
			for (NurseCompFeeItmDTO itmDTO : dtoArr) {
				BlCgAccountDTO blCgAccountDTO=AssembleBookkeepingData(itmDTO,pVisitDO,itmDTO.getId_dep_mp(),itmDTO.getId_dep_or());
				blCgAccountDTOs.add(blCgAccountDTO);
			}
		}
		FDateTime dateTime = null;
		if(dtoArr[0].getDt_oper_cg() == null){
			dateTime = BlFlowContextUtil.getNowTime();
		}else{
			dateTime = dtoArr[0].getDt_oper_cg();
		}
		
		//获取记账配置
		BlCgAccountSetDTO blCgAccountSetDTO=getBlCgAccountSetDTO(dtoArr[0].getId_dep_mp(),dateTime);
		
		//调用新的记账接口
		IBlCgAccountService iBlCgAccountService=ServiceFinder.find(IBlCgAccountService.class);
		BlCgAccountRltDTO keepAccountForIp = iBlCgAccountService.keepAccountForIp(blCgAccountDTOs.toArray(new BlCgAccountDTO[0]), blCgAccountSetDTO);
		
		BlCgErrorDTO [] error_entlist = (BlCgErrorDTO [])keepAccountForIp.getError_entlist().toArray(new BlCgErrorDTO []{});
		return this.returnValues(error_entlist, patiVisitDOs);
	}
	/**
	 * 
	 * @Title: AssembleBookkeepingData   
	 * @Description: 组装记账数据  
	 * @param: @param itmDTO
	 * @param: @param vist
	 * @param: @param picPate
	 * @param: @return
	 * @param: @throws BizException      
	 * @return: BlCgAccountDTO 
	 * @author: xy.zhou     
	 * @throws
	 */
	private BlCgAccountDTO AssembleBookkeepingData(NurseCompFeeItmDTO itmDTO,PatiVisitDO vist,String id_dep_mp,String id_dep_or)throws BizException{
		BlCgAccountDTO blAccountDTO=new BlCgAccountDTO();
		//就诊
		blAccountDTO.setId_ent(vist.getId_ent());
		//患者
		blAccountDTO.setId_pat(vist.getId_pat());
		//医嘱  null
		//blAccountDTO.setId_or("");
		//医嘱服务 null
		//blAccountDTO.setId_orsrv("");
		//服务
		blAccountDTO.setId_srv(itmDTO.getId_srv());
		//医嘱服务执行计划  null
		//blAccountDTO.setId_or_prsrv("");
		//物品
		blAccountDTO.setId_mm(itmDTO.getId_mm());
		//物品管理标识
		blAccountDTO.setFg_mm(itmDTO.getFg_mm());
		//服务单位 ?
		blAccountDTO.setId_unit_srv(itmDTO.getSrvu());
		//物品单位 ?
		blAccountDTO.setId_pkgu_cur(itmDTO.getSrvu());
		//数量
		blAccountDTO.setQuan(itmDTO.getQuan());
		//标准价格
		blAccountDTO.setPrice_std(itmDTO.getPrice());
		//折扣价
		blAccountDTO.setPrice_ratio(itmDTO.getPrice_ratio());
		//唯一码 
		blAccountDTO.setOnly_code(itmDTO.getOnlycode());
		//批次
		blAccountDTO.setBatch(itmDTO.getCd_batch());
		//执行科室
		blAccountDTO.setId_dep_mp(id_dep_mp);
		//记账方向
		blAccountDTO.setEu_direct(BookRtnDirectEnum.CHARGE);
		//开单科室
		blAccountDTO.setId_dep_or(id_dep_or);
		//开立医生
		blAccountDTO.setId_emp_or(itmDTO.getId_emp_or());
		return blAccountDTO;
	}
	/**
	 * 
	 * @Title: getBlCgAccountSetDTO   
	 * @Description: 组装记账数据  
	 * @param: @param id_emp
	 * @param: @param id_dep
	 * @param: @param dt_cg
	 * @param: @return
	 * @param: @throws BizException      
	 * @return: BlCgAccountSetDTO 
	 * @author: xy.zhou     
	 * @throws
	 */
	private BlCgAccountSetDTO getBlCgAccountSetDTO(String id_dep,FDateTime dt_cg)throws BizException{
		BlCgAccountSetDTO blCgDTO=new BlCgAccountSetDTO();
		//记账机构
		blCgDTO.setId_org_cg(Context.get().getOrgId());
		//记账人员
		blCgDTO.setId_emp_cg(Context.get().getStuffId());
		//记账科室 永远为当前科室
		blCgDTO.setId_dep_cg(Context.get().getDeptId());
		//记账时间
		blCgDTO.setDt_cg(dt_cg);
		//是否计算服务价格
		blCgDTO.setFg_price_cal(FBoolean.TRUE);
		//是否单患者模式
		blCgDTO.setFg_singlepat(FBoolean.TRUE);
		//是否支持后付费
		blCgDTO.setFg_postpaid(FBoolean.TRUE);
		//是否抛异常
		blCgDTO.setFg_exception(FBoolean.TRUE);
		//是否补费
		blCgDTO.setFg_addfee(FBoolean.TRUE);
		//记账来源
		blCgDTO.setSrcfunc_des(IBlCgFuncConst.FUNC_IPBL_NURSE_ADDREFUNDCOST);
		return blCgDTO;
	}

	/**
	 * 批量获取就诊信息
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	private PatiVisitDO [] getPatiVisitDO(String [] id_ent) throws BizException {
		IPativisitRService service = ServiceFinder.find(IPativisitRService.class);
        PatiVisitDO [] patiVisitDos = service.findByIds(id_ent,FBoolean.FALSE);
        return patiVisitDos;
	}
	
	/**
	 * 判断是否已经取消入科或退诊
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	private boolean IsCancle(String [] id_ent) throws BizException {
		StringBuilder sb = new StringBuilder();
		sb.append(" select count(entip.id_inpatient) from en_ent ent ");
		sb.append(" join en_ent_ip entip on entip.id_ent = ent.id_ent ");
		sb.append(" where ent.id_ent in ( ");
		boolean isDouHao = false;
		for(String idEnt : id_ent){
			if(isDouHao){
				sb.append(" , ");
			}
			isDouHao = true;
			sb.append("'").append(idEnt).append("'");
		}
		sb.append(") and (entip.sd_status = 22 or ent.fg_canc = 'Y') ");
		DAFacade daf = new DAFacade();
		daf.setAddTimeStamp(false);
		Integer num = (Integer) daf.execQuery(sb.toString(), new ColumnHandler());
		if(num != null && num > 0){
			return false;
		}
        return true;
	}
	/**
	 * 
	 * @Description: 组装补费返回值     
	 * @author: xy.zhou     
	 * @throws
	 */
	private BlNurSubsidyErrorReturnDTO [] returnValues(BlCgErrorDTO [] error_entlist,
			PatiVisitDO []patiVisitDOs)throws BizException{
		if (error_entlist!=null) {
			List<BlNurSubsidyErrorReturnDTO> bReturnDTOs=new ArrayList<>();
			for (int i = 0; i < error_entlist.length; i++) {
				for (int k = 0; k < patiVisitDOs.length; k++) {
					if (error_entlist[i].getId_ent().equals(patiVisitDOs[k].getId_ent())) {
						BlNurSubsidyErrorReturnDTO bErrorReturnDTO=new BlNurSubsidyErrorReturnDTO();
						bErrorReturnDTO.setId_ent(patiVisitDOs[k].getId_ent());
						bErrorReturnDTO.setPat_name(patiVisitDOs[k].getName_pat());
						bErrorReturnDTO.setEnt_code(patiVisitDOs[k].getCode());
						bErrorReturnDTO.setError(error_entlist[i].getError_msg());
						bReturnDTOs.add(bErrorReturnDTO);
						k=patiVisitDOs.length-1;
						continue;
					}
				}
			}
			return bReturnDTOs.toArray(new BlNurSubsidyErrorReturnDTO[]{});
		}
		return null;
	}
}
