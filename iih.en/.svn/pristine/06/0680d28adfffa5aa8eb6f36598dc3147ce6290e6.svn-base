package iih.en.comm.bp;


import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.fc.entp.d.EnTypeDO;
import iih.bd.fc.entp.i.IEntpRService;
import iih.en.comm.ep.ErPreEP;
import iih.en.comm.validator.EnValidator;
import iih.en.er.pre.d.EnErPreDO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 获取就诊类型
 * 
 * @author liubin
 *
 */
public class GetEntpBP {
	/**
     * 获取就诊类型
     * 
     * @param codeType
     * @param erPreId
     * @return
     * @throws BizException
     */
	public EnTypeDO exec(String codeType, String erPreId) throws BizException {
		//1.获取就诊类型编码
		String code = getCode(codeType, erPreId);
		//2.获取do
		EnTypeDO enTpDo = getEnTpDo(code);
		
		return enTpDo;
	}
	/**
	 * 获取就诊类型编码
	 * 
	 * @param codeType
	 * @param erPreId
	 * @return
	 * @throws BizException
	 */
	private String getCode(String codeType, String erPreId) throws BizException {
		String code = null;
		if (IBdFcDictCodeConst.SD_CODE_ENTP_ET.equals(codeType)) {
			code = IBdFcDictCodeConst.SD_CODE_ENTP_ET_FLOW;
		} else {
			code = IBdFcDictCodeConst.SD_CODE_ENTP_OP;
		}
		if(!EnValidator.isEmpty(erPreId)){
			ErPreEP ep = new ErPreEP();
			EnErPreDO erPreDo = ep.findById(erPreId);
			if(erPreDo != null){
				if(IEnDictCodeConst.SD_TRIAGETO_ERSTAY.equals(erPreDo.getSd_triage_to())){
					//暂时预约留观的走流水流程，开留观许可证
					code = IBdFcDictCodeConst.SD_CODE_ENTP_ET_FLOW;
				}
				else if(IEnDictCodeConst.SD_TRIAGETO_ERRESCUE.equals(erPreDo.getSd_triage_to())){
					code = IBdFcDictCodeConst.SD_CODE_ENTP_ET_FSTAID;
				}else{
					code = IBdFcDictCodeConst.SD_CODE_ENTP_ET_FLOW;
				}
			}
		}
		return code;
	}
	/**
	 * 获取就诊类型do
	 * 
	 * @param code
	 * @return
	 * @throws BizException
	 */
	private EnTypeDO getEnTpDo(String code) throws BizException {
		if(!EnValidator.isEmpty(code)){
			IEntpRService serv = ServiceFinder.find(IEntpRService.class);
			EnTypeDO[] dos = serv.findByAttrValString(EnTypeDO.CODE, code);
			if(!EnValidator.isEmpty(dos)){
				return dos[0];
			}
		}
		throw new BizException("获取就诊类型失败！");
	}
}
