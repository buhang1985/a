package iih.ci.rcm.contagionrecordop.s;

import iih.ci.rcm.contagion.d.ContagionDO;
import iih.ci.rcm.contagionrecordop.d.ContagionRecordOpDTO;
import iih.ci.rcm.contagionrecordop.i.IContagionRecordQryService;

import java.util.List;

import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.FArrayList;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
import xap.sys.appfw.xapformula.utils.AgeCalcUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

@Service(serviceInterfaces = { IContagionRecordQryService.class }, binding = Binding.JSONRPC)
public class IContagionRecordQryServiceImpl extends
		PagingServiceImpl<ContagionRecordOpDTO> implements
		IContagionRecordQryService {

	public PagingRtnData<ContagionRecordOpDTO> getOpContagionQryDTOList(
			QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo)
			throws BizException {

		IQrySQLGeneratorService service = ServiceFinder
				.find(IQrySQLGeneratorService.class);
		String sqlwhere = "ccc.ds <> '1' and ent.id_org = '"+ Context.get().getOrgId() +"'";
		if (qryRootNodeDTO != null) {
			String [] qryfiles = new String[]{"dep.id_dep","def.id_didef","ent.dt_acpt","pat.name","pat.barcode_chis","iscontagion","entp.id_entp","op.fg_first","def.fg_ur"};
			FArrayList[] nodeValues = service.getQueryFieldValues(qryRootNodeDTO, qryfiles);
			StringBuffer buff = new StringBuffer();
			if(nodeValues != null && nodeValues.length > 0){
				for(int i = 0 ; i < nodeValues.length ; i++){
					FArrayList attrName = nodeValues[i];
					if(attrName != null){
//						if(i<(nodeValues.length) && nodeValues[i+1]!= null){
//							buff.append(" and ");
//						}
						
						if(i==1){
							String str= attrName.toString();
							str = str.replaceAll(",", "','");
							str = str.replace("[", "('");
							str = str.replace("]", "')");
							buff.append(" and "+qryfiles[i] +" in "+ str +" ");
						}
						
					if(i != 5 && i != 1 && i !=8){
						
						if(attrName.size()>1){
							buff.append(" and "+ qryfiles[i]+">= '"+attrName.get(0)+"' ");
							buff.append(" and "+qryfiles[i]+"<= '"+attrName.get(1)+"'");
						}else{
							buff.append(" and "+qryfiles[i]+"= '"+attrName.get(0)+"'");
						}
						
					}else if(i == 5){ 
						if(nodeValues[i].toString().equals("[Y]")){
							buff.append(" and ccc.id_contagion is not null ");
							buff.append(" and ccc.sd_con_cardsu <> '1' ");
						}else{
							buff.append(" and ( ccc.id_contagion is  null or ccc.sd_con_cardsu = '1') ");
//							buff.append(" or ccc.sd_con_cardsu = '1' ");
						}
					}
					
					}
					if(i == 8 && nodeValues[8] != null && nodeValues[1]==null){
						if(nodeValues[8].toString().equals("[Y]")){
							buff.append(" and def.id_didef in (select c.id_didef from bd_di_def c where c.fg_ur = 'Y' ) ");
						}else{
							buff.append(" and def.id_didef in (select c.id_didef from bd_di_def c where c.fg_ur = 'N' ) ");
						}
					}
				}
			}
			String sqls = buff.toString();
			sqlwhere += sqls;
		}

		StringBuilder sql = new StringBuilder();

		sql.append("select distinct \n");
		sql.append("       pat.barcode_chis as op_code,\n");
		sql.append("       pat.name as name_pat,\n");
		sql.append("       sexdoc.name as name_sex,\n");
		sql.append("       pat.dt_birth as exact_age,\n");
		sql.append("	   (select listagg(name, ',') within group(order by name) as name ");
		sql.append(" 	   from (select distinct id_didef_name name,id_en ");
		sql.append("	   from ci_di cd ");
		sql.append("	    left join ci_di_itm cdi on cdi.id_di = cd.id_di ");
		sql.append("       ) where id_en = ent.id_ent) as diagnose,");
		sql.append("       ent.dt_acpt as clinic_time,\n");
		sql.append("       op.fg_first as is_first_en,\n");
		sql.append("       ent.id_ent as id_ent,\n");
		sql.append("       ccc.id_contagion as def1 ,\n");
		sql.append(" ccc.sd_con_cardsu, ");
		sql.append("       dep.name as clinic_unit,\n");
		sql.append("       ent.dt_acpt as fbrq,\n");
		sql.append("       doc.name as profession,\n");
		sql.append(" entp.name as name_entp, ");
		sql.append("       ent.addr_pat as addr_now \n");
		sql.append("  from en_ent ent \n");
		sql.append(" left join en_ent_op op \n");
		sql.append("    on ent.id_ent = op.id_ent\n");
		sql.append("  inner join pi_pat pat \n");
		sql.append("    on pat.id_pat = ent.id_pat\n");
		sql.append("  inner join ci_di di \n");
		sql.append("    on di.id_en = ent.id_ent \n");
		sql.append("  inner join ci_di_itm itm \n");
		sql.append("    on itm.id_di = di.id_di\n");
		sql.append(" inner join bd_di_def def \n");
		sql.append("    on def.id_didef = itm.id_didef \n");
		sql.append("  inner join bd_dep dep \n");
		sql.append("    on dep.id_dep = ent.id_dep_phy");
		sql.append("  left join bd_udidoc doc \n");
		sql.append("    on doc.id_udidoc = pat.id_occu");
		sql.append("  left join bd_entp entp ");
		sql.append("    on ent.id_entp = entp.id_entp ");
		sql.append("  left join ci_mr cimr \n");
		sql.append("    on cimr.id_ent = ent.id_ent");
		sql.append(" left join bd_udidoc sexdoc \n");
		sql.append("    on sexdoc.id_udidoc = pat.id_sex \n");
		sql.append(" left join ci_contagion_card ccc \n");
		sql.append("    on ent.id_ent = ccc.id_ent \n");
		sql.append("       WHERE " + sqlwhere + " order by ent.dt_acpt desc");
		String sqlStr = sql.toString();
 		PagingRtnData<ContagionRecordOpDTO> pagingRtnData = super
				.findByPageInfo(new ContagionRecordOpDTO(), paginationInfo,
						sqlStr, "", null);

 		ContagionDO [] contagionDo = getIdent();
		FArrayList list = pagingRtnData.getPageData();
		for (Object dto : list) {
			ContagionRecordOpDTO data = (ContagionRecordOpDTO) dto;
			if (data.getIs_first_en() == FBoolean.TRUE) {
				data.setDef1("初诊");
			} else if (data.getIs_first_en() == FBoolean.FALSE) {
				data.setDef1("复诊");
			} else {
				data.setDef1("");
			}
			for(int i = 0 ; i<contagionDo.length ; i++){
				if(contagionDo[i].getId_ent() != null){
					if(data.getId_ent() == contagionDo[i].getId_ent() && (contagionDo[i].getSd_con_cardsu().equals("2") || (contagionDo[i].getSd_con_cardsu().equals("3") || (contagionDo[i].getSd_con_cardsu().equals("4"))))){
						data.setIscontagion(FBoolean.TRUE);
						break;
					}else{
						data.setIscontagion(FBoolean.FALSE);
					}
				}
			}
			if(data.getIscontagion() == FBoolean.TRUE){
				data.setDef2("有");
			}else if(data.getIscontagion() == FBoolean.FALSE){
				data.setDef2("无");
			}else{
				data.setDef2("");
			}
			String age = AgeCalcUtil.getAge(new FDate(data.getExact_age()));
			data.setExact_age(age);
		}

		return pagingRtnData;
	}

	@SuppressWarnings("unchecked")
	public ContagionRecordOpDTO[] getAllPageData() throws BizException {
		StringBuilder sql = new StringBuilder();

		sql.append("select distinct \n");
		sql.append("       pat.barcode_chis as op_code,\n");
		sql.append("       pat.name as name_pat,\n");
		sql.append("       sexdoc.name as name_sex,\n");
		sql.append("       pat.dt_birth as exact_age,\n");
		sql.append("	   (select listagg(name, ',') within group(order by name) as name ");
		sql.append(" 	   from (select distinct id_didef_name name,id_en ");
		sql.append("	   from ci_di cd ");
		sql.append("	    left join ci_di_itm cdi on cdi.id_di = cd.id_di ");
		sql.append("       ) where id_en = op.id_ent) as diagnose,");
		sql.append("       ent.dt_acpt as clinic_time,\n");
		sql.append("       op.fg_first as is_first_en,\n");
		sql.append("       op.id_ent as id_ent,\n");
		sql.append("       ccc.id_contagion as def1,\n");
		sql.append("       dep.name as clinic_unit,\n");
		sql.append("       ent.dt_acpt as fbrq,\n");
		sql.append("       doc.name as profession,\n");
		sql.append("       ent.addr_pat as addr_now \n");
		sql.append("  from en_ent_op op \n");
		sql.append(" inner join en_ent ent \n");
		sql.append("    on ent.id_ent = op.id_ent\n");
		sql.append("  inner join pi_pat pat \n");
		sql.append("    on pat.id_pat = ent.id_pat\n");
		sql.append("  inner join ci_di di \n");
		sql.append("    on di.id_en = ent.id_ent \n");
		sql.append("  inner join ci_di_itm itm \n");
		sql.append("    on itm.id_di = di.id_di\n");
		sql.append(" inner join bd_di_def def \n");
		sql.append("    on def.id_didef = itm.id_didef and def.fg_ur = 'Y' \n");
		sql.append("  inner join bd_dep dep \n");
		sql.append("    on dep.id_dep = ent.id_dep_phy");
		sql.append("  left join bd_udidoc doc \n");
		sql.append("    on doc.id_udidoc = pat.id_occu");
		sql.append(" left join bd_udidoc sexdoc \n");
		sql.append("    on sexdoc.id_udidoc = pat.id_sex \n");
		sql.append(" left join ci_contagion_card ccc \n");
		sql.append("    on op.id_ent = ccc.id_ent \n");
		sql.append("       WHERE 1=1 and ent.id_org = '"+ Context.get().getOrgId() +"' order by ent.dt_acpt desc");
		String sqlStr = sql.toString();
		DAFacade daf = new DAFacade();
		List<ContagionRecordOpDTO> listDto = (List<ContagionRecordOpDTO>) daf
				.execQuery(sqlStr, new BeanListHandler(
						ContagionRecordOpDTO.class));
		return listDto.toArray(new ContagionRecordOpDTO[0]);
	}
	
	public ContagionDO[] getIdent() throws BizException{
		StringBuilder sql = new StringBuilder();
		sql.append(" select ccc.id_ent,ccc.id_contagion,ccc.sd_con_cardsu from ci_contagion_card ccc ");
		String sqlStr = sql.toString();
		DAFacade daf = new DAFacade();
		List<ContagionDO> listDo = (List<ContagionDO>)daf.execQuery(sqlStr, new BeanListHandler(ContagionDO.class));
		return listDo.toArray(new ContagionDO[0]);
	}

}
