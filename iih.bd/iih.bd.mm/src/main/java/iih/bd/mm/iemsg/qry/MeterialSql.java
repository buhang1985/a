package iih.bd.mm.iemsg.qry;

import java.util.ArrayList;

import iih.bd.bc.udi.pub.IBdMmDictCodeConst;
import iih.bd.mm.iemsg.d.MeterialDTO;
import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvDrugDO;
import iih.bd.srv.medsrv.i.IMedSrvDrugDORService;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.IEventType;

public class MeterialSql {

	public MeterialDTO[] setByStatu(MeterialDO[] newObjs, String eventtype) throws BizException {

		ArrayList<MeterialDTO> rtn = new ArrayList<MeterialDTO>();

		// 遍历
		for (MeterialDO mmdo : newObjs) {

			// 给DTO赋值
			MeterialDTO mmDTO = new MeterialDTO();
			mmDTO.setId_mm(mmdo.getId_mm());
			mmDTO.setMm_code(mmdo.getCode());
			mmDTO.setMm_name(mmdo.getName());
			mmDTO.setId_unit_pkgsp(mmdo.getId_unit_pkgsp());
			mmDTO.setName_unit_pkgsp(mmdo.getName_unit_pkgsp());
			// 获取药品剂型
			if (!(mmdo.getSd_mmtp().startsWith(IBdMmDictCodeConst.SD_MMTP_WEISHENG) || mmdo.getSd_mmtp().startsWith(IBdMmDictCodeConst.SD_MMTP_QIXIE))) {

				MedSrvDrugDO medDrugDO = getmedSrvDo(mmdo);
				if (medDrugDO != null) {
					mmDTO.setId_dosage(medDrugDO.getId_dosage());
					mmDTO.setName_dosage(medDrugDO.getDs_name());
					mmDTO.setFg_pois(medDrugDO.getFg_pois());
				}
			}
			mmDTO.setFactor_wb(mmdo.getFactor_wb());
			mmDTO.setId_unit_weight(mmdo.getId_unit_weight());
			mmDTO.setName_unit_weight(mmdo.getWeight_name());
			mmDTO.setFactor_vb(mmdo.getFactor_vb());
			mmDTO.setId_unit_volbase(mmdo.getId_unit_volbase());
			mmDTO.setName_unit_volbase(mmdo.getVolbase_name());
			mmDTO.setId_unit_pkgbase(mmdo.getId_unit_pkgbase());
			mmDTO.setName_unit_pkgbase(mmdo.getName_unit_pkgbase());
			mmDTO.setFactor_sb(mmdo.getFactor_sb());
			mmDTO.setSpec(mmdo.getSpec());
			mmDTO.setPrice(mmdo.getPrice());
			mmDTO.setId_sup(mmdo.getId_sup());
			mmDTO.setName_sup(mmdo.getSup_name());
			mmDTO.setSd_val(mmdo.getSd_val());
			mmDTO.setName_val(mmdo.getVal_name());
			mmDTO.setPycode(mmdo.getPycode());
			mmDTO.setSd_abrd(mmdo.getSd_abrd());
			mmDTO.setName_abrd(mmdo.getAbrd_name());
			mmDTO.setUdi_code(mmdo.getId_mmtp());
			mmDTO.setName_udi(mmdo.getMmtp_name());
			mmDTO.setMmca_code(mmdo.getMmca_code());
			mmDTO.setName_mmca(mmdo.getMmca_name());
			// 获取药品服务
			MedSrvDO medSrvDO = getSrvDo(mmdo);
			if (medSrvDO != null) {
				mmDTO.setId_route(medSrvDO.getId_route());
				mmDTO.setName_route(medSrvDO.getRoute_name());
				mmDTO.setCode_route(medSrvDO.getRoute_code());
				mmDTO.setId_freq(medSrvDO.getId_freq());
				mmDTO.setName_freq(medSrvDO.getFreq_name());
				mmDTO.setCode_freq(medSrvDO.getFreq_code());
				mmDTO.setQuan_med(medSrvDO.getQuan_med());
				mmDTO.setId_unit_med(medSrvDO.getId_unit_med());
				mmDTO.setName_unit_med(medSrvDO.getMed_name());
			}

			if (IEventType.TYPE_UPDATE_AFTER.equals(eventtype)) {
				mmDTO.setMessagetype("update");
			} else if (IEventType.TYPE_INSERT_AFTER.equals(eventtype)) {

				mmDTO.setMessagetype("insert");
			} else if (IEventType.TYPE_DELETE_AFTER.equals(eventtype)) {

				mmDTO.setMessagetype("delete");
			} else if ("190711".equals(eventtype)) {
				mmDTO.setMessagetype("update");
			} else if ("190712".equals(eventtype)) {
				mmDTO.setMessagetype("insert");
			} else if ("190713".equals(eventtype)) {

				mmDTO.setMessagetype("delete");
			} else {
				continue;
			}
			// 加入列表中
			rtn.add(mmDTO);
		}

		return rtn.toArray(new MeterialDTO[0]);
	}

	private MedSrvDO getSrvDo(MeterialDO mmdo) throws BizException {
		IMedsrvMDORService iMedsrvMDORService = ServiceFinder.find(IMedsrvMDORService.class);
		MedSrvDO medSrvDO = iMedsrvMDORService.findById(mmdo.getId_srv());
		return medSrvDO;
	}

	private MedSrvDrugDO getmedSrvDo(MeterialDO mmdo) throws BizException {

		IMedSrvDrugDORService iMedSrvDrugDORService = ServiceFinder.find(IMedSrvDrugDORService.class);
		MedSrvDrugDO[] medSrvDrugDOList = iMedSrvDrugDORService.find("a5.id_srv = '" + mmdo.getId_srv() + "' ", "",
				new FBoolean(false));
		if (medSrvDrugDOList == null || medSrvDrugDOList.length <= 0) {
			throw new BizException("该服务没有维护药品属性");
		}
		return medSrvDrugDOList[0];
	}

}
