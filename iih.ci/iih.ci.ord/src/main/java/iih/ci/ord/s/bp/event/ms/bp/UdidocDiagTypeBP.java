package iih.ci.ord.s.bp.event.ms.bp;

import java.util.ArrayList;

import iih.ci.ord.ms.d.MSUdidocDiagTypeDTO;
import iih.ci.ord.pub.CiOrdUtils;
import xap.sys.xbd.udi.d.UdidocDO;

public class UdidocDiagTypeBP {

	/**
	 * 组装数据 根据事件类型编码
	 * @param udidocDOs
	 * @return
	 */
	public MSUdidocDiagTypeDTO[] assemableDatabyState(UdidocDO[] udidocDOs,String eventtype) {
		ArrayList<MSUdidocDiagTypeDTO> rtn=new ArrayList<MSUdidocDiagTypeDTO>();
		if(CiOrdUtils.isEmpty(udidocDOs)) {
			return null;
		}
		for(UdidocDO udidocDO: udidocDOs ){
			MSUdidocDiagTypeDTO msUdidocDiagTypeDTO = new MSUdidocDiagTypeDTO();
			msUdidocDiagTypeDTO.setId_udidoc(udidocDO.getId_udidoc());
			msUdidocDiagTypeDTO.setCode(udidocDO.getCode());
			msUdidocDiagTypeDTO.setName(udidocDO.getName());
			msUdidocDiagTypeDTO.setPy_code(udidocDO.getPycode());
			if(udidocDO.getActivestate()!=null) {
				msUdidocDiagTypeDTO.setStopflag(udidocDO.getActivestate().toString());	
			}
			msUdidocDiagTypeDTO.setAction(eventtype);
			rtn.add(msUdidocDiagTypeDTO);
		}
		return rtn.toArray(new MSUdidocDiagTypeDTO[0]);
	}
}
