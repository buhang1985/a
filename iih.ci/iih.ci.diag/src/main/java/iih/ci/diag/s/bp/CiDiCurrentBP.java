package iih.ci.diag.s.bp;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.diag.cidiag.d.CiDiagDO;
import iih.ci.diag.cidiag.d.CidiagAggDO;
import iih.ci.diag.cidiag.d.desc.CiDiagDODesc;
import iih.ci.diag.s.CiDiUtils;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
 
import xap.mw.coreitf.d.FBoolean;
 
import xap.sys.appfw.orm.utils.DOUtil;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 本次就诊的所有诊断
 * @author li_zheng
 *
 */
public class CiDiCurrentBP {

	/**
	 * 当前诊断集合
	 * @param id_en
	 * @return
	 * @throws BizException
	 */
	public CidiagAggDO[] getIdEntCiDiS(String id_en)throws BizException{
		 if(id_en == null) return null;
		 //患者的当前诊断
		 CidiagAggDO[] agg = null;
		 String whereStr = " fg_cancel !='Y' and  id_en ='"+id_en+"'";
		 agg  = CiDiUtils.getICidiagRService().find(whereStr, "id_en", FBoolean.FALSE);
		 String[] fields  = {"sortno"};
		 //排序
		 //DOUtil.sortAggByAttrVal("sortno", agg, agg);
	    return agg;
	}
	 /**
	  * 
	  * @param id_en
	  * @return
	  * @throws BizException
	  */
	 public CidiagAggDO[] getCiDiCurrent(String id_en)throws BizException{
		 if(id_en == null) return null;
		 //患者的当前诊断
		 CidiagAggDO[] agg = null;
		 List<CiDiagDO> cidiagDOList = this.getListCiDiagDOnew(id_en);
			
		 if(cidiagDOList != null && cidiagDOList.size()>0){
			 String sql = getCiDiagIdDiSql(cidiagDOList);
			   agg =  CiDiUtils.getICidiagRService().find(sql, CiDiagDO.ID_DI, FBoolean.FALSE);
		 }
		 
		 if(agg== null || agg.length==0){new BizException("当前诊断为空");}
		 return agg;
	 }
	
	
	/**
	 * sql 
	 * @param cidiagDOList
	 * @return
	 * @throws BizException
	 */
	 private String getCiDiagIdDiSql(List<CiDiagDO> cidiagDOList)throws BizException{
		 if(cidiagDOList == null || cidiagDOList.size() ==0) new BizException("诊断集合为空");
		 String sql = "";
		 if(cidiagDOList.size()>0){
			  sql = CiDiagDODesc.TABLE_ALIAS_NAME+"."+ CiDiagDO.ID_DI +" in (";
			 for(CiDiagDO cidido :cidiagDOList){
				 sql+= "'"+cidido.getId_di()+"',";
			 }
			 sql = sql.substring(0, sql.lastIndexOf(","));
			 sql+=" )"; 
		 }
		 return sql;
	 }
	
	/**
	 * 当前诊断的主键集合
	 * @param id_en
	 * @return
	 * @throws BizException
	 */
	 private List<CiDiagDO> getListCiDiagDO(String id_en)throws BizException{
		 DAFacade facade = new DAFacade();
		 StringBuffer sb = new StringBuffer();
		 sb.append(" dt_sign in (" );
		 sb.append(" select max(dt_sign) from ci_di where id_en ='");
		 sb.append(id_en);
		 sb.append( "' and fg_cancel !='Y' and  fg_sign ='Y' and sd_ditp !='");
		 sb.append(ICiDictCodeConst.SD_SUPPLY + "'");
		 sb.append("  union all  ");
		 sb.append(" select dt_sign from ci_di where id_en ='" );
		 sb.append( id_en);
		 sb.append("' and fg_cancel !='Y' and fg_sign ='Y' and sd_ditp ='");
		 sb.append(ICiDictCodeConst.SD_SUPPLY + "'" + " and dt_sign> (");
		 sb.append( " select max(dt_sign) from ci_di where id_en ='");
		 sb.append(id_en);
		 sb.append( "' and fg_cancel !='Y' and fg_sign ='Y' and sd_ditp !='");
		 sb.append(ICiDictCodeConst.SD_SUPPLY );
		 sb.append("'" + " ) and id_en ='"+id_en+"') and id_en ='"+id_en+"'");
	     List<CiDiagDO> CiDiagDOList = (List<CiDiagDO>) facade.findByCond(CiDiagDO.class, sb.toString(), CiDiagDO.DT_DI);
	     return CiDiagDOList;
	 }
	 /**
	  *  获取当前诊断，使用dt_di作为最大时间的判断标准
	  * @param id_en
	  * @return
	  * @throws BizException
	  */
	 private List<CiDiagDO> getListCiDiagDOnew(String id_en)throws BizException{
		 DAFacade facade = new DAFacade();
		 StringBuffer sb = new StringBuffer();
		 sb.append(" fg_sign='Y' and fg_cancel='N' and id_en='"+id_en+"' and nvl(sd_ditp,'~')<>'"+ICiDictCodeConst.SD_SUPPLY+"'");
		 List<CiDiagDO> ciDiagDOList=new ArrayList<>();
		 List<CiDiagDO> dilist=(List<CiDiagDO>)facade.findByCond(CiDiagDO.class, sb.toString(), "sd_ditp desc,dt_di desc");
		 if(dilist==null||dilist.size()==0)
			 return null;
		 CiDiagDO maxdi=dilist.get(0);
		 ciDiagDOList.add(maxdi);
		 if(IBdFcDictCodeConst.SD_CODE_ENTP_IP.equals(maxdi.getCode_entp())
				 || IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS.equals(maxdi.getCode_entp())){
		 List<CiDiagDO> sdilist=(List<CiDiagDO>)facade.findByCond(CiDiagDO.class, "id_en='"+id_en+"' and sd_ditp='"+ICiDictCodeConst.SD_SUPPLY+"'  and fg_sign='Y' and fg_cancel='N' and dt_di>'"+maxdi.getDt_di()+"'", "dt_di");
		 if(sdilist!=null&&sdilist.size()>0) {
			 ciDiagDOList.addAll(sdilist);
		 }
		 }
		 return ciDiagDOList;
	 }
	 
}
