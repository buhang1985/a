package iih.bd.pp.hp.s.bp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import org.apache.commons.lang.StringUtils;

import iih.bd.pp.hp.d.BdHpUnlimitDrugDO;
import iih.bd.pp.hp.i.IBdHpUnlimitDrugDORService;
import iih.bd.pp.hpsrvorca.d.HPSrvorcaDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 医保计划不限量药品分页查询bp
 * 
 * @author guoyang
 *
 */
public class FindUnLimitDrugByPageInfoBp {

	public PagingRtnData<BdHpUnlimitDrugDO> exec(PaginationInfo pg, String wherePart, String orderByPart)
			throws BizException {
		return findUnLimitDrug(pg, wherePart, orderByPart);
	}

	/**
	 * 获取医保计划不限量药品分页数据
	 * 
	 * @param pg
	 * @param wherePart
	 * @param orderByPart
	 * @return
	 * @throws BizException
	 */
	private PagingRtnData<BdHpUnlimitDrugDO> findUnLimitDrug(PaginationInfo pg, String wherePart, String orderByPart)
			throws BizException {
		IBdHpUnlimitDrugDORService bdHpUnlimitDrugDORService = ServiceFinder.find(IBdHpUnlimitDrugDORService.class);
		PagingRtnData<BdHpUnlimitDrugDO> result = bdHpUnlimitDrugDORService.findByPageInfo(pg, wherePart, orderByPart);

		SetMedI(result);
		return result;
	}

	/**
	 * 设置医保信息
	 * 
	 * @param result
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private void SetMedI(PagingRtnData<BdHpUnlimitDrugDO> result) throws BizException {
		FArrayList pageDataList = result.getPageData();
		if (pageDataList != null && pageDataList.size() > 0) {
			SetMedI((BdHpUnlimitDrugDO[]) pageDataList.toArray(new BdHpUnlimitDrugDO[0]));
		}
	}

	/**
	 * 设置医保信息
	 * 
	 * @param pageDatas
	 * @throws BizException
	 */
	private void SetMedI(BdHpUnlimitDrugDO[] pageDatas) throws BizException {
		if (pageDatas == null || pageDatas.length <= 0) {
			return;
		}
		HashMap<String, HPSrvorcaDO> medIMap = GetMedIMap(pageDatas);
		if (medIMap == null || medIMap.size() <= 0) {
			return;
		}
		for (BdHpUnlimitDrugDO bdHpUnlimitDrugDO : pageDatas) {
			String medICode = bdHpUnlimitDrugDO.getCode_hp();
			if (medIMap.containsKey(medICode)) {
				HPSrvorcaDO hpSrvorcaDO = medIMap.get(medICode);
				bdHpUnlimitDrugDO.setName_hp(hpSrvorcaDO.getName());
			}
		}
	}

	/**
	 * 获取医保信息字典
	 * 
	 * @param pageDatas
	 * @return
	 * @throws BizException
	 */
	private HashMap<String, HPSrvorcaDO> GetMedIMap(BdHpUnlimitDrugDO[] pageDatas) throws BizException {
		String[] medICodes = GetMedICodes(pageDatas);
		HashMap<String, HPSrvorcaDO> medIMap = GetMedIMap(medICodes);
		return medIMap;
	}

	/**
	 * 获取医保编码集合
	 * 
	 * @param pageDatas
	 * @return
	 */
	private String[] GetMedICodes(BdHpUnlimitDrugDO[] pageDatas) {
		ArrayList<String> medICodes = new ArrayList<String>();
		for (BdHpUnlimitDrugDO bdHpUnlimitDrugDO : pageDatas) {
			String medICode = bdHpUnlimitDrugDO.getCode_hp();
			if (StringUtils.isNotEmpty(medICode)) {
				medICodes.add(medICode);
			}
		}
		return medICodes.toArray(new String[0]);
	}

	/**
	 * 获取医保信息字典
	 * 
	 * @param pageDatas
	 * @return
	 * @throws BizException
	 */
	private HashMap<String, HPSrvorcaDO> GetMedIMap(String[] medICodes) throws BizException {
		HPSrvorcaDO[] medIDatas = GetMedIDataByCodes(medICodes);
		HashMap<String, HPSrvorcaDO> medIMap = BuildMedIMap(medIDatas);
		return medIMap;
	}

	/**
	 * 根据医保编码集合获取医保信息
	 * 
	 * @param medICodes
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private HPSrvorcaDO[] GetMedIDataByCodes(String[] medICodes) throws BizException {
		DAFacade daFacade = new DAFacade();
		Collection result = daFacade.findByAttrValStrings(HPSrvorcaDO.class, HPSrvorcaDO.CODE, medICodes,
				new String[] { HPSrvorcaDO.CODE, HPSrvorcaDO.NAME });
		HPSrvorcaDO[] medIDatas = result == null ? null : (HPSrvorcaDO[]) result.toArray(new HPSrvorcaDO[0]);
		return medIDatas;
	}

	/**
	 * 构建医保字典
	 * 
	 * @param medIDatas
	 * @return
	 */
	private HashMap<String, HPSrvorcaDO> BuildMedIMap(HPSrvorcaDO[] medIDatas) {
		HashMap<String, HPSrvorcaDO> medIMap = new HashMap<String, HPSrvorcaDO>();
		if (medIDatas != null && medIDatas.length > 0) {
			for (HPSrvorcaDO hpSrvorcaDO : medIDatas) {
				if (!medIMap.containsKey(hpSrvorcaDO.getCode())) {
					medIMap.put(hpSrvorcaDO.getCode(), hpSrvorcaDO);
				}
			}
		}
		return medIMap;
	}
}
