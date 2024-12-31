package iih.ei.std.s.v1.bp.bl;

import java.util.ArrayList;
import java.util.List;

import iih.bd.base.utils.CollectionUtils;
import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.mm.meterial.i.IMeterialMDORService;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import iih.bl.cg.blcgquery.d.BlCgIpDO;
import iih.bl.cg.blcgquery.i.IBlcgqueryRService;
import iih.bl.cg.dto.cglogic.d.BlCgAccountDTO;
import iih.bl.cg.dto.cglogic.d.BlCgAccountSetDTO;
import iih.bl.cg.dto.cglogic.d.BlCgRefundAccountDTO;
import iih.bl.cg.dto.cglogic.d.BlCgRefundAccountSetDTO;
import iih.bl.cg.dto.cglogic.d.RefundModeEnum;
import iih.bl.cg.i.IBlCgAccountService;
import iih.bl.cg.service.udi.IBlCgCodeConst;
import iih.bl.pay.blpaypat.d.BookRtnDirectEnum;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.i.ICiorderMDORService;
import iih.ei.std.d.v1.bl.iprefundsupplydto.d.CgItm;
import iih.ei.std.d.v1.bl.iprefundsupplydto.d.IpRefundSupplyParamDTO;
import iih.ei.std.d.v1.commdto.d.NoParamDTO;
import iih.ei.std.s.v1.bp.IIHServiceBaseBP;
import iih.ei.std.s.v1.bp.bl.utils.BlAmtConverUtil;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.mm.itf.material.d.GetMaterialPriceDTO;
import iih.mm.itf.material.i.IMaterialBaseInfoService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.orgfw.dept.d.DeptDO;
import xap.sys.orgfw.dept.i.IDeptRService;

/***
 * 住院退补费(重构)
 * 
 * @author shaokx
 * @date: 2019.10.18
 */
public class IpRefundSupplyFeeBP extends IIHServiceBaseBP<IpRefundSupplyParamDTO, NoParamDTO> {

	@Override
	protected void checkParam(IpRefundSupplyParamDTO param) throws BizException {

		if (param == null) {
			throw new BizException("入参为空");
		}

		if (StringUtil.isEmptyWithTrim(param.getCode_pat())) {
			throw new BizException("患者编码为空");
		}

		if (StringUtil.isEmptyWithTrim(param.getTimes_ip())) {
			throw new BizException("住院次数为空");
		}

		if (StringUtil.isEmptyWithTrim(param.getCode_dep_mp())) {
			throw new BizException("执行科室为空");
		}

		if (StringUtil.isEmpty(param.getCode_dep_or())) {
			throw new BizException("开立科室为空");
		}

		if (StringUtil.isEmpty(param.getEu_direct())) {
			throw new BizException("补退费方向为空");
		}

		if (!"1".equals(param.getEu_direct()) && !"-1".equals(param.getEu_direct())) {
			throw new BizException("补退费方向值不正确");
		}

		FArrayList arr = param.getCgitm();

		if (CollectionUtils.isEmpty(arr)) {
			throw new BizException("入参记账明细为空");
		}

		for (Object itm : arr) {
			CgItm cgItm = (CgItm) itm;

			if (StringUtil.isEmpty(cgItm.getCode_srv()) && StringUtil.isEmpty(cgItm.getCode_mm())) {
				throw new BizException("入参记账明细服务编码和物品编码不能同时为空");
			}

			if (!StringUtil.isEmpty(cgItm.getCode_srv()) && !StringUtil.isEmpty(cgItm.getCode_mm())) {
				throw new BizException("入参记账明细服务编码和物品编码只能一个有值");
			}

			if (StringUtil.isEmpty(cgItm.getQuan())) {
				throw new BizException("入参记账明细数量为空");
			}
			
			if(new FDouble(cgItm.getQuan()).compareTo(new FDouble().ZERO_DBL) <= 0){
				throw new BizException("入参记账明细数量不能小于等于0");
			}

			if (StringUtil.isEmpty(cgItm.getPrice())) {
				throw new BizException("入参记账明细单价为空");
			}

			if (StringUtil.isEmpty(cgItm.getAmt())) {
				throw new BizException("入参记账明细金额为空");
			}
		}
		
		if (!StringUtil.isEmpty(param.getCode_emp_cg())) {
			// 设置人员上下文
			PsnDocDO psndocDO = BlAmtConverUtil.getPsnInfo(param.getCode_emp_cg());
			if (psndocDO == null) {
				throw new BizException("住院退补费:未查询到记账人员信息");
			}
			Context.get().setStuffId(psndocDO.getId_psndoc());
		}

	}

	@Override
	protected NoParamDTO process(IpRefundSupplyParamDTO param) throws BizException {

		// 获取患者就诊信息
		PatiVisitDO patiVisitDO = this.initPatiVisitInfo(param);

		if (FBoolean.TRUE.equals(patiVisitDO.getFg_st())) {
			throw new BizException("该患者已经出院结算，不允许记费或退费");
		}

		// 获取执行科室和开立科室的id
		String mpDepId = this.initDeptId(param.getCode_dep_mp());
		String orDepId = this.initDeptId(param.getCode_dep_or());

		// 根据医嘱编码查找医嘱信息
		CiOrderDO ciOrderDO = null;
		if (!StringUtil.isEmpty(param.getCode_or())) {
			ciOrderDO = this.initOrderInfo(param.getCode_or());
		}

		// 补退费
		if ("1".equals(param.getEu_direct())) {
			// 补费
			this.supplyFee(param, patiVisitDO, ciOrderDO, mpDepId, orDepId);
		} else {
			// 退费
			this.refundFee(param, patiVisitDO, ciOrderDO, mpDepId, orDepId);
		}

		return new NoParamDTO();
	}

	/**
	 * 住院补费
	 * 
	 * @param param
	 * @param patiVistDO
	 * @param ciOrderDO
	 * @param mpDepId
	 * @param orDepId
	 * @throws BizException
	 */
	private void supplyFee(IpRefundSupplyParamDTO param, PatiVisitDO patiVistDO, CiOrderDO ciOrderDO, String mpDepId,
			String orDepId) throws BizException {
		// 获取服务记账集合
		MedSrvDO[] srvCgArr = this.getSvrCgArr(param);
		// 获取物品记账集合
		MeterialDO[] mmCgArr = this.getMmCgArr(param);
		// 组装入参
		List<BlCgAccountDTO> blCgAccountDTOList = new ArrayList<BlCgAccountDTO>();
		if (!ArrayUtil.isEmpty(srvCgArr)) {
			for (MedSrvDO itm : srvCgArr) {
				// 获取这个服务的入参其他信息
				CgItm cgItm = new CgItm();
				for (Object itm1 : param.getCgitm()) {
					cgItm = (CgItm) itm1;
					if (itm.getCode().equals(cgItm.getCode_srv())) {
						break;
					}
				}
				// 组装这个服务的补费信息
				BlCgAccountDTO blCgAccountDTO = this.getSrvSupplyItmInfo(param,patiVistDO, ciOrderDO, itm, null, cgItm,
						mpDepId, orDepId);
				
				blCgAccountDTOList.add(blCgAccountDTO);
			}
		}

		if (!ArrayUtil.isEmpty(mmCgArr)) {
			for (MeterialDO itm : mmCgArr) {
				// 获取这个物品的入参其他信息
				CgItm cgItm = new CgItm();
				for (Object itm1 : param.getCgitm()) {
					cgItm = (CgItm) itm1;
					if (itm.getCode().equals(cgItm.getCode_mm())) {
						break;
					}
				}

				// 组装这个物品的补费信息
				BlCgAccountDTO blCgAccountDTO = this.getSrvSupplyItmInfo(param,patiVistDO, ciOrderDO, null, itm, cgItm,
						mpDepId, orDepId);
				blCgAccountDTOList.add(blCgAccountDTO);
			}
		}

		BlCgAccountSetDTO blCgAccountSetDTO = new BlCgAccountSetDTO();
		blCgAccountSetDTO.setFg_exception(FBoolean.TRUE); // 抛异常
		blCgAccountSetDTO.setFg_addfee(FBoolean.TRUE); // 补费
		blCgAccountSetDTO.setSrcfunc_des(IBlCgCodeConst.IpRtnCompensteFee);
		blCgAccountSetDTO.setFg_price_cal(FBoolean.FALSE);
		// 调用补费接口
		IBlCgAccountService blCgAccountService = ServiceFinder.find(IBlCgAccountService.class);
		blCgAccountService.keepAccountForIp(blCgAccountDTOList.toArray(new BlCgAccountDTO[] {}), blCgAccountSetDTO);
	}

	/**
	 * 获取物品记账集合
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	private MeterialDO[] getMmCgArr(IpRefundSupplyParamDTO param) throws BizException {
		List<MeterialDO> mmList = new ArrayList<MeterialDO>();

		for (Object itm : param.getCgitm()) {
			CgItm cgItm = (CgItm) itm;
			if (!StringUtil.isEmpty(cgItm.getCode_mm())) {
				// 对入参的物品价格进行校验
				IMeterialMDORService mSerivce = ServiceFinder.find(IMeterialMDORService.class);//
				MeterialDO[] tmpDOs = mSerivce.findByAttrValString(MeterialDO.CODE, cgItm.getCode_mm());
				if (ArrayUtil.isEmpty(tmpDOs)) {
					throw new BizException("编码为[" + cgItm.getCode_mm() + "]的物品不存在");
				}

				MeterialDO meterialDO = tmpDOs[0];
				IMaterialBaseInfoService mbaseService = ServiceFinder.find(IMaterialBaseInfoService.class);
				GetMaterialPriceDTO mmPriceDTO = mbaseService.MaterialPriceForOt(meterialDO.getId_mm(),
						meterialDO.getId_unit_pkgbase());

				if (mmPriceDTO != null && mmPriceDTO.getPrice_act() != null) {
					if (mmPriceDTO.getPrice_act().compareTo(new FDouble(cgItm.getPrice())) != 0) {
						StringBuilder sqlStrBuf = new StringBuilder();
						sqlStrBuf.append("住院补费：物品编码为[");
						sqlStrBuf.append(cgItm.getCode_mm());
						sqlStrBuf.append("]的补费价格(");
						sqlStrBuf.append(new FDouble(cgItm.getPrice()));
						sqlStrBuf.append(")和IIH计算的价格(");
						sqlStrBuf.append(mmPriceDTO.getPrice_act());
						sqlStrBuf.append(")有差异！");
						throw new BizException(sqlStrBuf.toString());
					}
				}
				mmList.add(meterialDO);
			}
		}
		return mmList.toArray(new MeterialDO[0]);
	}

	/**
	 * 组装补费信息
	 * 
	 * @param patiVistDO
	 * @param ciOrderDO
	 * @param itm
	 * @param cgItm
	 * @return
	 * @throws BizException 
	 */
	private BlCgAccountDTO getSrvSupplyItmInfo(IpRefundSupplyParamDTO param,PatiVisitDO patiVistDO, CiOrderDO ciOrderDO, MedSrvDO SrvItm,
			MeterialDO mmItm, CgItm cgItm, String mpDepId, String orDepId) throws BizException {
		BlCgAccountDTO tmpDTO = new BlCgAccountDTO();
		tmpDTO.setId_ent(patiVistDO.getId_ent()); // 就诊ID
		tmpDTO.setId_pat(patiVistDO.getId_pat()); // 患者ID
		if (ciOrderDO != null) {
			tmpDTO.setId_or(ciOrderDO.getId_or()); // 医嘱ID
		}
		tmpDTO.setId_srv(SrvItm == null ? mmItm.getId_srv() : SrvItm.getId_srv()); // 服务
		tmpDTO.setFg_mm(FBoolean.FALSE); // 物品管理标识
		if (mmItm != null) {
			tmpDTO.setFg_mm(FBoolean.TRUE); // 物品管理标识
			tmpDTO.setId_mm(mmItm.getId_mm()); // 物品
			tmpDTO.setId_pkgu_cur(mmItm.getId_unit_pkgbase()); // 物品单位
		}
		FDouble dTmp = new FDouble(Double.parseDouble(cgItm.getPrice()));
		tmpDTO.setPrice_std(dTmp); // 标准价
		tmpDTO.setPrice_ratio(dTmp); // 折扣价
		tmpDTO.setRatio_pripat(new FDouble(1)); // 价格比例
		tmpDTO.setQuan(new FDouble(cgItm.getQuan())); // 数量
		if (!StringUtil.isEmpty(cgItm.getCode_only())) {
			tmpDTO.setOnly_code(cgItm.getCode_only()); // 唯一码
		}
		tmpDTO.setId_dep_mp(mpDepId); // 执行科室
		tmpDTO.setId_dep_or(orDepId); // 开立科室
		tmpDTO.setEu_direct(BookRtnDirectEnum.CHARGE);
		
		if(!StringUtil.isEmpty(param.getCode_emp_or())){
			// 设置人员上下文
			PsnDocDO psndocDO = BlAmtConverUtil.getPsnInfo(param.getCode_emp_or());
			if (psndocDO == null) {
				throw new BizException("住院退补费:未查询到开立人员信息");
			}
			tmpDTO.setId_emp_or(psndocDO.getId_psndoc());
		}
		
		return tmpDTO;
	}

	/**
	 * 住院退费
	 * 
	 * @param param
	 * @param patiVistDO
	 * @param ciOrderDO
	 * @param mpDepId
	 * @param orDepId
	 * @throws BizException 
	 */
	private void refundFee(IpRefundSupplyParamDTO param, PatiVisitDO patiVistDO, CiOrderDO ciOrderDO, String mpDepId,
			String orDepId) throws BizException {
		// 获取服务记账集合
		MedSrvDO[] srvCgArr = this.getSvrCgArr(param);
		// 获取物品记账集合
		MeterialDO[] mmCgArr = this.getMmCgArr(param);

		// 获取本次就诊未退费的正向记账数据
		StringBuffer whereStr = new StringBuffer();
		whereStr.append(" id_ent ='" + patiVistDO.getId_ent() + "'");
		if (ciOrderDO != null) {
			whereStr.append(" and id_or ='" + ciOrderDO.getId_or() + "'");
		}
		whereStr.append(" and  fg_refund = 'N' and eu_direct = 1 ");

		IBlcgqueryRService iBlcgqueryRService = ServiceFinder.find(IBlcgqueryRService.class);
		BlCgIpDO[] blCgIpDOs = iBlcgqueryRService.find(whereStr.toString(), " dt_or desc", FBoolean.FALSE);

		if (ArrayUtil.isEmpty(blCgIpDOs)) {
			throw new BizException("未获取到本次就诊的正向记账数据");
		}

		// 组装入参(两次过滤)
		List<BlCgRefundAccountDTO> finalList = new ArrayList<BlCgRefundAccountDTO>();
		if (!ArrayUtil.isEmpty(srvCgArr)) {
			for (MedSrvDO itm : srvCgArr) {
				FDouble quanComp = FDouble.ZERO_DBL;
				List<BlCgIpDO> srvList = new ArrayList<BlCgIpDO>();
				// 获取这个服务的入参其他信息
				CgItm cgItm = new CgItm();
				for (Object itm1 : param.getCgitm()) {
					cgItm = (CgItm) itm1;
					if (itm.getCode().equals(cgItm.getCode_srv())) {
						break;
					}
				}

				for (BlCgIpDO blCgIpDO : blCgIpDOs) {
					if (itm.getId_srv().equals(blCgIpDO.getId_srv())
							&& blCgIpDO.getPrice().compareTo(new FDouble(cgItm.getPrice())) == 0 && quanComp.compareTo(new FDouble(cgItm.getQuan())) < 0) {
						srvList.add(blCgIpDO);
						quanComp = quanComp.add(blCgIpDO.getQuan().sub(blCgIpDO.getQuan_ret()));
					}
				}

				if (ListUtil.isEmpty(srvList)) {
					throw new BizException("未获取到" + cgItm.getCode_srv() + "服务编码所对应的正向记账数据");
				}

				FDouble itfQuan = new FDouble(cgItm.getQuan());
				if (quanComp.compareTo(itfQuan) < 0) {
					throw new BizException("服务编码 " + cgItm.getCode_srv() + "可退数量小于退费数量");
				}

				FDouble quanAll =  FDouble.ZERO_DBL;
				// 组装退费入参
				for (BlCgIpDO blCgIpDO : srvList) {
					BlCgRefundAccountDTO refundDto = new BlCgRefundAccountDTO();
					refundDto.setId_ent(blCgIpDO.getId_ent());
					refundDto.setId_pat(blCgIpDO.getId_pat());
					refundDto.setId_cg(blCgIpDO.getId_cgip());
					FDouble quan = blCgIpDO.getQuan().sub(blCgIpDO.getQuan_ret());
					quanAll = quanAll.add(quan);
					refundDto.setQuan(quanAll.compareTo(itfQuan) <= 0 ? quan : quan.sub(quanAll.sub(itfQuan)));
					finalList.add(refundDto);
				}
			}
		}

		// 物品进行过滤
		if (!ArrayUtil.isEmpty(mmCgArr)) {
			for (MeterialDO itm : mmCgArr) {
				FDouble quanComp = FDouble.ZERO_DBL;
				List<BlCgIpDO> mmList = new ArrayList<BlCgIpDO>();
				// 获取这个物品的入参其他信息
				CgItm cgItm = new CgItm();
				for (Object itm1 : param.getCgitm()) {
					cgItm = (CgItm) itm1;
					if (itm.getCode().equals(cgItm.getCode_mm())) {
						break;
					}
				}

				for (BlCgIpDO blCgIpDO : blCgIpDOs) {
					if (itm.getId_mm().equals(blCgIpDO.getId_mm())
							&& blCgIpDO.getPrice().compareTo(new FDouble(cgItm.getPrice())) == 0 && quanComp.compareTo(new FDouble(cgItm.getQuan())) < 0 ) {
						mmList.add(blCgIpDO);
						quanComp = quanComp.add(blCgIpDO.getQuan().sub(blCgIpDO.getQuan_ret()));
					}
				}

				if (ListUtil.isEmpty(mmList)) {
					throw new BizException("未获取到" + cgItm.getCode_mm() + "物品编码所对应的正向记账数据");
				}

				FDouble itfQuan = new FDouble(cgItm.getQuan());
				if (quanComp.compareTo(itfQuan) < 0) {
					throw new BizException("物品编码 " + cgItm.getCode_mm() + "可退数量小于退费数量");
				}

				FDouble quanAll =  FDouble.ZERO_DBL;
				// 组装退费入参
				for (BlCgIpDO blCgIpDO : mmList) {
					BlCgRefundAccountDTO refundDto = new BlCgRefundAccountDTO();
					refundDto.setId_ent(blCgIpDO.getId_ent());
					refundDto.setId_pat(blCgIpDO.getId_pat());
					refundDto.setId_cg(blCgIpDO.getId_cgip());
					FDouble quan = blCgIpDO.getQuan().sub(blCgIpDO.getQuan_ret());
					quanAll = quanAll.add(quan);
					refundDto.setQuan(quanAll.compareTo(itfQuan) <= 0 ? quan : quan.sub(quanAll.sub(itfQuan)));
					finalList.add(refundDto);
				}
			}
		}
		// 调用退费接口
		BlCgRefundAccountSetDTO blCgAccountSetDTO = new BlCgRefundAccountSetDTO();
		blCgAccountSetDTO.setSrcfunc_des(IBlCgCodeConst.IpRtnCompensteFee);
		blCgAccountSetDTO.setEu_rfdmode(RefundModeEnum.CG_KEY);
		
		//设置退记账人员
		if(!StringUtil.isEmpty(param.getCode_emp_cg())){
			// 设置人员上下文
			PsnDocDO psndocDO = BlAmtConverUtil.getPsnInfo(param.getCode_emp_cg());
			if (psndocDO == null) {
				throw new BizException("住院退补费:未查询到退记账人员信息");
			}
			blCgAccountSetDTO.setId_emp_cg(psndocDO.getId_psndoc());
		}

		IBlCgAccountService blCgAccountService = ServiceFinder.find(IBlCgAccountService.class);
		blCgAccountService.refundAccountForIp(finalList.toArray(new BlCgRefundAccountDTO[] {}),
				blCgAccountSetDTO);
	}

	/**
	 * 获取服务记账集合
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	private MedSrvDO[] getSvrCgArr(IpRefundSupplyParamDTO param) throws BizException {
		FArrayList listMedSrvList = new FArrayList();

		for (Object itm : param.getCgitm()) {
			CgItm cgItm = (CgItm) itm;
			if (!StringUtil.isEmpty(cgItm.getCode_srv())) {
				listMedSrvList.add(cgItm.getCode_srv());
			}
		}

		MedSrvDO[] medSrvs = null;
		if (!CollectionUtils.isEmpty(listMedSrvList)) {
			IMedsrvMDORService srvSerivce = ServiceFinder.find(IMedsrvMDORService.class);// SRV服务
			medSrvs = srvSerivce.findByAttrValList(MedSrvDO.CODE, listMedSrvList);

			if (ArrayUtil.isEmpty(medSrvs)) {
				throw new BizException("入参传入的服务编码都不存在");
			}
			// 差异分析
			if (medSrvs.length != listMedSrvList.size()) {
				for (MedSrvDO itm : medSrvs) {
					if (listMedSrvList.contains(itm.getCode())) {
						listMedSrvList.remove(itm.getCode());
					}
				}

				String err = "";
				for (int i = 0; i < listMedSrvList.size(); i++) {
					if (i == listMedSrvList.size() - 1) {
						err = err + (String) listMedSrvList.get(i);
					} else {
						err = err + (String) listMedSrvList.get(i) + "、";
					}
				}
				throw new BizException("住院补费：服务编码为" + err + "的服务不存在");
			}
		}

		return medSrvs;
	}

	/**
	 * 根据医嘱编码查询医嘱id
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */

	private CiOrderDO initOrderInfo(String orCode) throws BizException {
		ICiorderMDORService ciService = ServiceFinder.find(ICiorderMDORService.class);
		CiOrderDO[] orders = ciService.findByAttrValString(CiOrderDO.CODE_OR, orCode);
		if (ArrayUtil.isEmpty(orders)) {
			throw new BizException("住院补费：医嘱编码为" + orCode + "的医嘱不存在！");
		}
		return orders[0];
	}

	/**
	 * 根据物品编码查询服务信息(目前没用)
	 * 
	 * @param mmCode
	 * @return
	 * @throws BizException
	 */
	private MedSrvDO GetMedSrvInfo(String mmCode) throws BizException {
		// 获取患者本次就诊信息
		StringBuilder sqlStrBuf = new StringBuilder();
		sqlStrBuf.append("SELECT b.id_srv, ");
		sqlStrBuf.append("  b.code ");
		sqlStrBuf.append("FROM bd_mm a ");
		sqlStrBuf.append("inner join bd_srv b on a.id_srv = b.id_srv ");
		sqlStrBuf.append("WHERE (a.code = ?) ");

		SqlParam sqlp1 = new SqlParam();
		sqlp1.addParam(mmCode);

		List<MedSrvDO> tmpDTO = (List<MedSrvDO>) new DAFacade().execQuery(sqlStrBuf.toString(), sqlp1,
				new BeanListHandler(MedSrvDO.class));

		if (ListUtil.isEmpty(tmpDTO)) {
			throw new BizException("编码为[" + mmCode + "]的物品不存在！");
		}

		return tmpDTO.get(0);
	}

	/**
	 * 根据患者编码和住院次数查询患者信息
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	private PatiVisitDO initPatiVisitInfo(IpRefundSupplyParamDTO param) throws BizException {
		// 获取患者本次就诊信息
		StringBuilder sqlStrBuf = new StringBuilder();
		sqlStrBuf.append("SELECT a.id_pat, ");
		sqlStrBuf.append(" a.id_ent, ");
		sqlStrBuf.append(" a.id_pripat, ");
		sqlStrBuf.append(" a.fg_st ");
		sqlStrBuf.append("FROM en_ent a ");
		sqlStrBuf.append("inner join en_ent_ip b on a.id_ent = b.id_ent ");
		sqlStrBuf.append("inner join pi_pat pat on a.id_pat= pat.id_pat ");
		sqlStrBuf.append("WHERE (pat.code = ?) ");
		sqlStrBuf.append(" AND (b.times_ip = ?) ");

		SqlParam sqlp1 = new SqlParam();
		sqlp1.addParam(param.getCode_pat());
		sqlp1.addParam(param.getTimes_ip());

		List<PatiVisitDO> tmpDTO = (List<PatiVisitDO>) new DAFacade().execQuery(sqlStrBuf.toString(), sqlp1,
				new BeanListHandler(PatiVisitDO.class));

		if (ListUtil.isEmpty(tmpDTO)) {
			throw new BizException("患者编码为" + param.getCode_pat() + "(" + param.getTimes_ip() + ")的就诊患者不存在");
		}

		return tmpDTO.get(0);
	}

	/**
	 * 查询部门id
	 * 
	 * @param mpdepcode
	 * @return
	 * @throws BizException
	 */

	private String initDeptId(String codeDep) throws BizException {
		DeptDO[] dept = ServiceFinder.find(IDeptRService.class).findByAttrValString(DeptDO.CODE, codeDep);

		if (ArrayUtil.isEmpty(dept)) {
			throw new BizException("编码为[" + codeDep + "]的科室不存在");
		}

		// 设置上下文科室信息
		Context.get().setDeptId(dept[0].getId_dep());

		return dept[0].getId_dep();
	}

}
