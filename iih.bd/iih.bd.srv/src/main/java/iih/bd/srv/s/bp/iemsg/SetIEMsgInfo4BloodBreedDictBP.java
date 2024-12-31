package iih.bd.srv.s.bp.iemsg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import iih.bd.bc.event.pub.IBdSrvIEEventConst;
import iih.bd.srv.iemsg.d.IEbloodBreedDicDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.xbd.udi.d.UdidocDO;
import xap.sys.xbd.udi.i.IUdidocCudService;
import xap.sys.xbd.udi.i.IUdidocRService;

/**
 * 输血品种字典
 * 
 * @author YANG
 *
 */
public class SetIEMsgInfo4BloodBreedDictBP {

	public void exec(IEbloodBreedDicDTO[] dtos) throws BizException {
		if (dtos == null || dtos.length <= 0)
			return;
		ArrayList<UdidocDO> udiDOs = new ArrayList<UdidocDO>();
		Map<String, IEbloodBreedDicDTO> mapIEbloodBreedDicDTOs = new HashMap<String, IEbloodBreedDicDTO>();
		String strCodeUpdate = "";
		String strCodeDelete = "";
		for (IEbloodBreedDicDTO dto : dtos) {
			UdidocDO udiDO = new UdidocDO();
			switch (dto.getAction()) {
			case IBdSrvIEEventConst.ACTION_INSERT:
				execInsert(udiDO, dto);
				break;
			case IBdSrvIEEventConst.ACTION_UPDATE:
				strCodeUpdate += "'" + dto.getCode() + "',";
				mapIEbloodBreedDicDTOs.put(dto.getCode(), dto);
				break;
			case IBdSrvIEEventConst.ACTION_DELETE:
				strCodeDelete += "'" + dto.getCode() + "',";
				break;
			}
			udiDOs.add(udiDO);
		}
		UdidocDO[] udiDOsUpdate = getUdidocDOs(strCodeUpdate);
		UdidocDO[] udiDOsDelete = getUdidocDOs(strCodeDelete);
		if (udiDOsUpdate != null && udiDOsUpdate.length > 0) {
			execUpdate(mapIEbloodBreedDicDTOs,udiDOsUpdate,udiDOs);
		}
		if (udiDOsDelete != null && udiDOsDelete.length > 0) {
			for (UdidocDO udi : udiDOsDelete) {
				udi.setStatus(3);
				udiDOs.add(udi);
			}
		}

		if (udiDOs.size() > 0) {
			IUdidocCudService service = ServiceFinder.find(IUdidocCudService.class);
			service.save(udiDOs.toArray(new UdidocDO[udiDOs.size()]));
		}
	}

	private void execInsert(UdidocDO udiDO, IEbloodBreedDicDTO dto) {
		udiDO.setId_udidoclist("0001ZZ20000000000066");
		udiDO.setId_group("");
		udiDO.setId_org("");
		udiDO.setCode(dto.getCode());
		udiDO.setName(dto.getName());
		udiDO.setShortname(dto.getName());
		udiDO.setMnecode(dto.getCode());
		udiDO.setPycode(dto.getPycode());
		udiDO.setWbcode("");
		udiDO.setActivestate(2);
		udiDO.setFg_sys(FBoolean.TRUE);
		udiDO.setStatus(2);
	}

	private void execUpdate(Map<String, IEbloodBreedDicDTO> mapIEbloodBreedDicDTOs,UdidocDO[] udiDOsUpdate,ArrayList<UdidocDO> udiDOs){
		for(UdidocDO udiDO:udiDOsUpdate){
			udiDO.setName(mapIEbloodBreedDicDTOs.get(udiDO.getCode()).getName());
			udiDO.setShortname(mapIEbloodBreedDicDTOs.get(udiDO.getCode()).getName());
			udiDO.setPycode(mapIEbloodBreedDicDTOs.get(udiDO.getCode()).getPycode());
			udiDO.setWbcode("");
			udiDO.setStatus(1);
			udiDOs.add(udiDO);
		}
	}
	
	private UdidocDO[] getUdidocDOs(String sqlQry) throws BizException {
		if (sqlQry.length() < 1)
			return null;
		IUdidocRService service = ServiceFinder.find(IUdidocRService.class);
		return service.find(" code in (" + sqlQry.substring(0, sqlQry.length() - 1) + ")", "", FBoolean.FALSE);
	}
}
