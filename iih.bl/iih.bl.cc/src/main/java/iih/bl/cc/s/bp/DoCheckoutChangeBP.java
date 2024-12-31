package iih.bl.cc.s.bp;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBlDictCodeConst;
import iih.bd.pp.pripm.d.PriPmDO;
import iih.bd.pp.pripm.i.IPripmRService;
import iih.bl.cc.blcc.d.BlCcDO;
import iih.bl.cc.blcc.d.BlCcPmDO;
import iih.bl.cc.blcc.d.BlccAggDO;
import iih.bl.cc.blcc.d.desc.BlCcDODesc;
import iih.bl.cc.blcc.i.IBlccCudService;
import iih.bl.cc.blcc.i.IBlccRService;
import iih.bl.cc.ep.CcElecIncEP;
import iih.bl.cc.ep.CcIncEP;
import iih.bl.cc.ep.CcPmEP;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.service.time.TimeService;
import xap.mw.core.service.time.impl.TimeServiceImpl;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.custcfg.billcode.i.IBillcodeManage;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;

public class DoCheckoutChangeBP {
	/**
	 * 结账
	 * @param blccAggArr
	 * @param sd_cctp
	 * @param end_time
	 * @return
	 * @throws BizException
	 * @author LIM
	 */
	public BlccAggDO[] exec(BlccAggDO[] blccAggArr, String sd_cctp, FDateTime end_time) throws BizException {
		// 1.保存结账、结账付款方式、结账发票、结账退费发票、结账作废发票明细等信息
		// 验证参数是否为空
		for (BlccAggDO aggDO : blccAggArr) {
			List<BlCcPmDO> blCcPmDOList = new ArrayList<BlCcPmDO>();
			if (aggDO.getBlCcPmDO() == null || aggDO.getBlCcPmDO().length == 0) {
				continue;
			} else {
				for (BlCcPmDO blCcPmDO : aggDO.getBlCcPmDO()) {
					if (blCcPmDO.getAmt().doubleValue() > 0 || blCcPmDO.getAmt_return().doubleValue() > 0) {
						blCcPmDOList.add(blCcPmDO);
					}
				}
			}
			aggDO.setBlCcPmDO(blCcPmDOList.toArray(new BlCcPmDO[] {}));
			aggDO.getParentDO().setCode_cc(getCode_cc(aggDO.getParentDO() , end_time));
		}
		IBlccCudService service = ServiceFinder.find(IBlccCudService.class);
		BlccAggDO[] blccAggDO1 = service.save(blccAggArr);

		// 2.根据结账类型更新业务表数据结账标志
		List<String> idccList = new ArrayList<String>();
		for (BlccAggDO aggDO : blccAggDO1) {
			idccList.add(aggDO.getParentDO().getId_cc());
			// 修改结账标志
			this.setCheckoutStatus(aggDO.getParentDO().getId_cc(), Context.get().getStuffId(), Context.get().getOrgId(), sd_cctp, end_time);
		}
		// 3.将结账后的数据返回到前台页面
		IBlccRService rservice = ServiceFinder.find(IBlccRService.class);
		BlccAggDO[] blccAggDOArr = rservice.findByBIds(idccList.toArray(new String[] {}), FBoolean.FALSE);

		//4.更新结账时间与 结账金额
		for (BlccAggDO aggDO : blccAggArr) {
			aggDO.getParentDO().setAmt_dif(aggDO.getParentDO().getAmt().sub(aggDO.getParentDO().getAmt_return()));
		}

		// 判断是否包含全部的收付款方式，否则补全
		this.setBlCcPmInfo(blccAggDOArr);
		return blccAggDOArr;
	}
	/**
	 * 根据操作员和结账日期和结账类型和编码规则获取结账号
	 * @param ccDo
	 * @return
	 * @author hanJQ 2019年3月18日
	 * @throws BizException 
	 */
	private String getCode_cc(BlCcDO ccDo ,FDateTime end_time) throws BizException{
		String Code_cc = null;
		
		IBillcodeManage codeManage = ServiceFinder.find(IBillcodeManage.class);
		Code_cc = codeManage.getBillCode_RequiresNew(BlCcDODesc.CLASS_FULLNAME,ccDo);
		if(StringUtils.isBlank(Code_cc)){
			StringBuilder sf = new StringBuilder();
			sf.append("SELECT count(1) FROM BL_CC WHERE ID_EMP = ? AND ID_CCTP = ? AND DT_CC >= ? AND DT_CC <= ?;");
			SqlParam sp = new SqlParam();
			sp.addParam(ccDo.getId_emp());
			sp.addParam(ccDo.getId_cctp());
			sp.addParam(end_time.getDate()+" 00:00:00");
			sp.addParam(end_time.getDate()+" 23:59:59");
			int count=(int) new DAFacade().execQuery(sf.toString(),sp, new ColumnHandler());		
			Code_cc = (count+1)+"";
		}
		return Code_cc;
	}

	/**
	 * 修改结账标志
	 * 
	 * @param id_cc
	 * @param id_user
	 * @param id_org
	 * @param sd_cctp 就诊类型
	 * @param end_time
	 * @throws BizException
	 */
	private void setCheckoutStatus(String id_cc, String id_user, String id_org, String sd_cctp, FDateTime end_time) throws BizException {
		CcPmEP ccPmEP = new CcPmEP();
		if (IBlDictCodeConst.SD_CCTP_MZSF.equals(sd_cctp) || IBlDictCodeConst.SD_CCTP_MZLC.equals(sd_cctp)) {// 门诊（患者）
			// 1 、修改门诊结算表的结账标示
			UpdateBlStOepBP updateCheckoutStatusOfBlStOepBP = new UpdateBlStOepBP();
			updateCheckoutStatusOfBlStOepBP.exec(id_user, id_cc, end_time);

			// 2、修改结算收付款门诊表的结算标示
			ccPmEP.updatePayPatOepDO(id_user, end_time, id_cc);
		} else if (IBlDictCodeConst.SD_CCTP_ZYLC.equals(sd_cctp)|| IBlDictCodeConst.SD_CCTP_ZYSF.equals(sd_cctp)) {// 住院流程结账或住院收费结账
			// 1、修改住院结算表的结账标示
			UpdateBlStIpBP updateCheckoutStatusOfBlStIpBP = new UpdateBlStIpBP();
			updateCheckoutStatusOfBlStIpBP.exec(id_user, id_cc, end_time);

			// 2、修改结算收付款住院表的结算标示
			ccPmEP.updatePayPatIpDO(id_user, end_time, id_cc);
		}
		// 3、修改预交金表(BL_PREPAY_PAT)中结账标志为结账
		List<String> sd_paytp = new ArrayList<String>();
		// 结账时门诊收费和预交金合并，门诊结账时同时更新预交金 by lim 2017-10-27
		// 后续如果分开将IBlDictCodeConst.SD_CCTP_MZSF.equals(sd_cctp)删除
		if (IBlDictCodeConst.SD_CCTP_MZYJJ.equals(sd_cctp) || IBlDictCodeConst.SD_CCTP_MZLC.equals(sd_cctp)) {// 门诊预交金
			//sd_paytp = IBlDictCodeConst.SD_PAYTP_OPPREPAY;
			sd_paytp.add(IBlDictCodeConst.SD_PAYTP_OPPREPAY);
		} else if (IBlDictCodeConst.SD_CCTP_ZYLC.equals(sd_cctp) || IBlDictCodeConst.SD_CCTP_ZYYJJ.equals(sd_cctp)) {// 住院
			//sd_paytp = IBlDictCodeConst.SD_PAYTP_IPPREPAY;
			sd_paytp.add(IBlDictCodeConst.SD_PAYTP_IPPREPAY);//住院
			sd_paytp.add(IBlDictCodeConst.SD_PAYTP_PECMPYPREPAY);//团检
			sd_paytp.add(IBlDictCodeConst.SD_PAYTP_IPPREPAYSTTRANSFER);//结转
		}
		if(!ListUtil.isEmpty(sd_paytp)){
			UpdatePrePayPatBP updatePrePayPatDOBP = new UpdatePrePayPatBP();
			updatePrePayPatDOBP.exec(id_user, id_cc, end_time, sd_paytp);
		}
		
		//4.修改记录预交金票据记录
		String code_entp="";
		if(IBlDictCodeConst.SD_CCTP_ZYLC.equals(sd_cctp) || IBlDictCodeConst.SD_CCTP_ZYYJJ.equals(sd_cctp)){
			code_entp=IBdFcDictCodeConst.SD_CODE_ENTP_IP;
		}else if(IBlDictCodeConst.SD_CCTP_MZYJJ.equals(sd_cctp) || IBlDictCodeConst.SD_CCTP_MZLC.equals(sd_cctp)){
			code_entp=IBdFcDictCodeConst.SD_CODE_ENTP_OP;
		}
		UpdatePrePayPatRcptBP updatePrePayPatRcptBP= new UpdatePrePayPatRcptBP();
		updatePrePayPatRcptBP.exec(id_user, id_cc, end_time, code_entp);
		
		// 5、修改发票信息（BL_INC_OEP/BL_INC_IP）
		CcIncEP ccIncEP = new CcIncEP();
		if (IBlDictCodeConst.SD_CCTP_MZSF.equals(sd_cctp)|| IBlDictCodeConst.SD_CCTP_MZLC.equals(sd_cctp)) {// 门诊（患者）
			ccIncEP.updateIncOepInfos(id_user, end_time, id_cc);
		} else if (IBlDictCodeConst.SD_CCTP_ZYSF.equals(sd_cctp) || IBlDictCodeConst.SD_CCTP_ZYLC.equals(sd_cctp)) {// 住院
			ccIncEP.updateIncIpInfos(id_user, end_time, id_cc);
		}
		
		//6.修改电子发票信息（bl_inc_oep_paper）
		CcElecIncEP ccElecIncEP= new CcElecIncEP();
		if (IBlDictCodeConst.SD_CCTP_MZSF.equals(sd_cctp)|| IBlDictCodeConst.SD_CCTP_MZLC.equals(sd_cctp)) {// 门诊（患者）
			ccElecIncEP.updateElecIncOepInfos(id_user, end_time, id_cc);
		}
		// 7、修改空白作废票据表(BL_INC_CANC)中结账标志为未结账
		// if(IBlDictCodeConst.SD_CCTP_MZSF.equals(sd_cctp) ||
		// IBlDictCodeConst.SD_CCTP_ZYLC.equals(sd_cctp)){//门诊预交金
		ccIncEP.updateIncCancOepInfos(id_user, end_time, id_cc, FBoolean.TRUE, sd_cctp);
		// }
		//8.修改专用款表结账标志
		UpdatePaySpclBP updatePaySpclBP= new UpdatePaySpclBP();
		updatePaySpclBP.exec(id_user, id_cc, end_time);
	}

	/*
	 * 补全收款方式
	 */
	public void setBlCcPmInfo(BlccAggDO[] blccAggDOArr) throws BizException {
		IPripmRService pmService = ServiceFinder.find(IPripmRService.class);
		PriPmDO[] priPmDOArr = pmService.find(" 1 = 1 and id_pm <> '1001Z7100000000H1L91'", null, FBoolean.FALSE);

		for (BlccAggDO aggDO : blccAggDOArr) {
			List<BlCcPmDO> blCcPmDOList = new ArrayList<BlCcPmDO>();
			if (aggDO.getBlCcPmDO() == null || aggDO.getBlCcPmDO().length == 0) {
				for (PriPmDO priPmDO : priPmDOArr) {
					BlCcPmDO blCcPmDO = new BlCcPmDO();
					blCcPmDO.setId_pm(priPmDO.getId_pm());
					blCcPmDO.setCode(priPmDO.getCode());
					blCcPmDO.setName(priPmDO.getName());
					blCcPmDO.setAmt(new FDouble(0.00, 2));
					blCcPmDO.setCn_amt(0);
					blCcPmDO.setAmt_return(new FDouble(0.00, 2));
					blCcPmDO.setCn_amtreturn(0);
					blCcPmDOList.add(blCcPmDO);
				}
			} else {
				for (PriPmDO priPmDO : priPmDOArr) {
					Boolean flag = false;
					for (BlCcPmDO blCcPmDO : aggDO.getBlCcPmDO()) {
						if (blCcPmDO.getId_pm().equals(priPmDO.getId_pm())) {
							flag = true;
							blCcPmDOList.add(blCcPmDO);
							break;
						}
					}
					if (!flag) {
						BlCcPmDO blCcPmDO = new BlCcPmDO();
						blCcPmDO.setId_pm(priPmDO.getId_pm());
						blCcPmDO.setCode(priPmDO.getCode());
						blCcPmDO.setName(priPmDO.getName());
						blCcPmDO.setAmt(new FDouble(0.00, 2));
						blCcPmDO.setCn_amt(0);
						blCcPmDO.setAmt_return(new FDouble(0.00, 2));
						blCcPmDO.setCn_amtreturn(0);
						blCcPmDOList.add(blCcPmDO);
					}
				}
			}
			aggDO.setBlCcPmDO(blCcPmDOList.toArray(new BlCcPmDO[] {}));
			TimeService timeService = new TimeServiceImpl();
			aggDO.getParentDO().setDt_pt(timeService.getUFDateTime());
		}
	}

}
