package iih.en.comm.ep;

import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnLogUtil;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.enres.d.EnBedDO;
import iih.en.pv.enres.d.desc.EnBedDODesc;
import iih.en.pv.enres.i.IEnbedCudService;
import iih.en.pv.enres.i.IEnbedRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 就诊床位EP
 * @author yankan
 *
 */
public class EntBedEP {
	/**
	 * 使用床位(单个)
	 * @param entId 就诊id
	 * @param bedId 床位id
	 * @param bedName 床号
	 * @param nurId 科室ID
	 * @param dt_begin 开始时间
	 * @throws BizException
	 */
	public EnBedDO useBed(String entId,String bedId,String bedName,String nurId,FDateTime dt_begin) throws BizException{
		EnBedDO enbedDO = new EnBedDO();
		enbedDO.setId_ent(entId);
		enbedDO.setId_bed(bedId);
		enbedDO.setName_bed(bedName);
		enbedDO.setId_dep_wrd(nurId);//科室ID
		enbedDO.setDt_b(dt_begin);
		enbedDO.setDt_chg_bill(dt_begin);
		enbedDO.setId_usetype(IEnDictCodeConst.ID_USETYPE_MAIN);//主床ID
		enbedDO.setSd_usetype(IEnDictCodeConst.SD_USETYPE_MAIN);//主床编码
		enbedDO.setStatus(DOStatus.NEW);
		enbedDO = this.save(new EnBedDO[]{enbedDO});
		return enbedDO;
	}
	/**
	 * 结束使用床位(单个)
	 * @param entId 就诊id
	 * @param endTime 结束时间
	 * @throws BizException
	 */
	public EnBedDO endUseBed(String entId,FDateTime endTime) throws BizException {
		// 更新旧记录
		EnBedDO[] enbeddos = this.getUsingBedList(entId);
		endTime = endTime==null ? EnAppUtils.getServerDateTime() : endTime;
		if (!EnValidator.isEmpty(enbeddos)) {
			for (EnBedDO bedDO : enbeddos) {
				bedDO.setDt_e(endTime);// 结束日期
				bedDO.setStatus(DOStatus.UPDATED);
			}
			return this.save(enbeddos);
		}
		return null;
	}
	
	/**
	 * 结束使用床位
	 * @param entId 就诊id
	 * @param bedId 床位id
	 * @param dateTime 时间
	 * @throws BizException
	 */
	public void endUseBed(String entId,String bedId,FDateTime dateTime) throws BizException{
		EnBedDO oriDO = this.getUsingBed(entId, bedId);
		if(oriDO!=null){
			oriDO.setStatus(DOStatus.UPDATED);
			oriDO.setDt_e(dateTime);//结束日期
			getCudServ().save(new EnBedDO[]{(oriDO)});
		}
	}
	/**
	 * 包床
	 * @param entId 就诊ID
	 * @param bedId 床位ID
	 * @param bedName 床号
	 * @param nurId 使用病区ID
	 * @param dt_begin 开始时间
	 * @throws BizException
	 */
	public EnBedDO rentBed(String entId,String bedId,String bedName,String nurId,FDateTime dt_begin) throws BizException{
		EnBedDO enbedDO = new EnBedDO();
		enbedDO.setId_ent(entId);
		enbedDO.setId_bed(bedId);
		enbedDO.setName_bed(bedName);
		enbedDO.setId_dep_wrd(nurId);//科室ID
		enbedDO.setDt_b(dt_begin);
		enbedDO.setDt_e(null);
		enbedDO.setSd_usetype(IEnDictCodeConst.SD_USETYPE_SUB);//包床
		enbedDO.setId_usetype(IEnDictCodeConst.ID_USETYPE_SUB);//包床
		enbedDO.setUsetype_name("包床");
		enbedDO.setStatus(DOStatus.NEW);
		enbedDO = this.save(new EnBedDO[]{enbedDO});
		return enbedDO;
	}
	/**
	 * 获取当前使用的床位集合
	 * @param entId 就诊ID
	 * @return
	 * @throws BizException
	 */
	public EnBedDO[] getUsingBedList(String entId) throws BizException{
		String whereStr = String.format("%s.id_ent= '%s' AND %s.dt_e is null   ", 
								EnBedDODesc.TABLE_ALIAS_NAME,entId,EnBedDODesc.TABLE_ALIAS_NAME);
		String orderStr = "DT_B DESC"; //按使用开始时间倒序排列
		EnBedDO[] oriDOs = getRServ().find(whereStr,orderStr,FBoolean.FALSE);
		return oriDOs;
	}
	/**
	 * 获取当前包床集合
	 * @param entId 就诊ID
	 * @return
	 * @throws BizException
	 */
	public EnBedDO[] getRentingBedList(String entId) throws BizException{		
		String whereStr = String.format("%s.id_ent= '%s' AND %s.dt_e is null AND %s.sd_usetype='1' ", 
								EnBedDODesc.TABLE_ALIAS_NAME,entId,EnBedDODesc.TABLE_ALIAS_NAME,EnBedDODesc.TABLE_ALIAS_NAME);
		String orderStr = "DT_B DESC"; //按使用开始时间倒序排列
		EnBedDO[] oriDOs = getRServ().find(whereStr,orderStr,FBoolean.FALSE);
		return oriDOs;
	}
	/**
	 * 获取当前使用床位
	 * @param entId 就诊ID
	 * @param bedId 床位ID
	 * @return
	 * @throws BizException
	 */
	public EnBedDO getUsingBed(String entId,String bedId) throws BizException{
		String whereStr = String.format("%s.id_ent= '%s' and %s.id_bed='%s' AND %s.dt_e is null   ", 
							EnBedDODesc.TABLE_ALIAS_NAME,entId,EnBedDODesc.TABLE_ALIAS_NAME,bedId,EnBedDODesc.TABLE_ALIAS_NAME);
		EnBedDO[] oriDOs = getRServ().find(whereStr,"",FBoolean.FALSE);
		if(EnValidator.isEmpty(oriDOs))return null;
		return oriDOs[0];
	}	
	/**
	 * 获取床位使用记录
	 * @param entId 患者id
	 * @return
	 * @throws BizException
	 */
	public EnBedDO[] getUsedBedList(String entId) throws BizException{
		String whereStr = String.format("ID_ENT='%s'",entId);
		String orderStr = "DT_B DESC"; //按使用开始时间倒序排列
		EnBedDO[] enBedDOArray = getRServ().find(whereStr, orderStr, FBoolean.FALSE);		
		return enBedDOArray;
	}
	/**
	 * 换床(不带新生儿)
	 * @param entId 就诊ID
	 * @param bedId 床位ID
	 * @param bedName 床号
	 * @param depId 使用科室或病区ID
	 * @param time 发生时间
	 * @throws BizException
	 */
	public void changeToBed(String entId,String bedId,String bedName,String depId,FDateTime time) throws BizException{
		EnValidator.validateParam("就诊ID", entId);
		EnValidator.validateParam("床位ID", bedId);
		//更新旧记录
		EnLogUtil.getInstance().logError("修改就诊床位过程表-----更新旧记录");
		EnBedDO enBedDO = new EnBedDO();
		enBedDO = this.endUseBed(entId,time);
		EnLogUtil.getInstance().logError("更新完成，床号：" + enBedDO.getBed_name() + ",病区：" + enBedDO.getId_dep_wrd() + "就诊id_ent:" + enBedDO.getId_ent());
		
		//新增记录	
		enBedDO = new EnBedDO();
		EnLogUtil.getInstance().logError("修改就诊床位过程表-----新增记录");
		enBedDO = this.useBed(entId, bedId, bedName,depId, time);
		EnLogUtil.getInstance().logError("新增完成，床号：" + enBedDO.getBed_name() + ",病区：" + enBedDO.getId_dep_wrd() + "就诊id_ent:" + enBedDO.getId_ent());
	}	
	
	/**
	 * 保存就诊床位
	 * @param enBedDOs 就诊床位信息
	 * @throws BizException
	 */
	public EnBedDO save(EnBedDO[] enBedDOs) throws BizException{
		enBedDOs = getCudServ().save(enBedDOs);	
		return enBedDOs[0];
	}
	/**
	 * 删除
	 * 
	 * @param entIds
	 * @throws BizException
	 */
	public void deleteEnBedByEntIds(String[] entIds) throws BizException{
		EnBedDO[] beds = getRServ().findByAttrValStrings(EnBedDO.ID_ENT, entIds);
		if(EnValidator.isEmpty(beds))
			return;
		getCudServ().delete(beds);
	}
	/**
	 * 根据就诊id获取EnBedDO集合
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	public EnBedDO[] getByEntId(String entId) throws BizException {
		return getRServ().findByAttrValString(EnBedDO.ID_ENT, entId);
	}
	
	/**
	 * 保存
	 * 
	 * @param empArray
	 *            人员对象集合
	 * @throws BizException
	 */
	public EnBedDO[] saveBeds(EnBedDO[] beds) throws BizException {
		return getCudServ().save(beds);
	}
	/**
	 * 获取查询服务
	 * 
	 * @return
	 */
	public IEnbedRService getRServ(){
		return ServiceFinder.find(IEnbedRService.class);
	}
	/**
	 * 获取操作服务
	 * 
	 * @return
	 */
	public IEnbedCudService getCudServ(){
		return ServiceFinder.find(IEnbedCudService.class);
	}
}
