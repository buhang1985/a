package iih.ems.eass.emshift.i;




import iih.ems.eass.emshift.d.EmsEmShiftDO;
import iih.ems.eass.emshift.d.EmshiftAggDO;
import xap.mw.core.data.BizException;

public interface IEmshiftMaintainService {

	
	public EmshiftAggDO inDo(String sd_sttp) throws BizException;
	/**
	 * 变更单提交
	 * 
	 * @param mcDamageOutDo
	 *            主变更单
	 * @throws BizException
	 */
	public EmsEmShiftDO[] submitMainDO(EmsEmShiftDO[] emShiftDOs) throws BizException;
	


	/**
	 * 变更单审核
	 * 
	 * @param DmoutAggDO
	 *            卡变更单审核通过
	 * @throws BizException
	 */
	public EmshiftAggDO auditsubmit(EmshiftAggDO emShiftDO) throws BizException;

	/**
	 * 变更单审核
	 * 
	 * @param DmoutAggDO
	 *            卡变更单审核驳回
	 * @throws BizException
	 */
	public EmshiftAggDO auditreject(EmshiftAggDO emShiftDO) throws BizException;
	//作废
	public EmshiftAggDO[] cancellation(EmshiftAggDO[] emShiftDOs) throws BizException;
	//初始化
	public EmshiftAggDO initAggDo() throws BizException;

}
