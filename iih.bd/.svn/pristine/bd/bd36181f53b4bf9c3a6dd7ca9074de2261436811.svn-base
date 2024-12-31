package iih.bd.mm.dataimpt;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import iih.bd.base.utils.DoUtils;
import iih.bd.bc.param.IBdMmParamValueConst;
import iih.bd.bc.udi.pub.IBdMmDictCodeConst;
import iih.bd.bc.udi.pub.IBdMmDictCodeTypeConst;
import iih.bd.dataimport.BDBaseDataImport;
import iih.bd.mm.meterial.d.MMPackageUnitDO;
import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.mm.meterial.i.IMMPackageUnitDOCudService;
import iih.bd.mm.meterial.i.IMMPackageUnitDORService;
import iih.bd.mm.meterial.i.IMeterialMDOCudService;
import iih.bd.mm.meterial.i.ds.IMeterialService;
import iih.bd.mm.mmcategory.d.MMCategoryDO;
import iih.bd.mm.packageunit.d.PackageUnitDO;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.utils.BdMmParamUtils;
import iih.bd.utils.UdidocUtils;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FBinary;
import xap.mw.core.data.binary.BinaryBuilder;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.xbd.measdoc.d.MeasDocDO;
import xap.sys.xbd.udi.d.UdidocDO;

/**
 * 物品基本信息数据导入服务实现
 * 
 * @author hao_wu 2019-12-17 迭代导入类，支持更新包装单位
 *
 */
public class MmDataImptServiceImpl extends BDBaseDataImport<MeterialDO> {

	public final static String PaddingString = "    ";
	public final static String OffsetString = "  ";
	public final static String NextLineString = "\n";

	/**
	 * 包装单位类型字典<br/>
	 * 使用getPkgUnitTypeByCode访问
	 */
	private HashMap<String, PackageUnitDO> _pkgUnitTypeMap;
	/**
	 * 计量单位字典<br/>
	 * 使用getMeasdocById访问
	 */
	private HashMap<String, MeasDocDO> _measdocMap;

	/**
	 * 药品包装单位性质字典<br/>
	 * 使用getMmPkguProByCode访问
	 */
	private Map<String, UdidocDO> _mmPkguProMap;

	@Override
	protected void checkImportData(MeterialDO[] importDatas) throws BizException {
		checkValue(importDatas);
	}

	@Override
	protected String[] getCheckNullProps() {
		return new String[] { MeterialDO.ID_MM, MeterialDO.NAME, MeterialDO.CODE, MeterialDO.ID_SRV, MeterialDO.ID_MMCA,
				MeterialDO.ID_MMTP, MeterialDO.SD_MMTP, MeterialDO.ID_MUPKGUTP, MeterialDO.SD_MUPKGUTP,
				MeterialDO.ID_OPMUTP, MeterialDO.SD_OPMUTP, MeterialDO.ID_UNIT_PKGBASE, MeterialDO.ID_UNIT_PKGSP,
				MeterialDO.FACTOR_SB, MeterialDO.SPEC, MeterialDO.FG_SKIN, MeterialDO.FG_PAT, MeterialDO.FG_ACTIVE,
				MeterialDO.FG_OTC, MeterialDO.ID_PAP, MeterialDO.SD_PAP, MeterialDO.FACTOR_MB };
	}

	@Override
	protected BaseDO getDoInstance() {
		return new MeterialDO();
	}

	@Override
	protected void insertToDB(MeterialDO[] importDatas) throws BizException {
		MeterialDO[] result = ServiceFinder.find(IMeterialMDOCudService.class).insert(importDatas);

		// 生成包装单位集表数据
		initMmPkguData(result);
	}

	@Override
	protected void updateToDB(MeterialDO[] importDatas) throws BizException {
		MeterialDO[] result = ServiceFinder.find(IMeterialMDOCudService.class).update(importDatas);

		// 更新包装单位集表数据
		updateMmPkguData(result);
	}

	private void updateMmPkguData(MeterialDO[] meterialDOs) throws BizException {
		HashMap<String, MMPackageUnitDO> mmPkguMap = getMmPkguMap(meterialDOs);

		ArrayList<MMPackageUnitDO> mmPkguList = new ArrayList<>();
		for (MeterialDO meterialDO : meterialDOs) {
			// 基本单位
			String mmPkguMapKey = getMmPkguMapKey(meterialDO.getId_mm(), IBdMmDictCodeConst.SD_MMPKGUPRO_BASE);
			if (!mmPkguMap.containsKey(mmPkguMapKey)) {
				MMPackageUnitDO mmBasePkgu = createMmPkgu(meterialDO, IBdMmDictCodeConst.SD_MMPKGUPRO_BASE);
				mmPkguList.add(mmBasePkgu);
			} else {
				MMPackageUnitDO mmBasePkgu = mmPkguMap.get(mmPkguMapKey);
				if (!mmBasePkgu.getId_unit_pkg().equals(meterialDO.getId_unit_pkgbase())) {
					mmBasePkgu.setId_mmpkgu(meterialDO.getId_unit_pkgbase());
					mmBasePkgu.setStatus(DOStatus.UPDATED);
					mmPkguList.add(mmBasePkgu);
				}
			}

			// 零售单位
			mmPkguMapKey = getMmPkguMapKey(meterialDO.getId_mm(), IBdMmDictCodeConst.SD_MMPKGUPRO_SELL);
			if (!mmPkguMap.containsKey(mmPkguMapKey)) {
				MMPackageUnitDO mmBasePkgu = createMmPkgu(meterialDO, IBdMmDictCodeConst.SD_MMPKGUPRO_SELL);
				mmPkguList.add(mmBasePkgu);
			} else {
				MMPackageUnitDO mmSpPkgu = mmPkguMap.get(mmPkguMapKey);
				if (!mmSpPkgu.getId_unit_pkg().equals(meterialDO.getId_unit_pkgsp())
						|| mmSpPkgu.getFactor().equals(meterialDO.getFactor_sb())) {
					mmSpPkgu.setId_mmpkgu(meterialDO.getId_unit_pkgsp());
					mmSpPkgu.setFactor(meterialDO.getFactor_sb());
					mmSpPkgu.setStatus(DOStatus.UPDATED);
					mmPkguList.add(mmSpPkgu);
				}
			}
		}
	}

	/**
	 * 创建包装单位
	 * 
	 * @param meterialDO
	 * @param sdMmpkgupro
	 * @return
	 * @throws BizException
	 */
	private MMPackageUnitDO createMmPkgu(MeterialDO meterialDO, String sdMmpkgupro) throws BizException {
		MMPackageUnitDO pkgUnitDO = new MMPackageUnitDO();
		pkgUnitDO.setStatus(DOStatus.NEW);
		pkgUnitDO.setId_mm(meterialDO.getId_mm());

		// 包装单位性质
		UdidocDO mmPkguProDo = this.getMmPkguProByCode(sdMmpkgupro);
		pkgUnitDO.setId_mmpkgupro(mmPkguProDo.getId_udidoc());
		pkgUnitDO.setSd_mmpkgupro(mmPkguProDo.getCode());

		// 包装单位类型
		String pkgutpCode = this.getPkgUnitTypeCodeByPkguProCode(sdMmpkgupro);
		PackageUnitDO pkgUnitType = this.getPkgUnitTypeByCode(pkgutpCode);
		pkgUnitDO.setId_mmpkgutp(pkgUnitType.getId_mmpkgutp());
		pkgUnitDO.setMmpkgutp_name(pkgUnitType.getName());
		pkgUnitDO.setEn_ippkgtp(pkgUnitType.getEn_ippkgtp());
		pkgUnitDO.setEn_oppkgtp(pkgUnitType.getEn_oppkgtp());
		pkgUnitDO.setEn_erpkgtp(pkgUnitType.getEn_erpkgtp());
		pkgUnitDO.setEn_pepkgtp(pkgUnitType.getEn_pepkgtp());
		pkgUnitDO.setEn_fmpkgtp(pkgUnitType.getEn_fmpkgtp());

		// 包装单位
		MeasDocDO unitPkg = null;
		if (sdMmpkgupro.equals(IBdMmDictCodeConst.SD_MMPKGUPRO_BASE)) {
			unitPkg = this.getMeasdocById(meterialDO.getId_unit_pkgbase());
			pkgUnitDO.setFactor(new FDouble(1));
		} else if (sdMmpkgupro.equals(IBdMmDictCodeConst.SD_MMPKGUPRO_SELL)) {
			unitPkg = this.getMeasdocById(meterialDO.getId_unit_pkgsp());
			pkgUnitDO.setFactor(meterialDO.getFactor_sb());
		} else {
			String msg = String.format("不支持的包装单位性质，【%s】。", sdMmpkgupro);
			throw new BizException(msg);
		}
		pkgUnitDO.setId_unit_pkg(unitPkg.getId_measdoc());
		pkgUnitDO.setUnit_pkg_name(unitPkg.getName());
		pkgUnitDO.setMmpkguname(unitPkg.getName());

		return pkgUnitDO;
	}

	/**
	 * 根据包装单位性质编码获取包装单位性质信息
	 * 
	 * @param sdMmpkgupro 包装单位性质编码
	 * @return
	 * @throws BizException
	 */
	private UdidocDO getMmPkguProByCode(String sdMmpkgupro) throws BizException {
		if (this._mmPkguProMap == null) {
			this._mmPkguProMap = new HashMap<>();
			UdidocDO[] result = UdidocUtils.getUdidocByTpCode(IBdMmDictCodeTypeConst.SD_MMPKKGUPRO);
			if (ArrayUtils.isNotEmpty(result)) {
				for (UdidocDO udidocDO : result) {
					this._mmPkguProMap.put(udidocDO.getCode(), udidocDO);
				}
			}
		}

		if (!this._mmPkguProMap.containsKey(sdMmpkgupro)) {
			String msg = String.format("根据编码查询不到包装单位性质信息，【%s】。", sdMmpkgupro);
			throw new BizException(msg);
		}
		return this._mmPkguProMap.get(sdMmpkgupro);
	}

	/**
	 * 根据包装单位性质编码获取包装单位类型编码
	 * 
	 * @param sdMmpkgupro
	 * @return
	 * @throws BizException
	 */
	private String getPkgUnitTypeCodeByPkguProCode(String sdMmpkgupro) throws BizException {
		if (IBdMmDictCodeConst.SD_MMPKGUPRO_BASE.equals(sdMmpkgupro)) {
			return IBdMmDictCodeConst.MM_PKGUNIT_TYPE_BASE;
		}
		if (IBdMmDictCodeConst.SD_MMPKGUPRO_SELL.equals(sdMmpkgupro)) {
			return IBdMmDictCodeConst.MM_PKGUNIT_TYPE_SELL;
		}
		String msg = String.format("不支持的包装单位性质，【%s】。", sdMmpkgupro);
		throw new BizException(msg);
	}

	/**
	 * 获取物品包装单位集字典<br/>
	 * 使用getMmPkguMapKey生成Key
	 * 
	 * @param result
	 * @return
	 * @throws BizException
	 */
	private HashMap<String, MMPackageUnitDO> getMmPkguMap(MeterialDO[] meterialDOs) throws BizException {
		String[] mmIds = DoUtils.getAttrValArr(meterialDOs, MeterialDO.ID_MM, String.class);

		HashMap<String, MMPackageUnitDO> map = new HashMap<String, MMPackageUnitDO>();
		if (ArrayUtils.isEmpty(mmIds)) {
			return map;
		}

		IMMPackageUnitDORService unitDORService = ServiceFinder.find(IMMPackageUnitDORService.class);
		MMPackageUnitDO[] mmPkguDos = unitDORService.findByAttrValStrings(MMPackageUnitDO.ID_MM, mmIds);
		if (ArrayUtils.isEmpty(mmPkguDos)) {
			return map;
		}

		for (MMPackageUnitDO mmPackageUnitDO : mmPkguDos) {
			String mmPkguMapKey = getMmPkguMapKey(mmPackageUnitDO);
			map.put(mmPkguMapKey, mmPackageUnitDO);
		}
		return map;
	}

	/**
	 * 获取物品包装单位集字典Key
	 * 
	 * @param mmPackageUnitDO
	 * @return
	 */
	private String getMmPkguMapKey(MMPackageUnitDO mmPackageUnitDO) {
		return getMmPkguMapKey(mmPackageUnitDO.getId_mm(), mmPackageUnitDO.getSd_mmpkgupro());
	}

	/**
	 * 获取物品包装单位集字典Key
	 * 
	 * @param mmPackageUnitDO
	 * @return
	 */
	private String getMmPkguMapKey(String mmId, String mmPkguProCode) {
		return String.format("%s_%s", mmId, mmPkguProCode);
	}

	private void checkValue(MeterialDO[] dOS) throws BizException {

		Map<String, MMCategoryDO> mmcaList = this.getMmcateMap_imp();

		for (MeterialDO DO : dOS) {

			if (DO.getSd_pap().equals(IBdMmDictCodeConst.SD_PAP_CATEGORY)) {

				MMCategoryDO mmcaDO = mmcaList.get(DO.getId_mmca());
				if (mmcaDO == null) {

					String error = String.format("未在物品基本分类表(bd_mmca)找到物品(bd_mm)：%s的物品基本分类(id_mmca)%s", DO.getId_mm(),
							DO.getId_mmca());
					throw new BizException(error);
				}

				DO.setFg_price(mmcaDO.getFg_price());
				DO.setFg_charge(mmcaDO.getFg_charge());
				DO.setId_primode(mmcaDO.getId_primode());
				DO.setSd_primode(mmcaDO.getSd_primode());
				DO.setRate_pap(mmcaDO.getPap());
				DO.setFg_batch(mmcaDO.getFg_batch());
				DO.setId_outmode(mmcaDO.getId_outmode());
				DO.setSd_outmode(mmcaDO.getSd_outmode());
			} else {

				if (DO.getFg_price() == null) {

					String error = String.format("物品(bd_mm)：%s的是否售价管理标识(Fg_price)不能为空", DO.getId_mm());
					throw new BizException(error);
				}

				if (DO.getFg_batch() == null) {

					String error = String.format("物品(bd_mm)：%s的是否批次管理标识(Fg_batch)不能为空", DO.getId_mm());
					throw new BizException(error);
				}

				if (DO.getFg_price().booleanValue()) {

					if (DO.getFg_charge() == null) {

						String error = String.format("物品(bd_mm)：%s是否售价管理(Fg_price)为true，收费出库标识(Fg_charge)不能为空",
								DO.getId_mm());
						throw new BizException(error);
					}

					if (StringUtils.isBlank(DO.getId_primode()) || StringUtils.isBlank(DO.getSd_primode())) {

						String error = String.format(
								"物品(bd_mm)：%s是否售价管理(Fg_price)为true，售价计算模式(Id_primode、Sd_primode)不能为空", DO.getId_mm());
						throw new BizException(error);
					}

					if (!DO.getFg_charge().booleanValue()
							&& !DO.getSd_primode().equals(IBdMmDictCodeConst.SD_PRIMODE_FIX)) {

						String error = String.format("物品(bd_mm)：%s收费出库标识(Fg_charge)为false，售价计算方式(Sd_primode)必须为固定价",
								DO.getId_mm());
						throw new BizException(error);
					}
				} else {

					DO.setFg_charge(FBoolean.FALSE);
					DO.setId_primode(null);
					DO.setSd_primode(null);
					DO.setPrice(null);
					DO.setRate_pap(null);
				}

				if (DO.getFg_batch().booleanValue()) {

					if (StringUtils.isBlank(DO.getId_outmode()) || StringUtils.isBlank(DO.getSd_outmode())) {

						String error = String.format(
								"物品(bd_mm)：%s是否批次管理(Fg_batch)为true，批次出库方式(Id_outmode、Sd_outmode)不能为空", DO.getId_mm());
						throw new BizException(error);
					}
				} else {

					DO.setId_outmode(null);
					DO.setSd_outmode(null);
					DO.setId_validu(null);
					DO.setSd_validu(null);
					DO.setValid_cn(null);
				}
			}

			if (DO.getFg_price().booleanValue()) {

				if (DO.getSd_primode().equals(IBdMmDictCodeConst.SD_PRIMODE_FIX) && DO.getPrice() == null) {

					if (DO.getSd_pap().equals(IBdMmDictCodeConst.SD_PAP_CATEGORY)) {

						String error = String.format("物品(bd_mm)：%s所属基本分类的售价计算模式(Sd_primode)为固定价，零售价(Price)不能为空",
								DO.getId_mm());
						throw new BizException(error);
					} else {

						String error = String.format("物品(bd_mm)：%s售价计算模式(Sd_primode)为固定价，零售价(Price)不能为空",
								DO.getId_mm());
						throw new BizException(error);
					}
				}

				if (DO.getSd_primode().equals(IBdMmDictCodeConst.SD_PRIMODE_RATE) && DO.getRate_pap() == null) {

					if (DO.getSd_pap().equals(IBdMmDictCodeConst.SD_PAP_CATEGORY)) {

						String error = String.format("物品(bd_mm)：%s所属基本分类的售价计算模式(Sd_primode)为加成计算，加成率(Rate_pap)不能为空",
								DO.getId_mm());
						throw new BizException(error);
					} else {

						String error = String.format("物品(bd_mm)：%s售价计算模式(Sd_primode)为加成计算，加成率(Rate_pap)不能为空",
								DO.getId_mm());
						throw new BizException(error);
					}
				}
			}

			if (DO.getFg_batch().booleanValue() && DO.getSd_outmode().equals(IBdMmDictCodeConst.SD_OUTMODE_PERIOD)) {

				if (StringUtils.isBlank(DO.getId_validu()) || StringUtils.isBlank(DO.getSd_validu())) {

					if (DO.getSd_pap().equals(IBdMmDictCodeConst.SD_PAP_CATEGORY)) {

						String error = String.format(
								"物品(bd_mm)：%s所属基本分类的批次出库方式(Sd_outmode)为效期优先，有效期限单位(Id_validu、Sd_validu)不能为空",
								DO.getId_mm());
						throw new BizException(error);
					} else {

						String error = String.format(
								"物品(bd_mm)：%s批次出库方式(Sd_outmode)为效期优先，有效期限单位(Id_validu、Sd_validu)不能为空", DO.getId_mm());
						throw new BizException(error);
					}
				}

				if (DO.getValid_cn() == null) {

					if (DO.getSd_pap().equals(IBdMmDictCodeConst.SD_PAP_CATEGORY)) {

						String error = String.format("物品(bd_mm)：%s所属基本分类的批次出库方式(Sd_outmode)为效期优先，物品有效期限(Valid_cn)不能为空",
								DO.getId_mm());
						throw new BizException(error);
					} else {

						String error = String.format("物品(bd_mm)：%s批次出库方式(Sd_outmode)为效期优先，物品有效期限(Valid_cn)不能为空",
								DO.getId_mm());
						throw new BizException(error);
					}
				}
			}

			if (DO.getId_unit_pkgbase().equals(DO.getId_unit_pkgsp()) && DO.getFactor_sb().toDouble() != 1) {

				String error = String.format(
						"物品(bd_mm)：%s基本单位(Id_unit_pkgbase)与零售单位(Id_unit_pkgsp)相同时，零基换算系数(Factor_sb)应该为1",
						DO.getId_mm());
				throw new BizException(error);
			}

			if (!StringUtils.isBlank(DO.getId_unit_weight())
					&& (DO.getFactor_wb() == null || DO.getFactor_wb().toDouble() <= 0)) {

				String error = String.format("物品(bd_mm)：%s重量单位(Id_unit_weight)不为空时，重量/含量(Factor_wb)不能为空",
						DO.getId_mm());
				throw new BizException(error);
			}

			if (!StringUtils.isBlank(DO.getId_unit_volbase())
					&& (DO.getFactor_vb() == null || DO.getFactor_vb().toDouble() <= 0)) {

				String error = String.format("物品(bd_mm)：%s体积单位(Id_unit_volbase)不为空时，体积(Factor_vb)不能为空", DO.getId_mm());
				throw new BizException(error);
			}

			if (!StringUtils.isBlank(DO.getId_unit_weight()) && DO.getId_unit_weight().equals(DO.getId_unit_pkgbase())
					&& DO.getFactor_wb().toDouble() != 1) {

				String error = String.format(
						"物品(bd_mm)：%s重量单位(Id_unit_weight)与基本单位(Id_unit_pkgbase)相同时，重量/含量(Factor_wb)应该为1",
						DO.getId_mm());
				throw new BizException(error);
			}

			if (!StringUtils.isBlank(DO.getId_unit_volbase()) && DO.getId_unit_volbase().equals(DO.getId_unit_pkgbase())
					&& DO.getFactor_vb().toDouble() != 1) {

				String error = String.format(
						"物品(bd_mm)：%s体积单位(Id_unit_volbase)与基本单位(Id_unit_pkgbase)相同时，体积(Factor_vb)应该为1", DO.getId_mm());
				throw new BizException(error);
			}
		}
	}

	@SuppressWarnings("unchecked")
	private Map<String, MMCategoryDO> getMmcateMap_imp() throws BizException {

		DAFacade daFacade = new DAFacade();
		String qrySql = String.format("select * from %s where %s", (new MMCategoryDO()).getTableName(), "1=1");
		List<MMCategoryDO> list = (List<MMCategoryDO>) daFacade.execQuery(qrySql,
				new BeanListHandler((new MMCategoryDO()).getClass()));
		List<MMCategoryDO> list_imp = null;
		try {
			list_imp = (List<MMCategoryDO>) daFacade.execQuery(qrySql,
					new BeanListHandler((new MMCategoryDO()).getClass()));
		} catch (DAException daException) {

			if (daException.getMessage() != null && daException.getMessage().indexOf("ORA-00942") >= 0) {

			}
		}
		if ((list == null || list.size() <= 0) && (list_imp == null || list_imp.size() <= 0)) {
			throw new BizException("获取物品基本分类失败。");
		}
		List<MMCategoryDO> mmcalist = new ArrayList<MMCategoryDO>();
		if (list != null && list.size() > 0)
			mmcalist.addAll(list);
		if (list_imp != null && list_imp.size() > 0)
			mmcalist.addAll(list_imp);
		MMCategoryDO[] mmcaList = mmcalist
				.toArray((MMCategoryDO[]) Array.newInstance((new MMCategoryDO().getClass()), 0));

		Map<String, MMCategoryDO> result = new HashMap<String, MMCategoryDO>();
		for (MMCategoryDO mmcaDO : mmcaList) {

			result.put(mmcaDO.getId_mmca(), mmcaDO);
		}
		return result;
	}

	private void initMmPkguData(MeterialDO[] dOS) throws BizException {

		List<MMPackageUnitDO> result = new ArrayList<MMPackageUnitDO>();
		for (MeterialDO mmDO : dOS) {

			MeasDocDO baseUnitPkg = this.getMeasdocById(mmDO.getId_unit_pkgbase());
			if (baseUnitPkg == null) {

				throw new BizException("获取计量单位失败。[" + mmDO.getId_unit_pkgbase() + "]");
			}
			// 基本包装单位
			MMPackageUnitDO basePkgUnitDO = createMmPkgu(mmDO, IBdMmDictCodeConst.SD_MMPKGUPRO_BASE);
			result.add(basePkgUnitDO);

			// 零售包装单位
			MMPackageUnitDO sellPkgUnitDO = createMmPkgu(mmDO, IBdMmDictCodeConst.SD_MMPKGUPRO_SELL);
			result.add(sellPkgUnitDO);
		}

		IMMPackageUnitDOCudService mmpkgCudSrv = ServiceFinder.find(IMMPackageUnitDOCudService.class);
		mmpkgCudSrv.save(result.toArray(new MMPackageUnitDO[result.size()]));
	}

	/**
	 * 根据编码获取包装单位类型
	 * 
	 * @param sdMmpkgupro
	 * @return
	 * @throws BizException
	 */
	private PackageUnitDO getPkgUnitTypeByCode(String mmpkguTpCode) throws BizException {
		if (this._pkgUnitTypeMap == null) {
			this._pkgUnitTypeMap = this.getPackageMap();
		}

		if (!this._pkgUnitTypeMap.containsKey(mmpkguTpCode)) {
			String msg = String.format("获取包装单位类型失败，【%s】。", mmpkguTpCode);
			throw new BizException(msg);

		}
		return this._pkgUnitTypeMap.get(mmpkguTpCode);
	}

	@SuppressWarnings("unchecked")
	private HashMap<String, PackageUnitDO> getPackageMap() throws BizException {

		DAFacade daFacade = new DAFacade();
		String qrySql = String.format("select * from %s where %s", (new PackageUnitDO()).getTableName(), "1=1");
		List<PackageUnitDO> packgeDOS = (List<PackageUnitDO>) daFacade.execQuery(qrySql,
				new BeanListHandler((new PackageUnitDO()).getClass()));
		if (packgeDOS == null || packgeDOS.size() <= 0) {

			throw new BizException("获取包装单位类型失败。");
		}

		HashMap<String, PackageUnitDO> result = new HashMap<String, PackageUnitDO>();
		for (PackageUnitDO packDO : packgeDOS) {

			result.put(packDO.getCode(), packDO);
		}

		return result;
	}

	/**
	 * 根据主键获取计量单位
	 * 
	 * @param sdMmpkgupro
	 * @return
	 * @throws BizException
	 */
	private MeasDocDO getMeasdocById(String measdocId) throws BizException {
		if (this._measdocMap == null) {
			this._measdocMap = this.getMeasdocMap();
		}

		if (this._measdocMap.containsKey(measdocId)) {
			return this._measdocMap.get(measdocId);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	private HashMap<String, MeasDocDO> getMeasdocMap() throws BizException {

		DAFacade daFacade = new DAFacade();
		String qrySql = String.format("select * from %s where %s", (new MeasDocDO()).getTableName(), "1=1");
		List<MeasDocDO> measDocs = (List<MeasDocDO>) daFacade.execQuery(qrySql,
				new BeanListHandler((new MeasDocDO()).getClass()));
		if (measDocs == null || measDocs.size() <= 0) {

			throw new BizException("获取计量单位失败。");
		}

		HashMap<String, MeasDocDO> result = new HashMap<String, MeasDocDO>();
		for (MeasDocDO measDO : measDocs) {

			result.put(measDO.getId_measdoc(), measDO);
		}

		return result;
	}

	@Override
	public boolean cleanData() throws BizException {
		DAFacade daFacade = new DAFacade();
		daFacade.execUpdate("delete from BD_MM");
		daFacade.execUpdate("delete from BD_MM_PKGU");
		return true;
	}

	/**
	 * 基础数据完整性校验，服务接口调用</br>
	 * iih.bd.mm.meterial.i.ds.IMeterialService.CheckValidate(Boolean)
	 * 
	 * @param fg_update
	 * @return
	 * @throws BizException
	 */
	public String CheckValidate(Boolean fg_update) throws BizException {

		Map<String, MedSrvDO> medsrvList = this.getMedsrvMap();
		Map<String, MeterialDO> mmList = this.getMmMap();

		Map<String, List<String>> errorList = new HashMap<String, List<String>>();
		// 物品的医学单位关联校验
		errorList = this.checkValidate(medsrvList, mmList);

		// 更新启用标识
		if (fg_update) {

			this.updateData(errorList, mmList);
		}

		// 错误信息
		String sb = this.assembleError(errorList, mmList);
		this.writeLog(sb);

		return sb;
	}

	@SuppressWarnings("unchecked")
	private Map<String, MedSrvDO> getMedsrvMap() throws BizException {

		DAFacade daFacade = new DAFacade();
		String qrySql = String.format("select * from %s where %s", (new MedSrvDO()).getTableName(), "1=1");
		List<MedSrvDO> list = (List<MedSrvDO>) daFacade.execQuery(qrySql,
				new BeanListHandler((new MedSrvDO()).getClass()));
		if (list == null || list.size() <= 0) {
			throw new BizException("获取医疗服务失败。");
		}

		Map<String, MedSrvDO> result = new HashMap<String, MedSrvDO>();
		for (MedSrvDO medDO : list) {

			result.put(medDO.getId_srv(), medDO);
		}

		return result;
	}

	@SuppressWarnings("unchecked")
	private Map<String, MeterialDO> getMmMap() throws BizException {

		DAFacade daFacade = new DAFacade();
		String qrySql = String.format("select * from %s where sd_mmtp like '%s%%' and ds = 0",
				(new MeterialDO()).getTableName(), IBdMmDictCodeConst.SD_MMTP_DRUG);
		List<MeterialDO> list = (List<MeterialDO>) daFacade.execQuery(qrySql,
				new BeanListHandler((new MeterialDO()).getClass()));
		if (list == null || list.size() <= 0) {
			throw new BizException("获取物品基本信息失败。");
		}

		Map<String, MeterialDO> result = new HashMap<String, MeterialDO>();
		for (MeterialDO mmDO : list) {

			result.put(mmDO.getId_mm(), mmDO);
		}

		return result;
	}

	private Map<String, List<String>> checkValidate(Map<String, MedSrvDO> medsrvList, Map<String, MeterialDO> mmdos)
			throws BizException {

		Map<String, List<String>> result = new HashMap<String, List<String>>();
		String error;
		String drugMCPropMM = BdMmParamUtils.GetDrugMCPropMM();
		for (MeterialDO mmdo : mmdos.values()) {

			List<String> errorlist = new ArrayList<String>();

			String id_unit_med = null;
			if (IBdMmParamValueConst.DRUGMCPROPMM_SRV.equals(drugMCPropMM)) {

				// 医疗服务不存在
				MedSrvDO medSrvDO = medsrvList.get(mmdo.getId_srv());
				if (medSrvDO == null) {

					error = String.format("对应的医疗服务【%s】不存在", mmdo.getId_srv());
					errorlist.add(error);
				} else {

					// 医疗服务未设置医学单位
					if (StringUtils.isBlank(medSrvDO.getId_unit_med())) {

						error = String.format("对应的医疗服务【%s】未设置医学单位", medSrvDO.getId_srv());
						errorlist.add(error);
					}
					id_unit_med = medSrvDO.getId_unit_med();
				}
			} else {

				// 药品未设置医学单位
				if (StringUtils.isBlank(mmdo.getId_unit_med())) {

					error = "药品未设置医学单位";
					errorlist.add(error);
				}
				id_unit_med = mmdo.getId_unit_med();
			}

			if (!StringUtils.isBlank(id_unit_med)) {

				MeasDocDO measdo = this.getMeasdocById(id_unit_med);
				if (measdo == null) {

					error = String.format("对应的医学单位【%s】不存在", id_unit_med);
					errorlist.add(error);
				} else {

					if (!id_unit_med.equals(mmdo.getId_unit_volbase()) && !id_unit_med.equals(mmdo.getId_unit_weight())
							&& !id_unit_med.equals(mmdo.getId_unit_pkgbase())
							&& !id_unit_med.equals(mmdo.getId_unit_pkgsp())) {

						error = String.format("基本单位、重量单位、体积单位、零售单位中必须包含医学单位【%s：%s】", id_unit_med, measdo.getName());
						errorlist.add(error);
					} else {

						if (id_unit_med.equals(mmdo.getId_unit_pkgbase()) && mmdo.getFactor_mb().toDouble() != 1) {

							error = String.format("医学单位【%s】与基本单位【%s】相同时，医基换算系数应该为1", measdo.getName(),
									measdo.getName());
							errorlist.add(error);
						}

						if (id_unit_med.equals(mmdo.getId_unit_weight())
								&& mmdo.getFactor_mb().compareTo(mmdo.getFactor_wb()) != 0) {

							error = String.format("医学单位【%s】与重量单位【%s】相同时，医基换算系数与重量应该相同", measdo.getName(),
									measdo.getName());
							errorlist.add(error);
						}

						if (id_unit_med.equals(mmdo.getId_unit_volbase())
								&& mmdo.getFactor_mb().compareTo(mmdo.getFactor_vb()) != 0) {

							error = String.format("医学单位【%s】与体积单位【%s】相同时，医基换算系数与体积应该相同", measdo.getName(),
									measdo.getName());
							errorlist.add(error);
						}
					}
				}
			}

			if (errorlist.size() > 0) {

				result.put(mmdo.getId_mm(), errorlist);
			}
		}

		return result;
	}

	private void updateData(Map<String, List<String>> errorList, Map<String, MeterialDO> mmList) throws BizException {

		List<MeterialDO> active = new ArrayList<MeterialDO>();
		List<MeterialDO> unActive = new ArrayList<MeterialDO>();

		for (MeterialDO mmDO : mmList.values()) {

			if (!errorList.containsKey(mmDO.getId_mm()) && !mmDO.getFg_active().booleanValue()) {

				active.add(mmDO);
			}

			if (errorList.containsKey(mmDO.getId_mm()) && mmDO.getFg_active().booleanValue()) {

				unActive.add(mmDO);
			}
		}

		if (active.size() > 0) {

			ServiceFinder.find(IMeterialService.class).start(active.toArray(new MeterialDO[active.size()]));
		}

		if (unActive.size() > 0) {

			ServiceFinder.find(IMeterialService.class).stop(unActive.toArray(new MeterialDO[unActive.size()]));
		}
	}

	private String assembleError(Map<String, List<String>> errorList, Map<String, MeterialDO> mmList) {

		int index = 1;
		StringBuilder sb = new StringBuilder(String.format("摘要：时间：%s, 本次共扫描基础数据 %d条、错误数据 %d条。",
				new FDateTime().toLocalString(), mmList.size(), errorList.size()));

		if (errorList.size() > 0) {

			sb.append("详细信息如下:").append(NextLineString);
			for (String key : errorList.keySet()) {

				sb.append(index++).append("---------------------------------");
				sb.append(NextLineString).append(assembleError(errorList.get(key), mmList.get(key)));
			}

			sb.append(NextLineString).append("============================").append(NextLineString).append("结束");
		} else {

			sb.append("未发现错误数据。");
		}

		return sb.toString();
	}

	private Object assembleError(List<String> list, MeterialDO meterialDO) {

		int index = 1;
		StringBuilder sb = new StringBuilder();

		sb.append(String.format("%s%s%s%s规格：%s", meterialDO.getId_mm(), OffsetString, meterialDO.getName(),
				PaddingString, meterialDO.getSpec()));
		sb.append(NextLineString).append(PaddingString).append(OffsetString);
		sb.append("问题：").append(NextLineString);

		for (String msg : list) {

			sb.append(PaddingString).append(PaddingString).append(OffsetString);
			sb.append(index++).append(". ");
			sb.append(msg).append(NextLineString);
		}

		return sb.toString();
	}

	private void writeLog(String sb) throws BizException {

		String path = "M00/00/01/wKhJD1k3hWuEdFQMAAAAAE-tP7s5815157";
		xap.mw.basic.storage.StorageService ss = ServiceFinder.find(xap.mw.basic.storage.StorageService.class);
		FBinary rst = ss.read(path);
		try {
			StringBuilder log = new StringBuilder(convertStreamToString(rst.getBody()));
			log.append(NextLineString).append(NextLineString).append("物品基本信息校验开始：").append(NextLineString).append(sb);
			byte[] szData = log.toString().getBytes("UTF-8");
			FBinary bin = BinaryBuilder.builder().withSize(szData.length).withBody(new ByteArrayInputStream(szData))
					.build();
			ss.write(path, bin);
		} catch (IOException e) {
			throw new BizException(e.getMessage());
		}
	}

	private String convertStreamToString(InputStream is) {

		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		StringBuilder sb = new StringBuilder();
		String line = null;

		try {

			while ((line = reader.readLine()) != null) {

				sb.append(line + "\n");
			}
		} catch (IOException e) {

			e.printStackTrace();
		} finally {

			try {

				is.close();
			} catch (IOException e) {

				e.printStackTrace();
			}
		}

		return sb.toString();
	}
}
