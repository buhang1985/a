package iih.en.pv.s.bp.ip;

import java.util.ArrayList;

import com.mysql.jdbc.StringUtils;

import iih.bd.bc.udi.pub.IBdResDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.ci.mr.ciamr.d.AMrDO;
import iih.en.comm.ep.BedEP;
import iih.en.comm.ep.EntBedEP;
import iih.en.comm.ep.IpEP;
import iih.en.comm.evt.EnEvtHandle;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnContextUtils;
import iih.en.comm.util.EnLogUtil;
import iih.en.comm.util.EnParamUtils;
import iih.en.pv.inpatient.d.InpatientDO;
import iih.en.pv.inpatient.d.NewbornDO;
import iih.en.pv.inpatient.dto.d.BedBigCardDTO;
import iih.en.pv.inpatient.dto.d.ChgBed4EsDTO;
import iih.en.pv.s.event.IpChgBedEvent;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.appfw.businessevent.IEventType;
/***
 * 母婴分离的新生儿的换床处理
 * @author fanlq
 *
 */
public class ChangeBed4BbBP {

	private boolean isUseOneBed;
	public void exec(NewbornDO newBorn,BedBigCardDTO source, BedBigCardDTO target) throws BizException{
		ArrayList<String> sourceEntIdList = new ArrayList<String>();
		ArrayList<String> targetEntIdList = new ArrayList<String>();
		// 1.取得就诊id的list,源就诊id一定是新生儿单个，不存在别的情况
		this.getEntList(source, target, sourceEntIdList,targetEntIdList);
		// 2.获取新生儿与母亲是否使用同一张床位
		this.isUseOneBed(newBorn, source, target);
		// 3.更新en_ent_ip的数据
		this.updateInpatientDO(source, target,sourceEntIdList,targetEntIdList);
		// 4.更改bdbed的数据
		this.updateBdBed(source, target);
		// 5.更新en_ent_bed
		FDateTime currentTime = this.updateEntBed(source, target);
		// 6.更新病历表
		this.updateAmrBP(source, target, sourceEntIdList, targetEntIdList);
		// 7. 添加换床分配床位就诊事件
		new EnEvtHandle().insertChangeBedEvt(source, target, sourceEntIdList, targetEntIdList);
		// 8.触发事件
		if(!StringUtil.isEmptyWithTrim(source.getId_ent())){
			this.invokeEventForSouceBed(source, target, currentTime);
		}
		if(!StringUtil.isEmptyWithTrim(target.getId_ent())){
			this.invokeEventForTatgetBed(source, target, currentTime);
		}	
	}
	/**
	 * 查找就诊新生儿id
	 * 得到就诊id（加新生儿的）
	 * @param source
	 * @param target
	 * @param sourceEntIdList
	 * @param targetEntIdList
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private void getEntList(BedBigCardDTO source, BedBigCardDTO target, ArrayList<String> sourceEntIdList,ArrayList<String> targetEntIdList) throws BizException {
		if (!StringUtil.isEmpty(source.getId_ent())) {
			sourceEntIdList.add(source.getId_ent());
		}
		if (!StringUtil.isEmpty(target.getId_ent())) {
			targetEntIdList.add(target.getId_ent());
		}
	}
	/**
	 * 更新bd床位信息
	 * @param source
	 * @param target
	 * @throws BizException
	 */
	public void updateBdBed(BedBigCardDTO originalBedDO, BedBigCardDTO targetBedDO) throws BizException {
		BedEP bedBP = new BedEP();
		//区分床位性别
		if (IEnDictCodeConst.BED_HAS_SEX.equals(EnParamUtils.getBedSexParam(originalBedDO.getId_dep_nur()))) {
			//与母亲共床新生儿不需要释放源床位,否则需要释放床位
			if(!isUseOneBed){
				bedBP.releaseBedWithSex(originalBedDO.getId_ent(), originalBedDO.getId_bed(), FBoolean.FALSE);
				bedBP.releaseBedWithSex(targetBedDO.getId_ent(), targetBedDO.getId_bed(), FBoolean.FALSE);
			}
			// 如果原床位有人，则占用目标床位
			if (!StringUtil.isEmpty(originalBedDO.getId_ent())) {
				if(originalBedDO.getSd_bedsu().equals(IBdResDictCodeConst.SD_BEDSU_OCCUPYBYIN)){
					EnLogUtil.getInstance().logError("区分床位性别，换床占用目标床位前----原床位原状态为：" + originalBedDO.getSd_bedsu() + "，床号：" + originalBedDO.getName_bed() + "，病区id:" + originalBedDO.getId_dep_nur());
					EnLogUtil.getInstance().logError("----即将占用目标床位----");
					bedBP.occupyBedWithSex(targetBedDO.getId_bed(), null, originalBedDO.getCode_sex(), FBoolean.FALSE, 
							IBdResDictCodeConst.SD_BEDSU_OCCUPYBYIN, IBdResDictCodeConst.ID_BEDSU_OCCUPYBYIN);
				}else{
					EnLogUtil.getInstance().logError("区分床位性别，换床使用目标床位前----原床位原状态为：" + originalBedDO.getSd_bedsu() + "，床号：" + originalBedDO.getName_bed() + "，病区id:" + originalBedDO.getId_dep_nur());
					EnLogUtil.getInstance().logError("----即将使用目标床位----");
					bedBP.occupyBedWithSex(targetBedDO.getId_bed(), null, originalBedDO.getCode_sex(), FBoolean.FALSE, 
							IBdResDictCodeConst.SD_BEDSU_USEDBYPATIENT, IBdResDictCodeConst.ID_BEDSU_USEDBYPATIENT);
				}
			}else {
				EnLogUtil.getInstance().logError("区分床位性别----原床位id_ent为空，床号：" + originalBedDO.getName_bed() + "，病区id:" + originalBedDO.getId_dep_nur() + "，床位状态：" + originalBedDO.getSd_bedsu());
			}
			// 如果目标床位有人，则其占用原来床位
			if (!StringUtil.isEmpty(targetBedDO.getId_ent())) {
				if(targetBedDO.getSd_bedsu().equals(IBdResDictCodeConst.SD_BEDSU_OCCUPYBYIN)){
					EnLogUtil.getInstance().logError("区分床位性别，换床占用原床位前----目标床位原状态为：" + originalBedDO.getSd_bedsu() + "，床号：" + originalBedDO.getName_bed() + "，病区id:" + originalBedDO.getId_dep_nur());
					EnLogUtil.getInstance().logError("----即将占用原床位----");
					bedBP.occupyBedWithSex(originalBedDO.getId_bed(), null, targetBedDO.getCode_sex(), FBoolean.FALSE, 
							IBdResDictCodeConst.SD_BEDSU_OCCUPYBYIN, IBdResDictCodeConst.ID_BEDSU_OCCUPYBYIN);
				}else{
					EnLogUtil.getInstance().logError("区分床位性别，换床使用原床位前----目标床位原状态为：" + originalBedDO.getSd_bedsu() + "，床号：" + originalBedDO.getName_bed() + "，病区id:" + originalBedDO.getId_dep_nur());
					EnLogUtil.getInstance().logError("----即将使用原床位----");
					bedBP.occupyBedWithSex(originalBedDO.getId_bed(), null, targetBedDO.getCode_sex(), FBoolean.FALSE, 
							IBdResDictCodeConst.SD_BEDSU_USEDBYPATIENT, IBdResDictCodeConst.ID_BEDSU_USEDBYPATIENT);
				}
			}else {
				EnLogUtil.getInstance().logError("区分床位性别----目标床位id_ent为空，床号：" + targetBedDO.getName_bed() + "，病区id:" + targetBedDO.getId_dep_nur() + "，床位状态：" + targetBedDO.getSd_bedsu());
			}
			return;
		}
		//与母亲共床新生儿不需要释放源床位,否则需要释放床位
		if(!isUseOneBed){
			//不区分床位性别
			bedBP.releaseBed(originalBedDO.getId_ent(), originalBedDO.getId_bed());
			bedBP.releaseBed(targetBedDO.getId_ent(), targetBedDO.getId_bed());
		}
		// 如果原床位有人，则占用目标床位
		if (!StringUtil.isEmpty(originalBedDO.getId_ent())) {
			if(originalBedDO.getSd_bedsu().equals(IBdResDictCodeConst.SD_BEDSU_OCCUPYBYIN)){
				EnLogUtil.getInstance().logError("换床占用目标床位前----原床位原状态为：" + originalBedDO.getSd_bedsu() + "，床号：" + originalBedDO.getName_bed() + "，病区id:" + originalBedDO.getId_dep_nur());
				EnLogUtil.getInstance().logError("----即将占用目标床位----");
				bedBP.occupyBed2(targetBedDO.getId_bed());
			}else{
				EnLogUtil.getInstance().logError("换床使用目标床位前----原床位原状态为：" + originalBedDO.getSd_bedsu() + "，床号：" + originalBedDO.getName_bed() + "，病区id:" + originalBedDO.getId_dep_nur());
				EnLogUtil.getInstance().logError("----即将使用目标床位----");
				bedBP.useBed2(targetBedDO.getId_bed());
			}
		}else {
			EnLogUtil.getInstance().logError("----原床位id_ent为空，床号：" + originalBedDO.getName_bed() + "，病区id:" + originalBedDO.getId_dep_nur() + "，床位状态：" + originalBedDO.getSd_bedsu());
		}
		// 如果目标床位有人，则其占用原来床位
		if (!StringUtil.isEmpty(targetBedDO.getId_ent())) {
			if(targetBedDO.getSd_bedsu().equals(IBdResDictCodeConst.SD_BEDSU_OCCUPYBYIN)){
				EnLogUtil.getInstance().logError("换床占用原床位前----目标床位原状态为：" + originalBedDO.getSd_bedsu() + "，床号：" + originalBedDO.getName_bed() + "，病区id:" + originalBedDO.getId_dep_nur());
				EnLogUtil.getInstance().logError("----即将占用原床位----");
				bedBP.occupyBed2(originalBedDO.getId_bed());
			}else{
				EnLogUtil.getInstance().logError("换床使用原床位前----目标床位原状态为：" + originalBedDO.getSd_bedsu() + "，床号：" + originalBedDO.getName_bed() + "，病区id:" + originalBedDO.getId_dep_nur());
				EnLogUtil.getInstance().logError("----即将使用原床位----");
				bedBP.useBed2(originalBedDO.getId_bed());
			}
		}else {
			EnLogUtil.getInstance().logError("----目标床位id_ent为空，床号：" + targetBedDO.getName_bed() + "，病区id:" + targetBedDO.getId_dep_nur() + "，床位状态：" + targetBedDO.getSd_bedsu());
		}
	} 
	
	/**
	 * 更新entip表
	 * @param source
	 * @param target
	 * @throws BizException
	 */
	private void updateInpatientDO(BedBigCardDTO source, BedBigCardDTO target, ArrayList<String> sourceEntIdList, ArrayList<String> targetEntIdList) throws BizException {
		IpEP ipep = new IpEP();
		ipep.updateIpBedInfo(sourceEntIdList, target.getName_bed(), target.getId_bed());
		ipep.updateIpBedInfo(targetEntIdList, source.getName_bed(), source.getId_bed());
	}
	/**
	 * 更新就诊床位信息
	 * @param source
	 * @param target
	 * @throws BizException
	 */
	private FDateTime updateEntBed(BedBigCardDTO source, BedBigCardDTO target) throws BizException {
		EntBedEP enBedEP = new EntBedEP();
		FDateTime currentTime = EnAppUtils.getServerDateTime();
		String nurId = EnContextUtils.getDeptId();
		if (source.getId_ent() != null && source.getFg_ip() !=null && source.getFg_ip().booleanValue()) { 
			if(!isUseOneBed){
				// 结束使用旧床位
				enBedEP.changeToBed(source.getId_ent(), target.getId_bed(), target.getName_bed(), nurId, currentTime);
			}else{
				//使用新床位
				enBedEP.useBed(source.getId_ent(), target.getId_bed(), target.getName_bed(), nurId, currentTime);
			}
		}
		if (target.getId_ent() != null && target.getFg_ip() !=null && target.getFg_ip().booleanValue()) {
			// 使用新床位
			enBedEP.changeToBed(target.getId_ent(), source.getId_bed(), source.getName_bed(), nurId, currentTime);
		}
		return currentTime;
	}
	/***
	 * 新生儿与母亲是否使用同一张床
	 * @param newBorn
	 * @param originalBedDO
	 * @param targetBedDO
	 * @return
	 * @throws BizException
	 */
	private void isUseOneBed(NewbornDO newBorn,BedBigCardDTO originalBedDO,BedBigCardDTO targetBedDO) throws BizException{
		IpEP ipEP = new IpEP();
		//源床位和母亲是同一床位时，只允许更换到空床
		InpatientDO ipDO = ipEP.getIpByEntId(originalBedDO.getId_ent());
		if(ipDO == null || StringUtils.isNullOrEmpty(ipDO.getId_bed())){
			throw new BizException("新生儿住院就诊数据获取失败，请核对该新生儿对应的床位数据！");
		}
		InpatientDO[] mmDOs = ipEP.getIpDOByEntId(newBorn.getId_ent_mom());
		if(mmDOs == null || mmDOs.length <= 0 || StringUtils.isNullOrEmpty(mmDOs[0].getId_bed())){
			throw new BizException("新生儿母亲数据获取失败，请核对该新生儿对应的床位数据！");
		}
		if(ipDO.getId_bed().equals(mmDOs[0].getId_bed()) && !StringUtils.isNullOrEmpty(targetBedDO.getId_ent())){
			throw new BizException("源床位为与母亲共床的新生儿，目标床位必须为空床，请重新选择目标床位！");
		}
		if(ipDO.getId_bed().equals(mmDOs[0].getId_bed())){
			isUseOneBed =  true;
		}else{
			isUseOneBed = false;
		}
	}

	/**
	 * 更新病历
	 * @param source
	 * @param target
	 * @throws BizException
	 */
	private void updateAmrBP(BedBigCardDTO source, BedBigCardDTO target, ArrayList<String> sourceEntIdList, ArrayList<String> targetEntIdList) throws BizException {
		AmrBP amrBp = new AmrBP();
		// 源卡
		if (source.getId_ent() != null && source.getFg_ip() != null&& source.getFg_ip().booleanValue()) {
			if (!ListUtil.isEmpty(sourceEntIdList)) {
				AMrDO[] amrdos = amrBp.getAmrDO(sourceEntIdList);
				if (!ArrayUtil.isEmpty(amrdos)) {
					for (AMrDO amrdo : amrdos) {
						amrdo.setStatus(DOStatus.UPDATED);
						amrdo.setId_bed(target.getId_bed());
					}
					amrBp.saveAmr(amrdos);
				}
			}
		}
		// 目的卡
		if (target.getId_ent() != null && target.getFg_ip() != null&& target.getFg_ip().booleanValue()) {
			if (!ListUtil.isEmpty(targetEntIdList)) {
				AMrDO[] amrdos = amrBp.getAmrDO(targetEntIdList);
				if (!ArrayUtil.isEmpty(amrdos)) {
					for (AMrDO amrdo : amrdos) {
						amrdo.setStatus(DOStatus.UPDATED);
						amrdo.setId_bed(source.getId_bed());
					}
					amrBp.saveAmr(amrdos);
				}
			}
		}
	}
	/**
	 * 触发事件
	 * @param source 原床位
	 * @param target 目标床位
	 * @throws BizException
	 */
	private void invokeEventForSouceBed(BedBigCardDTO source, BedBigCardDTO target, FDateTime dt_opr) throws BizException{
		//1、构造事件源
		ChgBed4EsDTO esDTO = new ChgBed4EsDTO();
		esDTO.setId_ent(source.getId_ent());
		esDTO.setId_pat(source.getId_pat());
		esDTO.setSd_sex_pat(source.getCode_sex());
		//chgBed4EsDTO.setCode_amr_ip(source.get);
		esDTO.setName_pat(source.getName_pat());
		esDTO.setDt_birth(source.getDt_birth_pat());
		//esDTO.setOld_sd_dep_nur(source.getsd);
		esDTO.setOld_bedname(source.getName_bed());
		esDTO.setNew_bedname(target.getName_bed());
		esDTO.setOld_id_dep_nur(source.getId_dep_nur());
		esDTO.setOld_id_dep_phy(source.getId_dep_phy());
		esDTO.setId_dep_nur(source.getId_dep_nur());
		esDTO.setId_dep_phy(source.getId_dep_phy());
		esDTO.setDt_opr(dt_opr);
		esDTO.setCode_pat(source.getCode_pat());
		esDTO.setTimes_ip(source.getTimes_ip());
		
		//2、触发事件
		IpChgBedEvent chgBedEvent = new IpChgBedEvent();
		chgBedEvent.invoke(esDTO);
	}
	
	/**
	 * 触发事件
	 * @param source 原床位
	 * @param target 目标床位
	 * @throws BizException
	 */
	private void invokeEventForTatgetBed(BedBigCardDTO source, BedBigCardDTO target, FDateTime dt_opr) throws BizException{
		//1、构造事件源
		ChgBed4EsDTO esDTO = new ChgBed4EsDTO();
		esDTO.setId_ent(target.getId_ent());
		esDTO.setId_pat(target.getId_pat());
		esDTO.setSd_sex_pat(target.getCode_sex());
		//chgBed4EsDTO.setCode_amr_ip(source.get);
		esDTO.setName_pat(target.getName_pat());
		esDTO.setDt_birth(target.getDt_birth_pat());
		//esDTO.setOld_sd_dep_nur(source.getsd);
		esDTO.setOld_bedname(target.getName_bed());
		esDTO.setNew_bedname(source.getName_bed());
		esDTO.setOld_id_dep_nur(target.getId_dep_nur());
		esDTO.setOld_id_dep_phy(target.getId_dep_phy());
		esDTO.setId_dep_nur(target.getId_dep_nur());
		esDTO.setId_dep_phy(target.getId_dep_phy());
		esDTO.setEvent_source(IEventType.TYPE_INSERT_AFTER);//事件类型
		esDTO.setId_dep_opr(EnContextUtils.getDeptId());  //操作科室
		esDTO.setId_emp_opr(EnContextUtils.getPsnId());//操作员
		esDTO.setDt_opr(EnAppUtils.getServerDateTime());//操作时间
		esDTO.setDt_opr(dt_opr);
		esDTO.setCode_pat(target.getCode_pat());
		esDTO.setTimes_ip(target.getTimes_ip());
		//2、触发事件
		IpChgBedEvent chgBedEvent = new IpChgBedEvent();
		chgBedEvent.invoke(esDTO);;
	}
}
