package iih.bl.st.s;

import iih.bl.st.dto.bloepcharge.d.BlOepChargeAccurateCondDTO;
import iih.bl.st.dto.bloepcharge.d.BlOepChargeCommonCondDTO;
import iih.bl.st.dto.bloepcharge.d.BlOepChargeInputDTO;
import iih.bl.st.dto.bloepcharge.d.BlOepChargeSvCheckDTO;
import iih.bl.st.dto.bloeprefunddto.d.BlOepRefundDTO;
import iih.bl.st.dto.blpayoep.d.BlPayOepPmDTO;
import iih.bl.st.dto.d.BlStOepVsIncDTO;
import iih.bl.st.dto.d.BlStReFundBillDTO;
import iih.bl.st.i.IBlOepChargeQryService;
import iih.bl.st.s.bp.oepcharge.BlOepChargeCheckOrdSvBP;
import iih.bl.st.s.bp.oepcharge.FindOepCgItmByStIdBP;
import iih.bl.st.s.bp.oepcharge.FindOepPayItmByStIdBP;
import iih.bl.st.s.bp.oepcharge.FindOepPeStIncInfoByPatIdBP;
import iih.bl.st.s.bp.oepcharge.FindOepStIncInfoByPatIdBP;
import iih.bl.st.s.bp.oepcharge.GetOepCostInfoAccurateBP;
import iih.bl.st.s.bp.oepcharge.GetOepCostInfoCommonCondBP;
import iih.bl.st.s.bp.oepcharge.GetOepCostInfoOneDayBP;
import iih.bl.st.s.bp.oepcharge.GetOepCostInfoPeriodBP;
import iih.bl.st.s.bp.op.FindOepCgItmByStIdsBP;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;

/**
 * 门诊收费查询服务
 * 
 * @author zhangxin 2018年11月20日
 *
 */
@Service(serviceInterfaces = { IBlOepChargeQryService.class }, binding = Binding.JSONRPC)
public class BlOepChargeQryServiceImpl implements IBlOepChargeQryService {

	/**
	 * 门诊调入(一日费用)
	 * @param patId 患者id
	 * @return 待收费信息
	 * @throws BizException
	 * @author ly 2018/12/09
	 */
	@Override
	public BlOepChargeInputDTO[] findOepCostInfoOneDay(String patId) throws BizException {
		GetOepCostInfoOneDayBP bp = new GetOepCostInfoOneDayBP();
		return bp.exec(patId);
	}

	/**
	 * 门诊调入(时间段)
	 * @param patId 患者id
     * @param dtBegin 开始时间
     * @param dtEnd 结束时间
     * @return 待收费信息
	 * @throws BizException
	 * @author ly 2018/12/04
	 */
	@Override
	public BlOepChargeInputDTO[] findOepCostInfoPeriod(String patId, FDate dtBegin, FDate dtEnd) throws BizException{
		GetOepCostInfoPeriodBP bp = new GetOepCostInfoPeriodBP();
		return bp.exec(patId, dtBegin, dtEnd);
	}
	
	 /**
     * 门诊调入(多条件)
     * @param condDto 条件
     * @return 待收费信息
     * @throws BizException
     * @author ly 2019/07/03
     */
	@Override
    public BlOepChargeInputDTO[] findOepCostInfoCond(BlOepChargeCommonCondDTO condDto) throws BizException{
		GetOepCostInfoCommonCondBP bp = new GetOepCostInfoCommonCondBP();
		return bp.exec(condDto);
	}

	/**
	 * 门诊调入(精准调入)
	 * 
	 * @param 精准调入条件
	 * @return
	 * @throws BizException
	 * @author ly 2018/12/04
	 */
	@Override
	public BlOepChargeInputDTO[] findOepCostInfoAccurate(BlOepChargeAccurateCondDTO condDto) throws BizException {
		GetOepCostInfoAccurateBP bp = new GetOepCostInfoAccurateBP();
		return bp.exec(condDto);
	}

	
	 /**
     * 根据结算id查询记账明细（体检退费使用）
     * @param stId
     * @return
     * @throws BizException
     * @author wq.li 2018/12/11
     */
	@Override
    public BlOepRefundDTO[] findOepCgItmByStId(String stId) throws BizException{
		FindOepCgItmByStIdBP bp=new FindOepCgItmByStIdBP();
		return bp.exec(stId);
	}

	/**
     * 根据结算id查询支付信息
     * @param stId
     * @return
     * @throws BizException
     * @author wq.li 2018年12月12日
     */
    public BlPayOepPmDTO[] findOepPayItmByStId(String stId)throws BizException{
    	FindOepPayItmByStIdBP bp =new FindOepPayItmByStIdBP();
    	return bp.exec(stId);
    }

    /**
     * 查询人员的结算发票信息
     * @param patId
     * @param dtB
     * @param dtE
     * @return
     * @throws BizException
     */
    public BlStOepVsIncDTO[] findOepStIncInfoByPatId(String patId,FDateTime dtB,FDateTime dtE)throws BizException{
    	FindOepStIncInfoByPatIdBP bp=new FindOepStIncInfoByPatIdBP();
    	return bp.exec(patId, dtB, dtE);
    }
    /**
     * 查询体检人员的结算发票信息
     * @param patId
     * @param dtB
     * @param dtE
     * @return
     * @throws BizException
     */
    public BlStOepVsIncDTO[] findOepPeStIncInfoByPatId(String patId,FDateTime dtB,FDateTime dtE)throws BizException{
    	FindOepPeStIncInfoByPatIdBP bp=new FindOepPeStIncInfoByPatIdBP();
    	return bp.exec(patId, dtB, dtE);
    }
   	 /**
     * 根据结算id查询记账明细
     * @param stId
     * @return
     * @throws BizException
     * @author wq.li 2018/12/11
     */
	@Override
    public BlStReFundBillDTO[] findOepCgItmByStIds(String[] stIdArr) throws BizException{
    	FindOepCgItmByStIdsBP bp=new FindOepCgItmByStIdsBP();
		return bp.exec(stIdArr);
	}

	/**
     * 门诊收费校验医嘱sv
     * @param checkDtos
     * @throws BizException
     * @author ly 2019/11/28
     */
	@Override
    public void checkOrdSv(BlOepChargeSvCheckDTO[] checkDtos) throws BizException{
		BlOepChargeCheckOrdSvBP bp = new BlOepChargeCheckOrdSvBP();
		bp.exec(checkDtos);
    }
}
