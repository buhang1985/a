package iih.en.pv.s.bp.ip.qry;

import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.dto.d.EntQryModDTO;
import iih.en.pv.inpatient.d.EntPatListDO;

import java.util.Set;

import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.FMap;

/**
 * 查询住院医生站患者列表信息
 * 
 * @author liubin
 *
 */
public class GetIpPatientsBP {
	// 我的患者
	private final static String PERSONALPATS = "PERSONALPATS";
	// 关注患者
	private final static String MARKPATS = "MARKPATS";
	// 医疗组患者
	private final static String WORKGROUPPATS = "WORKGROUPPATS";
	// 会诊患者
	private final static String CONSULTATIONPATS = "CONSULTATIONPATS";
	// 待应答会诊患者
	private final static String RESPONSECONSPATS = "RESPONSECONSPATS";
	// 科室患者
	private final static String DEPTITEMPATS = "DEPTITEMPATS";
	// 病区患者
	private final static String NURITEMPATS = "NURITEMPATS";
	// 待入科患者
	private final static String APPLYIPPATS = "APPLYIPPATS";
	// 待出院患者
	private final static String APPLYOUTPATS = "APPLYOUTPATS";
	// 出院患者
	private final static String LVHOSPATS = "LVHOSPATS";
	// 跨科处置患者
	private final static String CROSSDEPTPATS = "CROSSDEPTPATS";
	// 转出患者
	public final static String TRANSOUTPATS = "TRANSOUTPATS";
	// 转入患者
	public final static String TRANSINPATS = "TRANSINPATS";
	// 自定义患者
	private final static String CUSTOMPATS = "CUSTOMPATS";
	// 授权患者
	private final static String ENAUTHPATS = "ENAUTHPATS";
	// 留观患者
	private final static String EMGSTAYPATS = "EMGSTAYPATS";

	/**
	 * 查询住院医生站患者列表信息
	 * 
	 * @param map
	 * @return
	 * @throws BizException
	 */
	public FMap exec(FMap qryMap) throws BizException {
		FMap map = new FMap();
		Set<String> keySet = qryMap.keySet();
		for (String key : keySet) {
			EntQryModDTO entQryDto = (EntQryModDTO) qryMap.get(key);
			if(null != entQryDto && EnValidator.isEmpty(entQryDto.getCode_entp())){
				entQryDto.setCode_entp(IEnDictCodeConst.SD_ENTP_INPATIENT);
			}
			switch (key) {
			case PERSONALPATS:// 我的患者
				map.put(key, EnAppUtils.doArray2List(new GetChargedPatsBP()
						.exec(entQryDto.getId_dep(), entQryDto.getId_emp(), entQryDto.getCode_entp())));
				break;
			case MARKPATS:// 关注患者
				map.put(key, EnAppUtils.doArray2List(new GetMarkPatsBP().exec(
						entQryDto.getId_dep(), entQryDto.getId_emp(), entQryDto.getCode_entp())));
				break;
			case WORKGROUPPATS:// 医疗组患者
				map.put(key, EnAppUtils.doArray2List(new GetWgPatsBP().exec(
						entQryDto.getId_dep(), entQryDto.getId_emp(), entQryDto.getCode_entp())));
				break;
			case CONSULTATIONPATS:// 会诊患者
				map.put(key, EnAppUtils.doArray2List(new GetConsPatsBP()
						.getConsPats(entQryDto.getId_dep(),
								entQryDto.getId_emp())));
				break;
			case RESPONSECONSPATS:// 待应答会诊患者
				map.put(key, EnAppUtils.doArray2List(new GetConsPatsBP()
						.getResponseConsPats(entQryDto.getId_dep(),
								entQryDto.getId_emp())));
				break;
			case DEPTITEMPATS:// 科室患者
				map.put(key, EnAppUtils.doArray2List(new GetDeptPatsBP().getDepPats(
						entQryDto.getId_dep(), entQryDto.getId_emp(), entQryDto.getCode_entp())));
				break;
			case NURITEMPATS:// 病区患者
				map.put(key, EnAppUtils.doArray2List(new GetDeptPatsBP().getNurPats(
						entQryDto.getId_dep(), entQryDto.getId_nur(),
						entQryDto.getId_emp(), entQryDto.getCode_entp())));
				break;
			case APPLYIPPATS:// 待入科患者
				map.put(key, EnAppUtils.doArray2List(new GetWillEnDeptPatsBP()
						.exec(entQryDto.getId_dep(), entQryDto.getId_emp(), entQryDto.getCode_entp())));
				break;
			case APPLYOUTPATS:// 待出院患者
				map.put(key, EnAppUtils.doArray2List(new GetWillLvHosPatsBP()
						.exec(entQryDto.getId_dep(), entQryDto.getId_emp(), entQryDto.getCode_entp())));
				break;
			case LVHOSPATS:// 出院患者
				map.put(key,
						EnAppUtils.doArray2List(new GetLvHosPatsBP().exec(
								entQryDto.getId_dep(), Context.get().getStuffId(),
								entQryDto)));
				break;
			case CROSSDEPTPATS:// 跨科处置患者
				map.put(key, EnAppUtils.doArray2List(new GetCrossDeptPatsBP()
						.exec(entQryDto.getId_dep(), entQryDto.getId_emp(), entQryDto.getCode_entp())));
				break;
			case TRANSOUTPATS:// 转出患者
				map.put(key, EnAppUtils.doArray2List(new GetTransPatsBP()
						.transOut(entQryDto.getId_dep(), entQryDto.getId_emp(),
								entQryDto.getDt_b(), entQryDto.getDt_e(),entQryDto.getCode_entp())));
				break;
			case TRANSINPATS:// 转入患者
				map.put(key, EnAppUtils.doArray2List(new GetTransPatsBP()
						.transIn(entQryDto.getId_dep(), entQryDto.getId_emp(),
								entQryDto.getDt_b(), entQryDto.getDt_e(),entQryDto.getCode_entp())));
				break;
			case CUSTOMPATS:// 自定义患者
				EntPatListDO entPatListDO = entQryDto.getData() != null ? (EntPatListDO) entQryDto
						.getData().get(0) : null;
				map.put(key, EnAppUtils.doArray2List(new GetCustomPatsBP()
						.exec(entPatListDO, entQryDto.getId_dep(),
								entQryDto.getId_emp())));
				break;
			case ENAUTHPATS:// 授权患者
				map.put(key, EnAppUtils.doArray2List(new GetAuthPatsBP()
						.exec(entQryDto)));
				break;
			case EMGSTAYPATS://留观患者
				map.put(key, EnAppUtils.doArray2List(new GetEmgstayPatsBP()
						.exec(entQryDto.getId_dep(),
								entQryDto.getId_emp(),entQryDto.getCode_entp())));
				break;
			}
		}
		return map;
	}
}
