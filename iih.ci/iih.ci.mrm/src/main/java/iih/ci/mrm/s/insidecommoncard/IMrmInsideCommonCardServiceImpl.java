package iih.ci.mrm.s.insidecommoncard;

import iih.bd.srv.emrtype.d.MrTpDO;
import iih.bd.srv.emrtype.i.IEmrtypeRService;
import iih.bd.srv.mrmtype.d.MrmTypeDO;
import iih.bd.srv.mrmtype.d.MrmTypeMrtpDO;
import iih.bd.srv.mrmtype.i.IMrmTypeMrtpDORService;
import iih.bd.srv.mrmtype.i.IMrmtypeMDORService;
import iih.ci.mr.ciamr.d.AMrDO;
import iih.ci.mr.ciamr.i.ICiamrRService;
import iih.ci.mrfp.cimrfp.d.CiMrFpDO;
import iih.ci.mrfp.cimrfp.i.ICimrfpRService;
import iih.ci.mrm.cimrmfiledto.d.CiMrmFileDTO;
import iih.ci.mrm.cimrmfileinfo.d.CiMrmFileInfoDO;
import iih.ci.mrm.cimrmfileinfo.i.ICimrmfileinfoCudService;
import iih.ci.mrm.cimrmfileinfo.i.ICimrmfileinfoRService;
import iih.ci.mrm.i.insidecommoncard.IMrmInsideCommonCardService;
import iih.mkr.std.deset.d.DeDataSetDO;
import iih.mkr.std.deset.i.IDesetMDORService;

import java.util.ArrayList;
import java.util.List;

import xap.mw.basic.storage.BusinessStorageService;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;

@Service(serviceInterfaces = { IMrmInsideCommonCardService.class }, binding = Binding.JSONRPC)
public class IMrmInsideCommonCardServiceImpl implements
		IMrmInsideCommonCardService {

	/**
	 * 添加扫描文件信息
	 * 
	 * @param ciMrmFileInfoDO
	 * @param isInsert
	 * @throws BizException
	 */
	@Override
	public void addMrmFileInfo(CiMrmFileInfoDO ciMrmFileInfoDO, Boolean isInsert)
			throws BizException {
		if (isInsert) {
			DAFacade daf = new DAFacade();
			String sql = "update ci_mrm_fi set sortno = sortno+1 where ci_mrm_fi.id_ci_amr='"
					+ ciMrmFileInfoDO.getId_ci_amr()
					+ "' and ci_mrm_fi.id_bd_mrm_tp='"
					+ ciMrmFileInfoDO.getId_bd_mrm_tp()
					+ "' and ci_mrm_fi.sortno >=" + ciMrmFileInfoDO.getSortno();
			daf.execUpdate(sql);
		}

		ICimrmfileinfoCudService service = ServiceFinder
				.find(ICimrmfileinfoCudService.class);
		service.save(new CiMrmFileInfoDO[] { ciMrmFileInfoDO });

	}

	/**
	 * 添加臊面文件信息
	 * 
	 * @param id_ent
	 * @param id_busy
	 * @param id_mrtp
	 * @param name
	 * @param code_file
	 * @param id_df
	 * @param sd_df
	 * @param isClear
	 * @return
	 * @throws BizException
	 */
	@Override
	public Boolean addMrmFileInfoMR(String id_ent, String id_busy,
			String id_mrtp, String name, String code_file, String id_df,
			String sd_df, Boolean isClear, int sortNo) throws BizException {

		ICiamrRService amrService = ServiceFinder.find(ICiamrRService.class);
		AMrDO[] aMrDOs = amrService.findByAttrValString("Id_ent", id_ent);
		if (aMrDOs == null || aMrDOs.length <= 0) {
			return false;
		}
		IMrmTypeMrtpDORService mrmTypeMrtpService = ServiceFinder
				.find(IMrmTypeMrtpDORService.class);
		IEmrtypeRService emrtypeRService = ServiceFinder
				.find(IEmrtypeRService.class);
		MrTpDO mrTpDO = emrtypeRService.findById(id_mrtp);
		if (mrTpDO == null || mrTpDO.getId_data_set() == null) {
			return false;
		}
		MrmTypeMrtpDO[] mrmTypeMrtpDOs = mrmTypeMrtpService
				.findByAttrValString("Id_set", mrTpDO.getId_data_set());
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

		CiMrmFileInfoDO ciMrmFileInfoDO = new CiMrmFileInfoDO();
		ciMrmFileInfoDO.setId_set(mrTpDO.getId_data_set());
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
	 * @param id_mrtp
	 * @param isClear
	 * @return
	 * @throws BizException
	 */
	@Override
	public Boolean addMrmFileInfoListMR(CiMrmFileDTO[] ciMrmFileDTOs,
			String id_ent, String id_busy, String id_mrtp, Boolean isClear)
			throws BizException {

		ICiamrRService amrService = ServiceFinder.find(ICiamrRService.class);
		AMrDO[] aMrDOs = amrService.findByAttrValString("Id_ent", id_ent);
		if (aMrDOs == null || aMrDOs.length <= 0) {
			return false;
		}
		IMrmTypeMrtpDORService mrmTypeMrtpService = ServiceFinder
				.find(IMrmTypeMrtpDORService.class);
		IEmrtypeRService emrtypeRService = ServiceFinder
				.find(IEmrtypeRService.class);
		MrTpDO mrTpDO = emrtypeRService.findById(id_mrtp);
		if (mrTpDO == null || mrTpDO.getId_data_set() == null) {
			return false;
		}
		MrmTypeMrtpDO[] mrmTypeMrtpDOs = mrmTypeMrtpService
				.findByAttrValString("Id_set",  mrTpDO.getId_data_set());
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
			ciMrmFileInfoDO.setId_set(mrTpDO.getId_data_set());
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
			lsFileDos.add(ciMrmFileInfoDO);
		}
		cimrmfileinfoCudService.save(lsFileDos.toArray(new CiMrmFileInfoDO[0]));
		return true;

	}

	/**
	 * 删除就诊病案分类下同一业务产生文件信息
	 * @param id_ent
	 * @param id_busy
	 * @param id_mrtp
	 * @return
	 * @throws BizException
	 */
	@Override
	public Boolean deleteMrmFileInfo(String id_ent, String id_busy,
			String id_mrtp) throws BizException {
		ICiamrRService amrService = ServiceFinder.find(ICiamrRService.class);
		AMrDO[] aMrDOs = amrService.findByAttrValString("Id_ent", id_ent);
		if (aMrDOs == null || aMrDOs.length <= 0) {
			return false;
		}
		IMrmTypeMrtpDORService mrmTypeMrtpService = ServiceFinder
				.find(IMrmTypeMrtpDORService.class);
		IEmrtypeRService emrtypeRService = ServiceFinder
				.find(IEmrtypeRService.class);
		MrTpDO mrTpDO = emrtypeRService.findById(id_mrtp);
		if (mrTpDO == null || mrTpDO.getId_data_set() == null) {
			return false;
		}
		MrmTypeMrtpDO[] mrmTypeMrtpDOs = mrmTypeMrtpService
				.findByAttrValString("Id_set",  mrTpDO.getId_data_set());
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

	/**
	 * 获取数据集是否自动生成病案电子文档
	 * @param id_mrtp
	 * @return
	 * @throws BizException
	 */
	@Override
	public Boolean isAutoSave(String id_mrtp) throws BizException {
		IEmrtypeRService emrtypeRService = ServiceFinder
				.find(IEmrtypeRService.class);
		IMrmTypeMrtpDORService mrmTypeMrtpService = ServiceFinder
				.find(IMrmTypeMrtpDORService.class);
		
		MrTpDO mrTpDO = emrtypeRService.findById(id_mrtp);
		if (mrTpDO == null || mrTpDO.getId_data_set() == null) {
			return false;
		}
		MrmTypeMrtpDO[] mrmTypeMrtpDOs = mrmTypeMrtpService
				.findByAttrValString("Id_set",  mrTpDO.getId_data_set());
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

	
	/**
	 * 删除病案文件
	 * @param lsCiMrmFileInfoDO
	 * @return
	 * @throws BizException
	 */
	@Override
	public Boolean deleteMrmFileInfoList(CiMrmFileInfoDO[] lsCiMrmFileInfoDO)
			throws BizException {
		ICimrmfileinfoCudService cimrmfileinfoCudService = ServiceFinder
				.find(ICimrmfileinfoCudService.class);
		
		cimrmfileinfoCudService.delete(lsCiMrmFileInfoDO);
		
		return true;
	}
	/**
	 * 保存病案首页pdf信息
	 * @param id_ent
	 * @param code_set
	 * @param name
	 * @param code_file
	 * @param id_df
	 * @param sd_df
	 * @return
	 * @throws BizException
	 */
	@Override
	public Boolean addMrmFileInfoMrFp(String id_ent, String code_set,
			String name, String code_file, String id_df, String sd_df)
			throws BizException {
		ICiamrRService amrService = ServiceFinder.find(ICiamrRService.class);
		AMrDO[] aMrDOs = amrService.findByAttrValString("Id_ent", id_ent);
		if (aMrDOs == null || aMrDOs.length <= 0) {
			return false;
		}
		IMrmTypeMrtpDORService mrmTypeMrtpService = ServiceFinder
				.find(IMrmTypeMrtpDORService.class);
		IDesetMDORService datasetdoRService=ServiceFinder.find(IDesetMDORService.class);
		DeDataSetDO[] setDoArr=datasetdoRService.find(" code='"+code_set+"'", "", FBoolean.FALSE);
		if (setDoArr.length<0) {
			return false;
		}
		DeDataSetDO mrTpDO = setDoArr[0];
		MrmTypeMrtpDO[] mrmTypeMrtpDOs = mrmTypeMrtpService
				.findByAttrValString("Id_set", mrTpDO.getId_set());
		if (mrmTypeMrtpDOs == null || mrmTypeMrtpDOs.length <= 0) {
			return false;
		}
		ICimrfpRService cimrfpRService = ServiceFinder.find(ICimrfpRService.class);
		CiMrFpDO[] ciMrFpDOArrs = cimrfpRService.find("id_ent='" + id_ent + "'", "", FBoolean.FALSE);
		if (ciMrFpDOArrs.length<0) {
			return false;
		}
		if(ciMrFpDOArrs==null ||ciMrFpDOArrs.length<=0)
		{
			return true;
		}
		CiMrFpDO mrfpDo=ciMrFpDOArrs[0];
		ICimrmfileinfoRService ciMrmFileInfoRService = ServiceFinder
				.find(ICimrmfileinfoRService.class);
		ICimrmfileinfoCudService cimrmfileinfoCudService = ServiceFinder
				.find(ICimrmfileinfoCudService.class);
		CiMrmFileInfoDO[] ciMrmFileInfoDOs = ciMrmFileInfoRService.find(
				"id_ci_amr = '" + aMrDOs[0].getId_enhr()
						+ "' and id_bd_mrm_tp='"
						+ mrmTypeMrtpDOs[0].getId_bd_mrm_tp()
						+ "' and id_bu_sy = '" + mrfpDo.getId_mrfp() + "'", "sortno desc",
				FBoolean.FALSE);
		if (ciMrmFileInfoDOs != null && ciMrmFileInfoDOs.length > 0) {
			cimrmfileinfoCudService.delete(ciMrmFileInfoDOs);
		}

		ciMrmFileInfoDOs = ciMrmFileInfoRService.find("id_ci_amr = '"
				+ aMrDOs[0].getId_enhr() + "' and id_bd_mrm_tp='"
				+ mrmTypeMrtpDOs[0].getId_bd_mrm_tp() + "'", "sortno desc",
				FBoolean.FALSE);

		CiMrmFileInfoDO ciMrmFileInfoDO = new CiMrmFileInfoDO();
		ciMrmFileInfoDO.setId_set(mrTpDO.getId_set());
		ciMrmFileInfoDO.setId_ci_amr(aMrDOs[0].getId_enhr());
		ciMrmFileInfoDO.setId_bu_sy(mrfpDo.getId_mrfp());
		ciMrmFileInfoDO.setId_bd_mrm_tp(mrmTypeMrtpDOs[0].getId_bd_mrm_tp());
		ciMrmFileInfoDO.setName(name);
		ciMrmFileInfoDO.setStatus(2);
		ciMrmFileInfoDO.setId_bd_mrm_df(id_df);
		ciMrmFileInfoDO.setSd_bd_mrm_df(sd_df);
		ciMrmFileInfoDO.setCode_file(code_file == null ? "~" : code_file);
		ciMrmFileInfoDO.setSortno(1);
		cimrmfileinfoCudService.save(new CiMrmFileInfoDO[] { ciMrmFileInfoDO });
		return true;
	}

	@Override
	public Boolean addMrmFileInfoCA(String id_ent, String id_busy, String id_mrtp, String name, String code_file,
			String id_df, String sd_df, Boolean isClear, int sortNo, String fg_ca, String dt_sign, String id_psn, String id_dep,
			String name_psn, String name_dept, String eu_pat_sign, String name_pat_sign) throws BizException {
		// 服务定义
		ICiamrRService amrService = ServiceFinder.find(ICiamrRService.class);
		IEmrtypeRService emrtypeRService = ServiceFinder.find(IEmrtypeRService.class);
		IMrmTypeMrtpDORService mrmTypeMrtpService = ServiceFinder.find(IMrmTypeMrtpDORService.class);
		ICimrmfileinfoRService ciMrmFileInfoRService = ServiceFinder.find(ICimrmfileinfoRService.class);
		ICimrmfileinfoCudService cimrmfileinfoCudService = ServiceFinder.find(ICimrmfileinfoCudService.class);
		
		AMrDO[] aMrDOs = amrService.findByAttrValString("Id_ent", id_ent);
		
		if (aMrDOs == null || aMrDOs.length <= 0) {
			return false;
		}
		MrTpDO mrTpDO = emrtypeRService.findById(id_mrtp);
		
		if (mrTpDO == null || mrTpDO.getId_data_set() == null) {
			return false;
		}
		MrmTypeMrtpDO[] mrmTypeMrtpDOs = mrmTypeMrtpService.findByAttrValString("Id_set", mrTpDO.getId_data_set());
		
		if (mrmTypeMrtpDOs == null || mrmTypeMrtpDOs.length <= 0) {
			return false;
		}
		CiMrmFileInfoDO[] ciMrmFileInfoDOs = ciMrmFileInfoRService.find(
				" id_ci_amr = '" + aMrDOs[0].getId_enhr() + "' and id_bd_mrm_tp='" + mrmTypeMrtpDOs[0].getId_bd_mrm_tp() 
				+ "' and id_bu_sy = '" + id_busy + "'", "sortno desc", FBoolean.FALSE);
		
		if (isClear && ciMrmFileInfoDOs != null && ciMrmFileInfoDOs.length > 0) {
			//添加从文件系统删除文件的调用
			BusinessStorageService storSer = ServiceFinder.find(BusinessStorageService.class);
			
			for(CiMrmFileInfoDO file : ciMrmFileInfoDOs)
			{
				storSer.delete(file.getCode_file());				
			}			
			cimrmfileinfoCudService.delete(ciMrmFileInfoDOs);
		}
		ciMrmFileInfoDOs = ciMrmFileInfoRService.find(" id_ci_amr = '" + aMrDOs[0].getId_enhr() 
				+ "' and id_bd_mrm_tp='" + mrmTypeMrtpDOs[0].getId_bd_mrm_tp() + "'", "sortno desc", FBoolean.FALSE);

		CiMrmFileInfoDO ciMrmFileInfoDO = new CiMrmFileInfoDO();
		ciMrmFileInfoDO.setId_set(mrTpDO.getId_data_set());
		ciMrmFileInfoDO.setId_ci_amr(aMrDOs[0].getId_enhr());
		ciMrmFileInfoDO.setId_bu_sy(id_busy);
		ciMrmFileInfoDO.setId_bd_mrm_tp(mrmTypeMrtpDOs[0].getId_bd_mrm_tp());
		ciMrmFileInfoDO.setName(name);
		
		if (sortNo == -1) {
			if (isClear || ciMrmFileInfoDOs == null || ciMrmFileInfoDOs.length <= 0) {
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
		
		if(fg_ca.equals("True")){
			ciMrmFileInfoDO.setFg_ca(FBoolean.TRUE);
			ciMrmFileInfoDO.setDt_sign(dt_sign);
			ciMrmFileInfoDO.setId_psn(id_psn);
			ciMrmFileInfoDO.setId_dep(id_dep);
			ciMrmFileInfoDO.setName_psn(name_psn);
			ciMrmFileInfoDO.setName_dept(name_dept);
			ciMrmFileInfoDO.setEu_pat_sign(eu_pat_sign);
			ciMrmFileInfoDO.setName_pat_sign(name_pat_sign);
		}else if(fg_ca.equals("False")){
			ciMrmFileInfoDO.setFg_ca(FBoolean.FALSE);
		}
		cimrmfileinfoCudService.save(new CiMrmFileInfoDO[] { ciMrmFileInfoDO });
		return true;
	}

}
