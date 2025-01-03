package iih.ci.ord.s.external.obtain.bp.bl;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.pp.bdprewarn.d.BdPreWarnDO;
import iih.bl.pay.dto.d.PrePaidAccAmtDTO;
import iih.bl.pay.dto.prepayamount.d.BlPrepayCondDTO;
import iih.bl.pay.i.IBlPayOutQryService;
import iih.ci.ord.i.external.obtain.meta.bl.PrePaidAccAmt4CiDTO;
import iih.en.pv.enfee.dto.d.BalanceDTO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitRService;
import xap.lui.core.xml.StringUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 获取患者预交金查询判断是否欠费
 * 
 * @author liyuelong 2020/1/15
 */
public class GetPatAccJudgeBP {
	public PrePaidAccAmt4CiDTO exec(String code_entp, String id_en, String id_pat,String id_patca) throws BizException {
		// 入参校验
		if (StringUtils.isEmpty(code_entp) || StringUtils.isEmpty(id_en) || StringUtils.isEmpty(id_pat)) {
			return null;
		}
		// 调用费用域接口
		BlPrepayCondDTO blPrepayCondDto = new BlPrepayCondDTO();
		blPrepayCondDto.setCode_entp(code_entp);
		blPrepayCondDto.setId_ent(id_en);
		blPrepayCondDto.setId_pat(id_pat);
		PatiVisitDO ent = ServiceFinder.find(IPativisitRService.class).findById(id_en);
		if (StringUtils.isEmpty(ent.getId_patca())) {
			return null;
		}
		blPrepayCondDto.setId_patca(ent.getId_patca());
		PrePaidAccAmtDTO accAmtDto = null;
		if (IBdFcDictCodeConst.SD_CODE_ENTP_IP.equals(code_entp)||IBdFcDictCodeConst.SD_CODE_ENTP_IP_PRE.equals(code_entp)) {// 住院医生站和预住院医生站 modify by wangqingzhu at 2020.3.27 10:56
			accAmtDto = ServiceFinder.find(IBlPayOutQryService.class).getAccJudge(blPrepayCondDto);
		} else if (IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS.equals(code_entp)) {// 急诊留观医生站
			accAmtDto = ServiceFinder.find(IBlPayOutQryService.class).getETAccJudge(code_entp, id_en, id_pat,
					ent.getId_patca());
		}
		PrePaidAccAmt4CiDTO CiaccAmtDto = new PrePaidAccAmt4CiDTO();
		CiaccAmtDto.setFg_arrears(accAmtDto.getFg_arrears());
		CiaccAmtDto.setSd_arslv(accAmtDto.getSd_arslv());
		CiaccAmtDto.setAmt_limit(accAmtDto.getAmt_limit());
		CiaccAmtDto.setAmt_available(accAmtDto.getAmt_available());
		CiaccAmtDto.setSd_prewarntp(accAmtDto.getSd_prewarntp());
		CiaccAmtDto.setAmt_prepay(accAmtDto.getAmt_prepay());
		CiaccAmtDto.setAmt_bal(accAmtDto.getAmt_bal());
		if (accAmtDto.getBalancedtos() != null && accAmtDto.getBalancedtos().size() > 0) {
			@SuppressWarnings("unchecked")
			BalanceDTO[] balanceDTOs = (BalanceDTO[]) accAmtDto.getBalancedtos()
					.toArray(new BalanceDTO[accAmtDto.getBalancedtos().size()]);
			CiaccAmtDto.setAmt_uncg(balanceDTOs[0].getAmt_uncg());
		}
		// 费用预交金管理策略计算
		getControlInfo(accAmtDto, CiaccAmtDto);
		return CiaccAmtDto;
	}

	@SuppressWarnings("unchecked")
	public void getControlInfo(PrePaidAccAmtDTO blAccAmtDto, PrePaidAccAmt4CiDTO ciAccAmt4CiDto) {
		if (blAccAmtDto.getPrewarns() != null && blAccAmtDto.getPrewarns().size() > 0) {
			BdPreWarnDO bdPreWarnDO = ((BdPreWarnDO[]) blAccAmtDto.getPrewarns()
					.toArray(new BdPreWarnDO[blAccAmtDto.getPrewarns().size()]))[0];
			ciAccAmt4CiDto.setAllControl(bdPreWarnDO.getF_control());
			ciAccAmt4CiDto.setSomeControl(bdPreWarnDO.getP_control());
			ciAccAmt4CiDto.setPrompt(bdPreWarnDO.getLimit());
		} 
	}
}
