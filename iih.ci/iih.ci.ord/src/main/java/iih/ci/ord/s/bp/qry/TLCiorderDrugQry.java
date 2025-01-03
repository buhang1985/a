package iih.ci.ord.s.bp.qry;

import org.apache.commons.lang.StringUtils;

import iih.bd.base.utils.SqlUtils;
import iih.bd.bc.param.IBdMmParamValueConst;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.utils.BdMmParamUtils;
import xap.mw.core.data.BizException;

/**
 * 根据服务id查询 服务关联的物品
 *
 */
public class TLCiorderDrugQry extends CiorderDrugQry{
	/**
	 * 
	 * @param id id_srv
	 * @param fldname 字段名称（暂时没用）
	 */
	public TLCiorderDrugQry(String[] id,String fldname){
		super(id,fldname);
	}
	public TLCiorderDrugQry(String mmtp) {
		super(mmtp);
	}

	@Override
	public String getQrySQLStr() {
		String drugManagementModel;
		try {
			drugManagementModel = BdMmParamUtils.GetDrugMCPropMM();
		} catch (BizException e) {
			drugManagementModel = IBdMmParamValueConst.DRUGMCPROPMM_SRV;
		}
		if (IBdMmParamValueConst.DRUGMCPROPMM_DRUG.equals(drugManagementModel)) {
			return " SELECT '' as name_heath, '' as limit,A.id_srvtp,A.sd_srvtp,A.id_srv,A.code as code_srv, A.name as name_srv,B.id_unit_med,"
		               +" B.id_mm,B.spec as spec_mm,B.name as name_mm,B.price,B.des as des_mm,B.sup_name as name_sup,B.code as code_mm ,"
		               +" drug.fg_highrisk fg_highrisk,drug.id_dosage id_dosage,drug.sd_dosage sd_dosage,dosage.name as name_dosage, drug.id_pharm id_pharm,drug.sd_pharm sd_pharm, '' id_antipsy,"
		               +" drug.sd_pois sd_pois,drug.id_pois id_pois,drug.id_anti id_anti,drug.sd_anti sd_anti,drug.fg_pois fg_pois,drug.fg_anti fg_anti,B.id_mmtp,B.sd_mmtp,"
		               +" B.factor_sb as factor_cb,factor_mb,B.sd_opmutp,B.sd_mupkgutp,B.id_val,B.sd_val,'' id_antipsy, '' sd_antipsy,D.name as name_unit_med,"
		    		   +" C.id_measdoc as id_unit_sale,C.name as name_unit_sale , E.id_measdoc as id_unit_base, E.name as name_unit_base,"
		               +" B.quan_med,"
		    		   +" B.id_freq,B.id_route,B.id_routedes,B.id_boil,B.id_boildes,B.Id_Srvskin,B.Fg_skin as fg_skintest, A.fg_mm,A.fg_ctm,F.name as Name_boildes,freq.freqct,freq.SD_FREQUNITCT,"
		    		   +" A.sd_mmbind_op,A.sd_mmbind_er,A.fg_bl ,bduidoc.name  Des,A.Id_srvca,B.id_herbpreparationtp,B.sd_herbpreparationtp,"
		    		   +" freq.fg_long"
		    		   +queryParam()
		    		   +" FROM BD_SRV A LEFT OUTER JOIN bd_mm B on A.id_srv = B.id_srv  and B.ds ='0' and "+SqlUtils.getInSqlByIds("A.id_srv", this.get_id()) //原有的sql串放到文档最后了
		    		   +" left outer join bd_srv_drug  drug on drug.id_srv = A.ID_SRV"
		    		   +addParam()
		    		   +" LEFT OUTER JOIN bd_measdoc C on B.id_unit_pkgsp=C.id_measdoc "
		    		   +" LEFT OUTER JOIN bd_measdoc D on B.id_unit_med=D.id_measdoc"
		    		   +" LEFT OUTER JOIN bd_measdoc E on B.id_unit_pkgbase=E.id_measdoc "
		    		   +" LEFT OUTER  JOIN bd_boil_des F  on B.Id_Boildes = F.Id_Boildes "
		    		   +" Left outer join bd_freq freq on freq.id_freq = B.id_freq"
		    		   +"  left  outer join bd_udidoc bduidoc on bduidoc.id_udidoc = b.id_mupkgutp "
		    		   +" left outer join bd_udidoc dosage on dosage.id_udidoc = drug.id_dosage and dosage.id_udidoclist='@@@@ZZ2000000000002R'"
		              +" WHERE  B.fg_active =  'Y' and "+SqlUtils.getInSqlByIds("A.id_srv", this.get_id());   //原有的sql串放到文档最后了
		}else{
			return " SELECT '' as name_heath, '' as limit,A.id_srvtp,A.sd_srvtp,A.id_srv,A.code as code_srv, A.name as name_srv,A.id_unit_med,"
		               +" B.id_mm,B.spec as spec_mm,B.name as name_mm,B.price,B.des as des_mm,B.sup_name as name_sup,B.code as code_mm ,"
		               +" drug.fg_highrisk fg_highrisk,drug.id_dosage id_dosage,drug.sd_dosage sd_dosage,dosage.name as name_dosage, drug.id_pharm id_pharm,drug.sd_pharm sd_pharm, '' id_antipsy,"
		               +" drug.sd_pois sd_pois,drug.id_pois id_pois,drug.id_anti id_anti,drug.sd_anti sd_anti,drug.fg_pois fg_pois,drug.fg_anti fg_anti,B.id_mmtp,B.sd_mmtp,"
		               +" B.factor_sb as factor_cb,factor_mb,B.sd_opmutp,B.sd_mupkgutp,B.id_val,B.sd_val,'' id_antipsy, '' sd_antipsy,D.name as name_unit_med,"
		    		   +" C.id_measdoc as id_unit_sale,C.name as name_unit_sale , E.id_measdoc as id_unit_base, E.name as name_unit_base,"
		               +" A.quan_med,"
		    		   +" A.id_freq,A.id_route,A.id_routedes,A.id_boil,A.id_boildes,B.Id_Srvskin,B.Fg_skin as fg_skintest, A.fg_mm,A.fg_ctm,F.name as Name_boildes,freq.freqct,freq.SD_FREQUNITCT,"
		    		   +" A.sd_mmbind_op,A.sd_mmbind_er,A.fg_bl ,bduidoc.name  Des,A.Id_srvca,B.id_herbpreparationtp,B.sd_herbpreparationtp,"
		    		   +" freq.fg_long"
		    		   +queryParam()
		    		   +" FROM BD_SRV A LEFT OUTER JOIN bd_mm B on A.id_srv = B.id_srv  and B.ds ='0' and "+SqlUtils.getInSqlByIds("A.id_srv", this.get_id())
		    		   +" left outer join bd_srv_drug  drug on drug.id_srv = A.ID_SRV"
		    		   +addParam()
		    		   +" LEFT OUTER JOIN bd_measdoc C on B.id_unit_pkgsp=C.id_measdoc "
		    		   +" LEFT OUTER JOIN bd_measdoc D on A.id_unit_med=D.id_measdoc"
		    		   +" LEFT OUTER JOIN bd_measdoc E on B.id_unit_pkgbase=E.id_measdoc "
		    		   +" LEFT OUTER  JOIN bd_boil_des F  on A.Id_Boildes = F.Id_Boildes "
		    		   +" Left outer join bd_freq freq on freq.id_freq = A.id_freq"
		    		   +"  left  outer join bd_udidoc bduidoc on bduidoc.id_udidoc = b.id_mupkgutp "
		    		   +" left outer join bd_udidoc dosage on dosage.id_udidoc = drug.id_dosage and dosage.id_udidoclist='@@@@ZZ2000000000002R'"
		              +" WHERE  B.fg_active =  'Y' and "+SqlUtils.getInSqlByIds("A.id_srv", this.get_id()); 
		}
	}

	public String addParam(){
		if(StringUtils.isEmpty(this.get_fldname())){
			return " ";
		}else{
			return " LEFT OUTER JOIN ci_or_srv srv on A.ID_SRV=srv.id_srv and srv.id_or='"+this.get_fldname().toString()+"' ";
		}
	}
	public String queryParam(){
		if(StringUtils.isEmpty(this.get_fldname())){
			return " ";
			}else{
				return ",srv.id_nodispense,srv.sd_nodispense ";
			}
	}
}
