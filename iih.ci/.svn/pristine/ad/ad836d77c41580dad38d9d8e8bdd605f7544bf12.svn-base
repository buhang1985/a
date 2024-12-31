/*
 * 扼要描述
     * 详细描述：门诊病历打印（批量）
 * author：张静波
 * reviewer：xxx
 */

package iih.ci.mr.cimrbatchprintdto.s;

import java.util.List;

import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.ci.mr.cimrbatchprintdto.d.CiMrBatchPrintDTO;
import iih.ci.mr.cimrbatchprintdto.i.ICiMrBatchPrintCrudService;
import iih.ci.mrqc.cimrrecall.i.ICimrrecallCudService;
import iih.ci.mrqc.cimrrecall.i.ICimrrecallRService;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PiPatCardDO;
import iih.pi.reg.pat.i.IPatiMDORService;
import iih.pi.reg.pat.i.IPiPatCardDORService;

/**
 * 门诊病历打印（批量）
 * 查询列表、病历fs等
 * @author    张静波
 * @version   [1.0, 2018-07-10]
*/
@Service(serviceInterfaces={ICiMrBatchPrintCrudService.class}, binding=Binding.JSONRPC)
public class CiMrBatchPrintCrudServiceImpl implements
		ICiMrBatchPrintCrudService {

	
	@Override
	public CiMrBatchPrintDTO[] findByQCond(QryRootNodeDTO qryRootNodeDTO,
			String orderStr, FBoolean isLazy) throws BizException {
		// TODO Auto-generated method stub
		IQrySQLGeneratorService service=ServiceFinder.find(IQrySQLGeneratorService.class);
 		
		//当前人员id
		String psnId = Context.get().getStuffId();
		
		String sqlwhere = " where 1=1";
 		if (qryRootNodeDTO!=null){
 			sqlwhere += "  AND " + service.getQueryStringWithoutDesc(qryRootNodeDTO);
 		}
 		StringBuilder sql = getSoildSqlState(sqlwhere);
 		String sqlStr=sql.toString();
 		DAFacade da = new DAFacade();
 		List<CiMrBatchPrintDTO> lst =  (List<CiMrBatchPrintDTO>)da.execQuery(sqlStr, new  BeanListHandler(CiMrBatchPrintDTO.class));
		if(lst!=null&&lst.size()>0)
		{
			CiMrBatchPrintDTO[] arrBatch = lst.toArray(new CiMrBatchPrintDTO[lst.size()]);
			return arrBatch;
		}
		else
			return null;
	}
	
	/**
	 * 拼接查询语句
	 */
	private StringBuilder getSoildSqlState(String sqlWhere)
	{
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT EN.ID_ENT AS ID_ENT, ");
		sb.append("EN.CODE AS CODE_ENT,");
		sb.append("EN.ID_PAT AS ID_PAT,");
		sb.append("pat.code AS code_pat,");
		sb.append("pat.id_idtp AS id_identitytype,");
		sb.append("pat.sd_idtp AS sd_identitytype,");
		sb.append("pat.id_code AS no_identity,");
		sb.append("concat(area.fullname ,addr.street) AS addr_now_pat,");
		sb.append("EN.NAME_PAT AS NAME_PAT,");
		sb.append("EN.SD_SEX_PAT AS SD_SEX,");
		sb.append("SEX.NAME AS NAME_SEX,");
		sb.append("EN.TELNO_PAT AS tel_pat,");
		sb.append("EN.ID_DEP_PHY AS ID_DEP_PHY,");
		sb.append("DEP.NAME AS NAME_DEP_PHY,");
		sb.append("EN.ID_EMP_PHY AS ID_EMP_PHY,");
		sb.append("EMP.NAME AS NAME_EMP_PHY,");
		sb.append("EN.DT_ENTRY AS DT_ENTRY,");
		sb.append("EN.CODE AS serialno  ,");
		sb.append("mred.name_class,");
		sb.append("mred.dll_path,");
		sb.append("MR.name as name_mr,");
		sb.append("MR.id_mr as id_mr,");
		sb.append("MR.sd_mrtplstmd as sd_mrtplstmd,");
		sb.append("MR.url_file as url_file");
		sb.append(" FROM CI_MR MR ");
		sb.append(" Left Join EN_ENT EN on Mr.id_ent = EN.id_ent");
		sb.append(" left join pi_pat pat on pat.id_pat = en.id_pat ");
		sb.append(" left join pi_pat_addr addr on addr.id_pat = pat.id_pat ");
		sb.append(" left join bd_adminarea area on area.id_adminarea = addr.id_admdiv ");
		sb.append(" LEFT JOIN BD_DEP DEP ON EN.ID_DEP_PHY = DEP.ID_DEP ");
		sb.append(" LEFT JOIN BD_PSNDOC EMP ON EN.ID_EMP_PHY = EMP.ID_PSNDOC ");
		sb.append(" LEFT JOIN BD_UDIDOC SEX ON EN.ID_SEX_PAT = SEX.ID_UDIDOC ");
		sb.append(" Left Join bd_mrtpl  mrtpl on Mr.id_mrtpl = mrtpl.id_mrtpl");
		sb.append(" left join bd_mred mred on mrtpl.id_mred = mred.id_mred");
		sb.append(sqlWhere);
		sb.append(" and addr.sd_addrtp ='"+IPiDictCodeConst.SD_ADDR_TYPE_NOW+"'");
		sb.append(" and EN.CODE_ENTP='00' or EN.CODE_ENTP='01'");
		
		return sb;
	}

	
	public CiMrBatchPrintDTO[]  getMrListByBarCode(String barCode) throws BizException
	{
		
		IPiPatCardDORService cardSer = ServiceFinder.find(IPiPatCardDORService.class);
		IPatiMDORService patSer = ServiceFinder.find(IPatiMDORService.class);
		if(cardSer!=null)
		{
			PiPatCardDO[] cardDOs = cardSer.findByAttrValString("Code", barCode);
			if(cardDOs!=null&&cardDOs.length>0)
			{
				FDate fd = new FDate();
				String dt_start = fd.toString()+" 00:00:00";
				String dt_end = fd.toString()+" 23:59:59";
				/*PatDO pat = patSer.findById(cardDOs[0].getId_pat());*/
				String sqlWhere = "where pat.id_pat = "+cardDOs[0].getId_pat()
						+"' and en.dt_entry between '"+dt_start+"' and '"+dt_end+"'";
				StringBuilder sql = getSoildSqlState(sqlWhere);
		 		String sqlStr=sql.toString();
		 		DAFacade da = new DAFacade();
		 		List<CiMrBatchPrintDTO> lst =  (List<CiMrBatchPrintDTO>)da.execQuery(sqlStr, new  BeanListHandler(CiMrBatchPrintDTO.class));
				if(lst!=null&&lst.size()>0)
				{
					CiMrBatchPrintDTO[] arrBatch = lst.toArray(new CiMrBatchPrintDTO[lst.size()]);
					return arrBatch;
				}
				
			}
			return null;
		}
		else
			return null;
		
	}
	
	public PatDO  getPatDOByBarCode(String barCode) throws BizException
	{
		
		IPiPatCardDORService cardSer = ServiceFinder.find(IPiPatCardDORService.class);
		IPatiMDORService patSer = ServiceFinder.find(IPatiMDORService.class);
		if(cardSer!=null&&patSer!=null)
		{
			PiPatCardDO[] cardDOs = cardSer.findByAttrValString("Code", barCode);
			if(cardDOs!=null&&cardDOs.length>0)
			{
				FDate fd = new FDate();
				String dt_start = fd.toString()+" 00:00:00";
				String dt_end = fd.toString()+" 23:59:59";
				PatDO pat = patSer.findById(cardDOs[0].getId_pat());
				return pat;
			}
			return null;
		}
		else
			return null;
		
	}
}
