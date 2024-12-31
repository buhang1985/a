package iih.bl.cg.api.s.bp;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PreDestroy;

import xap.mw.core.data.Context;
import xap.mw.core.data.FArrayList;
import iih.bl.cg.api.d.OpPayParam;
import iih.bl.cg.api.d.OpPayReturn;
import iih.bl.cg.api.d.UnpaidInfo;
import iih.bl.cg.blorderappendbillparamdto.d.BlOrderAppendBillParamDTO;
import iih.bl.cg.service.d.OperatorInfoDTO;
import iih.bl.cg.service.i.IBLCiOrderToBlCgService;
import iih.bl.st.service.i.IBLStQueService;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.dto.prescostdto.d.PrescriptionConstBaseDto;
import iih.ci.ord.dto.prescostdto.d.PrescriptionCostDto;
import iih.ci.ord.i.ICiOrdMaintainService;
import iih.ci.ord.i.ICiOrdQryService;
import iih.pi.reg.pat.d.PatDO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 第三方接口业务实现
 * @author Administrator
 *
 */
public class OpChargeThirdPartyBP {
	
	
	/**
	 * 第三方门诊缴费接口
	 * @param param
	 * @return OutpatientPaymentReturn 返回结果集
	 * @author Liwq
	 * @throws BizException
	 */
	public OpPayReturn doChargedOpThirdParty(OpPayParam param) throws BizException {
		
		if(param == null ){
			throw new BizException("传入的参数不能为空！");
		}
		if(param.getPatCode() == null || param.getOpTimes() ==null  || param.getApplyNos() == null ||param.getPayOrder() == null||param.getPmCode() ==null) {
			throw new BizException("传入的参数不能为空！");
		}
		if(!"01".equals(param.getPatType() )) {
			throw new BizException("该渠道不支持非自费患者进行结算！");
		}
		OpPayReturn rtnInfo = new OpPayReturn();
		rtnInfo.setResultCode("1");
		rtnInfo.setResultMsg("操作失败！");
		String patCode = param.getPatCode();
		//1、根据患者code查询患者id_pat
		String[] fields = {"Id_pat"};
		DAFacade dAFacade=new DAFacade();
		List<PatDO> patDoList = (List<PatDO>)dAFacade.findByCond(PatDO.class, "code = '"+patCode+"' ","1", fields);  
		
		if(patDoList == null || patDoList.size() <= 0)
		{
			rtnInfo.setResultCode("1");
			rtnInfo.setResultMsg("该患者不存在！");
			return rtnInfo;
		}
		String id_pat = patDoList.get(0).getId_pat();
		
		// 判断改患者订单号是否重复结算
		StringBuilder sqlbBuilder = new StringBuilder();
		sqlbBuilder.append(" select a.bankno,a.paymodenode from bl_pay_itm_pat_oep a, bl_st_oep b ");
		sqlbBuilder.append(" where a.id_paypatoep=b.id_paypatoep and b.id_pat ='").append(id_pat).append("' and a.bankno='");
		sqlbBuilder.append(param.getAccount()).append("' and a.paymodenode='").append(param.getPayOrder()).append("' ");
		List<String> listPayNo = (List<String>) new DAFacade().execQuery(sqlbBuilder.toString(),  new ColumnListHandler());
		if(listPayNo != null && listPayNo.size() > 0)
		{
			rtnInfo.setResultCode("1");
			rtnInfo.setResultMsg("该订单号已结算，无效号码！");
			return rtnInfo;
		}
		
		
		//2、获取并转换iih可识别的处方号
		if(ArrayUtil.isEmptyNoNull(param.getApplyNos()))
		{
			rtnInfo.setResultCode("1");
			rtnInfo.setResultMsg("病人无交费记录！");
			return rtnInfo;
		}
		//2.1 由于处方序号每次都是从1开始，所以需根据就诊次数和id_pat获取id_ent
		StringBuilder sqlStr = new StringBuilder();
		sqlStr.append(" select a.id_ent from en_ent a,en_ent_op b ");
		sqlStr.append(" where a.id_ent=b.id_ent and id_pat= ? and b.times_op = ? ");
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(id_pat);
		sqlParam.addParam(param.getOpTimes());
		@SuppressWarnings("unchecked")
		List<String> enList = (List<String>) new DAFacade().execQuery(sqlStr.toString(),sqlParam,new ColumnListHandler());
		if(enList == null || enList.size() <= 0)
		{
			throw new BizException("该患者对应就诊不存在!");
		}
		String id_ent= enList.get(0);
		//判断处方是否存在医保，如果存在医保计划则不允许结算
		GetEntExistsHpBP getEntExistsHpBP= new GetEntExistsHpBP();
		String existsHp =getEntExistsHpBP.exec(id_ent, param.getApplyNos(),"");
		if(!("").equals(existsHp)){
			rtnInfo.setResultCode("1");
			rtnInfo.setResultMsg(existsHp);
			return rtnInfo;
		}
		ICiOrdMaintainService   ciOrderMaintainService = ServiceFinder.find(ICiOrdMaintainService.class);
		PrescriptionConstBaseDto  presDtos = ciOrderMaintainService.getPrintDetailsSrv(param.getApplyNos(),id_ent);
		//备用方法
//		ICiOrdQryService iCiOrdQryService = ServiceFinder.find(ICiOrdQryService.class);
//		String[] sd_su_bl = {"0"};
//		PrescriptionConstBaseDto presDtos = iCiOrdQryService.getPrescriptionConstAccounting(id_ent, sd_su_bl);
		if(presDtos == null) {
			rtnInfo.setResultCode("1");
			rtnInfo.setResultMsg("病人无交费记录！");
			return rtnInfo;
		}
		
		IBLCiOrderToBlCgService ciToCgService = ServiceFinder.find(IBLCiOrderToBlCgService.class);
		//判断操作员是否存在
		String[] psn={"Id_psndoc"};
		List<PsnDocDO> psnList = (List<PsnDocDO>) new DAFacade().findByCond(PsnDocDO.class,"code='"+ param.getOperaCode() +"'","1",psn);
		if(psnList == null || psnList.size() <= 0)
		{
			rtnInfo.setResultCode("1");
			rtnInfo.setResultMsg("该操作员不存在！");
			return rtnInfo;
		}	
		//3.3 获取CG中未缴费信息 (直接记账的数据没有ID_OR)
		
		// 4、查询所有已记账费用，.进行划价 、结算
		List<BlOrderAppendBillParamDTO> blOrderAppendBillParamDTOs = new ArrayList<BlOrderAppendBillParamDTO>();
		//PrescriptionConstBaseDto 转 BlOrderAppendBillParamDTO
		FArrayList dtoInfoList = presDtos.getPrescriptionCostDto();
		if(dtoInfoList == null) {
			rtnInfo.setResultCode("1");
			rtnInfo.setResultMsg("病人无交费信息！");
			return rtnInfo;
		}
		IBLStQueService service = ServiceFinder.find(IBLStQueService.class);
		for (int i = 0; i < dtoInfoList.size(); i++) {
			PrescriptionCostDto presDto =  (PrescriptionCostDto)dtoInfoList.get(i);	
//			if (isIn(presDto.getPresno(), param.getApplyNos())) { 
				BlOrderAppendBillParamDTO dto = service.convertDto(presDto);
				dto.setId_emp_cg(psnList.get(0).getId_psndoc());
				blOrderAppendBillParamDTOs.add(dto);
			
//			}
		}			
		
		
		OperatorInfoDTO operatorInfoDTO = new OperatorInfoDTO();
		operatorInfoDTO.setId_dep(Context.get().getDeptId());
		operatorInfoDTO.setId_emp(psnList.get(0).getId_psndoc());
		operatorInfoDTO.setId_grp(Context.get().getGroupId());
		operatorInfoDTO.setId_org(Context.get().getOrgId());
		operatorInfoDTO.setId_org_emp(psnList.get(0).getId_psndoc());
		if("11".equals(param.getPmCode()))//支付宝
		{
			param.setPmCode("1");
		}else if("12".equals(param.getPmCode()))//微信
		{
			param.setPmCode("2");
		}
		rtnInfo = ciToCgService.PriceAndSettlementPaymentForThirdParty(blOrderAppendBillParamDTOs.toArray(new BlOrderAppendBillParamDTO[0]), operatorInfoDTO, new FDouble(param.getAmt()), id_pat, param);
		if(!"1".equals(rtnInfo.getResultCode())) {
			rtnInfo.setResultCode("0");
			rtnInfo.setResultMsg("操作成功！");
		}		
		return rtnInfo;
	}

	private boolean isIn(String substring, String[] source) {
		if (source == null || source.length == 0) {
			return false;
		}
		for (int i = 0; i < source.length; i++) {
			String aSource = source[i];
			if (aSource.equals(substring)) {
				return true;
			}
		}
		return false;
	}
}
