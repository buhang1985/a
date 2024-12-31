package iih.en.pv.s.bp.ip.qry;

import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeTypeConst;
import iih.bd.bc.udi.pub.IPiDictCodeTypeConst;
import iih.en.comm.custom.EnIpCustomServiceUtils;
import iih.en.comm.ep.EnTagtpEP;
import iih.en.comm.ep.EntStateEP;
import iih.en.comm.util.EnAgeCalcUtil;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnFMapUtils;
import iih.en.comm.util.EnLogUtil;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.enclin.d.EntStateDO;
import iih.en.pv.enfee.dto.d.BalanceDTO;
import iih.en.pv.inpatient.dto.d.PatientsDTO;
import iih.en.pv.s.bp.ip.CalculateHosDaysBP;
import iih.en.pv.s.bp.ip.GetBalanceBP;
import iih.pi.overview.overview.d.PiPatAlDO;
import iih.pi.overview.overview.i.IPiPatAlDORService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.transaction.TransactionStatus;

import xap.mw.core.data.BizException;
import xap.mw.core.data.BizRuntimeException;
import xap.mw.jdbc.tx.TransactionExecutor;
import xap.mw.jdbc.tx.TransactionalOperation;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.dataaccess.TmpTableFactory;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.xbd.udi.d.UdidocDO;
import xap.sys.xbd.udi.i.IUdidocServiceExt;

/**
 * 得到住院医生站患者列表
 * 
 * @author Liubin
 * 
 */
public class GetIpDocStationPatsBP {
	
	private boolean isOutHostPat = false;
	
	public GetIpDocStationPatsBP(){
	}
	
	public GetIpDocStationPatsBP(boolean isOutHostPat){
		this.isOutHostPat = isOutHostPat;
	}

	/**
	 * 根据就诊ID集合得到患者DTO集合
	 * 
	 * @param entIdArray
	 * 		就诊ID集合
	 * @return
	 * @throws BizException 
	 */
	public PatientsDTO[] exec(String[] entIdArray, String empId) throws BizException{
		if(!EnValidator.isEmpty(entIdArray)){
			return queryDTO(Arrays.asList(entIdArray), empId, null);
		}
		return null;
	}
	/**
	 * 根据就诊ID集合得到患者DTO集合
	 * 
	 * @param entIdList
	 * 		就诊ID集合
	 * @return
	 * @throws BizException 
	 */
	public PatientsDTO[] exec(List<String> entIdList, String empId) throws BizException{
		if(!EnValidator.isEmpty(entIdList)){
			return queryDTO(entIdList, empId, null);
		}
		return null;
	}
	/**
	 * 根据就诊ID集合得到患者DTO集合
	 * 
	 * @param entIdArray
	 * 		就诊ID集合
	 * @param extraWhere
	 * 		附加的查询条件
	 * @return
	 * @throws BizException 
	 */
	public PatientsDTO[] exec(String[] entIdArray, String empId, String extraWhere) throws BizException{
		if(!EnValidator.isEmpty(entIdArray)){
			return queryDTO(Arrays.asList(entIdArray), empId, extraWhere);
		}
		return null;
	}
	/**
	 * 根据就诊ID集合得到患者DTO集合
	 * 
	 * @param entIdList
	 * 		就诊ID集合
	 * @param extraWhere
	 * 		附加的查询条件
	 * @return
	 * @throws BizException 
	 */
	public PatientsDTO[] exec(List<String> entIdList, String empId, String extraWhere) throws BizException{
		if(!EnValidator.isEmpty(entIdList)){
			return queryDTO(entIdList, empId, extraWhere);
		}
		return null;
	}
	/**
	 * 根据就诊ID集合得到患者DTO集合
	 * 
	 * @param entIdList
	 * @param extraWhere
	 * @return
	 * @throws BizException
	 */
	private PatientsDTO[] queryDTO(List<String> entIdList, String empId, String extraWhere) throws BizException
	{
		long b = System.currentTimeMillis();
		if(EnValidator.isEmpty(entIdList))
			return null;
		List<PatientsDTO> list = queryByTempTable(entIdList, empId, extraWhere);
		if(EnValidator.isEmpty(list))
			return null;
		//性别
		Map<String, UdidocDO> sexMap = getUdiMap(IPiDictCodeTypeConst.SD_SEX_CODE);
		//病情等级
		Map<String, UdidocDO> diseLevelMap = getUdiMap(IEnDictCodeTypeConst.SD_STATUS_DISE);
		//护理等级
		Map<String, UdidocDO> nurLevelMap = getUdiMap(IEnDictCodeTypeConst.SD_STATUS_NUR);
		//就诊状况
		Map<String,Map<String, EntStateDO>> statesMap = new EntStateEP().getEntStateDOMap(entIdList.toArray(new String[0]), null);
		//患者标签
		//Map<String, String> tabMap = new EnTagtpEP().getTagTpStr(entIdList.toArray(new String[0]));
		new EnTagtpEP().essemly(list.toArray(new PatientsDTO[0]), "Id_ent", "Code_pat_pag", "Name_pat_pag");
		CalculateHosDaysBP daysBp  = new CalculateHosDaysBP();
		//设置金额信息 zhangpp 2019-6-13
		Map<String, BalanceDTO> balenceMap = new HashMap<>();
		BalanceDTO[] balences = new GetBalanceBP().exec(entIdList.toArray(new String[0]));
		if(!EnValidator.isEmpty(balences)){
			for(BalanceDTO balence : balences)
				balenceMap.put(balence.getId_ent(), balence);
		}
		
		for(PatientsDTO pat : list){
			//性别
			if(sexMap.containsKey(pat.getSd_sex_pat())){
				pat.setSex_pat(sexMap.get(pat.getSd_sex_pat()).getName());
			}
			//年龄
			/*if(pat.getDt_birth_hms()!=null){
				pat.setAge(AgeCalcUtil.getAge(pat.getDt_birth_hms()));
			}*/
			//病情等级
			if(diseLevelMap.containsKey(pat.getSd_level_dise()))
				pat.setName_level_dise(diseLevelMap.get(pat.getSd_level_dise()).getName());
			//护理等级
			if(nurLevelMap.containsKey(pat.getSd_level_nur()))
				pat.setName_level_nur(nurLevelMap.get(pat.getSd_level_nur()).getName());
			//就诊状况
			if(statesMap!=null && statesMap.containsKey(pat.getId_ent())){
		    	pat.setEnstatelist(EnAppUtils.doArray2List(statesMap.get(pat.getId_ent()).values().toArray(new EntStateDO[0])));
			}
			//患者标签
			//if(tabMap != null && tabMap.containsKey(pat.getId_ent()))
			//	pat.setName_pat_pag(tabMap.get(pat.getId_ent()));
			//设置住院天数
			pat.setInhosdays(String.format("%s天", daysBp.calculate(pat.getDt_acpt(), pat.getDt_end(), pat.getFg_ip())));
			//设置金额信息
			if(balenceMap.containsKey(pat.getId_ent())){
				BalanceDTO balence = balenceMap.get(pat.getId_ent());
				pat.setAmt_cred(balence.getAmt_cred());
				pat.setAmt_prepay(balence.getAmt_prepay());
				pat.setAmt_uncg(balence.getAmt_uncg());
				pat.setBalance(balence.getAmt_bal());
				pat.setAmt_hp(balence.getAmt_hp());
			}
		}
		//设置年龄
		EnAgeCalcUtil.setDoAges(list.toArray(new PatientsDTO[]{}), "Id_ent", "Age");
		//设置过敏史 zhangpp 2019-6-13
		this.handleAllergy(entIdList, list.toArray(new PatientsDTO[0]));
		long e = System.currentTimeMillis();
		EnLogUtil.getInstance().logInfo(String.format("住院患者列表-查询信息耗时:%s", e -b));
		PatientsDTO[] pats = EnValidator.isEmpty(list) ? null : list.toArray(new PatientsDTO[0]);
		EnIpCustomServiceUtils.handleIpPatients(pats);
		return pats;
	}
	/**
	 * 根据就诊ID集合得到患者DTO集合
	 * 
	 * @param entIdList
	 * @param extraWhere
	 * @return
	 * @throws BizException
	 */
	private List<PatientsDTO> queryByTempTable(final List<String> entIdList, final String empId, final String extraWhere) throws BizException
	{
		if(EnValidator.isEmpty(entIdList))
			return null;
		return TransactionExecutor.executeRequired(new TransactionalOperation<List<PatientsDTO>>() {
			@Override
			public List<PatientsDTO> doInTransaction(TransactionStatus status) {
				String tmpTableName = null;
			    try{
			    	// 生成临时表
				    tmpTableName = new TmpTableFactory().get(entIdList.toArray(new String[0]));
					// 查询数据
				    return getDatas(empId, extraWhere, tmpTableName);
			    }catch (BizException e) {
					throw new BizRuntimeException(e.getMessage());
				}
			}
		});
	}
	
	/**
	 * 查询数据
	 * 
	 * @param extraWhere
	 * @param tmpTableName
	 * @return
	 * @throws BizException
	 */
	private List<PatientsDTO> getDatas(String empId, String extraWhere,String tmpTableName) throws BizException{
		StringBuilder builder = new StringBuilder();
		SqlParam param = new SqlParam();
		builder.append("SELECT ");
		builder.append("EN.ID_ENT AS ID_ENT,"); //就诊ID
		builder.append("EN.DT_ACPT AS DT_ACPT,"); //入科时间
		builder.append("EN.NAME_PAT AS NAME_PAT,"); //姓名
		builder.append("EN.ID_DEP_PHY AS ID_DEP_PHY,"); //科室id
		builder.append("EN.ID_EMP_PHY AS ID_EMP_PHY,"); //责任医生id
		builder.append("EN.ID_PAT AS ID_PAT,"); //患者ID
		builder.append("EN.ID_ENTP AS ID_ENTP,"); //就诊类型ID
		builder.append("EN.CODE_ENTP AS CODE_ENTP,"); //就诊类型Code
		builder.append("EN.ID_SEX_PAT AS ID_SEX_PAT,"); //性别ID
		builder.append("EN.SD_SEX_PAT AS SD_SEX_PAT,"); //性别编码
		builder.append("EN.DT_BIRTH_PAT AS DT_BIRTH_PAT,");//出生日期
		builder.append("EN.ID_WG_PHY AS ID_WG_PHY,"); //医疗组
		builder.append(" WG.NAME AS NAME_WG_PHY, ");//医疗组名称
		builder.append("EN.ID_DEP_NUR AS ID_DEP_NUR,"); //病区
		builder.append("EN.ID_HP AS ID_HP,");//医保计划ID
		builder.append("EN.ID_PATCA AS ID_PATCA,");//患者分类
		builder.append("EN.DT_END AS DT_END,");//出院时间
		builder.append("EN.FG_IP,");//在院标志
		builder.append(" CASE WHEN EN.CODE_HPMEDKIND = '" + IEnDictCodeConst.SD_SINGLEDRGS + "' THEN '单' ELSE '' END AS FG_SINGLEDRGS, ");//单病种
		//builder.append("PI_PAT.PHOTO AS PHOTO, ");
		builder.append("PAT.DT_BIRTH_HMS AS DT_BIRTH_HMS, ");
		builder.append("IP.CODE_AMR_IP AS CODE,"); //住院号
		builder.append("IP.NAME_BED AS NAME_BED,"); //床位
		builder.append("IP.ID_BED AS ID_BED,"); //床位ID
		builder.append("IP.SD_LEVEL_DISE AS SD_LEVEL_DISE,"); //病情级别
		builder.append("IP.EU_INCP STATUS_INCP,");//是否在临床路径中
		builder.append("DI.Name_didef_dis AS NAME_DI,");//诊断名称
		builder.append("DI.Sd_cdsystp AS Sd_disunjtp,");//诊断类型
		//builder.append("itm.id_didef_name as AS NAME_DI,");
		//builder.append("itm.sd_disys AS Sd_disunjtp,");
		builder.append("HP.NAME AS NAME_HP,");//医保计划
		builder.append("NVL(ACC.AMT_TOTAL,0) AS AMT,");//费用
		builder.append("PSN.NAME AS NAME_EMP_PHY,");//责任医生
		builder.append(" IP.FG_NEWBORN AS FG_NB, ");//是否婴儿
		builder.append(" nurpsn.name as name_emp_nur, ");//责任护士
		builder.append("PCA.NAME AS NAME_PATCA,");//患者分类ID
		builder.append("DEP.NAME AS NAME_DEP_PHY,");//患者分类ID
		builder.append("NUR.NAME AS NAME_DEP_NUR,");//患者分类ID
		builder.append(" IP.ID_LEVEL_NUR,");//护理级别ID;
		builder.append(" IP.SD_LEVEL_NUR,");//护理级别SD;
		builder.append(" ENENTHP.NO_HP,");//医保号
		builder.append(" ENENTHP.FG_FUNDPAY,");//基金支付标志
		builder.append(" ENENTHP.FG_HP_CARD,");//持卡标志
		builder.append(" ENENTHP.FG_HPSPCL,");//特病标志
		builder.append(" HPPATCA.NAME_HPPATCA,");//医保身份
		builder.append(" HPKIND.NAME_HPKIND,");//险种名称
		builder.append("(CASE WHEN EXISTS(SELECT FLW.ID_ENTFLW FROM EN_ENT_FLW FLW WHERE FLW.ID_ENT = EN.ID_ENT AND FLW.ID_EMP = ? ) THEN 'Y' ELSE 'N' END) AS FG_ISMARK ");
		builder.append("FROM EN_ENT EN "); //
		builder.append("INNER JOIN ").append(tmpTableName).append(" TEMPTABLE ON EN.ID_ENT = TEMPTABLE.ID1 ");
		builder.append("INNER JOIN PI_PAT PI_PAT ON EN.ID_PAT = PI_PAT.ID_PAT ");
		builder.append("INNER JOIN EN_ENT_IP IP ON EN.ID_ENT = IP.ID_ENT ");
		builder.append("LEFT JOIN BD_HP HP ON EN.ID_HP = HP.ID_HP ");
		builder.append("LEFT JOIN PI_PAT_CA PCA ON EN.ID_PATCA = PCA.ID_PATCA ");
		builder.append("LEFT JOIN PI_PAT PAT ON EN.ID_PAT = PAT.ID_PAT ");
		builder.append("LEFT JOIN BD_DEP DEP ON EN.ID_DEP_PHY = DEP.ID_DEP ");
		builder.append("LEFT JOIN BD_PSNDOC PSN ON EN.ID_EMP_PHY = PSN.ID_PSNDOC ");
		builder.append(" left join bd_psndoc nurpsn on EN.id_emp_nur = nurpsn.id_psndoc ");
		builder.append("LEFT JOIN BD_DEP NUR ON EN.ID_DEP_NUR = NUR.ID_DEP ");
		builder.append("LEFT JOIN EN_ENT_DI DI ON EN.ID_ENT = DI.ID_ENT AND DI.FG_MAJ = 'Y' ");
		//builder.append("left join (select c.id_di,c.id_en,row_number() over(partition by c.id_en order by c.dt_sign desc) rn from ci_di c ) di on di.id_en=en.id_ent and di.rn=1 ");
		//builder.append("left join ci_di_itm itm on itm.id_di = di.id_di and itm.fg_majdi = 'Y' ");
		builder.append("LEFT JOIN EN_ENT_ACC ACC ON EN.ID_ENT = ACC.ID_ENT ");
		builder.append("LEFT JOIN BD_BED BED ON IP.ID_BED = BED.ID_BED ");
		builder.append("LEFT JOIN EN_ENT_HP ENENTHP ON ENENTHP.ID_HP = EN.ID_HP AND ENENTHP.ID_ENT = EN.ID_ENT ");
		builder.append("LEFT JOIN BD_HP_PATCA HPPATCA ON HPPATCA.ID_HP = EN.ID_HP AND HPPATCA.CODE_HPPATCA = ENENTHP.CODE_HPPATCA ");
		builder.append("LEFT JOIN BD_HP_KIND HPKIND ON HPKIND.ID_HP = EN.ID_HP AND HPKIND.CODE_HPKIND = ENENTHP.CODE_HPKIND ");
		builder.append(" LEFT JOIN BD_WG WG ON WG.ID_WG = EN.ID_WG_PHY ");
		if(!EnValidator.isEmpty(extraWhere)){
			builder.append(" WHERE ").append(extraWhere).append(" ");
		}
		if(isOutHostPat){
			builder.append("ORDER BY EN.DT_END ");
		}else{
			builder.append("ORDER BY ID_DEP_NUR, BED.SD_BEDTP, NAME_BED, CODE, DT_ACPT ");
		}
		String sql = builder.toString();
		param.addParam(empId);
		return (List<PatientsDTO>) new DAFacade().execQuery(sql, param, new BeanListHandler(PatientsDTO.class));
	}

	/**
	 * 获取自定义档案map
	 * 
	 * @param codetp
	 * @return
	 * @throws BizException
	 */
	private Map<String, UdidocDO> getUdiMap(String codetp) throws BizException{
		IUdidocServiceExt serv = ServiceFinder.find(IUdidocServiceExt.class);
		UdidocDO[] udis = serv.findByUdidoclistCode(codetp);
		Map<String, UdidocDO> map = new HashMap<>();
		if(!EnValidator.isEmpty(udis)){
			for(UdidocDO udi : udis){
				map.put(udi.getCode(), udi);
			}
		}
		return map;
	}
	
	/**
	 * 处理过敏史
	 * @param entIdList
	 * @param patientsDTOs
	 * @throws BizException
	 */
	private void handleAllergy(List<String> entIdList,PatientsDTO[] patientsDTOs) throws BizException{
		if(patientsDTOs == null || patientsDTOs.length <= 0)
			return;
		List<String> patIdlist = new ArrayList();
		for(PatientsDTO dto: patientsDTOs){
			if(!EnValidator.isEmpty(dto.getId_pat()) && !patIdlist.contains(dto.getId_pat())){
				patIdlist.add(dto.getId_pat());
			}
		}
		if(patIdlist == null || patIdlist.size() <= 0)
			return;
		IPiPatAlDORService serv = ServiceFinder.find(IPiPatAlDORService.class);
		PiPatAlDO[] alDos = serv.findByAttrValStrings(PiPatAlDO.ID_PAT, patIdlist.toArray(new String[0]));
		if(EnValidator.isEmpty(alDos))
			return;
		Map<String, List<PiPatAlDO>> map = EnFMapUtils.getMapList(PiPatAlDO.ID_PAT, alDos);
		for(PatientsDTO card : patientsDTOs){
			if(!EnValidator.isEmpty(card.getId_pat())
					&& map != null && map.containsKey(card.getId_pat())){
				List<PiPatAlDO> patAls = map.get(card.getId_pat());
				if(EnValidator.isEmpty(patAls))
					continue;
				StringBuilder allergy = new StringBuilder();
				boolean isFirst = true;
				for (PiPatAlDO piPatAlDO : patAls) {
					String val = null;
					if (!EnValidator.isEmpty(piPatAlDO.getMm_name())) {
						val = piPatAlDO.getMm_name();
					}else {
						val = piPatAlDO.getName_alcla();
					}
					if(EnValidator.isEmpty(val))
						continue;
					if(!isFirst){
						allergy.append(",");
					}else{
						isFirst = false;
					}
					allergy.append(val);
				}
				card.setPat_alcla(allergy.toString());
			}
		}
	}
}
