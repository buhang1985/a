package iih.bl.itf.esoe.s.bp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mysql.jdbc.StringUtils;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBlDictCodeConst;
import iih.bd.pp.pripm.i.IBdPripmCodeConst;
import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.blcgoep.d.BlCgOepDO;
import iih.bl.cg.blcgoep.d.BlcgoepAggDO;
import iih.bl.cg.blcgoep.d.FeeOriginEnum;
import iih.bl.cg.blcgoep.i.IBlcgoepCudService;
import iih.bl.comm.IBlCgFuncConst;
import iih.bl.comm.util.BlCodeUtils;
import iih.bl.inc.blincoep.d.BlincoepAggDO;
import iih.bl.inc.blincoep.i.IBlincoepCudService;
import iih.bl.inc.i.IBlIncOutCmdService;
import iih.bl.itf.esoe.d.BlEsoeCgDTO;
import iih.bl.itf.esoe.d.BlEsoeSaleDTO;
import iih.bl.itf.esoe.d.BlEsoeStoepDTO;
import iih.bl.pay.blpaypat.d.BookRtnDirectEnum;
import iih.bl.st.blpaypatoep.d.BlPayItmPatOepDO;
import iih.bl.st.blpaypatoep.d.BlPayPatOepDO;
import iih.bl.st.blpaypatoep.d.BlpaypatoepAggDO;
import iih.bl.st.blpaypatoep.i.IBlpaypatoepCudService;
import iih.bl.st.blstoep.d.BlStOepDO;
import iih.bl.st.blstoep.i.IBlstoepCudService;
import iih.bl.st.dto.bloeprefunddto.d.BlOepRefundItmDTO;
import iih.bl.st.dto.bloeprefunddto.d.BlOepRefundRltDTO;
import iih.bl.st.dto.bloeprefunddto.d.BlOepRefundSetDTO;
import iih.bl.st.dto.blpayoep.d.BlPayOepPmDTO;
import iih.bl.st.i.IBlOepChargeCmdService;
import iih.en.pv.pativisit.d.PatiVisitDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.dataaccess.DBUtil;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 应急系统同步服务
 * @author ly 2019/09/26
 *
 */
public class BlEsoeSyncDataBP {

	private PatiVisitDO entDO = null;
	
	private List<Map<String, String>> cgIdMapList;//记账数据id树级关系
	
	/**
	 * 同步应急系统数据
	 * @param saleDtos
	 * @throws BizException
	 */
	public void exec(BlEsoeSaleDTO[] saleDtos) throws BizException {
		
		if(ArrayUtil.isEmpty(saleDtos))
			return;
		
		this.validate(saleDtos);
		
		for (BlEsoeSaleDTO saleDto : saleDtos) {
			
			this.cgIdMapList = new ArrayList<Map<String, String>>();
			
			//查询就诊数据
			this.entDO = (PatiVisitDO)new DAFacade().findByPK(PatiVisitDO.class, saleDto.getId_ent());
			if(this.entDO == null){
				throw new BizException("为查询到就诊数据，id：" + saleDto.getId_ent());
			}
			
			//插入数据
			this.inertBlData(saleDto);
		}
	}
	
	/**
	 * 数据校验
	 * @param saleDtos
	 * @throws BizException
	 */
	private void validate(BlEsoeSaleDTO[] saleDtos) throws BizException {
		
		for (BlEsoeSaleDTO saleDto : saleDtos) {
			
			if(StringUtil.isEmpty(saleDto.getId_pat())){
				throw new BizException("入参销售单-患者id为空");
			}
			if(StringUtil.isEmpty(saleDto.getId_ent())){
				throw new BizException("入参销售单-就诊id为空");
			}
			if(StringUtil.isEmpty(saleDto.getId_st_by())){
				throw new BizException("入参销售单-创建结算id为空");
			}
			if(ListUtil.isEmpty(saleDto.getStList())){
				throw new BizException("入参销售单-结算信息为空");
			}
			
			for (BlEsoeStoepDTO stDto : saleDto.getStList()) {
				
				if(StringUtil.isEmpty(stDto.getCode_st())){
					throw new BizException("入参结算-结算编码为空");
				}
				if(stDto.getEu_direct() == null){
					throw new BizException("入参结算-结算方向为空");
				}
				if(ListUtil.isEmpty(stDto.getCgList())){
					throw new BizException("入参结算-记账数据为空");
				}
			}
		}
	}
	
	/**
	 * 插入费用数据
	 * @param saleDto
	 * @throws BizException
	 */
	private void inertBlData(BlEsoeSaleDTO saleDto) throws BizException {
		
		List<BlEsoeStoepDTO> stList = saleDto.getStList();
		Collections.sort(stList, new Comparator<BlEsoeStoepDTO>(){
			@Override
			public int compare(BlEsoeStoepDTO paramT1, BlEsoeStoepDTO paramT2) {
				if(paramT1.getSortno()==null||paramT2.getSortno()==null){
					return -1;
				}
				return paramT2.getSortno().compareTo(paramT1.getSortno());
			}});
		
		//处理正向数据
		BlEsoeStoepDTO forwardStDto = null;
		for (BlEsoeStoepDTO blEsoeStoepDTO : stList) {
			if("1".equals(blEsoeStoepDTO.getEu_direct())){
				forwardStDto = blEsoeStoepDTO;
				break;
			}
		}
		
		if(forwardStDto == null){
			throw new BizException("销售单中无正向结算数据，销售单id：" + saleDto.getId_sale());
		}
		
		String stId = this.dealForwardData(saleDto, forwardStDto);
		
		//处理半退或全退数据
		if(stList.size() > 1){
			for (BlEsoeStoepDTO blEsoeStoepDTO : stList) {
				if("1".equals(blEsoeStoepDTO.getEu_direct())){
					continue;
				}
				stId = this.dealBackwardData(stId, blEsoeStoepDTO);
			}
		}
	}
	
	/**
	 * 处理正向数据
	 * @param saleDto
	 * @param forwardStDto
	 * @throws BizException
	 */
	private String dealForwardData(BlEsoeSaleDTO saleDto, BlEsoeStoepDTO forwardStDto) throws BizException {
		
		IBlstoepCudService stService = ServiceFinder.find(IBlstoepCudService.class);
		IBlcgoepCudService cgService = ServiceFinder.find(IBlcgoepCudService.class);
		IBlincoepCudService incService = ServiceFinder.find(IBlincoepCudService.class);
		IBlpaypatoepCudService payService = ServiceFinder.find(IBlpaypatoepCudService.class);
		
		String[] keys = new DBUtil().getOIDs(2);
		//结算数据
		BlStOepDO stOepDO = this.assembleStData(saleDto, forwardStDto, keys);
		//记账数据
		BlcgoepAggDO cgAggDO = this.assembleCgData(saleDto, forwardStDto, stOepDO.getId_stoep());
	
		stService.insert(new BlStOepDO[] { stOepDO });
		cgService.insert(new BlcgoepAggDO[] { cgAggDO });
		
		//发票数据
		IBlIncOutCmdService incCmdService = ServiceFinder.find(IBlIncOutCmdService.class);
		BlincoepAggDO[] incAggDos = incCmdService.preSplitInvoice(cgAggDO.getBlCgItmOepDO());
		//收付款数据
		BlpaypatoepAggDO payAggDO = this.assemblePayData(stOepDO);
		
		incService.insert(incAggDos);
		payService.insert(new BlpaypatoepAggDO[] { payAggDO });
		
		Map<String, String> cgIdMap = new HashMap<String, String>();
		for (BlCgItmOepDO cgItmDO : cgAggDO.getBlCgItmOepDO()) {
			cgIdMap.put(cgItmDO.getId_cgitmoep(), cgItmDO.getId_cgitmoep());
		}
		this.cgIdMapList.add(cgIdMap);
		
		return stOepDO.getId_stoep();
	}
	
	/**
	 * 处理退费数据 TODO
	 * @param oldStId
	 * @param backwardDto
	 * @return 返回重收id，如果全退返回空
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private String dealBackwardData(String oldStId, BlEsoeStoepDTO backwardDto) throws BizException {
		
		BlOepRefundSetDTO refundSet = new BlOepRefundSetDTO();
		refundSet.setId_pat(backwardDto.getId_pat());
		refundSet.setId_stoep(oldStId);
		refundSet.setFg_print(FBoolean.FALSE);
		refundSet.setFg_printred(FBoolean.FALSE);
		refundSet.setFg_dealfeeonly(FBoolean.TRUE);
		refundSet.setSd_pttp(IBlDictCodeConst.SD_PTTP_WINDOW);
		
		List<BlOepRefundItmDTO> refundItmList = new ArrayList<BlOepRefundItmDTO>();
		for (BlEsoeCgDTO cgDto : backwardDto.getCgList()) {
			BlOepRefundItmDTO itmDto = new BlOepRefundItmDTO();
			itmDto.setId_cgitm(this.getOriCgId(cgDto.getId_par()));
			itmDto.setQuan_bk(new FDouble(cgDto.getQuan()));
			itmDto.setFg_getdrug(FBoolean.FALSE);
			refundItmList.add(itmDto);
		}
		
		BlPayOepPmDTO pmDto = new BlPayOepPmDTO();
		pmDto.setId_pm(IBdPripmCodeConst.ID_PRI_PM_CASH);
		pmDto.setSd_pm(IBdPripmCodeConst.CODE_PRI_PM_CASH);
		pmDto.setAmt(new FDouble(backwardDto.getAmt_ratio()));
		pmDto.setEu_direct(BookRtnDirectEnum.RETURNS);
		
		IBlOepChargeCmdService cmdService = ServiceFinder.find(IBlOepChargeCmdService.class);
		BlOepRefundRltDTO rltDto = cmdService.oepRefund(refundSet, refundItmList.toArray(new BlOepRefundItmDTO[0]), new BlPayOepPmDTO[]{pmDto});
		
		if(!StringUtil.isEmpty(rltDto.getId_strecharge())){
			//查询重收记账明细
			DAFacade daf = new DAFacade();
			List<BlCgItmOepDO> cgList = (List<BlCgItmOepDO>)daf.findByAttrValString(BlCgItmOepDO.class, BlCgItmOepDO.ID_STOEP, rltDto.getId_strecharge(),
					new String[] { BlCgItmOepDO.ID_CGITMOEP, BlCgItmOepDO.ID_PAR });
			
			if(!ListUtil.isEmpty(cgList)){
				Map<String,String> keyMap = new HashMap<String,String>();
				for (BlCgItmOepDO itmDO : cgList) {
					keyMap.put(itmDO.getId_par(), itmDO.getId_cgitmoep());
				}
				cgIdMapList.add(keyMap);
			}
		}
		
		return rltDto.getId_strecharge();
	}
	
	/**
	 * 组装正向结算数据
	 * @param saleDto
	 * @param stDto
	 * @return
	 * @throws BizException
	 */
	private BlStOepDO assembleStData(BlEsoeSaleDTO saleDto, BlEsoeStoepDTO stDto,String[] keys) throws BizException {
		
		BlStOepDO stDO = new BlStOepDO();
		stDO.setId_stoep(keys[0]);
		stDO.setId_grp(Context.get().getGroupId());
		stDO.setId_org(Context.get().getOrgId());
		stDO.setId_pat(saleDto.getId_pat());
		stDO.setId_ent(saleDto.getId_ent());
		stDO.setId_enttp(IBdFcDictCodeConst.ID_CODE_ENTP_OP);
		stDO.setCode_enttp(IBdFcDictCodeConst.SD_CODE_ENTP_OP);
		stDO.setId_patca(this.entDO.getId_patca());
		stDO.setCode_st(stDto.getCode_st());
		stDO.setEu_direct(BookRtnDirectEnum.CHARGE);
		stDO.setEu_sttp(stDto.getEu_sttp());
		stDO.setId_stresult(IBlDictCodeConst.ID_STRESULT_NORMAL);
		stDO.setSd_stresult(IBlDictCodeConst.SD_STRESULT_NORMAL);
		stDO.setAmt_std(new FDouble(stDto.getAmt_std()));
		stDO.setAmt_ratio(new FDouble(stDto.getAmt_ratio()));
		stDO.setAmt(stDO.getAmt_ratio());
		stDO.setAmt_pat(stDO.getAmt_ratio());
		stDO.setAmt_hp(stDO.getAmt_ratio());
		stDO.setDt_st(new FDateTime(stDto.getDt_st()));
		stDO.setId_dep_st(stDto.getId_dep_st());
		stDO.setId_emp_st(stDto.getId_emp_st());
		stDO.setId_cc(null);
		stDO.setFg_cc(FBoolean.FALSE);
		stDO.setId_emp_canc(null);
		stDO.setDt_canc(null);
		stDO.setFg_arclear(FBoolean.TRUE);
		stDO.setId_rootst(keys[0]);
		stDO.setId_paypatoep(keys[1]);
		stDO.setStatus(DOStatus.NEW);
		return stDO;
	}

	/**
	 * 组装记账数据
	 * @param saleDto
	 * @param stDto
	 * @param stId
	 * @return
	 * @throws BizException
	 */
	private BlcgoepAggDO assembleCgData(BlEsoeSaleDTO saleDto,BlEsoeStoepDTO stDto,String stId) throws BizException {
		
		BlcgoepAggDO cgAggDO = new BlcgoepAggDO();
		BlCgOepDO cgHdDO = new BlCgOepDO();
		cgHdDO.setId_grp(Context.get().getGroupId());
		cgHdDO.setId_org(Context.get().getOrgId());
		cgHdDO.setCode_cg(BlCodeUtils.generateOepCgCode());
		cgHdDO.setId_pat(saleDto.getId_pat());
		cgHdDO.setEu_direct(BookRtnDirectEnum.CHARGE);
		cgHdDO.setDt_cg(new FDateTime(stDto.getDt_st()));
		cgHdDO.setId_org_cg(Context.get().getOrgId());
		cgHdDO.setId_dep_cg(stDto.getId_dep_st());
		cgHdDO.setId_emp_cg(stDto.getId_emp_st());
		cgHdDO.setStatus(DOStatus.NEW);
		
		List<BlCgItmOepDO> cgItmList = new ArrayList<BlCgItmOepDO>();
		for (BlEsoeCgDTO cgDto : stDto.getCgList()) {
			
			BlCgItmOepDO cgItmDO = new BlCgItmOepDO();
			cgItmDO.setId_cgitmoep(cgDto.getId_cg());
			cgItmDO.setId_grp(Context.get().getGroupId());
			cgItmDO.setId_org(Context.get().getOrgId());
			cgItmDO.setId_pat(cgDto.getId_pat());
			cgItmDO.setId_ent(cgDto.getId_ent());
			cgItmDO.setId_enttp(IBdFcDictCodeConst.ID_CODE_ENTP_OP);
			cgItmDO.setCode_enttp(IBdFcDictCodeConst.SD_CODE_ENTP_OP);
			cgItmDO.setId_pres(null);
			cgItmDO.setId_or(null);
			cgItmDO.setId_orsrv(null);			
			cgItmDO.setId_srv(cgDto.getId_srv());
			cgItmDO.setCode_srv(cgDto.getCode_srv());
			cgItmDO.setName_srv(cgDto.getName_srv());
			cgItmDO.setSrvu(cgDto.getSrvu());
			
			cgItmDO.setFg_mm(new FBoolean(cgDto.getFg_mm()));
			if(FBoolean.TRUE.equals(cgItmDO.getFg_mm())){
				cgItmDO.setId_mm(cgDto.getId_mm());
				cgItmDO.setCode_mm(cgDto.getCode_mm());
				cgItmDO.setName_mm(cgDto.getName_mm());
				cgItmDO.setSpec(cgDto.getSpec());
				cgItmDO.setApprno(cgDto.getApprno());
				cgItmDO.setPgku_base(cgDto.getPgku_cur());
				cgItmDO.setPgku_cur(cgDto.getPgku_cur());
				cgItmDO.setFactor(new FDouble(cgDto.getFactor()));
			}
			
			//依赖前置规则补全
			cgItmDO.setCode_inccaitm(null);
			cgItmDO.setName_inccaitm(null);
			cgItmDO.setCode_account(null);
			cgItmDO.setName_account(null);
			
			cgItmDO.setPrice(new FDouble(cgDto.getPrice()));
			cgItmDO.setPrice_ratio(new FDouble(cgDto.getPrice_ratio()));
			cgItmDO.setRatio_pripat(new FDouble(cgDto.getRatio_pripat()));
			cgItmDO.setQuan(new FDouble(cgDto.getQuan()));
			cgItmDO.setQuan_base(new FDouble(cgDto.getQuan_base()));
			
			cgItmDO.setAmt_std(new FDouble(cgDto.getAmt_std()));
			cgItmDO.setAmt_ratio(new FDouble(cgDto.getAmt_ratio()));
			cgItmDO.setAmt(cgItmDO.getAmt_ratio());
			cgItmDO.setAmt_hp(FDouble.ZERO_DBL);
			cgItmDO.setAmt_pat(cgItmDO.getAmt_ratio());
			cgItmDO.setAmt_acc(FDouble.ZERO_DBL);

			cgItmDO.setFg_acc(FBoolean.FALSE);
			cgItmDO.setFg_additm(FBoolean.FALSE);
			cgItmDO.setFg_extdispense(FBoolean.FALSE);
			cgItmDO.setFg_free(FBoolean.FALSE);
			cgItmDO.setFg_hp(FBoolean.FALSE);
			cgItmDO.setFg_hpcg(FBoolean.FALSE);
			cgItmDO.setFg_pricinginsertcg(FBoolean.FALSE);
			cgItmDO.setFg_recg(FBoolean.FALSE);
			cgItmDO.setFg_refund(FBoolean.FALSE);
			cgItmDO.setFg_specill(FBoolean.FALSE);
			cgItmDO.setFg_st(FBoolean.TRUE);
			cgItmDO.setFg_susp(FBoolean.FALSE);
			cgItmDO.setFg_zeroreg(FBoolean.FALSE);
			
			cgItmDO.setId_stoep(stId);
			cgItmDO.setId_dep_or(cgDto.getId_dep_or());
			cgItmDO.setId_emp_or(cgDto.getId_emp_or());
			cgItmDO.setId_dep_mp(cgDto.getId_dep_mp());
			cgItmDO.setId_dep_phy(this.entDO.getId_dep_phy());
			cgItmDO.setId_emp_phy(this.entDO.getId_emp_phy());
			
			cgItmDO.setEu_srctp(FeeOriginEnum.ORDERS_FEE);
			cgItmDO.setDt_cg(new FDateTime(stDto.getDt_st()));
			cgItmDO.setDt_st(new FDateTime(stDto.getDt_st()));
			cgItmDO.setEu_direct(BookRtnDirectEnum.CHARGE);
			cgItmDO.setSrcfunc_des(IBlCgFuncConst.FUNC_ESOE);
			cgItmDO.setStatus(DOStatus.NEW);
			
			cgItmList.add(cgItmDO);
		}
		cgAggDO.setParentDO(cgHdDO);
		cgAggDO.setBlCgItmOepDO(cgItmList.toArray(new BlCgItmOepDO[0]));
		
		return cgAggDO;
	}

	/**
	 * 组装收付款数据
	 * @param stOepDO
	 * @return
	 * @throws BizException
	 */
	private BlpaypatoepAggDO assemblePayData(BlStOepDO stOepDO) throws BizException {
		
		BlpaypatoepAggDO payAggDO = new BlpaypatoepAggDO();
		BlPayPatOepDO payHdDO = new BlPayPatOepDO();
		payHdDO.setId_paypatoep(stOepDO.getId_paypatoep());
		payHdDO.setId_grp(stOepDO.getId_grp());
		payHdDO.setId_org(stOepDO.getId_org());
		payHdDO.setId_enttp(stOepDO.getId_enttp());
		payHdDO.setCode_enttp(stOepDO.getCode_enttp());
		payHdDO.setId_paytp(IBlDictCodeConst.ID_PAYTP_ST);
		payHdDO.setSd_paytp(IBlDictCodeConst.SD_PAYTP_ST);
		payHdDO.setId_pat(stOepDO.getId_pat());
		payHdDO.setEu_direct(stOepDO.getEu_direct());
		payHdDO.setAmt(stOepDO.getAmt_ratio());
		payHdDO.setDt_pay(stOepDO.getDt_st());
		payHdDO.setId_org_pay(stOepDO.getId_org());
		payHdDO.setId_emp_pay(stOepDO.getId_emp_st());
		payHdDO.setId_dep_pay(stOepDO.getId_dep_st());
		payHdDO.setFg_cc(FBoolean.FALSE);
		payHdDO.setId_cc(null);
		payHdDO.setId_pttp(IBlDictCodeConst.ID_PTTP_WINDOW);
		payHdDO.setSd_pttp(IBlDictCodeConst.SD_PTTP_WINDOW);
		payHdDO.setNote("应急系统导入");
		payHdDO.setStatus(DOStatus.NEW);
		
		BlPayItmPatOepDO payItmDO = new BlPayItmPatOepDO();
		payItmDO.setId_paypatoep(stOepDO.getId_paypatoep());
		payItmDO.setId_grp(stOepDO.getId_grp());
		payItmDO.setId_org(stOepDO.getId_org());
		payItmDO.setEu_direct(stOepDO.getEu_direct());
		payItmDO.setFg_realpay(FBoolean.TRUE);
		payItmDO.setId_pm(IBdPripmCodeConst.ID_PRI_PM_CASH);
		payItmDO.setSd_pm(IBdPripmCodeConst.CODE_PRI_PM_CASH);
		payItmDO.setAmt(stOepDO.getAmt_ratio());
		payItmDO.setFg_manual(FBoolean.FALSE);
		payItmDO.setStatus(DOStatus.NEW);
		
		payAggDO.setParentDO(payHdDO);
		payAggDO.setBlPayItmPatOepDO(new BlPayItmPatOepDO[] { payItmDO });
		
		return payAggDO;
	}

	/**
	 * 根据应急系统主键查询查找最新记账主键
	 * @param esoeCgId
	 * @return
	 */
	private String getOriCgId(String esoeCgId){
		
		String key = esoeCgId;
		
		for (Map<String, String> map : cgIdMapList) {
			
			if(map.containsKey(key)){
				key = map.get(key);
			}else{
				break;
			}
		}
		
		return key;
	}
}
