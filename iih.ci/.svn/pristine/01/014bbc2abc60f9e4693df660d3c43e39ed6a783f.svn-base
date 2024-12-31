package iih.ci.sdk.ems.meta;

import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.mm.meterial.i.IMeterialMDORService;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvDrugDO;
import iih.bd.srv.medsrv.d.MedSrvRelMmDTO;
import iih.bd.srv.medsrv.d.MedSrvSetItemDO;
import iih.bd.srv.medsrv.i.IMedSrvDrugDORService;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import iih.ci.sdk.cache.BDMeterialInfoCache;
import iih.ci.sdk.cache.BDSrvDrugInfoCache;
import iih.ci.sdk.cache.BDSrvInfoCache;
import iih.ci.sdk.cache.BDSrvRelMmInfoCache;
import iih.ci.sdk.utils.CiOrdAppUtils;
import iih.ci.sdk.utils.ObjectUtils;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
/**
 * 基础数据服务物品对象
 * @author wangqingzhu
 *
 */
public class BdSrvMmInfo {
	
	private MedSrvDO bdSrvInfo;
	
	private MedSrvSetItemDO bdSrvSetItemInfo;

	private MedSrvDrugDO srvDrugInfo;
	
	private MeterialDO mmInfo;
	
	private Object uiModel;
	
	
	public BdSrvMmInfo(){}
	
	
	public BdSrvMmInfo(Object uiModel){
		
		this.uiModel = uiModel;
	}
	
	/**
	 * 套内项目使用的构造方法
	 * @param bdSrvInfo
	 * @param srvSetItemInfo
	 */
	public BdSrvMmInfo(MedSrvDO bdSrvInfo, MedSrvSetItemDO srvSetItemInfo,Object uiModel){
		this.bdSrvInfo = bdSrvInfo;
		this.bdSrvSetItemInfo = srvSetItemInfo;
		this.uiModel = uiModel;
	}
	
	
	
	public BdSrvMmInfo(MedSrvDO bdSrvInfo,Object uiModel){
		this.bdSrvInfo = bdSrvInfo;
		this.uiModel = uiModel;
	}
	
	public BdSrvMmInfo(MedSrvDO bdSrvInfo){
		this.bdSrvInfo = bdSrvInfo;
		
	}
	
	public BdSrvMmInfo(MeterialDO mmInfo){
		this.mmInfo = mmInfo;
	
	}
	
	public BdSrvMmInfo(MedSrvDO bdSrvInfo,MeterialDO mmInfo){
		this.bdSrvInfo = bdSrvInfo;
		this.mmInfo = mmInfo;
		
	}
	
	public MedSrvDO getBdSrvInfo() {
		return bdSrvInfo;
	}
	public void setBdSrvInfo(MedSrvDO bdSrvInfo) {
		this.bdSrvInfo = bdSrvInfo;
	}
	
	

	public MedSrvSetItemDO getBdSrvSetItemInfo() {
		return bdSrvSetItemInfo;
	}


	public void setBdSrvSetItemInfo(MedSrvSetItemDO bdSrvSetItemInfo) {
		this.bdSrvSetItemInfo = bdSrvSetItemInfo;
	}


	public MeterialDO getMmInfo() {
		return mmInfo;
	}
	
	public void setMmInfo(MeterialDO mmInfo) {
		this.mmInfo = mmInfo;
	}
	
	public MedSrvDrugDO getSrvDrugInfo() {
		return srvDrugInfo;
	}

	public void setSrvDrugInfo(MedSrvDrugDO srvDrugInfo) {
		this.srvDrugInfo = srvDrugInfo;
	}

	public Object getUiModel() {
		return uiModel;
	}

	public void setUiModel(Object uiModel) {
		this.uiModel = uiModel;
	}

	/**
	 * 创建物品信息
	 * @param srvInfo 诊疗项目
	 * @param id_org 当前组织
	 * @param id_dep_or 当前科室
	 * @return 是否成功
	 * @throws BizException
	 */
	public boolean createSrvMmInfo(String id_org, String id_dep_or) throws BizException{
		if (null == bdSrvInfo){
			return false;
		}
		
		MedSrvRelMmDTO[] srvrelmmdos = BDSrvRelMmInfoCache.GetSrvRelMmInfos(id_dep_or, bdSrvInfo.getId_srv());//CiOrdAppUtils.getBdSrvQryQryService().getMedSrvRelMmDept(bdSrvInfo.getId_srv(), id_dep_or);
		if (!ObjectUtils.isEmpty(srvrelmmdos)){
			this.mmInfo = BDMeterialInfoCache.GetMeterialInfo(null, srvrelmmdos[0].getId_mm());// ServiceFinder.find(IMeterialMDORService.class).findById(srvrelmmdos[0].getId_mm());
			 MedSrvDrugDO medSrvDrugDO = BDSrvDrugInfoCache.GetBdSrvDrugInfo(null, bdSrvInfo.getId_srv());// ServiceFinder.find(IMedSrvDrugDORService.class).findByAttrValString(MedSrvDrugDO.ID_SRV, bdSrvInfo.getId_srv());
			 assert !ObjectUtils.isEmpty(medSrvDrugDO) : String.format("【%s】服务药品属性为空", bdSrvInfo.getName());
			 if (!ObjectUtils.isEmpty(medSrvDrugDO)){
				 this.srvDrugInfo = medSrvDrugDO;
			 }
		}
		return true;
	}
	
	/**
	 * 创建物品信息
	 * @param srvInfo 诊疗项目
	 * @param id_org 当前组织
	 * @param id_dep_or 当前科室
	 * @return 是否成功
	 * @throws BizException
	 */
	public boolean createSrvMmInfo(MedSrvDO srvInfo, String id_org, String id_dep_or) throws BizException{
		if (null == srvInfo){
			return false;
		}
		this.bdSrvInfo = srvInfo;
		MedSrvRelMmDTO[] srvrelmmdos = BDSrvRelMmInfoCache.GetSrvRelMmInfos(id_dep_or, bdSrvInfo.getId_srv());// CiOrdAppUtils.getBdSrvQryQryService().getMedSrvRelMmDept(bdSrvInfo.getId_srv(), id_dep_or);
		if (!ObjectUtils.isEmpty(srvrelmmdos) && ObjectUtils.isTrue(srvInfo.getFg_mm())){
			this.mmInfo = BDMeterialInfoCache.GetMeterialInfo(null, srvrelmmdos[0].getId_mm());// ServiceFinder.find(IMeterialMDORService.class).findById(srvrelmmdos[0].getId_mm());
			 MedSrvDrugDO medSrvDrugDO = BDSrvDrugInfoCache.GetBdSrvDrugInfo(null, bdSrvInfo.getId_srv());// ServiceFinder.find(IMedSrvDrugDORService.class).findByAttrValString(MedSrvDrugDO.ID_SRV, bdSrvInfo.getId_srv());
			 assert !ObjectUtils.isEmpty(medSrvDrugDO) : String.format("【%s】服务药品属性为空", bdSrvInfo.getName());
			 if (!ObjectUtils.isEmpty(medSrvDrugDO)){
				 this.srvDrugInfo = medSrvDrugDO;
			 }
		}
		return true;
	}
	
	/**
	 * 创建物品信息（默认关联物品）
	 * @param id_srv 诊疗项目ID
	 * @param id_org 当前组织
	 * @param id_dep_or 当前科室
	 * @return 是否成功
	 * @throws BizException
	 */
	public boolean createSrvMmInfo(String id_srv, String id_org, String id_dep_or) throws BizException{
		if (null == id_srv){
			return false;
		}
		this.bdSrvInfo = BDSrvInfoCache.GetBdSrvInfo(null, id_srv);// ServiceFinder.find(IMedsrvMDORService.class).findById(id_srv);
		
		return createSrvMmInfo(this.bdSrvInfo, id_org, id_dep_or);
	}
	/**
	 * 创建物品信息
	 * @param id_srv 诊疗项目服务ID
	 * @param id_mm 物品ID
	 * @param id_org 当前组织
	 * @param id_dep_or 当前科室
	 * @return
	 * @throws BizException
	 */
	public boolean createSrvMmInfo(String id_srv,String id_mm, String id_org, String id_dep_or) throws BizException{
		if (ObjectUtils.isEmpty(id_srv)||ObjectUtils.isEmpty(id_mm)){
			return false;
		}
		this.bdSrvInfo = BDSrvInfoCache.GetBdSrvInfo(null, id_srv);// ServiceFinder.find(IMedsrvMDORService.class).findById(id_srv);
		
		this.mmInfo = BDMeterialInfoCache.GetMeterialInfo(null, id_mm);// ServiceFinder.find(IMeterialMDORService.class).findById(id_mm);
		
		MedSrvDrugDO medSrvDrugDO = BDSrvDrugInfoCache.GetBdSrvDrugInfo(null, bdSrvInfo.getId_srv());// ServiceFinder.find(IMedSrvDrugDORService.class).findByAttrValString(MedSrvDrugDO.ID_SRV, bdSrvInfo.getId_srv());
		 assert !ObjectUtils.isEmpty(medSrvDrugDO) : String.format("【%s】服务药品属性为空", bdSrvInfo.getName());
		 if (!ObjectUtils.isEmpty(medSrvDrugDO)){
			 this.srvDrugInfo = medSrvDrugDO;
		 }
		
		return true;
	}
	/**
	 * 是否为医疗服务物品
	 * @return
	 */
	public boolean isMm(){
		return this.getMmInfo() != null && ObjectUtils.isTrue( this.getBdSrvInfo().getFg_mm() );
	}
}
