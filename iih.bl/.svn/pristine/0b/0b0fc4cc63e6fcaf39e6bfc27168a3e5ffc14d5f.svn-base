package iih.bl.cg.ep;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import iih.bd.bc.udi.pub.IBlDictCodeConst;
import iih.bl.cg.blcgquery.d.BookRtnDirectEnum;
import iih.bl.cg.service.d.OperatorInfoDTO;
import iih.bl.comm.util.BlCodeUtils;
import iih.bl.pay.blrtnreasondto.d.BlRtnReasonDTO;
import iih.bl.st.blstoep.d.BlStOepDO;
import iih.bl.st.blstoep.d.StTypeEnum;
import iih.bl.st.blstoep.i.IBlstoepCudService;
import iih.bl.st.blstoep.i.IBlstoepRService;

public class OepStEP {

	/**
	 *  红冲门诊结算表，且修改原结算表
	 * @param orgin_BlStOepDO 需要红冲的数据
	 * @param operatorInfoDTO 当前操作人
	 * @param id_paypatoep 结算编号
	 * @param strDateTime 取消时间
	 * @param eu_srctp 记账类型
	 * @param rtnReasonDTO 退费原因
	 * @return
	 * @throws BizException
	 */
	public BlStOepDO redBack_StOep(BlStOepDO orgin_BlStOepDO, 
			OperatorInfoDTO operatorInfoDTO, 
			String id_paypatoep, 
			FDateTime strDateTime, 
			Integer eu_srctp,
			BlRtnReasonDTO rtnReasonDTO) throws BizException {
		// 1. 修改原结算信息，设置为取消
		orgin_BlStOepDO.setFg_canc(FBoolean.TRUE);
		orgin_BlStOepDO.setId_emp_canc(operatorInfoDTO.getId_emp());
		orgin_BlStOepDO.setDt_canc(strDateTime);
		orgin_BlStOepDO.setId_reason_canc(IBlDictCodeConst.BD_REFUND_SETTLE_CANCELLED_ID);
		orgin_BlStOepDO.setSd_reason_cand(IBlDictCodeConst.BD_REFUND_SETTLE_CANCELLED);
		orgin_BlStOepDO.setStatus(DOStatus.UPDATED);
		IBlstoepCudService iBlstoepCudService = ServiceFinder.find(IBlstoepCudService.class);
		BlStOepDO[] blStOepDOs = iBlstoepCudService.save(new BlStOepDO[] { orgin_BlStOepDO });
		if (null == blStOepDOs || blStOepDOs.length == 0) {
			throw new BizException("修改原门诊结算信息失败");
		}
		// 2. 红冲结算,生成红冲的结算信息，并保存
		BlStOepDO red_blStOepDO = (BlStOepDO) orgin_BlStOepDO.clone();
		red_blStOepDO.setId_par(red_blStOepDO.getId_stoep());
		red_blStOepDO.setId_stoep(null);
		red_blStOepDO.setId_org(operatorInfoDTO.getId_org());
		red_blStOepDO.setId_grp(operatorInfoDTO.getId_grp());
		red_blStOepDO.setEu_direct(BookRtnDirectEnum.REFUND);
		String eu_sttp = "";
		if (eu_srctp != null && eu_srctp.intValue() == 1) {
			eu_sttp = StTypeEnum.ST_REGISTER_RED; // 门诊挂号取消结算
		} else {
			eu_sttp = StTypeEnum.ST_OEP_MIDWAY; // 门诊冲账
		}
		red_blStOepDO.setEu_sttp(eu_sttp);
		String stCode = BlCodeUtils.generateOepStCode();
		red_blStOepDO.setCode_st(stCode);
		red_blStOepDO.setDt_st(strDateTime);
		red_blStOepDO.setId_dep_st(operatorInfoDTO.getId_dep());
		red_blStOepDO.setId_emp_st(operatorInfoDTO.getId_emp());
		red_blStOepDO.setFg_cc(FBoolean.FALSE);
		red_blStOepDO.setFg_canc(FBoolean.FALSE);
		red_blStOepDO.setId_emp_canc(null);
		red_blStOepDO.setDt_canc(null);
		if (rtnReasonDTO == null) {
			red_blStOepDO.setId_reason_canc(null);
			red_blStOepDO.setSd_reason_cand(null);
			red_blStOepDO.setDes_reason_canc(null);
		} else {
			red_blStOepDO.setId_reason_canc(rtnReasonDTO.getId_udidoc());
			red_blStOepDO.setSd_reason_cand(rtnReasonDTO.getCode());
			red_blStOepDO.setDes_reason_canc(rtnReasonDTO.getName());
		}
		
		red_blStOepDO.setId_cc(null);//如果红冲数据已结账，将结账id清空 by lim 2017-9-29
		// 红冲的收付款主键
		red_blStOepDO.setId_paypatoep(id_paypatoep);
		//对关联首次结算赋值  2019/04/17 ly
		if(StringUtil.isEmpty(orgin_BlStOepDO.getId_rootst())){
			red_blStOepDO.setId_rootst(orgin_BlStOepDO.getId_stoep());
		}else{
			red_blStOepDO.setId_rootst(orgin_BlStOepDO.getId_rootst());
		}
		
		red_blStOepDO.setStatus(DOStatus.NEW);
		BlStOepDO[] red_blStOepDO1 = iBlstoepCudService.save(new BlStOepDO[] { red_blStOepDO });
		if (null == red_blStOepDO1 || red_blStOepDO1.length == 0) {
			throw new BizException("保存红冲门诊结算信息失败");
		}
		return red_blStOepDO1[0];
	}
	
	/**
	 * 获取结算信息
	 * @param idSt
	 * @return
	 * @throws BizException 
	 */
	public BlStOepDO getBlStOepDOByIdSt(String idSt) throws BizException {
		IBlstoepRService service=ServiceFinder.find(IBlstoepRService.class);
		return service.findById(idSt);
	}
	
}
