package iih.ci.ord.s.bp.event.ms.bp;

import java.util.ArrayList;

import iih.ci.ord.ms.d.MSUdidocPresTypeDTO;
import iih.ci.ord.pub.CiOrdUtils;
import xap.sys.xbd.udi.d.UdidocDO;

public class UdidocPresTypeBP {

	/**
	 * 组装数据 根据事件类型编码
	 * @param udidocDOs
	 * @return
	 */
	public MSUdidocPresTypeDTO[] assemableDatabyState(UdidocDO[] udidocDOs,String eventtype) {
		ArrayList<MSUdidocPresTypeDTO> rtn=new ArrayList<MSUdidocPresTypeDTO>();
		if(CiOrdUtils.isEmpty(udidocDOs)) {
			return null;
		}
		for(UdidocDO udidocDO: udidocDOs ){
			MSUdidocPresTypeDTO msUdidocDiagTypeDTO = new MSUdidocPresTypeDTO();
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
		return rtn.toArray(new MSUdidocPresTypeDTO[0]);
	}
}
