package iih.en.er.bp.inouttransmgr;

import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeTypeConst;
import iih.bd.bc.udi.pub.IPiDictCodeTypeConst;
import iih.en.comm.ep.ErPreEP;
import iih.en.comm.util.DateTimeUtils;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnFMapUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.er.dto.d.EuUrgInOutTransStatus;
import iih.en.er.dto.d.UrgInOutTransMgrDTO;

import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.util.AgeCalcUtil;
import xap.sys.xbd.udi.d.UdidocDO;
import xap.sys.xbd.udi.i.IUdidocServiceExt;

/**
 * UrgInOutTransMgrDTO处理
 * 
 * @author liubin
 *
 */
public class HandleUrgInOutTransMgrsBP {
	/**
	 * 结果数据处理
	 * 
	 * @param datas
	 * @throws BizException
	 */
	public void exec(UrgInOutTransMgrDTO[] datas) throws BizException{
		if(EnValidator.isEmpty(datas))
			return;
		ErPreEP erPreEP = new ErPreEP();
		erPreEP.setErScoleName(datas, "Sd_scale_triage", "Name_scale_triage");
		erPreEP.setGreenNames(datas, "Ids_green_channel_sym", "Names_green_channel_sym");
		Map<String, UdidocDO> udiMap = getUdiMap(new String[] {
				IPiDictCodeTypeConst.SD_SEX_CODE,
				IEnDictCodeTypeConst.SD_STATUS_NUR,
				IEnDictCodeTypeConst.SD_IP_GOWHERE,
				IEnDictCodeTypeConst.SD_ERPRE_TRIAGETO });
		for(UrgInOutTransMgrDTO data : datas){
			//处理性别
			if(!EnValidator.isEmpty(data.getId_sex())){
				if(udiMap != null && udiMap.containsKey(data.getId_sex())){
					UdidocDO sex = udiMap.get(data.getId_sex());
					data.setSd_sex(sex.getCode());
					data.setName_sex(sex.getName());
				}
			}
			//处理护理等级
			if(!EnValidator.isEmpty(data.getId_level_nur())){
				if(udiMap != null && udiMap.containsKey(data.getId_level_nur())){
					UdidocDO levelNur = udiMap.get(data.getId_level_nur());
					data.setSd_level_nur(levelNur.getCode());
					data.setName_level_nur(levelNur.getName());
				}
			}
			//处理转归
			if(!EnValidator.isEmpty(data.getId_gowhere())){
				if(udiMap != null && udiMap.containsKey(data.getId_gowhere())){
					UdidocDO goWhere = udiMap.get(data.getId_gowhere());
					data.setSd_gowhere(goWhere.getCode());
					data.setName_gowhere(goWhere.getName());
				}
			}
			//处理转归
			if(!EnValidator.isEmpty(data.getId_triage_to())){
				if(udiMap != null && udiMap.containsKey(data.getId_triage_to())){
					UdidocDO triageTo = udiMap.get(data.getId_triage_to());
					data.setSd_triage_to(triageTo.getCode());
					data.setName_triage_to(triageTo.getName());
				}
			}
			//年龄
			data.setAge(AgeCalcUtil.getAge(data.getDt_birth_hms()));
			//设置状态
			setEuUrgInOutTransStatus(data);
			//设置滞留时长
			setRetentionTime(data);
		}
	}
	/**
	 * 获取自定义档案Map
	 * 
	 * @param udiTps
	 * @return
	 * @throws BizException
	 */
	private Map<String, UdidocDO> getUdiMap(String[] udiTps) throws BizException {
		IUdidocServiceExt serv = ServiceFinder.find(IUdidocServiceExt.class);
		UdidocDO[] udis = serv.findByUdidoclistCodes(EnAppUtils.objArray2List(udiTps));
		return EnFMapUtils.getMap(UdidocDO.ID_UDIDOC, udis);
	}
	/**
	 * 设置状态
	 * 
	 * @param data
	 * @throws BizException
	 */
	private void setEuUrgInOutTransStatus(UrgInOutTransMgrDTO data) throws BizException {
		if(data == null)
			return;
		if(IEnDictCodeConst.SD_STATUS_ERPRE_END.equals(data.getSd_status_erpre())){
			data.setEu_urginouttransstatus(EuUrgInOutTransStatus.OUTDEP);
		}else{
			if(EnValidator.isEmpty(data.getId_bed())){
				data.setEu_urginouttransstatus(EuUrgInOutTransStatus.UNENTRY);
			}else{
				data.setEu_urginouttransstatus(EuUrgInOutTransStatus.INDEP);
			}
		}
	}
	/**
	 * 设置滞留时长
	 * 
	 * @param data
	 * @throws BizException
	 */
	private void setRetentionTime(UrgInOutTransMgrDTO data) throws BizException{
		switch (data.getEu_urginouttransstatus()) {
		case EuUrgInOutTransStatus.UNENTRY:
		case EuUrgInOutTransStatus.INDEP:
			data.setTimes_retention(DateTimeUtils.getTimeLength(data.getDt_entry(), EnAppUtils.getServerDateTime()));
			break;
		case EuUrgInOutTransStatus.OUTDEP:
			data.setTimes_retention(DateTimeUtils.getTimeLength(data.getDt_entry(), data.getDt_end()));
			break;
		default:
			break;
		}
	}
}
