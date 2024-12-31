package iih.ci.ord.printmanage.srv.ord;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import iih.ci.ord.printmanage.dto.CiConsInviteDO;
import iih.ci.ord.printmanage.dto.OrdConsRptDO;
import iih.ci.ord.printmanage.srv.CiorderPrintUtils;
import xap.dp.report.data.reader.sqlqryutil.RptQryUtil;
import xap.mw.coreitf.d.FDate;
import xap.sys.appfw.xapformula.utils.AgeCalcUtil;
/**
 * @code 会诊申请单
 * @author LiYue
 * @date 2019年12月25日,下午3:03:08
 */
public class CiorderConsPrintService {
	
	public List<OrdConsRptDO> exec(String ids,String blstatetp){
		if(StringUtils.isEmpty(ids)) return null;
		
		//获取会诊申请信息，患者信息
		List<OrdConsRptDO> ConsRptDOList = getConsRptList(ids);
		if(ConsRptDOList==null && ConsRptDOList.size()<=0) return null;
		
		//获取受邀方信息
		List<CiConsInviteDO> inviteDOList = getInviteDolist(ids);
		
		//数据组装
		for (OrdConsRptDO rptDo : ConsRptDOList) {
			for (CiConsInviteDO InviteDO : inviteDOList) {
				if(rptDo.getId_or().equals(InviteDO.getId_or()))
				{
					if(rptDo.getInviteDOList()==null) {
					   rptDo.setInviteDOList(new ArrayList<CiConsInviteDO>(inviteDOList.size()));
					}
					rptDo.getInviteDOList().add(InviteDO);
				}
				// 设置年龄（格式）
				if (rptDo.getDt_birth() != null) {
					Date birth = new Date();
					try {
						birth = CiorderPrintUtils.ConvertStrToDate(rptDo.getDt_birth());
					} catch (ParseException e) {
					}
					FDate dt = new FDate(birth);
					rptDo.setAge(AgeCalcUtil.getAge(dt));
				}
			}
		}
		
		return ConsRptDOList;
	}

	//获取受邀方信息
	private List<CiConsInviteDO> getInviteDolist(String ids) {
		//取SQL 查库
		String sql = getInvitedoSql(ids);
		CiConsInviteDO [] arr_result = RptQryUtil.qryRptBeansArr(sql, null ,CiConsInviteDO.class);
		//结果校验
		if(arr_result==null || arr_result.length<=0) return null;
		//数组转List
		ArrayList<CiConsInviteDO> resultList = new ArrayList<>(arr_result.length);
		Collections.addAll(resultList, arr_result);
		return resultList;
	}

	private String getInvitedoSql(String ids) {
		StringBuilder sb = new StringBuilder();
		              sb.append(" select psn.name Name_emp , inv.id_or, 							");
		              sb.append(" dep.name Name_dep, 												");
		              sb.append(" udi.name Name_emptitle_invite 									");
		              sb.append(" from CI_CONS_INVITE inv											");
		              sb.append(" left JOIN bd_psndoc psn on inv.ID_EMP = psn.ID_PSNDOC				");
		              sb.append(" left JOIN bd_dep dep on inv.id_dep = dep.id_dep					");
		              sb.append(" left JOIN bd_udidoc udi on udi.id_udidoc = inv.id_emptitle_invite	");
		sb.append(String.format(" where id_or in(%s) 												",ids ));
		return sb.toString();
	}

	//获取会诊申请信息
	private List<OrdConsRptDO> getConsRptList(String ids) {
		//取SQL 查库
		String sql = getConsRptSql(ids);
		OrdConsRptDO [] arr_result = RptQryUtil.qryRptBeansArr(sql, null ,OrdConsRptDO.class);
		//结果校验
		if(arr_result==null || arr_result.length<=0) return null;
		//数组转List
		ArrayList<OrdConsRptDO> resultList = new ArrayList<>(arr_result.length);
		Collections.addAll(resultList, arr_result);
		return resultList;
	}

	private String getConsRptSql(String ids) {
		StringBuilder sb = new StringBuilder();
		              sb.append(" SELECT pat.name Name_pati，											");
		              sb.append(" SEX.NAME Gender,														");
		              sb.append(" CONS.id_or,															");
		              sb.append(" '' as Age,															");
		              sb.append(" pat.DT_BIRTH DT_BIRTH,												");
		              sb.append(" DEP.NAME Name_dep_or,													");
		              sb.append(" EMPOR.NAME Name_emp_or,												");
		              sb.append(" Dep_pat.NAME Dep_pati,												");
		              sb.append(" enip.code_amr_ip CODE_EN,												");
		              sb.append(" enip.cont_name cont_name,												");
		              sb.append(" enip.cont_tel cont_tel,												");
		              sb.append(" Cons.PLACE PLACE,														");
		              sb.append(" CONS.DT_PLAN DT_CONS,													");
		              sb.append(" CONS.DES_EMR DES_EMR,													");
		              sb.append(" CONS.DES_PSP DES_PSP													");
		              sb.append(" FROM ci_ap_cons cons													");
		              sb.append(" LEFT JOIN CI_order ord on cons.id_or = ord.id_or						");
		              sb.append(" LEFT JOIN bd_psndoc EMPOR  ON EMPOR.Id_psndoc = ORD.Id_emp_or			");
		              sb.append(" LEFT JOIN EN_ENT_IP enip on ord.id_en = enip.id_ent					");
		              sb.append(" LEFT JOIN PI_PAT pat on ord.ID_PAT = pat.ID_PAT						");
		              sb.append(" LEFT JOIN BD_UDIDOC SEX ON SEX.ID_UDIDOC = pat.ID_SEX					");
		              sb.append(" LEFT JOIN BD_DEP DEP ON DEP.ID_DEP = enip.ID_DEP_PHYADM				");
		              sb.append(" LEFT JOIN BD_DEP DEP_PAT ON DEP_PAT.ID_DEP = enip.id_dep_nuradm		");
		sb.append(String.format(" where cons.id_or in (%s)											", ids));
		return sb.toString();
	}
}
