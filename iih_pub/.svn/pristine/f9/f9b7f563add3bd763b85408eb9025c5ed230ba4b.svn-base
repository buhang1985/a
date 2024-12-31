package iih.ci.ord.i.external.thirdws;


import xap.mw.core.data.BizException;

import java.io.UnsupportedEncodingException;

import org.dom4j.DocumentException;

import xap.mw.core.data.BizException;


/**
 * 临床作为数据消费方对外接口
 * @author zhangwq
 *
 */
public interface IOrdThirdWsService {
	/**
	 * 门诊回写西药信息
	 * @param xmlparam
	 * @return
	 */
	String opEmsDrugSave(String xmlparam);
	/**
	 * 门诊回写检验信息
	 * @param xmlparam
	 * @return
	 * @throws BizException 
	 * @throws DocumentException 
	 * @throws UnsupportedEncodingException 
	 */
	String opEmsLisSave(String xmlparam);
	/**
	 * 门诊回写检查信息
	 * @param xmlparam
	 * @return
	 */
	String opEmsRisSave(String xmlparam);
	/**
	 * 门诊回写手术信息
	 * @param xmlparam
	 * @return
	 */
	String opEmsOprSave(String xmlparam);
	/**
	 * 门诊回写备血信息
	 * @param xmlparam
	 * @return
	 */
	String opEmsBtSave(String xmlparam);
	/**
	 * 住院回写用血医嘱
	 * @param xmlparam
	 * @return
	 */
	String ipEmsBuSave(String xmlparam);
	/**
	 * 住院回写备血信息
	 * @param xmlparam
	 * @return
	 */
	String ipEmsBtSave(String xmlparam);
	/**
	 * 门诊回写用血信息
	 * @param xmlparam
	 * @return
	 */
	String opEmsBuSave(String xmlparam);
	/**
	 * 门诊回写诊疗信息
	 * @param xmlparam
	 * @return
	 */
	String opEmsTreatSave(String xmlparam);
	/**
	 * 门诊回写诊断信息
	 * @param xmlparam
	 * @return
	 */
	String opDiagSave(String xmlparam);
	/**
	 * 回写作废信息
	 * @param xmlparam
	 * @return
	 * @throws BizException 
	 */
	String opCancelOrd(String xmlparam);
	/**
	 * 医嘱收费状态判断接口
	 * @param xmlparam
	 * @return
	 */
	String ordBlStatus(String xmlparam);
	/**
	 * 获取医嘱号
	 * @param xmlparam
	 * @return
	 */
	String getCodeOr(String xmlparam);
	
}
