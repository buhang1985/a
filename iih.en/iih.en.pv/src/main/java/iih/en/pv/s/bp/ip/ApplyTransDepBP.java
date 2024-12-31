package iih.en.pv.s.bp.ip;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.i.ICiOrdQryService;
import iih.en.comm.IEnMsgConst;
import iih.en.comm.ep.BedEP;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnContextUtils;
import iih.en.comm.util.EnFMapUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.deptrans.d.EnDepTransDO;
import iih.en.pv.deptrans.d.EnEuTrans;
import iih.en.pv.deptrans.i.IEndeptransCudService;
import iih.en.pv.deptrans.i.IEndeptransRService;
import iih.en.pv.dto.d.TransDepPatDTO;
import iih.en.pv.inpatient.d.InpatientDO;
import iih.en.pv.inpatient.d.TransDepCheckStatus;
import iih.en.pv.inpatient.dto.d.TransDept4EsDTO;
import iih.en.pv.s.event.IpTranOutDeptEvent;

import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 申请转科BP
 * @author renying
 *
 */
public class ApplyTransDepBP {
	/**
	 * 申请转科
	 * 
	 * @param patDTO 患者信息
	 * @throws BizException
	 */
	public void exec(TransDepPatDTO[] patDTO) throws BizException {
		//费用召回患者不允许转科
		this.validateRecall(patDTO);
		//转科前再校验一次医嘱，医技，药品，执行核查状态
		this.checkStatus(patDTO);
		ICiOrdQryService iCiorderRService = ServiceFinder.find(ICiOrdQryService.class);
		for (int i = 0; i < patDTO.length; i++) {
			//校验医嘱状态
			this.validateOrderSu(patDTO[i]);
			//校验目标科室是否有空床，没有空床不允许转出
			validateBedData(patDTO[i].getId_dep_nur(),null);
			if(EnValidator.isEmpty(patDTO[i].getId_ortrans())){
				this.transApply(patDTO[i]);
			}else{
				boolean fg = iCiorderRService.TransferStatusUpdates(patDTO[i].getId_ortrans(), IEnDictCodeConst.SD_SU_APPLY);
				if (fg != true) {
					throw new BizException(IEnMsgConst.ERROR_TRANS_FAILED);// "转科失败"
				}else {
					this.transApply(patDTO[i]);
				}
			}
			this.invokeIpTransOutDeptEvent(patDTO[i]);
		}
	}
	
    /**
     * 转科并保存就诊转科记录
     * 
     * @param transDTO
     * @throws BizException 
     */
    private void transApply(TransDepPatDTO transDTO) throws BizException {

        EnDepTransDO saveDo = this.setEnDepTransDO(transDTO);
        this.saveEnDepTransDO(saveDo);
    }
    
    /**
     * 保存就诊转科记录
     * @throws BizException 
     */
    private void saveEnDepTransDO(EnDepTransDO saveDo) throws BizException {
        IEndeptransRService RService  = ServiceFinder.find(IEndeptransRService.class);
  	    String whereStr = "id_ent = '" +saveDo.getId_ent()+"' AND Eu_trans ='"+EnEuTrans.APPLY +"' AND Id_or = '" +saveDo.getId_or()+"'";
  	    EnDepTransDO[] res = RService.find(whereStr, "", FBoolean.FALSE);
  	    if(!EnValidator.isEmpty(res))
  	    	throw new BizException("申请状态发生改变，请刷新界面！");
        IEndeptransCudService  cudService = ServiceFinder.find(IEndeptransCudService.class);
        cudService.save(new EnDepTransDO[] {saveDo});
    }
    
    /**
     * 设置EnDepTransDO值
     * @param transDTO
     * @return
     */
    private EnDepTransDO setEnDepTransDO(TransDepPatDTO transDTO) {
        //创建一个新的对象
        EnDepTransDO newDo = new EnDepTransDO();
        //就诊id
        newDo.setId_ent(transDTO.getId_ent());
        //目标科室
        newDo.setId_dep_to(transDTO.getId_dep_phy());
        //目标病区
        newDo.setId_dep_nur_to(transDTO.getId_dep_nur());
        //原科室
        newDo.setId_dep_from(transDTO.getOld_dep_phy());
        //原病区
        newDo.setId_dep_nur_from(transDTO.getOld_dep_nur());
        //原床位
        newDo.setId_bed_from(transDTO.getId_bed());
        //转科过程状态
        newDo.setEu_trans(EnEuTrans.APPLY);
        //医嘱id
        newDo.setId_or(transDTO.getId_or());
        newDo.setDt_apply(new FDateTime());
        newDo.setId_emp_appl(EnContextUtils.getPsnId());
        newDo.setStatus(DOStatus.NEW);
        return newDo;
    }
    /**
     * 费用召回患者不允许转科
     * 
     * @param patDTO
     * @throws BizException
     */
    private void validateRecall(TransDepPatDTO[] patDTO) throws BizException{
    	if(EnValidator.isEmpty(patDTO))
    		return;
    	String[] entIds = EnAppUtils.getKeyPropArrayFromDO("Id_ent", patDTO);
    	Map<String, TransDepPatDTO> map = EnFMapUtils.getMap("Id_ent", patDTO);
    	@SuppressWarnings("unchecked")
		List<InpatientDO> list = (List<InpatientDO>) new DAFacade().findByAttrValStrings(InpatientDO.class, InpatientDO.ID_ENT, entIds, new String[]{InpatientDO.ID_ENT, InpatientDO.FG_BLRECALL});
    	if(EnValidator.isEmpty(list))
    		return;
    	for(InpatientDO ip : list){
    		if(FBoolean.TRUE.equals(ip.getFg_blrecall())){
    			throw new BizException(String.format("患者[%s]是费用召回患者，不允许转科！", map.get(ip.getId_ent()).getName_pat()));
    		}
    	}
    }
	
	/**
	 * 触发事件
	 * 
	 * @param transDepPat
	 * @throws BizException
	 */
	private void invokeIpTransOutDeptEvent(TransDepPatDTO transDepPat) throws BizException {
		// 1、构造事件源
		TransDept4EsDTO esDTO = new TransDept4EsDTO();
		esDTO.setId_ent(transDepPat.getId_ent());
		esDTO.setId_pat(transDepPat.getId_pat());
		esDTO.setName_pat(transDepPat.getName_pat());
		esDTO.setId_dep_nur(transDepPat.getId_dep_nur());
		esDTO.setId_dep_opr(transDepPat.getId_dep_phy());
		esDTO.setOld_dep_nur_name(transDepPat.getOld_dep_nur_name());
		esDTO.setOld_dep_phy_name(transDepPat.getOld_dep_phy_name());
		// 2、触发事件
		IpTranOutDeptEvent enterDeptEvent = new IpTranOutDeptEvent();
		enterDeptEvent.invoke(esDTO);
	} 
	
	/**
	 * 校验目标科室是否有空床，没有空床不允许转出
	 * 
	 * @param id_dep_nur
	 * @param sdPatSex
	 * @throws BizException
	 */
	private void validateBedData(String id_dep_nur,String sdPatSex) throws BizException {
		BedEP bedBP = new BedEP();
		bedBP.getBedbyDep(id_dep_nur, sdPatSex,false);
	}
	/**
	 * 转出前校验医嘱状态
	 * 
	 * @param transDepPat
	 * @throws BizException
	 */
	private void validateOrderSu(TransDepPatDTO transDepPat) throws BizException {
		if(transDepPat == null ||EnValidator.isEmpty(transDepPat.getId_or()))
			return;
		CiOrderDO ciOrder = (CiOrderDO) new DAFacade().findByPK(CiOrderDO.class, transDepPat.getId_or());
		if (ciOrder == null
				|| !(ICiDictCodeConst.SD_SU_CHECKTHROUGH.equals(ciOrder
						.getSd_su_or()) || ICiDictCodeConst.SD_SU_CHECKSTOP
						.equals(ciOrder.getSd_su_or()))) {
			throw new BizException(String.format("患者[%s]转科医嘱状态发生改变，请刷新后重试！", transDepPat.getName_pat()));
		}
	}
	/**
	 * 转科前再校验一次医嘱，医技，药品，执行核查状态
	 * 
	 * @param transDepPat
	 * @throws BizException
	 */
	private void checkStatus(TransDepPatDTO[] transDepPats) throws BizException {
		if(EnValidator.isEmpty(transDepPats))
			return;
		OutDepCheckBP check = new OutDepCheckBP();
		check.exec(transDepPats);
		for(TransDepPatDTO tranDto : transDepPats){
			if(TransDepCheckStatus.Error.equals(tranDto.getStatus_or()))
				throw new BizException(String.format("患者[%s]医嘱核查未通过，不允许转科！", tranDto.getName_pat()));
			if(TransDepCheckStatus.Error.equals(tranDto.getStatus_med()))
				throw new BizException(String.format("患者[%s]药品核查未通过，不允许转科！", tranDto.getName_pat()));
			if(TransDepCheckStatus.Error.equals(tranDto.getStatus_mp()))
				throw new BizException(String.format("患者[%s]执行核查未通过，不允许转科！", tranDto.getName_pat()));
			if(TransDepCheckStatus.Error.equals(tranDto.getStatus_tech()))
				throw new BizException(String.format("患者[%s]医技核查未通过，不允许转科！", tranDto.getName_pat()));
		}
	}

}
