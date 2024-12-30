package iih.sc.apt.s.bp.mt.apt;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.sc.apt.dto.d.MtAppQryDTO;
import iih.sc.apt.dto.d.MtResDTO;
import iih.sc.sch.i.IScSchOutQryService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 计算排班对应渠道剩余可预约数量BP
 * 
 * @author zhengcm
 * @date 2018-04-26 14:11:47
 *
 */
public class CalcSchChlRemainNewBP {

	/**
	 * 计算排班对应渠道剩余可预约数量
	 * 
	 * @author zhengcm
	 *
	 * @param resDTOList
	 * @throws BizException
	 */
	public void exec(List<MtResDTO> resDTOList,MtAppQryDTO qryDTO) throws BizException {
		if (ListUtil.isEmpty(resDTOList)) {
			return;
		}
		String id_scchl = resDTOList.get(0).getId_scchl();
		List<String> schIdList = new ArrayList<String>();
		for (MtResDTO resDTO : resDTOList) {
			String schId = resDTO.getId_sch();
			if (!schIdList.contains(schId)) {
				schIdList.add(schId);
			}
		}
		//String idEnttp = this.getEnttp(qryDTO);
		IScSchOutQryService schOutQryService = ServiceFinder.find(IScSchOutQryService.class);
		//Map<String,Map<Integer, Integer>> map = schOutQryService.batchGetChlSchRemainFilterEntpAmount(schIdList,idEnttp,id_scchl);
		Map<String,Map<Integer, Integer>> map = schOutQryService.batchGetChlSchRemainAmount(schIdList, id_scchl);
		if (null == map || map.isEmpty()) {
			return;
		}
		for (MtResDTO resDTO : resDTOList) {
			String key = resDTO.getId_sch();
			if (!map.containsKey(key) || null == map.get(key)) {
				continue;
			}
			resDTO.setQuan_remain(map.get(key).get(IScDictCodeConst.SC_CHL_REMAIN));
		}
	}
	/***
	 * 
	 * @param qryDTO
	 * @return
	 */
	private String getEnttp(MtAppQryDTO qryDTO){
		FBoolean fg_ip = qryDTO.getFg_ip()==null?FBoolean.FALSE:qryDTO.getFg_ip();//住院
		FBoolean fg_op = qryDTO.getFg_op()==null?FBoolean.FALSE:qryDTO.getFg_op();//门诊
		FBoolean fg_et = qryDTO.getFg_et()==null?FBoolean.FALSE:qryDTO.getFg_et();//急诊
		String idEnttp = null;
		if (fg_ip.booleanValue()) {
			idEnttp = IBdFcDictCodeConst.ID_CODE_ENTP_IP;
		}
		if (fg_op.booleanValue()) {
			idEnttp = IBdFcDictCodeConst.ID_CODE_ENTP_OP;
		}
		if (fg_et.booleanValue()) {
			idEnttp = IBdFcDictCodeConst.ID_CODE_ENTP_ET;
		}
		return idEnttp;
	}
}
