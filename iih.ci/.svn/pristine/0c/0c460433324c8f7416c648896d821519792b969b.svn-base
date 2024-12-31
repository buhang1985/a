package iih.ci.ord.s.external.bp.bl.account;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import iih.bl.cg.dto.cglogic.d.BlCgAccountDTO;
import iih.bl.cg.dto.cglogic.d.BlCgAccountRltDTO;
import iih.bl.cg.dto.cglogic.d.BlCgOpAccountSetDTO;
import iih.bl.cg.dto.cglogic.d.OepCgModeEnum;
import iih.bl.cg.i.IBlCgAccountService;
import iih.bl.comm.IBlCgFuncConst;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.dto.prescostdto.d.PrescriptionConstBaseDto;
import iih.ci.ord.dto.prescostdto.d.PrescriptionCostDto;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.OrderRstDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 医嘱记账BP
 * @author HUMS
 *
 */
public class KeepAccountOrdersBP {
	
	private IBlCgAccountService bIBlCgAccountService;
	
	/**
	 * 	待记账数据
	 */
	private List<BlCgAccountDTO> accDtos = new ArrayList<>();
	
	/**
	 * 	记账配置
	 */
	private BlCgOpAccountSetDTO accSetDto = new BlCgOpAccountSetDTO();
	
	public KeepAccountOrdersBP(){
		bIBlCgAccountService = ServiceFinder.find(IBlCgAccountService.class);
	}

	public OrderRstDTO exec(CiEnContextDTO ctx, List<CiOrderDO> orderList) {
		
		OrderRstDTO orderRst = new OrderRstDTO();
		orderRst.setIsSuccess(FBoolean.TRUE);
		if(orderList.size() ==0){
			orderRst.setIsSuccess(FBoolean.FALSE);
			return orderRst;
		}
		List<String> idOrList = new ArrayList<String>();
		for(CiOrderDO order : orderList){
			idOrList.add(order.getId_or());
		}
		
		try {
			this.assembleData(ctx, orderList);
			BlCgAccountRltDTO blCgAccountRltDTO = bIBlCgAccountService.keepAccountForOp(accDtos.toArray(new BlCgAccountDTO[accDtos.size()]), accSetDto);
			if (!blCgAccountRltDTO.getFg_success().booleanValue()) {
				orderRst.setIsSuccess(FBoolean.FALSE);
				orderRst.setMessageInfo(blCgAccountRltDTO.getErr_msg());
			}
		} catch ( BizException e){
			orderRst.setIsSuccess(FBoolean.FALSE);
			orderRst.setMessageInfo(e.getMessage());
		}
		
		return orderRst;
	}
	
	/**
	 * 	组装接口传参对象
	 * 
	 * @param ctx
	 * @param orderList
	 * @throws BizException 
	 */
	private void assembleData(CiEnContextDTO ctx, List<CiOrderDO> orderList) throws BizException {
		//组装门诊记账配置对象
		accSetDto.setId_emp_cg(ctx.getId_psndoc());//记账人员
		accSetDto.setId_org_cg(ctx.getId_org());//记账机构
		accSetDto.setId_dep_cg(ctx.getId_dep_en());//记账科室
		accSetDto.setDt_cg(new FDateTime(new Date()));//记账时间
		accSetDto.setSrcfunc_des(IBlCgFuncConst.FUNC_OPOR_DOCTORSTATION);//记账来源
		accSetDto.setEu_oepcgmode(OepCgModeEnum.PREPAY_CG);//门诊记账模式
		accSetDto.setFg_reserve(FBoolean.TRUE);
		//获取记账状态编码集合
		List<String> sdSuBlList = new ArrayList<>();
		List<String> id_ors = new ArrayList<String>();
		for (CiOrderDO ciOrderDO : orderList) {
			id_ors.add(ciOrderDO.getId_or());
			if (!sdSuBlList.contains(ciOrderDO.getSd_su_bl())) {
				sdSuBlList.add(ciOrderDO.getSd_su_bl());
			}
		}
		
		//获得处方信息和处方费用相关信息
		PrescriptionConstBaseDto baseDTO = CiOrdAppUtils.getCiOrdQryService().getPrescriptionConstAccounting(ctx.getId_en(), sdSuBlList.toArray(new String[sdSuBlList.size()]));
		if(baseDTO == null) {
			return;
		}
		//组装记账数据对象
		FArrayList prescriptionCostDtos = baseDTO.getPrescriptionCostDto();
		if(prescriptionCostDtos == null || prescriptionCostDtos.size() <= 0) {
			return;
		}
		for (Object obj : prescriptionCostDtos) {
			PrescriptionCostDto dto = (PrescriptionCostDto) obj;
			String id_or = dto.getId_or();
			if(!id_ors.contains(id_or)){
				continue;
			}
			BlCgAccountDTO blCgAccountDTO = new BlCgAccountDTO();
			blCgAccountDTO.setId_ent(dto.getId_en());//就诊
			blCgAccountDTO.setId_pat(dto.getId_pat());//患者
			blCgAccountDTO.setId_or(dto.getId_or());//医嘱
			blCgAccountDTO.setId_orsrv(dto.getId_orsrv());//医嘱服务
			blCgAccountDTO.setId_srv(dto.getId_srv());//服务
			blCgAccountDTO.setId_mm(dto.getId_mm());//物品
			blCgAccountDTO.setFg_mm(dto.getFg_mm());//物品管理标识
			blCgAccountDTO.setId_unit_srv(dto.getId_unit_med());//服务单位
			blCgAccountDTO.setId_pkgu_cur(dto.getId_unit_cur());//物品单位
			if (dto.getSd_srvtp().startsWith("01")) {//药品
				blCgAccountDTO.setQuan(dto.getQuan_cur());//数量
			} else {//非药品
				blCgAccountDTO.setQuan(new FDouble(dto.getQuan_med()));//数量
			}
			blCgAccountDTO.setPrice_std(dto.getPri_std());//标准价
			blCgAccountDTO.setPrice_ratio(dto.getPri_ratio());//折扣价
			blCgAccountDTO.setEu_direct(1);//记账方向
			blCgAccountDTO.setId_dep_or(dto.getId_dep_srv());//开立科室
			blCgAccountDTO.setId_emp_or(dto.getId_emp_srv());//开立医生
			blCgAccountDTO.setId_dep_mp(dto.getId_dep_mp());//执行科室
			blCgAccountDTO.setId_dep_wh(dto.getId_dep_wh());//执行药房
			blCgAccountDTO.setFg_addfee(FBoolean.FALSE);//补费标识
			accDtos.add(blCgAccountDTO);
		}
	}
}
