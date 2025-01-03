package iih.pis.ivx.apt.i;

import iih.bd.webservice.WsResultMsg;
import iih.en.pv.appoint.bean.CancAptAndRefundParam;
import iih.en.pv.appoint.bean.CfmPaidAptParam;
import iih.en.pv.appoint.bean.PayForAptParam;
import xap.mw.core.data.BizException;

public interface IAptCudService {
	
	/**
	 * 不缴费预约门诊号
	 * @param patCode
	 * @param id_sch
	 * @param id_dep
	 * @param name_dep
	 * @param id_doc
	 * @param name_doc
	 * @param ampm
	 * @return
	 * @throws Exception
	 */
	public Object makeApt(String patCode,String id_sch,String id_dep,String name_dep,String id_doc,String name_doc,String dt_apt) throws Exception;

	/**
	 * 取消预约(针对已预约但未缴费的情况)
	 * @param id_apt
	 * @return
	 * @throws BizException
	 */
	public WsResultMsg cancApt(String id_apt, String oprCode) throws BizException;
	
	/**
	 * 对已付费的预约(未取号)进行取消并且退号
	 * @param id_apt
	 * @return
	 * @throws BizException
	 */
	public WsResultMsg cancAptAndRefund(CancAptAndRefundParam cancAptAndRefundParam) throws BizException;
	/***
	 * @Description:划价
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public String regPricing(PayForAptParam payForAptParam, String serviceCode) throws BizException;
	/**
	 * 收取(未缴费预约门诊)的预约费
	 * @param id_apt
	 * @param oprCode
	 * @return
	 * @throws BizException
	 */
	public WsResultMsg payForApt(PayForAptParam payForAptParam, String id_stoep) throws BizException;
	/**
	 * 已收费预约取号
	 * @param id_apt
	 * @param oprCode
	 * @return
	 * @throws BizException
	 */
	public WsResultMsg cfmPaidApt(CfmPaidAptParam cfmPaidAptParam) throws BizException;

}
