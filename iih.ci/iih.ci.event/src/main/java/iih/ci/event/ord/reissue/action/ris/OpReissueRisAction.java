package iih.ci.event.ord.reissue.action.ris;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.base.utils.StringUtils;
import iih.ci.event.ord.reissue.action.ris.pathy.IpReissuePathyBP;
import iih.ci.event.ord.reissue.action.ris.pathy.OpReissuePathyBP;
import iih.ci.event.ord.reissue.common.ReissueCommonAction;
import iih.ci.event.ord.reissue.common.ReissueCommonBP;
import iih.ci.event.ord.utils.OrdEventUtil;
import iih.ci.event.reissue.d.IEMsgReissueDTO;
import iih.ci.event.reissue.d.IEMsgReissueItmDTO;
import iih.ci.event.reissue.d.IEMsgReissueRstDTO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.iemsg.d.IEOpPathApplyDTO;
import iih.ci.ord.iemsg.d.IEOpPathEntDTO;
import iih.ci.ord.iemsg.d.IEOpPathOrdDTO;
import iih.ci.ord.iemsg.d.IEOpRisOrDTO;
import iih.ci.ord.iemsg.d.IEOpRisOrEnDTO;
import xap.ip.mapping.MappingService;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList2;
import xap.mw.sf.core.util.ServiceFinder;
/**
 * 消息补发，检查组装数据
 * @author zhangwq
 *
 */
public class OpReissueRisAction extends ReissueRisCommonAction {

	@Override
	protected IEMsgReissueRstDTO assembleData(List<BaseDTO> dtos) throws BizException {
		MappingService mappingService = ServiceFinder.find(MappingService.class);
		if(dtos != null && dtos.size() > 0){
			List<IEMsgReissueItmDTO> itms = new ArrayList<IEMsgReissueItmDTO>();
			for (BaseDTO baseDTO : dtos) {
				if(baseDTO instanceof IEOpPathEntDTO){
					IEOpPathEntDTO iEOpPathEntDTO = (IEOpPathEntDTO)baseDTO;
					iEOpPathEntDTO.setResptype(OrdEventUtil.REPLACE);
					IEOpPathApplyDTO applyDTO=(IEOpPathApplyDTO) (iEOpPathEntDTO.getId_applylists()).get(0);
					IEOpPathOrdDTO ordDTO = null;
					if(!OrdEventUtil.isEmpty(applyDTO.getId_orlists())) {
						ordDTO=(IEOpPathOrdDTO) (applyDTO.getId_orlists()).get(0);
					}
					FArrayList2 fl = new FArrayList2();
					fl.add(iEOpPathEntDTO);
					String xmlItms;
					try {
						xmlItms = new String(mappingService.message2XmlBytes("BS452", "01",fl ),"utf-8");
					} catch (UnsupportedEncodingException e) {
						throw new BizException(e.getMessage());
					}
					//1:医疗机构编码;2:服务ID;3:就诊类型编码;4:申请科室编码;5:执行科室编码;6:发送系统ID;7:医嘱执行分类编码;8:拓展码
					String head = iEOpPathEntDTO.getOrgcode()
							+":"+this.iEMsgReissueDTO.getServiceid()
							+":"+this.iEMsgReissueDTO.getVisittypecode()
							+":"+iEOpPathEntDTO.getOrderdept()
							+":"+applyDTO.getExecutivedept()
							+":IIH"
							+":"+(ordDTO!=null?(StringUtils.isNotEmpty(ordDTO.getIemsgca_code())?ordDTO.getIemsgca_code():"0"):"")
							+":0";
					IEMsgReissueItmDTO itm = new IEMsgReissueItmDTO();
					itm.setHead(head);
					itm.setBody(xmlItms);
					itms.add(itm);
				}else if(baseDTO instanceof IEOpRisOrEnDTO){
					IEOpRisOrEnDTO iEOpRisOrEnDTO=(IEOpRisOrEnDTO) baseDTO;
					iEOpRisOrEnDTO.setResptype(OrdEventUtil.REPLACE);
					FArrayList2 fl = new FArrayList2();
					fl.add(iEOpRisOrEnDTO);
					String xmlItms;
					try {
						xmlItms = new String(mappingService.message2XmlBytes("BS002", "01",fl ),"utf-8");
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
						throw new BizException(e.getMessage());
					}
					IEOpRisOrDTO ierisordto=(IEOpRisOrDTO) (iEOpRisOrEnDTO.getIerisors()).get(0);
					//1:医疗机构编码;2:服务ID;3:就诊类型编码;4:申请科室编码;5:执行科室编码;6:发送系统ID;7:医嘱执行分类编码;8:拓展码
					String head = iEMsgReissueDTO.getHospitalcode()
							+":"+this.iEMsgReissueDTO.getServiceid()
							+":"+this.iEMsgReissueDTO.getVisittypecode()
							+":"+iEOpRisOrEnDTO.getApply_unit()
							+":"+ierisordto.getSqd_deptcode()
							+":IIH"
							+":"+(StringUtils.isNotEmpty(ierisordto.getIemsgca_code())?ierisordto.getIemsgca_code():"0")
							+":0";
					IEMsgReissueItmDTO itm = new IEMsgReissueItmDTO();
					itm.setHead(head);
					itm.setBody(xmlItms);
					itms.add(itm);
				}
			}
			IEMsgReissueRstDTO rst = new IEMsgReissueRstDTO();
			rst.setCode("0");
			rst.setResult("发送成功");
			rst.setReissueItms(itms);
			return rst;
		}
		return null;
	}
}
