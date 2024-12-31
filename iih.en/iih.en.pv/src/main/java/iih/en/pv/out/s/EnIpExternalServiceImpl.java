package iih.en.pv.out.s;

import iih.bd.utils.WsXmlUtils;
import iih.bd.webservice.BaseWsResult;
import iih.en.comm.util.EnLogUtil;
import iih.en.pv.out.i.IEnIpExternal;
import iih.en.pv.s.bp.ip.RecordIpAcptDtBP;
import iih.en.pv.s.bp.ip.ws.GetBedInfoBP;
import iih.en.pv.s.bp.ip.ws.GetCancIpInfoBP;
import iih.en.pv.s.bp.ip.ws.GetInpatientInfoBP;
import iih.en.pv.s.bp.ip.ws.GetIpAllInfoByDepBP;
import iih.en.pv.s.bp.ip.ws.GetIpAllInfoByIpCodeBP;
import iih.en.pv.s.bp.ip.ws.GetIpAllInfoByPatBP;
import iih.en.pv.s.bp.ip.ws.GetIpEntBedInfoBP;
import iih.en.pv.s.bp.ip.ws.GetIpEntContInfoBP;
import iih.en.pv.s.bp.ip.ws.GetIpEntDepTransInfoBP;
import iih.en.pv.s.bp.ip.ws.GetIpEntDiInfoBP;
import iih.en.pv.s.bp.ip.ws.GetIpEntHpInfoBP;
import iih.en.pv.s.bp.ip.ws.GetIpEntStateInfoBP;
import iih.en.pv.s.bp.ip.ws.GetIpInfoByDepBP;
import iih.en.pv.s.bp.ip.ws.GetIpInfoByIpCodeBP;
import iih.en.pv.s.bp.ip.ws.GetIpInfoByPatBP;
import iih.en.pv.s.bp.ip.ws.GetScAptByPatBP;
import iih.en.pv.s.bp.ip.ws.PrintIpWristBP;
import iih.en.pv.s.bp.ip.ws.SaveRegEntIpBP;
import iih.en.pv.s.bp.ip.ws.bean.PrintIpWristReturnBean;
import iih.en.pv.s.bp.ip.ws.bean.PrintIpwristParamBean;
import iih.en.pv.s.bp.ip.ws.bean.RecordIpAcptDtBean;
import xap.mw.core.data.BizException;

public class EnIpExternalServiceImpl implements IEnIpExternal {
    /**
     * 查询病区或者科室的住院患者信息
     * 
     * 
     * @param requestXML
     * @return
     */
    public String GetIpInfoByDep(String requestXML) {
    	return new GetIpInfoByDepBP().exec(requestXML);
    }
    /**
     * 根据患者住院号 获取患者住院信息
     * 
     * @param requestXML
     * @return
     */
    public String GetIpInfoByIpCode(String requestXML) {
    	return new GetIpInfoByIpCodeBP().exec(requestXML);
    }
	/**
     * 根据患者code 和住院次数 获取患者住院信息
     * @param requestXML
     * @return
     */
    public String GetIpInfoByPat(String requestXML) {
    	return new GetIpInfoByPatBP().exec(requestXML);
    }
    /**
	 * 查询病区或者科室的住院患者信息
	 * 
	 * @param requestXML
	 * @return
	 */
	@Override
	public String GetIpInfoAllByDep(String requestXML) {
    	return new GetIpAllInfoByDepBP().exec(requestXML);
	}
	/**
	 * 根据患者编码和住院次数查询患者住院信息
	 * 
	 * @param requestXML
	 * @return
	 */
	@Override
	public String GetIpInfoAllByPat(String requestXML) {
    	return new GetIpAllInfoByPatBP().exec(requestXML);
	}
	/**
	 * 根据住院号查询患者住院信息
	 * 
	 * @param requestXML
	 * @return
	 */
	@Override
	public String GetIpInfoAllByIpCode(String requestXML) {
    	return new GetIpAllInfoByIpCodeBP().exec(requestXML);
	}
	/**
	 * 根据就诊编码查询患者住院最新诊断信息
	 * 
	 * @param requestXML
	 * @return
	 */
	@Override
	public String GetEntDi(String requestXML) {
		return new GetIpEntDiInfoBP().exec(requestXML);
	}
	/**
	 * 查询患者住院医保信息
	 * 
	 * @param requestXML
	 * @return
	 */
	@Override
	public String GetEntHp(String requestXML) {
		return new GetIpEntHpInfoBP().exec(requestXML);
	}
	/**
	 * 查询住院患者状况信息信息
	 * 
	 * @param requestXML
	 * @return
	 */
	@Override
	public String GetEntState(String requestXML) {
		return new GetIpEntStateInfoBP().exec(requestXML);
	}
	/**
	 * 查询患者住院转科记录
	 * 
	 * @param requestXML
	 * @return
	 */
	@Override
	public String GetEntDepTrans(String requestXML) {
		return new GetIpEntDepTransInfoBP().exec(requestXML);
	}
	/**
	 * 查询患者住院床位过程记录信息
	 * 
	 * @param requestXML
	 * @return
	 */
	@Override
	public String GetEntBed(String requestXML) {
		return new GetIpEntBedInfoBP().exec(requestXML);
	}
	/**
	 * 查询住院患者联系人
	 * 
	 * @param requestXML
	 * @return
	 */
	@Override
	public String GetEntCont(String requestXML) {
		return new GetIpEntContInfoBP().exec(requestXML);
	}
	/**
	 * 查询患者住院其他信息
	 * 
	 * @param requestXML
	 * @return
	 */
	@Override
	public String GetEntMisc(String requestXML) {
		
		return null;
	}

	/**
	 * 获取床位信息 Code_Dept 病区编码
	 * 
	 * @param inputParam
	 * @return
	 */
	public String GetBedInfo(String inputParam) {
		EnLogUtil.getInstance().logInfo("方法：GetBedInfo参数为:inputParam:" + inputParam);
		GetBedInfoBP bp = new GetBedInfoBP();
		String rtnXml = bp.exec(inputParam);
		return rtnXml;
	}

	/**
	 * 获取一段时间内的退院患者列表
	 * 
	 * @param inputParam
	 * @return
	 */
	@Override
	public String GetCancIpInfos(String inputParam) {
		EnLogUtil.getInstance().logInfo("方法：GetCancIpInfos参数为:inputParam:" + inputParam);
		GetCancIpInfoBP bp = new GetCancIpInfoBP();
		String rtnXml = bp.exec(inputParam);
		return rtnXml;
	}
	
	/**
	 * 获取入院许可证
	 * @param param
	 * @return
	 */
	@Override
	public String getScAptByPat(String param) {
		EnLogUtil.getInstance().logInfo("方法：getScAptByPat入参为:Param:" + param);
		GetScAptByPatBP bp = new GetScAptByPatBP();
        String rtnXml = bp.exec(param);
        EnLogUtil.getInstance().logInfo("方法：getScAptByPat出参为:result:" + rtnXml);
        return rtnXml;
	}
	
    /**
     * 查询患者能够(打印病案信息)的历次住院基本信息
     */
	@Override
	public String GetInpatientInfo(String param) {
		EnLogUtil.getInstance().logInfo("方法：GetInpatientInfo入参为:Param:" + param);
		GetInpatientInfoBP bp = new GetInpatientInfoBP();
        String rtnXml = bp.exec(param);
        EnLogUtil.getInstance().logInfo("方法：GetInpatientInfo出参为:result:" + rtnXml);
        return rtnXml;
	}
    /**
     * 修改打印次数并返回修改后的次数
     *  PatCode  患者编码
     *  Times_ip 住院次数
     * @param inputParam
     * @return 
     */
    public String PrintIpWrist(String inputParam) {
        EnLogUtil.getInstance().logInfo("方法：PrintIpWrist参数为:inputParam:" + inputParam);
        final PrintIpwristParamBean inputBean = WsXmlUtils.deSerializeBaseDO(inputParam, PrintIpwristParamBean.class);
        PrintIpWristReturnBean resultBean = new PrintIpWristReturnBean();
        try {
            PrintIpWristBP bp = new PrintIpWristBP();
            int exec = bp.exec(inputBean.getPatCode(), inputBean.getTimes_ip());
            resultBean.setTimes_print(exec);
        } catch (BizException e) {
        	BaseWsResult resultBeanErr = new BaseWsResult();
        	resultBeanErr.setException(e);
        	return WsXmlUtils.serialize(resultBeanErr);
        }
        return WsXmlUtils.serialize(resultBean);
    }
	/**
	 * 记录移动护理入科时间
	 * 
	 * @param patCode
	 * @param times_ip
	 * @param dt_acpt
	 * @param operatorCode
	 * @param flag
	 * @return
	 * @throws BizException 
	 * @author jizb
	 */
	@Override
	public String recordIpAcptDt(String param){
	    EnLogUtil.getInstance().logInfo("方法：recordIpAcptDt参数为:param:" + param);
		final RecordIpAcptDtBean paramBean = WsXmlUtils.deSerializeBaseDO(param, RecordIpAcptDtBean.class);
		BaseWsResult resultBean = new BaseWsResult();
		
		RecordIpAcptDtBP bp = new RecordIpAcptDtBP();
		try {
			bp.exec(paramBean.getPatCode(), paramBean.getTimesIp(), paramBean.getDtAcpt(), paramBean.getOperatorCode(), paramBean.getFlag());
		} catch (BizException e) {
			resultBean.setException(e);
		}
		return WsXmlUtils.serialize(resultBean);
	}
	
	/**
	 * 保存住院登记
	 * @param param
	 * @return
	 */
	@Override
	public String saveRegEntIp(String param) {
		EnLogUtil.getInstance().logInfo("方法：saveRegEntIp入参为:Param:" + param);
		SaveRegEntIpBP bp = new SaveRegEntIpBP();
        String rtnXml = bp.exec(param);
        EnLogUtil.getInstance().logInfo("方法：saveRegEntIp出参为:result:" + rtnXml);
        return rtnXml;
	}
    
}
