package iih.ci.mrqc.outqamedpatlist.s;

import iih.bd.bc.udi.pub.ICiMrDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.ci.mrqc.outqamedpatlist.d.OutQaMedPatListDTO;
import iih.ci.mrqc.outqamedpatlist.i.IOutQaMedPatListQryService;
import iih.ci.mrqc.qrydto.d.OutQaPatQryDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

public class IOutQaMedPatListQryServiceImpl extends
PagingServiceImpl<OutQaMedPatListDTO> implements IOutQaMedPatListQryService{

	@Override
	public PagingRtnData<OutQaMedPatListDTO> getOutQaPatListDtos(
			QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo)
			throws BizException {
		IQrySQLGeneratorService service = ServiceFinder
				.find(IQrySQLGeneratorService.class);
		String sqlwhere = "1=1";
		if (qryRootNodeDTO != null) {
			sqlwhere += "  AND "
					+ service.getQueryStringWithoutDesc(qryRootNodeDTO);
		}

		StringBuilder sb = new StringBuilder();
		sb.append("SELECT EN.ID_ENT AS ID_ENT,");
		sb.append("EN.CODE AS CODE_ENT,");
		sb.append("OP.CODE_AMR_OEP AS CODE_AMR_OEP,");
		sb.append("OP.TIMES_OP AS TIMES_OP,");
		sb.append("EN.ID_PAT AS ID_PAT,");
		sb.append("PAT.CODE AS CODE_PAT,");
		sb.append("EN.NAME_PAT AS NAME_PAT,");
		sb.append("EN.DT_BIRTH_PAT AS DT_BIRTH_PAT,");
		sb.append("EN.SD_SEX_PAT AS SD_SEX,");
		sb.append("SEX.NAME AS NAME_SEX,");
		sb.append("EN.TELNO_PAT AS TELNO_PAT,");
		sb.append("EN.SD_MARI_PAT AS SD_MARI_PAT,");
		sb.append("MARI.NAME AS NAME_MARI_PAT,");
		sb.append("EN.ID_DEP_PHY AS ID_DEP_PHY,");
		sb.append("DEP.NAME AS NAME_DEP_PHY,");
		sb.append("EN.ID_EMP_PHY AS ID_EMP_PHY,");
		sb.append("EMP.NAME AS NAME_EMP_PHY,");
		sb.append("EN.ID_HP AS ID_HP,");
		sb.append("HP.NAME AS NAME_HP,");
		sb.append("ENTHP.NO_HP AS NO_HP,");
		sb.append("EN.DT_ENTRY AS DT_ENTRY,");
		sb.append("EN.ID_PATCA AS ID_PATCA,");
		sb.append("PATCA.NAME AS NAME_PATCA,");
		sb.append("EN.ID_PRIPAT AS ID_PRIPAT,");
		sb.append("PRI.NAME AS NAME_PRIPAT,");
		sb.append("EN.ID_PATCRET AS ID_PATCRET,");
		sb.append("CRET.NAME AS NAME_PATCRET,");
		sb.append("DI.ID_DIDEF_DIS AS ID_DI,");
		sb.append("DI.NAME_DIDEF_DIS AS NAME_DI,");
		sb.append("DI.SUPPLEMENT AS SUPPLEMENT_DI ");
		sb.append("FROM EN_ENT EN ");
		sb.append("INNER JOIN EN_ENT_OP OP ON EN.ID_ENT = OP.ID_ENT ");
		sb.append("INNER JOIN PI_PAT PAT ON EN.ID_PAT = PAT.ID_PAT ");
		sb.append("LEFT JOIN BD_UDIDOC SEX ON EN.ID_SEX_PAT = SEX.ID_UDIDOC ");
		sb.append("LEFT JOIN BD_UDIDOC MARI ON EN.ID_MARI_PAT = MARI.ID_UDIDOC ");
		sb.append("LEFT JOIN BD_DEP DEP ON EN.ID_DEP_PHY = DEP.ID_DEP ");
		sb.append("LEFT JOIN BD_PSNDOC EMP ON EN.ID_EMP_PHY = EMP.ID_PSNDOC ");
		sb.append("LEFT JOIN BD_HP HP ON EN.ID_HP = HP.ID_HP ");
		sb.append("LEFT JOIN EN_ENT_HP ENTHP ON EN.ID_ENT = ENTHP.ID_ENT AND EN.ID_HP = ENTHP.ID_HP ");
		sb.append("LEFT JOIN PI_PAT_CA PATCA ON EN.ID_PATCA = PATCA.ID_PATCA ");
		sb.append("LEFT JOIN BD_PRI_PAT PRI ON EN.ID_PRIPAT = PRI.ID_PRIPAT ");
		sb.append("LEFT JOIN PI_PAT_CRET CRET ON EN.ID_PATCRET = CRET.ID_PATCRET ");
		sb.append("LEFT JOIN EN_ENT_DI DI ON EN.ID_ENT = DI.ID_ENT AND DI.FG_MAJ = 'Y' ");
		sb.append("WHERE " + sqlwhere + " AND ");
		sb.append("OP.SD_STATUS = '" + IEnDictCodeConst.SD_ENSTATUS_OP_FINISH
				+ "'");
		sb.append("AND EN.FG_CANC = 'N' ");
		String sqlStr = sb.toString();
		PagingRtnData<OutQaMedPatListDTO> pagingRtnData = super.findByPageInfo(
				new OutQaMedPatListDTO(), paginationInfo, sqlStr, "", null);

		return pagingRtnData;
	}

	@Override
	public PagingRtnData<OutQaMedPatListDTO> getOutQaToRandomPatListDtos(
			OutQaPatQryDTO qryDTO, PaginationInfo paginationInfo)
			throws BizException {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		sb.append("select *\n");
		sb.append("  from ( select distinct * from( SELECT EN.ID_ENT         AS ID_ENT,\n");
		sb.append("               EN.CODE           AS CODE_ENT,\n");
		sb.append("               OP.CODE_AMR_OEP   AS CODE_AMR_OEP,\n");
		sb.append("               OP.TIMES_OP       AS TIMES_OP,\n");
		sb.append("               EN.ID_PAT         AS ID_PAT,\n");
		sb.append("               PAT.CODE          AS CODE_PAT,\n");
		sb.append("               EN.NAME_PAT       AS NAME_PAT,\n");
		sb.append("               EN.DT_BIRTH_PAT   AS DT_BIRTH_PAT,\n");
		sb.append("               EN.SD_SEX_PAT     AS SD_SEX,\n");
		sb.append("               SEX.NAME          AS NAME_SEX,\n");
		sb.append("               EN.TELNO_PAT      AS TELNO_PAT,\n");
		sb.append("               EN.SD_MARI_PAT    AS SD_MARI_PAT,\n");
		sb.append("               MARI.NAME         AS NAME_MARI_PAT,\n");
		sb.append("               EN.ID_DEP_PHY     AS ID_DEP_PHY,\n");
		sb.append("               DEP.NAME          AS NAME_DEP_PHY,\n");
		sb.append("               EN.ID_EMP_PHY     AS ID_EMP_PHY,\n");
		sb.append("               EMP.NAME          AS NAME_EMP_PHY,\n");
		sb.append("               EN.ID_HP          AS ID_HP,\n");
		sb.append("               HP.NAME           AS NAME_HP,\n");
		sb.append("               ENTHP.NO_HP       AS NO_HP,\n");
		sb.append("               EN.DT_ENTRY       AS DT_ENTRY,\n");
		sb.append("               EN.ID_PATCA       AS ID_PATCA,\n");
		sb.append("               PATCA.NAME        AS NAME_PATCA,\n");
		sb.append("               EN.ID_PRIPAT      AS ID_PRIPAT,\n");
		sb.append("               PRI.NAME          AS NAME_PRIPAT,\n");
		sb.append("               EN.ID_PATCRET     AS ID_PATCRET,\n");
		sb.append("               CRET.NAME         AS NAME_PATCRET,\n");
		sb.append("               DI.ID_DIDEF_DIS   AS ID_DI,\n");
		sb.append("               DI.NAME_DIDEF_DIS AS NAME_DI,\n");
		sb.append("               DI.SUPPLEMENT     AS SUPPLEMENT_DI,\n");
		sb.append("               AMR.ID_ENHR       AS ID_ENHR\n");
		sb.append("          FROM EN_ENT EN\n");
		sb.append("         INNER JOIN EN_ENT_OP OP\n");
		sb.append("            ON EN.ID_ENT = OP.ID_ENT\n");
		sb.append("         INNER JOIN PI_PAT PAT\n");
		sb.append("            ON EN.ID_PAT = PAT.ID_PAT\n");
		sb.append("          LEFT JOIN CI_AMR AMR\n");
		sb.append("            ON EN.ID_ENT = AMR.ID_ENT\n");
		sb.append("          LEFT JOIN BD_UDIDOC SEX\n");
		sb.append("            ON EN.ID_SEX_PAT = SEX.ID_UDIDOC\n");
		sb.append("          LEFT JOIN BD_UDIDOC MARI\n");
		sb.append("            ON EN.ID_MARI_PAT = MARI.ID_UDIDOC\n");
		sb.append("          LEFT JOIN BD_DEP DEP\n");
		sb.append("            ON EN.ID_DEP_PHY = DEP.ID_DEP\n");
		sb.append("          LEFT JOIN BD_PSNDOC EMP\n");
		sb.append("            ON EN.ID_EMP_PHY = EMP.ID_PSNDOC\n");
		sb.append("          LEFT JOIN BD_HP HP\n");
		sb.append("            ON EN.ID_HP = HP.ID_HP\n");
		sb.append("          LEFT JOIN EN_ENT_HP ENTHP\n");
		sb.append("            ON EN.ID_ENT = ENTHP.ID_ENT\n");
		sb.append("           AND EN.ID_HP = ENTHP.ID_HP\n");
		sb.append("          LEFT JOIN PI_PAT_CA PATCA\n");
		sb.append("            ON EN.ID_PATCA = PATCA.ID_PATCA\n");
		sb.append("          LEFT JOIN BD_PRI_PAT PRI\n");
		sb.append("            ON EN.ID_PRIPAT = PRI.ID_PRIPAT\n");
		sb.append("          LEFT JOIN PI_PAT_CRET CRET\n");
		sb.append("            ON EN.ID_PATCRET = CRET.ID_PATCRET\n");
		sb.append("          LEFT JOIN EN_ENT_DI DI\n");
		sb.append("            ON EN.ID_ENT = DI.ID_ENT\n");
		sb.append("           AND DI.FG_MAJ = 'Y'\n");
		sb.append("          left join ci_mr_qc_record_itm ci_mr_qc_record_itm\n ");
		sb.append("            on en.id_ent=ci_mr_qc_record_itm.id_ent \n ");
		sb.append("          left join ci_mr ci_mr\n ");
		sb.append("            on ci_mr.id_ent=en.id_ent \n ");
		sb.append("          left join bd_mrca_ctm bd_mrca_ctm\n ");
		sb.append("            on bd_mrca_ctm.id_mrcactm=ci_mr.id_mrcactm \n ");
		sb.append("         WHERE 1 = 1\n");
		sb.append("           AND OP.SD_STATUS = '08'\n");
		sb.append("           AND EN.FG_CANC = 'N'\n");
//		sb.append("           AND EN.ID_DEP_PHY = '"+Context.get().getDeptId()+"'\n");
		if(qryDTO.getId_dep_phy()!=null)
			sb.append("           AND DEP.NAME  in ('"+qryDTO.getId_dep_phy().replaceAll(",", "','")+"') \n");
		if(qryDTO.getId_emp_phy()!=null)
			sb.append("           AND EN.ID_EMP_PHY in ('"+qryDTO.getId_emp_phy().replaceAll(",", "','")+"') \n");
		if(qryDTO.getName_pat()!=null)
			sb.append("           AND EN.NAME_PAT = '"+qryDTO.getName_pat()+"'\n");
		if(qryDTO.getCode()!=null)
			sb.append("           AND EN.CODE = '"+qryDTO.getCode()+"'\n");
		if(qryDTO.getDt_entry_start()!=null&&qryDTO.getDt_entry_end()!=null)
			sb.append("           AND (EN.DT_ENTRY >= '"+qryDTO.getDt_entry_start()+"' and EN.DT_ENTRY<='"+qryDTO.getDt_entry_end()+"')\n");
		if(qryDTO.getFg_mr()!=null&&qryDTO.getFg_mr().equals(FBoolean.TRUE))
			sb.append("        and ci_mr.id_mr is not null and ci_mr.ds=0 and ci_mr.sd_su_mr <> '00' and bd_mrca_ctm.docornur in (10,30) \n");
		if(qryDTO.getFg_random()!=null&&qryDTO.getFg_random().equals(FBoolean.TRUE))
			sb.append("       AND EN.id_ent not in( select ci_mr_qc_record_itm.id_ent from ci_mr_qc_record_itm  ) \n ");
		sb.append("        ) order by dbms_random.value())\n");
		if(qryDTO.getTimes_random()!=null)
			sb.append(" where rownum <= "+qryDTO.getTimes_random()+"");

		String sqlStr = sb.toString();
		PagingRtnData<OutQaMedPatListDTO> pagingRtnData = super.findByPageInfo(
				new OutQaMedPatListDTO(), paginationInfo, sqlStr, "", null);

		return pagingRtnData;
	}

	@Override
	public PagingRtnData<OutQaMedPatListDTO> getOutQaHasRandomPatListDtos(
			OutQaPatQryDTO qryDTO, PaginationInfo paginationInfo)
			throws BizException {
		StringBuilder sb = new StringBuilder();
			sb.append("SELECT EN.ID_ENT         AS ID_ENT,\n" );
			sb.append("       EN.CODE           AS CODE_ENT,\n" );
			sb.append("       OP.CODE_AMR_OEP   AS CODE_AMR_OEP,\n" ); 
			sb.append("       OP.TIMES_OP       AS TIMES_OP,\n" ); 
			sb.append("       EN.ID_PAT         AS ID_PAT,\n" ); 
			sb.append("       PAT.CODE          AS CODE_PAT,\n" ); 
			sb.append("       EN.NAME_PAT       AS NAME_PAT,\n" ); 
			sb.append("       EN.DT_BIRTH_PAT   AS DT_BIRTH_PAT,\n" ); 
			sb.append("       EN.SD_SEX_PAT     AS SD_SEX,\n" ); 
			sb.append("       SEX.NAME          AS NAME_SEX,\n" ); 
			sb.append("       EN.TELNO_PAT      AS TELNO_PAT,\n" ); 
			sb.append("       EN.SD_MARI_PAT    AS SD_MARI_PAT,\n" ); 
			sb.append("       MARI.NAME         AS NAME_MARI_PAT,\n" ); 
			sb.append("       EN.ID_DEP_PHY     AS ID_DEP_PHY,\n" ); 
			sb.append("       DEP.NAME          AS NAME_DEP_PHY,\n" ); 
			sb.append("       EN.ID_EMP_PHY     AS ID_EMP_PHY,\n" ); 
			sb.append("       EMP.NAME          AS NAME_EMP_PHY,\n" ); 
			sb.append("       EN.ID_HP          AS ID_HP,\n" ); 
			sb.append("       HP.NAME           AS NAME_HP,\n" ); 
			sb.append("       ENTHP.NO_HP       AS NO_HP,\n" ); 
			sb.append("       EN.DT_ENTRY       AS DT_ENTRY,\n" ); 
			sb.append("       DI.ID_DIDEF_DIS   AS ID_DI,\n" ); 
			sb.append("       DI.NAME_DIDEF_DIS AS NAME_DI,\n" ); 
			sb.append("       DI.SUPPLEMENT     AS SUPPLEMENT_DI,\n" ); 
			sb.append("       AMR.ID_ENHR       AS ID_ENHR ,\n" ); 
			sb.append("       CASC.ID_EMP_CHECK AS ID_EMP_CHECK,\n" ); 
			sb.append("       SU.NAME           AS NAME_EMP_CHECK,\n" ); 
			sb.append("       CASC.SCORE_EMP_CHECK AS SCORE_EMP_CHECK\n" ); 
			sb.append("       CASC.ID_SPOT_CHECK AS ID_SPOT_CHECK\n" ); 
			sb.append("  FROM CI_AMR_SPOT_CHECK CASC\n" ); 
			sb.append("  LEFT JOIN EN_ENT EN\n" ); 
			sb.append("  ON CASC.ID_ENT=EN.ID_ENT AND EN.FG_CANC = 'N'\n" ); 
			sb.append(" LEFT JOIN EN_ENT_OP OP\n" ); 
			sb.append("    ON EN.ID_ENT = OP.ID_ENT AND OP.SD_STATUS = '08'\n" ); 
			sb.append(" LEFT JOIN PI_PAT PAT\n" ); 
			sb.append("    ON EN.ID_PAT = PAT.ID_PAT\n" ); 
			sb.append("  LEFT JOIN CI_AMR AMR\n" ); 
			sb.append("    ON EN.ID_ENT = AMR.ID_ENT\n" ); 
			sb.append("  LEFT JOIN BD_UDIDOC SEX\n" ); 
			sb.append("    ON EN.ID_SEX_PAT = SEX.ID_UDIDOC\n" ); 
			sb.append("  LEFT JOIN BD_UDIDOC MARI\n" ); 
			sb.append("    ON EN.ID_MARI_PAT = MARI.ID_UDIDOC\n" ); 
			sb.append("  LEFT JOIN BD_DEP DEP\n" ); 
			sb.append("    ON EN.ID_DEP_PHY = DEP.ID_DEP\n" ); 
			sb.append("  LEFT JOIN BD_PSNDOC EMP\n" ); 
			sb.append("    ON EN.ID_EMP_PHY = EMP.ID_PSNDOC\n" ); 
			sb.append("  LEFT JOIN BD_HP HP\n" ); 
			sb.append("    ON EN.ID_HP = HP.ID_HP\n" ); 
			sb.append("  LEFT JOIN EN_ENT_HP ENTHP\n" ); 
			sb.append("    ON EN.ID_ENT = ENTHP.ID_ENT\n" ); 
			sb.append("   AND EN.ID_HP = ENTHP.ID_HP\n" ); 
			sb.append("  LEFT JOIN EN_ENT_DI DI\n" ); 
			sb.append("    ON EN.ID_ENT = DI.ID_ENT\n" ); 
			sb.append("   AND DI.FG_MAJ = 'Y'\n" ); 
			sb.append("  LEFT JOIN SYS_USER SU\n" ); 
			sb.append("    ON CASC.ID_EMP_CHECK=SU.ID_USER\n" ); 
			sb.append(" WHERE  CASC.ID_CHECK_STATUS='"+ICiMrDictCodeConst.ID_MR_RANDOMQCCHECK_HASCHECK+"'  ");
			if(qryDTO.getId_dep_phy()!=null)
				sb.append("           AND EN.ID_DEP_PHY in ('"+qryDTO.getId_dep_phy().replaceAll(",", "','")+"') \n");
			if(qryDTO.getId_emp_phy()!=null)
				sb.append("           AND EN.ID_EMP_PHY in ('"+qryDTO.getId_emp_phy().replaceAll(",", "','")+"') \n");
			if(qryDTO.getName_pat()!=null)
				sb.append("           AND EN.NAME_PAT = '"+qryDTO.getName_pat()+"'\n");
			if(qryDTO.getCode()!=null)
				sb.append("           AND EN.CODE = '"+qryDTO.getCode()+"'\n");
			if(qryDTO.getDt_entry_start()!=null&&qryDTO.getDt_entry_end()!=null)
				sb.append("           AND CASC.DT_CHECK >= '"+qryDTO.getDt_entry_start()+"' and CASC.CHECK<='"+qryDTO.getDt_entry_end()+"'\n");
			
			String sqlStr = sb.toString();
			PagingRtnData<OutQaMedPatListDTO> pagingRtnData = super.findByPageInfo(
					new OutQaMedPatListDTO(), paginationInfo, sqlStr, "", null);

			return pagingRtnData;
	}

	@Override
	public PagingRtnData<OutQaMedPatListDTO> getOutQaTracePatListDtos(
			OutQaPatQryDTO qryDTO, PaginationInfo paginationInfo)
			throws BizException {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT EN.ID_ENT         AS ID_ENT,\n" );
		sb.append("       EN.CODE           AS CODE_ENT,\n" );
		sb.append("       OP.CODE_AMR_OEP   AS CODE_AMR_OEP,\n" ); 
		sb.append("       OP.TIMES_OP       AS TIMES_OP,\n" ); 
		sb.append("       EN.ID_PAT         AS ID_PAT,\n" ); 
		sb.append("       PAT.CODE          AS CODE_PAT,\n" ); 
		sb.append("       EN.NAME_PAT       AS NAME_PAT,\n" ); 
		sb.append("       EN.DT_BIRTH_PAT   AS DT_BIRTH_PAT,\n" ); 
		sb.append("       EN.SD_SEX_PAT     AS SD_SEX,\n" ); 
		sb.append("       SEX.NAME          AS NAME_SEX,\n" ); 
		sb.append("       EN.TELNO_PAT      AS TELNO_PAT,\n" ); 
		sb.append("       EN.SD_MARI_PAT    AS SD_MARI_PAT,\n" ); 
		sb.append("       MARI.NAME         AS NAME_MARI_PAT,\n" ); 
		sb.append("       EN.ID_DEP_PHY     AS ID_DEP_PHY,\n" ); 
		sb.append("       DEP.NAME          AS NAME_DEP_PHY,\n" ); 
		sb.append("       EN.ID_EMP_PHY     AS ID_EMP_PHY,\n" ); 
		sb.append("       EMP.NAME          AS NAME_EMP_PHY,\n" ); 
		sb.append("       EN.ID_HP          AS ID_HP,\n" ); 
		sb.append("       HP.NAME           AS NAME_HP,\n" ); 
		sb.append("       ENTHP.NO_HP       AS NO_HP,\n" ); 
		sb.append("       EN.DT_ENTRY       AS DT_ENTRY,\n" ); 
		sb.append("       DI.ID_DIDEF_DIS   AS ID_DI,\n" ); 
		sb.append("       DI.NAME_DIDEF_DIS AS NAME_DI,\n" ); 
		sb.append("       DI.SUPPLEMENT     AS SUPPLEMENT_DI,\n" ); 
		sb.append("       AMR.ID_ENHR       AS ID_ENHR ,\n" ); 
		sb.append("       CASC.ID_EMP_CHECK AS ID_EMP_CHECK,\n" ); 
		sb.append("       SU.NAME           AS NAME_EMP_CHECK,\n" ); 
		sb.append("       CASC.SCORE_EMP_CHECK AS SCORE_EMP_CHECK\n" ); 
		sb.append("       CASC.ID_SPOT_CHECK AS ID_SPOT_CHECK\n" ); 
		sb.append("  FROM CI_AMR_SPOT_CHECK CASC\n" ); 
		sb.append("  LEFT JOIN EN_ENT EN\n" ); 
		sb.append("  ON CASC.ID_ENT=EN.ID_ENT AND EN.FG_CANC = 'N'\n" ); 
		sb.append(" LEFT JOIN EN_ENT_OP OP\n" ); 
		sb.append("    ON EN.ID_ENT = OP.ID_ENT AND OP.SD_STATUS = '08'\n" ); 
		sb.append(" LEFT JOIN PI_PAT PAT\n" ); 
		sb.append("    ON EN.ID_PAT = PAT.ID_PAT\n" ); 
		sb.append("  LEFT JOIN CI_AMR AMR\n" ); 
		sb.append("    ON EN.ID_ENT = AMR.ID_ENT\n" ); 
		sb.append("  LEFT JOIN BD_UDIDOC SEX\n" ); 
		sb.append("    ON EN.ID_SEX_PAT = SEX.ID_UDIDOC\n" ); 
		sb.append("  LEFT JOIN BD_UDIDOC MARI\n" ); 
		sb.append("    ON EN.ID_MARI_PAT = MARI.ID_UDIDOC\n" ); 
		sb.append("  LEFT JOIN BD_DEP DEP\n" ); 
		sb.append("    ON EN.ID_DEP_PHY = DEP.ID_DEP\n" ); 
		sb.append("  LEFT JOIN BD_PSNDOC EMP\n" ); 
		sb.append("    ON EN.ID_EMP_PHY = EMP.ID_PSNDOC\n" ); 
		sb.append("  LEFT JOIN BD_HP HP\n" ); 
		sb.append("    ON EN.ID_HP = HP.ID_HP\n" ); 
		sb.append("  LEFT JOIN EN_ENT_HP ENTHP\n" ); 
		sb.append("    ON EN.ID_ENT = ENTHP.ID_ENT\n" ); 
		sb.append("   AND EN.ID_HP = ENTHP.ID_HP\n" ); 
		sb.append("  LEFT JOIN EN_ENT_DI DI\n" ); 
		sb.append("    ON EN.ID_ENT = DI.ID_ENT\n" ); 
		sb.append("   AND DI.FG_MAJ = 'Y'\n" ); 
		sb.append("  LEFT JOIN SYS_USER SU\n" ); 
		sb.append("    ON CASC.ID_EMP_CHECK=SU.ID_USER\n" ); 
		sb.append(" WHERE  CASC.ID_CHECK_STATUS='"+ICiMrDictCodeConst.ID_MR_RANDOMQCCHECK_EXAMINEPASS+"'  ");
		if(qryDTO.getId_dep_phy()!=null)
			sb.append("           AND EN.ID_DEP_PHY in ('"+qryDTO.getId_dep_phy().replaceAll(",", "','")+"') \n");
		if(qryDTO.getId_emp_phy()!=null)
			sb.append("           AND EN.ID_EMP_PHY in ('"+qryDTO.getId_emp_phy().replaceAll(",", "','")+"') \n");
		if(qryDTO.getName_pat()!=null)
			sb.append("           AND EN.NAME_PAT = '"+qryDTO.getName_pat()+"'\n");
		if(qryDTO.getCode()!=null)
			sb.append("           AND EN.CODE = '"+qryDTO.getCode()+"'\n");
		if(qryDTO.getDt_entry_start()!=null&&qryDTO.getDt_entry_end()!=null)
			sb.append("           AND CASC.DT_CHECK >= '"+qryDTO.getDt_entry_start()+"' and CASC.CHECK<='"+qryDTO.getDt_entry_end()+"'\n");
		
		String sqlStr = sb.toString();
		PagingRtnData<OutQaMedPatListDTO> pagingRtnData = super.findByPageInfo(
				new OutQaMedPatListDTO(), paginationInfo, sqlStr, "", null);

		return pagingRtnData;
	}

}
