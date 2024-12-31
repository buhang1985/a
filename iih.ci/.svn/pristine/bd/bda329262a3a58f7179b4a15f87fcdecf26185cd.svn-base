package iih.ci.ord.s.external.blood.ruimei.s.bp;

import java.util.ArrayList;
import java.util.List;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.mm.meterial.i.IMeterialMDORService;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import iih.bl.cg.dto.addfee.d.BlCgAddFeeQryCondDTO;
import iih.bl.cg.dto.addfee.d.BlCgAddFeeQryDTO;
import iih.bl.cg.dto.cglogic.d.BlCgAccountDTO;
import iih.bl.cg.dto.cglogic.d.BlCgAccountRltDTO;
import iih.bl.cg.dto.cglogic.d.BlCgAccountSetDTO;
import iih.bl.cg.dto.cglogic.d.BlCgRefundAccountDTO;
import iih.bl.cg.dto.cglogic.d.BlCgRefundAccountSetDTO;
import iih.bl.cg.dto.cglogic.d.RefundModeEnum;
import iih.bl.cg.i.IBlCgAccountService;
import iih.bl.cg.i.IBlOutQryService;
import iih.bl.comm.IBlCgFuncConst;
import iih.bl.comm.IBlConst;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrSourceFromEnum;
import iih.ci.ord.ciorder.i.ICiorderMDOCudService;
import iih.ci.ord.ciorder.i.ICiorderMDORService;
import iih.ci.ord.external.blood.wqxk.d.ChargeItem;
import iih.ci.ord.external.blood.wqxk.d.WQUbOrEnParamDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.bdfw.bbd.i.IPsndocMDORService;
import xap.sys.orgfw.dept.d.DeptDO;
import xap.sys.orgfw.dept.i.IDeptRService;
import xap.sys.xbd.measdoc.d.MeasDocDO;
import xap.sys.xbd.measdoc.i.IMeasdocRService;

public class AddFeeBP {

	
	/**
	 * 用血医嘱补费
	 * @param aggDO
	 * @return
	 * @throws BizException 
	 */
	public BlCgAccountRltDTO keepAcount4IP(WQUbOrEnParamDTO param,CiOrderDO ord) throws BizException {
//		ChargeItem[] items=(ChargeItem[]) param.getChargeitem().toArray();
		List<BlCgAccountDTO> blcglist=new ArrayList<>();
        for (Object o : param.getChargeitem()) {
        	ChargeItem item=(ChargeItem)o;
        	if(item.getChargecode()==null||item.getChargecode().trim().length()==0)
        		continue;
        	IMedsrvMDORService medService = ServiceFinder.find(IMedsrvMDORService.class);
            MedSrvDO[] medSrvDO=null;
    		medSrvDO = medService.find(" code='"+item.getChargecode()+"'", "", FBoolean.FALSE);
    		if(medSrvDO==null||medSrvDO.length!=1)
    			throw new BizException(" 编码为："+item.getChargecode()+" 的服务不存在，或对应多个服务");
        	BlCgAccountDTO dto=new BlCgAccountDTO();
        	dto.setId_srv(medSrvDO[0].getId_srv());
			dto.setId_or(ord.getId_or());
			dto.setEu_direct(IBlConst.BL_CHARGES);
			dto.setId_dep_mp(ord.getId_dep_mp());
//			dto.setId_orsrv(ordsrv.getId_orsrv());
//			dto.setFg_mm(ordsrv.getFg_mm());
			dto.setId_ent(ord.getId_en());
			dto.setId_dep_or(ord.getId_dep_or());
			dto.setId_pat(ord.getId_pat());
			dto.setQuan(new FDouble(item.getQuan()));
			dto.setFg_addfee(FBoolean.TRUE);
			dto.setPrice_ratio(new FDouble(item.getPrice()));
			dto.setPrice_std(new FDouble(item.getPrice()));
			dto.setRatio_pripat(new FDouble("1"));
			dto.setDt_cg_detail(BloodManageUtils.getServerDateTime());
			dto.setId_unit_srv(medSrvDO[0].getId_unit_med());
			if(item.getMmcode()!=null&&item.getMmcode().trim().length()>0) {
			  IMeterialMDORService service = ServiceFinder.find(IMeterialMDORService.class);
			  MeterialDO[] mms=service.find(" code='"+item.getMmcode()+"'", "", FBoolean.FALSE);
			  if(mms!=null&&mms.length==1) {
				  dto.setId_mm(mms[0].getId_mm());
				  dto.setFg_mm(FBoolean.TRUE);
				  if(item.getStorecode()!=null&&item.getStorecode().trim().length()>0) {
				  DeptDO[] depts = ServiceFinder.find(IDeptRService.class).find(" code='"+item.getStorecode()+"'","",FBoolean.FALSE);
				  if(depts!=null&&depts.length>0) {
					  dto.setId_dep_wh(depts[0].getId_dep());
				  }
				  }
			  }else {
				  throw new BizException(" 编码为："+item.getChargecode()+" 的物品不存在，或对应多个物品");
			  }
			}
			IMeasdocRService ser = ServiceFinder.find(IMeasdocRService.class);
			MeasDocDO[] meas = ser.find(" code='"+item.getUnitcode()+"'", "", FBoolean.FALSE);
			if(meas!=null&&meas.length>0) {
				dto.setId_pkgu_cur(meas[0].getId_measdoc());
			}
			
			blcglist.add(dto);
		}
        
        BlCgAccountSetDTO accSetDto=new BlCgAccountSetDTO();
        accSetDto.setFg_addfee(FBoolean.TRUE);
        accSetDto.setSrcfunc_des(IBlCgFuncConst.FUNC_IPMP_TRANSFUSION);
        PsnDocDO[]  psns=ServiceFinder.find(IPsndocMDORService.class).find(" code='"+param.getOperacg()+"'", "", FBoolean.FALSE);
        if(psns!=null&&psns.length>0)
        	accSetDto.setId_emp_cg(psns[0].getId_psndoc());
       return ServiceFinder.find(IBlCgAccountService.class).keepAccountForIp(blcglist.toArray(new BlCgAccountDTO[0]), accSetDto);
	}
	
	public BlCgAddFeeQryDTO[] queryfee(CiOrderDO ord) throws BizException {
		BlCgAddFeeQryCondDTO cond=new BlCgAddFeeQryCondDTO();
		cond.setId_ent(ord.getId_en());
		cond.setId_or(ord.getId_or());
		cond.setFg_relateor(FBoolean.TRUE);
		BlCgAddFeeQryDTO[] rnts=ServiceFinder.find(IBlOutQryService.class).qryIpAddFee(cond);
		return rnts;
	}
	public BlCgAccountRltDTO refundfee(WQUbOrEnParamDTO param,CiOrderDO ord) throws BizException {
	
		BlCgAddFeeQryDTO[] qrydtos=queryfee(ord);
		BlCgAccountRltDTO rnt=refundAccount(qrydtos,ord,param);
		return rnt;
	}
	/**
	 * 退费接口
	 * @param qrydto
	 * @param ord
	 * @throws BizException 
	 */
	public BlCgAccountRltDTO refundAccount(BlCgAddFeeQryDTO[] qrydto,CiOrderDO ord,WQUbOrEnParamDTO param) throws BizException {
		List<BlCgRefundAccountDTO> blcglist=new ArrayList<>();
		for (BlCgAddFeeQryDTO dto : qrydto) {
			BlCgRefundAccountDTO reacc=new BlCgRefundAccountDTO();
			reacc.setId_cg(dto.getId_cg());
			reacc.setId_ent(ord.getId_en());
			if(dto.getEu_direct()!=IBlConst.BL_CHARGES) {
				continue;
			}
			reacc.setId_pat(ord.getId_pat());
			reacc.setQuan(dto.getQuan());
			blcglist.add(reacc);
			
		}
		
		BlCgRefundAccountSetDTO setdto=new BlCgRefundAccountSetDTO();
		setdto.setEu_rfdmode(RefundModeEnum.CG_KEY);
		setdto.setSrcfunc_des(IBlCgFuncConst.FUNC_IPMP_TRANSFUSION);
		 PsnDocDO[]  psns=ServiceFinder.find(IPsndocMDORService.class).find(" code='"+param.getOperacg()+"'", "", FBoolean.FALSE);
	        if(psns!=null&&psns.length>0)
	        	setdto.setId_emp_cg(psns[0].getId_psndoc());	        
	   return     ServiceFinder.find(IBlCgAccountService.class).refundAccountForIp(blcglist.toArray(new BlCgRefundAccountDTO[0]), setdto);
	}
	
	public void updateOrdStatus(CiOrderDO ord) throws BizException {
		ord.setSd_su_or(ICiDictCodeConst.SD_SU_FINISH);
		ord.setId_su_or(ICiDictCodeConst.SD_SU_ID_FINISH);
		ord.setSd_su_bl(ICiDictCodeConst.SD_SU_BL_ACCOUNT);
		ord.setId_su_bl(ICiDictCodeConst.SD_SU_BL_ACCOUNT_ID);
		ord.setSd_su_mp(ICiDictCodeConst.SD_SU_MP_EXEOK);
		ord.setId_su_mp(ICiDictCodeConst.SD_SU_MP_EXEOK_ID);
		ord.setFg_chk(FBoolean.TRUE);
		ord.setDt_chk(BloodManageUtils.getServerDateTime());
		ord.setId_emp_chk(Context.get().getStuffId());
		ord.setId_dep_chk(Context.get().getDeptId());
		ord.setStatus(DOStatus.UPDATED);
		ServiceFinder.find(ICiorderMDOCudService.class).save(new CiOrderDO[] {ord});
	}
	public void updateOrdRefundStatus(CiOrderDO ord) throws BizException {
		ord.setSd_su_or(ICiDictCodeConst.SD_SU_CANCEL);
		ord.setId_su_or(ICiDictCodeConst.SD_SU_ID_CANCEL);
		ord.setSd_su_bl(ICiDictCodeConst.SD_SU_BL_REFOUND);
		ord.setId_su_bl(ICiDictCodeConst.SD_SU_BL_REFOUND_ID);
		ord.setSd_su_mp(ICiDictCodeConst.SD_SU_MP_NONE);
		ord.setId_su_mp(ICiDictCodeConst.SD_SU_MP_NONE_ID);
		ord.setFg_canc(FBoolean.TRUE);
		ord.setFg_chk_canc(FBoolean.TRUE);
		ord.setDt_canc(BloodManageUtils.getServerDateTime());
		ord.setDt_chk_canc(BloodManageUtils.getServerDateTime());
		ord.setId_emp_chk_canc(Context.get().getStuffId());
		ord.setId_dep_chk_canc(Context.get().getDeptId());
		ord.setStatus(DOStatus.UPDATED);
		ServiceFinder.find(ICiorderMDOCudService.class).save(new CiOrderDO[] {ord});
	}
	
	public CiOrderDO getCiOrd(WQUbOrEnParamDTO param) throws BizException {
		CiOrderDO[] ords=ServiceFinder.find(ICiorderMDORService.class).find(" applyno='"+param.getApplyno()+"' and fg_canc='N' and eu_orsrcmdtp='"+OrSourceFromEnum.THIRDPARTYSYS+"'", "", FBoolean.FALSE);
		if(ords==null||ords.length==0)
			throw new BizException("未查询到有效医嘱!");
		if(ords.length>1)
			throw new BizException("该申请单号对应多条医嘱");
		return ords[0];
	}

}
