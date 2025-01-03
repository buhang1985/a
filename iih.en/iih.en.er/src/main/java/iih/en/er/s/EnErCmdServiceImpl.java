package iih.en.er.s;

import iih.en.er.bp.baspat.SaveEnErBasic4PatBP;
import iih.en.er.bp.enprquery.CancelPreExamBP;
import iih.en.er.bp.inouttransmgr.IInOutTransMgr;
import iih.en.er.bp.inouttransmgr.InOutTransMgrFactory;
import iih.en.er.bp.pre.SaveErPreBP;
import iih.en.er.bp.qry.CheckValidPatBP;
import iih.en.er.bp.register.ChangePatHandleBP;
import iih.en.er.bp.register.HandleErRegistBP;
import iih.en.er.bp.registercanc.HandleErCancRegistBP;
import iih.en.er.bp.rescue.RescueChangeBedBP;
import iih.en.er.bp.rescue.UpdateRescuePrintTimesBP;
import iih.en.er.bp.stay.CancelObsPerBP;
import iih.en.er.bp.stay.SaveObsPerBP;
import iih.en.er.bp.stayout.SaveUrgStayOutBP;
import iih.en.er.bp.stayregist.CancUrgStayRegistBP;
import iih.en.er.bp.stayregist.SaveUrgStayRegistBP;
import iih.en.er.dto.d.EnErBasic4EditDTO;
import iih.en.er.dto.d.EnErPrQueryDTO;
import iih.en.er.dto.d.EnErPreInfoDTO;
import iih.en.er.dto.d.EnErPreTriageDTO;
import iih.en.er.dto.d.EnObsPermitDTO;
import iih.en.er.dto.d.UrgInOutTransMgrDTO;
import iih.en.er.dto.d.UrgStayOutDTO;
import iih.en.er.dto.d.UrgStayRegistryDTO;
import iih.en.er.i.IEnErCmdService;
import iih.en.pv.inpatient.dto.d.BedBigCardDTO;
import iih.en.pv.outpatient.dto.d.OpRegPatDTO;
import iih.en.pv.outpatient.dto.d.RegInfoDTO;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;

/**
 * 急诊操作服务
 * 
 * @author liubin
 *
 */
@Service(serviceInterfaces={IEnErCmdService.class}, binding = Binding.JSONRPC)
public class EnErCmdServiceImpl implements IEnErCmdService{
	/**
	 * 保存急诊预检
	 * 
	 * @param erPreTriage
	 * @return
	 * @throws BizException
	 */
	@Override
	public EnErPreTriageDTO saveErPre(EnErPreTriageDTO erPreTriage)
			throws BizException {
		SaveErPreBP bp = new SaveErPreBP();
		return bp.exec(erPreTriage);
	}
	/**
	 * 急诊换患者处理
	 * 
	 * @param opRegPatDto
	 * @throws BizException
	 */
	@Override
	public void changePatHandle(OpRegPatDTO opRegPatDto) throws BizException {
		ChangePatHandleBP bp = new ChangePatHandleBP();
		bp.exec(opRegPatDto);
	}
	
	/**
	 * 急诊挂号处理
	 * 
	 * @param regInfo
	 * @throws BizException
	 */
	@Override
	public void handleErRegist(RegInfoDTO regInfo) throws BizException {
		HandleErRegistBP bp = new HandleErRegistBP();
		bp.exec(regInfo);
	}
	/**
	 * 急诊退号处理
	 * 
	 * @param entId
	 * @throws BizException
	 */
	@Override
	public void handleErCancRegist(String entId) throws BizException {
		HandleErCancRegistBP bp = new HandleErCancRegistBP();
		bp.exec(entId);
	}
	/**
	 * * 保存急诊留观许可
	 * 
	 * @param obspermit
	 * @return
	 * @throws BizException
	 */
	@Override
	public EnObsPermitDTO saveObsPer(EnObsPermitDTO obspermit) throws BizException {
		SaveObsPerBP bp = new SaveObsPerBP();
		return bp.exec(obspermit);
	}
	/**
	 * 取消急诊留观许可
	 * 
	 */
	@Override
	public void cancelObsPer(EnObsPermitDTO obspermit) throws BizException {
		CancelObsPerBP bp = new CancelObsPerBP();
		bp.exec(obspermit);
	}
	/**
	 * * 保存急诊留观登记
	 * 
	 * @param urgstayregistry
	 * @return
	 * @throws BizException
	 */
	@Override
	public UrgStayRegistryDTO saveUrgStayRegist(UrgStayRegistryDTO urgstayregistry) throws BizException {
		SaveUrgStayRegistBP bp = new SaveUrgStayRegistBP();
		return bp.exec(urgstayregistry);
	}
	/**
	 * * 取消急诊留观登记
	 * 
	 * @param urgstayregistry
	 * @return
	 * @throws BizException
	 */
	@Override
	public void cancelUrgStayReg(UrgStayRegistryDTO urgstayregistry) throws BizException {
		CancUrgStayRegistBP bp = new CancUrgStayRegistBP();
		 bp.exec(urgstayregistry);
	}
	/**
	 * 急诊入出转操作
	 * 
	 * @param data
	 * @param euUrgInOutTransMgrType
	 * @return
	 * @throws BizException
	 */
	@Override
	public UrgInOutTransMgrDTO urgInOutTransMgr(UrgInOutTransMgrDTO data, String euUrgInOutTransMgrType) throws BizException {
		IInOutTransMgr mgr = new InOutTransMgrFactory().get(euUrgInOutTransMgrType);
		return mgr.exec(data);
	}
	
	/**
     * 抢救-计算并更新腕带打印次数
     * 
     * @param idEnt
	 * @throws BizException 
     */
	@Override
	public void updateRescuePrintTimes(String idEnt) throws BizException {
		UpdateRescuePrintTimesBP bp = new UpdateRescuePrintTimesBP();
		bp.exec(idEnt);
	}

	/**
	 *  保存出留观许可
	 * 
	 * @param urgstayout
	 * @return
	 * @throws BizException
	 */
	@Override
	public UrgStayOutDTO saveUrgStayOut(UrgStayOutDTO urgstayout) throws BizException {
		SaveUrgStayOutBP bp = new SaveUrgStayOutBP();
		return bp.exec(urgstayout);
	}
	/***
	 * 抢救换床
	 * @param mainStateDTO
	 * @throws BizException
	 */
	@Override
	public void rescueChangeBed(BedBigCardDTO source,BedBigCardDTO target) throws BizException{
		RescueChangeBedBP chgBedBP = new RescueChangeBedBP();
		chgBedBP.exec(source, target);
	}
	/***
	 * 预检查询取消预检
	 * @param dtos
	 * @throws BizException
	 */
	@Override
	public void cancelPreExam(EnErPrQueryDTO[] dtos) throws BizException {
		CancelPreExamBP bp = new CancelPreExamBP();
		bp.exec(dtos);
	}
	/**
	 * 更新急诊患者基本信息
	 * @param enErBasic4EditDTO
	 * @throws BizException 
	 * @auther yaohl
	 * @date 2018年12月28日
	 */
	@Override
	public EnErBasic4EditDTO saveEnErBasic4Edit(EnErBasic4EditDTO enErBasic4EditDTO) throws BizException {
		SaveEnErBasic4PatBP bp = new SaveEnErBasic4PatBP();
		return bp.exec(enErBasic4EditDTO);
	}
	/***
	 *急诊抢救医生站患者接诊校验控制
	 * @param id_ent
	 * @throws BizException
	 */
	@Override
	public void urgDocStationRecivePat(EnErPreInfoDTO dto) throws BizException {
		CheckValidPatBP bp = new CheckValidPatBP();
		bp.exec(dto);
	}
}
