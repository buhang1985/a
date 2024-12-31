package iih.ci.diag.s;

import org.apache.commons.lang.StringUtils;

import iih.bd.srv.diagdef.d.DiagDefDO;
import iih.ci.diag.cidiag.d.CiDiagDO;
import iih.ci.diag.cidiag.d.CiDiagItemDO;
import iih.ci.diag.cidiag.d.CidiagAggDO;
import iih.ci.diag.dto.d.DIDTO;
import iih.ci.diag.dto.d.IpViewDiagDTO;
import iih.ci.diag.dto.s.bp.getCiDiagItemDOlistBP;
import iih.ci.diag.dto.s.bp.getMedicalRecordDiagBP;
import iih.ci.diag.dto.s.qry.CiDiagCurrentQry;
import iih.ci.diag.dto.s.qry.CiDiagQueryServiceQry;
import iih.ci.diag.i.ICidiagQryService;
import iih.ci.diag.pub.CommonUtil;
import iih.ci.diag.s.bp.CiDiCurrentBP;
import iih.ci.diag.s.bp.GetCiDiagItemsBP;
import iih.ci.diag.s.bp.GetHpjudgetpCiDiagItemsBP;
import iih.ci.diag.s.bp.getCiDiagItemDOBP;
import iih.ci.diag.s.bp.getCidiagAggDOIdEnAndDiTpBP;
import iih.ci.diag.s.bp.getDiTypeBP;
import iih.ci.diag.s.bp.getDiagDefDOSBP;
import iih.ci.diag.s.bp.getLastCiDiagsBP;
import iih.ci.diag.s.ip.bp.IpDiCancelModeSetBP;
import iih.ci.diag.s.ip.bp.getCiDiagSelectedTypeBP;
import iih.ci.ord.i.ICiOrdNSysParamConst;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;
import xap.sys.xbd.udi.d.UdidocDO;
@Service(serviceInterfaces={ICidiagQryService.class}, binding=Binding.JSONRPC)
public class CidiagQryServiceImpl implements ICidiagQryService {

	@Override
	public IpViewDiagDTO[] getCiDiagItemDOlist(String id_ent)
			throws BizException {
		getCiDiagItemDOlistBP bp = new getCiDiagItemDOlistBP();
		return bp.exec(id_ent);
	}

	
	@Override
	public void getCiDiagDTO(DIDTO[] aggdos) throws BizException {
		// TODO Auto-generated method stub
		 
	}

	@Override
	public DIDTO[] QueryCiDiagDTO(String id,String type) throws BizException {
		// TODO Auto-generated method stub
		CiDiagQueryServiceQry cidiagQry = new CiDiagQueryServiceQry(id);
		CiDiagCurrentQry  Current = new CiDiagCurrentQry(id);
		DIDTO[] rtn;
		if(type.equals("current")){
			  rtn=(DIDTO[])AppFwUtil.getDORstWithDao(Current, DIDTO.class);
		}else{
			 rtn=(DIDTO[])AppFwUtil.getDORstWithDao(cidiagQry, DIDTO.class);
		}
		
		return rtn;
		
	}
/************以上方法暂时不用***********************************************
	 /**
	  * 病案首页诊断显示
	  * @param id_ent
	  * @return DIDTO[]
	  * @throws BizException
	  */
	 @Override
	 public  DIDTO[] getMedicalRecordDiag(String id_ent)throws BizException{
		getMedicalRecordDiagBP bp = new getMedicalRecordDiagBP();
		return bp.exec(id_ent);
	}
	 
	 
	 @Override
	 public DiagDefDO[] getDiagDefDOS(String value)throws BizException{ 
		 if(value == null) new BizException("value 为空");
		 getDiagDefDOSBP bp = new getDiagDefDOSBP();
		 Long lg = System.currentTimeMillis();
		// System.out.println("开始时间"+System.currentTimeMillis());
		 DiagDefDO[] diagDefDO= bp.exec(value);
		 //System.out.println("结束时间"+System.currentTimeMillis() +" 耗时 = "+(System.currentTimeMillis()-lg));
		 // 数据量大 暂时处理 临时方案 todo
		  if(diagDefDO != null  && diagDefDO.length>300){
			  DiagDefDO[] diagDef = new  DiagDefDO[10];
			  for(int i =0;i<10;i++){
				  diagDef[i] =diagDefDO[i];
			  }
			  return diagDef;
		  }
		 return diagDefDO;
	 }


	@Override
	public UdidocDO[] getDiType(String id_en ,String org,String entp) throws BizException {
		if(StringUtils.isBlank(id_en)) throw  new BizException("id_en  为空");
		getDiTypeBP bp = new getDiTypeBP();
		return bp.getUdidocDO(id_en,org,entp);
	}
	 
	@Override
	public  String getParamType()throws BizException{
		/*临床诊断系统设置（组织）
		ClinicalDiagSysCfg
		11  西医、12  中医、13  蒙医
		11,12则页签显示   西医页签和中医页签                        空则无页签显示*/
		//String di_system = ParamsetQryUtil.getParaString(CiDiUtils.getDeptId(), ICiDiagSysParamConst.SYS_PARAM_CiDiag);
		String di_system = ParamsetQryUtil.getParaString(CiDiUtils.getDeptId(), ICiOrdNSysParamConst.SYS_PARAM_ClinicalDiagSysCfg_D);
		return di_system;
	}
	
	 /**
	  * 根据 就诊和就诊类型 查询当前诊断
	  * @return
	  * @throws BizException
	  */
	@Override
	 public  CidiagAggDO getCidiagAggDOIdEnAndDiTp(String id_en,String id_ditp) throws BizException{
		if(id_en == null || id_ditp == null ) new CidiagAggDO();
		getCidiagAggDOIdEnAndDiTpBP bp = new getCidiagAggDOIdEnAndDiTpBP();
		return bp.getCidiagAggDOIdEnAndDiTp(id_en, id_ditp);
	}
	
	 /**
     * 根据就诊取得当所有断信息
     * @param id_en
     * @return
     * @throws BizException
     */
	 @Override
	 public  CidiagAggDO[] getIdEntCiDiS(String id_en)throws BizException{
		 CiDiCurrentBP bp = new CiDiCurrentBP();
		 if(id_en == null) return null;
		 return bp.getIdEntCiDiS(id_en);
	 }
	 
	   /**
      *本次就诊的最新诊断
      * @param id_en
      * @return
      * @throws BizException
      */
	 @Override
     public  CidiagAggDO[] getLastCiDiags(String id_en) throws BizException{
		 getLastCiDiagsBP bp = new getLastCiDiagsBP();
    	 return bp.getLastCiDiags(id_en);
     }
   
	  /**
      * 当前最新诊断的主诊断（id_en）
      * @param id_en
      * @return  CiDiagItemDO
      * @throws BizException
      */
	 
	 @Override
    public   CiDiagItemDO getCiDiagItemDO(String id_en,String entp_code)throws BizException{
    	if(id_en == null || id_en=="") return null;
    	getCiDiagItemDOBP bp = new getCiDiagItemDOBP();
    	return bp.exe(id_en,entp_code);
    }


	/**
	 * 获取当前就诊对应的诊断
	 * 
	 * @param id_en 就诊id
	 * @param sd_ditp 诊断类型编码
	 * @return 本次就诊指定类型的诊断
	 * @throws BizException
	 */
	@Override
	public CiDiagItemDO[] getCiDiagItems(String id_en, String sd_ditp) throws BizException {

		if (id_en == null || id_en == "")
			return null;

		GetCiDiagItemsBP bp = new GetCiDiagItemsBP();
		return bp.exe(id_en, sd_ditp);
	}


	/**
     * 获取当前就诊的保外诊断明细集合
     * @param id_en 就诊id
     * @return 保外诊断明细集合
     * @throws BizException
     */
	@Override
	public CiDiagItemDO[] getHpjudgetpCiDiagItems(String id_en) throws BizException {
		
		GetHpjudgetpCiDiagItemsBP bp = new GetHpjudgetpCiDiagItemsBP();
		return bp.exec(id_en);
	}
	 /**
     * 住院诊断维护作废模式设置  
     * @param parameter  组织
     * @param Id_wg_phy  诊疗组
     * @param id_emp_sign 签署人
     * @param id_psn    当前操作人
     * @return
     * @throws BizException
     */
	@Override
    public   String getIpDiCancelModeSet(String parameter,String Id_wg_phy,String id_emp_sign,String id_psn)throws BizException {
		// TODO Auto-generated method stub
		IpDiCancelModeSetBP bp =new IpDiCancelModeSetBP();
		return bp.getIpDiCancelModeSet(parameter,Id_wg_phy, id_emp_sign,id_psn);
	}

	 /**
     * 住院诊断管控模式
     * @param parameter
     * @return
     * @throws BizException
     */
	@Override
	public String getIpDiControlMode(String parameter) throws BizException {
		// TODO Auto-generated method stub
		return CommonUtil.getIpDiControlMode(parameter);
	}

	  /**
     * 新怎诊断下拉要选择的诊断类型
     * @param id_ent
     * @param id_org
     * @return
     */
	@Override
    public   String getCiDiagSelectedType(String id_ent,String id_org)throws BizException{
    	getCiDiagSelectedTypeBP bp =new getCiDiagSelectedTypeBP();
    	return bp.getCiDiagSelectedType(id_ent, id_org);
    }
	
	/**
	 * 住院诊断维护作废模式设置 01不允许作废、11任意医生可作废、12本人及上级医生可作废、13本人可作废 
	 * @param id_org
	 * @return
	 * @throws BizException
	 */
	@Override
	public String getIpDiCancelControlSet(String id_org)throws BizException{
		return CommonUtil.getIpDiCancelModeSet(id_org);
	}
}
