package iih.ei.std.s.v1.bp.mp.iprefundsupplymmout;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import iih.bd.base.utils.SqlUtils;
import iih.bd.bc.udi.pub.IBdMmDictCodeConst;
import iih.bd.mm.meterial.d.MMPackageUnitDO;
import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.mm.meterial.i.IMMPackageUnitDORService;
import iih.bd.mm.meterial.i.IMeterialMDORService;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import iih.bd.utils.BdEnvContextUtil;
import iih.bl.cg.blcgquery.d.BlCgIpDO;
import iih.bl.cg.blcgquery.i.IBlcgqueryRService;
import iih.bl.cg.dto.cglogic.d.BlCgAccountDTO;
import iih.bl.cg.dto.cglogic.d.BlCgAccountRltDTO;
import iih.bl.cg.dto.cglogic.d.BlCgAccountSetDTO;
import iih.bl.cg.dto.cglogic.d.BlCgRefundAccountDTO;
import iih.bl.cg.dto.cglogic.d.BlCgRefundAccountSetDTO;
import iih.bl.cg.dto.cglogic.d.RefundModeEnum;
import iih.bl.cg.i.IBlCgAccountService;
import iih.bl.comm.IBlCgFuncConst;
import iih.bl.pay.blpaypat.d.BookRtnDirectEnum;
import iih.ei.std.d.v1.commdto.d.NoParamDTO;
import iih.ei.std.d.v1.mp.iprefundsupplymmoutdto.d.CgMmOutItm;
import iih.ei.std.d.v1.mp.iprefundsupplymmoutdto.d.IpRefundSupplyMmOutParamDTO;
import iih.ei.std.s.v1.bp.IIHServiceBaseBP;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.mm.itf.material.d.DeliverResultDTO;
import iih.mm.itf.material.d.DeliverResultItemDTO;
import iih.mm.itf.material.d.DirectDeliverReqDTO;
import iih.mm.itf.material.d.ReturnItemDTO;
import iih.mm.itf.material.i.IMaterialStockService;
import iih.mm.st.stockout.d.StockOutItemDO;
import iih.mm.st.stockout.i.IStockOutItemDOCudService;
import iih.mm.st.stockout.i.IStockOutItemDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.bdfw.bbd.i.IPsndocMDORService;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.orgfw.dept.d.DeptDO;
import xap.sys.orgfw.dept.i.IDeptRService;
import xap.sys.xbd.measdoc.d.MeasDocDO;
import xap.sys.xbd.measdoc.i.IMeasdocRService;

/**
 * 住院补退费（含住院补退费+库存修改） 服务类直接调用费用计费 药品类先计费再调用出库操作
 * 
 * @author guoyang
 *
 */
public class IpRefundSupplyFeeMmOutBp extends IIHServiceBaseBP<IpRefundSupplyMmOutParamDTO, NoParamDTO> {

	private final String SPLIT = "#";
	private final String SUPPLY = "1";
	private final String REFUND = "-1";
	private final String MM = "mm";
	private final String SRV = "srv";

	@Override
	protected void checkParam(IpRefundSupplyMmOutParamDTO param) throws BizException {

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		format.setLenient(false);

		if (param == null) {
			throw new BizException("入参为空！");
		}

		if (StringUtils.isEmpty(param.getCode_pat())) {
			throw new BizException("入参患者编码为空！");
		}

		if (StringUtils.isEmpty(param.getTimes_ip())) {
			throw new BizException("入参住院次数为空！");
		}

		if (!StringUtils.isNumeric(param.getTimes_ip())) {
			throw new BizException(String.format("入参住院次数【%s】异常！", param.getTimes_ip()));
		}

		if (StringUtils.isEmpty(param.getFg_price_cal())) {
			param.setFg_price_cal("Y");
		}

		if (!"Y".equals(param.getFg_price_cal()) && !"N".equals(param.getFg_price_cal())) {
			throw new BizException(String.format("入参是否计算服务价格【%s】错误！", param.getFg_price_cal()));
		}

		if (StringUtils.isNotEmpty(param.getDt_cg())) {
			try {
				format.parse(param.getDt_cg());
			} catch (ParseException e) {
				throw new BizException(String.format("记账时间【%s】异常！异常信息：%s", param.getDt_cg(), e.toString()));
			}
		}

		FArrayList cgmmouts = param.getCgmmoutitm();

		if (cgmmouts == null || cgmmouts.size() <= 0) {
			throw new BizException("入参明细为空！");
		}

		boolean hasCode_srv = false;
		
		for (Object object : cgmmouts) {

			CgMmOutItm cgMmOutItm = (CgMmOutItm) object;

			if(StringUtils.isNotEmpty(cgMmOutItm.getCode_srv())){
				hasCode_srv = true;
			}
			
			if (StringUtils.isEmpty(cgMmOutItm.getEu_direct())) {
				throw new BizException("入参补退费方向为空！");
			}

			if (!SUPPLY.equals(cgMmOutItm.getEu_direct()) && !REFUND.equals(cgMmOutItm.getEu_direct())) {
				throw new BizException(String.format("入参补退费方向【%s】错误！", param.getFg_price_cal()));
			}

			if (StringUtils.isEmpty(cgMmOutItm.getCode_srv()) && StringUtils.isEmpty(cgMmOutItm.getCode_mm())) {
				throw new BizException("入参服务编码和物品编码都为空！");
			}

			if (StringUtils.isEmpty(cgMmOutItm.getQuan())) {
				throw new BizException("入参数量为空！");
			}

			if (!StringUtils.isNumeric(cgMmOutItm.getQuan())) {
				throw new BizException(String.format("入参数量【%s】异常！", cgMmOutItm.getQuan()));
			}

			if (!new FBoolean(param.getFg_price_cal()).booleanValue() && StringUtils.isNotEmpty(cgMmOutItm.getCode_srv())
					&& StringUtils.isEmpty(cgMmOutItm.getCode_mm()) && StringUtils.isEmpty(cgMmOutItm.getPrice())) {
				throw new BizException("入参价格为空！");
			}

			if (StringUtils.isEmpty(cgMmOutItm.getCode_emp_or())) {
				throw new BizException("入参开立人为空！");
			}

			if (StringUtils.isEmpty(cgMmOutItm.getCode_dep_or())) {
				throw new BizException("入参开立科室为空！");
			}

			if (StringUtils.isEmpty(cgMmOutItm.getCode_dep_mp())) {
				throw new BizException("入参执行科室为空！");
			}

			if (StringUtils.isNotEmpty(cgMmOutItm.getCode_mm()) && StringUtils.isEmpty(cgMmOutItm.getCode_dep_wh())) {
				throw new BizException("入参药房科室为空！");
			}

			if (StringUtils.isNotEmpty(cgMmOutItm.getDt_cg_detail())) {
				try {
					format.parse(cgMmOutItm.getDt_cg_detail());
				} catch (ParseException e) {
					throw new BizException(
							String.format("明细记账时间【%s】异常！异常信息：%s", cgMmOutItm.getDt_cg_detail(), e.toString()));
				}
			}
		}
		
		StringBuilder strBuf = new StringBuilder();
		if(hasCode_srv){
			List<MedSrvDO> medSrvDOs = getMedSrvDOs(cgmmouts);
			for(MedSrvDO medSrvDO : medSrvDOs){
				boolean[] valid = new boolean[2];
				valid[0] = medSrvDO.getFg_active_bl().booleanValue();
				valid[1] = medSrvDO.getModifiedtime().compareTo(new FDateTime()) >= 0;
				if(!valid[0] || !valid[1]){
					strBuf.append("入参服务编码 " + medSrvDO.getCode()+ "[项目名称：" + medSrvDO.getName() + "]" + " 对应的");
					strBuf.append(!valid[0] && !valid[1] ? "价表项目已停用，对应的项目定价已过期" : (valid[0] ? "项目定价已过期" : "价表项目已停用"));
					strBuf.append("！");
				}
			}
		}
		if(strBuf.length() > 0){
			throw new BizException(strBuf.toString());
		}
	}

	@Override
	protected NoParamDTO process(IpRefundSupplyMmOutParamDTO param) throws BizException {

		// 1.获取就诊信息
		PatiVisitDO patiVisitDO = getEntInfo(param);

		// 2.按照退记账分组
		Map<String, List<CgMmOutItm>> eudirectMap = groupByEudirect(param);

		// 3.获取服务药品集合分组
		Map<String, List<CgMmOutItm>> srvmmMap = getSrvMmMap(param);

		// 4.获取开立科室和药房科室信息
		Map<String, DeptDO> deptMap = getDeptInfo(param);

		// 5.获取人员基本信息
		Map<String, PsnDocDO> psnMap = getPsndocInfo(param);

		// 6.获取服务信息
		Map<String, MedSrvDO> srvMap = getSrvInfo(srvmmMap);

		// 7.获取物品信息eudirectMap
		Map<String, MeterialDO> mmMap = getMmInfo(srvmmMap);

		// 8.获取物品主键+物品包装单位主键信息
		Map<String, MMPackageUnitDO> mmpkguMap = getPkguInfo(srvmmMap, mmMap);

		// 9.住院补费
		ipSupplyFee(patiVisitDO, param, eudirectMap, srvMap, mmMap, mmpkguMap, deptMap, psnMap);

		// 10.住院退费
		ipRefundFee(patiVisitDO, param, eudirectMap, srvMap, mmMap, mmpkguMap, deptMap, psnMap);

		return null;
	}

	/**
	 * 根据患者编码和住院次数查询患者信息
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	private PatiVisitDO getEntInfo(IpRefundSupplyMmOutParamDTO param) throws BizException {
		// 获取患者本次就诊信息
		StringBuilder sqlStrBuf = new StringBuilder();
		sqlStrBuf.append(" SELECT ENT.ID_PAT, ");
		sqlStrBuf.append(" 	ENT.ID_ENT, ");
		sqlStrBuf.append(" 	ENT.FG_ST ");
		sqlStrBuf.append(" FROM EN_ENT ENT ");
		sqlStrBuf.append(" INNER JOIN EN_ENT_IP IP ON ENT.ID_ENT = IP.ID_ENT ");
		sqlStrBuf.append(" INNER JOIN PI_PAT PAT ON ENT.ID_PAT = PAT.ID_PAT ");
		sqlStrBuf.append(" WHERE 1 = 1 ");
		// 新增管控过滤
		String modeWherePart = new BdEnvContextUtil().processEnvContext(new PatiVisitDO(), "ENT");
		if (StringUtils.isNotEmpty(modeWherePart)) {
			sqlStrBuf.append(String.format(" AND %s ", modeWherePart));
		}
		sqlStrBuf.append(" AND PAT.CODE = ? ");
		sqlStrBuf.append(" AND IP.TIMES_IP = ? ");

		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(param.getCode_pat());
		sqlParam.addParam(param.getTimes_ip());

		List<PatiVisitDO> patiVisitDOs = (List<PatiVisitDO>) new DAFacade().execQuery(sqlStrBuf.toString(), sqlParam,
				new BeanListHandler(PatiVisitDO.class));

		if (patiVisitDOs == null || patiVisitDOs.size() <= 0) {
			throw new BizException(
					String.format("患者编码为【%s】，就诊次数为【%s】的就诊不存在！", param.getCode_pat(), param.getTimes_ip()));
		}
		return patiVisitDOs.get(0);
	}

	/**
	 * 按照收退费方向分组
	 * 
	 * @param param
	 * @return
	 */
	private Map<String, List<CgMmOutItm>> groupByEudirect(IpRefundSupplyMmOutParamDTO param) {
		Map<String, List<CgMmOutItm>> cgmmoutMap = new HashMap<String, List<CgMmOutItm>>();
		for (Object itm : param.getCgmmoutitm()) {
			CgMmOutItm cgMmOutItm = (CgMmOutItm) itm;
			switch (cgMmOutItm.getEu_direct()) {
			case SUPPLY:
				if (cgmmoutMap.get(SUPPLY) == null || cgmmoutMap.get(SUPPLY).size() <= 0) {
					List<CgMmOutItm> list = new ArrayList<CgMmOutItm>();
					list.add(cgMmOutItm);
					cgmmoutMap.put(SUPPLY, list);
				} else {
					cgmmoutMap.get(SUPPLY).add(cgMmOutItm);
				}
				break;
			case REFUND:
				if (cgmmoutMap.get(REFUND) == null || cgmmoutMap.get(REFUND).size() <= 0) {
					List<CgMmOutItm> list = new ArrayList<CgMmOutItm>();
					list.add(cgMmOutItm);
					cgmmoutMap.put(REFUND, list);
				} else {
					cgmmoutMap.get(REFUND).add(cgMmOutItm);
				}
				break;
			default:
				break;
			}
		}
		return cgmmoutMap;
	}

	/**
	 * 按照服务药品分组
	 * 
	 * @param param
	 * @return
	 */
	private Map<String, List<CgMmOutItm>> getSrvMmMap(IpRefundSupplyMmOutParamDTO param) {
		List<CgMmOutItm> mmlist = new ArrayList<CgMmOutItm>();
		List<CgMmOutItm> srvlist = new ArrayList<CgMmOutItm>();
		for (Object itm : param.getCgmmoutitm()) {
			CgMmOutItm cgMmOutItm = (CgMmOutItm) itm;
			if (StringUtils.isNotEmpty(cgMmOutItm.getCode_mm())) {
				mmlist.add(cgMmOutItm);
			} else if (StringUtils.isNotEmpty(cgMmOutItm.getCode_srv())) {
				srvlist.add(cgMmOutItm);
			}
		}

		Map<String, List<CgMmOutItm>> mmsrvMap = new HashMap<String, List<CgMmOutItm>>();
		if (mmlist.size() > 0) {
			mmsrvMap.put(MM, mmlist);
		}
		if (srvlist.size() > 0) {
			mmsrvMap.put(SRV, srvlist);
		}
		return mmsrvMap;
	}

	/**
	 * 获取科室基本信息
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	private Map<String, DeptDO> getDeptInfo(IpRefundSupplyMmOutParamDTO param) throws BizException {

		if (param == null || param.getCgmmoutitm() == null || param.getCgmmoutitm().size() <= 0) {
			return null;
		}

		FArrayList supplyItms = param.getCgmmoutitm();
		if (supplyItms == null || supplyItms.size() <= 0) {
			return null;
		}

		Set<String> codedeps = new HashSet<String>();
		for (Object object : supplyItms) {
			CgMmOutItm cgMmOutItm = (CgMmOutItm) object;
			codedeps.add(cgMmOutItm.getCode_dep_or());
			if (StringUtils.isNotEmpty(cgMmOutItm.getCode_dep_wh())) {
				codedeps.add(cgMmOutItm.getCode_dep_wh());
			}
			codedeps.add(cgMmOutItm.getCode_dep_mp());
			if (StringUtils.isNotEmpty(cgMmOutItm.getCode_dep_cg_detail())) {
				codedeps.add(cgMmOutItm.getCode_dep_cg_detail());
			}
		}

		if (StringUtils.isNotEmpty(param.getCode_dep_cg())) {
			codedeps.add(param.getCode_dep_cg());
		}

		IDeptRService depSrv = ServiceFinder.find(IDeptRService.class);
		DeptDO[] depts = depSrv.findByAttrValStrings(DeptDO.CODE, codedeps.toArray(new String[0]));

		if (depts == null || depts.length <= 0) {
			throw new BizException("入参传入的科室编码不存在！");
		}

		// 科室编码和查询科室集合差异比对
		if (codedeps.size() != depts.length) {
			for (DeptDO dept : depts) {
				if (codedeps.contains(dept.getCode())) {
					codedeps.remove(dept.getCode());
				}
			}

			StringBuilder errcode = new StringBuilder();
			for (String codedep : codedeps) {
				errcode.append("【");
				errcode.append(codedep);
				errcode.append("】");
			}
			throw new BizException(String.format("编码为%s的科室不存在", errcode));
		}

		Map<String, DeptDO> depMap = new HashMap<String, DeptDO>();
		for (DeptDO deptDO : depts) {
			depMap.put(deptDO.getCode(), deptDO);
		}
		return depMap;
	}

	/**
	 * 获取人员基本信息
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	private Map<String, PsnDocDO> getPsndocInfo(IpRefundSupplyMmOutParamDTO param) throws BizException {

		if (param == null || param.getCgmmoutitm() == null || param.getCgmmoutitm().size() <= 0) {
			return null;
		}

		FArrayList supplyItms = param.getCgmmoutitm();
		if (supplyItms == null || supplyItms.size() <= 0) {
			return null;
		}

		Set<String> codepsndocs = new HashSet<String>();
		for (Object object : supplyItms) {
			CgMmOutItm cgMmOutItm = (CgMmOutItm) object;
			codepsndocs.add(cgMmOutItm.getCode_emp_or());
			if (StringUtils.isNotEmpty(cgMmOutItm.getCode_emp_cg_detail())) {
				codepsndocs.add(cgMmOutItm.getCode_emp_cg_detail());
			}
		}

		if (StringUtils.isNotEmpty(param.getCode_emp_cg())) {
			codepsndocs.add(param.getCode_emp_cg());
		}

		IPsndocMDORService psndocMDORService = ServiceFinder.find(IPsndocMDORService.class);
		PsnDocDO[] psnDocDOs = psndocMDORService.findByAttrValStrings(DeptDO.CODE, codepsndocs.toArray(new String[0]));

		if (psnDocDOs == null || psnDocDOs.length <= 0) {
			throw new BizException("入参传入的人员编码不存在！");
		}

		// 科室编码和查询科室集合差异比对
		if (codepsndocs.size() != psnDocDOs.length) {
			for (PsnDocDO psnDocDO : psnDocDOs) {
				if (codepsndocs.contains(psnDocDO.getCode())) {
					codepsndocs.remove(psnDocDO.getCode());
				}
			}

			StringBuilder errcode = new StringBuilder();
			for (String codedep : codepsndocs) {
				errcode.append("【");
				errcode.append(codedep);
				errcode.append("】");
			}
			throw new BizException(String.format("编码为%s的人员不存在", errcode));
		}

		Map<String, PsnDocDO> psnMap = new HashMap<String, PsnDocDO>();
		for (PsnDocDO psnDocDO : psnDocDOs) {
			psnMap.put(psnDocDO.getCode(), psnDocDO);
		}
		return psnMap;
	}

	/**
	 * 获取服务信息
	 * 
	 * @param srvmmMap
	 * @return
	 * @throws BizException
	 */
	private Map<String, MedSrvDO> getSrvInfo(Map<String, List<CgMmOutItm>> srvmmMap) throws BizException {

		List<CgMmOutItm> cgMmOutItms = srvmmMap.get(SRV);
		if (cgMmOutItms == null || cgMmOutItms.size() <= 0) {
			return null;
		}

		Set<String> codesrvs = new HashSet<String>();
		for (CgMmOutItm cgMmOutItm : cgMmOutItms) {
			codesrvs.add(cgMmOutItm.getCode_srv());
		}

		IMedsrvMDORService medsrvMDORService = ServiceFinder.find(IMedsrvMDORService.class);
		MedSrvDO[] medSrvDOs = medsrvMDORService.findByAttrValStrings(MeterialDO.CODE, codesrvs.toArray(new String[0]));

		if (medSrvDOs == null || medSrvDOs.length <= 0) {
			throw new BizException("入参传入的服务编码不存在！");
		}

		if (codesrvs.size() != medSrvDOs.length) {
			for (MedSrvDO medSrvDO : medSrvDOs) {
				if (codesrvs.contains(medSrvDO.getCode())) {
					codesrvs.remove(medSrvDO.getCode());
				}
			}

			StringBuilder errcode = new StringBuilder();
			for (String codedep : codesrvs) {
				errcode.append("【");
				errcode.append(codedep);
				errcode.append("】");
			}
			throw new BizException(String.format("编码为%s的服务不存在", errcode));
		}

		Map<String, MedSrvDO> map = new HashMap<String, MedSrvDO>();
		for (MedSrvDO medSrvDO : medSrvDOs) {
			map.put(medSrvDO.getCode(), medSrvDO);
		}
		return map;
	}

	/**
	 * 获取物品信息
	 * 
	 * @param srvmmMap
	 * @return
	 * @throws BizException
	 */
	private Map<String, MeterialDO> getMmInfo(Map<String, List<CgMmOutItm>> srvmmMap) throws BizException {

		List<CgMmOutItm> cgMmOutItms = srvmmMap.get(MM);
		if (cgMmOutItms == null || cgMmOutItms.size() <= 0) {
			return null;
		}

		Set<String> codemms = new HashSet<String>();
		for (CgMmOutItm cgMmOutItm : cgMmOutItms) {
			codemms.add(cgMmOutItm.getCode_mm());
		}

		IMeterialMDORService meterialMDORService = ServiceFinder.find(IMeterialMDORService.class);
		MeterialDO[] meterialDOs = meterialMDORService.findByAttrValStrings(MeterialDO.CODE,
				codemms.toArray(new String[0]));

		if (meterialDOs == null || meterialDOs.length <= 0) {
			throw new BizException("入参传入的物品编码不存在！");
		}

		if (codemms.size() != meterialDOs.length) {
			for (MeterialDO meterialDO : meterialDOs) {
				if (codemms.contains(meterialDO.getCode())) {
					codemms.remove(meterialDO.getCode());
				}
			}

			StringBuilder errcode = new StringBuilder();
			for (String codedep : codemms) {
				errcode.append("【");
				errcode.append(codedep);
				errcode.append("】");
			}
			throw new BizException(String.format("编码为%s的物品不存在", errcode));
		}

		Map<String, MeterialDO> map = new HashMap<String, MeterialDO>();
		for (MeterialDO meterialDO : meterialDOs) {
			map.put(meterialDO.getCode(), meterialDO);
		}
		return map;
	}

	/**
	 * 获取包装单位信息
	 * 
	 * @param srvmmMap
	 * @param mmMap
	 * @return
	 * @throws BizException
	 */
	private Map<String, MMPackageUnitDO> getPkguInfo(Map<String, List<CgMmOutItm>> srvmmMap,
			Map<String, MeterialDO> mmMap) throws BizException {

		List<CgMmOutItm> mmList = srvmmMap.get(MM);
		if (mmList == null || mmList.size() <= 0) {
			return null;
		}

		Set<String> codeunits = new HashSet<String>();
		for (CgMmOutItm cgMmOutItm : mmList) {
			if (StringUtils.isEmpty(cgMmOutItm.getCode_unit())) {
				// 单位不填默认为基本包装单位
				cgMmOutItm.setCode_unit(mmMap.get(cgMmOutItm.getCode_mm()).getPkgbase_code());
			}
			codeunits.add(cgMmOutItm.getCode_unit());
		}

		IMeasdocRService measdocRService = ServiceFinder.find(IMeasdocRService.class);
		MeasDocDO[] measDocDOs = measdocRService.findByAttrValStrings(MeasDocDO.CODE, codeunits.toArray(new String[0]));

		if (measDocDOs == null || measDocDOs.length <= 0) {
			throw new BizException("入参传入的单位编码不存在！");
		}

		if (codeunits.size() != measDocDOs.length) {
			for (MeasDocDO measDocDO : measDocDOs) {
				if (codeunits.contains(measDocDO.getCode())) {
					codeunits.remove(measDocDO.getCode());
				}
			}

			StringBuilder errcode = new StringBuilder();
			for (String codedep : codeunits) {
				errcode.append("【");
				errcode.append(codedep);
				errcode.append("】");
			}
			throw new BizException(String.format("编码为%s的单位不存在", errcode));
		}

		Map<String, MeasDocDO> unitMap = new HashMap<String, MeasDocDO>();
		for (MeasDocDO measDocDO : measDocDOs) {
			unitMap.put(measDocDO.getCode(), measDocDO);
		}

		Set<String> set = new HashSet<String>();
		Set<String> idmmset = new HashSet<String>();
		Set<String> idunitset = new HashSet<String>();
		for (CgMmOutItm itm : mmList) {
			idmmset.add(mmMap.get(itm.getCode_mm()).getId_mm());
			idunitset.add(unitMap.get(itm.getCode_unit()).getId_measdoc());
			set.add(mmMap.get(itm.getCode_mm()).getId_mm() + SPLIT + unitMap.get(itm.getCode_unit()).getId_measdoc()
					+ SPLIT + itm.getCode_mm() + SPLIT + itm.getCode_unit());
		}

		String idmm = SqlUtils.getInSqlByIds("id_mm", idmmset.toArray(new String[0]));
		String idwh = SqlUtils.getInSqlByIds("id_unit_pkg", idunitset.toArray(new String[0]));
		String wherecondition = String.format(" %s and %s ", idmm, idwh);

		IMMPackageUnitDORService mmPackageUnitDORService = ServiceFinder.find(IMMPackageUnitDORService.class);
		MMPackageUnitDO[] mmPackageUnitDOs = mmPackageUnitDORService.find(wherecondition, "", FBoolean.FALSE);

		Map<String, MMPackageUnitDO> pkguMap = new HashMap<String, MMPackageUnitDO>();
		for (String value : set) {
			String[] ids = value.split(SPLIT);
			FBoolean flag = FBoolean.TRUE;
			for (MMPackageUnitDO mmPackageUnitDO : mmPackageUnitDOs) {
				if (ids[0].equals(mmPackageUnitDO.getId_mm()) && ids[1].equals(mmPackageUnitDO.getId_unit_pkg())) {
					pkguMap.put(ids[2] + ids[3], mmPackageUnitDO);
					flag = FBoolean.FALSE;
					break;
				}
			}
			if (flag.booleanValue()) {
				throw new BizException(String.format("获取物品包装单位信息失败，入参物品编码：%s 入参单位编码：%s", ids[2], ids[3]));
			}
		}
		return pkguMap;
	}

	/**
	 * 住院补费用接口
	 * 
	 * @param patiVisitDO
	 * @param param
	 * @param eudirectMap
	 * @param srvMap
	 * @param mmMap
	 * @param mmpkguMap
	 * @param deptMap
	 * @param psnMap
	 * @throws BizException
	 */
	private void ipSupplyFee(PatiVisitDO patiVisitDO, IpRefundSupplyMmOutParamDTO param,
			Map<String, List<CgMmOutItm>> eudirectMap, Map<String, MedSrvDO> srvMap, Map<String, MeterialDO> mmMap,
			Map<String, MMPackageUnitDO> mmpkguMap, Map<String, DeptDO> deptMap, Map<String, PsnDocDO> psnMap)
			throws BizException {

		List<CgMmOutItm> cgMmOutItms = eudirectMap.get(SUPPLY);

		if (cgMmOutItms == null || cgMmOutItms.size() <= 0) {
			return;
		}

		for (int i = 0; i < cgMmOutItms.size(); i++) {

			CgMmOutItm cgMmOutItm = cgMmOutItms.get(i);

			DeliverResultDTO deliverResultDTO = mmOut(cgMmOutItm, mmMap, deptMap, mmpkguMap);

			BlCgAccountDTO blCgAccountDTO = ConverToSupplyDto(patiVisitDO, param, cgMmOutItm, srvMap, mmMap, mmpkguMap,
					deptMap, psnMap);

			BlCgAccountSetDTO accountSetDTO = new BlCgAccountSetDTO();
			if (StringUtils.isNotEmpty(param.getCode_emp_cg())) {
				accountSetDTO.setId_emp_cg(psnMap.get(param.getCode_emp_cg()).getId_psndoc());
			}
			if (StringUtils.isNotEmpty(param.getCode_dep_cg())) {
				accountSetDTO.setId_dep_cg(deptMap.get(param.getCode_dep_cg()).getId_dep());
			}
			if (StringUtils.isNotEmpty(param.getDt_cg())) {
				try {
					accountSetDTO.setDt_cg(new FDateTime(param.getDt_cg()));
				} catch (Exception e) {
					throw new BizException(String.format("记账时间【%s】异常！异常信息：%s", param.getDt_cg(), e.toString()));
				}
			}
			if (StringUtils.isNotEmpty(param.getFg_price_cal())) {
				accountSetDTO.setFg_price_cal(new FBoolean(param.getFg_price_cal()));
			}
			accountSetDTO.setFg_addfee(FBoolean.TRUE);
			accountSetDTO.setSrcfunc_des(IBlCgFuncConst.FUNC_IPMP_OTADDCOST);
			// 调用补费接口
			IBlCgAccountService blCgAccountService = ServiceFinder.find(IBlCgAccountService.class);
			BlCgAccountRltDTO blCgAccountRltDTO = blCgAccountService
					.keepAccountForIp(new BlCgAccountDTO[] { blCgAccountDTO }, accountSetDTO);

			if (deliverResultDTO != null) {
				if (blCgAccountRltDTO == null || blCgAccountRltDTO.getCglist() == null
						|| blCgAccountRltDTO.getCglist().size() <= 0) {
					throw new BizException(String.format("编码【%s】补费异常！", StringUtils.isNotEmpty(cgMmOutItm.getCode_mm())
							? cgMmOutItm.getCode_mm() : cgMmOutItm.getCode_srv()));
				}
				BlCgIpDO blCgIpDO = (BlCgIpDO) blCgAccountRltDTO.getCglist().get(0);

				IStockOutItemDORService stockOutItemDORService = ServiceFinder.find(IStockOutItemDORService.class);
				StockOutItemDO[] stockOutItemDOs = stockOutItemDORService.findByAttrValString(StockOutItemDO.ID_OUT,
						deliverResultDTO.getId_order());
				if (stockOutItemDOs == null || stockOutItemDOs.length <= 0) {
					throw new BizException(String.format("物品编码【%s】未查询到出库信息！", cgMmOutItm.getCode_mm()));
				}

				stockOutItemDOs[0].setId_source(blCgIpDO.getId_cgip());
				stockOutItemDOs[0].setStatus(DOStatus.UPDATED);
				IStockOutItemDOCudService stockOutItemDOCudService = ServiceFinder
						.find(IStockOutItemDOCudService.class);
				stockOutItemDOCudService.save(stockOutItemDOs);
			}
		}
	}

	/**
	 * 住院退费接口
	 * 
	 * @param patiVisitDO
	 * @param param
	 * @param eudirectMap
	 * @param srvMap
	 * @param mmMap
	 * @param mmpkguMap
	 * @param deptMap
	 * @param psnMap
	 * @throws BizException
	 */
	private void ipRefundFee(PatiVisitDO patiVisitDO, IpRefundSupplyMmOutParamDTO param,
			Map<String, List<CgMmOutItm>> eudirectMap, Map<String, MedSrvDO> srvMap, Map<String, MeterialDO> mmMap,
			Map<String, MMPackageUnitDO> mmpkguMap, Map<String, DeptDO> deptMap, Map<String, PsnDocDO> psnMap)
			throws BizException {

		List<CgMmOutItm> refundlist = eudirectMap.get(REFUND);

		if (refundlist == null || refundlist.size() <= 0) {
			return;
		}

		// 获取本次就诊未退费的正向记账数据
		String whereStr = String.format("id_ent = '%s' and fg_refund = 'N' and eu_direct = 1 and fg_additm = 'Y'",
				patiVisitDO.getId_ent());
		IBlcgqueryRService iBlcgqueryRService = ServiceFinder.find(IBlcgqueryRService.class);
		BlCgIpDO[] blCgIpDOs = iBlcgqueryRService.find(whereStr.toString(), " dt_or desc", FBoolean.FALSE);

		if (ArrayUtil.isEmpty(blCgIpDOs)) {
			throw new BizException("未获取到本次就诊的正向记账数据");
		}
		List<BlCgIpDO> blCgIpDOList = new ArrayList<>();
		for (BlCgIpDO blCgIpDO : blCgIpDOs) {
			blCgIpDOList.add(blCgIpDO);
		}

		List<BlCgRefundAccountDTO> refundList = new ArrayList<BlCgRefundAccountDTO>();
		Map<String, ReturnItemDTO> returnItemMap = new HashMap<String, ReturnItemDTO>();
		Iterator<BlCgIpDO> iterator = blCgIpDOList.iterator();
		for (CgMmOutItm cgMmOutItm : refundlist) {
			String errmsg = null;
			FBoolean flag = FBoolean.TRUE;
			
			while (iterator.hasNext()) {
				BlCgIpDO blCgIpDO = iterator.next();
				if (StringUtils.isNotEmpty(cgMmOutItm.getCode_mm())
						&& mmMap.get(cgMmOutItm.getCode_mm()).getId_mm().equals(blCgIpDO.getId_mm())) {

					if (!blCgIpDO.getSrvu()
							.equals(mmpkguMap.get(cgMmOutItm.getCode_mm() + cgMmOutItm.getCode_unit()).getId_mmpkgu())
							|| blCgIpDO.getPrice().compareTo(new FDouble(cgMmOutItm.getPrice())) != 0) {
						continue;
					}

					if (blCgIpDO.getQuan().sub(blCgIpDO.getQuan_ret())
							.compareTo(new FDouble(cgMmOutItm.getQuan())) < 0) {
						errmsg = String.format("物品编码【%s】的可退数量小于退费数量！", cgMmOutItm.getCode_mm());
						continue;
					}
					
					BlCgRefundAccountDTO refundAccountDTO = converToRefundDto(blCgIpDO, cgMmOutItm);
					refundList.add(refundAccountDTO);
					ReturnItemDTO returnItemDTO = converToReturnItm(cgMmOutItm, blCgIpDO, mmpkguMap);
					returnItemMap.put(blCgIpDO.getId_cgip(), returnItemDTO);
					iterator.remove();
					flag = FBoolean.FALSE;
					break;

				} else if (StringUtils.isNotEmpty(cgMmOutItm.getCode_srv())
						&& srvMap.get(cgMmOutItm.getCode_srv()).getId_srv().equals(blCgIpDO.getId_srv())
						&& blCgIpDO.getPrice().compareTo(new FDouble(cgMmOutItm.getPrice())) == 0) {

					if (blCgIpDO.getQuan().sub(blCgIpDO.getQuan_ret())
							.compareTo(new FDouble(cgMmOutItm.getQuan())) < 0) {
						errmsg = String.format("服务编码【%s】的可退数量小于退费数量！", cgMmOutItm.getCode_srv());
						continue;
					} 
					BlCgRefundAccountDTO refundAccountDTO = converToRefundDto(blCgIpDO, cgMmOutItm);
					refundList.add(refundAccountDTO);
					iterator.remove();
					flag = FBoolean.FALSE;
					break;
				}
			}
			
			if (flag.booleanValue()) {
				if (errmsg != null) {
					throw new BizException(errmsg);
				}else {
					throw new BizException(
							String.format("编码为【%s】的未查询到正向记账数据！", StringUtils.isNotEmpty(cgMmOutItm.getCode_mm())
									? cgMmOutItm.getCode_mm() : cgMmOutItm.getCode_srv()));
				}
			}
		}
		// 调用退费接口
		BlCgRefundAccountSetDTO blCgRefundAccountSetDTO = new BlCgRefundAccountSetDTO();
		if (StringUtils.isNotEmpty(param.getCode_emp_cg())) {
			blCgRefundAccountSetDTO.setId_emp_cg(psnMap.get(param.getCode_emp_cg()).getId_psndoc());
		}
		if (StringUtils.isNotEmpty(param.getCode_dep_cg())) {
			blCgRefundAccountSetDTO.setId_dep_cg(deptMap.get(param.getCode_dep_cg()).getId_dep());
		}
		if (StringUtils.isNotEmpty(param.getDt_cg())) {
			try {
				blCgRefundAccountSetDTO.setDt_cg(new FDateTime(param.getDt_cg()));
			} catch (Exception e) {
				throw new BizException(String.format("记账时间【%s】异常！异常信息：%s", param.getDt_cg(), e.toString()));
			}
		}

		blCgRefundAccountSetDTO.setSrcfunc_des(IBlCgFuncConst.FUNC_IPMP_OTADDCOST);
		blCgRefundAccountSetDTO.setEu_rfdmode(RefundModeEnum.CG_KEY);

		IBlCgAccountService blCgAccountService = ServiceFinder.find(IBlCgAccountService.class);
		blCgAccountService.refundAccountForIp(refundList.toArray(new BlCgRefundAccountDTO[] {}),
				blCgRefundAccountSetDTO);

		//红字出库
		redMmOut(returnItemMap);
	}



	/**
	 * 组装计费DTO
	 * 
	 * @param blCgIpDO
	 * @param cgMmOutItm
	 * @return
	 */
	private BlCgRefundAccountDTO converToRefundDto(BlCgIpDO blCgIpDO, CgMmOutItm cgMmOutItm) {
		BlCgRefundAccountDTO refundDto = new BlCgRefundAccountDTO();
		refundDto.setId_ent(blCgIpDO.getId_ent());
		refundDto.setId_pat(blCgIpDO.getId_pat());
		refundDto.setId_cg(blCgIpDO.getId_cgip());
		refundDto.setQuan(new FDouble(cgMmOutItm.getQuan()));
		return refundDto;
	}

	/**
	 * 
	 * @param cgMmOutItm
	 * @param blCgIpDO
	 * @param mmpkguMap
	 * @return
	 */
	private ReturnItemDTO converToReturnItm(CgMmOutItm cgMmOutItm, BlCgIpDO blCgIpDO,
			Map<String, MMPackageUnitDO> mmpkguMap) {
		ReturnItemDTO returnItemDTO = new ReturnItemDTO();
		returnItemDTO.setId_mm(blCgIpDO.getId_mm());
		returnItemDTO.setReq_num(new FDouble(cgMmOutItm.getQuan()));
		returnItemDTO
				.setReq_unit_id(mmpkguMap.get(cgMmOutItm.getCode_mm() + cgMmOutItm.getCode_unit()).getId_unit_pkg());
		//计费出库不存在预留，所以随便赋值，防止退药接口空校验出错
		returnItemDTO.setId_orsrv("1");
		return returnItemDTO;
	}

	/**
	 * 出库
	 * 
	 * @param cgMmOutItm
	 * @param mmMap
	 * @param deptMap
	 * @param mmpkguMap
	 * @return
	 * @throws BizException
	 */
	private DeliverResultDTO mmOut(CgMmOutItm cgMmOutItm, Map<String, MeterialDO> mmMap, Map<String, DeptDO> deptMap,
			Map<String, MMPackageUnitDO> mmpkguMap) throws BizException {

		if (StringUtils.isEmpty(cgMmOutItm.getCode_mm())) {
			return null;
		}

		String whdep = deptMap.get(cgMmOutItm.getCode_dep_wh()).getId_dep();
		String ordep = deptMap.get(cgMmOutItm.getCode_dep_or()).getId_dep();

		DirectDeliverReqDTO reqDTO = new DirectDeliverReqDTO();
		reqDTO.setId_mm(mmMap.get(cgMmOutItm.getCode_mm()).getId_mm());
		reqDTO.setReq_unit_id(mmpkguMap.get(cgMmOutItm.getCode_mm() + cgMmOutItm.getCode_unit()).getId_mmpkgu());
		reqDTO.setReq_num(new FDouble(cgMmOutItm.getQuan()));
		reqDTO.setSd_sttp(IBdMmDictCodeConst.SD_STTP_OUT_SUPPLY);

		IMaterialStockService materialStockService = ServiceFinder.find(IMaterialStockService.class);
		DeliverResultDTO deliverResultDTO = materialStockService.directDeliver(whdep, ordep,
				new DirectDeliverReqDTO[] { reqDTO });
		if (deliverResultDTO == null || deliverResultDTO.getDeliveritems() == null
				|| deliverResultDTO.getDeliveritems().size() <= 0) {
			throw new BizException(String.format("物品编码【%s】出库异常！", cgMmOutItm.getCode_mm()));
		}
		DeliverResultItemDTO dItem = (DeliverResultItemDTO) deliverResultDTO.getDeliveritems().get(0);
		cgMmOutItm.setPrice(dItem.getPri_sa().toString());
		return deliverResultDTO;
	}
	
	/**
	 * 红字出库
	 * 
	 * @param returnItemMap
	 * @throws BizException
	 */
	private void redMmOut(Map<String, ReturnItemDTO> returnItemMap) throws BizException {
		
		if (returnItemMap == null || returnItemMap.size() <= 0) {
			return;
		}

		IStockOutItemDORService stockOutItemDORService = ServiceFinder.find(IStockOutItemDORService.class);
		StockOutItemDO[] stockOutItemDOs = stockOutItemDORService.findByAttrValStrings(StockOutItemDO.ID_SOURCE,
				returnItemMap.keySet().toArray(new String[0]));

		if (stockOutItemDOs == null || stockOutItemDOs.length <= 0) {
			throw new BizException("出库单明细未查询到退费待红字出库信息！");
		}

		if (stockOutItemDOs.length != returnItemMap.keySet().size()) {
			throw new BizException("退费信息和待红字出库信息不匹配!");
		}

		for (StockOutItemDO stockOutItemDO : stockOutItemDOs) {
			ReturnItemDTO returnItemDTO = returnItemMap.get(stockOutItemDO.getId_source());
			if (returnItemDTO == null) {
				throw new BizException("退费退库信息获取失败！");
			}
			returnItemDTO.setId_out(stockOutItemDO.getId_out());
		}

		Map<String, List<ReturnItemDTO>> outMap = new HashMap<String, List<ReturnItemDTO>>();
		for (Entry<String, ReturnItemDTO> entry : returnItemMap.entrySet()) {
			ReturnItemDTO returnItemDTO = entry.getValue();
			if (outMap.containsKey(returnItemDTO.getId_out())) {
				outMap.get(returnItemDTO.getId_out()).add(returnItemDTO);
			} else {
				List<ReturnItemDTO> list = new LinkedList<ReturnItemDTO>();
				list.add(returnItemDTO);
				outMap.put(returnItemDTO.getId_out(), list);
			}
		}

		IMaterialStockService materialStockService = ServiceFinder.find(IMaterialStockService.class);
		for (Entry<String, List<ReturnItemDTO>> entry : outMap.entrySet()) {
			materialStockService.returnMaterial(entry.getKey(), entry.getValue().toArray(new ReturnItemDTO[0]));
		}
		
	}

	/**
	 * IpRefundSupplyMmOutParamDTO转换为IpRefundSupplyParamDTO
	 * 
	 * @param patiVisitDO
	 * @param param
	 * @param cgMmOutItm
	 * @param mmMap
	 * @param srvMap
	 * @param deptMap
	 * @param mmpkguMap
	 * @param psnMap
	 * @return
	 * @throws BizException
	 */
	private BlCgAccountDTO ConverToSupplyDto(PatiVisitDO patiVisitDO, IpRefundSupplyMmOutParamDTO param,
			CgMmOutItm cgMmOutItm, Map<String, MedSrvDO> srvMap, Map<String, MeterialDO> mmMap,
			Map<String, MMPackageUnitDO> mmpkguMap, Map<String, DeptDO> deptMap, Map<String, PsnDocDO> psnMap)
			throws BizException {

		BlCgAccountDTO blCgAccountDTO = new BlCgAccountDTO();
		blCgAccountDTO.setId_ent(patiVisitDO.getId_ent());
		blCgAccountDTO.setId_pat(patiVisitDO.getId_pat());
		if (StringUtils.isNotEmpty(cgMmOutItm.getCode_mm())) {
			blCgAccountDTO.setFg_mm(FBoolean.TRUE);
			blCgAccountDTO.setId_srv(mmMap.get(cgMmOutItm.getCode_mm()).getId_srv());
			blCgAccountDTO.setId_mm(mmMap.get(cgMmOutItm.getCode_mm()).getId_mm());
			blCgAccountDTO
					.setId_pkgu_cur(mmpkguMap.get(cgMmOutItm.getCode_mm() + cgMmOutItm.getCode_unit()).getId_mmpkgu());
			blCgAccountDTO.setPrice_std(new FDouble(cgMmOutItm.getPrice()));
			blCgAccountDTO.setPrice_ratio(new FDouble(cgMmOutItm.getPrice()));
			// blCgAccountDTO.setBatch(batch);
		} else if (StringUtils.isNotEmpty(cgMmOutItm.getCode_srv())) {
			blCgAccountDTO.setId_srv(srvMap.get(cgMmOutItm.getCode_srv()).getId_srv());
			blCgAccountDTO.setId_unit_srv(srvMap.get(cgMmOutItm.getCode_srv()).getId_unit_med());
			if (!new FBoolean(param.getFg_price_cal()).booleanValue()) {
				blCgAccountDTO.setPrice_std(new FDouble(cgMmOutItm.getPrice()));
				blCgAccountDTO.setPrice_ratio(new FDouble(cgMmOutItm.getPrice()));
			}
		}
		blCgAccountDTO.setQuan(new FDouble(cgMmOutItm.getQuan()));
		blCgAccountDTO.setRatio_pripat(new FDouble(1));
		blCgAccountDTO.setOnly_code(cgMmOutItm.getCode_only());
		blCgAccountDTO.setEu_direct(BookRtnDirectEnum.CHARGE);
		blCgAccountDTO.setId_dep_or(deptMap.get(cgMmOutItm.getCode_dep_or()).getId_dep());
		blCgAccountDTO.setId_emp_or(psnMap.get(cgMmOutItm.getCode_emp_or()).getId_psndoc());
		blCgAccountDTO.setId_dep_mp(deptMap.get(cgMmOutItm.getCode_dep_mp()).getId_dep());
		if (StringUtils.isNotEmpty(cgMmOutItm.getCode_mm())) {
			blCgAccountDTO.setId_dep_wh(deptMap.get(cgMmOutItm.getCode_dep_wh()).getId_dep());
		}
		blCgAccountDTO.setFg_addfee(FBoolean.TRUE);
		blCgAccountDTO.setId_pripat(patiVisitDO.getId_pripat());

		if (StringUtils.isNotEmpty(cgMmOutItm.getDt_cg_detail())) {
			try {
				blCgAccountDTO.setDt_cg_detail(new FDateTime(cgMmOutItm.getDt_cg_detail()));
			} catch (Exception e) {
				throw new BizException(
						String.format("明细记账时间【%s】异常！异常信息：%s", cgMmOutItm.getDt_cg_detail(), e.toString()));
			}
		}
		if (StringUtils.isNotEmpty(cgMmOutItm.getCode_dep_cg_detail())) {
			blCgAccountDTO.setId_dep_cg_detail(deptMap.get(cgMmOutItm.getCode_dep_cg_detail()).getId_dep());
		}
		if (StringUtils.isNotEmpty(cgMmOutItm.getCode_emp_cg_detail())) {
			blCgAccountDTO.setId_emp_cg_detail(psnMap.get(cgMmOutItm.getCode_emp_cg_detail()).getId_psndoc());
		}
		return blCgAccountDTO;
	}
	
	private List<MedSrvDO> getMedSrvDOs(FArrayList list) throws BizException{
		StringBuilder sqlStrBuf = new StringBuilder();
		sqlStrBuf.append("SELECT SRV.CODE, SRV.NAME, SRV.FG_ACTIVE, SRV.FG_ACTIVE_BL, PRI.DT_E MODIFIEDTIME");
		sqlStrBuf.append("  FROM BD_SRV SRV");
		sqlStrBuf.append(" INNER JOIN (SELECT ID_SRV, MAX(DT_E) DT_E FROM BD_PRI_SRV GROUP BY ID_SRV) PRI");
		sqlStrBuf.append("    ON SRV.ID_SRV = PRI.ID_SRV");
		sqlStrBuf.append(" WHERE 1 = 1");
		new BdEnvContextUtil();
		// 新增管控过滤
		String modeWherePart = BdEnvContextUtil.processEnvContext(new MedSrvDO(), "SRV");
		if (StringUtils.isNotEmpty(modeWherePart)) {
			sqlStrBuf.append(String.format(" AND %s ", modeWherePart));
		}
		sqlStrBuf.append("   AND SRV.CODE IN (?");
		for (int i = 1; i < list.size(); i++) {
			sqlStrBuf.append(", ?");
		}
		sqlStrBuf.append(")");
		SqlParam sqlParam = new SqlParam();
		for (Object object : list) {
			CgMmOutItm cgMmOutItm = (CgMmOutItm) object;
			sqlParam.addParam(cgMmOutItm.getCode_srv());
		}
		List<MedSrvDO> medSrvDOs = (List<MedSrvDO>) new DAFacade().execQuery(sqlStrBuf.toString(), sqlParam,
				new BeanListHandler(MedSrvDO.class));
		return medSrvDOs;
	}
		
}
