package iih.ci.ord.s.ems.cache;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import iih.bd.base.cache.ContextCache;
import iih.bd.base.define.MmDoseUnitMap;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.mm.itf.material.d.GetStockReqDTO;
import iih.mm.itf.material.d.MaterialStockDTO;
import iih.mm.itf.material.i.IMaterialStockService;
import iih.mm.itf.materialunitdto.d.MaterialUnitDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 物品计量信息缓存工具
 * 
 * @author wangqingzhu
 *
 */
public class BDMmDoseUnitInfoCache {
	public static String BDMmDoseUnitInfoCache_Key = "BDMmDoseUnitInfoCache_Key";
	public static String DefaultContext_ID = "@@@@";

	private static BDMmDoseUnitInfoCache ins = new BDMmDoseUnitInfoCache();

	private BDMmDoseUnitInfoCache() {
	}

	public static MaterialUnitDTO[] getMaterialUnitInfos(String code_entp, String[] szId_mm) throws BizException {
		if (szId_mm == null || szId_mm.length <= 0 || StringUtils.isEmpty(code_entp))
			return null;
		StringBuilder sbFilter = new StringBuilder();
		SqlParam sqlParam = new SqlParam();
		for (String idmm : szId_mm) {
			sqlParam.addParam(idmm);
			sbFilter.append(",?");
		}
		StringBuilder strSql = new StringBuilder();
		strSql.append("select PKGU.Id_mm,PKGU.Id_mmpkgutp,MEAS.Id_measdoc,MEAS.Name Measdoc_name,PKGU.Factor,")
		.append("CAST(MM.price*(PKGU.factor/MM.factor_sb) AS DECIMAL(18,4)) as price ")
		.append("from bd_mm_pkgu PKGU ")
		.append("left join bd_measdoc MEAS on MEAS.Id_measdoc=PKGU.Id_unit_pkg ")
		.append("left join bd_mm MM on MM.Id_mm=PKGU.Id_mm ")
		.append(String.format("where PKGU.Id_mm in (%s)", sbFilter.substring(1)))
		.append(String.format(" and PKGU.%s is not null ", getStrFilter_entp(code_entp)))
		.append(" order by PKGU.id_mm," + getStrFilter_entp(code_entp));
		@SuppressWarnings("unchecked")
		List<MaterialUnitDTO> unitDOs = (List<MaterialUnitDTO>) new DAFacade().execQuery(strSql.toString(), sqlParam, 
				new BeanListHandler(MaterialUnitDTO.class));
		return unitDOs != null && unitDOs.size() > 0 ? unitDOs.toArray(new MaterialUnitDTO[0]) : null;
	}

	public static MmDoseUnitMap GetMmDoseUnitMap(CiEnContextDTO ctx, String[] szId_mm) throws BizException {

		MmDoseUnitMap infoMap = ContextCache.Get(BDMmDoseUnitInfoCache.class.getSimpleName(), ctx.getId_grp(),
				ctx.getId_org(), BDMmDoseUnitInfoCache_Key+ctx.getCode_entp(), Arrays.toString(szId_mm));
		if (infoMap == null) {
			MaterialUnitDTO[] szMaterialUnitInfo = getMaterialUnitInfos(ctx.getCode_entp(), szId_mm);
			if (null != szMaterialUnitInfo) {
				infoMap = new MmDoseUnitMap();
				for (MaterialUnitDTO item : szMaterialUnitInfo) {
					if (!infoMap.containsKey(item.getId_mm())) {
						infoMap.put(item.getId_mm(), new ArrayList<MaterialUnitDTO>());
					}
					infoMap.get(item.getId_mm()).add(item);
				}
				ContextCache.Put(BDMmDoseUnitInfoCache.class.getSimpleName(), ctx.getId_grp(), ctx.getId_org(),
						BDMmDoseUnitInfoCache_Key+ctx.getCode_entp(), Arrays.toString(szId_mm), infoMap);
			}
		}
		return infoMap;
	}

	/**
	 * 获取执行包装单位下的物品固定价格
	 * 
	 * @param id_mm
	 * @param id_pkg_unit
	 * @return
	 * @throws BizException
	 */
	public static FDouble GetPkgPriceOfMaterialBaseInfo(String id_mm, String id_pkg_unit) throws BizException {
		StringBuilder strSql = new StringBuilder();
		strSql.append("select PKGU.Id_mm,CAST(MM.price*(PKGU.factor/MM.factor_sb) AS DECIMAL(18,4)) as price ")
		.append("from bd_mm_pkgu PKGU ")
		.append("left join bd_mm MM on MM.Id_mm=PKGU.Id_mm ")
		.append("where PKGU.Id_mm=? and PKGU.Id_unit_pkg=? ");
		
		SqlParam sqlParam =new SqlParam();
		sqlParam.addParam(id_mm);
		sqlParam.addParam(id_pkg_unit);
		
		@SuppressWarnings("unchecked")
		List<MaterialUnitDTO> unitDTOs = (List<MaterialUnitDTO>) new DAFacade().execQuery(strSql.toString(), sqlParam, 
				new BeanListHandler(MaterialUnitDTO.class));
		return unitDTOs != null && unitDTOs.size() > 0 ? null : unitDTOs.get(0).getPrice();
	}
	
	/**
	 * 获取物品结存价格
	 * @param id_mm
	 * @param id_pkg_unit
	 * @return
	 * @throws BizException
	 */
	public static FDouble GetPkgPriceOfMaterialStockInfo(String id_dep_wh,String id_mm, String id_pkg_unit) throws BizException {
		GetStockReqDTO reqInfo = new GetStockReqDTO();
		reqInfo.setId_dep(id_dep_wh);
		reqInfo.setId_mm(id_mm);
		reqInfo.setReq_unit_id(id_pkg_unit);
		MaterialStockDTO[] szMaterialStockInfo = ServiceFinder.find(IMaterialStockService.class).getMaterialStocks(new GetStockReqDTO[]{reqInfo});
		if(null != szMaterialStockInfo && szMaterialStockInfo.length > 0){
			return szMaterialStockInfo[0].getPrice_sale();
		}
		return null;
	}

	public void Clear() {
		ContextCache.Clear(BDMmDoseUnitInfoCache.class.getSimpleName());
	}
	
	/**
	 * 获取就诊类型条件
	 * @param code_entp
	 * @return
	 */
    private static String getStrFilter_entp(String code_entp) {
        String value = "";
		switch (code_entp) {
		case IBdFcDictCodeConst.SD_CODE_ENTP_OP:
			value = "en_oppkgtp";
			break;
		case IBdFcDictCodeConst.SD_CODE_ENTP_IP:
			value = "en_ippkgtp";
			break;
		case IBdFcDictCodeConst.SD_CODE_ENTP_ET_FLOW:
			value = "en_erpkgtp";
			break;
		case IBdFcDictCodeConst.SD_CODE_ENTP_ET_FSTAID:
			value = "en_er1pkgtp";
			break;
		case IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS:
			value = "en_er2pkgtp";
			break;
		case IBdFcDictCodeConst.SD_CODE_ENTP_PE:
			value = "en_pepkgtp";
			break;
		case IBdFcDictCodeConst.SD_CODE_ENTP_FA:
			value = "en_fmpkgtp";
			break;
		case IBdFcDictCodeConst.SD_CODE_ENTP_IP_PRE:
			value = "en_pippkgtp";
		}

        return value;
    }
}
