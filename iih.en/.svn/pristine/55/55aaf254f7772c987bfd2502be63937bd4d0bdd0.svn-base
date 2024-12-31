package iih.en.pv.s.bp;

import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.dto.d.PatInfo4HDDTO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 血液透析管理系统与其他系统的小数据量数据交互,患者基本信息接口
 * 
 * @author jizb
 *
 */
public class GetPatientInfoBp {

	/**
	 * 液透析管理系统与其他系统的小数据量数据交互,患者基本信息接口
	 * 
	 * @param patientID
	 * @return
	 * @throws BizException
	 */
	public PatInfo4HDDTO exec(String patientID) throws BizException {
		//校验入参
		EnValidator.validateParam("患者ID", patientID);
		
		//组装sql
		StringBuilder sb = this.getSql();
		SqlParam param = new SqlParam();
		param.addParam(IPiDictCodeConst.SD_SEX_MALE);
		param.addParam(IPiDictCodeConst.SD_SEX_FEMALE);
		param.addParam(IPiDictCodeConst.SD_IDTP_IDENTITY);
		param.addParam(IPiDictCodeConst.SD_ADDR_TYPE_NOW);
		param.addParam(patientID);
		
		@SuppressWarnings("unchecked")
		List<PatInfo4HDDTO> list = (List<PatInfo4HDDTO>)new DAFacade().execQuery(sb.toString(), param, new BeanListHandler(PatInfo4HDDTO.class));
		//查询结果为空
		if (list.size() == 0) {
			return null;
		}
		PatInfo4HDDTO patInfo4HDDTO = null;
		//在院优先取住院数据
		for (PatInfo4HDDTO patInfo : list) {
			if ("1".equals(patInfo.getIoFlag())) {
				patInfo4HDDTO = patInfo;
			}
		}
		//未在院
		if (patInfo4HDDTO == null) {
			patInfo4HDDTO = list.get(0);
		}
		return patInfo4HDDTO;
	}
	
	/**
	 * 组装sql
	 * 
	 * @return
	 */
	private StringBuilder getSql(){
		StringBuilder sb = new StringBuilder();
		sb.append(" select pi.name patientName, ");	//姓名
		sb.append(" pi.pycode patientPinYin, ");	//姓名拼音
		sb.append(" case when pi.sd_sex = ? then 'M' when pi.sd_sex = ? then 'F' end as sex , ");//性别
		sb.append(" case when pi.sd_idtp = ? then '0' else '1' end as cardType , ");		//证件类型
		sb.append(" pi.id_code cardNo , ");			//证件号
//		sb.append(" pi.name_pat height , ");		//身高
//		sb.append(" pi.name_pat weight , ");		//体重
		sb.append(" pi.sd_occu job , ");			//职业
		sb.append(" addr.zip zipCode , ");			//邮编
		sb.append(" concat(area.fullname, addr.street) address , ");//住址
		sb.append(" pi.mob tel , ");				//电话 
		sb.append(" cont.name familyName , ");		//家属姓名
		sb.append(" cont.conttel familyTel , ");	//家属电话
		sb.append(" case when ent.fg_ip = 'Y' then '1' else '0' end as ioFlag , ");	//是否住院
		sb.append(" dep.name wardBlock , ");		//住院病区
		sb.append(" ip.name_bed wardBedNo ");		//住院病床号
		sb.append(" from pi_pat pi ");
		sb.append(" left join pi_pat_addr addr");
		sb.append("   on pi.id_pat = addr.id_pat");
		sb.append("   and addr.sd_addrtp = ? ");
		sb.append(" left join bd_adminarea area ");
		sb.append("   on addr.id_admdiv = pi.id_pat ");
		sb.append(" left join pi_pat_cont cont ");
		sb.append("   on cont.id_pat = area.id_adminarea");
		sb.append(" left join en_ent ent on pi.id_pat = ent.id_pat ");
		sb.append(" left join bd_dep dep on dep.id_dep = ent.id_dep_nur ");
		sb.append(" left join en_ent_ip ip on ip.id_ent = ent.id_ent ");
		sb.append(" where pi.code = ? ");
		return sb;
	}
}
