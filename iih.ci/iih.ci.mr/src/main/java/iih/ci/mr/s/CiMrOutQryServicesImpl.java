package iih.ci.mr.s;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.DocumentException;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst.DoctorNur;
import iih.bd.bc.udi.pub.ICiMrDictCodeConst;
import iih.bd.srv.emrtype.d.MrTpDO;
import iih.bd.srv.emrtype.i.IEmrtypeRService;
import iih.ci.mr.cideathcert.d.CideathcertDO;
import iih.ci.mr.cideathcert.i.ICideathcertRService;
import iih.ci.mr.cimr.d.CiMrDO;
import iih.ci.mr.cimr.i.ICiemrRService;
import iih.ci.mr.i.IBdMrSetTypeCodeConst;
import iih.ci.mr.i.ICiMrOutQryServices;
import iih.ci.mr.mrdocrefvalue.d.MrDocRefValueDO;
import iih.ci.mr.mrdocrefvalue.i.IMrdocrefvalueRService;
import iih.ci.mr.pub.MrConst.IMrPubConst;
import iih.ci.mr.s.bp.CiMrFsBP;
import iih.ci.mrfp.cimrsugdto.d.CiMrSugDTO;
import iih.ci.mrm.cimrmfileinfo.d.CiMrmFileInfoDO;
import iih.ci.mrm.cimrmfileinfo.i.ICimrmfileinfoRService;
import iih.ci.ord.i.external.provide.ICiOrdMrService;
import iih.ci.ord.i.external.provide.meta.mr.d.CiOrdInfoDTO;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap2;
import xap.mw.core.service.constant.Binding;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.d.AdminAreaDO;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanHandler;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

@Service(serviceInterfaces = { ICiMrOutQryServices.class }, binding = Binding.JSONRPC)
public class CiMrOutQryServicesImpl implements ICiMrOutQryServices {

	private List<AdminAreaDO> areaList;
	
	/**
	 * 根据就诊号获取现病史，如果没有数据则返回""
	 * 
	 * @param idEnt
	 * @return
	 */
	@Override
	public String getCiMrHistoryOfPresentIllness(String idEnt) throws BizException {
//		IMrdocrefvalueRService service = ServiceFinder.find(IMrdocrefvalueRService.class);
//		MrDocRefValueDO[] dos = service.find(MrDocRefValueDO.ID_ENT + "='" + idEnt + "' and "
//						+ MrDocRefValueDO.CODE_ELEMENT + " = 'S.03'", "sv desc", FBoolean.FALSE);
		
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT a0.Code_data_element, ");
		sb.append(" a0.Code_element, ");
		sb.append(" a0.Content, ");
		sb.append(" a0.Createdby, ");
		sb.append(" a0.Createdtime, ");
		sb.append(" a0.Ds, ");
		sb.append(" a0.Id_docrefvalue, ");
		sb.append(" a0.Id_element, ");
		sb.append(" a0.Id_ent, ");
		sb.append(" a0.Id_grp, ");
		sb.append(" a0.Id_mr, ");
		sb.append(" a0.Id_org, ");
		sb.append(" a0.Modifiedby, ");
		sb.append(" a0.Modifiedtime, ");
		sb.append(" a0.Sv ");
		sb.append(" FROM ci_mr_doc_reference_value a0 ");
		sb.append(" WHERE a0.id_ent = ? AND a0.code_element = ? ");
		sb.append(" AND a0.ds = 0 order by sv desc ");

		SqlParam sp = new SqlParam();
		sp.addParam(idEnt);
		sp.addParam("S.03");
		
		DAFacade daf = new DAFacade();
		@SuppressWarnings("unchecked")
		List<MrDocRefValueDO> listMr = (List<MrDocRefValueDO>) daf.execQuery(sb.toString(), sp, new BeanListHandler(MrDocRefValueDO.class));
		
		if (listMr != null && listMr.size() > 0) {
			MrDocRefValueDO[] mrDos = (MrDocRefValueDO[])listMr.toArray(new MrDocRefValueDO[]{});
			return mrDos[0].getContent();
		}
		return "";
	}

	/**
	 * 根据就诊号获取最后一次病程FMap，如果没有数据则返回new FMap();
	 * 
	 * @param idEnt
	 * @return
	 * @throws BizException
	 * @throws IOException 
	 * @throws DocumentException 
	 */
	@Override
	public FMap2 getCiMrCourseOfLastDisease(String idEnt, FBoolean isFirst)
			throws BizException, DocumentException, IOException {

		String sql;

		if (isFirst.equals(FBoolean.TRUE)) {
			sql = "select * from ci_mr where ci_mr.ds = 0 and ci_mr.id_ent='"
					+ idEnt
					+ "' and ci_mr.id_mrtp in (select id_mrtp from bd_mrtp where bd_mrtp.id_data_set in (select id_set from bd_set where bd_set.code='"
					+ IMrPubConst.DS_SCBC + "' ))";
		} else {
			sql = "select * from ci_mr where ci_mr.ds = 0 and ci_mr.id_ent='"
					+ idEnt
					+ "' and ci_mr.id_mrtp in (select bd_mrtp.id_mrtp from bd_mrtp where bd_mrtp.id_data_set in (select bd_set.id_set from bd_set where bd_set.id_setca = (select bd_set_tp.id_setca from bd_set_tp where bd_set_tp.code = '"
					+ IBdMrSetTypeCodeConst.MR_SET_TYPE_CODE_ZYBCJL
					+ "'))) order by ci_mr.dt_rd desc";
		}

		DAFacade daf = new DAFacade();

		@SuppressWarnings("unchecked")
		List<CiMrDO> listMr = (List<CiMrDO>) daf.execQuery(sql,
				new BeanListHandler(CiMrDO.class));

		if (listMr != null && listMr.size() > 0) {
			if (isFirst == FBoolean.FALSE && listMr.size() <= 1) {
				return new FMap2();
			}
			CiMrFsBP ciMrFsBp = new CiMrFsBP();
			String strArea = ciMrFsBp.GetCiMrFsArea(listMr.get(0));
			IEmrtypeRService iEmrtypeRService = ServiceFinder
					.find(IEmrtypeRService.class);
			MrTpDO mrtpdo = iEmrtypeRService.findById(listMr.get(0)
					.getId_mrtp());
			FMap2 fMap = new FMap2();
			fMap.put("dt_rd", listMr.get(0).getDt_rd());
			fMap.put("mrtp_name", mrtpdo == null ? "" : mrtpdo.getName());
			fMap.put("strArea", strArea.replaceAll("\\{", "").replaceAll("\\}",""));

			return fMap;

		}

		return new FMap2();
	}

	/**
	 * 根据就诊号获取所有门诊病历
	 * 
	 * @param strIdEnts
	 * @return
	 * @throws BizException
	 * @throws IOException 
	 * @throws DocumentException 
	 */
	@Override
	public FMap2 getOPCiMrByIdEnts(String[] strIdEnts) throws BizException, DocumentException, IOException {

		FMap2 result = new FMap2();

		if (strIdEnts != null && strIdEnts.length > 0) {
			String sql;
			DAFacade daf = new DAFacade();
			CiMrFsBP ciMrFsBp = new CiMrFsBP();
			for (int i = 0; i < strIdEnts.length; i++) {
				sql = "select * from ci_mr where ci_mr.ds = 0 and ci_mr.id_ent='"
						+ strIdEnts[i]
						+ "' and ci_mr.id_mrtp in (select id_mrtp from bd_mrtp where bd_mrtp.id_data_set in (select id_set from bd_set where bd_set.code in ('"
						+ IMrPubConst.DS_MJZBL
						+ "','"
						+ IMrPubConst.DS_RCBC
						+ "' )))";
				@SuppressWarnings("unchecked")
				List<CiMrDO> listMr = (List<CiMrDO>) daf.execQuery(sql,
						new BeanListHandler(CiMrDO.class));
				if (listMr != null && listMr.size() > 0) {
					String areaStr = "";
					for (CiMrDO cimrdoc : listMr) {						
						String strArea = ciMrFsBp.GetCiMrFsArea(cimrdoc);
						if (strArea != null && strArea.length() > 0) {
							strArea = strArea
									.replaceAll("\\{", "")
									.replaceAll("\\}", "");
							int subI = strArea.indexOf("医师签名");
							if (subI > 0) {
								strArea = strArea.substring(0, subI);
							}
							areaStr += strArea + "\n";
						}
					}
					result.put(strIdEnts[i], areaStr);
				}
			}
		}

		return result;
	}

	@Override
	public FBoolean hasCiMrDoByIdEnts(String idEnt) throws BizException {
		// TODO Auto-generated method stub

		if (idEnt != null) {
			String sql;
			DAFacade daf = new DAFacade();
			sql = "select mr.*  from ci_mr mr left join bd_mrca_ctm ctm on ctm.id_mrcactm = mr.id_mrcactm "
					+ "where mr.id_ent = '"
					+ idEnt
					+ "' and mr.ds =0 and ctm.docornur in ('"
					+ DoctorNur.doctor.getCode()
					+ "', '"
					+ DoctorNur.doctorNur.getCode() + "') ";
			@SuppressWarnings("unchecked")
			List<CiMrDO> listMr = (List<CiMrDO>) daf.execQuery(sql,
					new BeanListHandler(CiMrDO.class));
			if (listMr != null && listMr.size() > 0) {
				return FBoolean.TRUE;
			} else {
				return FBoolean.FALSE;
			}
		}

		return null;
	}

	/**
	 * 根据就诊号获取手术记录相关信息
	 * @param IdEnt
	 * @return
	 * @throws BizException
	 * */
	@Override
	public List<CiMrSugDTO> getCiMrSurgery(String idEnt) throws BizException {
			DAFacade daf = new DAFacade();
			String sql;
			sql = "select  cisug.id_ent,cisug.dt_start_sug,cisug.dt_end_sug,cisug.sd_sug,cisug.name_sug from CI_MR_FP_SUG cisug"
					+" where cisug.id_ent = '"
					+idEnt
					+ "'order by dt_start_sug desc";
			@SuppressWarnings("unchecked")
			List<CiMrSugDTO> listsug =(List<CiMrSugDTO>) daf.execQuery(sql, new BeanListHandler(CiMrSugDTO.class));
			if(listsug != null && listsug.size()>0){
				return listsug;
			}else{
				return null;
			}
	}
	
	/**
	 * 通过病历主键获取病历xml
	 * @param IdMr
	 * @return
	 * @throws BizException
	 */
	@Override
	public String getCimrXml(String IdMr) throws BizException {		
		ICiemrRService iCiemrRService  = ServiceFinder.find(ICiemrRService.class);
		CiMrDO ciMrDo = iCiemrRService.findById(IdMr);
		if(ciMrDo==null)
		{
			return "";
		}
		try {
			return (new CiMrFsBP()).GetCiMrFsXml(ciMrDo);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			return "";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return "";
		}
	}

	/**
	 * 通过病历主键获取病历内容
	 * @param IdMr
	 * @return
	 * @throws BizException
	 */
	@Override
	public String getCimrArea(String IdMr) throws BizException {
		ICiemrRService iCiemrRService  = ServiceFinder.find(ICiemrRService.class);
		CiMrDO ciMrDo = iCiemrRService.findById(IdMr);
		if(ciMrDo==null)
		{
			return "";
		}
		try {
			return (new CiMrFsBP()).GetCiMrFsArea(ciMrDo);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			return "";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return "";
		}
	}

	/**
	 * 通过病历主键获取病历结构化段落
	 * @param IdMr
	 * @return
	 * @throws BizException
	 */
	@Override
	public MrDocRefValueDO[] getCimrPhase(String IdMr,String[] ElemCodes) throws BizException {
		IMrdocrefvalueRService iMrdocrefvalueRService  = ServiceFinder.find(IMrdocrefvalueRService.class);
		String sqlWhere = "";
		if(ElemCodes!=null)
		{
			sqlWhere = " and Code_element in (''";
			for(String code :ElemCodes)
			{
				sqlWhere+=",'"+code+"'";
			}
			sqlWhere+=")";
		}
		return iMrdocrefvalueRService.find("id_mr = '"+IdMr+"'"+sqlWhere, "", FBoolean.FALSE);
	}
	/**
	 * 通过就诊id获取病历结构化段落
	 * @param IdEnt 就诊主键
	 * @param ElemCodes 对于获取内容的过滤，如果为null即不限制
	 * @return
	 * @throws BizException
	 */
	@Override
	public MrDocRefValueDO[] getCimrPhaseByElemCode(String IdEnt,String[] ElemCodes ) throws BizException
	{
		//IMrdocrefvalueRService iMrdocrefvalueRService  = ServiceFinder.find(IMrdocrefvalueRService.class);
		DAFacade da = new DAFacade();
		String sql = "select ref.* from  ci_mr_doc_reference_value ref left join ci_mr mr on ref.id_mr = mr.id_mr "; 
		String sqlWhere = " where (mr.ds = '0' or mr.ds is null) and ref.Id_ent = '"+IdEnt+"' ";
		if(ElemCodes!=null)
		{
			sqlWhere += " and ref.Code_element in (''";
			for(String code :ElemCodes)
			{
				sqlWhere+=",'"+code+"'";
			}
			sqlWhere+=")";
		}
		@SuppressWarnings("unchecked")
		ArrayList<MrDocRefValueDO>  refs =  (ArrayList<MrDocRefValueDO>)da.execQuery(sql+sqlWhere, new BeanListHandler(MrDocRefValueDO.class));
		if (refs == null || refs.size() == 0)
			return new MrDocRefValueDO[]{};
		else {
			MrDocRefValueDO[] arrRefs = new MrDocRefValueDO[refs.size()];
			return refs.toArray(arrRefs);
		}
		//return iMrdocrefvalueRService.find("Id_ent = '"+IdEnt+"' "+sqlWhere, "Code_element,sv ", FBoolean.FALSE);
	}
	/**
	 * 根据患者编码获取是否已经有效填写死亡报卡
	 * @param idEnt
	 * @return
	 */
	@Override
	public String getPatDeathByIdPat(String idPat) throws BizException {
		ICideathcertRService CideathcertRService = ServiceFinder.find(ICideathcertRService.class);
		CideathcertDO[] CideathcertDOs = CideathcertRService.find("id_pat = '"+idPat+"' and cert_status <> '"+ICiMrDictCodeConst.ID_CONTAGION_STATUS_INVALID+"'", "", FBoolean.FALSE);
		if(CideathcertDOs !=null && CideathcertDOs.length > 0)
		{
			return "";
		}
		return "请填写居民医学死亡诊断证明书！";
	}

	@Override
	public AdminAreaDO[] getLevelFourAddressById(String id_adminarea) throws BizException {
		AdminAreaDO levelone=new AdminAreaDO();
		AdminAreaDO leveltwo=new AdminAreaDO();
		AdminAreaDO levelthree=new AdminAreaDO();
		AdminAreaDO levelfour=new AdminAreaDO();
		
		DAFacade daf=new  DAFacade();
		String sql="select * from bd_adminarea  where id_adminarea='"+id_adminarea+"'";
		AdminAreaDO area= (AdminAreaDO)daf.execQuery(sql, new BeanHandler(AdminAreaDO.class));
		if(area!=null){
			if(StringUtil.isEmptyWithTrim(area.getId_parent())){
				levelone=area;
			}else{
				areaList=new ArrayList<AdminAreaDO>();
				List<AdminAreaDO> list=getAddress(area.getId_parent());
				if(list!=null && list.size()>0){
					switch(list.size()){
						case 1:
							levelone=list.get(0);
							leveltwo=area;
							break;
						case 2:
							levelone=list.get(1);
							leveltwo=list.get(0);
							levelthree=area;
							break;
						case 3:
							levelone=list.get(2);
							leveltwo=list.get(1);
							levelthree=list.get(0);
							levelfour=area;
							break;							
 					}
				}
			}
		}
		return new AdminAreaDO[]{levelone,leveltwo,levelthree,levelfour} ;
	}

	
	@Override
	public AdminAreaDO[] getLevelFourAddressBySd(String code) throws BizException {
		AdminAreaDO levelone=new AdminAreaDO();
		AdminAreaDO leveltwo=new AdminAreaDO();
		AdminAreaDO levelthree=new AdminAreaDO();
		AdminAreaDO levelfour=new AdminAreaDO();
		
		DAFacade daf=new  DAFacade();
		String sql="select * from bd_adminarea  where code='"+code+"'";
		AdminAreaDO area= (AdminAreaDO)daf.execQuery(sql, new BeanHandler(AdminAreaDO.class));
		if(area!=null){
			if(StringUtil.isEmptyWithTrim(area.getId_parent())){
				levelone=area;
			}else{
				areaList=new ArrayList<AdminAreaDO>();
				List<AdminAreaDO> list=getAddress(area.getId_parent());
				if(list!=null && list.size()>0){
					switch(list.size()){
						case 1:
							levelone=list.get(0);
							leveltwo=area;
							break;
						case 2:
							levelone=list.get(1);
							leveltwo=list.get(0);
							levelthree=area;
							break;
						case 3:
							levelone=list.get(2);
							leveltwo=list.get(1);
							levelthree=list.get(0);
							levelfour=area;
							break;					
 					}
				}
			}
		}
		return new AdminAreaDO[]{levelone,leveltwo,levelthree,levelfour} ;
	}
	
	
	public List<AdminAreaDO> getAddress(String id_parent) throws BizException{
		DAFacade daf=new  DAFacade();
		String sql="select * from bd_adminarea  where id_adminarea='"+id_parent+"'";
		AdminAreaDO area= (AdminAreaDO)daf.execQuery(sql, new BeanHandler(AdminAreaDO.class));
		if(area!=null){
			areaList.add(area);
			if(!StringUtil.isEmptyWithTrim(area.getId_parent())){
				getAddress(area.getId_parent());
			}
		}	
		return areaList;
	}
	
	/**
	 * 根据id_mr获取病历签名信息
	 * @throws ParseException 
	 */
	@Override
	public String getSignMessage(String id_mr) throws BizException, ParseException {
		ICimrmfileinfoRService cimrmfileinfoRService = ServiceFinder.find(ICimrmfileinfoRService.class);
		CiMrmFileInfoDO[] ciMrmFileInfoDos = cimrmfileinfoRService.find("id_bu_sy = '"+ id_mr +"'", "dt_sign desc", FBoolean.FALSE);
		if(ciMrmFileInfoDos != null && ciMrmFileInfoDos.length > 0 && FBoolean.TRUE.equals(ciMrmFileInfoDos[0].getFg_ca()) && ciMrmFileInfoDos[0].getDt_sign() != null && ciMrmFileInfoDos[0].getName_psn() != null){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			SimpleDateFormat myFmt=new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒 "); 
			return "当前文书已数字签名，签署人："+ ciMrmFileInfoDos[0].getName_psn() +"， 签署时间："+ myFmt.format(sdf.parse(ciMrmFileInfoDos[0].getDt_sign())).toString();//YYYY年MM月DD日 HH时MM分SS秒
		}
		return "当前文书未数字签名，内容仅供参考";
	}
	
	/**
	 * 根据id_ent查询门诊医嘱信息
	 */
	@Override
	public List<CiOrdInfoDTO> getCiOrdInfoByIden(String id_ent) throws BizException {
		ICiOrdMrService ordMrService = ServiceFinder.find(ICiOrdMrService.class);
		return ordMrService.getCiOrdInfoByIden(id_ent);
	}
	
}
