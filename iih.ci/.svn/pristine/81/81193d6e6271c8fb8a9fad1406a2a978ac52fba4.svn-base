package iih.ci.event.ord.reissue.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import iih.ci.event.i.reissue.IRessueAssebleDataService;
import iih.ci.event.reissue.d.IEMsgReissueConst;
import iih.ci.event.reissue.d.IEMsgReissueDTO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

public abstract class ReissueCommonAction implements IRessueAssebleDataService {
	protected ReissueCommonBP reissueBP;
	protected IEMsgReissueDTO iEMsgReissueDTO;
	public ReissueCommonAction(){};
	public void setiEMsgReissueDTO(IEMsgReissueDTO iEMsgReissueDTO) {
		this.iEMsgReissueDTO = iEMsgReissueDTO;
	}
	public ReissueCommonBP getReissueBP() {
		return reissueBP;
	}
	public void setReissueBP(ReissueCommonBP reissueBP) {
		this.reissueBP = reissueBP;
	}
	
	public static final Map<String, String> codeEntpMap = new HashMap<>();
	
	static {
		codeEntpMap.put("01", "00");//门诊
		codeEntpMap.put("02", "01");//急诊
		codeEntpMap.put("0201", "0101");//流水
		codeEntpMap.put("0202", "0102");//抢救
		codeEntpMap.put("0203", "0103");//留观
		codeEntpMap.put("03", "10");//住院
		codeEntpMap.put("04", "02");//体检
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public CiOrderDO[] getOrders() throws BizException {
		// TODO 过滤出医嘱
		
		StringBuffer sql = new StringBuffer();
		sql.append("select * from ci_order c ");
		sql.append("left join pi_pat t on c.id_pat = t.id_pat ");
		sql.append("left join en_ent e on e.id_ent = c.id_en ");
		sql.append("left join MP_OR_PR r on r.id_or = c.id_or ");
		sql.append("left join MP_NE_LAB_SAMP_ITM_REF f on f.id_or_pr = r.id_or_pr ");
		sql.append("left join mp_ne_lab_samp p on p.id_labsamp = f.id_labsamp ");
		sql.append("where 1=1 ");
		sql.append(getWhereParamCtlStr());
		StringBuffer whereStr = new StringBuffer();
		SqlParam param = new SqlParam();
		if (StringUtils.isNotEmpty(this.iEMsgReissueDTO.getOrderno())) {
			whereStr.append("and c.code_or = ? ");//医嘱号
			param.addParam(this.iEMsgReissueDTO.getOrderno());
		} else if (StringUtils.isNotEmpty(this.iEMsgReissueDTO.getBarcode())) {
			
			whereStr.append("and p.no_bar = ? ");//标本条码号
			param.addParam(this.iEMsgReissueDTO.getBarcode());
		} else if (StringUtils.isNotEmpty(this.iEMsgReissueDTO.getVisitordno())) {
			whereStr.append("and e.code = ? ");//就诊流水号
			param.addParam(this.iEMsgReissueDTO.getVisitordno());
		} else if (StringUtils.isNotEmpty(this.iEMsgReissueDTO.getPatientlid())) {
			whereStr.append("and t.code = ? ");//患者id
			param.addParam(this.iEMsgReissueDTO.getPatientlid());
		} else if (StringUtils.isNotEmpty(this.iEMsgReissueDTO.getEncountercardno())) {
			//当就诊类别 = 01,02,0201,0202时，对应pi_pat.barcode_chis
			String enCard = this.iEMsgReissueDTO.getVisittypecode();
			if ("01".equals(enCard) || "02".equals(enCard) || "0201".equals(enCard) || "0202".equals(enCard)) {
				whereStr.append("and t.barcode_chis = ? ");//就诊卡号
			} 
			//当就诊类别 = 0203,03时，对应pi_pat.code_amr_ip
			else if ("0203".equals(enCard) || "03".equals(enCard)) {
				whereStr.append("and t.code_amr_ip = ? ");//就诊卡号
			}
			param.addParam(this.iEMsgReissueDTO.getEncountercardno());
		} else if(StringUtils.isNotEmpty(this.iEMsgReissueDTO.getPatientlid()) && StringUtils.isNotEmpty(this.iEMsgReissueDTO.getVisittimes()) && StringUtils.isNotEmpty(this.iEMsgReissueDTO.getVisittypecode())){
			whereStr.append("and c.id_en = ? ");//就诊卡号
			param.addParam(this.getIdEnt(this.iEMsgReissueDTO.getPatientlid(),this.iEMsgReissueDTO.getVisittimes(),this.iEMsgReissueDTO.getVisittypecode()));
		} 
		whereStr.append("and c.code_entp = ? ");
		param.addParam(getCodeEntp(this.iEMsgReissueDTO.getVisittypecode()));
		
		if (whereStr.toString().length() == 0) return null;
		sql.append(whereStr.toString());
		List<CiOrderDO> orderDOs = (List<CiOrderDO>) new DAFacade().execQuery(sql.toString(), param,
				new BeanListHandler(CiOrderDO.class));
		return orderDOs.toArray(new CiOrderDO[orderDOs.size()]);
	}
	
	//就诊类别转换
	private String getCodeEntp(String visittypecode) {
		
		if (codeEntpMap.containsKey(visittypecode)) {
			return codeEntpMap.get(visittypecode);
		}
		return null;
	}
	
	private Object getIdEnt(String patientlid, String visittimes, String enCard) {
		
		StringBuffer sql = new StringBuffer();
		//门诊
		if ("01".equals(enCard) || "02".equals(enCard) || "0201".equals(enCard) || "0202".equals(enCard)) {
			sql.append("select ent.id_ent from en_ent_op eop "); 
			sql.append("inner join en_ent ent on eop.id_ent = ent.id_ent "); 
			sql.append("inner join pi_pat p on ent.id_pat = ent.id_pat "); 
			sql.append("where p.code = ? and eop.times_op = ? "); 
		} 
		//住院
		else if ("0203".equals(enCard) || "03".equals(enCard)) {
			sql.append("select ent.id_ent from en_ent_ip eip ");
			sql.append("inner join en_ent ent on eip.id_ent = ent.id_ent ");
			sql.append("inner join pi_pat p on ent.id_pat = ent.id_pat ");
			sql.append("where p.code = ? and eip.times_ip = ? ");
		}
		return sql.toString();
	}
	
	//参数控制条件
	public String getWhereParamCtlStr() {
		
		String record = "";
		try {
			record = ParamsetQryUtil.getParaString(Context.get().getOrgId(), "BLCG0002");
		} catch (Exception e) {
			record = "1";//出异常 默认不执行记账
		}
		StringBuffer sql = new StringBuffer();
		//就诊类别
		if (IEMsgReissueConst.OPVISITTYPE.equals(this.iEMsgReissueDTO.getVisittypecode())) {
			if ("4".equals(record)) {
				sql.append("and c.sd_su_bl = '1' and c.fg_sign = 'Y' and c.fg_canc = 'N' and c.sd_su_mp = '0' ");
			} else if (!"4".equals(record)) {
				sql.append("and c.sd_su_bl != '2' and c.fg_sign = 'Y' and c.fg_canc = 'N' and c.sd_su_mp = '0' ");
			}
		} else if (IEMsgReissueConst.IPVISITTYPE.equals(this.iEMsgReissueDTO.getVisittypecode())) {
			sql.append("and c.fg_chk = 'Y' and c.fg_chk_canc = 'N' and c.sd_su_mp = '0' ");
		}
		//补发类别
		if (IEMsgReissueConst.ORDERRIS.equals(this.iEMsgReissueDTO.getOrderexamorlab())) {
			sql.append("and substr(c.sd_srvtp,0,2) = '02' ");
		} else if (IEMsgReissueConst.ORDERLIS.equals(this.iEMsgReissueDTO.getOrderexamorlab())) {
			sql.append("and substr(c.sd_srvtp,0,2) = '03' ");
		}
		return sql.toString();
	}
}
