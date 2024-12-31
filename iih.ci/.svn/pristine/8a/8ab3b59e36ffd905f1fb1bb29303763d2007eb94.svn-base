package iih.ci.sdk.cache;

import java.util.ArrayList;
import java.util.List;

import iih.bd.base.cache.ContextCache;
import iih.bd.srv.medsrv.d.MedSrvSetItemDO;
import iih.ci.sdk.utils.CiOrdAppUtils;
import iih.ci.sdk.utils.ObjectUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

public class BDSrvSetInfoCache {
	public static String BDSrvSetInfoCache_Key = "BDSrvSetInfoCache_Key";
	public static String DefaultContext_ID = "@@@@";

	private BDSrvSetInfoCache() {
	}
	
	/**
	 * 获取服务套内项目
	 * @param id_srv
	 * @return
	 * @throws BizException
	 */
	public static MedSrvSetItemDO[] GetMedSrvSetItemInfo(String id_srv) throws BizException {
		List<MedSrvSetItemDO> lsSrvSetInfo = ContextCache.Get(BDSrvSetInfoCache.class.getSimpleName(), DefaultContext_ID, DefaultContext_ID, "fg_active='Y'", id_srv) ;
		if(ObjectUtils.isEmpty(lsSrvSetInfo)) {
			MedSrvSetItemDO[] szSrvSetInfo = CiOrdAppUtils.getMedSrvSetItemRService().find(String.format("a8.fg_active='Y' and a8.id_srv='%s'", id_srv), "", FBoolean.FALSE);
			if(!ObjectUtils.isEmpty(szSrvSetInfo)) {
				lsSrvSetInfo = ObjectUtils.asList(szSrvSetInfo);
				ContextCache.Put(BDSrvSetInfoCache.class.getSimpleName(), DefaultContext_ID, DefaultContext_ID, "fg_active='Y'", id_srv, lsSrvSetInfo);
			}
		}
		return ObjectUtils.isEmpty(lsSrvSetInfo)?null:lsSrvSetInfo.toArray(new MedSrvSetItemDO[lsSrvSetInfo.size()]);
	}
	
	/**
	 * 获取临床项目
	 * @param id_srv
	 * @return
	 * @throws BizException
	 */
	public static MedSrvSetItemDO[] GetMedSrvSetItemInfo_YC(String id_srv) throws BizException {
		MedSrvSetItemDO[] szMedSrvSetItemInfo = GetMedSrvSetItemInfo(id_srv);
		if(ObjectUtils.isEmpty(szMedSrvSetItemInfo)) {
			return null;
		}
		
		List<MedSrvSetItemDO> medSrvSetItemList = new ArrayList<MedSrvSetItemDO>() ;
		for(MedSrvSetItemDO item : szMedSrvSetItemInfo) {
			if(ObjectUtils.isTrue(item.getFg_clinical())) {
				medSrvSetItemList.add(item);
			}
		}
		return ObjectUtils.isEmpty(medSrvSetItemList)?null : medSrvSetItemList.toArray(new MedSrvSetItemDO[] {});
	}
	
	/**
	 * 获取非临床项目
	 * @param id_srv
	 * @return
	 * @throws BizException
	 */
	public static MedSrvSetItemDO[] GetMedSrvSetItemInfo_NC(String id_srv) throws BizException {
		MedSrvSetItemDO[] szMedSrvSetItemInfo = GetMedSrvSetItemInfo(id_srv);
		if(ObjectUtils.isEmpty(szMedSrvSetItemInfo)) {
			return null;
		}
		
		List<MedSrvSetItemDO> medSrvSetItemList = new ArrayList<MedSrvSetItemDO>() ;
		for(MedSrvSetItemDO item : szMedSrvSetItemInfo) {
			if(!ObjectUtils.isTrue(item.getFg_clinical())) {
				medSrvSetItemList.add(item);
			}
		}
		return ObjectUtils.isEmpty(medSrvSetItemList)?null : medSrvSetItemList.toArray(new MedSrvSetItemDO[] {});
	}
	
	/**
	 * 查询套内项目
	 * @param mId_srv 服务套Id
	 * @param szId_srv 套内服务id
	 * @return
	 * @throws BizException
	 */
	public static MedSrvSetItemDO[] GetMedSrvSetItemInfo(String id_srv,String[] szId_srv_item) throws BizException {
		MedSrvSetItemDO[] szMedSrvSetItemInfo = GetMedSrvSetItemInfo(id_srv);
		if(ObjectUtils.isEmpty(szMedSrvSetItemInfo) || ObjectUtils.isEmpty(szId_srv_item)) {
			return null;
		}
		String strId_srv_item = ObjectUtils.asString(szId_srv_item);
		List<MedSrvSetItemDO> medSrvSetItemList = new ArrayList<MedSrvSetItemDO>() ;
		for(MedSrvSetItemDO item : szMedSrvSetItemInfo) {
			if(strId_srv_item.contains(item.getId_srv_itm())) {
				medSrvSetItemList.add(item);
			}
		}
		return ObjectUtils.isEmpty(medSrvSetItemList)?null : medSrvSetItemList.toArray(new MedSrvSetItemDO[] {});
	}
	
	/**
	 * 从套内项目中分拣临床项目
	 * 
	 * @param szMedSrvSetItemDO
	 *            套内项目集合
	 * @return 返回临床套内项目集合
	 */
	public static MedSrvSetItemDO[] ClinicalMedSrvSetItemArrayOf(MedSrvSetItemDO[] szMedSrvSetItemDO) {
		List<MedSrvSetItemDO> listMedSrvSetItemDO = new ArrayList<MedSrvSetItemDO>();
		for (MedSrvSetItemDO item : szMedSrvSetItemDO) {
			if (FBoolean.TRUE.equals(item.getFg_active()) && FBoolean.TRUE.equals(item.getFg_clinical())) {
				listMedSrvSetItemDO.add(item);
			}
		}
		return listMedSrvSetItemDO.toArray(new MedSrvSetItemDO[listMedSrvSetItemDO.size()]);
	}

	/**
	 * 从套内项目集合中分拣非临床项目
	 * 
	 * @param szMedSrvSetItemDO
	 * @return 返回非临床套内项目集合
	 */
	public static MedSrvSetItemDO[] NotClinicalMedSrvSetItemArrayOf(MedSrvSetItemDO[] szMedSrvSetItemDO) {
		List<MedSrvSetItemDO> listMedSrvSetItemDO = new ArrayList<MedSrvSetItemDO>();
		for (MedSrvSetItemDO item : szMedSrvSetItemDO) {
			if (FBoolean.TRUE.equals(item.getFg_active()) && !FBoolean.TRUE.equals(item.getFg_clinical())) {
				listMedSrvSetItemDO.add(item);
			}
		}
		return listMedSrvSetItemDO.toArray(new MedSrvSetItemDO[listMedSrvSetItemDO.size()]);
	}
	
	public static void Clear() {
		ContextCache.Clear(BDSrvSetInfoCache.class.getSimpleName());
	}
}
