package iih.ei.std.s.v1.bp.mp.lisdata;

import iih.bd.base.utils.ArrayListUtil;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBlDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bl.cg.i.IBlCgValidateService;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ciorder.i.ICiorderMDORService;
import iih.ci.ord.ciorder.i.IOrdSrvDORService;
import iih.ei.std.d.v1.mp.lisdata.d.LabApDTO;
import iih.ei.std.d.v1.mp.lisdata.d.LabApplyInfoSqlRstDTO;
import iih.ei.std.d.v1.mp.lisdata.d.LabItemDTO;
import iih.ei.std.d.v1.mp.lisdata.d.LabParamDTO;
import iih.ei.std.d.v1.mp.lisdata.d.LabPatinfoDTO;
import iih.ei.std.d.v1.mp.lisdata.d.LabPatinfoResultDTO;
import iih.ei.std.s.v1.bp.common.EiParamUtils;
import iih.ei.std.s.v1.bp.mp.lisdata.qry.QueryIPLabAPSql;
import iih.ei.std.s.v1.bp.mp.lisdata.qry.QueryOPLabApSql;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PiPatCardDO;
import iih.pi.reg.pat.d.PiPatHpDO;
import iih.pi.reg.pat.i.IPatiMDORService;
import iih.pi.reg.pat.i.IPiPatCardDORService;
import iih.pi.reg.pat.i.IPiPatHpDORService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.utils.AppFwUtil;
/**
 * 
* @ClassName: QueryLabDataBp
* @Description: 查询检验申请单
* @author zhy
* @date 2019年9月27日
*
 */
public class QueryLabDataBp {
	
	private String patID;
	
	/**
	 * 程序主入口
	 * @param param
	 * @return
	 * @throws BizException 
	 */
	public LabPatinfoResultDTO exec(LabParamDTO param) throws BizException {
		
		// 1.获取就诊类型
		String code_entp = param.getCode_entp();
		
		// 2.查询数据
		LabApplyInfoSqlRstDTO[] sqlRstDTOs = queryData(code_entp,param);
		if (null == sqlRstDTOs || sqlRstDTOs.length < 1) {
			return null;
		}
		
		// 2.5 赋值患者就诊卡号
		addCodeCard(sqlRstDTOs);
		
		// 3.获取医嘱ID集合
		String[] idors = getIdors(sqlRstDTOs); 
		
		// 4.查询收费项目
		List<LabApplyInfoSqlRstDTO> items = getItems(idors);
		
		// 5.获取医嘱id与收费项目集合的映射关系
		Map<String, FArrayList> itemMap = getItemMap(items);
		
		// 6.维度拆分
		LabPatinfoDTO[] patients = ConVerToLevel(sqlRstDTOs,itemMap);
		
		LabPatinfoResultDTO resultDTO = new LabPatinfoResultDTO();
		resultDTO.setLabpatinfo(ArrayListUtil.ConvertToFArrayList(patients));
		return resultDTO;
	}

	


	/**
	 * 查询检验申请单数据
	 * @param code_entp
	 * @param param
	 * @return
	 * @throws BizException 
	 */
	private LabApplyInfoSqlRstDTO[] queryData(String code_entp, LabParamDTO param) throws BizException {

		// 住院
		if (IBdFcDictCodeConst.SD_CODE_ENTP_IP.equals(code_entp)) {
			//获取患者id(无患者信息可以查询病区数据)
		    patID = getPatID(param.getCode(),param.getNo_applyform());
			if ((null != param.getCode() || null != param.getNo_applyform()) && StringUtil.isEmptyWithTrim(patID) ) {
				throw new BizException("未查询到患者信息");
			}
			QueryIPLabAPSql sql = new QueryIPLabAPSql(param, patID);
			return (LabApplyInfoSqlRstDTO[]) AppFwUtil.getDORstWithDao(sql,LabApplyInfoSqlRstDTO.class);
			
		}
		
		// 门诊
		if (IBdFcDictCodeConst.SD_CODE_ENTP_OP.equals(code_entp)) {
			return querOPData(param);
		}
		
		return null;
	}
	
	

	/**
	 * 获取患者id
	 * @param code
	 * @param no_applyform
	 * @return
	 * @throws BizException 
	 */
	private String getPatID(String code, String no_applyform) throws BizException {
		
		if(!StringUtil.isEmptyWithTrim(no_applyform)){
			CiOrderDO[] ords = ServiceFinder.find(ICiorderMDORService.class).findByAttrValString(CiOrderDO.APPLYNO, no_applyform);
			if (ords != null && ords.length > 0) {
				return ords[0].getId_pat();
			}
		}
		
		// 按使用频次查询
		if (!StringUtil.isEmptyWithTrim(code)) {
			
			// 1.申请单号
			CiOrderDO[] ords = ServiceFinder.find(ICiorderMDORService.class).findByAttrValString(CiOrderDO.APPLYNO, code);
			if (ords != null && ords.length > 0) {
				return ords[0].getId_pat();
			}
			
			// 2.卡号
			PiPatCardDO[] patcardDOs = ServiceFinder.find(IPiPatCardDORService.class).findByAttrValString(PiPatCardDO.CODE, code);
			if (patcardDOs != null && patcardDOs.length > 0) {
				return patcardDOs[0].getId_pat();
			}
			
			// 3.医保卡号
			PiPatHpDO[] hpDOs = ServiceFinder.find(IPiPatHpDORService.class).findByAttrValString(PiPatHpDO.NO_HP, code);
			if (hpDOs != null && hpDOs.length > 0) {
				return hpDOs[0].getId_pat();
			}
	
			// 4.身份证号
			PatDO[] patDOS = ServiceFinder.find(IPatiMDORService.class).findByAttrValString(PatDO.ID_CODE, code);
			if (patDOS != null && patDOS.length > 0) {
				return patDOS[0].getId_pat();
			}
	
			// 5.患者编码
			PatDO[] patDObycode = ServiceFinder.find(IPatiMDORService.class).findByAttrValString(PatDO.CODE, code);
			if (patDObycode != null && patDObycode.length > 0) {
				return patDObycode[0].getId_pat();
			}
	
			// 6.身份证chis码
			PatDO[] patDObyBar = ServiceFinder.find(IPatiMDORService.class).findByAttrValString(PatDO.BARCODE_CHIS, code);
			if (patDObyBar != null && patDObyBar.length > 0) {
				return patDObyBar[0].getId_pat();
			}
		}
		return null;
	}
	
	/**
	 * 查询处理门诊检验数据
	 * @param param
	 * @return
	 * @throws BizException 
	 */
	private LabApplyInfoSqlRstDTO[] querOPData(LabParamDTO param) throws BizException {
		// 获取患者id
	    patID = getPatID(param.getCode(),param.getNo_applyform());
		if (StringUtil.isEmptyWithTrim(patID)) {
			throw new BizException("没有找到对应患者信息!");
		}
		
		QueryOPLabApSql sql = new QueryOPLabApSql(param, patID);
		LabApplyInfoSqlRstDTO[] doRstWithDao = (LabApplyInfoSqlRstDTO[]) AppFwUtil.getDORstWithDao(sql, LabApplyInfoSqlRstDTO.class);
		
		//预交金收费流程模式是执行计费不过滤计费状态
		IBlCgValidateService setService = ServiceFinder.find(IBlCgValidateService.class);
		String[] idors = getIdors(doRstWithDao);
		Map<String, FBoolean> map = setService.orHasSettled(idors);
		
		//过滤结算后的数据
		LabApplyInfoSqlRstDTO[] rtnSettledDtos = filterSettled(doRstWithDao,map);
		if (IBlDictCodeConst.PARAM_VALUE_EXECACCOUNT.equals(EiParamUtils.BLCG0002())) {
			return rtnSettledDtos;
		}
		//过滤返回结果
		LabApplyInfoSqlRstDTO[] rtnDtos = filterRst(doRstWithDao);
		if (null == rtnDtos || rtnDtos.length < 1) {
			return null;
		}
		return rtnDtos;
	}
	
	/**
	 * 过滤结算过的数据
	 * @param doRstWithDao
	 * @param map 
	 * @return 
	 */
	private LabApplyInfoSqlRstDTO[] filterSettled(LabApplyInfoSqlRstDTO[] doRstWithDao, Map<String, FBoolean> map) {
		List<LabApplyInfoSqlRstDTO> reList = new ArrayList<LabApplyInfoSqlRstDTO>();
		if (doRstWithDao != null && doRstWithDao.length > 0) {
			for (LabApplyInfoSqlRstDTO rtn : doRstWithDao) {
				if(ICiDictCodeConst.SD_SU_BL_REFOUND.equals(rtn.getSd_su_bl()) && map.get(rtn.getId_or()).booleanValue()){
					continue;
				}
				reList.add(rtn);
			}
		}
		return reList.toArray(new LabApplyInfoSqlRstDTO[reList.size()]);
		
	}






	/**
	 * 过滤返回结果
	 * @param doRstWithDao
	 * @return
	 */
	private LabApplyInfoSqlRstDTO[] filterRst(LabApplyInfoSqlRstDTO[] rtns) {
		List<LabApplyInfoSqlRstDTO> reList = new ArrayList<LabApplyInfoSqlRstDTO>();
		if (rtns != null && rtns.length > 0) {
			for (LabApplyInfoSqlRstDTO rtn : rtns) {
				if (rtn.getNum_bl() == 0) {
					// 无需计费的医嘱
					reList.add(rtn);
				} else {
					// 需要计费的医嘱
					if (ICiDictCodeConst.SD_SU_BL_ACCOUNT.equals(rtn.getSd_su_bl())) {
						reList.add(rtn);
					}
				}
			}
		}
		return reList.toArray(new LabApplyInfoSqlRstDTO[reList.size()]);
	}
	
	
	/**
	 * 为患者的就诊卡号赋值
	 * @param sqlRstDTOs
	 * @throws BizException 
	 */
	private void addCodeCard(LabApplyInfoSqlRstDTO[] sqlRstDTOs) throws BizException {
		String str  = " id_pat = '" + patID + "'  and fg_act = 'Y' "; 
		PiPatCardDO[] patCardDOs = ServiceFinder.find(IPiPatCardDORService.class).find(str, null, FBoolean.FALSE);
		if (null == patCardDOs || patCardDOs.length < 1) 
			return;
		for (LabApplyInfoSqlRstDTO sqlRstDTO : sqlRstDTOs) {
			sqlRstDTO.setCode_card(patCardDOs[0].getCode());
		}
	}

	/**
	 * 获取医嘱id集合
	 * @param sqlRstDTOs
	 * @return
	 */
	private String[] getIdors(LabApplyInfoSqlRstDTO[] lisDTOs) {
		List<String> idorList = new ArrayList<String>();
		for (LabApplyInfoSqlRstDTO orderInfoforLisDTO : lisDTOs) {
			if (idorList.contains(orderInfoforLisDTO.getId_or())) {
				continue;
			}
			idorList.add(orderInfoforLisDTO.getId_or());
		}
		return idorList.toArray(new String[idorList.size()]);
	}
	
	/**
	 * 获取检验收费项目信息
	 * @param idors
	 * @return
	 * @throws BizException 
	 */
	private List<LabApplyInfoSqlRstDTO> getItems(String[] idors) throws BizException {
		
		List<LabApplyInfoSqlRstDTO> items = new ArrayList<LabApplyInfoSqlRstDTO>();
		IOrdSrvDORService srvDORService = ServiceFinder.find(IOrdSrvDORService.class);
		OrdSrvDO[] itemDtos = srvDORService.findByAttrValStrings(OrdSrvDO.ID_OR, idors);
		if (itemDtos != null && itemDtos.length > 0) {
			for (OrdSrvDO srvDO : itemDtos) {
				LabApplyInfoSqlRstDTO item = new LabApplyInfoSqlRstDTO();
				item.setId_or(srvDO.getId_or());
				item.setCode_srv(srvDO.getCode_srv());// 项目编码
				item.setName_srv(srvDO.getName_srv());// 项目名称
				item.setQuan_medu(srvDO.getQuan_total_medu());// 数量
				item.setPri(srvDO.getPri());// 单价
				item.setSd_su_bl(srvDO.getSd_su_bl());// 收费状态
				if (FBoolean.TRUE.equals(srvDO.getFg_bl())) {
					items.add(item);
				}
			}
		}
		
		return items;
	}
	
	/**
	 * 获取医嘱ID与收费项目集合的映射关系
	 * @param items
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private Map<String, FArrayList> getItemMap(List<LabApplyInfoSqlRstDTO> items) {
		Map<String, FArrayList> map = new HashMap<String, FArrayList>();
		for (LabApplyInfoSqlRstDTO infoforLisDTO : items) {
			LabItemDTO item = new LabItemDTO();
			conVerToItem(item, infoforLisDTO);// 类型转换
			if (map.keySet().contains(infoforLisDTO.getId_or())) {
				map.get(infoforLisDTO.getId_or()).add(item);
			} else {
				FArrayList itemList = new FArrayList();
				itemList.add(item);
				map.put(infoforLisDTO.getId_or(), itemList);
			}
		}
		return map;
	}


	/**
	 * 信息转换
	 * @param item
	 * @param infoforLisDTO
	 */
	private void conVerToItem(LabItemDTO item, LabApplyInfoSqlRstDTO infoforLisDTO) {
		item.setCode_item(infoforLisDTO.getCode_srv());// 项目编码
		item.setName_item(infoforLisDTO.getName_srv());// 项目名称
		item.setQuan_medu(infoforLisDTO.getQuan_medu());// 数量
		item.setPrice(infoforLisDTO.getPri());// 价格
	}

	/**
	 * 维度拆分
	 * @param sqlRstDTOs
	 * @param itemMap
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private LabPatinfoDTO[] ConVerToLevel(LabApplyInfoSqlRstDTO[] sqlRstDTOs, Map<String, FArrayList> itemMap) {
		List<LabPatinfoDTO> reList = new ArrayList<>();
		Map<String, LabPatinfoDTO> mapPatient = new HashMap<>();
		
		for (LabApplyInfoSqlRstDTO sqlRstDTO : sqlRstDTOs) {
			
			//实例化申请单基本信息
			LabApDTO applyform = ConVerApplyform(sqlRstDTO);// 申请单信息
			FArrayList fArrayList = itemMap.get(sqlRstDTO.getId_or());// 申请单的项目信息
			FDouble pri = calPrice(fArrayList);// 计算总价格
			applyform.setPri(pri); //设置申请单价格信息
			applyform.setLabitemdto(fArrayList);
			
			// 根据就诊编号分组
			if (mapPatient.containsKey(sqlRstDTO.getCode_ent())) {
				LabPatinfoDTO patient = mapPatient.get(sqlRstDTO.getCode_ent());
				FArrayList applyformList = patient.getApplyform();
				applyformList.add(applyform);
			} else {
				LabPatinfoDTO patient = new LabPatinfoDTO();
				FArrayList applyformList = new FArrayList();
				ConVerToPatient(patient, sqlRstDTO);// 患者基本信息
				applyformList.add(applyform);
				patient.setApplyform(applyformList);// 设置申请单信息
				mapPatient.put(sqlRstDTO.getCode_ent(), patient);// 记录Patient
				reList.add(patient);// 添加到返回集合中
			}

			
		}
		return reList.toArray(new LabPatinfoDTO[reList.size()]);
	}

	/**
	 * 转换为xml所需层级申请单信息applyform
	 * @param sqlRstDTO
	 * @return
	 */
	private LabApDTO ConVerApplyform(LabApplyInfoSqlRstDTO sqlRstDTO) {
		LabApDTO applyform = new LabApDTO();
		applyform.setNo_applyform(sqlRstDTO.getNo_applyform());// 申请单号
		applyform.setCode_ent(sqlRstDTO.getCode_ent());// 就诊编码，用于做主子关联
		applyform.setCode_or(sqlRstDTO.getCode_or());// 医嘱号
		applyform.setName_applyform(sqlRstDTO.getName_applyform());// 申请项目名称
		applyform.setSd_srvtp(sqlRstDTO.getSd_srvtp());// 申请类别编码
		applyform.setName_srvtp(sqlRstDTO.getName_srvtp());// 申请类别
		applyform.setFg_urgent(sqlRstDTO.getFg_urgent());// 加急标识
		applyform.setName_samptp(sqlRstDTO.getName_samptp());// 标本类型
		applyform.setSd_samptp(sqlRstDTO.getSd_samptp());// 标本类型编码
		applyform.setName_contp(sqlRstDTO.getName_contp());// 容器类型名称
		applyform.setSd_contp(sqlRstDTO.getSd_contp());// 容器类型编码
		applyform.setName_colltp(sqlRstDTO.getName_colltp());// 采集方法
		applyform.setNo_bar(sqlRstDTO.getNo_bar());
		applyform.setSd_colltp(sqlRstDTO.getSd_colltp());// 采集方法编码
		applyform.setDes_labsamp(sqlRstDTO.getDes_labsamp());// 标本说明
		applyform.setCode_dep_app(sqlRstDTO.getCode_dep_app());// 申请科室名
		applyform.setName_dep_app(sqlRstDTO.getName_dep_app());// 申请科室编码
		applyform.setCode_emp_app(sqlRstDTO.getCode_emp_app());// 申请医生编码
		applyform.setName_emp_app(sqlRstDTO.getName_emp_app());// 申请医生名称
		applyform.setDt_app(sqlRstDTO.getDt_app());// 申请时间
		applyform.setCode_dep_mp(sqlRstDTO.getCode_dep_mp());// 执行科室编码
		applyform.setName_dep_mp(sqlRstDTO.getName_dep_mp());// 执行科室名称
		applyform.setNote_app(sqlRstDTO.getNote_app());// 申请备注
		applyform.setCode_srv(sqlRstDTO.getTotal_code_srv());// 申请项目编码
		return applyform;
	}
	
	/**
	 * 计算总价格
	 * @param fArrayList
	 * @return
	 */
	private FDouble calPrice(FArrayList fArrayList) {
		FDouble pri = new FDouble();
		if (fArrayList != null && fArrayList.size() > 0) {
			for (Object object : fArrayList) {
				LabItemDTO item = (LabItemDTO) object;
				if (item.getPrice() != null) {
					pri = pri.add(item.getPrice().multiply(item.getQuan_medu()));
				}
			}
		}
		return pri;
	}
	

	private void ConVerToPatient(LabPatinfoDTO patient, LabApplyInfoSqlRstDTO sqlRstDTO) {
		patient.setCode_hospital(sqlRstDTO.getCode_hospital());// 医院代码（暂时为空）
		patient.setCode_entp(sqlRstDTO.getCode_entp());// 就诊类型
		patient.setCode_pat(sqlRstDTO.getCode_pat());// 患者编码
		patient.setCode_card(sqlRstDTO.getCode_card());// 就诊卡号
		patient.setCode_ent(sqlRstDTO.getCode_ent());// 就诊号
		patient.setCode_amr_oep(sqlRstDTO.getCode_amr_oep());// 门诊病案编号
		patient.setCode_amr_ip(sqlRstDTO.getCode_amr_ip());// 住院病案编号
		patient.setName_pat(sqlRstDTO.getName_pat());// 患者姓名
		patient.setName_sex(sqlRstDTO.getName_sex());// 患者性别
		patient.setSd_sex(sqlRstDTO.getSd_sex());// 患者性别编码
		patient.setDt_birth(sqlRstDTO.getDt_birth());// 出生日期
		patient.setCode_ward(sqlRstDTO.getCode_ward());// 病区编码
		patient.setName_ward(sqlRstDTO.getName_ward());// 病区名称
		patient.setNo_bed(sqlRstDTO.getNo_bed());// 床号
		patient.setSd_patca(sqlRstDTO.getSd_patca());// 患者分类编码
		patient.setName_patca(sqlRstDTO.getName_patca());// 患者分类名称
		patient.setName_abo(sqlRstDTO.getName_abo());// ABO血型
		patient.setName_rh(sqlRstDTO.getName_rh());// RH血型
		patient.setTel(sqlRstDTO.getTel());// 联系方式
		patient.setName_idtp(sqlRstDTO.getName_idtp());// 证件类型
		patient.setId_code(sqlRstDTO.getId_code());// 证件号码
		patient.setSd_country(sqlRstDTO.getSd_country());// 国籍编码
		patient.setName_country(sqlRstDTO.getName_country());// 国籍
		patient.setAddress(sqlRstDTO.getAddress());// 住址
		patient.setName_di(sqlRstDTO.getName_di());// 诊断名称
		patient.setDt_acpt(sqlRstDTO.getDt_acpt());// 接诊日期
		
	}

}
