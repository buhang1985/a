package iih.mc.st.dmout.i;

import iih.mc.st.dmout.d.DmoutAggDO;
import iih.mc.st.dmout.d.McDamageOutDO;
import xap.mw.core.data.BizException;

public interface IDmoutMaintainService {
	
	/**
	 * 初始化报损单
	 * @param sd_sttp 库存交易类型
	 * @throws BizException
	 */
	public DmoutAggDO initAggDo(String sd_sttp) throws BizException;
	
	/**
	 * 报损单提交
	 * @param mcDamageOutDo 主报损单
	 * @throws BizException
	 */
	public McDamageOutDO[] submitMainDO(McDamageOutDO[] mcDamageOutDo) throws BizException;	
	
	/**
	 * 卡报损单提交
	 * @param dmOutAggDO 卡报损单
	 * @throws BizException
	 */
	public DmoutAggDO submitAggDO(DmoutAggDO dmOutAggDO) throws BizException;
	
	/**
	 * 报损单审核
	 * @param DmoutAggDO 卡报损单审核通过
	 * @throws BizException
	 */
	public DmoutAggDO auditsubmit(DmoutAggDO dmOutAggDO) throws BizException;
	
	/**
	 * 报损单审核
	 * @param DmoutAggDO 卡报损单审核驳回
	 * @throws BizException
	 */
	public DmoutAggDO auditreject(DmoutAggDO dmOutAggDO) throws BizException;
	

}
