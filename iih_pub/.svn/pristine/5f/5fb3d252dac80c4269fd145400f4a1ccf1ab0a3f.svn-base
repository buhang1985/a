package iih.ci.ord.i.third;

import java.util.List;

import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.dto.thirdparam.ChargeForCiParamDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.OrderRstDTO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import xap.mw.core.data.BizException;

public interface ICiOrderThirdService {
	/**
	 * 医技补录医嘱
	 * 
	 * @param szOrderAggInfo
	 * @return
	 */
	public abstract ThirdRstDTO save(CiorderAggDO[] szOrderAggInfo) throws BizException;

	/**
	 * 批量删除医技补录医嘱
	 * 
	 * @param szId_or
	 * @return
	 * @throws BizException
	 */
	public abstract ThirdRstDTO delete(String[] szId_or) throws BizException ;
	/**
	 * 简洁收费功能
	 * @param pat
	 * @param params
	 * @return
	 * @throws BizException
	 */
	public abstract ThirdRstDTO[] tidyFeeSave(PatiVisitDO pat, ChargeForCiParamDTO[] params) throws BizException;
	/**
	 * 医技补费（药品）保存
	 * @param params
	 * @return
	 * @throws BizException
	 */
	public abstract ThirdRstDTO medicalPatchFeeSave(ChargeForCiParamDTO[] params) throws BizException;
	/**
	 * 医技补费作废
	 * @param szId_or
	 * @return
	 * @throws BizException
	 */
	public abstract ThirdRstDTO cancel(String[] szId_or) throws BizException;
	/**
	 * 医嘱签署逻辑
	 * @param ctx
	 * @param idors
	 * @return
	 * @throws BizException
	 */
	public abstract OrderRstDTO signOrdByCtxIdors(CiEnContextDTO ctx, String[] idors) throws BizException;
	/**
	 * 医嘱签署逻辑
	 * @param ctx
	 * @param ciors
	 * @return
	 * @throws BizException
	 */
	public abstract OrderRstDTO signOrdByCtxOrdArrays(CiEnContextDTO ctx, CiOrderDO[] ciors) throws BizException;
	/**
	 * 医嘱签署逻辑
	 * @param ctx
	 * @param ciors
	 * @return
	 * @throws BizException
	 */
	public abstract OrderRstDTO signOrdByCtxOrdList(CiEnContextDTO ctx, List<CiOrderDO> ciors) throws BizException;
	/**
	 * 医嘱签署逻辑
	 * @param idors
	 * @return
	 * @throws BizException
	 */
	public abstract OrderRstDTO signOrdByIdors(String[] idors) throws BizException;
	/**
	 * 医嘱签署逻辑
	 * @param ciors
	 * @return
	 * @throws BizException
	 */
	public abstract OrderRstDTO signOrdByOrdArrays(CiOrderDO[] ciors) throws BizException;
	/**
	 * 医嘱签署逻辑
	 * @param ciors
	 * @return
	 * @throws BizException
	 */
	public abstract OrderRstDTO signOrdByOrdList(List<CiOrderDO> ciors) throws BizException;
}
