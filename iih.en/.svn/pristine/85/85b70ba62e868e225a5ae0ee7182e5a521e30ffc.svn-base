package iih.en.ip.s.bp.qry;

import java.util.List;

import iih.en.comm.util.EnAppUtils;
import iih.sc.apt.dto.d.AptIpDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 通过患者ID获取入院通知单BP
 * @author zhangpp
 */
public class GetAptIpByPatIdBP {

	/**
	 * 执行
	 */
	public AptIpDTO[] exec(String patId) throws BizException{
		
		//校验入参
		if (StringUtil.isEmpty(patId))
			return new AptIpDTO[0];
		//查询申请单信息
		AptIpDTO[] aptIpDTOs = getAptIpInfo(patId);
		
		return aptIpDTOs;
	}
	
	/**
	 * 查询申请单信息
	 * @param patId
	 * @return
	 * @throws BizException 
	 */
	@SuppressWarnings("unchecked")
	private AptIpDTO[] getAptIpInfo(String patId) throws BizException{
		
		SqlParam param = new SqlParam();
		StringBuffer buffer = new StringBuffer();
		buffer.append(" select");
		buffer.append(" inpt.id_pat as id_pat,");
		buffer.append(" inpt.id_ent as id_ent,");
		buffer.append(" inpt.id_aptip as id_scaptip,");
		buffer.append(" inpt.sd_status as sd_status,");
		buffer.append(" inpt.id_emp_phy_op as id_emp_phy_op,");
		buffer.append(" inpt.name_emp_phy_op as name_emp_phy_op,");
		buffer.append(" inpt.dt_insert as dt_insert,");
		buffer.append(" inpt.id_dep_phy_ip as id_dep_phy_ip,");
		buffer.append(" dep1.name as name_dep_phy_ip,");
		buffer.append(" inpt.id_dep_nur_ip as id_dep_nur_ip,");
		buffer.append(" dep2.name as name_dep_nur_ip,");
		buffer.append(" inpt.id_kind as id_kind,");
		buffer.append(" inpt.sd_kind as sd_kind,");
		buffer.append(" doc.name as name_kind,");
		buffer.append(" inpt.id_didef_op as id_didef_op,");
		buffer.append(" inpt.name_didef_op as name_didef_op,");
		buffer.append(" inpt.dt_admit_plan as dt_admit_plan,");
		buffer.append(" ent.fg_ip, ");
		buffer.append(" ip.sd_status as sd_status_ip ");
		buffer.append("  ");
		buffer.append(" from sc_apt_ip inpt");
		buffer.append(" left join en_ent ent on ent.id_ent = inpt.id_entip ");
		buffer.append(" left join en_ent_ip ip on ip.id_ent = ent.id_ent ");
		buffer.append(" left outer join bd_udidoc doc on doc.id_udidoc = inpt.id_kind");
		buffer.append(" left outer join bd_dep dep1 on dep1.id_dep = inpt.id_dep_phy_ip ");
		buffer.append(" left outer join bd_dep dep2 on dep2.id_dep = inpt.id_dep_nur_ip ");
		buffer.append(" where");
		buffer.append(" inpt.id_pat = ?");
		buffer.append(" and inpt.dt_valid >= ?");
		buffer.append(" and inpt.fg_canc = ?");
		buffer.append(" ");
		
		param.addParam(patId);
		param.addParam(EnAppUtils.getServerDateTime());
		param.addParam(FBoolean.FALSE);
		
		List<AptIpDTO> list = (List<AptIpDTO>) new DAFacade().execQuery(buffer.toString(), param, new BeanListHandler(AptIpDTO.class));
		if (list == null || list.size() <= 0){
			return new AptIpDTO[0];
		}
		return list.toArray(new AptIpDTO[0]);
	} 
	
}
