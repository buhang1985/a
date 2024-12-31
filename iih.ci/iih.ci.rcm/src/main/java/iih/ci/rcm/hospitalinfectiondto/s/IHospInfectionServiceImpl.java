package iih.ci.rcm.hospitalinfectiondto.s;

import iih.bd.bc.udi.pub.ICiMrDictCodeTypeConst;
import iih.ci.rcm.hospitalinfectiondto.d.HospitalInfectionDTO;
import iih.ci.rcm.hospitalinfectiondto.i.IHospInfectionService;
import iih.ci.rcm.hospitalreport.d.HospitalReportDO;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

@Service(serviceInterfaces = { IHospInfectionService.class }, binding = Binding.JSONRPC)
public class IHospInfectionServiceImpl implements IHospInfectionService {

	public HospitalInfectionDTO[] getHospInfecDto(String id_ent)
			throws BizException {
		List<HospitalInfectionDTO> dtos = new ArrayList<HospitalInfectionDTO>();
		String sql = "select hos.id_hospitalreport as id_hospitalreport,"
				+ "hos.is_surgery as is_surgery,"
				+ "hos.is_etiol_examination as is_etiol_examination,"
				+ "hos.is_use_antibiotics as is_use_antibiotics,"
				+ "hos.name_stage as name_stage "
				+ "from ci_mr_hos_report hos where hos.id_ent = '" + id_ent
				+ "'";
		DAFacade daf = new DAFacade();
		@SuppressWarnings("unchecked")
		List<HospitalReportDO> listDtos = (List<HospitalReportDO>) daf
				.execQuery(sql, new BeanListHandler(HospitalReportDO.class));
		if (listDtos != null && listDtos.size() > 0) {
			for (HospitalReportDO hospreportdo : listDtos) {
				HospitalInfectionDTO hdto = new HospitalInfectionDTO();
				// 添加主卡信息
				hdto.setId_node(hospreportdo.getId_hospitalreport());
				hdto.setId_parent_node("");
				hdto.setIs_main_card(FBoolean.TRUE);
				hdto.setIs_vice_card(FBoolean.FALSE);
				hdto.setName(ICiMrDictCodeTypeConst.NAME_HOSPITALINFECTION_MAIN);
				hdto.setStyle(ICiMrDictCodeTypeConst.STYLE_HOSPITALINFECTION_MAIN);
				hdto.setReport_status(hospreportdo.getName_stage());
				dtos.add(hdto);

				// 添加附卡（感染部位）
				HospitalInfectionDTO cdto = new HospitalInfectionDTO();
				cdto.setId_node(hospreportdo.getId_hospitalreport()
						+ ICiMrDictCodeTypeConst.STYLE_HOSPITALINFECTION_CONSITE);
				cdto.setId_parent_node(hospreportdo.getId_hospitalreport());
				cdto.setName(ICiMrDictCodeTypeConst.NAME_HOSPITALINFECTION_CONSITE);
				cdto.setStyle(ICiMrDictCodeTypeConst.STYLE_HOSPITALINFECTION_CONSITE);
				cdto.setIs_main_card(FBoolean.FALSE);
				cdto.setIs_vice_card(FBoolean.TRUE);
				cdto.setReport_status(hospreportdo.getName_stage());
				dtos.add(cdto);

				// 添加附卡（手术切口）
				HospitalInfectionDTO odto = new HospitalInfectionDTO();
				if (hospreportdo.getIs_surgery() == FBoolean.TRUE) {
					odto.setId_node(hospreportdo.getId_hospitalreport()
							+ ICiMrDictCodeTypeConst.STYLE_HOSPITALINFECTION_OPERATE);
					odto.setId_parent_node(hospreportdo.getId_hospitalreport());
					odto.setName(ICiMrDictCodeTypeConst.NAME_HOSPITALINFECTION_OPERATE);
					odto.setStyle(ICiMrDictCodeTypeConst.STYLE_HOSPITALINFECTION_OPERATE);
					odto.setIs_main_card(FBoolean.FALSE);
					odto.setIs_vice_card(FBoolean.TRUE);
					odto.setReport_status(hospreportdo.getName_stage());
					dtos.add(odto);
				}
				// 添加附卡（药敏信息）
				HospitalInfectionDTO ddto = new HospitalInfectionDTO();
				if (hospreportdo.getIs_etiol_examination() == FBoolean.TRUE) {
					ddto.setId_node(hospreportdo.getId_hospitalreport()
							+ ICiMrDictCodeTypeConst.STYLE_HOSPITALINFECTION_DRUGAN);
					ddto.setId_parent_node(hospreportdo.getId_hospitalreport());
					ddto.setName(ICiMrDictCodeTypeConst.NAME_HOSPITALINFECTION_DRUGAN);
					ddto.setStyle(ICiMrDictCodeTypeConst.STYLE_HOSPITALINFECTION_DRUGAN);
					ddto.setIs_main_card(FBoolean.FALSE);
					ddto.setIs_vice_card(FBoolean.TRUE);
					ddto.setReport_status(hospreportdo.getName_stage());
					dtos.add(ddto);
				}
				// 添加附卡（抗菌用药）
				HospitalInfectionDTO adto = new HospitalInfectionDTO();
				if (hospreportdo.getIs_use_antibiotics() == FBoolean.TRUE) {
					adto.setId_node(hospreportdo.getId_hospitalreport()
							+ ICiMrDictCodeTypeConst.STYLE_HOSPITALINFECTION_ANTIBIOSIS);
					adto.setId_parent_node(hospreportdo.getId_hospitalreport());
					adto.setName(ICiMrDictCodeTypeConst.NAME_HOSPITALINFECTION_ANTIBIOSIS);
					adto.setStyle(ICiMrDictCodeTypeConst.STYLE_HOSPITALINFECTION_ANTIBIOSIS);
					adto.setIs_main_card(FBoolean.FALSE);
					adto.setIs_vice_card(FBoolean.TRUE);
					adto.setReport_status(hospreportdo.getName_stage());
					dtos.add(adto);
				}
			}
		}
		if (dtos != null && dtos.size() > 0) {
			return dtos.toArray(new HospitalInfectionDTO[0]);
		} else {
			return null;
		}

	}

}
