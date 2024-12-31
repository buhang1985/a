package iih.pi.reg.pat.s.bp;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.handle.mapping.DORsReferMap;
import xap.sys.bdfw.bbd.d.AdminAreaDO;
import xap.sys.bdfw.bbd.d.desc.AdminAreaDODesc;
import xap.sys.bdfw.bbd.i.IAdminareaRService;
import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PatiAddrDO;
import iih.pi.reg.pat.d.PatiAggDO;

/**
 * 地址处理逻辑类
 * 新增患者时，如果输入身份证号，并且没有出入出生地址时，默认设置身份证对应的区县为出生地
 * @author ly
 *
 */
public class PiPatHandleAddressBP {

	/**
	 * 地址处理
	 * @param pat
	 * @throws BizException
	 */
	public void exec(PatiAggDO patAgg) throws BizException {
		
		if(patAgg == null)
			return;
		
		PatDO patDo = patAgg.getParentDO();
		PatiAddrDO[] addrDos = patAgg.getPatiAddrDO();
		List<PatiAddrDO> addrList = new ArrayList<PatiAddrDO>();
		
		//主身份标识不是身份证号时不处理
		if(!IPiDictCodeConst.SD_IDTP_IDENTITY.equals(patDo.getSd_idtp()) 
				|| StringUtil.isEmpty(patDo.getId_code()))
			return;
		
		int index = 1;
		if(!ArrayUtil.isEmpty(addrDos)){
			for (PatiAddrDO addr : addrDos) {
				
				//包含出生地址则不处理
				if(IPiDictCodeConst.SD_ADDR_TYPE_BORN.equals(addr.getSd_addrtp()))
					return;
				
				addrList.add(addr);
				index ++;
			}
		}
		if(patDo.getId_code()==null)
			return;
		//区县码
		String regionCode = patDo.getId_code().substring(0, 6);
		
		//取得区县码对应的行政区划数据
		IAdminareaRService areaService = ServiceFinder.find(IAdminareaRService.class);
		String whereSql = AdminAreaDODesc.TABLE_ALIAS_NAME + ".code = '" +regionCode+ "'";
		AdminAreaDO[] areas = areaService.find(whereSql, "", FBoolean.FALSE);
		
		//区县数据不存在返回
		if(ArrayUtil.isEmpty(areas))
			return;
		
		PatiAddrDO addr = new PatiAddrDO();
		addr.setId_addrtp(IPiDictCodeConst.ID_ADDR_TYPE_BORN);
		addr.setSd_addrtp(IPiDictCodeConst.SD_ADDR_TYPE_BORN);
		if(!ArrayUtil.isEmpty(areas)){
			//数据唯一
			addr.setId_admdiv(areas[0].getId_adminarea());
		}
		addr.setSd_admdiv(regionCode);
		addr.setStreet("");
		addr.setSortno(index);
		addr.setStatus(DOStatus.NEW);
		
		//取得关联数据
		PatiAddrDO[] addrs = new DORsReferMap<PatiAddrDO>(PatiAddrDO.class).convert(new PatiAddrDO[]{addr});
		addrList.add(addrs[0]);
		
		patAgg.setPatiAddrDO(addrList.toArray(new PatiAddrDO[addrList.size()]));
	}
}
