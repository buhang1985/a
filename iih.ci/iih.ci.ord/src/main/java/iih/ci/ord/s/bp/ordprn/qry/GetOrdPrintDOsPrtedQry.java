package iih.ci.ord.s.bp.ordprn.qry;

import com.mysql.jdbc.StringUtils;

import iih.ci.ord.dto.ordprintdto.d.OrdPrintParamDTO;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 查询已打印的数据
 * @author Young
 *
 */
public class GetOrdPrintDOsPrtedQry implements ITransQry {

	private OrdPrintParamDTO paramDTO;
	
	public GetOrdPrintDOsPrtedQry(OrdPrintParamDTO paramDTO){
		this.paramDTO = paramDTO;
	}
	
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		// TODO Auto-generated method stub
		SqlParam sqlparam = new SqlParam();
		if (!StringUtils.isNullOrEmpty(this.paramDTO.getId_en())) {
			sqlparam.addParam(this.paramDTO.getId_en());
		}
//		if (this.paramDTO.getFg_long() != null) {
//			sqlparam.addParam(this.paramDTO.getFg_long());
//		}
		if(this.paramDTO.getPage_num() != null){
			sqlparam.addParam(this.paramDTO.getPage_num());
		}
		
		return sqlparam;
	}

	@Override
	public String getQrySQLStr() {
		// TODO Auto-generated method stub
		String sqlSel="select PRN.*,"
				+ "ORG.name as name_org,BED.code code_bed,BED.name name_bed,"
				+ "PAT.code as code_pat_en,PAT.name as name_pat_en,"
				+ "DEPPHY.code as code_dep_phy,DEPPHY.name as name_dep_phy,"
				+ "DEPNUR.code as code_dep_nur,DEPNUR.name as name_dep_nur,"
				+ "EMPSIGN.code as code_emp_sign,EMPSIGN.name as name_emp_sign,"
				+ "EMPCHK.code as code_emp_chk,EMPCHK.name as name_emp_chk,"
				+ "EMPSTOP.code as code_emp_stop,EMPSTOP.name as name_emp_stop,"
				+ "EMPCHKSTOP.code as code_emp_chk_stop,EMPCHKSTOP.name as name_emp_chk_stop ";

		String sqlFrm=" from ci_or_prn PRN,bd_org ORG,pi_pat PAT,en_ent EN,bd_dep DEPPHY,bd_dep DEPNUR,bd_psndoc EMPSIGN,bd_psndoc EMPCHK,bd_psndoc EMPSTOP,bd_psndoc EMPCHKSTOP,bd_bed BED";
		
		StringBuffer sqlWhrDynamic = new StringBuffer();
		if(FBoolean.TRUE.equals(this.paramDTO.getFg_long()) && FBoolean.TRUE.equals(this.paramDTO.getFg_herb())){
			sqlWhrDynamic.append(" and PRN.fg_long='Y' ");
		}else if(FBoolean.TRUE.equals(this.paramDTO.getFg_long()) && FBoolean.FALSE.equals(this.paramDTO.getFg_herb())){
			sqlWhrDynamic.append(" and PRN.fg_long='Y' and PRN.sd_srvtp not like '0103%' ");
		}else if(FBoolean.FALSE.equals(this.paramDTO.getFg_long()) && FBoolean.TRUE.equals(this.paramDTO.getFg_herb())){
			sqlWhrDynamic.append(" and PRN.sd_srvtp like '0103%' ");
		}else if(FBoolean.FALSE.equals(this.paramDTO.getFg_long()) && FBoolean.FALSE.equals(this.paramDTO.getFg_herb())){
			sqlWhrDynamic.append(" and PRN.fg_long='N' ");
		}
		
		String sqlWhr = " where PRN.ds<1 and PRN.id_en=? and PRN.fg_long=? and PRN.id_org=ORG.id_org(+) and PRN.id_pat=PAT.id_pat and PRN.id_dep_phy=DEPPHY.id_dep(+) and PRN.id_en=EN.id_ent and EN.id_dep_nur=DEPNUR.id_dep(+)"
				+ " and PRN.id_emp_sign=EMPSIGN.id_psndoc(+) and PRN.id_emp_chk=EMPCHK.id_psndoc(+) and PRN.id_emp_stop=EMPSTOP.id_psndoc(+) and PRN.id_emp_chk_stop=EMPCHKSTOP.id_psndoc(+) and PRN.id_bed=BED.id_bed(+) "
				+ sqlWhrDynamic.toString()
				+ " order by PRN.page_num,PRN.row_num";
		
		return sqlSel + sqlFrm + sqlWhr;
	}

}
