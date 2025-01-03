package iih.en.comm.ep;

import iih.bd.bc.udi.pub.IBdResDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.bd.res.bed.d.Bdbed;
import iih.bd.res.bed.d.desc.BdbedDesc;
import iih.bd.res.bed.i.IBedMDOCudService;
import iih.bd.res.bed.i.IBedMDORService;
import iih.en.comm.IEnMsgConst;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnLogUtil;
import iih.en.comm.util.EnParamUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.er.op.d.EnEntOpErDO;
import iih.en.er.op.i.IEnentoperRService;
import iih.en.pv.inpatient.d.InpatientDO;
import iih.en.pv.inpatient.d.desc.InpatientDODesc;
import iih.en.pv.inpatient.i.IInpatientRService;
import iih.sc.apt.aptip.d.AptIpDO;
import iih.sc.apt.aptip.i.IAptipMDORService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.lock.PKLock;

/**
 * 基础数据--床位EP
 * @author yank
 * @since 2015-10-14
 *
 */
public class BedEP {
	public BedEP(){
		
	}

	/**
	 * 使用床位（校验预约,预约的抛错）
	 * 
	 * @param bedId 床位ID
	 * @return
	 * @throws BizException
	 */
	public Bdbed useBed(String bedId) throws BizException {
		EnValidator.validateParam("床位ID", bedId);
		Bdbed bedDO = this.getBed(bedId);
		this.validateBedExist(bedDO);
		this.validateBedInfo(bedId,null);

		bedDO.setSd_bedsu(IBdResDictCodeConst.SD_BEDSU_USEDBYPATIENT);// 患者使用
		bedDO.setId_bedsu(IBdResDictCodeConst.ID_BEDSU_USEDBYPATIENT);
		bedDO.setStatus(DOStatus.UPDATED);
		EnLogUtil.getInstance().logError("方法：useBed(String bedId)----床位即将被使用，床号：" + bedDO.getName() + "，床位所属病区id:" + bedDO.getId_dep_belong() + "，床位状态：" + bedDO.getSd_bedsu());
		Bdbed[] bedDOs = this.save(new Bdbed[] { bedDO });
		EnLogUtil.getInstance().logError("方法：useBed(String bedId)----床位已经被使用，床号：" + bedDOs[0].getName() + "，床位所属病区id:" + bedDOs[0].getId_dep_belong() + "，床位状态：" + bedDOs[0].getSd_bedsu());
		return bedDOs[0];
	}
	/**
	 * 使用床位（不校验预约）
	 * @param bedId 床位ID
	 * @return
	 * @throws BizException 
	 */
	public Bdbed useBed2(String bedId) throws BizException{
		EnValidator.validateParam("床位ID", bedId);	
		Bdbed bedDO = this.getBed(bedId);
		this.validateBedExist(bedDO);
		this.validateBedHasUsed(bedDO);
		
		bedDO.setSd_bedsu(IBdResDictCodeConst.SD_BEDSU_USEDBYPATIENT);//患者使用
		bedDO.setId_bedsu(IBdResDictCodeConst.ID_BEDSU_USEDBYPATIENT);
		bedDO.setStatus(DOStatus.UPDATED);
		EnLogUtil.getInstance().logError("方法：useBed2(String bedId)----床位即将被使用，床号：" + bedDO.getName() + "，床位所属病区id:" + bedDO.getId_dep_belong() + "，床位状态：" + bedDO.getSd_bedsu());
		Bdbed[] bedDOs = this.save(new Bdbed[]{bedDO});
		EnLogUtil.getInstance().logError("方法：useBed2(String bedId)----床位已经被使用，床号：" + bedDOs[0].getName() + "，床位所属病区id:" + bedDOs[0].getId_dep_belong() + "，床位状态：" + bedDOs[0].getSd_bedsu());
		return bedDOs[0];
	}
		
	/**
	 * 占用床位（不校验预约）
	 * @param bedId 床位ID
	 * @return
	 * @throws BizException 
	 */
	public Bdbed occupyBed2(String bedId) throws BizException{
		EnValidator.validateParam("床位ID", bedId);	
		Bdbed bedDO = this.getBed(bedId);
		this.validateBedExist(bedDO);
		this.validateBedHasUsed(bedDO);
		
		bedDO.setSd_bedsu(IBdResDictCodeConst.SD_BEDSU_OCCUPYBYIN);//
		bedDO.setId_bedsu(IBdResDictCodeConst.ID_BEDSU_OCCUPYBYIN);
		bedDO.setStatus(DOStatus.UPDATED);
		EnLogUtil.getInstance().logError("方法：occupyBed2(String bedId)----床位即将被占用，床号：" + bedDO.getName() + "，床位所属病区id:" + bedDO.getId_dep_belong() + "，床位状态：" + bedDO.getSd_bedsu());
		Bdbed[] bedDOs = this.save(new Bdbed[]{bedDO});
		EnLogUtil.getInstance().logError("方法：occupyBed2(String bedId)----床位已经被占用，床号：" + bedDOs[0].getName() + "，床位所属病区id:" + bedDOs[0].getId_dep_belong() + "，床位状态：" + bedDOs[0].getSd_bedsu());
		return bedDOs[0];
	}
	/**
	 * 占用床位（校验预约，修改预约状态）
	 * @param bedId 床位ID 
	 * @throws BizException 
	 */
	public void occupyBed(String bedId,String ipntId) throws BizException{
		EnValidator.validateParam("床位ID", bedId);
		Bdbed bedDO = this.getBed(bedId);
		this.validateBedExist(bedDO);
		this.validateBedInfo(bedId,ipntId);
		bedDO.setSd_bedsu(IBdResDictCodeConst.SD_BEDSU_OCCUPYBYIN);
		bedDO.setId_bedsu(IBdResDictCodeConst.ID_BEDSU_OCCUPYBYIN);
		bedDO.setFg_appt(FBoolean.FALSE);
		bedDO.setStatus(DOStatus.UPDATED);
		EnLogUtil.getInstance().logError("方法：occupyBed(String bedId,String ipntId)----床位即将被占用，床号：" + bedDO.getName() + "，床位所属病区id:" + bedDO.getId_dep_belong() + "，床位状态：" + bedDO.getSd_bedsu());
		Bdbed[] bedDOs = this.save(new Bdbed[]{bedDO});
		EnLogUtil.getInstance().logError("方法：occupyBed(String bedId,String ipntId)----床位已经被占用，床号：" + bedDOs[0].getName() + "，床位所属病区id:" + bedDOs[0].getId_dep_belong() + "，床位状态：" + bedDOs[0].getSd_bedsu());
	}
	
	/**
	 * 占/使用床位（区分床位性别）
	 * 
	 * @param bedId		床位id 
	 * @param ipntId	入院通知单id
	 * @param sdSexOfPat	患者性别编码
	 * @param modifyAppt	是否修改预约状态
	 * @param sdBedSu		床位状态sd
	 * @param idBedSu		床位状态id
	 * @return
	 * @throws BizException
	 */
	public Bdbed occupyBedWithSex(String bedId, String ipntId, String sdSexOfPat, 
			FBoolean modifyAppt, String sdBedSu, String idBedSu) throws BizException {
		EnValidator.validateParam("床位ID", bedId);
		Bdbed[] allBeds = this.getRelationBed(bedId);
		Bdbed bedDO = null;	
		for (Bdbed bdbed : allBeds) {
			if (bedId.equals(bdbed.getId_bed())) {
				bedDO = bdbed;
			}
		}
		this.validateBedExist(bedDO);
		if (modifyAppt.booleanValue()) {
			this.validateBedInfo(bedId,ipntId);
		}else {
			this.validateBedHasUsed(bedDO);
		}
		//修改床位性别
		if ((IPiDictCodeConst.SD_SEX_MALE.equals(sdSexOfPat) 
				&& !IBdResDictCodeConst.SD_BEDSEXLIMIT_MALE.equals(bedDO.getSd_bedsexlimit())) 
				|| (IPiDictCodeConst.SD_SEX_FEMALE.equals(sdSexOfPat) 
						&& !IBdResDictCodeConst.SD_BEDSEXLIMIT_FEMALE.equals(bedDO.getSd_bedsexlimit()))) {
			//得到所有非使用、占用床位
			List<Bdbed> ortherBedList = this.getEmptyBeds(allBeds, bedDO);
			//该房间其他使用中男床位
			List<Bdbed> unEmptyBedMale = this.getOrtherBedInUse(allBeds, bedDO, IBdResDictCodeConst.SD_BEDSEXLIMIT_MALE);
			//该房间其他使用中女床位
			List<Bdbed> unEmptyBedFemale = this.getOrtherBedInUse(allBeds, bedDO, IBdResDictCodeConst.SD_BEDSEXLIMIT_FEMALE);
			//如果房间内有异性患者，则改变所有空床为0不区分床位性别
			if ((!EnValidator.isEmpty(unEmptyBedMale) && !EnValidator.isEmpty(unEmptyBedFemale)) 
					|| (IPiDictCodeConst.SD_SEX_MALE.equals(sdSexOfPat) && !EnValidator.isEmpty(unEmptyBedFemale)) 
					|| (IPiDictCodeConst.SD_SEX_FEMALE.equals(sdSexOfPat) && !EnValidator.isEmpty(unEmptyBedMale))) {
				this.updateEmptyBedSex(ortherBedList != null ? ortherBedList.toArray(new Bdbed[]{}) : null, 
						IBdResDictCodeConst.SD_BEDSEXLIMIT_UNLIMIT, IBdResDictCodeConst.ID_BEDSEXLIMIT_UNLIMIT);
				//患者为男
				if (IPiDictCodeConst.SD_SEX_MALE.equals(sdSexOfPat)) {
					bedDO.setSd_bedsexlimit(IBdResDictCodeConst.SD_BEDSEXLIMIT_MALE);
					bedDO.setId_bedsexlimit(IBdResDictCodeConst.ID_BEDSEXLIMIT_MALE);
				}
				//患者为女
				if (IPiDictCodeConst.SD_SEX_FEMALE.equals(sdSexOfPat)) {
					bedDO.setSd_bedsexlimit(IBdResDictCodeConst.SD_BEDSEXLIMIT_FEMALE);
					bedDO.setId_bedsexlimit(IBdResDictCodeConst.ID_BEDSEXLIMIT_FEMALE);
				}
			}//否则，如果患者是男性，修改所有空床位性别为男性
			else if (IPiDictCodeConst.SD_SEX_MALE.equals(sdSexOfPat)) {
				this.updateEmptyBedSex(ortherBedList != null ? ortherBedList.toArray(new Bdbed[]{}) : null, 
						IBdResDictCodeConst.SD_BEDSEXLIMIT_MALE, IBdResDictCodeConst.ID_BEDSEXLIMIT_MALE);
				bedDO.setSd_bedsexlimit(IBdResDictCodeConst.SD_BEDSEXLIMIT_MALE);
				bedDO.setId_bedsexlimit(IBdResDictCodeConst.ID_BEDSEXLIMIT_MALE);
			}//否则，如果患者是女性，修改所有空床位性别为女性
			else if (IPiDictCodeConst.SD_SEX_FEMALE.equals(sdSexOfPat)) {
				this.updateEmptyBedSex(ortherBedList != null ? ortherBedList.toArray(new Bdbed[]{}) : null, 
						IBdResDictCodeConst.SD_BEDSEXLIMIT_FEMALE, IBdResDictCodeConst.ID_BEDSEXLIMIT_FEMALE);
				bedDO.setSd_bedsexlimit(IBdResDictCodeConst.SD_BEDSEXLIMIT_FEMALE);
				bedDO.setId_bedsexlimit(IBdResDictCodeConst.ID_BEDSEXLIMIT_FEMALE);
			}
		}
		bedDO.setSd_bedsu(sdBedSu);
		bedDO.setId_bedsu(idBedSu);
		if (modifyAppt.booleanValue()) {
			bedDO.setFg_appt(FBoolean.FALSE);
		}
		bedDO.setStatus(DOStatus.UPDATED);
		EnLogUtil.getInstance().logError("区分床位性别----床位即将被占/时用，床号：" + bedDO.getName() + "，床位所属病区id:" + bedDO.getId_dep_belong() + "，床位状态：" + bedDO.getSd_bedsu());
		Bdbed[] bedDOs = this.save(new Bdbed[]{bedDO});
		EnLogUtil.getInstance().logError("区分床位性别----床位已经被占/时用，床号：" + bedDOs[0].getName() + "，床位所属病区id:" + bedDOs[0].getId_dep_belong() + "，床位状态：" + bedDOs[0].getSd_bedsu());
		return bedDOs[0];
	
	}
	
	/**
	 * 释放床位
	 * @param bedId 床位id
	 * @throws BizException 
	 */
	public void releaseBed(String idEnt, String bedId) throws BizException{
		EnValidator.validateParam("床位ID", bedId);	
		validateBedWhoUse(idEnt, bedId);
		Bdbed bedDO = this.getBed(bedId);	
		this.validateBedExist(bedDO);
		if(!this.hasUsed(bedDO)){
			EnLogUtil.getInstance().logError("方法：releaseBed(String bedId)----床位未使用，无需释放，床号：" + bedDO.getName() + "，床位所属病区id:" + bedDO.getId_dep_belong() + "，床位状态：" + bedDO.getSd_bedsu());
			return;//如果未使用，无需释放
		}
		//1、释放包床
		this.releaseRentedBed(bedId);
		
		//2、释放床位
		this.setToUnused(bedDO);
		EnLogUtil.getInstance().logError("方法：releaseBed(String bedId)----床位即将释放，床号：" + bedDO.getName() + "，床位所属病区id:" + bedDO.getId_dep_belong() + "，床位状态：" + bedDO.getSd_bedsu());
		Bdbed[] bdbeds = this.save(new Bdbed[]{bedDO});
		EnLogUtil.getInstance().logError("方法：releaseBed(String bedId)----床位已释放，床号：" + bdbeds[0].getName() + "，床位所属病区id:" + bdbeds[0].getId_dep_belong() + "，床位状态：" + bdbeds[0].getSd_bedsu());
	}
	

	/**
	 * 释放床位(释放预约)
	 * @param bedId 床位id
	 * @throws BizException 
	 */
	public void releaseBedWithAppt(String idEnt, String bedId) throws BizException{
		EnValidator.validateParam("床位ID", bedId);	
		validateBedWhoUse(idEnt, bedId);
		Bdbed bedDO = this.getBed(bedId);	
		this.validateBedExist(bedDO);
		if(!this.hasUsed(bedDO)){
			if (bedDO.getFg_appt().booleanValue()) {
				EnLogUtil.getInstance().logError("方法：releaseBedWithAppt(String idBed)----释放患者预约的床位，床号：" + bedDO.getName() + "，床位所属病区id:" + bedDO.getId_dep_belong() + "，床位状态：" + bedDO.getSd_bedsu());
				bedDO.setStatus(DOStatus.UPDATED);
				bedDO.setFg_appt(FBoolean.FALSE);
				this.save(new Bdbed[]{bedDO});
				EnLogUtil.getInstance().logError("方法：releaseBedWithAppt(String idBed)----成功释放患者预约的床位，床号：" + bedDO.getName() + "，床位所属病区id:" + bedDO.getId_dep_belong() + "，床位状态：" + bedDO.getSd_bedsu());
				return;
			}
			EnLogUtil.getInstance().logError("方法：releaseBedWithAppt(String bedId)----床位未使用，无需释放，床号：" + bedDO.getName() + "，床位所属病区id:" + bedDO.getId_dep_belong() + "，床位状态：" + bedDO.getSd_bedsu());
			return;//如果未使用，无需释放
		}
		//1、释放包床
		this.releaseRentedBed(bedId);
		
		//2、释放床位
		this.setToUnusedWithAppt(bedDO);	
		EnLogUtil.getInstance().logError("方法：releaseBedWithAppt(String bedId)----床位即将释放，床号：" + bedDO.getName() + "，床位所属病区id:" + bedDO.getId_dep_belong() + "，床位状态：" + bedDO.getSd_bedsu());
		Bdbed[] bdbeds = this.save(new Bdbed[]{bedDO});
		EnLogUtil.getInstance().logError("方法：releaseBedWithAppt(String bedId)----床位已释放，床号：" + bdbeds[0].getName() + "，床位所属病区id:" + bdbeds[0].getId_dep_belong() + "，床位状态：" + bdbeds[0].getSd_bedsu());
	}
	
	/**
	 * 释放床位（科室区分床位性别）
	 * 
	 * @param idBed
	 * @param fg_setAppt	是否释放预约
	 * @throws BizException
	 */
	public void releaseBedWithSex(String idEnt, String idBed, FBoolean fg_setAppt) throws BizException {
		EnValidator.validateParam("床位ID", idBed);	
		validateBedWhoUse(idEnt, idBed);
		//1、获取包床和同一房间的其他床位
		Bdbed[] allBeds = this.getRelationBed(idBed);
		Bdbed bedDO = null;	
		for (Bdbed bdbed : allBeds) {
			if (idBed.equals(bdbed.getId_bed())) {
				bedDO = bdbed;
			}
		}
		
		this.validateBedExist(bedDO);
		if(!this.hasUsed(bedDO)){
			if (bedDO.getFg_appt().booleanValue()) {
				EnLogUtil.getInstance().logError("方法：releaseBedWithSex(String idBed, FBoolean fg_setAppt)----释放患者预约的床位，床号：" + bedDO.getName() + "，床位所属病区id:" + bedDO.getId_dep_belong() + "，床位状态：" + bedDO.getSd_bedsu());
				bedDO.setStatus(DOStatus.UPDATED);
				bedDO.setFg_appt(FBoolean.FALSE);
				this.save(new Bdbed[]{bedDO});
				EnLogUtil.getInstance().logError("方法：releaseBedWithSex(String idBed, FBoolean fg_setAppt)----成功释放患者预约的床位，床号：" + bedDO.getName() + "，床位所属病区id:" + bedDO.getId_dep_belong() + "，床位状态：" + bedDO.getSd_bedsu());
				return;
			}
			EnLogUtil.getInstance().logError("方法：releaseBedWithSex(String idBed, FBoolean fg_setAppt)----床位未使用，无需释放，床号：" + bedDO.getName() + "，床位所属病区id:" + bedDO.getId_dep_belong() + "，床位状态：" + bedDO.getSd_bedsu());
			return;//如果未使用，无需释放
		}
		
		//2、释放
		this.updataBeds(bedDO, allBeds, fg_setAppt);
	}
	
	/**
	 * 包床
	 * @param entId 就诊id
	 * @param mainBedId 主床位id
	 * @param bedId 床位id
	 * @return 床位信息
	 * @throws BizException
	 */
	public Bdbed rentBed(String entId,String mainBedId,String bedId) throws BizException{
		EnValidator.validateParam("主床ID", mainBedId);
		EnValidator.validateParam("床位ID", bedId);
		//包床占用
		Bdbed bedDO = this.getBed(bedId);
		this.validateBedExist(bedDO);
		this.validateBedHasUsed(bedDO);	
		
		bedDO.setSd_bedsu(IBdResDictCodeConst.SD_BEDSU_RENT);
		bedDO.setId_bedsu(IBdResDictCodeConst.ID_BEDSU_RENT);
		bedDO.setFg_share(FBoolean.TRUE);
		bedDO.setId_bed_main(mainBedId);
		bedDO.setStatus(DOStatus.UPDATED);
		Bdbed[] Bdbeds = this.save(new Bdbed[]{bedDO});	
		if(EnValidator.isEmpty(Bdbeds)){
			return null;
		}
		
		return Bdbeds[0];
	}
	
	/**
	 * 包床（区分床位性别）
	 */
//	public Bdbed rentBedWithSex(String entId, String mainBedId, String bedId, String sdSexOfPat) throws BizException {
//		EnValidator.validateParam("主床ID", mainBedId);
//		EnValidator.validateParam("床位ID", bedId);
//		Bdbed bedDO = this.getBed(bedId);
//		this.validateBedExist(bedDO);
//		this.validateBedHasUsed(bedDO);	
//		//修改床位性别
//		if ((IPiDictCodeConst.SD_SEX_MALE.equals(sdSexOfPat) 
//				&& !IBdResDictCodeConst.SD_BEDSEXLIMIT_MALE.equals(bedDO.getSd_bedsexlimit())) 
//				|| (IPiDictCodeConst.SD_SEX_FEMALE.equals(sdSexOfPat) 
//						&& !IBdResDictCodeConst.SD_BEDSEXLIMIT_FEMALE.equals(bedDO.getSd_bedsexlimit()))) {
//			Bdbed[] ortherBeds = this.getOrtherBedList(bedDO.getRoom(), bedDO.getId_bed());
//			List<Bdbed> bedInUse = this.getOrtherBedInUse(ortherBeds);
//			List<Bdbed> ortherBedList = Arrays.asList(ortherBeds);
//			if (!EnValidator.isEmpty(ortherBedList) && !EnValidator.isEmpty(bedInUse)) {
//				ortherBedList.removeAll(bedInUse);
//			}
////			//判断是否需要修改床位性别（该房间都是空床时修改，否则不修改）
////			if (EnValidator.isEmpty(bedInUse)) {
//			//如果患者是男性，修改所有空床位性别为男性
//			if (IPiDictCodeConst.SD_SEX_MALE.equals(sdSexOfPat)) {
//				this.updateEmptyBedSex(ortherBedList != null ? ortherBedList.toArray(ortherBeds) : null, 
//						IBdResDictCodeConst.SD_BEDSEXLIMIT_MALE, IBdResDictCodeConst.ID_BEDSEXLIMIT_MALE);
//				bedDO.setSd_bedsexlimit(IBdResDictCodeConst.SD_BEDSEXLIMIT_MALE);
//				bedDO.setId_bedsexlimit(IBdResDictCodeConst.ID_BEDSEXLIMIT_MALE);
//			}
//			//如果患者是女性，修改所有空床位性别为女性
//			if (IPiDictCodeConst.SD_SEX_FEMALE.equals(sdSexOfPat)) {
//				this.updateEmptyBedSex(ortherBedList != null ? ortherBedList.toArray(ortherBeds) : null, 
//						IBdResDictCodeConst.SD_BEDSEXLIMIT_FEMALE, IBdResDictCodeConst.ID_BEDSEXLIMIT_FEMALE);
//				bedDO.setSd_bedsexlimit(IBdResDictCodeConst.SD_BEDSEXLIMIT_FEMALE);
//				bedDO.setId_bedsexlimit(IBdResDictCodeConst.ID_BEDSEXLIMIT_FEMALE);
//			}
////			}
//		}
//		bedDO.setSd_bedsu(IBdResDictCodeConst.SD_BEDSU_RENT);
//		bedDO.setId_bedsu(IBdResDictCodeConst.ID_BEDSU_RENT);
//		bedDO.setFg_share(FBoolean.TRUE);
//		bedDO.setId_bed_main(mainBedId);
//		bedDO.setStatus(DOStatus.UPDATED);
//		Bdbed[] bedDOs = this.save(new Bdbed[]{bedDO});
//		if(EnValidator.isEmpty(bedDOs)){
//			return null;
//		}
//		return bedDOs[0];
//	}
	
	/**
	 * 检查是否已经使用
	 * @param bedId 床位id
	 * @return
	 * @throws BizException
	 */
	public FBoolean hasUsed(String bedId) throws BizException{
		Bdbed bedDO = this.getBed(bedId);
		boolean hasUsed = this.hasUsed(bedDO);
		return new FBoolean(hasUsed);
	}
	/**
	 * 判定床位状态是不是发生了改变
	 * @param bedId
	 * @param bedsu
	 * @return
	 * @throws BizException
	 */
	public FBoolean hasChanged(String bedId,String bedsu) throws BizException{
		Bdbed bedDO = this.getBed(bedId);
		if(bedDO.getBedsu_name()!=null && bedDO.getSd_bedsu().equals(bedsu)){
			return FBoolean.FALSE;
		}		
		return FBoolean.TRUE;
	}
	/**
	 * 是否已经使用
	 * @param bedDO 床位
	 * @return
	 * @throws BizException 
	 */
	public boolean hasUsed(Bdbed bedDO) throws BizException{
		EnValidator.validateParam("床位", bedDO);
		if(bedDO.getSd_bedsu()==null
			||IBdResDictCodeConst.SD_BEDSU_EMPTY.equals(bedDO.getSd_bedsu())){
			return false;
		}
		
		return true;
	}
	/**
	 * 根据id获取床位
	 * @param bedId 床位id
	 * @return
	 * @throws BizException 
	 */
	public Bdbed getBed(String bedId) throws BizException{
		if(EnValidator.isEmpty(bedId))return null;
		IBedMDORService bedRSV = ServiceFinder.find(IBedMDORService.class);
		Bdbed bedDO = bedRSV.findById(bedId);
		return bedDO;
	}
	
	/**
	 * 根据id获取床位
	 * @param bedId 床位id
	 * @return
	 * @throws BizException 
	 */
	public Map<String,Bdbed> getBeds(List<String> bedIdList) throws BizException{
		if(EnValidator.isEmpty(bedIdList))return null;
		IBedMDORService bedRSV = ServiceFinder.find(IBedMDORService.class);
		Bdbed[] bedDOs = bedRSV.findByIds(bedIdList.toArray(new String[0]),FBoolean.FALSE);
		if(EnValidator.isEmpty(bedDOs))
			return null;
		Map<String,Bdbed> map = new HashMap<String,Bdbed>();
		for(Bdbed bed:bedDOs){
			if(!map.containsKey(bed.getId_bed()))
			{
				map.put(bed.getId_bed(), bed);
			}
		}
		return map;
	}
	
	/**
	 * 获取该病床所在房间所有病床
	 * @param bedDO
	 * @return
	 * @throws BizException
	 * 
	 * @author jizb
	 */
	public Bdbed[] getBedsSameRoom(Bdbed bedDO) throws BizException {
		if(bedDO == null)return null;
		IBedMDORService bedRSV = ServiceFinder.find(IBedMDORService.class);
		StringBuilder whereStr = new StringBuilder();
		whereStr.append("bd_bed.room = '" + bedDO.getRoom() + "' and bd_bed.id_dep_belong = '" + bedDO.getId_dep_belong() + "'");
		Bdbed[] beds = bedRSV.find(whereStr.toString(), null, FBoolean.FALSE);
		return beds;
	}
	
	/**
	 * 获取床位的包床信息
	 * @param bedId 床位ID
	 * @return
	 * @throws BizException
	 */
	public Bdbed[] getRentedBedInfo(String bedId) throws BizException{
		if(EnValidator.isEmpty(bedId))return null;
		IBedMDORService bedRSV = ServiceFinder.find(IBedMDORService.class);	
		Bdbed[] relBeds = bedRSV.findByAttrValString(Bdbed.ID_BED_MAIN, bedId);
		return relBeds;
	}
	/**
	 * 获取床位的包床和同房间的其他床位
	 * @param bedId 床位ID
	 * @return
	 * @throws BizException
	 */
	public Bdbed[] getRelationBed(String bedId) throws BizException{
		if(EnValidator.isEmpty(bedId))return null;
		IBedMDORService bedRSV = ServiceFinder.find(IBedMDORService.class);	
		Bdbed[] relBeds = bedRSV.find(String.format(BdbedDesc.TABLE_ALIAS_NAME + ".id_bed_main='%s' or id_bed = '%s' or"
				+ "(room <> '~' and room is not null and room = (select room from bd_bed where id_bed = '%s') and id_dep_belong = "
				+ "(select id_dep_belong from bd_bed where id_bed = '%s') and fg_act = 'Y')", bedId, bedId, bedId, bedId), null, FBoolean.FALSE);
		return relBeds;
	}
	/**
	 * 保存床位
	 * @param beds 床位数组
	 * @return
	 * @throws BizException
	 */
	public Bdbed[] save(Bdbed[] beds) throws BizException{
		IBedMDOCudService bedCrudSV = ServiceFinder.find(IBedMDOCudService.class);
		return bedCrudSV.save(beds);
	}
	/**
	 * 释放包床
	 * @param bedId 床位ID
	 * @throws BizException
	 */
	private void releaseRentedBed(String bedId) throws BizException{
		Bdbed[] relBeds = this.getRentedBedInfo(bedId);
		if(!EnValidator.isEmpty(relBeds)){
			for(Bdbed bed : relBeds){
				this.setToUnused(bed);
			}	
			this.save(relBeds);
		}
	}
	/**
	 * 将床位设置为未使用
	 * @param bed
	 */
	private void setToUnused(Bdbed bed){
		bed.setSd_bedsu(IBdResDictCodeConst.SD_BEDSU_EMPTY);
		bed.setId_bedsu(IBdResDictCodeConst.ID_BEDSU_EMPTY);
		bed.setFg_share(FBoolean.FALSE);
		bed.setId_bed_main(null);
		bed.setStatus(DOStatus.UPDATED);
	}
	
	/**
	 * 更新空床床位性别
	 * 
	 * @param emptyBeds
	 * @param sdBedSex
	 * @param idBedSex
	 * @throws BizException
	 */
	private void updateEmptyBedSex(Bdbed[] emptyBeds, String sdBedSex, String idBedSex) throws BizException{
		if (!EnValidator.isEmpty(emptyBeds)) {
			for (Bdbed bdbed : emptyBeds) {
				this.setSexForUnusedBed(bdbed, sdBedSex, idBedSex);
				this.save(emptyBeds);
			}
		}
	}
	
	/**
	 * 获取本房间与本患者无关的其他非空床位(使用、占用)
	 * 
	 * @param allBeds
	 * @param mainBed
	 * @param sdBedSex
	 * @return
	 */
	private List<Bdbed> getOrtherBedInUse(Bdbed[] allBeds, Bdbed mainBed, String sdBedSex) {
		if (EnValidator.isEmpty(allBeds))
			return null;
		List<Bdbed> unEmptyBed = new ArrayList<Bdbed>(0);
		//该房间其他使用中床位
		for (Bdbed bdbed : allBeds) {
			if (bdbed.getSd_bedsu().equals(IBdResDictCodeConst.SD_BEDSU_USEDBYPATIENT) 
					|| bdbed.getSd_bedsu().equals(IBdResDictCodeConst.SD_BEDSU_OCCUPYBYIN)) {
				if (!mainBed.getId_bed().equals(bdbed.getId_bed()) && sdBedSex.equals(bdbed.getSd_bedsexlimit())) {
					unEmptyBed.add(bdbed);
				}
			}
		}
		return unEmptyBed;
	}
	
	/**
	 * 获取本房间空床位
	 * 
	 * @param ortherBeds
	 * @return
	 */
	private List<Bdbed> getEmptyBeds(Bdbed[] allBeds, Bdbed mainBed) {
		if (EnValidator.isEmpty(allBeds))
			return null;
		List<Bdbed> emptyBeds = new ArrayList<Bdbed>(0);
		//该房间其他使用中床位
		for (Bdbed bdbed : allBeds) {
			if (!bdbed.getSd_bedsu().equals(IBdResDictCodeConst.SD_BEDSU_USEDBYPATIENT) 
					&& !bdbed.getSd_bedsu().equals(IBdResDictCodeConst.SD_BEDSU_OCCUPYBYIN)) {
				if (!mainBed.getId_bed().equals(bdbed.getId_bed())) {
					emptyBeds.add(bdbed);
				}
			}
		}
		return emptyBeds;
	}
	
	/**
	 * 获取包床
	 * 
	 * @param ortherBeds
	 * @return
	 */
	private List<Bdbed> getRentBedFromAll(Bdbed[] allBeds, Bdbed mainBed) {
		if (EnValidator.isEmpty(allBeds))
			return null;
		List<Bdbed> rentBed = new ArrayList<Bdbed>();
		for (Bdbed bdbed : allBeds) {
			if (mainBed.getId_bed().equals(bdbed.getId_bed_main())) {
				rentBed.add(bdbed);
			}
		}
		return rentBed;
	}
	
	/**
	 * 将床位设置为未使用并释放(预约)&(改变床位性别)
	 * @param bed
	 * @throws BizException 
	 */
	private void setToUnusedWithAppt2(Bdbed bed, String sdBedSex, String idBedSex, FBoolean fg_setAppt) throws BizException{
		bed.setSd_bedsu(IBdResDictCodeConst.SD_BEDSU_EMPTY);
		bed.setId_bedsu(IBdResDictCodeConst.ID_BEDSU_EMPTY);
		bed.setSd_bedsexlimit(sdBedSex);
		bed.setId_bedsexlimit(idBedSex);
		bed.setFg_share(FBoolean.FALSE);
		if (fg_setAppt.booleanValue())
			bed.setFg_appt(FBoolean.FALSE);
		bed.setId_bed_main(null);
		bed.setStatus(DOStatus.UPDATED);
		this.save(new Bdbed[]{bed});
	}
	
	/**
	 * 设置空床床位性别
	 * @param bed
	 */
	private void setSexForUnusedBed(Bdbed bed, String sdBedSex, String idBedSex){
		bed.setSd_bedsexlimit(sdBedSex);
		bed.setId_bedsexlimit(idBedSex);
		bed.setStatus(DOStatus.UPDATED);
	}
	
	/**
	 * 区分性别时释放
	 * 
	 * @param mainBed  	主床
	 * @param rentBeds	包床
	 * @param fg_setAppt	是否释放预约
	 * @throws BizException
	 */
	private void updataBeds(Bdbed mainBed, Bdbed[] allBeds, FBoolean fg_setAppt) throws BizException {
		//该房间其他使用中男床位
		List<Bdbed> unEmptyBedMale = this.getOrtherBedInUse(allBeds, mainBed, IBdResDictCodeConst.SD_BEDSEXLIMIT_MALE);
		//该房间其他使用中女床位
		List<Bdbed> unEmptyBedFemale = this.getOrtherBedInUse(allBeds, mainBed, IBdResDictCodeConst.SD_BEDSEXLIMIT_FEMALE);
		//获取包床
		List<Bdbed> rentBeds = this.getRentBedFromAll(allBeds, mainBed);
		//若使用中床位是同一性别，则将同一房间所有床位改为这一行别
		//所有使用中 床位为男床
		if (!EnValidator.isEmpty(unEmptyBedMale) && EnValidator.isEmpty(unEmptyBedFemale)) {
			this.releaseWithSex(rentBeds, mainBed, allBeds, fg_setAppt, IBdResDictCodeConst.SD_BEDSEXLIMIT_MALE, IBdResDictCodeConst.ID_BEDSEXLIMIT_MALE);
			return;
		}
		//所有使用中 床位为女床
		if (EnValidator.isEmpty(unEmptyBedMale) && !EnValidator.isEmpty(unEmptyBedFemale)) {
			this.releaseWithSex(rentBeds, mainBed, allBeds, fg_setAppt, IBdResDictCodeConst.SD_BEDSEXLIMIT_FEMALE, IBdResDictCodeConst.ID_BEDSEXLIMIT_FEMALE);
			return;
		}
		//否则，释放床位并改变该房间所有床位性别为“0”不限制
		this.releaseWithSex(rentBeds, mainBed, allBeds, fg_setAppt, IBdResDictCodeConst.SD_BEDSEXLIMIT_UNLIMIT, IBdResDictCodeConst.ID_BEDSEXLIMIT_UNLIMIT);
	}
	
	/**
	 * 释放
	 * 
	 * @param rentBeds
	 * @param mainBed
	 * @param allBeds
	 * @param fg_setAppt
	 * @param sdBedSex
	 * @param idBedSex
	 * @throws BizException
	 */
	private void releaseWithSex(List<Bdbed> rentBeds, Bdbed mainBed, Bdbed[] allBeds, FBoolean fg_setAppt, String sdBedSex, String idBedSex) throws BizException {
		if(!EnValidator.isEmpty(rentBeds)){
			//释放包床
			for(Bdbed bed : rentBeds){
				this.setToUnused(bed);
			}	
			this.save(rentBeds.toArray(new Bdbed[]{}));
		}
		//释放床位
		EnLogUtil.getInstance().logError("方法：releaseWithSex(List<Bdbed> rentBeds, Bdbed mainBed, Bdbed[] allBeds, FBoolean fg_setAppt, String sdBedSex, String idBedSex)"
				+ "----床位即将释放，床号：" + mainBed.getName() + "，床位所属病区id:" + mainBed.getId_dep_belong() + "，床位状态：" + mainBed.getSd_bedsu());
		this.setToUnusedWithAppt2(mainBed, sdBedSex, idBedSex, fg_setAppt);	
		EnLogUtil.getInstance().logError("方法：releaseWithSex(List<Bdbed> rentBeds, Bdbed mainBed, Bdbed[] allBeds, FBoolean fg_setAppt, String sdBedSex, String idBedSex"
				+ "----床位已释放，床号：" + mainBed.getName() + "，床位所属病区id:" + mainBed.getId_dep_belong() + "，床位状态：" + mainBed.getSd_bedsu());
		//获取本房间所有空床
		List<Bdbed> ortherBeds = this.getEmptyBeds(allBeds, mainBed);
		//更新空床床位性别
		this.updateEmptyBedSex(ortherBeds.toArray(new Bdbed[]{}), sdBedSex, idBedSex);

	}

//	/**
//	 * 没有包床时
//	 * 
//	 * @param mainBed
//	 * @throws BizException
//	 */
//	private void update4NoRents(Bdbed mainBed) throws BizException {
//		Bdbed[] ortherBeds = this.getOrtherBedList(mainBed.getRoom(), mainBed.getId_bed());
//		//该房间其他使用中床位
//		List<Bdbed> unEmptyBed = this.getOrtherBedInUse(ortherBeds);
//		if (EnValidator.isEmpty(unEmptyBed)) {
//			//释放床位
//			this.setToUnusedWithAppt(mainBed);	
//			this.save(new Bdbed[]{mainBed});
//			return;
//		}
//		//否则，释放床位并改变该房间所有床位性别为“0”不限制
//		this.setToUnusedWithAppt2(mainBed, IBdResDictCodeConst.SD_BEDSEXLIMIT_UNLIMIT, IBdResDictCodeConst.ID_BEDSEXLIMIT_UNLIMIT);	
//		//更新空床床位性别
//		this.updateEmptyBedSex(ortherBeds, IBdResDictCodeConst.SD_BEDSEXLIMIT_UNLIMIT, IBdResDictCodeConst.ID_BEDSEXLIMIT_UNLIMIT);
//	}
	
	
	/**
	 * 将床位设置为未使用(预约)
	 * @param bed
	 */
	private void setToUnusedWithAppt(Bdbed bed){
		bed.setSd_bedsu(IBdResDictCodeConst.SD_BEDSU_EMPTY);
		bed.setId_bedsu(IBdResDictCodeConst.ID_BEDSU_EMPTY);
		bed.setFg_share(FBoolean.FALSE);
		if (EnValidator.isEmpty(bed.getId_bed_main()))
			bed.setFg_appt(FBoolean.FALSE);
		bed.setId_bed_main(null);
		bed.setStatus(DOStatus.UPDATED);
	}
	
	/**
	 * 释放前校验床位是否被此次就诊使用
	 * 
	 * @param idEnt
	 * @param idBed
	 * @throws BizException
	 */
	private void validateBedWhoUse(String idEnt, String idBed) throws BizException{
		if (idEnt == null)
			return;
		IInpatientRService rService = ServiceFinder.find(IInpatientRService.class);
		InpatientDO[] ipDos = rService.find(String.format(InpatientDODesc.TABLE_ALIAS_NAME + ".id_ent='%s'", idEnt), null, FBoolean.FALSE);
		if (EnValidator.isEmpty(ipDos))
			throw new BizException("患者此次住院信息不存在！");
		if (!idBed.equals(ipDos[0].getId_bed()))
			throw new BizException("患者使用的床位发生变化，请刷新后重试！");
	}
	
	/**
	 * 验证床位是否存在
	 * @param bedDO
	 * @throws BizException
	 */
	private void validateBedExist(Bdbed bedDO) throws BizException{
		if(bedDO==null){
			throw new BizException(IEnMsgConst.ERROR_BED_NOT_EXIST);
		}
		if (!bedDO.getFg_act().booleanValue()) {
			throw new BizException(bedDO.getName() + IEnMsgConst.ERROR_BED_NOT_ACTIVE);
		}
	}
	/**
	 * 验证床位是否被使用
	 * @param bed
	 * @throws BizException
	 */
	private void validateBedHasUsed(Bdbed bedDO) throws BizException{
		if(bedDO.getSd_bedsu()!=null && !IBdResDictCodeConst.SD_BEDSU_EMPTY.equals(bedDO.getSd_bedsu())){
			throw new BizException(bedDO.getName() + IEnMsgConst.ERROR_BED_HAS_USED);
		}
	}
	
	/**
	 * 校验床位是否被占用 是否已经使用 或者预约的情况下床位是否发生变化
	 * 
	 * @param inpatientDO
	 * @param enHosRegDTO
	 * @throws BizException
	 */
	public void validateBedInfo(String bedId,String ipntId) throws BizException {
		EnValidator.validateParam("床位ID", bedId);		
		//查询床位状态前加锁
		FDate today = EnAppUtils.getServerDate();
		boolean lock = PKLock.getInstance().addDynamicLock(bedId + today.toStdtString(), 5 * 1000);
		if(!lock){
			throw new BizException(IEnMsgConst.ERROR_BED_STATUS_CHANGED2);
		}		
		Bdbed bedDO = this.getBed(bedId);
		boolean hasUsed = this.hasUsed(bedDO);
		if (hasUsed) {
			throw new BizException(bedDO.getName() + IEnMsgConst.ERROR_BED_STATUS_USED);
		}
		if (bedDO.getFg_appt() != null && bedDO.getFg_appt().booleanValue()) {
			if (!EnValidator.isEmpty(ipntId)) {
				IAptipMDORService aptcudService = ServiceFinder.find(IAptipMDORService.class);
				AptIpDO ipntDo = aptcudService.findById(ipntId);
				if (ipntDo ==null || bedId.equals(ipntDo.getId_bed())) {
					return;
				}
			}
			throw new BizException(bedDO.getName() + IEnMsgConst.ERROR_BED_STATUS_APPT);
		}
	}
	
	/**
	 * 查找病区的空床 返回第0个值
	 * @param id_dep_belong
	 * @return
	 * @throws BizException
	 */
	public Bdbed getBedbyDep(String id_dep_belong, String sdPatSex,boolean isVirBedFirst) throws BizException{
		if(EnValidator.isEmpty(id_dep_belong)){
			throw new BizException(IEnMsgConst.ERROR_DEP_NOTEXIT);
		}
		IBedMDORService bedRSV = ServiceFinder.find(IBedMDORService.class);
		String whereCon = " id_dep_belong ='"+id_dep_belong+"' and sd_bedsu ='"+ IBdResDictCodeConst.SD_BEDSU_EMPTY+"' and fg_appt = 'N'"
				+ " and  fg_act = 'Y'  and ds = '0'  ";
	
		//加锁，防止并发问题。
		boolean lock = PKLock.getInstance().addDynamicLock(id_dep_belong + IBdResDictCodeConst.SD_BEDSU_EMPTY, 5 * 1000);
		if(!lock){
			throw new BizException("当前床位数据正在被他人修改，请稍后重新登记！");
		}
		String orderCon =" fg_appt Asc , name Asc";
		if(isVirBedFirst){
			orderCon = " sd_bedtp desc,fg_appt Asc , name Asc";
		}
		
		Bdbed[] bedDOs = bedRSV.find(whereCon, orderCon, FBoolean.FALSE);
		
		if(EnValidator.isEmpty(bedDOs)){
			throw new BizException(IEnMsgConst.ERROR_BED_NOTEXIT);
		}
		if (!EnValidator.isEmpty(sdPatSex) && IEnDictCodeConst.BED_HAS_SEX.equals(EnParamUtils.getBedSexParam(id_dep_belong))) {
			for (Bdbed bdbed : bedDOs) {
				if ((IPiDictCodeConst.SD_SEX_MALE.equals(sdPatSex) && IBdResDictCodeConst.SD_BEDSEXLIMIT_MALE.equals(bdbed.getSd_bedsexlimit())) 
						|| (IPiDictCodeConst.SD_SEX_FEMALE.equals(sdPatSex) && IBdResDictCodeConst.SD_BEDSEXLIMIT_FEMALE.equals(bdbed.getSd_bedsexlimit()))) {
					return bdbed;
				}
			}
		}
		return bedDOs[0];
	}
	
	/**
	 * 校验和查询是否有空床，如果有，取ENIP0108参数规则的第一个值返回，入院登记注册专用
	 * @param id_dep_belong
	 * @param sdPatSex
	 * @param isVirBedFirst
	 * @return
	 * @throws BizException
	 */
	public Bdbed getRegistBedbyDep(String id_dep_belong, String sdPatSex) throws BizException{
		if(EnValidator.isEmpty(id_dep_belong)){
			throw new BizException(IEnMsgConst.ERROR_DEP_NOTEXIT);
		}
		//加锁，防止并发问题。
		boolean lock = PKLock.getInstance().addDynamicLock(id_dep_belong + IBdResDictCodeConst.SD_BEDSU_EMPTY, 5 * 1000);
		if(!lock){
			throw new BizException("当前床位数据正在被他人修改，请稍后重新登记！");
		}
		//查询床位信息
		Bdbed[] bedDOs = getRegistBedsInfo(id_dep_belong);
		if(EnValidator.isEmpty(bedDOs)){
			throw new BizException(IEnMsgConst.ERROR_BED_NOTEXIT);
		}
		if (!EnValidator.isEmpty(sdPatSex) && IEnDictCodeConst.BED_HAS_SEX.equals(EnParamUtils.getBedSexParam(id_dep_belong))) {
			for (Bdbed bdbed : bedDOs) {
				if ((IPiDictCodeConst.SD_SEX_MALE.equals(sdPatSex) && IBdResDictCodeConst.SD_BEDSEXLIMIT_MALE.equals(bdbed.getSd_bedsexlimit())) 
					|| (IPiDictCodeConst.SD_SEX_FEMALE.equals(sdPatSex) && IBdResDictCodeConst.SD_BEDSEXLIMIT_FEMALE.equals(bdbed.getSd_bedsexlimit()))){
					return bdbed;
				}
			}
			for (Bdbed bdbed : bedDOs) {
				if (IBdResDictCodeConst.SD_BEDSEXLIMIT_UNLIMIT.equals(bdbed.getSd_bedsexlimit())){
					return bdbed;
				}
			}
		}
		return bedDOs[0];
	}
	/**
	 * 查询ENIP0108参数规则的空床位信息
	 * @param id_dep_belong
	 * @return
	 * @throws BizException
	 */
	private Bdbed[] getRegistBedsInfo(String id_dep_belong) throws BizException{
		IBedMDORService bedRSV = ServiceFinder.find(IBedMDORService.class);
		 StringBuilder whereStr = new StringBuilder();
		 StringBuilder orderStr = new StringBuilder();
		 whereStr.append(" id_dep_belong ='"+id_dep_belong+"' ");
		 whereStr.append(" and sd_bedsu ='"+IBdResDictCodeConst.SD_BEDSU_EMPTY+"' ");
		 whereStr.append(" and fg_appt = 'N' ");
		 whereStr.append(" and fg_act = 'Y' ");
		 whereStr.append(" and ds = '0' ");
		String bedTp = EnParamUtils.getEnIpUseBedTp(id_dep_belong);
		if (!EnValidator.isEmpty(bedTp)) {
			String[] strs = bedTp.split(",");
			int num = 1;
			whereStr.append(" and sd_bedtp in ( ");
			orderStr.append(" (case sd_bedtp ");
			for (String str : strs) {
				whereStr.append(" '"+str+"' ");
				if (strs.length != num) {
					whereStr.append(",");
				}
				orderStr.append(" when ");
				orderStr.append(" '"+str+"' ");
				orderStr.append(" then ");
				orderStr.append(" "+num+" ");
				num++;
			}
			whereStr.append(")");
			orderStr.append(" end), ");
		}
		orderStr.append(" fg_appt asc, ");
		orderStr.append(" name asc ");
		return bedRSV.find(whereStr.toString(), orderStr.toString(), FBoolean.FALSE);
	}
	
	/**
	 * 释放床位（科室区分床位性别）---急诊抢救
	 * fanlq-2019-03-13
	 * @param idBed
	 * @param fg_setAppt	是否释放预约
	 * @throws BizException
	 */
	public void releaseBedRescue(String idEnt, String idBed, FBoolean fg_setAppt) throws BizException {
		EnValidator.validateParam("床位ID", idBed);
		validateBedRescue(idEnt, idBed);
		//1、获取包床和同一房间的其他床位
		Bdbed[] allBeds = this.getRelationBed(idBed);
		Bdbed bedDO = null;	
		for (Bdbed bdbed : allBeds) {
			if (idBed.equals(bdbed.getId_bed())) {
				bedDO = bdbed;
			}
		}
		
		this.validateBedExist(bedDO);
		if(!this.hasUsed(bedDO)){
			if (bedDO.getFg_appt().booleanValue()) {
				EnLogUtil.getInstance().logError("方法：releaseBedRescue(String idBed, FBoolean fg_setAppt)----释放患者预约的床位，床号：" + bedDO.getName() + "，床位所属病区id:" + bedDO.getId_dep_belong() + "，床位状态：" + bedDO.getSd_bedsu());
				bedDO.setStatus(DOStatus.UPDATED);
				bedDO.setFg_appt(FBoolean.FALSE);
				this.save(new Bdbed[]{bedDO});
				EnLogUtil.getInstance().logError("方法：releaseBedRescue(String idBed, FBoolean fg_setAppt)----成功释放患者预约的床位，床号：" + bedDO.getName() + "，床位所属病区id:" + bedDO.getId_dep_belong() + "，床位状态：" + bedDO.getSd_bedsu());
				return;
			}
			EnLogUtil.getInstance().logError("方法：releaseBedRescue(String idBed, FBoolean fg_setAppt)----床位未使用，无需释放，床号：" + bedDO.getName() + "，床位所属病区id:" + bedDO.getId_dep_belong() + "，床位状态：" + bedDO.getSd_bedsu());
			return;//如果未使用，无需释放
		}
		
		//2、释放
		this.updataBeds(bedDO, allBeds, fg_setAppt);
	}
	
	/**
	 * 释放前校验床位是否被此次就诊使用---急诊抢救
	 * 
	 * @param idEnt
	 * @param idBed
	 * @throws BizException
	 */
	private void validateBedRescue(String idEnt, String idBed) throws BizException{
		if (idEnt == null)
			return;
		IEnentoperRService rService = ServiceFinder.find(IEnentoperRService.class);
		EnEntOpErDO[] ipDos = rService.findByAttrValString(EnEntOpErDO.ID_ENT, idEnt);
		if (EnValidator.isEmpty(ipDos))
			throw new BizException("患者此次急诊信息不存在！");
		if (!idBed.equals(ipDos[0].getId_bed()))
			throw new BizException("患者使用的床位发生变化，请刷新后重试！");
	}

}
