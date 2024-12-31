package iih.ci.mrm.s.outcommon;

import java.util.ArrayList;
import java.util.List;

import iih.bd.bc.udi.pub.ICiMrDictCodeConst;
import iih.bd.srv.emrtype.d.MrTpDO;
import iih.bd.srv.emrtype.i.IEmrtypeRService;
import iih.bd.srv.mrmtype.d.MrmTypeDO;
import iih.bd.srv.mrmtype.d.MrmTypeMrtpDO;
import iih.bd.srv.mrmtype.i.IMrmTypeMrtpDORService;
import iih.bd.srv.mrmtype.i.IMrmtypeMDORService;
import iih.ci.mr.ciamr.d.AMrDO;
import iih.ci.mr.ciamr.i.ICiamrRService;
import iih.ci.mrm.bp.common.CiMrMParamUtils;
import iih.ci.mrm.cimrmfiledto.d.CiMrmFileDTO;
import iih.ci.mrm.cimrmfileinfo.d.CiMrmFileInfoDO;
import iih.ci.mrm.cimrmfileinfo.i.ICimrmfileinfoCudService;
import iih.ci.mrm.cimrmfileinfo.i.ICimrmfileinfoRService;
import iih.ci.mrm.i.outcommon.IMrmOutCommonService;
import xap.mw.basic.storage.BusinessStorageService;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

@Service(serviceInterfaces = {IMrmOutCommonService.class }, binding = Binding.JSONRPC)
public class IMrmOutCommonServiceImpl implements IMrmOutCommonService{

	/**
	 * 添加臊面文件信息
	 * 
	 * @param id_ent
	 * @param id_busy
	 * @param id_set
	 * @param name
	 * @param code_file
	 * @param id_df
	 * @param sd_df
	 * @param isClear
	 * @return
	 * @throws BizException
	 */
	@Override
	public Boolean addMrmFileInfo(String id_ent, String id_busy,
			String id_set, String name, String code_file, String id_df,
			String sd_df, Boolean isClear, int sortNo) throws BizException {

		ICiamrRService amrService = ServiceFinder.find(ICiamrRService.class);
		AMrDO[] aMrDOs = amrService.findByAttrValString("Id_ent", id_ent);
		if (aMrDOs == null || aMrDOs.length <= 0) {
			return false;
		}
		IMrmTypeMrtpDORService mrmTypeMrtpService = ServiceFinder
				.find(IMrmTypeMrtpDORService.class);
		
		MrmTypeMrtpDO[] mrmTypeMrtpDOs = mrmTypeMrtpService
				.findByAttrValString("Id_set", id_set);
		if (mrmTypeMrtpDOs == null || mrmTypeMrtpDOs.length <= 0) {
			return false;
		}

		ICimrmfileinfoRService ciMrmFileInfoRService = ServiceFinder
				.find(ICimrmfileinfoRService.class);
		ICimrmfileinfoCudService cimrmfileinfoCudService = ServiceFinder
				.find(ICimrmfileinfoCudService.class);
		CiMrmFileInfoDO[] ciMrmFileInfoDOs = ciMrmFileInfoRService.find(
				"id_ci_amr = '" + aMrDOs[0].getId_enhr()
						+ "' and id_bd_mrm_tp='"
						+ mrmTypeMrtpDOs[0].getId_bd_mrm_tp()
						+ "' and id_bu_sy = '" + id_busy + "'", "sortno desc",
				FBoolean.FALSE);
		if (isClear && ciMrmFileInfoDOs != null && ciMrmFileInfoDOs.length > 0) {
			//添加从文件系统删除文件的调用
			BusinessStorageService storSer = ServiceFinder.find(BusinessStorageService.class);
			for(CiMrmFileInfoDO file : ciMrmFileInfoDOs)
			{
				storSer.delete(file.getCode_file());				
			}			
			cimrmfileinfoCudService.delete(ciMrmFileInfoDOs);
		}

		ciMrmFileInfoDOs = ciMrmFileInfoRService.find("id_ci_amr = '"
				+ aMrDOs[0].getId_enhr() + "' and id_bd_mrm_tp='"
				+ mrmTypeMrtpDOs[0].getId_bd_mrm_tp() + "'", "sortno desc",
				FBoolean.FALSE);

		CiMrmFileInfoDO ciMrmFileInfoDO = new CiMrmFileInfoDO();
		ciMrmFileInfoDO.setId_set(id_set);
		ciMrmFileInfoDO.setId_ci_amr(aMrDOs[0].getId_enhr());
		ciMrmFileInfoDO.setId_bu_sy(id_busy);
		ciMrmFileInfoDO.setId_bd_mrm_tp(mrmTypeMrtpDOs[0].getId_bd_mrm_tp());
		ciMrmFileInfoDO.setName(name);
		if (sortNo == -1) {
			if (isClear || ciMrmFileInfoDOs == null
					|| ciMrmFileInfoDOs.length <= 0) {
				ciMrmFileInfoDO.setSortno(1);
			} else if (ciMrmFileInfoDOs != null && ciMrmFileInfoDOs.length > 0) {
				ciMrmFileInfoDO.setSortno(ciMrmFileInfoDOs[0].getSortno() + 1);
			}
		} else {
			ciMrmFileInfoDO.setSortno(sortNo);
		}
		ciMrmFileInfoDO.setStatus(2);
		ciMrmFileInfoDO.setId_bd_mrm_df(id_df);
		ciMrmFileInfoDO.setSd_bd_mrm_df(sd_df);
		ciMrmFileInfoDO.setCode_file(code_file);
		cimrmfileinfoCudService.save(new CiMrmFileInfoDO[] { ciMrmFileInfoDO });
		return true;

	}

	/**
	 * 添加扫描文件信息（多份）
	 * @param ciMrmFileDTOs
	 * @param id_ent
	 * @param id_busy
	 * @param id_set
	 * @param isClear
	 * @return
	 * @throws BizException
	 */
	@Override
	public Boolean addMrmFileInfoList(CiMrmFileDTO[] ciMrmFileDTOs,
			String id_ent, String id_busy, String id_set, Boolean isClear)
			throws BizException {

		ICiamrRService amrService = ServiceFinder.find(ICiamrRService.class);
		AMrDO[] aMrDOs = amrService.findByAttrValString("Id_ent", id_ent);
		if (aMrDOs == null || aMrDOs.length <= 0) {
			return false;
		}
		IMrmTypeMrtpDORService mrmTypeMrtpService = ServiceFinder
				.find(IMrmTypeMrtpDORService.class);
		
		MrmTypeMrtpDO[] mrmTypeMrtpDOs = mrmTypeMrtpService
				.findByAttrValString("Id_set",  id_set);
		if (mrmTypeMrtpDOs == null || mrmTypeMrtpDOs.length <= 0) {
			return false;
		}

		ICimrmfileinfoRService ciMrmFileInfoRService = ServiceFinder
				.find(ICimrmfileinfoRService.class);
		ICimrmfileinfoCudService cimrmfileinfoCudService = ServiceFinder
				.find(ICimrmfileinfoCudService.class);

		CiMrmFileInfoDO[] ciMrmFileInfoDOs = ciMrmFileInfoRService.find(
				"id_ci_amr = '" + aMrDOs[0].getId_enhr()
						+ "' and id_bd_mrm_tp='"
						+ mrmTypeMrtpDOs[0].getId_bd_mrm_tp()
						+ "' and id_bu_sy = '" + id_busy + "'", "sortno desc",
				FBoolean.FALSE);

		if (isClear && ciMrmFileInfoDOs != null && ciMrmFileInfoDOs.length > 0) {
			cimrmfileinfoCudService.delete(ciMrmFileInfoDOs);
		}

		ciMrmFileInfoDOs = ciMrmFileInfoRService.find("id_ci_amr = '"
				+ aMrDOs[0].getId_enhr() + "' and id_bd_mrm_tp='"
				+ mrmTypeMrtpDOs[0].getId_bd_mrm_tp() + "'", "sortno desc",
				FBoolean.FALSE);

		List<CiMrmFileInfoDO> lsFileDos = new ArrayList<CiMrmFileInfoDO>();

		for (CiMrmFileDTO ciMrmFileDTO : ciMrmFileDTOs) {
			CiMrmFileInfoDO ciMrmFileInfoDO = new CiMrmFileInfoDO();
			ciMrmFileInfoDO.setId_ci_amr(aMrDOs[0].getId_enhr());
			ciMrmFileInfoDO.setId_bu_sy(id_busy);
			ciMrmFileInfoDO
					.setId_bd_mrm_tp(mrmTypeMrtpDOs[0].getId_bd_mrm_tp());
			ciMrmFileInfoDO.setName(ciMrmFileDTO.getName());
			if (ciMrmFileDTO.getSortno() == -1) {
				if (isClear || ciMrmFileInfoDOs == null
						|| ciMrmFileInfoDOs.length <= 0) {
					ciMrmFileInfoDO.setSortno(1);
				} else if (ciMrmFileInfoDOs != null
						&& ciMrmFileInfoDOs.length > 0) {

					ciMrmFileInfoDO
							.setSortno(ciMrmFileInfoDOs[0].getSortno() + 1);
				}
			} else {
				ciMrmFileInfoDO.setSortno(ciMrmFileDTO.getSortno());
			}
			ciMrmFileInfoDO.setStatus(2);
			ciMrmFileInfoDO.setId_bd_mrm_df(ciMrmFileDTO.getId_df());
			ciMrmFileInfoDO.setSd_bd_mrm_df(ciMrmFileDTO.getSd_df());
			ciMrmFileInfoDO.setCode_file(ciMrmFileDTO.getCode_file());
			ciMrmFileInfoDO.setId_set(id_set);
			lsFileDos.add(ciMrmFileInfoDO);
		}
		cimrmfileinfoCudService.save(lsFileDos.toArray(new CiMrmFileInfoDO[0]));
		return true;

	}

	/**
	 * 删除就诊病案分类下同一业务产生文件信息
	 * @param id_ent
	 * @param id_busy
	 * @param id_set
	 * @return
	 * @throws BizException
	 */
	@Override
	public Boolean deleteMrmFileInfo(String id_ent, String id_busy,
			String id_set) throws BizException {
		ICiamrRService amrService = ServiceFinder.find(ICiamrRService.class);
		AMrDO[] aMrDOs = amrService.findByAttrValString("Id_ent", id_ent);
		if (aMrDOs == null || aMrDOs.length <= 0) {
			return false;
		}
		IMrmTypeMrtpDORService mrmTypeMrtpService = ServiceFinder
				.find(IMrmTypeMrtpDORService.class);

		MrmTypeMrtpDO[] mrmTypeMrtpDOs = mrmTypeMrtpService
				.findByAttrValString("Id_set",  id_set);
		if (mrmTypeMrtpDOs == null || mrmTypeMrtpDOs.length <= 0) {
			return false;
		}

		ICimrmfileinfoRService ciMrmFileInfoRService = ServiceFinder
				.find(ICimrmfileinfoRService.class);
		ICimrmfileinfoCudService cimrmfileinfoCudService = ServiceFinder
				.find(ICimrmfileinfoCudService.class);

		CiMrmFileInfoDO[] ciMrmFileInfoDOs = ciMrmFileInfoRService.find(
				"id_ci_amr = '" + aMrDOs[0].getId_enhr()
						+ "' and id_bd_mrm_tp='"
						+ mrmTypeMrtpDOs[0].getId_bd_mrm_tp()
						+ "' and id_bu_sy = '" + id_busy + "'", "sortno desc",
				FBoolean.FALSE);

		if (ciMrmFileInfoDOs != null && ciMrmFileInfoDOs.length > 0) {
			cimrmfileinfoCudService.delete(ciMrmFileInfoDOs);
		}
		return true;
	}

	
	public String getSysParamSaveFormat()  throws BizException{
		// TODO Auto-generated method stub
		return CiMrMParamUtils.getSysParamSaveFormat(Context.get().getOrgId());
	}

	@Override
	public Boolean isAutoSave(String id_set)  throws BizException{
		IMrmTypeMrtpDORService mrmTypeMrtpService = ServiceFinder
				.find(IMrmTypeMrtpDORService.class);

		MrmTypeMrtpDO[] mrmTypeMrtpDOs = mrmTypeMrtpService
				.findByAttrValString("Id_set",  id_set);
		if (mrmTypeMrtpDOs == null || mrmTypeMrtpDOs.length <= 0) {
			return false;
		}
		
		IMrmtypeMDORService mrmtypeMDORService = ServiceFinder
				.find(IMrmtypeMDORService.class);
		
		MrmTypeDO mrmTypeDO = mrmtypeMDORService.findById(mrmTypeMrtpDOs[0].getId_bd_mrm_tp());
		
		if(mrmTypeDO!=null)
		{
			return mrmTypeDO.getFg_auto().booleanValue();
		}
		
		return false;
	}
	
	@Override
	public Boolean isInRecordRoom(String id_ent) throws BizException
	{
		Boolean isIn = false;
		ICiamrRService ser = ServiceFinder.find(ICiamrRService.class);
		if(ser!=null)
		{
			AMrDO[] arms = ser.findByAttrValString("Id_ent", id_ent);
			if(arms!=null&&id_ent.length()>0)
			{
				//病案这几种状态时代表在病案室
				String id_qa_doctor_part_sta = arms[0].getId_qa_doctor_part_sta();
				if(ICiMrDictCodeConst.ID_MR_HASSIGNED==id_qa_doctor_part_sta||
				   ICiMrDictCodeConst.ID_MR_HASTOCODE==	id_qa_doctor_part_sta||
				   ICiMrDictCodeConst.ID_MR_HASTOFILE ==id_qa_doctor_part_sta)
				{
					isIn = true;
				}
			}
		}
		return isIn;
	}
}
