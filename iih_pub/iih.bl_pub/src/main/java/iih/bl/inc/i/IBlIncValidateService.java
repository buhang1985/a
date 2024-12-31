package iih.bl.inc.i;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FBoolean;

/**
 * 发票域校验服务
 * @author ly 2018/04/04
 *
 */
public interface IBlIncValidateService {

	/**
	 * 是否打印红冲发票
	 * @param entId 就诊ID
	 * @return FBoolean
	 * @throws BizException
	 * @author yanglu
	 */
	public abstract FBoolean isPrintRedInc(String entId) throws BizException;
	
	/**
	 * 是否打印红冲发票
	 * @param hpId 医保产品id
	 * @param fgEnt 是否挂号发票
	 * @return 判断结果
	 * @throws BizException
	 * @author ly 2018/12/13
	 */
	public abstract FBoolean isPrintRedInc2(String hpId, FBoolean fgEnt) throws BizException;
	
	/**
	 * 发票是否属于当前PC或者人员
	 * @param inccaId 票据分类id
	 * @param incno 发票号
	 * @return true:属于 false:不属于
	 * @throws BizException
	 * @author ly 2018/09/14
	 */
	public abstract FBoolean isIncThisPCOrPsn(String inccaId, String incno) throws BizException;

	/**
	 * 判断结算对应的发票是否是电子发票
	 * @param stIds 结算id数组
	 * @param ecIncType 发票类型(1:门诊 2:住院)
	 * @return key：结算id value:FBoolean
	 * @throws BizException
	 * @author ly 2019/12/25
	 */
	public abstract FMap isEcInc(String[] stIds, String ecIncType) throws BizException;
}
