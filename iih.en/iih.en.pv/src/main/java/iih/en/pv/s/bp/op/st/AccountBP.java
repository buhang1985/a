package iih.en.pv.s.bp.op.st;

import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.blcgoep.d.BlcgoepAggDO;
import iih.bl.cg.blorderappendbillparamdto.d.BlOrderAppendBillParamDTO;
import iih.bl.cg.dto.cglogic.d.OepCgModeEnum;
import iih.bl.cg.dto.en.opaccount.d.BlCgOpAccount4EnDTO;
import iih.bl.cg.dto.en.opaccount.d.BlCgOpAccountItm4EnDTO;
import iih.bl.cg.dto.en.opaccount.d.BlCgOpAccountRlt4EnDTO;
import iih.bl.cg.i.IBlCgForEnService;
import iih.bl.cg.service.i.IBLCiOrderToBlCgService;
import iih.bl.cg.service.i.IBLOrderAppendBillService;
import iih.en.comm.IEnMsgConst;
import iih.en.comm.ep.PvEP;
import iih.en.comm.util.EnParamUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.outpatient.dto.d.RegInfoDTO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.sc.sch.reg.dto.d.RegResDTO;
import iih.sc.sch.reg.dto.d.RelSrvDTO;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 记账
 * 
 * @author yank
 */
public class AccountBP {
	
	/*
	 * 接诊使用记账模式
	 */
	private static final int ACC_ONLY = 0;
	/*
	 * 接诊使用预付费扣费模式
	 */
	private static final int PRE_PAY = 1;
	/***
	 * 接诊使用记账(不结算)模式
	 */
	private static final int ACC_NOST = 2;
	/**
	 * 挂号记账
	 * 
	 * @param regInfo
	 * @return
	 * @throws BizException
	 */
	public String exec(RegInfoDTO regInfo) throws BizException{
		//0-接诊使用记账模式；1-接诊使用预付费扣费模式；2-接诊使用记账(不结算)模式
		int blTPPatam = EnParamUtils.getEnUnregBlTp();
		String eu_oepcgmode = null;
		if(ACC_ONLY == blTPPatam){
			//0-只记账模式
			//return acconly(regInfo);
			eu_oepcgmode = OepCgModeEnum.SUSP_CG;
			return accountCgNew(regInfo,eu_oepcgmode);
		}
		if(PRE_PAY == blTPPatam){
			//1-预付费扣费模式
			//return prePay(regInfo);
			eu_oepcgmode = OepCgModeEnum.PREPAY_CG;
			return accountCgNew(regInfo,eu_oepcgmode);
		}
		if(ACC_NOST == blTPPatam){
			//2-接诊使用记账(不结算)模式
			eu_oepcgmode = OepCgModeEnum.ARREARS_CG;
			return accountCgNew(regInfo,eu_oepcgmode);
		}
		throw new BizException("挂号费记账模式配置错误[ENOP0019]");
	}
	/***
	 * @Description:挂号记账新接口，fanlq-2019-11-02
	 * @param regInfo
	 * @return
	 * @throws BizException 
	 */
	@SuppressWarnings("unchecked")
	private String accountCgNew(RegInfoDTO regInfo,String eu_oepcgmode) throws BizException{
		BlCgOpAccount4EnDTO dto = new BlCgOpAccount4EnDTO();
		dto.setId_ent(regInfo.getId_ent());
		dto.setId_pat(regInfo.getId_pat());
		dto.setEu_oepcgmode(eu_oepcgmode);
		//详细费用明细赋值
		FArrayList array = regInfo.getRegresarray();
		if (array == null || array.size() <= 0) {
			throw new BizException("挂号资源信息为空！");
		}
		RegResDTO resDTO = (RegResDTO) array.get(0);
		if(resDTO.getSrvarray()==null || resDTO.getSrvarray().size() <= 0){
			throw new BizException(String.format("挂号排班服务[%s]未维护正确的诊疗项目！", getScSRvName(resDTO.getId_scsrv())));
		}
		FArrayList itmList = new FArrayList();
		for (Object obj : resDTO.getSrvarray()) {
			RelSrvDTO relSrvDTO = (RelSrvDTO) obj;
			BlCgOpAccountItm4EnDTO itm = new BlCgOpAccountItm4EnDTO();
			itm.setId_srv(relSrvDTO.getId_srv()); // 服务项目ID
			itm.setQuan(new FDouble(1)); // 数量
			itmList.add(itm);
		}
		dto.setDetail(itmList);
		IBlCgForEnService cgservice = ServiceFinder.find(IBlCgForEnService.class);
		BlCgOpAccountRlt4EnDTO rltDTO = cgservice.opKeepAccount(dto);
		if(rltDTO == null){
			throw new BizException("BL挂号记账接口返回值为空！");
		}
		return rltDTO.getId_cgoep();
	}
	
	/**
	 * 记账 只记账，不结算
	 * 
	 * @param regInfo 挂号信息
	 * @return 结算ID
	 * @throws BizException
	 */
	@SuppressWarnings("unused")
	private String acconly(RegInfoDTO regInfo) throws BizException {
		//划价
		PricingBP pricingBP = new PricingBP();
		regInfo =  pricingBP.exec(regInfo, FBoolean.TRUE, FBoolean.FALSE);
		
		FArrayList pricedArray = regInfo.getPricedinfo();
		if (pricedArray == null || pricedArray.size() <= 0) {
			throw new BizException(IEnMsgConst.ERROR_OP_REG_PRICE_NOT_EXIST);
		}
		BlcgoepAggDO blcgAggDO = (BlcgoepAggDO) (pricedArray.get(0));
		if (blcgAggDO == null) {
			throw new BizException(IEnMsgConst.ERROR_OP_REG_PRICE_NOT_EXIST);
		}else{
			blcgAggDO.getParentDO().setId_pat(regInfo.getId_pat());
			BlCgItmOepDO[] blCgOepDOs = blcgAggDO.getBlCgItmOepDO();
			if(!EnValidator.isEmpty(blCgOepDOs)){
				for(BlCgItmOepDO blCgOepDO : blCgOepDOs){
					blCgOepDO.setId_pat(regInfo.getId_pat());
					blCgOepDO.setStatus(DOStatus.UPDATED);
				}
			}
		}
		// 2、记账
		IBLCiOrderToBlCgService blService = ServiceFinder.find(IBLCiOrderToBlCgService.class);
		blService.UpdateBlOepPriceIdent(regInfo.getId_ent(), new BlcgoepAggDO[] { blcgAggDO });

		return blcgAggDO.getParentDO().getId_cgoep();
	}
	/**
	 * 预付费扣费记账模式
	 * 
	 * @param regInfo
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unused")
	private String prePay(RegInfoDTO regInfo) throws BizException {
		IBLOrderAppendBillService serv = ServiceFinder.find(IBLOrderAppendBillService.class);
		PatiVisitDO pv  = new PvEP().getPvByPK(regInfo.getId_ent());
		GetBalanceDetailBP bp = new GetBalanceDetailBP();
		ArrayList<BlOrderAppendBillParamDTO> list = bp.prePay(regInfo, pv);
		BlOrderAppendBillParamDTO[] result = serv.SetOrderAppendBill_ByItms(list.toArray(new BlOrderAppendBillParamDTO[0]), pv.getCode_entp());
		if(EnValidator.isEmpty(result))
			return null;
		if(result[0].getOutpBillDTO() == null)
			return null;
		return result[0].getOutpBillDTO().getId_cgoep();
	}
	/**
	 * 根据排班服务id获取排班服务名称
	 * 
	 * @param scSrvId
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private String getScSRvName(String scSrvId)throws BizException {
		if(EnValidator.isEmpty(scSrvId))
			throw new BizException("挂号所需排班服务不能为空！");
		String sql = "SELECT SCSRV.NAME FROM SC_SRV SCSRV WHERE SCSRV.ID_SCSRV = ? AND SCSRV.FG_ACTIVE = 'Y'";
		SqlParam param = new SqlParam();
		param.addParam(scSrvId);
		List<String> names = (List<String>) new DAFacade().execQuery(sql, param, new ColumnListHandler());
		if(EnValidator.isEmpty(names))
			throw new BizException(String.format("未找到挂号所需排班服务[%S]信息!", scSrvId));
		return names.get(0);
	}
}
