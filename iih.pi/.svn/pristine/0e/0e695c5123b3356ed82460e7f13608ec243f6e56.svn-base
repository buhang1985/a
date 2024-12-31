package iih.pi.reg.pat.s.bp;

import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.en.pv.dto.d.SysPatDTO;
import iih.en.pv.i.IEnOutCmdService;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PatiAddrDO;
import iih.pi.reg.pat.d.PatiAggDO;
import iih.pi.reg.pat.i.IPatiAddrDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 修改患者数据时，同步就诊域数据
 * @author ly
 *
 */
public class PiPatSyncEnDataBP {

	/**
	 * 同步就诊域数据
	 * @param agg
	 * @throws BizException
	 */
	public void exec(PatiAggDO agg) throws BizException {
		
		//验证是否需要同步
		PatDO patDo = agg.getParentDO();
		if(!FBoolean.TRUE.equals(patDo.getFg_sync_en()))
			return;
		
		IEnOutCmdService enService = ServiceFinder.find(IEnOutCmdService.class);
		SysPatDTO patDto = new SysPatDTO();
		PatiAddrDO[] addrs = agg.getPatiAddrDO();
		//设置患者关键信息
		this.SetPatData(patDto, patDo);
		
		if(!ArrayUtil.isEmpty(addrs)){
			for (PatiAddrDO patiAddrDO : addrs) {
				if(!IPiDictCodeConst.SD_ADDR_TYPE_NOW.equals(patiAddrDO.getSd_addrtp()))
					continue;
				
				patDto.setAddr(patiAddrDO.getStreet());
				patDto.setId_admin_addr(patiAddrDO.getId_admdiv());
				patDto.setSd_admin_addr(patiAddrDO.getSd_admdiv());
				break;
			}
		}
		
		try {
			enService.syncEnPatInfo(patDto);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 同步就诊域数据
	 * @param patDo
	 * @throws BizException
	 */
	public void exec(PatDO patDo) throws BizException {
		
		IEnOutCmdService enService = ServiceFinder.find(IEnOutCmdService.class);
		SysPatDTO patDto = new SysPatDTO();
		//设置患者关键信息
		this.SetPatData(patDto, patDo);
		
		//保存现住址   0164191: 病历入院记录的家庭地址不能自动提取过来
		IPatiAddrDORService iService = ServiceFinder.find(IPatiAddrDORService.class);
		String str = " sd_addrtp = '" + IPiDictCodeConst.SD_ADDR_TYPE_NOW + "' and id_pat = '" + patDo.getId_pat() +"' ";
		PatiAddrDO[] addrDOs = iService.find(str, "", FBoolean.FALSE);
		if(!ArrayUtil.isEmpty(addrDOs)){
			patDto.setAddr(addrDOs[0].getStreet());
			patDto.setId_admin_addr(addrDOs[0].getId_admdiv());
			patDto.setSd_admin_addr(addrDOs[0].getSd_admdiv());
		}
		
		try {
			enService.syncEnPatInfo(patDto);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 设置患者关键信息
	 * @param patDto
	 * @param patDo
	 */
	private void SetPatData(SysPatDTO patDto,PatDO patDo){
		//设置关键信息
		patDto.setId_pat(patDo.getId_pat());
		patDto.setName_pat(patDo.getName());
		patDto.setId_sex(patDo.getId_sex());
		patDto.setSd_sex(patDo.getSd_sex());
		patDto.setId_marry(patDo.getId_marry());
		patDto.setSd_marry(patDo.getSd_marry());
		patDto.setMob(patDo.getMob());
		patDto.setTel(patDo.getTel());
		patDto.setDt_birth_pat(patDo.getDt_birth());
	}
}
