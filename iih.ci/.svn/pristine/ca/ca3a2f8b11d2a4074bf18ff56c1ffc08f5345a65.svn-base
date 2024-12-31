package iih.ci.ord.s.bp.ordprn.qry;

import iih.ci.ord.dto.ordprintdto.d.OrdPrintDataDTO;
import iih.ci.ord.dto.ordprintdto.d.OrdPrintParamDTO;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 根据待打印的作废医嘱获取已打印的医嘱
 * @author Young
 *
 */
public class GetOrdPrintDOQry implements ITransQry {

	private OrdPrintParamDTO paramDTO;
	private OrdPrintDataDTO[] printDataDTOs;

	public GetOrdPrintDOQry(OrdPrintParamDTO paramDTO, OrdPrintDataDTO[] printDataDTOs) {
		this.paramDTO = paramDTO;
		this.printDataDTOs = printDataDTOs;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlparam = new SqlParam();
		sqlparam.addParam(paramDTO.getId_en());
//		sqlparam.addParam(paramDTO.getFg_long());
		for (int i = 0; i < printDataDTOs.length; i++) {
			sqlparam.addParam(printDataDTOs[i].getId_or());
		}
		return sqlparam;
	}

	@Override
	public String getQrySQLStr() {

		String sqlSel="select PRN.*,"
				+ "ORG.name as name_org,BED.code code_bed,BED.name name_bed,"
				+ "PAT.code as code_pat_en,PAT.name as name_pat_en,"
				+ "DEPPHY.code as code_dep_phy,DEPPHY.name as name_dep_phy,"
				+ "EN.id_dep_nur,DEPNUR.code as code_dep_nur,DEPNUR.name as name_dep_nur,"
				+ "EMPSIGN.code as code_emp_sign,EMPSIGN.name as name_emp_sign,"
				+ "EMPCHK.code as code_emp_chk,EMPCHK.name as name_emp_chk,"
				+ "EMPSTOP.code as code_emp_stop,EMPSTOP.name as name_emp_stop,"
				+ "EMPCHKSTOP.code as code_emp_chk_stop,EMPCHKSTOP.name as name_emp_chk_stop ";

		String sqlFrm=" from ci_or_prn PRN,bd_org ORG,pi_pat PAT,en_ent EN,bd_dep DEPPHY,bd_dep DEPNUR,bd_psndoc EMPSIGN,bd_psndoc EMPCHK,bd_psndoc EMPSTOP,bd_psndoc EMPCHKSTOP,bd_bed BED";

		StringBuffer sqlIdors = new StringBuffer();
		for (int i = 0; i < printDataDTOs.length; i++) {
			sqlIdors.append(",?");
		}
		
		StringBuffer sqlWhrDynamic = new StringBuffer();
		if(FBoolean.TRUE.equals(this.paramDTO.getFg_long()) && FBoolean.TRUE.equals(this.paramDTO.getFg_herb())){
			sqlWhrDynamic.append(" and PRN.fg_long='Y' ");
		}else if(FBoolean.TRUE.equals(this.paramDTO.getFg_long()) && FBoolean.FALSE.equals(this.paramDTO.getFg_herb())){
			sqlWhrDynamic.append(" and PRN.fg_long='Y' and PRN.sd_srvtp not like '0103%' ");
		}else if(FBoolean.FALSE.equals( this.paramDTO.getFg_long()) && FBoolean.TRUE.equals(this.paramDTO.getFg_herb())){
			sqlWhrDynamic.append(" and PRN.sd_srvtp like '0103%' ");
		}else if(FBoolean.FALSE.equals(this.paramDTO.getFg_long()) && FBoolean.FALSE.equals(this.paramDTO.getFg_herb())){
			sqlWhrDynamic.append(" and PRN.fg_long='N' ");
		}
		
		String sqlWhr = " where PRN.id_en=? and prn.ds < 1 and PRN.id_org=ORG.id_org(+) and PRN.id_pat=PAT.id_pat and PRN.id_dep_phy=DEPPHY.id_dep(+) and PRN.id_en=EN.id_ent and EN.id_dep_nur=DEPNUR.id_dep(+)"
				+ " and PRN.id_emp_sign=EMPSIGN.id_psndoc(+) and PRN.id_emp_chk=EMPCHK.id_psndoc(+) and PRN.id_emp_stop=EMPSTOP.id_psndoc(+) and PRN.id_emp_chk_stop=EMPCHKSTOP.id_psndoc(+) and PRN.id_bed=BED.id_bed(+) "
				+ " and exists (select * from ci_or_prn where ds<1 and fg_reformed='N' and page_num=PRN.page_num and id_or in ("+ sqlIdors.substring(1) + "))"
				+ sqlWhrDynamic.toString()
				+ " order by PRN.page_num,PRN.row_num";
		
		return sqlSel + sqlFrm + sqlWhr ;
	}

}
