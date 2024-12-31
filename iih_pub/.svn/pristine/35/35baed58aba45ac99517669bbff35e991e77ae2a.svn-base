package iih.bl.st.i;

import iih.bl.st.dto.bloepcharge.d.BlOepChargeAccurateCondDTO;
import iih.bl.st.dto.bloepcharge.d.BlOepChargeCommonCondDTO;
import iih.bl.st.dto.bloepcharge.d.BlOepChargeInputDTO;
import iih.bl.st.dto.bloepcharge.d.BlOepChargeSvCheckDTO;
import iih.bl.st.dto.bloeprefunddto.d.BlOepRefundDTO;
import iih.bl.st.dto.blpayoep.d.BlPayOepPmDTO;
import iih.bl.st.dto.d.BlStOepVsIncDTO;
import iih.bl.st.dto.d.BlStReFundBillDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;

/**
 * 门诊收费查询服务
 * 
 * @author ly 2018/11/19
 *
 */
public interface IBlOepChargeQryService {
	
    /**
     * 门诊调入(一日费用)
     * @param patId 患者id
     * @return 待收费信息
     * @throws BizException
     * @author ly 2018/12/04
     */
    public abstract BlOepChargeInputDTO[] findOepCostInfoOneDay(String patId) throws BizException;

    /**
     * 门诊调入(时间段)
     * @param patId 患者id
     * @param dtBegin 开始时间
     * @param dtEnd 结束时间
     * @return 待收费信息
     * @throws BizException
     * @author ly 2018/12/04
     */
    public abstract BlOepChargeInputDTO[] findOepCostInfoPeriod(String patId, FDate dtBegin, FDate dtEnd) throws BizException;

    /**
     * 门诊调入(多条件)
     * @param condDto 条件
     * @return 待收费信息
     * @throws BizException
     * @author ly 2019/07/03
     */
    public abstract BlOepChargeInputDTO[] findOepCostInfoCond(BlOepChargeCommonCondDTO condDto) throws BizException;
    
    /**
     * 门诊调入(精准调入)
     * @param 精准调入条件
     * @return
     * @throws BizException
     * @author ly 2018/12/04
     */
    public abstract BlOepChargeInputDTO[] findOepCostInfoAccurate(BlOepChargeAccurateCondDTO condDto) throws BizException;

    /**
     * 根据结算id查询记账明细（体检退费使用）
     * @param stId
     * @return
     * @throws BizException
     * @author wq.li 2018/12/11
     */
    public abstract BlOepRefundDTO[] findOepCgItmByStId(String stId) throws BizException;
    /**
     * 根据结算id查询支付信息
     * @param stId
     * @return
     * @throws BizException
     * @author wq.li 2018年12月12日
     */
    public abstract BlPayOepPmDTO[] findOepPayItmByStId(String stId)throws BizException;

    /**
     * 查询人员的结算发票信息
     * @param patId
     * @param dtB
     * @param dtE
     * @return
     * @throws BizException
     */
    public abstract BlStOepVsIncDTO[] findOepStIncInfoByPatId(String patId,FDateTime dtB,FDateTime dtE)throws BizException;
    /**
     * 查询体检人员的结算发票信息
     * @param patId
     * @param dtB
     * @param dtE
     * @return
     * @throws BizException
     */
    public abstract BlStOepVsIncDTO[] findOepPeStIncInfoByPatId(String patId,FDateTime dtB,FDateTime dtE)throws BizException;
    /**
     * 根据结算id查询记账明细
     * @param stId
     * @return
     * @throws BizException
     * @author wq.li 2018/12/11
     */
    public abstract BlStReFundBillDTO[] findOepCgItmByStIds(String[] stIdArr) throws BizException;

    /**
     * 门诊收费校验医嘱sv
     * @param checkDtos
     * @throws BizException
     * @author ly 2019/11/28
     */
    public abstract void checkOrdSv(BlOepChargeSvCheckDTO[] checkDtos) throws BizException;
}
