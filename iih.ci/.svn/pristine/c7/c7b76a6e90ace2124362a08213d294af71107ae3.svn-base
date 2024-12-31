package iih.ci.ord.s.bp;

import iih.bd.srv.srvcate.d.SrvCateDO;
import iih.bd.srv.srvcate.d.desc.SrvCateDODesc;
import iih.bd.srv.srvcate.i.ISrvcateRService;
import iih.ci.ord.dto.orobsandlab.d.OrObsAandLabDTO;
import iih.ci.ord.s.bp.qry.getObsAndLabListQry;
import iih.ci.sdk.utils.ObjectUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.utils.AppFwUtil;

public class getObsAndLabListBP {
	
	 /**
     * 检查 检验报告的类别分类数据
     * @param id_ent
     * @return OrObsAandLabDTO[]
     * @throws BizException
     */
   public  OrObsAandLabDTO[] exec(String id_ent,String type)throws BizException{
		if (!ObjectUtils.isEmpty(id_ent) && !ObjectUtils.isEmpty(type)) {
			getObsAndLabListQry qry = new getObsAndLabListQry(id_ent, type);
			OrObsAandLabDTO[] rnt = (OrObsAandLabDTO[]) AppFwUtil.getDORstWithDao(qry, OrObsAandLabDTO.class);
			return rnt;
		}
		return null;
   }
   
   /**
    * 获取id_srv作为in条件
    * @param id_ent
    * @param type  检查检验不同报告类型分开处理
    * @return
    * @throws BizException
    */
   public SrvCateDO[] GetId_srv(String id_ent,String type)throws BizException{
		if (!ObjectUtils.isEmpty(id_ent) && !ObjectUtils.isEmpty(type)) {
			String str="";
			if ("lab".equals(type)) {// 检验
				str = GetLabSql(id_ent);
			} else if ("obs".equals(type)) {// 检查
				str = GetObsSql(id_ent);
			}
			ISrvcateRService service = (ISrvcateRService) ServiceFinder.find(ISrvcateRService.class);
			return service.find(SrvCateDODesc.TABLE_ALIAS_NAME + "." + SrvCateDODesc.PRIMARYKEY_FIELDNAME + " in ("+ str + ")", SrvCateDO.SV + " desc", FBoolean.FALSE);
		}
	   return  null;
   }



	/**
    * 检查 检验报告的时间分类数据
    * @param id_ent
    * @return OrObsAandLabDTO[]
    * @throws BizException
    */
	public OrObsAandLabDTO[] execDateList(String id_ent, String type) throws BizException {
		if (!ObjectUtils.isEmpty(id_ent) && !ObjectUtils.isEmpty(type)) {
			getObsAndLabListQry qry = new getObsAndLabListQry(id_ent, type);
			OrObsAandLabDTO[] rnt = (OrObsAandLabDTO[]) AppFwUtil.getDORstWithDao(qry, OrObsAandLabDTO.class);
			return rnt;
		}
		return null;
	}
   
   /**
    * 检验报告ci_rpt_lab
    * @param id_ent
    * @return
    */
   private String GetLabSql(String id_ent) {
		  StringBuilder sb = new StringBuilder();
		  sb.append("select distinct srv.ID_SRVCA from ci_rpt_lab lab ");
		  sb.append("left join CI_ORDER ci on lab.ID_OR=ci.ID_OR ");
		  sb.append("left join bd_srv srv on srv.ID_SRV=ci.id_srv ");
		  sb.append("where lab.id_ent = '"+id_ent +"'");
		  return sb.toString();
   }
   /**
    * 检查ci_rpt_obs
    * @param id_ent
    * @return
    */
   private String GetObsSql(String id_ent){
	   StringBuilder sb = new StringBuilder();
	  sb.append("select distinct srv.ID_SRVCA from ci_rpt_obs obs ");
	  sb.append("left join CI_ORDER ci on obs.ID_OR = ci.ID_OR ");
	  sb.append("left join bd_srv srv on srv.ID_SRV = ci.id_srv ");
	  sb.append("where obs.id_ent = '"+id_ent +"'");
	  return sb.toString();
   }

}
