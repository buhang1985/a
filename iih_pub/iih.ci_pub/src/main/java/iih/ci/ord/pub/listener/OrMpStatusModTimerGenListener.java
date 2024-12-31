package iih.ci.ord.pub.listener;

import org.apache.commons.lang3.StringUtils;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.cior.d.CiOrderTypeEnum;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.pub.CiOrPubUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.xbd.measdoc.d.MeasDocDO;
import xap.sys.xbd.measdoc.i.IMeasdocRService;

/**
 * 医嘱执行完成状态更新定时器生成侦听器
 * （停止核对时部署激活执行完成状态定时器）
 */
public class OrMpStatusModTimerGenListener extends AbstractOrStopCheckListener {
	@Override
	protected void doYourActionAfterOrStopCheck(CiOrderDO[] ors) throws BizException {
		//在此处增加你的代码实现
		
		

	}
	
	@Override
	protected boolean isSpecificOrder(CiOrderDO or) {
		//空判断 
				if(or==null)return false;
					String ortp=or.getSd_srvtp();
				if(StringUtils.isBlank(ortp))return false;
//				//是否为符合的服务类型,08嘱托类全部，0601分级护理,0602治疗性护理,0603生命体征,0503吸氧,0505营养膳食
//				if (ortp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_ENTRUST)
//						||ortp.equals(IBdSrvDictCodeConst.SD_SRVTP_NURSE_VS)
//						||ortp.equals(IBdSrvDictCodeConst.SD_SRVTP_NURSE_TREATNS)
//						||CiOrderTypeEnum.NUTRIONDIETORDER.equals(CiOrPubUtils.getCiOrderType(or))
//						||CiOrderTypeEnum.NSGRADEORDER.equals(CiOrPubUtils.getCiOrderType(or))
//						||ortp.equals(IBdSrvDictCodeConst.SD_SRVTP_TREAT_XIYANG))
//					return true;
//				return false;
				//持续非药品剂量单位是时间的医嘱都要在确认时变成执行中
				if(!ortp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_DRUG)
						&&or.getId_freq().equals(IBdSrvDictCodeConst.ID_FREQNUNITCT_ITEM_ALWAYS)
						&&this.isTimeMeasdoc(or.getId_unit_med())){
					return true;
				}
				return false;
	}
	/**
	 * 判断剂量单位是否为时间量纲
	 * @param id_measdoc
	 * @return
	 */
	private boolean isTimeMeasdoc(String id_measdoc){
		if(StringUtils.isBlank(id_measdoc))
		{
			return false;
		}
		if(id_measdoc.equals(ICiDictCodeConst.ID_MEASDOC_TIME_DD)||id_measdoc.equals(ICiDictCodeConst.ID_MEASDOC_TIME_HH)
				||id_measdoc.equals(ICiDictCodeConst.ID_MEASDOC_TIME_MM)
				||id_measdoc.equals(ICiDictCodeConst.ID_MEASDOC_TIME_SS)
				||id_measdoc.equals(ICiDictCodeConst.ID_MEASDOC_TIME_μS)
				||id_measdoc.equals(ICiDictCodeConst.ID_MEASDOC_TIME_MS)
				||id_measdoc.equals(ICiDictCodeConst.ID_MEASDOC_TIME_NS)){
			return true;
		}else {
			IMeasdocRService service = ServiceFinder.find(IMeasdocRService.class);
			try {
				MeasDocDO measDoc = service.findById(id_measdoc);
				if(measDoc!=null){
					if(measDoc.getId_oppdimen().equals(ICiDictCodeConst.DIMENSION_OF_TIME)){
						return true;
					}
				}
			} catch (BizException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
}
