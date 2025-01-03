package iih.ci.ord.s.bp.ordsrvchangedval;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.mysql.jdbc.StringUtils;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.mm.meterial.i.IMeterialMDORService;
import iih.bd.pp.primd.i.IBdPrimdCodeConst;
import iih.bd.pp.prisrvcomp.d.PriSrvCompDO;
import iih.bd.pp.prisrvcomp.i.IPrisrvcompRService;
import iih.bd.pp.prisrvsetfix.d.PriSrvSetFixDO;
import iih.bd.pp.prisrvsetfix.i.IPrisrvsetfixRService;
import iih.bd.pp.prisrvsetmu.d.PriSrvSetMuDO;
import iih.bd.pp.prisrvsetmu.i.IPrisrvsetmuRService;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvSetItemDO;
import iih.bd.srv.medsrv.i.IMedSrvSetItemDORService;
import iih.bd.utils.BdMmParamUtils;
import iih.ci.ord.dto.ordsrvchangeddto.d.OrdSrvChangedInfoDTO;
import iih.ci.ord.i.ICiOrdNSysParamConst;
import iih.ci.ord.s.bp.ordsrvchangedval.qry.GetMedSrvDOsQry;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.FMap;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

/**
 * @code 公共临床项目可使用校验
 * @author LiYue
 * @date 2020年1月15日,上午11:27:33
 */
public class OrdCommenChangedSrvValidateBP {

	public static String STR_SRV_ENTP_VAL = "服务【%s】就诊类型不符";
	public static String STR_SRV_ENTP_MM = "物品【%s】关联物品【%s】的就诊类型不符";
	public static String STR_SRV_ACTIVE_VAL = "服务【%s】停用";
	public static String STR_SRV_OR_VAL = "服务【%s】不是医嘱服务";
	public static String STR_SRV_MM_ACTIVE_VAL = "服务【%s】关联物品【%s】停用";
	public static String STR_SRV_MM_OUT_VAL = "服务【%s】关联物品【%s】停开";
	public static String STR_SRV_MM_VAL = "服务【%s】关联物品变更";
	public static String STR_SRV_SET_VAL = "【%s】套内明细【%s】停用";
	public static String STR_SRV_BL_VAL = "【%s】费用项已删除。";
	public static String STR_SRV_SET ="【%s】套内明细【%s】";

	protected Map mapMeSrvDOs_Checked = new FMap();
	protected FMap2 mapResult = new FMap2();
	/**
	 * 获取药品用药属性管理模式
	 */
	private String drugManagementModel;

	public OrdCommenChangedSrvValidateBP() throws BizException {
		drugManagementModel = BdMmParamUtils.GetDrugMCPropMM();
	}

	public String getOpenItemMaintainerValidate() throws BizException{
		String openItemMaintainerValidate = ParamsetQryUtil.getParaString(Context.get().getOrgId(),ICiOrdNSysParamConst.SYS_PARAM_OpenItemMaintainer);
		if(openItemMaintainerValidate==null||"".equals(openItemMaintainerValidate)){
			return ",请联系相关科室维护处理。";
		}
		return ","+openItemMaintainerValidate+"。";
	}
	/**
	 * 获取不可用医疗服务及提示信息
	 * 
	 * @param medSrvDOs
	 *            待判断服务对象集合
	 * @param code_entp
	 *            就诊类型
	 * @return
	 * @throws BizException
	 */
	public Map<String, String> exec(List<MedSrvDO> medSrvDOs, String code_entp) throws BizException {
		Map<String, String> srvStatusMap = new HashMap<String, String>();
		if (medSrvDOs == null || medSrvDOs.size() == 0) {
			return srvStatusMap;
		}

		FMap2 fmap = this.exec(medSrvDOs.toArray(new MedSrvDO[medSrvDOs.size()]));

		for (String key : fmap.keySet()) {
			srvStatusMap.put(key, fmap.get(key).toString());
		}

		return srvStatusMap;
	}
	
	/**
	 * 
	 */

	/**
	 * 获取不可用医疗服务及提示信息
	 * 
	 * @param code_entp
	 *            就诊类型
	 * @param medSrvDOs
	 *            待判断服务对象数组
	 * @return
	 * @throws BizException
	 */
	public FMap2 exec(MedSrvDO[] medSrvDOs) throws BizException {
		if (null == medSrvDOs || 0 >= medSrvDOs.length)
			return null;

		List<OrdSrvChangedInfoDTO> srvInfoDTOs = new ArrayList<OrdSrvChangedInfoDTO>();
		for (MedSrvDO medSrvDO : medSrvDOs) {
			OrdSrvChangedInfoDTO dto = new OrdSrvChangedInfoDTO();
			dto.setId_srv(medSrvDO.getId_srv());
			srvInfoDTOs.add(dto);
		}
		return this.exec(srvInfoDTOs.toArray(new OrdSrvChangedInfoDTO[srvInfoDTOs.size()]));
	}

	/**
	 * 获取不可用医疗服务及提示信息
	 * 
	 * @param code_entp
	 *            就诊类型
	 * @param ordSrvChangedInfoDTOs
	 *            服务是否可用判断参数
	 * @return Map<String,String> 非物品时 key：id_srv ; value：不可用提示信息，物品时
	 *         key：id_srv,id_mm ; value：不可用提示信息
	 * @throws BizException
	 */
	public Map<String, String> exec(String code_entp, List<OrdSrvChangedInfoDTO> ordSrvInfos) throws BizException {

		Map<String, String> srvStatusMap = new HashMap<String, String>();
		if (ordSrvInfos == null || ordSrvInfos.size() == 0) {
			return srvStatusMap;
		}

		FMap2 fmap = this.exec(ordSrvInfos.toArray(new OrdSrvChangedInfoDTO[ordSrvInfos.size()]));

		for (String key : fmap.keySet()) {
			srvStatusMap.put(key, fmap.get(key).toString());
		}

		return srvStatusMap;
	}

	/**
	 * 获取不可用医疗服务及提示信息
	 * 
	 * @param code_entp
	 *            就诊类型
	 * @param ordSrvChangedInfoDTOs
	 *            传入对象集合 （id_srv,id_mm）
	 * @return FMap2，不可开立的服务集合（Key:"Id_srv,Id_mm",Value:服务不可开立原因提示）
	 * @throws BizException
	 */
	public FMap2 exec(OrdSrvChangedInfoDTO[] ordSrvChangedInfoDTOs) throws BizException {
		if (null == ordSrvChangedInfoDTOs || 0 >= ordSrvChangedInfoDTOs.length)
			return mapResult;

		List<String> idSrvList = new ArrayList<String>();// 需要校验的服务ID集合
		Map<String, List<String>> srvMmMap = new HashMap<String, List<String>>();// 需要校验的
																					// 服务-物品
																					// （保存在模板中）

		for (OrdSrvChangedInfoDTO ordSrvChangedInfoDTO : ordSrvChangedInfoDTOs) {
			if (null != ordSrvChangedInfoDTO && !StringUtils.isNullOrEmpty(ordSrvChangedInfoDTO.getId_srv())) {
				String tempIdSrv = ordSrvChangedInfoDTO.getId_srv();
				String tempIdMm = ordSrvChangedInfoDTO.getId_mm();
				// 去除重复服务
				if (!idSrvList.contains(tempIdSrv))
					idSrvList.add(tempIdSrv);
				// (id_srv:id_mm1,id_mm2,id_mm3...)

				if (!StringUtils.isNullOrEmpty(tempIdMm)) {

					List<String> idMmList = null;
					if (srvMmMap.containsKey(tempIdSrv)) {
						idMmList = srvMmMap.get(tempIdSrv);
					} else {
						idMmList = new ArrayList<String>();
						srvMmMap.put(tempIdSrv, idMmList);
					}

					if (!idMmList.contains(tempIdMm)) {
						idMmList.add(tempIdMm);
					}
				}
			}
		}
		// 获取校验数据集合(id_srv:MedSrvDO)
		MedSrvDO[] meSrvDOs = getMedSrvDOs(idSrvList);
		if (null != meSrvDOs && 0 < meSrvDOs.length) {
			for (MedSrvDO meSrvDO : meSrvDOs) {
				mapMeSrvDOs_Checked.put(meSrvDO.getId_srv(), meSrvDO);
			}
		}
		
		//服务费用停用判断
		judgeSrvBL();

		return mapResult;
	}

	/**
	 * 服务就诊类型判断
	 * 
	 * @param code_entp
	 *            就诊类型
	 */
	private void judgeSrvEntp(String code_entp) {
		if (null == mapMeSrvDOs_Checked || 0 >= mapMeSrvDOs_Checked.size())
			return;

		try {
			Set<String> id_srvs = mapMeSrvDOs_Checked.keySet();
			for (String id_srv : new ArrayList<>(id_srvs)) {
				MedSrvDO meSrvDO = (MedSrvDO) mapMeSrvDOs_Checked.get(id_srv);

				boolean bEnable = false;

				if (IBdFcDictCodeConst.SD_CODE_ENTP_OP.equals(code_entp) 
						&& FBoolean.TRUE.equals(meSrvDO.getFg_use_op())) {
						bEnable = true;
				} else if (IBdFcDictCodeConst.SD_CODE_ENTP_IP.equals(code_entp)
						&& FBoolean.TRUE.equals(meSrvDO.getFg_use_ip())) {
					bEnable = true;
				} else if (IBdFcDictCodeConst.SD_CODE_ENTP_PE.equals(code_entp)
						&& FBoolean.TRUE.equals(meSrvDO.getFg_use_pe())) {
					bEnable = true;
				} else if (IBdFcDictCodeConst.SD_CODE_ENTP_FA.equals(code_entp) 
						&& FBoolean.TRUE.equals(meSrvDO.getFg_use_fm())) {
					bEnable = true;
				}else if(IBdFcDictCodeConst.SD_CODE_ENTP_ET_FLOW.equals(code_entp)
						&& FBoolean.TRUE.equals(meSrvDO.getFg_use_er())){// 急诊流水启用
					bEnable = true;
				}else if(IBdFcDictCodeConst.SD_CODE_ENTP_ET_FSTAID.equals(code_entp)
						&& FBoolean.TRUE.equals(meSrvDO.getFg_use_er1())){// 急诊抢救启用
					bEnable = true;
				}else if(IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS.equals(code_entp)
						&& FBoolean.TRUE.equals(meSrvDO.getFg_use_er2())){// 急诊留观启用
					bEnable = true;
				}

				if (!bEnable) {
					String msg=getOpenItemMaintainerValidate();
					mapResult.put(id_srv, String.format(STR_SRV_ENTP_VAL+msg, meSrvDO.getName()));
					mapMeSrvDOs_Checked.remove(id_srv);
				}
			}
		} catch (Exception e) {

		}
	}


	/**
	 * 商品模式下，判断物品的就诊类型
	 * @param code_entp
	 * @param id_srv
	 * @param name_srv
	 * @param meterial
	 * @throws BizException 
	 */
	private void judgeMmEntp(String code_entp,String id_srv,String name_srv,MeterialDO meterial) throws BizException{
		// 判断物品就诊类型是否可用
		boolean isAvailable = false;
		String msg=getOpenItemMaintainerValidate();
		if (IBdFcDictCodeConst.SD_CODE_ENTP_OP.equals(code_entp)
				&& FBoolean.TRUE.equals(meterial.getFg_use_op())) {
			isAvailable = true;
		} else if (IBdFcDictCodeConst.SD_CODE_ENTP_IP.equals(code_entp)
				&& FBoolean.TRUE.equals(meterial.getFg_use_ip())) {
			isAvailable = true;
		} else if (IBdFcDictCodeConst.SD_CODE_ENTP_ET_FLOW.equals(code_entp)
				&& FBoolean.TRUE.equals(meterial.getFg_use_er())) {
			isAvailable = true;
		}else if (IBdFcDictCodeConst.SD_CODE_ENTP_ET_FSTAID.equals(code_entp)
				&& FBoolean.TRUE.equals(meterial.getFg_use_er1())) {
			isAvailable = true;
		}else if (IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS.equals(code_entp)
				&& FBoolean.TRUE.equals(meterial.getFg_use_er2())) {
			isAvailable = true;
		} else if (IBdFcDictCodeConst.SD_CODE_ENTP_PE.equals(code_entp)
				&& FBoolean.TRUE.equals(meterial.getFg_use_pe())) {
			isAvailable = true;
		} else if (IBdFcDictCodeConst.SD_CODE_ENTP_FA.equals(code_entp)
				&& FBoolean.TRUE.equals(meterial.getFg_use_fm())) {
			isAvailable = true;
		}

		if (!isAvailable) {
			mapResult.put(id_srv + "," + meterial.getId_mm(),
					String.format(STR_SRV_ENTP_MM+msg, name_srv, meterial.getName()));
		}
	}


	/**
	 * 服务费用停用判断
	 * 
	 * @throws BizException
	 */
	private void judgeSrvBL() throws BizException {
		if (null == mapMeSrvDOs_Checked || 0 >= mapMeSrvDOs_Checked.size())
			return;

		Set<String> id_srvs = mapMeSrvDOs_Checked.keySet();
		List<String> idSrvList = new ArrayList<String>(id_srvs);

		MedSrvSetItemDO[] allMedSrvSetItemDOs = this.getMedSrvSetItemDOs(idSrvList);
		Map<String, List<MedSrvSetItemDO>> mapMedSrvSetItemDOs = new HashMap<String, List<MedSrvSetItemDO>>();
		if (allMedSrvSetItemDOs != null && allMedSrvSetItemDOs.length > 0) {
			for (MedSrvSetItemDO item : allMedSrvSetItemDOs) {
				if (mapMedSrvSetItemDOs.containsKey(item.getId_srv())) {
					mapMedSrvSetItemDOs.get(item.getId_srv()).add(item);
				} else {
					List<MedSrvSetItemDO> lst = new ArrayList<MedSrvSetItemDO>();
					lst.add(item);
					mapMedSrvSetItemDOs.put(item.getId_srv(), lst);
				}
			}
		}

		PriSrvSetMuDO[] allPriSrvSetMuDOs = getPriSrvSetMuDOs(idSrvList);
		Map<String, List<PriSrvSetMuDO>> mapPriSrvSetMuDOs = new HashMap<String, List<PriSrvSetMuDO>>();
		if (allPriSrvSetMuDOs != null && allPriSrvSetMuDOs.length > 0) {
			for (PriSrvSetMuDO item : allPriSrvSetMuDOs) {
				if (mapPriSrvSetMuDOs.containsKey(item.getId_srvset())) {
					mapPriSrvSetMuDOs.get(item.getId_srvset()).add(item);
				} else {
					List<PriSrvSetMuDO> lst = new ArrayList<PriSrvSetMuDO>();
					lst.add(item);
					mapPriSrvSetMuDOs.put(item.getId_srvset(), lst);
				}
			}
		}

		PriSrvSetFixDO[] allpPiSrvSetFixDOs = getPriSrvSetFixDOs(idSrvList);
		Map<String, List<PriSrvSetFixDO>> mapPriSrvSetFixDOs = new HashMap<String, List<PriSrvSetFixDO>>();
		if (allpPiSrvSetFixDOs != null && allpPiSrvSetFixDOs.length > 0) {
			for (PriSrvSetFixDO item : allpPiSrvSetFixDOs) {
				if (mapPriSrvSetFixDOs.containsKey(item.getId_srvset())) {
					mapPriSrvSetFixDOs.get(item.getId_srvset()).add(item);
				} else {
					List<PriSrvSetFixDO> lst = new ArrayList<PriSrvSetFixDO>();
					lst.add(item);
					mapPriSrvSetFixDOs.put(item.getId_srvset(), lst);
				}
			}
		}

		PriSrvCompDO[] allPriSrvCompDOs = getPriSrvCompDOs(idSrvList);
		Map<String, List<PriSrvCompDO>> mapPriSrvCompDOs = new HashMap<String, List<PriSrvCompDO>>();
		if (allPriSrvCompDOs != null && allPriSrvCompDOs.length > 0) {
			for (PriSrvCompDO item : allPriSrvCompDOs) {
				if (mapPriSrvCompDOs.containsKey(item.getId_srv())) {
					mapPriSrvCompDOs.get(item.getId_srv()).add(item);
				} else {
					List<PriSrvCompDO> lst = new ArrayList<PriSrvCompDO>();
					lst.add(item);
					mapPriSrvCompDOs.put(item.getId_srv(), lst);
				}
			}
		}

		for (String id_srv : new ArrayList<>(id_srvs)) {
			MedSrvDO meSrvDO = (MedSrvDO) mapMeSrvDOs_Checked.get(id_srv);
			if (null == meSrvDO.getFg_set() || !meSrvDO.getFg_set().booleanValue()) {
				judgeSrvBL_Srv(meSrvDO, id_srv, mapPriSrvCompDOs.get(id_srv) == null ? null
						: mapPriSrvCompDOs.get(id_srv).toArray(new PriSrvCompDO[] {}));
			} else {
				judgeSrvBL_Srvset(meSrvDO, id_srv,
						mapMedSrvSetItemDOs.get(id_srv) == null ? null
								: mapMedSrvSetItemDOs.get(id_srv).toArray(new MedSrvSetItemDO[] {}),
						mapPriSrvSetMuDOs.get(id_srv) == null ? null
								: mapPriSrvSetMuDOs.get(id_srv).toArray(new PriSrvSetMuDO[] {}),
						mapPriSrvSetFixDOs.get(id_srv) == null ? null
								: mapPriSrvSetFixDOs.get(id_srv).toArray(new PriSrvSetFixDO[] {}));
			}
		}
	}
	private String judgePriSrvComp(String id_srv) throws BizException{
		List<String> idSrvList = new ArrayList<String>();
		idSrvList.add(id_srv);
		PriSrvCompDO[] allPriSrvCompDOs = getPriSrvCompDOs(idSrvList);
		if (allPriSrvCompDOs == null || allPriSrvCompDOs.length == 0) {
			return String.format("组合计价明细未配置！");
		}
		List<String> idSrvs = new ArrayList<String>();
		for (PriSrvCompDO item : allPriSrvCompDOs) {
			idSrvs.add(item.getId_srv_bl());
		}
		if(idSrvs.size()>0){
			MedSrvDO[] meSrvDOs = getMedSrvDOs(idSrvs);
			if(meSrvDOs==null || meSrvDOs.length==0){
				return String.format("组合计价关联的服务不存在！");
			}
			for (MedSrvDO meSrvDO : meSrvDOs) {
				if (meSrvDO.getDs().equals(1)) {
					return String.format(STR_SRV_BL_VAL, meSrvDO.getName());
				}
				if(!FBoolean.TRUE.equals(meSrvDO.getFg_mm()) && FBoolean.TRUE.equals(meSrvDO.getFg_bl()) && !FBoolean.TRUE.equals(meSrvDO.getFg_active_bl())){
					return String.format("【%s】费用项目未启用(可能原因：本服务、组合定价、套内项目未启用)", meSrvDO.getName());
				}
			}
		}
		return null;
	}
	/**
	 * 非套服务费用校验
	 * 
	 * @param meSrvDO
	 * @param id_srv
	 * @return
	 * @throws BizException
	 */
	private boolean judgeSrvBL_Srv(MedSrvDO meSrvDO, String id_srv, PriSrvCompDO[] priSrvCompDOs) throws BizException {
		boolean b = true;
		if (meSrvDO.getSd_primd() == null) {
			return b;
		}
		switch (meSrvDO.getSd_primd()) {
		case IBdPrimdCodeConst.CODE_PRI_SRV:
			b = judgeSrvBL_Srv_This(meSrvDO, id_srv);
			break;
		case IBdPrimdCodeConst.CODE_PRI_SRV_COMP:
			b = judgeSrvBL_Srv_Comp(priSrvCompDOs, id_srv, meSrvDO.getName());
			break;
		case IBdPrimdCodeConst.CODE_PRI_FREE:
			break;
		case IBdPrimdCodeConst.CODE_PRI_PLUGIN:
			break;
		case IBdPrimdCodeConst.CODE_PRI_RES:
			break;
		}
		return b;
	}

	/**
	 * 本服务定价服务费用校验
	 * 
	 * @param meSrvDO
	 * @param id_srv
	 * @return
	 * @throws BizException 
	 */
	private boolean judgeSrvBL_Srv_This(MedSrvDO meSrvDO, String id_srv) throws BizException {
		
		if (meSrvDO.getDs().equals(1)) {
			String msg=getOpenItemMaintainerValidate();
			mapResult.put(id_srv, String.format(STR_SRV_BL_VAL+msg, meSrvDO.getName()));
			mapMeSrvDOs_Checked.remove(id_srv);
			return false;
		}
		if(!FBoolean.TRUE.equals(meSrvDO.getFg_mm()) && FBoolean.TRUE.equals(meSrvDO.getFg_bl()) && !FBoolean.TRUE.equals(meSrvDO.getFg_active_bl())){
			mapResult.put(id_srv, String.format("【%s】费用项目未启用(可能原因：本服务、组合定价、套内项目未启用)",meSrvDO.getName()));
			mapMeSrvDOs_Checked.remove(id_srv);
			return false;
		}
		return true;
	}

	/**
	 * 组合计价服务费用校验
	 * 
	 * @param id_srv_itm
	 * @param id_srv
	 * @return
	 * @throws BizException
	 */
	private boolean judgeSrvBL_Srv_Comp(PriSrvCompDO[] priSrvCompDOs, String id_srv, String name) throws BizException {
		ArrayList<String> id_srv_bls = new ArrayList<String>();
		if (null != priSrvCompDOs && 0 < priSrvCompDOs.length) {
			for (PriSrvCompDO priSrvCompDO : priSrvCompDOs)
				id_srv_bls.add(priSrvCompDO.getId_srv_bl());
		}

		return judgeSrvBL_Srvset_item(id_srv, name, id_srv_bls);
	}

	/**
	 * 套服务费用校验
	 * 
	 * @param meSrvDO
	 * @param id_srv
	 * @throws BizException
	 */
	private void judgeSrvBL_Srvset(MedSrvDO meSrvDO, String id_srv, MedSrvSetItemDO[] medSrvSetItemDOs,
			PriSrvSetMuDO[] priSrvSetMuDOs, PriSrvSetFixDO[] priSrvSetFixDOs) throws BizException {
		boolean isAmount = false;
		switch (meSrvDO.getSd_primd()) {
		case IBdPrimdCodeConst.CODE_PRI_SRVSET_AMOUNT:// 成员合计
			isAmount = true;
			break;
		case IBdPrimdCodeConst.CODE_PRI_SRVSET_MU:// 个数加收
			if (!judgeSrvBL_Srvset_Mu(id_srv, meSrvDO.getName(), priSrvSetMuDOs))
				return;
			break;
		case IBdPrimdCodeConst.CODE_PRI_SRVSET_FIX:// 个数定价
			if (!judgeSrvBL_Srvset_Fix(id_srv, meSrvDO.getName(), priSrvSetFixDOs))
				return;
			break;
		}

		List<String> idSrvItmList = new ArrayList<String>();
		for (MedSrvSetItemDO medSrvSetItemDO : medSrvSetItemDOs) {
			if (isAmount)
				idSrvItmList.add(medSrvSetItemDO.getId_srv_itm());
			else {
				// 非临床项目明细
				if (null == medSrvSetItemDO.getFg_clinical() || !medSrvSetItemDO.getFg_clinical().booleanValue())
					idSrvItmList.add(medSrvSetItemDO.getId_srv_itm());
			}
		}
		if (idSrvItmList.size() > 0) {

			PriSrvCompDO[] allPriSrvCompDOs = getPriSrvCompDOs(idSrvItmList);
			Map<String, List<PriSrvCompDO>> mapPriSrvCompDOs = new HashMap<String, List<PriSrvCompDO>>();
			if (allPriSrvCompDOs != null && allPriSrvCompDOs.length > 0) {
				for (PriSrvCompDO item : allPriSrvCompDOs) {
					if (mapPriSrvCompDOs.containsKey(item.getId_srv())) {
						mapPriSrvCompDOs.get(item.getId_srv()).add(item);
					} else {
						List<PriSrvCompDO> lst = new ArrayList<PriSrvCompDO>();
						lst.add(item);
						mapPriSrvCompDOs.put(item.getId_srv(), lst);
					}
				}
			}

			// 获取校验数据集合
			MedSrvDO[] itmMeSrvDOs = getMedSrvDOs(idSrvItmList);
			if (null != itmMeSrvDOs && 0 < itmMeSrvDOs.length) {
				for (MedSrvDO itmMeSrvDO : itmMeSrvDOs) {
					if (!judgeSrvBL_Srv(itmMeSrvDO, id_srv, mapPriSrvCompDOs.get(id_srv) == null ? null
							: mapPriSrvCompDOs.get(itmMeSrvDO.getId_srv()).toArray(new PriSrvCompDO[] {})))
						return;
				}
			}
		}
	}

	/**
	 * 套服务个数加收计价费用校验
	 * 
	 * @param id_srv
	 * @return
	 * @throws BizException
	 */
	private boolean judgeSrvBL_Srvset_Mu(String id_srv, String name, PriSrvSetMuDO[] priSrvSetMuDOs)
			throws BizException {
		ArrayList<String> id_srv_mus = new ArrayList<String>();
		if (null != priSrvSetMuDOs && 0 < priSrvSetMuDOs.length) {
			for (PriSrvSetMuDO priSrvSetMuDO : priSrvSetMuDOs) {
				if(!id_srv_mus.contains(priSrvSetMuDO.getId_srvadd()))
				id_srv_mus.add(priSrvSetMuDO.getId_srvadd());
			}
		}

		return judgeSrvBL_Srvset_item(id_srv, name, id_srv_mus);
	}

	/**
	 * 套服务个数定价费用校验
	 * 
	 * @param id_srv
	 * @return
	 * @throws BizException
	 */
	private boolean judgeSrvBL_Srvset_Fix(String id_srv, String name, PriSrvSetFixDO[] priSrvSetFixDOs)
			throws BizException {
		ArrayList<String> id_srv_fixs = new ArrayList<String>();
		if (null != priSrvSetFixDOs && 0 < priSrvSetFixDOs.length) {
			for (PriSrvSetFixDO priSrvSetFixDO : priSrvSetFixDOs) {
				id_srv_fixs.add(priSrvSetFixDO.getId_srvadd());
			}
		}

		return judgeSrvBL_Srvset_item(id_srv, name, id_srv_fixs);
	}

	/**
	 * 费用项目停用校验
	 * 
	 * @param id_srv
	 * @param name
	 * @param id_srvs
	 * @return
	 * @throws BizException
	 */
	private boolean judgeSrvBL_Srvset_item(String id_srv, String name, List<String> idSrvList) throws BizException {
		String msg=getOpenItemMaintainerValidate();
		if (0 < idSrvList.size()) {
			MedSrvDO[] blMeSrvDOs = getMedSrvDOs(idSrvList);
			if (null != blMeSrvDOs && 0 < blMeSrvDOs.length) {

				for (MedSrvDO blMeSrvDO : blMeSrvDOs) {
					if (blMeSrvDO.getDs().equals(1)) {
						mapResult.put(id_srv, String.format(STR_SRV_BL_VAL+msg, name));
						mapMeSrvDOs_Checked.remove(id_srv);
						return false;
					}
					if(!FBoolean.TRUE.equals(blMeSrvDO.getFg_mm()) && FBoolean.TRUE.equals(blMeSrvDO.getFg_bl()) && !FBoolean.TRUE.equals(blMeSrvDO.getFg_active_bl())){
						mapResult.put(id_srv, String.format("【%s】费用项目未启用(可能原因：本服务、组合定价、套内项目未启用)",blMeSrvDO.getName()));
						mapMeSrvDOs_Checked.remove(id_srv);
						return false;
					}
					idSrvList.remove(blMeSrvDO.getId_srv());
				}
			}
		}
		if (0 < idSrvList.size()) {
			mapResult.put(id_srv, String.format(STR_SRV_BL_VAL+msg, name));
			mapMeSrvDOs_Checked.remove(id_srv);
			return false;
		}

		return true;
	}

	/**
	 * 医疗服务
	 * 
	 * @param ids
	 * @return
	 * @throws BizException
	 */
	private MedSrvDO[] getMedSrvDOs(List<String> idSrvList) throws BizException {
		MedSrvDO[] rtn = null;
		if (idSrvList != null && idSrvList.size() > 0) {
			GetMedSrvDOsQry qry = new GetMedSrvDOsQry(idSrvList);
			rtn = (MedSrvDO[]) AppFwUtil.getDORstWithDao(qry, MedSrvDO.class);
		}

		return rtn;
	}

	/**
	 * 获取物品map集合
	 * 
	 * @param idSrvList
	 *            v
	 * @return key:id_srv, value: 物品List集合
	 * @throws BizException
	 */
	private Map<String, List<MeterialDO>> getMeterialMap(List<String> idSrvList) throws BizException {

		IMeterialMDORService meterialMDORService = (IMeterialMDORService) ServiceFinder
				.find(IMeterialMDORService.class);
		MeterialDO[] meterialDOs = meterialMDORService.findByAttrValStrings("Id_srv",
				idSrvList.toArray(new String[idSrvList.size()]));

		Map<String, List<MeterialDO>> meterialMap = new HashMap<String, List<MeterialDO>>();
		if (meterialDOs != null && meterialDOs.length > 0) {
			for (MeterialDO item : meterialDOs) {
				if (meterialMap.containsKey(item.getId_srv())) {
					meterialMap.get(item.getId_srv()).add(item);
				} else {
					List<MeterialDO> lst = new ArrayList<MeterialDO>();
					lst.add(item);
					meterialMap.put(item.getId_srv(), lst);
				}
			}
		}

		return meterialMap;
	}

	/**
	 * 服务套内项目
	 * 
	 * @param id_srv
	 * @return
	 * @throws BizException
	 */
	private MedSrvSetItemDO[] getMedSrvSetItemDOs(List<String> idSrvList) throws BizException {

		String inWhereStr = this.getInWhereStr("id_srv", idSrvList);

		IMedSrvSetItemDORService medSrvSetItemDORService = (IMedSrvSetItemDORService) ServiceFinder
				.find(IMedSrvSetItemDORService.class);
		MedSrvSetItemDO[] medSrvSetItemDOs = medSrvSetItemDORService.find(inWhereStr, "", FBoolean.FALSE);
		return medSrvSetItemDOs;
	}

	/**
	 * 组合计价策略
	 * 
	 * @param id_srv
	 * @return
	 * @throws BizException
	 */
	private PriSrvCompDO[] getPriSrvCompDOs(List<String> idSrvList) throws BizException {

		String inWhereStr = this.getInWhereStr("id_srv", idSrvList);
		IPrisrvcompRService prisrvcompRService = (IPrisrvcompRService) ServiceFinder.find(IPrisrvcompRService.class);
		PriSrvCompDO[] priSrvCompDOs = prisrvcompRService.find(inWhereStr, "", FBoolean.FALSE);
		return priSrvCompDOs;
	}

	/**
	 * 服务套个数加收策略
	 * 
	 * @param id_srv
	 * @return
	 * @throws BizException
	 */
	private PriSrvSetMuDO[] getPriSrvSetMuDOs(List<String> idSrvList) throws BizException {

		String inWhereStr = this.getInWhereStr("id_srvset", idSrvList);
		IPrisrvsetmuRService prisrvsetmuRService = (IPrisrvsetmuRService) ServiceFinder
				.find(IPrisrvsetmuRService.class);
		PriSrvSetMuDO[] priSrvSetMuDOs = prisrvsetmuRService.find(inWhereStr, "", FBoolean.FALSE);
		return priSrvSetMuDOs;
	}

	/**
	 * 服务套个数定价策略
	 * 
	 * @param id_srv
	 * @return
	 * @throws BizException
	 */
	private PriSrvSetFixDO[] getPriSrvSetFixDOs(List<String> idSrvList) throws BizException {

		String inWhereStr = this.getInWhereStr("id_srvset", idSrvList);

		IPrisrvsetfixRService prisrvsetfixRService = (IPrisrvsetfixRService) ServiceFinder
				.find(IPrisrvsetfixRService.class);
		PriSrvSetFixDO[] priSrvSetFixDOs = prisrvsetfixRService.find(inWhereStr, "", FBoolean.FALSE);
		return priSrvSetFixDOs;
	}

	/**
	 * 	物品绑定时机编码
	 * 
	 * @param code_entp
	 * @param medsrvDO
	 * @return
	 */
	private String getSd_mmbindType(String code_entp, MedSrvDO medsrvDO) {
		String value = "";
		switch (code_entp) {
		case IBdFcDictCodeConst.SD_CODE_ENTP_OP:
			value = medsrvDO.getSd_mmbind_op();
			break;
		case IBdFcDictCodeConst.SD_CODE_ENTP_ET_FLOW:
			value = medsrvDO.getSd_mmbind_er();
			break;
		case IBdFcDictCodeConst.SD_CODE_ENTP_ET_FSTAID:
			value = medsrvDO.getSd_mmbind_er();
			break;
		case IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS:
			value = medsrvDO.getSd_mmbind_er();
			break;
		case IBdFcDictCodeConst.SD_CODE_ENTP_IP:
			value = medsrvDO.getSd_mmbind_ip();
			break;
		case IBdFcDictCodeConst.SD_CODE_ENTP_FA:
			value = medsrvDO.getSd_mmbind_fm();
			break;
		case IBdFcDictCodeConst.SD_CODE_ENTP_PE:
			value = medsrvDO.getSd_mmbind_pe();
			break;

		}

		return value;
	}

	/**
	 * 当id集合查询大于1000时，拆分成多个in查询条件
	 * 
	 * @param filterColumn
	 *            待过滤的字段
	 * @param idList
	 *            id集合
	 * @return in查询语句，结构 filterColumn in (....) or filterColumn in (....)
	 */
	private String getInWhereStr(String filterColumn, List<String> idList) {

		String idSql = " or " + filterColumn + " in (%s)";

		StringBuffer whereStr = new StringBuffer();
		StringBuffer sqlBuffer = new StringBuffer();

		for (int i = 0; i < idList.size(); i++) {
			String id_srv = idList.get(i);
			sqlBuffer.append(",'" + id_srv + "'");
			if ((i > 0 && i % 900 == 0) || i == idList.size() - 1) {
				whereStr.append(String.format(idSql, sqlBuffer.substring(1)));
				sqlBuffer.setLength(0);
			}
		}

		return whereStr.substring(3);
	}
}
