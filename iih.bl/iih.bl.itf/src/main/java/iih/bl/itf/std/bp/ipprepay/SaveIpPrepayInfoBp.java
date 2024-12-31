package iih.bl.itf.std.bp.ipprepay;

import java.util.HashMap;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import iih.bl.pay.blpaypat.d.BlPrePayPatDO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.i.IPatiRService;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bl.comm.IBlMsgConst;
import iih.bl.comm.XmlUtils;
import iih.bl.itf.std.bean.input.prepay.BlIpPrepayParamDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.orgfw.dept.d.DeptDO;
import xap.sys.orgfw.dept.i.IDeptRService;



public class SaveIpPrepayInfoBp {
	
	/**
	 * 主入口
	 * 
	 * @param params 从第三方传入的预交金相关信息，包括患者信息、操作员信息、支付凭证号、收单机构流水号、录入的收款金额、 支付方式等
	 * @return
	 * @throws BizException
	 */
	public String exec(BlIpPrepayParamDTO[] params) throws BizException {
		//1.实例化Document对象
		Document document = XmlUtils.getDocumentObj();

		//2.初始化xml
		HashMap<String, Element> reMap = new HashMap<String, Element>();
		initxml(document, reMap);
		try {
			//3.基础校验
			validation(params);
			
			String depID = ""; //需要指定收费科室
			
			//4.根据患者编码和住院次数初始化患者就诊DO
			PatiVisitDO patiVistDO = this.initPatiVisitInfo(params); 
					
			//5.住院缴押金
			for (BlIpPrepayParamDTO blIpPrepayParamDTO : params) {
				this.execSaveIpPrepayInfo(blIpPrepayParamDTO, patiVistDO, depID);
			}	
		} catch (Exception e) {
			e.printStackTrace();
			reMap.get("code").setTextContent(IBlMsgConst.FG_FAIL);
			reMap.get("message").setTextContent(e.getMessage());
		}
		// 生成xml字符串
		String rtn = XmlUtils.getXmlStr(document);

		return rtn;
	}
	
	/**
	 * 基础校验
	 * 
	 * @param params
	 * @throws BizException
	 */
	private void validation(BlIpPrepayParamDTO[] params) throws BizException {
		if (params == null || params.length <= 0)
			throw new BizException("住院缴押金:参数空异常！");
		Integer index = 0;
		for (BlIpPrepayParamDTO prepay : params) {
			if (StringUtil.isEmptyWithTrim(prepay.getPatcode())) {
				throw new BizException("住院缴押金:第【" + (index + 1) + "】行患者编码空异常！");
			}
			if (StringUtil.isEmptyWithTrim(prepay.getPaymentmethod())) {
				throw new BizException("住院缴押金:第【" + (index + 1) + "】行支付方式空异常！");
			}
			if (StringUtil.isEmptyWithTrim(prepay.getDocumentnumber())) {
				throw new BizException("住院缴押金:第【" + (index + 1) + "】行支付凭证号空异常！");
			}
			if (StringUtil.isEmptyWithTrim(prepay.getOrdernumber())) {
				throw new BizException("住院缴押金:第【" + (index + 1) + "】行收单机构流水号空异常！");
			}
			try {
				FDouble tmpAmt = new FDouble(prepay.getPaymoney());
				if (tmpAmt.getDouble() <= 0) {
					throw new BizException("住院缴押金:第【" + (index + 1) + "】行缴款金额不能小于等于零！");
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new BizException(e.getMessage());
			}
			index++;
		}

		for (int i = 0; i < params.length; i++) {
			if (!params[i].getOperacode().equals(params[0].getOperacode())) {
				throw new BizException("住院缴押金：操作员不一致！");
			}
		}
	}
	
	/**
	 *住院 预交金数据保存
	 * @param blIpPrepayParamDTO  
	 * @param patiVistDO 患者就诊信息
	 * @param depID 收付款科室
	 */
	public void execSaveIpPrepayInfo(BlIpPrepayParamDTO blIpPrepayParamDTO, PatiVisitDO patiVistDO, String depID) 
			throws BizException{
		try{	
					
			//1.先插入一条住院预交金数据，
			BlPrepayPatDOEp  prepayEp = new BlPrepayPatDOEp();	
						
			//2.先插入一条住院预交金数据，保存
			BlPrePayPatDO[] blPrePayPatDOArr = prepayEp.insertPrepayInfo(blIpPrepayParamDTO, patiVistDO, IBdFcDictCodeConst.ID_CODE_ENTP_IP, depID);
		
			//3.再更新就诊账户信息， 账户信息修改接口：当为住院时修改就诊账户信息，同时支持门诊或者住院的账户修改
			FDouble payMoney = new FDouble(blIpPrepayParamDTO.getPaymoney());
			
			prepayEp.updatePiPatAccInfo(payMoney, blPrePayPatDOArr[0], IBdFcDictCodeConst.ID_CODE_ENTP_IP);	
		
		} catch (Exception e) {
			e.printStackTrace();
			throw new BizException(e.getMessage());
		}
	}


	/**
	 * 实例化结果信息，并返回根节点
	 * 
	 * @param document
	 * @param reMap
	 */
	private void initxml(Document document, HashMap<String, Element> reMap) {
		// 根节点
		Element root = document.createElement("results");
		document.appendChild(root);
			
		// msg内容节点
		Element eleCode = document.createElement("code");
		eleCode.setTextContent(IBlMsgConst.FG_SUCESS);
		Element eleMsg = document.createElement("message");
		eleMsg.setTextContent("住院缴押金成功！");
		root.appendChild(eleCode);
		root.appendChild(eleMsg);
		reMap.put("code", eleCode);
		reMap.put("message", eleMsg);
	}
	
	/**
	 * 根据患者编码查在院患者就诊DO
	 * 
	 * @param params
	 * @return
	 * @throws BizException
	 */
	private PatiVisitDO initPatiVisitInfo(BlIpPrepayParamDTO[] params) throws BizException {
		// 获取患者在院就诊信息
		DAFacade daFacade = new DAFacade();
		StringBuilder sqlStrBuf = new StringBuilder();
		sqlStrBuf.append("SELECT a.id_pat, ");
		sqlStrBuf.append(" b.times_ip, ");
		sqlStrBuf.append(" a.id_ent, ");
		sqlStrBuf.append(" a.id_pripat ");
		sqlStrBuf.append("FROM en_ent a ");
		sqlStrBuf.append("inner join en_ent_ip b on a.id_ent = b.id_ent ");
		sqlStrBuf.append("inner join pi_pat pat on a.id_pat= pat.id_pat ");
		sqlStrBuf.append("WHERE (a.fg_ip='Y') and (pat.code = ?) ");
		//sqlStrBuf.append(" AND (b.times_ip = ?) ");
		SqlParam sqlp1 = new SqlParam();
		sqlp1.addParam(params[0].getPatcode());
		//Integer timesIp = new Integer(params[0].getTimesip());
		//sqlp1.addParam(timesIp);
		List<PatiVisitDO> tmpDTO = (List<PatiVisitDO>) daFacade.execQuery(sqlStrBuf.toString(), sqlp1, new BeanListHandler(PatiVisitDO.class));
		if (tmpDTO == null || tmpDTO.size() <= 0) {
			throw new BizException("住院缴押金：患者编码为" + params[0].getPatcode() + "("+ params[0].getTimesip() + ")的就诊患者不存在！");
		}	
		if (tmpDTO != null && tmpDTO.size() > 0) 
		{
			return tmpDTO.get(0);
		}
		return null;
	}
	
}
