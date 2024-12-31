package iih.bd.mm.meterial.bp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import iih.bd.bc.udi.pub.IBdMmDictCodeConst;
import iih.bd.mm.meterial.d.MMPackageUnitDO;
import iih.bd.mm.meterial.d.MeterialAggDO;
import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.mm.meterial.i.IMeterialCudService;
import iih.bd.mm.meterial.i.IMeterialMDORService;
import iih.bd.mm.mmcategory.d.MMCategoryDO;
import iih.bd.mm.mmcategory.i.IMmcategoryRService;
import iih.bd.mm.packageunit.d.PackageUnitDO;
import iih.bd.mm.packageunit.i.IPackageunitRService;
import iih.bd.mm.supplier.d.SupplierDO;
import iih.bd.mm.supplier.i.ISupplierRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.xbd.measdoc.d.MeasDocDO;
import xap.sys.xbd.measdoc.i.IMeasdocRService;
import xap.sys.xbd.udi.d.UdidocDO;
import xap.sys.xbd.udi.d.UdidoclistDO;
import xap.sys.xbd.udi.i.IUdidocRService;
import xap.sys.xbd.udi.i.IUdidoclistRService;

/**  
 * ClassName:耗材基本信息数据导入。<br/>  
 * Function: TODO ADD FUNCTION. <br/>  
 * Date:     2019年3月21日 下午5:20:32 <br/>  
 * @author   zmyang  
 * @version    
 * @since    JDK 1.7.0_76       
 */
public class McSaniBaseInfoImport {

	public void exec(MeterialDO[] meterialDOs) throws BizException{
		// ■ 参数校验
		this.validaPara(meterialDOs);

		// ■ 自定义档案值是否合法(物品类型)
		Map<String, UdidocDO> mmtpUdidocList = new HashMap<String, UdidocDO>();
		// ■ 卫材分类是否合法(卫材分类模式)
		Map<String, MMCategoryDO> mMCategoryDOList = new HashMap<String, MMCategoryDO>();
		// ■ 包装单位是否合法(包装单位)
		Map<String, MeasDocDO> MeasDocDOList = new HashMap<String, MeasDocDO>();
		// ■ 生产厂商是否合法(生产厂商)
		Map<String, SupplierDO> SupplierDOList = new HashMap<String, SupplierDO>();
		// ■ 进口分类是否合法(进口分类)
		Map<String, UdidocDO> abrdUdidocList = new HashMap<String, UdidocDO>();
		// ■ 参照是否合法
		this.checkUdidocValue(meterialDOs, mmtpUdidocList, mMCategoryDOList,MeasDocDOList,SupplierDOList,abrdUdidocList);

		// ■ 编码是否合法
		this.checkCode(meterialDOs);

		// ■ 导入
		this.importMmca(meterialDOs);
	}


	/**
	 * validaPara: 参数校验 <br/>  
	 * @author zmyang  
	 * @param meterialDOs  
	 * @since JDK 1.7.0_76
	 */
	private void validaPara(MeterialDO[] meterialDOs) throws BizException {
		if (meterialDOs == null || meterialDOs.length < 1) {
			throw new BizException("传入参数为空!");
		}
		
		int num = 0;
		StringBuffer errMsg = new StringBuffer();
		for(MeterialDO meterialDO : meterialDOs) {
			
			num = num + 1;
			if(StringUtils.isBlank(meterialDO.getCode())) {
				
				errMsg.append(String.format("第【%s】行数据卫材编码为空；", String.valueOf(num)));
			}
			if(StringUtils.isBlank(meterialDO.getName())) {
				
				errMsg.append(String.format("第【%s】行数据卫材名称为空；", String.valueOf(num)));
			}
			if(StringUtils.isBlank(meterialDO.getSd_mmtp())) {
				
				errMsg.append(String.format("第【%s】行数据物品类型为空；", String.valueOf(num)));
			}
			if(StringUtils.isBlank(meterialDO.getMmca_code())) {
				
				errMsg.append(String.format("第【%s】行数据卫材分类为空；", String.valueOf(num)));
			}
			if(StringUtils.isBlank(meterialDO.getPkgbase_code())) {
				
				errMsg.append(String.format("第【%s】行数据包装单位为空；", String.valueOf(num)));
			}
			
		    if(!StringUtils.isBlank(errMsg)) {
				
				errMsg.append("\n");
			}
		}
		
		if(!StringUtils.isBlank(errMsg)) {
			
			throw new BizException(errMsg.toString());
		}
	}
	
	/**
	 * checkUdidocValue:获取参照，看是否能找到对应参照 <br/>  
	 * @author zmyang  
	 * @param meterialDOs
	 * @param mmtpUdidocList
	 * @param mMCategoryDOList
	 * @param measDocDOList
	 * @param supplierDOList
	 * @param abrdUdidocList
	 * @throws BizException  
	 * @since JDK 1.7.0_76
	 */
	private void checkUdidocValue(MeterialDO[] meterialDOs, Map<String, UdidocDO> mmtpUdidocList,
			Map<String, MMCategoryDO> mMCategoryDOList, Map<String, MeasDocDO> measDocDOList, Map<String, SupplierDO> supplierDOList, Map<String, UdidocDO> abrdUdidocList) throws BizException {

		// 物品类型自定义档案
		this.getMmtpUdidoc(mmtpUdidocList);
		// 卫材分类
		this.getMmCategoryDO(mMCategoryDOList);
		// 包装单位
		this.getMeasDocDO(measDocDOList);
		int num = 0;
		StringBuffer errMsg = new StringBuffer();
		for (MeterialDO meterialDO : meterialDOs) {
			if (meterialDO.getSup_name() != null && !StringUtil.isEmptyWithTrim(meterialDO.getSup_name())) {
				this.getSupplierDO(supplierDOList);
			}
			if (meterialDO.getSd_abrd() != null && !StringUtil.isEmptyWithTrim(meterialDO.getSd_abrd())) {
				this.getAbrdUdidoc(abrdUdidocList);
			}
			num = num + 1;
			if (mmtpUdidocList != null && mmtpUdidocList.size() >0 && !mmtpUdidocList.containsKey(meterialDO.getSd_mmtp())) {
				errMsg.append(String.format("第【%s】行数据卫材对应的物品类型不存在；", String.valueOf(num)));
			}
			if (mMCategoryDOList != null && mMCategoryDOList.size() >0 && !mMCategoryDOList.containsKey(meterialDO.getMmca_code())) {
				errMsg.append(String.format("第【%s】行数据卫材对应的卫材基本分类不存在；", String.valueOf(num)));
			}
			if (measDocDOList != null && measDocDOList.size() >0 && !measDocDOList.containsKey(meterialDO.getPkgbase_code())) {
				errMsg.append(String.format("第【%s】行数据卫材对应的包装单位不存在；", String.valueOf(num)));
			}
			if (supplierDOList != null && supplierDOList.size() >0 && !supplierDOList.containsKey(meterialDO.getSup_name())) {
				errMsg.append(String.format("第【%s】行数据卫材对应的生产厂商不存在；", String.valueOf(num)));
			}
			if (abrdUdidocList != null && abrdUdidocList.size() >0 && !abrdUdidocList.containsKey(meterialDO.getSd_abrd())) {
				errMsg.append(String.format("第【%s】行数据卫材对应的进口分类不存在；", String.valueOf(num)));
			}
			if (!StringUtils.isBlank(errMsg)) {
				errMsg.append("\n");
			}
			if (mmtpUdidocList.containsKey(meterialDO.getSd_mmtp())) {
				UdidocDO udidocDO = mmtpUdidocList.get(meterialDO.getSd_mmtp());
				meterialDO.setId_mmtp(udidocDO.getId_udidoc());
			}
			if (mMCategoryDOList.containsKey(meterialDO.getMmca_code())) {
				MMCategoryDO mmCategoryDO = mMCategoryDOList.get(meterialDO.getMmca_code());
				meterialDO.setId_mmca(mmCategoryDO.getId_mmca());
			}
			if (measDocDOList.containsKey(meterialDO.getPkgbase_code())) {
				MeasDocDO measDocDO = measDocDOList.get(meterialDO.getPkgbase_code());
				meterialDO.setId_unit_pkgbase(measDocDO.getId_measdoc());
				meterialDO.setName_unit_pkgbase(measDocDO.getName());
				meterialDO.setId_unit_med(measDocDO.getId_measdoc());
				meterialDO.setUnit_med_name(measDocDO.getName());
			}
			if (supplierDOList.containsKey(meterialDO.getSup_name())) {
				SupplierDO supplierDO = supplierDOList.get(meterialDO.getSup_name());
				meterialDO.setId_sup(supplierDO.getId_sup());
			}
			if (abrdUdidocList.containsKey(meterialDO.getSd_abrd())) {
				UdidocDO udidocDO = abrdUdidocList.get(meterialDO.getSd_abrd());
				meterialDO.setId_abrd(udidocDO.getId_udidoc());
			}
		}

		if (!StringUtils.isBlank(errMsg)) {

			throw new BizException(errMsg.toString());
		}

	}

	private void getMmtpUdidoc(Map<String, UdidocDO> mmtpUdidocList) throws BizException {
		
		IUdidocRService udiSrv = ServiceFinder.find(IUdidocRService.class);
		IUdidoclistRService dioListSrv = ServiceFinder.find(IUdidoclistRService.class);
		
		String whrStr = String.format("code = '%s'", IBdMmDictCodeConst.SD_MMTP);
		UdidoclistDO[] udiListDOS = dioListSrv.find(whrStr, "", FBoolean.TRUE);
		
		if(udiListDOS == null || udiListDOS.length <= 0) {
			
			throw new BizException("获取物品类型自定义档案失败。");
		}
		
		whrStr = String.format("id_udidoclist = '%s'", udiListDOS[0].getId_udidoclist());
		UdidocDO[] uidList = udiSrv.find(whrStr, "", FBoolean.TRUE);
		
		if(uidList == null || uidList.length <= 0) {
			
			throw new BizException("获取物品类型自定义档案失败。");
		}
		
		for(UdidocDO udiDO : uidList) {
			
			mmtpUdidocList.put(udiDO.getCode(), udiDO);
		}
	}

	private void getMmCategoryDO(Map<String, MMCategoryDO> mMCategoryDOList) throws BizException {
		  
		IMmcategoryRService mmcaservice = ServiceFinder.find(IMmcategoryRService.class);
		MMCategoryDO [] mmCategoryDOs = mmcaservice.find("1=1","",FBoolean.TRUE);
		if (mmCategoryDOs == null || mmCategoryDOs.length <1) {
			throw new BizException("获取卫材基本分类失败");
		}
		for (MMCategoryDO mmCategoryDO : mmCategoryDOs) {
			mMCategoryDOList.put(mmCategoryDO.getCode(), mmCategoryDO);
		}
	}
	
	private void getMeasDocDO(Map<String, MeasDocDO> measDocDOList) throws BizException {
		  
		IMeasdocRService measdocRService = ServiceFinder.find(IMeasdocRService.class);
		MeasDocDO [] measDocDOs = measdocRService.find("1=1", "", FBoolean.TRUE);
		if (measDocDOs == null || measDocDOs.length <1) {
			throw new BizException("获取包装单位失败");
		}
		for (MeasDocDO measDocDO : measDocDOs) {
			measDocDOList.put(measDocDO.getCode(), measDocDO);
		}
	}

	private void getSupplierDO(Map<String, SupplierDO> supplierDOList) throws BizException{
		  
		ISupplierRService iSupplierRService = ServiceFinder.find(ISupplierRService.class);
		SupplierDO [] supplierDOs = iSupplierRService.find("1=1", "", FBoolean.TRUE);
		if (supplierDOs == null || supplierDOs.length <1) {
			throw new BizException("获取生产厂商失败");
		}	
		for (SupplierDO supplierDO : supplierDOs) {
			supplierDOList.put(supplierDO.getName(), supplierDO);
		}
	}

	private void getAbrdUdidoc(Map<String, UdidocDO> abrdUdidocList) throws BizException {
		
		IUdidocRService udiSrv = ServiceFinder.find(IUdidocRService.class);
		IUdidoclistRService dioListSrv = ServiceFinder.find(IUdidoclistRService.class);
		
		String whrStr = String.format("code = '%s'", IBdMmDictCodeConst.SD_ABRD);
		UdidoclistDO[] udiListDOS = dioListSrv.find(whrStr, "", FBoolean.TRUE);
		
		if(udiListDOS == null || udiListDOS.length <= 0) {
			
			throw new BizException("获取进口分类自定义档案失败。");
		}
		
		whrStr = String.format("id_udidoclist = '%s'", udiListDOS[0].getId_udidoclist());
		UdidocDO[] uidList = udiSrv.find(whrStr, "", FBoolean.TRUE);
		
		if(uidList == null || uidList.length <= 0) {
			
			throw new BizException("获取进口分类自定义档案失败。");
		}
		
		for(UdidocDO udiDO : uidList) {
			
			abrdUdidocList.put(udiDO.getCode(), udiDO);
		}
	}

	/**
	 * checkCode:校验编码重复 <br/>  
	 * @author zmyang  
	 * @param meterialDOs
	 * @throws BizException  
	 * @since JDK 1.7.0_76
	 */
	private void checkCode(MeterialDO[] meterialDOs) throws BizException{
		
		IMeterialMDORService iMeterialMDORService = ServiceFinder.find(IMeterialMDORService.class);
		List<String> codeList = new ArrayList<String>();
		Integer maxcode = 0;
		for (MeterialDO meterialDO : meterialDOs) {
			if (meterialDO != null) {
				codeList.add(meterialDO.getCode());
			}else {
				maxcode = this.rtnOnlyCode();
				meterialDO.setCode((++maxcode).toString());
			}
		}
		MeterialDO[] meterialDOs2 = iMeterialMDORService.findByAttrValStrings(MeterialDO.CODE, codeList.toArray(new String [0]));
		if (meterialDOs2 != null && meterialDOs2.length >0) {
			throw new BizException(String.format("卫材编码【%s】在数据库中已存在。",meterialDOs2[0].getCode()));
		}
	}
	
	/**
	 * rtnOnlyCode:获得数据库最大的编码 <br/>  
	 * @author zmyang  
	 * @return
	 * @throws BizException  
	 * @since JDK 1.7.0_76
	 */
	private Integer rtnOnlyCode() throws BizException {
		
		String sql = "select max(code) code from bd_mm ";
		String code  =  (String) new DAFacade().execQuery(sql, new ColumnHandler());
		return Integer.parseInt(code);
	}
	
	/**
	 * importMmca:导入<br/>  
	 * @author zmyang  
	 * @param meterialDOs
	 * @throws BizException  
	 * @since JDK 1.7.0_76
	 */
	private void importMmca(MeterialDO[] meterialDOs) throws BizException{
		  
		List<MeterialAggDO> agglist = new ArrayList<MeterialAggDO>();
		for (MeterialDO meterialDO : meterialDOs) {
			meterialDO.setStatus(DOStatus.NEW);
			//集团
			meterialDO.setId_grp(Context.get().getGroupId());
			//机构
			meterialDO.setId_org(Context.get().getOrgId());
			//是否启用
			meterialDO.setFg_active(FBoolean.TRUE);
			//皮试标志
			meterialDO.setFg_skin(FBoolean.FALSE);
			//患者使用标志
			meterialDO.setFg_pat(FBoolean.TRUE);
			//是否价格管理
			meterialDO.setFg_price(FBoolean.FALSE);
			//OTC标志
			meterialDO.setFg_otc(FBoolean.FALSE);
			//收费出库标识
			meterialDO.setFg_charge(FBoolean.FALSE);
			//GMP标志
			meterialDO.setFg_gmp(FBoolean.FALSE);
			//基本药物标志（废弃）
			//meterialDO.setFg_essdg(FBoolean.FALSE);
			//停发标志
			meterialDO.setFg_out(FBoolean.FALSE);
			//急诊使用标志
			meterialDO.setFg_use_er(FBoolean.FALSE);
			//家床使用标志
			meterialDO.setFg_use_fm(FBoolean.FALSE);
			//住院使用标志
			meterialDO.setFg_use_ip(FBoolean.FALSE);
			//门诊使用标志
			meterialDO.setFg_use_op(FBoolean.FALSE);
			//体检使用标志
			meterialDO.setFg_use_pe(FBoolean.FALSE);
			//OA请领标识
			meterialDO.setFg_oa_applyreceive(FBoolean.TRUE);
			//是否批次管理
			meterialDO.setFg_batch(meterialDO.getFg_batchmix());
			
			Map<String, UdidocDO> udidocmap = this.getPriceMode();
			UdidocDO udidocDO = udidocmap.get(IBdMmDictCodeConst.SD_PRIMODE_FIX);
			//零售价id
			meterialDO.setId_primode(udidocDO.getId_udidoc());
			//零售价sd
			meterialDO.setSd_primode(IBdMmDictCodeConst.SD_PRIMODE_FIX);
			
			
			List<MMPackageUnitDO> unitList = new ArrayList<MMPackageUnitDO>();
			Map<String, PackageUnitDO> mmPackmap = this.getUnitPkgTpMap();
			PackageUnitDO packageUnitDO = mmPackmap.get(IBdMmDictCodeConst.MM_PKGUNIT_TYPE_BASE);
			MMPackageUnitDO mmPackageUnitDO = new MMPackageUnitDO();
			mmPackageUnitDO.setStatus(DOStatus.NEW);
			mmPackageUnitDO.setEn_erpkgtp(packageUnitDO.getEn_erpkgtp());
			mmPackageUnitDO.setEn_fmpkgtp(packageUnitDO.getEn_fmpkgtp());
			mmPackageUnitDO.setEn_ippkgtp(packageUnitDO.getEn_ippkgtp());
			mmPackageUnitDO.setEn_oppkgtp(packageUnitDO.getEn_oppkgtp());
			mmPackageUnitDO.setEn_pepkgtp(packageUnitDO.getEn_pepkgtp());
			mmPackageUnitDO.setFactor(FDouble.ONE_DBL);
			mmPackageUnitDO.setId_mmpkgutp(packageUnitDO.getId_mmpkgutp());
			mmPackageUnitDO.setId_unit_pkg(meterialDO.getId_unit_med());
			mmPackageUnitDO.setMmpkguname(meterialDO.getUnit_med_name());
			mmPackageUnitDO.setUnit_pkg_name(meterialDO.getUnit_med_name());
			mmPackageUnitDO.setSd_mmpkgupro(IBdMmDictCodeConst.SD_MMPKGUPRO_BASE);
			unitList.add(mmPackageUnitDO);
			
			
			MeterialAggDO aggdo = new MeterialAggDO();
			aggdo.setParentDO(meterialDO);
			aggdo.setMMPackageUnitDO(unitList.toArray(new MMPackageUnitDO[0]));
			agglist.add(aggdo);
		}
		IMeterialCudService iMeterialCudService = ServiceFinder.find(IMeterialCudService.class);
		iMeterialCudService.insert(agglist.toArray(new MeterialAggDO[0]));
	}
	
	/**
	 * getUnitPkgTpMap:获取基本包装单位<br/>  
	 * @author zmyang  
	 * @return
	 * @throws BizException  
	 * @since JDK 1.7.0_76
	 */
	private Map<String, PackageUnitDO> getUnitPkgTpMap() throws BizException {
		
		IPackageunitRService unitpkgSrv = ServiceFinder.find(IPackageunitRService.class);
		
		Map<String, PackageUnitDO> result = new HashMap<String, PackageUnitDO>();
		String[] code = new String[]{ IBdMmDictCodeConst.MM_PKGUNIT_TYPE_BASE, IBdMmDictCodeConst.MM_PKGUNIT_TYPE_SELL };
		PackageUnitDO[] unitPkgDOS = unitpkgSrv.findByAttrValStrings(PackageUnitDO.CODE, code);
		for(PackageUnitDO pkgUnitDO : unitPkgDOS) {
			
			result.put(pkgUnitDO.getCode(), pkgUnitDO);
		}
		
		return result;
	}
	
	/**
	 * getPriceMode:获取零售价计算方式自定义档案 <br/>  
	 * @author zmyang  
	 * @return
	 * @throws BizException  
	 * @since JDK 1.7.0_76
	 */
	private Map<String, UdidocDO> getPriceMode() throws BizException{
		IUdidocRService udiSrv = ServiceFinder.find(IUdidocRService.class);
		IUdidoclistRService dioListSrv = ServiceFinder.find(IUdidoclistRService.class);
		
		Map<String, UdidocDO> udidocMap = new HashMap<String, UdidocDO>();
		String whrStr = String.format("code = '%s'", IBdMmDictCodeConst.SD_PRIMODE);
		UdidoclistDO[] udiListDOS = dioListSrv.find(whrStr, "", FBoolean.TRUE);
		
		if(udiListDOS == null || udiListDOS.length <= 0) {
			
			throw new BizException("获取进口分类自定义档案失败。");
		}
		
		whrStr = String.format("id_udidoclist = '%s'", udiListDOS[0].getId_udidoclist());
		UdidocDO[] uidList = udiSrv.find(whrStr, "", FBoolean.TRUE);
		
		if(uidList == null || uidList.length <= 0) {
			
			throw new BizException("获取进口分类自定义档案失败。");
		}
		
		for(UdidocDO udiDO : uidList) {
			
			udidocMap.put(udiDO.getCode(), udiDO);
		}
		return udidocMap;
	}
}
  
