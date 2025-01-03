package iih.ci.diag.s.bp;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.diag.pub.CiDiagConstant;
import iih.ci.diag.pub.CommonUtil;
import iih.ci.diag.s.bp.qry.getDiTypeQry;
import iih.ci.diag.s.bp.qry.getDiTypeQryUdidoc;
import iih.ci.diag.s.bp.qry.getDiTypeQryUdidocList;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.xbd.udi.d.UdidocDO;

/**
 * 诊断过程
 * @author li_zheng
 *
 */
public class getDiTypeBP {

	/**
	 *  诊断过程的 下次诊断
	 * @param id_en
	 * @param org
	 * @param entp
	 * @return
	 * @throws BizException
	 */
	public UdidocDO[] getUdidocDO(String id_en,String org,String entp)throws BizException{
		 if(StringUtils.isBlank(id_en)) throw new BizException(" parameter: id_en  is null");
		 UdidocDO[] rtn = null;
	      //门诊  住院·
	/*	 if(entp != null && IEnDictCodeConst.SD_ENTP_OUTPATIENT.equals(entp)){//门诊
		     getDiTypeQryUdidoc qryUdidoc = new getDiTypeQryUdidoc(ICiDictCodeConst.ID_OPDI);
		     rtn = (UdidocDO[])AppFwUtil.getDORstWithDao(qryUdidoc, UdidocDO.class);
		     return rtn;
		 }*/
		 //住院/预住院
		 if(entp != null && (IBdFcDictCodeConst.SD_CODE_ENTP_IP.equals(entp) 
				 || IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS.equals(entp))
		         || IBdFcDictCodeConst.SD_CODE_ENTP_IP_PRE.equals(entp)){
			 //管控模式
			 /*2)	【住院诊断管理模式】 = 01不管控 时，不控制诊断类型的选择，由医生自己操作。
			 	诊断类型参照显示全部诊断类型。
			 3)	【住院诊断管理模式】 = 02严格管控时，*/
	          String param = CommonUtil.getIpDiControlMode(org);
			   if(param != null && CiDiagConstant.sys_IpDiControlMode_01.equals(param)){
				     getDiTypeQryUdidocList qryUdidoc = new getDiTypeQryUdidocList(ICiDictCodeConst.ID_process_udidoclist);
				     rtn = (UdidocDO[])AppFwUtil.getDORstWithDao(qryUdidoc, UdidocDO.class);
				    return rtn;
			   }
			 
			    getDiTypeQry qry = new getDiTypeQry(id_en);
			    rtn = (UdidocDO[])AppFwUtil.getDORstWithDao(qry, UdidocDO.class);
			    if(rtn == null  ||rtn.length == 0){
			    	//默认初步诊断
	    	    /* getDiTypeQryUdidoc qryUdidoc = new getDiTypeQryUdidoc(ICiDictCodeConst.ID_FIRST);
			        rtn = (UdidocDO[])AppFwUtil.getDORstWithDao(qryUdidoc, UdidocDO.class);
			       return rtn;*/
			       String IdType ="'"+ICiDictCodeConst.ID_FIRST+"','"+ICiDictCodeConst.ID_INHOSPITAL+"'";
				    return getCidiagType(IdType);
			  }
			  if(rtn != null && rtn.length>0){
				  UdidocDO udidoc = rtn[0];
				  if(udidoc.getCode() == ICiDictCodeConst.SD_INHOSPITAL){
					  return rtn; 
				  }else{
					    //其它是  修正诊断
					  getDiTypeQryUdidoc qryUdidoc = new getDiTypeQryUdidoc(ICiDictCodeConst.ID_AMEND);
					     rtn = (UdidocDO[])AppFwUtil.getDORstWithDao(qryUdidoc, UdidocDO.class);
					  return rtn;
				  }
			  }
		 }
	     return rtn;
	}
	/**
	 * 诊断类型
	 * @param IdTypes
	 * @return
	 * @throws BizException
	 */
	private  UdidocDO[] getCidiagType(String IdTypes)throws BizException{
		DAFacade dafacade =new DAFacade();
		String sql =" select  id_udidoc,code ,name from bd_udidoc where id_udidoc in ("+IdTypes+")";
	     List<UdidocDO>	list = (List<UdidocDO>)dafacade.execQuery(sql, new BeanListHandler(UdidocDO.class));
		 if(list != null && list.size() >0) return list.toArray(new UdidocDO[list.size()]);
	     return null;
	}
	
}
