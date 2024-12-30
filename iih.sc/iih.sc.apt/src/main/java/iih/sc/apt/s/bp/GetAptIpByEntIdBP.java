package iih.sc.apt.s.bp;

import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.pi.reg.pat.d.PatiAddrDO;
import iih.pi.reg.pat.d.desc.PatiAddrDODesc;
import iih.pi.reg.pat.i.IPatiAddrDORService;
import iih.sc.apt.dto.d.AptIpDTO;

import java.util.List;

import org.apache.commons.lang3.ArrayUtils;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.xbd.udi.d.UdidocDO;
import xap.sys.xbd.udi.i.IUdidocRService;

/**
 * 根据就诊id获取住院预约申请单
 * @author renying
 *
 */
public class GetAptIpByEntIdBP {
	/**
	 * 查询住院预约申请单
	 * @param entId 就诊id 
	 * @return
	 * @throws BizException
	 * @author renying
	 */
	public AptIpDTO exec(String entId) throws BizException{
		StringBuffer ipntBuffer = new StringBuffer();		
		ipntBuffer.append(" select pat.code,   ");		
		ipntBuffer.append(" pat.mob             telno_pat,");			
		ipntBuffer.append(" doc.name            sd_patcardtp,");
		ipntBuffer.append(" pat.id_pat, ");
		ipntBuffer.append(" pat.id_code         sd_patcardtp_code,");
		ipntBuffer.append(" di.name_didef_dis   name_didef_dis,");
		ipntBuffer.append(" di.supplement as    desc_diag, ");
		ipntBuffer.append(" docStatus.name      name_status_pat,");
		ipntBuffer.append(" dep.name            dep_name,");
		ipntBuffer.append(" ipnt.id_aptip    ,");
		ipntBuffer.append(" ipnt.dt_admit_plan,");
		ipntBuffer.append(" ipnt.amt_deposit,");
		ipntBuffer.append(" ipnt.note,");
		ipntBuffer.append(" ent.id_dep_phy     id_dep_op,");
		ipntBuffer.append(" ipnt.sd_level_dise  sd_status_pat,");
		ipntBuffer.append(" ipnt.id_level_dise   id_status_pat,");
		ipntBuffer.append(" ipnt.id_dep_phy_ip,");
		ipntBuffer.append(" ent.addr_pat,");
		ipntBuffer.append(" ent.id_ent");
		ipntBuffer.append(" from en_ent ent");
		ipntBuffer.append(" inner join pi_pat pat");
		ipntBuffer.append(" on pat.id_pat = ent.id_pat");
		ipntBuffer.append(" left outer join en_ent_di di");
		ipntBuffer.append(" on di.id_ent = ent.id_ent");
		ipntBuffer.append(" and di.fg_maj = 'Y'");
		ipntBuffer.append(" left outer join bd_udidoc doc");
		ipntBuffer.append(" on doc.id_udidoc = pat.id_idtp");
		ipntBuffer.append(" left outer join sc_apt_ip ipnt");
		ipntBuffer.append(" on ipnt.id_ent = ent.id_ent");
		ipntBuffer.append(" left outer join bd_udidoc docStatus");
		ipntBuffer.append(" on docStatus.id_udidoc = ipnt.id_level_dise");
		//ipntBuffer.append(" and docStatus.Code = ipnt.sd_status_pat");
		ipntBuffer.append(" left outer join bd_dep dep");
		ipntBuffer.append("   on dep.id_dep = ipnt.id_dep_phy_ip");
		ipntBuffer.append(" where ent.id_ent = ?");
				
		String ipntSql = ipntBuffer.toString();
		SqlParam ipntParam = new SqlParam();
		ipntParam.addParam(entId);
		AptIpDTO entipntDTO = new AptIpDTO();
		
		@SuppressWarnings("unchecked")
		List<AptIpDTO> list = (List<AptIpDTO>)new DAFacade().execQuery(ipntSql,ipntParam,new BeanListHandler(AptIpDTO.class));
		if(!list.isEmpty()){
			entipntDTO = list.get(0);
			if(!StringUtil.isEmptyWithTrim(entipntDTO.getId_pat()))
			{
				entipntDTO.setAddr_pat(getPatFamilyAddress(entipntDTO.getId_pat()));
			}
			
			return entipntDTO;
		}
		return null;		
	}    


	/**
	 * 获取家庭住址
	 * 
	 * @param patId
	 *            患者id
	 * @return
	 * @throws BizException
	 */
	public String getPatFamilyAddress(String patId) throws BizException {
		IPatiAddrDORService patAddrService = ServiceFinder.find(IPatiAddrDORService.class);
		String whereStr = String.format("%s.id_pat='%s'",PatiAddrDODesc.TABLE_ALIAS_NAME, patId);
		PatiAddrDO[] addrDOArray = patAddrService.find(whereStr, null,FBoolean.FALSE);
		String address = null;
		if (!ArrayUtils.isEmpty(addrDOArray)) {
			for (PatiAddrDO patiAddrDO : addrDOArray) {
				// 地址类型：家庭
				if (IPiDictCodeConst.SD_ADDR_TYPE_FAMILY.equals(patiAddrDO
						.getSd_addrtp())) {
					address = parseAddress(patiAddrDO.getId_admdiv(),
							patiAddrDO.getStreet());
					break;
				}
			}
		}

		return address;
	}

	/**
	 * 获取地址
	 * @param areaUdiDocId区域地址
	 * @param street 街道
	 * @return
	 * @throws BizException
	 */
	private String parseAddress(String areaUdiDocId, String street)
			throws BizException {
		String address = street;
		IUdidocRService udiService = ServiceFinder.find(IUdidocRService.class);
		UdidocDO udi = udiService.findById(areaUdiDocId);
		if (udi != null) {
			address = udi.getName() + address;
		}

		return address;
	}

}
