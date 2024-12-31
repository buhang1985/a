package iih.bl.st.ip.s.bp;

import org.apache.commons.lang.StringUtils;
import iih.ci.mrfp.cmis.d.CiMrFpMsgDTO;
import iih.ci.mrfp.cmis.i.ICMISService;
import iih.en.pv.hpdto.d.IpHpRegistDTO;
import iih.en.pv.i.IEnOutQryService;
import iih.mi.biz.dto.d.MedicaluploadDTO;
import iih.mi.biz.dto.d.MedicaluploadTcmDTO;
import iih.mi.itf.bizgrpitf.param.ResultOutParamDTO;
import iih.mi.itf.context.InsureContext;
import iih.mi.itf.facade.InsureFacade;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 上传病案信息
 * @author yangyang
 *
 */
public class UploadMedicalDataBp {

	public void exec(String strIdEnt,FBoolean fg_xy) throws BizException
	{
		//1、校验参数
		if(!StringUtils.isNotEmpty(strIdEnt))
		{
			throw new BizException("病历上传业务，传入的就诊号为空!");
		}
		//2、获取到当前的就诊信息
		IEnOutQryService entOutQryService=ServiceFinder.find(IEnOutQryService.class);
		IpHpRegistDTO ipHpRegisterDto=entOutQryService.getIpHpRegist(strIdEnt);
		if(ipHpRegisterDto==null)
			throw new BizException("该患者不是医保患者!");
		//3、获取his病历信息
		ICMISService cMisService=ServiceFinder.find(ICMISService.class);
		CiMrFpMsgDTO mrDto=cMisService.getCimrfpdtoAggDTO(strIdEnt);
		ResultOutParamDTO<String> resultInfo=null;
		
		InsureContext context=new InsureContext();
		context.setIdHp(ipHpRegisterDto.getId_hp());
		//测试医保，BD_HP, {"ID":""1001BZ1000000006WYYU"", "NAME":"河南新农合"}, nielisheng, 2018-05-27
		//context.setIdHp("1001BZ1000000006WYYU");
		InsureFacade facade=new InsureFacade(context);

		if(fg_xy.booleanValue())
		{
			//病历信息转化-普通（西医）,
			AbstractMedicalDataProcess process=new XUrbanMedicalDataProcess();
			MedicaluploadDTO medicalDto=process.process(mrDto);
			//上传西医病历
			resultInfo=facade.uploadMedicalupload(medicalDto);
		}else{
			//病历信息转化-中医,
			AbstractMedicalDataProcess process=new XUrbanMedicalTcmDataProcess();
			MedicaluploadTcmDTO medicalTcmDto=process.process(mrDto);
			resultInfo=facade.uploadMedicaluploadTcm(medicalTcmDto);
		}
		
		if(!resultInfo.getFg_HpSuccess().booleanValue())//如果交易成功
		{
			throw new BizException("上传病案信息失败，错误信息为："+resultInfo.getErrorMsg());
		}
	}
}
