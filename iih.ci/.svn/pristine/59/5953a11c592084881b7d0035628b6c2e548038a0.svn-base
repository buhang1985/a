package iih.ci.ord.s.ems.op.bloodbadreaction.bp;


import java.util.List;

import iih.ci.ord.bloodbadreaction.d.CiBloodAdverseReactionDO;
import iih.ci.ord.cibloodadversereactioncount.d.CiBloodAdverseReactionCountDTO;
import iih.ci.ord.s.ems.op.bloodbadreaction.qry.GetBloodBadReactionCountDOQry;
import iih.ci.ord.s.ems.op.bloodbadreaction.qry.GetBloodBadReactionDOQry;
import xap.mw.core.constenum.DefaultConstEnum;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FDate;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
import xap.sys.appfw.xapformula.utils.AgeCalcUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.permfw.dataper.d.systemEnum;

/**
 * 输血不良反应统计BP
 * @author yzh
 *
 */
public class BloodBadReactionCountBP {
	//开始时间
	private static String qry_begin_date = "qry_begin_date";
	//截止时间
	private static String qry_end_date = "qry_end_date";
	//就诊类型
	private static String code_entp = "code_entp";
	//不良反应类型
	private static String bad_reaction_type = "bad_reaction_type";
	public PagingRtnData<CiBloodAdverseReactionCountDTO> qryCountData(QryRootNodeDTO qryRootNodeDTO, String orderStr,
			PaginationInfo pg) throws BizException {
		IQrySQLGeneratorService service = ServiceFinder.find(IQrySQLGeneratorService .class);
		FArrayList beginList = service.getQueryFieldValue(qryRootNodeDTO, qry_begin_date);
		FArrayList endList = service.getQueryFieldValue(qryRootNodeDTO, qry_end_date);
		FArrayList codeEntpList = service.getQueryFieldValue(qryRootNodeDTO, code_entp);
		FArrayList badReactionTypeList = service.getQueryFieldValue(qryRootNodeDTO, bad_reaction_type);
		String beginDate ="";
		String endDate = "";
		String codeEntp = "0";
		if(beginList != null) beginDate = beginList.get(0)+" 00:00:00";
		if(endList != null) endDate = endList.get(0)+" 23:59:59";
		String condition =""; 
		if(badReactionTypeList != null){
			DefaultConstEnum badreactiontype = (DefaultConstEnum)badReactionTypeList.get(0);
			String badreactiontypevalue = badreactiontype.getValue().toString();
			if("1".equals(badreactiontypevalue)){
				condition = " and blood.fg_tran_blood_bad_reaction='N'";
			}else if("0".equals(badreactiontypevalue)){
				condition = " and blood.fg_tran_blood_bad_reaction='Y'";
			}
		}
		
		if(codeEntpList != null){
			DefaultConstEnum codeentp = (DefaultConstEnum)codeEntpList.get(0);
			String codeentpvalue = codeentp.getValue().toString();
			if("00".equals(codeentpvalue)){
				codeEntp = codeentpvalue;
			}else if("10".equals(codeentpvalue)){
				codeEntp = codeentpvalue;
			}else{
				codeEntp = "0";
			}
		}
		
		
		ITransQry qry = new GetBloodBadReactionCountDOQry(beginDate, endDate, codeEntp, orderStr, condition);
		String sql  = qry.getQrySQLStr();
		PagingServiceImpl ps = new PagingServiceImpl();
		PagingRtnData<CiBloodAdverseReactionCountDTO> result = new PagingRtnData<CiBloodAdverseReactionCountDTO>();
		result = ps.findByPageInfo(new CiBloodAdverseReactionCountDTO(), pg, sql, null, null);
		FArrayList list = result.getPageData();
		for (int i = 0; i < list.size(); i++) {
			CiBloodAdverseReactionCountDTO dto = (CiBloodAdverseReactionCountDTO) list.get(i);
			if(dto.getAge() != null){
				dto.setAge(AgeCalcUtil.getAge(new FDate(dto.getAge())));
			}
		}
		
//		result.setPagingInfo(pg);
//		result.setPageData(datalist);
		
		return result;
	}

	
}
