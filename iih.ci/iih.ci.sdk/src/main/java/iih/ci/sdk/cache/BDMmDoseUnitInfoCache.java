package iih.ci.sdk.cache;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import iih.bd.base.cache.ContextCache;
import iih.bd.base.define.MmDoseUnitMap;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.mm.meterial.d.MMPackageUnitDO;
import iih.bd.mm.meterial.i.IMMPackageUnitDORService;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.sdk.database.SqlParamBuilder;
import iih.ci.sdk.database.SqlParamDbUtils;
import iih.ci.sdk.utils.ObjectUtils;
import iih.mm.itf.materialunitdto.d.MaterialUnitDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
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

	private MaterialUnitDTO[] getMaterialUnitInfos(String code_entp, String[] szId_mm) throws BizException {
		StringBuilder strSql = new StringBuilder();
		strSql.append("select PKGU.Id_mm,PKGU.Id_mmpkgutp,MEAS.Id_measdoc,MEAS.Name Measdoc_name,PKGU.Factor,")
		.append("CAST(MM.price*(PKGU.factor/MM.factor_sb) AS DECIMAL(18,4)) as price ")
		.append("from bd_mm_pkgu PKGU ")
		.append("left join bd_measdoc MEAS on MEAS.Id_measdoc=PKGU.Id_unit_pkg ")
		.append("left join bd_mm MM on MM.Id_mm=PKGU.Id_mm ");
		
		SqlParamBuilder scp = new SqlParamBuilder(strSql.toString());
		scp.whereIn(" PKGU.Id_mm", szId_mm)
		.appendSql(String.format(" and PKGU.%s is not null ", getStrFilter_entp(code_entp)))
		.appendSql(" order by PKGU.id_mm," + getStrFilter_entp(code_entp));
		List<MaterialUnitDTO> unitDTOs = SqlParamDbUtils.Q(scp, MaterialUnitDTO.class);
		return ObjectUtils.isEmpty(unitDTOs) ? null : unitDTOs.toArray(new MaterialUnitDTO[0]);
	}

	public static MmDoseUnitMap GetMmDoseUnitMap(CiEnContextDTO ctx, String[] szId_mm) throws BizException {
		MmDoseUnitMap infoMap = ContextCache.Get(BDMmDoseUnitInfoCache.class.getSimpleName(),
				ObjectUtils.isEmpty(ctx) ? DefaultContext_ID : ctx.getId_grp(),
				ObjectUtils.isEmpty(ctx) ? DefaultContext_ID : ctx.getId_org(),
				ObjectUtils.isEmpty(ctx) ? BDMmDoseUnitInfoCache_Key : BDMmDoseUnitInfoCache_Key + ctx.getCode_entp(),
				Arrays.toString(szId_mm));
		if (infoMap == null) {
			MaterialUnitDTO[] szMaterialUnitInfo = ins.getMaterialUnitInfos(ctx.getCode_entp(), szId_mm);
			if (null != szMaterialUnitInfo) {
				infoMap = new MmDoseUnitMap();
				for (MaterialUnitDTO item : szMaterialUnitInfo) {
					if (!infoMap.containsKey(item.getId_mm())) {
						infoMap.put(item.getId_mm(), new ArrayList<MaterialUnitDTO>());
					}
					infoMap.get(item.getId_mm()).add(item);
				}
				ContextCache.Put(BDMmDoseUnitInfoCache.class.getSimpleName(), 
						ObjectUtils.isEmpty(ctx) ? DefaultContext_ID : ctx.getId_grp(), 
						ObjectUtils.isEmpty(ctx) ? DefaultContext_ID : ctx.getId_org(),
						ObjectUtils.isEmpty(ctx) ? BDMmDoseUnitInfoCache_Key : BDMmDoseUnitInfoCache_Key + ctx.getCode_entp(), 
						Arrays.toString(szId_mm), infoMap);
			}
		}
		return infoMap;
	}

	/**
	 * 获取执行包装单位下的物品价格
	 * 
	 * @param id_mm
	 * @param id_pkg_unit
	 * @return
	 * @throws BizException
	 */
	public static FDouble GetPkgPriceOfMaterialBaseInfo(String id_mm, String id_pkg_unit) throws BizException {
//		return ServiceFinder.find(IMaterialBaseInfoService.class).getSalePrice(id_mm, id_pkg_unit);
		StringBuilder strSql = new StringBuilder();
		strSql.append("select PKGU.Id_mm,CAST(MM.price*(PKGU.factor/MM.factor_sb) AS DECIMAL(18,4)) as price ")
		.append("from bd_mm_pkgu PKGU ")
		.append("left join bd_mm MM on MM.Id_mm=PKGU.Id_mm ")
		.append("where PKGU.Id_mm=? and PKGU.Id_unit_pkg=? ");
		
		SqlParam sqlParam =new SqlParam();
		sqlParam.addParam(id_mm);
		sqlParam.addParam(id_pkg_unit);
		SqlParamBuilder scp = new SqlParamBuilder(strSql.toString());
		scp.appendParam(sqlParam);
		
		List<MaterialUnitDTO> unitDTOs = SqlParamDbUtils.Q(scp, MaterialUnitDTO.class);
		return ObjectUtils.isEmpty(unitDTOs) ? null : unitDTOs.get(0).getPrice();
	}
	
	/**
	 * 获取
	 * @param id_mm
	 * @param id_pkg_unit
	 * @return
	 * @throws BizException
	 */
	public static FDouble GetPkgFactorOfMaterialBaseInfo(String id_mm, String id_pkg_unit) throws BizException {
		String whereString = String.format(" id_mm = '%s' and id_unit_pkg = '%s' ", id_mm, id_pkg_unit);
		MMPackageUnitDO[] szMMPackageUnit = ServiceFinder.find(IMMPackageUnitDORService.class).find(whereString, "", FBoolean.FALSE);
		if(null != szMMPackageUnit && szMMPackageUnit.length > 0){
			return szMMPackageUnit[0].getFactor();
		}
		return null;
	}

	public void Clear() {
		ContextCache.Clear(BDMmDoseUnitInfoCache.class.getSimpleName());
	}
	
	/**
	 * 获取就诊类型条件
	 * @param sd_entp
	 * @return
	 */
    private static String getStrFilter_entp(String sd_entp) {
        String value = "";
		switch (sd_entp) {
		case IBdFcDictCodeConst.SD_CODE_ENTP_OP:
			value = "en_oppkgtp";
			break;
		case IBdFcDictCodeConst.SD_CODE_ENTP_IP:
			value = "en_ippkgtp";
			break;
		case IBdFcDictCodeConst.SD_CODE_ENTP_ET:
			value = "en_erpkgtp";
			break;
		case IBdFcDictCodeConst.SD_CODE_ENTP_PE:
			value = "en_pepkgtp";
			break;
		case IBdFcDictCodeConst.SD_CODE_ENTP_FA:
			value = "en_fmpkgtp";
			break;
		}

        return value;
    }
}
