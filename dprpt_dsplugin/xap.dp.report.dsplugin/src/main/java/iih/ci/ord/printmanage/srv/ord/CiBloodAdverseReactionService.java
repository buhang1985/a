package iih.ci.ord.printmanage.srv.ord;

import java.util.Date;
import java.util.List;

import com.mysql.jdbc.StringUtils;

import iih.ci.ord.printmanage.dto.CiBloodAdverseReactionDTO;
import iih.ci.ord.printmanage.dto.ItemDTO;
import iih.ci.ord.printmanage.srv.CiorderPrintUtils;
import iih.ci.ord.printmanage.srv.ICiorderPrintService;
import xap.mw.coreitf.d.FDate;
import xap.sys.appfw.xapformula.utils.AgeCalcUtil;
/**
 * 输血不良反应回报单Service
 * @author LiYue
 *  2018年2月7日
 */
public class CiBloodAdverseReactionService implements ICiorderPrintService<CiBloodAdverseReactionDTO, ItemDTO> {

	@Override
	public List<CiBloodAdverseReactionDTO> exec ( String ids ) throws Exception {
		
		List<CiBloodAdverseReactionDTO>  preslist = this.getOrderList( this.getOrdInfoSqlQry( ids ) );
		
		 setOrdInfo(preslist);
		return preslist;
	}
	
	/**
	 * 执行查询
	 * @param ids
	 * @param blstatetp
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<CiBloodAdverseReactionDTO> exec(String ids, String blstatetp) throws Exception{
		if (StringUtils.isNullOrEmpty(ids))
			return null;
		return this.exec(ids);
	}

	//SQL查询拼接
@Override
public String getOrdInfoSqlQry(String ids){            //外键ID
	StringBuilder str = new StringBuilder();
	str.append("select BAR.Id_pat,");
	str.append("BAR.Id_sex,");
	str.append("BAR.Id_dispensing_nurse,");
	str.append("BAR.Id_paracent_nurse,");
	str.append("BAR.Id_ward_nurse,");
	str.append("BAR.Id_psndoc,");
	str.append("BAR.Id_disease_diagnosis,");
	str.append("BAR.Id_operate,");
	str.append("BAR.Id_dep,");
	str.append("BAR.Fg_blood_his,");
	
	str.append("BAR.Def1,");                           //拓展字段
	str.append("BAR.Def2,");
	str.append("BAR.Def3,");
	str.append("BAR.Def4,");
	str.append("BAR.Def5,");
	str.append("BAR.Def6,");
	str.append("BAR.Def7,");
	str.append("BAR.Def8,");
	str.append("BAR.Def9,");
	str.append("BAR.Def10,");
	str.append("BAR.Def11,");
	str.append("BAR.Def12,");
	str.append("BAR.Def13,");
	str.append("BAR.Def14,");
	str.append("BAR.Def15,");
	str.append("BAR.Def16,");
	str.append("BAR.Def17,");
	str.append("BAR.Def18,");
	str.append("BAR.Def19,");
	str.append("BAR.Def20,");
	str.append("BAR.Def21,");
	str.append("BAR.Def22,");
	str.append("BAR.Def23,");
	str.append("BAR.Def24,");
	str.append("BAR.Def25,");
	str.append("BAR.Def26,");
	str.append("BAR.Def27,");
	str.append("BAR.Def28,");
	str.append("BAR.Def29,");
	str.append("BAR.Def30,");
	str.append("BAR.Def31,");
	str.append("BAR.Def32,");
	str.append("BAR.Def33,");
	str.append("BAR.Def34,");
	str.append("BAR.Def35,");
	str.append("BAR.Def36,");
	str.append("BAR.Def37,");
	str.append("BAR.Def38,");
	str.append("BAR.Def39,");
	str.append("BAR.Def40,");
	str.append("BAR.Def41,");
	
	str.append("BAR.Op_no,");//门诊号       
	str.append("BAR.Oth,");//其他
	str.append("BAR.Reaction_time,");
	str.append("BAR.Blood_bag_no,");
	str.append("BAR.Collection_time,");
	str.append("BAR.Fg_tran_blood_bad_reaction,");
	str.append("BAR.Fg_fever,");
	str.append("BAR.Fg_allergy,");
	str.append("BAR.Fg_hemolysis,");
	str.append("BAR.Fg_bacterium_contaminate,");
	str.append("BAR.Fg_oth,");
	str.append("BAR.Reporter,");
	str.append("BAR.Report_time,");
	str.append("BAR.Dept_sign,");
	str.append("BAR.time,");

	
	
	
	str.append("BAR.Dt_birth,");                             //患者出生
	str.append("BAR.Fg_pregnant,");
	str.append("BAR.Pregnant,");
	str.append("BAR.Birth,");                                //患者产子
	

	
	str.append(" pi.Name as name_pat,");                     //姓名
	str.append("DEP.Name as Sd_dep,");                       //部门科别
	str.append("SRV.Name as Sd_operate,");                   //手术
	str.append("DEF.Name as Sd_disease_diagnosis,");         //诊断

	
	str.append("bd1.NAme as Name_sex,");
	str.append("bd2.NAme as Sd_bloodtype_pat,");             //患者血型
	str.append("bd3.NAme as Sd_bloodtype_sipply,");          //供血血型
	str.append("bd4.NAme as Sd_rh,");                        //rh血型
	str.append("bd5.NAme as Sd_blood_spec,");                //血型规格
	str.append("SRV1.NAme as Sd_bloodtype_tran,");            //输血血型
	
	str.append("P1.NAme as Sd_paracent_nurse,");             //配药护士
	str.append("P2.NAme as Sd_dispensing_nurse,");           //穿刺护士
	str.append("P3.NAme as Sd_ward_nurse,");                 //病房护士长
	str.append("P4.NAme as Sd_psndoc");                      //医生
	
	str.append(" from               ci_blood_adverse_reaction        BAR ");
	
	str.append(" left outer join    bd_udidoc                        bd1    on BAR.id_sex = bd1.id_udidoc ");
	
	str.append(" left outer join    bd_udidoc                        bd2    on BAR.id_bloodtype_pat = bd2.id_udidoc ");
	
	str.append(" left outer join    bd_udidoc                        bd3    on BAR.id_bloodtype_sipply = bd3.id_udidoc ");
	
	str.append(" left outer join    bd_udidoc                        bd4    on BAR.id_rh = bd4.id_udidoc ");
	
	str.append(" left outer join    bd_udidoc                        bd5    on BAR.id_blood_spec = bd5.id_udidoc ");

	str.append(" left outer join    pi_pat                           PI     on BAR.Id_pat = PI.Id_pat ");
	
	str.append(" left outer join    bd_dep                           DEP    on BAR.Id_dep = DEP.Id_dep  ");
	
	str.append(" left outer join    bd_srv                           SRV    on BAR.id_operate = SRV.id_srv ");
	
	str.append(" left outer join    bd_srv                           SRV1   on BAR.Id_bloodtype_tran = SRV1.id_srv ");
	
	str.append(" left outer join    bd_di_def                        DEF    on BAR.id_disease_diagnosis = DEF.id_didef ");
	
	str.append(" left outer join    bd_psndoc                        P1     on BAR.id_paracent_nurse = P1.id_psndoc ");
	
	str.append(" left outer join    bd_psndoc          	              P2     on BAR.Id_dispensing_nurse = P2.id_psndoc ");
	
	str.append(" left outer join    bd_psndoc                        P3     on BAR.id_ward_nurse = P3.id_psndoc ");
	
	str.append(" left outer join    bd_psndoc                        P4     on BAR.id_psndoc = P4.id_psndoc ");
	
	String wherestr = "";
	
	if (ids!=null && !ids.isEmpty()) {
		if (wherestr.length() > 0) {
			wherestr += " and ";
		} else {
			wherestr += " where ";
		}
		wherestr += " BAR.Id_AR = '" + ids + "'";
	}
	str.append(wherestr);


	return str.toString();
	

}

/**
 * 获取检验、检查、诊疗医嘱信息
 */
@Override
public List<CiBloodAdverseReactionDTO> getOrderList(String sqlQry) throws Exception {
	List<CiBloodAdverseReactionDTO> result = CiorderPrintUtils.GetQueryResulte(CiBloodAdverseReactionDTO.class, sqlQry);

	return result;
}

/**
 * 
 */
@Override
public String getItmInfoSqlQry(String id) {
	return "";
}

@Override
public List<ItemDTO> getItemList(String sqlQry) throws Exception {
	List<ItemDTO> result = CiorderPrintUtils.GetQueryResulte(ItemDTO.class, sqlQry);
	
	return result;
}

/**
 * 
 */
@Override
public void setOrdInfo(List<CiBloodAdverseReactionDTO> dtos) throws Exception {

	for (CiBloodAdverseReactionDTO dto : dtos) {
	//	 设置年龄（格式）
		if (dto.getDt_birth() != null) {
			Date birth = new Date();
			birth = CiorderPrintUtils.ConvertStrToDate(dto.getDt_birth());
			FDate dt = new FDate(birth);
			dto.setAge(AgeCalcUtil.getAge(dt));
		}

	}
}

}
