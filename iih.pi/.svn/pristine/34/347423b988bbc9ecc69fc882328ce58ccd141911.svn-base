package iih.pi.card.s.bp.cardrtnrpt.qry;

import org.apache.commons.lang.StringUtils;

import iih.pi.card.dto.d.CardrtnrptDTO;
import iih.pi.dic.cardtype.d.CardDTO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.appfw.tmpl.qryscheme.QuerySQLFactory;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 患者卡操作查询患者信息
 * @author:hanjq
 * @date  :2020年6月10日
 */
public class FindPatCardsBP {

	public PagingRtnData<CardDTO> exec(PaginationInfo pg, QryRootNodeDTO qryNode) throws BizException {
		PagingServiceImpl<CardDTO> pagingServiceImpl = new PagingServiceImpl<CardDTO>();
		PagingRtnData<CardDTO> pRtnData = pagingServiceImpl.findByPageInfo(new CardDTO(), pg,
				this.GetSql(qryNode), null, new SqlParam());
		return pRtnData;
	}
	
	private String GetSql(QryRootNodeDTO qryRootNodeDTO) throws BizException{
		StringBuilder sql = new StringBuilder();
		sql.append("select	distinct	");
		sql.append("	patcard.Id_patcard,pat.Id_pat,patcard.Id_patcardtp,patcard.sd_patcardtp Patcardtpcode,	");
		sql.append("	cardtp.name Patcardtpname,cardtp.id_patcardtp Id_cardtp,bdu.name Cardtpname,	");
		sql.append("	card.Code,card.eu_cardsu Id_cardsu,card.Id_card,pat.code Code_pat, pat.name Name_pat	");
		sql.append("from pi_card card		");
		sql.append("join pi_pat_card patcard on patcard.id_card = card.id_card		");
		sql.append("join pi_pat pat on pat.id_pat = patcard.id_pat		");
		sql.append("join pi_pat_cardtp cardtp on patcard.id_patcardtp = cardtp.id_cardtp		");
		sql.append("join bd_udidoc bdu on bdu.id_udidoc = cardtp.id_patcardtp		");
		sql.append("join pi_card_act card_act on card.id_card=card_act.id_card		");
		sql.append("where 1=1		");
		String wherePart = "";
		if(StringUtils.isNotBlank(wherePart)){
			sql.append("and ").append(wherePart);
		}
//		if ((qryRootNodeDTO != null) && (qryRootNodeDTO.getChildCount() > 0)) {
//			wherePart = new QuerySQLFactory().create(qryRootNodeDTO);
//		}
		IQrySQLGeneratorService qrySQLGeneratorService = ServiceFinder.find(IQrySQLGeneratorService.class);
		String wherePart2 = qrySQLGeneratorService.getQueryStringWithoutDesc(qryRootNodeDTO);
		if (!StringUtils.isEmpty(wherePart2)) {
			sql.append(" AND ");
			sql.append(wherePart2);
		}
		
		return sql.toString();		
	}
}
