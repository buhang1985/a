package iih.bl.cg.s.bp;

import iih.bl.pay.dto.d.PatInfoQryDTO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.service.time.TimeService;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

import com.mysql.jdbc.StringUtils;

/**
 * 查询门诊当天待收费的就诊信息
 * @param pageInfo 分页
 * @param qryNode 查询模板
 * @author liwq
 * @since 2018年2月3日21:04:09
 */
public class FindPatiEntInfoBp {

	public PatInfoQryDTO[] exec(QryRootNodeDTO qryNode) throws BizException {
		IQrySQLGeneratorService ser = (IQrySQLGeneratorService) ServiceFinder.find(IQrySQLGeneratorService.class);
		String whereStr = ser.getQueryStringWithoutDesc(qryNode);
	
		StringBuilder sb = new StringBuilder();
		sb.append("select ent.id_ent, ");
		sb.append("ent.id_dep_phy,dep.name as Name_ent_dep,       ");
		sb.append("pat.id_pat,pat.code as code_pat, pat.name as name_pat, ");
		sb.append("pat.id_sex,udi.name as sex_name,pat.mob  as telno ");
		sb.append("from  en_ent  ent                                  ");
		sb.append("inner join en_ent_op entop on entop.id_ent = ent.id_ent  ");
		sb.append("inner join pi_pat pat      on  ent.id_pat    = pat.id_pat ");
		sb.append("inner join  bd_dep  dep    on  ent.id_dep_phy = dep.id_dep ");
		sb.append("join bd_udidoc  udi  on pat.id_sex = udi.id_udidoc   ");
	
		sb.append("where  ent.code_entp = '00' and ent.fg_canc = 'N'            ");
		sb.append(" and ent.id_ent in ( select id_en from ci_order where fg_sign='Y' and substr(ci_order.dt_sign,0,10) =  to_char(sysdate,'yyyy-MM-dd') )  ");
		sb.append("and udi.id_udidoclist='@@@@ZZ20000000000035'         ");
		sb.append("and substr(ent.dt_acpt,0,10) =  to_char(sysdate,'yyyy-MM-dd')  ");
		if(!StringUtils.isEmptyOrWhitespaceOnly(whereStr))	
			sb.append(" and ").append(whereStr);
		
		List<PatInfoQryDTO> list  = (List<PatInfoQryDTO>)new DAFacade().execQuery(sb.toString(), new BeanListHandler(PatInfoQryDTO.class));
		return list.toArray(new PatInfoQryDTO[0]);
	}
}
