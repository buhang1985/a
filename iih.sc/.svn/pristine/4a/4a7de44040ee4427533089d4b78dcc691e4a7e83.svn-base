package iih.sc.apt.s.bp.ip;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.res.bed.d.Bdbed;
import iih.bd.res.bed.i.IBedMDOCudService;
import iih.bd.res.bed.i.IBedMDORService;
import iih.sc.apt.aptip.d.AptIpDO;
import iih.sc.apt.aptip.d.AptIpMatchDO;
import iih.sc.apt.aptip.d.desc.AptIpMatchDODesc;
import iih.sc.apt.aptip.i.IAptipMDOCudService;
import iih.sc.apt.aptip.i.IAptipMDORService;
import iih.sc.apt.aptip.i.IAptipmatchRService;
import iih.sc.apt.dto.d.AptIpDTO;
import iih.sc.apt.dto.d.EuStatus;
import iih.sc.comm.IScMsgConst;
import iih.sc.comm.ScAppUtils;
import iih.sc.comm.ScContextUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 批量预约床位
 * @author ccj
 *
 */
public class BatchAptBedBP {
	/**
	 * 批量预约床位
	 * @param aptDTOArray 住院预约DTO集合
	 * @throws BizException
	 */
	public void exec(AptIpDTO[] aptDTOArray) throws BizException{
		List<Object> list = new ArrayList<Object>(); //存放所有住院预约Id 和 修改后的住院预约do
		List<String> idBedList = new ArrayList<String>(); //存放所有的预约床位id
		Map<String, AptIpDTO> map = new HashMap<String, AptIpDTO>();  //一个住院预id 对应一个dto
		for (AptIpDTO aptIpDTO : aptDTOArray) {
			list.add(aptIpDTO.getId_scaptip());
			map.put(aptIpDTO.getId_scaptip(), aptIpDTO);
		}
		IAptipMDORService mdorService = ServiceFinder.find(IAptipMDORService.class);
		AptIpDO[] aptIpDOs = mdorService.findByIds(list.toArray(new String[list.size()]), FBoolean.TRUE);
		list.clear();
		for (AptIpDO aptIpDO : aptIpDOs) {
			AptIpDTO aptIpDTO = map.get(aptIpDO.getId_aptip());
			String id_bed = aptIpDTO.getId_bed(); //床位id
			aptIpDO.setDt_appt(ScAppUtils.getServerDateTime());  //匹配时间
			aptIpDO.setId_bed(id_bed);   
//			aptIpDO.setId_dep_nur_ip(aptIpDTO.getId_dep_belong());   //入院病区
			aptIpDO.setSd_status(EuStatus.ARRANG);
			aptIpDO.setStatus(DOStatus.UPDATED);
			list.add(aptIpDO);
			idBedList.add(id_bed);
		}
		// 查找所有匹配临时表中的记录 与住院预约改变记录做 比较
		IAptipmatchRService aptipmatchRService = ServiceFinder.find(IAptipmatchRService.class);
		AptIpMatchDO[] aptIpMatchDOs =  aptipmatchRService.find(AptIpMatchDODesc.TABLE_ALIAS_NAME+".code_session = '"+ScContextUtils.getPcId()+"'", "", FBoolean.TRUE);
		if(list.size() != aptIpMatchDOs.length)
			// 匹配出的预约和存在临时表中的记录数不相等 
			throw new BizException(IScMsgConst.SC_APT_IP_IS_MODIFIED);
		IAptipMDOCudService aptipMDOCudService = ServiceFinder.find(IAptipMDOCudService.class);
		aptipMDOCudService.save(list.toArray(new AptIpDO[list.size()]));
		IBedMDORService bedMDORService = ServiceFinder.find(IBedMDORService.class);
		Bdbed[] bdbeds =  bedMDORService.findByIds(idBedList.toArray(new String[idBedList.size()]), FBoolean.TRUE);
		if(list.size() != bdbeds.length)
			// 匹配出的预约和存在临时表中的记录数不相等
			throw new BizException(IScMsgConst.SC_APT_IP_IS_MODIFIED);
		for (Bdbed bdbed : bdbeds) {
			bdbed.setFg_appt(FBoolean.TRUE); //床位预约状态
			bdbed.setStatus(DOStatus.UPDATED);
		}
		IBedMDOCudService bedMDOCudService = ServiceFinder.find(IBedMDOCudService.class);
		bedMDOCudService.save(bdbeds);
	}
}
