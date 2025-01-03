package iih.ci.event.ord.reissue.action.lis;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import iih.bd.base.utils.StringUtils;
import iih.ci.event.ord.bps.sign.op.listenerbp.OpLisSignStandardBP;
import iih.ci.event.ord.reissue.common.ReissueCommonBP;
import iih.ci.event.ord.utils.OrdEventLogger;
import iih.ci.event.ord.utils.OrdEventUtil;
import iih.ci.event.reissue.d.IEMsgReissueItmDTO;
import iih.ci.event.reissue.d.IEMsgReissueRstDTO;
import iih.ci.ord.iemsg.d.IEOpLisOrDTO;
import iih.ci.ord.iemsg.d.IEOpLisOrEnDTO;
import iih.ci.ord.iemsg.d.IEOpLisOrItmDTO;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList2;

public class OpReissueLisBP extends ReissueCommonBP{

	public OpReissueLisBP() {
		this.listener = new OpLisSignStandardBP();
	}

	@Override
	protected IEMsgReissueRstDTO assembleData(BaseDTO[] baseDTOs) throws BizException {
		// TODO Auto-generated method stub
		IEOpLisOrEnDTO[] ieOpLisOrEnDtos = (IEOpLisOrEnDTO[])baseDTOs;
		try {
			List<IEMsgReissueItmDTO> itms = new ArrayList<IEMsgReissueItmDTO>();
			for(IEOpLisOrEnDTO ieOpLisOrEnDTO : ieOpLisOrEnDtos){
				ieOpLisOrEnDTO.setResptype(OrdEventUtil.REPLACE);
				IEOpLisOrDTO ielisordto=(IEOpLisOrDTO) (ieOpLisOrEnDTO.getId_ielisors()).get(0);
				IEOpLisOrItmDTO ielisitemdto=(IEOpLisOrItmDTO) (ielisordto.getId_ielisoritms()).get(0);
				FArrayList2 fl = new FArrayList2();
				fl.add(ieOpLisOrEnDTO);
				String xmlItms = new String(mappingService.message2XmlBytes("BS006", "01",fl ),"utf-8");
				//1:医疗机构编码;2:服务ID;3:就诊类型编码;4:申请科室编码;5:执行科室编码;6:发送系统ID;7:医嘱执行分类编码;8:拓展码
				String head = ieOpLisOrEnDtos[0].getHospital_code()
						+":"+this.iEMsgReissueDTO.getServiceid()
						+":"+this.iEMsgReissueDTO.getVisittypecode()
						+":"+ieOpLisOrEnDtos[0].getApply_unit()
						+":"+ielisitemdto.getExec_code()
						+":IIH"
						+":"+(StringUtils.isNotEmpty(ielisordto.getIemsgca_code())?ielisordto.getIemsgca_code():"0")
						+":0";
				IEMsgReissueItmDTO itm = new IEMsgReissueItmDTO();
				itm.setHead(head);
				itm.setBody(xmlItms);
				itms.add(itm);
			}
			IEMsgReissueRstDTO rst = new IEMsgReissueRstDTO();
			rst.setCode("0");
			rst.setResult("发送成功");
			rst.setReissueItms(itms);
			return rst;
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			OrdEventLogger.info("", e.getMessage());
			return null;
		}
	}
	
}
